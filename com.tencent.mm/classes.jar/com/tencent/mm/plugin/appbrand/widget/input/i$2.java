package com.tencent.mm.plugin.appbrand.widget.input;

import android.widget.EditText;
import com.tencent.mm.plugin.appbrand.jsapi.d.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class i$2
  implements aa.b
{
  public i$2(i parami, WeakReference paramWeakReference, c paramc, String paramString) {}
  
  public final boolean mK(int paramInt)
  {
    if (paramInt == 67)
    {
      q localq = (q)this.gro.get();
      if (localq != null) {}
      try
      {
        paramInt = this.htx.hsX;
        f.a locala = new f.a();
        JSONObject localJSONObject = new JSONObject().put("value", this.htx.arH().getText().toString()).put("data", this.hty).put("cursor", 0).put("inputId", paramInt).put("keyCode", 8);
        locala.a(localq.getRuntime().Zy(), localq.hashCode()).tL(localJSONObject.toString()).dispatch();
        return true;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          y.e("MicroMsg.AppBrandInputJsApiHandler", "onKeyUpPostIme DEL, e = %s", new Object[] { localException });
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.2
 * JD-Core Version:    0.7.0.1
 */