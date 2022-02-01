package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import com.tencent.luggage.l.e;
import com.tencent.luggage.l.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import org.json.JSONObject;

public abstract class q
  extends r
{
  protected Activity activity;
  int rwy;
  
  public q(p paramp, y paramy, ad paramad, JSONObject paramJSONObject, int paramInt)
  {
    super(paramp, paramy, paramad, paramJSONObject, paramInt);
    this.activity = AndroidContextUtil.castActivityOrNull(paramy.getRuntime().mContext);
    if (this.activity == null) {
      throw new IllegalArgumentException("JsApiActivityResultRequest. Activity is null");
    }
    this.rwy = (paramp.hashCode() & 0xFFFF);
  }
  
  protected abstract void F(Intent paramIntent);
  
  protected abstract boolean a(Activity paramActivity, JSONObject paramJSONObject, int paramInt);
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.rwy != paramInt1) {
      return;
    }
    if (paramInt2 == -1)
    {
      F(paramIntent);
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
    e.bt(this.activity).b(new e.c()
    {
      public final boolean onResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
      {
        AppMethodBeat.i(174747);
        if (paramAnonymousInt1 == q.this.rwy)
        {
          q.this.mmOnActivityResult(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(174747);
          return true;
        }
        AppMethodBeat.o(174747);
        return false;
      }
    });
    if (!a(this.activity, cpO(), this.rwy)) {
      onError(-1, "fail:system error {{launch fail}}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.q
 * JD-Core Version:    0.7.0.1
 */