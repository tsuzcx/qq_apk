package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.dv;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONObject;

final class ExdeviceWCLanSDKUtil$3
  implements j.a
{
  ExdeviceWCLanSDKUtil$3(ExdeviceWCLanSDKUtil paramExdeviceWCLanSDKUtil) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    dv localdv2 = null;
    AppMethodBeat.i(19286);
    if ((paramInt != 13) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof String)) || (!(paramVarArgs[1] instanceof Integer)))
    {
      AppMethodBeat.o(19286);
      return;
    }
    Object localObject = (String)paramVarArgs[0];
    paramInt = ((Integer)paramVarArgs[1]).intValue();
    for (;;)
    {
      try
      {
        localObject = new JSONObject(new String((String)localObject));
        paramVarArgs = ((JSONObject)localObject).getString("deviceId");
        ab.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", localException1, "", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject = ((JSONObject)localObject).getString("deviceType");
          switch (paramInt)
          {
          default: 
            this.lFe.lFd = 0;
            this.lFe.lEE.put(paramVarArgs, Boolean.FALSE);
            ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
            if (this.lFe.lFc)
            {
              if (this.lFe.lFd == 2) {
                this.lFe.n(true, paramVarArgs);
              }
              localdv2 = new dv();
              localdv2.crI.bYu = paramVarArgs;
              localdv2.crI.crJ = this.lFe.lFd;
              localdv2.crI.cqQ = ((String)localObject);
              a.ymk.l(localdv2);
            }
            AppMethodBeat.o(19286);
            return;
          }
        }
        catch (Exception localException2)
        {
          dv localdv1;
          break label238;
        }
        localException1 = localException1;
        paramVarArgs = null;
      }
      label238:
      ab.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
      localdv1 = localdv2;
      continue;
      this.lFe.lFd = 2;
      this.lFe.lEE.put(paramVarArgs, Boolean.TRUE);
      ab.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.3
 * JD-Core Version:    0.7.0.1
 */