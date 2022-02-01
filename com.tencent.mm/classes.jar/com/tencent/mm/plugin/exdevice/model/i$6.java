package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONObject;

final class i$6
  implements l.a
{
  i$6(i parami) {}
  
  public final void h(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23324);
    if ((paramInt != 13) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof String)) || (!(paramVarArgs[1] instanceof Integer)))
    {
      AppMethodBeat.o(23324);
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
        Log.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", localException, "", new Object[0]);
        Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
      }
      i.g(this.yrv).put(paramVarArgs, Boolean.FALSE);
      Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(23324);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(23324);
      return;
      i.g(this.yrv).put(paramVarArgs, Boolean.TRUE);
      Log.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i.6
 * JD-Core Version:    0.7.0.1
 */