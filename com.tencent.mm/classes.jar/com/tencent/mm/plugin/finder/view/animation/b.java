package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.loader.h;
import com.tencent.mm.plugin.finder.loader.h.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.k;
import d.g.b.v.e;
import d.v;
import d.y;
import java.util.LinkedList;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper;", "", "()V", "TAG", "", "anim", "", "view", "Landroid/view/View;", "from", "", "to", "listener", "Landroid/animation/Animator$AnimatorListener;", "setAvatarImg", "info", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Landroid/widget/ImageView;", "start", "startAvatarAnimator", "likeList", "Ljava/util/LinkedList;", "avatarLayoutList", "", "parent", "startWithAlpha", "plugin-finder_release"})
public final class b
{
  public static final b qYv;
  
  static
  {
    AppMethodBeat.i(168461);
    qYv = new b();
    AppMethodBeat.o(168461);
  }
  
  public static void a(View paramView, String paramString, float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(200247);
    paramString = ObjectAnimator.ofFloat(paramView, paramString, new float[] { paramFloat1, paramFloat2 });
    k.g(paramString, "tranX");
    paramString.setDuration(500L);
    if (paramAnimatorListener != null) {
      paramString.addListener(paramAnimatorListener);
    }
    for (;;)
    {
      paramString.start();
      AppMethodBeat.o(200247);
      return;
      paramString.addListener((Animator.AnimatorListener)new d(paramView));
    }
  }
  
  public static void a(FinderCommentInfo paramFinderCommentInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(200248);
    if (k.g(paramFinderCommentInfo.username, u.aqG()))
    {
      com.tencent.mm.ui.f.a.a.c(paramImageView, u.aqG());
      AppMethodBeat.o(200248);
      return;
    }
    Object localObject = h.qCF;
    localObject = h.cmV();
    paramFinderCommentInfo = new com.tencent.mm.plugin.finder.loader.a(paramFinderCommentInfo.headUrl);
    h localh = h.qCF;
    ((d)localObject).a(paramFinderCommentInfo, paramImageView, h.a(h.a.qCI));
    AppMethodBeat.o(200248);
  }
  
  public static void dU(View paramView)
  {
    AppMethodBeat.i(168459);
    k.h(paramView, "view");
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, 1.05F, 1.0F, 0.95F, 1.0F }) });
    localValueAnimator.setDuration(500L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new a(paramView));
    localValueAnimator.start();
    AppMethodBeat.o(168459);
  }
  
  public static void dV(View paramView)
  {
    AppMethodBeat.i(168460);
    k.h(paramView, "view");
    paramView.setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.5F, 1.75F, 1.25F, 1.5F }), PropertyValuesHolder.ofFloat("alpha", new float[] { 0.7F, 0.5F, 0.7F, 0.9F }) });
    localValueAnimator.setDuration(500L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(paramView));
    localValueAnimator.addListener((Animator.AnimatorListener)new c(paramView));
    localValueAnimator.start();
    AppMethodBeat.o(168460);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a(View paramView) {}
    
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
      ad.d("LikeIconAnimationHelper", "valueScale=".concat(String.valueOf(f)));
      this.jFc.setScaleX(f);
      this.jFc.setScaleY(f);
      AppMethodBeat.o(168455);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class b
    implements ValueAnimator.AnimatorUpdateListener
  {
    b(View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(168456);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("scale");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(168456);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      this.jFc.setScaleX(f);
      this.jFc.setScaleY(f);
      AppMethodBeat.o(168456);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startWithAlpha$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    c(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168458);
      this.jFc.animate().alpha(0.0F).setStartDelay(300L).withEndAction((Runnable)new a(this)).start();
      AppMethodBeat.o(168458);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class a
      implements Runnable
    {
      a(b.c paramc) {}
      
      public final void run()
      {
        AppMethodBeat.i(168457);
        this.qYw.jFc.setScaleX(1.0F);
        this.qYw.jFc.setScaleY(1.0F);
        this.qYw.jFc.setAlpha(1.0F);
        this.qYw.jFc.setVisibility(8);
        AppMethodBeat.o(168457);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$anim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class d
    implements Animator.AnimatorListener
  {
    d(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200242);
      if (paramAnimator != null)
      {
        paramAnimator.cancel();
        AppMethodBeat.o(200242);
        return;
      }
      AppMethodBeat.o(200242);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(200243);
      this.jFc.setVisibility(0);
      AppMethodBeat.o(200243);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startAvatarAnimator$5", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    public e(LinkedList paramLinkedList, v.e parame1, v.e parame2) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(200245);
      c.a(500L, (d.g.a.a)new a(this));
      AppMethodBeat.o(200245);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(200246);
      ((View)this.LgA.Jhw).setVisibility(0);
      AppMethodBeat.o(200246);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
    static final class a
      extends d.g.b.l
      implements d.g.a.a<y>
    {
      a(b.e parame)
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