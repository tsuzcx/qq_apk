package com.tencent.mm.plugin.appbrand.jsapi.e;

import android.app.Activity;
import com.tencent.luggage.g.e;
import com.tencent.luggage.g.e.d;
import com.tencent.luggage.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

abstract class a<CONTEXT extends c>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<CONTEXT>
{
  boolean hMV;
  
  static boolean q(CONTEXT paramCONTEXT)
  {
    return g.o(paramCONTEXT.getContext(), "android.permission.ACCESS_FINE_LOCATION");
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
      ab.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "operateRecorder, pageContext is null");
      paramCONTEXT.h(paramInt, j("fail:internal error invalid android context", null));
      bool = false;
    }
    for (;;)
    {
      if (bool) {
        break label148;
      }
      ab.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s requestPermission fail", new Object[] { getName() });
      return;
      localActivity = null;
      break;
      label82:
      if (q(paramCONTEXT))
      {
        bool = true;
      }
      else if (this.hMV)
      {
        paramCONTEXT.h(paramInt, j("fail:system permission denied", null));
        bool = false;
      }
      else
      {
        bool = e.at(localActivity).a("android.permission.ACCESS_FINE_LOCATION", new e.d()
        {
          public final void n(int[] paramAnonymousArrayOfInt)
          {
            AppMethodBeat.i(93820);
            if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
            {
              ab.i("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "PERMISSION_GRANTED, do invoke again");
              a.this.a(paramCONTEXT, paramJSONObject, paramInt);
              AppMethodBeat.o(93820);
              return;
            }
            ab.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "SYS_PERM_DENIED");
            a.this.hMV = true;
            paramCONTEXT.h(paramInt, a.this.j("fail:system permission denied", null));
            AppMethodBeat.o(93820);
          }
        });
      }
    }
    label148:
    if (paramJSONObject == null)
    {
      ab.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s invalid data", new Object[] { getName() });
      paramCONTEXT.h(paramInt, j("fail:invalid data", null));
      return;
    }
    c(paramCONTEXT, paramJSONObject, paramInt);
  }
  
  protected abstract void c(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.e.a
 * JD-Core Version:    0.7.0.1
 */