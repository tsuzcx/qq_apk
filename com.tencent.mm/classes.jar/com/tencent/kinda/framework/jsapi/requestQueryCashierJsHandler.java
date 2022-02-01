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

public class requestQueryCashierJsHandler
  implements KindaJSInvokeListener.JSHandler
{
  public int type;
  
  public void handle(final ll paramll)
  {
    AppMethodBeat.i(214449);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(214448);
        if (paramll.dQK.result == null) {
          paramll.dQK.result = new Bundle();
        }
        paramll.dQK.result.putInt("closeWindow", 1);
        AppMethodBeat.o(214448);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(214447);
        Log.i("requestQueryCashier", "callback: %s", new Object[] { paramAnonymousString });
        if (paramll.dQK.result == null) {
          paramll.dQK.result = new Bundle();
        }
        paramll.dQK.result.putString("ret", paramAnonymousString);
        paramll.dQJ.dQN.run();
        AppMethodBeat.o(214447);
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
    localITransmitKvData.putString("notifyType", paramll.dQJ.dQL.getString("notifyType"));
    localITransmitKvData.putString("appId", paramll.dQJ.dQL.getString("appId"));
    localITransmitKvData.putString("nonceStr", paramll.dQJ.dQL.getString("nonceStr"));
    localITransmitKvData.putString("timeStamp", paramll.dQJ.dQL.getString("timeStamp"));
    localITransmitKvData.putString("package", paramll.dQJ.dQL.getString("package"));
    localITransmitKvData.putString("paySign", paramll.dQJ.dQL.getString("paySign"));
    localITransmitKvData.putString("signType", paramll.dQJ.dQL.getString("signType"));
    if (paramll.dQJ.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      Log.d("requestQueryCashierJsHandler", "data: %s", new Object[] { paramll.dQJ.dQL.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      paramll.dQK.result.putString("ret", "fail");
      paramll.dQJ.dQN.run();
      AppMethodBeat.o(214449);
      return;
      if (paramll.dQJ.type == 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.requestQueryCashierJsHandler
 * JD-Core Version:    0.7.0.1
 */