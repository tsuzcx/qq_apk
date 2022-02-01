package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.framework.module.impl.KindaJSEvent;
import com.tencent.kinda.framework.module.impl.KindaJSEvent.KindaJsEventDelegate;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaJSEventType;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kv;
import com.tencent.mm.g.a.kv.a;
import com.tencent.mm.g.a.kv.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.HashMap;

public class PhoneBindCardVerifySmsJSHandler
  implements KindaJSInvokeListener.JSHandler
{
  public int type;
  
  public void handle(final kv paramkv)
  {
    AppMethodBeat.i(193155);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(193154);
        if (paramkv.dyX.dza == null) {
          paramkv.dyX.dza = new Bundle();
        }
        paramkv.dyX.dza.putInt("closeWindow", 1);
        AppMethodBeat.o(193154);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(193153);
        ae.i("PhoneBindCardVerifySmsJSHandler", "callback: %s", new Object[] { paramAnonymousString });
        if (paramkv.dyX.dza == null) {
          paramkv.dyX.dza = new Bundle();
        }
        paramkv.dyX.dza.putString("ret", paramAnonymousString);
        paramkv.dyW.cEv.run();
        AppMethodBeat.o(193153);
      }
      
      public KindaJSEventType kindaGetType()
      {
        if (paramkv.dyW.type == 1) {
          return KindaJSEventType.WEB;
        }
        return KindaJSEventType.TINYAPP;
      }
    });
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putJSEvent("jsEvent", localKindaJSEvent);
    localITransmitKvData.putString("app_id", paramkv.dyW.dyY.getString("app_id"));
    localITransmitKvData.putString("nonce_str", paramkv.dyW.dyY.getString("nonce_str"));
    localITransmitKvData.putString("timeStamp", paramkv.dyW.dyY.getString("timeStamp"));
    localITransmitKvData.putString("package", paramkv.dyW.dyY.getString("package"));
    localITransmitKvData.putString("paySign", paramkv.dyW.dyY.getString("paySign"));
    localITransmitKvData.putString("signType", paramkv.dyW.dyY.getString("signType"));
    localITransmitKvData.putString("sessionid", paramkv.dyW.dyY.getString("sessionid"));
    if (paramkv.dyW.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      ae.d("PhoneBindCardVerifySmsJSHandler", "data: %s", new Object[] { paramkv.dyW.dyY.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      AppMethodBeat.o(193155);
      return;
      if (paramkv.dyW.type == 0) {
        localITransmitKvData.putInt("jsApiScene", 2);
      }
    }
  }
  
  public String handleJsApi()
  {
    return "phoneBindCardVerifySms";
  }
  
  public int handleType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.PhoneBindCardVerifySmsJSHandler
 * JD-Core Version:    0.7.0.1
 */