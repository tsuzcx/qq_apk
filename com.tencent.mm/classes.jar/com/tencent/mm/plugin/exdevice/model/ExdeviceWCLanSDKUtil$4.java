package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dw;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

final class ExdeviceWCLanSDKUtil$4
  implements j.a
{
  ExdeviceWCLanSDKUtil$4(ExdeviceWCLanSDKUtil paramExdeviceWCLanSDKUtil) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19287);
    if ((paramInt != 16) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof String)) || (!(paramVarArgs[1] instanceof byte[])))
    {
      AppMethodBeat.o(19287);
      return;
    }
    Object localObject1 = (String)paramVarArgs[0];
    byte[] arrayOfByte = (byte[])paramVarArgs[1];
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(new String((String)localObject1));
        paramVarArgs = ((JSONObject)localObject1).getString("deviceType");
        dw localdw;
        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", localException1, "", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject1).getString("deviceId");
          ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = ".concat(String.valueOf(new String(arrayOfByte))));
          localdw = new dw();
          localdw.crK.bYu = ((String)localObject1);
          localdw.crK.data = arrayOfByte;
          localdw.crK.cqQ = paramVarArgs;
          a.ymk.l(localdw);
          AppMethodBeat.o(19287);
          return;
        }
        catch (Exception localException2)
        {
          Object localObject2;
          break label173;
        }
        localException1 = localException1;
        paramVarArgs = null;
      }
      label173:
      ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.4
 * JD-Core Version:    0.7.0.1
 */