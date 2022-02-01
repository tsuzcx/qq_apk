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
  public h.a qhk = new h.a();
  protected boolean qhl;
  private String qhm = null;
  
  protected final void H(com.tencent.mm.plugin.fav.a.g paramg)
  {
    if ((paramg != null) && (this.qhk.scene > 0))
    {
      this.qhk.pZL = paramg.field_id;
      this.qhk.type = paramg.field_type;
      this.qhk.dep = paramg.field_sourceType;
      this.qhk.timestamp = (paramg.field_sourceCreateTime / 1000L);
      if (this.qhk.timestamp == 0L) {
        this.qhk.timestamp = (paramg.field_updateTime / 1000L);
      }
      if (this.qhk.timestamp == 0L) {
        this.qhk.timestamp = paramg.field_edittime;
      }
      this.qhk.pZM = com.tencent.mm.plugin.fav.a.b.r(paramg);
      this.qhl = true;
    }
  }
  
  protected MMLoadScrollView cjv()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("key_activity_browse_time", 0L);
      h.a locala = this.qhk;
      locala.pZO += l;
      ad.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", new Object[] { Long.valueOf(this.qhk.pZO), Long.valueOf(l) });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qhk.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.qhk.niJ = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.qhk.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.qhk.query = getIntent().getStringExtra("key_detail_fav_query");
    this.qhk.pZX = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.qhk.pZZ = getIntent().getStringExtra("key_detail_fav_tags");
    h.a locala = this.qhk;
    if (this.qhk.query == null)
    {
      paramBundle = "";
      locala.query = paramBundle;
      locala = this.qhk;
      if (this.qhk.pZX != null) {
        break label265;
      }
      paramBundle = "";
      label145:
      locala.pZX = paramBundle;
      locala = this.qhk;
      if (this.qhk.pZZ != null) {
        break label276;
      }
    }
    label265:
    label276:
    for (paramBundle = "";; paramBundle = this.qhk.pZZ)
    {
      locala.pZZ = paramBundle;
      paramBundle = cjv();
      if (paramBundle != null)
      {
        paramBundle.setOnTopOrBottomListerner(new MMLoadScrollView.a()
        {
          public final void bWX()
          {
            BaseFavDetailReportUI.this.qhk.pZW = true;
          }
        });
        if ((paramBundle instanceof FavDetailScrollView)) {
          ((FavDetailScrollView)paramBundle).setOnScrollChangeListener(new FavDetailScrollView.a()
          {
            public final void cjw()
            {
              AppMethodBeat.i(107110);
              BaseFavDetailReportUI.this.showActionbarLine();
              AppMethodBeat.o(107110);
            }
            
            public final void cjx()
            {
              AppMethodBeat.i(107111);
              BaseFavDetailReportUI.this.hideActionbarLine();
              AppMethodBeat.o(107111);
            }
          });
        }
      }
      if (this.qhk.scene == 0) {
        ad.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
      }
      setActionbarColor(getContext().getResources().getColor(2131101179));
      hideActionbarLine();
      return;
      paramBundle = this.qhk.query;
      break;
      paramBundle = this.qhk.pZX;
      break label145;
    }
  }
  
  public void onDestroy()
  {
    if (this.qhl) {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107112);
          BaseFavDetailReportUI.this.qhk.pZY = (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().Cm((int)BaseFavDetailReportUI.this.qhk.pZL) + 1);
          h.a(BaseFavDetailReportUI.this.qhk);
          AppMethodBeat.o(107112);
        }
      }, "BaseFavReport");
    }
    setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    e.ciR();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.qhk.pZN = getActivityBrowseTimeMs();
    String str1 = com.tencent.mm.modelstat.f.aBG().hvV;
    h.a locala;
    long l2;
    com.tencent.mm.modelstat.f localf;
    String str2;
    if ((!bt.kU(getClass().getName(), str1)) && (!bt.kU(str1, this.qhm)))
    {
      locala = this.qhk;
      l2 = locala.pZO;
      localf = com.tencent.mm.modelstat.f.aBG();
      str2 = com.tencent.mm.modelstat.f.aBG().hvV;
      if (localf.hvU == null) {
        break label154;
      }
    }
    label154:
    for (long l1 = ((Long)localf.hvU.get(str2)).longValue();; l1 = 0L)
    {
      locala.pZO = (l1 + l2);
      ad.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", new Object[] { str1, Long.valueOf(this.qhk.pZN), Long.valueOf(this.qhk.pZO) });
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (bt.isNullOrNil(this.qhm)) {
      this.qhm = com.tencent.mm.modelstat.f.aBG().hvV;
    }
    ad.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", new Object[] { this.qhm });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void pY(long paramLong)
  {
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramLong);
    if (localg != null) {
      H(localg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
 * JD-Core Version:    0.7.0.1
 */