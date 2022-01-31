package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import com.tencent.mm.compatible.a.a;

public final class a
{
  public static int bh(Context paramContext)
  {
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(a.a.actionBarSize, localTypedValue, true)) {
      return TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
    }
    if (paramContext.getTheme().resolveAttribute(16843499, localTypedValue, true)) {
      return TypedValue.complexToDimensionPixelSize(localTypedValue.data, paramContext.getResources().getDisplayMetrics());
    }
    return 0;
  }
  
  public static int o(Activity paramActivity)
  {
    if ((paramActivity instanceof AppCompatActivity))
    {
      if (((AppCompatActivity)paramActivity).getSupportActionBar() != null) {
        return ((AppCompatActivity)paramActivity).getSupportActionBar().getHeight();
      }
    }
    else if (paramActivity.getActionBar() != null) {
      return paramActivity.getActionBar().getHeight();
    }
    return bh(paramActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.util.a
 * JD-Core Version:    0.7.0.1
 */