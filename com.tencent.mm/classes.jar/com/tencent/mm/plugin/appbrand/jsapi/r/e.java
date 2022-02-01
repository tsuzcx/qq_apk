package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.h.a;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.utils.q.a;
import com.tencent.mm.plugin.appbrand.widget.picker.AppBrandEmptyPickerView;
import com.tencent.mm.plugin.appbrand.widget.picker.b;
import com.tencent.mm.plugin.appbrand.widget.picker.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

public abstract class e
  extends b
{
  private static q.a mmV = com.tencent.mm.plugin.appbrand.utils.a.ogC;
  private int csv;
  private p lAi;
  private boolean mmD;
  private WeakReference<h> mmT;
  String mmU;
  
  public static void a(q.a parama)
  {
    mmV = parama;
  }
  
  protected final void P(Runnable paramRunnable)
  {
    if (this.mmT == null) {}
    for (h localh = null; localh == null; localh = (h)this.mmT.get()) {
      return;
    }
    localh.P(paramRunnable);
  }
  
  final void a(p paramp, h paramh, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    this.lAi = paramp;
    this.mmT = new WeakReference(paramh);
    this.csv = paramInt;
    this.mmD = paramBoolean;
    ac(paramJSONObject);
  }
  
  void ac(JSONObject paramJSONObject)
  {
    if (this.mmD)
    {
      this.mmU = paramJSONObject.optString("headerText");
      ae(paramJSONObject);
      return;
    }
    ad(paramJSONObject);
  }
  
  abstract void ad(JSONObject paramJSONObject);
  
  abstract void ae(JSONObject paramJSONObject);
  
  final void b(bc parambc)
  {
    if (this.mmT == null) {}
    for (h localh = null; localh == null; localh = (h)this.mmT.get()) {
      return;
    }
    parambc.h(localh).bEo();
  }
  
  public final View bIn()
  {
    try
    {
      View localView = ((h)this.mmT.get()).getCustomViewContainer().getRootView();
      return localView;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.w("MicroMsg.AppBrand.JsApiPickerHandler", "getInvokerView: return a null invoker view");
    }
    return null;
  }
  
  final void bIo()
  {
    if ((AppBrandEmptyPickerView)aK(AppBrandEmptyPickerView.class) == null)
    {
      Log.e("MicroMsg.AppBrand.JsApiPickerHandler", "showEmptyView settlePicker returns NULL");
      return;
    }
    this.oza.setOnResultListener(new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, Object paramAnonymousObject)
      {
        AppMethodBeat.i(137579);
        e.a(e.this).hide();
        AppMethodBeat.o(137579);
      }
    });
    this.oza.show();
  }
  
  public final com.tencent.mm.plugin.appbrand.widget.picker.a dR(Context paramContext)
  {
    paramContext = super.dR(paramContext);
    Log.d("MicroMsg.AppBrand.JsApiPickerHandler", "createPanel, hook for setOrientationGetter");
    if ((paramContext != null) && (this.mmT != null))
    {
      h localh = (h)this.mmT.get();
      if (localh != null) {
        paramContext.setOrientationGetter(mmV.a(localh));
      }
    }
    return paramContext;
  }
  
  final void q(String paramString, Map<String, Object> paramMap)
  {
    if ((this.mmT != null) && (this.mmT.get() != null) && (this.lAi != null)) {
      ((h)this.mmT.get()).i(this.csv, this.lAi.n(paramString, paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.r.e
 * JD-Core Version:    0.7.0.1
 */