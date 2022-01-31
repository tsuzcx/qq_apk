package com.tencent.mm.plugin.appbrand.ui;

import android.support.v7.app.ActionBar;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import com.tencent.mm.plugin.appbrand.compat.c.a;
import com.tencent.mm.ui.MMActivity;

final class m
{
  static void b(MMActivity paramMMActivity)
  {
    if ((paramMMActivity == null) || (paramMMActivity.getSupportActionBar() == null)) {}
    do
    {
      return;
      paramMMActivity = paramMMActivity.getSupportActionBar().getCustomView().findViewById(c.a.actionbar_up_indicator);
    } while ((paramMMActivity == null) || (paramMMActivity.getLayoutParams() == null) || (!(paramMMActivity.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)));
    ((ViewGroup.MarginLayoutParams)paramMMActivity.getLayoutParams()).rightMargin = 0;
    paramMMActivity.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.m
 * JD-Core Version:    0.7.0.1
 */