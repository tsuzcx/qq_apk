package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionStore;", "", "()V", "store", "Landroid/util/SparseArray;", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyFunction;", "getStore", "()Landroid/util/SparseArray;", "removeReturns", "V", "key", "", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "plugin-appbrand-integration_release"})
final class a
{
  private static final SparseArray<b<MMActivity, x>> nbj;
  public static final a nbk;
  
  static
  {
    AppMethodBeat.i(228890);
    nbk = new a();
    nbj = new SparseArray();
    AppMethodBeat.o(228890);
  }
  
  public static SparseArray<b<MMActivity, x>> bOJ()
  {
    return nbj;
  }
  
  public static <V> V c(SparseArray<V> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(228889);
    p.h(paramSparseArray, "$this$removeReturns");
    Object localObject = paramSparseArray.get(paramInt);
    if (localObject != null) {
      paramSparseArray.remove(paramInt);
    }
    AppMethodBeat.o(228889);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.a
 * JD-Core Version:    0.7.0.1
 */