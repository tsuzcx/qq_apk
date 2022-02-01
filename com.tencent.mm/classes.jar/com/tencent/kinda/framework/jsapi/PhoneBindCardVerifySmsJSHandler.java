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
import com.tencent.mm.f.a.mc;
import com.tencent.mm.f.a.mc.a;
import com.tencent.mm.f.a.mc.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class PhoneBindCardVerifySmsJSHandler
  implements KindaJSInvokeListener.JSHandler
{
  public int type;
  
  public void handle(final mc parammc)
  {
    AppMethodBeat.i(263256);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(263119);
        if (parammc.fKa.result == null) {
          parammc.fKa.result = new Bundle();
        }
        parammc.fKa.result.putInt("closeWindow", 1);
        AppMethodBeat.o(263119);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(263118);
        Log.i("PhoneBindCardVerifySmsJSHandler", "callback: %s", new Object[] { paramAnonymousString });
        if (parammc.fKa.result == null) {
          parammc.fKa.result = new Bundle();
        }
        parammc.fKa.result.putString("ret", paramAnonymousString);
        parammc.fJZ.fKd.run();
        AppMethodBeat.o(263118);
      }
      
      public KindaJSEventType kindaGetType()
      {
        if (parammc.fJZ.type == 1) {
          return KindaJSEventType.TINYAPP;
        }
        return KindaJSEventType.WEB;
      }
    });
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putJSEvent("jsEvent", localKindaJSEvent);
    localITransmitKvData.putString("notifyType", "fastBindCard");
    localITransmitKvData.putString("app_id", parammc.fJZ.fKb.getString("app_id"));
    localITransmitKvData.putString("nonce_str", parammc.fJZ.fKb.getString("nonce_str"));
    localITransmitKvData.putString("timeStamp", parammc.fJZ.fKb.getString("timeStamp"));
    localITransmitKvData.putString("package", parammc.fJZ.fKb.getString("package"));
    localITransmitKvData.putString("paySign", parammc.fJZ.fKb.getString("paySign"));
    localITransmitKvData.putString("signType", parammc.fJZ.fKb.getString("signType"));
    localITransmitKvData.putString("sessionid", parammc.fJZ.fKb.getString("sessionid"));
    localITransmitKvData.putString("jsApiName", parammc.fJZ.fKc);
    if (parammc.fJZ.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      Log.d("PhoneBindCardVerifySmsJSHandler", "data: %s", new Object[] { parammc.fJZ.fKb.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      AppMethodBeat.o(263256);
      return;
      if (parammc.fJZ.type == 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.PhoneBindCardVerifySmsJSHandler
 * JD-Core Version:    0.7.0.1
 */