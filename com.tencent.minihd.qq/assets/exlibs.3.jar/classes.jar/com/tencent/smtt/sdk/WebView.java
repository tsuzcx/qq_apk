package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Rect;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebChromeClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebSettingsExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.extension.proxy.X5ProxyWebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient.CustomViewCallback;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.FindListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.PictureListener;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.sdk.stat.MttLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.d;
import com.tencent.smtt.utils.q;
import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

public class WebView
  extends FrameLayout
  implements View.OnLongClickListener
{
  public static final int GETPVERROR = -1;
  public static int NIGHT_MODE_ALPHA = 153;
  public static final int NIGHT_MODE_COLOR = -16777216;
  public static final int NORMAL_MODE_ALPHA = 255;
  public static final String SCHEME_GEO = "geo:0,0?q=";
  public static final String SCHEME_MAILTO = "mailto:";
  public static final String SCHEME_TEL = "tel:";
  private static final Lock c = new ReentrantLock();
  private static OutputStream d = null;
  private static Context j = null;
  private static com.tencent.smtt.utils.o l;
  public static boolean mSysWebviewCreated;
  public static boolean mWebViewCreated = false;
  private static Method n;
  private static String q;
  private static Paint w;
  private static boolean x;
  volatile int a = 0;
  private final String b = "WebView";
  private boolean e = false;
  private IX5WebViewBase f;
  private a g;
  private WebSettings h = null;
  private Context i = null;
  private volatile boolean k = false;
  private boolean m = false;
  public WebViewCallbackClient mWebViewCallbackClient;
  private WebViewClient o = null;
  private WebChromeClient p = null;
  private final int r = 1;
  private final int s = 2;
  private final int t = 3;
  private final String u = "javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));";
  private final String v = "javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);";
  private Object y = null;
  private View.OnLongClickListener z = null;
  
  static
  {
    l = null;
    n = null;
    q = null;
    mSysWebviewCreated = false;
    w = null;
    x = true;
  }
  
  public WebView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, false);
  }
  
  @TargetApi(11)
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, Map<String, Object> paramMap, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet, paramInt);
    mWebViewCreated = true;
    q.a("0");
    if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext)))
    {
      this.i = paramContext;
      this.f = null;
      this.e = false;
      QbSdk.a(paramContext, "failed to createTBSWebview!");
      this.g = new a(paramContext, paramAttributeSet);
      CookieManager.getInstance().a(paramContext, true, false);
      CookieSyncManager.createInstance(this.i).startSync();
    }
    try
    {
      paramAttributeSet = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
      paramAttributeSet.setAccessible(true);
      ((Handler)paramAttributeSet.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new h());
      mSysWebviewCreated = true;
      label218:
      CookieManager.getInstance().a();
      this.g.setFocusableInTouchMode(true);
      addView(this.g, new FrameLayout.LayoutParams(-1, -1));
      TbsLog.i("WebView", "SystemWebView Created Success! #3, SysWebViewForcedByOuter.");
      TbsLog.e("WebView", "sys WebView: IsSysWebViewForcedByOuter = true", true);
      TbsCoreLoadStat.getInstance().a(paramContext, 402);
      return;
      if (TbsShareManager.isThirdPartyApp(paramContext)) {
        TbsLog.setWriteLogJIT(true);
      }
      for (;;)
      {
        TbsLog.initIfNeed(paramContext);
        if (paramContext != null) {
          break;
        }
        throw new IllegalArgumentException("Invalid context argument");
        TbsLog.setWriteLogJIT(false);
      }
      if (l == null) {
        l = com.tencent.smtt.utils.o.a(paramContext);
      }
      if (l.a)
      {
        TbsLog.e("WebView", "sys WebView: debug.conf force syswebview", true);
        QbSdk.a(paramContext, "debug.conf force syswebview!");
      }
      c(paramContext);
      this.i = paramContext;
      if (paramContext != null) {
        j = paramContext.getApplicationContext();
      }
      if ((this.e) && (!QbSdk.a))
      {
        this.f = x.a().a(true).a(paramContext);
        if ((this.f == null) || (this.f.getView() == null))
        {
          TbsLog.e("WebView", "sys WebView: failed to createTBSWebview", true);
          this.f = null;
          this.e = false;
          QbSdk.a(paramContext, "failed to createTBSWebview!");
          c(paramContext);
          if (TbsShareManager.isThirdPartyApp(this.i)) {
            this.g = new a(paramContext, paramAttributeSet);
          }
          for (;;)
          {
            TbsLog.i("WebView", "SystemWebView Created Success! #1");
            CookieManager.getInstance().a(paramContext, true, false);
            CookieManager.getInstance().a();
            this.g.setFocusableInTouchMode(true);
            addView(this.g, new FrameLayout.LayoutParams(-1, -1));
            try
            {
              if (Build.VERSION.SDK_INT >= 11)
              {
                removeJavascriptInterface("searchBoxJavaBridge_");
                removeJavascriptInterface("accessibility");
                removeJavascriptInterface("accessibilityTraversal");
              }
              TbsLog.writeLogToDisk();
              p.a(paramContext);
              return;
              this.g = new a(paramContext);
            }
            catch (Throwable paramAttributeSet)
            {
              for (;;)
              {
                paramAttributeSet.printStackTrace();
              }
            }
          }
        }
        TbsLog.i("WebView", "X5 WebView Created Success!!");
        if (TbsShareManager.isThirdPartyApp(paramContext)) {
          q.a(paramContext, "x5_webview_ok", "" + QbSdk.getTbsVersion(paramContext));
        }
        q.a("20");
        this.f.getView().setFocusableInTouchMode(true);
        a(paramAttributeSet);
        addView(this.f.getView(), new FrameLayout.LayoutParams(-1, -1));
        this.f.setDownloadListener(new b(this, null, this.e));
        this.f.getX5WebViewExtension().setWebViewClientExtension(new X5ProxyWebViewClientExtension(x.a().a(true).k())
        {
          public void invalidate() {}
          
          public void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
          {
            super.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
            WebView.a(WebView.this, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt1, paramAnonymousInt2);
          }
        });
      }
      try
      {
        if (Build.VERSION.SDK_INT >= 11)
        {
          removeJavascriptInterface("searchBoxJavaBridge_");
          removeJavascriptInterface("accessibility");
          removeJavascriptInterface("accessibilityTraversal");
        }
        if ((("com.tencent.mobileqq".equals(this.i.getApplicationInfo().packageName)) || ("com.tencent.mm".equals(this.i.getApplicationInfo().packageName))) && (g.a(true).h()) && (Build.VERSION.SDK_INT >= 11)) {
          setLayerType(1, null);
        }
        if (this.f != null)
        {
          TbsLog.writeLogToDisk();
          if (!TbsShareManager.isThirdPartyApp(paramContext))
          {
            paramInt = TbsDownloadConfig.getInstance(paramContext).mPreferences.getInt("tbs_decouplecoreversion", 0);
            if ((paramInt <= 0) || (paramInt == p.a().i(paramContext)) || (paramInt != p.a().j(paramContext))) {
              break label1025;
            }
            p.a().o(paramContext);
          }
        }
        QbSdk.continueLoadSo(paramContext);
        return;
        this.f = null;
        if (TbsShareManager.isThirdPartyApp(this.i)) {}
        for (this.g = new a(paramContext, paramAttributeSet);; this.g = new a(paramContext))
        {
          TbsLog.i("WebView", "SystemWebView Created Success! #2");
          if (TbsShareManager.isThirdPartyApp(paramContext)) {
            q.a(paramContext, "x5_webview_fail", "");
          }
          CookieManager.getInstance().a(paramContext, true, false);
          CookieManager.getInstance().a();
          this.g.setFocusableInTouchMode(true);
          addView(this.g, new FrameLayout.LayoutParams(-1, -1));
          setDownloadListener(null);
          TbsLog.writeLogToDisk();
          p.a(paramContext);
          break;
        }
      }
      catch (Throwable paramAttributeSet)
      {
        for (;;)
        {
          paramAttributeSet.printStackTrace();
          continue;
          label1025:
          TbsLog.i("WebView", "webview construction #1 deCoupleCoreVersion is " + paramInt + " getTbsCoreShareDecoupleCoreVersion is " + p.a().i(paramContext) + " getTbsCoreInstalledVerInNolock is " + p.a().j(paramContext));
        }
      }
    }
    catch (Exception paramAttributeSet)
    {
      break label218;
    }
  }
  
  @Deprecated
  public WebView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, boolean paramBoolean)
  {
    this(paramContext, paramAttributeSet, paramInt, null, paramBoolean);
  }
  
  public WebView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
  }
  
  private void a(AttributeSet paramAttributeSet)
  {
    int i1 = 0;
    if (paramAttributeSet != null) {}
    for (;;)
    {
      int[] arrayOfInt;
      int i3;
      try
      {
        int i2 = paramAttributeSet.getAttributeCount();
        if (i1 < i2)
        {
          if (!paramAttributeSet.getAttributeName(i1).equalsIgnoreCase("scrollbars")) {
            break label147;
          }
          arrayOfInt = getResources().getIntArray(16842974);
          i3 = paramAttributeSet.getAttributeIntValue(i1, -1);
          if (i3 == arrayOfInt[1])
          {
            this.f.getView().setVerticalScrollBarEnabled(false);
            this.f.getView().setHorizontalScrollBarEnabled(false);
          }
          else if (i3 == arrayOfInt[2])
          {
            this.f.getView().setVerticalScrollBarEnabled(false);
          }
        }
      }
      catch (Exception paramAttributeSet)
      {
        paramAttributeSet.printStackTrace();
      }
      return;
      if (i3 == arrayOfInt[3]) {
        this.f.getView().setHorizontalScrollBarEnabled(false);
      }
      label147:
      i1 += 1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    q.b("old03");
    Object localObject4;
    Object localObject1;
    Object localObject7;
    Object localObject6;
    Object localObject5;
    int i1;
    if ((!this.k) && (this.a != 0))
    {
      q.b("old04");
      this.k = true;
      localObject4 = "";
      ??? = "";
      localObject1 = "";
      localObject7 = localObject1;
      localObject6 = ???;
      localObject5 = localObject4;
      if (this.e)
      {
        q.b("old05");
        localObject5 = this.f.getX5WebViewExtension().getSdkQBStatisticsInfo();
        if (localObject5 != null)
        {
          localObject4 = ((Bundle)localObject5).getString("guid");
          ??? = ((Bundle)localObject5).getString("qua2");
          localObject1 = ((Bundle)localObject5).getString("lc");
        }
        q.b("old06");
        localObject5 = localObject4;
        localObject6 = ???;
        localObject7 = localObject1;
      }
      if ("com.qzone".equals(this.i.getApplicationInfo().packageName))
      {
        int i2 = e(this.i);
        i1 = i2;
        if (i2 == -1) {
          i1 = this.a;
        }
        this.a = i1;
        f(this.i);
      }
    }
    try
    {
      q.b("old07");
      bool = this.f.getX5WebViewExtension().isX5CoreSandboxMode();
      q.b("old08");
      com.tencent.smtt.sdk.stat.b.a(this.i, (String)localObject5, localObject6, localObject7, this.a, this.e, i(), bool);
      q.b("old09");
      this.a = 0;
      this.k = false;
      q.b("old10");
      if (!this.e) {}
      try
      {
        q.b("old11");
        localObject1 = Class.forName("android.webkit.WebViewClassic");
        ??? = ((Class)localObject1).getMethod("fromWebView", new Class[] { android.webkit.WebView.class });
        ((Method)???).setAccessible(true);
        ??? = ((Method)???).invoke(null, new Object[] { this.g });
        if (??? != null)
        {
          q.b("old12");
          localObject1 = ((Class)localObject1).getDeclaredField("mListBoxDialog");
          ((Field)localObject1).setAccessible(true);
          localObject1 = ((Field)localObject1).get(???);
          if (localObject1 != null)
          {
            q.b("old13");
            localObject1 = (Dialog)localObject1;
            ((Dialog)localObject1).setOnCancelListener(null);
            ??? = Class.forName("android.app.Dialog");
            localObject4 = ((Class)???).getDeclaredField("CANCEL");
            ((Field)localObject4).setAccessible(true);
            i1 = ((Integer)((Field)localObject4).get(localObject1)).intValue();
            ??? = ((Class)???).getDeclaredField("mListenersHandler");
            ((Field)???).setAccessible(true);
            ((Handler)((Field)???).get(localObject1)).removeMessages(i1);
          }
        }
      }
      catch (Exception localException2)
      {
        label464:
        ComponentCallbacks localComponentCallbacks;
        break label464;
      }
      q.b("old14");
      if (paramBoolean) {
        this.g.destroy();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          boolean bool;
          q.b("old15");
          TbsLog.i("sdkreport", "webview.tbsWebviewDestroy mQQMusicCrashFix is " + this.m);
          paramBoolean = this.m;
          if (paramBoolean)
          {
            return;
            localThrowable = localThrowable;
            TbsLog.w("tbsWebviewDestroy", "exception: " + localThrowable);
            bool = false;
            continue;
          }
          ??? = Class.forName("android.webkit.BrowserFrame").getDeclaredField("sConfigCallback");
          ((Field)???).setAccessible(true);
          localComponentCallbacks = (ComponentCallbacks)((Field)???).get(null);
          if (localComponentCallbacks != null)
          {
            q.b("old16");
            ((Field)???).set(null, null);
            ??? = Class.forName("android.view.ViewRoot").getDeclaredField("sConfigCallbacks");
            ((Field)???).setAccessible(true);
            ??? = ((Field)???).get(null);
            if (??? == null) {}
          }
        }
        catch (Exception localException1)
        {
          continue;
        }
        synchronized ((List)???)
        {
          ((List)???).remove(localComponentCallbacks);
          q.b("old17");
          TbsLog.i("WebView", "X5 GUID = " + QbSdk.b());
          return;
        }
        q.b("old18");
        if (paramBoolean) {
          this.f.destroy();
        }
        q.b("old19");
      }
    }
  }
  
  private boolean a(View paramView)
  {
    if ((this.i != null) && (getTbsCoreVersion(this.i) > 36200)) {
      return false;
    }
    paramView = com.tencent.smtt.utils.i.a(this.y, "onLongClick", new Class[] { View.class }, new Object[] { paramView });
    if (paramView != null) {
      return ((Boolean)paramView).booleanValue();
    }
    return false;
  }
  
  private boolean a(WebChromeClient paramWebChromeClient)
  {
    boolean bool = true;
    if (paramWebChromeClient == null) {
      return false;
    }
    paramWebChromeClient = paramWebChromeClient.getClass();
    i3 = 0;
    i1 = 0;
    while ((paramWebChromeClient != WebChromeClient.class) && ((i3 == 0) || (i1 == 0)))
    {
      i2 = i3;
      if (i3 == 0) {}
      try
      {
        paramWebChromeClient.getDeclaredMethod("onShowCustomView", new Class[] { View.class, IX5WebChromeClient.CustomViewCallback.class });
        i2 = 1;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        for (;;)
        {
          i2 = i3;
        }
      }
      i3 = i1;
      if (i1 == 0) {}
      try
      {
        paramWebChromeClient.getDeclaredMethod("onHideCustomView", new Class[0]);
        i3 = 1;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        for (;;)
        {
          i3 = i1;
        }
      }
      paramWebChromeClient = paramWebChromeClient.getSuperclass();
      i1 = i3;
      i3 = i2;
    }
    if ((i3 != 0) && (i1 != 0)) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  private boolean b(Context paramContext)
  {
    try
    {
      int i1 = paramContext.getPackageName().indexOf("com.tencent.mobileqq");
      if (i1 >= 0) {
        return true;
      }
    }
    catch (Throwable paramContext)
    {
      paramContext.printStackTrace();
    }
    return false;
  }
  
  static void c()
  {
    Runnable local8 = new Runnable()
    {
      public void run()
      {
        if (WebView.f() == null) {
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--mAppContext == null");
        }
        g localg;
        int i;
        int j;
        do
        {
          return;
          localg = g.a(true);
          if (g.b)
          {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--needReboot = true");
            return;
          }
          n localn = n.a(WebView.f());
          i = localn.c();
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--installStatus = " + i);
          if (i == 2)
          {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--install setTbsNeedReboot true");
            localg.a(String.valueOf(localn.b()));
            localg.b(true);
            return;
          }
          j = localn.b("copy_status");
          TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copyStatus = " + j);
          if (j == 1)
          {
            TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--copy setTbsNeedReboot true");
            localg.a(String.valueOf(localn.c("copy_core_ver")));
            localg.b(true);
            return;
          }
        } while ((x.a().b()) || ((i != 3) && (j != 3)));
        TbsLog.d("TbsNeedReboot", "WebView.updateNeeeRebootStatus--setTbsNeedReboot true");
        localg.a(String.valueOf(g.d()));
        localg.b(true);
      }
    };
    try
    {
      new Thread(local8).start();
      return;
    }
    catch (Throwable localThrowable)
    {
      TbsLog.e("webview", "updateRebootStatus excpetion: " + localThrowable);
    }
  }
  
  private void c(Context paramContext)
  {
    if ((QbSdk.i) && (TbsShareManager.isThirdPartyApp(paramContext))) {
      TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(paramContext);
    }
    x localx = x.a();
    localx.a(paramContext);
    this.e = localx.b();
  }
  
  private Context d(Context paramContext)
  {
    Context localContext = paramContext;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localContext = paramContext;
      if (Build.VERSION.SDK_INT <= 22) {
        localContext = paramContext.createConfigurationContext(new Configuration());
      }
    }
    return localContext;
  }
  
  @Deprecated
  public static void disablePlatformNotifications()
  {
    if (!x.a().b()) {
      com.tencent.smtt.utils.i.a("android.webkit.WebView", "disablePlatformNotifications");
    }
  }
  
  /* Error */
  private int e(Context paramContext)
  {
    // Byte code:
    //   0: aload_1
    //   1: iconst_1
    //   2: ldc_w 833
    //   5: invokestatic 838	com/tencent/smtt/utils/FileUtil:b	(Landroid/content/Context;ZLjava/lang/String;)Ljava/io/FileOutputStream;
    //   8: astore 6
    //   10: aload 6
    //   12: ifnull +16 -> 28
    //   15: aload_1
    //   16: aload 6
    //   18: invokestatic 841	com/tencent/smtt/utils/FileUtil:a	(Landroid/content/Context;Ljava/io/FileOutputStream;)Ljava/nio/channels/FileLock;
    //   21: astore 7
    //   23: aload 7
    //   25: ifnonnull +5 -> 30
    //   28: iconst_m1
    //   29: ireturn
    //   30: getstatic 105	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   33: invokeinterface 846 1 0
    //   38: ifeq +472 -> 510
    //   41: aconst_null
    //   42: astore 5
    //   44: aload_1
    //   45: invokestatic 850	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   48: astore_1
    //   49: new 852	java/io/File
    //   52: dup
    //   53: new 403	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   60: aload_1
    //   61: invokevirtual 706	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   64: getstatic 855	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: ldc_w 857
    //   73: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: ldc_w 859
    //   82: invokespecial 861	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +12 -> 99
    //   90: aload_1
    //   91: invokevirtual 864	java/io/File:exists	()Z
    //   94: istore_3
    //   95: iload_3
    //   96: ifne +65 -> 161
    //   99: iconst_0
    //   100: ifeq +11 -> 111
    //   103: new 866	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 867	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: getstatic 105	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   114: invokeinterface 870 1 0
    //   119: aload 7
    //   121: aload 6
    //   123: invokestatic 873	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   126: iconst_m1
    //   127: ireturn
    //   128: astore_1
    //   129: ldc_w 875
    //   132: new 403	java/lang/StringBuilder
    //   135: dup
    //   136: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   139: ldc_w 877
    //   142: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 878	java/io/IOException:toString	()Ljava/lang/String;
    //   149: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   155: invokestatic 801	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   158: goto -47 -> 111
    //   161: new 880	java/util/Properties
    //   164: dup
    //   165: invokespecial 881	java/util/Properties:<init>	()V
    //   168: astore 8
    //   170: new 883	java/io/FileInputStream
    //   173: dup
    //   174: aload_1
    //   175: invokespecial 886	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   178: astore 4
    //   180: aload 4
    //   182: astore_1
    //   183: aload 8
    //   185: aload 4
    //   187: invokevirtual 890	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   190: aload 4
    //   192: astore_1
    //   193: aload 4
    //   195: invokevirtual 893	java/io/FileInputStream:close	()V
    //   198: aload 4
    //   200: astore_1
    //   201: aload 8
    //   203: ldc_w 895
    //   206: invokevirtual 898	java/util/Properties:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   209: astore 5
    //   211: aload 5
    //   213: ifnonnull +63 -> 276
    //   216: aload 4
    //   218: ifnull +8 -> 226
    //   221: aload 4
    //   223: invokevirtual 893	java/io/FileInputStream:close	()V
    //   226: getstatic 105	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   229: invokeinterface 870 1 0
    //   234: aload 7
    //   236: aload 6
    //   238: invokestatic 873	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   241: iconst_m1
    //   242: ireturn
    //   243: astore_1
    //   244: ldc_w 875
    //   247: new 403	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   254: ldc_w 877
    //   257: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   260: aload_1
    //   261: invokevirtual 878	java/io/IOException:toString	()Ljava/lang/String;
    //   264: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   270: invokestatic 801	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   273: goto -47 -> 226
    //   276: aload 4
    //   278: astore_1
    //   279: aload 5
    //   281: invokestatic 901	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   284: istore_2
    //   285: aload 4
    //   287: ifnull +8 -> 295
    //   290: aload 4
    //   292: invokevirtual 893	java/io/FileInputStream:close	()V
    //   295: getstatic 105	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   298: invokeinterface 870 1 0
    //   303: aload 7
    //   305: aload 6
    //   307: invokestatic 873	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   310: iload_2
    //   311: ireturn
    //   312: astore_1
    //   313: ldc_w 875
    //   316: new 403	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   323: ldc_w 877
    //   326: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: aload_1
    //   330: invokevirtual 878	java/io/IOException:toString	()Ljava/lang/String;
    //   333: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   336: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   339: invokestatic 801	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   342: goto -47 -> 295
    //   345: astore 5
    //   347: aconst_null
    //   348: astore 4
    //   350: aload 4
    //   352: astore_1
    //   353: ldc_w 875
    //   356: new 403	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   363: ldc_w 903
    //   366: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: aload 5
    //   371: invokevirtual 904	java/lang/Exception:toString	()Ljava/lang/String;
    //   374: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 801	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   383: aload 4
    //   385: ifnull +8 -> 393
    //   388: aload 4
    //   390: invokevirtual 893	java/io/FileInputStream:close	()V
    //   393: getstatic 105	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   396: invokeinterface 870 1 0
    //   401: aload 7
    //   403: aload 6
    //   405: invokestatic 873	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   408: iconst_m1
    //   409: ireturn
    //   410: astore_1
    //   411: ldc_w 875
    //   414: new 403	java/lang/StringBuilder
    //   417: dup
    //   418: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   421: ldc_w 877
    //   424: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: aload_1
    //   428: invokevirtual 878	java/io/IOException:toString	()Ljava/lang/String;
    //   431: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 801	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   440: goto -47 -> 393
    //   443: astore_1
    //   444: aload 5
    //   446: astore 4
    //   448: aload 4
    //   450: ifnull +8 -> 458
    //   453: aload 4
    //   455: invokevirtual 893	java/io/FileInputStream:close	()V
    //   458: getstatic 105	com/tencent/smtt/sdk/WebView:c	Ljava/util/concurrent/locks/Lock;
    //   461: invokeinterface 870 1 0
    //   466: aload 7
    //   468: aload 6
    //   470: invokestatic 873	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   473: aload_1
    //   474: athrow
    //   475: astore 4
    //   477: ldc_w 875
    //   480: new 403	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 877
    //   490: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload 4
    //   495: invokevirtual 878	java/io/IOException:toString	()Ljava/lang/String;
    //   498: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 801	com/tencent/smtt/utils/TbsLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   507: goto -49 -> 458
    //   510: aload 7
    //   512: aload 6
    //   514: invokestatic 873	com/tencent/smtt/utils/FileUtil:a	(Ljava/nio/channels/FileLock;Ljava/io/FileOutputStream;)V
    //   517: iconst_m1
    //   518: ireturn
    //   519: astore 5
    //   521: aload_1
    //   522: astore 4
    //   524: aload 5
    //   526: astore_1
    //   527: goto -79 -> 448
    //   530: astore 5
    //   532: goto -182 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	535	0	this	WebView
    //   0	535	1	paramContext	Context
    //   284	27	2	i1	int
    //   94	2	3	bool	boolean
    //   178	276	4	localObject1	Object
    //   475	19	4	localIOException	java.io.IOException
    //   522	1	4	localContext	Context
    //   42	238	5	str	String
    //   345	100	5	localException1	Exception
    //   519	6	5	localObject2	Object
    //   530	1	5	localException2	Exception
    //   8	505	6	localFileOutputStream	java.io.FileOutputStream
    //   21	490	7	localFileLock	java.nio.channels.FileLock
    //   168	34	8	localProperties	java.util.Properties
    // Exception table:
    //   from	to	target	type
    //   103	111	128	java/io/IOException
    //   221	226	243	java/io/IOException
    //   290	295	312	java/io/IOException
    //   44	86	345	java/lang/Exception
    //   90	95	345	java/lang/Exception
    //   161	180	345	java/lang/Exception
    //   388	393	410	java/io/IOException
    //   44	86	443	finally
    //   90	95	443	finally
    //   161	180	443	finally
    //   453	458	475	java/io/IOException
    //   183	190	519	finally
    //   193	198	519	finally
    //   201	211	519	finally
    //   279	285	519	finally
    //   353	383	519	finally
    //   183	190	530	java/lang/Exception
    //   193	198	530	java/lang/Exception
    //   201	211	530	java/lang/Exception
    //   279	285	530	java/lang/Exception
  }
  
  @Deprecated
  public static void enablePlatformNotifications()
  {
    if (!x.a().b()) {
      com.tencent.smtt.utils.i.a("android.webkit.WebView", "enablePlatformNotifications");
    }
  }
  
  private void f(Context paramContext)
  {
    try
    {
      paramContext = QbSdk.getTbsFolderDir(paramContext);
      paramContext = new File(paramContext + File.separator + "core_private", "pv.db");
      if (paramContext != null)
      {
        if (!paramContext.exists()) {
          return;
        }
        paramContext.delete();
        return;
      }
    }
    catch (Exception paramContext)
    {
      TbsLog.i("getTbsCorePV", "TbsInstaller--getTbsCorePV Exception=" + paramContext.toString());
    }
  }
  
  @Deprecated
  public static String findAddress(String paramString)
  {
    if (!x.a().b()) {
      return android.webkit.WebView.findAddress(paramString);
    }
    return null;
  }
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc_w 916
    //   6: invokestatic 593	com/tencent/smtt/utils/q:b	(Ljava/lang/String;)V
    //   9: aload_0
    //   10: getfield 159	com/tencent/smtt/sdk/WebView:k	Z
    //   13: ifne +14 -> 27
    //   16: aload_0
    //   17: getfield 157	com/tencent/smtt/sdk/WebView:a	I
    //   20: ifeq +7 -> 27
    //   23: aload_0
    //   24: invokespecial 918	com/tencent/smtt/sdk/WebView:j	()V
    //   27: ldc_w 920
    //   30: invokestatic 593	com/tencent/smtt/utils/q:b	(Ljava/lang/String;)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: getfield 151	com/tencent/smtt/sdk/WebView:e	Z
    //   40: ifne +175 -> 215
    //   43: ldc_w 922
    //   46: invokestatic 593	com/tencent/smtt/utils/q:b	(Ljava/lang/String;)V
    //   49: aload_0
    //   50: getfield 214	com/tencent/smtt/sdk/WebView:g	Lcom/tencent/smtt/sdk/WebView$a;
    //   53: invokevirtual 690	android/webkit/WebView:destroy	()V
    //   56: ldc_w 924
    //   59: invokestatic 593	com/tencent/smtt/utils/q:b	(Ljava/lang/String;)V
    //   62: ldc_w 694
    //   65: new 403	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 926
    //   75: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_0
    //   79: getfield 161	com/tencent/smtt/sdk/WebView:m	Z
    //   82: invokevirtual 699	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   85: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 302	com/tencent/smtt/utils/TbsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   91: aload_0
    //   92: getfield 161	com/tencent/smtt/sdk/WebView:m	Z
    //   95: istore_1
    //   96: iload_1
    //   97: ifeq +10 -> 107
    //   100: return
    //   101: astore_2
    //   102: ldc 2
    //   104: monitorexit
    //   105: aload_2
    //   106: athrow
    //   107: ldc_w 710
    //   110: invokestatic 240	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   113: ldc_w 712
    //   116: invokevirtual 655	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   119: astore_3
    //   120: aload_3
    //   121: iconst_1
    //   122: invokevirtual 658	java/lang/reflect/Field:setAccessible	(Z)V
    //   125: aload_3
    //   126: aconst_null
    //   127: invokevirtual 662	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   130: checkcast 714	android/content/ComponentCallbacks
    //   133: astore_2
    //   134: ldc_w 928
    //   137: invokestatic 593	com/tencent/smtt/utils/q:b	(Ljava/lang/String;)V
    //   140: aload_2
    //   141: ifnull +54 -> 195
    //   144: aload_3
    //   145: aconst_null
    //   146: aconst_null
    //   147: invokevirtual 720	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   150: ldc_w 722
    //   153: invokestatic 240	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   156: ldc_w 724
    //   159: invokevirtual 655	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   162: astore_3
    //   163: aload_3
    //   164: iconst_1
    //   165: invokevirtual 658	java/lang/reflect/Field:setAccessible	(Z)V
    //   168: aload_3
    //   169: aconst_null
    //   170: invokevirtual 662	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   173: astore_3
    //   174: aload_3
    //   175: ifnull +20 -> 195
    //   178: aload_3
    //   179: checkcast 726	java/util/List
    //   182: astore_3
    //   183: aload_3
    //   184: monitorenter
    //   185: aload_3
    //   186: aload_2
    //   187: invokeinterface 729 2 0
    //   192: pop
    //   193: aload_3
    //   194: monitorexit
    //   195: ldc_w 930
    //   198: invokestatic 593	com/tencent/smtt/utils/q:b	(Ljava/lang/String;)V
    //   201: return
    //   202: astore_2
    //   203: ldc_w 932
    //   206: invokestatic 593	com/tencent/smtt/utils/q:b	(Ljava/lang/String;)V
    //   209: return
    //   210: astore_2
    //   211: aload_3
    //   212: monitorexit
    //   213: aload_2
    //   214: athrow
    //   215: ldc_w 934
    //   218: invokestatic 593	com/tencent/smtt/utils/q:b	(Ljava/lang/String;)V
    //   221: aload_0
    //   222: getfield 204	com/tencent/smtt/sdk/WebView:f	Lcom/tencent/smtt/export/external/interfaces/IX5WebViewBase;
    //   225: invokeinterface 738 1 0
    //   230: ldc_w 936
    //   233: invokestatic 593	com/tencent/smtt/utils/q:b	(Ljava/lang/String;)V
    //   236: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	this	WebView
    //   95	2	1	bool	boolean
    //   101	5	2	localObject1	Object
    //   133	54	2	localComponentCallbacks	ComponentCallbacks
    //   202	1	2	localException	Exception
    //   210	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	27	101	finally
    //   27	36	101	finally
    //   102	105	101	finally
    //   62	96	202	java/lang/Exception
    //   107	140	202	java/lang/Exception
    //   144	174	202	java/lang/Exception
    //   178	185	202	java/lang/Exception
    //   195	201	202	java/lang/Exception
    //   213	215	202	java/lang/Exception
    //   185	195	210	finally
    //   211	213	210	finally
  }
  
  public static String getCrashExtraMessage(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    String str = "tbs_core_version:" + QbSdk.getTbsVersionForCrash(paramContext) + ";" + "tbs_sdk_version:" + 44085 + ";";
    if ("com.tencent.mm".equals(paramContext.getApplicationInfo().packageName)) {}
    for (;;)
    {
      try
      {
        Class.forName("de.robv.android.xposed.XposedBridge");
        i1 = 1;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        i1 = 0;
        continue;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        i1 = 0;
        continue;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(g.a(true).e());
        localStringBuilder.append("\n");
        localStringBuilder.append(str);
        if ((TbsShareManager.isThirdPartyApp(paramContext)) || (QbSdk.o == null) || (!QbSdk.o.containsKey("weapp_id")) || (!QbSdk.o.containsKey("weapp_name"))) {
          continue;
        }
        paramContext = "weapp_id:" + QbSdk.o.get("weapp_id") + ";" + "weapp_name" + ":" + QbSdk.o.get("weapp_name") + ";";
        localStringBuilder.append("\n");
        localStringBuilder.append(paramContext);
        if (localStringBuilder.length() <= 8192) {
          continue;
        }
        return localStringBuilder.substring(localStringBuilder.length() - 8192);
        return localStringBuilder.toString();
      }
      if (i1 != 0) {
        return str + "isXposed=true;";
      }
      int i1 = 0;
    }
  }
  
  public static PackageInfo getCurrentWebViewPackage()
  {
    if (!x.a().b())
    {
      if (Build.VERSION.SDK_INT < 26) {
        return null;
      }
      try
      {
        PackageInfo localPackageInfo = (PackageInfo)com.tencent.smtt.utils.i.a("android.webkit.WebView", "getCurrentWebViewPackage");
        return localPackageInfo;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  /* Error */
  @Deprecated
  public static Object getPluginList()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 352	com/tencent/smtt/sdk/x:a	()Lcom/tencent/smtt/sdk/x;
    //   6: invokevirtual 814	com/tencent/smtt/sdk/x:b	()Z
    //   9: ifne +18 -> 27
    //   12: ldc_w 825
    //   15: ldc_w 989
    //   18: invokestatic 829	com/tencent/smtt/utils/i:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;
    //   21: astore_0
    //   22: ldc 2
    //   24: monitorexit
    //   25: aload_0
    //   26: areturn
    //   27: aconst_null
    //   28: astore_0
    //   29: goto -7 -> 22
    //   32: astore_0
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload_0
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   21	8	0	localObject1	Object
    //   32	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   3	22	32	finally
  }
  
  public static int getTbsCoreVersion(Context paramContext)
  {
    return QbSdk.getTbsVersion(paramContext);
  }
  
  public static boolean getTbsNeedReboot()
  {
    c();
    return g.a(true).f();
  }
  
  public static int getTbsSDKVersion(Context paramContext)
  {
    return 44085;
  }
  
  private void h()
  {
    try
    {
      q.b("old01");
      if ("com.xunmeng.pinduoduo".equals(this.i.getApplicationInfo().packageName))
      {
        new Thread("WebviewDestroy")
        {
          public void run()
          {
            WebView.a(WebView.this, false);
          }
        }.start();
        if (this.e)
        {
          this.f.destroy();
          return;
        }
        this.g.destroy();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      q.b("old30");
      a(true);
      return;
    }
    q.b("old02");
    a(true);
  }
  
  private long i()
  {
    synchronized (QbSdk.h)
    {
      if (QbSdk.e)
      {
        QbSdk.g += System.currentTimeMillis() - QbSdk.f;
        TbsLog.d("sdkreport", "pv report, WebView.getWifiConnectedTime QbSdk.sWifiConnectedTime=" + QbSdk.g);
      }
      long l1 = QbSdk.g / 1000L;
      QbSdk.g = 0L;
      QbSdk.f = System.currentTimeMillis();
      return l1;
    }
  }
  
  private void j()
  {
    new Thread(new Runnable()
    {
      public void run()
      {
        boolean bool1 = false;
        if ((!WebView.b(WebView.this)) && (WebView.this.a != 0))
        {
          Object localObject2;
          String str2;
          String str1;
          boolean bool2;
          label254:
          try
          {
            if ((WebView.b(WebView.this)) || (WebView.this.a == 0)) {
              return;
            }
            WebView.b(WebView.this, true);
            Object localObject3 = "";
            String str3 = "";
            String str4 = "";
            localObject2 = localObject3;
            str2 = str3;
            str1 = str4;
            if (WebView.c(WebView.this))
            {
              Bundle localBundle = WebView.d(WebView.this).getX5WebViewExtension().getSdkQBStatisticsInfo();
              localObject2 = localObject3;
              str2 = str3;
              str1 = str4;
              if (localBundle != null)
              {
                localObject2 = localBundle.getString("guid");
                str2 = localBundle.getString("qua2");
                str1 = localBundle.getString("lc");
              }
            }
            if ("com.qzone".equals(WebView.a(WebView.this).getApplicationInfo().packageName))
            {
              int j = WebView.a(WebView.this, WebView.a(WebView.this));
              localObject3 = WebView.this;
              int i = j;
              if (j == -1) {
                i = WebView.this.a;
              }
              ((WebView)localObject3).a = i;
              WebView.b(WebView.this, WebView.a(WebView.this));
            }
          }
          finally {}
          try
          {
            bool2 = WebView.d(WebView.this).getX5WebViewExtension().isX5CoreSandboxMode();
            bool1 = bool2;
          }
          catch (Throwable localThrowable)
          {
            TbsLog.w("onVisibilityChanged", "exception: " + localThrowable);
            break label254;
          }
          com.tencent.smtt.sdk.stat.b.a(WebView.a(WebView.this), (String)localObject2, str2, str1, WebView.this.a, WebView.c(WebView.this), WebView.e(WebView.this), bool1);
          WebView.this.a = 0;
          WebView.b(WebView.this, false);
          return;
        }
      }
    }).start();
  }
  
  public static void setDataDirectorySuffix(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 28) {}
    try
    {
      com.tencent.smtt.utils.i.a(Class.forName("android.webkit.WebView"), "setDataDirectorySuffix", new Class[] { String.class }, new Object[] { paramString });
      HashMap localHashMap = new HashMap();
      localHashMap.put("data_directory_suffix", paramString);
      QbSdk.initTbsSettings(localHashMap);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public static void setSysDayOrNight(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = x;
        if (paramBoolean == bool) {
          return;
        }
        x = paramBoolean;
        if (w == null)
        {
          w = new Paint();
          w.setColor(-16777216);
        }
        if (!paramBoolean)
        {
          if (w.getAlpha() == NIGHT_MODE_ALPHA) {
            continue;
          }
          w.setAlpha(NIGHT_MODE_ALPHA);
          continue;
        }
        if (w.getAlpha() == 255) {
          continue;
        }
      }
      finally {}
      w.setAlpha(255);
    }
  }
  
  public static void setWebContentsDebuggingEnabled(boolean paramBoolean)
  {
    x localx = x.a();
    if ((localx != null) && (localx.b())) {
      localx.c().a(paramBoolean);
    }
    for (;;)
    {
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        try
        {
          n = Class.forName("android.webkit.WebView").getDeclaredMethod("setWebContentsDebuggingEnabled", new Class[] { Boolean.TYPE });
          if (n != null)
          {
            n.setAccessible(true);
            n.invoke(null, new Object[] { Boolean.valueOf(paramBoolean) });
            return;
          }
        }
        catch (Exception localException)
        {
          TbsLog.e("QbSdk", "Exception:" + localException.getStackTrace());
          localException.printStackTrace();
        }
      }
    }
  }
  
  android.webkit.WebView a()
  {
    if (!this.e) {
      return this.g;
    }
    return null;
  }
  
  /* Error */
  void a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 542	com/tencent/smtt/sdk/WebView:e	(Landroid/content/Context;)I
    //   5: istore_2
    //   6: iload_2
    //   7: iconst_m1
    //   8: if_icmpeq +76 -> 84
    //   11: new 403	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 1090
    //   21: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_2
    //   25: iconst_1
    //   26: iadd
    //   27: invokestatic 1092	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   30: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_3
    //   37: aload_1
    //   38: invokestatic 850	com/tencent/smtt/sdk/QbSdk:getTbsFolderDir	(Landroid/content/Context;)Ljava/io/File;
    //   41: astore_1
    //   42: new 852	java/io/File
    //   45: dup
    //   46: new 403	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 404	java/lang/StringBuilder:<init>	()V
    //   53: aload_1
    //   54: invokevirtual 706	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   57: getstatic 855	java/io/File:separator	Ljava/lang/String;
    //   60: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: ldc_w 857
    //   66: invokevirtual 410	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: invokevirtual 421	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: ldc_w 859
    //   75: invokespecial 861	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: astore_1
    //   79: aload_1
    //   80: ifnonnull +11 -> 91
    //   83: return
    //   84: ldc_w 1094
    //   87: astore_3
    //   88: goto -51 -> 37
    //   91: aload_1
    //   92: invokevirtual 1098	java/io/File:getParentFile	()Ljava/io/File;
    //   95: invokevirtual 1101	java/io/File:mkdirs	()Z
    //   98: pop
    //   99: aload_1
    //   100: invokevirtual 1104	java/io/File:isFile	()Z
    //   103: ifeq +10 -> 113
    //   106: aload_1
    //   107: invokevirtual 864	java/io/File:exists	()Z
    //   110: ifne +8 -> 118
    //   113: aload_1
    //   114: invokevirtual 1107	java/io/File:createNewFile	()Z
    //   117: pop
    //   118: new 1109	java/io/FileOutputStream
    //   121: dup
    //   122: aload_1
    //   123: iconst_0
    //   124: invokespecial 1112	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   127: putstatic 107	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   130: getstatic 107	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   133: aload_3
    //   134: invokevirtual 1116	java/lang/String:getBytes	()[B
    //   137: invokevirtual 1122	java/io/OutputStream:write	([B)V
    //   140: getstatic 107	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   143: ifnull -60 -> 83
    //   146: getstatic 107	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   149: invokevirtual 1125	java/io/OutputStream:flush	()V
    //   152: return
    //   153: astore_1
    //   154: getstatic 107	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   157: ifnull +9 -> 166
    //   160: getstatic 107	com/tencent/smtt/sdk/WebView:d	Ljava/io/OutputStream;
    //   163: invokevirtual 1125	java/io/OutputStream:flush	()V
    //   166: aload_1
    //   167: athrow
    //   168: astore_1
    //   169: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	WebView
    //   0	170	1	paramContext	Context
    //   5	22	2	i1	int
    //   36	98	3	str	String
    // Exception table:
    //   from	to	target	type
    //   91	113	153	finally
    //   113	118	153	finally
    //   118	140	153	finally
    //   140	152	168	java/lang/Throwable
    //   154	166	168	java/lang/Throwable
    //   166	168	168	java/lang/Throwable
  }
  
  void a(android.webkit.WebView paramWebView)
  {
    if (!this.e) {}
  }
  
  void a(IX5WebViewBase paramIX5WebViewBase)
  {
    this.f = paramIX5WebViewBase;
  }
  
  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (!this.e)
    {
      this.g.addJavascriptInterface(paramObject, paramString);
      return;
    }
    this.f.addJavascriptInterface(paramObject, paramString);
  }
  
  public void addView(View paramView)
  {
    if (!this.e)
    {
      this.g.addView(paramView);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = com.tencent.smtt.utils.i.a(localView, "addView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  IX5WebViewBase b()
  {
    return this.f;
  }
  
  public boolean canGoBack()
  {
    if (!this.e) {
      return this.g.canGoBack();
    }
    return this.f.canGoBack();
  }
  
  public boolean canGoBackOrForward(int paramInt)
  {
    if (!this.e) {
      return this.g.canGoBackOrForward(paramInt);
    }
    return this.f.canGoBackOrForward(paramInt);
  }
  
  public boolean canGoForward()
  {
    if (!this.e) {
      return this.g.canGoForward();
    }
    return this.f.canGoForward();
  }
  
  @Deprecated
  public boolean canZoomIn()
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.i.a(this.g, "canZoomIn");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.f.canZoomIn();
  }
  
  @Deprecated
  public boolean canZoomOut()
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.i.a(this.g, "canZoomOut");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.f.canZoomOut();
  }
  
  @Deprecated
  public Picture capturePicture()
  {
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.i.a(this.g, "capturePicture");
      if (localObject == null) {
        return null;
      }
      return (Picture)localObject;
    }
    return this.f.capturePicture();
  }
  
  public void clearCache(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.clearCache(paramBoolean);
      return;
    }
    this.f.clearCache(paramBoolean);
  }
  
  public void clearFormData()
  {
    if (!this.e)
    {
      this.g.clearFormData();
      return;
    }
    this.f.clearFormData();
  }
  
  public void clearHistory()
  {
    if (!this.e)
    {
      this.g.clearHistory();
      return;
    }
    this.f.clearHistory();
  }
  
  @TargetApi(3)
  public void clearMatches()
  {
    if (!this.e)
    {
      this.g.clearMatches();
      return;
    }
    this.f.clearMatches();
  }
  
  public void clearSslPreferences()
  {
    if (!this.e)
    {
      this.g.clearSslPreferences();
      return;
    }
    this.f.clearSslPreferences();
  }
  
  @Deprecated
  public void clearView()
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.i.a(this.g, "clearView");
      return;
    }
    this.f.clearView();
  }
  
  public int computeHorizontalScrollExtent()
  {
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.i.a(this.f.getView(), "computeHorizontalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeHorizontalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeHorizontalScrollOffset()
  {
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.i.a(this.f.getView(), "computeHorizontalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeHorizontalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeHorizontalScrollRange()
  {
    try
    {
      if (this.e) {
        return ((Integer)com.tencent.smtt.utils.i.a(this.f.getView(), "computeHorizontalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeHorizontalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public void computeScroll()
  {
    if (!this.e)
    {
      this.g.computeScroll();
      return;
    }
    this.f.computeScroll();
  }
  
  public int computeVerticalScrollExtent()
  {
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.i.a(this.f.getView(), "computeVerticalScrollExtent", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeVerticalScrollExtent", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeVerticalScrollOffset()
  {
    try
    {
      if (this.e)
      {
        localMethod = com.tencent.smtt.utils.i.a(this.f.getView(), "computeVerticalScrollOffset", new Class[0]);
        localMethod.setAccessible(true);
        return ((Integer)localMethod.invoke(this.f.getView(), new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeVerticalScrollOffset", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public int computeVerticalScrollRange()
  {
    try
    {
      if (this.e) {
        return ((Integer)com.tencent.smtt.utils.i.a(this.f.getView(), "computeVerticalScrollRange", new Class[0], new Object[0])).intValue();
      }
      Method localMethod = com.tencent.smtt.utils.i.a(this.g, "computeVerticalScrollRange", new Class[0]);
      localMethod.setAccessible(true);
      int i1 = ((Integer)localMethod.invoke(this.g, new Object[0])).intValue();
      return i1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }
  
  public WebBackForwardList copyBackForwardList()
  {
    if (this.e) {
      return WebBackForwardList.a(this.f.copyBackForwardList());
    }
    return WebBackForwardList.a(this.g.copyBackForwardList());
  }
  
  public Object createPrintDocumentAdapter(String paramString)
  {
    Object localObject = null;
    if (this.e) {}
    while (Build.VERSION.SDK_INT < 21) {
      try
      {
        localObject = this.f.createPrintDocumentAdapter(paramString);
        return localObject;
      }
      catch (Throwable paramString)
      {
        paramString.printStackTrace();
        return null;
      }
    }
    return com.tencent.smtt.utils.i.a(this.g, "createPrintDocumentAdapter", new Class[] { String.class }, new Object[] { paramString });
  }
  
  public void customDiskCachePathEnabled(boolean paramBoolean, String paramString)
  {
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("enabled", paramBoolean);
      localBundle.putString("path", paramString);
      getX5WebViewExtension().invokeMiscMethod("customDiskCachePathEnabled", localBundle);
    }
  }
  
  public void destroy()
  {
    boolean bool2 = false;
    this.m = false;
    boolean bool1 = bool2;
    try
    {
      if (this.i.getApplicationInfo().packageName.contains("com.tencent.qqmusic")) {
        if (Build.VERSION.SDK_INT != 21)
        {
          bool1 = bool2;
          if (Build.VERSION.SDK_INT != 22) {}
        }
        else
        {
          this.m = true;
          boolean bool3 = q.f(this.i);
          bool1 = bool2;
          if (!bool3) {
            bool1 = true;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        TbsLog.i("webview", "stack is " + Log.getStackTraceString(localThrowable));
        bool1 = bool2;
      }
      g();
    }
    TbsLog.i("webview", "destroy forceDestoyOld is " + bool1);
    if (bool1)
    {
      h();
      return;
    }
  }
  
  public void documentHasImages(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.documentHasImages(paramMessage);
      return;
    }
    this.f.documentHasImages(paramMessage);
  }
  
  public void dumpViewHierarchyWithProperties(BufferedWriter paramBufferedWriter, int paramInt)
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.i.a(this.g, "dumpViewHierarchyWithProperties", new Class[] { BufferedWriter.class, Integer.TYPE }, new Object[] { paramBufferedWriter, Integer.valueOf(paramInt) });
      return;
    }
    this.f.dumpViewHierarchyWithProperties(paramBufferedWriter, paramInt);
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (this.e) {}
    Method localMethod;
    while (Build.VERSION.SDK_INT < 19) {
      try
      {
        localMethod = com.tencent.smtt.utils.i.a(this.f.getView(), "evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
        localMethod.setAccessible(true);
        localMethod.invoke(this.f.getView(), new Object[] { paramString, paramValueCallback });
        return;
      }
      catch (Exception paramValueCallback)
      {
        paramValueCallback.printStackTrace();
        loadUrl(paramString);
        return;
      }
    }
    try
    {
      localMethod = Class.forName("android.webkit.WebView").getDeclaredMethod("evaluateJavascript", new Class[] { String.class, android.webkit.ValueCallback.class });
      localMethod.setAccessible(true);
      localMethod.invoke(this.g, new Object[] { paramString, paramValueCallback });
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  @Deprecated
  public int findAll(String paramString)
  {
    if (!this.e)
    {
      paramString = com.tencent.smtt.utils.i.a(this.g, "findAll", new Class[] { String.class }, new Object[] { paramString });
      if (paramString == null) {
        return 0;
      }
      return ((Integer)paramString).intValue();
    }
    return this.f.findAll(paramString);
  }
  
  @TargetApi(16)
  public void findAllAsync(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        com.tencent.smtt.utils.i.a(this.g, "findAllAsync", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.f.findAllAsync(paramString);
  }
  
  public View findHierarchyView(String paramString, int paramInt)
  {
    if (!this.e) {
      return (View)com.tencent.smtt.utils.i.a(this.g, "findHierarchyView", new Class[] { String.class, Integer.TYPE }, new Object[] { paramString, Integer.valueOf(paramInt) });
    }
    return this.f.findHierarchyView(paramString, paramInt);
  }
  
  @TargetApi(3)
  public void findNext(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.findNext(paramBoolean);
      return;
    }
    this.f.findNext(paramBoolean);
  }
  
  public void flingScroll(int paramInt1, int paramInt2)
  {
    if (!this.e)
    {
      this.g.flingScroll(paramInt1, paramInt2);
      return;
    }
    this.f.flingScroll(paramInt1, paramInt2);
  }
  
  @Deprecated
  public void freeMemory()
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.i.a(this.g, "freeMemory");
      return;
    }
    this.f.freeMemory();
  }
  
  public SslCertificate getCertificate()
  {
    if (!this.e) {
      return this.g.getCertificate();
    }
    return this.f.getCertificate();
  }
  
  public int getContentHeight()
  {
    if (!this.e) {
      return this.g.getContentHeight();
    }
    return this.f.getContentHeight();
  }
  
  public int getContentWidth()
  {
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.i.a(this.g, "getContentWidth");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.f.getContentWidth();
  }
  
  public Bitmap getFavicon()
  {
    if (!this.e) {
      return this.g.getFavicon();
    }
    return this.f.getFavicon();
  }
  
  public HitTestResult getHitTestResult()
  {
    if (!this.e) {
      return new HitTestResult(this.g.getHitTestResult());
    }
    return new HitTestResult(this.f.getHitTestResult());
  }
  
  public String[] getHttpAuthUsernamePassword(String paramString1, String paramString2)
  {
    if (!this.e) {
      return this.g.getHttpAuthUsernamePassword(paramString1, paramString2);
    }
    return this.f.getHttpAuthUsernamePassword(paramString1, paramString2);
  }
  
  @TargetApi(3)
  public String getOriginalUrl()
  {
    if (!this.e) {
      return this.g.getOriginalUrl();
    }
    return this.f.getOriginalUrl();
  }
  
  public int getProgress()
  {
    if (!this.e) {
      return this.g.getProgress();
    }
    return this.f.getProgress();
  }
  
  public boolean getRendererPriorityWaivedWhenNotVisible()
  {
    boolean bool;
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return false;
        }
        Object localObject = com.tencent.smtt.utils.i.a(this.g, "getRendererPriorityWaivedWhenNotVisible");
        if (localObject == null) {
          bool = false;
        } else {
          bool = ((Boolean)localObject).booleanValue();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
    return bool;
  }
  
  public int getRendererRequestedPriority()
  {
    int i1;
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return 0;
        }
        Object localObject = com.tencent.smtt.utils.i.a(this.g, "getRendererRequestedPriority");
        if (localObject == null) {
          i1 = 0;
        } else {
          i1 = ((Integer)localObject).intValue();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
    return i1;
  }
  
  @Deprecated
  public float getScale()
  {
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.i.a(this.g, "getScale");
      if (localObject == null) {
        return 0.0F;
      }
      return ((Float)localObject).floatValue();
    }
    return this.f.getScale();
  }
  
  public int getScrollBarDefaultDelayBeforeFade()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarDefaultDelayBeforeFade();
  }
  
  public int getScrollBarFadeDuration()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarFadeDuration();
  }
  
  public int getScrollBarSize()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarSize();
  }
  
  public int getScrollBarStyle()
  {
    if (getView() == null) {
      return 0;
    }
    return getView().getScrollBarStyle();
  }
  
  public WebSettings getSettings()
  {
    if (this.h != null) {
      return this.h;
    }
    if (this.e)
    {
      localWebSettings = new WebSettings(this.f.getSettings());
      this.h = localWebSettings;
      return localWebSettings;
    }
    WebSettings localWebSettings = new WebSettings(this.g.getSettings());
    this.h = localWebSettings;
    return localWebSettings;
  }
  
  public IX5WebSettingsExtension getSettingsExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getSettingsExtension();
  }
  
  public int getSysNightModeAlpha()
  {
    return NIGHT_MODE_ALPHA;
  }
  
  public String getTitle()
  {
    if (!this.e) {
      return this.g.getTitle();
    }
    return this.f.getTitle();
  }
  
  public String getUrl()
  {
    if (!this.e) {
      return this.g.getUrl();
    }
    return this.f.getUrl();
  }
  
  public View getView()
  {
    if (!this.e) {
      return this.g;
    }
    return this.f.getView();
  }
  
  public int getVisibleTitleHeight()
  {
    if (!this.e)
    {
      Object localObject = com.tencent.smtt.utils.i.a(this.g, "getVisibleTitleHeight");
      if (localObject == null) {
        return 0;
      }
      return ((Integer)localObject).intValue();
    }
    return this.f.getVisibleTitleHeight();
  }
  
  public WebChromeClient getWebChromeClient()
  {
    return this.p;
  }
  
  public IX5WebChromeClientExtension getWebChromeClientExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getWebChromeClientExtension();
  }
  
  public int getWebScrollX()
  {
    if (this.e) {
      return this.f.getView().getScrollX();
    }
    return this.g.getScrollX();
  }
  
  public int getWebScrollY()
  {
    if (this.e) {
      return this.f.getView().getScrollY();
    }
    return this.g.getScrollY();
  }
  
  public WebViewClient getWebViewClient()
  {
    return this.o;
  }
  
  public IX5WebViewClientExtension getWebViewClientExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension().getWebViewClientExtension();
  }
  
  public IX5WebViewBase.HitTestResult getX5HitTestResult()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getHitTestResult();
  }
  
  public IX5WebViewExtension getX5WebViewExtension()
  {
    if (!this.e) {
      return null;
    }
    return this.f.getX5WebViewExtension();
  }
  
  @Deprecated
  public View getZoomControls()
  {
    if (!this.e) {
      return (View)com.tencent.smtt.utils.i.a(this.g, "getZoomControls");
    }
    return this.f.getZoomControls();
  }
  
  public void goBack()
  {
    if (!this.e)
    {
      this.g.goBack();
      return;
    }
    this.f.goBack();
  }
  
  public void goBackOrForward(int paramInt)
  {
    if (!this.e)
    {
      this.g.goBackOrForward(paramInt);
      return;
    }
    this.f.goBackOrForward(paramInt);
  }
  
  public void goForward()
  {
    if (!this.e)
    {
      this.g.goForward();
      return;
    }
    this.f.goForward();
  }
  
  public void invokeZoomPicker()
  {
    if (!this.e)
    {
      this.g.invokeZoomPicker();
      return;
    }
    this.f.invokeZoomPicker();
  }
  
  public boolean isDayMode()
  {
    return x;
  }
  
  public boolean isPrivateBrowsingEnabled()
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        Object localObject = com.tencent.smtt.utils.i.a(this.g, "isPrivateBrowsingEnabled");
        if (localObject == null) {
          return false;
        }
        return ((Boolean)localObject).booleanValue();
      }
      return false;
    }
    return this.f.isPrivateBrowsingEnable();
  }
  
  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    if (!this.e)
    {
      this.g.loadData(paramString1, paramString2, paramString3);
      return;
    }
    this.f.loadData(paramString1, paramString2, paramString3);
  }
  
  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    if (!this.e)
    {
      this.g.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      return;
    }
    this.f.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public void loadUrl(String paramString)
  {
    if ((!this.e) || ((paramString == null) || (showDebugView(paramString)))) {
      return;
    }
    if (!this.e)
    {
      this.g.loadUrl(paramString);
      return;
    }
    this.f.loadUrl(paramString);
  }
  
  @TargetApi(8)
  public void loadUrl(String paramString, Map<String, String> paramMap)
  {
    if ((!this.e) || ((paramString == null) || (showDebugView(paramString)))) {}
    do
    {
      return;
      if (this.e) {
        break;
      }
    } while (Build.VERSION.SDK_INT < 8);
    this.g.loadUrl(paramString, paramMap);
    return;
    this.f.loadUrl(paramString, paramMap);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((!this.k) && (this.a != 0)) {
      j();
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.z != null)
    {
      if (!this.z.onLongClick(paramView)) {
        return a(paramView);
      }
      return true;
    }
    return a(paramView);
  }
  
  public void onPause()
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.i.a(this.g, "onPause");
      return;
    }
    this.f.onPause();
  }
  
  public void onResume()
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.i.a(this.g, "onResume");
      return;
    }
    this.f.onResume();
  }
  
  @TargetApi(11)
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT >= 21) && (b(this.i)) && (isHardwareAccelerated()) && (paramInt1 > 0) && (paramInt2 > 0) && (getLayerType() != 2)) {}
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    if (this.i == null)
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if (q == null) {
      q = this.i.getApplicationInfo().packageName;
    }
    if ((q != null) && ((q.equals("com.tencent.mm")) || (q.equals("com.tencent.mobileqq"))))
    {
      super.onVisibilityChanged(paramView, paramInt);
      return;
    }
    if ((paramInt != 0) && (!this.k) && (this.a != 0)) {
      j();
    }
    super.onVisibilityChanged(paramView, paramInt);
  }
  
  public boolean overlayHorizontalScrollbar()
  {
    if (!this.e) {
      return this.g.overlayHorizontalScrollbar();
    }
    return this.f.overlayHorizontalScrollbar();
  }
  
  public boolean overlayVerticalScrollbar()
  {
    if (this.e) {
      return this.f.overlayVerticalScrollbar();
    }
    return this.g.overlayVerticalScrollbar();
  }
  
  public boolean pageDown(boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.pageDown(paramBoolean);
    }
    return this.f.pageDown(paramBoolean, -1);
  }
  
  public boolean pageUp(boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.pageUp(paramBoolean);
    }
    return this.f.pageUp(paramBoolean, -1);
  }
  
  public void pauseTimers()
  {
    if (!this.e)
    {
      this.g.pauseTimers();
      return;
    }
    this.f.pauseTimers();
  }
  
  @TargetApi(5)
  public void postUrl(String paramString, byte[] paramArrayOfByte)
  {
    if (!this.e)
    {
      this.g.postUrl(paramString, paramArrayOfByte);
      return;
    }
    this.f.postUrl(paramString, paramArrayOfByte);
  }
  
  @Deprecated
  public void refreshPlugins(boolean paramBoolean)
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.i.a(this.g, "refreshPlugins", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.f.refreshPlugins(paramBoolean);
  }
  
  public void reload()
  {
    if (!this.e)
    {
      this.g.reload();
      return;
    }
    this.f.reload();
  }
  
  @TargetApi(11)
  public void removeJavascriptInterface(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        com.tencent.smtt.utils.i.a(this.g, "removeJavascriptInterface", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.f.removeJavascriptInterface(paramString);
  }
  
  public void removeView(View paramView)
  {
    if (!this.e)
    {
      this.g.removeView(paramView);
      return;
    }
    View localView = this.f.getView();
    try
    {
      Method localMethod = com.tencent.smtt.utils.i.a(localView, "removeView", new Class[] { View.class });
      localMethod.setAccessible(true);
      localMethod.invoke(localView, new Object[] { paramView });
      return;
    }
    catch (Throwable paramView) {}
  }
  
  public JSONObject reportInitPerformance(long paramLong1, int paramInt, long paramLong2, long paramLong3)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("IS_X5", this.e);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject;
  }
  
  public boolean requestChildRectangleOnScreen(View paramView, Rect paramRect, boolean paramBoolean)
  {
    if (this.e)
    {
      localObject1 = this.f.getView();
      if ((localObject1 instanceof ViewGroup))
      {
        localObject2 = (ViewGroup)localObject1;
        if (paramView == this) {
          paramView = (View)localObject1;
        }
        for (;;)
        {
          return ((ViewGroup)localObject2).requestChildRectangleOnScreen(paramView, paramRect, paramBoolean);
        }
      }
      return false;
    }
    Object localObject2 = this.g;
    Object localObject1 = paramView;
    if (paramView == this) {
      localObject1 = this.g;
    }
    return ((android.webkit.WebView)localObject2).requestChildRectangleOnScreen((View)localObject1, paramRect, paramBoolean);
  }
  
  public void requestFocusNodeHref(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.requestFocusNodeHref(paramMessage);
      return;
    }
    this.f.requestFocusNodeHref(paramMessage);
  }
  
  public void requestImageRef(Message paramMessage)
  {
    if (!this.e)
    {
      this.g.requestImageRef(paramMessage);
      return;
    }
    this.f.requestImageRef(paramMessage);
  }
  
  @Deprecated
  public boolean restorePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.e)
    {
      paramBundle = com.tencent.smtt.utils.i.a(this.g, "restorePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.f.restorePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList restoreState(Bundle paramBundle)
  {
    if (!this.e) {
      return WebBackForwardList.a(this.g.restoreState(paramBundle));
    }
    return WebBackForwardList.a(this.f.restoreState(paramBundle));
  }
  
  public void resumeTimers()
  {
    if (!this.e)
    {
      this.g.resumeTimers();
      return;
    }
    this.f.resumeTimers();
  }
  
  @Deprecated
  public void savePassword(String paramString1, String paramString2, String paramString3)
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.i.a(this.g, "savePassword", new Class[] { String.class, String.class, String.class }, new Object[] { paramString1, paramString2, paramString3 });
      return;
    }
    this.f.savePassword(paramString1, paramString2, paramString3);
  }
  
  @Deprecated
  public boolean savePicture(Bundle paramBundle, File paramFile)
  {
    if (!this.e)
    {
      paramBundle = com.tencent.smtt.utils.i.a(this.g, "savePicture", new Class[] { Bundle.class, File.class }, new Object[] { paramBundle, paramFile });
      if (paramBundle == null) {
        return false;
      }
      return ((Boolean)paramBundle).booleanValue();
    }
    return this.f.savePicture(paramBundle, paramFile);
  }
  
  public WebBackForwardList saveState(Bundle paramBundle)
  {
    if (!this.e) {
      return WebBackForwardList.a(this.g.saveState(paramBundle));
    }
    return WebBackForwardList.a(this.f.saveState(paramBundle));
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        com.tencent.smtt.utils.i.a(this.g, "saveWebArchive", new Class[] { String.class }, new Object[] { paramString });
      }
      return;
    }
    this.f.saveWebArchive(paramString);
  }
  
  @TargetApi(11)
  public void saveWebArchive(String paramString, boolean paramBoolean, ValueCallback<String> paramValueCallback)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 11) {
        com.tencent.smtt.utils.i.a(this.g, "saveWebArchive", new Class[] { String.class, Boolean.TYPE, android.webkit.ValueCallback.class }, new Object[] { paramString, Boolean.valueOf(paramBoolean), paramValueCallback });
      }
      return;
    }
    this.f.saveWebArchive(paramString, paramBoolean, paramValueCallback);
  }
  
  public void setARModeEnable(boolean paramBoolean)
  {
    try
    {
      if (this.e) {
        getSettingsExtension().setARModeEnable(paramBoolean);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (!this.e) {
      this.g.setBackgroundColor(paramInt);
    }
    for (;;)
    {
      super.setBackgroundColor(paramInt);
      return;
      this.f.setBackgroundColor(paramInt);
    }
  }
  
  @Deprecated
  public void setCertificate(SslCertificate paramSslCertificate)
  {
    if (!this.e)
    {
      this.g.setCertificate(paramSslCertificate);
      return;
    }
    this.f.setCertificate(paramSslCertificate);
  }
  
  public void setDayOrNight(boolean paramBoolean)
  {
    try
    {
      if (this.e) {
        getSettingsExtension().setDayOrNight(paramBoolean);
      }
      setSysDayOrNight(paramBoolean);
      getView().postInvalidate();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void setDownloadListener(final DownloadListener paramDownloadListener)
  {
    if (!this.e)
    {
      this.g.setDownloadListener(new android.webkit.DownloadListener()
      {
        public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
        {
          if (paramDownloadListener == null)
          {
            if (WebView.a(WebView.this) == null) {}
            for (paramAnonymousString2 = null;; paramAnonymousString2 = WebView.a(WebView.this).getApplicationInfo())
            {
              if ((paramAnonymousString2 == null) || (!"com.tencent.mm".equals(paramAnonymousString2.packageName))) {
                MttLoader.loadUrl(WebView.a(WebView.this), paramAnonymousString1, null, null);
              }
              return;
            }
          }
          paramDownloadListener.onDownloadStart(paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, paramAnonymousString4, paramAnonymousLong);
        }
      });
      return;
    }
    this.f.setDownloadListener(new b(this, paramDownloadListener, this.e));
  }
  
  @TargetApi(16)
  public void setFindListener(final IX5WebViewBase.FindListener paramFindListener)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 16) {
        this.g.setFindListener(new WebView.FindListener()
        {
          public void onFindResultReceived(int paramAnonymousInt1, int paramAnonymousInt2, boolean paramAnonymousBoolean)
          {
            paramFindListener.onFindResultReceived(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousBoolean);
          }
        });
      }
      return;
    }
    this.f.setFindListener(paramFindListener);
  }
  
  public void setHorizontalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.setHorizontalScrollbarOverlay(paramBoolean);
      return;
    }
    this.f.setHorizontalScrollbarOverlay(paramBoolean);
  }
  
  public void setHttpAuthUsernamePassword(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    if (!this.e)
    {
      this.g.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
      return;
    }
    this.f.setHttpAuthUsernamePassword(paramString1, paramString2, paramString3, paramString4);
  }
  
  public void setInitialScale(int paramInt)
  {
    if (!this.e)
    {
      this.g.setInitialScale(paramInt);
      return;
    }
    this.f.setInitialScale(paramInt);
  }
  
  @Deprecated
  public void setMapTrackballToArrowKeys(boolean paramBoolean)
  {
    if (!this.e)
    {
      com.tencent.smtt.utils.i.a(this.g, "setMapTrackballToArrowKeys", new Class[] { Boolean.TYPE }, new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    this.f.setMapTrackballToArrowKeys(paramBoolean);
  }
  
  public void setNetworkAvailable(boolean paramBoolean)
  {
    if (!this.e)
    {
      if (Build.VERSION.SDK_INT >= 3) {
        this.g.setNetworkAvailable(paramBoolean);
      }
      return;
    }
    this.f.setNetworkAvailable(paramBoolean);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    if (!this.e)
    {
      this.g.setOnLongClickListener(paramOnLongClickListener);
      return;
    }
    Object localObject1 = this.f.getView();
    try
    {
      if (this.y == null)
      {
        Object localObject2 = com.tencent.smtt.utils.i.a(localObject1, "getListenerInfo", new Class[0]);
        ((Method)localObject2).setAccessible(true);
        localObject1 = ((Method)localObject2).invoke(localObject1, (Object[])null);
        localObject2 = localObject1.getClass().getDeclaredField("mOnLongClickListener");
        ((Field)localObject2).setAccessible(true);
        this.y = ((Field)localObject2).get(localObject1);
      }
      this.z = paramOnLongClickListener;
      getView().setOnLongClickListener(this);
      return;
    }
    catch (Throwable paramOnLongClickListener) {}
  }
  
  public void setOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    getView().setOnTouchListener(paramOnTouchListener);
  }
  
  @Deprecated
  public void setPictureListener(final PictureListener paramPictureListener)
  {
    if (!this.e)
    {
      if (paramPictureListener == null)
      {
        this.g.setPictureListener(null);
        return;
      }
      this.g.setPictureListener(new android.webkit.WebView.PictureListener()
      {
        public void onNewPicture(android.webkit.WebView paramAnonymousWebView, Picture paramAnonymousPicture)
        {
          WebView.this.a(paramAnonymousWebView);
          paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
        }
      });
      return;
    }
    if (paramPictureListener == null)
    {
      this.f.setPictureListener(null);
      return;
    }
    this.f.setPictureListener(new IX5WebViewBase.PictureListener()
    {
      public void onNewPicture(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture, boolean paramAnonymousBoolean)
      {
        WebView.this.a(paramAnonymousIX5WebViewBase);
        paramPictureListener.onNewPicture(WebView.this, paramAnonymousPicture);
      }
      
      public void onNewPictureIfHaveContent(IX5WebViewBase paramAnonymousIX5WebViewBase, Picture paramAnonymousPicture) {}
    });
  }
  
  public void setRendererPriorityPolicy(int paramInt, boolean paramBoolean)
  {
    try
    {
      if (!this.e)
      {
        if (Build.VERSION.SDK_INT < 26) {
          return;
        }
        com.tencent.smtt.utils.i.a(this.g, "setRendererPriorityPolicy", new Class[] { Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void setScrollBarStyle(int paramInt)
  {
    if (this.e)
    {
      this.f.getView().setScrollBarStyle(paramInt);
      return;
    }
    this.g.setScrollBarStyle(paramInt);
  }
  
  public void setSysNightModeAlpha(int paramInt)
  {
    NIGHT_MODE_ALPHA = paramInt;
  }
  
  public void setVerticalScrollbarOverlay(boolean paramBoolean)
  {
    if (!this.e)
    {
      this.g.setVerticalScrollbarOverlay(paramBoolean);
      return;
    }
    this.f.setVerticalScrollbarOverlay(paramBoolean);
  }
  
  public boolean setVideoFullScreen(Context paramContext, boolean paramBoolean)
  {
    if ((paramContext.getApplicationInfo().processName.contains("com.tencent.android.qqdownloader")) && (this.f != null))
    {
      paramContext = new Bundle();
      if (paramBoolean) {
        paramContext.putInt("DefaultVideoScreen", 2);
      }
      for (;;)
      {
        this.f.getX5WebViewExtension().invokeMiscMethod("setVideoParams", paramContext);
        return true;
        paramContext.putInt("DefaultVideoScreen", 1);
      }
    }
    return false;
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (getView() == null) {
      return;
    }
    getView().setVisibility(paramInt);
  }
  
  public void setWebChromeClient(WebChromeClient paramWebChromeClient)
  {
    Object localObject = null;
    if (this.e)
    {
      IX5WebViewBase localIX5WebViewBase = this.f;
      if (paramWebChromeClient == null) {
        localIX5WebViewBase.setWebChromeClient((IX5WebChromeClient)localObject);
      }
    }
    for (;;)
    {
      this.p = paramWebChromeClient;
      return;
      localObject = new i(x.a().a(true).i(), this, paramWebChromeClient);
      break;
      if (paramWebChromeClient != null)
      {
        if (a(paramWebChromeClient)) {
          this.g.setWebChromeClient(new e(this, paramWebChromeClient));
        } else {
          this.g.setWebChromeClient(new SystemWebChromeClient(this, paramWebChromeClient));
        }
      }
      else {
        this.g.setWebChromeClient(null);
      }
    }
  }
  
  public void setWebChromeClientExtension(IX5WebChromeClientExtension paramIX5WebChromeClientExtension)
  {
    if (!this.e) {
      return;
    }
    this.f.getX5WebViewExtension().setWebChromeClientExtension(paramIX5WebChromeClientExtension);
  }
  
  public void setWebViewCallbackClient(WebViewCallbackClient paramWebViewCallbackClient)
  {
    this.mWebViewCallbackClient = paramWebViewCallbackClient;
    if ((this.e) && (getX5WebViewExtension() != null))
    {
      paramWebViewCallbackClient = new Bundle();
      paramWebViewCallbackClient.putBoolean("flag", true);
      getX5WebViewExtension().invokeMiscMethod("setWebViewCallbackClientFlag", paramWebViewCallbackClient);
    }
  }
  
  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
    IX5WebViewBase localIX5WebViewBase = null;
    Object localObject = null;
    if (this.e)
    {
      localIX5WebViewBase = this.f;
      if (paramWebViewClient == null) {}
      for (;;)
      {
        localIX5WebViewBase.setWebViewClient((IX5WebViewClient)localObject);
        this.o = paramWebViewClient;
        return;
        localObject = new j(x.a().a(true).j(), this, paramWebViewClient);
      }
    }
    a locala = this.g;
    if (paramWebViewClient == null) {}
    for (localObject = localIX5WebViewBase;; localObject = new SystemWebViewClient(this, paramWebViewClient))
    {
      locala.setWebViewClient((android.webkit.WebViewClient)localObject);
      break;
    }
  }
  
  public void setWebViewClientExtension(IX5WebViewClientExtension paramIX5WebViewClientExtension)
  {
    if (!this.e) {
      return;
    }
    this.f.getX5WebViewExtension().setWebViewClientExtension(paramIX5WebViewClientExtension);
  }
  
  @SuppressLint({"NewApi"})
  public boolean showDebugView(String paramString)
  {
    boolean bool2 = false;
    paramString = paramString.toLowerCase();
    boolean bool1;
    if (paramString.startsWith("https://debugtbs.qq.com"))
    {
      getView().setVisibility(4);
      d.a(this.i).a(paramString, this, this.i, o.a().getLooper());
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!paramString.startsWith("https://debugx5.qq.com"));
      bool1 = bool2;
    } while (this.e);
    paramString = new StringBuilder();
    paramString.append("<!DOCTYPE html><html><body>");
    paramString.append("<head>");
    paramString.append("<title>无法打开debugx5</title>");
    paramString.append("<meta name=\"viewport\" content=\"width=device-width, user-scalable=no\" />");
    paramString.append("</head>");
    paramString.append("<br/><br /><h2>debugx5页面仅在使用了X5内核时有效，由于当前没有使用X5内核，无法打开debugx5！</h2><br />");
    paramString.append("尝试<a href=\"https://debugtbs.qq.com?10000\">进入DebugTbs安装或打开X5内核</a>");
    paramString.append("</body></html>");
    loadDataWithBaseURL(null, paramString.toString(), "text/html", "utf-8", null);
    return true;
  }
  
  public boolean showFindDialog(String paramString, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopLoading()
  {
    if (!this.e)
    {
      this.g.stopLoading();
      return;
    }
    this.f.stopLoading();
  }
  
  public void super_computeScroll()
  {
    if (!this.e)
    {
      this.g.a();
      return;
    }
    View localView = this.f.getView();
    try
    {
      com.tencent.smtt.utils.i.a(localView, "super_computeScroll");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.b(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.i.a(localView, "super_dispatchTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.c(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.i.a(localView, "super_onInterceptTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public void super_onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      return;
    }
    View localView = this.f.getView();
    try
    {
      com.tencent.smtt.utils.i.a(localView, "super_onOverScrolled", new Class[] { Integer.TYPE, Integer.TYPE, Boolean.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void super_onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.e)
    {
      this.g.a(paramInt1, paramInt2, paramInt3, paramInt4);
      return;
    }
    View localView = this.f.getView();
    try
    {
      com.tencent.smtt.utils.i.a(localView, "super_onScrollChanged", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public boolean super_onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.e) {
      return this.g.a(paramMotionEvent);
    }
    View localView = this.f.getView();
    try
    {
      paramMotionEvent = com.tencent.smtt.utils.i.a(localView, "super_onTouchEvent", new Class[] { MotionEvent.class }, new Object[] { paramMotionEvent });
      if (paramMotionEvent == null) {
        return false;
      }
      boolean bool = ((Boolean)paramMotionEvent).booleanValue();
      return bool;
    }
    catch (Throwable paramMotionEvent) {}
    return false;
  }
  
  public boolean super_overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
  {
    if (!this.e) {
      return this.g.a(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
    }
    Object localObject = this.f.getView();
    try
    {
      localObject = com.tencent.smtt.utils.i.a(localObject, "super_overScrollBy", new Class[] { Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, Boolean.TYPE }, new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), Integer.valueOf(paramInt8), Boolean.valueOf(paramBoolean) });
      if (localObject == null) {
        return false;
      }
      paramBoolean = ((Boolean)localObject).booleanValue();
      return paramBoolean;
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public void switchNightMode(boolean paramBoolean)
  {
    if (paramBoolean == x) {
      return;
    }
    x = paramBoolean;
    if (x)
    {
      TbsLog.e("QB_SDK", "deleteNightMode");
      loadUrl("javascript:document.getElementsByTagName('HEAD').item(0).removeChild(document.getElementById('QQBrowserSDKNightMode'));");
      return;
    }
    TbsLog.e("QB_SDK", "nightMode");
    loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
  }
  
  public void switchToNightMode()
  {
    TbsLog.e("QB_SDK", "switchToNightMode 01");
    if (!x)
    {
      TbsLog.e("QB_SDK", "switchToNightMode");
      loadUrl("javascript:var style = document.createElement('style');style.type='text/css';style.id='QQBrowserSDKNightMode';style.innerHTML='html,body{background:none !important;background-color: #1d1e2a !important;}html *{background-color: #1d1e2a !important; color:#888888 !important;border-color:#3e4f61 !important;text-shadow:none !important;box-shadow:none !important;}a,a *{border-color:#4c5b99 !important; color:#2d69b3 !important;text-decoration:none !important;}a:visited,a:visited *{color:#a600a6 !important;}a:active,a:active *{color:#5588AA !important;}input,select,textarea,option,button{background-image:none !important;color:#AAAAAA !important;border-color:#4c5b99 !important;}form,div,button,span{background-color:#1d1e2a !important; border-color:#4c5b99 !important;}img{opacity:0.5}';document.getElementsByTagName('HEAD').item(0).appendChild(style);");
    }
  }
  
  public boolean zoomIn()
  {
    if (!this.e) {
      return this.g.zoomIn();
    }
    return this.f.zoomIn();
  }
  
  public boolean zoomOut()
  {
    if (!this.e) {
      return this.g.zoomOut();
    }
    return this.f.zoomOut();
  }
  
  public static class HitTestResult
  {
    @Deprecated
    public static final int ANCHOR_TYPE = 1;
    public static final int EDIT_TEXT_TYPE = 9;
    public static final int EMAIL_TYPE = 4;
    public static final int GEO_TYPE = 3;
    @Deprecated
    public static final int IMAGE_ANCHOR_TYPE = 6;
    public static final int IMAGE_TYPE = 5;
    public static final int PHONE_TYPE = 2;
    public static final int SRC_ANCHOR_TYPE = 7;
    public static final int SRC_IMAGE_ANCHOR_TYPE = 8;
    public static final int UNKNOWN_TYPE = 0;
    private IX5WebViewBase.HitTestResult a;
    private android.webkit.WebView.HitTestResult b = null;
    
    public HitTestResult()
    {
      this.a = null;
      this.b = null;
    }
    
    public HitTestResult(android.webkit.WebView.HitTestResult paramHitTestResult)
    {
      this.a = null;
      this.b = paramHitTestResult;
    }
    
    public HitTestResult(IX5WebViewBase.HitTestResult paramHitTestResult)
    {
      this.a = paramHitTestResult;
      this.b = null;
    }
    
    public String getExtra()
    {
      String str = "";
      if (this.a != null) {
        str = this.a.getExtra();
      }
      while (this.b == null) {
        return str;
      }
      return this.b.getExtra();
    }
    
    public int getType()
    {
      int i = 0;
      if (this.a != null) {
        i = this.a.getType();
      }
      while (this.b == null) {
        return i;
      }
      return this.b.getType();
    }
  }
  
  @Deprecated
  public static abstract interface PictureListener
  {
    @Deprecated
    public abstract void onNewPicture(WebView paramWebView, Picture paramPicture);
  }
  
  public class WebViewTransport
  {
    private WebView b;
    
    public WebViewTransport() {}
    
    public WebView getWebView()
    {
      try
      {
        WebView localWebView = this.b;
        return localWebView;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setWebView(WebView paramWebView)
    {
      try
      {
        this.b = paramWebView;
        return;
      }
      finally
      {
        paramWebView = finally;
        throw paramWebView;
      }
    }
  }
  
  private class a
    extends android.webkit.WebView
  {
    public a(Context paramContext)
    {
      this(paramContext, null);
    }
    
    public a(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      if ((QbSdk.getIsSysWebViewForcedByOuter()) && (TbsShareManager.isThirdPartyApp(paramContext))) {
        return;
      }
      CookieSyncManager.createInstance(WebView.a(WebView.this)).startSync();
      try
      {
        this$1 = Class.forName("android.webkit.WebViewWorker").getDeclaredMethod("getHandler", new Class[0]);
        WebView.this.setAccessible(true);
        ((Handler)WebView.this.invoke(null, new Object[0])).getLooper().getThread().setUncaughtExceptionHandler(new h());
        WebView.mSysWebviewCreated = true;
        return;
      }
      catch (Exception this$1) {}
    }
    
    public void a()
    {
      super.computeScroll();
    }
    
    public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    @TargetApi(9)
    public void a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
      }
    }
    
    @TargetApi(9)
    public boolean a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
    
    public boolean a(MotionEvent paramMotionEvent)
    {
      return super.onTouchEvent(paramMotionEvent);
    }
    
    public boolean b(MotionEvent paramMotionEvent)
    {
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public boolean c(MotionEvent paramMotionEvent)
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    public void computeScroll()
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.computeScroll(this);
        return;
      }
      super.computeScroll();
    }
    
    protected void dispatchDraw(Canvas paramCanvas)
    {
      try
      {
        super.dispatchDraw(paramCanvas);
        if ((!WebView.d()) && (WebView.e() != null))
        {
          paramCanvas.save();
          paramCanvas.drawPaint(WebView.e());
          paramCanvas.restore();
        }
        return;
      }
      catch (Throwable paramCanvas)
      {
        paramCanvas.printStackTrace();
      }
    }
    
    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.dispatchTouchEvent(paramMotionEvent, this);
      }
      return super.dispatchTouchEvent(paramMotionEvent);
    }
    
    public android.webkit.WebSettings getSettings()
    {
      try
      {
        android.webkit.WebSettings localWebSettings = super.getSettings();
        return localWebSettings;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return null;
    }
    
    public void invalidate()
    {
      super.invalidate();
      if (WebView.this.mWebViewCallbackClient != null) {
        WebView.this.mWebViewCallbackClient.invalidate();
      }
    }
    
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.onInterceptTouchEvent(paramMotionEvent, this);
      }
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    
    @TargetApi(9)
    public void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        WebView.this.mWebViewCallbackClient.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2, this);
      }
      while (Build.VERSION.SDK_INT < 9) {
        return;
      }
      super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    }
    
    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      if (WebView.this.mWebViewCallbackClient != null)
      {
        WebView.this.mWebViewCallbackClient.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4, this);
        return;
      }
      super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      WebView.b(WebView.this, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent paramMotionEvent)
    {
      if (!hasFocus()) {
        requestFocus();
      }
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.onTouchEvent(paramMotionEvent, this);
      }
      try
      {
        boolean bool = super.onTouchEvent(paramMotionEvent);
        return bool;
      }
      catch (Exception paramMotionEvent)
      {
        paramMotionEvent.printStackTrace();
      }
      return false;
    }
    
    @TargetApi(9)
    public boolean overScrollBy(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, boolean paramBoolean)
    {
      if (WebView.this.mWebViewCallbackClient != null) {
        return WebView.this.mWebViewCallbackClient.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean, this);
      }
      if (Build.VERSION.SDK_INT >= 9) {
        return super.overScrollBy(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramInt7, paramInt8, paramBoolean);
      }
      return false;
    }
    
    public void setOverScrollMode(int paramInt)
    {
      try
      {
        super.setOverScrollMode(paramInt);
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebView
 * JD-Core Version:    0.7.0.1
 */