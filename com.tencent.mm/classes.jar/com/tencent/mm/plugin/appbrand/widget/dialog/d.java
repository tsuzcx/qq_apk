package com.tencent.mm.plugin.appbrand.widget.dialog;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Looper;
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
import androidx.a.a.c.a;
import androidx.b.b;
import com.tencent.luggage.k.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.n.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class d
  extends RelativeLayout
  implements l
{
  private boolean dic;
  private final View.OnClickListener mOnClickListener;
  private int mRotation;
  private final MMHandler pRi;
  private Set<k> rsG;
  private final Set<Object> rsH;
  private final Set<Object> rsI;
  private boolean rsJ;
  private final i rsm;
  private final LinkedList<j> rso;
  private final Runnable rsp;
  private j rsq;
  private j rsr;
  private boolean rtL;
  
  public d(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(131483);
    this.mRotation = 0;
    this.pRi = new MMHandler(Looper.getMainLooper());
    this.rsm = new i(this);
    this.rso = new LinkedList();
    this.mOnClickListener = new d.1(this);
    this.rsp = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131478);
        d.this.setBackgroundColor(0);
        d.this.removeAllViews();
        d.this.setVisibility(4);
        AppMethodBeat.o(131478);
      }
    };
    this.dic = false;
    this.rsG = new b();
    this.rsH = new b();
    this.rsI = new b();
    this.rsJ = false;
    this.rtL = true;
    setVisibility(4);
    setBackgroundColor(0);
    setOnClickListener(this.mOnClickListener);
    paramContext = (WindowManager)getContext().getSystemService("window");
    if (paramContext != null) {
      this.mRotation = paramContext.getDefaultDisplay().getRotation();
    }
    AppMethodBeat.o(131483);
  }
  
  private static Animator R(View paramView, int paramInt)
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
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(paramView.getContext(), n.a.decelerate_quint_interpolator);
    Object localObject = AnimationUtils.loadInterpolator(paramView.getContext(), n.a.decelerate_cubic_interpolator);
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
  
  private static void dl(View paramView)
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
  
  public final void a(final j paramj)
  {
    AppMethodBeat.i(131484);
    if (paramj == null)
    {
      AppMethodBeat.o(131484);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandDialogContainerLayout", "showDialog dialog[%s] tid[%d]", new Object[] { paramj.getClass().getName(), Long.valueOf(Thread.currentThread().getId()) });
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      this.pRi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131479);
          d.this.a(paramj);
          AppMethodBeat.o(131479);
        }
      });
      AppMethodBeat.o(131484);
      return;
    }
    g.aK(getContext());
    if (this.rsm.isRunning()) {
      this.rsm.cancel();
    }
    View localView = paramj.getContentView();
    if (localView == null)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandDialogContainerLayout", "showDialog NULL dialogView from dialog[%s], stack=%s", new Object[] { paramj, android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(131484);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (localView.getParent() != this)
    {
      dl(localView);
      if (paramj.getPosition() != 2) {
        break label357;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      addView(localView, localLayoutParams);
      if (this.rsr != paramj)
      {
        localView.clearAnimation();
        if (paramj.getPosition() != 2) {
          break label378;
        }
        localView.startAnimation(AnimationUtils.loadAnimation(getContext(), n.a.in_from_bottom));
      }
    }
    for (;;)
    {
      this.rsr = paramj;
      localView.setOnClickListener(this.mOnClickListener);
      this.rso.add(paramj);
      paramj.a(this);
      setVisibility(0);
      if (this.rtL) {
        bringToFront();
      }
      this.rsm.c(Color.argb(127, 0, 0, 0), null);
      if ((this.rsG.isEmpty()) || (this.dic)) {
        break label395;
      }
      paramj = this.rsG.iterator();
      while (paramj.hasNext()) {
        ((k)paramj.next()).l(Boolean.TRUE);
      }
      label357:
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      break;
      label378:
      localView.startAnimation(AnimationUtils.loadAnimation(getContext(), n.a.appbrand_dialog_enter));
    }
    label395:
    this.dic = true;
    AppMethodBeat.o(131484);
  }
  
  public final void a(k paramk)
  {
    AppMethodBeat.i(176008);
    this.rsG.add(paramk);
    AppMethodBeat.o(176008);
  }
  
  public final void b(final j paramj)
  {
    AppMethodBeat.i(131485);
    if ((paramj == null) || (paramj.getContentView() == null))
    {
      AppMethodBeat.o(131485);
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      this.pRi.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(230406);
          d.this.b(paramj);
          AppMethodBeat.o(230406);
        }
      });
      AppMethodBeat.o(131485);
      return;
    }
    if (paramj.getContentView().getParent() != this)
    {
      AppMethodBeat.o(131485);
      return;
    }
    if (this.rsq == paramj)
    {
      AppMethodBeat.o(131485);
      return;
    }
    this.rsq = paramj;
    if (this.rsr == paramj) {
      this.rsr = null;
    }
    final View localView = paramj.getContentView();
    localView.animate().cancel();
    localView.clearAnimation();
    Animator localAnimator = R(localView, paramj.getPosition());
    localAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(229389);
        onAnimationEnd(paramAnonymousAnimator);
        AppMethodBeat.o(229389);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(229392);
        localView.setVisibility(8);
        d.b(d.this).remove(paramj);
        d.c(d.this);
        d.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(230474);
            d.this.removeView(d.5.this.rrO);
            d.a(d.this, true);
            Iterator localIterator = d.d(d.this).iterator();
            while (localIterator.hasNext()) {
              localIterator.next();
            }
            d.a(d.this, false);
            if (!d.e(d.this).isEmpty())
            {
              d.d(d.this).removeAll(d.e(d.this));
              d.e(d.this).clear();
            }
            AppMethodBeat.o(230474);
          }
        });
        AppMethodBeat.o(229392);
      }
    });
    localAnimator.start();
    if (this.rso.size() <= 1) {
      this.rsm.c(0, this.rsp);
    }
    if ((!this.rsG.isEmpty()) && (this.dic))
    {
      paramj = this.rsG.iterator();
      while (paramj.hasNext()) {
        ((k)paramj.next()).l(Boolean.FALSE);
      }
    }
    this.dic = false;
    AppMethodBeat.o(131485);
  }
  
  public final void b(k paramk)
  {
    AppMethodBeat.i(176009);
    this.rsG.remove(paramk);
    AppMethodBeat.o(176009);
  }
  
  public final void cnJ()
  {
    AppMethodBeat.i(183778);
    if (this.rsm.isRunning()) {
      this.rsm.cancel();
    }
    if (!this.rso.isEmpty())
    {
      a local6 = new a() {};
      while (!this.rso.isEmpty()) {
        local6.apply(this.rso.pollFirst());
      }
    }
    this.rsq = null;
    this.rsr = null;
    this.rsJ = false;
    this.rsH.clear();
    this.rsI.clear();
    removeAllViewsInLayout();
    this.pRi.removeCallbacksAndMessages(null);
    this.rsp.run();
    AppMethodBeat.o(183778);
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
  
  public final j getCurrentDialog()
  {
    AppMethodBeat.i(131486);
    j localj = (j)this.rso.peekLast();
    AppMethodBeat.o(131486);
    return localj;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(131489);
    j localj = (j)this.rso.peekLast();
    if (localj == null)
    {
      setVisibility(8);
      AppMethodBeat.o(131489);
      return false;
    }
    if ((!localj.bsB()) && (localj.isCancelable()))
    {
      localj.onCancel();
      b(localj);
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
        paramConfiguration = this.rso.iterator();
        while (paramConfiguration.hasNext()) {
          ((j)paramConfiguration.next()).xu(this.mRotation);
        }
      }
    }
    AppMethodBeat.o(131491);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(229615);
    super.onViewRemoved(paramView);
    if (this.rso.size() == 0) {
      this.rsm.c(0, this.rsp);
    }
    AppMethodBeat.o(229615);
  }
  
  public final void setShouldBringSelfToFrontWhenDialogShown(boolean paramBoolean)
  {
    this.rtL = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.d
 * JD-Core Version:    0.7.0.1
 */