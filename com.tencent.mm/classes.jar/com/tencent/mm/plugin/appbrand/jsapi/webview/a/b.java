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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic;
import com.tencent.mm.plugin.scanner.ScanCodeSheetItemLogic.a;
import com.tencent.mm.plugin.scanner.k;
import com.tencent.mm.plugin.webview.stub.WebviewScanImageActivity;
import com.tencent.mm.pluginsdk.ui.tools.ab;
import com.tencent.mm.pluginsdk.ui.tools.ab.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.m;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.mm.ui.widget.a.e.b;
import com.tencent.xweb.WebView.b;

final class b
  extends a
  implements View.OnCreateContextMenuListener
{
  private ScanCodeSheetItemLogic oxq;
  private m pGE;
  String pGF;
  private String pGG;
  int pGH;
  int pGI;
  com.tencent.mm.plugin.webview.modeltools.g pGJ;
  WebView.b pGK;
  WebView.b pGL;
  private com.tencent.mm.plugin.webview.modeltools.g.c pGQ;
  
  b(com.tencent.mm.plugin.appbrand.jsapi.webview.g.c paramc)
  {
    super(paramc);
    AppMethodBeat.i(271472);
    this.pGQ = new com.tencent.mm.plugin.webview.modeltools.g.c()
    {
      public final void ajA(String paramAnonymousString)
      {
        AppMethodBeat.i(264450);
        try
        {
          if (b.this.pGC != null)
          {
            b.this.pGC.a(paramAnonymousString, new int[] { 3 }, 0, 0);
            AppMethodBeat.o(264450);
            return;
          }
          Log.i("MicroMsg.AppBrand.HTMLViewScanHelper", "viewCaptureCallback, invoker is null");
          AppMethodBeat.o(264450);
          return;
        }
        catch (RemoteException paramAnonymousString)
        {
          Log.e("MicroMsg.AppBrand.HTMLViewScanHelper", "recog failed");
          AppMethodBeat.o(264450);
        }
      }
    };
    this.oxq = new ScanCodeSheetItemLogic(getContext(), new ScanCodeSheetItemLogic.a()
    {
      public final void bPS()
      {
        AppMethodBeat.i(258812);
        if ((b.a(b.this) != null) && (b.a(b.this).XSU.isShowing())) {
          b.b(b.this);
        }
        AppMethodBeat.o(258812);
      }
    });
    try
    {
      bXG();
      AppMethodBeat.o(271472);
      return;
    }
    catch (Exception paramc)
    {
      Log.printErrStackTrace("MicroMsg.AppBrand.HTMLViewScanHelper", paramc, "<init> initMenu() get exception", new Object[0]);
      this.pGE = null;
      AppMethodBeat.o(271472);
    }
  }
  
  private void bXF()
  {
    AppMethodBeat.i(271476);
    this.pGN.runOnUiThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(282489);
        b.a(b.this).a(b.this.lxa, new View.OnCreateContextMenuListener()
        {
          public final void onCreateContextMenu(ContextMenu paramAnonymous2ContextMenu, View paramAnonymous2View, ContextMenu.ContextMenuInfo paramAnonymous2ContextMenuInfo)
          {
            AppMethodBeat.i(265208);
            b.this.a(paramAnonymous2ContextMenu, b.this.pGF);
            AppMethodBeat.o(265208);
          }
        }, null, new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(267531);
            b.d(b.this);
            b.e(b.this);
            b.f(b.this).onDismiss();
            if ((b.this.pGJ != null) && (b.this.pGC != null)) {
              try
              {
                b.this.pGC.blU(b.this.pGJ.PXC);
                b.this.pGJ.gWy();
                AppMethodBeat.o(267531);
                return;
              }
              catch (Exception localException)
              {
                Log.e("MicroMsg.AppBrand.HTMLViewScanHelper", "cancel capture failed");
              }
            }
            AppMethodBeat.o(267531);
          }
        });
        AppMethodBeat.o(282489);
      }
    });
    AppMethodBeat.o(271476);
  }
  
  private void bXG()
  {
    AppMethodBeat.i(271477);
    this.pGE = new m(getContext());
    this.pGE.a(this.pGN.getWebView(), this, null);
    AppMethodBeat.o(271477);
  }
  
  private String getCurrentUrl()
  {
    AppMethodBeat.i(271482);
    String str = ((d)this.pGN.getController()).getCurrentUrl();
    AppMethodBeat.o(271482);
    return str;
  }
  
  final boolean a(ContextMenu paramContextMenu, final String paramString)
  {
    AppMethodBeat.i(271479);
    try
    {
      bool1 = this.pGC.isSDCardAvailable();
      if (!bool1)
      {
        AppMethodBeat.o(271479);
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
      if (this.pGD == null)
      {
        AppMethodBeat.o(271479);
        return true;
      }
      paramContextMenu.setHeaderTitle(au.i.wv_image);
      try
      {
        bool1 = this.pGC.gWY();
        boolean bool2 = this.pGD.gWJ().hoX();
        boolean bool3 = this.pGD.gWJ().hoY();
        Log.i("MicroMsg.AppBrand.HTMLViewScanHelper", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((bool1) && (bool2)) {
          paramContextMenu.add(0, 0, 0, getContext().getString(au.i.readerapp_alert_retransmit)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(271192);
              try
              {
                boolean bool = b.this.pGC.isSDCardAvailable();
                ab.a(b.this.getContext(), b.g(b.this), com.tencent.xweb.c.ivX().getCookie(b.g(b.this)), bool, new ab.a()
                {
                  public final void ajz(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(281291);
                    if (Util.isNullOrNil(paramAnonymous2String))
                    {
                      Log.w("MicroMsg.AppBrand.HTMLViewScanHelper", "share image to friend fail, imgPath is null");
                      AppMethodBeat.o(281291);
                      return;
                    }
                    b.a(b.this, paramAnonymous2String);
                    AppMethodBeat.o(281291);
                  }
                });
                AppMethodBeat.o(271192);
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
        paramContextMenu.add(0, 0, 0, getContext().getString(au.i.save_to_local)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
        {
          public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
          {
            AppMethodBeat.i(275170);
            try
            {
              bool = b.this.pGC.isSDCardAvailable();
            }
            catch (Exception paramAnonymousMenuItem)
            {
              try
              {
                for (;;)
                {
                  Log.i("MicroMsg.AppBrand.HTMLViewScanHelper", "onMenuItemClick saveImage2SD with url[%s]", new Object[] { b.g(b.this) });
                  ab.b(b.this.getContext(), b.g(b.this), com.tencent.xweb.c.ivX().getCookie(b.g(b.this)), bool);
                  AppMethodBeat.o(275170);
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
          paramContextMenu.add(0, 0, 0, getContext().getString(au.i.plugin_favorite_opt)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(271969);
              try
              {
                boolean bool = b.this.pGC.isSDCardAvailable();
                paramAnonymousMenuItem = b.g(b.this).replaceAll("tp=webp", "");
                ab.a(b.this.getContext(), paramAnonymousMenuItem, com.tencent.xweb.c.ivX().getCookie(paramAnonymousMenuItem), bool, new ab.a()
                {
                  public final void ajz(String paramAnonymous2String)
                  {
                    AppMethodBeat.i(282234);
                    b.b(b.this, paramAnonymous2String);
                    AppMethodBeat.o(282234);
                  }
                });
                AppMethodBeat.o(271969);
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
        this.pGE.XSU.setFooterView(null);
        if (this.pGF != null)
        {
          paramContextMenu = new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(264581);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLViewScanHelper$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if ((b.a(b.this) != null) && (b.a(b.this).XSU.isShowing())) {
                b.a(b.this).dismiss();
              }
              b.this.d(this.pGW, b.h(b.this), paramString, b.this.pGH, b.this.pGI);
              paramAnonymousView = com.tencent.mm.plugin.appbrand.jsapi.webview.e.pGh;
              com.tencent.mm.plugin.appbrand.jsapi.webview.e.a(b.this.pGN.getPageView(), true, b.this.pGH, b.c(b.this), true, b.h(b.this));
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLViewScanHelper$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(264581);
            }
          };
          this.pGE.XSU.setFooterView(this.oxq.a(paramContextMenu, this.pGH, this.pGF, 10));
          paramContextMenu = com.tencent.mm.plugin.appbrand.jsapi.webview.e.pGh;
          com.tencent.mm.plugin.appbrand.jsapi.webview.e.a(this.pGN.getPageView(), true, this.pGH, this.pGF, false, getCurrentUrl());
          AppMethodBeat.o(271479);
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
        AppMethodBeat.o(271479);
      }
    }
    return false;
  }
  
  /* Error */
  protected final void aD(Context paramContext)
  {
    // Byte code:
    //   0: ldc_w 343
    //   3: invokestatic 58	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: aload_1
    //   8: invokespecial 345	com/tencent/mm/plugin/appbrand/jsapi/webview/a/a:aD	(Landroid/content/Context;)V
    //   11: aload_0
    //   12: getfield 75	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:oxq	Lcom/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic;
    //   15: aload_1
    //   16: putfield 349	com/tencent/mm/plugin/scanner/ScanCodeSheetItemLogic:mContext	Landroid/content/Context;
    //   19: aload_0
    //   20: getfield 96	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:pGE	Lcom/tencent/mm/ui/tools/m;
    //   23: ifnull +15 -> 38
    //   26: aload_0
    //   27: getfield 96	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:pGE	Lcom/tencent/mm/ui/tools/m;
    //   30: invokevirtual 352	com/tencent/mm/ui/tools/m:dismiss	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 96	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:pGE	Lcom/tencent/mm/ui/tools/m;
    //   38: aload_1
    //   39: instanceof 354
    //   42: ifeq +7 -> 49
    //   45: aload_0
    //   46: invokespecial 79	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:bXG	()V
    //   49: ldc_w 343
    //   52: invokestatic 82	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   55: return
    //   56: astore_2
    //   57: aload_0
    //   58: aconst_null
    //   59: putfield 96	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:pGE	Lcom/tencent/mm/ui/tools/m;
    //   62: goto -24 -> 38
    //   65: astore_1
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 96	com/tencent/mm/plugin/appbrand/jsapi/webview/a/b:pGE	Lcom/tencent/mm/ui/tools/m;
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
  
  public final void d(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271478);
    if (paramString1 == null)
    {
      AppMethodBeat.o(271478);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClass(getContext(), WebviewScanImageActivity.class);
    localIntent.putExtra("key_string_for_scan", paramString1);
    localIntent.putExtra("key_string_for_url", paramString2);
    localIntent.putExtra("key_string_for_image_url", paramString3);
    localIntent.putExtra("key_codetype_for_scan", paramInt1);
    localIntent.putExtra("key_codeversion_for_scan", paramInt2);
    if ((this.pGN != null) && (!Util.isNullOrNil(this.pGN.getAppId()))) {
      localIntent.putExtra("key_string_for_wxapp_id", this.pGN.getAppId());
    }
    localIntent.putExtra("geta8key_scene", 44);
    if ((this.pGN != null) && (this.pGN.getPageView() != null)) {
      localIntent.putExtra("wxappPathWithQuery", this.pGN.getPageView().qoI);
    }
    paramString1 = getContext();
    paramString2 = new com.tencent.mm.hellhoundlib.b.a().bm(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramString1, paramString2.aFh(), "com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLViewScanHelper", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramString1.startActivity((Intent)paramString2.sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramString1, "com/tencent/mm/plugin/appbrand/jsapi/webview/bwc/HTMLViewScanHelper", "reqDealQBarResult", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(271478);
  }
  
  public final void e(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(271475);
    Log.d("MicroMsg.AppBrand.HTMLViewScanHelper", "result: ".concat(String.valueOf(paramString2)));
    if ((this.pGJ == null) || (paramString1 == null) || (!paramString1.equals(this.pGJ.PXC)))
    {
      AppMethodBeat.o(271475);
      return;
    }
    if (!k.e(paramInt1, paramString2, ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).apb(getCurrentUrl()), this.pGN.Qv()))
    {
      paramString1 = com.tencent.mm.plugin.appbrand.jsapi.webview.e.pGh;
      com.tencent.mm.plugin.appbrand.jsapi.webview.e.a(this.pGN.getPageView(), false, paramInt1, paramString2, false, getCurrentUrl());
      this.pGF = null;
      AppMethodBeat.o(271475);
      return;
    }
    if (this.pGJ != null) {
      this.pGJ.gWy();
    }
    this.pGH = paramInt1;
    this.pGI = paramInt2;
    if ((paramString2 == null) || (this.pGE == null))
    {
      AppMethodBeat.o(271475);
      return;
    }
    if (Util.isNullOrNil(paramString2)) {
      Log.w("MicroMsg.AppBrand.HTMLViewScanHelper", "processGetWXACodeNickName mResultOfImageUrl nil");
    }
    for (;;)
    {
      this.pGF = paramString2;
      if ((this.pGE != null) && (this.pGE.XSU.isShowing())) {
        bXF();
      }
      AppMethodBeat.o(271475);
      return;
      if (k.ci(this.pGH, paramString2))
      {
        Log.i("MicroMsg.AppBrand.HTMLViewScanHelper", "processGetWXACodeNickName");
        this.oxq.cl(this.pGH, paramString2);
      }
    }
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(271481);
    boolean bool;
    if ((paramView instanceof WebView))
    {
      paramView = this.lxa.getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(271481);
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
          this.pGJ.a(this.lxa, this.pGQ);
        }
      }
      AppMethodBeat.o(271481);
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      paramView = ((MMWebView)paramView).getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(271481);
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
          this.pGJ.a(this.lxa, this.pGQ);
        }
      }
    }
    AppMethodBeat.o(271481);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.webview.a.b
 * JD-Core Version:    0.7.0.1
 */