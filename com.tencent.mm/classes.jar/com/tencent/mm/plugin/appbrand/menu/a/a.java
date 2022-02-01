package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.q;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.ui.base.l;

public abstract class a<T extends aa>
{
  public final int lTy;
  
  public a(int paramInt)
  {
    this.lTy = paramInt;
  }
  
  public void a(Context paramContext, T paramT, l paraml, String paramString) {}
  
  public abstract void a(Context paramContext, T paramT, String paramString, q paramq);
  
  public final int bsX()
  {
    return this.lTy;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.a.a
 * JD-Core Version:    0.7.0.1
 */