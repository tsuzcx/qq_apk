package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class g$5
  implements j.a
{
  g$5(g paramg) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
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
      paramVarArgs = (String)this.qiW.qiV.get(Integer.valueOf(paramInt));
      if (paramVarArgs != null) {
        try
        {
          localObject = new String((byte[])localObject);
          ae.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", new Object[] { localObject });
          JSONObject localJSONObject = new JSONObject((String)localObject);
          if ((!localJSONObject.isNull("errcode")) && (localJSONObject.getInt("errcode") != 0))
          {
            g.fG(paramVarArgs, this.qiW.qiA);
            ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", new Object[] { localObject });
            AppMethodBeat.o(23323);
            return;
          }
          g.fG(paramVarArgs, this.qiW.qiz);
          ae.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
          AppMethodBeat.o(23323);
          return;
        }
        catch (JSONException paramVarArgs)
        {
          ae.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", new Object[] { paramVarArgs });
          AppMethodBeat.o(23323);
          return;
        }
      }
    }
    ae.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(23323);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.5
 * JD-Core Version:    0.7.0.1
 */