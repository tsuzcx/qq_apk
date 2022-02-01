package com.tencent.mm.plugin.mall.ui;

import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.support.v7.app.ActionBar;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.exc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  public static final int zjP;
  public static final int zjQ;
  public static final int zjR;
  private static int zjS;
  private static int zjT;
  private static int zjU;
  private static int zjV;
  private static int zjW;
  private static int zjX;
  private static int zjY;
  private static int zjZ;
  private static float zka;
  
  static
  {
    AppMethodBeat.i(66032);
    zjP = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    zjQ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 140);
    zjR = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 85);
    zjS = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 39);
    zjT = 40;
    zjU = 95;
    zjV = 0;
    zjW = 0;
    zjX = 0;
    zjY = 70;
    zjZ = 38;
    zka = 1.0F;
    AppMethodBeat.o(66032);
  }
  
  public static void b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(66030);
    if (paramBoolean)
    {
      k(paramMMActivity);
      AppMethodBeat.o(66030);
      return;
    }
    k(paramMMActivity);
    Log.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[] { Integer.valueOf(zjV), Integer.valueOf(zjX) });
    AppMethodBeat.o(66030);
  }
  
  public static int egM()
  {
    return zjV;
  }
  
  public static int egN()
  {
    return zjX;
  }
  
  public static int egO()
  {
    return zjS;
  }
  
  public static int egP()
  {
    return zjW;
  }
  
  public static float egQ()
  {
    return zka;
  }
  
  public static void j(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(213543);
    Object localObject = new Rect();
    paramMMActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).right - ((Rect)localObject).left;
    int j = zjP;
    int k = j * 11;
    int m = (i - k * 4) / 5;
    Log.i("MicroMsg.FunctionGridSizeCalculator", "screenWidth，：%s , defaultGapWidth: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
    Log.i("MicroMsg.FunctionGridSizeCalculator", "baseA：%s , tempGridGapSize: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m) });
    if (m >= j)
    {
      zjS = m;
      zjW = k;
      paramMMActivity = b.fSd().iterator();
      i = 0;
      label135:
      while (paramMMActivity.hasNext())
      {
        localObject = (bfv)paramMMActivity.next();
        if (localObject != null)
        {
          TextPaint localTextPaint = new TextPaint(1);
          float f = com.tencent.mm.cb.a.ez(MMApplicationContext.getContext());
          zka = f;
          if ((ao.as(f, com.tencent.mm.cb.a.jc(MMApplicationContext.getContext()))) || (ao.as(zka, com.tencent.mm.cb.a.jd(MMApplicationContext.getContext())))) {
            zka = com.tencent.mm.cb.a.jb(MMApplicationContext.getContext());
          }
          localTextPaint.setTextSize(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 14) * zka);
          j = new StaticLayout(((bfv)localObject).LPr.Name, localTextPaint, zjW, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6), true).getHeight();
          if (Util.isNullOrNil(((bfv)localObject).LPx)) {
            break label514;
          }
          localTextPaint.setTextSize(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 10) * zka);
          j = new StaticLayout(((bfv)localObject).LPx, localTextPaint, zjW, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 6), true).getHeight() + j + com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 1);
        }
      }
    }
    label514:
    for (;;)
    {
      if (i < j) {}
      for (;;)
      {
        i = j;
        break label135;
        zjS = j;
        zjW = (i - zjS * 5) / 4;
        break;
        Log.i("MicroMsg.FunctionGridSizeCalculator", "maxTextHeight: %s", new Object[] { Integer.valueOf(i) });
        j = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 12);
        i = j + (com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32) + j + com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 10) + i);
        zjV = i;
        if (i < zjW)
        {
          Log.i("MicroMsg.FunctionGridSizeCalculator", "GRID_HEIGHT_SIZE_PX < GRID_Width_SIZE_PX,use GRID_Width_SIZE_PX: %s", new Object[] { Integer.valueOf(zjW) });
          zjV = zjW;
        }
        Log.i("MicroMsg.FunctionGridSizeCalculator", "GRID_GAP_SIZE_PX: %s，GRID_Width_SIZE_PX:%s,MAX_GRID_HEIGHT ：%s", new Object[] { Integer.valueOf(zjS), Integer.valueOf(zjW), Integer.valueOf(zjV) });
        AppMethodBeat.o(213543);
        return;
        j = i;
      }
    }
  }
  
  private static void k(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(66031);
    Point localPoint = ao.az(paramMMActivity);
    int n = localPoint.x;
    int k = localPoint.y;
    if (ao.aA(paramMMActivity)) {}
    for (int j = k - ao.aD(paramMMActivity);; j = k)
    {
      if (paramMMActivity.getSupportActionBar() != null)
      {
        int m = paramMMActivity.getSupportActionBar().getHeight();
        i = m;
        if (m > 0) {}
      }
      for (int i = paramMMActivity.getResources().getDimensionPixelSize(2131165256);; i = 0)
      {
        i = j - i - ao.getStatusBarHeight(paramMMActivity);
        if (k / n * 1.0D > 2.0D) {}
        for (i = (i - zjP * 3) / 20;; i = (i - zjP * 3) / 17)
        {
          zjX = Math.max(i * 4, zjQ);
          zjS = (int)(i * 1.5D);
          zjV = Math.max(i * 3, zjR);
          Log.i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(zjX) });
          AppMethodBeat.o(66031);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.a
 * JD-Core Version:    0.7.0.1
 */