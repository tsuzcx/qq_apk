package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper;", "", "()V", "TAG", "", "location", "", "anim", "", "view", "Landroid/view/View;", "from", "", "to", "listener", "Landroid/animation/Animator$AnimatorListener;", "setAvatarImg", "info", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Landroid/widget/ImageView;", "start", "startAvatarAnimator", "likeList", "Ljava/util/LinkedList;", "avatarLayoutList", "", "parent", "avatarRectControl", "", "startWithAlpha", "scale", "e", "Landroid/view/MotionEvent;", "isDetach", "heightOffset", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c GGo;
  private static final int[] bfh;
  
  static
  {
    AppMethodBeat.i(168461);
    GGo = new c();
    bfh = new int[2];
    AppMethodBeat.o(168461);
  }
  
  private static final void a(MotionEvent paramMotionEvent, View paramView, float paramFloat1, float paramFloat2, final boolean paramBoolean)
  {
    AppMethodBeat.i(345999);
    s.u(paramView, "$view");
    if (paramMotionEvent != null)
    {
      paramView.setTranslationX(0.0F);
      paramView.setTranslationY(0.0F);
      paramView.getLocationInWindow(bfh);
      paramView.setTranslationX(paramMotionEvent.getRawX() - bfh[0] - paramView.getWidth() / 2);
      paramView.setTranslationY(paramMotionEvent.getRawY() - bfh[1] - paramView.getHeight() / 2 + paramFloat2);
    }
    paramView.setAlpha(1.0F);
    paramMotionEvent = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { paramFloat1 * 0.5F, 1.75F * paramFloat1, 1.25F * paramFloat1, 1.5F * paramFloat1 }), PropertyValuesHolder.ofFloat("alpha", new float[] { 0.7F, 0.5F, 0.8F, 1.0F }) });
    paramMotionEvent.setDuration(500L).addUpdateListener(new c..ExternalSyntheticLambda1(paramView));
    paramMotionEvent.addListener((Animator.AnimatorListener)new c(paramView, paramBoolean));
    paramMotionEvent.start();
    AppMethodBeat.o(345999);
  }
  
  public static void a(View paramView, MotionEvent paramMotionEvent, float paramFloat)
  {
    AppMethodBeat.i(345941);
    s.u(paramView, "view");
    if (paramView.getVisibility() == 0)
    {
      AppMethodBeat.o(345941);
      return;
    }
    paramView.setVisibility(0);
    paramView.setAlpha(0.0F);
    paramView.post(new c..ExternalSyntheticLambda2(paramMotionEvent, paramView, 1.4F, paramFloat, true));
    AppMethodBeat.o(345941);
  }
  
  public static void a(View paramView, String paramString, float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(345953);
    paramString = ObjectAnimator.ofFloat(paramView, paramString, new float[] { paramFloat1, paramFloat2 });
    paramString.setDuration(500L);
    if (paramAnimatorListener != null) {
      paramString.addListener(paramAnimatorListener);
    }
    for (;;)
    {
      paramString.start();
      AppMethodBeat.o(345953);
      return;
      paramString.addListener((Animator.AnimatorListener)new a(paramView));
    }
  }
  
  public static void a(FinderCommentInfo paramFinderCommentInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(345968);
    paramImageView.setImageDrawable(null);
    if (s.p(paramFinderCommentInfo.username, z.bAM()))
    {
      paramFinderCommentInfo = p.ExI;
      paramFinderCommentInfo = p.eCr();
      localObject = new com.tencent.mm.plugin.finder.loader.b("");
      localp = p.ExI;
      paramFinderCommentInfo.a(localObject, paramImageView, p.a(p.a.ExN));
      paramFinderCommentInfo = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eRW().bmg()).intValue() == 1)
      {
        a.b.g(paramImageView, z.bAM());
        AppMethodBeat.o(345968);
        return;
      }
      a.b.a(paramImageView, z.bAM(), 0.0F, false);
      AppMethodBeat.o(345968);
      return;
    }
    Object localObject = p.ExI;
    localObject = p.eCr();
    paramFinderCommentInfo = new com.tencent.mm.plugin.finder.loader.b(paramFinderCommentInfo.headUrl);
    p localp = p.ExI;
    ((com.tencent.mm.loader.d)localObject).a(paramFinderCommentInfo, paramImageView, p.a(p.a.ExN));
    AppMethodBeat.o(345968);
  }
  
  private static final void c(View paramView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(345980);
    s.u(paramView, "$view");
    paramValueAnimator = paramValueAnimator.getAnimatedValue("scale");
    if (paramValueAnimator == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(345980);
      throw paramView;
    }
    float f = ((Float)paramValueAnimator).floatValue();
    Log.d("LikeIconAnimationHelper", s.X("valueScale=", Float.valueOf(f)));
    paramView.setScaleX(f);
    paramView.setScaleY(f);
    AppMethodBeat.o(345980);
  }
  
  private static final void d(View paramView, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(345989);
    s.u(paramView, "$view");
    Object localObject = paramValueAnimator.getAnimatedValue("scale");
    if (localObject == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(345989);
      throw paramView;
    }
    float f1 = ((Float)localObject).floatValue();
    paramValueAnimator = paramValueAnimator.getAnimatedValue("alpha");
    if (paramValueAnimator == null)
    {
      paramView = new NullPointerException("null cannot be cast to non-null type kotlin.Float");
      AppMethodBeat.o(345989);
      throw paramView;
    }
    float f2 = ((Float)paramValueAnimator).floatValue();
    paramView.setScaleX(f1);
    paramView.setScaleY(f1);
    paramView.setAlpha(f2);
    AppMethodBeat.o(345989);
  }
  
  public static void hd(View paramView)
  {
    AppMethodBeat.i(168459);
    s.u(paramView, "view");
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, 1.05F, 1.0F, 0.95F, 1.0F }) });
    localValueAnimator.setDuration(500L).addUpdateListener(new c..ExternalSyntheticLambda0(paramView));
    localValueAnimator.start();
    AppMethodBeat.o(168459);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$anim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Animator.AnimatorListener
  {
    a(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(346060);
      if (paramAnimator != null) {
        paramAnimator.cancel();
      }
      AppMethodBeat.o(346060);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(346071);
      this.$view.setVisibility(0);
      AppMethodBeat.o(346071);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startAvatarAnimator$6", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements Animator.AnimatorListener
  {
    public b(List<View> paramList, ah.f<View> paramf, LinkedList<FinderCommentInfo> paramLinkedList) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(345971);
      paramAnimator = ((Iterable)this.AIT).iterator();
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
      ((View)this.GGp.aqH).setVisibility(8);
      ((View)this.GGp.aqH).setTranslationX(0.0F);
      paramAnimator = c.GGo;
      paramAnimator = this.AIQ.get(0);
      s.s(paramAnimator, "likeList[0]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      Object localObject = this.AIT.get(0);
      s.checkNotNull(localObject);
      localObject = ((View)localObject).findViewById(e.e.friend_avatar_1);
      s.s(localObject, "avatarLayoutList[0]!!.fi…yId(R.id.friend_avatar_1)");
      c.b(paramAnimator, (ImageView)localObject);
      paramAnimator = c.GGo;
      paramAnimator = this.AIQ.get(1);
      s.s(paramAnimator, "likeList[1]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      localObject = this.AIT.get(1);
      s.checkNotNull(localObject);
      localObject = ((View)localObject).findViewById(e.e.friend_avatar_2);
      s.s(localObject, "avatarLayoutList[1]!!.fi…yId(R.id.friend_avatar_2)");
      c.b(paramAnimator, (ImageView)localObject);
      paramAnimator = c.GGo;
      paramAnimator = this.AIQ.get(2);
      s.s(paramAnimator, "likeList[2]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      localObject = this.AIT.get(2);
      s.checkNotNull(localObject);
      localObject = ((View)localObject).findViewById(e.e.friend_avatar_3);
      s.s(localObject, "avatarLayoutList[2]!!.fi…yId(R.id.friend_avatar_3)");
      c.b(paramAnimator, (ImageView)localObject);
      AppMethodBeat.o(345971);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startWithAlpha$1$3", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements Animator.AnimatorListener
  {
    c(View paramView, boolean paramBoolean) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(346006);
      this.$view.animate().alpha(0.0F).setStartDelay(300L).setListener((Animator.AnimatorListener)new a(this.$view, paramBoolean)).start();
      AppMethodBeat.o(346006);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startWithAlpha$1$3$onAnimationEnd$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements Animator.AnimatorListener
    {
      a(View paramView, boolean paramBoolean) {}
      
      private static final void he(View paramView)
      {
        AppMethodBeat.i(346066);
        s.u(paramView, "$view");
        ViewParent localViewParent = paramView.getParent();
        if (localViewParent == null)
        {
          paramView = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
          AppMethodBeat.o(346066);
          throw paramView;
        }
        ((ViewGroup)localViewParent).removeView(paramView);
        AppMethodBeat.o(346066);
      }
      
      public final void onAnimationCancel(Animator paramAnimator) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(346096);
        this.$view.setScaleX(1.0F);
        this.$view.setScaleY(1.0F);
        this.$view.setAlpha(1.0F);
        this.$view.setTranslationX(0.0F);
        this.$view.setTranslationY(0.0F);
        this.$view.setVisibility(8);
        if (this.GGq) {
          this.$view.post(new c.c.a..ExternalSyntheticLambda0(this.$view));
        }
        AppMethodBeat.o(346096);
      }
      
      public final void onAnimationRepeat(Animator paramAnimator) {}
      
      public final void onAnimationStart(Animator paramAnimator) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.c
 * JD-Core Version:    0.7.0.1
 */