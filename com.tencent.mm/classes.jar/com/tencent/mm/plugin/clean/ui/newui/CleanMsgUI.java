package com.tencent.mm.plugin.clean.ui.newui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.clean.c.c;
import com.tencent.mm.plugin.clean.c.g;
import com.tencent.mm.plugin.clean.ui.PieView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
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
  private ProgressDialog eeN;
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
  private com.tencent.mm.plugin.clean.c.e kJh;
  private c kJn;
  
  private void g(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(18898);
    int j = (int)(360L * paramLong2 / paramLong1);
    if (j < 5) {
      j = 5;
    }
    for (;;)
    {
      int i = 0;
      if (paramLong3 > 0L)
      {
        int k = (int)(360L * paramLong3 / paramLong1);
        i = k;
        if (k < 5) {
          i = 5;
        }
      }
      long l = paramLong1 - paramLong2 - paramLong3;
      ab.i("MicroMsg.CleanMsgUI", "update [%d %d] [%d %d] [%d %d] wechatSize[%d]", new Object[] { Long.valueOf(paramLong2), Integer.valueOf(j), Long.valueOf(paramLong3), Integer.valueOf(i), Long.valueOf(l), Integer.valueOf((int)(360L * l / paramLong1)), Long.valueOf(paramLong1) });
      this.kIm.setGreenTargetAngle(j);
      this.kIm.setOtherAccTargetAngle(i);
      this.kIm.setStage(1);
      this.kIl.setVisibility(0);
      this.kIq.setText(bo.hk(paramLong2));
      this.kIr.setText(bo.hk(paramLong3));
      this.kIs.setText(bo.hk(l));
      if (paramLong3 > 0L)
      {
        this.kIu.setVisibility(0);
        this.kIp.setVisibility(0);
      }
      for (;;)
      {
        i = (int)(100L * paramLong2 / paramLong1);
        this.kIx.setText(getString(2131298367, new Object[] { i + "%" }));
        i = (int)(100L * paramLong3 / paramLong1);
        this.kIy.setText(getString(2131298390, new Object[] { i + "%" }));
        i = (int)(100L * l / paramLong1);
        this.kIz.setText(getString(2131298393, new Object[] { i + "%" }));
        AppMethodBeat.o(18898);
        return;
        this.kIp.setVisibility(8);
        this.kIu.setVisibility(8);
      }
    }
  }
  
  private void h(long paramLong1, long paramLong2, long paramLong3)
  {
    AppMethodBeat.i(18899);
    g(paramLong1, paramLong3, paramLong2);
    AppMethodBeat.o(18899);
  }
  
  public final void a(long paramLong1, long paramLong2, long paramLong3, ArrayList<com.tencent.mm.plugin.clean.c.b> paramArrayList, long paramLong4, HashSet<String> paramHashSet)
  {
    AppMethodBeat.i(18903);
    ab.i("MicroMsg.CleanMsgUI", "%d on clean result cleanDataSize[%d] wechatSize[%d] otherAccSize[%d]", new Object[] { Integer.valueOf(hashCode()), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Long.valueOf(paramLong4) });
    this.kIn.setVisibility(8);
    this.kIo.setEnabled(true);
    enableOptionMenu(0, true);
    h(paramLong2, paramLong4, paramLong3);
    if (paramLong1 > 0L)
    {
      this.kIv.setVisibility(0);
      this.kIv.setText(getString(2131298376, new Object[] { bo.hk(paramLong1) }));
    }
    for (;;)
    {
      com.tencent.mm.plugin.clean.c.d.it(paramLong1);
      com.tencent.mm.plugin.clean.c.d.iq(paramLong2);
      com.tencent.mm.plugin.clean.c.d.is(paramLong4);
      com.tencent.mm.plugin.clean.c.d.b(paramHashSet);
      com.tencent.mm.plugin.clean.c.d.ir(paramLong3);
      com.tencent.mm.plugin.clean.c.d.u(paramArrayList);
      if (paramLong4 <= 0L) {
        break;
      }
      com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(282L, 9L, 1L, false);
      AppMethodBeat.o(18903);
      return;
      this.kIv.setVisibility(8);
      this.kIv.setText("");
    }
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(282L, 10L, 1L, false);
    AppMethodBeat.o(18903);
  }
  
  public final void dX(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18902);
    this.kIn.setText(getString(2131296534, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
    AppMethodBeat.o(18902);
  }
  
  public final void dY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18904);
    this.eeN.setMessage(getString(2131298394, new Object[] { paramInt1 * 100 / paramInt2 + "%" }));
    AppMethodBeat.o(18904);
  }
  
  public int getLayoutId()
  {
    return 2130969164;
  }
  
  public final void iv(long paramLong)
  {
    AppMethodBeat.i(18905);
    this.eeN.dismiss();
    com.tencent.mm.plugin.clean.c.d.iq(com.tencent.mm.plugin.clean.c.d.bgR() - paramLong);
    com.tencent.mm.plugin.clean.c.d.it(com.tencent.mm.plugin.clean.c.d.bgU() + paramLong);
    com.tencent.mm.plugin.clean.c.d.bgU();
    h(com.tencent.mm.plugin.clean.c.d.bgR(), com.tencent.mm.plugin.clean.c.d.bgT(), com.tencent.mm.plugin.clean.c.d.bgS());
    AppMethodBeat.o(18905);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(18901);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    com.tencent.mm.plugin.clean.c.d.bgU();
    h(com.tencent.mm.plugin.clean.c.d.bgR(), com.tencent.mm.plugin.clean.c.d.bgT(), com.tencent.mm.plugin.clean.c.d.bgS());
    AppMethodBeat.o(18901);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18897);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.qsU.idkeyStat(282L, 3L, 1L, false);
    com.tencent.mm.plugin.clean.c.d.bgX();
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
    this.kIx = ((TextView)$(2131822848));
    this.kIy = ((TextView)$(2131822853));
    this.kIz = ((TextView)$(2131822857));
    this.kIu = ((View)$(2131822850));
    setMMTitle(2131298402);
    com.tencent.mm.plugin.clean.c.d.a(new com.tencent.mm.plugin.clean.c.a.b());
    setBackBtn(new CleanMsgUI.1(this));
    this.kIp.setOnClickListener(new CleanMsgUI.2(this));
    this.kIo.setOnClickListener(new CleanMsgUI.3(this));
    addIconOptionMenu(0, 2131230740, new CleanMsgUI.4(this));
    enableOptionMenu(0, false);
    getString(2131297087);
    this.eeN = com.tencent.mm.ui.base.h.b(this, getString(2131298374), false, new CleanMsgUI.5(this));
    this.eeN.dismiss();
    if (com.tencent.mm.plugin.clean.c.d.bgQ() != null)
    {
      this.kIn.setVisibility(8);
      this.kIo.setEnabled(true);
      enableOptionMenu(0, true);
      com.tencent.mm.plugin.clean.c.d.bgU();
      h(com.tencent.mm.plugin.clean.c.d.bgR(), com.tencent.mm.plugin.clean.c.d.bgT(), com.tencent.mm.plugin.clean.c.d.bgS());
      AppMethodBeat.o(18897);
      return;
    }
    paramBundle = com.tencent.mm.plugin.clean.c.d.bgO();
    if (paramBundle != null)
    {
      this.kJn = new c(paramBundle, this);
      com.tencent.mm.sdk.g.d.post(this.kJn, "CleanUI_clean");
      this.kIn.setText(getString(2131296534, new Object[] { "0%" }));
    }
    AppMethodBeat.o(18897);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(18900);
    Object localObject;
    if (this.kJn != null)
    {
      localObject = this.kJn;
      ab.i("MicroMsg.CleanController", "stop CleanController [%d]", new Object[] { Integer.valueOf(localObject.hashCode()) });
      ((c)localObject).isStop = true;
      com.tencent.mm.sdk.g.d.ysm.remove((Runnable)localObject);
    }
    if (this.kJh != null) {
      this.kJh.bgZ();
    }
    if (com.tencent.mm.plugin.clean.c.d.bgO() != null)
    {
      localObject = com.tencent.mm.plugin.clean.c.d.bgO();
      Iterator localIterator = ((com.tencent.mm.plugin.clean.c.a.b)localObject).kHi.values().iterator();
      while (localIterator.hasNext()) {
        ((ak)localIterator.next()).removeCallbacksAndMessages(null);
      }
      localIterator = ((com.tencent.mm.plugin.clean.c.a.b)localObject).kHi.values().iterator();
      while (localIterator.hasNext())
      {
        ak localak = (ak)localIterator.next();
        localak.getLooper().getThread().interrupt();
        localak.getLooper().quit();
      }
      ab.i("MicroMsg.ThreadController", "finish thread controller [%d]", new Object[] { Integer.valueOf(localObject.hashCode()) });
    }
    com.tencent.mm.plugin.clean.c.d.bgY();
    com.tencent.mm.plugin.clean.c.d.bgW();
    super.onDestroy();
    AppMethodBeat.o(18900);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanMsgUI
 * JD-Core Version:    0.7.0.1
 */