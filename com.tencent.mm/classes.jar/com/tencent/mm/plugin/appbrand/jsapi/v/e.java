package com.tencent.mm.plugin.appbrand.jsapi.v;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.utils.v.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.mm.plugin.appbrand.widget.picker.a;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public abstract class e
  extends com.tencent.mm.plugin.appbrand.widget.picker.b
{
  private static v.a sqd = com.tencent.mm.plugin.appbrand.utils.b.uql;
  private int eit;
  private p ryT;
  private boolean spN;
  private WeakReference<h> sqb;
  String sqc;
  
  public static void a(v.a parama)
  {
    sqd = parama;
  }
  
  protected final void V(Runnable paramRunnable)
  {
    if (this.sqb == null) {}
    for (h localh = null; localh == null; localh = (h)this.sqb.get()) {
      return;
    }
    localh.V(paramRunnable);
  }
  
  final void a(p paramp, h paramh, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    this.ryT = paramp;
    this.sqb = new WeakReference(paramh);
    this.eit = paramInt;
    this.spN = paramBoolean;
    aq(paramJSONObject);
  }
  
  final void aal(String paramString)
  {
    q(paramString, null);
  }
  
  void aq(JSONObject paramJSONObject)
  {
    if (this.spN)
    {
      this.sqc = paramJSONObject.optString("headerText");
      as(paramJSONObject);
      return;
    }
    ar(paramJSONObject);
  }
  
  abstract void ar(JSONObject paramJSONObject);
  
  abstract void as(JSONObject paramJSONObject);
  
  final void b(bc parambc)
  {
    if (this.sqb == null) {}
    for (h localh = null; localh == null; localh = (h)this.sqb.get()) {
      return;
    }
    parambc.i(localh).cpV();
  }
  
  public final View cuk()
  {
    try
    {
      View localView = ((h)this.sqb.get()).getCustomViewContainer().getRootView();
      return localView;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.w("MicroMsg.AppBrand.JsApiPickerHandler", "getInvokerView: return a null invoker view");
    }
    return null;
  }
  
  final void cul()
  {
    if ((AppBrandEmptyPickerView)bb(AppBrandEmptyPickerView.class) == null)
    {
      Log.e("MicroMsg.AppBrand.JsApiPickerHandler", "showEmptyView settlePicker returns NULL");
      return;
    }
    cSl().setOnResultListener(new c.a()
    {
      public final void c(boolean paramAnonymousBoolean, Object paramAnonymousObject)
      {
        AppMethodBeat.i(137579);
        e.a(e.this).hide();
        AppMethodBeat.o(137579);
      }
    });
    cSl().show();
  }
  
  public final a eL(Context paramContext)
  {
    paramContext = super.eL(paramContext);
    Log.d("MicroMsg.AppBrand.JsApiPickerHandler", "createPanel, hook for setOrientationGetter");
    if ((paramContext != null) && (this.sqb != null))
    {
      h localh = (h)this.sqb.get();
      if (localh != null) {
        paramContext.setOrientationGetter(sqd.a(localh));
      }
    }
    return paramContext;
  }
  
  final void q(String paramString, Map<String, Object> paramMap)
  {
    if ((this.sqb != null) && (this.sqb.get() != null) && (this.ryT != null)) {
      ((h)this.sqb.get()).callback(this.eit, this.ryT.m(paramString, paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.e
 * JD-Core Version:    0.7.0.1
 */