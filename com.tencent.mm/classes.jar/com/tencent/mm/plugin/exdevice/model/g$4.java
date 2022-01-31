package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.h.c.cc;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

final class g$4
  implements j.a
{
  g$4(g paramg) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt != 14) || (paramVarArgs == null) || (paramVarArgs.length <= 0) || (!(paramVarArgs[0] instanceof byte[]))) {
      return;
    }
    paramVarArgs = (byte[])paramVarArgs[0];
    try
    {
      localJSONObject1 = new JSONObject(new String(paramVarArgs));
      localJSONObject2 = localJSONObject1.getJSONObject("deviceInfo");
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        JSONObject localJSONObject1;
        label98:
        Object localObject;
        label335:
        JSONObject localJSONObject2 = null;
        paramVarArgs = null;
        str = null;
      }
    }
    try
    {
      str = localJSONObject2.getString("deviceType");
    }
    catch (Exception localException3)
    {
      paramVarArgs = null;
      str = null;
      break label98;
    }
    try
    {
      paramVarArgs = localJSONObject2.getString("deviceId");
      try
      {
        if (!localJSONObject1.isNull("profile")) {
          break label335;
        }
        y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "json have not profile, return");
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException4)
    {
      paramVarArgs = null;
      break label98;
    }
    y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode failed in discover package callback %s", new Object[] { localException1 });
    for (localObject = localJSONObject2;; localObject = localJSONObject2)
    {
      if ((str != null) && (paramVarArgs != null)) {
        y.i("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package deviceType %s, deviceId %s", new Object[] { str, paramVarArgs });
      }
      int i = this.jvq.jvb.size();
      paramInt = 0;
      while (paramInt < i)
      {
        if ((((b)this.jvq.jvb.get(paramInt)).field_deviceID.equals(paramVarArgs)) && (((b)this.jvq.jvb.get(paramInt)).field_deviceType.equals(str)) && (((b)this.jvq.jvb.get(paramInt)).cMZ.contains("wechat_to_device")) && (!this.jvq.jvc.contains(this.jvq.jvb.get(paramInt))))
        {
          this.jvq.jvd.put(paramVarArgs, localObject.toString());
          this.jvq.jvc.add(this.jvq.jvb.get(paramInt));
          g.bd(this.jvq.jvc);
        }
        paramInt += 1;
      }
      break;
      y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "discover package profiles %s", new Object[] { localObject.getJSONArray("profile").toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.4
 * JD-Core Version:    0.7.0.1
 */