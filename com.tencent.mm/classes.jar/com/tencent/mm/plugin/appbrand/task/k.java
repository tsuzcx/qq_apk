package com.tencent.mm.plugin.appbrand.task;

import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.weishi.AppBrandWeishiUI;

final class k
  extends j
{
  k()
  {
    super(AppBrandWeishiUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class);
  }
  
  protected final boolean a(g paramg)
  {
    return paramg != g.iKT;
  }
  
  final void aLF() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.k
 * JD-Core Version:    0.7.0.1
 */