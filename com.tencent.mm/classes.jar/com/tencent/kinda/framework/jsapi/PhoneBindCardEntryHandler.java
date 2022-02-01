package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.framework.module.impl.KindaJSEvent;
import com.tencent.kinda.framework.module.impl.KindaJSEvent.KindaJsEventDelegate;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KindaJSEventType;
import com.tencent.kinda.gen.UseCaseCallback;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ni;
import com.tencent.mm.autogen.a.ni.a;
import com.tencent.mm.autogen.a.ni.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class PhoneBindCardEntryHandler
  implements KindaJSInvokeListener.JSHandler
{
  private static final String TAG = "MicroMsg.PhoneBindCardEntryHandler";
  public int type;
  
  public void handle(final ni paramni)
  {
    AppMethodBeat.i(226310);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(226311);
        if (paramni.hPG.result == null) {
          paramni.hPG.result = new Bundle();
        }
        paramni.hPG.result.putInt("closeWindow", 1);
        AppMethodBeat.o(226311);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(226308);
        Log.i("MicroMsg.PhoneBindCardEntryHandler", "callback: %s", new Object[] { paramAnonymousString });
        if (paramni.hPG.result == null) {
          paramni.hPG.result = new Bundle();
        }
        paramni.hPG.result.putString("ret", paramAnonymousString);
        paramni.hPF.hPJ.run();
        AppMethodBeat.o(226308);
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
    localITransmitKvData.putString("notifyType", "phoneBindCardEntry");
    localITransmitKvData.putString("app_id", paramni.hPF.hPH.getString("app_id"));
    localITransmitKvData.putString("nonce_str", paramni.hPF.hPH.getString("nonce_str"));
    localITransmitKvData.putString("timeStamp", paramni.hPF.hPH.getString("timeStamp"));
    localITransmitKvData.putString("package", paramni.hPF.hPH.getString("package"));
    localITransmitKvData.putString("paySign", paramni.hPF.hPH.getString("paySign"));
    localITransmitKvData.putString("signType", paramni.hPF.hPH.getString("signType"));
    localITransmitKvData.putString("jsApiName", paramni.hPF.hPI);
    localITransmitKvData.putInt("bind_card_entrance_scene", 3);
    if (paramni.hPF.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      Log.d("MicroMsg.PhoneBindCardEntryHandler", "data: %s", new Object[] { paramni.hPF.hPH.toString() });
      KindaApp.appKinda().startUseCase("fastbindcard", localITransmitKvData, new UseCaseCallback()
      {
        public void call(ITransmitKvData paramAnonymousITransmitKvData) {}
      });
      AppMethodBeat.o(226310);
      return;
      if (paramni.hPF.type == 0) {
        localITransmitKvData.putInt("jsApiScene", 2);
      }
    }
  }
  
  public String handleJsApi()
  {
    return "phoneBindCardEntry";
  }
  
  public int handleType()
  {
    return this.type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.PhoneBindCardEntryHandler
 * JD-Core Version:    0.7.0.1
 */