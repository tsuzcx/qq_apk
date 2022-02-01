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
  private boolean cMS;
  private final ap lEc;
  private final View.OnClickListener mOnClickListener;
  private int mRotation;
  private final j ndp;
  private final LinkedList<k> ndq;
  private final Runnable ndr;
  private k nds;
  private k ndt;
  private Set<l> ndu;
  private final Set<Object> ndv;
  private final Set<Object> ndx;
  private boolean ndy;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(131483);
    this.mRotation = 0;
    this.lEc = new ap(Looper.getMainLooper());
    this.ndp = new j(this);
    this.ndq = new LinkedList();
    this.mOnClickListener = new e.1(this);
    this.ndr = new Runnable()
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
    this.cMS = false;
    this.ndu = new b();
    this.ndv = new b();
    this.ndx = new b();
    this.ndy = false;
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
  
  public final void My()
  {
    AppMethodBeat.i(183778);
    if (this.ndp.isRunning()) {
      this.ndp.cancel();
    }
    if (!this.ndq.isEmpty())
    {
      a local6 = new a() {};
      while (!this.ndq.isEmpty()) {
        local6.apply(this.ndq.pollFirst());
      }
    }
    this.nds = null;
    this.ndt = null;
    this.ndy = false;
    this.ndv.clear();
    this.ndx.clear();
    removeAllViewsInLayout();
    this.lEc.removeCallbacksAndMessages(null);
    this.ndr.run();
    AppMethodBeat.o(183778);
  }
  
  public final void a(l paraml)
  {
    AppMethodBeat.i(176008);
    this.ndu.add(paraml);
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
      this.lEc.post(new Runnable()
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
    f.aC(getContext());
    if (this.ndp.isRunning()) {
      this.ndp.cancel();
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
      cZ(localView);
      if (paramk.getPosition() != 2) {
        break label357;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      addView(localView, localLayoutParams);
      if (this.ndt != paramk)
      {
        localView.clearAnimation();
        if (paramk.getPosition() != 2) {
          break label378;
        }
        localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772064));
      }
    }
    for (;;)
    {
      this.ndt = paramk;
      localView.setOnClickListener(this.mOnClickListener);
      this.ndq.add(paramk);
      paramk.a(this);
      setVisibility(0);
      bringToFront();
      this.ndp.c(Color.argb(127, 0, 0, 0), null);
      if ((this.ndu.isEmpty()) || (this.cMS)) {
        break label395;
      }
      paramk = this.ndu.iterator();
      while (paramk.hasNext()) {
        ((l)paramk.next()).h(Boolean.TRUE);
      }
      label357:
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      break;
      label378:
      localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130771999));
    }
    label395:
    this.cMS = true;
    AppMethodBeat.o(131484);
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(176009);
    this.ndu.remove(paraml);
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
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      this.lEc.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(199401);
          e.this.c(paramk);
          AppMethodBeat.o(199401);
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
    if (this.nds == paramk)
    {
      AppMethodBeat.o(131485);
      return;
    }
    this.nds = paramk;
    if (this.ndt == paramk) {
      this.ndt = null;
    }
    final View localView = paramk.getContentView();
    localView.animate().cancel();
    localView.clearAnimation();
    Animator localAnimator = Q(localView, paramk.getPosition());
    localAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(199403);
        onAnimationEnd(paramAnonymousAnimator);
        AppMethodBeat.o(199403);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(199404);
        localView.setVisibility(8);
        e.b(e.this).remove(paramk);
        e.c(e.this);
        e.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(199402);
            e.this.removeView(e.5.this.nbv);
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
            AppMethodBeat.o(199402);
          }
        });
        AppMethodBeat.o(199404);
      }
    });
    localAnimator.start();
    if (this.ndq.size() <= 1) {
      this.ndp.c(0, this.ndr);
    }
    if ((!this.ndu.isEmpty()) && (this.cMS))
    {
      paramk = this.ndu.iterator();
      while (paramk.hasNext()) {
        ((l)paramk.next()).h(Boolean.FALSE);
      }
    }
    this.cMS = false;
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
    k localk = (k)this.ndq.peekLast();
    AppMethodBeat.o(131486);
    return localk;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(131489);
    k localk = (k)this.ndq.peekLast();
    if (localk == null)
    {
      setVisibility(8);
      AppMethodBeat.o(131489);
      return false;
    }
    if ((!localk.aOv()) && (localk.isCancelable()))
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
        paramConfiguration = this.ndq.iterator();
        while (paramConfiguration.hasNext()) {
          ((k)paramConfiguration.next()).qy(this.mRotation);
        }
      }
    }
    AppMethodBeat.o(131491);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(199406);
    super.onViewRemoved(paramView);
    if (this.ndq.size() == 0) {
      this.ndp.c(0, this.ndr);
    }
    AppMethodBeat.o(199406);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.e
 * JD-Core Version:    0.7.0.1
 */