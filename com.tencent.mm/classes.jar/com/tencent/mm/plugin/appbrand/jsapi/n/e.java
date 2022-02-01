package com.tencent.mm.plugin.appbrand.jsapi.n;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

abstract class e
  extends b
{
  private int bZo;
  private m jxX;
  private WeakReference<com.tencent.mm.plugin.appbrand.jsapi.e> kgC;
  String kgD;
  private boolean kgn;
  
  protected final void L(Runnable paramRunnable)
  {
    if (this.kgC == null) {}
    for (com.tencent.mm.plugin.appbrand.jsapi.e locale = null; locale == null; locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.kgC.get()) {
      return;
    }
    locale.L(paramRunnable);
  }
  
  void R(JSONObject paramJSONObject)
  {
    if (this.kgn)
    {
      this.kgD = paramJSONObject.optString("headerText");
      T(paramJSONObject);
      return;
    }
    S(paramJSONObject);
  }
  
  abstract void S(JSONObject paramJSONObject);
  
  abstract void T(JSONObject paramJSONObject);
  
  final void a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    this.jxX = paramm;
    this.kgC = new WeakReference(parame);
    this.bZo = paramInt;
    this.kgn = paramBoolean;
    R(paramJSONObject);
  }
  
  public final View bbA()
  {
    try
    {
      View localView = ((com.tencent.mm.plugin.appbrand.jsapi.e)this.kgC.get()).aOg().getRootView();
      return localView;
    }
    catch (NullPointerException localNullPointerException)
    {
      ad.w("MicroMsg.AppBrand.JsApiPickerHandler", "getInvokerView: return a null invoker view");
    }
    return null;
  }
  
  final void bbB()
  {
    aK(AppBrandEmptyPickerView.class);
    this.mhO.setOnResultListener(new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, Object paramAnonymousObject)
      {
        AppMethodBeat.i(137579);
        e.this.mhO.hide();
        AppMethodBeat.o(137579);
      }
    });
    this.mhO.show();
  }
  
  final void c(ar paramar)
  {
    if (this.kgC == null) {}
    for (com.tencent.mm.plugin.appbrand.jsapi.e locale = null; locale == null; locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.kgC.get()) {
      return;
    }
    paramar.h(locale).aXQ();
  }
  
  final void n(String paramString, Map<String, Object> paramMap)
  {
    if ((this.kgC != null) && (this.kgC.get() != null) && (this.jxX != null)) {
      ((com.tencent.mm.plugin.appbrand.jsapi.e)this.kgC.get()).h(this.bZo, this.jxX.k(paramString, paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n.e
 * JD-Core Version:    0.7.0.1
 */