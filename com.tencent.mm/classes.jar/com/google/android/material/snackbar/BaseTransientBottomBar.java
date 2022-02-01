package com.google.android.material.snackbar;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.material.a.b;

public abstract class BaseTransientBottomBar<B extends BaseTransientBottomBar<B>>
{
  private static final boolean dxy;
  private static final int[] dxz;
  static final Handler handler;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {}
    for (boolean bool = true;; bool = false)
    {
      dxy = bool;
      dxz = new int[] { a.b.snackbarStyle };
      handler = new Handler(Looper.getMainLooper(), new BaseTransientBottomBar.1());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar
 * JD-Core Version:    0.7.0.1
 */