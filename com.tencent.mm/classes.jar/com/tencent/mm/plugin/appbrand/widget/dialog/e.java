package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.arch.a.c.a;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Looper;
import android.support.v4.e.b;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.luggage.h.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
  extends RelativeLayout
  implements m
{
  private boolean cNB;
  private final aq lIB;
  private final View.OnClickListener mOnClickListener;
  private int mRotation;
  private final Runnable ngA;
  private k ngB;
  private k ngG;
  private Set<l> ngH;
  private final Set<Object> ngI;
  private final Set<Object> ngJ;
  private boolean ngK;
  private boolean ngL;
  private final j ngy;
  private final LinkedList<k> ngz;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(131483);
    this.mRotation = 0;
    this.lIB = new aq(Looper.getMainLooper());
    this.ngy = new j(this);
    this.ngz = new LinkedList();
    this.mOnClickListener = new e.1(this);
    this.ngA = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131478);
        e.this.setBackgroundColor(0);
        e.this.removeAllViews();
        e.this.setVisibility(4);
        AppMethodBeat.o(131478);
      }
    };
    this.cNB = false;
    this.ngH = new b();
    this.ngI = new b();
    this.ngJ = new b();
    this.ngK = false;
    this.ngL = true;
    setVisibility(4);
    setBackgroundColor(0);
    setOnClickListener(this.mOnClickListener);
    paramContext = (WindowManager)getContext().getSystemService("window");
    if (paramContext != null) {
      this.mRotation = paramContext.getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(131483);
  }
  
  private static Animator Q(View paramView, int paramInt)
  {
    AppMethodBeat.i(131490);
    if (paramInt == 2)
    {
      localObject = new AccelerateInterpolator();
      localAnimatorSet = new AnimatorSet();
      paramView = ObjectAnimator.ofFloat(paramView, "translationY", new float[] { 0.0F, paramView.getHeight() }).setDuration(200L);
      paramView.setInterpolator((TimeInterpolator)localObject);
      localAnimatorSet.playTogether(new Animator[] { paramView });
      AppMethodBeat.o(131490);
      return localAnimatorSet;
    }
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(paramView.getContext(), 2130772015);
    Object localObject = AnimationUtils.loadInterpolator(paramView.getContext(), 2130772014);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(paramView, "scaleX", new float[] { 1.0F, 0.9F }).setDuration(220L);
    localObjectAnimator1.setInterpolator(localInterpolator);
    ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(paramView, "scaleY", new float[] { 1.0F, 0.9F }).setDuration(220L);
    localObjectAnimator2.setInterpolator(localInterpolator);
    paramView = ObjectAnimator.ofFloat(paramView, "alpha", new float[] { 1.0F, 0.0F }).setDuration(150L);
    paramView.setInterpolator((TimeInterpolator)localObject);
    localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2, paramView });
    AppMethodBeat.o(131490);
    return localAnimatorSet;
  }
  
  private static void cZ(View paramView)
  {
    AppMethodBeat.i(131487);
    if ((paramView == null) || (paramView.getParent() == null))
    {
      AppMethodBeat.o(131487);
      return;
    }
    ((ViewGroup)paramView.getParent()).removeView(paramView);
    AppMethodBeat.o(131487);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(176008);
    this.ngH.add(paraml);
    AppMethodBeat.o(176008);
  }
  
  public final void b(final k paramk)
  {
    AppMethodBeat.i(131484);
    if (paramk == null)
    {
      AppMethodBeat.o(131484);
      return;
    }
    ae.i("MicroMsg.AppBrandDialogContainerLayout", "showDialog dialog[%s] tid[%d]", new Object[] { paramk.getClass().getName(), Long.valueOf(Thread.currentThread().getId()) });
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      this.lIB.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131479);
          e.this.b(paramk);
          AppMethodBeat.o(131479);
        }
      });
      AppMethodBeat.o(131484);
      return;
    }
    f.aD(getContext());
    if (this.ngy.isRunning()) {
      this.ngy.cancel();
    }
    View localView = paramk.getContentView();
    if (localView == null)
    {
      ae.w("MicroMsg.AppBrandDialogContainerLayout", "showDialog NULL dialogView from dialog[%s], stack=%s", new Object[] { paramk, Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(131484);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (localView.getParent() != this)
    {
      cZ(localView);
      if (paramk.getPosition() != 2) {
        break label358;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      addView(localView, localLayoutParams);
      if (this.ngG != paramk)
      {
        localView.clearAnimation();
        if (paramk.getPosition() != 2) {
          break label379;
        }
        localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772064));
      }
    }
    for (;;)
    {
      this.ngG = paramk;
      localView.setOnClickListener(this.mOnClickListener);
      this.ngz.add(paramk);
      paramk.a(this);
      setVisibility(0);
      if (this.ngL) {
        bringToFront();
      }
      this.ngy.c(Color.argb(127, 0, 0, 0), null);
      if ((this.ngH.isEmpty()) || (this.cNB)) {
        break label396;
      }
      paramk = this.ngH.iterator();
      while (paramk.hasNext()) {
        ((l)paramk.next()).h(Boolean.TRUE);
      }
      label358:
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      break;
      label379:
      localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130771999));
    }
    label396:
    this.cNB = true;
    AppMethodBeat.o(131484);
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(176009);
    this.ngH.remove(paraml);
    AppMethodBeat.o(176009);
  }
  
  public final void bEI()
  {
    AppMethodBeat.i(183778);
    if (this.ngy.isRunning()) {
      this.ngy.cancel();
    }
    if (!this.ngz.isEmpty())
    {
      a local6 = new a() {};
      while (!this.ngz.isEmpty()) {
        local6.apply(this.ngz.pollFirst());
      }
    }
    this.ngB = null;
    this.ngG = null;
    this.ngK = false;
    this.ngI.clear();
    this.ngJ.clear();
    removeAllViewsInLayout();
    this.lIB.removeCallbacksAndMessages(null);
    this.ngA.run();
    AppMethodBeat.o(183778);
  }
  
  public final void c(final k paramk)
  {
    AppMethodBeat.i(131485);
    if ((paramk == null) || (paramk.getContentView() == null))
    {
      AppMethodBeat.o(131485);
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      this.lIB.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(200132);
          e.this.c(paramk);
          AppMethodBeat.o(200132);
        }
      });
      AppMethodBeat.o(131485);
      return;
    }
    if (paramk.getContentView().getParent() != this)
    {
      AppMethodBeat.o(131485);
      return;
    }
    if (this.ngB == paramk)
    {
      AppMethodBeat.o(131485);
      return;
    }
    this.ngB = paramk;
    if (this.ngG == paramk) {
      this.ngG = null;
    }
    final View localView = paramk.getContentView();
    localView.animate().cancel();
    localView.clearAnimation();
    Animator localAnimator = Q(localView, paramk.getPosition());
    localAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(200134);
        onAnimationEnd(paramAnonymousAnimator);
        AppMethodBeat.o(200134);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(200135);
        localView.setVisibility(8);
        e.b(e.this).remove(paramk);
        e.c(e.this);
        e.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(200133);
            e.this.removeView(e.5.this.ngE);
            e.a(e.this, true);
            Iterator localIterator = e.d(e.this).iterator();
            while (localIterator.hasNext()) {
              localIterator.next();
            }
            e.a(e.this, false);
            if (!e.e(e.this).isEmpty())
            {
              e.d(e.this).removeAll(e.e(e.this));
              e.e(e.this).clear();
            }
            AppMethodBeat.o(200133);
          }
        });
        AppMethodBeat.o(200135);
      }
    });
    localAnimator.start();
    if (this.ngz.size() <= 1) {
      this.ngy.c(0, this.ngA);
    }
    if ((!this.ngH.isEmpty()) && (this.cNB))
    {
      paramk = this.ngH.iterator();
      while (paramk.hasNext()) {
        ((l)paramk.next()).h(Boolean.FALSE);
      }
    }
    this.cNB = false;
    AppMethodBeat.o(131485);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(131488);
    if (getChildCount() == 0)
    {
      AppMethodBeat.o(131488);
      return false;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(131488);
    return bool;
  }
  
  public final k getCurrentDialog()
  {
    AppMethodBeat.i(131486);
    k localk = (k)this.ngz.peekLast();
    AppMethodBeat.o(131486);
    return localk;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(131489);
    k localk = (k)this.ngz.peekLast();
    if (localk == null)
    {
      setVisibility(8);
      AppMethodBeat.o(131489);
      return false;
    }
    if ((!localk.aOS()) && (localk.isCancelable()))
    {
      localk.onCancel();
      c(localk);
    }
    AppMethodBeat.o(131489);
    return true;
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(131491);
    super.onConfigurationChanged(paramConfiguration);
    paramConfiguration = (WindowManager)getContext().getSystemService("window");
    if (paramConfiguration != null)
    {
      int i = paramConfiguration.getDefaultDisplay().getRotation();
      if (this.mRotation != i)
      {
        this.mRotation = i;
        paramConfiguration = this.ngz.iterator();
        while (paramConfiguration.hasNext()) {
          ((k)paramConfiguration.next()).qB(this.mRotation);
        }
      }
    }
    AppMethodBeat.o(131491);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(200137);
    super.onViewRemoved(paramView);
    if (this.ngz.size() == 0) {
      this.ngy.c(0, this.ngA);
    }
    AppMethodBeat.o(200137);
  }
  
  public final void setShouldBringSelfToFrontWhenDialogShown(boolean paramBoolean)
  {
    this.ngL = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.e
 * JD-Core Version:    0.7.0.1
 */