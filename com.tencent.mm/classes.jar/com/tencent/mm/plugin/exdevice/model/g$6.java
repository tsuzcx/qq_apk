package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import org.json.JSONObject;

final class g$6
  implements j.a
{
  g$6(g paramg) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
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
        ae.printErrStackTrace("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", localException, "", new Object[0]);
        ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in device ConnState notify callback");
      }
      this.qiW.qiL.put(paramVarArgs, Boolean.FALSE);
      ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device not connect stateCode = ".concat(String.valueOf(paramInt)));
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
      this.qiW.qiL.put(paramVarArgs, Boolean.TRUE);
      ae.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "device connect");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.6
 * JD-Core Version:    0.7.0.1
 */