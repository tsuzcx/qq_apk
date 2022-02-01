package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.v;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.ui.base.o;

public abstract class a<T extends ad>
{
  public final int qgq;
  
  public a(int paramInt)
  {
    this.qgq = paramInt;
  }
  
  public void a(Context paramContext, T paramT, o paramo, String paramString) {}
  
  public abstract void a(Context paramContext, T paramT, String paramString, v paramv);
  
  public final int cbA()
  {
    return this.qgq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.a.a
 * JD-Core Version:    0.7.0.1
 */