package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
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
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView
  extends FrameLayout
{
  public static DisplayMetrics gjH;
  View gEO;
  GestureDetector lOj;
  ValueAnimator lsF;
  private View omA;
  int omB;
  private View omC;
  private int omD;
  int omE;
  private final float omF;
  private final float omG;
  private final float omH;
  private ArrayList<Float> omI;
  private ArrayList<Float> omJ;
  private boolean omK;
  private int omL;
  private int omM;
  List<View> omr;
  private ShuffleView.c oms;
  ValueAnimator omt;
  private ValueAnimator omu;
  ValueAnimator omv;
  private ShuffleView.a omw;
  private ShuffleView.a omx;
  private ShuffleView.b omy;
  View omz;
  private float translationX;
  private float translationY;
  
  public ShuffleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(42244);
    this.omF = 0.23F;
    this.omG = 0.28F;
    this.omH = 0.33F;
    this.omM = 2500;
    this.lOj = new GestureDetector(new GestureDetector.OnGestureListener()
    {
      public final boolean onDown(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(42239);
        ab.d("ShuffleView", "gesture down");
        switch (ShuffleView.l(ShuffleView.this).omS)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(42239);
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
                AppMethodBeat.o(42239);
                return true;
              }
              ab.i("ShuffleView", "down on the select card");
              AppMethodBeat.o(42239);
              return true;
            }
            i += 1;
          }
        }
      }
      
      public final boolean onFling(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(42242);
        ab.i("ShuffleView", "fling up ".concat(String.valueOf(paramAnonymousFloat2)));
        if (paramAnonymousFloat2 < -ShuffleView.r(ShuffleView.this))
        {
          switch (ShuffleView.l(ShuffleView.this).omS)
          {
          }
          for (;;)
          {
            AppMethodBeat.o(42242);
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
                paramAnonymousMotionEvent1.yj(ShuffleView.d(ShuffleView.this));
              }
              ShuffleView.c(ShuffleView.this, ShuffleView.i(ShuffleView.this));
            }
          }
        }
        AppMethodBeat.o(42242);
        return false;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent) {}
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(42241);
        int j;
        int k;
        if (paramAnonymousMotionEvent2.getActionMasked() == 2)
        {
          j = (int)paramAnonymousMotionEvent2.getX();
          k = (int)paramAnonymousMotionEvent2.getY();
          switch (ShuffleView.l(ShuffleView.this).omS)
          {
          }
        }
        label202:
        do
        {
          AppMethodBeat.o(42241);
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
              ab.i("ShuffleView", "scroll on the select card");
            }
          }
        } while (Math.abs(paramAnonymousFloat1) >= ShuffleView.o(ShuffleView.this));
        ab.d("ShuffleView", "scroll distanceY:".concat(String.valueOf(paramAnonymousFloat2)));
        if (ShuffleView.k(ShuffleView.this) != null) {
          paramAnonymousMotionEvent1 = ShuffleView.k(ShuffleView.this);
        }
        for (;;)
        {
          if (paramAnonymousMotionEvent1 != null)
          {
            ab.i("ShuffleView", "scroll translationY:" + paramAnonymousMotionEvent1.getTranslationY() + "," + paramAnonymousMotionEvent1.getHeight() / 7);
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
                  ab.i("ShuffleView", "scroll when select view is animation");
                  ShuffleView.q(ShuffleView.this).cancel();
                }
                ShuffleView.b(ShuffleView.this, null);
                ShuffleView.e(ShuffleView.this, 0);
              }
            }
          }
          for (;;)
          {
            AppMethodBeat.o(42241);
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
        AppMethodBeat.i(42240);
        switch (ShuffleView.l(ShuffleView.this).omS)
        {
        default: 
          AppMethodBeat.o(42240);
          return false;
        }
        if (ShuffleView.h(ShuffleView.this) != null)
        {
          ab.d("ShuffleView", "click the select card");
          if (ShuffleView.n(ShuffleView.this) != null) {
            ShuffleView.n(ShuffleView.this).eB(ShuffleView.f(ShuffleView.this), ShuffleView.d(ShuffleView.this));
          }
          ShuffleView.m(ShuffleView.this);
        }
        if (ShuffleView.k(ShuffleView.this) != null)
        {
          if (ShuffleView.n(ShuffleView.this) != null)
          {
            paramAnonymousMotionEvent = ShuffleView.n(ShuffleView.this);
            ShuffleView.i(ShuffleView.this);
            paramAnonymousMotionEvent.yj(ShuffleView.d(ShuffleView.this));
          }
          ShuffleView.c(ShuffleView.this, ShuffleView.i(ShuffleView.this));
        }
        AppMethodBeat.o(42240);
        return true;
      }
    });
    this.oms = new ShuffleView.c();
    this.omr = new ArrayList();
    this.omI = new ArrayList();
    this.omJ = new ArrayList();
    this.omL = getResources().getDimensionPixelSize(2131428515);
    AppMethodBeat.o(42244);
  }
  
  private void bNb()
  {
    AppMethodBeat.i(42247);
    if (this.omE > 1)
    {
      ab.d("ShuffleView", "card width: %d,height: %d", new Object[] { Integer.valueOf(((View)this.omr.get(0)).getWidth()), Integer.valueOf(((View)this.omr.get(0)).getHeight()) });
      if (this.oms.omR == 2)
      {
        this.translationX = (((View)this.omr.get(0)).getWidth() * 1.5F / this.omE);
        if (this.translationX > ((View)this.omr.get(0)).getWidth() * 0.23F)
        {
          this.translationX = (((View)this.omr.get(0)).getWidth() * 0.23F);
          AppMethodBeat.o(42247);
        }
      }
      else if (this.oms.omR == 1)
      {
        this.translationY = (((View)this.omr.get(0)).getHeight() * 1.0F / this.omE);
        AppMethodBeat.o(42247);
      }
    }
    else
    {
      this.translationX = 0.0F;
      this.translationY = 0.0F;
    }
    AppMethodBeat.o(42247);
  }
  
  private void bNd()
  {
    AppMethodBeat.i(42250);
    if (this.gEO != null)
    {
      ab.i("ShuffleView", "selectView != null, cancel select");
      if (this.omv.isStarted()) {
        this.omv.cancel();
      }
      this.omv.removeAllUpdateListeners();
      this.omv.removeAllListeners();
      switch (this.oms.omS)
      {
      }
    }
    for (;;)
    {
      this.gEO = null;
      this.omB = 0;
      this.omv.start();
      AppMethodBeat.o(42250);
      return;
      if (this.omB >= 0) {
        this.omv.addUpdateListener(new ShuffleView.8(this));
      }
    }
  }
  
  private void bNe()
  {
    AppMethodBeat.i(42253);
    if (this.omC != null)
    {
      ab.i("ShuffleView", "touchView != null,cancel touch");
      if (this.omv.isStarted()) {
        this.omv.cancel();
      }
      this.omv.removeAllUpdateListeners();
      this.omv.removeAllListeners();
      switch (this.oms.omS)
      {
      }
    }
    for (;;)
    {
      this.omC = null;
      this.omD = -1;
      this.omv.start();
      AppMethodBeat.o(42253);
      return;
      if (this.omD >= 0) {
        this.omv.addUpdateListener(new ShuffleView.11(this));
      }
    }
  }
  
  private float getSelectScaleTranslationX()
  {
    AppMethodBeat.i(42251);
    if (this.gEO != null)
    {
      float f1 = this.gEO.getWidth();
      float f2 = this.translationX;
      int j = this.omB - 1;
      int k = this.omE - 1 - this.omB;
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
        AppMethodBeat.o(42251);
        return f1;
      }
    }
    AppMethodBeat.o(42251);
    return 0.0F;
  }
  
  private float getTouchScaleTranslationX()
  {
    AppMethodBeat.i(42254);
    if (this.omC != null)
    {
      float f1 = this.omC.getWidth();
      float f2 = this.translationX;
      int j = this.omD - 1;
      int k = this.omE - 1 - this.omD;
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
        AppMethodBeat.o(42254);
        return f1;
      }
    }
    AppMethodBeat.o(42254);
    return 0.0F;
  }
  
  private Rect yn(int paramInt)
  {
    AppMethodBeat.i(42256);
    if ((paramInt >= 0) && (paramInt < this.omE)) {
      localObject = (View)this.omr.get(paramInt);
    }
    switch (this.oms.omS)
    {
    default: 
      AppMethodBeat.o(42256);
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
      AppMethodBeat.o(42256);
      return localObject;
    }
    View localView = (View)this.omr.get(paramInt - 1);
    paramInt = localView.getRight();
    int i = (int)localView.getTranslationX();
    int j = ((View)localObject).getTop();
    int k = (int)((View)localObject).getTranslationY();
    int m = ((View)localObject).getRight();
    int n = (int)((View)localObject).getTranslationX();
    int i1 = ((View)localObject).getBottom();
    Object localObject = new Rect(i + paramInt, j + k, m + n, (int)((View)localObject).getTranslationY() + i1);
    AppMethodBeat.o(42256);
    return localObject;
  }
  
  final void aa(View paramView, int paramInt)
  {
    AppMethodBeat.i(42248);
    if (this.oms.omR == 1)
    {
      paramView.setScaleX(1.0F - this.oms.scaleX * paramInt);
      paramView.setTranslationY(yl(paramInt));
      AppMethodBeat.o(42248);
      return;
    }
    if (this.oms.omR == 2)
    {
      paramView.setScaleY(1.0F - this.oms.scaleY * paramInt);
      paramView.setTranslationX(yk(paramInt));
    }
    AppMethodBeat.o(42248);
  }
  
  final int bNc()
  {
    AppMethodBeat.i(42249);
    int i = (int)(Math.random() * this.omE);
    AppMethodBeat.o(42249);
    return i;
  }
  
  public View getEnterView()
  {
    return this.omA;
  }
  
  public View getExitView()
  {
    return this.omz;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(42255);
    if (this.omK)
    {
      AppMethodBeat.o(42255);
      return true;
    }
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    if (this.omE <= 0)
    {
      AppMethodBeat.o(42255);
      return false;
    }
    ab.d("ShuffleView", "y:%d,packet largest:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(getHeight() - ((View)this.omr.get(0)).getHeight() - ((View)this.omr.get(0)).getHeight() / 7) });
    if (k < getHeight() - ((View)this.omr.get(0)).getHeight() - ((View)this.omr.get(0)).getHeight() / 7)
    {
      if ((this.gEO != null) && (paramMotionEvent.getActionMasked() == 0))
      {
        if (this.omy != null) {
          this.omy.eB(this.omB, this.omE);
        }
        bNd();
      }
      for (;;)
      {
        AppMethodBeat.o(42255);
        return false;
        if ((this.omC != null) && (this.omC.getTranslationY() == -this.omC.getHeight() / 7))
        {
          if (this.omy != null) {
            this.omy.yj(this.omE);
          }
          ym(this.omD);
        }
        else if (this.omC != null)
        {
          bNe();
        }
      }
    }
    int i = 0;
    if (i < this.omE)
    {
      Rect localRect = yn(i);
      if ((localRect == null) || (!localRect.contains(j, k))) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        ab.d("ShuffleView", "event %d out of cards,%d,%d", new Object[] { Integer.valueOf(paramMotionEvent.getActionMasked()), Integer.valueOf(j), Integer.valueOf(k) });
        if ((this.gEO == null) || (paramMotionEvent.getActionMasked() != 0)) {
          break label428;
        }
        if (this.omy != null) {
          this.omy.eB(this.omB, this.omE);
        }
        bNd();
      }
      for (;;)
      {
        if (this.omE > 1) {
          break label503;
        }
        AppMethodBeat.o(42255);
        return false;
        i += 1;
        break;
        label428:
        if ((this.omC != null) && (this.omC.getTranslationY() == -this.omC.getHeight() / 7))
        {
          if (this.omy != null) {
            this.omy.yj(this.omE);
          }
          ym(this.omD);
        }
        else if (this.omC != null)
        {
          bNe();
        }
      }
      label503:
      boolean bool = this.lOj.onTouchEvent(paramMotionEvent);
      ab.i("ShuffleView", "ret:%s,action:%s", new Object[] { Boolean.valueOf(bool), Integer.valueOf(paramMotionEvent.getActionMasked()) });
      if ((!bool) && (paramMotionEvent.getActionMasked() == 1))
      {
        if ((this.omC == null) || (this.omC.getTranslationY() != -this.omC.getHeight() / 7)) {
          break label622;
        }
        if (this.omy != null) {
          this.omy.yj(this.omE);
        }
        ym(this.omD);
      }
      for (;;)
      {
        AppMethodBeat.o(42255);
        return true;
        label622:
        if (this.omC != null) {
          bNe();
        }
      }
    }
  }
  
  public void setAllShuffleCards(List<View> paramList)
  {
    AppMethodBeat.i(42246);
    this.omr.clear();
    this.omr.addAll(paramList);
    this.omB = 0;
    this.gEO = null;
    this.omD = -1;
    this.omC = null;
    removeAllViews();
    paramList = this.omr;
    if (paramList.size() > 100) {
      this.omE = 100;
    }
    for (;;)
    {
      int i = this.omE - 1;
      while (i >= 0)
      {
        addView((View)paramList.get(i));
        i -= 1;
      }
      this.omE = paramList.size();
      if (this.omE == 1) {
        ((View)paramList.get(0)).findViewById(2131825665).setVisibility(0);
      }
    }
    addOnLayoutChangeListener(new ShuffleView.1(this));
    AppMethodBeat.o(42246);
  }
  
  public void setCardListener(ShuffleView.b paramb)
  {
    this.omy = paramb;
  }
  
  public void setEnterAnimator(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(42259);
    if (this.omu != null)
    {
      this.omu.removeAllListeners();
      this.omu.cancel();
    }
    this.omu = paramValueAnimator;
    if (this.omu != null) {
      this.omu.addUpdateListener(new ShuffleView.7(this));
    }
    AppMethodBeat.o(42259);
  }
  
  public void setEnterAnimatorListener(ShuffleView.a parama)
  {
    this.omx = parama;
  }
  
  public void setExitAnimator(ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(42258);
    if (this.omt != null)
    {
      this.omt.removeAllListeners();
      this.omt.cancel();
    }
    this.omt = paramValueAnimator;
    if (this.omt != null) {
      this.omt.addUpdateListener(new ShuffleView.6(this));
    }
    AppMethodBeat.o(42258);
  }
  
  public void setExitAnimatorListener(ShuffleView.a parama)
  {
    this.omw = parama;
  }
  
  public void setShuffleSetting(ShuffleView.c paramc)
  {
    AppMethodBeat.i(42245);
    this.oms = paramc;
    this.lsF = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.omU);
    this.omv = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.omV);
    AppMethodBeat.o(42245);
  }
  
  public final float yk(int paramInt)
  {
    if ((this.oms.omR == 2) && (this.omE > 0))
    {
      if (this.oms.omS == 3) {
        return (this.omE - 1) * 0.5F * this.translationX - this.translationX * paramInt;
      }
      if (this.oms.omS == 4) {
        return this.translationX * paramInt - (this.omE - 1) * 0.5F * this.translationX;
      }
    }
    return 0.0F;
  }
  
  public final float yl(int paramInt)
  {
    if (this.oms.omR == 1)
    {
      if (this.oms.omS == 1) {
        return (this.omE - 1) * 0.5F * this.translationY - this.translationY * paramInt;
      }
      if (this.oms.omS == 2) {
        return this.translationY * paramInt - (this.omE - 1) * 0.5F * this.translationY;
      }
    }
    return 0.0F;
  }
  
  final void ym(int paramInt)
  {
    AppMethodBeat.i(42252);
    if ((paramInt >= 0) && (paramInt < this.omE))
    {
      ab.i("ShuffleView", "select card ".concat(String.valueOf(paramInt)));
      if (this.omv.isStarted()) {
        this.omv.cancel();
      }
      this.omv.removeAllUpdateListeners();
      this.omv.removeAllListeners();
      this.gEO = ((View)this.omr.get(paramInt));
      this.omB = paramInt;
      this.omC = null;
      this.omD = -1;
      switch (this.oms.omS)
      {
      }
    }
    for (;;)
    {
      this.omv.start();
      AppMethodBeat.o(42252);
      return;
      if (paramInt > 0)
      {
        int i = this.omE;
        this.omv.addUpdateListener(new ShuffleView.9(this, paramInt - 1, i - 1 - paramInt));
      }
      else
      {
        this.omv.addUpdateListener(new ShuffleView.10(this));
      }
    }
  }
  
  final void yo(int paramInt)
  {
    AppMethodBeat.i(42257);
    this.lsF.removeAllUpdateListeners();
    this.lsF.removeAllListeners();
    if (this.omr.size() < this.omE)
    {
      this.omE -= 1;
      if (this.omE == 1) {
        ((View)this.omr.get(0)).findViewById(2131825665).setVisibility(0);
      }
      bNb();
      this.lsF.addUpdateListener(new ShuffleView.15(this));
      this.lsF.addListener(new ShuffleView.2(this));
      this.lsF.start();
      AppMethodBeat.o(42257);
      return;
    }
    this.omA = ((View)this.omr.get(this.omE - 1));
    aa(this.omA, this.omE - 1);
    addView(this.omA, 0);
    if (this.omu != null) {
      switch (this.oms.omT)
      {
      }
    }
    for (;;)
    {
      this.omA.setVisibility(4);
      this.lsF.addUpdateListener(new ShuffleView.3(this, paramInt));
      this.lsF.addListener(new ShuffleView.4(this));
      break;
      this.omA.setTranslationY(-gjH.heightPixels);
      continue;
      this.omA.setTranslationY(gjH.heightPixels);
      continue;
      this.omA.setTranslationX(-gjH.widthPixels);
      continue;
      this.omA.setTranslationX(gjH.widthPixels);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView
 * JD-Core Version:    0.7.0.1
 */