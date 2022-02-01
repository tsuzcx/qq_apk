package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;

public abstract class BaseFavDetailReportUI
  extends MMActivity
{
  public h.a rzL = new h.a();
  protected boolean rzM;
  private String rzN = null;
  
  protected final void H(com.tencent.mm.plugin.fav.a.g paramg)
  {
    if ((paramg != null) && (this.rzL.scene > 0))
    {
      this.rzL.rst = paramg.field_id;
      this.rzL.type = paramg.field_type;
      this.rzL.dnh = paramg.field_sourceType;
      this.rzL.timestamp = (paramg.field_sourceCreateTime / 1000L);
      if (this.rzL.timestamp == 0L) {
        this.rzL.timestamp = (paramg.field_updateTime / 1000L);
      }
      if (this.rzL.timestamp == 0L) {
        this.rzL.timestamp = paramg.field_edittime;
      }
      this.rzL.rsu = com.tencent.mm.plugin.fav.a.b.r(paramg);
      this.rzM = true;
    }
  }
  
  protected MMLoadScrollView cwM()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("key_activity_browse_time", 0L);
      h.a locala = this.rzL;
      locala.rsw += l;
      ad.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", new Object[] { Long.valueOf(this.rzL.rsw), Long.valueOf(l) });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.rzL.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.rzL.ooi = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.rzL.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.rzL.query = getIntent().getStringExtra("key_detail_fav_query");
    this.rzL.qXk = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.rzL.rsG = getIntent().getStringExtra("key_detail_fav_tags");
    h.a locala = this.rzL;
    if (this.rzL.query == null)
    {
      paramBundle = "";
      locala.query = paramBundle;
      locala = this.rzL;
      if (this.rzL.qXk != null) {
        break label265;
      }
      paramBundle = "";
      label145:
      locala.qXk = paramBundle;
      locala = this.rzL;
      if (this.rzL.rsG != null) {
        break label276;
      }
    }
    label265:
    label276:
    for (paramBundle = "";; paramBundle = this.rzL.rsG)
    {
      locala.rsG = paramBundle;
      paramBundle = cwM();
      if (paramBundle != null)
      {
        paramBundle.setOnTopOrBottomListerner(new MMLoadScrollView.a()
        {
          public final void ciN()
          {
            BaseFavDetailReportUI.this.rzL.rsE = true;
          }
        });
        if ((paramBundle instanceof FavDetailScrollView)) {
          ((FavDetailScrollView)paramBundle).setOnScrollChangeListener(new FavDetailScrollView.a()
          {
            public final void cwN()
            {
              AppMethodBeat.i(107110);
              BaseFavDetailReportUI.this.showActionbarLine();
              AppMethodBeat.o(107110);
            }
            
            public final void cwO()
            {
              AppMethodBeat.i(107111);
              BaseFavDetailReportUI.this.hideActionbarLine();
              AppMethodBeat.o(107111);
            }
          });
        }
      }
      if (this.rzL.scene == 0) {
        ad.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
      }
      setActionbarColor(getContext().getResources().getColor(2131101179));
      hideActionbarLine();
      return;
      paramBundle = this.rzL.query;
      break;
      paramBundle = this.rzL.qXk;
      break label145;
    }
  }
  
  public void onDestroy()
  {
    if (this.rzM) {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107112);
          BaseFavDetailReportUI.this.rzL.rsF = (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().DZ((int)BaseFavDetailReportUI.this.rzL.rst) + 1);
          h.a(BaseFavDetailReportUI.this.rzL);
          AppMethodBeat.o(107112);
        }
      }, "BaseFavReport");
    }
    setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    e.cwd();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.rzL.rsv = getActivityBrowseTimeMs();
    String str1 = com.tencent.mm.modelstat.f.aLG().ipR;
    h.a locala;
    long l2;
    com.tencent.mm.modelstat.f localf;
    String str2;
    if ((!bt.lQ(getClass().getName(), str1)) && (!bt.lQ(str1, this.rzN)))
    {
      locala = this.rzL;
      l2 = locala.rsw;
      localf = com.tencent.mm.modelstat.f.aLG();
      str2 = com.tencent.mm.modelstat.f.aLG().ipR;
      if (localf.ipQ == null) {
        break label154;
      }
    }
    label154:
    for (long l1 = ((Long)localf.ipQ.get(str2)).longValue();; l1 = 0L)
    {
      locala.rsw = (l1 + l2);
      ad.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", new Object[] { str1, Long.valueOf(this.rzL.rsv), Long.valueOf(this.rzL.rsw) });
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (bt.isNullOrNil(this.rzN)) {
      this.rzN = com.tencent.mm.modelstat.f.aLG().ipR;
    }
    ad.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", new Object[] { this.rzN });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void vK(long paramLong)
  {
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramLong);
    if (localg != null) {
      H(localg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
 * JD-Core Version:    0.7.0.1
 */