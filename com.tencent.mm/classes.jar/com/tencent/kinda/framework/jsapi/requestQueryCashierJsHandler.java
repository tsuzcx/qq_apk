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

public class requestQueryCashierJsHandler
  implements KindaJSInvokeListener.JSHandler
{
  private static final String TAG = "MicroMsg.requestQueryCashierJsHandler";
  public int type;
  
  public void handle(final ni paramni)
  {
    AppMethodBeat.i(226337);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(226344);
        if (paramni.hPG.result == null) {
          paramni.hPG.result = new Bundle();
        }
        paramni.hPG.result.putInt("closeWindow", 1);
        AppMethodBeat.o(226344);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(226338);
        Log.i("MicroMsg.requestQueryCashierJsHandler", "callback: %s", new Object[] { paramAnonymousString });
        if (paramni.hPG.result == null) {
          paramni.hPG.result = new Bundle();
        }
        paramni.hPG.result.putString("ret", paramAnonymousString);
        paramni.hPF.hPJ.run();
        AppMethodBeat.o(226338);
      }
      
      public KindaJSEventType kindaGetType()
      {
        if (paramni.hPF.type == 1) {
          return KindaJSEventType.TINYAPP;
        }
        return KindaJSEventType.WEB;
      }
    });
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putJSEvent("jsEvent", localKindaJSEvent);
    localITransmitKvData.putString("notifyType", paramni.hPF.hPH.getString("notifyType"));
    localITransmitKvData.putString("appId", paramni.hPF.hPH.getString("appId"));
    localITransmitKvData.putString("nonceStr", paramni.hPF.hPH.getString("nonceStr"));
    localITransmitKvData.putString("timeStamp", paramni.hPF.hPH.getString("timeStamp"));
    localITransmitKvData.putString("package", paramni.hPF.hPH.getString("package"));
    localITransmitKvData.putString("paySign", paramni.hPF.hPH.getString("paySign"));
    localITransmitKvData.putString("signType", paramni.hPF.hPH.getString("signType"));
    if (paramni.hPF.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      Log.i("MicroMsg.requestQueryCashierJsHandler", "data: %s", new Object[] { paramni.hPF.hPH.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      if (paramni.hPG.result == null) {
        paramni.hPG.result = new Bundle();
      }
      paramni.hPG.result.putString("ret", "fail");
      paramni.hPF.hPJ.run();
      AppMethodBeat.o(226337);
      return;
      if (paramni.hPF.type == 0) {
        localITransmitKvData.putInt("jsApiScene", 2);
      }
    }
  }
  
  public String handleJsApi()
  {
    return "requestQueryCashier";
  }
  
  public int handleType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.requestQueryCashierJsHandler
 * JD-Core Version:    0.7.0.1
 */