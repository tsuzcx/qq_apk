package com.tencent.mm.plugin.mall.ui;

import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.mall.a.k;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.geb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  public static final int DWW;
  private static int Jyb;
  public static final int KJE;
  public static final int KJF;
  private static int KJG;
  private static int KJH;
  private static int KJI;
  private static int KJJ;
  private static int KJK;
  private static int KJL;
  private static int KJM;
  private static float KJN;
  
  static
  {
    AppMethodBeat.i(66032);
    DWW = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    KJE = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 140);
    KJF = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 85);
    KJG = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 39);
    KJH = 40;
    KJI = 95;
    KJJ = 0;
    KJK = 0;
    KJL = 0;
    Jyb = 70;
    KJM = 38;
    KJN = 1.0F;
    AppMethodBeat.o(66032);
  }
  
  public static void b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(66030);
    if (paramBoolean)
    {
      o(paramMMActivity);
      AppMethodBeat.o(66030);
      return;
    }
    o(paramMMActivity);
    Log.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[] { Integer.valueOf(KJJ), Integer.valueOf(KJL) });
    AppMethodBeat.o(66030);
  }
  
  public static int fZc()
  {
    return KJJ;
  }
  
  public static int fZd()
  {
    return KJL;
  }
  
  public static int fZe()
  {
    return KJG;
  }
  
  public static int fZf()
  {
    return KJK;
  }
  
  public static float fZg()
  {
    return KJN;
  }
  
  public static void n(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(262439);
    Object localObject = new Rect();
    paramMMActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).right - ((Rect)localObject).left;
    int j = DWW;
    int k = j * 11;
    int m = (i - k * 4) / 5;
    Log.i("MicroMsg.FunctionGridSizeCalculator", "screenWidth，：%s , defaultGapWidth: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
    Log.i("MicroMsg.FunctionGridSizeCalculator", "baseA：%s , tempGridGapSize: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m) });
    if (m >= j)
    {
      KJG = m;
      KJK = k;
      paramMMActivity = b.ika().iterator();
      i = 0;
      label135:
      while (paramMMActivity.hasNext())
      {
        localObject = (caq)paramMMActivity.next();
        if (localObject != null)
        {
          TextPaint localTextPaint = new TextPaint(1);
          float f = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
          KJN = f;
          if ((aw.bc(f, com.tencent.mm.cd.a.mi(MMApplicationContext.getContext()))) || (aw.bc(KJN, com.tencent.mm.cd.a.mj(MMApplicationContext.getContext())))) {
            KJN = com.tencent.mm.cd.a.mh(MMApplicationContext.getContext());
          }
          localTextPaint.setTextSize(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 14) * KJN);
          j = new StaticLayout(((caq)localObject).aajz.IGU, localTextPaint, KJK, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6), true).getHeight();
          if (Util.isNullOrNil(((caq)localObject).aajF)) {
            break label514;
          }
          localTextPaint.setTextSize(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 10) * KJN);
          j = new StaticLayout(((caq)localObject).aajF, localTextPaint, KJK, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 6), true).getHeight() + j + com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 1);
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
        KJG = j;
        KJK = (i - KJG * 5) / 4;
        break;
        Log.i("MicroMsg.FunctionGridSizeCalculator", "maxTextHeight: %s", new Object[] { Integer.valueOf(i) });
        j = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 12);
        i = j + (com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 32) + j + com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 10) + i);
        KJJ = i;
        if (i < KJK)
        {
          Log.i("MicroMsg.FunctionGridSizeCalculator", "GRID_HEIGHT_SIZE_PX < GRID_Width_SIZE_PX,use GRID_Width_SIZE_PX: %s", new Object[] { Integer.valueOf(KJK) });
          KJJ = KJK;
        }
        Log.i("MicroMsg.FunctionGridSizeCalculator", "GRID_GAP_SIZE_PX: %s，GRID_Width_SIZE_PX:%s,MAX_GRID_HEIGHT ：%s", new Object[] { Integer.valueOf(KJG), Integer.valueOf(KJK), Integer.valueOf(KJJ) });
        AppMethodBeat.o(262439);
        return;
        j = i;
      }
    }
  }
  
  private static void o(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(66031);
    Object localObject = aw.bf(paramMMActivity);
    int n = ((Point)localObject).x;
    int k = ((Point)localObject).y;
    if (aw.bg(paramMMActivity)) {}
    for (int j = k - aw.bk(paramMMActivity);; j = k)
    {
      if (paramMMActivity.getSupportActionBar() != null)
      {
        int m = paramMMActivity.getSupportActionBar().getHeight();
        i = m;
        if (m > 0) {}
      }
      for (int i = paramMMActivity.getResources().getDimensionPixelSize(a.d.DefaultActionbarHeightPort);; i = 0)
      {
        i = j - i - aw.getStatusBarHeight(paramMMActivity);
        if (k / n * 1.0D > 2.0D)
        {
          i = (i - DWW * 3) / 20;
          KJL = Math.max(i * 4, KJE);
          KJG = (int)(i * 1.5D);
          Log.i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(KJL) });
          KJK = (n - DWW * 2) / 3;
          h.baF();
          i = ((Integer)h.baE().ban().get(at.a.acNa, null)).intValue();
          paramMMActivity = k.fZb().aam(i).iterator();
          i = 0;
          label210:
          while (paramMMActivity.hasNext())
          {
            localObject = (MallFunction)paramMMActivity.next();
            if (localObject != null)
            {
              TextPaint localTextPaint = new TextPaint(1);
              float f = com.tencent.mm.cd.a.getScaleSize(MMApplicationContext.getContext());
              KJN = f;
              if ((aw.bc(f, com.tencent.mm.cd.a.mi(MMApplicationContext.getContext()))) || (aw.bc(KJN, com.tencent.mm.cd.a.mj(MMApplicationContext.getContext())))) {
                KJN = com.tencent.mm.cd.a.mh(MMApplicationContext.getContext());
              }
              localTextPaint.setTextSize(com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 14) * KJN);
              j = KJK;
              k = com.tencent.mm.cd.a.br(MMApplicationContext.getContext(), a.d.Edge_2A);
              j = new StaticLayout(((MallFunction)localObject).idA, localTextPaint, j - k, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 0), true).getHeight();
              if (i >= j) {
                break label521;
              }
              i = j;
            }
          }
        }
        label521:
        for (;;)
        {
          break label210;
          i = (i - DWW * 3) / 17;
          break;
          Log.i("MicroMsg.FunctionGridSizeCalculator", "maxTextHeight: %s", new Object[] { Integer.valueOf(i) });
          i = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 24) + com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 35) + com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 5) + i + com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 12);
          KJJ = i;
          if (i < KJK)
          {
            Log.i("MicroMsg.FunctionGridSizeCalculator", "GRID_HEIGHT_SIZE_PX < GRID_Width_SIZE_PX,use GRID_Width_SIZE_PX: %s", new Object[] { Integer.valueOf(KJK) });
            KJJ = KJK;
          }
          Log.i("MicroMsg.FunctionGridSizeCalculator", "GRID_GAP_SIZE_PX: %s，GRID_Width_SIZE_PX:%s,MAX_GRID_HEIGHT ：%s", new Object[] { Integer.valueOf(KJG), Integer.valueOf(KJK), Integer.valueOf(KJJ) });
          AppMethodBeat.o(66031);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.a
 * JD-Core Version:    0.7.0.1
 */