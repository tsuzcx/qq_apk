package com.tencent.mm.plugin.clean.ui.newui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.clean.c.d;
import com.tencent.mm.plugin.clean.c.g;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CleanMsgUI
  extends MMActivity
  implements g, com.tencent.mm.plugin.clean.c.h
{
  private ProgressDialog dnm;
  private View iDe;
  private PieView iDf;
  private TextView iDg;
  private Button iDh;
  private Button iDi;
  private TextView iDj;
  private TextView iDk;
  private TextView iDl;
  private TextView iDm;
  private View iDn;
  private TextView iDo;
  private TextView iDp;
  private TextView iDq;
  private TextView iDr;
  private TextView iDs;
  private com.tencent.mm.plugin.clean.c.e iEa;
  private c iEg;
  
  private void g(long paramLong1, long paramLong2, long paramLong3)
  {
    int j = (int)(360L * paramLong3 / paramLong1);
    if (j < 5) {
      j = 5;
    }
    for (;;)
    {
      int i = 0;
      if (paramLong2 > 0L)
      {
        int k = (int)(360L * paramLong2 / paramLong1);
        i = k;
        if (k < 5) {
          i = 5;
        }
      }
      long l = paramLong1 - paramLong3 - paramLong2;
      y.i("MicroMsg.CleanMsgUI", "update [%d %d] [%d %d] [%d %d] wechatSize[%d]", new Object[] { Long.valueOf(paramLong3), Integer.valueOf(j), Long.valueOf(paramLong2), Integer.valueOf(i), Long.valueOf(l), Integer.valueOf((int)(360L * l / paramLong1)), Long.valueOf(paramLong1) });
      this.iDf.setGreenTargetAngle(j);
      this.iDf.setOtherAccTargetAngle(i);
      this.iDf.setStage(1);
      this.iDe.setVisibility(0);
      this.iDj.setText(bk.cm(paramLong3));
      this.iDk.setText(bk.cm(paramLong2));
      this.iDl.setText(bk.cm(l));
      if (paramLong2 > 0L)
      {
        this.iDn.setVisibility(0);
        this.iDi.setVisibility(0);
      }
      for (;;)
      {
        i = (int)(100L * paramLong3 / paramLong1);
        this.iDq.setText(getString(R.l.clean_acc_tips, new Object[] { i + "%" }));
        i = (int)(100L * paramLong2 / paramLong1);
        this.iDr.setText(getString(R.l.clean_other_acc_size_tips, new Object[] { i + "%" }));
        i = (int)(100L * l / paramLong1);
        this.iDs.setText(getString(R.l.clean_other_size_tips, new Object[] { i + "%" }));
        return;
        this.iDi.setVisibility(8);
        this.iDn.setVisibility(8);
      }
    }
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, ArrayList<com.tencent.mm.plugin.clean.c.b> paramArrayList, long paramLong4, HashSet<String> paramHashSet)
  {
    y.i("MicroMsg.CleanMsgUI", "%d on clean result cleanDataSize[%d] wechatSize[%d] otherAccSize[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong4) });
    this.iDg.setVisibility(8);
    this.iDh.setEnabled(true);
    enableOptionMenu(0, true);
    g(paramLong2, paramLong4, paramLong3);
    if (paramLong1 > 0L)
    {
      this.iDo.setVisibility(0);
      this.iDo.setText(getString(R.l.clean_del_temp_data, new Object[] { bk.cm(paramLong1) }));
    }
    for (;;)
    {
      d.cX(paramLong1);
      d.cU(paramLong2);
      d.cW(paramLong4);
      d.b(paramHashSet);
      d.cV(paramLong3);
      d.p(paramArrayList);
      if (paramLong4 <= 0L) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.nFQ.a(282L, 9L, 1L, false);
      return;
      this.iDo.setVisibility(8);
      this.iDo.setText("");
    }
    com.tencent.mm.plugin.report.service.h.nFQ.a(282L, 10L, 1L, false);
  }
  
  public final void cA(int paramInt1, int paramInt2)
  {
    this.dnm.setMessage(getString(R.l.clean_progress_tip, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
  }
  
  public final void cZ(long paramLong)
  {
    this.dnm.dismiss();
    d.cU(d.aDR() - paramLong);
    d.cX(d.aDU() + paramLong);
    d.aDU();
    g(d.aDR(), d.aDT(), d.aDS());
  }
  
  public final void cz(int paramInt1, int paramInt2)
  {
    this.iDg.setText(getString(R.l.analyse_file_profress, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
  }
  
  protected final int getLayoutId()
  {
    return R.i.clean_msg_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    d.aDU();
    g(d.aDR(), d.aDT(), d.aDS());
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.nFQ.a(282L, 3L, 1L, false);
    d.aDX();
    this.iDg = ((TextView)findViewById(R.h.process_info_tv));
    this.iDf = ((PieView)findViewById(R.h.pie_view));
    this.iDh = ((Button)findViewById(R.h.clean_btn));
    this.iDi = ((Button)findViewById(R.h.clean_other_btn));
    this.iDe = findViewById(R.h.analyse_data_layout);
    this.iDj = ((TextView)findViewById(R.h.wechat_data_tv));
    this.iDj.setTextSize(1, 16.0F);
    this.iDk = ((TextView)findViewById(R.h.other_acc_data_tv));
    this.iDk.setTextSize(1, 16.0F);
    this.iDl = ((TextView)findViewById(R.h.other_data_tv));
    this.iDl.setTextSize(1, 16.0F);
    this.iDm = ((TextView)findViewById(R.h.free_data_tv));
    this.iDm.setTextSize(1, 16.0F);
    this.iDo = ((TextView)findViewById(R.h.clean_data_tv));
    this.iDp = ((TextView)findViewById(R.h.clean_suggest_tv));
    this.iDq = ((TextView)findViewById(R.h.wechat_tip));
    this.iDr = ((TextView)findViewById(R.h.other_acc_tip));
    this.iDs = ((TextView)findViewById(R.h.other_tip));
    this.iDn = ((View)findViewById(R.h.other_acc_data_layout));
    setMMTitle(R.l.clean_ui_title);
    d.a(new com.tencent.mm.plugin.clean.c.a.b());
    setBackBtn(new CleanMsgUI.1(this));
    this.iDi.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        com.tencent.mm.ui.base.h.a(CleanMsgUI.this, CleanMsgUI.this.getString(R.l.clean_other_acc_tips, new Object[] { bk.ht(d.aDT()) }), "", CleanMsgUI.this.getString(R.l.app_ok), CleanMsgUI.this.getString(R.l.app_cancel), new CleanMsgUI.2.1(this), null);
      }
    });
    this.iDh.setOnClickListener(new CleanMsgUI.3(this));
    addIconOptionMenu(0, R.k.actionbar_icon_dark_more, new CleanMsgUI.4(this));
    enableOptionMenu(0, false);
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.clean_del_data), false, new CleanMsgUI.5(this));
    this.dnm.dismiss();
    if (d.aDQ() != null)
    {
      this.iDg.setVisibility(8);
      this.iDh.setEnabled(true);
      enableOptionMenu(0, true);
      d.aDU();
      g(d.aDR(), d.aDT(), d.aDS());
    }
    do
    {
      return;
      paramBundle = d.aDO();
    } while (paramBundle == null);
    this.iEg = new c(paramBundle, this);
    com.tencent.mm.sdk.f.e.post(this.iEg, "CleanUI_clean");
    this.iDg.setText(getString(R.l.analyse_file_profress, new Object[] { "0%" }));
  }
  
  protected void onDestroy()
  {
    Object localObject;
    if (this.iEg != null)
    {
      localObject = this.iEg;
      y.i("MicroMsg.CleanController", "stop CleanController [%d]", new Object[] { Integer.valueOf(localObject.hashCode()) });
      ((c)localObject).isStop = true;
      com.tencent.mm.sdk.f.e.Y((Runnable)localObject);
    }
    if (this.iEa != null) {
      this.iEa.aDZ();
    }
    if (d.aDO() != null)
    {
      localObject = d.aDO();
      Iterator localIterator = ((com.tencent.mm.plugin.clean.c.a.b)localObject).iCb.values().iterator();
      while (localIterator.hasNext()) {
        ((ah)localIterator.next()).removeCallbacksAndMessages(null);
      }
      localIterator = ((com.tencent.mm.plugin.clean.c.a.b)localObject).iCb.values().iterator();
      while (localIterator.hasNext())
      {
        ah localah = (ah)localIterator.next();
        localah.getLooper().getThread().interrupt();
        localah.getLooper().quit();
      }
      y.i("MicroMsg.ThreadController", "finish thread controller [%d]", new Object[] { Integer.valueOf(localObject.hashCode()) });
    }
    d.aDY();
    d.aDW();
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI
 * JD-Core Version:    0.7.0.1
 */