package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand1IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand2IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand3IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand4IPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.SupportProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;

final class PluginIPC$1
  extends com.tencent.mm.ipcinvoker.a.a
{
  PluginIPC$1(PluginIPC paramPluginIPC) {}
  
  public final void a(com.tencent.mm.ipcinvoker.a.d paramd)
  {
    AppMethodBeat.i(126203);
    super.a(paramd);
    paramd.a(PluginIPC.a.eEQ);
    AppMethodBeat.o(126203);
  }
  
  public final void a(com.tencent.mm.ipcinvoker.a.e parame)
  {
    AppMethodBeat.i(126204);
    super.a(parame);
    parame.a(new d());
    parame.a(new a());
    parame.a(new e());
    AppMethodBeat.o(126204);
  }
  
  public final void b(com.tencent.mm.ipcinvoker.a.d paramd)
  {
    AppMethodBeat.i(126205);
    paramd.b("com.tencent.mm", MainProcessIPCService.class);
    paramd.b("com.tencent.mm:tools", ToolsProcessIPCService.class);
    paramd.b("com.tencent.mm:toolsmp", ToolsMpProcessIPCService.class);
    paramd.b("com.tencent.mm:support", SupportProcessIPCService.class);
    paramd.b("com.tencent.mm:appbrand0", Appbrand0IPCService.class);
    paramd.b("com.tencent.mm:appbrand1", Appbrand1IPCService.class);
    paramd.b("com.tencent.mm:appbrand2", Appbrand2IPCService.class);
    paramd.b("com.tencent.mm:appbrand3", Appbrand3IPCService.class);
    paramd.b("com.tencent.mm:appbrand4", Appbrand4IPCService.class);
    AppMethodBeat.o(126205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.1
 * JD-Core Version:    0.7.0.1
 */