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
import com.tencent.mm.cd.a;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.appbrand.af.r;
import com.tencent.mm.plugin.appbrand.af.r.a;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;

public class e
  implements g
{
  private m IxO;
  private Context mContext;
  private boolean xtT;
  
  public e(Context paramContext)
  {
    AppMethodBeat.i(276972);
    this.xtT = true;
    this.mContext = paramContext;
    this.IxO = f.b(null).aEc();
    this.IxO.a(1, new com.tencent.mm.plugin.appbrand.n.h()
    {
      public final void handleException(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(276997);
        Log.e("MicroMsg.LuggageGameJsRuntimeImpl", "handleException, message : %s\n, stackTrace : %s", new Object[] { paramAnonymousString1, paramAnonymousString2 });
        paramAnonymousString1 = String.format("try {WxGameJsCoreBridge.invokeError(\"%s\");} catch(e) {console.log(e);}", new Object[] { org.apache.commons.c.h.bLc("exception : " + paramAnonymousString1 + " ; stack : " + paramAnonymousString2) });
        Log.i("MicroMsg.LuggageGameJsRuntimeImpl", "handleException, js = %s", new Object[] { paramAnonymousString1 });
        e.this.evaluateJavascript(paramAnonymousString1, null);
        AppMethodBeat.o(276997);
      }
    });
    addJavascriptInterface(new c(), "WxGameJsCoreNative");
    AppMethodBeat.o(276972);
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    AppMethodBeat.i(276986);
    this.IxO.a(paramObject, paramString, JavascriptInterface.class);
    AppMethodBeat.o(276986);
  }
  
  public final void aof()
  {
    AppMethodBeat.i(276996);
    Object localObject = com.tencent.mm.plugin.appbrand.af.d.ags("luggage_mm_adapter.js");
    this.IxO.a((String)localObject, null);
    localObject = bf.bf(MMApplicationContext.getContext());
    int i = ((Point)localObject).y;
    int j = bf.fs(MMApplicationContext.getContext());
    int k = bf.getStatusBarHeight(MMApplicationContext.getContext());
    int m = bf.bk(MMApplicationContext.getContext());
    float f = a.getDensity(MMApplicationContext.getContext());
    String str = NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext());
    evaluateJavascript(String.format(com.tencent.mm.plugin.appbrand.af.d.ags("game_jscore_system_info.js"), new Object[] { String.valueOf(((Point)localObject).x), String.valueOf(i - j - k - m), String.valueOf(((Point)localObject).x), String.valueOf(((Point)localObject).y), String.valueOf(f), str, Build.BRAND, q.aPo(), String.format("0x%08X", new Object[] { Integer.valueOf(com.tencent.mm.protocal.d.Yxh) }), "Android-" + Build.VERSION.SDK_INT, LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()), Boolean.valueOf(aw.isDarkMode()) }), null);
    AppMethodBeat.o(276996);
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(276999);
    this.IxO.destroy();
    this.mContext = null;
    AppMethodBeat.o(276999);
  }
  
  public void evaluateJavascript(String paramString, final ValueCallback<String> paramValueCallback)
  {
    AppMethodBeat.i(276990);
    this.IxO.a(paramString, new m.b()
    {
      public final void onResult(String paramAnonymousString, m.c paramAnonymousc)
      {
        AppMethodBeat.i(276998);
        if (paramValueCallback != null) {
          paramValueCallback.onReceiveValue(paramAnonymousString);
        }
        AppMethodBeat.o(276998);
      }
    });
    AppMethodBeat.o(276990);
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public String getUserAgent()
  {
    AppMethodBeat.i(276979);
    String str = r.a(MMApplicationContext.getContext(), "", (r.a)com.tencent.luggage.a.e.T(r.a.class)) + " v8";
    AppMethodBeat.o(276979);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.h.e
 * JD-Core Version:    0.7.0.1
 */