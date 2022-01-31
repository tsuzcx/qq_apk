package com.tencent.mm.plugin.appbrand.task;

import com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI;
import java.util.Collection;
import java.util.LinkedHashMap;

final class a
  extends i
{
  final long hbb;
  private String hbc;
  
  a(long paramLong)
  {
    super(AppBrandEmbedUI.class, null, null);
    this.hbb = paramLong;
  }
  
  final void a(String paramString, int paramInt, AppBrandRemoteTaskController paramAppBrandRemoteTaskController)
  {
    if (this.hch.keySet().isEmpty()) {
      this.hbc = paramString;
    }
    super.a(paramString, paramInt, paramAppBrandRemoteTaskController);
  }
  
  final void wi(String paramString)
  {
    if (this.hbc.equals(paramString))
    {
      this.hch.clear();
      this.hci.clear();
      this.hcj = f.hbW;
      return;
    }
    super.wi(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.task.a
 * JD-Core Version:    0.7.0.1
 */