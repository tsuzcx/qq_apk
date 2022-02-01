package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.os.RemoteException;
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
import com.tencent.luggage.sdk.launching.ActivityStarterIpcDelegate;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.k.a;
import com.tencent.mm.g.a.k.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.ipcinvoker.wx_extension.service.ToolsProcessIPCService;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.platform.window.a.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.model.ar;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.NFCEventTransfer;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.a;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.pluginsdk.ui.tools.z;
import com.tencent.mm.pluginsdk.ui.tools.z.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.JsResult;
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
import java.util.concurrent.ConcurrentSkipListSet;
import org.json.JSONObject;

public class f
  implements View.OnCreateContextMenuListener, e.a
{
  private String mGQ;
  private MMWebViewWithJsApi mHe;
  private b mHf;
  private a mHg;
  private com.tencent.mm.plugin.webview.stub.e mHh;
  private com.tencent.mm.plugin.webview.f.g mHi;
  private l mHj;
  private String mHk;
  private String mHl;
  int mHm;
  int mHn;
  com.tencent.mm.plugin.webview.modeltools.h mHo;
  WebView.b mHp;
  WebView.b mHq;
  private final com.tencent.mm.plugin.webview.modeltools.d mHr;
  final e.c mHs;
  private com.tencent.mm.plugin.webview.d.h mHt;
  ScanCodeSheetItemLogic mHu;
  private m mHv;
  private com.tencent.mm.plugin.webview.modeltools.h.c mHw;
  
  public f(e.c paramc)
  {
    AppMethodBeat.i(21102);
    this.mHr = new com.tencent.mm.plugin.webview.modeltools.d();
    this.mHv = new m()
    {
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21071);
        Log.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: ".concat(String.valueOf(paramAnonymousString2)));
        if ((f.this.mHo == null) || (paramAnonymousString1 == null) || (!paramAnonymousString1.equals(f.this.mHo.Jbk)))
        {
          AppMethodBeat.o(21071);
          return;
        }
        boolean bool = f.k(f.this);
        if ((!bool) && (paramAnonymousInt1 != 22))
        {
          AppMethodBeat.o(21071);
          return;
        }
        if ((bool) && (!com.tencent.mm.plugin.scanner.g.ck(paramAnonymousInt1, paramAnonymousString2)))
        {
          f.b(f.this, null);
          AppMethodBeat.o(21071);
          return;
        }
        if (f.this.mHo != null) {
          f.this.mHo.gdA();
        }
        f.this.mHm = paramAnonymousInt1;
        f.this.mHn = paramAnonymousInt2;
        if ((paramAnonymousString2 == null) || (f.a(f.this) == null))
        {
          AppMethodBeat.o(21071);
          return;
        }
        f.c(f.this, paramAnonymousString2);
        f.b(f.this, paramAnonymousString2);
        if ((f.a(f.this) != null) && (f.a(f.this).QuS.isShowing())) {
          f.b(f.this);
        }
        AppMethodBeat.o(21071);
      }
      
      public final boolean f(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(21069);
        if (paramAnonymousInt == 110001) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21068);
              f localf = f.this;
              Object localObject = paramAnonymousBundle;
              Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onFetchQrCodeResp");
              int i = ((Bundle)localObject).getInt("key_resp_ret", -1);
              localObject = ((Bundle)localObject).getByteArray("key_resp_item_bytes");
              localf.mHu.q(i, (byte[])localObject);
              AppMethodBeat.o(21068);
            }
          });
        }
        boolean bool = super.f(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(21069);
        return bool;
      }
      
      public final Bundle j(int paramAnonymousInt, Bundle paramAnonymousBundle)
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
              f.c(f.this).ah(paramAnonymousBundle);
            }
            catch (Exception paramAnonymousBundle) {}
            continue;
            paramAnonymousBundle.setClassLoader(f.class.getClassLoader());
            localObject2 = AndroidContextUtil.castActivityOrNull(f.f(f.this));
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = f.f(f.this);
            }
            com.tencent.mm.br.c.b((Context)localObject1, paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name"), paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras")));
            continue;
            paramAnonymousBundle = f.f(f.this);
            if (!(paramAnonymousBundle instanceof Activity))
            {
              Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "AC_GET_OPEN_WEAPP_ACTIVITY_IPC_DELEGATE invalid context(%s) hash(%d) url(%s)", new Object[] { paramAnonymousBundle, Integer.valueOf(f.c(f.this).hashCode()), f.g(f.this).getUrl() });
            }
            else
            {
              localBundle.putParcelable("delegate", ActivityStarterIpcDelegate.aJ(paramAnonymousBundle));
              continue;
              localBundle.putInt("key_webview_preverify_info_scene", 1);
              localBundle.putString("key_webview_preverify_info_source_appid", f.c(f.this).getAppId());
              continue;
              localBundle.putStringArray("key_webview_apbrand_jsapi_report_args", f.c(f.this).getJsApiReportArgs());
              continue;
              paramAnonymousBundle = f.f(f.this);
              if (!(paramAnonymousBundle instanceof Activity))
              {
                Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "AC_GET_PUBLISHER_ID invalid context(%s) hash(%d) url(%s)", new Object[] { paramAnonymousBundle, Integer.valueOf(f.c(f.this).hashCode()), f.g(f.this).getUrl() });
              }
              else
              {
                localBundle.putString("KPublisherId", ((Activity)paramAnonymousBundle).getIntent().getStringExtra("KPublisherId"));
                localBundle.putInt("getA8KeyScene", fWY());
                localBundle.putString("url", f.e(f.this));
                continue;
                bool1 = f.j(f.this).gio();
                paramAnonymousBundle = f.j(f.this).coy();
                localObject1 = f.j(f.this).gip();
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
                    com.tencent.xweb.d.lA(MMApplicationContext.getContext());
                    localObject2 = com.tencent.xweb.c.hsp();
                    Iterator localIterator = ((Map)localObject1).keySet().iterator();
                    while (localIterator.hasNext())
                    {
                      String str = (String)localIterator.next();
                      ((com.tencent.xweb.c)localObject2).setCookie(Util.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                    }
                    com.tencent.xweb.d.hsr();
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
        Object localObject1 = new com.tencent.mm.g.a.k();
        ((com.tencent.mm.g.a.k)localObject1).dCc.context = f.f(f.this);
        ((com.tencent.mm.g.a.k)localObject1).dCc.actionCode = paramAnonymousInt;
        if (4003 == paramAnonymousInt)
        {
          paramAnonymousBundle = paramAnonymousBundle.getString("apdu");
          ((com.tencent.mm.g.a.k)localObject1).dCc.dCe = paramAnonymousBundle;
          label789:
          Log.i("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult actionCode: %d", new Object[] { Integer.valueOf(((com.tencent.mm.g.a.k)localObject1).dCc.actionCode) });
        }
        for (;;)
        {
          try
          {
            paramAnonymousBundle = new NFCIPCHelper.NFCEventTransfer((com.tencent.mm.g.a.k)localObject1);
            paramAnonymousBundle = (NFCIPCHelper.NFCEventTransfer)XIPCInvoker.a(ToolsProcessIPCService.dkO, paramAnonymousBundle, NFCIPCHelper.a.class);
            if ((paramAnonymousBundle == null) || (paramAnonymousBundle.dCh == null)) {
              continue;
            }
            ((com.tencent.mm.g.a.k)localObject1).dCd.dCh = paramAnonymousBundle.dCh;
          }
          catch (Exception paramAnonymousBundle)
          {
            boolean bool2;
            Log.printErrStackTrace("MicroMsg.NFCIPCHelper", paramAnonymousBundle, "alvinluo nfcInvokeAsResult exception", new Object[0]);
            NFCIPCHelper.gdo();
            continue;
          }
          if (((com.tencent.mm.g.a.k)localObject1).dCd.dCh == null) {
            break;
          }
          localBundle.putAll(((com.tencent.mm.g.a.k)localObject1).dCd.dCh);
          break;
          if (4004 != paramAnonymousInt) {
            break label789;
          }
          localObject2 = paramAnonymousBundle.getString("apdus");
          bool1 = paramAnonymousBundle.getBoolean("breakIfFail", true);
          bool2 = paramAnonymousBundle.getBoolean("breakIfTrue", false);
          ((com.tencent.mm.g.a.k)localObject1).dCc.dCe = ((String)localObject2);
          ((com.tencent.mm.g.a.k)localObject1).dCc.dCf = bool1;
          ((com.tencent.mm.g.a.k)localObject1).dCc.dCg = bool2;
          break label789;
          NFCIPCHelper.gdo();
        }
      }
    };
    this.mHw = new com.tencent.mm.plugin.webview.modeltools.h.c()
    {
      public final void abF(String paramAnonymousString)
      {
        AppMethodBeat.i(21081);
        try
        {
          if (f.o(f.this) != null)
          {
            f.o(f.this).a(paramAnonymousString, new int[] { 3 }, 0, 0);
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
    this.mHs = paramc;
    this.mHe = ((MMWebViewWithJsApi)paramc.getWebView());
    this.mHf = new b(this.mHe);
    this.mHg = new a(this.mHe);
    this.mHe.setWebViewClient(this.mHf);
    this.mHe.setWebChromeClient(this.mHg);
    this.mHe.setCleanOnDetached(false);
    this.mHu = new ScanCodeSheetItemLogic(getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bLz()
      {
        AppMethodBeat.i(21067);
        if ((f.a(f.this) != null) && (f.a(f.this).QuS.isShowing())) {
          f.b(f.this);
        }
        AppMethodBeat.o(21067);
      }
    });
    this.mHj = new l(getContext());
    this.mHj.a(this.mHe, this, null);
    AppMethodBeat.o(21102);
  }
  
  private boolean a(final ContextMenu paramContextMenu, final String paramString)
  {
    AppMethodBeat.i(21108);
    try
    {
      bool1 = this.mHh.isSDCardAvailable();
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
      if (this.mHi == null)
      {
        AppMethodBeat.o(21108);
        return true;
      }
      paramContextMenu.setHeaderTitle(2131768782);
      try
      {
        bool1 = this.mHh.gdW();
        bool2 = this.mHi.gdI().gtH();
        boolean bool3 = this.mHi.gdI().gtI();
        Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((bool1) && (bool2)) {
          paramContextMenu.add(0, 0, 0, getContext().getString(2131764184)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(21076);
              try
              {
                boolean bool = f.o(f.this).isSDCardAvailable();
                z.a(f.f(f.this), f.p(f.this), com.tencent.xweb.c.hsp().getCookie(f.p(f.this)), bool, new z.a()
                {
                  public final void abE(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(21075);
                    if (Util.isNullOrNil(paramAnonymous2String))
                    {
                      Log.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
                      AppMethodBeat.o(21075);
                      return;
                    }
                    f.d(f.this, paramAnonymous2String);
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
        paramContextMenu.add(0, 0, 0, getContext().getString(2131764870)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(21077);
            try
            {
              bool = f.o(f.this).isSDCardAvailable();
            }
            catch (Exception paramAnonymousMenuItem)
            {
              try
              {
                for (;;)
                {
                  Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick saveImage2SD with url[%s]", new Object[] { f.p(f.this) });
                  z.b(f.f(f.this), f.p(f.this), com.tencent.xweb.c.hsp().getCookie(f.p(f.this)), bool);
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
          paramContextMenu.add(0, 0, 0, getContext().getString(2131763947)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(21079);
              try
              {
                boolean bool = f.o(f.this).isSDCardAvailable();
                paramAnonymousMenuItem = f.p(f.this).replaceAll("tp=webp", "");
                z.a(f.f(f.this), paramAnonymousMenuItem, com.tencent.xweb.c.hsp().getCookie(paramAnonymousMenuItem), bool, new z.a()
                {
                  public final void abE(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(21078);
                    f.e(f.this, paramAnonymous2String);
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
        this.mHj.QuS.setFooterView(null);
        if (this.mHk != null)
        {
          bool1 = bLy();
          bool2 = com.tencent.mm.plugin.scanner.g.ca(this.mHm, this.mHk);
          if ((!bool1) && (!bool2))
          {
            this.mHk = null;
            AppMethodBeat.o(21108);
            return true;
          }
        }
      }
      catch (Exception localException2)
      {
        boolean bool2;
        for (;;)
        {
          Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", new Object[] { localException2.getMessage() });
          bool1 = false;
        }
        paramContextMenu = this.mHk;
        if (bool2) {
          getContext().getString(2131764244);
        }
        for (;;)
        {
          paramContextMenu = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(21080);
              Object localObject = new b();
              ((b)localObject).bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
              if ((f.a(f.this) != null) && (f.a(f.this).QuS.isShowing())) {
                f.a(f.this).dismiss();
              }
              localObject = f.this;
              String str1 = paramContextMenu;
              String str2 = f.e(f.this);
              String str3 = paramString;
              int i = f.this.mHm;
              int j = f.this.mHn;
              if (str1 != null)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.setClass(((f)localObject).getContext(), WebviewScanImageActivity.class);
                paramAnonymousView.putExtra("key_string_for_scan", str1);
                paramAnonymousView.putExtra("key_string_for_url", str2);
                paramAnonymousView.putExtra("key_string_for_image_url", str3);
                paramAnonymousView.putExtra("key_codetype_for_scan", i);
                paramAnonymousView.putExtra("key_codeversion_for_scan", j);
                if ((((f)localObject).mHs != null) && (!Util.isNullOrNil(((f)localObject).mHs.getAppId()))) {
                  paramAnonymousView.putExtra("key_string_for_wxapp_id", ((f)localObject).mHs.getAppId());
                }
                localObject = ((f)localObject).getContext();
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bl(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.axQ(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject).startActivity((Intent)paramAnonymousView.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21080);
            }
          };
          this.mHj.QuS.setFooterView(this.mHu.a(paramContextMenu, this.mHm, this.mHk, 10));
          AppMethodBeat.o(21108);
          return true;
          getContext().getString(2131764967);
        }
        AppMethodBeat.o(21108);
      }
    }
    return false;
  }
  
  private boolean bLy()
  {
    AppMethodBeat.i(21110);
    String str = this.mGQ;
    if ((str != null) && ((str.startsWith("https://" + WeChatHosts.domainString(2131761726) + "/")) || (str.startsWith("http://" + WeChatHosts.domainString(2131761726) + "/"))))
    {
      AppMethodBeat.o(21110);
      return true;
    }
    AppMethodBeat.o(21110);
    return false;
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(21104);
    this.mHf.cleanup();
    a locala = this.mHg;
    while (!locala.Jyu.isEmpty()) {
      ((JsResult)locala.Jyu.pollFirst()).cancel();
    }
    AppMethodBeat.o(21104);
  }
  
  public final int getBinderID()
  {
    AppMethodBeat.i(174923);
    int i = this.mHf.iGY.hashCode();
    AppMethodBeat.o(174923);
    return i;
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(21103);
    Object localObject = AndroidContextUtil.castActivityOrNull(this.mHe.getContext());
    if (localObject == null)
    {
      localObject = this.mHe.getContext();
      AppMethodBeat.o(21103);
      return localObject;
    }
    AppMethodBeat.o(21103);
    return localObject;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(21107);
    if (this.mHf.JpW != null) {
      this.mHf.JpW.yY(false);
    }
    AppMethodBeat.o(21107);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(21109);
    boolean bool;
    if ((paramView instanceof android.webkit.WebView))
    {
      paramView = this.mHe.getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(21109);
        return;
      }
      if ((paramView.mType == 5) || (paramView.mType == 8))
      {
        bool = a(paramContextMenu, paramView.mExtra);
        this.mHl = paramView.mExtra;
        if ((!bool) && (this.mHi.gdI().gtD()))
        {
          this.mHp = paramView;
          this.mHo = new com.tencent.mm.plugin.webview.modeltools.h();
          this.mHo.a(this.mHe, this.mHw);
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
        this.mHl = paramView.mExtra;
        if ((!bool) && (this.mHi.gdI().gtD()))
        {
          this.mHq = paramView;
          this.mHo = new com.tencent.mm.plugin.webview.modeltools.h();
          this.mHo.a(this.mHe, this.mHw);
        }
      }
    }
    AppMethodBeat.o(21109);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(21106);
    if (this.mHf.JpW != null) {
      this.mHf.JpW.yY(true);
    }
    AppMethodBeat.o(21106);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21105);
    Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "notifyKeyboardStateChanged, shown[%b], height[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.webview.d.h localh = this.mHt;
    if (localh != null) {
      if (!paramBoolean) {
        break label57;
      }
    }
    for (;;)
    {
      localh.afV(paramInt);
      AppMethodBeat.o(21105);
      return;
      label57:
      paramInt = 0;
    }
  }
  
  public final void setCurrentUrl(String paramString)
  {
    this.mGQ = paramString;
  }
  
  final class a
    extends i
  {
    private a mHE;
    private com.tencent.mm.plugin.appbrand.h.c mHF;
    
    a(MMWebViewWithJsApi paramMMWebViewWithJsApi)
    {
      super();
    }
    
    private void a(ValueCallback<Uri> paramValueCallback, ValueCallback<Uri[]> paramValueCallback1, String paramString1, String paramString2)
    {
      AppMethodBeat.i(21087);
      Object localObject = f.f(f.this);
      if (!(localObject instanceof Activity))
      {
        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startFileChooser, invalid context(%s) hash(%d) url(%s)", new Object[] { localObject, Integer.valueOf(f.c(f.this).hashCode()), f.g(f.this).getUrl() });
        AppMethodBeat.o(21087);
        return;
      }
      localObject = (Activity)localObject;
      com.tencent.luggage.h.f.aK((Context)localObject).b(new com.tencent.luggage.h.f.c()
      {
        public final boolean c(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(227030);
          boolean bool = f.h(f.this).d(this.val$activity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(227030);
          return bool;
        }
      });
      f.h(f.this).a((Activity)localObject, f.i(f.this), paramValueCallback, paramValueCallback1, paramString1, paramString2);
      AppMethodBeat.o(21087);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(227033);
      if (f.c(f.this).bLr())
      {
        if (this.mHE == null) {
          this.mHE = new a((byte)0);
        }
        paramView = this.mHE;
        paramCustomViewCallback = AndroidContextUtil.castActivityOrNull(f.c(f.this).getPageView().getContext());
        if ((paramCustomViewCallback instanceof com.tencent.mm.plugin.appbrand.platform.window.a.a))
        {
          paramView.mHH = ((com.tencent.mm.plugin.appbrand.platform.window.a.a)paramCustomViewCallback);
          paramView.mHH.a(paramView);
        }
      }
      paramView = f.c(f.this).getAppId();
      paramCustomViewCallback = new com.tencent.mm.plugin.appbrand.h.c()
      {
        private void leaveFullscreen()
        {
          AppMethodBeat.i(227028);
          f.c(f.this).getWebView().leaveFullscreen();
          AppMethodBeat.o(227028);
        }
        
        public final void a(h.d paramAnonymousd)
        {
          AppMethodBeat.i(227026);
          if (paramAnonymousd == h.d.kzW) {
            leaveFullscreen();
          }
          AppMethodBeat.o(227026);
        }
        
        public final void bra()
        {
          AppMethodBeat.i(227027);
          leaveFullscreen();
          AppMethodBeat.o(227027);
        }
      };
      this.mHF = paramCustomViewCallback;
      com.tencent.mm.plugin.appbrand.h.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(227033);
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
    
    public final boolean bLA()
    {
      AppMethodBeat.i(227034);
      if (this.mHE != null) {
        this.mHE.uninstall();
      }
      com.tencent.mm.plugin.appbrand.h.b(f.c(f.this).getAppId(), this.mHF);
      f.c(f.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(227029);
          if (f.c(f.this).getPageView().getFullscreenImpl() != null)
          {
            f.c(f.this).getPageView().getFullscreenImpl().btC();
            com.tencent.mm.plugin.appbrand.page.a.d locald = (com.tencent.mm.plugin.appbrand.page.a.d)f.c(f.this).getPageView().S(com.tencent.mm.plugin.appbrand.page.a.d.class);
            if (locald != null) {
              locald.a(null);
            }
          }
          AppMethodBeat.o(227029);
        }
      });
      AppMethodBeat.o(227034);
      return false;
    }
    
    public final void d(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(21083);
      super.d(paramWebView, paramString);
      f.c(f.this).abB(paramString);
      AppMethodBeat.o(21083);
    }
    
    public final void onClose()
    {
      AppMethodBeat.i(21084);
      f.c(f.this).bLs();
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
      com.tencent.mm.plugin.appbrand.platform.window.a.a mHH;
      
      private a() {}
      
      final void uninstall()
      {
        AppMethodBeat.i(227032);
        if (this.mHH != null) {
          this.mHH.b(this);
        }
        AppMethodBeat.o(227032);
      }
      
      public final boolean xM(int paramInt)
      {
        AppMethodBeat.i(227031);
        if (f.c(f.this).getPageView().getFullscreenImpl() == null)
        {
          AppMethodBeat.o(227031);
          return false;
        }
        uninstall();
        f.c(f.this).getPageView().getFullscreenImpl().vH(d.a.yX(paramInt));
        AppMethodBeat.o(227031);
        return true;
      }
    }
  }
  
  final class b
    extends com.tencent.mm.plugin.webview.ui.tools.widget.k
  {
    private com.tencent.mm.plugin.webview.ui.tools.c mHI;
    
    b(MMWebView paramMMWebView)
    {
      super();
      AppMethodBeat.i(180295);
      if (f.c(f.this).NA()) {
        this.JyE = new f.c(f.this, this.ctH);
      }
      AppMethodBeat.o(180295);
    }
    
    public final boolean Lb(String paramString)
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
        paramString = this.iGY.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(21092);
        return true;
      }
      if ((paramString.startsWith("sms:")) || (paramString.startsWith("smsto:")))
      {
        localObject = new Intent("android.intent.action.SENDTO");
        ((Intent)localObject).setData(Uri.parse(paramString));
        paramString = this.iGY.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
      AppMethodBeat.i(227039);
      super.a(paramh);
      if ((paramh != null) && (f.c(f.this) != null)) {
        paramh.IRp = f.c(f.this).getAppId();
      }
      f.a(f.this, paramh);
      AppMethodBeat.o(227039);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, com.tencent.mm.plugin.webview.f.g paramg)
    {
      AppMethodBeat.i(227035);
      f.a(f.this, parame);
      f.a(f.this, paramg);
      try
      {
        paramg = new Bundle();
        paramg.putString("key_webview_container_env", "miniProgram");
        Bundle localBundle = new Bundle();
        localBundle.putBundle("jsapiargs", paramg);
        parame.a(20, localBundle, this.iGY.hashCode());
        AppMethodBeat.o(227035);
        return;
      }
      catch (RemoteException parame)
      {
        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + parame.getMessage());
        AppMethodBeat.o(227035);
      }
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(21100);
      f.c(f.this).z(paramString2, paramInt, paramString1);
      AppMethodBeat.o(21100);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, r paramr, SslError paramSslError)
    {
      AppMethodBeat.i(21093);
      paramWebView = f.e(f.this);
      if (paramWebView == null)
      {
        Log.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "urlStr == null, return");
        AppMethodBeat.o(21093);
        return;
      }
      if (this.mHI == null) {
        this.mHI = new com.tencent.mm.plugin.webview.ui.tools.c(this.ctH, this.iGY);
      }
      this.mHI.a(paramWebView, paramr, paramSslError);
      AppMethodBeat.o(21093);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(21094);
      f.a(f.this, paramString);
      f.c(f.this).abC(paramString);
      AppMethodBeat.o(21094);
    }
    
    public final boolean a(com.tencent.xweb.WebView paramWebView, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(227036);
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
          f.c(f.this).getReporter().H(new ArrayList(localLinkedList));
          str1 = paramString;
        }
        if (!URLUtil.isAboutUrl(paramString)) {
          break;
        }
        paramWebView = new LinkedList();
        paramWebView.add(new IDKey(1097, 2, 1));
        paramWebView.add(new IDKey(1097, 6, 1));
        f.c(f.this).getReporter().H(new ArrayList(paramWebView));
        AppMethodBeat.o(227036);
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
        f.c(f.this).getReporter().H(new ArrayList(paramWebView));
        AppMethodBeat.o(227036);
        return true;
      }
      if (!URLUtil.isNetworkUrl(paramString))
      {
        f.c(f.this).getReporter().xK(6);
        str1 = paramWebView.getUrl();
      }
      if (this.Jyz) {
        av(str1, false);
      }
      for (;;)
      {
        AppMethodBeat.o(227036);
        return true;
        if ((this.IRi != null) && (!this.IRi.has(str1)))
        {
          Log.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "doUpdateVisitedHistory start geta8key, url = %s", new Object[] { str1 });
          av(str1, false);
        }
      }
    }
    
    public final boolean abG(String paramString)
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
        if (!paramString.getHost().contains(com.tencent.luggage.h.h.Ph()))
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
    
    public final String abH(String paramString)
    {
      AppMethodBeat.i(21098);
      if ((f.e(f.this) != null) && (f.e(f.this).equals(paramString)))
      {
        AppMethodBeat.o(21098);
        return "";
      }
      paramString = f.e(f.this);
      AppMethodBeat.o(21098);
      return paramString;
    }
    
    public final void av(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(227037);
      LinkedList localLinkedList = new LinkedList();
      if (URLUtil.isAboutUrl(paramString))
      {
        localLinkedList.add(new IDKey(1097, 12, 1));
        localLinkedList.add(new IDKey(1097, 14, 1));
        if (localLinkedList.size() <= 0) {
          break label217;
        }
        f.c(f.this).getReporter().H(new ArrayList(localLinkedList));
        Log.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startGetA8Key with invalid url[%s], force[%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      }
      for (;;)
      {
        super.av(paramString, paramBoolean);
        AppMethodBeat.o(227037);
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
        f.c(f.this).getReporter().xK(11);
      }
    }
    
    public final m bLB()
    {
      AppMethodBeat.i(21089);
      m localm = f.d(f.this);
      AppMethodBeat.o(21089);
      return localm;
    }
    
    public final int bLC()
    {
      AppMethodBeat.i(21096);
      if (f.c(f.this).bLu())
      {
        AppMethodBeat.o(21096);
        return 55;
      }
      AppMethodBeat.o(21096);
      return 49;
    }
    
    public final int bLD()
    {
      AppMethodBeat.i(21097);
      if (f.c(f.this).bLu())
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
      if (this.mHI != null) {
        this.mHI.detach();
      }
      AppMethodBeat.o(21091);
    }
    
    public final void e(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(227038);
      super.e(paramWebView, paramString);
      f.c(f.this).abD(paramString);
      AppMethodBeat.o(227038);
    }
    
    public final void f(Bundle paramBundle, String paramString)
    {
      AppMethodBeat.i(21099);
      super.f(paramBundle, paramString);
      paramBundle.putString("geta8key_data_appid", f.c(f.this).getAppId());
      AppMethodBeat.o(21099);
    }
    
    public final void f(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(21095);
      f.a(f.this, paramString);
      f.c(f.this).cW(paramString);
      AppMethodBeat.o(21095);
    }
  }
  
  final class c
    extends ar
  {
    public c(Context paramContext)
    {
      super();
    }
    
    public final WebResourceResponse a(String paramString, WebResourceRequest paramWebResourceRequest, boolean paramBoolean, com.tencent.mm.plugin.webview.stub.e parame)
    {
      AppMethodBeat.i(180296);
      f.c(f.this).a(f.e(f.this), paramWebResourceRequest);
      paramString = super.a(paramString, paramWebResourceRequest, paramBoolean, parame);
      AppMethodBeat.o(180296);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.f
 * JD-Core Version:    0.7.0.1
 */