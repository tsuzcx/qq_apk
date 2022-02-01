package com.tencent.mm.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONException;
import org.json.JSONObject;

class WXHardCoderJNI$4
  implements c.b
{
  public void onFuncRet(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte)
  {
    int i = 0;
    AppMethodBeat.i(155950);
    Log.i("MicroMsg.WXHardCoderJNI", "FuncRetCallback callbackType:" + paramInt1 + ", requestId:" + paramLong + ", retCode:" + paramInt2 + ", funcId:" + paramInt3 + ", dataType:" + paramInt4);
    if (paramInt1 == 2) {
      switch (paramInt3)
      {
      }
    }
    do
    {
      do
      {
        AppMethodBeat.o(155950);
        return;
      } while (WXHardCoderJNI.access$200() == null);
      try
      {
        paramInt1 = new JSONObject(new String(paramArrayOfByte)).optInt("system_event_code", 0);
        Log.i("MicroMsg.WXHardCoderJNI", "onData SYSTEM_EVENT_CODE: ".concat(String.valueOf(paramInt1)));
        WXHardCoderJNI.access$200().onEvent(paramInt1);
        AppMethodBeat.o(155950);
        return;
      }
      catch (JSONException paramArrayOfByte)
      {
        Log.i("MicroMsg.WXHardCoderJNI", "onData parse system event e:" + paramArrayOfByte.getMessage());
        AppMethodBeat.o(155950);
        return;
      }
    } while (WXHardCoderJNI.access$300() == null);
    for (;;)
    {
      try
      {
        paramArrayOfByte = new JSONObject(new String(paramArrayOfByte));
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          paramInt1 = paramArrayOfByte.getInt("getparameterstype");
          Log.i("MicroMsg.WXHardCoderJNI", "onData GET_PARAMETERS: " + paramArrayOfByte + ", type:" + paramInt1);
          WXHardCoderJNI.access$300().onGetParameters(paramInt1, paramArrayOfByte);
        }
        catch (JSONException localJSONException2)
        {
          break label279;
        }
        localJSONException1 = localJSONException1;
        paramArrayOfByte = null;
      }
      label279:
      Log.i("MicroMsg.WXHardCoderJNI", "onData parse get parameters e:" + localJSONException1.getMessage());
      paramInt1 = i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.hardcoder.WXHardCoderJNI.4
 * JD-Core Version:    0.7.0.1
 */