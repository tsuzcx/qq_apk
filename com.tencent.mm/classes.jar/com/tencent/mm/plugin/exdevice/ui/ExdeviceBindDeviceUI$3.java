package com.tencent.mm.plugin.exdevice.ui;

import android.util.Base64;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONObject;

final class ExdeviceBindDeviceUI$3
  implements j.a
{
  ExdeviceBindDeviceUI$3(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt != 10) || (paramVarArgs == null)) {
      return;
    }
    paramVarArgs = (byte[])paramVarArgs[0];
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(new String(paramVarArgs));
        localObject1 = localJSONObject.getJSONObject("deviceInfo");
        paramVarArgs = ((JSONObject)localObject1).getString("deviceType");
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          try
          {
            localObject1 = ((JSONObject)localObject1).getString("deviceId");
            localObject2 = localObject1;
            arrayOfObject1 = paramVarArgs;
          }
          catch (Exception localException2)
          {
            JSONObject localJSONObject;
            Object localObject2;
            Object[] arrayOfObject1;
            Object[] arrayOfObject2;
            Object localObject1 = null;
            continue;
          }
          try
          {
            if (localJSONObject.isNull("manufacturerData")) {
              continue;
            }
            localObject2 = localJSONObject.getString("manufacturerData");
            arrayOfObject1 = paramVarArgs;
            paramVarArgs = (Object[])localObject2;
            if ((arrayOfObject1 == null) || (localObject1 == null)) {
              break;
            }
            localObject2 = new ExdeviceBindDeviceUI.f(this.jBw, (byte)0);
            ((ExdeviceBindDeviceUI.f)localObject2).jBQ = ExdeviceBindDeviceUI.b.jBH;
            ((ExdeviceBindDeviceUI.f)localObject2).jBS = new ExdeviceBindDeviceUI.d(this.jBw, (byte)0);
            ((ExdeviceBindDeviceUI.f)localObject2).jBS.jAa = arrayOfObject1;
            ((ExdeviceBindDeviceUI.f)localObject2).jBS.juM = ((String)localObject1);
            if (bk.bl(paramVarArgs)) {
              continue;
            }
            ((ExdeviceBindDeviceUI.f)localObject2).jBX = Base64.encodeToString(paramVarArgs.getBytes(), 2);
            y.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[] { ((ExdeviceBindDeviceUI.f)localObject2).jBX });
            ai.d(new ExdeviceBindDeviceUI.3.1(this, (ExdeviceBindDeviceUI.f)localObject2));
            return;
          }
          catch (Exception localException3) {}
        }
        localException1 = localException1;
        localObject1 = null;
        paramVarArgs = null;
      }
      y.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", localException1, "", new Object[0]);
      y.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
      arrayOfObject2 = paramVarArgs;
      localObject2 = localObject1;
      paramVarArgs = null;
      localObject1 = localObject2;
      continue;
      ((ExdeviceBindDeviceUI.f)localObject2).jBX = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.3
 * JD-Core Version:    0.7.0.1
 */