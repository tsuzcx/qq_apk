package com.tencent.mm.plugin.appbrand.service;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import java.util.List;

public abstract interface q
  extends a
{
  public abstract void H(Context paramContext, int paramInt);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, List<WxaAttributes.WxaEntryInfo> paramList);
  
  public abstract void d(Context paramContext, int paramInt1, int paramInt2);
  
  public abstract void di(Context paramContext);
  
  public abstract boolean dj(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.service.q
 * JD-Core Version:    0.7.0.1
 */