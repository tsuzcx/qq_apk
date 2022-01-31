package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.d.f.a;
import com.tencent.mm.plugin.appbrand.jsapi.l;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.bk;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class i$3
  implements ae
{
  public i$3(i parami, WeakReference paramWeakReference, c paramc, int paramInt, String paramString) {}
  
  public final void a(String paramString, int paramInt, ae.a parama)
  {
    for (;;)
    {
      try
      {
        q localq = (q)this.gro.get();
        if (localq == null) {
          return;
        }
        JSONObject localJSONObject = new JSONObject().put("value", paramString).put("keyCode", ((aa)this.htx.arH()).getLastKeyPressed()).put("inputId", this.grq).put("cursor", paramInt);
        if (ae.a.hvK.equals(parama))
        {
          paramString = new f.a();
          paramString.a(localq.getRuntime().Zy(), localq.hashCode()).dispatch();
          paramString.tL(localJSONObject.put("data", this.hty).toString());
          paramString.dispatch();
          return;
        }
        switch (i.5.htz[parama.ordinal()])
        {
        case 2: 
          if (!bk.bl(paramString))
          {
            localq.i(paramString, localJSONObject.toString(), 0);
            return;
            paramString = "onKeyboardConfirm";
            continue;
          }
          return;
        }
      }
      catch (Exception paramString)
      {
        return;
      }
      paramString = null;
      continue;
      paramString = "onKeyboardComplete";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.i.3
 * JD-Core Version:    0.7.0.1
 */