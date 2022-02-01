package com.tencent.mm.loader.d;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mm.loader.d.b.g;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/loader/impr/DefaultImageLoaderAnimation;", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "animation", "Landroid/view/animation/Animation;", "animTarget", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "(Landroid/view/animation/Animation;Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getAnimTarget", "()Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "setAnimTarget", "(Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;)V", "getAnimation", "()Landroid/view/animation/Animation;", "setAnimation", "(Landroid/view/animation/Animation;)V", "onLoadCompleted", "", "holder", "onLoadStart", "libimageloader_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements com.tencent.mm.loader.e.d
{
  Animation bCz;
  g<?> nqv;
  
  public d()
  {
    this(null, null, 3);
  }
  
  private d(Animation paramAnimation, g<?> paramg)
  {
    this.bCz = paramAnimation;
    this.nqv = paramg;
  }
  
  public final void a(final g<?> paramg)
  {
    com.tencent.mm.ae.d.uiThread((a)new a(this, paramg));
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<ah>
  {
    a(d paramd, g<?> paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.loader.d.d
 * JD-Core Version:    0.7.0.1
 */