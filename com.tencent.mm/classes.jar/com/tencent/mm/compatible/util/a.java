package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  public static int bL(Context paramContext)
  {
    AppMethodBeat.i(93058);
    TypedValue localTypedValue = new TypedValue();
    int i;
    if (paramContext.getTheme().resolveAttribute(2130772143, localTypedValue, true))
    {
      i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
      AppMethodBeat.o(93058);
      return i;
    }
    if (paramContext.getTheme().resolveAttribute(16843499, localTypedValue, true))
    {
      i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
      AppMethodBeat.o(93058);
      return i;
    }
    AppMethodBeat.o(93058);
    return 0;
  }
  
  public static int p(Activity paramActivity)
  {
    AppMethodBeat.i(93057);
    if ((paramActivity instanceof AppCompatActivity))
    {
      if (((AppCompatActivity)paramActivity).getSupportActionBar() != null)
      {
        i = ((AppCompatActivity)paramActivity).getSupportActionBar().getHeight();
        AppMethodBeat.o(93057);
        return i;
      }
    }
    else if (paramActivity.getActionBar() != null)
    {
      i = paramActivity.getActionBar().getHeight();
      AppMethodBeat.o(93057);
      return i;
    }
    int i = bL(paramActivity);
    AppMethodBeat.o(93057);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.a
 * JD-Core Version:    0.7.0.1
 */