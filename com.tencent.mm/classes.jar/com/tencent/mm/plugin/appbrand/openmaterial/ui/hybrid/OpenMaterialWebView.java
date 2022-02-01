package com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.ad;
import com.tencent.xweb.ao;
import java.io.File;
import java.lang.reflect.Field;

public class OpenMaterialWebView
  extends MMWebView
{
  private Context context;
  
  public OpenMaterialWebView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(323759);
    this.context = paramContext;
    init();
    AppMethodBeat.o(323759);
  }
  
  public OpenMaterialWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(323771);
    this.context = paramContext;
    init();
    AppMethodBeat.o(323771);
  }
  
  public OpenMaterialWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(323780);
    this.context = paramContext;
    init();
    AppMethodBeat.o(323780);
  }
  
  private void cDC()
  {
    AppMethodBeat.i(323801);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(323801);
      return;
    }
    if (d.rb(19))
    {
      AppMethodBeat.o(323801);
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
      AppMethodBeat.o(323801);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.AppBrand.OpenMaterialWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(323801);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(323788);
    Log.printInfoStack("MicroMsg.AppBrand.OpenMaterialWebView", "init OpenMaterialWebView", new Object[0]);
    this.lYs = true;
    nJ(this.context);
    cDC();
    AppMethodBeat.o(323788);
  }
  
  public final void cDD()
  {
    AppMethodBeat.i(323812);
    getSettings().kfS();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().kfU();
    getSettings().setUserAgentString(aa.cN(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().kfN();
    getSettings().kfM();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().kfU();
    getSettings().kfQ();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().kfP();
    getSettings().kfR();
    getSettings().setDatabasePath(com.tencent.mm.loader.i.b.bmq() + "databases/");
    ao.kfp();
    ao.g(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)MMApplicationContext.getContext().getSystemService("window"));
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    Log.i("MicroMsg.AppBrand.OpenMaterialWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
    setBackgroundColor(-1);
    jEU();
    AppMethodBeat.o(323812);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(323817);
    this.context = null;
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    super.destroy();
    AppMethodBeat.o(323817);
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(323824);
    try
    {
      Field localField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null)
      {
        AppMethodBeat.o(323824);
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      AppMethodBeat.o(323824);
      return;
    }
    catch (Exception paramWindowManager)
    {
      AppMethodBeat.o(323824);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.ui.hybrid.OpenMaterialWebView
 * JD-Core Version:    0.7.0.1
 */