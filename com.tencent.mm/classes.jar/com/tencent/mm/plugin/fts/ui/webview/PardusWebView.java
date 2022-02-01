package com.tencent.mm.plugin.fts.ui.webview;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
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
  
  private void bOa()
  {
    AppMethodBeat.i(176923);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(176923);
      return;
    }
    if (d.lA(19))
    {
      AppMethodBeat.o(176923);
      return;
    }
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
      ae.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mProvider", null).get();
      ae.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mWebViewCore", null).get();
      ae.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "sWebCoreHandler", null).get();
      ae.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mLooper", null).get();
      ae.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mThread", null).get();
      ae.d("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        ae.i("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      AppMethodBeat.o(176923);
      return;
    }
    catch (Exception localException)
    {
      ae.e("MicroMsg.FTS.PardusWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(176923);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(176922);
    ae.i("MicroMsg.FTS.PardusWebView", "init FlightWebView");
    this.gff = true;
    kM(this.context);
    bOa();
    AppMethodBeat.o(176922);
  }
  
  public final void a(a parama, b paramb)
  {
    AppMethodBeat.i(176924);
    getSettings().gfD();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().gfF();
    getSettings().setUserAgentString(x.bX(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().gfw();
    getSettings().gfv();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().gfF();
    getSettings().gfB();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().gfA();
    getSettings().gfC();
    getSettings().setDatabasePath(com.tencent.mm.loader.j.b.asa() + "databases/");
    com.tencent.xweb.c.geY().geZ();
    com.tencent.xweb.c.geY().e(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)ak.getContext().getSystemService("window"));
    super.setWebChromeClient(parama);
    super.setWebViewClient(paramb);
    fPT();
    ae.i("MicroMsg.FTS.PardusWebView", "current webview core %s", new Object[] { getWebCoreType() });
    float f = getContext().getSharedPreferences(ak.fow(), 0).getFloat("current_text_size_scale_key", com.tencent.mm.cb.a.ie(getContext()));
    if (f >= com.tencent.mm.cb.a.ik(getContext())) {
      getSettings().setTextZoom(148);
    }
    for (;;)
    {
      ae.i("MicroMsg.FTS.PardusWebView", "SetFontSize, fontSize = %f", new Object[] { Float.valueOf(f) });
      AppMethodBeat.o(176924);
      return;
      if (f >= com.tencent.mm.cb.a.ij(getContext())) {
        getSettings().setTextZoom(140);
      } else if (f >= com.tencent.mm.cb.a.ii(getContext())) {
        getSettings().setTextZoom(132);
      } else if (f >= com.tencent.mm.cb.a.ih(getContext())) {
        getSettings().setTextZoom(124);
      } else if (f >= com.tencent.mm.cb.a.ig(getContext())) {
        getSettings().setTextZoom(116);
      } else if (f >= com.tencent.mm.cb.a.jdMethod_if(getContext())) {
        getSettings().setTextZoom(108);
      } else if (f >= com.tencent.mm.cb.a.ie(getContext())) {
        getSettings().setTextZoom(100);
      } else if (f >= com.tencent.mm.cb.a.id(getContext())) {
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