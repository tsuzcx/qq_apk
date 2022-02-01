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
import android.view.ViewGroup.LayoutParams;
import android.view.ViewPropertyAnimator;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import androidx.a.a.c.a;
import androidx.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.q.a;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public final class g
  extends RelativeLayout
  implements r
{
  private boolean fhR;
  private final View.OnClickListener mOnClickListener;
  private int mRotation;
  private final MMHandler sVR;
  private n uCA;
  private n uCB;
  private Set<p> uCC;
  private final Set<o> uCD;
  private final Set<o> uCE;
  private boolean uCG;
  private boolean uCK;
  private s uCL;
  private boolean uCM;
  private final h uCq;
  private final l uCr;
  private final LinkedList<n> uCx;
  private final Runnable uCy;
  
  public g(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(131483);
    AppMethodBeat.o(131483);
  }
  
  public g(Context paramContext, h paramh)
  {
    super(paramContext);
    AppMethodBeat.i(324693);
    this.mRotation = 0;
    this.sVR = new MMHandler(Looper.getMainLooper());
    this.uCr = new l(this);
    this.uCx = new LinkedList();
    this.mOnClickListener = new g.1(this);
    this.uCy = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(131478);
        g.this.setBackgroundColor(0);
        g.this.removeAllViews();
        g.this.setVisibility(4);
        AppMethodBeat.o(131478);
      }
    };
    this.fhR = false;
    this.uCC = new b();
    this.uCD = new b();
    this.uCE = new b();
    this.uCG = false;
    this.uCK = true;
    this.uCL = null;
    this.uCM = false;
    setVisibility(4);
    setBackgroundColor(0);
    setOnClickListener(this.mOnClickListener);
    paramContext = (WindowManager)getContext().getSystemService("window");
    if (paramContext != null) {
      this.mRotation = paramContext.getDefaultDisplay().getRotation();
    }
    paramContext = paramh;
    if (paramh == null) {
      paramContext = new h();
    }
    kotlin.g.b.s.u(this, "dialogContainer");
    paramh = paramContext.uCc;
    kotlin.g.b.s.u(this, "dialogContainer");
    ((Map)paramh.uCb).put(this, new f.a.a(paramh, this));
    this.uCq = paramContext;
    AppMethodBeat.o(324693);
  }
  
  private static Animator X(View paramView, int paramInt)
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
    Interpolator localInterpolator = AnimationUtils.loadInterpolator(paramView.getContext(), q.a.decelerate_quint_interpolator);
    Object localObject = AnimationUtils.loadInterpolator(paramView.getContext(), q.a.decelerate_cubic_interpolator);
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
  
  private static void dY(View paramView)
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
  
  public final void a(o paramo)
  {
    AppMethodBeat.i(324765);
    this.uCD.add(paramo);
    AppMethodBeat.o(324765);
  }
  
  public final void a(p paramp)
  {
    AppMethodBeat.i(176008);
    this.uCC.add(paramp);
    AppMethodBeat.o(176008);
  }
  
  public final void b(final n paramn)
  {
    AppMethodBeat.i(131484);
    if (paramn == null)
    {
      AppMethodBeat.o(131484);
      return;
    }
    com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandDialogContainerLayout", "showDialog dialog[%s] tid[%d]", new Object[] { paramn.getClass().getName(), Long.valueOf(Thread.currentThread().getId()) });
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      this.sVR.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(131479);
          g.this.b(paramn);
          AppMethodBeat.o(131479);
        }
      });
      AppMethodBeat.o(131484);
      return;
    }
    com.tencent.luggage.l.f.bv(getContext());
    if (this.uCr.isRunning()) {
      this.uCr.cancel();
    }
    View localView = paramn.getContentView();
    if (localView == null)
    {
      com.tencent.mm.sdk.platformtools.Log.w("MicroMsg.AppBrandDialogContainerLayout", "showDialog NULL dialogView from dialog[%s], stack=%s", new Object[] { paramn, android.util.Log.getStackTraceString(new Throwable()) });
      AppMethodBeat.o(131484);
      return;
    }
    if (localView.getParent() != this)
    {
      dY(localView);
      if (paramn.getPosition() != 2) {
        break label422;
      }
      localObject = new RelativeLayout.LayoutParams(-1, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(12);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      addView(localView, (ViewGroup.LayoutParams)localObject);
      if (this.uCB != paramn)
      {
        localView.clearAnimation();
        if (paramn.getPosition() != 2) {
          break label443;
        }
      }
    }
    label422:
    label443:
    for (Object localObject = AnimationUtils.loadAnimation(getContext(), q.a.in_from_bottom);; localObject = AnimationUtils.loadAnimation(getContext(), q.a.appbrand_dialog_enter))
    {
      ((Animation)localObject).setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(324769);
          com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandDialogContainerLayout", "on dialogView start animation end");
          g.b(g.this);
          paramn.bQh();
          AppMethodBeat.o(324769);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
      localView.startAnimation((Animation)localObject);
      this.uCB = paramn;
      if (localView.getVisibility() != 0) {
        localView.setVisibility(0);
      }
      localView.animate().translationX(0.0F).translationY(0.0F).alpha(1.0F).setDuration(0L).scaleX(1.0F).scaleY(1.0F).start();
      localView.setOnClickListener(this.mOnClickListener);
      this.uCx.add(paramn);
      paramn.a(this);
      setVisibility(0);
      if (this.uCK) {
        bringToFront();
      }
      this.uCr.c(Color.argb(127, 0, 0, 0), null);
      if ((this.uCC.isEmpty()) || (this.fhR)) {
        break label457;
      }
      paramn = this.uCC.iterator();
      while (paramn.hasNext()) {
        ((p)paramn.next()).n(Boolean.TRUE);
      }
      localObject = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      break;
    }
    label457:
    this.fhR = true;
    AppMethodBeat.o(131484);
  }
  
  public final void b(o paramo)
  {
    AppMethodBeat.i(324770);
    if (!this.uCG)
    {
      this.uCD.remove(paramo);
      AppMethodBeat.o(324770);
      return;
    }
    this.uCE.add(paramo);
    AppMethodBeat.o(324770);
  }
  
  public final void b(p paramp)
  {
    AppMethodBeat.i(176009);
    this.uCC.remove(paramp);
    AppMethodBeat.o(176009);
  }
  
  public final void c(final n paramn)
  {
    AppMethodBeat.i(131485);
    if ((paramn == null) || (paramn.getContentView() == null))
    {
      AppMethodBeat.o(131485);
      return;
    }
    if (Looper.getMainLooper() != Looper.myLooper())
    {
      this.sVR.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324771);
          g.this.c(paramn);
          AppMethodBeat.o(324771);
        }
      });
      AppMethodBeat.o(131485);
      return;
    }
    if (paramn.getContentView().getParent() != this)
    {
      AppMethodBeat.o(131485);
      return;
    }
    if (this.uCA == paramn)
    {
      AppMethodBeat.o(131485);
      return;
    }
    this.uCA = paramn;
    if (this.uCB == paramn) {
      this.uCB = null;
    }
    final View localView = paramn.getContentView();
    localView.animate().cancel();
    localView.clearAnimation();
    Animator localAnimator = X(localView, paramn.getPosition());
    localAnimator.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationCancel(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(324762);
        onAnimationEnd(paramAnonymousAnimator);
        AppMethodBeat.o(324762);
      }
      
      public final void onAnimationEnd(final Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(324767);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.AppBrandDialogContainerLayout", "on dialogView exit animation end");
        paramAnonymousAnimator = g.c(g.this);
        localView.setVisibility(8);
        g.d(g.this).remove(paramn);
        g.e(g.this);
        g.this.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(324766);
            g.this.removeView(g.6.this.uCu);
            g.a(g.this, true);
            Iterator localIterator = g.f(g.this).iterator();
            while (localIterator.hasNext()) {
              ((o)localIterator.next()).a(g.6.this.uCt);
            }
            g.a(g.this, false);
            if (!g.g(g.this).isEmpty())
            {
              g.f(g.this).removeAll(g.g(g.this));
              g.g(g.this).clear();
            }
            if (paramAnonymousAnimator != null) {
              paramAnonymousAnimator.bQh();
            }
            AppMethodBeat.o(324766);
          }
        });
        AppMethodBeat.o(324767);
      }
    });
    localAnimator.start();
    if (this.uCx.size() <= 1) {
      this.uCr.c(0, this.uCy);
    }
    if ((!this.uCC.isEmpty()) && (this.fhR))
    {
      paramn = this.uCC.iterator();
      while (paramn.hasNext()) {
        ((p)paramn.next()).n(Boolean.FALSE);
      }
    }
    this.fhR = false;
    AppMethodBeat.o(131485);
  }
  
  public final void cQI()
  {
    AppMethodBeat.i(183778);
    if (this.uCr.isRunning()) {
      this.uCr.cancel();
    }
    if (!this.uCx.isEmpty())
    {
      a local7 = new a() {};
      while (!this.uCx.isEmpty()) {
        local7.apply((n)this.uCx.pollFirst());
      }
    }
    this.uCA = null;
    this.uCB = null;
    this.uCG = false;
    this.uCD.clear();
    this.uCE.clear();
    removeAllViewsInLayout();
    this.sVR.removeCallbacksAndMessages(null);
    this.uCy.run();
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
  
  public final n getCurrentDialog()
  {
    AppMethodBeat.i(131486);
    n localn = (n)this.uCx.peekLast();
    AppMethodBeat.o(131486);
    return localn;
  }
  
  public final h getShareContext()
  {
    return this.uCq;
  }
  
  public final boolean onBackPressed()
  {
    AppMethodBeat.i(131489);
    n localn = (n)this.uCx.peekLast();
    if (localn == null)
    {
      setVisibility(8);
      AppMethodBeat.o(131489);
      return false;
    }
    if ((!localn.bQg()) && (localn.isCancelable()))
    {
      localn.onCancel();
      c(localn);
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
        paramConfiguration = this.uCx.iterator();
        while (paramConfiguration.hasNext()) {
          ((n)paramConfiguration.next()).xt(this.mRotation);
        }
      }
    }
    AppMethodBeat.o(131491);
  }
  
  public final void onViewRemoved(View paramView)
  {
    AppMethodBeat.i(324759);
    super.onViewRemoved(paramView);
    if (this.uCx.size() == 0) {
      this.uCr.c(0, this.uCy);
    }
    AppMethodBeat.o(324759);
  }
  
  public final void setListener(s params)
  {
    this.uCL = params;
  }
  
  public final void setShouldBringSelfToFrontWhenDialogShown(boolean paramBoolean)
  {
    this.uCK = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.g
 * JD-Core Version:    0.7.0.1
 */