package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.f.a;
import org.json.JSONObject;

public abstract class n
  extends o
{
  protected Activity activity;
  int ktZ;
  
  public n(m paramm, r paramr, z paramz, JSONObject paramJSONObject, int paramInt)
  {
    super(paramm, paramr, paramz, paramJSONObject, paramInt);
    this.activity = a.jw(paramr.getRuntime().mContext);
    if (this.activity == null) {
      throw new IllegalArgumentException("JsApiActivityResultRequest. Activity is null");
    }
    this.ktZ = (paramm.hashCode() & 0xFFFF);
  }
  
  protected abstract void C(Intent paramIntent);
  
  protected abstract boolean a(Activity paramActivity, JSONObject paramJSONObject, int paramInt);
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.ktZ != paramInt1) {
      return;
    }
    if (paramInt2 == -1)
    {
      C(paramIntent);
      return;
    }
    if ((paramIntent != null) && (paramIntent.hasExtra("result_error_msg")))
    {
      onError(paramIntent.getIntExtra("result_error_code", -1), paramIntent.getStringExtra("result_error_msg"));
      return;
    }
    onError(-1, "fail:system error {{unknow error}}");
  }
  
  protected abstract void onError(int paramInt, String paramString);
  
  public final void run()
  {
    e.aB(this.activity).b(new e.c()
    {
      public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174747);
        if (paramAnonymousInt1 == n.this.ktZ)
        {
          n.this.c(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(174747);
          return true;
        }
        AppMethodBeat.o(174747);
        return false;
      }
    });
    if (!a(this.activity, biT(), this.ktZ)) {
      onError(-1, "fail:system error {{launch fail}}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n
 * JD-Core Version:    0.7.0.1
 */