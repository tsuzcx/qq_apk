package com.tencent.kinda.framework.widget.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.aw;

public class MMKViewUtil
{
  private static final String TAG = "MMKViewUtil";
  private static float density = -1.0F;
  public static float[] fontLevel = { 0.8F, 1.0F, 1.1F, 1.12F, 1.125F, 1.4F };
  
  public static int argbColor(long paramLong)
  {
    AppMethodBeat.i(19391);
    int i = Color.argb((int)(paramLong >> 24 & 0xFF), (int)(paramLong >> 16 & 0xFF), (int)(paramLong >> 8 & 0xFF), (int)(0xFF & paramLong));
    AppMethodBeat.o(19391);
    return i;
  }
  
  public static float dpToPx(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(19389);
    if (paramContext == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MMKViewUtil", "DpToPx method parameter is illegal! context is null! stack: \n" + android.util.Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(19389);
      return 2.0F * paramFloat;
    }
    paramFloat = BackwardSupportUtil.BitmapFactory.fromDPToPix(paramContext, paramFloat);
    AppMethodBeat.o(19389);
    return paramFloat;
  }
  
  public static float getScaleSize(Context paramContext)
  {
    AppMethodBeat.i(226466);
    if (((c)h.ax(c.class)).a(c.a.yWZ, 0) == 1) {}
    for (int i = 1; i != 0; i = 0)
    {
      float f2 = a.getScaleSize(paramContext);
      float f1 = f2;
      if (paramContext.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0).getBoolean("screenResolution_isModifyDensity", true)) {
        if (!aw.bc(f2, 1.1F))
        {
          f1 = f2;
          if (!aw.bc(f2, 0.8F)) {}
        }
        else
        {
          f1 = 1.0F;
        }
      }
      if (!aw.bc(f1, a.mi(paramContext)))
      {
        f2 = f1;
        if (!aw.bc(f1, a.mj(paramContext))) {}
      }
      else
      {
        f2 = a.mh(paramContext);
      }
      AppMethodBeat.o(226466);
      return f2;
    }
    AppMethodBeat.o(226466);
    return 1.0F;
  }
  
  public static float pxToDp(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(19390);
    if (paramContext == null)
    {
      com.tencent.mm.sdk.platformtools.Log.e("MMKViewUtil", "dpToPx method parameter is illegal! context is null! stack: \n" + android.util.Log.getStackTraceString(new Throwable()));
      paramFloat /= 2.0F;
      AppMethodBeat.o(19390);
      return paramFloat;
    }
    paramFloat = 160.0F * paramFloat / paramContext.getResources().getDisplayMetrics().densityDpi;
    AppMethodBeat.o(19390);
    return paramFloat;
  }
  
  public static void setExpandSize(View paramView, float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(226469);
    paramView.post(new MMKViewUtil.1(paramView, paramFloat1, paramFloat2));
    AppMethodBeat.o(226469);
  }
  
  public static void setId4KindaImplView(Context paramContext, String paramString, View paramView)
  {
    AppMethodBeat.i(226462);
    int i = paramContext.getResources().getIdentifier(paramString, "id", paramContext.getPackageName());
    if (i > 0)
    {
      paramView.setId(i);
      com.tencent.mm.sdk.platformtools.Log.d("MMKViewUtil", "setViewId has set rid: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(226462);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.d("MMKViewUtil", "setViewId has not set rid: " + paramString + ", because no found res.");
    AppMethodBeat.o(226462);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.MMKViewUtil
 * JD-Core Version:    0.7.0.1
 */