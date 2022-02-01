package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.app.Activity;
import com.tencent.luggage.h.f.f;
import com.tencent.luggage.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

abstract class a<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.f>
  extends d<CONTEXT>
{
  boolean lWS;
  
  static boolean q(CONTEXT paramCONTEXT)
  {
    return i.n(paramCONTEXT.getContext(), "android.permission.ACCESS_FINE_LOCATION");
  }
  
  public void a(final CONTEXT paramCONTEXT, final JSONObject paramJSONObject, final int paramInt)
  {
    Activity localActivity;
    boolean bool;
    if ((paramCONTEXT.getContext() instanceof Activity))
    {
      localActivity = (Activity)paramCONTEXT.getContext();
      if (localActivity != null) {
        break label82;
      }
      Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "operateRecorder, pageContext is null");
      paramCONTEXT.i(paramInt, h("fail:internal error invalid android context", null));
      bool = false;
    }
    for (;;)
    {
      if (bool) {
        break label148;
      }
      Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s requestPermission fail", new Object[] { getName() });
      return;
      localActivity = null;
      break;
      label82:
      if (q(paramCONTEXT))
      {
        bool = true;
      }
      else if (this.lWS)
      {
        paramCONTEXT.i(paramInt, h("fail:system permission denied", null));
        bool = false;
      }
      else
      {
        bool = com.tencent.luggage.h.f.aK(localActivity).a("android.permission.ACCESS_FINE_LOCATION", new f.f()
        {
          public final void q(int[] paramAnonymousArrayOfInt)
          {
            AppMethodBeat.i(143625);
            if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
            {
              Log.i("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "PERMISSION_GRANTED, do invoke again");
              a.this.a(paramCONTEXT, paramJSONObject, paramInt);
              AppMethodBeat.o(143625);
              return;
            }
            Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "SYS_PERM_DENIED");
            a.this.lWS = true;
            paramCONTEXT.i(paramInt, a.this.h("fail:system permission denied", null));
            AppMethodBeat.o(143625);
          }
        });
      }
    }
    label148:
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s invalid data", new Object[] { getName() });
      paramCONTEXT.i(paramInt, h("fail:invalid data", null));
      return;
    }
    d(paramCONTEXT, paramJSONObject, paramInt);
  }
  
  protected abstract void d(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a
 * JD-Core Version:    0.7.0.1
 */