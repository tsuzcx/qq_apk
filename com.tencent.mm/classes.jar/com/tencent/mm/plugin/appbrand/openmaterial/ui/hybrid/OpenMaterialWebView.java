package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import java.io.File;
import java.lang.reflect.Field;

public class OpenMaterialWebView
  extends MMWebView
{
  private Context context;
  
  public OpenMaterialWebView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(227259);
    this.context = paramContext;
    init();
    AppMethodBeat.o(227259);
  }
  
  public OpenMaterialWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(227260);
    this.context = paramContext;
    init();
    AppMethodBeat.o(227260);
  }
  
  public OpenMaterialWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(227261);
    this.context = paramContext;
    init();
    AppMethodBeat.o(227261);
  }
  
  private void bQp()
  {
    AppMethodBeat.i(227263);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(227263);
      return;
    }
    if (d.oD(19))
    {
      AppMethodBeat.o(227263);
      return;
    }
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mProvider", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mWebViewCore", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "sWebCoreHandler", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mLooper", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mThread", null).get();
      Log.d("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        Log.i("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      AppMethodBeat.o(227263);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(227263);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(227262);
    Log.printInfoStack("MicroMsg.AppBrand.OpenMaterialWebView", "init OpenMaterialWebView", new Object[0]);
    this.gKM = true;
    kI(this.context);
    bQp();
    AppMethodBeat.o(227262);
  }
  
  public final void bQq()
  {
    AppMethodBeat.i(227264);
    getSettings().hsU();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().hsW();
    getSettings().setUserAgentString(com.tencent.mm.pluginsdk.ui.tools.z.cr(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().hsN();
    getSettings().hsM();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().hsW();
    getSettings().hsS();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().hsR();
    getSettings().hsT();
    getSettings().setDatabasePath(b.aKA() + "databases/");
    com.tencent.xweb.c.hsp().hsq();
    com.tencent.xweb.c.hsp().e(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    Log.i("MicroMsg.AppBrand.OpenMaterialWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
    setBackgroundColor(-1);
    gYW();
    AppMethodBeat.o(227264);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(227265);
    this.context = null;
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    super.destroy();
    AppMethodBeat.o(227265);
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(227266);
    try
    {
      Field localField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null)
      {
        AppMethodBeat.o(227266);
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      AppMethodBeat.o(227266);
      return;
    }
    catch (Exception paramWindowManager)
    {
      AppMethodBeat.o(227266);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialWebView
 * JD-Core Version:    0.7.0.1
 */