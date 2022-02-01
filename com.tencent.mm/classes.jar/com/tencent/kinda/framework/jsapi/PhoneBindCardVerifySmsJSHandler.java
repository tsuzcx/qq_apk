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

public class PhoneBindCardVerifySmsJSHandler
  implements KindaJSInvokeListener.JSHandler
{
  public int type;
  
  public void handle(final ku paramku)
  {
    AppMethodBeat.i(199445);
    KindaJSEvent localKindaJSEvent = new KindaJSEvent();
    localKindaJSEvent.setDelegate(new KindaJSEvent.KindaJsEventDelegate()
    {
      public void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        AppMethodBeat.i(199444);
        if (paramku.dxS.dxV == null) {
          paramku.dxS.dxV = new Bundle();
        }
        paramku.dxS.dxV.putInt("closeWindow", 1);
        AppMethodBeat.o(199444);
      }
      
      public void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        AppMethodBeat.i(199443);
        ad.i("PhoneBindCardVerifySmsJSHandler", "callback: %s", new Object[] { paramAnonymousString });
        if (paramku.dxS.dxV == null) {
          paramku.dxS.dxV = new Bundle();
        }
        paramku.dxS.dxV.putString("ret", paramAnonymousString);
        paramku.dxR.cDO.run();
        AppMethodBeat.o(199443);
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
    localITransmitKvData.putString("app_id", paramku.dxR.dxT.getString("app_id"));
    localITransmitKvData.putString("nonce_str", paramku.dxR.dxT.getString("nonce_str"));
    localITransmitKvData.putString("timeStamp", paramku.dxR.dxT.getString("timeStamp"));
    localITransmitKvData.putString("package", paramku.dxR.dxT.getString("package"));
    localITransmitKvData.putString("paySign", paramku.dxR.dxT.getString("paySign"));
    localITransmitKvData.putString("signType", paramku.dxR.dxT.getString("signType"));
    localITransmitKvData.putString("sessionid", paramku.dxR.dxT.getString("sessionid"));
    if (paramku.dxR.type == 1) {
      localITransmitKvData.putInt("jsApiScene", 1);
    }
    for (;;)
    {
      ad.d("PhoneBindCardVerifySmsJSHandler", "data: %s", new Object[] { paramku.dxR.dxT.toString() });
      KindaApp.appKinda().notifyAllUseCases(localITransmitKvData);
      AppMethodBeat.o(199445);
      return;
      if (paramku.dxR.type == 0) {
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