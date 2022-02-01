package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.e;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiRequestSnsPayment;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentWithExtra;", "()V", "activityRequestCode", "", "invoke", "", "env", "param", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cu
  extends c<k>
{
  private static final int CTRL_INDEX;
  private static final String NAME;
  public static final a rAx;
  private final int rAy;
  
  static
  {
    AppMethodBeat.i(325461);
    rAx = new a((byte)0);
    NAME = "requestSnsPayment";
    CTRL_INDEX = 1087;
    AppMethodBeat.o(325461);
  }
  
  public cu()
  {
    AppMethodBeat.i(325451);
    this.rAy = a.ce(this);
    AppMethodBeat.o(325451);
  }
  
  private static final boolean a(cu paramcu, k paramk, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    int i = 0;
    AppMethodBeat.i(325458);
    s.u(paramcu, "this$0");
    Log.i("MicroMsg.JsApiRequestSnsPayment", "on Activity result: %s", new Object[] { Integer.valueOf(paramInt3) });
    if (paramInt2 != paramcu.rAy)
    {
      AppMethodBeat.o(325458);
      return false;
    }
    Object localObject1;
    label79:
    Object localObject2;
    if (paramIntent != null)
    {
      localObject1 = paramIntent.getStringExtra("ret");
      if (localObject1 != null) {
        if (paramInt3 == -1)
        {
          paramInt2 = 1;
          if (paramInt2 == 0) {
            break label170;
          }
          if (localObject1 != null) {
            break label176;
          }
          localObject2 = "fail";
          label88:
          if (localObject1 == null) {
            break label183;
          }
          localObject1 = a.e.rVt;
          label98:
          paramk.callback(paramInt1, paramcu.a((String)localObject2, (a.d)localObject1, null));
          paramcu = paramk.getRuntime();
          paramInt1 = i;
          if (paramIntent != null)
          {
            paramInt1 = i;
            if (paramIntent.getIntExtra("closeWindow", 0) == 1) {
              paramInt1 = 1;
            }
          }
          if (paramInt1 == 0) {
            break label191;
          }
        }
      }
    }
    for (;;)
    {
      if (paramcu != null) {
        paramcu.close();
      }
      AppMethodBeat.o(325458);
      return true;
      paramInt2 = 0;
      break;
      label170:
      localObject1 = null;
      break label79;
      label176:
      localObject2 = localObject1;
      break label88;
      label183:
      localObject1 = a.e.rVx;
      break label98;
      label191:
      paramcu = null;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiRequestSnsPayment$Companion;", "", "()V", "CTRL_INDEX", "", "getCTRL_INDEX$annotations", "getCTRL_INDEX", "()I", "NAME", "", "getNAME$annotations", "getNAME", "()Ljava/lang/String;", "TAG", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.cu
 * JD-Core Version:    0.7.0.1
 */