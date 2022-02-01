package com.tencent.mm.plugin.appbrand.widget.recent;

import android.content.Context;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.c.a;
import com.tencent.mm.plugin.appbrand.api.c;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;

@e(gf=c.class)
public abstract interface k
  extends a
{
  public abstract AppBrandRecentView a(Context paramContext, k.b paramb, a parama);
  
  public abstract void cqi();
  
  public static abstract interface a
  {
    public abstract LocalUsageInfo ceL();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.recent.k
 * JD-Core Version:    0.7.0.1
 */