package com.tencent.mm.plugin.appbrand.jsapi.z;

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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.a.j.a;
import com.tencent.mm.g.a.j.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.s.a.a.a.a;
import com.tencent.mm.plugin.appbrand.s.a.d.a;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.NFCEventTransfer;
import com.tencent.mm.plugin.webview.modeltools.NFCIPCHelper.a;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.i;
import com.tencent.mm.plugin.webview.ui.tools.widget.k;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.pluginsdk.ui.tools.x;
import com.tencent.mm.pluginsdk.ui.tools.x.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebResourceRequest;
import com.tencent.xweb.WebResourceResponse;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.q;
import com.tencent.xweb.w.a;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import org.json.JSONObject;

public class f
  implements View.OnCreateContextMenuListener, e.a
{
  private String kwP;
  private MMWebViewWithJsApi kxc;
  private b kxd;
  private a kxe;
  private com.tencent.mm.plugin.webview.stub.e kxf;
  private com.tencent.mm.plugin.webview.e.g kxg;
  private l kxh;
  private String kxi;
  private String kxj;
  int kxk;
  int kxl;
  h kxm;
  WebView.b kxn;
  WebView.b kxo;
  private final com.tencent.mm.plugin.webview.modeltools.d kxp;
  final e.b kxq;
  private com.tencent.mm.plugin.webview.c.f kxr;
  ScanCodeSheetItemLogic kxs;
  private m kxt;
  private h.c kxu;
  
  public f(e.b paramb)
  {
    AppMethodBeat.i(21102);
    this.kxp = new com.tencent.mm.plugin.webview.modeltools.d();
    this.kxt = new m()
    {
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21071);
        ad.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: ".concat(String.valueOf(paramAnonymousString2)));
        if ((f.this.kxm == null) || (paramAnonymousString1 == null) || (!paramAnonymousString1.equals(f.this.kxm.Bap)))
        {
          AppMethodBeat.o(21071);
          return;
        }
        if ((!f.k(f.this)) && (paramAnonymousInt1 != 22))
        {
          AppMethodBeat.o(21071);
          return;
        }
        if (f.this.kxm != null) {
          f.this.kxm.emK();
        }
        f.this.kxk = paramAnonymousInt1;
        f.this.kxl = paramAnonymousInt2;
        if ((paramAnonymousString2 == null) || (f.a(f.this) == null))
        {
          AppMethodBeat.o(21071);
          return;
        }
        f.b(f.this, paramAnonymousString2);
        f.c(f.this, paramAnonymousString2);
        if ((f.a(f.this) != null) && (f.a(f.this).HrW.isShowing())) {
          f.b(f.this);
        }
        AppMethodBeat.o(21071);
      }
      
      public final boolean f(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(21069);
        if (paramAnonymousInt == 110001) {
          com.tencent.mm.sdk.platformtools.aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21068);
              f localf = f.this;
              Object localObject = paramAnonymousBundle;
              ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onFetchQrCodeResp");
              int i = ((Bundle)localObject).getInt("key_resp_ret", -1);
              localObject = ((Bundle)localObject).getByteArray("key_resp_item_bytes");
              localf.kxs.q(i, (byte[])localObject);
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
              f.c(f.this).V(paramAnonymousBundle);
            }
            catch (Exception paramAnonymousBundle) {}
            continue;
            paramAnonymousBundle.setClassLoader(f.class.getClassLoader());
            localObject2 = com.tencent.mm.sdk.f.a.iV(f.f(f.this));
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = f.f(f.this);
            }
            com.tencent.mm.bs.d.b((Context)localObject1, paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_name"), paramAnonymousBundle.getString("open_ui_with_webview_ui_plugin_entry"), new Intent().putExtras(paramAnonymousBundle.getBundle("open_ui_with_webview_ui_extras")));
            continue;
            localBundle.putInt("key_webview_preverify_info_scene", 1);
            localBundle.putString("key_webview_preverify_info_source_appid", f.c(f.this).getAppId());
            continue;
            localBundle.putStringArray("key_webview_apbrand_jsapi_report_args", f.c(f.this).getJsApiReportArgs());
            continue;
            paramAnonymousBundle = f.f(f.this);
            if (!(paramAnonymousBundle instanceof Activity))
            {
              ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "AC_GET_PUBLISHER_ID invalid context(%s) hash(%d) url(%s)", new Object[] { paramAnonymousBundle, Integer.valueOf(f.c(f.this).hashCode()), f.g(f.this).getUrl() });
            }
            else
            {
              localBundle.putString("KPublisherId", ((Activity)paramAnonymousBundle).getIntent().getStringExtra("KPublisherId"));
              localBundle.putInt("getA8KeyScene", enf());
              localBundle.putString("url", f.e(f.this));
              continue;
              bool1 = f.j(f.this).erb();
              paramAnonymousBundle = f.j(f.this).ekV();
              localObject1 = f.j(f.this).erc();
              if (bool1)
              {
                localBundle.putString("result", "not_return");
              }
              else
              {
                localBundle.putString("full_url", bt.nullAsNil(paramAnonymousBundle));
                if ((localObject1 != null) && (((Map)localObject1).size() != 0))
                {
                  localBundle.putInt("set_cookie", 1);
                  com.tencent.xweb.d.kU(aj.getContext());
                  localObject2 = com.tencent.xweb.c.fqC();
                  Iterator localIterator = ((Map)localObject1).keySet().iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    ((com.tencent.xweb.c)localObject2).setCookie(bt.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                  }
                  com.tencent.xweb.d.fqE();
                  com.tencent.xweb.d.sync();
                  ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "cookies:%s", new Object[] { ((com.tencent.xweb.c)localObject2).getCookie(bt.nullAsNil(paramAnonymousBundle)) });
                }
                else
                {
                  localBundle.putInt("set_cookie", 0);
                }
              }
            }
          }
        }
        Object localObject1 = new j();
        ((j)localObject1).dba.context = f.f(f.this);
        ((j)localObject1).dba.actionCode = paramAnonymousInt;
        if (4003 == paramAnonymousInt)
        {
          paramAnonymousBundle = paramAnonymousBundle.getString("apdu");
          ((j)localObject1).dba.dbc = paramAnonymousBundle;
          label700:
          ad.i("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult actionCode: %d", new Object[] { Integer.valueOf(((j)localObject1).dba.actionCode) });
        }
        for (;;)
        {
          try
          {
            paramAnonymousBundle = (NFCIPCHelper.NFCEventTransfer)XIPCInvoker.a("com.tencent.mm:tools", new NFCIPCHelper.NFCEventTransfer((j)localObject1), NFCIPCHelper.a.class);
            if ((paramAnonymousBundle == null) || (paramAnonymousBundle.dbf == null)) {
              continue;
            }
            ((j)localObject1).dbb.dbf = paramAnonymousBundle.dbf;
          }
          catch (Exception paramAnonymousBundle)
          {
            boolean bool2;
            ad.printErrStackTrace("MicroMsg.NFCIPCHelper", paramAnonymousBundle, "alvinluo nfcInvokeAsResult exception", new Object[0]);
            NFCIPCHelper.emy();
            continue;
          }
          if (((j)localObject1).dbb.dbf == null) {
            break;
          }
          localBundle.putAll(((j)localObject1).dbb.dbf);
          break;
          if (4004 != paramAnonymousInt) {
            break label700;
          }
          localObject2 = paramAnonymousBundle.getString("apdus");
          bool1 = paramAnonymousBundle.getBoolean("breakIfFail", true);
          bool2 = paramAnonymousBundle.getBoolean("breakIfTrue", false);
          ((j)localObject1).dba.dbc = ((String)localObject2);
          ((j)localObject1).dba.dbd = bool1;
          ((j)localObject1).dba.dbe = bool2;
          break label700;
          NFCIPCHelper.emy();
        }
      }
    };
    this.kxu = new h.c()
    {
      public final void JL(String paramAnonymousString)
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
          ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "viewCaptureCallback, invoker is null");
          AppMethodBeat.o(21081);
          return;
        }
        catch (RemoteException paramAnonymousString)
        {
          ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "recog failed");
          AppMethodBeat.o(21081);
        }
      }
    };
    this.kxq = paramb;
    this.kxc = ((MMWebViewWithJsApi)paramb.getWebView());
    this.kxd = new b(this.kxc);
    this.kxe = new a(this.kxc);
    this.kxc.setWebViewClient(this.kxd);
    this.kxc.setWebChromeClient(this.kxe);
    this.kxc.setCleanOnDetached(false);
    this.kxs = new ScanCodeSheetItemLogic(getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void beE()
      {
        AppMethodBeat.i(21067);
        if ((f.a(f.this) != null) && (f.a(f.this).HrW.isShowing())) {
          f.b(f.this);
        }
        AppMethodBeat.o(21067);
      }
    });
    this.kxh = new l(getContext());
    this.kxh.a(this.kxc, this, null);
    AppMethodBeat.o(21102);
  }
  
  private boolean a(final ContextMenu paramContextMenu, final String paramString)
  {
    AppMethodBeat.i(21108);
    try
    {
      bool1 = this.kxf.isSDCardAvailable();
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
        ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + localException1.getMessage());
        bool1 = false;
      }
      if (this.kxg == null)
      {
        AppMethodBeat.o(21108);
        return true;
      }
      paramContextMenu.setHeaderTitle(2131766271);
      try
      {
        bool1 = this.kxf.enj();
        bool2 = this.kxg.emS().eBR();
        boolean bool3 = this.kxg.emS().eBS();
        ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((bool1) && (bool2)) {
          paramContextMenu.add(0, 0, 0, getContext().getString(2131762163)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(21076);
              try
              {
                boolean bool = f.o(f.this).isSDCardAvailable();
                x.a(f.f(f.this), f.p(f.this), com.tencent.xweb.c.fqC().getCookie(f.p(f.this)), bool, new x.a()
                {
                  public final void JK(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(21075);
                    if (bt.isNullOrNil(paramAnonymous2String))
                    {
                      ad.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "share image to friend fail, imgPath is null");
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
                  ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
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
                  ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick saveImage2SD with url[%s]", new Object[] { f.p(f.this) });
                  x.b(f.f(f.this), f.p(f.this), com.tencent.xweb.c.fqC().getCookie(f.p(f.this)), bool);
                  AppMethodBeat.o(21077);
                  return true;
                  paramAnonymousMenuItem = paramAnonymousMenuItem;
                  ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                  boolean bool = false;
                }
              }
              catch (Exception paramAnonymousMenuItem)
              {
                for (;;)
                {
                  ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "save to sdcard failed : %s", new Object[] { paramAnonymousMenuItem.getMessage() });
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
                x.a(f.f(f.this), paramAnonymousMenuItem, com.tencent.xweb.c.fqC().getCookie(paramAnonymousMenuItem), bool, new x.a()
                {
                  public final void JK(String paramAnonymous2String)
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
                  ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                }
              }
            }
          });
        }
        this.kxh.HrW.setFooterView(null);
        if (this.kxi != null)
        {
          bool1 = beD();
          bool2 = com.tencent.mm.plugin.scanner.e.bD(this.kxk, this.kxi);
          if ((!bool1) && (!bool2))
          {
            this.kxi = null;
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
          ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", new Object[] { localException2.getMessage() });
          bool1 = false;
        }
        paramContextMenu = this.kxi;
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
              if ((f.a(f.this) != null) && (f.a(f.this).HrW.isShowing())) {
                f.a(f.this).dismiss();
              }
              Object localObject = f.this;
              String str1 = paramContextMenu;
              String str2 = f.e(f.this);
              String str3 = paramString;
              int i = f.this.kxk;
              int j = f.this.kxl;
              if (str1 == null)
              {
                AppMethodBeat.o(21080);
                return;
              }
              paramAnonymousView = new Intent();
              paramAnonymousView.setClass(((f)localObject).getContext(), WebviewScanImageActivity.class);
              paramAnonymousView.putExtra("key_string_for_scan", str1);
              paramAnonymousView.putExtra("key_string_for_url", str2);
              paramAnonymousView.putExtra("key_string_for_image_url", str3);
              paramAnonymousView.putExtra("key_codetype_for_scan", i);
              paramAnonymousView.putExtra("key_codeversion_for_scan", j);
              if ((((f)localObject).kxq != null) && (!bt.isNullOrNil(((f)localObject).kxq.getAppId()))) {
                paramAnonymousView.putExtra("key_string_for_wxapp_id", ((f)localObject).kxq.getAppId());
              }
              localObject = ((f)localObject).getContext();
              paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.adn(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              ((Context)localObject).startActivity((Intent)paramAnonymousView.lS(0));
              com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              AppMethodBeat.o(21080);
            }
          };
          this.kxh.HrW.setFooterView(this.kxs.a(paramContextMenu, this.kxk, this.kxi, 10));
          AppMethodBeat.o(21108);
          return true;
          getContext().getString(2131762857);
        }
        AppMethodBeat.o(21108);
      }
    }
    return false;
  }
  
  private boolean beD()
  {
    AppMethodBeat.i(21110);
    String str = this.kwP;
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
    this.kxd.cleanup();
    a locala = this.kxe;
    while (!locala.Buf.isEmpty()) {
      ((JsResult)locala.Buf.pollFirst()).cancel();
    }
    AppMethodBeat.o(21104);
  }
  
  public final int getBinderID()
  {
    AppMethodBeat.i(174923);
    int i = this.kxd.gQk.hashCode();
    AppMethodBeat.o(174923);
    return i;
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(21103);
    Object localObject = com.tencent.mm.sdk.f.a.iV(this.kxc.getContext());
    if (localObject == null)
    {
      localObject = this.kxc.getContext();
      AppMethodBeat.o(21103);
      return localObject;
    }
    AppMethodBeat.o(21103);
    return localObject;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(21107);
    if (this.kxd.BmE != null) {
      this.kxd.BmE.ti(false);
    }
    AppMethodBeat.o(21107);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(21109);
    boolean bool;
    if ((paramView instanceof android.webkit.WebView))
    {
      paramView = this.kxc.getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(21109);
        return;
      }
      if ((paramView.mType == 5) || (paramView.mType == 8))
      {
        bool = a(paramContextMenu, paramView.mExtra);
        this.kxj = paramView.mExtra;
        if ((!bool) && (this.kxg.emS().eBN()))
        {
          this.kxn = paramView;
          this.kxm = new h();
          this.kxm.a(this.kxc, this.kxu);
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
        this.kxj = paramView.mExtra;
        if ((!bool) && (this.kxg.emS().eBN()))
        {
          this.kxo = paramView;
          this.kxm = new h();
          this.kxm.a(this.kxc, this.kxu);
        }
      }
    }
    AppMethodBeat.o(21109);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(21106);
    if (this.kxd.BmE != null) {
      this.kxd.BmE.ti(true);
    }
    AppMethodBeat.o(21106);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21105);
    ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "notifyKeyboardStateChanged, shown[%b], height[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.webview.c.f localf = this.kxr;
    if (localf != null) {
      if (!paramBoolean) {
        break label57;
      }
    }
    for (;;)
    {
      localf.SG(paramInt);
      AppMethodBeat.o(21105);
      return;
      label57:
      paramInt = 0;
    }
  }
  
  public final void setCurrentUrl(String paramString)
  {
    this.kwP = paramString;
  }
  
  final class a
    extends i
  {
    private a kxC;
    private g.c kxD;
    
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
        ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startFileChooser, invalid context(%s) hash(%d) url(%s)", new Object[] { localObject, Integer.valueOf(f.c(f.this).hashCode()), f.g(f.this).getUrl() });
        AppMethodBeat.o(21087);
        return;
      }
      localObject = (Activity)localObject;
      com.tencent.luggage.h.e.az((Context)localObject).b(new com.tencent.luggage.h.e.b()
      {
        public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(195971);
          boolean bool = f.h(f.this).c(this.val$activity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(195971);
          return bool;
        }
      });
      f.h(f.this).a((Activity)localObject, f.i(f.this), paramValueCallback, paramValueCallback1, paramString1, paramString2);
      AppMethodBeat.o(21087);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(195974);
      if (f.c(f.this).bew())
      {
        if (this.kxC == null) {
          this.kxC = new a((byte)0);
        }
        paramView = this.kxC;
        paramCustomViewCallback = com.tencent.mm.sdk.f.a.iV(f.c(f.this).getPageView().getContext());
        if ((paramCustomViewCallback instanceof com.tencent.mm.plugin.appbrand.s.a.a.a))
        {
          paramView.kxF = ((com.tencent.mm.plugin.appbrand.s.a.a.a)paramCustomViewCallback);
          paramView.kxF.a(paramView);
        }
      }
      paramView = f.c(f.this).getAppId();
      paramCustomViewCallback = new g.c()
      {
        private void leaveFullscreen()
        {
          AppMethodBeat.i(195969);
          f.c(f.this).getWebView().leaveFullscreen();
          AppMethodBeat.o(195969);
        }
        
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(195967);
          if (paramAnonymousd == g.d.iDj) {
            leaveFullscreen();
          }
          AppMethodBeat.o(195967);
        }
        
        public final void aLD()
        {
          AppMethodBeat.i(195968);
          leaveFullscreen();
          AppMethodBeat.o(195968);
        }
      };
      this.kxD = paramCustomViewCallback;
      com.tencent.mm.plugin.appbrand.g.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(195974);
      return false;
    }
    
    public final boolean a(com.tencent.xweb.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, w.a parama)
    {
      AppMethodBeat.i(21086);
      if (parama.getMode() == 0)
      {
        if ((parama.getAcceptTypes() == null) || (parama.getAcceptTypes().length <= 0))
        {
          ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onShowFileChooser, mode = MODE_OPEN, but params.getAcceptTypes is null");
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
    
    public final boolean beF()
    {
      AppMethodBeat.i(195975);
      if (this.kxC != null) {
        this.kxC.uninstall();
      }
      com.tencent.mm.plugin.appbrand.g.b(f.c(f.this).getAppId(), this.kxD);
      f.c(f.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(195970);
          if (f.c(f.this).getPageView().getFullscreenImpl() != null)
          {
            f.c(f.this).getPageView().getFullscreenImpl().aNT();
            com.tencent.mm.plugin.appbrand.page.b.d locald = (com.tencent.mm.plugin.appbrand.page.b.d)f.c(f.this).getPageView().Q(com.tencent.mm.plugin.appbrand.page.b.d.class);
            if (locald != null) {
              locald.a(null);
            }
          }
          AppMethodBeat.o(195970);
        }
      });
      AppMethodBeat.o(195975);
      return false;
    }
    
    public final void d(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(21083);
      super.d(paramWebView, paramString);
      f.c(f.this).JH(paramString);
      AppMethodBeat.o(21083);
    }
    
    public final void onClose()
    {
      AppMethodBeat.i(21084);
      f.c(f.this).bex();
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
      com.tencent.mm.plugin.appbrand.s.a.a.a kxF;
      
      private a() {}
      
      public final boolean sp(int paramInt)
      {
        AppMethodBeat.i(195972);
        if (f.c(f.this).getPageView().getFullscreenImpl() == null)
        {
          AppMethodBeat.o(195972);
          return false;
        }
        uninstall();
        f.c(f.this).getPageView().getFullscreenImpl().qw(d.a.tE(paramInt));
        AppMethodBeat.o(195972);
        return true;
      }
      
      final void uninstall()
      {
        AppMethodBeat.i(195973);
        if (this.kxF != null) {
          this.kxF.b(this);
        }
        AppMethodBeat.o(195973);
      }
    }
  }
  
  final class b
    extends k
  {
    private com.tencent.mm.plugin.webview.ui.tools.c kxG;
    
    b(MMWebView paramMMWebView)
    {
      super();
      AppMethodBeat.i(180295);
      if (f.c(f.this).CZ()) {
        this.Bup = new f.c(f.this, this.cas);
      }
      AppMethodBeat.o(180295);
    }
    
    public final boolean JM(String paramString)
    {
      AppMethodBeat.i(21088);
      if (bt.isNullOrNil(paramString))
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
        if (bt.isNullOrNil(paramString.getHost()))
        {
          AppMethodBeat.o(21088);
          return true;
        }
        if (!paramString.getHost().contains(com.tencent.luggage.h.g.Ep()))
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
    
    public final String JN(String paramString)
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
      AppMethodBeat.i(195978);
      super.a(paramf);
      if ((paramf != null) && (f.c(f.this) != null)) {
        paramf.ARs = f.c(f.this).getAppId();
      }
      f.a(f.this, paramf);
      AppMethodBeat.o(195978);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, com.tencent.mm.plugin.webview.e.g paramg)
    {
      AppMethodBeat.i(195976);
      f.a(f.this, parame);
      f.a(f.this, paramg);
      try
      {
        paramg = new Bundle();
        paramg.putString("key_webview_container_env", "miniProgram");
        Bundle localBundle = new Bundle();
        localBundle.putBundle("jsapiargs", paramg);
        parame.a(20, localBundle, this.gQk.hashCode());
        AppMethodBeat.o(195976);
        return;
      }
      catch (RemoteException parame)
      {
        ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + parame.getMessage());
        AppMethodBeat.o(195976);
      }
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(21100);
      f.c(f.this).r(paramString2, paramInt, paramString1);
      AppMethodBeat.o(21100);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, q paramq, SslError paramSslError)
    {
      AppMethodBeat.i(21093);
      paramWebView = f.e(f.this);
      if (paramWebView == null)
      {
        ad.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "urlStr == null, return");
        AppMethodBeat.o(21093);
        return;
      }
      if (this.kxG == null) {
        this.kxG = new com.tencent.mm.plugin.webview.ui.tools.c(this.cas, this.gQk);
      }
      this.kxG.a(paramWebView, paramq, paramSslError);
      AppMethodBeat.o(21093);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(21094);
      f.a(f.this, paramString);
      f.c(f.this).JI(paramString);
      AppMethodBeat.o(21094);
    }
    
    public final m beG()
    {
      AppMethodBeat.i(21089);
      m localm = f.d(f.this);
      AppMethodBeat.o(21089);
      return localm;
    }
    
    public final int beH()
    {
      AppMethodBeat.i(21096);
      if (f.c(f.this).bez())
      {
        AppMethodBeat.o(21096);
        return 55;
      }
      AppMethodBeat.o(21096);
      return 49;
    }
    
    public final int beI()
    {
      AppMethodBeat.i(21097);
      if (f.c(f.this).bez())
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
      if (this.kxG != null) {
        this.kxG.detach();
      }
      AppMethodBeat.o(21091);
    }
    
    public final void e(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(195977);
      super.e(paramWebView, paramString);
      f.c(f.this).JJ(paramString);
      AppMethodBeat.o(195977);
    }
    
    public final void f(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(21095);
      f.a(f.this, paramString);
      f.c(f.this).bV(paramString);
      AppMethodBeat.o(21095);
    }
    
    public final void g(Bundle paramBundle, String paramString)
    {
      AppMethodBeat.i(21099);
      super.g(paramBundle, paramString);
      paramBundle.putString("geta8key_data_appid", f.c(f.this).getAppId());
      AppMethodBeat.o(21099);
    }
    
    public final boolean uJ(String paramString)
    {
      AppMethodBeat.i(21092);
      if (paramString.startsWith("file:///android_asset"))
      {
        ad.w("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found %s", new Object[] { paramString });
        AppMethodBeat.o(21092);
        return true;
      }
      Object localObject;
      if (paramString.startsWith("tel:"))
      {
        localObject = new Intent("android.intent.action.DIAL");
        ((Intent)localObject).setData(Uri.parse(paramString));
        paramString = this.gQk.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(21092);
        return true;
      }
      if ((paramString.startsWith("sms:")) || (paramString.startsWith("smsto:")))
      {
        localObject = new Intent("android.intent.action.SENDTO");
        ((Intent)localObject).setData(Uri.parse(paramString));
        paramString = this.gQk.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(21092);
        return true;
      }
      if ((URLUtil.isHttpUrl(paramString)) || (URLUtil.isHttpsUrl(paramString)) || (bt.nullAsNil(paramString).startsWith("weixin"))) {}
      for (int i = 1; i == 0; i = 0)
      {
        ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "handleUrlLoading found unacceptable %s", new Object[] { paramString });
        AppMethodBeat.o(21092);
        return true;
      }
      AppMethodBeat.o(21092);
      return false;
    }
  }
  
  final class c
    extends com.tencent.mm.plugin.webview.model.aq
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.z.f
 * JD-Core Version:    0.7.0.1
 */