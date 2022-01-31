package com.tencent.mm.ipcinvoker.wx_extension;

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
    super.a(paramd);
    paramd.a(PluginIPC.a.dHn);
  }
  
  public final void a(com.tencent.mm.ipcinvoker.a.e parame)
  {
    super.a(parame);
    parame.a(new d());
    parame.a(new a());
    parame.a(new e());
  }
  
  public final void b(com.tencent.mm.ipcinvoker.a.d paramd)
  {
    paramd.c("com.tencent.mm", MainProcessIPCService.class);
    paramd.c("com.tencent.mm:tools", ToolsProcessIPCService.class);
    paramd.c("com.tencent.mm:toolsmp", ToolsMpProcessIPCService.class);
    paramd.c("com.tencent.mm:support", SupportProcessIPCService.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.1
 * JD-Core Version:    0.7.0.1
 */