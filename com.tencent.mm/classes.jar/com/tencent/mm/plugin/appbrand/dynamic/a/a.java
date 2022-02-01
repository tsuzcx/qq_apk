package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.f;
import com.tencent.mm.plugin.appbrand.af.j;
import java.util.Map;
import java.util.Set;

final class a
  implements f
{
  private final j<Object, View> rkP;
  
  a()
  {
    AppMethodBeat.i(121207);
    this.rkP = new j();
    AppMethodBeat.o(121207);
  }
  
  public final Map<Object, Set<View>> bEG()
  {
    AppMethodBeat.i(121212);
    Map localMap = this.rkP.cNk();
    AppMethodBeat.o(121212);
    return localMap;
  }
  
  public final boolean d(Object paramObject, View paramView)
  {
    AppMethodBeat.i(121208);
    boolean bool = this.rkP.v(paramObject, paramView);
    AppMethodBeat.o(121208);
    return bool;
  }
  
  public final Set<View> dA(Object paramObject)
  {
    AppMethodBeat.i(121211);
    paramObject = this.rkP.ek(paramObject);
    AppMethodBeat.o(121211);
    return paramObject;
  }
  
  public final Set<View> dz(Object paramObject)
  {
    AppMethodBeat.i(121210);
    paramObject = this.rkP.ej(paramObject);
    AppMethodBeat.o(121210);
    return paramObject;
  }
  
  public final boolean e(Object paramObject, View paramView)
  {
    AppMethodBeat.i(121209);
    boolean bool = this.rkP.O(paramObject, paramView);
    AppMethodBeat.o(121209);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.a
 * JD-Core Version:    0.7.0.1
 */