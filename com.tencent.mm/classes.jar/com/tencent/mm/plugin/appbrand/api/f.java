package com.tencent.mm.plugin.appbrand.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback;", "", "onError", "", "errCode", "", "errMsg", "", "onSuccess", "ErrCode", "api-protocol_release"})
public abstract interface f
{
  public abstract void onError(int paramInt, String paramString);
  
  public abstract void onSuccess();
  
  @l(hxD={1, 1, 16})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/api/PreRenderColdStartResultCallback$ErrCode;", "", "()V", "ERR_INVALID_PARAMS", "", "ERR_TASK_ALREADY_ALIVE", "ERR_TASK_BIND_REMOTE_SERVICE_FAIL", "ERR_TASK_CREATE_RUNTIME_FAILED", "ERR_TASK_GET_ATTRS_FAIL", "ERR_TASK_REMOTE_SERVICE_DIED", "ERR_TASK_RESOURCE_PREPARE_FAIL", "ERR_TASK_UNSUPPORTED", "OK", "codeToString", "", "code", "api-protocol_release"})
  public static final class b
  {
    public static final b kHv;
    
    static
    {
      AppMethodBeat.i(194314);
      kHv = new b();
      AppMethodBeat.o(194314);
    }
    
    public static String vM(int paramInt)
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
      }
      return "ERR_TASK_UNSUPPORTED";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.api.f
 * JD-Core Version:    0.7.0.1
 */