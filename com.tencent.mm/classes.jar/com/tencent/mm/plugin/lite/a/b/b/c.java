package com.tencent.mm.plugin.lite.a.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.jsapi.b;
import com.tencent.mm.plugin.webview.jsapi.e;
import com.tencent.mm.plugin.webview.jsapi.g;
import com.tencent.mm.plugin.webview.jsapi.h;
import com.tencent.mm.plugin.webview.jsapi.p;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiClearFinderRedDot;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiGetFinderRedDot;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenFinderLiveIncome;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.JsApiOpenFinderLiveLottery;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.n;
import com.tencent.mm.plugin.webview.ui.tools.newjsapi.webprefetcher.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;

public final class c
{
  public HashMap<String, Class> Kae;
  
  public c()
  {
    AppMethodBeat.i(271543);
    this.Kae = new HashMap();
    long l = System.currentTimeMillis();
    Object localObject = b.WDu;
    b.its();
    aJX("scanQRCode");
    aJX("chooseImage");
    aJX("chooseMedia");
    aJX("getLocalImgData");
    aJX("closeWindowAndGoNext");
    aJX("closeWindow");
    aJX("addDownloadTask");
    aJX("launchGameVideoEditor");
    aJX("chooseHaowanMedia");
    aJX("publishHaowanEdition");
    aJX("queryHaowanPublish");
    aJX("imagePreview");
    localObject = JsApiOpenFinderLiveIncome.Xny;
    aJX(JsApiOpenFinderLiveIncome.idA);
    localObject = JsApiOpenFinderLiveLottery.Xnz;
    aJX(JsApiOpenFinderLiveLottery.idA);
    localObject = n.Xnf;
    aJX(n.idA);
    localObject = JsApiClearFinderRedDot.XmL;
    aJX(JsApiClearFinderRedDot.idA);
    localObject = JsApiGetFinderRedDot.Xnc;
    aJX(JsApiGetFinderRedDot.idA);
    Log.i("LiteAppJsApiBridgeWebViewJsApiPool", "init WebViewServiceJsApiPool takes %d ms", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    AppMethodBeat.o(271543);
  }
  
  private void aJX(String paramString)
  {
    AppMethodBeat.i(271550);
    this.Kae.put(paramString, a.class);
    AppMethodBeat.o(271550);
  }
  
  public static final class a
    implements g
  {
    private static final HashMap<String, com.tencent.mm.plugin.webview.jsapi.c.a> Kaf;
    private static a Kag;
    
    static
    {
      AppMethodBeat.i(271565);
      HashMap localHashMap = new HashMap();
      Kaf = localHashMap;
      d locald = d.Xoj;
      localHashMap.put(d.idA, d.Xoj);
      Kag = null;
      AppMethodBeat.o(271565);
    }
    
    public static a fUa()
    {
      AppMethodBeat.i(271557);
      if (Kag == null) {
        Kag = new a();
      }
      a locala = Kag;
      AppMethodBeat.o(271557);
      return locala;
    }
    
    public final boolean a(h paramh, p paramp)
    {
      AppMethodBeat.i(271570);
      if (Kaf.containsKey(paramp.function))
      {
        com.tencent.mm.plugin.webview.jsapi.c.a locala = (com.tencent.mm.plugin.webview.jsapi.c.a)Kaf.get(paramp.function);
        if ((locala != null) && (paramh.sk(locala.gPZ()))) {
          locala.a(paramh, paramp);
        }
        for (;;)
        {
          AppMethodBeat.o(271570);
          return true;
          Log.e("LiteAppJsApiBridgeWebViewJsApiPool", "handleMsg access denied func: %s", new Object[] { paramp.function });
          paramh.WDy.doCallback(paramp.WEH, "system:access_denied", null);
        }
      }
      AppMethodBeat.o(271570);
      return false;
    }
    
    public final boolean b(h paramh, p paramp)
    {
      AppMethodBeat.i(271574);
      if ((!Kaf.isEmpty()) && (paramh.WDy.itt() == this))
      {
        AppMethodBeat.o(271574);
        return true;
      }
      AppMethodBeat.o(271574);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.a.b.b.c
 * JD-Core Version:    0.7.0.1
 */