package com.tencent.mm.plugin.appbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/PreRenderIDKeyReport;", "", "()V", "ID", "", "KEY_TASK_COMPLETE", "KEY_TASK_FAIL_ALREADY_ALIVE", "KEY_TASK_FAIL_BIND_REMOTE_SERVICE_FAIL", "KEY_TASK_FAIL_CREATE_RUNTIME_FAILED", "KEY_TASK_FAIL_GET_ATTRS_FAIL", "KEY_TASK_FAIL_INVALID_PARAMS", "KEY_TASK_FAIL_REMOTE_SERVICE_DIED", "KEY_TASK_FAIL_RESOURCE_PREPARE_FAIL", "KEY_TASK_FAIL_UNSUPPORTED", "KEY_TASK_START", "codeToKey", "code", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class az
{
  public static final az qxZ;
  
  static
  {
    AppMethodBeat.i(316624);
    qxZ = new az();
    AppMethodBeat.o(316624);
  }
  
  public static int yX(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 10000;
    case 0: 
      return 1;
    case -1: 
      return 2;
    case -2: 
      return 3;
    case -3: 
      return 4;
    case -4: 
      return 5;
    case -5: 
      return 6;
    case -6: 
      return 7;
    case -7: 
      return 8;
    }
    return 9;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.az
 * JD-Core Version:    0.7.0.1
 */