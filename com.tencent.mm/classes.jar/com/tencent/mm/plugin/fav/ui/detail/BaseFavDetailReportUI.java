package com.tencent.mm.plugin.fav.ui.detail;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.n.b;
import com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public abstract class BaseFavDetailReportUI
  extends MMActivity
{
  public h.a keY = new h.a();
  protected boolean keZ;
  private String kfa = null;
  
  public final void E(com.tencent.mm.plugin.fav.a.g paramg)
  {
    if ((paramg != null) && (this.keY.scene > 0))
    {
      this.keY.jYG = paramg.field_id;
      this.keY.type = paramg.field_type;
      this.keY.source = paramg.field_sourceType;
      this.keY.timestamp = (paramg.field_sourceCreateTime / 1000L);
      if (this.keY.timestamp == 0L) {
        this.keY.timestamp = (paramg.field_updateTime / 1000L);
      }
      if (this.keY.timestamp == 0L) {
        this.keY.timestamp = paramg.field_edittime;
      }
      this.keY.jYH = b.r(paramg);
      this.keZ = true;
    }
  }
  
  protected MMLoadScrollView aRE()
  {
    return null;
  }
  
  public final void eK(long paramLong)
  {
    com.tencent.mm.plugin.fav.a.g localg = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(paramLong);
    if (localg != null) {
      E(localg);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("key_activity_browse_time", 0L);
      h.a locala = this.keY;
      locala.jYJ += l;
      y.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", new Object[] { Long.valueOf(this.keY.jYJ), Long.valueOf(l) });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.keY.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.keY.jYS = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.keY.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.keY.bVk = getIntent().getStringExtra("key_detail_fav_query");
    this.keY.sid = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.keY.jYU = getIntent().getStringExtra("key_detail_fav_tags");
    h.a locala = this.keY;
    if (this.keY.bVk == null)
    {
      paramBundle = "";
      locala.bVk = paramBundle;
      locala = this.keY;
      if (this.keY.sid != null) {
        break label269;
      }
      paramBundle = "";
      label145:
      locala.sid = paramBundle;
      locala = this.keY;
      if (this.keY.jYU != null) {
        break label280;
      }
    }
    label269:
    label280:
    for (paramBundle = "";; paramBundle = this.keY.jYU)
    {
      locala.jYU = paramBundle;
      paramBundle = aRE();
      if (paramBundle != null)
      {
        paramBundle.setOnTopOrBottomListerner(new BaseFavDetailReportUI.1(this));
        if ((paramBundle instanceof FavDetailScrollView)) {
          ((FavDetailScrollView)paramBundle).setOnScrollChangeListener(new BaseFavDetailReportUI.2(this));
        }
      }
      if (this.keY.scene == 0) {
        y.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
      }
      ta(this.mController.uMN.getResources().getColor(n.b.actionbar_title_light_color));
      czo();
      return;
      paramBundle = this.keY.bVk;
      break;
      paramBundle = this.keY.sid;
      break label145;
    }
  }
  
  public void onDestroy()
  {
    if (this.keZ) {
      e.post(new BaseFavDetailReportUI.3(this), "BaseFavReport");
    }
    setResult(-1, getIntent().putExtra("key_activity_browse_time", czu()));
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.keY.jYI = czu();
    String str1 = com.tencent.mm.modelstat.f.Rs().eDv;
    h.a locala;
    long l2;
    com.tencent.mm.modelstat.f localf;
    String str2;
    if ((!bk.isEqual(getClass().getName(), str1)) && (!bk.isEqual(str1, this.kfa)))
    {
      locala = this.keY;
      l2 = locala.jYJ;
      localf = com.tencent.mm.modelstat.f.Rs();
      str2 = com.tencent.mm.modelstat.f.Rs().eDv;
      if (localf.eDu == null) {
        break label152;
      }
    }
    label152:
    for (long l1 = ((Long)localf.eDu.get(str2)).longValue();; l1 = 0L)
    {
      locala.jYJ = (l1 + l2);
      y.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", new Object[] { str1, Long.valueOf(this.keY.jYI), Long.valueOf(this.keY.jYJ) });
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (bk.bl(this.kfa)) {
      this.kfa = com.tencent.mm.modelstat.f.Rs().eDv;
    }
    y.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", new Object[] { this.kfa });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
 * JD-Core Version:    0.7.0.1
 */