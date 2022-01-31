package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

final class g$6
  implements j.a
{
  g$6(g paramg) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19256);
    if ((paramInt != 13) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof String)) || (!(paramVarArgs[1] instanceof Integer)))
    {
      AppMethodBeat.o(19256);
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
        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", localException, "", new Object[0]);
        ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
      }
      this.lEP.lEE.put(paramVarArgs, Boolean.FALSE);
      ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = ".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(19256);
      return;
    }
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(19256);
      return;
      this.lEP.lEE.put(paramVarArgs, Boolean.TRUE);
      ab.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.6
 * JD-Core Version:    0.7.0.1
 */