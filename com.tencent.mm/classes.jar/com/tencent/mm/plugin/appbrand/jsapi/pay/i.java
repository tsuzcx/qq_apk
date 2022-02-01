package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.content.Intent;
import com.tencent.d.f.h;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.ui.e.d.a;
import d.g.b.p;
import d.l;
import d.m;
import d.v;
import java.io.Serializable;
import java.lang.ref.WeakReference;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "REQUEST_FACE_TO_FACE_PAYMENT_RESULT_CODE", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"})
public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.a<c>
{
  public static final int CTRL_INDEX = 820;
  public static final String NAME = "requestFacetoFacePayment";
  public static final a ldi;
  private final int ldh;
  
  static
  {
    AppMethodBeat.i(189161);
    ldi = new a((byte)0);
    AppMethodBeat.o(189161);
  }
  
  public i()
  {
    AppMethodBeat.i(189160);
    this.ldh = com.tencent.luggage.sdk.g.a.aC(this);
    AppMethodBeat.o(189160);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment$invoke$3", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultInterceptCallback;", "onResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"})
  public static final class b
    implements e.c
  {
    b(WeakReference paramWeakReference, int paramInt) {}
    
    public final boolean b(int paramInt1, int paramInt2, Intent paramIntent)
    {
      paramInt2 = 0;
      AppMethodBeat.i(189158);
      if (i.a(this.ldj) != paramInt1)
      {
        AppMethodBeat.o(189158);
        return false;
      }
      c localc = (c)this.ldk.get();
      if (localc == null)
      {
        AppMethodBeat.o(189158);
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
        localObject1 = (Serializable)e.d.a.IUr;
      }
      if (localObject1 == null)
      {
        paramIntent = new v("null cannot be cast to non-null type com.tencent.mm.ui.ConstantsUI.F2FAppBrandRemittanceUI.RESULT_TYPE");
        AppMethodBeat.o(189158);
        throw paramIntent;
      }
      Object localObject2 = (e.d.a)localObject1;
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
      h.fUh();
      int i = this.krv;
      Object localObject1 = this.ldj;
      switch (j.cpQ[localObject2.ordinal()])
      {
      default: 
        paramIntent = new m();
        AppMethodBeat.o(189158);
        throw paramIntent;
      case 1: 
        paramIntent = "ok";
      }
      for (;;)
      {
        localc.h(i, ((i)localObject1).Pg(paramIntent));
        AppMethodBeat.o(189158);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.i
 * JD-Core Version:    0.7.0.1
 */