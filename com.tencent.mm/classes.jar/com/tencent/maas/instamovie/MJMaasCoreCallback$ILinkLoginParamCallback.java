package com.tencent.maas.instamovie;

import com.tencent.maas.MJMaasCore;
import com.tencent.maas.MJMaasCore.LoginParamsCallback;
import com.tencent.maas.internal.NativeCallbackManager.CallbackArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJMaasCoreCallback$ILinkLoginParamCallback
  extends MJMaasCoreCallback.BaseCallbackWithReturnValue<NativeCallbackManager.CallbackArgs>
{
  private final MJMaasCore.LoginParamsCallback loginParamsCallback;
  
  public MJMaasCoreCallback$ILinkLoginParamCallback(MJMaasCore paramMJMaasCore, MJMaasCore.LoginParamsCallback paramLoginParamsCallback)
  {
    super(paramMJMaasCore);
    this.loginParamsCallback = paramLoginParamsCallback;
  }
  
  public MJMaasCoreCallback$ILinkLoginParamCallback(MJMaasCore paramMJMaasCore, MJMaasCore.LoginParamsCallback paramLoginParamsCallback, boolean paramBoolean)
  {
    super(paramMJMaasCore, paramBoolean);
    this.loginParamsCallback = paramLoginParamsCallback;
  }
  
  public Object onInvokeWithReturnValue(MJMaasCore paramMJMaasCore, NativeCallbackManager.CallbackArgs paramCallbackArgs)
  {
    AppMethodBeat.i(216921);
    paramMJMaasCore = this.loginParamsCallback.onGetLoginParams();
    AppMethodBeat.o(216921);
    return paramMJMaasCore;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMaasCoreCallback.ILinkLoginParamCallback
 * JD-Core Version:    0.7.0.1
 */