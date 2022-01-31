package com.tencent.mm.plugin.appbrand.jsapi.u;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.a;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.b;
import com.tencent.xweb.b;

public class e
  implements View.OnCreateContextMenuListener, c.b
{
  private String igI;
  MMWebViewWithJsApi igR;
  private e.b igS;
  private e.a igT;
  private com.tencent.mm.plugin.webview.stub.d igU;
  private com.tencent.mm.plugin.webview.ui.tools.k igV;
  private l igW;
  private String igX;
  int igY;
  int igZ;
  h iha;
  WebView.b ihb;
  WebView.b ihc;
  private final com.tencent.mm.plugin.webview.modeltools.d ihd;
  final c.c ihe;
  private com.tencent.mm.plugin.webview.ui.tools.jsapi.d ihf;
  private m ihg;
  private h.c ihh;
  
  public e(c.c paramc)
  {
    AppMethodBeat.i(17053);
    this.ihd = new com.tencent.mm.plugin.webview.modeltools.d();
    this.ihg = new e.1(this);
    this.ihh = new e.7(this);
    this.ihe = paramc;
    this.igR = ((MMWebViewWithJsApi)paramc.getWebView());
    this.igS = new e.b(this, this.igR);
    this.igT = new e.a(this, this.igR);
    this.igR.setWebViewClient(this.igS);
    this.igR.setWebChromeClient(this.igT);
    this.igR.setCleanOnDetached(true);
    this.igW = new l(this.igR.getContext());
    this.igW.a(this.igR, this, null);
    this.igW.setOnCancelListener(new e.2(this));
    AppMethodBeat.o(17053);
  }
  
  private void a(ContextMenu paramContextMenu, WebView.b paramb)
  {
    AppMethodBeat.i(17059);
    if ((!a(paramContextMenu, paramb.mExtra)) && (this.igV.ddW().dqw()))
    {
      this.ihc = paramb;
      this.iha = new h();
      this.iha.a(this.igR, this.ihh);
    }
    AppMethodBeat.o(17059);
  }
  
  private boolean a(ContextMenu paramContextMenu, final String paramString)
  {
    AppMethodBeat.i(17058);
    try
    {
      bool1 = this.igU.isSDCardAvailable();
      if (!bool1)
      {
        AppMethodBeat.o(17058);
        return true;
      }
    }
    catch (Exception localException1)
    {
      boolean bool1;
      for (;;)
      {
        ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + localException1.getMessage());
        bool1 = false;
      }
      if (this.igV == null)
      {
        AppMethodBeat.o(17058);
        return true;
      }
      paramContextMenu.setHeaderTitle(2131306023);
      try
      {
        bool1 = this.igU.ddb();
        boolean bool2 = this.igV.ddW().dqy();
        boolean bool3 = this.igV.ddW().dqz();
        ab.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
        if ((bool1) && (bool2)) {
          paramContextMenu.add(0, 0, 0, this.igR.getContext().getString(2131302282)).setOnMenuItemClickListener(new e.3(this, paramString));
        }
        paramContextMenu.add(0, 0, 0, this.igR.getContext().getString(2131302871)).setOnMenuItemClickListener(new e.4(this, paramString));
        if ((bool1) && (bool3)) {
          paramContextMenu.add(0, 0, 0, this.igR.getContext().getString(2131302102)).setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener()
          {
            public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
            {
              AppMethodBeat.i(17033);
              try
              {
                boolean bool = e.i(e.this).isSDCardAvailable();
                paramAnonymousMenuItem = paramString.replaceAll("tp=webp", "");
                u.a(e.g(e.this), paramAnonymousMenuItem, b.dYg().getCookie(paramAnonymousMenuItem), bool, new e.5.1(this));
                AppMethodBeat.o(17033);
                return true;
              }
              catch (Exception paramAnonymousMenuItem)
              {
                for (;;)
                {
                  ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onMenuItemClick fail, ex = " + paramAnonymousMenuItem.getMessage());
                }
              }
            }
          });
        }
        if (this.igX != null) {
          if (!a.ba(this.igY, this.igX))
          {
            this.igX = null;
            AppMethodBeat.o(17058);
            return true;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", new Object[] { localException2.getMessage() });
          bool1 = false;
        }
        String str = this.igX;
        paramContextMenu.add(0, 0, 0, this.igR.getContext().getString(2131302339)).setOnMenuItemClickListener(new e.6(this, str, paramString));
        this.igX = null;
        AppMethodBeat.o(17058);
        return true;
      }
      AppMethodBeat.o(17058);
    }
    return false;
  }
  
  private void b(ContextMenu paramContextMenu, WebView.b paramb)
  {
    AppMethodBeat.i(17060);
    if ((!a(paramContextMenu, paramb.mExtra)) && (this.igV.ddW().dqw()))
    {
      this.ihb = paramb;
      this.iha = new h();
      this.iha.a(this.igR, this.ihh);
    }
    AppMethodBeat.o(17060);
  }
  
  public final void cleanup()
  {
    AppMethodBeat.i(17054);
    this.igS.cleanup();
    this.igR.destroy();
    AppMethodBeat.o(17054);
  }
  
  public final void m(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(17055);
    ab.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "notifyKeyboardStateChanged, shown[%b], height[%d]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt) });
    com.tencent.mm.plugin.webview.ui.tools.jsapi.d locald = this.ihf;
    if (locald != null) {
      if (!paramBoolean) {
        break label57;
      }
    }
    for (;;)
    {
      locald.KT(paramInt);
      AppMethodBeat.o(17055);
      return;
      label57:
      paramInt = 0;
    }
  }
  
  public final void onBackground()
  {
    AppMethodBeat.i(17057);
    if (this.igS.vmp != null) {
      this.igS.vmp.oq(false);
    }
    AppMethodBeat.o(17057);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(17061);
    if ((paramView instanceof WebView))
    {
      paramView = this.igR.getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(17061);
        return;
      }
      if ((paramView.mType == 5) || (paramView.mType == 8)) {
        b(paramContextMenu, paramView);
      }
      AppMethodBeat.o(17061);
      return;
    }
    if ((paramView instanceof MMWebView))
    {
      paramView = ((MMWebView)paramView).getHitTestResult();
      if (paramView == null)
      {
        AppMethodBeat.o(17061);
        return;
      }
      if ((paramView.mType == 5) || (paramView.mType == 8)) {
        a(paramContextMenu, paramView);
      }
    }
    AppMethodBeat.o(17061);
  }
  
  public final void onForeground()
  {
    AppMethodBeat.i(17056);
    if (this.igS.vmp != null) {
      this.igS.vmp.oq(true);
    }
    AppMethodBeat.o(17056);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.u.e
 * JD-Core Version:    0.7.0.1
 */