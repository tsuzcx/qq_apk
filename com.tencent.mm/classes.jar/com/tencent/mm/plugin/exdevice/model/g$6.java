package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONObject;

final class g$6
  implements j.a
{
  g$6(g paramg) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt != 13) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof String)) || (!(paramVarArgs[1] instanceof Integer))) {
      return;
    }
    Object localObject = (String)paramVarArgs[0];
    paramInt = ((Integer)paramVarArgs[1]).intValue();
    String str = null;
    paramVarArgs = str;
    try
    {
      localObject = new JSONObject(new String((String)localObject));
      paramVarArgs = str;
      str = ((JSONObject)localObject).getString("deviceId");
      paramVarArgs = str;
      ((JSONObject)localObject).getString("deviceType");
      paramVarArgs = str;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", localException, "", new Object[0]);
        y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
      }
      this.jvq.jvf.put(paramVarArgs, Boolean.valueOf(true));
      y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
    }
    switch (paramInt)
    {
    default: 
    case -2: 
    case -1: 
    case 0: 
      this.jvq.jvf.put(paramVarArgs, Boolean.valueOf(false));
      y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = " + paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.6
 * JD-Core Version:    0.7.0.1
 */