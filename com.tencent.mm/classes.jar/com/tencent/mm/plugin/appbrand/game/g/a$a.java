package com.tencent.mm.plugin.appbrand.game.g;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import java.lang.ref.WeakReference;

public abstract class a$a
{
  protected WeakReference<MagicBrushView> jsZ;
  
  private a$a(MagicBrushView paramMagicBrushView)
  {
    this.jsZ = new WeakReference(paramMagicBrushView);
  }
  
  abstract void a(b.b paramb);
  
  abstract void a(c.b paramb, d<String> paramd);
  
  abstract void a(d<String> paramd);
  
  abstract void aXa();
  
  public abstract VideoTransPara aXb();
  
  public final MagicBrushView aXc()
  {
    return (MagicBrushView)this.jsZ.get();
  }
  
  abstract void b(d<String> paramd);
  
  abstract void c(d<String> paramd);
  
  abstract void d(d<String> paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.a.a
 * JD-Core Version:    0.7.0.1
 */