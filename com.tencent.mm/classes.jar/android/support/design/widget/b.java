package android.support.design.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.t;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class b<B extends b<B>>
{
  private static final boolean fP;
  static final Handler sHandler;
  final ViewGroup fQ;
  final b.e fR;
  private final b.b fS;
  private List<Object<B>> fT;
  private final AccessibilityManager fU;
  final l.a fV;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {}
    for (boolean bool = true;; bool = false)
    {
      fP = bool;
      sHandler = new Handler(Looper.getMainLooper(), new Handler.Callback()
      {
        public final boolean handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return false;
          case 0: 
            paramAnonymousMessage = (b)paramAnonymousMessage.obj;
            if (paramAnonymousMessage.fR.getParent() == null)
            {
              localObject = paramAnonymousMessage.fR.getLayoutParams();
              if ((localObject instanceof CoordinatorLayout.d))
              {
                localObject = (CoordinatorLayout.d)localObject;
                b.a locala = new b.a(paramAnonymousMessage);
                locala.kV = SwipeDismissBehavior.o(0.1F);
                locala.kW = SwipeDismissBehavior.o(0.6F);
                locala.kT = 0;
                locala.kP = new b.5(paramAnonymousMessage);
                ((CoordinatorLayout.d)localObject).a(locala);
                ((CoordinatorLayout.d)localObject).iQ = 80;
              }
              paramAnonymousMessage.fQ.addView(paramAnonymousMessage.fR);
            }
            paramAnonymousMessage.fR.setOnAttachStateChangeListener(new b.6(paramAnonymousMessage));
            if (t.as(paramAnonymousMessage.fR)) {
              if (paramAnonymousMessage.aT()) {
                paramAnonymousMessage.aQ();
              }
            }
            for (;;)
            {
              return true;
              paramAnonymousMessage.aR();
              continue;
              paramAnonymousMessage.fR.setOnLayoutChangeListener(new b.7(paramAnonymousMessage));
            }
          }
          Object localObject = (b)paramAnonymousMessage.obj;
          int i = paramAnonymousMessage.arg1;
          if ((((b)localObject).aT()) && (((b)localObject).fR.getVisibility() == 0)) {
            if (Build.VERSION.SDK_INT >= 12)
            {
              paramAnonymousMessage = new ValueAnimator();
              paramAnonymousMessage.setIntValues(new int[] { 0, ((b)localObject).fR.getHeight() });
              paramAnonymousMessage.setInterpolator(a.fj);
              paramAnonymousMessage.setDuration(250L);
              paramAnonymousMessage.addListener(new b.2((b)localObject, i));
              paramAnonymousMessage.addUpdateListener(new b.3((b)localObject));
              paramAnonymousMessage.start();
            }
          }
          for (;;)
          {
            return true;
            paramAnonymousMessage = AnimationUtils.loadAnimation(((b)localObject).fR.getContext(), 2131034158);
            paramAnonymousMessage.setInterpolator(a.fj);
            paramAnonymousMessage.setDuration(250L);
            paramAnonymousMessage.setAnimationListener(new b.4((b)localObject, i));
            ((b)localObject).fR.startAnimation(paramAnonymousMessage);
            continue;
            ((b)localObject).aS();
          }
        }
      });
      return;
    }
  }
  
  final void aQ()
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      int i = this.fR.getHeight();
      if (fP) {
        t.q(this.fR, i);
      }
      for (;;)
      {
        localObject = new ValueAnimator();
        ((ValueAnimator)localObject).setIntValues(new int[] { i, 0 });
        ((ValueAnimator)localObject).setInterpolator(a.fj);
        ((ValueAnimator)localObject).setDuration(250L);
        ((ValueAnimator)localObject).addListener(new b.8(this));
        ((ValueAnimator)localObject).addUpdateListener(new b.9(this, i));
        ((ValueAnimator)localObject).start();
        return;
        this.fR.setTranslationY(i);
      }
    }
    Object localObject = AnimationUtils.loadAnimation(this.fR.getContext(), 2131034157);
    ((Animation)localObject).setInterpolator(a.fj);
    ((Animation)localObject).setDuration(250L);
    ((Animation)localObject).setAnimationListener(new b.10(this));
    this.fR.startAnimation((Animation)localObject);
  }
  
  final void aR()
  {
    l locall = l.bD();
    l.a locala = this.fV;
    synchronized (locall.mLock)
    {
      if (locall.d(locala)) {
        locall.b(locall.kD);
      }
      if (this.fT != null)
      {
        int i = this.fT.size() - 1;
        if (i >= 0)
        {
          this.fT.get(i);
          i -= 1;
        }
      }
    }
  }
  
  final void aS()
  {
    l locall = l.bD();
    l.a locala = this.fV;
    synchronized (locall.mLock)
    {
      if (locall.d(locala))
      {
        locall.kD = null;
        if ((locall.kE != null) && (locall.kE != null))
        {
          locall.kD = locall.kE;
          locall.kE = null;
          if ((l.a)locall.kD.kG.get() == null) {
            locall.kD = null;
          }
        }
      }
      if (this.fT != null)
      {
        int i = this.fT.size() - 1;
        if (i >= 0)
        {
          this.fT.get(i);
          i -= 1;
        }
      }
    }
    if (Build.VERSION.SDK_INT < 11) {
      this.fR.setVisibility(8);
    }
    ??? = this.fR.getParent();
    if ((??? instanceof ViewGroup)) {
      ((ViewGroup)???).removeView(this.fR);
    }
  }
  
  final boolean aT()
  {
    return !this.fU.isEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.b
 * JD-Core Version:    0.7.0.1
 */