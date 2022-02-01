package com.tencent.mm.loader.e;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.ad.c;
import com.tencent.mm.loader.e.b.g;
import d.g.a.a;
import d.g.b.q;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/loader/impr/DefaultImageLoaderAnimation;", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "animation", "Landroid/view/animation/Animation;", "animTarget", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Landroid/view/animation/Animation;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getAnimTarget", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setAnimTarget", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getAnimation", "()Landroid/view/animation/Animation;", "setAnimation", "(Landroid/view/animation/Animation;)V", "onLoadCompleted", "", "holder", "onLoadStart", "libimageloader_release"})
public final class d
  implements com.tencent.mm.loader.f.d
{
  Animation FD;
  g<?> hez;
  
  public d()
  {
    this(null, null, 3);
  }
  
  private d(Animation paramAnimation, g<?> paramg)
  {
    this.FD = paramAnimation;
    this.hez = paramg;
  }
  
  public final void b(final g<?> paramg)
  {
    c.g((a)new a(this, paramg));
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<z>
  {
    a(d paramd, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.loader.e.d
 * JD-Core Version:    0.7.0.1
 */