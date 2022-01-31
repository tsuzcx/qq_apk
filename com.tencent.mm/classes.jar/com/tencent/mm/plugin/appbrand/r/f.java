package com.tencent.mm.plugin.appbrand.r;

import android.content.Context;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaEntryInfo;
import java.util.List;

public abstract interface f
  extends a
{
  public abstract void a(Context paramContext, String paramString1, String paramString2, List<WxaAttributes.WxaEntryInfo> paramList);
  
  public abstract void b(Context paramContext, int paramInt, boolean paramBoolean);
  
  public abstract void cb(Context paramContext);
  
  public abstract void cc(Context paramContext);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.r.f
 * JD-Core Version:    0.7.0.1
 */