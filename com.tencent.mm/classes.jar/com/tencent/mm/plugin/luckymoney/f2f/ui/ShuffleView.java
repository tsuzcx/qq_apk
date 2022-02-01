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
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView
  extends FrameLayout
{
  public static DisplayMetrics hUu;
  GestureDetector hRv;
  View isv;
  ValueAnimator oIY;
  private ArrayList<Float> tcA;
  private boolean tcB;
  private int tcC;
  private int tcD;
  List<View> tci;
  private c tcj;
  ValueAnimator tck;
  private ValueAnimator tcl;
  ValueAnimator tcm;
  private a tcn;
  private a tco;
  private b tcp;
  View tcq;
  private View tcr;
  int tcs;
  private View tct;
  private int tcu;
  int tcv;
  private final float tcw;
  private final float tcx;
  private final float tcy;
  private ArrayList<Float> tcz;
  private float translationX;
  private float translationY;
  
  public ShuffleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65134);
    this.tcw = 0.23F;
    this.tcx = 0.28F;
    this.tcy = 0.33F;
    this.tcD = 2500;
    this.hRv = new GestureDetector(new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65129);
        ad.d("ShuffleView", "gesture down");
        switch (ShuffleView.l(ShuffleView.this).tcJ)
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
          switch (ShuffleView.l(ShuffleView.this).tcJ)
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
                paramAnonymousMotionEvent1.FM(ShuffleView.d(ShuffleView.this));
              }
              ShuffleView.c(ShuffleView.this, ShuffleView.i(ShuffleView.this));
            }
          }
        }
        AppMethodBeat.o(65132);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(65131);
        int j;
        int k;
        if (paramAnonymousMotionEvent2.getActionMasked() == 2)
        {
          j = (int)paramAnonymousMotionEvent2.getX();
          k = (int)paramAnonymousMotionEvent2.getY();
          switch (ShuffleView.l(ShuffleView.this).tcJ)
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
        switch (ShuffleView.l(ShuffleView.this).tcJ)
        {
        default: 
          AppMethodBeat.o(65130);
          return false;
        }
        if (ShuffleView.h(ShuffleView.this) != null)
        {
          ad.d("ShuffleView", "click the select card");
          if (ShuffleView.n(ShuffleView.this) != null) {
            ShuffleView.n(ShuffleView.this).fX(ShuffleView.f(ShuffleView.this), ShuffleView.d(ShuffleView.this));
          }
          ShuffleView.m(ShuffleView.this);
        }
        if (ShuffleView.k(ShuffleView.this) != null)
        {
          if (ShuffleView.n(ShuffleView.this) != null)
          {
            paramAnonymousMotionEvent = ShuffleView.n(ShuffleView.this);
            ShuffleView.i(ShuffleView.this);
            paramAnonymousMotionEvent.FM(ShuffleView.d(ShuffleView.this));
          }
          ShuffleView.c(ShuffleView.this, ShuffleView.i(ShuffleView.this));
        }
        AppMethodBeat.o(65130);
        return true;
      }
    });
    this.tcj = new c();
    this.tci = new ArrayList();
    this.tcz = new ArrayList();
    this.tcA = new ArrayList();
    this.tcC = getResources().getDimensionPixelSize(2131166504);
    AppMethodBeat.o(65134);
  }
  
  private Rect FQ(int paramInt)
  {
    AppMethodBeat.i(65146);
    if ((paramInt >= 0) && (paramInt < this.tcv)) {
      localObject = (View)this.tci.get(paramInt);
    }
    switch (this.tcj.tcJ)
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
    View localView = (View)this.tci.get(paramInt - 1);
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
  
  private void cLk()
  {
    AppMethodBeat.i(65137);
    if (this.tcv > 1)
    {
      ad.d("ShuffleView", "card width: %d,height: %d", new Object[] { Integer.valueOf(((View)this.tci.get(0)).getWidth()), Integer.valueOf(((View)this.tci.get(0)).getHeight()) });
      if (this.tcj.tcI == 2)
      {
        this.translationX = (((View)this.tci.get(0)).getWidth() * 1.5F / this.tcv);
        if (this.translationX > ((View)this.tci.get(0)).getWidth() * 0.23F)
        {
          this.translationX = (((View)this.tci.get(0)).getWidth() * 0.23F);
          AppMethodBeat.o(65137);
        }
      }
      else if (this.tcj.tcI == 1)
      {
        this.translationY = (((View)this.tci.get(0)).getHeight() * 1.0F / this.tcv);
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
  
  private void cLm()
  {
    AppMethodBeat.i(65140);
    if (this.isv != null)
    {
      ad.i("ShuffleView", "selectView != null, cancel select");
      if (this.tcm.isStarted()) {
        this.tcm.cancel();
      }
      this.tcm.removeAllUpdateListeners();
      this.tcm.removeAllListeners();
      switch (this.tcj.tcJ)
      {
      }
    }
    for (;;)
    {
      this.isv = null;
      this.tcs = 0;
      this.tcm.start();
      AppMethodBeat.o(65140);
      return;
      if (this.tcs >= 0) {
        this.tcm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FN(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FO(i) * f);
              i += 1;
            }
            AppMethodBeat.o(65123);
          }
        });
      }
    }
  }
  
  private void cLn()
  {
    AppMethodBeat.i(65143);
    if (this.tct != null)
    {
      ad.i("ShuffleView", "touchView != null,cancel touch");
      if (this.tcm.isStarted()) {
        this.tcm.cancel();
      }
      this.tcm.removeAllUpdateListeners();
      this.tcm.removeAllListeners();
      switch (this.tcj.tcJ)
      {
      }
    }
    for (;;)
    {
      this.tct = null;
      this.tcu = -1;
      this.tcm.start();
      AppMethodBeat.o(65143);
      return;
      if (this.tcu >= 0) {
        this.tcm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FN(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FO(i) * f);
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
    if (this.isv != null)
    {
      float f1 = this.isv.getWidth();
      float f2 = this.translationX;
      int j = this.tcs - 1;
      int k = this.tcv - 1 - this.tcs;
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
    if (this.tct != null)
    {
      float f1 = this.tct.getWidth();
      float f2 = this.translationX;
      int j = this.tcu - 1;
      int k = this.tcv - 1 - this.tcu;
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
  
  public final float FN(int paramInt)
  {
    if ((this.tcj.tcI == 2) && (this.tcv > 0))
    {
      if (this.tcj.tcJ == 3) {
        return (this.tcv - 1) * 0.5F * this.translationX - this.translationX * paramInt;
      }
      if (this.tcj.tcJ == 4) {
        return this.translationX * paramInt - (this.tcv - 1) * 0.5F * this.translationX;
      }
    }
    return 0.0F;
  }
  
  public final float FO(int paramInt)
  {
    if (this.tcj.tcI == 1)
    {
      if (this.tcj.tcJ == 1) {
        return (this.tcv - 1) * 0.5F * this.translationY - this.translationY * paramInt;
      }
      if (this.tcj.tcJ == 2) {
        return this.translationY * paramInt - (this.tcv - 1) * 0.5F * this.translationY;
      }
    }
    return 0.0F;
  }
  
  final void FP(int paramInt)
  {
    AppMethodBeat.i(65142);
    if ((paramInt >= 0) && (paramInt < this.tcv))
    {
      ad.i("ShuffleView", "select card ".concat(String.valueOf(paramInt)));
      if (this.tcm.isStarted()) {
        this.tcm.cancel();
      }
      this.tcm.removeAllUpdateListeners();
      this.tcm.removeAllListeners();
      this.isv = ((View)this.tci.get(paramInt));
      this.tcs = paramInt;
      this.tct = null;
      this.tcu = -1;
      switch (this.tcj.tcJ)
      {
      }
    }
    for (;;)
    {
      this.tcm.start();
      AppMethodBeat.o(65142);
      return;
      if (paramInt > 0)
      {
        int i = this.tcv;
        this.tcm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
            if (this.tcG > 0)
            {
              i = 0;
              while (i < ShuffleView.f(ShuffleView.this) - 1)
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + (ShuffleView.this.FN(i) - (i + 1) * ShuffleView.g(ShuffleView.this)) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FO(i) * f);
                i += 1;
              }
              ((View)ShuffleView.e(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).floatValue() * (1.0F - f) + (ShuffleView.this.FN(ShuffleView.f(ShuffleView.this) - 1) - ShuffleView.g(ShuffleView.this) * this.tcG / 2.0F) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).floatValue() * (1.0F - f) + ShuffleView.this.FO(ShuffleView.f(ShuffleView.this) - 1) * f);
            }
            while (this.tcH > 0)
            {
              ShuffleView.h(ShuffleView.this).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(ShuffleView.f(ShuffleView.this))).floatValue() * (1.0F - f) + (ShuffleView.this.FN(ShuffleView.f(ShuffleView.this)) + ShuffleView.g(ShuffleView.this) * this.tcH / 2.0F) * f);
              i = ShuffleView.f(ShuffleView.this) + 1;
              while (i < ShuffleView.d(ShuffleView.this))
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + (ShuffleView.this.FN(i) + (ShuffleView.d(ShuffleView.this) - i) * ShuffleView.g(ShuffleView.this)) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FO(i) * f);
                i += 1;
              }
              i = 0;
              while (i < ShuffleView.f(ShuffleView.this))
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FN(i) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FO(i) * f);
                i += 1;
              }
            }
            i = ShuffleView.f(ShuffleView.this);
            while (i < ShuffleView.d(ShuffleView.this))
            {
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FN(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FO(i) * f);
              i += 1;
            }
            ShuffleView.h(ShuffleView.this).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(ShuffleView.f(ShuffleView.this))).floatValue() * (1.0F - f) - ShuffleView.h(ShuffleView.this).getHeight() * f / 7.0F);
            AppMethodBeat.o(65124);
          }
        });
      }
      else
      {
        this.tcm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FN(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.FO(i) * f);
              i += 1;
            }
            AppMethodBeat.o(65125);
          }
        });
      }
    }
  }
  
  final void FR(final int paramInt)
  {
    AppMethodBeat.i(65147);
    this.oIY.removeAllUpdateListeners();
    this.oIY.removeAllListeners();
    if (this.tci.size() < this.tcv)
    {
      this.tcv -= 1;
      if (this.tcv == 1) {
        ((View)this.tci.get(0)).findViewById(2131301827).setVisibility(0);
      }
      cLk();
      this.oIY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
            if (ShuffleView.l(ShuffleView.this).tcI == 1)
            {
              f2 = ShuffleView.l(ShuffleView.this).scaleX;
              f3 = i + 1;
              localView.setScaleX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleX + (1.0F - f2 * f3));
              f2 = ShuffleView.this.FO(i);
              localView.setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
            }
            for (;;)
            {
              i += 1;
              break;
              if (ShuffleView.l(ShuffleView.this).tcI == 2)
              {
                f2 = ShuffleView.l(ShuffleView.this).scaleY;
                f3 = i + 1;
                localView.setScaleY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleY + (1.0F - f2 * f3));
                f2 = ShuffleView.this.FN(i);
                localView.setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
              }
            }
          }
          AppMethodBeat.o(65133);
        }
      });
      this.oIY.addListener(new Animator.AnimatorListener()
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
      this.oIY.start();
      AppMethodBeat.o(65147);
      return;
    }
    this.tcr = ((View)this.tci.get(this.tcv - 1));
    ah(this.tcr, this.tcv - 1);
    addView(this.tcr, 0);
    if (this.tcl != null) {
      switch (this.tcj.tcK)
      {
      }
    }
    for (;;)
    {
      this.tcr.setVisibility(4);
      this.oIY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
            if (ShuffleView.l(ShuffleView.this).tcI == 1)
            {
              f1 = ShuffleView.l(ShuffleView.this).scaleX;
              f2 = i + 1;
              localView.setScaleX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleX + (1.0F - f1 * f2));
              if (ShuffleView.l(ShuffleView.this).tcJ == 2) {
                localView.setTranslationY(ShuffleView.this.FO(i + 1) - ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(ShuffleView.this));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if (ShuffleView.l(ShuffleView.this).tcJ == 1)
              {
                f1 = ShuffleView.this.FO(i + 1);
                localView.setTranslationY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(ShuffleView.this) + f1);
                continue;
                if (ShuffleView.l(ShuffleView.this).tcI == 2)
                {
                  f1 = ShuffleView.l(ShuffleView.this).scaleY;
                  f2 = i + 1;
                  localView.setScaleY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleY + (1.0F - f1 * f2));
                  if (ShuffleView.l(ShuffleView.this).tcJ == 3)
                  {
                    f1 = ShuffleView.this.FN(i + 1);
                    localView.setTranslationX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(ShuffleView.this) + f1);
                  }
                  else if (ShuffleView.l(ShuffleView.this).tcJ == 4)
                  {
                    localView.setTranslationX(ShuffleView.this.FN(i + 1) - ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(ShuffleView.this));
                  }
                }
              }
            }
          }
          AppMethodBeat.o(65117);
        }
      });
      this.oIY.addListener(new Animator.AnimatorListener()
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
      this.tcr.setTranslationY(-hUu.heightPixels);
      continue;
      this.tcr.setTranslationY(hUu.heightPixels);
      continue;
      this.tcr.setTranslationX(-hUu.widthPixels);
      continue;
      this.tcr.setTranslationX(hUu.widthPixels);
    }
  }
  
  final void ah(View paramView, int paramInt)
  {
    AppMethodBeat.i(65138);
    if (this.tcj.tcI == 1)
    {
      paramView.setScaleX(1.0F - this.tcj.scaleX * paramInt);
      paramView.setTranslationY(FO(paramInt));
      AppMethodBeat.o(65138);
      return;
    }
    if (this.tcj.tcI == 2)
    {
      paramView.setScaleY(1.0F - this.tcj.scaleY * paramInt);
      paramView.setTranslationX(FN(paramInt));
    }
    AppMethodBeat.o(65138);
  }
  
  final int cLl()
  {
    AppMethodBeat.i(65139);
    int i = (int)(Math.random() * this.tcv);
    AppMethodBeat.o(65139);
    return i;
  }
  
  public View getEnterView()
  {
    return this.tcr;
  }
  
  public View getExitView()
  {
    return this.tcq;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65145);
    if (this.tcB)
    {
      AppMethodBeat.o(65145);
      return true;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (this.tcv <= 0)
    {
      AppMethodBeat.o(65145);
      return false;
    }
    ad.d("ShuffleView", "y:%d,packet largest:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(getHeight() - ((View)this.tci.get(0)).getHeight() - ((View)this.tci.get(0)).getHeight() / 7) });
    if (k < getHeight() - ((View)this.tci.get(0)).getHeight() - ((View)this.tci.get(0)).getHeight() / 7)
    {
      if ((this.isv != null) && (paramMotionEvent.getActionMasked() == 0))
      {
        if (this.tcp != null) {
          this.tcp.fX(this.tcs, this.tcv);
        }
        cLm();
      }
      for (;;)
      {
        AppMethodBeat.o(65145);
        return false;
        if ((this.tct != null) && (this.tct.getTranslationY() == -this.tct.getHeight() / 7))
        {
          if (this.tcp != null) {
            this.tcp.FM(this.tcv);
          }
          FP(this.tcu);
        }
        else if (this.tct != null)
        {
          cLn();
        }
      }
    }
    int i = 0;
    if (i < this.tcv)
    {
      Rect localRect = FQ(i);
      if ((localRect == null) || (!localRect.contains(j, k))) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ad.d("ShuffleView", "event %d out of cards,%d,%d", new Object[] { Integer.valueOf(paramMotionEvent.getActionMasked()), Integer.valueOf(j), Integer.valueOf(k) });
        if ((this.isv == null) || (paramMotionEvent.getActionMasked() != 0)) {
          break label428;
        }
        if (this.tcp != null) {
          this.tcp.fX(this.tcs, this.tcv);
        }
        cLm();
      }
      for (;;)
      {
        if (this.tcv > 1) {
          break label503;
        }
        AppMethodBeat.o(65145);
        return false;
        i += 1;
        break;
        label428:
        if ((this.tct != null) && (this.tct.getTranslationY() == -this.tct.getHeight() / 7))
        {
          if (this.tcp != null) {
            this.tcp.FM(this.tcv);
          }
          FP(this.tcu);
        }
        else if (this.tct != null)
        {
          cLn();
        }
      }
      label503:
      boolean bool = this.hRv.onTouchEvent(paramMotionEvent);
      ad.i("ShuffleView", "ret:%s,action:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramMotionEvent.getActionMasked()) });
      if ((!bool) && (paramMotionEvent.getActionMasked() == 1))
      {
        if ((this.tct == null) || (this.tct.getTranslationY() != -this.tct.getHeight() / 7)) {
          break label622;
        }
        if (this.tcp != null) {
          this.tcp.FM(this.tcv);
        }
        FP(this.tcu);
      }
      for (;;)
      {
        AppMethodBeat.o(65145);
        return true;
        label622:
        if (this.tct != null) {
          cLn();
        }
      }
    }
  }
  
  public void setAllShuffleCards(List<View> paramList)
  {
    AppMethodBeat.i(65136);
    this.tci.clear();
    this.tci.addAll(paramList);
    this.tcs = 0;
    this.isv = null;
    this.tcu = -1;
    this.tct = null;
    removeAllViews();
    paramList = this.tci;
    if (paramList.size() > 100) {
      this.tcv = 100;
    }
    for (;;)
    {
      int i = this.tcv - 1;
      while (i >= 0)
      {
        addView((View)paramList.get(i));
        i -= 1;
      }
      this.tcv = paramList.size();
      if (this.tcv == 1) {
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
        while (paramAnonymousInt1 < paramAnonymousView.tcv)
        {
          paramAnonymousView.ah((View)paramAnonymousView.tci.get(paramAnonymousInt1), paramAnonymousInt1);
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
    this.tcp = paramb;
  }
  
  public void setEnterAnimator(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(65149);
    if (this.tcl != null)
    {
      this.tcl.removeAllListeners();
      this.tcl.cancel();
    }
    this.tcl = paramValueAnimator;
    if (this.tcl != null) {
      this.tcl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.tco = parama;
  }
  
  public void setExitAnimator(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(65148);
    if (this.tck != null)
    {
      this.tck.removeAllListeners();
      this.tck.cancel();
    }
    this.tck = paramValueAnimator;
    if (this.tck != null) {
      this.tck.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.tcn = parama;
  }
  
  public void setShuffleSetting(c paramc)
  {
    AppMethodBeat.i(65135);
    this.tcj = paramc;
    this.oIY = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.tcL);
    this.tcm = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.tcM);
    AppMethodBeat.o(65135);
  }
  
  static abstract interface a
  {
    public abstract void a(ValueAnimator paramValueAnimator, View paramView);
  }
  
  static abstract interface b
  {
    public abstract void FM(int paramInt);
    
    public abstract void fW(int paramInt1, int paramInt2);
    
    public abstract void fX(int paramInt1, int paramInt2);
  }
  
  static final class c
  {
    public float scaleX = 0.01F;
    public float scaleY = 0.01F;
    public int tcI = 1;
    public int tcJ = 1;
    public int tcK = 2;
    public int tcL = 200;
    public int tcM = 80;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView
 * JD-Core Version:    0.7.0.1
 */