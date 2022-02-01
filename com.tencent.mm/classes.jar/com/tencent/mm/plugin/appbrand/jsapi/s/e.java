package com.tencent.mm.plugin.appbrand.jsapi.s;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.appbrand.jsapi.g.a;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.utils.s.a;
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
  private static s.a plc = com.tencent.mm.plugin.appbrand.utils.b.rip;
  private int cqA;
  private o ovz;
  private boolean pkL;
  private WeakReference<g> pla;
  String plb;
  
  public static void a(s.a parama)
  {
    plc = parama;
  }
  
  protected final void P(Runnable paramRunnable)
  {
    if (this.pla == null) {}
    for (g localg = null; localg == null; localg = (g)this.pla.get()) {
      return;
    }
    localg.P(paramRunnable);
  }
  
  final void a(o paramo, g paramg, JSONObject paramJSONObject, int paramInt, boolean paramBoolean)
  {
    this.ovz = paramo;
    this.pla = new WeakReference(paramg);
    this.cqA = paramInt;
    this.pkL = paramBoolean;
    ag(paramJSONObject);
  }
  
  void ag(JSONObject paramJSONObject)
  {
    if (this.pkL)
    {
      this.plb = paramJSONObject.optString("headerText");
      ai(paramJSONObject);
      return;
    }
    ah(paramJSONObject);
  }
  
  abstract void ah(JSONObject paramJSONObject);
  
  final void aho(String paramString)
  {
    p(paramString, null);
  }
  
  abstract void ai(JSONObject paramJSONObject);
  
  final void b(az paramaz)
  {
    if (this.pla == null) {}
    for (g localg = null; localg == null; localg = (g)this.pla.get()) {
      return;
    }
    paramaz.j(localg).bPO();
  }
  
  public final View bTX()
  {
    try
    {
      View localView = ((g)this.pla.get()).getCustomViewContainer().getRootView();
      return localView;
    }
    catch (NullPointerException localNullPointerException)
    {
      Log.w("MicroMsg.AppBrand.JsApiPickerHandler", "getInvokerView: return a null invoker view");
    }
    return null;
  }
  
  final void bTY()
  {
    if ((AppBrandEmptyPickerView)aH(AppBrandEmptyPickerView.class) == null)
    {
      Log.e("MicroMsg.AppBrand.JsApiPickerHandler", "showEmptyView settlePicker returns NULL");
      return;
    }
    cpG().setOnResultListener(new c.a()
    {
      public final void a(boolean paramAnonymousBoolean, Object paramAnonymousObject)
      {
        AppMethodBeat.i(137579);
        e.a(e.this).hide();
        AppMethodBeat.o(137579);
      }
    });
    cpG().show();
  }
  
  public final a dQ(Context paramContext)
  {
    paramContext = super.dQ(paramContext);
    Log.d("MicroMsg.AppBrand.JsApiPickerHandler", "createPanel, hook for setOrientationGetter");
    if ((paramContext != null) && (this.pla != null))
    {
      g localg = (g)this.pla.get();
      if (localg != null) {
        paramContext.setOrientationGetter(plc.a(localg));
      }
    }
    return paramContext;
  }
  
  final void p(String paramString, Map<String, Object> paramMap)
  {
    if ((this.pla != null) && (this.pla.get() != null) && (this.ovz != null)) {
      ((g)this.pla.get()).j(this.cqA, this.ovz.m(paramString, paramMap));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.e
 * JD-Core Version:    0.7.0.1
 */