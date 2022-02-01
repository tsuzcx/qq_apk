package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.aa.h;
import java.util.Map;
import java.util.Set;

final class a
  implements e
{
  private final h<Object, View> jld;
  
  a()
  {
    AppMethodBeat.i(121207);
    this.jld = new h();
    AppMethodBeat.o(121207);
  }
  
  public final Map<Object, Set<View>> atJ()
  {
    AppMethodBeat.i(121212);
    Map localMap = this.jld.bqk();
    AppMethodBeat.o(121212);
    return localMap;
  }
  
  public final Set<View> bX(Object paramObject)
  {
    AppMethodBeat.i(121210);
    paramObject = this.jld.cD(paramObject);
    AppMethodBeat.o(121210);
    return paramObject;
  }
  
  public final Set<View> bY(Object paramObject)
  {
    AppMethodBeat.i(121211);
    paramObject = this.jld.cE(paramObject);
    AppMethodBeat.o(121211);
    return paramObject;
  }
  
  public final boolean d(Object paramObject, View paramView)
  {
    AppMethodBeat.i(121208);
    boolean bool = this.jld.h(paramObject, paramView);
    AppMethodBeat.o(121208);
    return bool;
  }
  
  public final boolean e(Object paramObject, View paramView)
  {
    AppMethodBeat.i(121209);
    boolean bool = this.jld.B(paramObject, paramView);
    AppMethodBeat.o(121209);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.a
 * JD-Core Version:    0.7.0.1
 */