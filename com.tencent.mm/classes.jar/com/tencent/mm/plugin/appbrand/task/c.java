package com.tencent.mm.plugin.appbrand.task;

import com.tencent.mm.plugin.appbrand.keepalive.AppBrandKeepAliveService;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;

final class c
  extends i
{
  c()
  {
    super(AppBrandPluginUI.class, AppBrandTaskPreloadReceiver.class, AppBrandKeepAliveService.class);
  }
  
  protected final boolean a(f paramf)
  {
    return paramf != f.hbV;
  }
  
  final void aoC() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.c
 * JD-Core Version:    0.7.0.1
 */