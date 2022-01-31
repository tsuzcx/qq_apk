package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.h.a.ds;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONObject;

final class ExdeviceWCLanSDKUtil$3
  implements j.a
{
  ExdeviceWCLanSDKUtil$3(ExdeviceWCLanSDKUtil paramExdeviceWCLanSDKUtil) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    ds localds2 = null;
    if ((paramInt != 13) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof String)) || (!(paramVarArgs[1] instanceof Integer))) {
      label37:
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
      }
      catch (Exception localException1)
      {
        try
        {
          localObject = ((JSONObject)localObject).getString("deviceType");
          switch (paramInt)
          {
          default: 
            this.jvF.jvE = 0;
            this.jvF.jvf.put(paramVarArgs, Boolean.valueOf(false));
            y.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device disconnect!");
            if (!this.jvF.jvD) {
              break label37;
            }
            if (this.jvF.jvE == 2) {
              this.jvF.i(true, paramVarArgs);
            }
            localds2 = new ds();
            localds2.bKo.bwK = paramVarArgs;
            localds2.bKo.bKp = this.jvF.jvE;
            localds2.bKo.bJw = ((String)localObject);
            a.udP.m(localds2);
            return;
          }
        }
        catch (Exception localException2)
        {
          ds localds1;
          break label221;
        }
        localException1 = localException1;
        paramVarArgs = null;
      }
      label221:
      y.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", localException1, "", new Object[0]);
      y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in device ConnState notify callback");
      localds1 = localds2;
      continue;
      this.jvF.jvE = 2;
      this.jvF.jvf.put(paramVarArgs, Boolean.valueOf(true));
      y.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "device connect!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.3
 * JD-Core Version:    0.7.0.1
 */