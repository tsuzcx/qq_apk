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
import com.tencent.mm.g.a.ku;
import com.tencent.mm.g.a.ku.a;
import com.tencent.mm.g.a.ku.b;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.HashMap;

public class requestQueryCashierJsHandler
  implements KindaJSInvokeListener.JSHandler
{
  public int type;
  
  public void handle(final ku paramku)
  {
    AppMethodBeat.i(199448);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(199447);
        if (paramku.dxS.dxV == null) {
          paramku.dxS.dxV = new Bundle();
        }
        paramku.dxS.dxV.putInt("closeWindow", 1);
        AppMethodBeat.o(199447);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(199446);
        ad.i("requestQueryCashier", "callback: %s", new Object[] { paramAnonymousString });
        if (paramku.dxS.dxV == null) {
          paramku.dxS.dxV = new Bundle();
        }
        paramku.dxS.dxV.putString("ret", paramAnonymousString);
        paramku.dxR.cDO.run();
        AppMethodBeat.o(199446);
      }
      
      public KindaJSEventType kindaGetType()
      {
        if (paramku.dxR.type == 1) {
          return KindaJSEventType.WEB;
        }
        return KindaJSEventType.TINYAPP;
      }
    });
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putJSEvent("jsEvent", localKindaJSEvent);
    localITransmitKvData.putString("notifyType", paramku.dxR.dxT.getString("notifyType"));
    localITransmitKvData.putString("appId", paramku.dxR.dxT.getString("appId"));
    localITransmitKvData.putString("nonceStr", paramku.dxR.dxT.getString("nonceStr"));
    localITransmitKvData.putString("timeStamp", paramku.dxR.dxT.getString("timeStamp"));
    localITransmitKvData.putString("package", paramku.dxR.dxT.getString("package"));
    localITransmitKvData.putString("paySign", paramku.dxR.dxT.getString("paySign"));
    localITransmitKvData.putString("signType", paramku.dxR.dxT.getString("signType"));
    if (paramku.dxR.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      ad.d("requestQueryCashierJsHandler", "data: %s", new Object[] { paramku.dxR.dxT.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      paramku.dxS.dxV.putString("ret", "fail");
      paramku.dxR.cDO.run();
      AppMethodBeat.o(199448);
      return;
      if (paramku.dxR.type == 0) {
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