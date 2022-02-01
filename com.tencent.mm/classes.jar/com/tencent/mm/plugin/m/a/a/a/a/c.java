package com.tencent.mm.plugin.m.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.m.a.a.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import io.flutter.plugin.a.k.d;
import java.util.List;
import java.util.Map;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/VideoComponentEventHandler;", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/IMethodCallHandler;", "renderViewManager", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "(Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;)V", "onHandle", "", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onMethodNameToHandle", "", "", "Companion", "luggage-native-view_release"})
public final class c
  implements a
{
  public static final c.a vCu;
  private final b vBV;
  
  static
  {
    AppMethodBeat.i(123833);
    vCu = new c.a((byte)0);
    AppMethodBeat.o(123833);
  }
  
  public c(b paramb)
  {
    AppMethodBeat.i(123832);
    this.vBV = paramb;
    AppMethodBeat.o(123832);
  }
  
  public final boolean b(io.flutter.plugin.a.j paramj, k.d paramd)
  {
    AppMethodBeat.i(123830);
    p.h(paramj, "methodCall");
    p.h(paramd, "result");
    paramd = paramj.method;
    if (paramd == null) {}
    for (;;)
    {
      AppMethodBeat.o(123830);
      return false;
      switch (paramd.hashCode())
      {
      default: 
        break;
      case -802181223: 
        if (paramd.equals("exitFullScreen"))
        {
          ad.i("VideoComponentEventHandler", "exitFullScreen");
          paramj = paramj.grf;
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            AppMethodBeat.o(123830);
            throw paramj;
          }
        }
        break;
      case 837852371: 
        if (paramd.equals("enterFullScreen"))
        {
          ad.i("VideoComponentEventHandler", "enterFullScreen");
          paramj = paramj.grf;
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.collections.Map<*, *>");
            AppMethodBeat.o(123830);
            throw paramj;
          }
          paramj = ((Map)paramj).get("viewId");
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(123830);
            throw paramj;
          }
          int i = ((Integer)paramj).intValue();
          paramj = this.vBV;
          long l = i;
          paramd = paramj.vCx.get(Long.valueOf(l));
          if (paramd == null) {
            p.gfZ();
          }
          ((com.tencent.mm.plugin.m.a.a.b.a)paramd).bnj();
          paramj.d((com.tencent.mm.plugin.m.a.a.b.a)paramd);
          continue;
          paramj = ((Map)paramj).get("viewId");
          if (paramj == null)
          {
            paramj = new v("null cannot be cast to non-null type kotlin.Int");
            AppMethodBeat.o(123830);
            throw paramj;
          }
          i = ((Integer)paramj).intValue();
          paramj = this.vBV;
          l = i;
          paramd = paramj.vCx.get(Long.valueOf(l));
          if (paramd == null) {
            p.gfZ();
          }
          ((com.tencent.mm.plugin.m.a.a.b.a)paramd).dfI();
          paramj.d((com.tencent.mm.plugin.m.a.a.b.a)paramd);
        }
        break;
      }
    }
  }
  
  public final List<String> djS()
  {
    AppMethodBeat.i(123831);
    List localList = d.a.j.listOf(new String[] { "enterFullScreen", "exitFullScreen" });
    AppMethodBeat.o(123831);
    return localList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */