package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.ui.base.l;

public abstract class a<T extends v>
{
  public final int irp;
  
  public a(int paramInt)
  {
    this.irp = paramInt;
  }
  
  public abstract void a(Context paramContext, T paramT, l paraml, String paramString);
  
  public abstract void a(Context paramContext, T paramT, String paramString, q paramq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.a.a
 * JD-Core Version:    0.7.0.1
 */