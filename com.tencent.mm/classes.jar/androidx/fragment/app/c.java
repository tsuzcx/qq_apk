package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.c.b;
import androidx.core.c.b.a;
import androidx.core.g.u;
import androidx.fragment.a.a;
import androidx.fragment.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
{
  static a a(Context paramContext, Fragment paramFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(193792);
    int j = paramFragment.getNextTransition();
    int i;
    if (paramBoolean2) {
      if (paramBoolean1) {
        i = paramFragment.getPopEnterAnim();
      }
    }
    for (;;)
    {
      paramFragment.setAnimations(0, 0, 0, 0);
      if ((paramFragment.mContainer != null) && (paramFragment.mContainer.getTag(a.b.visible_removing_fragment_view_tag) != null)) {
        paramFragment.mContainer.setTag(a.b.visible_removing_fragment_view_tag, null);
      }
      if ((paramFragment.mContainer == null) || (paramFragment.mContainer.getLayoutTransition() == null)) {
        break;
      }
      AppMethodBeat.o(193792);
      return null;
      i = paramFragment.getPopExitAnim();
      continue;
      if (paramBoolean1) {
        i = paramFragment.getEnterAnim();
      } else {
        i = paramFragment.getExitAnim();
      }
    }
    Animation localAnimation = paramFragment.onCreateAnimation(j, paramBoolean1, i);
    if (localAnimation != null)
    {
      paramContext = new a(localAnimation);
      AppMethodBeat.o(193792);
      return paramContext;
    }
    paramFragment = paramFragment.onCreateAnimator(j, paramBoolean1, i);
    if (paramFragment != null)
    {
      paramContext = new a(paramFragment);
      AppMethodBeat.o(193792);
      return paramContext;
    }
    if ((i == 0) && (j != 0))
    {
      i = -1;
      switch (j)
      {
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        paramBoolean1 = "anim".equals(paramContext.getResources().getResourceTypeName(i));
        if (paramBoolean1) {}
        for (;;)
        {
          try
          {
            paramFragment = AnimationUtils.loadAnimation(paramContext, i);
            if (paramFragment != null)
            {
              paramFragment = new a(paramFragment);
              AppMethodBeat.o(193792);
              return paramFragment;
              if (paramBoolean1)
              {
                i = a.a.fragment_open_enter;
                break;
              }
              i = a.a.fragment_open_exit;
              break;
              if (paramBoolean1)
              {
                i = a.a.fragment_close_enter;
                break;
              }
              i = a.a.fragment_close_exit;
              break;
              if (paramBoolean1)
              {
                i = a.a.fragment_fade_enter;
                break;
              }
              i = a.a.fragment_fade_exit;
              break;
            }
            j = 1;
            if (j != 0) {
              break label432;
            }
            j = 0;
          }
          catch (Resources.NotFoundException paramContext)
          {
            try
            {
              paramFragment = AnimatorInflater.loadAnimator(paramContext, i);
              if (paramFragment == null) {
                break label432;
              }
              paramFragment = new a(paramFragment);
              AppMethodBeat.o(193792);
              return paramFragment;
            }
            catch (RuntimeException paramFragment)
            {
              if (!paramBoolean1) {
                break label405;
              }
              AppMethodBeat.o(193792);
              throw paramFragment;
              paramContext = AnimationUtils.loadAnimation(paramContext, i);
              if (paramContext == null) {
                break label432;
              }
              paramContext = new a(paramContext);
              AppMethodBeat.o(193792);
              return paramContext;
            }
            paramContext = paramContext;
            AppMethodBeat.o(193792);
            throw paramContext;
          }
          catch (RuntimeException paramFragment) {}
        }
      }
      label405:
      label432:
      AppMethodBeat.o(193792);
      return null;
    }
  }
  
  static final class a
  {
    public final Animator bCA;
    public final Animation bCz;
    
    a(Animator paramAnimator)
    {
      AppMethodBeat.i(193554);
      this.bCz = null;
      this.bCA = paramAnimator;
      if (paramAnimator == null)
      {
        paramAnimator = new IllegalStateException("Animator cannot be null");
        AppMethodBeat.o(193554);
        throw paramAnimator;
      }
      AppMethodBeat.o(193554);
    }
    
    a(Animation paramAnimation)
    {
      AppMethodBeat.i(193545);
      this.bCz = paramAnimation;
      this.bCA = null;
      if (paramAnimation == null)
      {
        paramAnimation = new IllegalStateException("Animation cannot be null");
        AppMethodBeat.o(193545);
        throw paramAnimation;
      }
      AppMethodBeat.o(193545);
    }
  }
  
  static final class b
    extends AnimationSet
    implements Runnable
  {
    private final ViewGroup bCB;
    private final View bCC;
    private boolean bCD;
    private boolean bCE;
    private boolean bwb;
    
    b(Animation paramAnimation, ViewGroup paramViewGroup, View paramView)
    {
      super();
      AppMethodBeat.i(193576);
      this.bwb = true;
      this.bCB = paramViewGroup;
      this.bCC = paramView;
      addAnimation(paramAnimation);
      this.bCB.post(this);
      AppMethodBeat.o(193576);
    }
    
    public final boolean getTransformation(long paramLong, Transformation paramTransformation)
    {
      AppMethodBeat.i(193584);
      this.bwb = true;
      if (this.bCD)
      {
        if (!this.bCE)
        {
          AppMethodBeat.o(193584);
          return true;
        }
        AppMethodBeat.o(193584);
        return false;
      }
      if (!super.getTransformation(paramLong, paramTransformation))
      {
        this.bCD = true;
        u.a(this.bCB, this);
      }
      AppMethodBeat.o(193584);
      return true;
    }
    
    public final boolean getTransformation(long paramLong, Transformation paramTransformation, float paramFloat)
    {
      AppMethodBeat.i(193593);
      this.bwb = true;
      if (this.bCD)
      {
        if (!this.bCE)
        {
          AppMethodBeat.o(193593);
          return true;
        }
        AppMethodBeat.o(193593);
        return false;
      }
      if (!super.getTransformation(paramLong, paramTransformation, paramFloat))
      {
        this.bCD = true;
        u.a(this.bCB, this);
      }
      AppMethodBeat.o(193593);
      return true;
    }
    
    public final void run()
    {
      AppMethodBeat.i(193602);
      if ((!this.bCD) && (this.bwb))
      {
        this.bwb = false;
        this.bCB.post(this);
        AppMethodBeat.o(193602);
        return;
      }
      this.bCB.endViewTransition(this.bCC);
      this.bCE = true;
      AppMethodBeat.o(193602);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.fragment.app.c
 * JD-Core Version:    0.7.0.1
 */