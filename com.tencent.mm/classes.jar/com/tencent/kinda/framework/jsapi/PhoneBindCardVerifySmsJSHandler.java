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
import com.tencent.mm.g.a.ll;
import com.tencent.mm.g.a.ll.a;
import com.tencent.mm.g.a.ll.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public class PhoneBindCardVerifySmsJSHandler
  implements KindaJSInvokeListener.JSHandler
{
  public int type;
  
  public void handle(final ll paramll)
  {
    AppMethodBeat.i(214446);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(214445);
        if (paramll.dQK.result == null) {
          paramll.dQK.result = new Bundle();
        }
        paramll.dQK.result.putInt("closeWindow", 1);
        AppMethodBeat.o(214445);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(214444);
        Log.i("PhoneBindCardVerifySmsJSHandler", "callback: %s", new Object[] { paramAnonymousString });
        if (paramll.dQK.result == null) {
          paramll.dQK.result = new Bundle();
        }
        paramll.dQK.result.putString("ret", paramAnonymousString);
        paramll.dQJ.dQN.run();
        AppMethodBeat.o(214444);
      }
      
      public KindaJSEventType kindaGetType()
      {
        if (paramll.dQJ.type == 1) {
          return KindaJSEventType.WEB;
        }
        return KindaJSEventType.TINYAPP;
      }
    });
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putJSEvent("jsEvent", localKindaJSEvent);
    localITransmitKvData.putString("app_id", paramll.dQJ.dQL.getString("app_id"));
    localITransmitKvData.putString("nonce_str", paramll.dQJ.dQL.getString("nonce_str"));
    localITransmitKvData.putString("timeStamp", paramll.dQJ.dQL.getString("timeStamp"));
    localITransmitKvData.putString("package", paramll.dQJ.dQL.getString("package"));
    localITransmitKvData.putString("paySign", paramll.dQJ.dQL.getString("paySign"));
    localITransmitKvData.putString("signType", paramll.dQJ.dQL.getString("signType"));
    localITransmitKvData.putString("sessionid", paramll.dQJ.dQL.getString("sessionid"));
    if (paramll.dQJ.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      Log.d("PhoneBindCardVerifySmsJSHandler", "data: %s", new Object[] { paramll.dQJ.dQL.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      AppMethodBeat.o(214446);
      return;
      if (paramll.dQJ.type == 0) {
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