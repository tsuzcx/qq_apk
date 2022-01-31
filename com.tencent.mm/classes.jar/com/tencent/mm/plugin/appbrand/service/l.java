package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import java.util.List;

public abstract interface l
  extends a
{
  public abstract void D(Context paramContext, int paramInt);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, List<WxaAttributes.WxaEntryInfo> paramList);
  
  public abstract void c(Context paramContext, int paramInt, boolean paramBoolean);
  
  public abstract void cG(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.l
 * JD-Core Version:    0.7.0.1
 */