package com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/FunctionStore;", "", "()V", "store", "Landroid/util/SparseArray;", "Lkotlin/Function1;", "Lcom/tencent/mm/ui/MMActivity;", "", "Lcom/tencent/mm/plugin/appbrand/luggage/export/functionalpage/jsapi/ProxyFunction;", "getStore", "()Landroid/util/SparseArray;", "removeReturns", "V", "key", "", "(Landroid/util/SparseArray;I)Ljava/lang/Object;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class a
{
  public static final a tgy;
  private static final SparseArray<b<MMActivity, ah>> tgz;
  
  static
  {
    AppMethodBeat.i(320125);
    tgy = new a();
    tgz = new SparseArray();
    AppMethodBeat.o(320125);
  }
  
  public static SparseArray<b<MMActivity, ah>> cBs()
  {
    return tgz;
  }
  
  public static <V> V d(SparseArray<V> paramSparseArray, int paramInt)
  {
    AppMethodBeat.i(320119);
    s.u(paramSparseArray, "<this>");
    Object localObject = paramSparseArray.get(paramInt);
    if (localObject != null) {
      paramSparseArray.remove(paramInt);
    }
    AppMethodBeat.o(320119);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.jsapi.a
 * JD-Core Version:    0.7.0.1
 */