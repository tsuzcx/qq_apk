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
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.i.a;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.g.b.y.f;
import d.l;
import d.v;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper;", "", "()V", "TAG", "", "anim", "", "view", "Landroid/view/View;", "from", "", "to", "listener", "Landroid/animation/Animator$AnimatorListener;", "setAvatarImg", "info", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Landroid/widget/ImageView;", "start", "startAvatarAnimator", "likeList", "Ljava/util/LinkedList;", "avatarLayoutList", "", "parent", "startWithAlpha", "plugin-finder_release"})
public final class c
{
  public static final c sXx;
  
  static
  {
    AppMethodBeat.i(168461);
    sXx = new c();
    AppMethodBeat.o(168461);
  }
  
  public static void a(View paramView, String paramString, float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(205322);
    paramString = ObjectAnimator.ofFloat(paramView, paramString, new float[] { paramFloat1, paramFloat2 });
    p.g(paramString, "tranX");
    paramString.setDuration(500L);
    if (paramAnimatorListener != null) {
      paramString.addListener(paramAnimatorListener);
    }
    for (;;)
    {
      paramString.start();
      AppMethodBeat.o(205322);
      return;
      paramString.addListener((Animator.AnimatorListener)new a(paramView));
    }
  }
  
  public static void a(FinderCommentInfo paramFinderCommentInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(205323);
    if (p.i(paramFinderCommentInfo.username, u.aAm()))
    {
      com.tencent.mm.ui.f.a.a.c(paramImageView, u.aAm());
      AppMethodBeat.o(205323);
      return;
    }
    Object localObject = i.sja;
    localObject = i.cCC();
    paramFinderCommentInfo = new com.tencent.mm.plugin.finder.loader.a(paramFinderCommentInfo.headUrl);
    i locali = i.sja;
    ((d)localObject).a(paramFinderCommentInfo, paramImageView, i.a(i.a.sjd));
    AppMethodBeat.o(205323);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$anim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    a(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205319);
      if (paramAnimator != null)
      {
        paramAnimator.cancel();
        AppMethodBeat.o(205319);
        return;
      }
      AppMethodBeat.o(205319);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(205320);
      this.kAn.setVisibility(0);
      AppMethodBeat.o(205320);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
      ad.d("LikeIconAnimationHelper", "valueScale=".concat(String.valueOf(f)));
      this.kAn.setScaleX(f);
      this.kAn.setScaleY(f);
      AppMethodBeat.o(168455);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startAvatarAnimator$6", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    public c(List paramList, y.f paramf, LinkedList paramLinkedList) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(205321);
      paramAnimator = ((Iterable)this.rNK).iterator();
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
      paramAnimator = (View)this.sXy.MLV;
      p.g(paramAnimator, "avatarExtra");
      paramAnimator.setVisibility(8);
      paramAnimator = (View)this.sXy.MLV;
      p.g(paramAnimator, "avatarExtra");
      paramAnimator.setTranslationX(0.0F);
      paramAnimator = c.sXx;
      paramAnimator = this.sXz.get(0);
      p.g(paramAnimator, "likeList[0]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      Object localObject = this.rNK.get(0);
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((View)localObject).findViewById(2131307453);
      p.g(localObject, "avatarLayoutList[0]!!.fi…yId(R.id.friend_avatar_1)");
      c.b(paramAnimator, (ImageView)localObject);
      paramAnimator = c.sXx;
      paramAnimator = this.sXz.get(1);
      p.g(paramAnimator, "likeList[1]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      localObject = this.rNK.get(1);
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((View)localObject).findViewById(2131307455);
      p.g(localObject, "avatarLayoutList[1]!!.fi…yId(R.id.friend_avatar_2)");
      c.b(paramAnimator, (ImageView)localObject);
      paramAnimator = c.sXx;
      paramAnimator = this.sXz.get(2);
      p.g(paramAnimator, "likeList[2]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      localObject = this.rNK.get(2);
      if (localObject == null) {
        p.gfZ();
      }
      localObject = ((View)localObject).findViewById(2131307457);
      p.g(localObject, "avatarLayoutList[2]!!.fi…yId(R.id.friend_avatar_3)");
      c.b(paramAnimator, (ImageView)localObject);
      AppMethodBeat.o(205321);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
        paramValueAnimator = new v("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(168456);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      this.kAn.setScaleX(f);
      this.kAn.setScaleY(f);
      AppMethodBeat.o(168456);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startWithAlpha$2", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class e
    implements Animator.AnimatorListener
  {
    e(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(168458);
      this.kAn.animate().alpha(0.0F).setStartDelay(300L).setListener((Animator.AnimatorListener)new a(this)).start();
      AppMethodBeat.o(168458);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startWithAlpha$2$onAnimationEnd$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
    public static final class a
      implements Animator.AnimatorListener
    {
      public final void onAnimationCancel(Animator paramAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(221575);
        this.sXA.kAn.setScaleX(1.0F);
        this.sXA.kAn.setScaleY(1.0F);
        this.sXA.kAn.setAlpha(1.0F);
        this.sXA.kAn.setVisibility(8);
        AppMethodBeat.o(221575);
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