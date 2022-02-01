package com.tencent.mm.plugin.appbrand.game.g;

import com.tencent.magicbrush.ui.MagicBrushView;
import com.tencent.mm.modelcontrol.VideoTransPara;
import java.lang.ref.WeakReference;

public abstract class a$a
{
  protected WeakReference<MagicBrushView> kqX;
  
  private a$a(MagicBrushView paramMagicBrushView)
  {
    this.kqX = new WeakReference(paramMagicBrushView);
  }
  
  abstract void a(b.b paramb);
  
  abstract void a(c.b paramb, d<String> paramd);
  
  abstract void a(d<String> paramd);
  
  abstract void b(d<String> paramd);
  
  abstract void bik();
  
  public abstract VideoTransPara bil();
  
  public final MagicBrushView bim()
  {
    return (MagicBrushView)this.kqX.get();
  }
  
  abstract void c(d<String> paramd);
  
  abstract void d(d<String> paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.g.a.a
 * JD-Core Version:    0.7.0.1
 */