package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public abstract class p
  extends q
{
  protected Activity activity;
  int osC;
  
  public p(o paramo, v paramv, ad paramad, JSONObject paramJSONObject, int paramInt)
  {
    super(paramo, paramv, paramad, paramJSONObject, paramInt);
    this.activity = AndroidContextUtil.castActivityOrNull(paramv.getRuntime().mContext);
    if (this.activity == null) {
      throw new IllegalArgumentException("JsApiActivityResultRequest. Activity is null");
    }
    this.osC = (paramo.hashCode() & 0xFFFF);
  }
  
  protected abstract void D(Intent paramIntent);
  
  protected abstract boolean a(Activity paramActivity, JSONObject paramJSONObject, int paramInt);
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.osC != paramInt1) {
      return;
    }
    if (paramInt2 == -1)
    {
      D(paramIntent);
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
    f.aI(this.activity).b(new f.c()
    {
      public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174747);
        if (paramAnonymousInt1 == p.this.osC)
        {
          p.this.d(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(174747);
          return true;
        }
        AppMethodBeat.o(174747);
        return false;
      }
    });
    if (!a(this.activity, bPH(), this.osC)) {
      onError(-1, "fail:system error {{launch fail}}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.p
 * JD-Core Version:    0.7.0.1
 */