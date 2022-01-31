package com.tencent.kinda.framework.widget.tools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

public class MMKViewUtil
{
  private static final String TAG = "MMKViewUtil";
  private static float density = -1.0F;
  
  public static int argbColor(long paramLong)
  {
    AppMethodBeat.i(145211);
    int i = Color.argb((int)(paramLong >> 24 & 0xFF), (int)(paramLong >> 16 & 0xFF), (int)(paramLong >> 8 & 0xFF), (int)(0xFF & paramLong));
    AppMethodBeat.o(145211);
    return i;
  }
  
  public static float dpToPx(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(145209);
    if (paramContext == null)
    {
      ab.e("MMKViewUtil", "DpToPx method parameter is illegal! context is null! stack: \n" + Log.getStackTraceString(new Throwable()));
      AppMethodBeat.o(145209);
      return 2.0F * paramFloat;
    }
    paramFloat = BackwardSupportUtil.b.b(paramContext, paramFloat);
    AppMethodBeat.o(145209);
    return paramFloat;
  }
  
  public static float pxToDp(Context paramContext, float paramFloat)
  {
    AppMethodBeat.i(145210);
    if (paramContext == null)
    {
      ab.e("MMKViewUtil", "dpToPx method parameter is illegal! context is null! stack: \n" + Log.getStackTraceString(new Throwable()));
      paramFloat /= 2.0F;
      AppMethodBeat.o(145210);
      return paramFloat;
    }
    paramFloat = 160.0F * paramFloat / paramContext.getResources().getDisplayMetrics().densityDpi;
    AppMethodBeat.o(145210);
    return paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.MMKViewUtil
 * JD-Core Version:    0.7.0.1
 */