package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.app.Activity;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.f;
import com.tencent.luggage.l.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

abstract class a<CONTEXT extends f>
  extends c<CONTEXT>
{
  boolean rZS;
  
  static boolean u(CONTEXT paramCONTEXT)
  {
    return i.a(paramCONTEXT.getContext(), paramCONTEXT, "android.permission.ACCESS_FINE_LOCATION");
  }
  
  public void a(final CONTEXT paramCONTEXT, final JSONObject paramJSONObject, final int paramInt)
  {
    Activity localActivity;
    boolean bool;
    if ((paramCONTEXT.getContext() instanceof Activity))
    {
      localActivity = (Activity)paramCONTEXT.getContext();
      if (localActivity != null) {
        break label81;
      }
      Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "operateRecorder, pageContext is null");
      paramCONTEXT.callback(paramInt, ZP("fail:internal error invalid android context"));
      bool = false;
    }
    for (;;)
    {
      if (bool) {
        break label147;
      }
      Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s requestPermission fail", new Object[] { getName() });
      return;
      localActivity = null;
      break;
      label81:
      if (u(paramCONTEXT))
      {
        bool = true;
      }
      else if (this.rZS)
      {
        paramCONTEXT.callback(paramInt, ZP("fail:system permission denied"));
        bool = false;
      }
      else
      {
        bool = e.bt(localActivity).a(paramCONTEXT, "android.permission.ACCESS_FINE_LOCATION", new e.f()
        {
          public final void onResult(String[] paramAnonymousArrayOfString, int[] paramAnonymousArrayOfInt)
          {
            AppMethodBeat.i(329209);
            if ((paramAnonymousArrayOfInt != null) && (paramAnonymousArrayOfInt.length > 0) && (paramAnonymousArrayOfInt[0] == 0))
            {
              Log.i("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "PERMISSION_GRANTED, do invoke again");
              a.this.a(paramCONTEXT, paramJSONObject, paramInt);
              AppMethodBeat.o(329209);
              return;
            }
            Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "SYS_PERM_DENIED");
            a.this.rZS = true;
            paramCONTEXT.callback(paramInt, a.this.ZP("fail:system permission denied"));
            AppMethodBeat.o(329209);
          }
        });
      }
    }
    label147:
    if (paramJSONObject == null)
    {
      Log.e("MicroMsg.AppBrand.BaseLbsAsyncJsApi", "%s invalid data", new Object[] { getName() });
      paramCONTEXT.callback(paramInt, ZP("fail:invalid data"));
      return;
    }
    d(paramCONTEXT, paramJSONObject, paramInt);
  }
  
  protected abstract void d(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.a
 * JD-Core Version:    0.7.0.1
 */