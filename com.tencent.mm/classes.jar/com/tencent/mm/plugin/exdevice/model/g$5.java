package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class g$5
  implements j.a
{
  g$5(g paramg) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19255);
    if ((paramInt != 12) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof Integer)) || (!(paramVarArgs[1] instanceof byte[])))
    {
      AppMethodBeat.o(19255);
      return;
    }
    paramInt = ((Integer)paramVarArgs[0]).intValue();
    Object localObject = (byte[])paramVarArgs[1];
    if (paramInt > 0)
    {
      paramVarArgs = (String)this.lEP.lEO.get(Integer.valueOf(paramInt));
      if (paramVarArgs != null) {
        try
        {
          localObject = new String((byte[])localObject);
          ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", new Object[] { localObject });
          JSONObject localJSONObject = new JSONObject((String)localObject);
          if ((!localJSONObject.isNull("errcode")) && (localJSONObject.getInt("errcode") != 0))
          {
            g.dS(paramVarArgs, this.lEP.lEt);
            ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", new Object[] { localObject });
            AppMethodBeat.o(19255);
            return;
          }
          g.dS(paramVarArgs, this.lEP.lEs);
          ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
          AppMethodBeat.o(19255);
          return;
        }
        catch (JSONException paramVarArgs)
        {
          ab.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", new Object[] { paramVarArgs });
          AppMethodBeat.o(19255);
          return;
        }
      }
    }
    ab.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(19255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.5
 * JD-Core Version:    0.7.0.1
 */