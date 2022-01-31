package android.support.design.widget;

import android.animation.ValueAnimator;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.a.a;
import android.support.v4.view.q;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import java.lang.ref.WeakReference;
import java.util.List;

public abstract class b<B extends b<B>>
{
  static final Handler eP;
  private static final boolean eQ;
  final ViewGroup eR;
  final b.e eS;
  private final b.b eT;
  private List<Object<B>> eU;
  private final AccessibilityManager eV;
  final l.a eW;
  
  static
  {
    if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT <= 19)) {}
    for (boolean bool = true;; bool = false)
    {
      eQ = bool;
      eP = new Handler(Looper.getMainLooper(), new Handler.Callback()
      {
        public final boolean handleMessage(Message paramAnonymousMessage)
        {
          switch (paramAnonymousMessage.what)
          {
          default: 
            return false;
          case 0: 
            paramAnonymousMessage = (b)paramAnonymousMessage.obj;
            if (paramAnonymousMessage.eS.getParent() == null)
            {
              localObject = paramAnonymousMessage.eS.getLayoutParams();
              if ((localObject instanceof CoordinatorLayout.d))
              {
                localObject = (CoordinatorLayout.d)localObject;
                b.a locala = new b.a(paramAnonymousMessage);
                locala.jX = n.n(0.1F);
                locala.jY = n.n(0.6F);
                locala.jV = 0;
                locala.jR = new b.5(paramAnonymousMessage);
                ((CoordinatorLayout.d)localObject).a(locala);
                ((CoordinatorLayout.d)localObject).hT = 80;
              }
              paramAnonymousMessage.eR.addView(paramAnonymousMessage.eS);
            }
            paramAnonymousMessage.eS.setOnAttachStateChangeListener(new b.6(paramAnonymousMessage));
            if (q.al(paramAnonymousMessage.eS)) {
              if (paramAnonymousMessage.ap()) {
                paramAnonymousMessage.am();
              }
            }
            for (;;)
            {
              return true;
              paramAnonymousMessage.an();
              continue;
              paramAnonymousMessage.eS.setOnLayoutChangeListener(new b.7(paramAnonymousMessage));
            }
          }
          Object localObject = (b)paramAnonymousMessage.obj;
          int i = paramAnonymousMessage.arg1;
          if ((((b)localObject).ap()) && (((b)localObject).eS.getVisibility() == 0)) {
            if (Build.VERSION.SDK_INT >= 12)
            {
              paramAnonymousMessage = new ValueAnimator();
              paramAnonymousMessage.setIntValues(new int[] { 0, ((b)localObject).eS.getHeight() });
              paramAnonymousMessage.setInterpolator(a.el);
              paramAnonymousMessage.setDuration(250L);
              paramAnonymousMessage.addListener(new b.2((b)localObject, i));
              paramAnonymousMessage.addUpdateListener(new b.3((b)localObject));
              paramAnonymousMessage.start();
            }
          }
          for (;;)
          {
            return true;
            paramAnonymousMessage = AnimationUtils.loadAnimation(((b)localObject).eS.getContext(), a.a.design_snackbar_out);
            paramAnonymousMessage.setInterpolator(a.el);
            paramAnonymousMessage.setDuration(250L);
            paramAnonymousMessage.setAnimationListener(new b.4((b)localObject, i));
            ((b)localObject).eS.startAnimation(paramAnonymousMessage);
            continue;
            ((b)localObject).ao();
          }
        }
      });
      return;
    }
  }
  
  final void am()
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      int i = this.eS.getHeight();
      if (eQ) {
        q.p(this.eS, i);
      }
      for (;;)
      {
        localObject = new ValueAnimator();
        ((ValueAnimator)localObject).setIntValues(new int[] { i, 0 });
        ((ValueAnimator)localObject).setInterpolator(a.el);
        ((ValueAnimator)localObject).setDuration(250L);
        ((ValueAnimator)localObject).addListener(new b.8(this));
        ((ValueAnimator)localObject).addUpdateListener(new b.9(this, i));
        ((ValueAnimator)localObject).start();
        return;
        this.eS.setTranslationY(i);
      }
    }
    Object localObject = AnimationUtils.loadAnimation(this.eS.getContext(), a.a.design_snackbar_in);
    ((Animation)localObject).setInterpolator(a.el);
    ((Animation)localObject).setDuration(250L);
    ((Animation)localObject).setAnimationListener(new b.10(this));
    this.eS.startAnimation((Animation)localObject);
  }
  
  final void an()
  {
    l locall = l.aT();
    l.a locala = this.eW;
    synchronized (locall.mLock)
    {
      if (locall.d(locala)) {
        locall.b(locall.jF);
      }
      if (this.eU != null)
      {
        int i = this.eU.size() - 1;
        if (i >= 0)
        {
          this.eU.get(i);
          i -= 1;
        }
      }
    }
  }
  
  final void ao()
  {
    l locall = l.aT();
    l.a locala = this.eW;
    synchronized (locall.mLock)
    {
      if (locall.d(locala))
      {
        locall.jF = null;
        if ((locall.jG != null) && (locall.jG != null))
        {
          locall.jF = locall.jG;
          locall.jG = null;
          if ((l.a)locall.jF.jI.get() == null) {
            locall.jF = null;
          }
        }
      }
      if (this.eU != null)
      {
        int i = this.eU.size() - 1;
        if (i >= 0)
        {
          this.eU.get(i);
          i -= 1;
        }
      }
    }
    if (Build.VERSION.SDK_INT < 11) {
      this.eS.setVisibility(8);
    }
    ??? = this.eS.getParent();
    if ((??? instanceof ViewGroup)) {
      ((ViewGroup)???).removeView(this.eS);
    }
  }
  
  final boolean ap()
  {
    return !this.eV.isEnabled();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     android.support.design.widget.b
 * JD-Core Version:    0.7.0.1
 */