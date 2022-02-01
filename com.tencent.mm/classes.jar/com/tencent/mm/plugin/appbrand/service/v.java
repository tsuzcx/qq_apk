package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import java.util.List;

public abstract interface v
  extends a
{
  public abstract void T(Context paramContext, int paramInt);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, List<WxaAttributes.WxaEntryInfo> paramList);
  
  public abstract boolean ceP();
  
  public abstract void ev(Context paramContext);
  
  public abstract boolean ew(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.v
 * JD-Core Version:    0.7.0.1
 */