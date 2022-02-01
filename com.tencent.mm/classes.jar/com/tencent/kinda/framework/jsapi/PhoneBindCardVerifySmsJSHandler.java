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
import com.tencent.mm.g.a.kd;
import com.tencent.mm.g.a.kd.a;
import com.tencent.mm.g.a.kd.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public class PhoneBindCardVerifySmsJSHandler
  implements KindaJSInvokeListener.JSHandler
{
  public int type;
  
  public void handle(final kd paramkd)
  {
    AppMethodBeat.i(186430);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(186429);
        if (paramkd.dov.doy == null) {
          paramkd.dov.doy = new Bundle();
        }
        paramkd.dov.doy.putInt("closeWindow", 1);
        AppMethodBeat.o(186429);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(186428);
        ad.i("PhoneBindCardVerifySmsJSHandler", "callback: %s", new Object[] { paramAnonymousString });
        if (paramkd.dov.doy == null) {
          paramkd.dov.doy = new Bundle();
        }
        paramkd.dov.doy.putString("ret", paramAnonymousString);
        paramkd.dou.cvK.run();
        AppMethodBeat.o(186428);
      }
      
      public KindaJSEventType kindaGetType()
      {
        if (paramkd.dou.type == 1) {
          return KindaJSEventType.WEB;
        }
        return KindaJSEventType.TINYAPP;
      }
    });
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putJSEvent("jsEvent", localKindaJSEvent);
    localITransmitKvData.putString("app_id", paramkd.dou.dow.getString("app_id"));
    localITransmitKvData.putString("nonce_str", paramkd.dou.dow.getString("nonce_str"));
    localITransmitKvData.putString("timeStamp", paramkd.dou.dow.getString("timeStamp"));
    localITransmitKvData.putString("package", paramkd.dou.dow.getString("package"));
    localITransmitKvData.putString("paySign", paramkd.dou.dow.getString("paySign"));
    localITransmitKvData.putString("signType", paramkd.dou.dow.getString("signType"));
    localITransmitKvData.putString("sessionid", paramkd.dou.dow.getString("sessionid"));
    if (paramkd.dou.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      ad.d("PhoneBindCardVerifySmsJSHandler", "data: %s", new Object[] { paramkd.dou.dow.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      AppMethodBeat.o(186430);
      return;
      if (paramkd.dou.type == 0) {
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