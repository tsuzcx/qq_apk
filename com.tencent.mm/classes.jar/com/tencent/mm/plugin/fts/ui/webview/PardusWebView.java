package com.tencent.mm.plugin.fts.ui.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.y;
import java.io.File;
import java.lang.reflect.Field;

public class PardusWebView
  extends MMWebView
{
  private Context context;
  
  public PardusWebView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(176919);
    this.context = paramContext;
    init();
    AppMethodBeat.o(176919);
  }
  
  public PardusWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(176920);
    this.context = paramContext;
    init();
    AppMethodBeat.o(176920);
  }
  
  public PardusWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(176921);
    this.context = paramContext;
    init();
    AppMethodBeat.o(176921);
  }
  
  private void bBO()
  {
    AppMethodBeat.i(176923);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(176923);
      return;
    }
    if (d.lf(19))
    {
      AppMethodBeat.o(176923);
      return;
    }
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
      ad.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mProvider", null).get();
      ad.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mWebViewCore", null).get();
      ad.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "sWebCoreHandler", null).get();
      ad.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mLooper", null).get();
      ad.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mThread", null).get();
      ad.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        ad.i("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      AppMethodBeat.o(176923);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(176923);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(176922);
    ad.i("MicroMsg.FTS.PardusWebView", "init FlightWebView");
    this.fFP = true;
    ki(this.context);
    bBO();
    AppMethodBeat.o(176922);
  }
  
  public final void a(a parama, b paramb)
  {
    AppMethodBeat.i(176924);
    getSettings().frg();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().fri();
    getSettings().setUserAgentString(x.bR(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().fqZ();
    getSettings().fqY();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().fri();
    getSettings().fre();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().frd();
    getSettings().frf();
    getSettings().setDatabasePath(com.tencent.mm.loader.j.b.ahY() + "databases/");
    com.tencent.xweb.c.fqC().fqD();
    com.tencent.xweb.c.fqC().e(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)aj.getContext().getSystemService("window"));
    super.setWebChromeClient(parama);
    super.setWebViewClient(paramb);
    feR();
    ad.i("MicroMsg.FTS.PardusWebView", "current webview core %s", new Object[] { getWebCoreType() });
    float f = getContext().getSharedPreferences(aj.eFD(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cd.a.hF(getContext()));
    if (f >= com.tencent.mm.cd.a.hL(getContext())) {
      getSettings().setTextZoom(148);
    }
    for (;;)
    {
      ad.i("MicroMsg.FTS.PardusWebView", "SetFontSize, fontSize = %f", new Object[] { Float.valueOf(f) });
      AppMethodBeat.o(176924);
      return;
      if (f >= com.tencent.mm.cd.a.hK(getContext())) {
        getSettings().setTextZoom(140);
      } else if (f >= com.tencent.mm.cd.a.hJ(getContext())) {
        getSettings().setTextZoom(132);
      } else if (f >= com.tencent.mm.cd.a.hI(getContext())) {
        getSettings().setTextZoom(124);
      } else if (f >= com.tencent.mm.cd.a.hH(getContext())) {
        getSettings().setTextZoom(116);
      } else if (f >= com.tencent.mm.cd.a.hG(getContext())) {
        getSettings().setTextZoom(108);
      } else if (f >= com.tencent.mm.cd.a.hF(getContext())) {
        getSettings().setTextZoom(100);
      } else if (f >= com.tencent.mm.cd.a.hE(getContext())) {
        getSettings().setTextZoom(92);
      } else {
        getSettings().setTextZoom(80);
      }
    }
  }
  
  public void destroy()
  {
    AppMethodBeat.i(176925);
    this.context = null;
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    super.destroy();
    AppMethodBeat.o(176925);
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(176926);
    try
    {
      Field localField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null)
      {
        AppMethodBeat.o(176926);
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      AppMethodBeat.o(176926);
      return;
    }
    catch (Exception paramWindowManager)
    {
      AppMethodBeat.o(176926);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.webview.PardusWebView
 * JD-Core Version:    0.7.0.1
 */