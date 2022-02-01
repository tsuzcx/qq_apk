package com.tencent.mm.plugin.appbrand.jsapi.ab;

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
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.j;
import com.tencent.mm.g.a.j.a;
import com.tencent.mm.g.a.j.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ipcinvoker.extension.XIPCInvoker;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.g.d;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.r.a.a.a.a;
import com.tencent.mm.plugin.appbrand.r.a.d.a;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.webview.model.ar;
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
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
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
  int lvA;
  int lvB;
  h lvC;
  WebView.b lvD;
  WebView.b lvE;
  private final com.tencent.mm.plugin.webview.modeltools.d lvF;
  final e.c lvG;
  private com.tencent.mm.plugin.webview.c.f lvH;
  ScanCodeSheetItemLogic lvI;
  private m lvJ;
  private h.c lvK;
  private String lve;
  private MMWebViewWithJsApi lvs;
  private b lvt;
  private a lvu;
  private com.tencent.mm.plugin.webview.stub.e lvv;
  private com.tencent.mm.plugin.webview.e.g lvw;
  private l lvx;
  private String lvy;
  private String lvz;
  
  public f(e.c paramc)
  {
    AppMethodBeat.i(21102);
    this.lvF = new com.tencent.mm.plugin.webview.modeltools.d();
    this.lvJ = new m()
    {
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(21071);
        ad.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "result: ".concat(String.valueOf(paramAnonymousString2)));
        if ((f.this.lvC == null) || (paramAnonymousString1 == null) || (!paramAnonymousString1.equals(f.this.lvC.DWh)))
        {
          AppMethodBeat.o(21071);
          return;
        }
        if ((!f.k(f.this)) && (paramAnonymousInt1 != 22))
        {
          AppMethodBeat.o(21071);
          return;
        }
        if (f.this.lvC != null) {
          f.this.lvC.eQZ();
        }
        f.this.lvA = paramAnonymousInt1;
        f.this.lvB = paramAnonymousInt2;
        if ((paramAnonymousString2 == null) || (f.a(f.this) == null))
        {
          AppMethodBeat.o(21071);
          return;
        }
        f.b(f.this, paramAnonymousString2);
        f.c(f.this, paramAnonymousString2);
        if ((f.a(f.this) != null) && (f.a(f.this).KJx.isShowing())) {
          f.b(f.this);
        }
        AppMethodBeat.o(21071);
      }
      
      public final boolean g(int paramAnonymousInt, final Bundle paramAnonymousBundle)
      {
        AppMethodBeat.i(21069);
        if (paramAnonymousInt == 110001) {
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(21068);
              f localf = f.this;
              Object localObject = paramAnonymousBundle;
              ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onFetchQrCodeResp");
              int i = ((Bundle)localObject).getInt("key_resp_ret", -1);
              localObject = ((Bundle)localObject).getByteArray("key_resp_item_bytes");
              localf.lvI.q(i, (byte[])localObject);
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
            localObject2 = com.tencent.mm.sdk.f.a.jq(f.f(f.this));
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
              localBundle.putInt("getA8KeyScene", eLx());
              localBundle.putString("url", f.e(f.this));
              continue;
              bool1 = f.j(f.this).eVv();
              paramAnonymousBundle = f.j(f.this).ePh();
              localObject1 = f.j(f.this).eVw();
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
                  com.tencent.xweb.d.lv(aj.getContext());
                  localObject2 = com.tencent.xweb.c.gaw();
                  Iterator localIterator = ((Map)localObject1).keySet().iterator();
                  while (localIterator.hasNext())
                  {
                    String str = (String)localIterator.next();
                    ((com.tencent.xweb.c)localObject2).setCookie(bt.nullAsNil(paramAnonymousBundle), str + "=" + (String)((Map)localObject1).get(str));
                  }
                  com.tencent.xweb.d.gay();
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
        ((j)localObject1).djO.context = f.f(f.this);
        ((j)localObject1).djO.actionCode = paramAnonymousInt;
        if (4003 == paramAnonymousInt)
        {
          paramAnonymousBundle = paramAnonymousBundle.getString("apdu");
          ((j)localObject1).djO.djQ = paramAnonymousBundle;
          label700:
          ad.i("MicroMsg.NFCIPCHelper", "alvinluo nfcInvokeAsResult actionCode: %d", new Object[] { Integer.valueOf(((j)localObject1).djO.actionCode) });
        }
        for (;;)
        {
          try
          {
            paramAnonymousBundle = (NFCIPCHelper.NFCEventTransfer)XIPCInvoker.a("com.tencent.mm:tools", new NFCIPCHelper.NFCEventTransfer((j)localObject1), NFCIPCHelper.a.class);
            if ((paramAnonymousBundle == null) || (paramAnonymousBundle.djT == null)) {
              continue;
            }
            ((j)localObject1).djP.djT = paramAnonymousBundle.djT;
          }
          catch (Exception paramAnonymousBundle)
          {
            boolean bool2;
            ad.printErrStackTrace("MicroMsg.NFCIPCHelper", paramAnonymousBundle, "alvinluo nfcInvokeAsResult exception", new Object[0]);
            NFCIPCHelper.eQN();
            continue;
          }
          if (((j)localObject1).djP.djT == null) {
            break;
          }
          localBundle.putAll(((j)localObject1).djP.djT);
          break;
          if (4004 != paramAnonymousInt) {
            break label700;
          }
          localObject2 = paramAnonymousBundle.getString("apdus");
          bool1 = paramAnonymousBundle.getBoolean("breakIfFail", true);
          bool2 = paramAnonymousBundle.getBoolean("breakIfTrue", false);
          ((j)localObject1).djO.djQ = ((String)localObject2);
          ((j)localObject1).djO.djR = bool1;
          ((j)localObject1).djO.djS = bool2;
          break label700;
          NFCIPCHelper.eQN();
        }
      }
    };
    this.lvK = new h.c()
    {
      public final void Rr(String paramAnonymousString)
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
    this.lvG = paramc;
    this.lvs = ((MMWebViewWithJsApi)paramc.getWebView());
    this.lvt = new b(this.lvs);
    this.lvu = new a(this.lvs);
    this.lvs.setWebViewClient(this.lvt);
    this.lvs.setWebChromeClient(this.lvu);
    this.lvs.setCleanOnDetached(false);
    this.lvI = new ScanCodeSheetItemLogic(getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bpj()
      {
        AppMethodBeat.i(21067);
        if ((f.a(f.this) != null) && (f.a(f.this).KJx.isShowing())) {
          f.b(f.this);
        }
        AppMethodBeat.o(21067);
      }
    });
    this.lvx = new l(getContext());
    this.lvx.a(this.lvs, this, null);
    AppMethodBeat.o(21102);
  }
  
  private boolean a(final ContextMenu paramContextMenu, final String paramString)
  {
    AppMethodBeat.i(21108);
    try
    {
      bool1 = this.lvv.isSDCardAvailable();
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
      if (this.lvw == null)
      {
        AppMethodBeat.o(21108);
        return true;
      }
      paramContextMenu.setHeaderTitle(2131766271);
      try
      {
        bool1 = this.lvv.eRt();
        bool2 = this.lvw.eRh().fgq();
        boolean bool3 = this.lvw.eRh().fgr();
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
                x.a(f.f(f.this), f.p(f.this), com.tencent.xweb.c.gaw().getCookie(f.p(f.this)), bool, new com.tencent.mm.pluginsdk.ui.tools.x.a()
                {
                  public final void Rq(String paramAnonymous2String)
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
                  x.b(f.f(f.this), f.p(f.this), com.tencent.xweb.c.gaw().getCookie(f.p(f.this)), bool);
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
                x.a(f.f(f.this), paramAnonymousMenuItem, com.tencent.xweb.c.gaw().getCookie(paramAnonymousMenuItem), bool, new com.tencent.mm.pluginsdk.ui.tools.x.a()
                {
                  public final void Rq(String paramAnonymous2String)
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
        this.lvx.KJx.setFooterView(null);
        if (this.lvy != null)
        {
          bool1 = bpi();
          bool2 = com.tencent.mm.plugin.scanner.f.bM(this.lvA, this.lvy);
          if ((!bool1) && (!bool2))
          {
            this.lvy = null;
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
        paramContextMenu = this.lvy;
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
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
              if ((f.a(f.this) != null) && (f.a(f.this).KJx.isShowing())) {
                f.a(f.this).dismiss();
              }
              localObject = f.this;
              String str1 = paramContextMenu;
              String str2 = f.e(f.this);
              String str3 = paramString;
              int i = f.this.lvA;
              int j = f.this.lvB;
              if (str1 != null)
              {
                paramAnonymousView = new Intent();
                paramAnonymousView.setClass(((f)localObject).getContext(), WebviewScanImageActivity.class);
                paramAnonymousView.putExtra("key_string_for_scan", str1);
                paramAnonymousView.putExtra("key_string_for_url", str2);
                paramAnonymousView.putExtra("key_string_for_image_url", str3);
                paramAnonymousView.putExtra("key_codetype_for_scan", i);
                paramAnonymousView.putExtra("key_codeversion_for_scan", j);
                if ((((f)localObject).lvG != null) && (!bt.isNullOrNil(((f)localObject).lvG.getAppId()))) {
                  paramAnonymousView.putExtra("key_string_for_wxapp_id", ((f)localObject).lvG.getAppId());
                }
                localObject = ((f)localObject).getContext();
                paramAnonymousView = new com.tencent.mm.hellhoundlib.b.a().bc(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.a(localObject, paramAnonymousView.ahp(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                ((Context)localObject).startActivity((Intent)paramAnonymousView.mq(0));
                com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(21080);
            }
          };
          this.lvx.KJx.setFooterView(this.lvI.a(paramContextMenu, this.lvA, this.lvy, 10));
          AppMethodBeat.o(21108);
          return true;
          getContext().getString(2131762857);
        }
        AppMethodBeat.o(21108);
      }
    }
    return false;
  }
  
  private boolean bpi()
  {
    AppMethodBeat.i(21110);
    String str = this.lve;
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
    this.lvt.cleanup();
    a locala = this.lvu;
    while (!locala.Eqo.isEmpty()) {
      ((JsResult)locala.Eqo.pollFirst()).cancel();
    }
    AppMethodBeat.o(21104);
  }
  
  public final int getBinderID()
  {
    AppMethodBeat.i(174923);
    int i = this.lvt.hJc.hashCode();
    AppMethodBeat.o(174923);
    return i;
  }
  
  final Context getContext()
  {
    AppMethodBeat.i(21103);
    Object localObject = com.tencent.mm.sdk.f.a.jq(this.lvs.getContext());
    if (localObject == null)
    {
      localObject = this.lvs.getContext();
      AppMethodBeat.o(21103);
      return localObject;
    }
    AppMethodBeat.o(21103);
    return localObject;
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(21107);
    if (this.lvt.Eiv != null) {
      this.lvt.Eiv.uY(false);
    }
    AppMethodBeat.o(21107);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(21109);
    boolean bool;
    if ((paramView instanceof android.webkit.WebView))
    {
      paramView = this.lvs.getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(21109);
        return;
      }
      if ((paramView.mType == 5) || (paramView.mType == 8))
      {
        bool = a(paramContextMenu, paramView.mExtra);
        this.lvz = paramView.mExtra;
        if ((!bool) && (this.lvw.eRh().fgm()))
        {
          this.lvD = paramView;
          this.lvC = new h();
          this.lvC.a(this.lvs, this.lvK);
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
        this.lvz = paramView.mExtra;
        if ((!bool) && (this.lvw.eRh().fgm()))
        {
          this.lvE = paramView;
          this.lvC = new h();
          this.lvC.a(this.lvs, this.lvK);
        }
      }
    }
    AppMethodBeat.o(21109);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(21106);
    if (this.lvt.Eiv != null) {
      this.lvt.Eiv.uY(true);
    }
    AppMethodBeat.o(21106);
  }
  
  public final void s(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(21105);
    ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "notifyKeyboardStateChanged, shown[%b], height[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.webview.c.f localf = this.lvH;
    if (localf != null) {
      if (!paramBoolean) {
        break label57;
      }
    }
    for (;;)
    {
      localf.WF(paramInt);
      AppMethodBeat.o(21105);
      return;
      label57:
      paramInt = 0;
    }
  }
  
  public final void setCurrentUrl(String paramString)
  {
    this.lve = paramString;
  }
  
  final class a
    extends i
  {
    private a lvS;
    private g.c lvT;
    
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
      com.tencent.luggage.h.e.aA((Context)localObject).b(new com.tencent.luggage.h.e.c()
      {
        public final boolean b(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(188560);
          boolean bool = f.h(f.this).c(this.val$activity, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousIntent);
          AppMethodBeat.o(188560);
          return bool;
        }
      });
      f.h(f.this).a((Activity)localObject, f.i(f.this), paramValueCallback, paramValueCallback1, paramString1, paramString2);
      AppMethodBeat.o(21087);
    }
    
    public final boolean a(View paramView, WebChromeClient.CustomViewCallback paramCustomViewCallback)
    {
      AppMethodBeat.i(188563);
      if (f.c(f.this).bpb())
      {
        if (this.lvS == null) {
          this.lvS = new a((byte)0);
        }
        paramView = this.lvS;
        paramCustomViewCallback = com.tencent.mm.sdk.f.a.jq(f.c(f.this).getPageView().getContext());
        if ((paramCustomViewCallback instanceof com.tencent.mm.plugin.appbrand.r.a.a.a))
        {
          paramView.lvV = ((com.tencent.mm.plugin.appbrand.r.a.a.a)paramCustomViewCallback);
          paramView.lvV.a(paramView);
        }
      }
      paramView = f.c(f.this).getAppId();
      paramCustomViewCallback = new g.c()
      {
        private void leaveFullscreen()
        {
          AppMethodBeat.i(188558);
          f.c(f.this).getWebView().leaveFullscreen();
          AppMethodBeat.o(188558);
        }
        
        public final void a(g.d paramAnonymousd)
        {
          AppMethodBeat.i(188556);
          if (paramAnonymousd == g.d.jws) {
            leaveFullscreen();
          }
          AppMethodBeat.o(188556);
        }
        
        public final void aVG()
        {
          AppMethodBeat.i(188557);
          leaveFullscreen();
          AppMethodBeat.o(188557);
        }
      };
      this.lvT = paramCustomViewCallback;
      com.tencent.mm.plugin.appbrand.g.a(paramView, paramCustomViewCallback);
      AppMethodBeat.o(188563);
      return false;
    }
    
    public final boolean a(com.tencent.xweb.WebView paramWebView, ValueCallback<Uri[]> paramValueCallback, com.tencent.xweb.x.a parama)
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
    
    public final boolean bpk()
    {
      AppMethodBeat.i(188564);
      if (this.lvS != null) {
        this.lvS.uninstall();
      }
      com.tencent.mm.plugin.appbrand.g.b(f.c(f.this).getAppId(), this.lvT);
      f.c(f.this).post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(188559);
          if (f.c(f.this).getPageView().getFullscreenImpl() != null)
          {
            f.c(f.this).getPageView().getFullscreenImpl().aXV();
            com.tencent.mm.plugin.appbrand.page.b.d locald = (com.tencent.mm.plugin.appbrand.page.b.d)f.c(f.this).getPageView().Q(com.tencent.mm.plugin.appbrand.page.b.d.class);
            if (locald != null) {
              locald.a(null);
            }
          }
          AppMethodBeat.o(188559);
        }
      });
      AppMethodBeat.o(188564);
      return false;
    }
    
    public final void d(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(21083);
      super.d(paramWebView, paramString);
      f.c(f.this).Rn(paramString);
      AppMethodBeat.o(21083);
    }
    
    public final void onClose()
    {
      AppMethodBeat.i(21084);
      f.c(f.this).bpc();
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
      com.tencent.mm.plugin.appbrand.r.a.a.a lvV;
      
      private a() {}
      
      public final boolean tJ(int paramInt)
      {
        AppMethodBeat.i(188561);
        if (f.c(f.this).getPageView().getFullscreenImpl() == null)
        {
          AppMethodBeat.o(188561);
          return false;
        }
        uninstall();
        f.c(f.this).getPageView().getFullscreenImpl().rK(d.a.va(paramInt));
        AppMethodBeat.o(188561);
        return true;
      }
      
      final void uninstall()
      {
        AppMethodBeat.i(188562);
        if (this.lvV != null) {
          this.lvV.b(this);
        }
        AppMethodBeat.o(188562);
      }
    }
  }
  
  final class b
    extends k
  {
    private com.tencent.mm.plugin.webview.ui.tools.c lvW;
    
    b(MMWebView paramMMWebView)
    {
      super();
      AppMethodBeat.i(180295);
      if (f.c(f.this).Eb()) {
        this.Eqy = new f.c(f.this, this.chM);
      }
      AppMethodBeat.o(180295);
    }
    
    public final boolean BO(String paramString)
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
        paramString = this.hJc.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramString, "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(21092);
        return true;
      }
      if ((paramString.startsWith("sms:")) || (paramString.startsWith("smsto:")))
      {
        localObject = new Intent("android.intent.action.SENDTO");
        ((Intent)localObject).setData(Uri.parse(paramString));
        paramString = this.hJc.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramString, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/appbrand/jsapi/webview/HTMLWebViewLogicDelegate$HTMLWebViewClient", "handleUrlLoading", "(Ljava/lang/String;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramString.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
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
    
    public final boolean Rs(String paramString)
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
        if (!paramString.getHost().contains(com.tencent.luggage.h.g.Fs()))
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
    
    public final String Rt(String paramString)
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
      AppMethodBeat.i(188569);
      super.a(paramf);
      if ((paramf != null) && (f.c(f.this) != null)) {
        paramf.DMJ = f.c(f.this).getAppId();
      }
      f.a(f.this, paramf);
      AppMethodBeat.o(188569);
    }
    
    public final void a(com.tencent.mm.plugin.webview.stub.e parame, com.tencent.mm.plugin.webview.e.g paramg)
    {
      AppMethodBeat.i(188565);
      f.a(f.this, parame);
      f.a(f.this, paramg);
      try
      {
        paramg = new Bundle();
        paramg.putString("key_webview_container_env", "miniProgram");
        Bundle localBundle = new Bundle();
        localBundle.putBundle("jsapiargs", paramg);
        parame.a(20, localBundle, this.hJc.hashCode());
        AppMethodBeat.o(188565);
        return;
      }
      catch (RemoteException parame)
      {
        ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onServiceConnected, invoke AC_SET_INITIAL_ARGS, ex = " + parame.getMessage());
        AppMethodBeat.o(188565);
      }
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      AppMethodBeat.i(21100);
      f.c(f.this).s(paramString2, paramInt, paramString1);
      AppMethodBeat.o(21100);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, r paramr, SslError paramSslError)
    {
      AppMethodBeat.i(21093);
      paramWebView = f.e(f.this);
      if (paramWebView == null)
      {
        ad.d("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "urlStr == null, return");
        AppMethodBeat.o(21093);
        return;
      }
      if (this.lvW == null) {
        this.lvW = new com.tencent.mm.plugin.webview.ui.tools.c(this.chM, this.hJc);
      }
      this.lvW.a(paramWebView, paramr, paramSslError);
      AppMethodBeat.o(21093);
    }
    
    public final void a(com.tencent.xweb.WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      AppMethodBeat.i(21094);
      f.a(f.this, paramString);
      f.c(f.this).Ro(paramString);
      AppMethodBeat.o(21094);
    }
    
    public final boolean a(com.tencent.xweb.WebView paramWebView, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(188566);
      ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "doUpdateVisitedHistory, view.url[%s], updatedUrl[%s], isReload[%b]", new Object[] { paramWebView.getUrl(), paramString, Boolean.valueOf(paramBoolean) });
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
        AppMethodBeat.o(188566);
        return true;
        if (bt.nullAsNil(str2).startsWith("file:///android_asset/"))
        {
          localLinkedList.add(new IDKey(1097, 3, 1));
          localLinkedList.add(new IDKey(1097, 5, 1));
        }
        else if (!URLUtil.isNetworkUrl(str2))
        {
          localLinkedList.add(new IDKey(1097, 5, 1));
        }
      }
      if (bt.nullAsNil(paramString).startsWith("file:///android_asset/"))
      {
        paramWebView = new LinkedList();
        paramWebView.add(new IDKey(1097, 4, 1));
        paramWebView.add(new IDKey(1097, 6, 1));
        f.c(f.this).getReporter().C(new ArrayList(paramWebView));
        AppMethodBeat.o(188566);
        return true;
      }
      if (!URLUtil.isNetworkUrl(paramString))
      {
        f.c(f.this).getReporter().tH(6);
        str1 = paramWebView.getUrl();
      }
      if (this.Eqt) {
        at(str1, false);
      }
      for (;;)
      {
        AppMethodBeat.o(188566);
        return true;
        if ((this.DMC != null) && (!this.DMC.has(str1)))
        {
          ad.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "doUpdateVisitedHistory start geta8key, url = %s", new Object[] { str1 });
          at(str1, false);
        }
      }
    }
    
    public final void at(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(188567);
      LinkedList localLinkedList = new LinkedList();
      if (URLUtil.isAboutUrl(paramString))
      {
        localLinkedList.add(new IDKey(1097, 12, 1));
        localLinkedList.add(new IDKey(1097, 14, 1));
        if (localLinkedList.size() <= 0) {
          break label217;
        }
        f.c(f.this).getReporter().C(new ArrayList(localLinkedList));
        ad.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "startGetA8Key with invalid url[%s], force[%b]", new Object[] { paramString, Boolean.valueOf(paramBoolean) });
      }
      for (;;)
      {
        super.at(paramString, paramBoolean);
        AppMethodBeat.o(188567);
        return;
        if (bt.nullAsNil(paramString).startsWith("file:///android_asset/"))
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
        f.c(f.this).getReporter().tH(11);
      }
    }
    
    public final m bpl()
    {
      AppMethodBeat.i(21089);
      m localm = f.d(f.this);
      AppMethodBeat.o(21089);
      return localm;
    }
    
    public final int bpm()
    {
      AppMethodBeat.i(21096);
      if (f.c(f.this).bpe())
      {
        AppMethodBeat.o(21096);
        return 55;
      }
      AppMethodBeat.o(21096);
      return 49;
    }
    
    public final int bpn()
    {
      AppMethodBeat.i(21097);
      if (f.c(f.this).bpe())
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
      if (this.lvW != null) {
        this.lvW.detach();
      }
      AppMethodBeat.o(21091);
    }
    
    public final void e(com.tencent.xweb.WebView paramWebView, String paramString)
    {
      AppMethodBeat.i(188568);
      super.e(paramWebView, paramString);
      f.c(f.this).Rp(paramString);
      AppMethodBeat.o(188568);
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
      f.c(f.this).cE(paramString);
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ab.f
 * JD-Core Version:    0.7.0.1
 */