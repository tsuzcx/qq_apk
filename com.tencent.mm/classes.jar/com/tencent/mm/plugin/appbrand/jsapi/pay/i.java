package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.content.Intent;
import com.tencent.e.f.h;
import com.tencent.luggage.h.f.c;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.ui.e.f.a;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.m;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "REQUEST_FACE_TO_FACE_PAYMENT_RESULT_CODE", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"})
public final class i
  extends d<c>
{
  public static final int CTRL_INDEX = 820;
  public static final String NAME = "requestFacetoFacePayment";
  public static final a mmp;
  private final int mmo;
  
  static
  {
    AppMethodBeat.i(228444);
    mmp = new a((byte)0);
    AppMethodBeat.o(228444);
  }
  
  public i()
  {
    AppMethodBeat.i(228443);
    this.mmo = a.aK(this);
    AppMethodBeat.o(228443);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment$invoke$3", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultInterceptCallback;", "onResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
  public static final class b
    implements f.c
  {
    b(WeakReference paramWeakReference, int paramInt) {}
    
    public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      paramInt2 = 0;
      AppMethodBeat.i(228441);
      if (i.a(this.mmq) != paramInt1)
      {
        AppMethodBeat.o(228441);
        return false;
      }
      c localc = (c)this.mmr.get();
      if (localc == null)
      {
        AppMethodBeat.o(228441);
        return true;
      }
      p.g(localc, "envRef.get() ?: return true");
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getSerializableExtra("key_result_pay_result");
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = (Serializable)e.f.a.OyY;
      }
      if (localObject1 == null)
      {
        paramIntent = new t("null cannot be cast to non-null type com.tencent.mm.ui.ConstantsUI.F2FAppBrandRemittanceUI.RESULT_TYPE");
        AppMethodBeat.o(228441);
        throw paramIntent;
      }
      Object localObject2 = (e.f.a)localObject1;
      if (paramIntent != null)
      {
        localObject1 = paramIntent.getStringExtra("key_result_error_msg");
        paramIntent = (Intent)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        paramIntent = "";
      }
      new StringBuilder("[onResult] result=").append(localObject2).append(", errorMsg").append(paramIntent);
      h.hkS();
      int i = this.lyo;
      Object localObject1 = this.mmq;
      switch (j.$EnumSwitchMapping$0[localObject2.ordinal()])
      {
      default: 
        paramIntent = new m();
        AppMethodBeat.o(228441);
        throw paramIntent;
      case 1: 
        paramIntent = "ok";
      }
      for (;;)
      {
        localc.i(i, ((i)localObject1).Zf(paramIntent));
        AppMethodBeat.o(228441);
        return true;
        paramInt1 = paramInt2;
        if (((CharSequence)paramIntent).length() == 0) {
          paramInt1 = 1;
        }
        if (paramInt1 != 0)
        {
          paramIntent = "fail";
        }
        else
        {
          paramIntent = "fail:".concat(String.valueOf(paramIntent));
          continue;
          paramIntent = "cancel";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.i
 * JD-Core Version:    0.7.0.1
 */