package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.widget.input.c.a;
import com.tencent.mm.plugin.appbrand.widget.input.c.b;
import com.tencent.mm.sdk.platformtools.y;

final class AppBrandInputInvokeHandler$12
  implements b
{
  AppBrandInputInvokeHandler$12(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler) {}
  
  public final void agA()
  {
    if (AppBrandInputInvokeHandler.access$200(this.htr) == null) {
      return;
    }
    y.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] onComposingDismissed %s", new Object[] { AppBrandInputInvokeHandler.access$200(this.htr).getEditableText() });
    AppBrandInputInvokeHandler.access$400(this.htr).a(AppBrandInputInvokeHandler.access$200(this.htr).getEditableText(), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.12
 * JD-Core Version:    0.7.0.1
 */