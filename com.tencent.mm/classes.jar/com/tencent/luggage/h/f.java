package com.tencent.luggage.h;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f
{
  public static boolean aC(Context paramContext)
  {
    AppMethodBeat.i(140517);
    if (paramContext == null)
    {
      AppMethodBeat.o(140517);
      return false;
    }
    InputMethodManager localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
    if (localInputMethodManager == null)
    {
      AppMethodBeat.o(140517);
      return false;
    }
    if ((paramContext instanceof Activity)) {}
    for (paramContext = (Activity)paramContext; paramContext == null; paramContext = null)
    {
      AppMethodBeat.o(140517);
      return false;
    }
    paramContext = paramContext.getCurrentFocus();
    if (paramContext == null)
    {
      AppMethodBeat.o(140517);
      return false;
    }
    paramContext = paramContext.getWindowToken();
    if (paramContext == null)
    {
      AppMethodBeat.o(140517);
      return false;
    }
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow(paramContext, 0);
      AppMethodBeat.o(140517);
      return bool;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        boolean bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.h.f
 * JD-Core Version:    0.7.0.1
 */