package com.tencent.mm.plugin.finder.webview;

import com.tencent.mm.ui.widget.MMWebView;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper;", "", "addWebViewStateListener", "", "listener", "Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper$IWebViewStateListener;", "clearWebViewStateListener", "getWithInitWebView", "Lcom/tencent/mm/ui/widget/MMWebView;", "release", "reload", "removeWebViewStateListener", "IWebViewStateListener", "plugin-finder_release"})
public abstract interface k
{
  public abstract void a(a parama);
  
  public abstract MMWebView elR();
  
  public abstract void release();
  
  public abstract void reload();
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/webview/IFinderWebViewHelper$IWebViewStateListener;", "", "onCreateBoxWebViewEnd", "", "enablePreloadWebView", "", "enablePreloadFromFindTab", "useCache", "onCreateBoxWebViewStart", "onError", "onExecuteActionCode", "actionCode", "", "data", "Landroid/os/Bundle;", "onInitWebViewEnd", "onInitWebViewStart", "onWebViewReady", "plugin-finder_release"})
  public static abstract interface a
  {
    public abstract void elM();
    
    public abstract void elN();
    
    public abstract void elO();
    
    public abstract void elP();
    
    public abstract void elQ();
    
    public abstract void onError();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.k
 * JD-Core Version:    0.7.0.1
 */