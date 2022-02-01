package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;

@e(c.class)
public abstract interface l
  extends a
{
  public abstract AppBrandRecentView a(Context paramContext, l.b paramb, a parama);
  
  public abstract void ccV();
  
  public abstract g ccW();
  
  public static abstract interface a
  {
    public abstract LocalUsageInfo bRO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.l
 * JD-Core Version:    0.7.0.1
 */