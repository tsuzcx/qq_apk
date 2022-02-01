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

public class requestQueryCashierJsHandler
  implements KindaJSInvokeListener.JSHandler
{
  public int type;
  
  public void handle(final kv paramkv)
  {
    AppMethodBeat.i(193158);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(193157);
        if (paramkv.dyX.dza == null) {
          paramkv.dyX.dza = new Bundle();
        }
        paramkv.dyX.dza.putInt("closeWindow", 1);
        AppMethodBeat.o(193157);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(193156);
        ae.i("requestQueryCashier", "callback: %s", new Object[] { paramAnonymousString });
        if (paramkv.dyX.dza == null) {
          paramkv.dyX.dza = new Bundle();
        }
        paramkv.dyX.dza.putString("ret", paramAnonymousString);
        paramkv.dyW.cEv.run();
        AppMethodBeat.o(193156);
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
    localITransmitKvData.putString("notifyType", paramkv.dyW.dyY.getString("notifyType"));
    localITransmitKvData.putString("appId", paramkv.dyW.dyY.getString("appId"));
    localITransmitKvData.putString("nonceStr", paramkv.dyW.dyY.getString("nonceStr"));
    localITransmitKvData.putString("timeStamp", paramkv.dyW.dyY.getString("timeStamp"));
    localITransmitKvData.putString("package", paramkv.dyW.dyY.getString("package"));
    localITransmitKvData.putString("paySign", paramkv.dyW.dyY.getString("paySign"));
    localITransmitKvData.putString("signType", paramkv.dyW.dyY.getString("signType"));
    if (paramkv.dyW.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      ae.d("requestQueryCashierJsHandler", "data: %s", new Object[] { paramkv.dyW.dyY.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      paramkv.dyX.dza.putString("ret", "fail");
      paramkv.dyW.cEv.run();
      AppMethodBeat.o(193158);
      return;
      if (paramkv.dyW.type == 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.requestQueryCashierJsHandler
 * JD-Core Version:    0.7.0.1
 */