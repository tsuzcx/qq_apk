package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.content.Intent;
import com.tencent.d.f.h;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.f.l.a;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import kotlin.l;
import kotlin.m;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestPersonalPay;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "REQUEST_C_TO_C_PAYMENT_RESULT_CODE", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"})
public final class p
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 976;
  public static final String NAME = "requestPersonalPay";
  public static final a pkB;
  private final int pkA;
  
  static
  {
    AppMethodBeat.i(268140);
    pkB = new a((byte)0);
    AppMethodBeat.o(268140);
  }
  
  public p()
  {
    AppMethodBeat.i(268139);
    this.pkA = a.aI(this);
    AppMethodBeat.o(268139);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestPersonalPay$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestPersonalPay$invoke$3", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultInterceptCallback;", "onResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
  public static final class b
    implements f.c
  {
    b(WeakReference paramWeakReference, int paramInt) {}
    
    public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      paramInt2 = 0;
      AppMethodBeat.i(273055);
      if (p.a(this.pkC) != paramInt1)
      {
        AppMethodBeat.o(273055);
        return false;
      }
      com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)this.pkw.get();
      if (localc == null)
      {
        AppMethodBeat.o(273055);
        return true;
      }
      kotlin.g.b.p.j(localc, "envRef.get() ?: return true");
      if (paramIntent != null)
      {
        localObject2 = paramIntent.getSerializableExtra("key_result_pay_result");
        localObject1 = localObject2;
        if (localObject2 != null) {}
      }
      else
      {
        localObject1 = (Serializable)f.l.a.VSu;
      }
      if (localObject1 == null)
      {
        paramIntent = new t("null cannot be cast to non-null type com.tencent.mm.ui.ConstantsUI.PersonalPayRemittanceUI.RESULT_TYPE");
        AppMethodBeat.o(273055);
        throw paramIntent;
      }
      Object localObject2 = (f.l.a)localObject1;
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
      h.ioq();
      int i = this.otk;
      Object localObject1 = this.pkC;
      switch (q.$EnumSwitchMapping$0[localObject2.ordinal()])
      {
      default: 
        paramIntent = new m();
        AppMethodBeat.o(273055);
        throw paramIntent;
      case 1: 
        paramIntent = "ok";
      }
      for (;;)
      {
        localc.j(i, ((p)localObject1).agS(paramIntent));
        AppMethodBeat.o(273055);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.p
 * JD-Core Version:    0.7.0.1
 */