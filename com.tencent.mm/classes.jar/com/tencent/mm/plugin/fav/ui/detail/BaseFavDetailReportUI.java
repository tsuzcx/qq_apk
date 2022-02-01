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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMLoadScrollView.a;

public abstract class BaseFavDetailReportUI
  extends MMActivity
{
  public h.a qPM = new h.a();
  protected boolean qPN;
  private String qPO = null;
  
  protected final void H(com.tencent.mm.plugin.fav.a.g paramg)
  {
    if ((paramg != null) && (this.qPM.scene > 0))
    {
      this.qPM.qIs = paramg.field_id;
      this.qPM.type = paramg.field_type;
      this.qPM.dbL = paramg.field_sourceType;
      this.qPM.timestamp = (paramg.field_sourceCreateTime / 1000L);
      if (this.qPM.timestamp == 0L) {
        this.qPM.timestamp = (paramg.field_updateTime / 1000L);
      }
      if (this.qPM.timestamp == 0L) {
        this.qPM.timestamp = paramg.field_edittime;
      }
      this.qPM.qIt = com.tencent.mm.plugin.fav.a.b.r(paramg);
      this.qPN = true;
    }
  }
  
  protected MMLoadScrollView crc()
  {
    return null;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (paramIntent != null))
    {
      long l = paramIntent.getLongExtra("key_activity_browse_time", 0L);
      h.a locala = this.qPM;
      locala.qIv += l;
      ac.v("MicroMsg.Fav.BaseFavDetailReportUI", "onActivityResult subDetailPeriod[%d] subUIBrowserTime[%d]", new Object[] { Long.valueOf(this.qPM.qIv), Long.valueOf(l) });
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.qPM.scene = getIntent().getIntExtra("key_detail_fav_scene", 0);
    this.qPM.nLC = getIntent().getIntExtra("key_detail_fav_sub_scene", 0);
    this.qPM.index = getIntent().getIntExtra("key_detail_fav_index", 0);
    this.qPM.query = getIntent().getStringExtra("key_detail_fav_query");
    this.qPM.qon = getIntent().getStringExtra("key_detail_fav_sessionid");
    this.qPM.qIF = getIntent().getStringExtra("key_detail_fav_tags");
    h.a locala = this.qPM;
    if (this.qPM.query == null)
    {
      paramBundle = "";
      locala.query = paramBundle;
      locala = this.qPM;
      if (this.qPM.qon != null) {
        break label265;
      }
      paramBundle = "";
      label145:
      locala.qon = paramBundle;
      locala = this.qPM;
      if (this.qPM.qIF != null) {
        break label276;
      }
    }
    label265:
    label276:
    for (paramBundle = "";; paramBundle = this.qPM.qIF)
    {
      locala.qIF = paramBundle;
      paramBundle = crc();
      if (paramBundle != null)
      {
        paramBundle.setOnTopOrBottomListerner(new MMLoadScrollView.a()
        {
          public final void cek()
          {
            BaseFavDetailReportUI.this.qPM.qID = true;
          }
        });
        if ((paramBundle instanceof FavDetailScrollView)) {
          ((FavDetailScrollView)paramBundle).setOnScrollChangeListener(new FavDetailScrollView.a()
          {
            public final void crd()
            {
              AppMethodBeat.i(107110);
              BaseFavDetailReportUI.this.showActionbarLine();
              AppMethodBeat.o(107110);
            }
            
            public final void cre()
            {
              AppMethodBeat.i(107111);
              BaseFavDetailReportUI.this.hideActionbarLine();
              AppMethodBeat.o(107111);
            }
          });
        }
      }
      if (this.qPM.scene == 0) {
        ac.i("MicroMsg.Fav.BaseFavDetailReportUI", "report object scene is 0");
      }
      setActionbarColor(getContext().getResources().getColor(2131101179));
      hideActionbarLine();
      return;
      paramBundle = this.qPM.query;
      break;
      paramBundle = this.qPM.qon;
      break label145;
    }
  }
  
  public void onDestroy()
  {
    if (this.qPN) {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(107112);
          BaseFavDetailReportUI.this.qPM.qIE = (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().Dh((int)BaseFavDetailReportUI.this.qPM.qIs) + 1);
          h.a(BaseFavDetailReportUI.this.qPM);
          AppMethodBeat.o(107112);
        }
      }, "BaseFavReport");
    }
    setResult(-1, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    e.cqy();
    super.onDestroy();
  }
  
  public void onPause()
  {
    this.qPM.qIu = getActivityBrowseTimeMs();
    String str1 = com.tencent.mm.modelstat.f.aIw().hWw;
    h.a locala;
    long l2;
    com.tencent.mm.modelstat.f localf;
    String str2;
    if ((!bs.lr(getClass().getName(), str1)) && (!bs.lr(str1, this.qPO)))
    {
      locala = this.qPM;
      l2 = locala.qIv;
      localf = com.tencent.mm.modelstat.f.aIw();
      str2 = com.tencent.mm.modelstat.f.aIw().hWw;
      if (localf.hWv == null) {
        break label154;
      }
    }
    label154:
    for (long l1 = ((Long)localf.hWv.get(str2)).longValue();; l1 = 0L)
    {
      locala.qIv = (l1 + l2);
      ac.v("MicroMsg.Fav.BaseFavDetailReportUI", "onPause lastClassname[%s] detailPeriod[%d] subDetailPeriod[%d]", new Object[] { str1, Long.valueOf(this.qPM.qIu), Long.valueOf(this.qPM.qIv) });
      super.onPause();
      return;
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (bs.isNullOrNil(this.qPO)) {
      this.qPO = com.tencent.mm.modelstat.f.aIw().hWw;
    }
    ac.v("MicroMsg.Fav.BaseFavDetailReportUI", "onResume firstResumeClassname[%s]", new Object[] { this.qPO });
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  protected final void tN(long paramLong)
  {
    com.tencent.mm.plugin.fav.a.g localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramLong);
    if (localg != null) {
      H(localg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.BaseFavDetailReportUI
 * JD-Core Version:    0.7.0.1
 */