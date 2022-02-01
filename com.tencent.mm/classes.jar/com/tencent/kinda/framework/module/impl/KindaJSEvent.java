package com.tencent.kinda.framework.module.impl;

import android.content.Intent;
import com.tencent.kinda.gen.KJSEvent;
import com.tencent.kinda.gen.KindaJSEventType;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;
import java.util.HashMap<Ljava.lang.String;Ljava.lang.String;>;

public class KindaJSEvent
  implements KJSEvent
{
  private static final String TAG = "MicroMsg.KindaJSEvent";
  private KindaJsEventDelegate mDelegate;
  private KindaJSEventType mEventType;
  @Deprecated
  private MMActivity.a mIMMOnActivityResult;
  @Deprecated
  private int mRequestCode;
  @Deprecated
  private int mResultCode;
  
  public KindaJSEvent()
  {
    AppMethodBeat.i(18639);
    this.mResultCode = 0;
    this.mEventType = KindaJSEventType.WEB;
    AppMethodBeat.o(18639);
  }
  
  public void kindaCloseWebViewImpl(boolean paramBoolean, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18640);
    if (this.mDelegate != null)
    {
      this.mDelegate.kindaCloseWebViewImpl(paramBoolean, paramVoidCallback);
      AppMethodBeat.o(18640);
      return;
    }
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("key_jsapi_close_page_after_pay", i);
      Log.i("MicroMsg.KindaJSEvent", "[kindaCloseWebViewImpl] The data from JsApiPayUseCase: isCloseWebView: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      if (this.mIMMOnActivityResult != null) {
        this.mIMMOnActivityResult.d(this.mRequestCode, this.mResultCode, localIntent);
      }
      if (paramVoidCallback != null) {
        paramVoidCallback.call();
      }
      AppMethodBeat.o(18640);
      return;
    }
  }
  
  public void kindaEndWithResult(String paramString, HashMap<String, String> paramHashMap)
  {
    AppMethodBeat.i(170114);
    if (this.mDelegate != null)
    {
      this.mDelegate.kindaEndWithResult(paramString, paramHashMap);
      AppMethodBeat.o(170114);
      return;
    }
    Object localObject = "";
    String str = "";
    int i;
    if (paramHashMap != null) {
      if ("pending".equals(paramHashMap.get("pay_status")))
      {
        i = 0;
        localObject = (String)paramHashMap.get("err_code");
        str = (String)paramHashMap.get("err_desc");
      }
    }
    for (paramHashMap = (HashMap<String, String>)localObject;; paramHashMap = (HashMap<String, String>)localObject)
    {
      Log.i("MicroMsg.KindaJSEvent", "[kindaEndWithResult] The data from JsApiPayUseCase: result: %s, pay_status(isClearFailure): %d, err_code: %s, err_desc: %s", new Object[] { paramString, Integer.valueOf(i), paramHashMap, str });
      localObject = new Intent();
      this.mResultCode = 0;
      if (paramString.endsWith("ok"))
      {
        this.mResultCode = -1;
        ((Intent)localObject).putExtra("key_is_clear_failure", i);
      }
      for (;;)
      {
        if (this.mIMMOnActivityResult != null) {
          this.mIMMOnActivityResult.d(this.mRequestCode, this.mResultCode, (Intent)localObject);
        }
        AppMethodBeat.o(170114);
        return;
        if (!"fail".equals(paramHashMap.get("pay_status"))) {
          break label246;
        }
        i = 1;
        break;
        if (paramString.endsWith("fail"))
        {
          this.mResultCode = 5;
          ((Intent)localObject).putExtra("key_jsapi_pay_err_code", paramHashMap);
          ((Intent)localObject).putExtra("key_jsapi_pay_err_msg", str);
          ((Intent)localObject).putExtra("key_is_clear_failure", i);
        }
      }
      label246:
      i = -1;
      break;
      i = -1;
    }
  }
  
  public KindaJSEventType kindaGetType()
  {
    AppMethodBeat.i(264266);
    if (this.mDelegate != null)
    {
      localKindaJSEventType = this.mDelegate.kindaGetType();
      AppMethodBeat.o(264266);
      return localKindaJSEventType;
    }
    KindaJSEventType localKindaJSEventType = this.mEventType;
    AppMethodBeat.o(264266);
    return localKindaJSEventType;
  }
  
  public void setDelegate(KindaJsEventDelegate paramKindaJsEventDelegate)
  {
    this.mDelegate = paramKindaJsEventDelegate;
  }
  
  public void setIMMOnActivityResult(MMActivity.a parama)
  {
    this.mIMMOnActivityResult = parama;
  }
  
  public void setRequestCode(int paramInt)
  {
    this.mRequestCode = paramInt;
  }
  
  public void setType(KindaJSEventType paramKindaJSEventType)
  {
    this.mEventType = paramKindaJSEventType;
  }
  
  public static abstract interface KindaJsEventDelegate
    extends KJSEvent
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaJSEvent
 * JD-Core Version:    0.7.0.1
 */