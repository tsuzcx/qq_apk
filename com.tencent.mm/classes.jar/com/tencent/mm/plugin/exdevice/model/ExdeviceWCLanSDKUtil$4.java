package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.h.a.dt;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class ExdeviceWCLanSDKUtil$4
  implements j.a
{
  ExdeviceWCLanSDKUtil$4(ExdeviceWCLanSDKUtil paramExdeviceWCLanSDKUtil) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt != 16) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof String)) || (!(paramVarArgs[1] instanceof byte[]))) {
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
        Object localObject3;
        y.printErrStackTrace("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", localException1, "", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject1).getString("deviceId");
          localObject3 = new String(arrayOfByte);
          y.i("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "receive data = " + (String)localObject3);
          localObject3 = new dt();
          ((dt)localObject3).bKq.bwK = ((String)localObject1);
          ((dt)localObject3).bKq.data = arrayOfByte;
          ((dt)localObject3).bKq.bJw = paramVarArgs;
          a.udP.m((b)localObject3);
          return;
        }
        catch (Exception localException2)
        {
          Object localObject2;
          break label166;
        }
        localException1 = localException1;
        paramVarArgs = null;
      }
      label166:
      y.e("MicroMsg.exdevice.ExdeviceWCLanSDKUtil", "JSON decode failed in receive notify callback");
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.ExdeviceWCLanSDKUtil.4
 * JD-Core Version:    0.7.0.1
 */