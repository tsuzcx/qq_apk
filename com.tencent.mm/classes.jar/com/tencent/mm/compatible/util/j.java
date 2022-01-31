package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.mm.sdk.platformtools.u;

@Deprecated
public final class j
  extends u
{
  @TargetApi(11)
  public static final void p(Activity paramActivity)
  {
    if (paramActivity == null) {
      return;
    }
    Rect localRect = new Rect();
    paramActivity.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
    int i = localRect.top;
    int j = a.o(paramActivity);
    ueB = paramActivity.getResources().getDisplayMetrics().heightPixels - j - i;
  }
  
  public static final int zM()
  {
    return ueB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.util.j
 * JD-Core Version:    0.7.0.1
 */