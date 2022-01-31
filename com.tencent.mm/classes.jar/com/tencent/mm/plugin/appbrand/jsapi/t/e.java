package com.tencent.mm.plugin.appbrand.jsapi.t;

import android.content.Context;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.webkit.WebView;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.scanner.a;
import com.tencent.mm.plugin.webview.modeltools.h;
import com.tencent.mm.plugin.webview.modeltools.h.c;
import com.tencent.mm.plugin.webview.ui.tools.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;
import com.tencent.mm.plugin.webview.ui.tools.widget.m;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.j;
import com.tencent.mm.ui.widget.MMWebView;
import com.tencent.xweb.WebView.b;

public class e
  implements View.OnCreateContextMenuListener, c.b
{
  private String gGe;
  MMWebViewWithJsApi gGk;
  private e.b gGl;
  private e.a gGm;
  private com.tencent.mm.plugin.webview.stub.d gGn;
  private f gGo;
  private j gGp;
  private String gGq;
  int gGr;
  int gGs;
  h gGt;
  WebView.b gGu;
  WebView.b gGv;
  private final com.tencent.mm.plugin.webview.modeltools.d gGw = new com.tencent.mm.plugin.webview.modeltools.d();
  final c.c gGx;
  private m gGy = new e.1(this);
  private h.c gGz = new e.7(this);
  
  public e(c.c paramc)
  {
    this.gGx = paramc;
    this.gGk = ((MMWebViewWithJsApi)paramc.getWebView());
    this.gGl = new e.b(this, this.gGk);
    this.gGm = new e.a(this, this.gGk);
    this.gGk.setWebViewClient(this.gGl);
    this.gGk.setWebChromeClient(this.gGm);
    this.gGk.setCleanOnDetached(true);
    this.gGp = new j(this.gGk.getContext());
    this.gGp.a(this.gGk, this, null);
    this.gGp.d(new e.2(this));
  }
  
  private void a(ContextMenu paramContextMenu, WebView.b paramb)
  {
    if ((!a(paramContextMenu, paramb.mExtra)) && (this.gGo.cdJ().coW()))
    {
      this.gGv = paramb;
      this.gGt = new h();
      this.gGt.a(this.gGk, this.gGz);
    }
  }
  
  private boolean a(ContextMenu paramContextMenu, String paramString)
  {
    boolean bool2 = false;
    try
    {
      bool1 = this.gGn.isSDCardAvailable();
      if (!bool1)
      {
        bool1 = true;
        return bool1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        y.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "onCreateContextMenu fail, ex = " + localException1.getMessage());
        boolean bool1 = false;
        continue;
        if (this.gGo == null) {
          return true;
        }
        paramContextMenu.setHeaderTitle(R.l.wv_image);
        try
        {
          bool1 = this.gGn.cdg();
          boolean bool3 = this.gGo.cdJ().coY();
          boolean bool4 = this.gGo.cdJ().coZ();
          y.i("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "hasSetAcc = %b, canShareImage = %b, canFavImage = %b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool3), Boolean.valueOf(bool4) });
          if ((bool1) && (bool3)) {
            paramContextMenu.add(0, 0, 0, this.gGk.getContext().getString(R.l.readerapp_alert_retransmit)).setOnMenuItemClickListener(new e.3(this, paramString));
          }
          paramContextMenu.add(0, 0, 0, this.gGk.getContext().getString(R.l.save_to_local)).setOnMenuItemClickListener(new e.4(this, paramString));
          if ((bool1) && (bool4)) {
            paramContextMenu.add(0, 0, 0, this.gGk.getContext().getString(R.l.plugin_favorite_opt)).setOnMenuItemClickListener(new e.5(this, paramString));
          }
          bool1 = bool2;
          if (this.gGq != null) {
            if (!a.aD(this.gGr, this.gGq))
            {
              this.gGq = null;
              return true;
            }
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            y.e("MicroMsg.AppBrand.HTMLWebViewLogicDelegate", "get has setuin failed : %s", new Object[] { localException2.getMessage() });
            bool1 = false;
          }
          String str = this.gGq;
          paramContextMenu.add(0, 0, 0, this.gGk.getContext().getString(R.l.recog_wxcode_of_image_file)).setOnMenuItemClickListener(new e.6(this, str, paramString));
          this.gGq = null;
        }
      }
    }
    return true;
  }
  
  private void b(ContextMenu paramContextMenu, WebView.b paramb)
  {
    if ((!a(paramContextMenu, paramb.mExtra)) && (this.gGo.cdJ().coW()))
    {
      this.gGu = paramb;
      this.gGt = new h();
      this.gGt.a(this.gGk, this.gGz);
    }
  }
  
  public final void cleanup()
  {
    this.gGl.cleanup();
    this.gGk.destroy();
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    if ((paramView instanceof WebView))
    {
      paramView = this.gGk.getHitTestResult();
      if (paramView != null) {}
    }
    do
    {
      do
      {
        do
        {
          return;
        } while ((paramView.mType != 5) && (paramView.mType != 8));
        b(paramContextMenu, paramView);
        return;
      } while (!(paramView instanceof MMWebView));
      paramView = ((MMWebView)paramView).getHitTestResult();
    } while ((paramView == null) || ((paramView.mType != 5) && (paramView.mType != 8)));
    a(paramContextMenu, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.t.e
 * JD-Core Version:    0.7.0.1
 */