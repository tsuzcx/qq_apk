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
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.ac.p;
import com.tencent.mm.plugin.appbrand.ac.p.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.au;

public class e
  implements g
{
  private Context mContext;
  private boolean qMl;
  private m xzE;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(187015);
    this.qMl = true;
    this.mContext = paramContext;
    this.xzE = com.tencent.mm.appbrand.v8.f.b(null).XA();
    this.xzE.a(1, new com.tencent.mm.plugin.appbrand.m.h()
    {
      public final void u(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(187013);
        Log.e("MicroMsg.LuggageGameJsRuntimeImpl", "handleException, message : %s\n, stackTrace : %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        paramAnonymousString1 = String.format("try {WxGameJsCoreBridge.invokeError(\"%s\");} catch(e) {console.log(e);}", new Object[] { org.apache.commons.b.f.bve("exception : " + paramAnonymousString1 + " ; stack : " + paramAnonymousString2) });
        Log.i("MicroMsg.LuggageGameJsRuntimeImpl", "handleException, js = %s", new Object[] { paramAnonymousString1 });
        e.this.evaluateJavascript(paramAnonymousString1, null);
        AppMethodBeat.o(187013);
      }
    });
    addJavascriptInterface(new c(), "WxGameJsCoreNative");
    AppMethodBeat.o(187015);
  }
  
  public final void Le()
  {
    AppMethodBeat.i(187019);
    Object localObject = com.tencent.mm.plugin.appbrand.ac.d.afA("luggage_mm_adapter.js");
    this.xzE.a((String)localObject, null);
    localObject = au.az(MMApplicationContext.getContext());
    int i = ((Point)localObject).y;
    int j = au.eu(MMApplicationContext.getContext());
    int k = au.getStatusBarHeight(MMApplicationContext.getContext());
    int m = au.aD(MMApplicationContext.getContext());
    float f = a.getDensity(MMApplicationContext.getContext());
    String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    evaluateJavascript(String.format(com.tencent.mm.plugin.appbrand.ac.d.afA("game_jscore_system_info.js"), new Object[] { String.valueOf(((Point)localObject).x), String.valueOf(i - j - k - m), String.valueOf(((Point)localObject).x), String.valueOf(((Point)localObject).y), String.valueOf(f), str, Build.BRAND, Build.MODEL, String.format("0x%08X", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.KyO) }), "Android-" + Build.VERSION.SDK_INT, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), Boolean.valueOf(ao.isDarkMode()) }), null);
    AppMethodBeat.o(187019);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(187017);
    this.xzE.a(paramObject, paramString, JavascriptInterface.class);
    AppMethodBeat.o(187017);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(187020);
    this.xzE.destroy();
    this.mContext = null;
    AppMethodBeat.o(187020);
  }
  
  public void evaluateJavascript(String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(187018);
    this.xzE.a(paramString, new m.b()
    {
      public final void a(String paramAnonymousString, m.c paramAnonymousc)
      {
        AppMethodBeat.i(187014);
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(paramAnonymousString);
        }
        AppMethodBeat.o(187014);
      }
    });
    AppMethodBeat.o(187018);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getUserAgent()
  {
    AppMethodBeat.i(187016);
    String str = p.a(MMApplicationContext.getContext(), "", (p.a)com.tencent.luggage.a.e.M(p.a.class)) + " v8";
    AppMethodBeat.o(187016);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.i.e
 * JD-Core Version:    0.7.0.1
 */