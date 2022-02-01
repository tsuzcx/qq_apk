package com.tencent.mm.plugin.finder.webview;

import android.content.Context;
import android.view.Window;
import com.tencent.mm.plugin.scanner.MultiCodeMaskView;
import com.tencent.mm.plugin.webview.core.BaseWebViewController;
import com.tencent.mm.plugin.webview.f.g;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.ui.widget.MMWebView;

public abstract interface l
{
  public abstract e elT();
  
  public abstract g elU();
  
  public abstract Float elV();
  
  public abstract Float elW();
  
  public abstract boolean elX();
  
  public abstract String elY();
  
  public abstract int elZ();
  
  public abstract MultiCodeMaskView ema();
  
  public abstract Context getContext();
  
  public abstract BaseWebViewController getController();
  
  public abstract MMWebView getWebView();
  
  public abstract Window getWindow();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.l
 * JD-Core Version:    0.7.0.1
 */