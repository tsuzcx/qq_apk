package com.tencent.mm.plugin.game.luggage.i;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.os.Build.VERSION;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import com.tencent.luggage.d.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.appbrand.v8.m;
import com.tencent.mm.appbrand.v8.m.b;
import com.tencent.mm.appbrand.v8.m.c;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.ax;

public class e
  implements g
{
  private m CDJ;
  private Context mContext;
  private boolean unx;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(231238);
    this.unx = true;
    this.mContext = paramContext;
    this.CDJ = com.tencent.mm.appbrand.v8.f.b(null).acd();
    this.CDJ.a(1, new com.tencent.mm.plugin.appbrand.m.h()
    {
      public final void A(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(231384);
        Log.e("MicroMsg.LuggageGameJsRuntimeImpl", "handleException, message : %s\n, stackTrace : %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        paramAnonymousString1 = String.format("try {WxGameJsCoreBridge.invokeError(\"%s\");} catch(e) {console.log(e);}", new Object[] { org.apache.commons.b.f.bIi("exception : " + paramAnonymousString1 + " ; stack : " + paramAnonymousString2) });
        Log.i("MicroMsg.LuggageGameJsRuntimeImpl", "handleException, js = %s", new Object[] { paramAnonymousString1 });
        e.this.evaluateJavascript(paramAnonymousString1, null);
        AppMethodBeat.o(231384);
      }
    });
    addJavascriptInterface(new c(), "WxGameJsCoreNative");
    AppMethodBeat.o(231238);
  }
  
  public final void NV()
  {
    AppMethodBeat.i(231246);
    Object localObject = com.tencent.mm.plugin.appbrand.ac.d.anc("luggage_mm_adapter.js");
    this.CDJ.a((String)localObject, null);
    localObject = ax.au(MMApplicationContext.getContext());
    int i = ((Point)localObject).y;
    int j = ax.ew(MMApplicationContext.getContext());
    int k = ax.getStatusBarHeight(MMApplicationContext.getContext());
    int m = ax.aB(MMApplicationContext.getContext());
    float f = a.getDensity(MMApplicationContext.getContext());
    String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    evaluateJavascript(String.format(com.tencent.mm.plugin.appbrand.ac.d.anc("game_jscore_system_info.js"), new Object[] { String.valueOf(((Point)localObject).x), String.valueOf(i - j - k - m), String.valueOf(((Point)localObject).x), String.valueOf(((Point)localObject).y), String.valueOf(f), str, Build.BRAND, Build.MODEL, String.format("0x%08X", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.RAD) }), "Android-" + Build.VERSION.SDK_INT, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), Boolean.valueOf(ar.isDarkMode()) }), null);
    AppMethodBeat.o(231246);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(231241);
    this.CDJ.a(paramObject, paramString, JavascriptInterface.class);
    AppMethodBeat.o(231241);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(231248);
    this.CDJ.destroy();
    this.mContext = null;
    AppMethodBeat.o(231248);
  }
  
  public void evaluateJavascript(String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(231242);
    this.CDJ.a(paramString, new m.b()
    {
      public final void a(String paramAnonymousString, m.c paramAnonymousc)
      {
        AppMethodBeat.i(231723);
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(paramAnonymousString);
        }
        AppMethodBeat.o(231723);
      }
    });
    AppMethodBeat.o(231242);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getUserAgent()
  {
    AppMethodBeat.i(231240);
    String str = p.a(MMApplicationContext.getContext(), "", (p.a)com.tencent.luggage.a.e.K(p.a.class)) + " v8";
    AppMethodBeat.o(231240);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i.e
 * JD-Core Version:    0.7.0.1
 */