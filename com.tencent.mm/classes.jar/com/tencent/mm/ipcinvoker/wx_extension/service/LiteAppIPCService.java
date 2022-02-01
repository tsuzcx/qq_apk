package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ipcinvoker/wx_extension/service/LiteAppIPCService;", "Lcom/tencent/mm/ipcinvoker/BaseIPCService;", "()V", "getProcessName", "", "Companion", "lib-ipcinvoker-wx-extension_release"})
public final class LiteAppIPCService
  extends BaseIPCService
{
  private static String TAG;
  private static final String cTJ = "com.tencent.mm:lite";
  public static final a gyu;
  
  static
  {
    AppMethodBeat.i(189792);
    gyu = new a((byte)0);
    TAG = "MicroMsg.LiteAppIPCService";
    cTJ = "com.tencent.mm:lite";
    AppMethodBeat.o(189792);
  }
  
  public final String getProcessName()
  {
    return cTJ;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/ipcinvoker/wx_extension/service/LiteAppIPCService$Companion;", "", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "setTAG", "(Ljava/lang/String;)V", "invokeAsyncToLiteApp", "", "T", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "InputType", "ResultType", "Landroid/os/Parcelable;", "data", "taskClass", "Ljava/lang/Class;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "(Landroid/os/Parcelable;Ljava/lang/Class;Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;)Z", "lib-ipcinvoker-wx-extension_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService
 * JD-Core Version:    0.7.0.1
 */