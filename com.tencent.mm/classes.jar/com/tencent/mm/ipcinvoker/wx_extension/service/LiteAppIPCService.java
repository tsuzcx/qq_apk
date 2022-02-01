package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/ipcinvoker/wx_extension/service/LiteAppIPCService;", "Lcom/tencent/mm/ipcinvoker/BaseIPCService;", "()V", "getProcessName", "", "Companion", "lib-ipcinvoker-wx-extension_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiteAppIPCService
  extends BaseIPCService
{
  private static final String PROCESS_NAME;
  private static String TAG;
  public static final a mzL;
  
  static
  {
    AppMethodBeat.i(235724);
    mzL = new a((byte)0);
    TAG = "MicroMsg.LiteAppIPCService";
    PROCESS_NAME = s.X(MMApplicationContext.getPackageName(), ":lite");
    AppMethodBeat.o(235724);
  }
  
  public final String getProcessName()
  {
    return PROCESS_NAME;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/ipcinvoker/wx_extension/service/LiteAppIPCService$Companion;", "", "()V", "PROCESS_NAME", "", "getPROCESS_NAME", "()Ljava/lang/String;", "TAG", "getTAG", "setTAG", "(Ljava/lang/String;)V", "invokeAsyncToLiteApp", "", "T", "Lcom/tencent/mm/ipcinvoker/IPCAsyncInvokeTask;", "InputType", "ResultType", "Landroid/os/Parcelable;", "data", "taskClass", "Ljava/lang/Class;", "callback", "Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;", "(Landroid/os/Parcelable;Ljava/lang/Class;Lcom/tencent/mm/ipcinvoker/IPCInvokeCallback;)Z", "invokeSyncToLiteApp", "Lcom/tencent/mm/ipcinvoker/IPCSyncInvokeTask;", "(Landroid/os/Parcelable;Ljava/lang/Class;)Landroid/os/Parcelable;", "lib-ipcinvoker-wx-extension_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.LiteAppIPCService
 * JD-Core Version:    0.7.0.1
 */