package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import d.g.a.b;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionStore;", "", "()V", "store", "Landroid/util/SparseArray;", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyFunction;", "getStore", "()Landroid/util/SparseArray;", "removeReturns", "V", "key", "", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "plugin-appbrand-integration_release"})
final class a
{
  private static final SparseArray<b<MMActivity, z>> lPc;
  public static final a lPd;
  
  static
  {
    AppMethodBeat.i(189411);
    lPd = new a();
    lPc = new SparseArray();
    AppMethodBeat.o(189411);
  }
  
  public static SparseArray<b<MMActivity, z>> bsr()
  {
    return lPc;
  }
  
  public static <V> V c(SparseArray<V> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(189410);
    p.h(paramSparseArray, "$this$removeReturns");
    Object localObject = paramSparseArray.get(paramInt);
    if (localObject != null) {
      paramSparseArray.remove(paramInt);
    }
    AppMethodBeat.o(189410);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.a
 * JD-Core Version:    0.7.0.1
 */