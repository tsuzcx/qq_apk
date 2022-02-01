package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.q.b;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView.a;
import com.tencent.mm.plugin.secdata.ui.MMSecDataActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;

public abstract class BaseFavDetailReportUI
  extends MMSecDataActivity
{
  public h.a Akw = new h.a();
  protected boolean Akx;
  private String Aky = null;
  
  protected final void H(g paramg)
  {
    if ((paramg != null) && (this.Akw.scene > 0))
    {
      this.Akw.Acx = paramg.field_id;
      this.Akw.type = paramg.field_type;
      this.Akw.source = paramg.field_sourceType;
      this.Akw.timestamp = (paramg.field_sourceCreateTime / 1000L);
      if (this.Akw.timestamp == 0L) {
        this.Akw.timestamp = (paramg.field_updateTime / 1000L);
      }
      if (this.Akw.timestamp == 0L) {
        this.Akw.timestamp = paramg.field_edittime;
      }
      this.Akw.Acy = b.r(paramg);
      this.Akx = true;
    }
  }
  
  protected MMLoadScrollView dSo()
  {
    return null;
  }
  
  protected final void mQ(long paramLong)
  {
    g localg = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(paramLong);
    if (localg != null) {
      H(localg);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("key_activity_browse_time", 0L);
      h.a locala = this.Akw;
      locala.AcA += l;
      Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", new Object[] { Long.valueOf(this.Akw.AcA), Long.valueOf(l) });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.Akw.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.Akw.AcJ = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.Akw.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.Akw.query = getIntent().getStringExtra("key_detail_fav_query");
    this.Akw.zIC = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.Akw.AcL = getIntent().getStringExtra("key_detail_fav_tags");
    h.a locala = this.Akw;
    if (this.Akw.query == null)
    {
      paramBundle = "";
      locala.query = paramBundle;
      locala = this.Akw;
      if (this.Akw.zIC != null) {
        break label266;
      }
      paramBundle = "";
      label145:
      locala.zIC = paramBundle;
      locala = this.Akw;
      if (this.Akw.AcL != null) {
        break label277;
      }
    }
    label266:
    label277:
    for (paramBundle = "";; paramBundle = this.Akw.AcL)
    {
      locala.AcL = paramBundle;
      paramBundle = dSo();
      if (paramBundle != null)
      {
        paramBundle.setOnTopOrBottomListerner(new MMLoadScrollView.a()
        {
          public final void dCr()
          {
            BaseFavDetailReportUI.this.Akw.AcI = true;
          }
        });
        if ((paramBundle instanceof FavDetailScrollView)) {
          ((FavDetailScrollView)paramBundle).setOnScrollChangeListener(new FavDetailScrollView.a()
          {
            public final void dSp()
            {
              AppMethodBeat.i(107110);
              BaseFavDetailReportUI.this.showActionbarLine();
              AppMethodBeat.o(107110);
            }
            
            public final void dSq()
            {
              AppMethodBeat.i(107111);
              BaseFavDetailReportUI.this.hideActionbarLine();
              AppMethodBeat.o(107111);
            }
          });
        }
      }
      if (this.Akw.scene == 0) {
        Log.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
      }
      setActionbarColor(getContext().getResources().getColor(q.b.white));
      hideActionbarLine();
      return;
      paramBundle = this.Akw.query;
      break;
      paramBundle = this.Akw.zIC;
      break label145;
    }
  }
  
  public void onDestroy()
  {
    if (this.Akx) {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107112);
          BaseFavDetailReportUI.this.Akw.AcK = (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().ME((int)BaseFavDetailReportUI.this.Akw.Acx) + 1);
          com.tencent.mm.plugin.fav.a.h.a(BaseFavDetailReportUI.this.Akw);
          AppMethodBeat.o(107112);
        }
      }, "BaseFavReport");
    }
    setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    com.tencent.mm.plugin.fav.ui.e.dRE();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.Akw.Acz = getActivityBrowseTimeMs();
    String str1 = com.tencent.mm.modelstat.e.bNb().oWh;
    h.a locala;
    long l2;
    com.tencent.mm.modelstat.e locale;
    String str2;
    if ((!Util.isEqual(getClass().getName(), str1)) && (!Util.isEqual(str1, this.Aky)))
    {
      locala = this.Akw;
      l2 = locala.AcA;
      locale = com.tencent.mm.modelstat.e.bNb();
      str2 = com.tencent.mm.modelstat.e.bNb().oWh;
      if (locale.oWg == null) {
        break label154;
      }
    }
    label154:
    for (long l1 = ((Long)locale.oWg.get(str2)).longValue();; l1 = 0L)
    {
      locala.AcA = (l1 + l2);
      Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", new Object[] { str1, Long.valueOf(this.Akw.Acz), Long.valueOf(this.Akw.AcA) });
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (Util.isNullOrNil(this.Aky)) {
      this.Aky = com.tencent.mm.modelstat.e.bNb().oWh;
    }
    Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", new Object[] { this.Aky });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
 * JD-Core Version:    0.7.0.1
 */