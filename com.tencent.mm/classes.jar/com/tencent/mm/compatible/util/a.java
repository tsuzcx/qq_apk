package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.util.TypedValue;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static int c(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(261698);
    if (paramActivity == null)
    {
      Log.w("MicroMsg.ActionBarCompatHelper", "[getActionBarHeight] activity is null!");
      AppMethodBeat.o(261698);
      return paramInt;
    }
    int i;
    if ((paramActivity instanceof AppCompatActivity))
    {
      if (((AppCompatActivity)paramActivity).getSupportActionBar() == null) {
        break label109;
      }
      i = ((AppCompatActivity)paramActivity).getSupportActionBar().getHeight();
    }
    for (;;)
    {
      int j = i;
      if (i <= 0) {
        j = paramInt;
      }
      Log.i("MicroMsg.ActionBarCompatHelper", "[getActionBarHeight] real:%s defaultVal:%s", new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
      AppMethodBeat.o(261698);
      return j;
      if (paramActivity.getActionBar() != null) {
        i = paramActivity.getActionBar().getHeight();
      } else {
        label109:
        i = 0;
      }
    }
  }
  
  public static int cu(Context paramContext)
  {
    AppMethodBeat.i(155863);
    TypedValue localTypedValue = new TypedValue();
    int i;
    if (paramContext.getTheme().resolveAttribute(a.a.actionBarSize, localTypedValue, true))
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
  
  public static int t(Activity paramActivity)
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
    int i = cu(paramActivity);
    AppMethodBeat.o(155862);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.util.a
 * JD-Core Version:    0.7.0.1
 */