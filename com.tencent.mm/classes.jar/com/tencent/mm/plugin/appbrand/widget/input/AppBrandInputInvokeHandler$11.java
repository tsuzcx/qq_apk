package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.Editable;
import com.tencent.mm.plugin.appbrand.widget.input.c.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.widget.f;
import java.lang.ref.WeakReference;

final class AppBrandInputInvokeHandler$11
  extends f
{
  AppBrandInputInvokeHandler$11(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    if ((this.htr.mPageRef == null) || (this.htr.mPageRef.get() == null) || (AppBrandInputInvokeHandler.access$200(this.htr) == null)) {
      return;
    }
    AppBrandInputInvokeHandler.access$700(this.htr);
    if (ai.s(paramEditable))
    {
      y.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] text composing %s", new Object[] { paramEditable });
      return;
    }
    y.d("MicroMsg.AppBrandInputInvokeHandler", "[bindInput] not composing text %s", new Object[] { paramEditable });
    paramEditable = AppBrandInputInvokeHandler.access$200(this.htr).getEditableText();
    AppBrandInputInvokeHandler.access$400(this.htr).a(paramEditable, AppBrandInputInvokeHandler.access$600(this.htr));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.11
 * JD-Core Version:    0.7.0.1
 */