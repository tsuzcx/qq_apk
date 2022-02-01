package com.tencent.mapsdk.internal;

import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class js
{
  public static int a(String paramString1, String paramString2, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(224125);
    int j = i;
    int k;
    if (!gz.a(paramString1))
    {
      j = i;
      if (!gz.a(paramString2))
      {
        if (paramString1.equals(paramString2))
        {
          AppMethodBeat.o(224125);
          return 0;
        }
        String[] arrayOfString1 = paramString1.split("\\.");
        String[] arrayOfString2 = paramString2.split("\\.");
        k = 0;
        i = 0;
        if (k >= paramInt) {
          break label154;
        }
        if (k >= arrayOfString1.length) {
          break label132;
        }
        paramString1 = arrayOfString1[k];
        label83:
        if (k >= arrayOfString2.length) {
          break label138;
        }
        paramString2 = arrayOfString2[k];
      }
    }
    for (;;)
    {
      try
      {
        j = Integer.valueOf(Integer.parseInt(paramString1)).compareTo(Integer.valueOf(Integer.parseInt(paramString2)));
        i = j;
        if (j == 0) {
          continue;
        }
        AppMethodBeat.o(224125);
        return j;
      }
      catch (Exception paramString1)
      {
        label132:
        label138:
        k += 1;
      }
      paramString1 = "0";
      break label83;
      paramString2 = "0";
      continue;
      break;
      label154:
      j = i;
    }
  }
  
  private static void a(View paramView, float paramFloat)
  {
    AppMethodBeat.i(224056);
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setAlpha(paramFloat);
      AppMethodBeat.o(224056);
      return;
    }
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(0.0F, paramFloat);
    localAlphaAnimation.setDuration(0L);
    localAlphaAnimation.setFillAfter(true);
    paramView.startAnimation(localAlphaAnimation);
    AppMethodBeat.o(224056);
  }
  
  private static void a(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224066);
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramView.setScaleX(paramFloat1);
      paramView.setScaleY(paramFloat2);
      AppMethodBeat.o(224066);
      return;
    }
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, paramFloat1, 1.0F, paramFloat2);
    localScaleAnimation.setDuration(0L);
    localScaleAnimation.setFillAfter(true);
    paramView.startAnimation(localScaleAnimation);
    AppMethodBeat.o(224066);
  }
  
  private static void a(Object paramObject, String paramString, int paramInt, float... paramVarArgs)
  {
    AppMethodBeat.i(224081);
    if (Build.VERSION.SDK_INT >= 11)
    {
      paramObject = ObjectAnimator.ofFloat(paramObject, paramString, new float[] { paramVarArgs[0], paramVarArgs[1] });
      paramObject.setDuration(paramInt);
      paramObject.start();
      AppMethodBeat.o(224081);
      return;
    }
    if (("Alpha".equals(paramString)) && ((paramObject instanceof View)))
    {
      paramString = new AlphaAnimation(paramVarArgs[0], paramVarArgs[1]);
      paramString.setDuration(paramInt);
      paramString.setFillAfter(true);
      ((View)paramObject).startAnimation(paramString);
      AppMethodBeat.o(224081);
      return;
    }
    if (("Scale".equals(paramString)) && ((paramObject instanceof View)))
    {
      paramString = new ScaleAnimation(paramVarArgs[0], paramVarArgs[1], paramVarArgs[0], paramVarArgs[1]);
      paramString.setDuration(paramInt);
      paramString.setFillAfter(true);
      ((View)paramObject).startAnimation(paramString);
    }
    AppMethodBeat.o(224081);
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224099);
    if (a(paramString1, paramString2, 3) < 0)
    {
      AppMethodBeat.o(224099);
      return true;
    }
    AppMethodBeat.o(224099);
    return false;
  }
  
  private static boolean b(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(224089);
    if (a(paramString1, paramString2, paramInt) > 0)
    {
      AppMethodBeat.o(224089);
      return true;
    }
    AppMethodBeat.o(224089);
    return false;
  }
  
  private static boolean c(String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(224110);
    if (a(paramString1, paramString2, paramInt) == 0)
    {
      AppMethodBeat.o(224110);
      return true;
    }
    AppMethodBeat.o(224110);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mapsdk.internal.js
 * JD-Core Version:    0.7.0.1
 */