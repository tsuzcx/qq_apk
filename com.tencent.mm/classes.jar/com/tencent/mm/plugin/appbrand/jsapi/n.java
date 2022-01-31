package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public abstract class n
  extends o
  implements MMActivity.a
{
  protected MMActivity hwZ;
  private int hxa;
  
  public n(m paramm, com.tencent.mm.plugin.appbrand.r paramr, v paramv, JSONObject paramJSONObject, int paramInt)
  {
    super(paramm, paramr, paramv, paramJSONObject, paramInt);
    paramr = paramr.getRuntime().atj();
    if (paramr == null) {
      paramr = null;
    }
    for (;;)
    {
      this.hwZ = paramr;
      if (this.hwZ != null) {
        break;
      }
      throw new IllegalArgumentException("JsApiActivityResultRequest. Activity is null");
      paramr = paramr.getContext();
      if (!(paramr instanceof MMActivity)) {
        paramr = null;
      } else {
        paramr = (MMActivity)paramr;
      }
    }
    this.hxa = (paramm.hashCode() & 0xFFFF);
  }
  
  protected abstract void D(Intent paramIntent);
  
  protected abstract boolean a(MMActivity paramMMActivity, JSONObject paramJSONObject, int paramInt);
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.hxa != paramInt1) {
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
    this.hwZ.mmSetOnActivityResultCallback(this);
    if (!a(this.hwZ, aBw(), this.hxa)) {
      onError(-1, "fail:system error {{launch fail}}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.n
 * JD-Core Version:    0.7.0.1
 */