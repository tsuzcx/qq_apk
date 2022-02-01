package com.tencent.mm.plugin.exdevice.ui;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.j.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

final class ExdeviceBindDeviceUI$3
  implements j.a
{
  ExdeviceBindDeviceUI$3(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23896);
    if ((paramInt != 10) || (paramVarArgs == null))
    {
      AppMethodBeat.o(23896);
      return;
    }
    paramVarArgs = (byte[])paramVarArgs[0];
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(new String(paramVarArgs));
        localObject1 = localJSONObject.getJSONObject("deviceInfo");
        paramVarArgs = ((JSONObject)localObject1).getString("deviceType");
        Object[] arrayOfObject1;
        ad.printErrStackTrace("MicroMsg.ExdeviceBindDeviceUI", localException1, "", new Object[0]);
      }
      catch (Exception localException1)
      {
        try
        {
          localObject1 = ((JSONObject)localObject1).getString("deviceId");
          localObject2 = localObject1;
          arrayOfObject1 = paramVarArgs;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject2;
            Object[] arrayOfObject2;
            Object localObject1 = null;
          }
        }
        try
        {
          if (localJSONObject.isNull("manufacturerData")) {
            break label151;
          }
          localObject2 = localJSONObject.getString("manufacturerData");
          arrayOfObject1 = paramVarArgs;
          paramVarArgs = (Object[])localObject2;
          if ((arrayOfObject1 != null) && (localObject1 != null)) {
            break;
          }
          AppMethodBeat.o(23896);
          return;
        }
        catch (Exception localException3)
        {
          break label125;
        }
        localException1 = localException1;
        localObject1 = null;
        paramVarArgs = null;
      }
      label125:
      ad.e("MicroMsg.ExdeviceBindDeviceUI", "json decode failed: deviceInfo decode");
      arrayOfObject2 = paramVarArgs;
      localObject2 = localObject1;
      label151:
      paramVarArgs = null;
      localObject1 = localObject2;
    }
    localObject2 = new ExdeviceBindDeviceUI.f(this.pbF, (byte)0);
    ((ExdeviceBindDeviceUI.f)localObject2).pbZ = ExdeviceBindDeviceUI.b.pbQ;
    ((ExdeviceBindDeviceUI.f)localObject2).pcb = new ExdeviceBindDeviceUI.d(this.pbF, (byte)0);
    ((ExdeviceBindDeviceUI.f)localObject2).pcb.mDeviceType = arrayOfObject2;
    ((ExdeviceBindDeviceUI.f)localObject2).pcb.oUX = ((String)localObject1);
    if (!bt.isNullOrNil(paramVarArgs))
    {
      ((ExdeviceBindDeviceUI.f)localObject2).pcg = Base64.encodeToString(paramVarArgs.getBytes(), 2);
      ad.i("MicroMsg.ExdeviceBindDeviceUI", "device.mManufacturerData: %s", new Object[] { ((ExdeviceBindDeviceUI.f)localObject2).pcg });
    }
    for (;;)
    {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(23895);
          ExdeviceBindDeviceUI.3.this.pbF.a(this.pbG);
          AppMethodBeat.o(23895);
        }
      });
      AppMethodBeat.o(23896);
      return;
      ((ExdeviceBindDeviceUI.f)localObject2).pcg = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.3
 * JD-Core Version:    0.7.0.1
 */