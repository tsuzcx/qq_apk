package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputConnection;

final class AppBrandNumberKeyboardView$2
  implements View.OnClickListener
{
  AppBrandNumberKeyboardView$2(AppBrandNumberKeyboardView paramAppBrandNumberKeyboardView) {}
  
  public final void onClick(View paramView)
  {
    if (AppBrandNumberKeyboardView.a(this.huN) == null) {
      return;
    }
    String str1 = null;
    String str2;
    if (paramView.getId() == AppBrandNumberKeyboardView.a(this.huN, "tenpay_keyboard_x")) {
      switch (AppBrandNumberKeyboardView.b(this.huN))
      {
      default: 
        return;
      case 1: 
        str2 = "X";
      }
    }
    int i;
    do
    {
      while (!TextUtils.isEmpty(str2))
      {
        AppBrandNumberKeyboardView.a(this.huN).commitText(str2, str2.length());
        return;
        str2 = ".";
      }
      i = 0;
      str2 = str1;
    } while (i >= AppBrandNumberKeyboardView.c(this.huN).size());
    int j = AppBrandNumberKeyboardView.b(this.huN, (String)AppBrandNumberKeyboardView.c(this.huN).valueAt(i));
    if (paramView.getId() == j) {
      str1 = String.valueOf(AppBrandNumberKeyboardView.c(this.huN).keyAt(i));
    }
    for (;;)
    {
      i += 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandNumberKeyboardView.2
 * JD-Core Version:    0.7.0.1
 */