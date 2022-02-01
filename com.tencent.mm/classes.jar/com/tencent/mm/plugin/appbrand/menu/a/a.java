package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.t;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.ui.base.m;

public abstract class a<T extends ac>
{
  public final int nfG;
  
  public a(int paramInt)
  {
    this.nfG = paramInt;
  }
  
  public void a(Context paramContext, T paramT, m paramm, String paramString) {}
  
  public abstract void a(Context paramContext, T paramT, String paramString, t paramt);
  
  public final int bPj()
  {
    return this.nfG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.a.a
 * JD-Core Version:    0.7.0.1
 */