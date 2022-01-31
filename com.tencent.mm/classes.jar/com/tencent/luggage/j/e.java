package com.tencent.luggage.j;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mm.ui.statusbar.d;

public final class e
{
  public static boolean af(Context paramContext)
  {
    if (paramContext == null) {}
    InputMethodManager localInputMethodManager;
    do
    {
      do
      {
        do
        {
          do
          {
            return false;
            localInputMethodManager = (InputMethodManager)paramContext.getSystemService("input_method");
          } while (localInputMethodManager == null);
          paramContext = d.cx(paramContext);
        } while (paramContext == null);
        paramContext = paramContext.getCurrentFocus();
      } while (paramContext == null);
      paramContext = paramContext.getWindowToken();
    } while (paramContext == null);
    try
    {
      bool = localInputMethodManager.hideSoftInputFromWindow(paramContext, 0);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.j.e
 * JD-Core Version:    0.7.0.1
 */