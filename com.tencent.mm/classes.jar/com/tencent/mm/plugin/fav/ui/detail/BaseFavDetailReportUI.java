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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;

public abstract class BaseFavDetailReportUI
  extends MMActivity
{
  public h.a rHW = new h.a();
  protected boolean rHX;
  private String rHY = null;
  
  protected final void H(com.tencent.mm.plugin.fav.a.g paramg)
  {
    if ((paramg != null) && (this.rHW.scene > 0))
    {
      this.rHW.rAG = paramg.field_id;
      this.rHW.type = paramg.field_type;
      this.rHW.doj = paramg.field_sourceType;
      this.rHW.timestamp = (paramg.field_sourceCreateTime / 1000L);
      if (this.rHW.timestamp == 0L) {
        this.rHW.timestamp = (paramg.field_updateTime / 1000L);
      }
      if (this.rHW.timestamp == 0L) {
        this.rHW.timestamp = paramg.field_edittime;
      }
      this.rHW.rAH = com.tencent.mm.plugin.fav.a.b.r(paramg);
      this.rHX = true;
    }
  }
  
  protected MMLoadScrollView cyn()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("key_activity_browse_time", 0L);
      h.a locala = this.rHW;
      locala.rAJ += l;
      ae.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", new Object[] { Long.valueOf(this.rHW.rAJ), Long.valueOf(l) });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.rHW.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.rHW.otZ = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.rHW.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.rHW.query = getIntent().getStringExtra("key_detail_fav_query");
    this.rHW.rfp = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.rHW.rAT = getIntent().getStringExtra("key_detail_fav_tags");
    h.a locala = this.rHW;
    if (this.rHW.query == null)
    {
      paramBundle = "";
      locala.query = paramBundle;
      locala = this.rHW;
      if (this.rHW.rfp != null) {
        break label265;
      }
      paramBundle = "";
      label145:
      locala.rfp = paramBundle;
      locala = this.rHW;
      if (this.rHW.rAT != null) {
        break label276;
      }
    }
    label265:
    label276:
    for (paramBundle = "";; paramBundle = this.rHW.rAT)
    {
      locala.rAT = paramBundle;
      paramBundle = cyn();
      if (paramBundle != null)
      {
        paramBundle.setOnTopOrBottomListerner(new MMLoadScrollView.a()
        {
          public final void ckd()
          {
            BaseFavDetailReportUI.this.rHW.rAR = true;
          }
        });
        if ((paramBundle instanceof FavDetailScrollView)) {
          ((FavDetailScrollView)paramBundle).setOnScrollChangeListener(new FavDetailScrollView.a()
          {
            public final void cyo()
            {
              AppMethodBeat.i(107110);
              BaseFavDetailReportUI.this.showActionbarLine();
              AppMethodBeat.o(107110);
            }
            
            public final void cyp()
            {
              AppMethodBeat.i(107111);
              BaseFavDetailReportUI.this.hideActionbarLine();
              AppMethodBeat.o(107111);
            }
          });
        }
      }
      if (this.rHW.scene == 0) {
        ae.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
      }
      setActionbarColor(getContext().getResources().getColor(2131101179));
      hideActionbarLine();
      return;
      paramBundle = this.rHW.query;
      break;
      paramBundle = this.rHW.rfp;
      break label145;
    }
  }
  
  public void onDestroy()
  {
    if (this.rHX) {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107112);
          BaseFavDetailReportUI.this.rHW.rAS = (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().Em((int)BaseFavDetailReportUI.this.rHW.rAG) + 1);
          h.a(BaseFavDetailReportUI.this.rHW);
          AppMethodBeat.o(107112);
        }
      }, "BaseFavReport");
    }
    setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    e.cxE();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.rHW.rAI = getActivityBrowseTimeMs();
    String str1 = com.tencent.mm.modelstat.f.aMd().isM;
    h.a locala;
    long l2;
    com.tencent.mm.modelstat.f localf;
    String str2;
    if ((!bu.lX(getClass().getName(), str1)) && (!bu.lX(str1, this.rHY)))
    {
      locala = this.rHW;
      l2 = locala.rAJ;
      localf = com.tencent.mm.modelstat.f.aMd();
      str2 = com.tencent.mm.modelstat.f.aMd().isM;
      if (localf.isL == null) {
        break label154;
      }
    }
    label154:
    for (long l1 = ((Long)localf.isL.get(str2)).longValue();; l1 = 0L)
    {
      locala.rAJ = (l1 + l2);
      ae.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", new Object[] { str1, Long.valueOf(this.rHW.rAI), Long.valueOf(this.rHW.rAJ) });
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (bu.isNullOrNil(this.rHY)) {
      this.rHY = com.tencent.mm.modelstat.f.aMd().isM;
    }
    ae.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", new Object[] { this.rHY });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void wa(long paramLong)
  {
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramLong);
    if (localg != null) {
      H(localg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
 * JD-Core Version:    0.7.0.1
 */