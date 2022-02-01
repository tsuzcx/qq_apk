package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import d.g.b.v.f;
import d.v;
import d.y;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper;", "", "()V", "TAG", "", "anim", "", "view", "Landroid/view/View;", "from", "", "to", "listener", "Landroid/animation/Animator$AnimatorListener;", "setAvatarImg", "info", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Landroid/widget/ImageView;", "start", "startAvatarAnimator", "likeList", "Ljava/util/LinkedList;", "avatarLayoutList", "", "parent", "startWithAlpha", "plugin-finder_release"})
public final class b
{
  public static final b sag;
  
  static
  {
    AppMethodBeat.i(168461);
    sag = new b();
    AppMethodBeat.o(168461);
  }
  
  public static void a(View paramView, String paramString, float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(204317);
    paramString = ObjectAnimator.ofFloat(paramView, paramString, new float[] { paramFloat1, paramFloat2 });
    k.g(paramString, "tranX");
    paramString.setDuration(500L);
    if (paramAnimatorListener != null) {
      paramString.addListener(paramAnimatorListener);
    }
    for (;;)
    {
      paramString.start();
      AppMethodBeat.o(204317);
      return;
      paramString.addListener((Animator.AnimatorListener)new a(paramView));
    }
  }
  
  public static void a(FinderCommentInfo paramFinderCommentInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(204318);
    if (k.g(paramFinderCommentInfo.username, u.axw()))
    {
      com.tencent.mm.ui.f.a.a.c(paramImageView, u.axw());
      AppMethodBeat.o(204318);
      return;
    }
    Object localObject = h.rtK;
    localObject = h.cwo();
    paramFinderCommentInfo = new com.tencent.mm.plugin.finder.loader.a(paramFinderCommentInfo.headUrl);
    h localh = h.rtK;
    ((d)localObject).a(paramFinderCommentInfo, paramImageView, h.a(h.a.rtN));
    AppMethodBeat.o(204318);
  }
  
  public static void eb(View paramView)
  {
    AppMethodBeat.i(168459);
    k.h(paramView, "view");
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, 1.05F, 1.0F, 0.95F, 1.0F }) });
    localValueAnimator.setDuration(500L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(paramView));
    localValueAnimator.start();
    AppMethodBeat.o(168459);
  }
  
  public static void ec(View paramView)
  {
    AppMethodBeat.i(168460);
    k.h(paramView, "view");
    paramView.setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.5F, 1.75F, 1.25F, 1.5F }), PropertyValuesHolder.ofFloat("alpha", new float[] { 0.7F, 0.5F, 0.7F, 0.9F }) });
    localValueAnimator.setDuration(500L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b.d(paramView));
    localValueAnimator.addListener((Animator.AnimatorListener)new b.e(paramView));
    localValueAnimator.start();
    AppMethodBeat.o(168460);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$anim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    a(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(204312);
      if (paramAnimator != null)
      {
        paramAnimator.cancel();
        AppMethodBeat.o(204312);
        return;
      }
      AppMethodBeat.o(204312);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(204313);
      this.kfz.setVisibility(0);
      AppMethodBeat.o(204313);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(168455);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("scale");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(168455);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      ac.d("LikeIconAnimationHelper", "valueScale=".concat(String.valueOf(f)));
      this.kfz.setScaleX(f);
      this.kfz.setScaleY(f);
      AppMethodBeat.o(168455);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startAvatarAnimator$5", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public c(LinkedList paramLinkedList, v.f paramf1, v.f paramf2) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(204315);
      c.a(500L, (d.g.a.a)new a(this));
      AppMethodBeat.o(204315);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(204316);
      ((View)this.saj.KUQ).setVisibility(0);
      AppMethodBeat.o(204316);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(b.c paramc)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.b
 * JD-Core Version:    0.7.0.1
 */