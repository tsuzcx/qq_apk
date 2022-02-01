package com.tencent.mm.plugin.m.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import d.v;
import io.flutter.plugin.a.k.d;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/RenderViewStatsHandler;", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/IMethodCallHandler;", "renderViewManager", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "(Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;)V", "onHandle", "", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onMethodNameToHandle", "", "", "Companion", "luggage-native-view_release"})
public final class b
  implements a
{
  public static final a uzQ;
  private final com.tencent.mm.plugin.m.a.a.b.b uzs;
  
  static
  {
    AppMethodBeat.i(123829);
    uzQ = new a((byte)0);
    AppMethodBeat.o(123829);
  }
  
  public b(com.tencent.mm.plugin.m.a.a.b.b paramb)
  {
    AppMethodBeat.i(123828);
    this.uzs = paramb;
    AppMethodBeat.o(123828);
  }
  
  public final boolean b(io.flutter.plugin.a.j paramj, k.d paramd)
  {
    AppMethodBeat.i(123826);
    k.h(paramj, "methodCall");
    k.h(paramd, "result");
    paramd = paramj.method;
    if (paramd == null) {}
    for (;;)
    {
      AppMethodBeat.o(123826);
      return false;
      switch (paramd.hashCode())
      {
      default: 
        break;
      case 790315414: 
        if (paramd.equals("onRenderViewShowed"))
        {
          if (!(paramj.fXJ instanceof Map))
          {
            paramj = (Throwable)new IllegalArgumentException();
            AppMethodBeat.o(123826);
            throw paramj;
          }
          paramd = paramj.fXJ;
          if (paramd == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            AppMethodBeat.o(123826);
            throw paramj;
          }
          paramd = ((Map)paramd).get("newViewId");
          paramj = paramj.fXJ;
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            AppMethodBeat.o(123826);
            throw paramj;
          }
          Object localObject = ((Map)paramj).get("oldViewId");
          paramj = this.uzs;
          if (paramd == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(123826);
            throw paramj;
          }
          int i = ((Integer)paramd).intValue();
          if (localObject == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(123826);
            throw paramj;
          }
          ((Integer)localObject).intValue();
          paramd = (com.tencent.mm.plugin.m.a.a.b.a)paramj.uzU.get(Long.valueOf(i));
          if (paramd != null) {}
          for (i = 1; i == 0; i = 0)
          {
            paramj = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
            AppMethodBeat.o(123826);
            throw paramj;
          }
          paramj.d(paramd);
          paramd.onShow();
        }
        break;
      }
    }
  }
  
  public final List<String> daF()
  {
    AppMethodBeat.i(123827);
    List localList = d.a.j.listOf("onRenderViewShowed");
    AppMethodBeat.o(123827);
    return localList;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/RenderViewStatsHandler$Companion;", "", "()V", "METHOD_ON_RENDER_VIEW_SHOWED", "", "luggage-native-view_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */