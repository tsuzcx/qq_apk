package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.z.h;
import java.util.Map;
import java.util.Set;

final class a
  implements e
{
  private final h<Object, View> kfB;
  
  a()
  {
    AppMethodBeat.i(121207);
    this.kfB = new h();
    AppMethodBeat.o(121207);
  }
  
  public final Map<Object, Set<View>> aDD()
  {
    AppMethodBeat.i(121212);
    Map localMap = this.kfB.bBn();
    AppMethodBeat.o(121212);
    return localMap;
  }
  
  public final Set<View> bX(Object paramObject)
  {
    AppMethodBeat.i(121210);
    paramObject = this.kfB.cE(paramObject);
    AppMethodBeat.o(121210);
    return paramObject;
  }
  
  public final Set<View> bY(Object paramObject)
  {
    AppMethodBeat.i(121211);
    paramObject = this.kfB.cF(paramObject);
    AppMethodBeat.o(121211);
    return paramObject;
  }
  
  public final boolean d(Object paramObject, View paramView)
  {
    AppMethodBeat.i(121208);
    boolean bool = this.kfB.j(paramObject, paramView);
    AppMethodBeat.o(121208);
    return bool;
  }
  
  public final boolean e(Object paramObject, View paramView)
  {
    AppMethodBeat.i(121209);
    boolean bool = this.kfB.D(paramObject, paramView);
    AppMethodBeat.o(121209);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.a
 * JD-Core Version:    0.7.0.1
 */