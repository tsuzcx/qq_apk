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
import com.tencent.mm.autogen.a.ni;
import com.tencent.mm.autogen.a.ni.a;
import com.tencent.mm.autogen.a.ni.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class FastBindCardGetResultHandler
  implements KindaJSInvokeListener.JSHandler
{
  public int type;
  
  public void handle(final ni paramni)
  {
    AppMethodBeat.i(226346);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(226326);
        if (paramni.hPG.result == null) {
          paramni.hPG.result = new Bundle();
        }
        paramni.hPG.result.putInt("closeWindow", 1);
        AppMethodBeat.o(226326);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(226320);
        Log.i("MicroMsg.FastBindCardGetResultHandler", "callback: %s", new Object[] { paramAnonymousString });
        if (paramni.hPG.result == null) {
          paramni.hPG.result = new Bundle();
        }
        paramni.hPG.result.putString("ret", paramAnonymousString);
        paramni.hPF.hPJ.run();
        AppMethodBeat.o(226320);
      }
      
      public KindaJSEventType kindaGetType()
      {
        if (paramni.hPF.type == 1) {
          return KindaJSEventType.WEB;
        }
        return KindaJSEventType.TINYAPP;
      }
    });
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putJSEvent("jsEvent", localKindaJSEvent);
    localITransmitKvData.putString("notifyType", "fastBindCard");
    localITransmitKvData.putString("app_id", paramni.hPF.hPH.getString("app_id"));
    localITransmitKvData.putString("nonce_str", paramni.hPF.hPH.getString("nonce_str"));
    localITransmitKvData.putString("timeStamp", paramni.hPF.hPH.getString("timeStamp"));
    localITransmitKvData.putString("package", paramni.hPF.hPH.getString("package"));
    localITransmitKvData.putString("paySign", paramni.hPF.hPH.getString("paySign"));
    localITransmitKvData.putString("signType", paramni.hPF.hPH.getString("signType"));
    localITransmitKvData.putString("sessionid", paramni.hPF.hPH.getString("sessionid"));
    localITransmitKvData.putString("jsApiName", paramni.hPF.hPI);
    if (paramni.hPF.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      Log.d("MicroMsg.FastBindCardGetResultHandler", "data: %s", new Object[] { paramni.hPF.hPH.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      AppMethodBeat.o(226346);
      return;
      if (paramni.hPF.type == 0) {
        localITransmitKvData.putInt("jsApiScene", 2);
      }
    }
  }
  
  public String handleJsApi()
  {
    return "fastBindCardGetResult";
  }
  
  public int handleType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.FastBindCardGetResultHandler
 * JD-Core Version:    0.7.0.1
 */