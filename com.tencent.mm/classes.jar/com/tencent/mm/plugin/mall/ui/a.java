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
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.protocal.protobuf.bmw;
import com.tencent.mm.protocal.protobuf.fhp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import java.util.ArrayList;
import java.util.Iterator;

public final class a
{
  private static int DGD;
  public static final int EPg;
  public static final int EPh;
  public static final int EPi;
  private static int EPj;
  private static int EPk;
  private static int EPl;
  private static int EPm;
  private static int EPn;
  private static int EPo;
  private static int EPp;
  private static float EPq;
  
  static
  {
    AppMethodBeat.i(66032);
    EPg = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    EPh = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 140);
    EPi = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 85);
    EPj = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 39);
    EPk = 40;
    EPl = 95;
    EPm = 0;
    EPn = 0;
    EPo = 0;
    DGD = 70;
    EPp = 38;
    EPq = 1.0F;
    AppMethodBeat.o(66032);
  }
  
  public static void b(MMActivity paramMMActivity, boolean paramBoolean)
  {
    AppMethodBeat.i(66030);
    if (paramBoolean)
    {
      l(paramMMActivity);
      AppMethodBeat.o(66030);
      return;
    }
    l(paramMMActivity);
    Log.i("MicroMsg.FunctionGridSizeCalculator", "calcGridSize, GRID_HEIGHT_SIZE_PX: %s, TOP_FUNC_LINE_GRID_SIZE_PX: %s", new Object[] { Integer.valueOf(EPm), Integer.valueOf(EPo) });
    AppMethodBeat.o(66030);
  }
  
  public static int eQs()
  {
    return EPm;
  }
  
  public static int eQt()
  {
    return EPo;
  }
  
  public static int eQu()
  {
    return EPj;
  }
  
  public static int eQv()
  {
    return EPn;
  }
  
  public static float eQw()
  {
    return EPq;
  }
  
  public static void k(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(272273);
    Object localObject = new Rect();
    paramMMActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
    int i = ((Rect)localObject).right - ((Rect)localObject).left;
    int j = EPg;
    int k = j * 11;
    int m = (i - k * 4) / 5;
    Log.i("MicroMsg.FunctionGridSizeCalculator", "screenWidth，：%s , defaultGapWidth: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(k) });
    Log.i("MicroMsg.FunctionGridSizeCalculator", "baseA：%s , tempGridGapSize: %s", new Object[] { Integer.valueOf(j), Integer.valueOf(m) });
    if (m >= j)
    {
      EPj = m;
      EPn = k;
      paramMMActivity = b.gKI().iterator();
      i = 0;
      label135:
      while (paramMMActivity.hasNext())
      {
        localObject = (bmw)paramMMActivity.next();
        if (localObject != null)
        {
          TextPaint localTextPaint = new TextPaint(1);
          float f = com.tencent.mm.ci.a.ez(MMApplicationContext.getContext());
          EPq = f;
          if ((ar.ax(f, com.tencent.mm.ci.a.kg(MMApplicationContext.getContext()))) || (ar.ax(EPq, com.tencent.mm.ci.a.kh(MMApplicationContext.getContext())))) {
            EPq = com.tencent.mm.ci.a.kf(MMApplicationContext.getContext());
          }
          localTextPaint.setTextSize(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 14) * EPq);
          j = new StaticLayout(((bmw)localObject).SXF.CMP, localTextPaint, EPn, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 6), true).getHeight();
          if (Util.isNullOrNil(((bmw)localObject).SXL)) {
            break label514;
          }
          localTextPaint.setTextSize(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 10) * EPq);
          j = new StaticLayout(((bmw)localObject).SXL, localTextPaint, EPn, Layout.Alignment.ALIGN_NORMAL, 1.0F, com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 6), true).getHeight() + j + com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 1);
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
        EPj = j;
        EPn = (i - EPj * 5) / 4;
        break;
        Log.i("MicroMsg.FunctionGridSizeCalculator", "maxTextHeight: %s", new Object[] { Integer.valueOf(i) });
        j = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 12);
        i = j + (com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 32) + j + com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 10) + i);
        EPm = i;
        if (i < EPn)
        {
          Log.i("MicroMsg.FunctionGridSizeCalculator", "GRID_HEIGHT_SIZE_PX < GRID_Width_SIZE_PX,use GRID_Width_SIZE_PX: %s", new Object[] { Integer.valueOf(EPn) });
          EPm = EPn;
        }
        Log.i("MicroMsg.FunctionGridSizeCalculator", "GRID_GAP_SIZE_PX: %s，GRID_Width_SIZE_PX:%s,MAX_GRID_HEIGHT ：%s", new Object[] { Integer.valueOf(EPj), Integer.valueOf(EPn), Integer.valueOf(EPm) });
        AppMethodBeat.o(272273);
        return;
        j = i;
      }
    }
  }
  
  private static void l(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(66031);
    Point localPoint = ar.au(paramMMActivity);
    int n = localPoint.x;
    int k = localPoint.y;
    if (ar.av(paramMMActivity)) {}
    for (int j = k - ar.aB(paramMMActivity);; j = k)
    {
      if (paramMMActivity.getSupportActionBar() != null)
      {
        int m = paramMMActivity.getSupportActionBar().getHeight();
        i = m;
        if (m > 0) {}
      }
      for (int i = paramMMActivity.getResources().getDimensionPixelSize(a.d.DefaultActionbarHeightPort);; i = 0)
      {
        i = j - i - ar.getStatusBarHeight(paramMMActivity);
        if (k / n * 1.0D > 2.0D) {}
        for (i = (i - EPg * 3) / 20;; i = (i - EPg * 3) / 17)
        {
          EPo = Math.max(i * 4, EPh);
          EPj = (int)(i * 1.5D);
          EPm = Math.max(i * 3, EPi);
          Log.i("MicroMsg.FunctionGridSizeCalculator", "baseA: %s, top height: %s", new Object[] { Integer.valueOf(i), Integer.valueOf(EPo) });
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