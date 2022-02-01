package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.r;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.ui.base.l;

public abstract class a<T extends z>
{
  public final int lYa;
  
  public a(int paramInt)
  {
    this.lYa = paramInt;
  }
  
  public void a(Context paramContext, T paramT, l paraml, String paramString) {}
  
  public abstract void a(Context paramContext, T paramT, String paramString, r paramr);
  
  public final int btI()
  {
    return this.lYa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.a.a
 * JD-Core Version:    0.7.0.1
 */