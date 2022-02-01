package com.tencent.kinda.framework.jsapi;

import android.os.Bundle;
import com.tencent.kinda.framework.boot.KindaApp;
import com.tencent.kinda.framework.module.impl.KindaJSEvent;
import com.tencent.kinda.framework.module.impl.KindaJSEvent.KindaJsEventDelegate;
import com.tencent.kinda.gen.IAppKinda;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KJSEvent;
import com.tencent.kinda.gen.KindaJSEventType;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ni;
import com.tencent.mm.autogen.a.ni.a;
import com.tencent.mm.autogen.a.ni.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/kinda/framework/jsapi/RequestKidsPayRechargePaymentHandler;", "Lcom/tencent/kinda/framework/jsapi/KindaJSInvokeListener$JSHandler;", "()V", "handle", "", "event", "Lcom/tencent/mm/autogen/events/KindaJSInvokeEvent;", "handleJsApi", "", "handleType", "", "Companion", "kinda-framework-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RequestKidsPayRechargePaymentHandler
  implements KindaJSInvokeListener.JSHandler
{
  public static final Companion Companion;
  private static final String TAG = "MicroMsg.RequestKidsPayRechargePaymentHandler";
  
  static
  {
    AppMethodBeat.i(226335);
    Companion = new Companion(null);
    AppMethodBeat.o(226335);
  }
  
  private static final void handle$lambda-2(ITransmitKvData paramITransmitKvData) {}
  
  public final void handle(ni paramni)
  {
    AppMethodBeat.i(226348);
    Object localObject = new KindaJSEvent();
    ((KindaJSEvent)localObject).setDelegate((KindaJSEvent.KindaJsEventDelegate)new KindaJSEvent.KindaJsEventDelegate()
    {
      public final void kindaCloseWebViewImpl(boolean paramAnonymousBoolean, VoidCallback paramAnonymousVoidCallback)
      {
        Object localObject = null;
        AppMethodBeat.i(226323);
        s.u(paramAnonymousVoidCallback, "completion");
        paramAnonymousVoidCallback = this.$event;
        if (paramAnonymousVoidCallback == null)
        {
          paramAnonymousVoidCallback = null;
          if (paramAnonymousVoidCallback == null)
          {
            paramAnonymousVoidCallback = this.$event;
            if (paramAnonymousVoidCallback != null) {
              break label116;
            }
          }
        }
        label116:
        for (paramAnonymousVoidCallback = localObject;; paramAnonymousVoidCallback = paramAnonymousVoidCallback.hPG)
        {
          if (paramAnonymousVoidCallback != null) {
            paramAnonymousVoidCallback.result = new Bundle();
          }
          paramAnonymousVoidCallback = this.$event;
          if (paramAnonymousVoidCallback != null)
          {
            paramAnonymousVoidCallback = paramAnonymousVoidCallback.hPG;
            if (paramAnonymousVoidCallback != null)
            {
              paramAnonymousVoidCallback = paramAnonymousVoidCallback.result;
              if (paramAnonymousVoidCallback != null) {
                paramAnonymousVoidCallback.putInt("closeWindow", 1);
              }
            }
          }
          AppMethodBeat.o(226323);
          return;
          paramAnonymousVoidCallback = paramAnonymousVoidCallback.hPG;
          if (paramAnonymousVoidCallback == null)
          {
            paramAnonymousVoidCallback = null;
            break;
          }
          paramAnonymousVoidCallback = paramAnonymousVoidCallback.result;
          break;
        }
      }
      
      public final void kindaEndWithResult(String paramAnonymousString, HashMap<String, String> paramAnonymousHashMap)
      {
        Object localObject = null;
        AppMethodBeat.i(226316);
        s.u(paramAnonymousString, "result");
        s.u(paramAnonymousHashMap, "extraInfo");
        Log.i("MicroMsg.RequestKidsPayRechargePaymentHandler", "callback: %s", new Object[] { paramAnonymousString });
        paramAnonymousHashMap = this.$event;
        if (paramAnonymousHashMap == null)
        {
          paramAnonymousHashMap = null;
          if (paramAnonymousHashMap == null)
          {
            paramAnonymousHashMap = this.$event;
            if (paramAnonymousHashMap != null) {
              break label170;
            }
          }
        }
        label170:
        for (paramAnonymousHashMap = localObject;; paramAnonymousHashMap = paramAnonymousHashMap.hPG)
        {
          if (paramAnonymousHashMap != null) {
            paramAnonymousHashMap.result = new Bundle();
          }
          paramAnonymousHashMap = this.$event;
          if (paramAnonymousHashMap != null)
          {
            paramAnonymousHashMap = paramAnonymousHashMap.hPG;
            if (paramAnonymousHashMap != null)
            {
              paramAnonymousHashMap = paramAnonymousHashMap.result;
              if (paramAnonymousHashMap != null) {
                paramAnonymousHashMap.putString("ret", paramAnonymousString);
              }
            }
          }
          paramAnonymousString = this.$event;
          if (paramAnonymousString != null)
          {
            paramAnonymousString = paramAnonymousString.hPF;
            if (paramAnonymousString != null)
            {
              paramAnonymousString = paramAnonymousString.hPJ;
              if (paramAnonymousString != null) {
                paramAnonymousString.run();
              }
            }
          }
          AppMethodBeat.o(226316);
          return;
          paramAnonymousHashMap = paramAnonymousHashMap.hPG;
          if (paramAnonymousHashMap == null)
          {
            paramAnonymousHashMap = null;
            break;
          }
          paramAnonymousHashMap = paramAnonymousHashMap.result;
          break;
        }
      }
      
      public final KindaJSEventType kindaGetType()
      {
        Object localObject = this.$event;
        if (localObject != null)
        {
          localObject = ((ni)localObject).hPF;
          if ((localObject == null) || (((ni.a)localObject).type != 2)) {}
        }
        for (int i = 1; i != 0; i = 0) {
          return KindaJSEventType.TINYAPP;
        }
        return KindaJSEventType.WEB;
      }
    });
    ITransmitKvData localITransmitKvData = ITransmitKvData.create();
    localITransmitKvData.putJSEvent("JSEvent", (KJSEvent)localObject);
    localITransmitKvData.putInt("payScene", 70);
    if (paramni != null)
    {
      localObject = paramni.hPF;
      if (localObject != null)
      {
        localObject = ((ni.a)localObject).hPH;
        if (localObject != null)
        {
          localITransmitKvData.putString("appId", ((Bundle)localObject).getString("appId"));
          localITransmitKvData.putString("timeStamp", ((Bundle)localObject).getString("timeStamp"));
          localITransmitKvData.putString("nonceStr", ((Bundle)localObject).getString("nonceStr"));
          localITransmitKvData.putString("package", ((Bundle)localObject).getString("package"));
          localITransmitKvData.putString("signType", ((Bundle)localObject).getString("signType"));
          localITransmitKvData.putString("paySign", ((Bundle)localObject).getString("paySign"));
          localITransmitKvData.putString("webViewUrl", ((Bundle)localObject).getString("webViewUrl"));
        }
      }
    }
    if (paramni == null) {
      paramni = null;
    }
    for (;;)
    {
      Log.d("MicroMsg.RequestKidsPayRechargePaymentHandler", s.X("data: ", paramni));
      KindaApp.appKinda().startUseCase("kidsPayRecharge", localITransmitKvData, RequestKidsPayRechargePaymentHandler..ExternalSyntheticLambda0.INSTANCE);
      AppMethodBeat.o(226348);
      return;
      paramni = paramni.hPF;
      if (paramni == null) {
        paramni = null;
      } else {
        paramni = paramni.hPH;
      }
    }
  }
  
  public final String handleJsApi()
  {
    return "requestKidsPayRechargePayment";
  }
  
  public final int handleType()
  {
    return 0;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/kinda/framework/jsapi/RequestKidsPayRechargePaymentHandler$Companion;", "", "()V", "TAG", "", "kinda-framework-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.jsapi.RequestKidsPayRechargePaymentHandler
 * JD-Core Version:    0.7.0.1
 */