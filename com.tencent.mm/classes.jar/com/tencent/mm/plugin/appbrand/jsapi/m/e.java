package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class e
  extends b
{
  private int bWl;
  private m jYs;
  private boolean kHd;
  private WeakReference<com.tencent.mm.plugin.appbrand.jsapi.e> kHs;
  String kHt;
  
  protected final void N(Runnable paramRunnable)
  {
    if (this.kHs == null) {}
    for (com.tencent.mm.plugin.appbrand.jsapi.e locale = null; locale == null; locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.kHs.get()) {
      return;
    }
    locale.N(paramRunnable);
  }
  
  void R(JSONObject paramJSONObject)
  {
    if (this.kHd)
    {
      this.kHt = paramJSONObject.optString("headerText");
      T(paramJSONObject);
      return;
    }
    S(paramJSONObject);
  }
  
  abstract void S(JSONObject paramJSONObject);
  
  abstract void T(JSONObject paramJSONObject);
  
  final void a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    this.jYs = paramm;
    this.kHs = new WeakReference(parame);
    this.bWl = paramInt;
    this.kHd = paramBoolean;
    R(paramJSONObject);
  }
  
  public final View bit()
  {
    try
    {
      View localView = ((com.tencent.mm.plugin.appbrand.jsapi.e)this.kHs.get()).aUW().getRootView();
      return localView;
    }
    catch (NullPointerException localNullPointerException)
    {
      ac.w("MicroMsg.AppBrand.JsApiPickerHandler", "getInvokerView: return a null invoker view");
    }
    return null;
  }
  
  final void biu()
  {
    aK(AppBrandEmptyPickerView.class);
    this.mJP.setOnResultListener(new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, Object paramAnonymousObject)
      {
        AppMethodBeat.i(137579);
        e.this.mJP.hide();
        AppMethodBeat.o(137579);
      }
    });
    this.mJP.show();
  }
  
  final void c(ar paramar)
  {
    if (this.kHs == null) {}
    for (com.tencent.mm.plugin.appbrand.jsapi.e locale = null; locale == null; locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.kHs.get()) {
      return;
    }
    paramar.h(locale).beN();
  }
  
  final void n(String paramString, Map<String, Object> paramMap)
  {
    if ((this.kHs != null) && (this.kHs.get() != null) && (this.jYs != null)) {
      ((com.tencent.mm.plugin.appbrand.jsapi.e)this.kHs.get()).h(this.bWl, this.jYs.k(paramString, paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.e
 * JD-Core Version:    0.7.0.1
 */