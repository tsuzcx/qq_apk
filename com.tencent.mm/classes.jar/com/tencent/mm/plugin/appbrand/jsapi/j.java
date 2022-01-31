package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.n;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import org.json.JSONObject;

public abstract class j
  extends k
  implements MMActivity.a
{
  protected MMActivity gfb;
  private int gfc;
  
  public j(i parami, o paramo, q paramq, JSONObject paramJSONObject, int paramInt)
  {
    super(parami, paramo, paramq, paramJSONObject, paramInt);
    paramo = paramo.getRuntime().Zz();
    if (paramo == null) {
      paramo = null;
    }
    for (;;)
    {
      this.gfb = paramo;
      if (this.gfb != null) {
        break;
      }
      throw new IllegalArgumentException("JsApiActivityResultRequest. Activity is null");
      paramo = paramo.getContext();
      if (!(paramo instanceof MMActivity)) {
        paramo = null;
      } else {
        paramo = (MMActivity)paramo;
      }
    }
    this.gfc = (parami.hashCode() & 0xFFFF);
  }
  
  public abstract boolean a(MMActivity paramMMActivity, JSONObject paramJSONObject, int paramInt);
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.gfc != paramInt1) {
      return;
    }
    if (paramInt2 == -1)
    {
      n(paramIntent);
      return;
    }
    if ((paramIntent != null) && (paramIntent.hasExtra("result_error_msg")))
    {
      onError(paramIntent.getIntExtra("result_error_code", -1), paramIntent.getStringExtra("result_error_msg"));
      return;
    }
    onError(-1, "fail:system error {{unknow error}}");
  }
  
  public abstract void n(Intent paramIntent);
  
  public abstract void onError(int paramInt, String paramString);
  
  public final void run()
  {
    this.gfb.gJb = this;
    if (!a(this.gfb, ahN(), this.gfc)) {
      onError(-1, "fail:system error {{launch fail}}");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j
 * JD-Core Version:    0.7.0.1
 */