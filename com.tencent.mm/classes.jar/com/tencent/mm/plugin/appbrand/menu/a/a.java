package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.w;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.ui.base.s;

public abstract class a<T extends ad>
{
  public final int tlb;
  
  public a(int paramInt)
  {
    this.tlb = paramInt;
  }
  
  public void a(Context paramContext, T paramT, s params, String paramString) {}
  
  public abstract void a(Context paramContext, T paramT, String paramString, w paramw);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.a.a
 * JD-Core Version:    0.7.0.1
 */