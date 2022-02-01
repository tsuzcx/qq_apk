package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
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
  private int cgA;
  private m ksO;
  private WeakReference<com.tencent.mm.plugin.appbrand.jsapi.e> ldL;
  String ldM;
  private boolean ldw;
  
  protected final void M(Runnable paramRunnable)
  {
    if (this.ldL == null) {}
    for (com.tencent.mm.plugin.appbrand.jsapi.e locale = null; locale == null; locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.ldL.get()) {
      return;
    }
    locale.M(paramRunnable);
  }
  
  void T(JSONObject paramJSONObject)
  {
    if (this.ldw)
    {
      this.ldM = paramJSONObject.optString("headerText");
      V(paramJSONObject);
      return;
    }
    U(paramJSONObject);
  }
  
  abstract void U(JSONObject paramJSONObject);
  
  abstract void V(JSONObject paramJSONObject);
  
  final void a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    this.ksO = paramm;
    this.ldL = new WeakReference(parame);
    this.cgA = paramInt;
    this.ldw = paramBoolean;
    T(paramJSONObject);
  }
  
  public final View bmf()
  {
    try
    {
      View localView = ((com.tencent.mm.plugin.appbrand.jsapi.e)this.ldL.get()).aYi().getRootView();
      return localView;
    }
    catch (NullPointerException localNullPointerException)
    {
      ad.w("MicroMsg.AppBrand.JsApiPickerHandler", "getInvokerView: return a null invoker view");
    }
    return null;
  }
  
  final void bmg()
  {
    if ((AppBrandEmptyPickerView)aK(AppBrandEmptyPickerView.class) == null)
    {
      ad.e("MicroMsg.AppBrand.JsApiPickerHandler", "showEmptyView settlePicker returns NULL");
      return;
    }
    this.nkl.setOnResultListener(new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, Object paramAnonymousObject)
      {
        AppMethodBeat.i(137579);
        e.this.nkl.hide();
        AppMethodBeat.o(137579);
      }
    });
    this.nkl.show();
  }
  
  final void c(at paramat)
  {
    if (this.ldL == null) {}
    for (com.tencent.mm.plugin.appbrand.jsapi.e locale = null; locale == null; locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.ldL.get()) {
      return;
    }
    paramat.h(locale).bir();
  }
  
  final void p(String paramString, Map<String, Object> paramMap)
  {
    if ((this.ldL != null) && (this.ldL.get() != null) && (this.ksO != null)) {
      ((com.tencent.mm.plugin.appbrand.jsapi.e)this.ldL.get()).h(this.cgA, this.ksO.m(paramString, paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.e
 * JD-Core Version:    0.7.0.1
 */