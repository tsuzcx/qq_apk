package com.tencent.mm.plugin.appbrand.jsapi.p;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public abstract class e
  extends b
{
  private static q.a lhy = com.tencent.mm.plugin.appbrand.utils.a.mTz;
  private int cgA;
  private m kwe;
  private boolean lhh;
  private WeakReference<com.tencent.mm.plugin.appbrand.jsapi.e> lhw;
  String lhx;
  
  public static void a(q.a parama)
  {
    lhy = parama;
  }
  
  protected final void K(Runnable paramRunnable)
  {
    if (this.lhw == null) {}
    for (com.tencent.mm.plugin.appbrand.jsapi.e locale = null; locale == null; locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.lhw.get()) {
      return;
    }
    locale.K(paramRunnable);
  }
  
  void T(JSONObject paramJSONObject)
  {
    if (this.lhh)
    {
      this.lhx = paramJSONObject.optString("headerText");
      V(paramJSONObject);
      return;
    }
    U(paramJSONObject);
  }
  
  abstract void U(JSONObject paramJSONObject);
  
  abstract void V(JSONObject paramJSONObject);
  
  final void a(m paramm, com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    this.kwe = paramm;
    this.lhw = new WeakReference(parame);
    this.cgA = paramInt;
    this.lhh = paramBoolean;
    T(paramJSONObject);
  }
  
  public final View bmO()
  {
    try
    {
      View localView = ((com.tencent.mm.plugin.appbrand.jsapi.e)this.lhw.get()).aYC().getRootView();
      return localView;
    }
    catch (NullPointerException localNullPointerException)
    {
      ae.w("MicroMsg.AppBrand.JsApiPickerHandler", "getInvokerView: return a null invoker view");
    }
    return null;
  }
  
  final void bmP()
  {
    if ((AppBrandEmptyPickerView)aK(AppBrandEmptyPickerView.class) == null)
    {
      ae.e("MicroMsg.AppBrand.JsApiPickerHandler", "showEmptyView settlePicker returns NULL");
      return;
    }
    this.npt.setOnResultListener(new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, Object paramAnonymousObject)
      {
        AppMethodBeat.i(137579);
        e.a(e.this).hide();
        AppMethodBeat.o(137579);
      }
    });
    this.npt.show();
  }
  
  final void c(at paramat)
  {
    if (this.lhw == null) {}
    for (com.tencent.mm.plugin.appbrand.jsapi.e locale = null; locale == null; locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.lhw.get()) {
      return;
    }
    paramat.h(locale).bja();
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.picker.a dw(Context paramContext)
  {
    paramContext = super.dw(paramContext);
    ae.d("MicroMsg.AppBrand.JsApiPickerHandler", "createPanel, hook for setOrientationGetter");
    if ((paramContext != null) && (this.lhw != null))
    {
      com.tencent.mm.plugin.appbrand.jsapi.e locale = (com.tencent.mm.plugin.appbrand.jsapi.e)this.lhw.get();
      if (locale != null) {
        paramContext.setOrientationGetter(lhy.a(locale));
      }
    }
    return paramContext;
  }
  
  final void q(String paramString, Map<String, Object> paramMap)
  {
    if ((this.lhw != null) && (this.lhw.get() != null) && (this.kwe != null)) {
      ((com.tencent.mm.plugin.appbrand.jsapi.e)this.lhw.get()).h(this.cgA, this.kwe.n(paramString, paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p.e
 * JD-Core Version:    0.7.0.1
 */