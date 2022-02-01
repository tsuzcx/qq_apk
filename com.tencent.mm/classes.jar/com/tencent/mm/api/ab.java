package com.tencent.mm.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.core.BaseWebViewController.d;
import com.tencent.mm.plugin.webview.jsapi.g;
import com.tencent.mm.plugin.webview.jsapi.j;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.ui.widget.MMWebView;

public abstract interface ab
  extends a
{
  public abstract int a(Context paramContext, e parame, String paramString);
  
  public abstract BaseWebViewController a(MMWebView paramMMWebView);
  
  public abstract BaseWebViewController a(MMWebView paramMMWebView, BaseWebViewController.d paramd, g paramg);
  
  public abstract boolean a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract j b(MMWebView paramMMWebView);
  
  public abstract void c(Activity paramActivity, String paramString);
  
  public abstract String hW(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.api.ab
 * JD-Core Version:    0.7.0.1
 */