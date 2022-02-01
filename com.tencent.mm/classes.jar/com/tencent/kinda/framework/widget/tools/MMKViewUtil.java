package com.tencent.kinda.framework.widget.tools;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;

public class MMKViewUtil
{
  private static final String TAG = "MMKViewUtil";
  private static float density = -1.0F;
  
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
  
  @SuppressLint({"ResourceType"})
  public static void setId4KindaImplView(Context paramContext, String paramString, View paramView)
  {
    AppMethodBeat.i(263912);
    int i = paramContext.getResources().getIdentifier(paramString, "id", paramContext.getPackageName());
    if (i > 0)
    {
      paramView.setId(i);
      com.tencent.mm.sdk.platformtools.Log.d("MMKViewUtil", "setViewId has set rid: ".concat(String.valueOf(paramString)));
      AppMethodBeat.o(263912);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.d("MMKViewUtil", "setViewId has not set rid: " + paramString + ", because no found res.");
    AppMethodBeat.o(263912);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.MMKViewUtil
 * JD-Core Version:    0.7.0.1
 */