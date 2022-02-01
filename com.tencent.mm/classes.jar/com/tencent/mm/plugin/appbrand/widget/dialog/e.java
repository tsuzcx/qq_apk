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
import com.tencent.luggage.h.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e
  extends RelativeLayout
  implements m
{
  private final j Atv;
  private final LinkedList<k> Atw;
  private final Runnable Atx;
  private k GcY;
  private final Set<Object> GdC;
  private final Set<Object> GdH;
  private boolean GdI;
  private k Gdg;
  private Set<l> Gdi;
  private boolean GfG;
  private boolean ddZ;
  private final View.OnClickListener mOnClickListener;
  private final MMHandler mQp;
  private int mRotation;
  
  public e(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(131483);
    this.mRotation = 0;
    this.mQp = new MMHandler(Looper.getMainLooper());
    this.Atv = new j(this);
    this.Atw = new LinkedList();
    this.mOnClickListener = new e.1(this);
    this.Atx = new Runnable()
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
    this.ddZ = false;
    this.Gdi = new b();
    this.GdC = new b();
    this.GdH = new b();
    this.GdI = false;
    this.GfG = true;
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
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(paramView.getContext(), 2130772021);
    Object localObject = AnimationUtils.loadInterpolator(paramView.getContext(), 2130772020);
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
  
  private static void cS(View paramView)
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
    this.Gdi.add(paraml);
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
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandDialogContainerLayout", "showDialog dialog[%s] tid[%d]", new Object[] { paramk.getClass().getName(), Long.valueOf(Thread.currentThread().getId()) });
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      this.mQp.post(new Runnable()
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
    g.aM(getContext());
    if (this.Atv.isRunning()) {
      this.Atv.cancel();
    }
    View localView = paramk.getContentView();
    if (localView == null)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandDialogContainerLayout", "showDialog NULL dialogView from dialog[%s], stack=%s", new Object[] { paramk, android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(131484);
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams;
    if (localView.getParent() != this)
    {
      cS(localView);
      if (paramk.getPosition() != 2) {
        break label358;
      }
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
      localLayoutParams.addRule(12);
      localLayoutParams.addRule(14);
      addView(localView, localLayoutParams);
      if (this.Gdg != paramk)
      {
        localView.clearAnimation();
        if (paramk.getPosition() != 2) {
          break label379;
        }
        localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772076));
      }
    }
    for (;;)
    {
      this.Gdg = paramk;
      localView.setOnClickListener(this.mOnClickListener);
      this.Atw.add(paramk);
      paramk.a(this);
      setVisibility(0);
      if (this.GfG) {
        bringToFront();
      }
      this.Atv.c(Color.argb(127, 0, 0, 0), null);
      if ((this.Gdi.isEmpty()) || (this.ddZ)) {
        break label396;
      }
      paramk = this.Gdi.iterator();
      while (paramk.hasNext()) {
        ((l)paramk.next()).h(Boolean.TRUE);
      }
      label358:
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      break;
      label379:
      localView.startAnimation(AnimationUtils.loadAnimation(getContext(), 2130772004));
    }
    label396:
    this.ddZ = true;
    AppMethodBeat.o(131484);
  }
  
  public final void b(l paraml)
  {
    AppMethodBeat.i(176009);
    this.Gdi.remove(paraml);
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
      this.mQp.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(204428);
          e.this.c(paramk);
          AppMethodBeat.o(204428);
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
    if (this.GcY == paramk)
    {
      AppMethodBeat.o(131485);
      return;
    }
    this.GcY = paramk;
    if (this.Gdg == paramk) {
      this.Gdg = null;
    }
    final View localView = paramk.getContentView();
    localView.animate().cancel();
    localView.clearAnimation();
    Animator localAnimator = P(localView, paramk.getPosition());
    localAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(204430);
        onAnimationEnd(paramAnonymousAnimator);
        AppMethodBeat.o(204430);
      }
      
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(204431);
        localView.setVisibility(8);
        e.b(e.this).remove(paramk);
        e.c(e.this);
        e.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(204429);
            e.this.removeView(e.5.this.oqr);
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
            AppMethodBeat.o(204429);
          }
        });
        AppMethodBeat.o(204431);
      }
    });
    localAnimator.start();
    if (this.Atw.size() <= 1) {
      this.Atv.c(0, this.Atx);
    }
    if ((!this.Gdi.isEmpty()) && (this.ddZ))
    {
      paramk = this.Gdi.iterator();
      while (paramk.hasNext()) {
        ((l)paramk.next()).h(Boolean.FALSE);
      }
    }
    this.ddZ = false;
    AppMethodBeat.o(131485);
  }
  
  public final void caW()
  {
    AppMethodBeat.i(183778);
    if (this.Atv.isRunning()) {
      this.Atv.cancel();
    }
    if (!this.Atw.isEmpty())
    {
      a local6 = new a() {};
      while (!this.Atw.isEmpty()) {
        local6.apply(this.Atw.pollFirst());
      }
    }
    this.GcY = null;
    this.Gdg = null;
    this.GdI = false;
    this.GdC.clear();
    this.GdH.clear();
    removeAllViewsInLayout();
    this.mQp.removeCallbacksAndMessages(null);
    this.Atx.run();
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
  
  public final k getCurrentDialog()
  {
    AppMethodBeat.i(131486);
    k localk = (k)this.Atw.peekLast();
    AppMethodBeat.o(131486);
    return localk;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(131489);
    k localk = (k)this.Atw.peekLast();
    if (localk == null)
    {
      setVisibility(8);
      AppMethodBeat.o(131489);
      return false;
    }
    if ((!localk.bjb()) && (localk.isCancelable()))
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
        paramConfiguration = this.Atw.iterator();
        while (paramConfiguration.hasNext()) {
          ((k)paramConfiguration.next()).ut(this.mRotation);
        }
      }
    }
    AppMethodBeat.o(131491);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(204433);
    super.onViewRemoved(paramView);
    if (this.Atw.size() == 0) {
      this.Atv.c(0, this.Atx);
    }
    AppMethodBeat.o(204433);
  }
  
  public final void setShouldBringSelfToFrontWhenDialogShown(boolean paramBoolean)
  {
    this.GfG = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.e
 * JD-Core Version:    0.7.0.1
 */