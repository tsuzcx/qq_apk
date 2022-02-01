package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ipcinvoker/wx_extension/service/LiteAppIPCService;", "Lcom/tencent/mm/ipcinvoker/BaseIPCService;", "()V", "getProcessName", "", "Companion", "lib-ipcinvoker-wx-extension_release"})
public final class LiteAppIPCService
  extends BaseIPCService
{
  private static final String PROCESS_NAME;
  private static String TAG;
  public static final a jZH;
  
  static
  {
    AppMethodBeat.i(205216);
    jZH = new a((byte)0);
    TAG = "MicroMsg.LiteAppIPCService";
    PROCESS_NAME = MMApplicationContext.getPackageName() + ":lite";
    AppMethodBeat.o(205216);
  }
  
  public final String getProcessName()
  {
    return PROCESS_NAME;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/ipcinvoker/wx_extension/service/LiteAppIPCService$Companion;", "", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "setTAG", "(Ljava/lang/String;)V", "invokeAsyncToLiteApp", "", "T", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "InputType", "ResultType", "Landroid/os/Parcelable;", "data", "taskClass", "Ljava/lang/Class;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "(Landroid/os/Parcelable;Ljava/lang/Class;Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;)Z", "invokeSyncToLiteApp", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "(Landroid/os/Parcelable;Ljava/lang/Class;)Landroid/os/Parcelable;", "lib-ipcinvoker-wx-extension_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService
 * JD-Core Version:    0.7.0.1
 */