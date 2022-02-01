package com.tencent.mm.plugin.appbrand.menu.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.menu.p;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.ui.base.l;

public abstract class a<T extends aa>
{
  public final int kSO;
  
  public a(int paramInt)
  {
    this.kSO = paramInt;
  }
  
  public void a(Context paramContext, T paramT, l paraml, String paramString) {}
  
  public abstract void a(Context paramContext, T paramT, String paramString, p paramp);
  
  public final int bie()
  {
    return this.kSO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.menu.a.a
 * JD-Core Version:    0.7.0.1
 */