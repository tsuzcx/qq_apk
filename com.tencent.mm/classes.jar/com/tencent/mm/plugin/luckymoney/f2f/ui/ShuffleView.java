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
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView
  extends FrameLayout
{
  public static DisplayMetrics metrics;
  GestureDetector jKk;
  View kmM;
  ValueAnimator rnC;
  private ValueAnimator tMC;
  ValueAnimator tMD;
  private float translationX;
  private float translationY;
  ValueAnimator yTA;
  private a yTB;
  private a yTC;
  private b yTD;
  View yTE;
  private View yTF;
  int yTG;
  private View yTH;
  private int yTI;
  int yTJ;
  private final float yTK;
  private final float yTL;
  private final float yTM;
  private ArrayList<Float> yTN;
  private ArrayList<Float> yTO;
  private boolean yTP;
  private int yTQ;
  private int yTR;
  List<View> yTy;
  private ShuffleView.c yTz;
  
  public ShuffleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(65134);
    this.yTK = 0.23F;
    this.yTL = 0.28F;
    this.yTM = 0.33F;
    this.yTR = 2500;
    this.jKk = new GestureDetector(new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(65129);
        Log.d("ShuffleView", "gesture down");
        switch (ShuffleView.l(ShuffleView.this).yTX)
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
              Log.i("ShuffleView", "down on the select card");
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
        Log.i("ShuffleView", "fling up ".concat(String.valueOf(paramAnonymousFloat2)));
        if (paramAnonymousFloat2 < -ShuffleView.r(ShuffleView.this))
        {
          switch (ShuffleView.l(ShuffleView.this).yTX)
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
                paramAnonymousMotionEvent1.PE(ShuffleView.d(ShuffleView.this));
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
        AppMethodBeat.i(213266);
        b localb = new b();
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(213266);
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
          switch (ShuffleView.l(ShuffleView.this).yTX)
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
              Log.i("ShuffleView", "scroll on the select card");
            }
          }
        } while (Math.abs(paramAnonymousFloat1) >= ShuffleView.o(ShuffleView.this));
        Log.d("ShuffleView", "scroll distanceY:".concat(String.valueOf(paramAnonymousFloat2)));
        if (ShuffleView.k(ShuffleView.this) != null) {
          paramAnonymousMotionEvent1 = ShuffleView.k(ShuffleView.this);
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent1 != null)
          {
            Log.i("ShuffleView", "scroll translationY:" + paramAnonymousMotionEvent1.getTranslationY() + "," + paramAnonymousMotionEvent1.getHeight() / 7);
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
                  Log.i("ShuffleView", "scroll when select view is animation");
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
        localb.bm(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
        switch (ShuffleView.l(ShuffleView.this).yTX)
        {
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(65130);
          return false;
        }
        if (ShuffleView.h(ShuffleView.this) != null)
        {
          Log.d("ShuffleView", "click the select card");
          if (ShuffleView.n(ShuffleView.this) != null) {
            ShuffleView.n(ShuffleView.this).gT(ShuffleView.f(ShuffleView.this), ShuffleView.d(ShuffleView.this));
          }
          ShuffleView.m(ShuffleView.this);
        }
        if (ShuffleView.k(ShuffleView.this) != null)
        {
          if (ShuffleView.n(ShuffleView.this) != null)
          {
            paramAnonymousMotionEvent = ShuffleView.n(ShuffleView.this);
            ShuffleView.i(ShuffleView.this);
            paramAnonymousMotionEvent.PE(ShuffleView.d(ShuffleView.this));
          }
          ShuffleView.c(ShuffleView.this, ShuffleView.i(ShuffleView.this));
        }
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView$8", "android/view/GestureDetector$OnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(65130);
        return true;
      }
    });
    this.yTz = new ShuffleView.c();
    this.yTy = new ArrayList();
    this.yTN = new ArrayList();
    this.yTO = new ArrayList();
    this.yTQ = getResources().getDimensionPixelSize(2131166619);
    AppMethodBeat.o(65134);
  }
  
  private Rect PI(int paramInt)
  {
    AppMethodBeat.i(65146);
    if ((paramInt >= 0) && (paramInt < this.yTJ)) {
      localObject = (View)this.yTy.get(paramInt);
    }
    switch (this.yTz.yTX)
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
    View localView = (View)this.yTy.get(paramInt - 1);
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
  
  private void eeT()
  {
    AppMethodBeat.i(65137);
    if (this.yTJ > 1)
    {
      Log.d("ShuffleView", "card width: %d,height: %d", new Object[] { Integer.valueOf(((View)this.yTy.get(0)).getWidth()), Integer.valueOf(((View)this.yTy.get(0)).getHeight()) });
      if (this.yTz.yTW == 2)
      {
        this.translationX = (((View)this.yTy.get(0)).getWidth() * 1.5F / this.yTJ);
        if (this.translationX > ((View)this.yTy.get(0)).getWidth() * 0.23F)
        {
          this.translationX = (((View)this.yTy.get(0)).getWidth() * 0.23F);
          AppMethodBeat.o(65137);
        }
      }
      else if (this.yTz.yTW == 1)
      {
        this.translationY = (((View)this.yTy.get(0)).getHeight() * 1.0F / this.yTJ);
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
  
  private void eeV()
  {
    AppMethodBeat.i(65140);
    if (this.kmM != null)
    {
      Log.i("ShuffleView", "selectView != null, cancel select");
      if (this.yTA.isStarted()) {
        this.yTA.cancel();
      }
      this.yTA.removeAllUpdateListeners();
      this.yTA.removeAllListeners();
      switch (this.yTz.yTX)
      {
      }
    }
    for (;;)
    {
      this.kmM = null;
      this.yTG = 0;
      this.yTA.start();
      AppMethodBeat.o(65140);
      return;
      if (this.yTG >= 0) {
        this.yTA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PF(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PG(i) * f);
              i += 1;
            }
            AppMethodBeat.o(65123);
          }
        });
      }
    }
  }
  
  private void eeW()
  {
    AppMethodBeat.i(65143);
    if (this.yTH != null)
    {
      Log.i("ShuffleView", "touchView != null,cancel touch");
      if (this.yTA.isStarted()) {
        this.yTA.cancel();
      }
      this.yTA.removeAllUpdateListeners();
      this.yTA.removeAllListeners();
      switch (this.yTz.yTX)
      {
      }
    }
    for (;;)
    {
      this.yTH = null;
      this.yTI = -1;
      this.yTA.start();
      AppMethodBeat.o(65143);
      return;
      if (this.yTI >= 0) {
        this.yTA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PF(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PG(i) * f);
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
    if (this.kmM != null)
    {
      float f1 = this.kmM.getWidth();
      float f2 = this.translationX;
      int j = this.yTG - 1;
      int k = this.yTJ - 1 - this.yTG;
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
    if (this.yTH != null)
    {
      float f1 = this.yTH.getWidth();
      float f2 = this.translationX;
      int j = this.yTI - 1;
      int k = this.yTJ - 1 - this.yTI;
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
  
  public final float PF(int paramInt)
  {
    if ((this.yTz.yTW == 2) && (this.yTJ > 0))
    {
      if (this.yTz.yTX == 3) {
        return (this.yTJ - 1) * 0.5F * this.translationX - this.translationX * paramInt;
      }
      if (this.yTz.yTX == 4) {
        return this.translationX * paramInt - (this.yTJ - 1) * 0.5F * this.translationX;
      }
    }
    return 0.0F;
  }
  
  public final float PG(int paramInt)
  {
    if (this.yTz.yTW == 1)
    {
      if (this.yTz.yTX == 1) {
        return (this.yTJ - 1) * 0.5F * this.translationY - this.translationY * paramInt;
      }
      if (this.yTz.yTX == 2) {
        return this.translationY * paramInt - (this.yTJ - 1) * 0.5F * this.translationY;
      }
    }
    return 0.0F;
  }
  
  final void PH(int paramInt)
  {
    AppMethodBeat.i(65142);
    if ((paramInt >= 0) && (paramInt < this.yTJ))
    {
      Log.i("ShuffleView", "select card ".concat(String.valueOf(paramInt)));
      if (this.yTA.isStarted()) {
        this.yTA.cancel();
      }
      this.yTA.removeAllUpdateListeners();
      this.yTA.removeAllListeners();
      this.kmM = ((View)this.yTy.get(paramInt));
      this.yTG = paramInt;
      this.yTH = null;
      this.yTI = -1;
      switch (this.yTz.yTX)
      {
      }
    }
    for (;;)
    {
      this.yTA.start();
      AppMethodBeat.o(65142);
      return;
      if (paramInt > 0)
      {
        int i = this.yTJ;
        this.yTA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
            if (this.yTU > 0)
            {
              i = 0;
              while (i < ShuffleView.f(ShuffleView.this) - 1)
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + (ShuffleView.this.PF(i) - (i + 1) * ShuffleView.g(ShuffleView.this)) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PG(i) * f);
                i += 1;
              }
              ((View)ShuffleView.e(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).floatValue() * (1.0F - f) + (ShuffleView.this.PF(ShuffleView.f(ShuffleView.this) - 1) - ShuffleView.g(ShuffleView.this) * this.yTU / 2.0F) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(ShuffleView.f(ShuffleView.this) - 1)).floatValue() * (1.0F - f) + ShuffleView.this.PG(ShuffleView.f(ShuffleView.this) - 1) * f);
            }
            while (this.yTV > 0)
            {
              ShuffleView.h(ShuffleView.this).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(ShuffleView.f(ShuffleView.this))).floatValue() * (1.0F - f) + (ShuffleView.this.PF(ShuffleView.f(ShuffleView.this)) + ShuffleView.g(ShuffleView.this) * this.yTV / 2.0F) * f);
              i = ShuffleView.f(ShuffleView.this) + 1;
              while (i < ShuffleView.d(ShuffleView.this))
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + (ShuffleView.this.PF(i) + (ShuffleView.d(ShuffleView.this) - i) * ShuffleView.g(ShuffleView.this)) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PG(i) * f);
                i += 1;
              }
              i = 0;
              while (i < ShuffleView.f(ShuffleView.this))
              {
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PF(i) * f);
                ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PG(i) * f);
                i += 1;
              }
            }
            i = ShuffleView.f(ShuffleView.this);
            while (i < ShuffleView.d(ShuffleView.this))
            {
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PF(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PG(i) * f);
              i += 1;
            }
            ShuffleView.h(ShuffleView.this).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(ShuffleView.f(ShuffleView.this))).floatValue() * (1.0F - f) - ShuffleView.h(ShuffleView.this).getHeight() * f / 7.0F);
            AppMethodBeat.o(65124);
          }
        });
      }
      else
      {
        this.yTA.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PF(i) * f);
              ((View)ShuffleView.e(ShuffleView.this).get(i)).setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f) + ShuffleView.this.PG(i) * f);
              i += 1;
            }
            AppMethodBeat.o(65125);
          }
        });
      }
    }
  }
  
  final void PJ(final int paramInt)
  {
    AppMethodBeat.i(65147);
    this.rnC.removeAllUpdateListeners();
    this.rnC.removeAllListeners();
    if (this.yTy.size() < this.yTJ)
    {
      this.yTJ -= 1;
      if (this.yTJ == 1) {
        ((View)this.yTy.get(0)).findViewById(2131304138).setVisibility(0);
      }
      eeT();
      this.rnC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
            if (ShuffleView.l(ShuffleView.this).yTW == 1)
            {
              f2 = ShuffleView.l(ShuffleView.this).scaleX;
              f3 = i + 1;
              localView.setScaleX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleX + (1.0F - f2 * f3));
              f2 = ShuffleView.this.PG(i);
              localView.setTranslationY(((Float)ShuffleView.c(ShuffleView.this).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
            }
            for (;;)
            {
              i += 1;
              break;
              if (ShuffleView.l(ShuffleView.this).yTW == 2)
              {
                f2 = ShuffleView.l(ShuffleView.this).scaleY;
                f3 = i + 1;
                localView.setScaleY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleY + (1.0F - f2 * f3));
                f2 = ShuffleView.this.PF(i);
                localView.setTranslationX(((Float)ShuffleView.b(ShuffleView.this).get(i)).floatValue() * (1.0F - f1) + f1 * f2);
              }
            }
          }
          AppMethodBeat.o(65133);
        }
      });
      this.rnC.addListener(new Animator.AnimatorListener()
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
      this.rnC.start();
      AppMethodBeat.o(65147);
      return;
    }
    this.yTF = ((View)this.yTy.get(this.yTJ - 1));
    al(this.yTF, this.yTJ - 1);
    addView(this.yTF, 0);
    if (this.tMC != null) {
      switch (this.yTz.yTY)
      {
      }
    }
    for (;;)
    {
      this.yTF.setVisibility(4);
      this.rnC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
            if (ShuffleView.l(ShuffleView.this).yTW == 1)
            {
              f1 = ShuffleView.l(ShuffleView.this).scaleX;
              f2 = i + 1;
              localView.setScaleX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleX + (1.0F - f1 * f2));
              if (ShuffleView.l(ShuffleView.this).yTX == 2) {
                localView.setTranslationY(ShuffleView.this.PG(i + 1) - ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(ShuffleView.this));
              }
            }
            for (;;)
            {
              i += 1;
              break;
              if (ShuffleView.l(ShuffleView.this).yTX == 1)
              {
                f1 = ShuffleView.this.PG(i + 1);
                localView.setTranslationY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.s(ShuffleView.this) + f1);
                continue;
                if (ShuffleView.l(ShuffleView.this).yTW == 2)
                {
                  f1 = ShuffleView.l(ShuffleView.this).scaleY;
                  f2 = i + 1;
                  localView.setScaleY(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.l(ShuffleView.this).scaleY + (1.0F - f1 * f2));
                  if (ShuffleView.l(ShuffleView.this).yTX == 3)
                  {
                    f1 = ShuffleView.this.PF(i + 1);
                    localView.setTranslationX(((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(ShuffleView.this) + f1);
                  }
                  else if (ShuffleView.l(ShuffleView.this).yTX == 4)
                  {
                    localView.setTranslationX(ShuffleView.this.PF(i + 1) - ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue() * ShuffleView.t(ShuffleView.this));
                  }
                }
              }
            }
          }
          AppMethodBeat.o(65117);
        }
      });
      this.rnC.addListener(new Animator.AnimatorListener()
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
      this.yTF.setTranslationY(-metrics.heightPixels);
      continue;
      this.yTF.setTranslationY(metrics.heightPixels);
      continue;
      this.yTF.setTranslationX(-metrics.widthPixels);
      continue;
      this.yTF.setTranslationX(metrics.widthPixels);
    }
  }
  
  final void al(View paramView, int paramInt)
  {
    AppMethodBeat.i(65138);
    if (this.yTz.yTW == 1)
    {
      paramView.setScaleX(1.0F - this.yTz.scaleX * paramInt);
      paramView.setTranslationY(PG(paramInt));
      AppMethodBeat.o(65138);
      return;
    }
    if (this.yTz.yTW == 2)
    {
      paramView.setScaleY(1.0F - this.yTz.scaleY * paramInt);
      paramView.setTranslationX(PF(paramInt));
    }
    AppMethodBeat.o(65138);
  }
  
  final int eeU()
  {
    AppMethodBeat.i(65139);
    int i = (int)(Math.random() * this.yTJ);
    AppMethodBeat.o(65139);
    return i;
  }
  
  public View getEnterView()
  {
    return this.yTF;
  }
  
  public View getExitView()
  {
    return this.yTE;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(65145);
    if (this.yTP)
    {
      AppMethodBeat.o(65145);
      return true;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (this.yTJ <= 0)
    {
      AppMethodBeat.o(65145);
      return false;
    }
    Log.d("ShuffleView", "y:%d,packet largest:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(getHeight() - ((View)this.yTy.get(0)).getHeight() - ((View)this.yTy.get(0)).getHeight() / 7) });
    if (k < getHeight() - ((View)this.yTy.get(0)).getHeight() - ((View)this.yTy.get(0)).getHeight() / 7)
    {
      if ((this.kmM != null) && (paramMotionEvent.getActionMasked() == 0))
      {
        if (this.yTD != null) {
          this.yTD.gT(this.yTG, this.yTJ);
        }
        eeV();
      }
      for (;;)
      {
        AppMethodBeat.o(65145);
        return false;
        if ((this.yTH != null) && (this.yTH.getTranslationY() == -this.yTH.getHeight() / 7))
        {
          if (this.yTD != null) {
            this.yTD.PE(this.yTJ);
          }
          PH(this.yTI);
        }
        else if (this.yTH != null)
        {
          eeW();
        }
      }
    }
    int i = 0;
    Object localObject;
    if (i < this.yTJ)
    {
      localObject = PI(i);
      if ((localObject == null) || (!((Rect)localObject).contains(j, k))) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        Log.d("ShuffleView", "event %d out of cards,%d,%d", new Object[] { Integer.valueOf(paramMotionEvent.getActionMasked()), Integer.valueOf(j), Integer.valueOf(k) });
        if ((this.kmM == null) || (paramMotionEvent.getActionMasked() != 0)) {
          break label428;
        }
        if (this.yTD != null) {
          this.yTD.gT(this.yTG, this.yTJ);
        }
        eeV();
      }
      for (;;)
      {
        if (this.yTJ > 1) {
          break label503;
        }
        AppMethodBeat.o(65145);
        return false;
        i += 1;
        break;
        label428:
        if ((this.yTH != null) && (this.yTH.getTranslationY() == -this.yTH.getHeight() / 7))
        {
          if (this.yTD != null) {
            this.yTD.PE(this.yTJ);
          }
          PH(this.yTI);
        }
        else if (this.yTH != null)
        {
          eeW();
        }
      }
      label503:
      localObject = this.jKk;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      boolean bool = com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/luckymoney/f2f/ui/ShuffleView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
      Log.i("ShuffleView", "ret:%s,action:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramMotionEvent.getActionMasked()) });
      if ((!bool) && (paramMotionEvent.getActionMasked() == 1))
      {
        if ((this.yTH == null) || (this.yTH.getTranslationY() != -this.yTH.getHeight() / 7)) {
          break label698;
        }
        if (this.yTD != null) {
          this.yTD.PE(this.yTJ);
        }
        PH(this.yTI);
      }
      for (;;)
      {
        AppMethodBeat.o(65145);
        return true;
        label698:
        if (this.yTH != null) {
          eeW();
        }
      }
    }
  }
  
  public void setAllShuffleCards(List<View> paramList)
  {
    AppMethodBeat.i(65136);
    this.yTy.clear();
    this.yTy.addAll(paramList);
    this.yTG = 0;
    this.kmM = null;
    this.yTI = -1;
    this.yTH = null;
    removeAllViews();
    paramList = this.yTy;
    if (paramList.size() > 100) {
      this.yTJ = 100;
    }
    for (;;)
    {
      int i = this.yTJ - 1;
      while (i >= 0)
      {
        addView((View)paramList.get(i));
        i -= 1;
      }
      this.yTJ = paramList.size();
      if (this.yTJ == 1) {
        ((View)paramList.get(0)).findViewById(2131304138).setVisibility(0);
      }
    }
    addOnLayoutChangeListener(new ShuffleView.1(this));
    AppMethodBeat.o(65136);
  }
  
  public void setCardListener(b paramb)
  {
    this.yTD = paramb;
  }
  
  public void setEnterAnimator(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(65149);
    if (this.tMC != null)
    {
      this.tMC.removeAllListeners();
      this.tMC.cancel();
    }
    this.tMC = paramValueAnimator;
    if (this.tMC != null) {
      this.tMC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.yTC = parama;
  }
  
  public void setExitAnimator(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(65148);
    if (this.tMD != null)
    {
      this.tMD.removeAllListeners();
      this.tMD.cancel();
    }
    this.tMD = paramValueAnimator;
    if (this.tMD != null) {
      this.tMD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
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
    this.yTB = parama;
  }
  
  public void setShuffleSetting(ShuffleView.c paramc)
  {
    AppMethodBeat.i(65135);
    this.yTz = paramc;
    this.rnC = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.yTZ);
    this.yTA = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.yUa);
    AppMethodBeat.o(65135);
  }
  
  static abstract interface a
  {
    public abstract void a(ValueAnimator paramValueAnimator, View paramView);
  }
  
  static abstract interface b
  {
    public abstract void PE(int paramInt);
    
    public abstract void gS(int paramInt1, int paramInt2);
    
    public abstract void gT(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView
 * JD-Core Version:    0.7.0.1
 */