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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
  extends RelativeLayout
  implements m
{
  private final j KCJ;
  private final LinkedList<k> KCK;
  private final Runnable KCL;
  private k KCM;
  private k KCN;
  private Set<l> KCO;
  private final Set<Object> KCP;
  private final Set<Object> KCQ;
  private boolean KCR;
  private boolean cEL;
  private final ap kFL;
  private final View.OnClickListener mOnClickListener;
  private int mRotation;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(131483);
    this.mRotation = 0;
    this.kFL = new ap(Looper.getMainLooper());
    this.KCJ = new j(this);
    this.KCK = new LinkedList();
    this.mOnClickListener = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(131477);
        if (paramAnonymousView == e.this) {
          e.a(e.this);
        }
        AppMethodBeat.o(131477);
      }
    };
    this.KCL = new Runnable()
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
    this.cEL = false;
    this.KCO = new b();
    this.KCP = new b();
    this.KCQ = new b();
    this.KCR = false;
    setVisibility(4);
    setBackgroundColor(0);
    setOnClickListener(this.mOnClickListener);
    paramContext = (WindowManager)getContext().getSystemService("window");
    if (paramContext != null) {
      this.mRotation = paramContext.getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(131483);
  }
  
  private static Animator P(View paramView, int paramInt)
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
  
  private static void cW(View paramView)
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
    this.KCO.add(paraml);
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
    ad.i("MicroMsg.AppBrandDialogContainerLayout", "showDialog dialog[%s] tid[%d]", new Object[] { paramk.getClass().getName(), Long.valueOf(Thread.currentThread().getId()) });
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      this.kFL.post(new Runnable()
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
    f.aB(getContext());
    if (this.KCJ.isRunning()) {
      this.KCJ.cancel();
    }
    View localView = paramk.getContentView();
    if (localView == null)
    {
      ad.w("MicroMsg.AppBrandDialogContainerLayout", "showDialog NULL dialogView from dialog[%s], stack=%s", new Object[] { paramk, Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(131484);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (localView.getParent() != this)
    {
      cW(localView);
      if (paramk.getPosition() != 2) {
        break label350;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      addView(localView, localLayoutParams);
      if (this.KCN != paramk)
      {
        localView.clearAnimation();
        if (paramk.getPosition() != 2) {
          break label371;
        }
        localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772064));
      }
    }
    for (;;)
    {
      this.KCN = paramk;
      localView.setOnClickListener(this.mOnClickListener);
      this.KCK.add(paramk);
      paramk.a(this);
      setVisibility(0);
      bringToFront();
      this.KCJ.c(Color.argb(127, 0, 0, 0), null);
      if ((this.KCO.isEmpty()) || (this.cEL)) {
        break label388;
      }
      paramk = this.KCO.iterator();
      while (paramk.hasNext()) {
        ((l)paramk.next()).f(Boolean.TRUE);
      }
      label350:
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      break;
      label371:
      localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130771999));
    }
    label388:
    this.cEL = true;
    AppMethodBeat.o(131484);
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(176009);
    this.KCO.remove(paraml);
    AppMethodBeat.o(176009);
  }
  
  public final void c(final k paramk)
  {
    AppMethodBeat.i(131485);
    if ((paramk == null) || (paramk.getContentView() == null))
    {
      AppMethodBeat.o(131485);
      return;
    }
    if (paramk.getContentView().getParent() != this)
    {
      AppMethodBeat.o(131485);
      return;
    }
    if (this.KCM == paramk)
    {
      AppMethodBeat.o(131485);
      return;
    }
    this.KCM = paramk;
    if (this.KCN == paramk) {
      this.KCN = null;
    }
    final View localView = paramk.getContentView();
    localView.animate().cancel();
    localView.clearAnimation();
    Animator localAnimator = P(localView, paramk.getPosition());
    localAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(131481);
        onAnimationEnd(paramAnonymousAnimator);
        AppMethodBeat.o(131481);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(131482);
        localView.setVisibility(8);
        e.b(e.this).remove(paramk);
        e.c(e.this);
        e.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(131480);
            e.this.removeView(e.4.this.KCT);
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
            AppMethodBeat.o(131480);
          }
        });
        AppMethodBeat.o(131482);
      }
    });
    localAnimator.start();
    if (this.KCK.size() <= 1) {
      this.KCJ.c(0, this.KCL);
    }
    if ((!this.KCO.isEmpty()) && (this.cEL))
    {
      paramk = this.KCO.iterator();
      while (paramk.hasNext()) {
        ((l)paramk.next()).f(Boolean.FALSE);
      }
    }
    this.cEL = false;
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
  
  public final void fQX()
  {
    AppMethodBeat.i(183778);
    if (this.KCJ.isRunning()) {
      this.KCJ.cancel();
    }
    if (!this.KCK.isEmpty())
    {
      a local5 = new a() {};
      while (!this.KCK.isEmpty()) {
        local5.apply(this.KCK.pollFirst());
      }
    }
    this.KCM = null;
    this.KCN = null;
    this.KCR = false;
    this.KCP.clear();
    this.KCQ.clear();
    removeAllViewsInLayout();
    this.kFL.removeCallbacksAndMessages(null);
    this.KCL.run();
    AppMethodBeat.o(183778);
  }
  
  public final k getCurrentDialog()
  {
    AppMethodBeat.i(131486);
    k localk = (k)this.KCK.peekLast();
    AppMethodBeat.o(131486);
    return localk;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(131489);
    k localk = (k)this.KCK.peekLast();
    if (localk == null)
    {
      setVisibility(8);
      AppMethodBeat.o(131489);
      return false;
    }
    if ((!localk.aEu()) && (localk.isCancelable()))
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
        paramConfiguration = this.KCK.iterator();
        while (paramConfiguration.hasNext()) {
          ((k)paramConfiguration.next()).pi(this.mRotation);
        }
      }
    }
    AppMethodBeat.o(131491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.e
 * JD-Core Version:    0.7.0.1
 */