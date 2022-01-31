package com.tencent.mm.plugin.appbrand.jsapi.d;

import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler;
import com.tencent.mm.plugin.appbrand.widget.input.d.e;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class c
  extends f
{
  private static final int CTRL_INDEX = 110;
  private static final String NAME = "insertTextArea";
  
  protected final AppBrandInputInvokeHandler a(WeakReference<q> paramWeakReference, String paramString, int paramInt)
  {
    return new c.3(this, paramWeakReference, paramInt, paramString);
  }
  
  public final void a(q paramq, JSONObject paramJSONObject, int paramInt)
  {
    super.a(paramq, paramJSONObject, paramInt);
  }
  
  protected final void a(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler)
  {
    super.a(paramAppBrandInputInvokeHandler);
    paramAppBrandInputInvokeHandler.setOnLineHeightChangeListener(new c.1(this, paramAppBrandInputInvokeHandler));
    paramAppBrandInputInvokeHandler.setOnInputFocusChangeListener(new c.2(this, paramAppBrandInputInvokeHandler));
  }
  
  protected final boolean a(e parame, JSONObject paramJSONObject, q paramq, int paramInt)
  {
    if (!super.a(parame, paramJSONObject, paramq, paramInt)) {
      return false;
    }
    parame.hyO = Boolean.valueOf(true);
    parame.hys = "emoji";
    parame.hyt = false;
    parame.hyu = false;
    parame.hyU = Boolean.valueOf(false);
    parame.hyP = Boolean.valueOf(paramJSONObject.optBoolean("confirm", true));
    return true;
  }
  
  protected final boolean aiU()
  {
    return false;
  }
  
  protected final boolean aiV()
  {
    return false;
  }
  
  protected final boolean aiW()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.c
 * JD-Core Version:    0.7.0.1
 */