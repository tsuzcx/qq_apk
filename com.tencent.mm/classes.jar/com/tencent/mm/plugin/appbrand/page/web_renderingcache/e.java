package com.tencent.mm.plugin.appbrand.page.web_renderingcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"invokeMMAsync", "", "T", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "Lcom/tencent/mm/ipcinvoker/type/IPCVoid;", "p", "(Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;Ljava/lang/Object;)V", "plugin-appbrand-integration_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class e
{
  public static final <T> void a(d<T, IPCVoid> paramd, T paramT)
  {
    AppMethodBeat.i(50984);
    s.u(paramd, "<this>");
    XIPCInvoker.a(MainProcessIPCService.PROCESS_NAME, paramT, paramd.getClass(), null);
    AppMethodBeat.o(50984);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.web_renderingcache.e
 * JD-Core Version:    0.7.0.1
 */