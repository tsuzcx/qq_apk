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
import com.tencent.luggage.l.e.c;
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.m;
import com.tencent.mm.autogen.a.m.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.platform.window.a.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.plugin.appbrand.utils.y;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.n;
import com.tencent.mm.plugin.webview.ui.tools.widget.p;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pluginsdk.ui.tools.aa.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ao;
import com.tencent.xweb.t;
import com.tencent.xweb.z.a;
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
  private ScanCodeSheetItemLogic rAP;
  private b sLA;
  private a sLB;
  private com.tencent.mm.plugin.webview.stub.e sLC;
  private g sLD;
  private com.tencent.mm.ui.tools.l sLE;
  private String sLF;
  private String sLG;
  int sLH;
  int sLI;
  com.tencent.mm.plugin.webview.k.h sLJ;
  WebView.b sLK;
  WebView.b sLL;
  private final com.tencent.mm.plugin.webview.modeltools.d sLM;
  final g.c sLN;
  private j sLO;
  private p sLP;
  private com.tencent.mm.plugin.webview.k.h.c sLQ;
  private String sLe;
  private MMWebViewWithJsApi sLz;
  
  public h(g.c paramc)
  {
    AppMethodBeat.i(21102);
    this.sLM = new com.tencent.mm.plugin.webview.modeltools.d();
    this.sLP = new p()
    {
      public final void f(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21071);
        Log.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: ".concat(String.valueOf(paramAnonymousString2)));
        if ((h.this.sLJ == null) || (paramAnonymousString1 == null) || (!paramAnonymousString1.equals(h.this.sLJ.XsV)))
        {
          AppMethodBeat.o(21071);
          return;
        }
        if (!com.tencent.mm.plugin.scanner.k.e(paramAnonymousInt1, paramAnonymousString2, ((com.tencent.mm.plugin.brandservice.api.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).aiy(h.e(h.this)), h.c(h.this).aqJ()))
        {
          h.b(h.this, null);
          paramAnonymousString1 = e.sLq;
          e.a(h.c(h.this).getPageView(), false, paramAnonymousInt1, paramAnonymousString2, false, h.e(h.this));
          AppMethodBeat.o(21071);
          return;
        }
        if (h.this.sLJ != null) {
          h.this.sLJ.iCR();
        }
        h.this.sLH = paramAnonymousInt1;
        h.this.sLI = paramAnonymousInt2;
        if ((paramAnonymousString2 == null) || (h.a(h.this) == null))
        {
          AppMethodBeat.o(21071);
          return;
        }
        h.c(h.this, paramAnonymousString2);
        h.b(h.this, paramAnonymousString2);
        if ((h.a(h.this) != null) && (h.a(h.this).afJj.isShowing())) {
          h.b(h.this);
        }
        AppMethodBeat.o(21071);
      }
      
      public final boolean i(int paramAnonymousInt, Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(21069);
        boolean bool = super.i(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(21069);
        return bool;
      }
      
      public final Bundle m(int paramAnonymousInt, Bundle paramAnonymousBundle)
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
              h.c(h.this).av(paramAnonymousBundle);
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
            String str = paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry");
            paramAnonymousBundle = new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras"));
            if ((str.endsWith(".BaseScanUI")) && ((localObject1 instanceof Activity)))
            {
              e.c local1 = new e.c()
              {
                public final boolean onResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
                {
                  return true;
                }
              };
              com.tencent.luggage.l.e.bt((Context)localObject1).b(local1);
              com.tencent.mm.br.c.b((Context)localObject1, (String)localObject2, str, paramAnonymousBundle, com.tencent.luggage.sdk.h.a.ce(local1));
            }
            else
            {
              com.tencent.mm.br.c.b((Context)localObject1, (String)localObject2, str, paramAnonymousBundle);
              continue;
              paramAnonymousBundle = h.f(h.this);
              if (!(paramAnonymousBundle instanceof Activity))
              {
                Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "AC_GET_OPEN_WEAPP_ACTIVITY_IPC_DELEGATE invalid context(%s) hash(%d) url(%s)", new Object[] { paramAnonymousBundle, Integer.valueOf(h.c(h.this).hashCode()), h.g(h.this).getUrl() });
              }
              else
              {
                localBundle.putParcelable("delegate", ActivityStarterIpcDelegate.bq(paramAnonymousBundle));
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
                  localBundle.putInt("getA8KeyScene", ipc());
                  localBundle.putString("url", h.e(h.this));
                  paramAnonymousBundle = e.sLq;
                  e.a(localBundle, h.c(h.this).getPageView());
                  continue;
                  bool1 = h.j(h.this).iCk();
                  paramAnonymousBundle = h.j(h.this).dfU();
                  localObject1 = h.j(h.this).iCl();
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
                      ao.oQ(MMApplicationContext.getContext());
                      localObject2 = ((Map)localObject1).keySet().iterator();
                      while (((Iterator)localObject2).hasNext())
                      {
                        str = (String)((Iterator)localObject2).next();
                        ao.setCookie(Util.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                      }
                      ao.kgo();
                      Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cookies:%s", new Object[] { ao.getCookie(Util.nullAsNil(paramAnonymousBundle)) });
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
        Object localObject1 = new m();
        ((m)localObject1).hyZ.context = h.f(h.this);
        ((m)localObject1).hyZ.actionCode = paramAnonymousInt;
        if (4003 == paramAnonymousInt)
        {
          paramAnonymousBundle = paramAnonymousBundle.getString("apdu");
          ((m)localObject1).hyZ.hzb = paramAnonymousBundle;
        }
        for (;;)
        {
          NFCIPCHelper.b((m)localObject1);
          if (((m)localObject1).hza.hze == null) {
            break;
          }
          localBundle.putAll(((m)localObject1).hza.hze);
          break;
          if (4004 == paramAnonymousInt)
          {
            localObject2 = paramAnonymousBundle.getString("apdus");
            bool1 = paramAnonymousBundle.getBoolean("breakIfFail", true);
            boolean bool2 = paramAnonymousBundle.getBoolean("breakIfTrue", false);
            ((m)localObject1).hyZ.hzb = ((String)localObject2);
            ((m)localObject1).hyZ.hzc = bool1;
            ((m)localObject1).hyZ.hzd = bool2;
          }
        }
      }
    };
    this.sLQ = new com.tencent.mm.plugin.webview.k.h.c()
    {
      public final void acB(String paramAnonymousString)
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
    this.sLN = paramc;
    this.sLz = ((MMWebViewWithJsApi)paramc.getWebView());
    this.sLA = new b(this.sLz);
    this.sLz.iiA = this.sLA.cxN();
    this.sLB = new a(this.sLz);
    this.sLz.setWebViewClient(this.sLA);
    this.sLz.setWebChromeClient(this.sLB);
    this.sLz.setCleanOnDetached(false);
    this.rAP = new ScanCodeSheetItemLogic(getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void onFetchedCodeInfo()
      {
        AppMethodBeat.i(21067);
        if ((h.a(h.this) != null) && (h.a(h.this).afJj.isShowing())) {
          h.b(h.this);
        }
        AppMethodBeat.o(21067);
      }
    });
    this.sLE = new com.tencent.mm.ui.tools.l(getContext());
    this.sLE.a(this.sLz, this, null);
    AppMethodBeat.o(21102);
  }
  
  private boolean a(ContextMenu paramContextMenu, final String paramString)
  {
    AppMethodBeat.i(21108);
    try
    {
      bool1 = this.sLC.isSDCardAvailable();
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
      if (this.sLD == null)
      {
        AppMethodBeat.o(21108);
        return true;
      }
      paramContextMenu.setHeaderTitle(ba.i.wv_image);
      try
      {
        bool1 = this.sLC.iwU();
        boolean bool2 = this.sLD.iwp().iPR();
        boolean bool3 = this.sLD.iwp().iPS();
        Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((bool1) && (bool2)) {
          paramContextMenu.add(0, 0, 0, getContext().getString(ba.i.readerapp_alert_retransmit)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(21076);
              try
              {
                boolean bool = h.n(h.this).isSDCardAvailable();
                aa.a(h.f(h.this), h.o(h.this), ao.getCookie(h.o(h.this)), bool, new aa.a()
                {
                  public final void acA(String paramAnonymous2String)
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
        paramContextMenu.add(0, 0, 0, getContext().getString(ba.i.save_to_local)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
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
                  aa.b(h.f(h.this), h.o(h.this), ao.getCookie(h.o(h.this)), bool);
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
          paramContextMenu.add(0, 0, 0, getContext().getString(ba.i.plugin_favorite_opt)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(21079);
              try
              {
                boolean bool = h.n(h.this).isSDCardAvailable();
                paramAnonymousMenuItem = h.o(h.this).replaceAll("tp=webp", "");
                aa.a(h.f(h.this), paramAnonymousMenuItem, ao.getCookie(paramAnonymousMenuItem), bool, new aa.a()
                {
                  public final void acA(String paramAnonymous2String)
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
        this.sLE.afJj.setFooterView(null);
        if (this.sLF != null)
        {
          paramContextMenu = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(21080);
              Object localObject = new b();
              ((b)localObject).cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
              if ((h.a(h.this) != null) && (h.a(h.this).afJj.isShowing())) {
                h.a(h.this).dismiss();
              }
              localObject = h.this;
              String str1 = this.sLW;
              String str2 = h.e(h.this);
              String str3 = paramString;
              int i = h.this.sLH;
              int j = h.this.sLI;
              if (str1 != null)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.setClass(((h)localObject).getContext(), WebviewScanImageActivity.class);
                paramAnonymousView.putExtra("key_string_for_scan", str1);
                paramAnonymousView.putExtra("key_string_for_url", str2);
                paramAnonymousView.putExtra("key_string_for_image_url", str3);
                paramAnonymousView.putExtra("key_codetype_for_scan", i);
                paramAnonymousView.putExtra("key_codeversion_for_scan", j);
                if ((((h)localObject).sLN != null) && (!Util.isNullOrNil(((h)localObject).sLN.getAppId()))) {
                  paramAnonymousView.putExtra("key_string_for_wxapp_id", ((h)localObject).sLN.getAppId());
                }
                paramAnonymousView.putExtra("geta8key_scene", 44);
                if ((((h)localObject).sLN != null) && (((h)localObject).sLN.getPageView() != null)) {
                  paramAnonymousView.putExtra("wxappPathWithQuery", ((h)localObject).sLN.getPageView().cEE());
                }
                localObject = ((h)localObject).getContext();
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().cG(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b(localObject, paramAnonymousView.aYi(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject).startActivity((Intent)paramAnonymousView.sb(0));
                com.tencent.mm.hellhoundlib.a.a.c(localObject, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              paramAnonymousView = e.sLq;
              e.a(h.c(h.this).getPageView(), true, h.this.sLH, h.k(h.this), true, h.e(h.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21080);
            }
          };
          this.sLE.afJj.setFooterView(this.rAP.a(paramContextMenu, this.sLH, this.sLF, 10));
          paramContextMenu = e.sLq;
          e.a(this.sLN.getPageView(), true, this.sLH, this.sLF, false, this.sLe);
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
  
  public final void acz(String paramString)
  {
    AppMethodBeat.i(327635);
    if (!TextUtils.isEmpty(paramString))
    {
      this.sLe = paramString;
      MMWebView localMMWebView = this.sLN.getWebView();
      if ((paramString.indexOf("#") >= 0) && (!TextUtils.isEmpty(localMMWebView.getUrl())) && (!paramString.endsWith("#wechat_redirect")))
      {
        localMMWebView.evaluateJavascript(String.format("window.location=\"%s\"", new Object[] { y.agF(paramString) }), null);
        AppMethodBeat.o(327635);
        return;
      }
      localMMWebView.loadUrl(paramString);
    }
    AppMethodBeat.o(327635);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(21104);
    this.sLA.cleanup();
    this.sLB.cleanup();
    AppMethodBeat.o(21104);
  }
  
  public final int getBinderID()
  {
    AppMethodBeat.i(174923);
    int i = this.sLA.ooz.hashCode();
    AppMethodBeat.o(174923);
    return i;
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(21103);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.sLz.getContext());
    if (localObject == null)
    {
      localObject = this.sLz.getContext();
      AppMethodBeat.o(21103);
      return localObject;
    }
    AppMethodBeat.o(21103);
    return localObject;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(21107);
    if (this.sLA.sNc != null) {
      this.sLA.sNc.IB(false);
    }
    AppMethodBeat.o(21107);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(21109);
    boolean bool;
    if ((paramView instanceof android.webkit.WebView))
    {
      paramView = this.sLz.getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(21109);
        return;
      }
      if ((paramView.mType == 5) || (paramView.mType == 8))
      {
        bool = a(paramContextMenu, paramView.mExtra);
        this.sLG = paramView.mExtra;
        if ((!bool) && (this.sLD.iwp().iPP()))
        {
          this.sLK = paramView;
          this.sLJ = new com.tencent.mm.plugin.webview.k.h();
          this.sLJ.a(this.sLz, this.sLQ);
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
        this.sLG = paramView.mExtra;
        if ((!bool) && (this.sLD.iwp().iPP()))
        {
          this.sLL = paramView;
          this.sLJ = new com.tencent.mm.plugin.webview.k.h();
          this.sLJ.a(this.sLz, this.sLQ);
        }
      }
    }
    AppMethodBeat.o(21109);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(21106);
    if (this.sLA.sNc != null) {
      this.sLA.sNc.IB(true);
    }
    AppMethodBeat.o(21106);
  }
  
  public final void t(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21105);
    Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "notifyKeyboardStateChanged, shown[%b], height[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    j localj = this.sLO;
    if (localj != null) {
      if (!paramBoolean) {
        break label58;
      }
    }
    for (;;)
    {
      localj.nh(paramInt, 0);
      AppMethodBeat.o(21105);
      return;
      label58:
      paramInt = 0;
    }
  }
  
  final class a
    extends com.tencent.mm.plugin.webview.ui.tools.widget.l
  {
    private a sLY;
    private k.c sLZ;
    
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
      com.tencent.luggage.l.e.bt((Context)localObject).b(new e.c()
      {
        public final boolean onResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(327430);
          boolean bool = h.h(h.this).d(this.val$activity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(327430);
          return bool;
        }
      });
      h.h(h.this).a((Activity)localObject, h.i(h.this), paramValueCallback, paramValueCallback1, paramString1, paramString2);
      AppMethodBeat.o(21087);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(327479);
      if (h.c(h.this).cxE())
      {
        if (this.sLY == null) {
          this.sLY = new a((byte)0);
        }
        paramView = this.sLY;
        paramCustomViewCallback = AndroidContextUtil.castActivityOrNull(h.c(h.this).getPageView().getContext());
        if ((paramCustomViewCallback instanceof com.tencent.mm.plugin.appbrand.platform.window.a.a))
        {
          paramView.sMb = ((com.tencent.mm.plugin.appbrand.platform.window.a.a)paramCustomViewCallback);
          paramView.sMb.a(paramView);
        }
      }
      paramView = h.c(h.this).getAppId();
      paramCustomViewCallback = new k.c()
      {
        private void leaveFullscreen()
        {
          AppMethodBeat.i(327432);
          h.c(h.this).getWebView().leaveFullscreen();
          AppMethodBeat.o(327432);
        }
        
        public final void a(k.d paramAnonymousd)
        {
          AppMethodBeat.i(327435);
          if (paramAnonymousd == k.d.qrN) {
            leaveFullscreen();
          }
          AppMethodBeat.o(327435);
        }
        
        public final void cbm()
        {
          AppMethodBeat.i(327440);
          leaveFullscreen();
          AppMethodBeat.o(327440);
        }
      };
      this.sLZ = paramCustomViewCallback;
      com.tencent.mm.plugin.appbrand.k.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(327479);
      return false;
    }
    
    public final boolean a(com.tencent.xweb.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, z.a parama)
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
    
    public final void bfj()
    {
      AppMethodBeat.i(21084);
      h.c(h.this).cxG();
      AppMethodBeat.o(21084);
    }
    
    public final boolean cxL()
    {
      AppMethodBeat.i(327485);
      if (this.sLY != null) {
        this.sLY.uninstall();
      }
      com.tencent.mm.plugin.appbrand.k.b(h.c(h.this).getAppId(), this.sLZ);
      h.c(h.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(327434);
          if (h.c(h.this).getPageView().getFullscreenImpl() != null)
          {
            h.c(h.this).getPageView().getFullscreenImpl().cdL();
            com.tencent.mm.plugin.appbrand.page.a.d locald = (com.tencent.mm.plugin.appbrand.page.a.d)h.c(h.this).getPageView().aa(com.tencent.mm.plugin.appbrand.page.a.d.class);
            if (locald != null) {
              locald.a(null);
            }
          }
          AppMethodBeat.o(327434);
        }
      });
      AppMethodBeat.o(327485);
      return false;
    }
    
    public final void d(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(21083);
      super.d(paramWebView, paramString);
      h.c(h.this).acw(paramString);
      AppMethodBeat.o(21083);
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
      com.tencent.mm.plugin.appbrand.platform.window.a.a sMb;
      
      private a() {}
      
      public final boolean Bx(int paramInt)
      {
        AppMethodBeat.i(327425);
        if (h.c(h.this).getPageView().getFullscreenImpl() == null)
        {
          AppMethodBeat.o(327425);
          return false;
        }
        uninstall();
        h.c(h.this).getPageView().getFullscreenImpl().zb(d.a.CT(paramInt));
        AppMethodBeat.o(327425);
        return true;
      }
      
      final void uninstall()
      {
        AppMethodBeat.i(327428);
        if (this.sMb != null) {
          this.sMb.b(this);
        }
        AppMethodBeat.o(327428);
      }
    }
  }
  
  final class b
    extends n
  {
    private com.tencent.mm.plugin.webview.ui.tools.d sMc;
    
    b(MMWebView paramMMWebView)
    {
      super();
      AppMethodBeat.i(180295);
      if (h.c(h.this).aqJ()) {
        this.XpJ = new h.c(h.this);
      }
      AppMethodBeat.o(180295);
    }
    
    public final boolean Kw(String paramString)
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
        paramString = this.ooz.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramString, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(21092);
        return true;
      }
      if ((paramString.startsWith("sms:")) || (paramString.startsWith("smsto:")))
      {
        localObject = new Intent("android.intent.action.SENDTO");
        ((Intent)localObject).setData(Uri.parse(paramString));
        paramString = this.ooz.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
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
    
    public final void a(j paramj)
    {
      AppMethodBeat.i(327643);
      super.a(paramj);
      if ((paramj != null) && (h.c(h.this) != null)) {
        paramj.WDP = h.c(h.this).getAppId();
      }
      h.a(h.this, paramj);
      AppMethodBeat.o(327643);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, g paramg)
    {
      AppMethodBeat.i(327499);
      h.a(h.this, parame);
      h.a(h.this, paramg);
      try
      {
        paramg = new Bundle();
        paramg.putString("key_webview_container_env", "miniProgram");
        Bundle localBundle = new Bundle();
        localBundle.putBundle("jsapiargs", paramg);
        parame.a(20, localBundle, this.ooz.hashCode());
        AppMethodBeat.o(327499);
        return;
      }
      catch (RemoteException parame)
      {
        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + parame.getMessage());
        AppMethodBeat.o(327499);
      }
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(21100);
      h.c(h.this).C(paramString2, paramInt, paramString1);
      AppMethodBeat.o(21100);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, t paramt, SslError paramSslError)
    {
      AppMethodBeat.i(21093);
      paramWebView = h.e(h.this);
      if (paramWebView == null)
      {
        Log.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "urlStr == null, return");
        AppMethodBeat.o(21093);
        return;
      }
      if (this.sMc == null) {
        this.sMc = new com.tencent.mm.plugin.webview.ui.tools.d(this.ejG, this.ooz);
      }
      this.sMc.a(paramWebView, paramt, paramSslError);
      AppMethodBeat.o(21093);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(21094);
      h.a(h.this, paramString);
      h.c(h.this).eG(paramString);
      AppMethodBeat.o(21094);
    }
    
    public final boolean a(com.tencent.xweb.WebView paramWebView, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(327526);
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
          h.c(h.this).getReporter().M(new ArrayList(localLinkedList));
          str1 = paramString;
        }
        if (!URLUtil.isAboutUrl(paramString)) {
          break;
        }
        paramWebView = new LinkedList();
        paramWebView.add(new IDKey(1097, 2, 1));
        paramWebView.add(new IDKey(1097, 6, 1));
        h.c(h.this).getReporter().M(new ArrayList(paramWebView));
        AppMethodBeat.o(327526);
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
        h.c(h.this).getReporter().M(new ArrayList(paramWebView));
        AppMethodBeat.o(327526);
        return true;
      }
      if (!URLUtil.isNetworkUrl(paramString))
      {
        h.c(h.this).getReporter().zJ(6);
        str1 = paramWebView.getUrl();
      }
      if (this.XpE) {
        aJ(str1, false);
      }
      for (;;)
      {
        AppMethodBeat.o(327526);
        return true;
        if ((this.sNd != null) && (!this.sNd.has(str1)))
        {
          Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "doUpdateVisitedHistory start geta8key, url = %s", new Object[] { str1 });
          aJ(str1, false);
        }
      }
    }
    
    public final void aJ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(327540);
      LinkedList localLinkedList = new LinkedList();
      if (URLUtil.isAboutUrl(paramString))
      {
        localLinkedList.add(new IDKey(1097, 12, 1));
        localLinkedList.add(new IDKey(1097, 14, 1));
        if (localLinkedList.size() <= 0) {
          break label217;
        }
        h.c(h.this).getReporter().M(new ArrayList(localLinkedList));
        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startGetA8Key with invalid url[%s], force[%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      }
      for (;;)
      {
        super.aJ(paramString, paramBoolean);
        AppMethodBeat.o(327540);
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
        h.c(h.this).getReporter().zJ(11);
      }
    }
    
    public final boolean acC(String paramString)
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
        if (!paramString.getHost().contains(com.tencent.luggage.l.h.atl()))
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
    
    public final String acD(String paramString)
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
    
    public final void cleanup()
    {
      AppMethodBeat.i(21091);
      super.cleanup();
      if (this.sMc != null) {
        this.sMc.detach();
      }
      AppMethodBeat.o(21091);
    }
    
    public final p cxM()
    {
      AppMethodBeat.i(21089);
      p localp = h.d(h.this);
      AppMethodBeat.o(21089);
      return localp;
    }
    
    public final int cxN()
    {
      AppMethodBeat.i(21096);
      if (h.c(h.this).cxI())
      {
        AppMethodBeat.o(21096);
        return 55;
      }
      AppMethodBeat.o(21096);
      return 49;
    }
    
    public final int cxO()
    {
      AppMethodBeat.i(21097);
      if (h.c(h.this).cxI())
      {
        AppMethodBeat.o(21097);
        return 55;
      }
      AppMethodBeat.o(21097);
      return 49;
    }
    
    public final void e(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(327574);
      super.e(paramWebView, paramString);
      h.c(h.this).acx(paramString);
      AppMethodBeat.o(327574);
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
      h.c(h.this).eH(paramString);
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