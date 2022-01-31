package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.c;
import com.tencent.mm.plugin.appbrand.s.i;
import java.util.Map;
import java.util.Set;

final class a
  implements c
{
  private final i<Object, View> hnV;
  
  a()
  {
    AppMethodBeat.i(10726);
    this.hnV = new i();
    AppMethodBeat.o(10726);
  }
  
  public final Set<View> aS(Object paramObject)
  {
    AppMethodBeat.i(10729);
    paramObject = this.hnV.br(paramObject);
    AppMethodBeat.o(10729);
    return paramObject;
  }
  
  public final Set<View> aT(Object paramObject)
  {
    AppMethodBeat.i(10730);
    paramObject = this.hnV.bs(paramObject);
    AppMethodBeat.o(10730);
    return paramObject;
  }
  
  public final Map<Object, Set<View>> acj()
  {
    AppMethodBeat.i(141924);
    Map localMap = this.hnV.aNQ();
    AppMethodBeat.o(141924);
    return localMap;
  }
  
  public final boolean d(Object paramObject, View paramView)
  {
    AppMethodBeat.i(10727);
    boolean bool = this.hnV.s(paramObject, paramView);
    AppMethodBeat.o(10727);
    return bool;
  }
  
  public final boolean e(Object paramObject, View paramView)
  {
    AppMethodBeat.i(10728);
    boolean bool = this.hnV.t(paramObject, paramView);
    AppMethodBeat.o(10728);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.dynamic.a.a
 * JD-Core Version:    0.7.0.1
 */