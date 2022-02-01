package com.tencent.mm.api;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.c;
import com.tencent.mm.plugin.webview.d.e;
import com.tencent.mm.plugin.webview.d.h;
import com.tencent.mm.ui.widget.MMWebView;

public abstract interface aa
  extends a
{
  public abstract BaseWebViewController a(MMWebView paramMMWebView);
  
  public abstract BaseWebViewController a(MMWebView paramMMWebView, BaseWebViewController.c paramc, e parame);
  
  public abstract boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract h b(MMWebView paramMMWebView);
  
  public abstract void c(Activity paramActivity, String paramString);
  
  public abstract String fM(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.aa
 * JD-Core Version:    0.7.0.1
 */