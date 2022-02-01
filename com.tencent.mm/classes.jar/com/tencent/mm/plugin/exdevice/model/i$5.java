package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class i$5
  implements l.a
{
  i$5(i parami) {}
  
  public final void h(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(23323);
    if ((paramInt != 12) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof Integer)) || (!(paramVarArgs[1] instanceof byte[])))
    {
      AppMethodBeat.o(23323);
      return;
    }
    paramInt = ((Integer)paramVarArgs[0]).intValue();
    Object localObject = (byte[])paramVarArgs[1];
    if (paramInt > 0)
    {
      paramVarArgs = (String)i.c(this.yrv).get(Integer.valueOf(paramInt));
      if (paramVarArgs != null) {
        try
        {
          localObject = new String((byte[])localObject);
          Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", new Object[] { localObject });
          JSONObject localJSONObject = new JSONObject((String)localObject);
          if ((!localJSONObject.isNull("errcode")) && (localJSONObject.getInt("errcode") != 0))
          {
            e.gR(paramVarArgs, e.ypy);
            Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", new Object[] { localObject });
            AppMethodBeat.o(23323);
            return;
          }
          e.gR(paramVarArgs, e.ypx);
          Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
          AppMethodBeat.o(23323);
          return;
        }
        catch (JSONException paramVarArgs)
        {
          Log.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", new Object[] { paramVarArgs });
          AppMethodBeat.o(23323);
          return;
        }
      }
    }
    Log.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(23323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.i.5
 * JD-Core Version:    0.7.0.1
 */