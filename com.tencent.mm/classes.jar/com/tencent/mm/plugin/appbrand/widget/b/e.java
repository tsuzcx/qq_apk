package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.g.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
  extends RelativeLayout
  implements l
{
  final Set<Object> jjk;
  private final j jjl;
  public final LinkedList<k> jjm;
  private final Runnable jjn;
  private k jjo;
  private k jjp;
  private final View.OnClickListener mOnClickListener;
  private int mRotation;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(77409);
    this.mRotation = 0;
    this.jjk = new HashSet();
    this.jjl = new j(this);
    this.jjm = new LinkedList();
    this.mOnClickListener = new e.1(this);
    this.jjn = new e.2(this);
    setVisibility(4);
    setBackgroundColor(0);
    setOnClickListener(this.mOnClickListener);
    paramContext = (WindowManager)getContext().getSystemService("window");
    if (paramContext != null) {
      this.mRotation = paramContext.getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(77409);
  }
  
  private static Animator K(View paramView, int paramInt)
  {
    AppMethodBeat.i(143025);
    if (paramInt == 2)
    {
      localObject = new AccelerateInterpolator();
      localAnimatorSet = new AnimatorSet();
      paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, paramView.getHeight() }).setDuration(200L);
      paramView.setInterpolator((TimeInterpolator)localObject);
      localAnimatorSet.playTogether(new Animator[] { paramView });
      AppMethodBeat.o(143025);
      return localAnimatorSet;
    }
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(paramView.getContext(), 2131034154);
    Object localObject = AnimationUtils.loadInterpolator(paramView.getContext(), 2131034153);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.9F }).setDuration(220L);
    localObjectAnimator1.setInterpolator(localInterpolator);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.9F }).setDuration(220L);
    localObjectAnimator2.setInterpolator(localInterpolator);
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(150L);
    paramView.setInterpolator((TimeInterpolator)localObject);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramView });
    AppMethodBeat.o(143025);
    return localAnimatorSet;
  }
  
  public final void b(k paramk)
  {
    int i = 1;
    AppMethodBeat.i(77410);
    if (paramk == null)
    {
      AppMethodBeat.o(77410);
      return;
    }
    ab.i("MicroMsg.AppBrandDialogContainerLayout", "showDialog dialog[%s] tid[%d]", new Object[] { paramk.getClass().getName(), Long.valueOf(Thread.currentThread().getId()) });
    if (!al.isMainThread())
    {
      al.d(new e.3(this, paramk));
      AppMethodBeat.o(77410);
      return;
    }
    f.av(getContext());
    Object localObject = this.jjl;
    View localView;
    if ((((j)localObject).ggX != null) && (((j)localObject).ggX.isRunning()))
    {
      if (i != 0)
      {
        localObject = this.jjl;
        if (((j)localObject).ggX != null) {
          ((j)localObject).ggX.cancel();
        }
      }
      localView = paramk.getContentView();
      if (localView.getParent() != this)
      {
        if ((localView != null) && (localView.getParent() != null)) {
          break label301;
        }
        label157:
        if (paramk.getPosition() != 2) {
          break label317;
        }
        localObject = new RelativeLayout.LayoutParams(-1, -2);
        ((RelativeLayout.LayoutParams)localObject).addRule(12);
        ((RelativeLayout.LayoutParams)localObject).addRule(14);
        label190:
        addView(localView, (ViewGroup.LayoutParams)localObject);
        if (this.jjp != paramk)
        {
          localView.clearAnimation();
          if (paramk.getPosition() != 2) {
            break label338;
          }
          localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2131034190));
        }
      }
    }
    for (;;)
    {
      this.jjp = paramk;
      localView.setOnClickListener(this.mOnClickListener);
      this.jjm.add(paramk);
      paramk.a(this);
      setVisibility(0);
      bringToFront();
      this.jjl.c(Color.argb(127, 0, 0, 0), null);
      AppMethodBeat.o(77410);
      return;
      i = 0;
      break;
      label301:
      ((ViewGroup)localView.getParent()).removeView(localView);
      break label157;
      label317:
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      break label190;
      label338:
      localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2131034139));
    }
  }
  
  public final void c(k paramk)
  {
    AppMethodBeat.i(77411);
    if (paramk.getContentView().getParent() != this)
    {
      AppMethodBeat.o(77411);
      return;
    }
    if (this.jjo == paramk)
    {
      AppMethodBeat.o(77411);
      return;
    }
    this.jjo = paramk;
    View localView = paramk.getContentView();
    localView.animate().cancel();
    localView.clearAnimation();
    Animator localAnimator = K(localView, paramk.getPosition());
    localAnimator.addListener(new e.4(this, localView, paramk));
    localAnimator.start();
    if (this.jjm.size() <= 1) {
      this.jjl.c(0, this.jjn);
    }
    AppMethodBeat.o(77411);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(77413);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(77413);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(77413);
    return bool;
  }
  
  public final k getCurrentDialog()
  {
    AppMethodBeat.i(77412);
    k localk = (k)this.jjm.peekLast();
    AppMethodBeat.o(77412);
    return localk;
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(77415);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = (WindowManager)getContext().getSystemService("window");
    if (paramConfiguration != null)
    {
      int i = paramConfiguration.getDefaultDisplay().getRotation();
      if (this.mRotation != i)
      {
        this.mRotation = i;
        paramConfiguration = this.jjm.iterator();
        while (paramConfiguration.hasNext()) {
          ((k)paramConfiguration.next()).pq(this.mRotation);
        }
      }
    }
    AppMethodBeat.o(77415);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.e
 * JD-Core Version:    0.7.0.1
 */