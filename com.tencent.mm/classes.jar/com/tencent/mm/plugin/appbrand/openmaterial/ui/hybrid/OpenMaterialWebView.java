package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.aa;
import com.tencent.xweb.c;
import java.io.File;
import java.lang.reflect.Field;

public class OpenMaterialWebView
  extends MMWebView
{
  private Context context;
  
  public OpenMaterialWebView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(271950);
    this.context = paramContext;
    init();
    AppMethodBeat.o(271950);
  }
  
  public OpenMaterialWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(271951);
    this.context = paramContext;
    init();
    AppMethodBeat.o(271951);
  }
  
  public OpenMaterialWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(271952);
    this.context = paramContext;
    init();
    AppMethodBeat.o(271952);
  }
  
  private void cdf()
  {
    AppMethodBeat.i(271954);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(271954);
      return;
    }
    if (d.qV(19))
    {
      AppMethodBeat.o(271954);
      return;
    }
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.b(this, "mSysWebView", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.b(localObject, "mProvider", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.b(localObject, "mWebViewCore", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.b(localObject, "sWebCoreHandler", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.b(localObject, "mLooper", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.b(localObject, "mThread", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        Log.i("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      AppMethodBeat.o(271954);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(271954);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(271953);
    Log.printInfoStack("MicroMsg.AppBrand.OpenMaterialWebView", "init OpenMaterialWebView", new Object[0]);
    this.jvb = true;
    lF(this.context);
    cdf();
    AppMethodBeat.o(271953);
  }
  
  public final void cdg()
  {
    AppMethodBeat.i(271955);
    getSettings().iwC();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().iwE();
    getSettings().setUserAgentString(ab.cC(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().iwx();
    getSettings().iww();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().iwE();
    getSettings().iwA();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().iwz();
    getSettings().iwB();
    getSettings().setDatabasePath(com.tencent.mm.loader.j.b.aSC() + "databases/");
    c.ivX().ivY();
    c.ivX().f(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    Log.i("MicroMsg.AppBrand.OpenMaterialWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
    setBackgroundColor(-1);
    hZN();
    AppMethodBeat.o(271955);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(271956);
    this.context = null;
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    super.destroy();
    AppMethodBeat.o(271956);
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(271958);
    try
    {
      Field localField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null)
      {
        AppMethodBeat.o(271958);
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      AppMethodBeat.o(271958);
      return;
    }
    catch (Exception paramWindowManager)
    {
      AppMethodBeat.o(271958);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialWebView
 * JD-Core Version:    0.7.0.1
 */