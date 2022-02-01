package com.tencent.mm.plugin.datareport.b;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class b
{
  private static View a(View paramView, com.tencent.mm.plugin.datareport.d.a.b paramb)
  {
    AppMethodBeat.i(262846);
    paramb = b(paramb);
    if (paramb != null)
    {
      AppMethodBeat.o(262846);
      return paramb;
    }
    paramView = paramView.getParent();
    if ((paramView instanceof View))
    {
      paramView = (View)paramView;
      AppMethodBeat.o(262846);
      return paramView;
    }
    AppMethodBeat.o(262846);
    return null;
  }
  
  private static View b(com.tencent.mm.plugin.datareport.d.a.b paramb)
  {
    AppMethodBeat.i(262853);
    if (paramb == null)
    {
      AppMethodBeat.o(262853);
      return null;
    }
    if (paramb.xhj == null)
    {
      AppMethodBeat.o(262853);
      return null;
    }
    paramb = (View)paramb.xhj.get();
    AppMethodBeat.o(262853);
    return paramb;
  }
  
  public static a eH(Object paramObject)
  {
    AppMethodBeat.i(262838);
    if ((paramObject == null) || (!(paramObject instanceof View)))
    {
      AppMethodBeat.o(262838);
      return null;
    }
    a locala = new a();
    paramObject = (View)paramObject;
    Object localObject = paramObject.getContext();
    if (localObject != null)
    {
      com.tencent.mm.plugin.datareport.a.dtn();
      if (com.tencent.mm.plugin.datareport.a.eF(localObject)) {}
    }
    else
    {
      AppMethodBeat.o(262838);
      return null;
    }
    if (com.tencent.mm.plugin.datareport.d.a.eM(localObject)) {
      locala.eG(localObject);
    }
    int i = 0;
    while ((paramObject != null) && (i < 100))
    {
      localObject = com.tencent.mm.plugin.datareport.d.a.h(paramObject, false);
      if (com.tencent.mm.plugin.datareport.d.a.eJ(paramObject)) {
        locala.a((com.tencent.mm.plugin.datareport.d.a.b)localObject);
      }
      paramObject = a(paramObject, (com.tencent.mm.plugin.datareport.d.a.b)localObject);
      i += 1;
    }
    AppMethodBeat.o(262838);
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.datareport.b.b
 * JD-Core Version:    0.7.0.1
 */