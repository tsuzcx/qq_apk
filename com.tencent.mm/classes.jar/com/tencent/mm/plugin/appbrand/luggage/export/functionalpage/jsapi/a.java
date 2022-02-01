package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionStore;", "", "()V", "store", "Landroid/util/SparseArray;", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyFunction;", "getStore", "()Landroid/util/SparseArray;", "removeReturns", "V", "key", "", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "plugin-appbrand-integration_release"})
final class a
{
  private static final SparseArray<b<MMActivity, x>> qby;
  public static final a qbz;
  
  static
  {
    AppMethodBeat.i(265099);
    qbz = new a();
    qby = new SparseArray();
    AppMethodBeat.o(265099);
  }
  
  public static <V> V c(SparseArray<V> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(265097);
    p.k(paramSparseArray, "$this$removeReturns");
    Object localObject = paramSparseArray.get(paramInt);
    if (localObject != null) {
      paramSparseArray.remove(paramInt);
    }
    AppMethodBeat.o(265097);
    return localObject;
  }
  
  public static SparseArray<b<MMActivity, x>> caZ()
  {
    return qby;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.a
 * JD-Core Version:    0.7.0.1
 */