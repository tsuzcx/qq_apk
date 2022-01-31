package com.tencent.mm.plugin.appbrand.widget.input;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

final class AppBrandInputInvokeHandler$6
  implements TextView.OnEditorActionListener
{
  AppBrandInputInvokeHandler$6(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler, int paramInt) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == this.hts)
    {
      AppBrandInputInvokeHandler.access$902(this.htr, AppBrandInputInvokeHandler.c.htu);
      AppBrandInputInvokeHandler.access$1000(this.htr);
      AppBrandInputInvokeHandler.access$902(this.htr, null);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.6
 * JD-Core Version:    0.7.0.1
 */