package com.tencent.mm.plugin.appbrand.openmaterial;

import com.tencent.mm.vending.e.a;

public abstract interface g
  extends a
{
  public static final g trt = new g()
  {
    public final void a(g.b paramAnonymousb) {}
    
    public final void cDb() {}
    
    public final void dead() {}
    
    public final void hide() {}
    
    public final void show() {}
  };
  
  public abstract void a(b paramb);
  
  public abstract void cDb();
  
  public abstract void hide();
  
  public abstract void show();
  
  public static abstract interface b
  {
    public abstract void onHidden();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.openmaterial.g
 * JD-Core Version:    0.7.0.1
 */