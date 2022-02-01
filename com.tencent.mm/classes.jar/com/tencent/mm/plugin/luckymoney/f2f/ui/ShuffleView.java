package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView
  extends FrameLayout
{
  public static DisplayMetrics iQv;
  GestureDetector iNw;
  View joC;
  ValueAnimator pWD;
  private ValueAnimator scX;
  ValueAnimator scY;
  private float translationX;
  private float translationY;
  private ArrayList<Float> vzA;
  private boolean vzB;
  private int vzC;
  private int vzD;
  List<View> vzk;
  private c vzl;
  ValueAnimator vzm;
  private a vzn;
  private a vzo;
  private b vzp;
  View vzq;
  private View vzr;
  int vzs;
  private View vzt;
  private int vzu;
  int vzv;
  private final float vzw;
  private final float vzx;
  private final float vzy;
  private ArrayList<Float> vzz;
  
  public ShuffleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65134);
    this.vzw = 0.23F;
    this.vzx = 0.28F;
    this.vzy = 0.33F;
    this.vzD = 2500;
    this.iNw = new GestureDetector(new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65129);
        ae.d("ShuffleView", "gesture down");
        switch (ShuffleView.l(ShuffleView.this).vzJ)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(65129);
          return false;
          int j = (int)paramAnonymousMotionEvent.getX();
          int k = (int)paramAnonymousMotionEvent.getY();
          int i = 0;
          while (i < ShuffleView.d(ShuffleView.this))
          {
            paramAnonymousMotionEvent = ShuffleView.a(ShuffleView.this, i);
            if ((paramAnonymousMotionEvent != null) && (paramAnonymousMotionEvent.contains(j, k)))
            {
              paramAnonymousMotionEvent = (View)ShuffleView.e(ShuffleView.this).get(i);
              if ((ShuffleView.h(ShuffleView.this) != paramAnonymousMotionEvent) && (ShuffleView.h(ShuffleView.this) != null)) {
                ShuffleView.m(ShuffleView.this);
              }
              while (ShuffleView.h(ShuffleView.this) != paramAnonymousMotionEvent)
              {
                ShuffleView.b(ShuffleView.this, i);
                AppMethodBeat.o(65129);
                return true;
              }
              ae.i("ShuffleView", "down on the select card");
              AppMethodBeat.o(65129);
              return true;
            }
            i += 1;
          }
        }
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(65132);
        ae.i("ShuffleView", "fling up ".concat(String.valueOf(paramAnonymousFloat2)));
        if (paramAnonymousFloat2 < -ShuffleView.r(ShuffleView.this))
        {
          switch (ShuffleView.l(ShuffleView.this).vzJ)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(65132);
            return true;
            if (ShuffleView.h(ShuffleView.this) != null) {
              ShuffleView.m(ShuffleView.this);
            }
            if (ShuffleView.k(ShuffleView.this) != null)
            {
              if (ShuffleView.n(ShuffleView.this) != null)
              {
                paramAnonymousMotionEvent1 = ShuffleView.n(ShuffleView.this);
                ShuffleView.i(ShuffleView.this);
                paramAnonymousMotionEvent1.JC(ShuffleView.d(ShuffleView.this));
              }
              ShuffleView.c(ShuffleView.this, ShuffleView.i(ShuffleView.this));
            }
          }
        }
        AppMethodBeat.o(65132);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(189837);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(189837);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(65131);
        int j;
        int k;
        if (paramAnonymousMotionEvent2.getActionMasked() == 2)
        {
          j = (int)paramAnonymousMotionEvent2.getX();
          k = (int)paramAnonymousMotionEvent2.getY();
          switch (ShuffleView.l(ShuffleView.this).vzJ)
          {
          }
        }
        label202:
        do
        {
          AppMethodBeat.o(65131);
          return false;
          if (Math.abs(paramAnonymousFloat2) < ShuffleView.o(ShuffleView.this))
          {
            int i = 0;
            if (i < ShuffleView.d(ShuffleView.this))
            {
              paramAnonymousMotionEvent1 = ShuffleView.a(ShuffleView.this, i);
              if ((paramAnonymousMotionEvent1 != null) && (paramAnonymousMotionEvent1.contains(j, k)))
              {
                paramAnonymousMotionEvent1 = (View)ShuffleView.e(ShuffleView.this).get(i);
                if ((ShuffleView.h(ShuffleView.this) == paramAnonymousMotionEvent1) || (ShuffleView.h(ShuffleView.this) == null)) {
                  break label202;
                }
                ShuffleView.m(ShuffleView.this);
              }
              while (ShuffleView.h(ShuffleView.this) != paramAnonymousMotionEvent1)
              {
                if (ShuffleView.k(ShuffleView.this) != paramAnonymousMotionEvent1)
                {
                  ShuffleView.p(ShuffleView.this);
                  ShuffleView.b(ShuffleView.this, i);
                }
                i += 1;
                break;
              }
              ae.i("ShuffleView", "scroll on the select card");
            }
          }
        } while (Math.abs(paramAnonymousFloat1) >= ShuffleView.o(ShuffleView.this));
        ae.d("ShuffleView", "scroll distanceY:".concat(String.valueOf(paramAnonymousFloat2)));
        if (ShuffleView.k(ShuffleView.this) != null) {
          paramAnonymousMotionEvent1 = ShuffleView.k(ShuffleView.this);
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent1 != null)
          {
            ae.i("ShuffleView", "scroll translationY:" + paramAnonymousMotionEvent1.getTranslationY() + "," + paramAnonymousMotionEvent1.getHeight() / 7);
            if ((int)paramAnonymousMotionEvent1.getTranslationY() > -paramAnonymousMotionEvent1.getHeight() / 7) {
              break label502;
            }
            if ((paramAnonymousFloat2 < 0.0F) && (Math.abs(paramAnonymousFloat2) > ShuffleView.o(ShuffleView.this)))
            {
              if ((int)paramAnonymousFloat2 > -paramAnonymousMotionEvent1.getHeight() / 7) {
                break label488;
              }
              paramAnonymousMotionEvent1.setTranslationY(0.0F);
              label371:
              if (paramAnonymousMotionEvent1 == ShuffleView.h(ShuffleView.this))
              {
                ShuffleView.a(ShuffleView.this, ShuffleView.h(ShuffleView.this));
                ShuffleView.d(ShuffleView.this, ShuffleView.f(ShuffleView.this));
                if (ShuffleView.q(ShuffleView.this).isStarted())
                {
                  ae.i("ShuffleView", "scroll when select view is animation");
                  ShuffleView.q(ShuffleView.this).cancel();
                }
                ShuffleView.b(ShuffleView.this, null);
                ShuffleView.e(ShuffleView.this, 0);
              }
            }
          }
          for (;;)
          {
            AppMethodBeat.o(65131);
            return false;
            if (ShuffleView.h(ShuffleView.this) == null) {
              break label668;
            }
            paramAnonymousMotionEvent1 = ShuffleView.h(ShuffleView.this);
            break;
            label488:
            paramAnonymousMotionEvent1.setTranslationY(paramAnonymousMotionEvent1.getTranslationY() - paramAnonymousFloat2);
            break label371;
            label502:
            if (paramAnonymousMotionEvent1.getTranslationY() == 0.0F)
            {
              if ((paramAnonymousFloat2 > 0.0F) && (Math.abs(paramAnonymousFloat2) > ShuffleView.o(ShuffleView.this))) {
                if ((int)paramAnonymousFloat2 >= paramAnonymousMotionEvent1.getHeight() / 7) {
                  paramAnonymousMotionEvent1.setTranslationY(-paramAnonymousMotionEvent1.getHeight() / 7);
                } else {
                  paramAnonymousMotionEvent1.setTranslationY(paramAnonymousMotionEvent1.getTranslationY() - paramAnonymousFloat2);
                }
              }
            }
            else if (paramAnonymousFloat2 < 0.0F)
            {
              if (paramAnonymousMotionEvent1.getTranslationY() - paramAnonymousFloat2 >= 0.0F) {
                paramAnonymousMotionEvent1.setTranslationY(0.0F);
              } else {
                paramAnonymousMotionEvent1.setTranslationY(paramAnonymousMotionEvent1.getTranslationY() - paramAnonymousFloat2);
              }
            }
            else if ((int)(paramAnonymousMotionEvent1.getTranslationY() - paramAnonymousFloat2) <= -paramAnonymousMotionEvent1.getHeight() / 7) {
              paramAnonymousMotionEvent1.setTranslationY(-paramAnonymousMotionEvent1.getHeight() / 7);
            } else {
              paramAnonymousMotionEvent1.setTranslationY(paramAnonymousMotionEvent1.getTranslationY() - paramAnonymousFloat2);
            }
          }
          label668:
          paramAnonymousMotionEvent1 = null;
        }
      }
      
      public final void onShowPress(MotionEvent paramAnonymousMotionEvent) {}
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65130);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahF());
        switch (ShuffleView.l(ShuffleView.this).vzJ)
        {
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(65130);
          return false;
        }
        if (ShuffleView.h(ShuffleView.this) != null)
        {
          ae.d("ShuffleView", "click the select card");
          if (ShuffleView.n(ShuffleView.this) != null) {
            ShuffleView.n(ShuffleView.this).gv(ShuffleView.f(ShuffleView.this), ShuffleView.d(ShuffleView.this));
          }
          ShuffleView.m(ShuffleView.this);
        }
        if (ShuffleView.k(ShuffleView.this) != null)
        {
          if (ShuffleView.n(ShuffleView.this) != null)
          {
            paramAnonymousMotionEvent = ShuffleView.n(ShuffleView.this);
            ShuffleView.i(ShuffleView.this);
            paramAnonymousMotionEvent.JC(ShuffleView.d(ShuffleView.this));
          }
          ShuffleView.c(ShuffleView.this, ShuffleView.i(ShuffleView.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(65130);
        return true;
      }
    });
    this.vzl = new c();
    this.vzk = new ArrayList();
    this.vzz = new ArrayList();
    this.vzA = new ArrayList();
    this.vzC = getResources().getDimensionPixelSize(2131166504);
    AppMethodBeat.o(65134);
  }
  
  private Rect JG(int paramInt)
  {
    AppMethodBeat.i(65146);
    if ((paramInt >= 0) && (paramInt < this.vzv)) {
      localObject = (View)this.vzk.get(paramInt);
    }
    switch (this.vzl.vzJ)
    {
    default: 
      AppMethodBeat.o(65146);
      return null;
    }
    if (paramInt == 0)
    {
      paramInt = ((View)localObject).getLeft();
      i = (int)((View)localObject).getTranslationX();
      j = ((View)localObject).getTop();
      k = (int)((View)localObject).getTranslationY();
      m = ((View)localObject).getRight();
      n = (int)((View)localObject).getTranslationX();
      i1 = ((View)localObject).getBottom();
      localObject = new Rect(paramInt + i, j + k, m + n, (int)((View)localObject).getTranslationY() + i1);
      AppMethodBeat.o(65146);
      return localObject;
    }
    View localView = (View)this.vzk.get(paramInt - 1);
    paramInt = localView.getRight();
    int i = (int)localView.getTranslationX();
    int j = ((View)localObject).getTop();
    int k = (int)((View)localObject).getTranslationY();
    int m = ((View)localObject).getRight();
    int n = (int)((View)localObject).getTranslationX();
    int i1 = ((View)localObject).getBottom();
    Object localObject = new Rect(i + paramInt, j + k, m + n, (int)((View)localObject).getTranslationY() + i1);
    AppMethodBeat.o(65146);
    return localObject;
  }
  
  private void dlb()
  {
    AppMethodBeat.i(65137);
    if (this.vzv > 1)
    {
      ae.d("ShuffleView", "card width: %d,height: %d", new Object[] { Integer.valueOf(((View)this.vzk.get(0)).getWidth()), Integer.valueOf(((View)this.vzk.get(0)).getHeight()) });
      if (this.vzl.vzI == 2)
      {
        this.translationX = (((View)this.vzk.get(0)).getWidth() * 1.5F / this.vzv);
        if (this.translationX > ((View)this.vzk.get(0)).getWidth() * 0.23F)
        {
          this.translationX = (((View)this.vzk.get(0)).getWidth() * 0.23F);
          AppMethodBeat.o(65137);
        }
      }
      else if (this.vzl.vzI == 1)
      {
        this.translationY = (((View)this.vzk.get(0)).getHeight() * 1.0F / this.vzv);
        AppMethodBeat.o(65137);
      }
    }
    else
    {
      this.translationX = 0.0F;
      this.translationY = 0.0F;
    }
    AppMethodBeat.o(65137);
  }
  
  private void dld()
  {
    AppMethodBeat.i(65140);
    if (this.joC != null)
    {
      ae.i("ShuffleView", "selectView != null, cancel select");
      if (this.vzm.isStarted()) {
        this.vzm.cancel();
      }
      this.vzm.removeAllUpdateListeners();
      this.vzm.removeAllListeners();
      switch (this.vzl.vzJ)
      {
      }
    }
    for (;;)
    {
      this.joC = null;
      this.vzs = 0;
      this.vzm.start();
      AppMethodBeat.o(65140);
      return;
      if (this.vzs >= 0) {
        this.vzm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            int i = 0;
            AppMethodBeat.i(65123);
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            if (f == 0.0F)
            {
              ShuffleView.b(ShuffleView.this).clear();
              ShuffleView.c(ShuffleView.this).clear();
              while (i < ShuffleView.d(ShuffleView.this))
              {
                ShuffleView.b(ShuffleView.this).add(Float.valueOf(((View)ShuffleView.e(ShuffleView.this).get(i)).getTranslationX()));
                ShuffleView.c(ShuffleView.this).add(Float.valueOf(((View)ShuffleView.e(ShuffleView.this).get(i)).getTranslationY()));
                i += 1;
              }
              AppMethodBeat.o(65123);
              return;
            }
            i = 0;
            while (i < ShuffleView.d(ShuffleView.this))
            {
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JD(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JE(i) * f);
              i += 1;
            }
            AppMethodBeat.o(65123);
          }
        });
      }
    }
  }
  
  private void dle()
  {
    AppMethodBeat.i(65143);
    if (this.vzt != null)
    {
      ae.i("ShuffleView", "touchView != null,cancel touch");
      if (this.vzm.isStarted()) {
        this.vzm.cancel();
      }
      this.vzm.removeAllUpdateListeners();
      this.vzm.removeAllListeners();
      switch (this.vzl.vzJ)
      {
      }
    }
    for (;;)
    {
      this.vzt = null;
      this.vzu = -1;
      this.vzm.start();
      AppMethodBeat.o(65143);
      return;
      if (this.vzu >= 0) {
        this.vzm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            int i = 0;
            AppMethodBeat.i(65126);
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            if (f == 0.0F)
            {
              ShuffleView.b(ShuffleView.this).clear();
              ShuffleView.c(ShuffleView.this).clear();
              while (i < ShuffleView.d(ShuffleView.this))
              {
                ShuffleView.b(ShuffleView.this).add(Float.valueOf(((View)ShuffleView.e(ShuffleView.this).get(i)).getTranslationX()));
                ShuffleView.c(ShuffleView.this).add(Float.valueOf(((View)ShuffleView.e(ShuffleView.this).get(i)).getTranslationY()));
                i += 1;
              }
              AppMethodBeat.o(65126);
              return;
            }
            i = 0;
            while (i < ShuffleView.d(ShuffleView.this))
            {
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JD(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JE(i) * f);
              i += 1;
            }
            AppMethodBeat.o(65126);
          }
        });
      }
    }
  }
  
  private float getSelectScaleTranslationX()
  {
    AppMethodBeat.i(65141);
    if (this.joC != null)
    {
      float f1 = this.joC.getWidth();
      float f2 = this.translationX;
      int j = this.vzs - 1;
      int k = this.vzv - 1 - this.vzs;
      int i = 0;
      if (j > 0) {
        i = j + 0;
      }
      j = i;
      if (k > 0) {
        j = i + k;
      }
      if (j > 0)
      {
        f1 = (0.33F * f1 - f2) * 2.0F / j;
        AppMethodBeat.o(65141);
        return f1;
      }
    }
    AppMethodBeat.o(65141);
    return 0.0F;
  }
  
  private float getTouchScaleTranslationX()
  {
    AppMethodBeat.i(65144);
    if (this.vzt != null)
    {
      float f1 = this.vzt.getWidth();
      float f2 = this.translationX;
      int j = this.vzu - 1;
      int k = this.vzv - 1 - this.vzu;
      int i = 0;
      if (j > 0) {
        i = j + 0;
      }
      j = i;
      if (k > 0) {
        j = i + k;
      }
      if (j > 0)
      {
        f1 = (0.28F * f1 - f2) * 2.0F / j;
        AppMethodBeat.o(65144);
        return f1;
      }
    }
    AppMethodBeat.o(65144);
    return 0.0F;
  }
  
  public final float JD(int paramInt)
  {
    if ((this.vzl.vzI == 2) && (this.vzv > 0))
    {
      if (this.vzl.vzJ == 3) {
        return (this.vzv - 1) * 0.5F * this.translationX - this.translationX * paramInt;
      }
      if (this.vzl.vzJ == 4) {
        return this.translationX * paramInt - (this.vzv - 1) * 0.5F * this.translationX;
      }
    }
    return 0.0F;
  }
  
  public final float JE(int paramInt)
  {
    if (this.vzl.vzI == 1)
    {
      if (this.vzl.vzJ == 1) {
        return (this.vzv - 1) * 0.5F * this.translationY - this.translationY * paramInt;
      }
      if (this.vzl.vzJ == 2) {
        return this.translationY * paramInt - (this.vzv - 1) * 0.5F * this.translationY;
      }
    }
    return 0.0F;
  }
  
  final void JF(int paramInt)
  {
    AppMethodBeat.i(65142);
    if ((paramInt >= 0) && (paramInt < this.vzv))
    {
      ae.i("ShuffleView", "select card ".concat(String.valueOf(paramInt)));
      if (this.vzm.isStarted()) {
        this.vzm.cancel();
      }
      this.vzm.removeAllUpdateListeners();
      this.vzm.removeAllListeners();
      this.joC = ((View)this.vzk.get(paramInt));
      this.vzs = paramInt;
      this.vzt = null;
      this.vzu = -1;
      switch (this.vzl.vzJ)
      {
      }
    }
    for (;;)
    {
      this.vzm.start();
      AppMethodBeat.o(65142);
      return;
      if (paramInt > 0)
      {
        int i = this.vzv;
        this.vzm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            int i = 0;
            AppMethodBeat.i(65124);
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            if (f == 0.0F)
            {
              ShuffleView.b(ShuffleView.this).clear();
              ShuffleView.c(ShuffleView.this).clear();
              while (i < ShuffleView.d(ShuffleView.this))
              {
                ShuffleView.b(ShuffleView.this).add(Float.valueOf(((View)ShuffleView.e(ShuffleView.this).get(i)).getTranslationX()));
                ShuffleView.c(ShuffleView.this).add(Float.valueOf(((View)ShuffleView.e(ShuffleView.this).get(i)).getTranslationY()));
                i += 1;
              }
              AppMethodBeat.o(65124);
              return;
            }
            if (this.vzG > 0)
            {
              i = 0;
              while (i < ShuffleView.f(ShuffleView.this) - 1)
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + (ShuffleView.this.JD(i) - (i + 1) * ShuffleView.g(ShuffleView.this)) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JE(i) * f);
                i += 1;
              }
              ((View)ShuffleView.e(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).floatValue() * (1.0F - f) + (ShuffleView.this.JD(ShuffleView.f(ShuffleView.this) - 1) - ShuffleView.g(ShuffleView.this) * this.vzG / 2.0F) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).floatValue() * (1.0F - f) + ShuffleView.this.JE(ShuffleView.f(ShuffleView.this) - 1) * f);
            }
            while (this.vzH > 0)
            {
              ShuffleView.h(ShuffleView.this).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(ShuffleView.f(ShuffleView.this))).floatValue() * (1.0F - f) + (ShuffleView.this.JD(ShuffleView.f(ShuffleView.this)) + ShuffleView.g(ShuffleView.this) * this.vzH / 2.0F) * f);
              i = ShuffleView.f(ShuffleView.this) + 1;
              while (i < ShuffleView.d(ShuffleView.this))
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + (ShuffleView.this.JD(i) + (ShuffleView.d(ShuffleView.this) - i) * ShuffleView.g(ShuffleView.this)) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JE(i) * f);
                i += 1;
              }
              i = 0;
              while (i < ShuffleView.f(ShuffleView.this))
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JD(i) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JE(i) * f);
                i += 1;
              }
            }
            i = ShuffleView.f(ShuffleView.this);
            while (i < ShuffleView.d(ShuffleView.this))
            {
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JD(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JE(i) * f);
              i += 1;
            }
            ShuffleView.h(ShuffleView.this).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(ShuffleView.f(ShuffleView.this))).floatValue() * (1.0F - f) - ShuffleView.h(ShuffleView.this).getHeight() * f / 7.0F);
            AppMethodBeat.o(65124);
          }
        });
      }
      else
      {
        this.vzm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            int i = 0;
            AppMethodBeat.i(65125);
            float f = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            if (f == 0.0F)
            {
              ShuffleView.b(ShuffleView.this).clear();
              ShuffleView.c(ShuffleView.this).clear();
              while (i < ShuffleView.d(ShuffleView.this))
              {
                ShuffleView.b(ShuffleView.this).add(Float.valueOf(((View)ShuffleView.e(ShuffleView.this).get(i)).getTranslationX()));
                ShuffleView.c(ShuffleView.this).add(Float.valueOf(((View)ShuffleView.e(ShuffleView.this).get(i)).getTranslationY()));
                i += 1;
              }
              AppMethodBeat.o(65125);
              return;
            }
            ShuffleView.h(ShuffleView.this).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(0)).floatValue() * (1.0F - f) - ShuffleView.h(ShuffleView.this).getHeight() * f / 7.0F);
            i = 1;
            while (i < ShuffleView.d(ShuffleView.this))
            {
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JD(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.JE(i) * f);
              i += 1;
            }
            AppMethodBeat.o(65125);
          }
        });
      }
    }
  }
  
  final void JH(final int paramInt)
  {
    AppMethodBeat.i(65147);
    this.pWD.removeAllUpdateListeners();
    this.pWD.removeAllListeners();
    if (this.vzk.size() < this.vzv)
    {
      this.vzv -= 1;
      if (this.vzv == 1) {
        ((View)this.vzk.get(0)).findViewById(2131301827).setVisibility(0);
      }
      dlb();
      this.pWD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          int i = 0;
          AppMethodBeat.i(65133);
          float f1 = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
          if (f1 == 0.0F)
          {
            ShuffleView.b(ShuffleView.this).clear();
            ShuffleView.c(ShuffleView.this).clear();
            while (i < ShuffleView.d(ShuffleView.this))
            {
              ShuffleView.b(ShuffleView.this).add(Float.valueOf(((View)ShuffleView.e(ShuffleView.this).get(i)).getTranslationX()));
              ShuffleView.c(ShuffleView.this).add(Float.valueOf(((View)ShuffleView.e(ShuffleView.this).get(i)).getTranslationY()));
              i += 1;
            }
            AppMethodBeat.o(65133);
            return;
          }
          i = 0;
          if (i < ShuffleView.d(ShuffleView.this))
          {
            View localView = (View)ShuffleView.e(ShuffleView.this).get(i);
            float f2;
            float f3;
            if (ShuffleView.l(ShuffleView.this).vzI == 1)
            {
              f2 = ShuffleView.l(ShuffleView.this).scaleX;
              f3 = i + 1;
              localView.setScaleX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleX + (1.0F - f2 * f3));
              f2 = ShuffleView.this.JE(i);
              localView.setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
            }
            for (;;)
            {
              i += 1;
              break;
              if (ShuffleView.l(ShuffleView.this).vzI == 2)
              {
                f2 = ShuffleView.l(ShuffleView.this).scaleY;
                f3 = i + 1;
                localView.setScaleY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleY + (1.0F - f2 * f3));
                f2 = ShuffleView.this.JD(i);
                localView.setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
              }
            }
          }
          AppMethodBeat.o(65133);
        }
      });
      this.pWD.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(65116);
          ShuffleView.a(ShuffleView.this, false);
          ShuffleView.a(ShuffleView.this, null);
          ShuffleView.d(ShuffleView.this, -1);
          AppMethodBeat.o(65116);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(65115);
          ShuffleView.a(ShuffleView.this, true);
          AppMethodBeat.o(65115);
        }
      });
      this.pWD.start();
      AppMethodBeat.o(65147);
      return;
    }
    this.vzr = ((View)this.vzk.get(this.vzv - 1));
    aj(this.vzr, this.vzv - 1);
    addView(this.vzr, 0);
    if (this.scX != null) {
      switch (this.vzl.vzK)
      {
      }
    }
    for (;;)
    {
      this.vzr.setVisibility(4);
      this.pWD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(65117);
          int i = paramInt;
          if (i < ShuffleView.d(ShuffleView.this) - 1)
          {
            View localView = (View)ShuffleView.e(ShuffleView.this).get(i);
            float f1;
            float f2;
            if (ShuffleView.l(ShuffleView.this).vzI == 1)
            {
              f1 = ShuffleView.l(ShuffleView.this).scaleX;
              f2 = i + 1;
              localView.setScaleX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleX + (1.0F - f1 * f2));
              if (ShuffleView.l(ShuffleView.this).vzJ == 2) {
                localView.setTranslationY(ShuffleView.this.JE(i + 1) - ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(ShuffleView.this));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if (ShuffleView.l(ShuffleView.this).vzJ == 1)
              {
                f1 = ShuffleView.this.JE(i + 1);
                localView.setTranslationY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(ShuffleView.this) + f1);
                continue;
                if (ShuffleView.l(ShuffleView.this).vzI == 2)
                {
                  f1 = ShuffleView.l(ShuffleView.this).scaleY;
                  f2 = i + 1;
                  localView.setScaleY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleY + (1.0F - f1 * f2));
                  if (ShuffleView.l(ShuffleView.this).vzJ == 3)
                  {
                    f1 = ShuffleView.this.JD(i + 1);
                    localView.setTranslationX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(ShuffleView.this) + f1);
                  }
                  else if (ShuffleView.l(ShuffleView.this).vzJ == 4)
                  {
                    localView.setTranslationX(ShuffleView.this.JD(i + 1) - ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(ShuffleView.this));
                  }
                }
              }
            }
          }
          AppMethodBeat.o(65117);
        }
      });
      this.pWD.addListener(new Animator.AnimatorListener()
      {
        public final void onAnimationCancel(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(65119);
          ShuffleView.a(ShuffleView.this, false);
          ShuffleView.u(ShuffleView.this).setVisibility(0);
          if (ShuffleView.v(ShuffleView.this) != null) {
            ShuffleView.v(ShuffleView.this).start();
          }
          AppMethodBeat.o(65119);
        }
        
        public final void onAnimationRepeat(Animator paramAnonymousAnimator) {}
        
        public final void onAnimationStart(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(65118);
          ShuffleView.a(ShuffleView.this, true);
          AppMethodBeat.o(65118);
        }
      });
      break;
      this.vzr.setTranslationY(-iQv.heightPixels);
      continue;
      this.vzr.setTranslationY(iQv.heightPixels);
      continue;
      this.vzr.setTranslationX(-iQv.widthPixels);
      continue;
      this.vzr.setTranslationX(iQv.widthPixels);
    }
  }
  
  final void aj(View paramView, int paramInt)
  {
    AppMethodBeat.i(65138);
    if (this.vzl.vzI == 1)
    {
      paramView.setScaleX(1.0F - this.vzl.scaleX * paramInt);
      paramView.setTranslationY(JE(paramInt));
      AppMethodBeat.o(65138);
      return;
    }
    if (this.vzl.vzI == 2)
    {
      paramView.setScaleY(1.0F - this.vzl.scaleY * paramInt);
      paramView.setTranslationX(JD(paramInt));
    }
    AppMethodBeat.o(65138);
  }
  
  final int dlc()
  {
    AppMethodBeat.i(65139);
    int i = (int)(Math.random() * this.vzv);
    AppMethodBeat.o(65139);
    return i;
  }
  
  public View getEnterView()
  {
    return this.vzr;
  }
  
  public View getExitView()
  {
    return this.vzq;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65145);
    if (this.vzB)
    {
      AppMethodBeat.o(65145);
      return true;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (this.vzv <= 0)
    {
      AppMethodBeat.o(65145);
      return false;
    }
    ae.d("ShuffleView", "y:%d,packet largest:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(getHeight() - ((View)this.vzk.get(0)).getHeight() - ((View)this.vzk.get(0)).getHeight() / 7) });
    if (k < getHeight() - ((View)this.vzk.get(0)).getHeight() - ((View)this.vzk.get(0)).getHeight() / 7)
    {
      if ((this.joC != null) && (paramMotionEvent.getActionMasked() == 0))
      {
        if (this.vzp != null) {
          this.vzp.gv(this.vzs, this.vzv);
        }
        dld();
      }
      for (;;)
      {
        AppMethodBeat.o(65145);
        return false;
        if ((this.vzt != null) && (this.vzt.getTranslationY() == -this.vzt.getHeight() / 7))
        {
          if (this.vzp != null) {
            this.vzp.JC(this.vzv);
          }
          JF(this.vzu);
        }
        else if (this.vzt != null)
        {
          dle();
        }
      }
    }
    int i = 0;
    Object localObject;
    if (i < this.vzv)
    {
      localObject = JG(i);
      if ((localObject == null) || (!((Rect)localObject).contains(j, k))) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ae.d("ShuffleView", "event %d out of cards,%d,%d", new Object[] { Integer.valueOf(paramMotionEvent.getActionMasked()), Integer.valueOf(j), Integer.valueOf(k) });
        if ((this.joC == null) || (paramMotionEvent.getActionMasked() != 0)) {
          break label428;
        }
        if (this.vzp != null) {
          this.vzp.gv(this.vzs, this.vzv);
        }
        dld();
      }
      for (;;)
      {
        if (this.vzv > 1) {
          break label503;
        }
        AppMethodBeat.o(65145);
        return false;
        i += 1;
        break;
        label428:
        if ((this.vzt != null) && (this.vzt.getTranslationY() == -this.vzt.getHeight() / 7))
        {
          if (this.vzp != null) {
            this.vzp.JC(this.vzv);
          }
          JF(this.vzu);
        }
        else if (this.vzt != null)
        {
          dle();
        }
      }
      label503:
      localObject = this.iNw;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      ae.i("ShuffleView", "ret:%s,action:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramMotionEvent.getActionMasked()) });
      if ((!bool) && (paramMotionEvent.getActionMasked() == 1))
      {
        if ((this.vzt == null) || (this.vzt.getTranslationY() != -this.vzt.getHeight() / 7)) {
          break label698;
        }
        if (this.vzp != null) {
          this.vzp.JC(this.vzv);
        }
        JF(this.vzu);
      }
      for (;;)
      {
        AppMethodBeat.o(65145);
        return true;
        label698:
        if (this.vzt != null) {
          dle();
        }
      }
    }
  }
  
  public void setAllShuffleCards(List<View> paramList)
  {
    AppMethodBeat.i(65136);
    this.vzk.clear();
    this.vzk.addAll(paramList);
    this.vzs = 0;
    this.joC = null;
    this.vzu = -1;
    this.vzt = null;
    removeAllViews();
    paramList = this.vzk;
    if (paramList.size() > 100) {
      this.vzv = 100;
    }
    for (;;)
    {
      int i = this.vzv - 1;
      while (i >= 0)
      {
        addView((View)paramList.get(i));
        i -= 1;
      }
      this.vzv = paramList.size();
      if (this.vzv == 1) {
        ((View)paramList.get(0)).findViewById(2131301827).setVisibility(0);
      }
    }
    addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(65114);
        ShuffleView.a(ShuffleView.this);
        paramAnonymousView = ShuffleView.this;
        paramAnonymousInt1 = 0;
        while (paramAnonymousInt1 < paramAnonymousView.vzv)
        {
          paramAnonymousView.aj((View)paramAnonymousView.vzk.get(paramAnonymousInt1), paramAnonymousInt1);
          paramAnonymousInt1 += 1;
        }
        ShuffleView.this.removeOnLayoutChangeListener(this);
        AppMethodBeat.o(65114);
      }
    });
    AppMethodBeat.o(65136);
  }
  
  public void setCardListener(b paramb)
  {
    this.vzp = paramb;
  }
  
  public void setEnterAnimator(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(65149);
    if (this.scX != null)
    {
      this.scX.removeAllListeners();
      this.scX.cancel();
    }
    this.scX = paramValueAnimator;
    if (this.scX != null) {
      this.scX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(65122);
          if (ShuffleView.A(ShuffleView.this) != null) {
            ShuffleView.A(ShuffleView.this).a(paramAnonymousValueAnimator, ShuffleView.u(ShuffleView.this));
          }
          AppMethodBeat.o(65122);
        }
      });
    }
    AppMethodBeat.o(65149);
  }
  
  public void setEnterAnimatorListener(a parama)
  {
    this.vzo = parama;
  }
  
  public void setExitAnimator(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(65148);
    if (this.scY != null)
    {
      this.scY.removeAllListeners();
      this.scY.cancel();
    }
    this.scY = paramValueAnimator;
    if (this.scY != null) {
      this.scY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
      {
        public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
        {
          AppMethodBeat.i(65121);
          if (ShuffleView.z(ShuffleView.this) != null) {
            ShuffleView.z(ShuffleView.this).a(paramAnonymousValueAnimator, ShuffleView.w(ShuffleView.this));
          }
          AppMethodBeat.o(65121);
        }
      });
    }
    AppMethodBeat.o(65148);
  }
  
  public void setExitAnimatorListener(a parama)
  {
    this.vzn = parama;
  }
  
  public void setShuffleSetting(c paramc)
  {
    AppMethodBeat.i(65135);
    this.vzl = paramc;
    this.pWD = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.vzL);
    this.vzm = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.vzM);
    AppMethodBeat.o(65135);
  }
  
  static abstract interface a
  {
    public abstract void a(ValueAnimator paramValueAnimator, View paramView);
  }
  
  static abstract interface b
  {
    public abstract void JC(int paramInt);
    
    public abstract void gu(int paramInt1, int paramInt2);
    
    public abstract void gv(int paramInt1, int paramInt2);
  }
  
  static final class c
  {
    public float scaleX = 0.01F;
    public float scaleY = 0.01F;
    public int vzI = 1;
    public int vzJ = 1;
    public int vzK = 2;
    public int vzL = 200;
    public int vzM = 80;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView
 * JD-Core Version:    0.7.0.1
 */