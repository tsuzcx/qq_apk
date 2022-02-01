package com.tencent.mm.plugin.appbrand.jsapi.pay;

import android.content.Intent;
import com.tencent.e.f.h;
import com.tencent.luggage.l.e.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.f.g.a;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/service/AppBrandServiceWC;", "()V", "REQUEST_FACE_TO_FACE_PAYMENT_RESULT_CODE", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.service.c>
{
  public static final int CTRL_INDEX = 820;
  public static final String NAME = "requestFacetoFacePayment";
  public static final a spu;
  private final int spv;
  
  static
  {
    AppMethodBeat.i(327842);
    spu = new a((byte)0);
    AppMethodBeat.o(327842);
  }
  
  public i()
  {
    AppMethodBeat.i(327836);
    this.spv = a.ce(this);
    AppMethodBeat.o(327836);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/pay/JsApiRequestFaceToFacePayment$invoke$3", "Lcom/tencent/luggage/util/LuggageActivityHelper$ActivityResultInterceptCallback;", "onResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements e.c
  {
    b(i parami, WeakReference<com.tencent.mm.plugin.appbrand.service.c> paramWeakReference, int paramInt) {}
    
    public final boolean onResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      paramInt2 = 0;
      AppMethodBeat.i(327831);
      if (i.a(this.spw) != paramInt1)
      {
        AppMethodBeat.o(327831);
        return false;
      }
      com.tencent.mm.plugin.appbrand.service.c localc = (com.tencent.mm.plugin.appbrand.service.c)this.spx.get();
      if (localc == null)
      {
        AppMethodBeat.o(327831);
        return true;
      }
      Object localObject1;
      label56:
      Object localObject2;
      if (paramIntent == null)
      {
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = (Serializable)f.g.a.adwj;
        }
        localObject2 = (f.g.a)localObject2;
        if (paramIntent != null) {
          break label186;
        }
        paramIntent = "";
      }
      int i;
      for (;;)
      {
        new StringBuilder("[onResult] result=").append(localObject2).append(", errorMsg").append(paramIntent);
        h.jXD();
        i = this.rxe;
        localObject1 = this.spw;
        switch (j.a.$EnumSwitchMapping$0[localObject2.ordinal()])
        {
        default: 
          paramIntent = new p();
          AppMethodBeat.o(327831);
          throw paramIntent;
          localObject1 = paramIntent.getSerializableExtra("key_result_pay_result");
          break label56;
          label186:
          localObject1 = paramIntent.getStringExtra("key_result_error_msg");
          paramIntent = (Intent)localObject1;
          if (localObject1 == null) {
            paramIntent = "";
          }
          break;
        }
      }
      paramIntent = "ok";
      for (;;)
      {
        localc.callback(i, ((i)localObject1).ZP(paramIntent));
        AppMethodBeat.o(327831);
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
          paramIntent = s.X("fail:", paramIntent);
          continue;
          paramIntent = "cancel";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.pay.i
 * JD-Core Version:    0.7.0.1
 */