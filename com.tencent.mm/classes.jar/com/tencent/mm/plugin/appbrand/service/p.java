package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import java.util.List;

public abstract interface p
  extends a
{
  public abstract void D(Context paramContext, int paramInt);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, List<WxaAttributes.WxaEntryInfo> paramList);
  
  public abstract void b(Context paramContext, int paramInt1, int paramInt2);
  
  public abstract void db(Context paramContext);
  
  public abstract boolean dc(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.p
 * JD-Core Version:    0.7.0.1
 */