package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.e;
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
  public h.a thD = new h.a();
  protected boolean thE;
  private String thF = null;
  
  protected final void Ee(long paramLong)
  {
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramLong);
    if (localg != null) {
      H(localg);
    }
  }
  
  protected final void H(com.tencent.mm.plugin.fav.a.g paramg)
  {
    if ((paramg != null) && (this.thD.scene > 0))
    {
      this.thD.tal = paramg.field_id;
      this.thD.type = paramg.field_type;
      this.thD.source = paramg.field_sourceType;
      this.thD.timestamp = (paramg.field_sourceCreateTime / 1000L);
      if (this.thD.timestamp == 0L) {
        this.thD.timestamp = (paramg.field_updateTime / 1000L);
      }
      if (this.thD.timestamp == 0L) {
        this.thD.timestamp = paramg.field_edittime;
      }
      this.thD.tam = b.r(paramg);
      this.thE = true;
    }
  }
  
  protected MMLoadScrollView cWr()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("key_activity_browse_time", 0L);
      h.a locala = this.thD;
      locala.tao += l;
      Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", new Object[] { Long.valueOf(this.thD.tao), Long.valueOf(l) });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.thD.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.thD.pHw = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.thD.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.thD.query = getIntent().getStringExtra("key_detail_fav_query");
    this.thD.sGF = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.thD.tay = getIntent().getStringExtra("key_detail_fav_tags");
    h.a locala = this.thD;
    if (this.thD.query == null)
    {
      paramBundle = "";
      locala.query = paramBundle;
      locala = this.thD;
      if (this.thD.sGF != null) {
        break label265;
      }
      paramBundle = "";
      label145:
      locala.sGF = paramBundle;
      locala = this.thD;
      if (this.thD.tay != null) {
        break label276;
      }
    }
    label265:
    label276:
    for (paramBundle = "";; paramBundle = this.thD.tay)
    {
      locala.tay = paramBundle;
      paramBundle = cWr();
      if (paramBundle != null)
      {
        paramBundle.setOnTopOrBottomListerner(new MMLoadScrollView.a()
        {
          public final void cIe()
          {
            BaseFavDetailReportUI.this.thD.taw = true;
          }
        });
        if ((paramBundle instanceof FavDetailScrollView)) {
          ((FavDetailScrollView)paramBundle).setOnScrollChangeListener(new FavDetailScrollView.a()
          {
            public final void cWs()
            {
              AppMethodBeat.i(107110);
              BaseFavDetailReportUI.this.showActionbarLine();
              AppMethodBeat.o(107110);
            }
            
            public final void cWt()
            {
              AppMethodBeat.i(107111);
              BaseFavDetailReportUI.this.hideActionbarLine();
              AppMethodBeat.o(107111);
            }
          });
        }
      }
      if (this.thD.scene == 0) {
        Log.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
      }
      setActionbarColor(getContext().getResources().getColor(2131101424));
      hideActionbarLine();
      return;
      paramBundle = this.thD.query;
      break;
      paramBundle = this.thD.sGF;
      break label145;
    }
  }
  
  public void onDestroy()
  {
    if (this.thE) {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107112);
          BaseFavDetailReportUI.this.thD.tax = (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().HX((int)BaseFavDetailReportUI.this.thD.tal) + 1);
          h.a(BaseFavDetailReportUI.this.thD);
          AppMethodBeat.o(107112);
        }
      }, "BaseFavReport");
    }
    setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    e.cVI();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.thD.tan = getActivityBrowseTimeMs();
    String str1 = com.tencent.mm.modelstat.f.bgg().jnZ;
    h.a locala;
    long l2;
    com.tencent.mm.modelstat.f localf;
    String str2;
    if ((!Util.isEqual(getClass().getName(), str1)) && (!Util.isEqual(str1, this.thF)))
    {
      locala = this.thD;
      l2 = locala.tao;
      localf = com.tencent.mm.modelstat.f.bgg();
      str2 = com.tencent.mm.modelstat.f.bgg().jnZ;
      if (localf.jnY == null) {
        break label154;
      }
    }
    label154:
    for (long l1 = ((Long)localf.jnY.get(str2)).longValue();; l1 = 0L)
    {
      locala.tao = (l1 + l2);
      Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", new Object[] { str1, Long.valueOf(this.thD.tan), Long.valueOf(this.thD.tao) });
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (Util.isNullOrNil(this.thF)) {
      this.thF = com.tencent.mm.modelstat.f.bgg().jnZ;
    }
    Log.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", new Object[] { this.thF });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
 * JD-Core Version:    0.7.0.1
 */