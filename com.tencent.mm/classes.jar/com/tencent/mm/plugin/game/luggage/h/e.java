package com.tencent.mm.plugin.game.luggage.h;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.luggage.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.f;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.y.p.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.ui.ar;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements g
{
  private Context mContext;
  private boolean pwU;
  private m uhi;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(193117);
    this.pwU = true;
    this.mContext = paramContext;
    this.uhi = f.b(null).No();
    this.uhi.a(1, new com.tencent.mm.plugin.appbrand.jsruntime.h()
    {
      public final void u(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(193114);
        ae.e("MicroMsg.LuggageGameJsRuntimeImpl", "handleException, message : %s\n, stackTrace : %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        if (e.a(e.this))
        {
          e.b(e.this);
          com.tencent.mm.ipcinvoker.p.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(193113);
              e.a(e.this, paramAnonymousString1 + "\n" + paramAnonymousString2);
              AppMethodBeat.o(193113);
            }
          }, 3000L);
          AppMethodBeat.o(193114);
          return;
        }
        e.a(e.this, paramAnonymousString1 + "\n" + paramAnonymousString2);
        AppMethodBeat.o(193114);
      }
    });
    addJavascriptInterface(new c(), "WxGameJsCoreNative");
    AppMethodBeat.o(193117);
  }
  
  public final void BQ()
  {
    AppMethodBeat.i(193121);
    Object localObject = com.tencent.mm.plugin.appbrand.y.d.VE("luggage_mm_adapter.js");
    this.uhi.a((String)localObject, null);
    localObject = ar.ck(ak.getContext());
    int i = ((Point)localObject).y;
    int j = ar.dX(ak.getContext());
    int k = ar.jN(ak.getContext());
    int m = ar.en(ak.getContext());
    float f = a.getDensity(ak.getContext());
    String str = az.iW(ak.getContext());
    evaluateJavascript(String.format(com.tencent.mm.plugin.appbrand.y.d.VE("game_jscore_system_info.js"), new Object[] { String.valueOf(((Point)localObject).x), String.valueOf(i - j - k - m), String.valueOf(((Point)localObject).x), String.valueOf(((Point)localObject).y), String.valueOf(f), str, Build.BRAND, Build.MODEL, String.format("0x%08X", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.FFH) }), "Android-" + Build.VERSION.SDK_INT, ad.iR(ak.getContext()) }), null);
    AppMethodBeat.o(193121);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(193119);
    this.uhi.a(paramObject, paramString, JavascriptInterface.class);
    AppMethodBeat.o(193119);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(193122);
    this.uhi.destroy();
    this.mContext = null;
    AppMethodBeat.o(193122);
  }
  
  public void evaluateJavascript(String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(193120);
    this.uhi.a(paramString, new m.b()
    {
      public final void a(String paramAnonymousString, m.c paramAnonymousc)
      {
        AppMethodBeat.i(193116);
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(paramAnonymousString);
        }
        AppMethodBeat.o(193116);
      }
    });
    AppMethodBeat.o(193120);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getUserAgent()
  {
    AppMethodBeat.i(193118);
    String str = com.tencent.mm.plugin.appbrand.y.p.a(this.mContext, "", (p.a)com.tencent.luggage.a.e.K(p.a.class)) + " luggage";
    AppMethodBeat.o(193118);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.e
 * JD-Core Version:    0.7.0.1
 */