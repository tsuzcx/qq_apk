package com.tencent.mm.plugin.mall.ui;

import android.content.res.Resources;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.protocal.protobuf.atw;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  public static final int vDH;
  public static final int vDI;
  public static final int vDJ;
  private static int vDK;
  private static int vDL;
  private static int vDM;
  private static int vDN;
  private static int vDO;
  private static int vDP;
  private static int vDQ;
  private static int vDR;
  private static float vDS;
  
  static
  {
    AppMethodBeat.i(66032);
    vDH = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 8);
    vDI = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 140);
    vDJ = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 85);
    vDK = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 39);
    vDL = 40;
    vDM = 95;
    vDN = 0;
    vDO = 0;
    vDP = 0;
    vDQ = 70;
    vDR = 38;
    vDS = 1.0F;
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
    ad.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[] { Integer.valueOf(vDN), Integer.valueOf(vDP) });
    AppMethodBeat.o(66030);
  }
  
  public static int dkb()
  {
    return vDN;
  }
  
  public static int dkc()
  {
    return vDP;
  }
  
  public static int dkd()
  {
    return vDK;
  }
  
  public static int dke()
  {
    return vDO;
  }
  
  public static float dkf()
  {
    return vDS;
  }
  
  public static void j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(199031);
    int i = al.ci(paramMMActivity).x;
    int j = vDH;
    int k = j * 11;
    int m = (i - k * 4) / 5;
    ad.i("MicroMsg.FunctionGridSizeCalculator", "screenWidth，：%s , defaultGapWidth: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
    ad.i("MicroMsg.FunctionGridSizeCalculator", "baseA：%s , tempGridGapSize: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m) });
    if (m >= j)
    {
      vDK = m;
      vDO = k;
      paramMMActivity = b.eGQ().iterator();
      i = 0;
      label110:
      while (paramMMActivity.hasNext())
      {
        atw localatw = (atw)paramMMActivity.next();
        if (localatw != null)
        {
          TextPaint localTextPaint = new TextPaint(1);
          float f = com.tencent.mm.cc.a.eb(aj.getContext());
          vDS = f;
          if ((al.al(f, com.tencent.mm.cc.a.ie(aj.getContext()))) || (al.al(vDS, com.tencent.mm.cc.a.jdMethod_if(aj.getContext())))) {
            vDS = com.tencent.mm.cc.a.id(aj.getContext());
          }
          localTextPaint.setTextSize(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 14) * vDS);
          j = new StaticLayout(localatw.GrP.Name, localTextPaint, vDO, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 6), true).getHeight();
          if (bt.isNullOrNil(localatw.GrV)) {
            break label489;
          }
          localTextPaint.setTextSize(com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 10) * vDS);
          j = new StaticLayout(localatw.GrV, localTextPaint, vDO, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 6), true).getHeight() + j + com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 1);
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
        vDK = j;
        vDO = (i - vDK * 5) / 4;
        break;
        ad.i("MicroMsg.FunctionGridSizeCalculator", "maxTextHeight: %s", new Object[] { Integer.valueOf(i) });
        j = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 12);
        i = j + (com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 32) + j + com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 10) + i);
        vDN = i;
        if (i < vDO)
        {
          ad.i("MicroMsg.FunctionGridSizeCalculator", "GRID_HEIGHT_SIZE_PX < GRID_Width_SIZE_PX,use GRID_Width_SIZE_PX: %s", new Object[] { Integer.valueOf(vDO) });
          vDN = vDO;
        }
        ad.i("MicroMsg.FunctionGridSizeCalculator", "GRID_GAP_SIZE_PX: %s，GRID_Width_SIZE_PX:%s,MAX_GRID_HEIGHT ：%s", new Object[] { Integer.valueOf(vDK), Integer.valueOf(vDO), Integer.valueOf(vDN) });
        AppMethodBeat.o(199031);
        return;
        j = i;
      }
    }
  }
  
  private static void k(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(66031);
    Point localPoint = al.ci(paramMMActivity);
    int n = localPoint.x;
    int k = localPoint.y;
    if (al.jR(paramMMActivity)) {}
    for (int j = k - al.ej(paramMMActivity);; j = k)
    {
      if (paramMMActivity.getSupportActionBar() != null)
      {
        int m = paramMMActivity.getSupportActionBar().getHeight();
        i = m;
        if (m > 0) {}
      }
      for (int i = paramMMActivity.getResources().getDimensionPixelSize(2131165252);; i = 0)
      {
        i = j - i - al.jG(paramMMActivity);
        if (k / n * 1.0D > 2.0D) {}
        for (i = (i - vDH * 3) / 20;; i = (i - vDH * 3) / 17)
        {
          vDP = Math.max(i * 4, vDI);
          vDK = (int)(i * 1.5D);
          vDN = Math.max(i * 3, vDJ);
          ad.i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(vDP) });
          AppMethodBeat.o(66031);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.a
 * JD-Core Version:    0.7.0.1
 */