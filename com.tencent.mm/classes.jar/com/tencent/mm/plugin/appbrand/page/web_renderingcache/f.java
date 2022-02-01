package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"invokeMMAsync", "", "T", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "p", "(Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Ljava/lang/Object;)V", "plugin-appbrand-integration_release"})
public final class f
{
  public static final <T> void a(b<T, IPCVoid> paramb, T paramT)
  {
    AppMethodBeat.i(50984);
    k.h(paramb, "$this$invokeMMAsync");
    XIPCInvoker.a("com.tencent.mm", paramT, paramb.getClass(), null);
    AppMethodBeat.o(50984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.f
 * JD-Core Version:    0.7.0.1
 */