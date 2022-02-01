package com.tencent.mm.plugin.appbrand.jsapi.webview.a;

import android.content.Context;
import android.content.Intent;
import android.os.RemoteException;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.jsapi.webview.g.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.brandservice.api.c;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.e.a;
import com.tencent.mm.plugin.scanner.k;
import com.tencent.mm.plugin.webview.e.g;
import com.tencent.mm.plugin.webview.k.h.c;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.pluginsdk.ui.tools.aa;
import com.tencent.mm.pluginsdk.ui.tools.aa.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.ao;

final class b
  extends a
  implements View.OnCreateContextMenuListener
{
  private ScanCodeSheetItemLogic rAP;
  private l sLE;
  String sLF;
  private String sLG;
  int sLH;
  int sLI;
  com.tencent.mm.plugin.webview.k.h sLJ;
  WebView.b sLK;
  WebView.b sLL;
  private h.c sLQ;
  
  b(g.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(327544);
    this.sLQ = new h.c()
    {
      public final void acB(String paramAnonymousString)
      {
        AppMethodBeat.i(327529);
        try
        {
          if (b.this.sLC != null)
          {
            b.this.sLC.a(paramAnonymousString, new int[] { 3 }, 0, 0);
            AppMethodBeat.o(327529);
            return;
          }
          Log.i("MicroMsg.AppBrand.HTMLViewScanHelper", "viewCaptureCallback, invoker is null");
          AppMethodBeat.o(327529);
          return;
        }
        catch (RemoteException paramAnonymousString)
        {
          Log.e("MicroMsg.AppBrand.HTMLViewScanHelper", "recog failed");
          AppMethodBeat.o(327529);
        }
      }
    };
    this.rAP = new ScanCodeSheetItemLogic(getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void onFetchedCodeInfo()
      {
        AppMethodBeat.i(327520);
        if ((b.a(b.this) != null) && (b.a(b.this).afJj.isShowing())) {
          b.b(b.this);
        }
        AppMethodBeat.o(327520);
      }
    });
    try
    {
      cxR();
      AppMethodBeat.o(327544);
      return;
    }
    catch (Exception paramc)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.HTMLViewScanHelper", paramc, "<init> initMenu() get exception", new Object[0]);
      this.sLE = null;
      AppMethodBeat.o(327544);
    }
  }
  
  private void cxQ()
  {
    AppMethodBeat.i(327550);
    this.sLN.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(327521);
        b.a(b.this).a(b.this.ooz, new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(327508);
            b.this.a(paramAnonymous2ContextMenu, b.this.sLF);
            AppMethodBeat.o(327508);
          }
        }, null, new f.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(327507);
            b.d(b.this);
            b.e(b.this);
            b.f(b.this).onDismiss();
            if ((b.this.sLJ != null) && (b.this.sLC != null)) {
              try
              {
                b.this.sLC.blv(b.this.sLJ.XsV);
                b.this.sLJ.iCR();
                AppMethodBeat.o(327507);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.AppBrand.HTMLViewScanHelper", "cancel capture failed");
              }
            }
            AppMethodBeat.o(327507);
          }
        });
        AppMethodBeat.o(327521);
      }
    });
    AppMethodBeat.o(327550);
  }
  
  private void cxR()
  {
    AppMethodBeat.i(327557);
    this.sLE = new l(getContext());
    this.sLE.a(this.sLN.getWebView(), this, null);
    AppMethodBeat.o(327557);
  }
  
  private String getCurrentUrl()
  {
    AppMethodBeat.i(327563);
    String str = ((d)this.sLN.getController()).getCurrentUrl();
    AppMethodBeat.o(327563);
    return str;
  }
  
  final boolean a(ContextMenu paramContextMenu, final String paramString)
  {
    AppMethodBeat.i(327645);
    try
    {
      bool1 = this.sLC.isSDCardAvailable();
      if (!bool1)
      {
        AppMethodBeat.o(327645);
        return true;
      }
    }
    catch (Exception localException1)
    {
      boolean bool1;
      for (;;)
      {
        Log.e("MicroMsg.AppBrand.HTMLViewScanHelper", "onCreateContextMenu fail, ex = " + localException1.getMessage());
        bool1 = false;
      }
      if (this.sLD == null)
      {
        AppMethodBeat.o(327645);
        return true;
      }
      paramContextMenu.setHeaderTitle(ba.i.wv_image);
      try
      {
        bool1 = this.sLC.iwU();
        boolean bool2 = this.sLD.iwp().iPR();
        boolean bool3 = this.sLD.iwp().iPS();
        Log.i("MicroMsg.AppBrand.HTMLViewScanHelper", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((bool1) && (bool2)) {
          paramContextMenu.add(0, 0, 0, getContext().getString(ba.i.readerapp_alert_retransmit)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(327532);
              try
              {
                boolean bool = b.this.sLC.isSDCardAvailable();
                aa.a(b.this.getContext(), b.g(b.this), ao.getCookie(b.g(b.this)), bool, new aa.a()
                {
                  public final void acA(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(327590);
                    if (Util.isNullOrNil(paramAnonymous2String))
                    {
                      Log.w("MicroMsg.AppBrand.HTMLViewScanHelper", "share image to friend fail, imgPath is null");
                      AppMethodBeat.o(327590);
                      return;
                    }
                    b.a(b.this, paramAnonymous2String);
                    AppMethodBeat.o(327590);
                  }
                });
                AppMethodBeat.o(327532);
                return true;
              }
              catch (Exception paramAnonymousMenuItem)
              {
                for (;;)
                {
                  Log.e("MicroMsg.AppBrand.HTMLViewScanHelper", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                }
              }
            }
          });
        }
        paramContextMenu.add(0, 0, 0, getContext().getString(ba.i.save_to_local)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(327538);
            try
            {
              bool = b.this.sLC.isSDCardAvailable();
            }
            catch (Exception paramAnonymousMenuItem)
            {
              try
              {
                for (;;)
                {
                  Log.i("MicroMsg.AppBrand.HTMLViewScanHelper", "onMenuItemClick saveImage2SD with url[%s]", new Object[] { b.g(b.this) });
                  aa.b(b.this.getContext(), b.g(b.this), ao.getCookie(b.g(b.this)), bool);
                  AppMethodBeat.o(327538);
                  return true;
                  paramAnonymousMenuItem = paramAnonymousMenuItem;
                  Log.e("MicroMsg.AppBrand.HTMLViewScanHelper", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                  boolean bool = false;
                }
              }
              catch (Exception paramAnonymousMenuItem)
              {
                for (;;)
                {
                  Log.e("MicroMsg.AppBrand.HTMLViewScanHelper", "save to sdcard failed : %s", new Object[] { paramAnonymousMenuItem.getMessage() });
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
              AppMethodBeat.i(327528);
              try
              {
                boolean bool = b.this.sLC.isSDCardAvailable();
                paramAnonymousMenuItem = b.g(b.this).replaceAll("tp=webp", "");
                aa.a(b.this.getContext(), paramAnonymousMenuItem, ao.getCookie(paramAnonymousMenuItem), bool, new aa.a()
                {
                  public final void acA(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(327552);
                    b.b(b.this, paramAnonymous2String);
                    AppMethodBeat.o(327552);
                  }
                });
                AppMethodBeat.o(327528);
                return true;
              }
              catch (Exception paramAnonymousMenuItem)
              {
                for (;;)
                {
                  Log.e("MicroMsg.AppBrand.HTMLViewScanHelper", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
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
              AppMethodBeat.i(327531);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLViewScanHelper$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if ((b.a(b.this) != null) && (b.a(b.this).afJj.isShowing())) {
                b.a(b.this).dismiss();
              }
              b.this.e(this.sLW, b.h(b.this), paramString, b.this.sLH, b.this.sLI);
              paramAnonymousView = com.tencent.mm.plugin.appbrand.jsapi.webview.e.sLq;
              com.tencent.mm.plugin.appbrand.jsapi.webview.e.a(b.this.sLN.getPageView(), true, b.this.sLH, b.c(b.this), true, b.h(b.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLViewScanHelper$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(327531);
            }
          };
          this.sLE.afJj.setFooterView(this.rAP.a(paramContextMenu, this.sLH, this.sLF, 10));
          paramContextMenu = com.tencent.mm.plugin.appbrand.jsapi.webview.e.sLq;
          com.tencent.mm.plugin.appbrand.jsapi.webview.e.a(this.sLN.getPageView(), true, this.sLH, this.sLF, false, getCurrentUrl());
          AppMethodBeat.o(327645);
          return true;
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.AppBrand.HTMLViewScanHelper", "get has setuin failed : %s", new Object[] { localException2.getMessage() });
          bool1 = false;
        }
        AppMethodBeat.o(327645);
      }
    }
    return false;
  }
  
  /* Error */
  protected final void bm(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 343
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 345	com/tencent/mm/plugin/appbrand/jsapi/webview/a/a:bm	(Landroid/content/Context;)V
    //   11: aload_0
    //   12: getfield 75	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:rAP	Lcom/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic;
    //   15: aload_1
    //   16: putfield 349	com/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic:mContext	Landroid/content/Context;
    //   19: aload_0
    //   20: getfield 96	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:sLE	Lcom/tencent/mm/ui/tools/l;
    //   23: ifnull +15 -> 38
    //   26: aload_0
    //   27: getfield 96	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:sLE	Lcom/tencent/mm/ui/tools/l;
    //   30: invokevirtual 352	com/tencent/mm/ui/tools/l:dismiss	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 96	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:sLE	Lcom/tencent/mm/ui/tools/l;
    //   38: aload_1
    //   39: instanceof 354
    //   42: ifeq +7 -> 49
    //   45: aload_0
    //   46: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:cxR	()V
    //   49: ldc_w 343
    //   52: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: astore_2
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 96	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:sLE	Lcom/tencent/mm/ui/tools/l;
    //   62: goto -24 -> 38
    //   65: astore_1
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 96	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:sLE	Lcom/tencent/mm/ui/tools/l;
    //   71: ldc_w 343
    //   74: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: aload_1
    //   78: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	79	0	this	b
    //   0	79	1	paramContext	Context
    //   56	1	2	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   26	33	56	java/lang/Exception
    //   26	33	65	finally
  }
  
  public final void e(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(327637);
    if (paramString1 == null)
    {
      AppMethodBeat.o(327637);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(getContext(), WebviewScanImageActivity.class);
    localIntent.putExtra("key_string_for_scan", paramString1);
    localIntent.putExtra("key_string_for_url", paramString2);
    localIntent.putExtra("key_string_for_image_url", paramString3);
    localIntent.putExtra("key_codetype_for_scan", paramInt1);
    localIntent.putExtra("key_codeversion_for_scan", paramInt2);
    if ((this.sLN != null) && (!Util.isNullOrNil(this.sLN.getAppId()))) {
      localIntent.putExtra("key_string_for_wxapp_id", this.sLN.getAppId());
    }
    localIntent.putExtra("geta8key_scene", 44);
    if ((this.sLN != null) && (this.sLN.getPageView() != null)) {
      localIntent.putExtra("wxappPathWithQuery", this.sLN.getPageView().cEE());
    }
    paramString1 = getContext();
    paramString2 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aYi(), "com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLViewScanHelper", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString1.startActivity((Intent)paramString2.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLViewScanHelper", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(327637);
  }
  
  public final void f(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(327631);
    Log.d("MicroMsg.AppBrand.HTMLViewScanHelper", "result: ".concat(String.valueOf(paramString2)));
    if ((this.sLJ == null) || (paramString1 == null) || (!paramString1.equals(this.sLJ.XsV)))
    {
      AppMethodBeat.o(327631);
      return;
    }
    if (!k.e(paramInt1, paramString2, ((c)com.tencent.mm.kernel.h.ax(c.class)).aiy(getCurrentUrl()), this.sLN.aqJ()))
    {
      paramString1 = com.tencent.mm.plugin.appbrand.jsapi.webview.e.sLq;
      com.tencent.mm.plugin.appbrand.jsapi.webview.e.a(this.sLN.getPageView(), false, paramInt1, paramString2, false, getCurrentUrl());
      this.sLF = null;
      AppMethodBeat.o(327631);
      return;
    }
    if (this.sLJ != null) {
      this.sLJ.iCR();
    }
    this.sLH = paramInt1;
    this.sLI = paramInt2;
    if ((paramString2 == null) || (this.sLE == null))
    {
      AppMethodBeat.o(327631);
      return;
    }
    if (Util.isNullOrNil(paramString2)) {
      Log.w("MicroMsg.AppBrand.HTMLViewScanHelper", "processGetWXACodeNickName mResultOfImageUrl nil");
    }
    for (;;)
    {
      this.sLF = paramString2;
      if ((this.sLE != null) && (this.sLE.afJj.isShowing())) {
        cxQ();
      }
      AppMethodBeat.o(327631);
      return;
      if (k.cU(this.sLH, paramString2))
      {
        Log.i("MicroMsg.AppBrand.HTMLViewScanHelper", "processGetWXACodeNickName");
        this.rAP.c(this.sLH, e.a.lE(paramString2, getCurrentUrl()));
      }
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(327651);
    boolean bool;
    if ((paramView instanceof WebView))
    {
      paramView = this.ooz.getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(327651);
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
          this.sLJ.a(this.ooz, this.sLQ);
        }
      }
      AppMethodBeat.o(327651);
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      paramView = ((MMWebView)paramView).getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(327651);
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
          this.sLJ.a(this.ooz, this.sLQ);
        }
      }
    }
    AppMethodBeat.o(327651);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.b
 * JD-Core Version:    0.7.0.1
 */