package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CleanMsgUI
  extends MMActivity
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
  private TextView iDt;
  private LinearLayout iDu;
  
  private void f(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = paramLong1;
    if (paramLong1 <= 0L)
    {
      l = 1L;
      com.tencent.mm.plugin.report.service.h.nFQ.a(714L, 61L, 1L, false);
    }
    int j = (int)(360L * paramLong2 / l);
    if ((paramLong2 > 0L) && (j < 5)) {
      j = 5;
    }
    for (;;)
    {
      int i = 0;
      if (paramLong3 > 0L)
      {
        int k = (int)(360L * paramLong3 / l);
        i = k;
        if (k < 5) {
          i = 5;
        }
      }
      paramLong1 = l - paramLong2 - paramLong3;
      y.i("MicroMsg.CleanMsgUI", "update acc[%d %d] otherAcc[%d %d] other[%d %d] wechat[%d] stack[%s]", new Object[] { Long.valueOf(paramLong2), Integer.valueOf((int)(100L * paramLong2 / l)), Long.valueOf(paramLong3), Integer.valueOf((int)(100L * paramLong3 / l)), Long.valueOf(paramLong1), Integer.valueOf((int)(100L * paramLong1 / l)), Long.valueOf(l), bk.csb() });
      this.iDf.setGreenTargetAngle(j);
      this.iDf.setOtherAccTargetAngle(i);
      this.iDf.setStage(1);
      this.iDe.setVisibility(0);
      this.iDj.setText(bk.cm(paramLong2));
      this.iDk.setText(bk.cm(paramLong3));
      this.iDl.setText(bk.cm(paramLong1));
      if (paramLong3 > 0L)
      {
        this.iDn.setVisibility(0);
        this.iDi.setEnabled(true);
      }
      TextView localTextView;
      StringBuffer localStringBuffer;
      for (;;)
      {
        this.iDq.setText(getString(R.l.clean_acc_tips));
        this.iDr.setText(getString(R.l.clean_other_acc_size_tips));
        this.iDs.setText(getString(R.l.clean_other_size_tips));
        if (((Integer)g.DP().Dz().get(ac.a.uxA, Integer.valueOf(0))).intValue() <= 0) {
          break label501;
        }
        this.iDu.setVisibility(0);
        this.iDt.setVisibility(0);
        localTextView = this.iDt;
        HashMap localHashMap = j.aEb().iBX;
        localStringBuffer = new StringBuffer();
        if (localHashMap.isEmpty()) {
          break;
        }
        Iterator localIterator = localHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localStringBuffer.append(str).append(" : ").append(bk.cm(((Long)localHashMap.get(str)).longValue())).append("\n");
        }
        this.iDi.setEnabled(false);
        this.iDn.setVisibility(0);
      }
      localTextView.setText(localStringBuffer.toString());
      label501:
      return;
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.clean_msg_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    f(j.aEb().iBk, j.aEb().iBl, j.aEb().iBm);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.nFQ.a(714L, 10L, 1L, false);
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
    this.iDt = ((TextView)findViewById(R.h.debug));
    this.iDu = ((LinearLayout)findViewById(R.h.debug_root));
    this.iDq = ((TextView)findViewById(R.h.wechat_tip));
    this.iDr = ((TextView)findViewById(R.h.other_acc_tip));
    this.iDs = ((TextView)findViewById(R.h.other_tip));
    this.iDn = ((View)findViewById(R.h.other_acc_data_layout));
    setMMTitle(R.l.clean_msg_ui_title);
    setBackBtn(new CleanMsgUI.1(this));
    this.iDi.setOnClickListener(new CleanMsgUI.2(this));
    this.iDh.setEnabled(true);
    this.iDh.setOnClickListener(new CleanMsgUI.3(this));
    getString(R.l.app_tip);
    this.dnm = com.tencent.mm.ui.base.h.b(this, getString(R.l.clean_del_data), false, new CleanMsgUI.4(this));
    this.dnm.dismiss();
    f(j.aEb().iBk, j.aEb().iBl, j.aEb().iBm);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI
 * JD-Core Version:    0.7.0.1
 */