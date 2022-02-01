package com.tencent.kinda.framework.widget.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;

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
      ad.e("MMKViewUtil", "DpToPx method parameter is illegal! context is null! stack: \n" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(19389);
      return 2.0F * paramFloat;
    }
    paramFloat = BackwardSupportUtil.b.g(paramContext, paramFloat);
    AppMethodBeat.o(19389);
    return paramFloat;
  }
  
  public static float pxToDp(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(19390);
    if (paramContext == null)
    {
      ad.e("MMKViewUtil", "dpToPx method parameter is illegal! context is null! stack: \n" + Log.getStackTraceString(new Throwable()));
      paramFloat /= 2.0F;
      AppMethodBeat.o(19390);
      return paramFloat;
    }
    paramFloat = 160.0F * paramFloat / paramContext.getResources().getDisplayMetrics().densityDpi;
    AppMethodBeat.o(19390);
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.MMKViewUtil
 * JD-Core Version:    0.7.0.1
 */