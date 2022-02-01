package com.tencent.mm.plugin.m.a.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.m.a.a.b.b;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.l;
import d.v;
import io.flutter.plugin.a.k.d;
import java.util.List;
import java.util.Map;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/VideoComponentEventHandler;", "Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/IMethodCallHandler;", "renderViewManager", "Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;", "(Lcom/tencent/mm/plugin/luggage/natives/flutter/renderview/RenderViewManager;)V", "onHandle", "", "methodCall", "Lio/flutter/plugin/common/MethodCall;", "result", "Lio/flutter/plugin/common/MethodChannel$Result;", "onMethodNameToHandle", "", "", "Companion", "luggage-native-view_release"})
public final class c
  implements a
{
  public static final a uzR;
  private final b uzs;
  
  static
  {
    AppMethodBeat.i(123833);
    uzR = new a((byte)0);
    AppMethodBeat.o(123833);
  }
  
  public c(b paramb)
  {
    AppMethodBeat.i(123832);
    this.uzs = paramb;
    AppMethodBeat.o(123832);
  }
  
  public final boolean b(io.flutter.plugin.a.j paramj, k.d paramd)
  {
    AppMethodBeat.i(123830);
    k.h(paramj, "methodCall");
    k.h(paramd, "result");
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
          ac.i("VideoComponentEventHandler", "exitFullScreen");
          paramj = paramj.fXJ;
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
          ac.i("VideoComponentEventHandler", "enterFullScreen");
          paramj = paramj.fXJ;
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
          paramj = this.uzs;
          long l = i;
          paramd = paramj.uzU.get(Long.valueOf(l));
          if (paramd == null) {
            k.fOy();
          }
          ((com.tencent.mm.plugin.m.a.a.b.a)paramd).bjx();
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
          paramj = this.uzs;
          l = i;
          paramd = paramj.uzU.get(Long.valueOf(l));
          if (paramd == null) {
            k.fOy();
          }
          ((com.tencent.mm.plugin.m.a.a.b.a)paramd).cWw();
          paramj.d((com.tencent.mm.plugin.m.a.a.b.a)paramd);
        }
        break;
      }
    }
  }
  
  public final List<String> daF()
  {
    AppMethodBeat.i(123831);
    List localList = d.a.j.listOf(new String[] { "enterFullScreen", "exitFullScreen" });
    AppMethodBeat.o(123831);
    return localList;
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/event/VideoComponentEventHandler$Companion;", "", "()V", "METHOD_ENTER_FULLSCREEN", "", "METHOD_EXIT_FULLSCREEN", "TAG", "luggage-native-view_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a.a.c
 * JD-Core Version:    0.7.0.1
 */