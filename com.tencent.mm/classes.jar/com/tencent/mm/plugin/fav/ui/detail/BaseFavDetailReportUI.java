package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public abstract class BaseFavDetailReportUI
  extends MMActivity
{
  public h.a mzH = new h.a();
  protected boolean mzI;
  private String mzJ = null;
  
  protected final void F(com.tencent.mm.plugin.fav.a.g paramg)
  {
    if ((paramg != null) && (this.mzH.scene > 0))
    {
      this.mzH.msZ = paramg.field_id;
      this.mzH.type = paramg.field_type;
      this.mzH.cpt = paramg.field_sourceType;
      this.mzH.timestamp = (paramg.field_sourceCreateTime / 1000L);
      if (this.mzH.timestamp == 0L) {
        this.mzH.timestamp = (paramg.field_updateTime / 1000L);
      }
      if (this.mzH.timestamp == 0L) {
        this.mzH.timestamp = paramg.field_edittime;
      }
      this.mzH.mta = b.r(paramg);
      this.mzI = true;
    }
  }
  
  protected MMLoadScrollView bxU()
  {
    return null;
  }
  
  protected final void ki(long paramLong)
  {
    com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(paramLong);
    if (localg != null) {
      F(localg);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("key_activity_browse_time", 0L);
      h.a locala = this.mzH;
      locala.mtc += l;
      ab.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", new Object[] { Long.valueOf(this.mzH.mtc), Long.valueOf(l) });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mzH.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.mzH.kbN = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.mzH.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.mzH.query = getIntent().getStringExtra("key_detail_fav_query");
    this.mzH.sid = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.mzH.mtm = getIntent().getStringExtra("key_detail_fav_tags");
    h.a locala = this.mzH;
    if (this.mzH.query == null)
    {
      paramBundle = "";
      locala.query = paramBundle;
      locala = this.mzH;
      if (this.mzH.sid != null) {
        break label265;
      }
      paramBundle = "";
      label145:
      locala.sid = paramBundle;
      locala = this.mzH;
      if (this.mzH.mtm != null) {
        break label276;
      }
    }
    label265:
    label276:
    for (paramBundle = "";; paramBundle = this.mzH.mtm)
    {
      locala.mtm = paramBundle;
      paramBundle = bxU();
      if (paramBundle != null)
      {
        paramBundle.setOnTopOrBottomListerner(new BaseFavDetailReportUI.1(this));
        if ((paramBundle instanceof FavDetailScrollView)) {
          ((FavDetailScrollView)paramBundle).setOnScrollChangeListener(new BaseFavDetailReportUI.2(this));
        }
      }
      if (this.mzH.scene == 0) {
        ab.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
      }
      setActionbarColor(getContext().getResources().getColor(2131689653));
      hideActionbarLine();
      return;
      paramBundle = this.mzH.query;
      break;
      paramBundle = this.mzH.sid;
      break label145;
    }
  }
  
  public void onDestroy()
  {
    if (this.mzI) {
      d.post(new BaseFavDetailReportUI.3(this), "BaseFavReport");
    }
    setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    c.bxt();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.mzH.mtb = getActivityBrowseTimeMs();
    String str1 = com.tencent.mm.modelstat.f.akB().fTm;
    h.a locala;
    long l2;
    com.tencent.mm.modelstat.f localf;
    String str2;
    if ((!bo.isEqual(getClass().getName(), str1)) && (!bo.isEqual(str1, this.mzJ)))
    {
      locala = this.mzH;
      l2 = locala.mtc;
      localf = com.tencent.mm.modelstat.f.akB();
      str2 = com.tencent.mm.modelstat.f.akB().fTm;
      if (localf.fTl == null) {
        break label154;
      }
    }
    label154:
    for (long l1 = ((Long)localf.fTl.get(str2)).longValue();; l1 = 0L)
    {
      locala.mtc = (l1 + l2);
      ab.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", new Object[] { str1, Long.valueOf(this.mzH.mtb), Long.valueOf(this.mzH.mtc) });
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (bo.isNullOrNil(this.mzJ)) {
      this.mzJ = com.tencent.mm.modelstat.f.akB().fTm;
    }
    ab.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", new Object[] { this.mzJ });
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