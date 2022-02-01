package com.tencent.mm.plugin.finder.view.animation;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.storage.config.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.FinderCommentInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.z.f;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper;", "", "()V", "TAG", "", "location", "", "anim", "", "view", "Landroid/view/View;", "from", "", "to", "listener", "Landroid/animation/Animator$AnimatorListener;", "setAvatarImg", "info", "Lcom/tencent/mm/protocal/protobuf/FinderCommentInfo;", "Landroid/widget/ImageView;", "start", "startAvatarAnimator", "likeList", "Ljava/util/LinkedList;", "avatarLayoutList", "", "parent", "avatarRectControl", "", "startWithAlpha", "scale", "e", "Landroid/view/MotionEvent;", "isDetach", "heightOffset", "plugin-finder_release"})
public final class c
{
  private static final int[] wrA;
  public static final c wrB;
  
  static
  {
    AppMethodBeat.i(168461);
    wrB = new c();
    wrA = new int[2];
    AppMethodBeat.o(168461);
  }
  
  public static void a(final View paramView, final float paramFloat1, MotionEvent paramMotionEvent, final boolean paramBoolean, final float paramFloat2)
  {
    AppMethodBeat.i(255172);
    p.h(paramView, "view");
    if (paramView.getVisibility() == 0)
    {
      AppMethodBeat.o(255172);
      return;
    }
    paramView.setVisibility(0);
    paramView.setAlpha(0.0F);
    paramView.post((Runnable)new d(paramMotionEvent, paramView, paramFloat2, paramFloat1, paramBoolean));
    AppMethodBeat.o(255172);
  }
  
  private static void a(View paramView, String paramString, float paramFloat1, float paramFloat2, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(255175);
    paramString = ObjectAnimator.ofFloat(paramView, paramString, new float[] { paramFloat1, paramFloat2 });
    p.g(paramString, "tranX");
    paramString.setDuration(500L);
    if (paramAnimatorListener != null) {
      paramString.addListener(paramAnimatorListener);
    }
    for (;;)
    {
      paramString.start();
      AppMethodBeat.o(255175);
      return;
      paramString.addListener((Animator.AnimatorListener)new a(paramView));
    }
  }
  
  private static void a(FinderCommentInfo paramFinderCommentInfo, ImageView paramImageView)
  {
    AppMethodBeat.i(255176);
    if (p.j(paramFinderCommentInfo.username, z.aTY()))
    {
      paramFinderCommentInfo = com.tencent.mm.plugin.finder.storage.c.vCb;
      if (((Number)com.tencent.mm.plugin.finder.storage.c.dsq().value()).intValue() == 1)
      {
        a.b.c(paramImageView, z.aTY());
        AppMethodBeat.o(255176);
        return;
      }
      a.b.d(paramImageView, z.aTY(), 0.0F);
      AppMethodBeat.o(255176);
      return;
    }
    Object localObject = m.uJa;
    localObject = m.dkc();
    paramFinderCommentInfo = new com.tencent.mm.plugin.finder.loader.a(paramFinderCommentInfo.headUrl);
    m localm = m.uJa;
    ((d)localObject).a(paramFinderCommentInfo, paramImageView, m.a(m.a.uJf));
    AppMethodBeat.o(255176);
  }
  
  public static void c(final LinkedList<FinderCommentInfo> paramLinkedList, List<View> paramList, View paramView, boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(255174);
    p.h(paramLinkedList, "likeList");
    p.h(paramList, "avatarLayoutList");
    p.h(paramView, "parent");
    int k = paramLinkedList.size();
    if (k == 0)
    {
      AppMethodBeat.o(255174);
      return;
    }
    float f;
    if (paramBoolean)
    {
      localObject1 = (View)paramList.get(0);
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).getContext();
        if (localObject1 != null)
        {
          localObject1 = ((Context)localObject1).getResources();
          if (localObject1 == null) {}
        }
      }
      for (f = ((Resources)localObject1).getDimension(2131165300);; f = 0.0F)
      {
        if (k == 1)
        {
          localObject1 = (View)paramList.get(0);
          if (localObject1 != null) {
            ((View)localObject1).setVisibility(0);
          }
        }
        if ((k != 2) && (k != 3)) {
          break label405;
        }
        if (k <= paramList.size()) {
          break;
        }
        AppMethodBeat.o(255174);
        return;
      }
    }
    Object localObject1 = (View)paramList.get(0);
    if (localObject1 != null) {}
    for (localObject1 = ((View)localObject1).getContext();; localObject1 = null)
    {
      f = com.tencent.mm.cb.a.fromDPToPix((Context)localObject1, 14);
      break;
    }
    int m = k - 2;
    if (m >= 0)
    {
      i = 0;
      for (;;)
      {
        localObject1 = (View)paramList.get(i);
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(0);
        }
        if (i == m) {
          break;
        }
        i += 1;
      }
    }
    localObject1 = (View)paramList.get(0);
    if (localObject1 != null) {
      ((View)localObject1).setVisibility(0);
    }
    if (localObject1 == null) {
      p.hyc();
    }
    a((View)localObject1, "alpha", 0.0F, 1.0F, null);
    int i = 1;
    while (i < k)
    {
      localObject1 = (View)paramList.get(i);
      if (localObject1 != null) {
        a((View)localObject1, "translationX", -f, 0.0F, null);
      }
      i += 1;
    }
    localObject1 = paramView.findViewById(2131306597);
    Object localObject2 = paramView.findViewById(2131306594);
    if (localObject1 != null) {
      a((View)localObject1, "translationX", -f, 0.0F, null);
    }
    if (localObject2 != null) {
      a((View)localObject2, "translationX", -f, 0.0F, null);
    }
    label405:
    if (k > 3)
    {
      localObject1 = new z.f();
      ((z.f)localObject1).SYG = paramView.findViewById(2131301780);
      paramView = (View)((z.f)localObject1).SYG;
      p.g(paramView, "avatarExtra");
      paramView.setVisibility(0);
      paramView = paramLinkedList.get(0);
      p.g(paramView, "likeList[0]");
      paramView = (FinderCommentInfo)paramView;
      localObject2 = ((View)((z.f)localObject1).SYG).findViewById(2131301776);
      p.g(localObject2, "avatarExtra.findViewById(R.id.friend_avatar_extra)");
      a(paramView, (ImageView)localObject2);
      paramView = paramLinkedList.get(1);
      p.g(paramView, "likeList[1]");
      paramView = (FinderCommentInfo)paramView;
      localObject2 = paramList.get(0);
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = ((View)localObject2).findViewById(2131301770);
      p.g(localObject2, "avatarLayoutList[0]!!.fi…yId(R.id.friend_avatar_1)");
      a(paramView, (ImageView)localObject2);
      paramView = paramLinkedList.get(2);
      p.g(paramView, "likeList[2]");
      paramView = (FinderCommentInfo)paramView;
      localObject2 = paramList.get(1);
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = ((View)localObject2).findViewById(2131301772);
      p.g(localObject2, "avatarLayoutList[1]!!.fi…yId(R.id.friend_avatar_2)");
      a(paramView, (ImageView)localObject2);
      paramView = paramLinkedList.get(3);
      p.g(paramView, "likeList[3]");
      paramView = (FinderCommentInfo)paramView;
      localObject2 = paramList.get(2);
      if (localObject2 == null) {
        p.hyc();
      }
      localObject2 = ((View)localObject2).findViewById(2131301774);
      p.g(localObject2, "avatarLayoutList[2]!!.fi…yId(R.id.friend_avatar_3)");
      a(paramView, (ImageView)localObject2);
      paramView = ((Iterable)paramList).iterator();
      for (;;)
      {
        i = j;
        if (!paramView.hasNext()) {
          break;
        }
        localObject2 = (View)paramView.next();
        if (localObject2 != null) {
          ((View)localObject2).setVisibility(0);
        }
      }
      while (i < 2)
      {
        paramView = (View)paramList.get(i);
        if (paramView != null) {
          a(paramView, "translationX", 0.0F, f, null);
        }
        i += 1;
      }
      paramView = paramList.get(2);
      if (paramView == null) {
        p.hyc();
      }
      a((View)paramView, "alpha", 1.0F, 0.0F, null);
      paramView = (View)((z.f)localObject1).SYG;
      p.g(paramView, "avatarExtra");
      a(paramView, "alpha", 0.0F, 1.0F, (Animator.AnimatorListener)new c(paramList, (z.f)localObject1, paramLinkedList));
    }
    AppMethodBeat.o(255174);
  }
  
  public static void ei(View paramView)
  {
    AppMethodBeat.i(168459);
    p.h(paramView, "view");
    ValueAnimator localValueAnimator = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { 1.0F, 1.05F, 1.0F, 0.95F, 1.0F }) });
    localValueAnimator.setDuration(500L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new b(paramView));
    localValueAnimator.start();
    AppMethodBeat.o(168459);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$anim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class a
    implements Animator.AnimatorListener
  {
    a(View paramView) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(255164);
      if (paramAnimator != null)
      {
        paramAnimator.cancel();
        AppMethodBeat.o(255164);
        return;
      }
      AppMethodBeat.o(255164);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator)
    {
      AppMethodBeat.i(255165);
      this.hCI.setVisibility(0);
      AppMethodBeat.o(255165);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"})
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
        paramValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
        AppMethodBeat.o(168455);
        throw paramValueAnimator;
      }
      float f = ((Float)paramValueAnimator).floatValue();
      Log.d("LikeIconAnimationHelper", "valueScale=".concat(String.valueOf(f)));
      this.hCI.setScaleX(f);
      this.hCI.setScaleY(f);
      AppMethodBeat.o(168455);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startAvatarAnimator$6", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
  public static final class c
    implements Animator.AnimatorListener
  {
    c(List paramList, z.f paramf, LinkedList paramLinkedList) {}
    
    public final void onAnimationCancel(Animator paramAnimator) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(255166);
      paramAnimator = ((Iterable)this.tBi).iterator();
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
      paramAnimator = (View)this.wrC.SYG;
      p.g(paramAnimator, "avatarExtra");
      paramAnimator.setVisibility(8);
      paramAnimator = (View)this.wrC.SYG;
      p.g(paramAnimator, "avatarExtra");
      paramAnimator.setTranslationX(0.0F);
      paramAnimator = c.wrB;
      paramAnimator = paramLinkedList.get(0);
      p.g(paramAnimator, "likeList[0]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      Object localObject = this.tBi.get(0);
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((View)localObject).findViewById(2131301770);
      p.g(localObject, "avatarLayoutList[0]!!.fi…yId(R.id.friend_avatar_1)");
      c.b(paramAnimator, (ImageView)localObject);
      paramAnimator = c.wrB;
      paramAnimator = paramLinkedList.get(1);
      p.g(paramAnimator, "likeList[1]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      localObject = this.tBi.get(1);
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((View)localObject).findViewById(2131301772);
      p.g(localObject, "avatarLayoutList[1]!!.fi…yId(R.id.friend_avatar_2)");
      c.b(paramAnimator, (ImageView)localObject);
      paramAnimator = c.wrB;
      paramAnimator = paramLinkedList.get(2);
      p.g(paramAnimator, "likeList[2]");
      paramAnimator = (FinderCommentInfo)paramAnimator;
      localObject = this.tBi.get(2);
      if (localObject == null) {
        p.hyc();
      }
      localObject = ((View)localObject).findViewById(2131301774);
      p.g(localObject, "avatarLayoutList[2]!!.fi…yId(R.id.friend_avatar_3)");
      c.b(paramAnimator, (ImageView)localObject);
      AppMethodBeat.o(255166);
    }
    
    public final void onAnimationRepeat(Animator paramAnimator) {}
    
    public final void onAnimationStart(Animator paramAnimator) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(MotionEvent paramMotionEvent, View paramView, float paramFloat1, float paramFloat2, boolean paramBoolean) {}
    
    public final void run()
    {
      AppMethodBeat.i(255171);
      if (this.wrE != null)
      {
        paramView.setTranslationX(0.0F);
        paramView.setTranslationY(0.0F);
        localObject = paramView;
        c localc = c.wrB;
        ((View)localObject).getLocationInWindow(c.dHr());
        localObject = paramView;
        float f = this.wrE.getX();
        localc = c.wrB;
        ((View)localObject).setTranslationX(f - c.dHr()[0] - paramView.getWidth() / 2);
        localObject = paramView;
        f = this.wrE.getY();
        localc = c.wrB;
        ((View)localObject).setTranslationY(f - c.dHr()[1] - paramView.getHeight() / 2 + paramFloat2);
      }
      paramView.setAlpha(1.0F);
      Object localObject = ValueAnimator.ofPropertyValuesHolder(new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat("scale", new float[] { paramFloat1 * 0.5F, paramFloat1 * 1.75F, paramFloat1 * 1.25F, paramFloat1 * 1.5F }), PropertyValuesHolder.ofFloat("alpha", new float[] { 0.7F, 0.5F, 0.8F, 1.0F }) });
      ((ValueAnimator)localObject).setDuration(500L).addUpdateListener((ValueAnimator.AnimatorUpdateListener)new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(255167);
          Object localObject = paramAnonymousValueAnimator.getAnimatedValue("scale");
          if (localObject == null)
          {
            paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
            AppMethodBeat.o(255167);
            throw paramAnonymousValueAnimator;
          }
          float f1 = ((Float)localObject).floatValue();
          paramAnonymousValueAnimator = paramAnonymousValueAnimator.getAnimatedValue("alpha");
          if (paramAnonymousValueAnimator == null)
          {
            paramAnonymousValueAnimator = new t("null cannot be cast to non-null type kotlin.Float");
            AppMethodBeat.o(255167);
            throw paramAnonymousValueAnimator;
          }
          float f2 = ((Float)paramAnonymousValueAnimator).floatValue();
          this.wrI.hCI.setScaleX(f1);
          this.wrI.hCI.setScaleY(f1);
          this.wrI.hCI.setAlpha(f2);
          AppMethodBeat.o(255167);
        }
      });
      ((ValueAnimator)localObject).addListener((Animator.AnimatorListener)new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(255170);
          this.wrI.hCI.animate().alpha(0.0F).setStartDelay(300L).setListener((Animator.AnimatorListener)new a(this)).start();
          AppMethodBeat.o(255170);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator) {}
        
        @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/view/animation/LikeIconAnimationHelper$startWithAlpha$1$3$onAnimationEnd$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "plugin-finder_release"})
        public static final class a
          implements Animator.AnimatorListener
        {
          public final void onAnimationCancel(Animator paramAnimator) {}
          
          public final void onAnimationEnd(Animator paramAnimator)
          {
            AppMethodBeat.i(255169);
            this.wrJ.wrI.hCI.setScaleX(1.0F);
            this.wrJ.wrI.hCI.setScaleY(1.0F);
            this.wrJ.wrI.hCI.setAlpha(1.0F);
            this.wrJ.wrI.hCI.setTranslationX(0.0F);
            this.wrJ.wrI.hCI.setTranslationY(0.0F);
            this.wrJ.wrI.hCI.setVisibility(8);
            if (this.wrJ.wrI.wrH) {
              this.wrJ.wrI.hCI.post((Runnable)new a(this));
            }
            AppMethodBeat.o(255169);
          }
          
          public final void onAnimationRepeat(Animator paramAnimator) {}
          
          public final void onAnimationStart(Animator paramAnimator) {}
          
          @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
          static final class a
            implements Runnable
          {
            a(c.d.2.a parama) {}
            
            public final void run()
            {
              AppMethodBeat.i(255168);
              Object localObject = this.wrK.wrJ.wrI.hCI.getParent();
              if (localObject == null)
              {
                localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
                AppMethodBeat.o(255168);
                throw ((Throwable)localObject);
              }
              ((ViewGroup)localObject).removeView(this.wrK.wrJ.wrI.hCI);
              AppMethodBeat.o(255168);
            }
          }
        }
      });
      ((ValueAnimator)localObject).start();
      AppMethodBeat.o(255171);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.animation.c
 * JD-Core Version:    0.7.0.1
 */