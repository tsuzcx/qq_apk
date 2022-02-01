package com.tencent.mm.plugin.appbrand.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "ErrCode", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
{
  public abstract void onError(int paramInt, String paramString);
  
  public abstract void onSuccess();
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback$ErrCode;", "", "()V", "ERR_INVALID_PARAMS", "", "ERR_TASK_ALREADY_ALIVE", "ERR_TASK_BIND_REMOTE_SERVICE_FAIL", "ERR_TASK_CREATE_RUNTIME_FAILED", "ERR_TASK_GET_ATTRS_FAIL", "ERR_TASK_LOAD_MODULE_FAILED", "ERR_TASK_REMOTE_SERVICE_DIED", "ERR_TASK_RESOURCE_PREPARE_FAIL", "ERR_TASK_UNSUPPORTED", "OK", "codeToString", "", "code", "api-protocol_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
  {
    public static final b qAE;
    
    static
    {
      AppMethodBeat.i(319296);
      qAE = new b();
      AppMethodBeat.o(319296);
    }
    
    public static String zh(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "UNKNOWN";
      case 0: 
        return "OK";
      case -1: 
        return "ERR_INVALID_PARAMS";
      case -2: 
        return "ERR_TASK_ALREADY_ALIVE";
      case -3: 
        return "ERR_TASK_GET_ATTRS_FAIL";
      case -4: 
        return "ERR_TASK_BIND_REMOTE_SERVICE_FAIL";
      case -5: 
        return "ERR_TASK_REMOTE_SERVICE_DIED";
      case -6: 
        return "ERR_TASK_CREATE_RUNTIME_FAILED";
      case -7: 
        return "ERR_TASK_RESOURCE_PREPARE_FAIL";
      case -8: 
        return "ERR_TASK_UNSUPPORTED";
      }
      return "ERR_TASK_LOAD_MODULE_FAILED";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.f
 * JD-Core Version:    0.7.0.1
 */