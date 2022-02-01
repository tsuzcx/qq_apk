package com.tencent.mm.plugin.hardcoder;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.lf;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hardcoder.WXHardCoderJNI.GetParametersCallback;
import com.tencent.mm.hardcoder.WXHardCoderJNI.SystemEventCallback;
import com.tencent.mm.hardcoder.c.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import org.json.JSONException;
import org.json.JSONObject;

final class PluginHardcoder$1$1
  implements c.a
{
  PluginHardcoder$1$1(PluginHardcoder.1 param1) {}
  
  public final void eK(boolean paramBoolean)
  {
    AppMethodBeat.i(130763);
    Log.i("MicroMsg.PluginHardcoder", "configure initHardCoder callback, connect:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if ((paramBoolean) && (MMApplicationContext.isMMProcess()))
    {
      WXHardCoderJNI.registerSystemEventCallback(new WXHardCoderJNI.SystemEventCallback()
      {
        public final void onEvent(int paramAnonymousInt)
        {
          AppMethodBeat.i(130761);
          Log.i("MicroMsg.PluginHardcoder", "configure SystemEventCallback onEvent eventCode[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
          lf locallf = new lf();
          locallf.fIV.fIW = paramAnonymousInt;
          EventCenter.instance.publish(locallf);
          AppMethodBeat.o(130761);
        }
      });
      Log.i("MicroMsg.PluginHardcoder", "configure registerGetParametersCallback ret:%d", new Object[] { Integer.valueOf(WXHardCoderJNI.registerGetParametersCallback(1, new WXHardCoderJNI.GetParametersCallback()
      {
        public final void onGetParameters(int paramAnonymousInt, JSONObject paramAnonymousJSONObject)
        {
          AppMethodBeat.i(130762);
          Log.i("MicroMsg.PluginHardcoder", "configure GetParametersCallback onGetParameters type[%d]", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (paramAnonymousInt == 1) {
            try
            {
              String str1 = paramAnonymousJSONObject.getString("HCMinQPKey");
              String str2 = paramAnonymousJSONObject.getString("HCMaxQPKey");
              paramAnonymousJSONObject = paramAnonymousJSONObject.getString("HCQPSceneKey");
              Log.i("MicroMsg.PluginHardcoder", "onGetParameters, minkey:%s, maxKey:%s, sceneKey:%s", new Object[] { str1, str2, paramAnonymousJSONObject });
              MultiProcessMMKV localMultiProcessMMKV = MultiProcessMMKV.getMMKV("HardcoderQP");
              localMultiProcessMMKV.encode("HCMinQPKey", str1);
              localMultiProcessMMKV.encode("HCMaxQPKey", str2);
              localMultiProcessMMKV.encode("HCQPSceneKey", paramAnonymousJSONObject);
              AppMethodBeat.o(130762);
              return;
            }
            catch (JSONException paramAnonymousJSONObject) {}
          }
          AppMethodBeat.o(130762);
        }
      }, new String[] { "HCMinQPKey", "HCMaxQPKey", "HCQPSceneKey" })) });
    }
    AppMethodBeat.o(130763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.PluginHardcoder.1.1
 * JD-Core Version:    0.7.0.1
 */