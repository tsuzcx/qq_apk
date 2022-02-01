package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.appcache.b.c;
import d.g.a.a;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/jsapi/TaskCallPredownload;", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/plugin/appbrand/jsapi/TaskParamsCallPredownload;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "()V", "invoke", "", "data", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "plugin-appbrand-integration_release"})
final class cm
  implements b<TaskParamsCallPredownload, IPCVoid>
{
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    public static final a kys;
    
    static
    {
      AppMethodBeat.i(50420);
      kys = new a();
      AppMethodBeat.o(50420);
    }
    
    a()
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(String paramString1, String paramString2, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(50421);
      c.a(new c(this.gTN, this.kyt, this.hVL), true, 2);
      AppMethodBeat.o(50421);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cm
 * JD-Core Version:    0.7.0.1
 */