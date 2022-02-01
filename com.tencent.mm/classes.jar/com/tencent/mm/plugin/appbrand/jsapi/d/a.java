package com.tencent.mm.plugin.appbrand.jsapi.d;

import android.app.Activity;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.e;
import com.tencent.luggage.h.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

abstract class a<CONTEXT extends c>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<CONTEXT>
{
  boolean ksS;
  
  static boolean q(CONTEXT paramCONTEXT)
  {
    return h.o(paramCONTEXT.getContext(), "android.permission.ACCESS_FINE_LOCATION");
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
      ac.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "operateRecorder, pageContext is null");
      paramCONTEXT.h(paramInt, e("fail:internal error invalid android context", null));
      bool = false;
    }
    for (;;)
    {
      if (bool) {
        break label148;
      }
      ac.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s requestPermission fail", new Object[] { getName() });
      return;
      localActivity = null;
      break;
      label82:
      if (q(paramCONTEXT))
      {
        bool = true;
      }
      else if (this.ksS)
      {
        paramCONTEXT.h(paramInt, e("fail:system permission denied", null));
        bool = false;
      }
      else
      {
        bool = e.aA(localActivity).a("android.permission.ACCESS_FINE_LOCATION", new e.e()
        {
          public final void p(int[] paramAnonymousArrayOfInt)
          {
            AppMethodBeat.i(143625);
            if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
            {
              ac.i("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "PERMISSION_GRANTED, do invoke again");
              a.this.a(paramCONTEXT, paramJSONObject, paramInt);
              AppMethodBeat.o(143625);
              return;
            }
            ac.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "SYS_PERM_DENIED");
            a.this.ksS = true;
            paramCONTEXT.h(paramInt, a.this.e("fail:system permission denied", null));
            AppMethodBeat.o(143625);
          }
        });
      }
    }
    label148:
    if (paramJSONObject == null)
    {
      ac.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s invalid data", new Object[] { getName() });
      paramCONTEXT.h(paramInt, e("fail:invalid data", null));
      return;
    }
    d(paramCONTEXT, paramJSONObject, paramInt);
  }
  
  protected abstract void d(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.d.a
 * JD-Core Version:    0.7.0.1
 */