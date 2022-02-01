package com.google.android.gms.common.util;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class InputMethodUtils
{
  public static boolean hideSoftInput(Context paramContext, View paramView)
  {
    AppMethodBeat.i(5261);
    paramContext = zzf(paramContext);
    if (paramContext != null)
    {
      paramContext.hideSoftInputFromWindow(paramView.getWindowToken(), 0);
      AppMethodBeat.o(5261);
      return true;
    }
    AppMethodBeat.o(5261);
    return false;
  }
  
  public static boolean isAcceptingText(Context paramContext)
  {
    AppMethodBeat.i(5263);
    paramContext = zzf(paramContext);
    if (paramContext != null)
    {
      boolean bool = paramContext.isAcceptingText();
      AppMethodBeat.o(5263);
      return bool;
    }
    AppMethodBeat.o(5263);
    return false;
  }
  
  public static void restart(Context paramContext, View paramView)
  {
    AppMethodBeat.i(5262);
    paramContext = zzf(paramContext);
    if (paramContext != null) {
      paramContext.restartInput(paramView);
    }
    AppMethodBeat.o(5262);
  }
  
  public static boolean showSoftInput(Context paramContext, View paramView)
  {
    AppMethodBeat.i(5260);
    paramContext = zzf(paramContext);
    if (paramContext != null)
    {
      paramContext.showSoftInput(paramView, 0);
      AppMethodBeat.o(5260);
      return true;
    }
    AppMethodBeat.o(5260);
    return false;
  }
  
  private static InputMethodManager zzf(Context paramContext)
  {
    AppMethodBeat.i(5259);
    paramContext = (InputMethodManager)paramContext.getSystemService("input_method");
    AppMethodBeat.o(5259);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.util.InputMethodUtils
 * JD-Core Version:    0.7.0.1
 */