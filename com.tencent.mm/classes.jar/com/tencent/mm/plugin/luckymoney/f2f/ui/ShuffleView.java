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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView
  extends FrameLayout
{
  public static DisplayMetrics iNB;
  GestureDetector iKD;
  View jlI;
  ValueAnimator pPY;
  private ValueAnimator rUt;
  ValueAnimator rUu;
  private float translationX;
  private float translationY;
  List<View> vnf;
  private c vng;
  ValueAnimator vnh;
  private a vni;
  private a vnj;
  private b vnk;
  View vnl;
  private View vnm;
  int vnn;
  private View vno;
  private int vnp;
  int vnq;
  private final float vnr;
  private final float vns;
  private final float vnt;
  private ArrayList<Float> vnu;
  private ArrayList<Float> vnv;
  private boolean vnw;
  private int vnx;
  private int vny;
  
  public ShuffleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65134);
    this.vnr = 0.23F;
    this.vns = 0.28F;
    this.vnt = 0.33F;
    this.vny = 2500;
    this.iKD = new GestureDetector(new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65129);
        ad.d("ShuffleView", "gesture down");
        switch (ShuffleView.l(ShuffleView.this).vnE)
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
              ad.i("ShuffleView", "down on the select card");
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
        ad.i("ShuffleView", "fling up ".concat(String.valueOf(paramAnonymousFloat2)));
        if (paramAnonymousFloat2 < -ShuffleView.r(ShuffleView.this))
        {
          switch (ShuffleView.l(ShuffleView.this).vnE)
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
                paramAnonymousMotionEvent1.Jd(ShuffleView.d(ShuffleView.this));
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
        AppMethodBeat.i(199003);
        b localb = new b();
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.ahq());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(199003);
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
          switch (ShuffleView.l(ShuffleView.this).vnE)
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
              ad.i("ShuffleView", "scroll on the select card");
            }
          }
        } while (Math.abs(paramAnonymousFloat1) >= ShuffleView.o(ShuffleView.this));
        ad.d("ShuffleView", "scroll distanceY:".concat(String.valueOf(paramAnonymousFloat2)));
        if (ShuffleView.k(ShuffleView.this) != null) {
          paramAnonymousMotionEvent1 = ShuffleView.k(ShuffleView.this);
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent1 != null)
          {
            ad.i("ShuffleView", "scroll translationY:" + paramAnonymousMotionEvent1.getTranslationY() + "," + paramAnonymousMotionEvent1.getHeight() / 7);
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
                  ad.i("ShuffleView", "scroll when select view is animation");
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.ahq());
        switch (ShuffleView.l(ShuffleView.this).vnE)
        {
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(65130);
          return false;
        }
        if (ShuffleView.h(ShuffleView.this) != null)
        {
          ad.d("ShuffleView", "click the select card");
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
            paramAnonymousMotionEvent.Jd(ShuffleView.d(ShuffleView.this));
          }
          ShuffleView.c(ShuffleView.this, ShuffleView.i(ShuffleView.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(65130);
        return true;
      }
    });
    this.vng = new c();
    this.vnf = new ArrayList();
    this.vnu = new ArrayList();
    this.vnv = new ArrayList();
    this.vnx = getResources().getDimensionPixelSize(2131166504);
    AppMethodBeat.o(65134);
  }
  
  private Rect Jh(int paramInt)
  {
    AppMethodBeat.i(65146);
    if ((paramInt >= 0) && (paramInt < this.vnq)) {
      localObject = (View)this.vnf.get(paramInt);
    }
    switch (this.vng.vnE)
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
    View localView = (View)this.vnf.get(paramInt - 1);
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
  
  private void dic()
  {
    AppMethodBeat.i(65137);
    if (this.vnq > 1)
    {
      ad.d("ShuffleView", "card width: %d,height: %d", new Object[] { Integer.valueOf(((View)this.vnf.get(0)).getWidth()), Integer.valueOf(((View)this.vnf.get(0)).getHeight()) });
      if (this.vng.vnD == 2)
      {
        this.translationX = (((View)this.vnf.get(0)).getWidth() * 1.5F / this.vnq);
        if (this.translationX > ((View)this.vnf.get(0)).getWidth() * 0.23F)
        {
          this.translationX = (((View)this.vnf.get(0)).getWidth() * 0.23F);
          AppMethodBeat.o(65137);
        }
      }
      else if (this.vng.vnD == 1)
      {
        this.translationY = (((View)this.vnf.get(0)).getHeight() * 1.0F / this.vnq);
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
  
  private void die()
  {
    AppMethodBeat.i(65140);
    if (this.jlI != null)
    {
      ad.i("ShuffleView", "selectView != null, cancel select");
      if (this.vnh.isStarted()) {
        this.vnh.cancel();
      }
      this.vnh.removeAllUpdateListeners();
      this.vnh.removeAllListeners();
      switch (this.vng.vnE)
      {
      }
    }
    for (;;)
    {
      this.jlI = null;
      this.vnn = 0;
      this.vnh.start();
      AppMethodBeat.o(65140);
      return;
      if (this.vnn >= 0) {
        this.vnh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Je(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Jf(i) * f);
              i += 1;
            }
            AppMethodBeat.o(65123);
          }
        });
      }
    }
  }
  
  private void dif()
  {
    AppMethodBeat.i(65143);
    if (this.vno != null)
    {
      ad.i("ShuffleView", "touchView != null,cancel touch");
      if (this.vnh.isStarted()) {
        this.vnh.cancel();
      }
      this.vnh.removeAllUpdateListeners();
      this.vnh.removeAllListeners();
      switch (this.vng.vnE)
      {
      }
    }
    for (;;)
    {
      this.vno = null;
      this.vnp = -1;
      this.vnh.start();
      AppMethodBeat.o(65143);
      return;
      if (this.vnp >= 0) {
        this.vnh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Je(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Jf(i) * f);
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
    if (this.jlI != null)
    {
      float f1 = this.jlI.getWidth();
      float f2 = this.translationX;
      int j = this.vnn - 1;
      int k = this.vnq - 1 - this.vnn;
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
    if (this.vno != null)
    {
      float f1 = this.vno.getWidth();
      float f2 = this.translationX;
      int j = this.vnp - 1;
      int k = this.vnq - 1 - this.vnp;
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
  
  public final float Je(int paramInt)
  {
    if ((this.vng.vnD == 2) && (this.vnq > 0))
    {
      if (this.vng.vnE == 3) {
        return (this.vnq - 1) * 0.5F * this.translationX - this.translationX * paramInt;
      }
      if (this.vng.vnE == 4) {
        return this.translationX * paramInt - (this.vnq - 1) * 0.5F * this.translationX;
      }
    }
    return 0.0F;
  }
  
  public final float Jf(int paramInt)
  {
    if (this.vng.vnD == 1)
    {
      if (this.vng.vnE == 1) {
        return (this.vnq - 1) * 0.5F * this.translationY - this.translationY * paramInt;
      }
      if (this.vng.vnE == 2) {
        return this.translationY * paramInt - (this.vnq - 1) * 0.5F * this.translationY;
      }
    }
    return 0.0F;
  }
  
  final void Jg(int paramInt)
  {
    AppMethodBeat.i(65142);
    if ((paramInt >= 0) && (paramInt < this.vnq))
    {
      ad.i("ShuffleView", "select card ".concat(String.valueOf(paramInt)));
      if (this.vnh.isStarted()) {
        this.vnh.cancel();
      }
      this.vnh.removeAllUpdateListeners();
      this.vnh.removeAllListeners();
      this.jlI = ((View)this.vnf.get(paramInt));
      this.vnn = paramInt;
      this.vno = null;
      this.vnp = -1;
      switch (this.vng.vnE)
      {
      }
    }
    for (;;)
    {
      this.vnh.start();
      AppMethodBeat.o(65142);
      return;
      if (paramInt > 0)
      {
        int i = this.vnq;
        this.vnh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
            if (this.vnB > 0)
            {
              i = 0;
              while (i < ShuffleView.f(ShuffleView.this) - 1)
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + (ShuffleView.this.Je(i) - (i + 1) * ShuffleView.g(ShuffleView.this)) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Jf(i) * f);
                i += 1;
              }
              ((View)ShuffleView.e(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).floatValue() * (1.0F - f) + (ShuffleView.this.Je(ShuffleView.f(ShuffleView.this) - 1) - ShuffleView.g(ShuffleView.this) * this.vnB / 2.0F) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).floatValue() * (1.0F - f) + ShuffleView.this.Jf(ShuffleView.f(ShuffleView.this) - 1) * f);
            }
            while (this.vnC > 0)
            {
              ShuffleView.h(ShuffleView.this).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(ShuffleView.f(ShuffleView.this))).floatValue() * (1.0F - f) + (ShuffleView.this.Je(ShuffleView.f(ShuffleView.this)) + ShuffleView.g(ShuffleView.this) * this.vnC / 2.0F) * f);
              i = ShuffleView.f(ShuffleView.this) + 1;
              while (i < ShuffleView.d(ShuffleView.this))
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + (ShuffleView.this.Je(i) + (ShuffleView.d(ShuffleView.this) - i) * ShuffleView.g(ShuffleView.this)) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Jf(i) * f);
                i += 1;
              }
              i = 0;
              while (i < ShuffleView.f(ShuffleView.this))
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Je(i) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Jf(i) * f);
                i += 1;
              }
            }
            i = ShuffleView.f(ShuffleView.this);
            while (i < ShuffleView.d(ShuffleView.this))
            {
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Je(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Jf(i) * f);
              i += 1;
            }
            ShuffleView.h(ShuffleView.this).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(ShuffleView.f(ShuffleView.this))).floatValue() * (1.0F - f) - ShuffleView.h(ShuffleView.this).getHeight() * f / 7.0F);
            AppMethodBeat.o(65124);
          }
        });
      }
      else
      {
        this.vnh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Je(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.Jf(i) * f);
              i += 1;
            }
            AppMethodBeat.o(65125);
          }
        });
      }
    }
  }
  
  final void Ji(final int paramInt)
  {
    AppMethodBeat.i(65147);
    this.pPY.removeAllUpdateListeners();
    this.pPY.removeAllListeners();
    if (this.vnf.size() < this.vnq)
    {
      this.vnq -= 1;
      if (this.vnq == 1) {
        ((View)this.vnf.get(0)).findViewById(2131301827).setVisibility(0);
      }
      dic();
      this.pPY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
            if (ShuffleView.l(ShuffleView.this).vnD == 1)
            {
              f2 = ShuffleView.l(ShuffleView.this).scaleX;
              f3 = i + 1;
              localView.setScaleX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleX + (1.0F - f2 * f3));
              f2 = ShuffleView.this.Jf(i);
              localView.setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
            }
            for (;;)
            {
              i += 1;
              break;
              if (ShuffleView.l(ShuffleView.this).vnD == 2)
              {
                f2 = ShuffleView.l(ShuffleView.this).scaleY;
                f3 = i + 1;
                localView.setScaleY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleY + (1.0F - f2 * f3));
                f2 = ShuffleView.this.Je(i);
                localView.setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
              }
            }
          }
          AppMethodBeat.o(65133);
        }
      });
      this.pPY.addListener(new Animator.AnimatorListener()
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
      this.pPY.start();
      AppMethodBeat.o(65147);
      return;
    }
    this.vnm = ((View)this.vnf.get(this.vnq - 1));
    aj(this.vnm, this.vnq - 1);
    addView(this.vnm, 0);
    if (this.rUt != null) {
      switch (this.vng.vnF)
      {
      }
    }
    for (;;)
    {
      this.vnm.setVisibility(4);
      this.pPY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
            if (ShuffleView.l(ShuffleView.this).vnD == 1)
            {
              f1 = ShuffleView.l(ShuffleView.this).scaleX;
              f2 = i + 1;
              localView.setScaleX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleX + (1.0F - f1 * f2));
              if (ShuffleView.l(ShuffleView.this).vnE == 2) {
                localView.setTranslationY(ShuffleView.this.Jf(i + 1) - ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(ShuffleView.this));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if (ShuffleView.l(ShuffleView.this).vnE == 1)
              {
                f1 = ShuffleView.this.Jf(i + 1);
                localView.setTranslationY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(ShuffleView.this) + f1);
                continue;
                if (ShuffleView.l(ShuffleView.this).vnD == 2)
                {
                  f1 = ShuffleView.l(ShuffleView.this).scaleY;
                  f2 = i + 1;
                  localView.setScaleY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleY + (1.0F - f1 * f2));
                  if (ShuffleView.l(ShuffleView.this).vnE == 3)
                  {
                    f1 = ShuffleView.this.Je(i + 1);
                    localView.setTranslationX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(ShuffleView.this) + f1);
                  }
                  else if (ShuffleView.l(ShuffleView.this).vnE == 4)
                  {
                    localView.setTranslationX(ShuffleView.this.Je(i + 1) - ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(ShuffleView.this));
                  }
                }
              }
            }
          }
          AppMethodBeat.o(65117);
        }
      });
      this.pPY.addListener(new Animator.AnimatorListener()
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
      this.vnm.setTranslationY(-iNB.heightPixels);
      continue;
      this.vnm.setTranslationY(iNB.heightPixels);
      continue;
      this.vnm.setTranslationX(-iNB.widthPixels);
      continue;
      this.vnm.setTranslationX(iNB.widthPixels);
    }
  }
  
  final void aj(View paramView, int paramInt)
  {
    AppMethodBeat.i(65138);
    if (this.vng.vnD == 1)
    {
      paramView.setScaleX(1.0F - this.vng.scaleX * paramInt);
      paramView.setTranslationY(Jf(paramInt));
      AppMethodBeat.o(65138);
      return;
    }
    if (this.vng.vnD == 2)
    {
      paramView.setScaleY(1.0F - this.vng.scaleY * paramInt);
      paramView.setTranslationX(Je(paramInt));
    }
    AppMethodBeat.o(65138);
  }
  
  final int did()
  {
    AppMethodBeat.i(65139);
    int i = (int)(Math.random() * this.vnq);
    AppMethodBeat.o(65139);
    return i;
  }
  
  public View getEnterView()
  {
    return this.vnm;
  }
  
  public View getExitView()
  {
    return this.vnl;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65145);
    if (this.vnw)
    {
      AppMethodBeat.o(65145);
      return true;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (this.vnq <= 0)
    {
      AppMethodBeat.o(65145);
      return false;
    }
    ad.d("ShuffleView", "y:%d,packet largest:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(getHeight() - ((View)this.vnf.get(0)).getHeight() - ((View)this.vnf.get(0)).getHeight() / 7) });
    if (k < getHeight() - ((View)this.vnf.get(0)).getHeight() - ((View)this.vnf.get(0)).getHeight() / 7)
    {
      if ((this.jlI != null) && (paramMotionEvent.getActionMasked() == 0))
      {
        if (this.vnk != null) {
          this.vnk.gv(this.vnn, this.vnq);
        }
        die();
      }
      for (;;)
      {
        AppMethodBeat.o(65145);
        return false;
        if ((this.vno != null) && (this.vno.getTranslationY() == -this.vno.getHeight() / 7))
        {
          if (this.vnk != null) {
            this.vnk.Jd(this.vnq);
          }
          Jg(this.vnp);
        }
        else if (this.vno != null)
        {
          dif();
        }
      }
    }
    int i = 0;
    Object localObject;
    if (i < this.vnq)
    {
      localObject = Jh(i);
      if ((localObject == null) || (!((Rect)localObject).contains(j, k))) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ad.d("ShuffleView", "event %d out of cards,%d,%d", new Object[] { Integer.valueOf(paramMotionEvent.getActionMasked()), Integer.valueOf(j), Integer.valueOf(k) });
        if ((this.jlI == null) || (paramMotionEvent.getActionMasked() != 0)) {
          break label428;
        }
        if (this.vnk != null) {
          this.vnk.gv(this.vnn, this.vnq);
        }
        die();
      }
      for (;;)
      {
        if (this.vnq > 1) {
          break label503;
        }
        AppMethodBeat.o(65145);
        return false;
        i += 1;
        break;
        label428:
        if ((this.vno != null) && (this.vno.getTranslationY() == -this.vno.getHeight() / 7))
        {
          if (this.vnk != null) {
            this.vnk.Jd(this.vnq);
          }
          Jg(this.vnp);
        }
        else if (this.vno != null)
        {
          dif();
        }
      }
      label503:
      localObject = this.iKD;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      ad.i("ShuffleView", "ret:%s,action:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramMotionEvent.getActionMasked()) });
      if ((!bool) && (paramMotionEvent.getActionMasked() == 1))
      {
        if ((this.vno == null) || (this.vno.getTranslationY() != -this.vno.getHeight() / 7)) {
          break label698;
        }
        if (this.vnk != null) {
          this.vnk.Jd(this.vnq);
        }
        Jg(this.vnp);
      }
      for (;;)
      {
        AppMethodBeat.o(65145);
        return true;
        label698:
        if (this.vno != null) {
          dif();
        }
      }
    }
  }
  
  public void setAllShuffleCards(List<View> paramList)
  {
    AppMethodBeat.i(65136);
    this.vnf.clear();
    this.vnf.addAll(paramList);
    this.vnn = 0;
    this.jlI = null;
    this.vnp = -1;
    this.vno = null;
    removeAllViews();
    paramList = this.vnf;
    if (paramList.size() > 100) {
      this.vnq = 100;
    }
    for (;;)
    {
      int i = this.vnq - 1;
      while (i >= 0)
      {
        addView((View)paramList.get(i));
        i -= 1;
      }
      this.vnq = paramList.size();
      if (this.vnq == 1) {
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
        while (paramAnonymousInt1 < paramAnonymousView.vnq)
        {
          paramAnonymousView.aj((View)paramAnonymousView.vnf.get(paramAnonymousInt1), paramAnonymousInt1);
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
    this.vnk = paramb;
  }
  
  public void setEnterAnimator(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(65149);
    if (this.rUt != null)
    {
      this.rUt.removeAllListeners();
      this.rUt.cancel();
    }
    this.rUt = paramValueAnimator;
    if (this.rUt != null) {
      this.rUt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.vnj = parama;
  }
  
  public void setExitAnimator(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(65148);
    if (this.rUu != null)
    {
      this.rUu.removeAllListeners();
      this.rUu.cancel();
    }
    this.rUu = paramValueAnimator;
    if (this.rUu != null) {
      this.rUu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.vni = parama;
  }
  
  public void setShuffleSetting(c paramc)
  {
    AppMethodBeat.i(65135);
    this.vng = paramc;
    this.pPY = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.vnG);
    this.vnh = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.vnH);
    AppMethodBeat.o(65135);
  }
  
  static abstract interface a
  {
    public abstract void a(ValueAnimator paramValueAnimator, View paramView);
  }
  
  static abstract interface b
  {
    public abstract void Jd(int paramInt);
    
    public abstract void gu(int paramInt1, int paramInt2);
    
    public abstract void gv(int paramInt1, int paramInt2);
  }
  
  static final class c
  {
    public float scaleX = 0.01F;
    public float scaleY = 0.01F;
    public int vnD = 1;
    public int vnE = 1;
    public int vnF = 2;
    public int vnG = 200;
    public int vnH = 80;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView
 * JD-Core Version:    0.7.0.1
 */