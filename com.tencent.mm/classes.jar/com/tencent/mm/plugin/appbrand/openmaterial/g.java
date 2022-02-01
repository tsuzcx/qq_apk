package com.tencent.mm.plugin.appbrand.openmaterial;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.openmaterial.model.AppBrandOpenMaterialCollection;
import com.tencent.mm.plugin.appbrand.openmaterial.model.b;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vending.e.a;

public abstract interface g
  extends a
{
  public static final g nlh = new g()
  {
    public final void a(g.b paramAnonymousb) {}
    
    public final void bPY() {}
    
    public final void dead() {}
    
    public final void hide() {}
    
    public final void show() {}
  };
  
  public abstract void a(g.b paramb);
  
  public abstract void bPY();
  
  public abstract void hide();
  
  public abstract void show();
  
  public static abstract interface a
  {
    public abstract g a(Context paramContext, e parame, AppBrandOpenMaterialCollection paramAppBrandOpenMaterialCollection);
    
    public abstract a b(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.g
 * JD-Core Version:    0.7.0.1
 */