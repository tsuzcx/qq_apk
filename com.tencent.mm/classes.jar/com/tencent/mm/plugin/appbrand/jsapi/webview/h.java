package com.tencent.mm.plugin.appbrand.jsapi.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.k.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.a.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.plugin.appbrand.utils.t;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.pluginsdk.ui.tools.ab.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.r;
import com.tencent.xweb.x.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public class h
  implements View.OnCreateContextMenuListener, g.a
{
  private ScanCodeSheetItemLogic oxq;
  private String pFV;
  private b pGA;
  private a pGB;
  private com.tencent.mm.plugin.webview.stub.e pGC;
  private com.tencent.mm.plugin.webview.f.g pGD;
  private com.tencent.mm.ui.tools.m pGE;
  private String pGF;
  private String pGG;
  int pGH;
  int pGI;
  com.tencent.mm.plugin.webview.modeltools.g pGJ;
  WebView.b pGK;
  WebView.b pGL;
  private final com.tencent.mm.plugin.webview.modeltools.c pGM;
  final g.c pGN;
  private com.tencent.mm.plugin.webview.d.h pGO;
  private com.tencent.mm.plugin.webview.ui.tools.widget.m pGP;
  private com.tencent.mm.plugin.webview.modeltools.g.c pGQ;
  private MMWebViewWithJsApi pGz;
  
  public h(g.c paramc)
  {
    AppMethodBeat.i(21102);
    this.pGM = new com.tencent.mm.plugin.webview.modeltools.c();
    this.pGP = new com.tencent.mm.plugin.webview.ui.tools.widget.m()
    {
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21071);
        Log.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: ".concat(String.valueOf(paramAnonymousString2)));
        if ((h.this.pGJ == null) || (paramAnonymousString1 == null) || (!paramAnonymousString1.equals(h.this.pGJ.PXC)))
        {
          AppMethodBeat.o(21071);
          return;
        }
        if (!com.tencent.mm.plugin.scanner.k.e(paramAnonymousInt1, paramAnonymousString2, ((com.tencent.mm.plugin.brandservice.a.c)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb(h.e(h.this)), h.c(h.this).Qv()))
        {
          h.b(h.this, null);
          paramAnonymousString1 = e.pGh;
          e.a(h.c(h.this).getPageView(), false, paramAnonymousInt1, paramAnonymousString2, false, h.e(h.this));
          AppMethodBeat.o(21071);
          return;
        }
        if (h.this.pGJ != null) {
          h.this.pGJ.gWy();
        }
        h.this.pGH = paramAnonymousInt1;
        h.this.pGI = paramAnonymousInt2;
        if ((paramAnonymousString2 == null) || (h.a(h.this) == null))
        {
          AppMethodBeat.o(21071);
          return;
        }
        h.c(h.this, paramAnonymousString2);
        h.b(h.this, paramAnonymousString2);
        if ((h.a(h.this) != null) && (h.a(h.this).XSU.isShowing())) {
          h.b(h.this);
        }
        AppMethodBeat.o(21071);
      }
      
      public final boolean h(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(21069);
        boolean bool = super.h(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(21069);
        return bool;
      }
      
      public final Bundle l(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(21070);
        Bundle localBundle = new Bundle();
        localBundle.putString("key_webview_container_env", "miniProgram");
        Object localObject2;
        boolean bool1;
        switch (paramAnonymousInt)
        {
        default: 
        case 139: 
        case 101: 
        case 302: 
        case 140: 
        case 145: 
        case 18: 
        case 87: 
          for (;;)
          {
            AppMethodBeat.o(21070);
            return localBundle;
            paramAnonymousBundle = paramAnonymousBundle.getString("info");
            try
            {
              paramAnonymousBundle = new JSONObject(paramAnonymousBundle);
              h.c(h.this).al(paramAnonymousBundle);
            }
            catch (Exception paramAnonymousBundle) {}
            continue;
            paramAnonymousBundle.setClassLoader(h.class.getClassLoader());
            localObject2 = AndroidContextUtil.castActivityOrNull(h.f(h.this));
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = h.f(h.this);
            }
            localObject2 = paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name");
            Object localObject3 = paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry");
            paramAnonymousBundle = new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras"));
            Object localObject4;
            if ((((String)localObject3).endsWith(".BaseScanUI")) && ((localObject1 instanceof Activity)))
            {
              localObject4 = new f.c()
              {
                public final boolean c(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
                {
                  return true;
                }
              };
              f.aI((Context)localObject1).b((f.c)localObject4);
              com.tencent.mm.by.c.b((Context)localObject1, (String)localObject2, (String)localObject3, paramAnonymousBundle, com.tencent.luggage.sdk.h.a.aI(localObject4));
            }
            else
            {
              com.tencent.mm.by.c.b((Context)localObject1, (String)localObject2, (String)localObject3, paramAnonymousBundle);
              continue;
              paramAnonymousBundle = h.f(h.this);
              if (!(paramAnonymousBundle instanceof Activity))
              {
                Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "AC_GET_OPEN_WEAPP_ACTIVITY_IPC_DELEGATE invalid context(%s) hash(%d) url(%s)", new Object[] { paramAnonymousBundle, Integer.valueOf(h.c(h.this).hashCode()), h.g(h.this).getUrl() });
              }
              else
              {
                localBundle.putParcelable("delegate", ActivityStarterIpcDelegate.aH(paramAnonymousBundle));
                continue;
                localBundle.putInt("key_webview_preverify_info_scene", 1);
                localBundle.putString("key_webview_preverify_info_source_appid", h.c(h.this).getAppId());
                continue;
                localBundle.putStringArray("key_webview_apbrand_jsapi_report_args", h.c(h.this).getJsApiReportArgs());
                continue;
                paramAnonymousBundle = h.f(h.this);
                if (!(paramAnonymousBundle instanceof Activity))
                {
                  Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "AC_GET_PUBLISHER_ID invalid context(%s) hash(%d) url(%s)", new Object[] { paramAnonymousBundle, Integer.valueOf(h.c(h.this).hashCode()), h.g(h.this).getUrl() });
                }
                else
                {
                  localBundle.putString("KPublisherId", ((Activity)paramAnonymousBundle).getIntent().getStringExtra("KPublisherId"));
                  localBundle.putInt("getA8KeyScene", gPI());
                  localBundle.putString("url", h.e(h.this));
                  paramAnonymousBundle = e.pGh;
                  e.a(localBundle, h.c(h.this).getPageView());
                  continue;
                  bool1 = h.j(h.this).hbQ();
                  paramAnonymousBundle = h.j(h.this).cCL();
                  localObject1 = h.j(h.this).hbR();
                  if (bool1)
                  {
                    localBundle.putString("result", "not_return");
                  }
                  else
                  {
                    localBundle.putString("full_url", Util.nullAsNil(paramAnonymousBundle));
                    if ((localObject1 != null) && (((Map)localObject1).size() != 0))
                    {
                      localBundle.putInt("set_cookie", 1);
                      com.tencent.xweb.d.my(MMApplicationContext.getContext());
                      localObject2 = com.tencent.xweb.c.ivX();
                      localObject3 = ((Map)localObject1).keySet().iterator();
                      while (((Iterator)localObject3).hasNext())
                      {
                        localObject4 = (String)((Iterator)localObject3).next();
                        ((com.tencent.xweb.c)localObject2).setCookie(Util.nullAsNil(paramAnonymousBundle), (String)localObject4 + "=" + (String)((Map)localObject1).get(localObject4));
                      }
                      com.tencent.xweb.d.ivZ();
                      com.tencent.xweb.d.sync();
                      Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cookies:%s", new Object[] { ((com.tencent.xweb.c)localObject2).getCookie(Util.nullAsNil(paramAnonymousBundle)) });
                    }
                    else
                    {
                      localBundle.putInt("set_cookie", 0);
                    }
                  }
                }
              }
            }
          }
        }
        Object localObject1 = new com.tencent.mm.f.a.k();
        ((com.tencent.mm.f.a.k)localObject1).fuF.context = h.f(h.this);
        ((com.tencent.mm.f.a.k)localObject1).fuF.actionCode = paramAnonymousInt;
        if (4003 == paramAnonymousInt)
        {
          paramAnonymousBundle = paramAnonymousBundle.getString("apdu");
          ((com.tencent.mm.f.a.k)localObject1).fuF.fuH = paramAnonymousBundle;
        }
        for (;;)
        {
          NFCIPCHelper.b((com.tencent.mm.f.a.k)localObject1);
          if (((com.tencent.mm.f.a.k)localObject1).fuG.fuK == null) {
            break;
          }
          localBundle.putAll(((com.tencent.mm.f.a.k)localObject1).fuG.fuK);
          break;
          if (4004 == paramAnonymousInt)
          {
            localObject2 = paramAnonymousBundle.getString("apdus");
            bool1 = paramAnonymousBundle.getBoolean("breakIfFail", true);
            boolean bool2 = paramAnonymousBundle.getBoolean("breakIfTrue", false);
            ((com.tencent.mm.f.a.k)localObject1).fuF.fuH = ((String)localObject2);
            ((com.tencent.mm.f.a.k)localObject1).fuF.fuI = bool1;
            ((com.tencent.mm.f.a.k)localObject1).fuF.fuJ = bool2;
          }
        }
      }
    };
    this.pGQ = new com.tencent.mm.plugin.webview.modeltools.g.c()
    {
      public final void ajA(String paramAnonymousString)
      {
        AppMethodBeat.i(21081);
        try
        {
          if (h.n(h.this) != null)
          {
            h.n(h.this).a(paramAnonymousString, new int[] { 3 }, 0, 0);
            AppMethodBeat.o(21081);
            return;
          }
          Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
          AppMethodBeat.o(21081);
          return;
        }
        catch (RemoteException paramAnonymousString)
        {
          Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
          AppMethodBeat.o(21081);
        }
      }
    };
    this.pGN = paramc;
    this.pGz = ((MMWebViewWithJsApi)paramc.getWebView());
    this.pGA = new b(this.pGz);
    this.pGz.gco = this.pGA.bXC();
    this.pGB = new a(this.pGz);
    this.pGz.setWebViewClient(this.pGA);
    this.pGz.setWebChromeClient(this.pGB);
    this.pGz.setCleanOnDetached(false);
    this.oxq = new ScanCodeSheetItemLogic(getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bPS()
      {
        AppMethodBeat.i(21067);
        if ((h.a(h.this) != null) && (h.a(h.this).XSU.isShowing())) {
          h.b(h.this);
        }
        AppMethodBeat.o(21067);
      }
    });
    this.pGE = new com.tencent.mm.ui.tools.m(getContext());
    this.pGE.a(this.pGz, this, null);
    AppMethodBeat.o(21102);
  }
  
  private boolean a(ContextMenu paramContextMenu, final String paramString)
  {
    AppMethodBeat.i(21108);
    try
    {
      bool1 = this.pGC.isSDCardAvailable();
      if (!bool1)
      {
        AppMethodBeat.o(21108);
        return true;
      }
    }
    catch (Exception localException1)
    {
      boolean bool1;
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + localException1.getMessage());
        bool1 = false;
      }
      if (this.pGD == null)
      {
        AppMethodBeat.o(21108);
        return true;
      }
      paramContextMenu.setHeaderTitle(au.i.wv_image);
      try
      {
        bool1 = this.pGC.gWY();
        boolean bool2 = this.pGD.gWJ().hoX();
        boolean bool3 = this.pGD.gWJ().hoY();
        Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((bool1) && (bool2)) {
          paramContextMenu.add(0, 0, 0, getContext().getString(au.i.readerapp_alert_retransmit)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(21076);
              try
              {
                boolean bool = h.n(h.this).isSDCardAvailable();
                ab.a(h.f(h.this), h.o(h.this), com.tencent.xweb.c.ivX().getCookie(h.o(h.this)), bool, new ab.a()
                {
                  public final void ajz(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(21075);
                    if (Util.isNullOrNil(paramAnonymous2String))
                    {
                      Log.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
                      AppMethodBeat.o(21075);
                      return;
                    }
                    h.d(h.this, paramAnonymous2String);
                    AppMethodBeat.o(21075);
                  }
                });
                AppMethodBeat.o(21076);
                return true;
              }
              catch (Exception paramAnonymousMenuItem)
              {
                for (;;)
                {
                  Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                }
              }
            }
          });
        }
        paramContextMenu.add(0, 0, 0, getContext().getString(au.i.save_to_local)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(21077);
            try
            {
              bool = h.n(h.this).isSDCardAvailable();
            }
            catch (Exception paramAnonymousMenuItem)
            {
              try
              {
                for (;;)
                {
                  Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick saveImage2SD with url[%s]", new Object[] { h.o(h.this) });
                  ab.b(h.f(h.this), h.o(h.this), com.tencent.xweb.c.ivX().getCookie(h.o(h.this)), bool);
                  AppMethodBeat.o(21077);
                  return true;
                  paramAnonymousMenuItem = paramAnonymousMenuItem;
                  Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                  boolean bool = false;
                }
              }
              catch (Exception paramAnonymousMenuItem)
              {
                for (;;)
                {
                  Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                }
              }
            }
          }
        });
        if ((bool1) && (bool3)) {
          paramContextMenu.add(0, 0, 0, getContext().getString(au.i.plugin_favorite_opt)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(21079);
              try
              {
                boolean bool = h.n(h.this).isSDCardAvailable();
                paramAnonymousMenuItem = h.o(h.this).replaceAll("tp=webp", "");
                ab.a(h.f(h.this), paramAnonymousMenuItem, com.tencent.xweb.c.ivX().getCookie(paramAnonymousMenuItem), bool, new ab.a()
                {
                  public final void ajz(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(21078);
                    h.e(h.this, paramAnonymous2String);
                    AppMethodBeat.o(21078);
                  }
                });
                AppMethodBeat.o(21079);
                return true;
              }
              catch (Exception paramAnonymousMenuItem)
              {
                for (;;)
                {
                  Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                }
              }
            }
          });
        }
        this.pGE.XSU.setFooterView(null);
        if (this.pGF != null)
        {
          paramContextMenu = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(21080);
              Object localObject = new b();
              ((b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
              if ((h.a(h.this) != null) && (h.a(h.this).XSU.isShowing())) {
                h.a(h.this).dismiss();
              }
              localObject = h.this;
              String str1 = this.pGW;
              String str2 = h.e(h.this);
              String str3 = paramString;
              int i = h.this.pGH;
              int j = h.this.pGI;
              if (str1 != null)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.setClass(((h)localObject).getContext(), WebviewScanImageActivity.class);
                paramAnonymousView.putExtra("key_string_for_scan", str1);
                paramAnonymousView.putExtra("key_string_for_url", str2);
                paramAnonymousView.putExtra("key_string_for_image_url", str3);
                paramAnonymousView.putExtra("key_codetype_for_scan", i);
                paramAnonymousView.putExtra("key_codeversion_for_scan", j);
                if ((((h)localObject).pGN != null) && (!Util.isNullOrNil(((h)localObject).pGN.getAppId()))) {
                  paramAnonymousView.putExtra("key_string_for_wxapp_id", ((h)localObject).pGN.getAppId());
                }
                paramAnonymousView.putExtra("geta8key_scene", 44);
                if ((((h)localObject).pGN != null) && (((h)localObject).pGN.getPageView() != null)) {
                  paramAnonymousView.putExtra("wxappPathWithQuery", ((h)localObject).pGN.getPageView().qoI);
                }
                localObject = ((h)localObject).getContext();
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bm(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aFh(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject).startActivity((Intent)paramAnonymousView.sf(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              paramAnonymousView = e.pGh;
              e.a(h.c(h.this).getPageView(), true, h.this.pGH, h.k(h.this), true, h.e(h.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21080);
            }
          };
          this.pGE.XSU.setFooterView(this.oxq.a(paramContextMenu, this.pGH, this.pGF, 10));
          paramContextMenu = e.pGh;
          e.a(this.pGN.getPageView(), true, this.pGH, this.pGF, false, this.pFV);
          AppMethodBeat.o(21108);
          return true;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", new Object[] { localException2.getMessage() });
          bool1 = false;
        }
        AppMethodBeat.o(21108);
      }
    }
    return false;
  }
  
  public final void ajy(String paramString)
  {
    AppMethodBeat.i(272219);
    if (!TextUtils.isEmpty(paramString))
    {
      this.pFV = paramString;
      MMWebView localMMWebView = this.pGN.getWebView();
      if ((paramString.indexOf("#") >= 0) && (!TextUtils.isEmpty(localMMWebView.getUrl())) && (!paramString.endsWith("#wechat_redirect")))
      {
        localMMWebView.evaluateJavascript(String.format("window.location=\"%s\"", new Object[] { t.anl(paramString) }), null);
        AppMethodBeat.o(272219);
        return;
      }
      localMMWebView.loadUrl(paramString);
    }
    AppMethodBeat.o(272219);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(21104);
    this.pGA.cleanup();
    this.pGB.cleanup();
    AppMethodBeat.o(21104);
  }
  
  public final int getBinderID()
  {
    AppMethodBeat.i(174923);
    int i = this.pGA.lxa.hashCode();
    AppMethodBeat.o(174923);
    return i;
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(21103);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.pGz.getContext());
    if (localObject == null)
    {
      localObject = this.pGz.getContext();
      AppMethodBeat.o(21103);
      return localObject;
    }
    AppMethodBeat.o(21103);
    return localObject;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(21107);
    if (this.pGA.pIl != null) {
      this.pGA.pIl.CT(false);
    }
    AppMethodBeat.o(21107);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(21109);
    boolean bool;
    if ((paramView instanceof android.webkit.WebView))
    {
      paramView = this.pGz.getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(21109);
        return;
      }
      if ((paramView.mType == 5) || (paramView.mType == 8))
      {
        bool = a(paramContextMenu, paramView.mExtra);
        this.pGG = paramView.mExtra;
        if ((!bool) && (this.pGD.gWJ().hoT()))
        {
          this.pGK = paramView;
          this.pGJ = new com.tencent.mm.plugin.webview.modeltools.g();
          this.pGJ.a(this.pGz, this.pGQ);
        }
      }
      AppMethodBeat.o(21109);
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      paramView = ((MMWebView)paramView).getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(21109);
        return;
      }
      if ((paramView.mType == 5) || (paramView.mType == 8))
      {
        bool = a(paramContextMenu, paramView.mExtra);
        this.pGG = paramView.mExtra;
        if ((!bool) && (this.pGD.gWJ().hoT()))
        {
          this.pGL = paramView;
          this.pGJ = new com.tencent.mm.plugin.webview.modeltools.g();
          this.pGJ.a(this.pGz, this.pGQ);
        }
      }
    }
    AppMethodBeat.o(21109);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(21106);
    if (this.pGA.pIl != null) {
      this.pGA.pIl.CT(true);
    }
    AppMethodBeat.o(21106);
  }
  
  public final void v(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21105);
    Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "notifyKeyboardStateChanged, shown[%b], height[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.webview.d.h localh = this.pGO;
    if (localh != null) {
      if (!paramBoolean) {
        break label58;
      }
    }
    for (;;)
    {
      localh.lx(paramInt, 0);
      AppMethodBeat.o(21105);
      return;
      label58:
      paramInt = 0;
    }
  }
  
  final class a
    extends i
  {
    private a pGY;
    private k.c pGZ;
    
    a(MMWebViewWithJsApi paramMMWebViewWithJsApi)
    {
      super();
    }
    
    private void a(ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
    {
      AppMethodBeat.i(21087);
      Object localObject = h.f(h.this);
      if (!(localObject instanceof Activity))
      {
        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startFileChooser, invalid context(%s) hash(%d) url(%s)", new Object[] { localObject, Integer.valueOf(h.c(h.this).hashCode()), h.g(h.this).getUrl() });
        AppMethodBeat.o(21087);
        return;
      }
      localObject = (Activity)localObject;
      f.aI((Context)localObject).b(new f.c()
      {
        public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(268226);
          boolean bool = h.h(h.this).c(this.val$activity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(268226);
          return bool;
        }
      });
      h.h(h.this).a((Activity)localObject, h.i(h.this), paramValueCallback, paramValueCallback1, paramString1, paramString2);
      AppMethodBeat.o(21087);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(273433);
      if (h.c(h.this).bXs())
      {
        if (this.pGY == null) {
          this.pGY = new a((byte)0);
        }
        paramView = this.pGY;
        paramCustomViewCallback = AndroidContextUtil.castActivityOrNull(h.c(h.this).getPageView().getContext());
        if ((paramCustomViewCallback instanceof com.tencent.mm.plugin.appbrand.platform.window.a.a))
        {
          paramView.pHb = ((com.tencent.mm.plugin.appbrand.platform.window.a.a)paramCustomViewCallback);
          paramView.pHb.a(paramView);
        }
      }
      paramView = h.c(h.this).getAppId();
      paramCustomViewCallback = new k.c()
      {
        private void leaveFullscreen()
        {
          AppMethodBeat.i(278799);
          h.c(h.this).getWebView().leaveFullscreen();
          AppMethodBeat.o(278799);
        }
        
        public final void a(k.d paramAnonymousd)
        {
          AppMethodBeat.i(278797);
          if (paramAnonymousd == k.d.nti) {
            leaveFullscreen();
          }
          AppMethodBeat.o(278797);
        }
        
        public final void bBQ()
        {
          AppMethodBeat.i(278798);
          leaveFullscreen();
          AppMethodBeat.o(278798);
        }
      };
      this.pGZ = paramCustomViewCallback;
      com.tencent.mm.plugin.appbrand.k.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(273433);
      return false;
    }
    
    public final boolean a(com.tencent.xweb.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, x.a parama)
    {
      AppMethodBeat.i(21086);
      if (parama.getMode() == 0)
      {
        if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
        {
          Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
          AppMethodBeat.o(21086);
          return true;
        }
        String str2 = parama.getAcceptTypes()[0];
        String str1 = "*";
        paramWebView = str1;
        if (parama.isCaptureEnabled())
        {
          if (!"image/*".equalsIgnoreCase(str2)) {
            break label95;
          }
          paramWebView = "camera";
        }
        for (;;)
        {
          a(null, paramValueCallback, str2, paramWebView);
          AppMethodBeat.o(21086);
          return true;
          label95:
          paramWebView = str1;
          if ("video/*".equalsIgnoreCase(str2)) {
            paramWebView = "camcorder";
          }
        }
      }
      AppMethodBeat.o(21086);
      return false;
    }
    
    public final boolean bXA()
    {
      AppMethodBeat.i(273434);
      if (this.pGY != null) {
        this.pGY.uninstall();
      }
      com.tencent.mm.plugin.appbrand.k.b(h.c(h.this).getAppId(), this.pGZ);
      h.c(h.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(278132);
          if (h.c(h.this).getPageView().getFullscreenImpl() != null)
          {
            h.c(h.this).getPageView().getFullscreenImpl().bEz();
            com.tencent.mm.plugin.appbrand.page.a.d locald = (com.tencent.mm.plugin.appbrand.page.a.d)h.c(h.this).getPageView().R(com.tencent.mm.plugin.appbrand.page.a.d.class);
            if (locald != null) {
              locald.a(null);
            }
          }
          AppMethodBeat.o(278132);
        }
      });
      AppMethodBeat.o(273434);
      return false;
    }
    
    public final void d(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(21083);
      super.d(paramWebView, paramString);
      h.c(h.this).ajv(paramString);
      AppMethodBeat.o(21083);
    }
    
    public final void onClose()
    {
      AppMethodBeat.i(21084);
      h.c(h.this).bXu();
      AppMethodBeat.o(21084);
    }
    
    public final void openFileChooser(ValueCallback<Uri> paramValueCallback, String paramString1, String paramString2)
    {
      AppMethodBeat.i(21085);
      a(paramValueCallback, null, paramString1, paramString2);
      AppMethodBeat.o(21085);
    }
    
    final class a
      implements a.a
    {
      com.tencent.mm.plugin.appbrand.platform.window.a.a pHb;
      
      private a() {}
      
      public final boolean Bk(int paramInt)
      {
        AppMethodBeat.i(267773);
        if (h.c(h.this).getPageView().getFullscreenImpl() == null)
        {
          AppMethodBeat.o(267773);
          return false;
        }
        uninstall();
        h.c(h.this).getPageView().getFullscreenImpl().yS(d.a.CC(paramInt));
        AppMethodBeat.o(267773);
        return true;
      }
      
      final void uninstall()
      {
        AppMethodBeat.i(267775);
        if (this.pHb != null) {
          this.pHb.b(this);
        }
        AppMethodBeat.o(267775);
      }
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.webview.ui.tools.widget.k
  {
    private com.tencent.mm.plugin.webview.ui.tools.c pHc;
    
    b(MMWebView paramMMWebView)
    {
      super();
      AppMethodBeat.i(180295);
      if (h.c(h.this).Qv()) {
        this.QwP = new h.c(h.this);
      }
      AppMethodBeat.o(180295);
    }
    
    public final boolean Su(String paramString)
    {
      AppMethodBeat.i(21092);
      if (paramString.startsWith("file:///android_asset"))
      {
        Log.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found %s", new Object[] { paramString });
        AppMethodBeat.o(21092);
        return true;
      }
      Object localObject;
      if (paramString.startsWith("tel:"))
      {
        localObject = new Intent("android.intent.action.DIAL");
        ((Intent)localObject).setData(Uri.parse(paramString));
        paramString = this.lxa.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(21092);
        return true;
      }
      if ((paramString.startsWith("sms:")) || (paramString.startsWith("smsto:")))
      {
        localObject = new Intent("android.intent.action.SENDTO");
        ((Intent)localObject).setData(Uri.parse(paramString));
        paramString = this.lxa.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(21092);
        return true;
      }
      if ((URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString)) || (Util.nullAsNil(paramString).startsWith("weixin"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found unacceptable %s", new Object[] { paramString });
        AppMethodBeat.o(21092);
        return true;
      }
      AppMethodBeat.o(21092);
      return false;
    }
    
    public final void a(com.tencent.mm.plugin.webview.d.h paramh)
    {
      AppMethodBeat.i(267166);
      super.a(paramh);
      if ((paramh != null) && (h.c(h.this) != null)) {
        paramh.PND = h.c(h.this).getAppId();
      }
      h.a(h.this, paramh);
      AppMethodBeat.o(267166);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, com.tencent.mm.plugin.webview.f.g paramg)
    {
      AppMethodBeat.i(267162);
      h.a(h.this, parame);
      h.a(h.this, paramg);
      try
      {
        paramg = new Bundle();
        paramg.putString("key_webview_container_env", "miniProgram");
        Bundle localBundle = new Bundle();
        localBundle.putBundle("jsapiargs", paramg);
        parame.a(20, localBundle, this.lxa.hashCode());
        AppMethodBeat.o(267162);
        return;
      }
      catch (RemoteException parame)
      {
        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + parame.getMessage());
        AppMethodBeat.o(267162);
      }
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(21100);
      h.c(h.this).A(paramString2, paramInt, paramString1);
      AppMethodBeat.o(21100);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, r paramr, SslError paramSslError)
    {
      AppMethodBeat.i(21093);
      paramWebView = h.e(h.this);
      if (paramWebView == null)
      {
        Log.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "urlStr == null, return");
        AppMethodBeat.o(21093);
        return;
      }
      if (this.pHc == null) {
        this.pHc = new com.tencent.mm.plugin.webview.ui.tools.c(this.crM, this.lxa);
      }
      this.pHc.a(paramWebView, paramr, paramSslError);
      AppMethodBeat.o(21093);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(21094);
      h.a(h.this, paramString);
      h.c(h.this).dv(paramString);
      AppMethodBeat.o(21094);
    }
    
    public final boolean a(com.tencent.xweb.WebView paramWebView, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(267163);
      Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "doUpdateVisitedHistory, view.url[%s], updatedUrl[%s], isReload[%b]", new Object[] { paramWebView.getUrl(), paramString, Boolean.valueOf(paramBoolean) });
      String str1 = paramWebView.getUrl();
      LinkedList localLinkedList = new LinkedList();
      String str2 = paramWebView.getUrl();
      if (URLUtil.isAboutUrl(str2))
      {
        localLinkedList.add(new IDKey(1097, 1, 1));
        localLinkedList.add(new IDKey(1097, 5, 1));
      }
      for (;;)
      {
        if (localLinkedList.size() > 0)
        {
          h.c(h.this).getReporter().I(new ArrayList(localLinkedList));
          str1 = paramString;
        }
        if (!URLUtil.isAboutUrl(paramString)) {
          break;
        }
        paramWebView = new LinkedList();
        paramWebView.add(new IDKey(1097, 2, 1));
        paramWebView.add(new IDKey(1097, 6, 1));
        h.c(h.this).getReporter().I(new ArrayList(paramWebView));
        AppMethodBeat.o(267163);
        return true;
        if (Util.nullAsNil(str2).startsWith("file:///android_asset/"))
        {
          localLinkedList.add(new IDKey(1097, 3, 1));
          localLinkedList.add(new IDKey(1097, 5, 1));
        }
        else if (!URLUtil.isNetworkUrl(str2))
        {
          localLinkedList.add(new IDKey(1097, 5, 1));
        }
      }
      if (Util.nullAsNil(paramString).startsWith("file:///android_asset/"))
      {
        paramWebView = new LinkedList();
        paramWebView.add(new IDKey(1097, 4, 1));
        paramWebView.add(new IDKey(1097, 6, 1));
        h.c(h.this).getReporter().I(new ArrayList(paramWebView));
        AppMethodBeat.o(267163);
        return true;
      }
      if (!URLUtil.isNetworkUrl(paramString))
      {
        h.c(h.this).getReporter().Bi(6);
        str1 = paramWebView.getUrl();
      }
      if (this.QwK) {
        ax(str1, false);
      }
      for (;;)
      {
        AppMethodBeat.o(267163);
        return true;
        if ((this.pIm != null) && (!this.pIm.has(str1)))
        {
          Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "doUpdateVisitedHistory start geta8key, url = %s", new Object[] { str1 });
          ax(str1, false);
        }
      }
    }
    
    public final boolean ajB(String paramString)
    {
      AppMethodBeat.i(21088);
      if (Util.isNullOrNil(paramString))
      {
        AppMethodBeat.o(21088);
        return true;
      }
      if (URLUtil.isAboutUrl(paramString))
      {
        AppMethodBeat.o(21088);
        return false;
      }
      if (!URLUtil.isFileUrl(paramString))
      {
        paramString = Uri.parse(paramString);
        if (Util.isNullOrNil(paramString.getHost()))
        {
          AppMethodBeat.o(21088);
          return true;
        }
        if (!paramString.getHost().contains(com.tencent.luggage.k.h.SH()))
        {
          AppMethodBeat.o(21088);
          return true;
        }
        AppMethodBeat.o(21088);
        return false;
      }
      boolean bool = "file:///android_asset/jsapi/wxjs.js".equals(paramString);
      AppMethodBeat.o(21088);
      return bool;
    }
    
    public final String ajC(String paramString)
    {
      AppMethodBeat.i(21098);
      if ((h.e(h.this) != null) && (h.e(h.this).equals(paramString)))
      {
        AppMethodBeat.o(21098);
        return "";
      }
      paramString = h.e(h.this);
      AppMethodBeat.o(21098);
      return paramString;
    }
    
    public final void ax(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(267164);
      LinkedList localLinkedList = new LinkedList();
      if (URLUtil.isAboutUrl(paramString))
      {
        localLinkedList.add(new IDKey(1097, 12, 1));
        localLinkedList.add(new IDKey(1097, 14, 1));
        if (localLinkedList.size() <= 0) {
          break label217;
        }
        h.c(h.this).getReporter().I(new ArrayList(localLinkedList));
        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startGetA8Key with invalid url[%s], force[%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      }
      for (;;)
      {
        super.ax(paramString, paramBoolean);
        AppMethodBeat.o(267164);
        return;
        if (Util.nullAsNil(paramString).startsWith("file:///android_asset/"))
        {
          localLinkedList.add(new IDKey(1097, 13, 1));
          localLinkedList.add(new IDKey(1097, 14, 1));
          break;
        }
        if (URLUtil.isNetworkUrl(paramString)) {
          break;
        }
        localLinkedList.add(new IDKey(1097, 14, 1));
        break;
        label217:
        h.c(h.this).getReporter().Bi(11);
      }
    }
    
    public final com.tencent.mm.plugin.webview.ui.tools.widget.m bXB()
    {
      AppMethodBeat.i(21089);
      com.tencent.mm.plugin.webview.ui.tools.widget.m localm = h.d(h.this);
      AppMethodBeat.o(21089);
      return localm;
    }
    
    public final int bXC()
    {
      AppMethodBeat.i(21096);
      if (h.c(h.this).bXw())
      {
        AppMethodBeat.o(21096);
        return 55;
      }
      AppMethodBeat.o(21096);
      return 49;
    }
    
    public final int bXD()
    {
      AppMethodBeat.i(21097);
      if (h.c(h.this).bXw())
      {
        AppMethodBeat.o(21097);
        return 55;
      }
      AppMethodBeat.o(21097);
      return 49;
    }
    
    public final void cleanup()
    {
      AppMethodBeat.i(21091);
      super.cleanup();
      if (this.pHc != null) {
        this.pHc.detach();
      }
      AppMethodBeat.o(21091);
    }
    
    public final void e(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(267165);
      super.e(paramWebView, paramString);
      h.c(h.this).ajw(paramString);
      AppMethodBeat.o(267165);
    }
    
    public final void f(Bundle paramBundle, String paramString)
    {
      AppMethodBeat.i(21099);
      super.f(paramBundle, paramString);
      paramBundle.putString("geta8key_data_appid", h.c(h.this).getAppId());
      AppMethodBeat.o(21099);
    }
    
    public final void f(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(21095);
      h.a(h.this, paramString);
      h.c(h.this).dw(paramString);
      AppMethodBeat.o(21095);
    }
  }
  
  final class c
    extends ar
  {
    public c() {}
    
    public final WebResourceResponse a(String paramString, WebResourceRequest paramWebResourceRequest, boolean paramBoolean, com.tencent.mm.plugin.webview.stub.e parame)
    {
      AppMethodBeat.i(180296);
      h.c(h.this).a(h.e(h.this), paramWebResourceRequest);
      paramString = super.a(paramString, paramWebResourceRequest, paramBoolean, parame);
      AppMethodBeat.o(180296);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.h
 * JD-Core Version:    0.7.0.1
 */