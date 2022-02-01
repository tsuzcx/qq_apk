package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ipcinvoker/wx_extension/service/LiteAppIPCService;", "Lcom/tencent/mm/ipcinvoker/BaseIPCService;", "()V", "getProcessName", "", "Companion", "lib-ipcinvoker-wx-extension_release"})
public final class LiteAppIPCService
  extends BaseIPCService
{
  private static String TAG;
  private static final String dkO;
  public static final a hnQ;
  
  static
  {
    AppMethodBeat.i(225244);
    hnQ = new a((byte)0);
    TAG = "MicroMsg.LiteAppIPCService";
    dkO = MMApplicationContext.getPackageName() + ":lite";
    AppMethodBeat.o(225244);
  }
  
  public final String getProcessName()
  {
    return dkO;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/ipcinvoker/wx_extension/service/LiteAppIPCService$Companion;", "", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "setTAG", "(Ljava/lang/String;)V", "invokeAsyncToLiteApp", "", "T", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "InputType", "ResultType", "Landroid/os/Parcelable;", "data", "taskClass", "Ljava/lang/Class;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "(Landroid/os/Parcelable;Ljava/lang/Class;Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;)Z", "invokeSyncToLiteApp", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "(Landroid/os/Parcelable;Ljava/lang/Class;)Landroid/os/Parcelable;", "lib-ipcinvoker-wx-extension_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService
 * JD-Core Version:    0.7.0.1
 */