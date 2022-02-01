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
  public static int cb(Context paramContext)
  {
    AppMethodBeat.i(155863);
    TypedValue localTypedValue = new TypedValue();
    int i;
    if (paramContext.getTheme().resolveAttribute(2130968600, localTypedValue, true))
    {
      i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
      AppMethodBeat.o(155863);
      return i;
    }
    if (paramContext.getTheme().resolveAttribute(16843499, localTypedValue, true))
    {
      i = TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
      AppMethodBeat.o(155863);
      return i;
    }
    AppMethodBeat.o(155863);
    return 0;
  }
  
  public static int u(Activity paramActivity)
  {
    AppMethodBeat.i(155862);
    if ((paramActivity instanceof AppCompatActivity))
    {
      if (((AppCompatActivity)paramActivity).getSupportActionBar() != null)
      {
        i = ((AppCompatActivity)paramActivity).getSupportActionBar().getHeight();
        AppMethodBeat.o(155862);
        return i;
      }
    }
    else if (paramActivity.getActionBar() != null)
    {
      i = paramActivity.getActionBar().getHeight();
      AppMethodBeat.o(155862);
      return i;
    }
    int i = cb(paramActivity);
    AppMethodBeat.o(155862);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.a
 * JD-Core Version:    0.7.0.1
 */