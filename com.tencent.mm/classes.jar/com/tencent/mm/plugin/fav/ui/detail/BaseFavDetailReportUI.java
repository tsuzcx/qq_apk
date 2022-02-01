package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.f;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.s.b;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.ui.report.MMSecDataActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;

public abstract class BaseFavDetailReportUI
  extends MMSecDataActivity
{
  public h.a wNU = new h.a();
  protected boolean wNV;
  private String wNW = null;
  
  protected final void H(g paramg)
  {
    if ((paramg != null) && (this.wNU.scene > 0))
    {
      this.wNU.wGo = paramg.field_id;
      this.wNU.type = paramg.field_type;
      this.wNU.source = paramg.field_sourceType;
      this.wNU.timestamp = (paramg.field_sourceCreateTime / 1000L);
      if (this.wNU.timestamp == 0L) {
        this.wNU.timestamp = (paramg.field_updateTime / 1000L);
      }
      if (this.wNU.timestamp == 0L) {
        this.wNU.timestamp = paramg.field_edittime;
      }
      this.wNU.wGp = b.r(paramg);
      this.wNV = true;
    }
  }
  
  protected final void Ks(long paramLong)
  {
    g localg = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(paramLong);
    if (localg != null) {
      H(localg);
    }
  }
  
  protected MMLoadScrollView dly()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("key_activity_browse_time", 0L);
      h.a locala = this.wNU;
      locala.wGr += l;
      Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", new Object[] { Long.valueOf(this.wNU.wGr), Long.valueOf(l) });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.wNU.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.wNU.wGA = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.wNU.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.wNU.query = getIntent().getStringExtra("key_detail_fav_query");
    this.wNU.wmA = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.wNU.wGC = getIntent().getStringExtra("key_detail_fav_tags");
    h.a locala = this.wNU;
    if (this.wNU.query == null)
    {
      paramBundle = "";
      locala.query = paramBundle;
      locala = this.wNU;
      if (this.wNU.wmA != null) {
        break label266;
      }
      paramBundle = "";
      label145:
      locala.wmA = paramBundle;
      locala = this.wNU;
      if (this.wNU.wGC != null) {
        break label277;
      }
    }
    label266:
    label277:
    for (paramBundle = "";; paramBundle = this.wNU.wGC)
    {
      locala.wGC = paramBundle;
      paramBundle = dly();
      if (paramBundle != null)
      {
        paramBundle.setOnTopOrBottomListerner(new MMLoadScrollView.a()
        {
          public final void cWL()
          {
            BaseFavDetailReportUI.this.wNU.wGz = true;
          }
        });
        if ((paramBundle instanceof FavDetailScrollView)) {
          ((FavDetailScrollView)paramBundle).setOnScrollChangeListener(new FavDetailScrollView.a()
          {
            public final void dlA()
            {
              AppMethodBeat.i(107111);
              BaseFavDetailReportUI.this.hideActionbarLine();
              AppMethodBeat.o(107111);
            }
            
            public final void dlz()
            {
              AppMethodBeat.i(107110);
              BaseFavDetailReportUI.this.showActionbarLine();
              AppMethodBeat.o(107110);
            }
          });
        }
      }
      if (this.wNU.scene == 0) {
        Log.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
      }
      setActionbarColor(getContext().getResources().getColor(s.b.white));
      hideActionbarLine();
      return;
      paramBundle = this.wNU.query;
      break;
      paramBundle = this.wNU.wmA;
      break label145;
    }
  }
  
  public void onDestroy()
  {
    if (this.wNV) {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107112);
          BaseFavDetailReportUI.this.wNU.wGB = (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().LH((int)BaseFavDetailReportUI.this.wNU.wGo) + 1);
          com.tencent.mm.plugin.fav.a.h.a(BaseFavDetailReportUI.this.wNU);
          AppMethodBeat.o(107112);
        }
      }, "BaseFavReport");
    }
    setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    com.tencent.mm.plugin.fav.ui.e.dkO();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.wNU.wGq = getActivityBrowseTimeMs();
    String str1 = com.tencent.mm.modelstat.e.bpu().mdo;
    h.a locala;
    long l2;
    com.tencent.mm.modelstat.e locale;
    String str2;
    if ((!Util.isEqual(getClass().getName(), str1)) && (!Util.isEqual(str1, this.wNW)))
    {
      locala = this.wNU;
      l2 = locala.wGr;
      locale = com.tencent.mm.modelstat.e.bpu();
      str2 = com.tencent.mm.modelstat.e.bpu().mdo;
      if (locale.mdn == null) {
        break label154;
      }
    }
    label154:
    for (long l1 = ((Long)locale.mdn.get(str2)).longValue();; l1 = 0L)
    {
      locala.wGr = (l1 + l2);
      Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", new Object[] { str1, Long.valueOf(this.wNU.wGq), Long.valueOf(this.wNU.wGr) });
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (Util.isNullOrNil(this.wNW)) {
      this.wNW = com.tencent.mm.modelstat.e.bpu().mdo;
    }
    Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", new Object[] { this.wNW });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
 * JD-Core Version:    0.7.0.1
 */