package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.bk;

final class AppBrandInputInvokeHandler$2
  implements v.d
{
  AppBrandInputInvokeHandler$2(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler) {}
  
  public final boolean xb(String paramString)
  {
    if (AppBrandInputInvokeHandler.access$200(this.htr) != null)
    {
      if (!"[DELETE_EMOTION]".equalsIgnoreCase(paramString)) {
        break label108;
      }
      paramString = AppBrandInputInvokeHandler.access$200(this.htr);
      if (paramString.huL == null) {
        break label76;
      }
      if (!bk.L(paramString.getEditableText())) {
        paramString.huL.deleteSurroundingText(paramString.getEditableText().length(), paramString.getEditableText().length() - 1);
      }
    }
    return true;
    label76:
    paramString.dispatchKeyEvent(new KeyEvent(0, 67));
    paramString.dispatchKeyEvent(new KeyEvent(1, 67));
    return true;
    label108:
    x localx = AppBrandInputInvokeHandler.access$200(this.htr);
    if (localx.getEditableText() == null) {
      localx.setText(paramString, TextView.BufferType.EDITABLE);
    }
    for (;;)
    {
      localx.setSelection(localx.getEditableText().length());
      return true;
      localx.getEditableText().append(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.2
 * JD-Core Version:    0.7.0.1
 */