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
import com.tencent.mm.g.a.kl;
import com.tencent.mm.g.a.kl.a;
import com.tencent.mm.g.a.kl.b;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.HashMap;

public class PhoneBindCardVerifySmsJSHandler
  implements KindaJSInvokeListener.JSHandler
{
  public int type;
  
  public void handle(final kl paramkl)
  {
    AppMethodBeat.i(207392);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(207391);
        if (paramkl.dme.dmh == null) {
          paramkl.dme.dmh = new Bundle();
        }
        paramkl.dme.dmh.putInt("closeWindow", 1);
        AppMethodBeat.o(207391);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(207390);
        ac.i("PhoneBindCardVerifySmsJSHandler", "callback: %s", new Object[] { paramAnonymousString });
        if (paramkl.dme.dmh == null) {
          paramkl.dme.dmh = new Bundle();
        }
        paramkl.dme.dmh.putString("ret", paramAnonymousString);
        paramkl.dmd.csS.run();
        AppMethodBeat.o(207390);
      }
      
      public KindaJSEventType kindaGetType()
      {
        if (paramkl.dmd.type == 1) {
          return KindaJSEventType.WEB;
        }
        return KindaJSEventType.TINYAPP;
      }
    });
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putJSEvent("jsEvent", localKindaJSEvent);
    localITransmitKvData.putString("app_id", paramkl.dmd.dmf.getString("app_id"));
    localITransmitKvData.putString("nonce_str", paramkl.dmd.dmf.getString("nonce_str"));
    localITransmitKvData.putString("timeStamp", paramkl.dmd.dmf.getString("timeStamp"));
    localITransmitKvData.putString("package", paramkl.dmd.dmf.getString("package"));
    localITransmitKvData.putString("paySign", paramkl.dmd.dmf.getString("paySign"));
    localITransmitKvData.putString("signType", paramkl.dmd.dmf.getString("signType"));
    localITransmitKvData.putString("sessionid", paramkl.dmd.dmf.getString("sessionid"));
    if (paramkl.dmd.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      ac.d("PhoneBindCardVerifySmsJSHandler", "data: %s", new Object[] { paramkl.dmd.dmf.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      AppMethodBeat.o(207392);
      return;
      if (paramkl.dmd.type == 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.PhoneBindCardVerifySmsJSHandler
 * JD-Core Version:    0.7.0.1
 */