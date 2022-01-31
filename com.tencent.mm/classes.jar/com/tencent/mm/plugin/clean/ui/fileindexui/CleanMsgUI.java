package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.clean.c.j;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class CleanMsgUI
  extends MMActivity
{
  private ProgressDialog eeN;
  private TextView kIA;
  private LinearLayout kIB;
  private View kIl;
  private PieView kIm;
  private TextView kIn;
  private Button kIo;
  private Button kIp;
  private TextView kIq;
  private TextView kIr;
  private TextView kIs;
  private TextView kIt;
  private View kIu;
  private TextView kIv;
  private TextView kIw;
  private TextView kIx;
  private TextView kIy;
  private TextView kIz;
  
  private void g(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(18805);
    long l = paramLong1;
    if (paramLong1 <= 0L)
    {
      l = 1L;
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(714L, 61L, 1L, false);
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
      ab.i("MicroMsg.CleanMsgUI", "update acc[%d %d] otherAcc[%d %d] other[%d %d] wechat[%d] stack[%s]", new Object[] { Long.valueOf(paramLong2), Integer.valueOf((int)(100L * paramLong2 / l)), Long.valueOf(paramLong3), Integer.valueOf((int)(100L * paramLong3 / l)), Long.valueOf(paramLong1), Integer.valueOf((int)(100L * paramLong1 / l)), Long.valueOf(l), bo.dtY() });
      this.kIm.setGreenTargetAngle(j);
      this.kIm.setOtherAccTargetAngle(i);
      this.kIm.setStage(1);
      this.kIl.setVisibility(0);
      this.kIq.setText(bo.hk(paramLong2));
      this.kIr.setText(bo.hk(paramLong3));
      this.kIs.setText(bo.hk(paramLong1));
      if (paramLong3 > 0L)
      {
        this.kIu.setVisibility(0);
        this.kIp.setEnabled(true);
      }
      for (;;)
      {
        this.kIx.setText(getString(2131298367));
        this.kIy.setText(getString(2131298390));
        this.kIz.setText(getString(2131298393));
        if (((Integer)g.RL().Ru().get(ac.a.yHJ, Integer.valueOf(0))).intValue() > 0)
        {
          this.kIB.setVisibility(0);
          this.kIA.setVisibility(0);
          this.kIA.setText(l(j.bhb().kHe));
        }
        AppMethodBeat.o(18805);
        return;
        this.kIp.setEnabled(false);
        this.kIu.setVisibility(0);
      }
    }
  }
  
  private static String l(HashMap<String, Long> paramHashMap)
  {
    AppMethodBeat.i(18808);
    StringBuffer localStringBuffer = new StringBuffer();
    if (!paramHashMap.isEmpty())
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localStringBuffer.append(str).append(" : ").append(bo.hk(((Long)paramHashMap.get(str)).longValue())).append("\n");
      }
    }
    paramHashMap = localStringBuffer.toString();
    AppMethodBeat.o(18808);
    return paramHashMap;
  }
  
  public int getLayoutId()
  {
    return 2130969164;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(18807);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    g(j.bhb().kGr, j.bhb().kGs, j.bhb().kGt);
    AppMethodBeat.o(18807);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18804);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(714L, 10L, 1L, false);
    this.kIn = ((TextView)findViewById(2131822844));
    this.kIm = ((PieView)findViewById(2131822843));
    this.kIo = ((Button)findViewById(2131822865));
    this.kIp = ((Button)$(2131822866));
    this.kIl = findViewById(2131822845);
    this.kIq = ((TextView)findViewById(2131822849));
    this.kIq.setTextSize(1, 16.0F);
    this.kIr = ((TextView)$(2131822854));
    this.kIr.setTextSize(1, 16.0F);
    this.kIs = ((TextView)findViewById(2131822858));
    this.kIs.setTextSize(1, 16.0F);
    this.kIt = ((TextView)findViewById(2131822862));
    this.kIt.setTextSize(1, 16.0F);
    this.kIv = ((TextView)findViewById(2131822863));
    this.kIw = ((TextView)findViewById(2131822864));
    this.kIA = ((TextView)$(2131822868));
    this.kIB = ((LinearLayout)$(2131822867));
    this.kIx = ((TextView)$(2131822848));
    this.kIy = ((TextView)$(2131822853));
    this.kIz = ((TextView)$(2131822857));
    this.kIu = ((View)$(2131822850));
    setMMTitle(2131298387);
    setBackBtn(new CleanMsgUI.1(this));
    this.kIp.setOnClickListener(new CleanMsgUI.2(this));
    this.kIo.setEnabled(true);
    this.kIo.setOnClickListener(new CleanMsgUI.3(this));
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131298374), false, new CleanMsgUI.4(this));
    this.eeN.dismiss();
    g(j.bhb().kGr, j.bhb().kGs, j.bhb().kGt);
    AppMethodBeat.o(18804);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(18806);
    super.onDestroy();
    AppMethodBeat.o(18806);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.fileindexui.CleanMsgUI
 * JD-Core Version:    0.7.0.1
 */