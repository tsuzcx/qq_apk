package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.model.OpenImKefuStartChattingResultReceiver.b;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/customer_service/JsApiOpenCustomerServiceChat$openCustomerServiceChat$request$1$4", "Lcom/tencent/mm/openim/model/OpenImKefuStartChattingResultReceiver$ReceiveResultCallback;", "hasShownConfirmPage", "", "onReceiveResult", "", "resultData", "Landroid/os/Bundle;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$b
  implements OpenImKefuStartChattingResultReceiver.b
{
  private boolean rUh;
  
  a$b(a parama, y paramy, int paramInt) {}
  
  private static final void b(a parama, y paramy, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(325630);
    s.u(parama, "this$0");
    s.u(paramString, "$errMsg");
    a.a(parama, paramy, paramInt1, paramInt2, paramString);
    AppMethodBeat.o(325630);
  }
  
  public final void R(Bundle paramBundle)
  {
    AppMethodBeat.i(325640);
    if (paramBundle == null)
    {
      AppMethodBeat.o(325640);
      return;
    }
    int i = paramBundle.getInt("result_key_action", -1);
    if (i < 0)
    {
      AppMethodBeat.o(325640);
      return;
    }
    int j = paramBundle.getInt("result_key_err_code", -1);
    Object localObject = paramBundle.getString("result_key_err_msg");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    Log.i("MicroMsg.JsApiOpenCustomerServiceChat", "openCustomerServiceChat onReceiveResult action: " + i + ", errCode: " + j + ", errMsg: " + paramBundle);
    switch (i)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(325640);
      return;
      a.a(this.rUi, this.rKC, this.rxe, j, paramBundle);
      AppMethodBeat.o(325640);
      return;
      this.rUh = true;
      AppMethodBeat.o(325640);
      return;
      a.a(this.rUi, this.rKC, this.rxe, j, paramBundle);
      AppMethodBeat.o(325640);
      return;
      a.a(this.rUi, this.rKC, this.rxe, j, paramBundle);
      AppMethodBeat.o(325640);
      return;
      localObject = h.ahAA;
      paramBundle = new a.b..ExternalSyntheticLambda0(this.rUi, this.rKC, this.rxe, j, paramBundle);
      if (this.rUh) {}
      for (long l = 0L;; l = 1000L)
      {
        ((i)localObject).o(paramBundle, l);
        AppMethodBeat.o(325640);
        return;
      }
      a.a(this.rUi, this.rKC, this.rxe, j, paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.a.b
 * JD-Core Version:    0.7.0.1
 */