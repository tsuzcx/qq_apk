package com.tencent.mm.plugin.mall.ui;

import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.protocal.protobuf.aum;
import com.tencent.mm.protocal.protobuf.ecu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  public static final int vPL;
  public static final int vPM;
  public static final int vPN;
  private static int vPO;
  private static int vPP;
  private static int vPQ;
  private static int vPR;
  private static int vPS;
  private static int vPT;
  private static int vPU;
  private static int vPV;
  private static float vPW;
  
  static
  {
    AppMethodBeat.i(66032);
    vPL = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
    vPM = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 140);
    vPN = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 85);
    vPO = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 39);
    vPP = 40;
    vPQ = 95;
    vPR = 0;
    vPS = 0;
    vPT = 0;
    vPU = 70;
    vPV = 38;
    vPW = 1.0F;
    AppMethodBeat.o(66032);
  }
  
  public static void c(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(66030);
    if (paramBoolean)
    {
      k(paramMMActivity);
      AppMethodBeat.o(66030);
      return;
    }
    k(paramMMActivity);
    ae.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[] { Integer.valueOf(vPR), Integer.valueOf(vPT) });
    AppMethodBeat.o(66030);
  }
  
  public static int dna()
  {
    return vPR;
  }
  
  public static int dnb()
  {
    return vPT;
  }
  
  public static int dnc()
  {
    return vPO;
  }
  
  public static int dnd()
  {
    return vPS;
  }
  
  public static float dne()
  {
    return vPW;
  }
  
  public static void j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(189866);
    int i = al.ck(paramMMActivity).x;
    int j = vPL;
    int k = j * 11;
    int m = (i - k * 4) / 5;
    ae.i("MicroMsg.FunctionGridSizeCalculator", "screenWidth，：%s , defaultGapWidth: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
    ae.i("MicroMsg.FunctionGridSizeCalculator", "baseA：%s , tempGridGapSize: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m) });
    if (m >= j)
    {
      vPO = m;
      vPS = k;
      paramMMActivity = b.eKy().iterator();
      i = 0;
      label110:
      while (paramMMActivity.hasNext())
      {
        aum localaum = (aum)paramMMActivity.next();
        if (localaum != null)
        {
          TextPaint localTextPaint = new TextPaint(1);
          float f = com.tencent.mm.cb.a.ef(ak.getContext());
          vPW = f;
          if ((al.al(f, com.tencent.mm.cb.a.ij(ak.getContext()))) || (al.al(vPW, com.tencent.mm.cb.a.ik(ak.getContext())))) {
            vPW = com.tencent.mm.cb.a.ii(ak.getContext());
          }
          localTextPaint.setTextSize(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 14) * vPW);
          j = new StaticLayout(localaum.GLn.Name, localTextPaint, vPS, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 6), true).getHeight();
          if (bu.isNullOrNil(localaum.GLt)) {
            break label489;
          }
          localTextPaint.setTextSize(com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 10) * vPW);
          j = new StaticLayout(localaum.GLt, localTextPaint, vPS, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 6), true).getHeight() + j + com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 1);
        }
      }
    }
    label489:
    for (;;)
    {
      if (i < j) {}
      for (;;)
      {
        i = j;
        break label110;
        vPO = j;
        vPS = (i - vPO * 5) / 4;
        break;
        ae.i("MicroMsg.FunctionGridSizeCalculator", "maxTextHeight: %s", new Object[] { Integer.valueOf(i) });
        j = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 12);
        i = j + (com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 32) + j + com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 10) + i);
        vPR = i;
        if (i < vPS)
        {
          ae.i("MicroMsg.FunctionGridSizeCalculator", "GRID_HEIGHT_SIZE_PX < GRID_Width_SIZE_PX,use GRID_Width_SIZE_PX: %s", new Object[] { Integer.valueOf(vPS) });
          vPR = vPS;
        }
        ae.i("MicroMsg.FunctionGridSizeCalculator", "GRID_GAP_SIZE_PX: %s，GRID_Width_SIZE_PX:%s,MAX_GRID_HEIGHT ：%s", new Object[] { Integer.valueOf(vPO), Integer.valueOf(vPS), Integer.valueOf(vPR) });
        AppMethodBeat.o(189866);
        return;
        j = i;
      }
    }
  }
  
  private static void k(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(66031);
    Point localPoint = al.ck(paramMMActivity);
    int n = localPoint.x;
    int k = localPoint.y;
    if (al.jY(paramMMActivity)) {}
    for (int j = k - al.en(paramMMActivity);; j = k)
    {
      if (paramMMActivity.getSupportActionBar() != null)
      {
        int m = paramMMActivity.getSupportActionBar().getHeight();
        i = m;
        if (m > 0) {}
      }
      for (int i = paramMMActivity.getResources().getDimensionPixelSize(2131165252);; i = 0)
      {
        i = j - i - al.jN(paramMMActivity);
        if (k / n * 1.0D > 2.0D) {}
        for (i = (i - vPL * 3) / 20;; i = (i - vPL * 3) / 17)
        {
          vPT = Math.max(i * 4, vPM);
          vPO = (int)(i * 1.5D);
          vPR = Math.max(i * 3, vPN);
          ae.i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(vPT) });
          AppMethodBeat.o(66031);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.a
 * JD-Core Version:    0.7.0.1
 */