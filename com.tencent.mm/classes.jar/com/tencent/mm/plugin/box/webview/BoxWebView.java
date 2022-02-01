package com.tencent.mm.plugin.box.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView;
import com.tencent.xweb.z;
import java.io.File;
import java.lang.reflect.Field;

public class BoxWebView
  extends MMWebView
{
  private Context context;
  
  public BoxWebView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(76344);
    this.context = paramContext;
    init();
    AppMethodBeat.o(76344);
  }
  
  public BoxWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(76345);
    this.context = paramContext;
    init();
    AppMethodBeat.o(76345);
  }
  
  public BoxWebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(76346);
    this.context = paramContext;
    init();
    AppMethodBeat.o(76346);
  }
  
  private void bIM()
  {
    AppMethodBeat.i(76348);
    if (getIsX5Kernel())
    {
      AppMethodBeat.o(76348);
      return;
    }
    if (d.kZ(19))
    {
      AppMethodBeat.o(76348);
      return;
    }
    try
    {
      Object localObject = new com.tencent.mm.compatible.loader.c(this, "mSysWebView", null).get();
      ac.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, mSysWebView = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mProvider", null).get();
      ac.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, mWebViewClassic = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mWebViewCore", null).get();
      ac.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, mWebViewCore = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "sWebCoreHandler", null).get();
      ac.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, sWebCoreHandler = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mLooper", null).get();
      ac.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, mLooper = %s", new Object[] { localObject });
      localObject = new com.tencent.mm.compatible.loader.c(localObject, "mThread", null).get();
      ac.d("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, mThread = %s", new Object[] { localObject });
      if ((localObject instanceof Thread))
      {
        localObject = (Thread)localObject;
        ac.i("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, webCoreThread.getState = %s", new Object[] { ((Thread)localObject).getState() });
        if (((Thread)localObject).getState() == Thread.State.WAITING) {
          ((Thread)localObject).interrupt();
        }
      }
      AppMethodBeat.o(76348);
      return;
    }
    catch (Exception localException)
    {
      ac.e("MicroMsg.Flight.FlightWebView", "tryInterruptAwaitingWebCoreThread, exception = %s", new Object[] { localException });
      AppMethodBeat.o(76348);
    }
  }
  
  private void init()
  {
    AppMethodBeat.i(76347);
    ac.i("MicroMsg.Flight.FlightWebView", "init FlightWebView");
    this.fJw = true;
    kt(this.context);
    bIM();
    AppMethodBeat.o(76347);
  }
  
  public final void a(a parama, c paramc)
  {
    AppMethodBeat.i(76349);
    getSettings().fJH();
    getSettings().setJavaScriptEnabled(true);
    getSettings().setPluginsEnabled(true);
    getSettings().setBuiltInZoomControls(false);
    getSettings().setMediaPlaybackRequiresUserGesture(true);
    getSettings().fJJ();
    getSettings().setUserAgentString(x.bS(getContext(), getSettings().getUserAgentString()));
    getSettings().setUseWideViewPort(true);
    getSettings().setLoadWithOverviewMode(true);
    getSettings().fJA();
    getSettings().fJz();
    getSettings().setGeolocationEnabled(true);
    getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    getSettings().fJJ();
    getSettings().fJF();
    getSettings().setAppCachePath(this.context.getDir("webviewcache", 0).getAbsolutePath());
    getSettings().fJE();
    getSettings().fJG();
    getSettings().setDatabasePath(b.aoY() + "databases/");
    com.tencent.xweb.c.fJa().fJb();
    com.tencent.xweb.c.fJa().e(this);
    getView().setHorizontalScrollBarEnabled(false);
    getView().setVerticalScrollBarEnabled(true);
    setConfigCallback((WindowManager)ai.getContext().getSystemService("window"));
    super.setWebChromeClient(parama);
    super.setWebViewClient(paramc);
    ac.i("MicroMsg.Flight.FlightWebView", "Is the current broswer kernel X5, " + getIsX5Kernel());
    setBackgroundColor(-1);
    fuM();
    AppMethodBeat.o(76349);
  }
  
  public void destroy()
  {
    AppMethodBeat.i(76350);
    this.context = null;
    super.setWebChromeClient(null);
    super.setWebViewClient(null);
    super.destroy();
    AppMethodBeat.o(76350);
  }
  
  public void setConfigCallback(WindowManager paramWindowManager)
  {
    AppMethodBeat.i(76351);
    try
    {
      Field localField = WebView.class.getDeclaredField("mWebViewCore").getType().getDeclaredField("mBrowserFrame").getType().getDeclaredField("sConfigCallback");
      localField.setAccessible(true);
      Object localObject = localField.get(null);
      if (localObject == null)
      {
        AppMethodBeat.o(76351);
        return;
      }
      localField = localField.getType().getDeclaredField("mWindowManager");
      localField.setAccessible(true);
      localField.set(localObject, paramWindowManager);
      AppMethodBeat.o(76351);
      return;
    }
    catch (Exception paramWindowManager)
    {
      AppMethodBeat.o(76351);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.webview.BoxWebView
 * JD-Core Version:    0.7.0.1
 */