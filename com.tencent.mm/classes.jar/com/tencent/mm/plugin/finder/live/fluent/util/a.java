package com.tencent.mm.plugin.finder.live.fluent.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.plugin.finder.live.fluent.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bd;
import com.tencent.mm.ui.bf;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.k.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/fluent/util/FinderLiveFluentUtil;", "", "()V", "SCREEN_HEIGHT", "", "getSCREEN_HEIGHT", "()I", "SCREEN_WITDH", "getSCREEN_WITDH", "setSCREEN_WITDH", "(I)V", "TAG", "", "createFullWindowLayoutParams", "Landroid/view/WindowManager$LayoutParams;", "getFullScreenRect", "Landroid/graphics/Rect;", "params", "Lcom/tencent/mm/plugin/finder/live/fluent/FinderFluentSwitchParams;", "getLiveContentTop", "getLiveMarginTop", "videoWidth", "videoHeight", "getLocationOnScreen", "", "targetView", "Landroid/view/View;", "pos", "", "getScaleRate", "", "isLandscapeVideo", "", "isLinkMicVideo", "removeAndAddBack", "view", "safetyInvoke", "block", "Lkotlin/Function0;", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static int CCO;
  private static final int CCP;
  public static final a CDq;
  
  static
  {
    AppMethodBeat.i(352367);
    CDq = new a();
    CCO = bf.bf(MMApplicationContext.getContext()).x;
    CCP = bf.bf(MMApplicationContext.getContext()).y;
    AppMethodBeat.o(352367);
  }
  
  public static void a(View paramView, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(352286);
    s.u(paramView, "targetView");
    s.u(paramArrayOfInt, "pos");
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    if (arrayOfInt[1] < arrayOfInt[1])
    {
      Log.w("FinderLiveFluentUtil", "getLocationOnScreen use recyclerView Y:" + arrayOfInt[1] + " targetViewPos[" + arrayOfInt[0] + 'x' + arrayOfInt[1] + "] recyclerViewPos[" + arrayOfInt[0] + 'x' + arrayOfInt[1] + ']');
      paramArrayOfInt[1] = arrayOfInt[1];
    }
    for (;;)
    {
      paramArrayOfInt[0] = arrayOfInt[0];
      AppMethodBeat.o(352286);
      return;
      paramArrayOfInt[1] = arrayOfInt[1];
    }
  }
  
  public static void ba(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(352310);
    s.u(parama, "block");
    try
    {
      parama.invoke();
      AppMethodBeat.o(352310);
      return;
    }
    finally
    {
      Log.e("FinderLiveFluentUtil", "safeInvoke exception ", new Object[] { parama });
      AppMethodBeat.o(352310);
    }
  }
  
  public static Rect d(h paramh)
  {
    AppMethodBeat.i(352344);
    s.u(paramh, "params");
    int k = CCO;
    int i = CCP;
    float f = paramh.hKI;
    int m;
    int j;
    if (!f(paramh))
    {
      f = e(paramh);
      int n = (int)(paramh.videoWidth * f);
      m = (int)(f * paramh.videoHeight);
      j = (k - n) / 2;
      i = (i - m) / 2;
      k = n;
    }
    for (;;)
    {
      paramh = new Rect(j, i, k + j, m + i);
      AppMethodBeat.o(352344);
      return paramh;
      m = (int)(k / f);
      if (hE(k, m))
      {
        aw.jkS();
        i = bd.fromDPToPix(MMApplicationContext.getContext(), 120);
        j = 0;
      }
      else
      {
        i = (int)(CCO * (m / k));
        f = CCP;
        if (i <= f * 0.688F)
        {
          i = (int)(0.156F * CCP) + bf.getStatusBarHeight(MMApplicationContext.getContext());
          j = 0;
        }
        else
        {
          i = 0;
          j = 0;
        }
      }
    }
  }
  
  public static float e(h paramh)
  {
    AppMethodBeat.i(352351);
    s.u(paramh, "params");
    int i = CCO;
    float f = CCP / paramh.videoHeight;
    f = k.bt(i / paramh.videoWidth, f);
    AppMethodBeat.o(352351);
    return f;
  }
  
  public static WindowManager.LayoutParams ejY()
  {
    AppMethodBeat.i(352300);
    WindowManager.LayoutParams localLayoutParams = new WindowManager.LayoutParams();
    if (d.rb(26)) {}
    for (localLayoutParams.type = 2038;; localLayoutParams.type = 2002)
    {
      localLayoutParams.format = 1;
      localLayoutParams.packageName = MMApplicationContext.getContext().getPackageName();
      localLayoutParams.flags = 196904;
      localLayoutParams.gravity = 8388659;
      localLayoutParams.width = -1;
      localLayoutParams.height = -1;
      AppMethodBeat.o(352300);
      return localLayoutParams;
    }
  }
  
  public static int ejw()
  {
    return CCO;
  }
  
  public static int ejx()
  {
    return CCP;
  }
  
  public static boolean f(h paramh)
  {
    AppMethodBeat.i(352359);
    s.u(paramh, "params");
    if (paramh.hKI >= 1.0F)
    {
      AppMethodBeat.o(352359);
      return true;
    }
    AppMethodBeat.o(352359);
    return false;
  }
  
  public static void fQ(View paramView)
  {
    AppMethodBeat.i(352330);
    s.u(paramView, "view");
    Object localObject = paramView.getParent();
    if ((localObject instanceof ViewGroup)) {}
    for (localObject = (ViewGroup)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((ViewGroup)localObject).removeView(paramView);
      }
      if (localObject != null) {
        ((ViewGroup)localObject).addView(paramView);
      }
      AppMethodBeat.o(352330);
      return;
    }
  }
  
  private static boolean hE(int paramInt1, int paramInt2)
  {
    bool2 = false;
    AppMethodBeat.i(352320);
    Log.i("FinderLiveFluentUtil", "isLinkMicVideo videoWidth:" + paramInt1 + ",videoHeight:" + paramInt2);
    bool1 = bool2;
    if (paramInt1 > 0)
    {
      bool1 = bool2;
      if (paramInt2 <= 0) {}
    }
    for (;;)
    {
      try
      {
        float f = new BigDecimal(paramInt1 / paramInt2).setScale(1, 4).floatValue();
        if (f != 1.1F) {
          continue;
        }
        paramInt1 = 1;
        if (paramInt1 == 0)
        {
          if (f != 1.0F) {
            continue;
          }
          paramInt1 = 1;
          bool1 = bool2;
          if (paramInt1 == 0) {}
        }
        else
        {
          bool1 = true;
        }
      }
      catch (Exception localException)
      {
        Log.w("FinderLiveFluentUtil", s.X("ex:", localException.getMessage()));
        bool1 = bool2;
        continue;
      }
      AppMethodBeat.o(352320);
      return bool1;
      paramInt1 = 0;
      continue;
      paramInt1 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.fluent.util.a
 * JD-Core Version:    0.7.0.1
 */