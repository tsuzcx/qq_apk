package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionStore;", "", "()V", "store", "Landroid/util/SparseArray;", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyFunction;", "getStore", "()Landroid/util/SparseArray;", "removeReturns", "V", "key", "", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "plugin-appbrand-integration_release"})
final class a
{
  private static final SparseArray<b<MMActivity, z>> lTD;
  public static final a lTE;
  
  static
  {
    AppMethodBeat.i(223671);
    lTE = new a();
    lTD = new SparseArray();
    AppMethodBeat.o(223671);
  }
  
  public static SparseArray<b<MMActivity, z>> btc()
  {
    return lTD;
  }
  
  public static <V> V c(SparseArray<V> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(223670);
    p.h(paramSparseArray, "$this$removeReturns");
    Object localObject = paramSparseArray.get(paramInt);
    if (localObject != null) {
      paramSparseArray.remove(paramInt);
    }
    AppMethodBeat.o(223670);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.a
 * JD-Core Version:    0.7.0.1
 */