package com.tencent.mm.plugin.appbrand.jsapi.ac;

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
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.a.j.a;
import com.tencent.mm.g.a.j.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.h.d;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.platform.window.a.a.a;
import com.tencent.mm.plugin.appbrand.platform.window.d.a;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.NFCEventTransfer;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.a;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.r;
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
  com.tencent.mm.plugin.webview.modeltools.h lAa;
  WebView.b lAb;
  WebView.b lAc;
  private final com.tencent.mm.plugin.webview.modeltools.d lAd;
  final e.c lAe;
  private com.tencent.mm.plugin.webview.c.f lAf;
  ScanCodeSheetItemLogic lAg;
  private m lAh;
  private com.tencent.mm.plugin.webview.modeltools.h.c lAi;
  private String lzC;
  private MMWebViewWithJsApi lzQ;
  private b lzR;
  private a lzS;
  private com.tencent.mm.plugin.webview.stub.e lzT;
  private com.tencent.mm.plugin.webview.e.g lzU;
  private l lzV;
  private String lzW;
  private String lzX;
  int lzY;
  int lzZ;
  
  public f(e.c paramc)
  {
    AppMethodBeat.i(21102);
    this.lAd = new com.tencent.mm.plugin.webview.modeltools.d();
    this.lAh = new m()
    {
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21071);
        ae.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: ".concat(String.valueOf(paramAnonymousString2)));
        if ((f.this.lAa == null) || (paramAnonymousString1 == null) || (!paramAnonymousString1.equals(f.this.lAa.Eog)))
        {
          AppMethodBeat.o(21071);
          return;
        }
        if ((!f.k(f.this)) && (paramAnonymousInt1 != 22))
        {
          AppMethodBeat.o(21071);
          return;
        }
        if (f.this.lAa != null) {
          f.this.lAa.eUL();
        }
        f.this.lzY = paramAnonymousInt1;
        f.this.lzZ = paramAnonymousInt2;
        if ((paramAnonymousString2 == null) || (f.a(f.this) == null))
        {
          AppMethodBeat.o(21071);
          return;
        }
        f.b(f.this, paramAnonymousString2);
        f.c(f.this, paramAnonymousString2);
        if ((f.a(f.this) != null) && (f.a(f.this).LfR.isShowing())) {
          f.b(f.this);
        }
        AppMethodBeat.o(21071);
      }
      
      public final boolean g(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(21069);
        if (paramAnonymousInt == 110001) {
          com.tencent.mm.sdk.platformtools.ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21068);
              f localf = f.this;
              Object localObject = paramAnonymousBundle;
              ae.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onFetchQrCodeResp");
              int i = ((Bundle)localObject).getInt("key_resp_ret", -1);
              localObject = ((Bundle)localObject).getByteArray("key_resp_item_bytes");
              localf.lAg.q(i, (byte[])localObject);
              AppMethodBeat.o(21068);
            }
          });
        }
        boolean bool = super.g(paramAnonymousInt, paramAnonymousBundle);
        AppMethodBeat.o(21069);
        return bool;
      }
      
      public final Bundle k(int paramAnonymousInt, Bundle paramAnonymousBundle)
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
              f.c(f.this).X(paramAnonymousBundle);
            }
            catch (Exception paramAnonymousBundle) {}
            continue;
            paramAnonymousBundle.setClassLoader(f.class.getClassLoader());
            localObject2 = com.tencent.mm.sdk.f.a.jw(f.f(f.this));
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = f.f(f.this);
            }
            com.tencent.mm.br.d.b((Context)localObject1, paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name"), paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras")));
            continue;
            paramAnonymousBundle = f.f(f.this);
            if (!(paramAnonymousBundle instanceof Activity))
            {
              ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "AC_GET_OPEN_WEAPP_ACTIVITY_IPC_DELEGATE invalid context(%s) hash(%d) url(%s)", new Object[] { paramAnonymousBundle, Integer.valueOf(f.c(f.this).hashCode()), f.g(f.this).getUrl() });
            }
            else
            {
              localBundle.putParcelable("delegate", ActivityStarterIpcDelegate.aA(paramAnonymousBundle));
              continue;
              localBundle.putInt("key_webview_preverify_info_scene", 1);
              localBundle.putString("key_webview_preverify_info_source_appid", f.c(f.this).getAppId());
              continue;
              localBundle.putStringArray("key_webview_apbrand_jsapi_report_args", f.c(f.this).getJsApiReportArgs());
              continue;
              paramAnonymousBundle = f.f(f.this);
              if (!(paramAnonymousBundle instanceof Activity))
              {
                ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "AC_GET_PUBLISHER_ID invalid context(%s) hash(%d) url(%s)", new Object[] { paramAnonymousBundle, Integer.valueOf(f.c(f.this).hashCode()), f.g(f.this).getUrl() });
              }
              else
              {
                localBundle.putString("KPublisherId", ((Activity)paramAnonymousBundle).getIntent().getStringExtra("KPublisherId"));
                localBundle.putInt("getA8KeyScene", ePg());
                localBundle.putString("url", f.e(f.this));
                continue;
                bool1 = f.j(f.this).eZi();
                paramAnonymousBundle = f.j(f.this).eST();
                localObject1 = f.j(f.this).eZj();
                if (bool1)
                {
                  localBundle.putString("result", "not_return");
                }
                else
                {
                  localBundle.putString("full_url", bu.nullAsNil(paramAnonymousBundle));
                  if ((localObject1 != null) && (((Map)localObject1).size() != 0))
                  {
                    localBundle.putInt("set_cookie", 1);
                    com.tencent.xweb.d.lB(ak.getContext());
                    localObject2 = com.tencent.xweb.c.geY();
                    Iterator localIterator = ((Map)localObject1).keySet().iterator();
                    while (localIterator.hasNext())
                    {
                      String str = (String)localIterator.next();
                      ((com.tencent.xweb.c)localObject2).setCookie(bu.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                    }
                    com.tencent.xweb.d.gfa();
                    com.tencent.xweb.d.sync();
                    ae.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cookies:%s", new Object[] { ((com.tencent.xweb.c)localObject2).getCookie(bu.nullAsNil(paramAnonymousBundle)) });
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
        Object localObject1 = new j();
        ((j)localObject1).dkQ.context = f.f(f.this);
        ((j)localObject1).dkQ.actionCode = paramAnonymousInt;
        if (4003 == paramAnonymousInt)
        {
          paramAnonymousBundle = paramAnonymousBundle.getString("apdu");
          ((j)localObject1).dkQ.dkS = paramAnonymousBundle;
          label786:
          ae.i("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult actionCode: %d", new Object[] { Integer.valueOf(((j)localObject1).dkQ.actionCode) });
        }
        for (;;)
        {
          try
          {
            paramAnonymousBundle = (NFCIPCHelper.NFCEventTransfer)XIPCInvoker.a("com.tencent.mm:tools", new NFCIPCHelper.NFCEventTransfer((j)localObject1), NFCIPCHelper.a.class);
            if ((paramAnonymousBundle == null) || (paramAnonymousBundle.dkV == null)) {
              continue;
            }
            ((j)localObject1).dkR.dkV = paramAnonymousBundle.dkV;
          }
          catch (Exception paramAnonymousBundle)
          {
            boolean bool2;
            ae.printErrStackTrace("MicroMsg.NFCIPCHelper", paramAnonymousBundle, "alvinluo nfcInvokeAsResult exception", new Object[0]);
            NFCIPCHelper.eUz();
            continue;
          }
          if (((j)localObject1).dkR.dkV == null) {
            break;
          }
          localBundle.putAll(((j)localObject1).dkR.dkV);
          break;
          if (4004 != paramAnonymousInt) {
            break label786;
          }
          localObject2 = paramAnonymousBundle.getString("apdus");
          bool1 = paramAnonymousBundle.getBoolean("breakIfFail", true);
          bool2 = paramAnonymousBundle.getBoolean("breakIfTrue", false);
          ((j)localObject1).dkQ.dkS = ((String)localObject2);
          ((j)localObject1).dkQ.dkT = bool1;
          ((j)localObject1).dkQ.dkU = bool2;
          break label786;
          NFCIPCHelper.eUz();
        }
      }
    };
    this.lAi = new com.tencent.mm.plugin.webview.modeltools.h.c()
    {
      public final void Sa(String paramAnonymousString)
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
          ae.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
          AppMethodBeat.o(21081);
          return;
        }
        catch (RemoteException paramAnonymousString)
        {
          ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
          AppMethodBeat.o(21081);
        }
      }
    };
    this.lAe = paramc;
    this.lzQ = ((MMWebViewWithJsApi)paramc.getWebView());
    this.lzR = new b(this.lzQ);
    this.lzS = new a(this.lzQ);
    this.lzQ.setWebViewClient(this.lzR);
    this.lzQ.setWebChromeClient(this.lzS);
    this.lzQ.setCleanOnDetached(false);
    this.lAg = new ScanCodeSheetItemLogic(getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bpT()
      {
        AppMethodBeat.i(21067);
        if ((f.a(f.this) != null) && (f.a(f.this).LfR.isShowing())) {
          f.b(f.this);
        }
        AppMethodBeat.o(21067);
      }
    });
    this.lzV = new l(getContext());
    this.lzV.a(this.lzQ, this, null);
    AppMethodBeat.o(21102);
  }
  
  private boolean a(final ContextMenu paramContextMenu, final String paramString)
  {
    AppMethodBeat.i(21108);
    try
    {
      bool1 = this.lzT.isSDCardAvailable();
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
        ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + localException1.getMessage());
        bool1 = false;
      }
      if (this.lzU == null)
      {
        AppMethodBeat.o(21108);
        return true;
      }
      paramContextMenu.setHeaderTitle(2131766271);
      try
      {
        bool1 = this.lzT.eVf();
        bool2 = this.lzU.eUT().fkg();
        boolean bool3 = this.lzU.eUT().fkh();
        ae.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((bool1) && (bool2)) {
          paramContextMenu.add(0, 0, 0, getContext().getString(2131762163)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(21076);
              try
              {
                boolean bool = f.o(f.this).isSDCardAvailable();
                x.a(f.f(f.this), f.p(f.this), com.tencent.xweb.c.geY().getCookie(f.p(f.this)), bool, new com.tencent.mm.pluginsdk.ui.tools.x.a()
                {
                  public final void RZ(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(21075);
                    if (bu.isNullOrNil(paramAnonymous2String))
                    {
                      ae.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
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
                  ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                }
              }
            }
          });
        }
        paramContextMenu.add(0, 0, 0, getContext().getString(2131762783)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
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
                  ae.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick saveImage2SD with url[%s]", new Object[] { f.p(f.this) });
                  x.b(f.f(f.this), f.p(f.this), com.tencent.xweb.c.geY().getCookie(f.p(f.this)), bool);
                  AppMethodBeat.o(21077);
                  return true;
                  paramAnonymousMenuItem = paramAnonymousMenuItem;
                  ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                  boolean bool = false;
                }
              }
              catch (Exception paramAnonymousMenuItem)
              {
                for (;;)
                {
                  ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", new Object[] { paramAnonymousMenuItem.getMessage() });
                }
              }
            }
          }
        });
        if ((bool1) && (bool3)) {
          paramContextMenu.add(0, 0, 0, getContext().getString(2131761941)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(21079);
              try
              {
                boolean bool = f.o(f.this).isSDCardAvailable();
                paramAnonymousMenuItem = f.p(f.this).replaceAll("tp=webp", "");
                x.a(f.f(f.this), paramAnonymousMenuItem, com.tencent.xweb.c.geY().getCookie(paramAnonymousMenuItem), bool, new com.tencent.mm.pluginsdk.ui.tools.x.a()
                {
                  public final void RZ(String paramAnonymous2String)
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
                  ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                }
              }
            }
          });
        }
        this.lzV.LfR.setFooterView(null);
        if (this.lzW != null)
        {
          bool1 = bpS();
          bool2 = com.tencent.mm.plugin.scanner.g.bM(this.lzY, this.lzW);
          if ((!bool1) && (!bool2))
          {
            this.lzW = null;
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
          ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", new Object[] { localException2.getMessage() });
          bool1 = false;
        }
        paramContextMenu = this.lzW;
        if (bool2) {
          getContext().getString(2131762222);
        }
        for (;;)
        {
          paramContextMenu = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(21080);
              Object localObject = new b();
              ((b)localObject).bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
              if ((f.a(f.this) != null) && (f.a(f.this).LfR.isShowing())) {
                f.a(f.this).dismiss();
              }
              localObject = f.this;
              String str1 = paramContextMenu;
              String str2 = f.e(f.this);
              String str3 = paramString;
              int i = f.this.lzY;
              int j = f.this.lzZ;
              if (str1 != null)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.setClass(((f)localObject).getContext(), WebviewScanImageActivity.class);
                paramAnonymousView.putExtra("key_string_for_scan", str1);
                paramAnonymousView.putExtra("key_string_for_url", str2);
                paramAnonymousView.putExtra("key_string_for_image_url", str3);
                paramAnonymousView.putExtra("key_codetype_for_scan", i);
                paramAnonymousView.putExtra("key_codeversion_for_scan", j);
                if ((((f)localObject).lAe != null) && (!bu.isNullOrNil(((f)localObject).lAe.getAppId()))) {
                  paramAnonymousView.putExtra("key_string_for_wxapp_id", ((f)localObject).lAe.getAppId());
                }
                localObject = ((f)localObject).getContext();
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahE(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject).startActivity((Intent)paramAnonymousView.mt(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21080);
            }
          };
          this.lzV.LfR.setFooterView(this.lAg.a(paramContextMenu, this.lzY, this.lzW, 10));
          AppMethodBeat.o(21108);
          return true;
          getContext().getString(2131762857);
        }
        AppMethodBeat.o(21108);
      }
    }
    return false;
  }
  
  private boolean bpS()
  {
    AppMethodBeat.i(21110);
    String str = this.lzC;
    if ((str != null) && ((str.startsWith("https://mp.weixin.qq.com/")) || (str.startsWith("http://mp.weixin.qq.com/"))))
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
    this.lzR.cleanup();
    a locala = this.lzS;
    while (!locala.EIE.isEmpty()) {
      ((JsResult)locala.EIE.pollFirst()).cancel();
    }
    AppMethodBeat.o(21104);
  }
  
  public final int getBinderID()
  {
    AppMethodBeat.i(174923);
    int i = this.lzR.hLV.hashCode();
    AppMethodBeat.o(174923);
    return i;
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(21103);
    Object localObject = com.tencent.mm.sdk.f.a.jw(this.lzQ.getContext());
    if (localObject == null)
    {
      localObject = this.lzQ.getContext();
      AppMethodBeat.o(21103);
      return localObject;
    }
    AppMethodBeat.o(21103);
    return localObject;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(21107);
    if (this.lzR.EAz != null) {
      this.lzR.EAz.vg(false);
    }
    AppMethodBeat.o(21107);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(21109);
    boolean bool;
    if ((paramView instanceof android.webkit.WebView))
    {
      paramView = this.lzQ.getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(21109);
        return;
      }
      if ((paramView.mType == 5) || (paramView.mType == 8))
      {
        bool = a(paramContextMenu, paramView.mExtra);
        this.lzX = paramView.mExtra;
        if ((!bool) && (this.lzU.eUT().fkc()))
        {
          this.lAb = paramView;
          this.lAa = new com.tencent.mm.plugin.webview.modeltools.h();
          this.lAa.a(this.lzQ, this.lAi);
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
        this.lzX = paramView.mExtra;
        if ((!bool) && (this.lzU.eUT().fkc()))
        {
          this.lAc = paramView;
          this.lAa = new com.tencent.mm.plugin.webview.modeltools.h();
          this.lAa.a(this.lzQ, this.lAi);
        }
      }
    }
    AppMethodBeat.o(21109);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(21106);
    if (this.lzR.EAz != null) {
      this.lzR.EAz.vg(true);
    }
    AppMethodBeat.o(21106);
  }
  
  public final void setCurrentUrl(String paramString)
  {
    this.lzC = paramString;
  }
  
  public final void t(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21105);
    ae.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "notifyKeyboardStateChanged, shown[%b], height[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.webview.c.f localf = this.lAf;
    if (localf != null) {
      if (!paramBoolean) {
        break label57;
      }
    }
    for (;;)
    {
      localf.Xm(paramInt);
      AppMethodBeat.o(21105);
      return;
      label57:
      paramInt = 0;
    }
  }
  
  final class a
    extends i
  {
    private a lAq;
    private com.tencent.mm.plugin.appbrand.h.c lAr;
    
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
        ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startFileChooser, invalid context(%s) hash(%d) url(%s)", new Object[] { localObject, Integer.valueOf(f.c(f.this).hashCode()), f.g(f.this).getUrl() });
        AppMethodBeat.o(21087);
        return;
      }
      localObject = (Activity)localObject;
      com.tencent.luggage.h.e.aB((Context)localObject).b(new com.tencent.luggage.h.e.c()
      {
        public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(222719);
          boolean bool = f.h(f.this).d(this.val$activity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(222719);
          return bool;
        }
      });
      f.h(f.this).a((Activity)localObject, f.i(f.this), paramValueCallback, paramValueCallback1, paramString1, paramString2);
      AppMethodBeat.o(21087);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(222722);
      if (f.c(f.this).bpL())
      {
        if (this.lAq == null) {
          this.lAq = new a((byte)0);
        }
        paramView = this.lAq;
        paramCustomViewCallback = com.tencent.mm.sdk.f.a.jw(f.c(f.this).getPageView().getContext());
        if ((paramCustomViewCallback instanceof com.tencent.mm.plugin.appbrand.platform.window.a.a))
        {
          paramView.lAt = ((com.tencent.mm.plugin.appbrand.platform.window.a.a)paramCustomViewCallback);
          paramView.lAt.a(paramView);
        }
      }
      paramView = f.c(f.this).getAppId();
      paramCustomViewCallback = new com.tencent.mm.plugin.appbrand.h.c()
      {
        private void leaveFullscreen()
        {
          AppMethodBeat.i(222717);
          f.c(f.this).getWebView().leaveFullscreen();
          AppMethodBeat.o(222717);
        }
        
        public final void a(h.d paramAnonymousd)
        {
          AppMethodBeat.i(222715);
          if (paramAnonymousd == h.d.jzo) {
            leaveFullscreen();
          }
          AppMethodBeat.o(222715);
        }
        
        public final void aWf()
        {
          AppMethodBeat.i(222716);
          leaveFullscreen();
          AppMethodBeat.o(222716);
        }
      };
      this.lAr = paramCustomViewCallback;
      com.tencent.mm.plugin.appbrand.h.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(222722);
      return false;
    }
    
    public final boolean a(com.tencent.xweb.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, com.tencent.xweb.x.a parama)
    {
      AppMethodBeat.i(21086);
      if (parama.getMode() == 0)
      {
        if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
        {
          ae.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
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
    
    public final boolean bpU()
    {
      AppMethodBeat.i(222723);
      if (this.lAq != null) {
        this.lAq.uninstall();
      }
      com.tencent.mm.plugin.appbrand.h.b(f.c(f.this).getAppId(), this.lAr);
      f.c(f.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(222718);
          if (f.c(f.this).getPageView().getFullscreenImpl() != null)
          {
            f.c(f.this).getPageView().getFullscreenImpl().aYo();
            com.tencent.mm.plugin.appbrand.page.a.d locald = (com.tencent.mm.plugin.appbrand.page.a.d)f.c(f.this).getPageView().Q(com.tencent.mm.plugin.appbrand.page.a.d.class);
            if (locald != null) {
              locald.a(null);
            }
          }
          AppMethodBeat.o(222718);
        }
      });
      AppMethodBeat.o(222723);
      return false;
    }
    
    public final void d(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(21083);
      super.d(paramWebView, paramString);
      f.c(f.this).RW(paramString);
      AppMethodBeat.o(21083);
    }
    
    public final void onClose()
    {
      AppMethodBeat.i(21084);
      f.c(f.this).bpM();
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
      com.tencent.mm.plugin.appbrand.platform.window.a.a lAt;
      
      private a() {}
      
      public final boolean tO(int paramInt)
      {
        AppMethodBeat.i(222720);
        if (f.c(f.this).getPageView().getFullscreenImpl() == null)
        {
          AppMethodBeat.o(222720);
          return false;
        }
        uninstall();
        f.c(f.this).getPageView().getFullscreenImpl().rM(d.a.vf(paramInt));
        AppMethodBeat.o(222720);
        return true;
      }
      
      final void uninstall()
      {
        AppMethodBeat.i(222721);
        if (this.lAt != null) {
          this.lAt.b(this);
        }
        AppMethodBeat.o(222721);
      }
    }
  }
  
  final class b
    extends k
  {
    private com.tencent.mm.plugin.webview.ui.tools.c lAu;
    
    b(MMWebView paramMMWebView)
    {
      super();
      AppMethodBeat.i(180295);
      if (f.c(f.this).Ee()) {
        this.EIO = new f.c(f.this, this.chM);
      }
      AppMethodBeat.o(180295);
    }
    
    public final boolean Cq(String paramString)
    {
      AppMethodBeat.i(21092);
      if (paramString.startsWith("file:///android_asset"))
      {
        ae.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found %s", new Object[] { paramString });
        AppMethodBeat.o(21092);
        return true;
      }
      Object localObject;
      if (paramString.startsWith("tel:"))
      {
        localObject = new Intent("android.intent.action.DIAL");
        ((Intent)localObject).setData(Uri.parse(paramString));
        paramString = this.hLV.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(21092);
        return true;
      }
      if ((paramString.startsWith("sms:")) || (paramString.startsWith("smsto:")))
      {
        localObject = new Intent("android.intent.action.SENDTO");
        ((Intent)localObject).setData(Uri.parse(paramString));
        paramString = this.hLV.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(21092);
        return true;
      }
      if ((URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString)) || (bu.nullAsNil(paramString).startsWith("weixin"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found unacceptable %s", new Object[] { paramString });
        AppMethodBeat.o(21092);
        return true;
      }
      AppMethodBeat.o(21092);
      return false;
    }
    
    public final boolean Sb(String paramString)
    {
      AppMethodBeat.i(21088);
      if (bu.isNullOrNil(paramString))
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
        if (bu.isNullOrNil(paramString.getHost()))
        {
          AppMethodBeat.o(21088);
          return true;
        }
        if (!paramString.getHost().contains(com.tencent.luggage.h.g.Fy()))
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
    
    public final String Sc(String paramString)
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
    
    public final void a(com.tencent.mm.plugin.webview.c.f paramf)
    {
      AppMethodBeat.i(222728);
      super.a(paramf);
      if ((paramf != null) && (f.c(f.this) != null)) {
        paramf.EeI = f.c(f.this).getAppId();
      }
      f.a(f.this, paramf);
      AppMethodBeat.o(222728);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, com.tencent.mm.plugin.webview.e.g paramg)
    {
      AppMethodBeat.i(222724);
      f.a(f.this, parame);
      f.a(f.this, paramg);
      try
      {
        paramg = new Bundle();
        paramg.putString("key_webview_container_env", "miniProgram");
        Bundle localBundle = new Bundle();
        localBundle.putBundle("jsapiargs", paramg);
        parame.a(20, localBundle, this.hLV.hashCode());
        AppMethodBeat.o(222724);
        return;
      }
      catch (RemoteException parame)
      {
        ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + parame.getMessage());
        AppMethodBeat.o(222724);
      }
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(21100);
      f.c(f.this).u(paramString2, paramInt, paramString1);
      AppMethodBeat.o(21100);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, r paramr, SslError paramSslError)
    {
      AppMethodBeat.i(21093);
      paramWebView = f.e(f.this);
      if (paramWebView == null)
      {
        ae.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "urlStr == null, return");
        AppMethodBeat.o(21093);
        return;
      }
      if (this.lAu == null) {
        this.lAu = new com.tencent.mm.plugin.webview.ui.tools.c(this.chM, this.hLV);
      }
      this.lAu.a(paramWebView, paramr, paramSslError);
      AppMethodBeat.o(21093);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(21094);
      f.a(f.this, paramString);
      f.c(f.this).RX(paramString);
      AppMethodBeat.o(21094);
    }
    
    public final boolean a(com.tencent.xweb.WebView paramWebView, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(222725);
      ae.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "doUpdateVisitedHistory, view.url[%s], updatedUrl[%s], isReload[%b]", new Object[] { paramWebView.getUrl(), paramString, Boolean.valueOf(paramBoolean) });
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
          f.c(f.this).getReporter().C(new ArrayList(localLinkedList));
          str1 = paramString;
        }
        if (!URLUtil.isAboutUrl(paramString)) {
          break;
        }
        paramWebView = new LinkedList();
        paramWebView.add(new IDKey(1097, 2, 1));
        paramWebView.add(new IDKey(1097, 6, 1));
        f.c(f.this).getReporter().C(new ArrayList(paramWebView));
        AppMethodBeat.o(222725);
        return true;
        if (bu.nullAsNil(str2).startsWith("file:///android_asset/"))
        {
          localLinkedList.add(new IDKey(1097, 3, 1));
          localLinkedList.add(new IDKey(1097, 5, 1));
        }
        else if (!URLUtil.isNetworkUrl(str2))
        {
          localLinkedList.add(new IDKey(1097, 5, 1));
        }
      }
      if (bu.nullAsNil(paramString).startsWith("file:///android_asset/"))
      {
        paramWebView = new LinkedList();
        paramWebView.add(new IDKey(1097, 4, 1));
        paramWebView.add(new IDKey(1097, 6, 1));
        f.c(f.this).getReporter().C(new ArrayList(paramWebView));
        AppMethodBeat.o(222725);
        return true;
      }
      if (!URLUtil.isNetworkUrl(paramString))
      {
        f.c(f.this).getReporter().tM(6);
        str1 = paramWebView.getUrl();
      }
      if (this.EIJ) {
        at(str1, false);
      }
      for (;;)
      {
        AppMethodBeat.o(222725);
        return true;
        if ((this.EeB != null) && (!this.EeB.has(str1)))
        {
          ae.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "doUpdateVisitedHistory start geta8key, url = %s", new Object[] { str1 });
          at(str1, false);
        }
      }
    }
    
    public final void at(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(222726);
      LinkedList localLinkedList = new LinkedList();
      if (URLUtil.isAboutUrl(paramString))
      {
        localLinkedList.add(new IDKey(1097, 12, 1));
        localLinkedList.add(new IDKey(1097, 14, 1));
        if (localLinkedList.size() <= 0) {
          break label217;
        }
        f.c(f.this).getReporter().C(new ArrayList(localLinkedList));
        ae.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startGetA8Key with invalid url[%s], force[%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      }
      for (;;)
      {
        super.at(paramString, paramBoolean);
        AppMethodBeat.o(222726);
        return;
        if (bu.nullAsNil(paramString).startsWith("file:///android_asset/"))
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
        f.c(f.this).getReporter().tM(11);
      }
    }
    
    public final m bpV()
    {
      AppMethodBeat.i(21089);
      m localm = f.d(f.this);
      AppMethodBeat.o(21089);
      return localm;
    }
    
    public final int bpW()
    {
      AppMethodBeat.i(21096);
      if (f.c(f.this).bpO())
      {
        AppMethodBeat.o(21096);
        return 55;
      }
      AppMethodBeat.o(21096);
      return 49;
    }
    
    public final int bpX()
    {
      AppMethodBeat.i(21097);
      if (f.c(f.this).bpO())
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
      if (this.lAu != null) {
        this.lAu.detach();
      }
      AppMethodBeat.o(21091);
    }
    
    public final void e(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(222727);
      super.e(paramWebView, paramString);
      f.c(f.this).RY(paramString);
      AppMethodBeat.o(222727);
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
      f.c(f.this).cF(paramString);
      AppMethodBeat.o(21095);
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.webview.model.ar
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.f
 * JD-Core Version:    0.7.0.1
 */