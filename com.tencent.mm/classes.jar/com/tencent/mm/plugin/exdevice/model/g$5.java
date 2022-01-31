package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

final class g$5
  implements j.a
{
  g$5(g paramg) {}
  
  public final void g(int paramInt, Object... paramVarArgs)
  {
    if ((paramInt != 12) || (paramVarArgs == null) || (paramVarArgs.length < 2) || (!(paramVarArgs[0] instanceof Integer)) || (!(paramVarArgs[1] instanceof byte[]))) {
      return;
    }
    paramInt = ((Integer)paramVarArgs[0]).intValue();
    Object localObject = (byte[])paramVarArgs[1];
    if (paramInt > 0)
    {
      paramVarArgs = (String)this.jvq.jvp.get(Integer.valueOf(paramInt));
      if (paramVarArgs != null)
      {
        try
        {
          localObject = new String((byte[])localObject);
          y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive response json %s", new Object[] { localObject });
          JSONObject localJSONObject = new JSONObject((String)localObject);
          if ((!localJSONObject.isNull("errcode")) && (localJSONObject.getInt("errcode") != 0))
          {
            g.cO(paramVarArgs, this.jvq.juU);
            y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send msg failed data %s", new Object[] { localObject });
            return;
          }
        }
        catch (JSONException paramVarArgs)
        {
          y.e("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "JSON decode mUseWCLanDeviceServiceCmdId failed %s", new Object[] { paramVarArgs });
          return;
        }
        g.cO(paramVarArgs, this.jvq.juT);
        y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "send data success!");
        return;
      }
    }
    y.d("MicroMsg.exdevice.ExdeviceSendDataToNetworkDevice", "receive cmdId =" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.g.5
 * JD-Core Version:    0.7.0.1
 */