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
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.a;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper;", "", "()V", "TAG", "", "anim", "", "view", "Landroid/view/View;", "from", "", "to", "listener", "Landroid/animation/Animator$AnimatorListener;", "setAvatarImg", "info", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Landroid/widget/ImageView;", "start", "startAvatarAnimator", "likeList", "Ljava/util/LinkedList;", "avatarLayoutList", "", "parent", "startWithAlpha", "plugin-finder_release"})
public final class c
{
  public static final c tiL;
  
  static
  {
    AppMethodBeat.i(168461);
    tiL = new c();
    AppMethodBeat.o(168461);
  }
  
  public static void a(View paramView, String paramString, float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(205965);
    paramString = ObjectAnimator.ofFloat(paramView, paramString, new float[] { paramFloat1, paramFloat2 });
    p.g(paramString, "tranX");
    paramString.setDuration(500L);
    if (paramAnimatorListener != null) {
      paramString.addListener(paramAnimatorListener);
    }
    for (;;)
    {
      paramString.start();
      AppMethodBeat.o(205965);
      return;
      paramString.addListener((Animator.AnimatorListener)new a(paramView));
    }
  }
  
  public static void a(FinderCommentInfo paramFinderCommentInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(205966);
    if (p.i(paramFinderCommentInfo.username, com.tencent.mm.model.v.aAC()))
    {
      a.b.d(paramImageView, com.tencent.mm.model.v.aAC(), 0.0F);
      AppMethodBeat.o(205966);
      return;
    }
    Object localObject = i.srW;
    localObject = i.cEq();
    paramFinderCommentInfo = new a(paramFinderCommentInfo.headUrl);
    i locali = i.srW;
    ((d)localObject).a(paramFinderCommentInfo, paramImageView, i.a(i.a.ssa));
    AppMethodBeat.o(205966);
  }
  
  public static void ej(View paramView)
  {
    AppMethodBeat.i(168459);
    p.h(paramView, "view");
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, 1.05F, 1.0F, 0.95F, 1.0F }) });
    localValueAnimator.setDuration(500L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(paramView));
    localValueAnimator.start();
    AppMethodBeat.o(168459);
  }
  
  public static void ek(View paramView)
  {
    AppMethodBeat.i(168460);
    p.h(paramView, "view");
    paramView.setVisibility(0);
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 0.5F, 1.75F, 1.25F, 1.5F }), PropertyValuesHolder.ofFloat("alpha", new float[] { 0.7F, 0.5F, 0.7F, 0.9F }) });
    localValueAnimator.setDuration(500L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new d(paramView));
    localValueAnimator.addListener((Animator.AnimatorListener)new e(paramView));
    localValueAnimator.start();
    AppMethodBeat.o(168460);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$anim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    a(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205961);
      if (paramAnimator != null)
      {
        paramAnimator.cancel();
        AppMethodBeat.o(205961);
        return;
      }
      AppMethodBeat.o(205961);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(205962);
      this.kDC.setVisibility(0);
      AppMethodBeat.o(205962);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
        paramValueAnimator = new d.v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(168455);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      ae.d("LikeIconAnimationHelper", "valueScale=".concat(String.valueOf(f)));
      this.kDC.setScaleX(f);
      this.kDC.setScaleY(f);
      AppMethodBeat.o(168455);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startAvatarAnimator$6", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public c(List paramList, y.f paramf, LinkedList paramLinkedList) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205963);
      paramAnimator = ((Iterable)this.rWc).iterator();
      while (paramAnimator.hasNext())
      {
        localObject = (View)paramAnimator.next();
        if (localObject != null) {
          ((View)localObject).setTranslationX(0.0F);
        }
        if (localObject != null) {
          ((View)localObject).setAlpha(1.0F);
        }
      }
      paramAnimator = (View)this.tiM.NiY;
      p.g(paramAnimator, "avatarExtra");
      paramAnimator.setVisibility(8);
      paramAnimator = (View)this.tiM.NiY;
      p.g(paramAnimator, "avatarExtra");
      paramAnimator.setTranslationX(0.0F);
      paramAnimator = c.tiL;
      paramAnimator = this.tiN.get(0);
      p.g(paramAnimator, "likeList[0]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      Object localObject = this.rWc.get(0);
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((View)localObject).findViewById(2131307453);
      p.g(localObject, "avatarLayoutList[0]!!.fi…yId(R.id.friend_avatar_1)");
      c.b(paramAnimator, (ImageView)localObject);
      paramAnimator = c.tiL;
      paramAnimator = this.tiN.get(1);
      p.g(paramAnimator, "likeList[1]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      localObject = this.rWc.get(1);
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((View)localObject).findViewById(2131307455);
      p.g(localObject, "avatarLayoutList[1]!!.fi…yId(R.id.friend_avatar_2)");
      c.b(paramAnimator, (ImageView)localObject);
      paramAnimator = c.tiL;
      paramAnimator = this.tiN.get(2);
      p.g(paramAnimator, "likeList[2]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      localObject = this.rWc.get(2);
      if (localObject == null) {
        p.gkB();
      }
      localObject = ((View)localObject).findViewById(2131307457);
      p.g(localObject, "avatarLayoutList[2]!!.fi…yId(R.id.friend_avatar_3)");
      c.b(paramAnimator, (ImageView)localObject);
      AppMethodBeat.o(205963);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
  static final class d
    implements ValueAnimator.AnimatorUpdateListener
  {
    d(View paramView) {}
    
    public final void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      AppMethodBeat.i(168456);
      paramValueAnimator = paramValueAnimator.getAnimatedValue("scale");
      if (paramValueAnimator == null)
      {
        paramValueAnimator = new d.v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(168456);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      this.kDC.setScaleX(f);
      this.kDC.setScaleY(f);
      AppMethodBeat.o(168456);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startWithAlpha$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168458);
      this.kDC.animate().alpha(0.0F).setStartDelay(300L).setListener((Animator.AnimatorListener)new a(this)).start();
      AppMethodBeat.o(168458);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startWithAlpha$2$onAnimationEnd$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class a
      implements Animator.AnimatorListener
    {
      public final void onAnimationCancel(Animator paramAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(205964);
        this.tiO.kDC.setScaleX(1.0F);
        this.tiO.kDC.setScaleY(1.0F);
        this.tiO.kDC.setAlpha(1.0F);
        this.tiO.kDC.setVisibility(8);
        AppMethodBeat.o(205964);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.c
 * JD-Core Version:    0.7.0.1
 */