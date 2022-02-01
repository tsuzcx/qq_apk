package com.tencent.mm.loader.e;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.loader.e.b.g;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/impr/DefaultImageLoaderAnimation;", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "animation", "Landroid/view/animation/Animation;", "animTarget", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Landroid/view/animation/Animation;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getAnimTarget", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setAnimTarget", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getAnimation", "()Landroid/view/animation/Animation;", "setAnimation", "(Landroid/view/animation/Animation;)V", "onLoadCompleted", "", "holder", "onLoadStart", "libimageloader_release"})
public final class d
  implements com.tencent.mm.loader.f.d
{
  Animation FN;
  g<?> iah;
  
  public d()
  {
    this(null, null, 3);
  }
  
  private d(Animation paramAnimation, g<?> paramg)
  {
    this.FN = paramAnimation;
    this.iah = paramg;
  }
  
  public final void a(final g<?> paramg)
  {
    com.tencent.mm.ac.d.h((a)new a(this, paramg));
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements a<x>
  {
    a(d paramd, g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.e.d
 * JD-Core Version:    0.7.0.1
 */