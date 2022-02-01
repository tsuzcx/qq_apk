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
import com.tencent.mm.cc.a;
import com.tencent.mm.plugin.appbrand.z.p.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.ui.ar;
import org.json.JSONException;
import org.json.JSONObject;

public class e
  implements g
{
  private Context mContext;
  private boolean pqo;
  private m tWk;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(211718);
    this.pqo = true;
    this.mContext = paramContext;
    this.tWk = f.b(null).Nt();
    this.tWk.a(1, new com.tencent.mm.plugin.appbrand.jsruntime.h()
    {
      public final void u(final String paramAnonymousString1, final String paramAnonymousString2)
      {
        AppMethodBeat.i(211715);
        ad.e("MicroMsg.LuggageGameJsRuntimeImpl", "handleException, message : %s\n, stackTrace : %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        if (e.a(e.this))
        {
          e.b(e.this);
          com.tencent.mm.ipcinvoker.p.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(211714);
              e.a(e.this, paramAnonymousString1 + "\n" + paramAnonymousString2);
              AppMethodBeat.o(211714);
            }
          }, 3000L);
          AppMethodBeat.o(211715);
          return;
        }
        e.a(e.this, paramAnonymousString1 + "\n" + paramAnonymousString2);
        AppMethodBeat.o(211715);
      }
    });
    addJavascriptInterface(new c(), "WxGameJsCoreNative");
    AppMethodBeat.o(211718);
  }
  
  public final void BP()
  {
    AppMethodBeat.i(211722);
    Object localObject = com.tencent.mm.plugin.appbrand.z.d.UT("luggage_mm_adapter.js");
    this.tWk.a((String)localObject, null);
    localObject = ar.ci(aj.getContext());
    int i = ((Point)localObject).y;
    int j = ar.dT(aj.getContext());
    int k = ar.jG(aj.getContext());
    int m = ar.ej(aj.getContext());
    float f = a.getDensity(aj.getContext());
    String str = ay.iR(aj.getContext());
    evaluateJavascript(String.format(com.tencent.mm.plugin.appbrand.z.d.UT("game_jscore_system_info.js"), new Object[] { String.valueOf(((Point)localObject).x), String.valueOf(i - j - k - m), String.valueOf(((Point)localObject).x), String.valueOf(((Point)localObject).y), String.valueOf(f), str, Build.BRAND, Build.MODEL, String.format("0x%08X", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.Fnj) }), "Android-" + Build.VERSION.SDK_INT, ac.iM(aj.getContext()) }), null);
    AppMethodBeat.o(211722);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(211720);
    this.tWk.a(paramObject, paramString, JavascriptInterface.class);
    AppMethodBeat.o(211720);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(211723);
    this.tWk.destroy();
    this.mContext = null;
    AppMethodBeat.o(211723);
  }
  
  public void evaluateJavascript(String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(211721);
    this.tWk.a(paramString, new m.b()
    {
      public final void a(String paramAnonymousString, m.c paramAnonymousc)
      {
        AppMethodBeat.i(211717);
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(paramAnonymousString);
        }
        AppMethodBeat.o(211717);
      }
    });
    AppMethodBeat.o(211721);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getUserAgent()
  {
    AppMethodBeat.i(211719);
    String str = com.tencent.mm.plugin.appbrand.z.p.a(this.mContext, "", (p.a)com.tencent.luggage.a.e.K(p.a.class)) + " luggage";
    AppMethodBeat.o(211719);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.e
 * JD-Core Version:    0.7.0.1
 */