package com.tencent.mm.plugin.luckymoney.f2f.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public class ShuffleView
  extends FrameLayout
{
  public static DisplayMetrics eRM;
  View fnv;
  GestureDetector jEK = new GestureDetector(new ShuffleView.14(this));
  ValueAnimator jjN;
  List<View> lOX = new ArrayList();
  private ShuffleView.c lOY = new ShuffleView.c();
  ValueAnimator lOZ;
  private ValueAnimator lPa;
  ValueAnimator lPb;
  private ShuffleView.a lPc;
  private ShuffleView.a lPd;
  private ShuffleView.b lPe;
  View lPf;
  private View lPg;
  int lPh;
  private View lPi;
  private int lPj;
  int lPk;
  private float lPl;
  private float lPm;
  private final float lPn = 0.23F;
  private final float lPo = 0.28F;
  private final float lPp = 0.33F;
  private ArrayList<Float> lPq = new ArrayList();
  private ArrayList<Float> lPr = new ArrayList();
  private boolean lPs;
  private int lPt = getResources().getDimensionPixelSize(a.d.lucky_money_f2f_shuffle_view_touch_error_distance);
  private int lPu = 2500;
  
  public ShuffleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void bfB()
  {
    if (this.lPk > 1)
    {
      y.d("ShuffleView", "card width: %d,height: %d", new Object[] { Integer.valueOf(((View)this.lOX.get(0)).getWidth()), Integer.valueOf(((View)this.lOX.get(0)).getHeight()) });
      if (this.lOY.lPz == 2)
      {
        this.lPl = (((View)this.lOX.get(0)).getWidth() * 1.5F / this.lPk);
        if (this.lPl > ((View)this.lOX.get(0)).getWidth() * 0.23F) {
          this.lPl = (((View)this.lOX.get(0)).getWidth() * 0.23F);
        }
      }
      while (this.lOY.lPz != 1) {
        return;
      }
      this.lPm = (((View)this.lOX.get(0)).getHeight() * 1.0F / this.lPk);
      return;
    }
    this.lPl = 0.0F;
    this.lPm = 0.0F;
  }
  
  private void bfD()
  {
    if (this.fnv != null)
    {
      y.i("ShuffleView", "selectView != null, cancel select");
      if (this.lPb.isStarted()) {
        this.lPb.cancel();
      }
      this.lPb.removeAllUpdateListeners();
      this.lPb.removeAllListeners();
      switch (this.lOY.lPA)
      {
      }
    }
    for (;;)
    {
      this.fnv = null;
      this.lPh = 0;
      this.lPb.start();
      return;
      if (this.lPh >= 0) {
        this.lPb.addUpdateListener(new ShuffleView.8(this));
      }
    }
  }
  
  private void bfE()
  {
    if (this.lPi != null)
    {
      y.i("ShuffleView", "touchView != null,cancel touch");
      if (this.lPb.isStarted()) {
        this.lPb.cancel();
      }
      this.lPb.removeAllUpdateListeners();
      this.lPb.removeAllListeners();
      switch (this.lOY.lPA)
      {
      }
    }
    for (;;)
    {
      this.lPi = null;
      this.lPj = -1;
      this.lPb.start();
      return;
      if (this.lPj >= 0) {
        this.lPb.addUpdateListener(new ShuffleView.11(this));
      }
    }
  }
  
  private float getSelectScaleTranslationX()
  {
    if (this.fnv != null)
    {
      float f1 = this.fnv.getWidth();
      float f2 = this.lPl;
      int j = this.lPh - 1;
      int k = this.lPk - 1 - this.lPh;
      int i = 0;
      if (j > 0) {
        i = j + 0;
      }
      j = i;
      if (k > 0) {
        j = i + k;
      }
      if (j > 0) {
        return (0.33F * f1 - f2) * 2.0F / j;
      }
    }
    return 0.0F;
  }
  
  private float getTouchScaleTranslationX()
  {
    if (this.lPi != null)
    {
      float f1 = this.lPi.getWidth();
      float f2 = this.lPl;
      int j = this.lPj - 1;
      int k = this.lPk - 1 - this.lPj;
      int i = 0;
      if (j > 0) {
        i = j + 0;
      }
      j = i;
      if (k > 0) {
        j = i + k;
      }
      if (j > 0) {
        return (0.28F * f1 - f2) * 2.0F / j;
      }
    }
    return 0.0F;
  }
  
  private Rect tl(int paramInt)
  {
    View localView1;
    if ((paramInt >= 0) && (paramInt < this.lPk)) {
      localView1 = (View)this.lOX.get(paramInt);
    }
    switch (this.lOY.lPA)
    {
    default: 
      return null;
    }
    if (paramInt == 0)
    {
      paramInt = localView1.getLeft();
      i = (int)localView1.getTranslationX();
      j = localView1.getTop();
      k = (int)localView1.getTranslationY();
      m = localView1.getRight();
      n = (int)localView1.getTranslationX();
      i1 = localView1.getBottom();
      return new Rect(paramInt + i, j + k, m + n, (int)localView1.getTranslationY() + i1);
    }
    View localView2 = (View)this.lOX.get(paramInt - 1);
    paramInt = localView2.getRight();
    int i = (int)localView2.getTranslationX();
    int j = localView1.getTop();
    int k = (int)localView1.getTranslationY();
    int m = localView1.getRight();
    int n = (int)localView1.getTranslationX();
    int i1 = localView1.getBottom();
    return new Rect(i + paramInt, j + k, m + n, (int)localView1.getTranslationY() + i1);
  }
  
  final void K(View paramView, int paramInt)
  {
    if (this.lOY.lPz == 1)
    {
      paramView.setScaleX(1.0F - this.lOY.scaleX * paramInt);
      paramView.setTranslationY(tj(paramInt));
    }
    while (this.lOY.lPz != 2) {
      return;
    }
    paramView.setScaleY(1.0F - this.lOY.scaleY * paramInt);
    paramView.setTranslationX(ti(paramInt));
  }
  
  final int bfC()
  {
    return (int)(Math.random() * this.lPk);
  }
  
  public View getEnterView()
  {
    return this.lPg;
  }
  
  public View getExitView()
  {
    return this.lPf;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (this.lPs) {
      bool1 = true;
    }
    int j;
    int k;
    do
    {
      do
      {
        return bool1;
        j = (int)paramMotionEvent.getX();
        k = (int)paramMotionEvent.getY();
        bool1 = bool2;
      } while (this.lPk <= 0);
      y.d("ShuffleView", "y:%d,packet largest:%d", new Object[] { Integer.valueOf(k), Integer.valueOf(getHeight() - ((View)this.lOX.get(0)).getHeight() - ((View)this.lOX.get(0)).getHeight() / 7) });
      if (k >= getHeight() - ((View)this.lOX.get(0)).getHeight() - ((View)this.lOX.get(0)).getHeight() / 7) {
        break;
      }
      if ((this.fnv != null) && (paramMotionEvent.getActionMasked() == 0))
      {
        if (this.lPe != null) {
          this.lPe.dd(this.lPh, this.lPk);
        }
        bfD();
        return false;
      }
      if ((this.lPi != null) && (this.lPi.getTranslationY() == -this.lPi.getHeight() / 7))
      {
        if (this.lPe != null) {
          this.lPe.th(this.lPk);
        }
        tk(this.lPj);
        return false;
      }
      bool1 = bool2;
    } while (this.lPi == null);
    bfE();
    return false;
    int i = 0;
    if (i < this.lPk)
    {
      Rect localRect = tl(i);
      if ((localRect == null) || (!localRect.contains(j, k))) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        y.d("ShuffleView", "event %d out of cards,%d,%d", new Object[] { Integer.valueOf(paramMotionEvent.getActionMasked()), Integer.valueOf(j), Integer.valueOf(k) });
        if ((this.fnv != null) && (paramMotionEvent.getActionMasked() == 0))
        {
          if (this.lPe != null) {
            this.lPe.dd(this.lPh, this.lPk);
          }
          bfD();
        }
      }
      else
      {
        label392:
        bool1 = bool2;
        if (this.lPk <= 1) {
          break;
        }
        bool1 = this.jEK.onTouchEvent(paramMotionEvent);
        y.i("ShuffleView", "ret:%s,action:%s", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(paramMotionEvent.getActionMasked()) });
        if ((!bool1) && (paramMotionEvent.getActionMasked() == 1))
        {
          if ((this.lPi == null) || (this.lPi.getTranslationY() != -this.lPi.getHeight() / 7)) {
            break label599;
          }
          if (this.lPe != null) {
            this.lPe.th(this.lPk);
          }
          tk(this.lPj);
        }
      }
      for (;;)
      {
        return true;
        i += 1;
        break;
        if ((this.lPi != null) && (this.lPi.getTranslationY() == -this.lPi.getHeight() / 7))
        {
          if (this.lPe != null) {
            this.lPe.th(this.lPk);
          }
          tk(this.lPj);
          break label392;
        }
        if (this.lPi == null) {
          break label392;
        }
        bfE();
        break label392;
        label599:
        if (this.lPi != null) {
          bfE();
        }
      }
    }
  }
  
  public void setAllShuffleCards(List<View> paramList)
  {
    this.lOX.clear();
    this.lOX.addAll(paramList);
    this.lPh = 0;
    this.fnv = null;
    this.lPj = -1;
    this.lPi = null;
    removeAllViews();
    paramList = this.lOX;
    if (paramList.size() > 100) {
      this.lPk = 100;
    }
    for (;;)
    {
      int i = this.lPk - 1;
      while (i >= 0)
      {
        addView((View)paramList.get(i));
        i -= 1;
      }
      this.lPk = paramList.size();
      if (this.lPk == 1) {
        ((View)paramList.get(0)).findViewById(a.f.lucky_money_f2f_single_card).setVisibility(0);
      }
    }
    addOnLayoutChangeListener(new ShuffleView.1(this));
  }
  
  public void setCardListener(ShuffleView.b paramb)
  {
    this.lPe = paramb;
  }
  
  public void setEnterAnimator(ValueAnimator paramValueAnimator)
  {
    if (this.lPa != null)
    {
      this.lPa.removeAllListeners();
      this.lPa.cancel();
    }
    this.lPa = paramValueAnimator;
    if (this.lPa != null) {
      this.lPa.addUpdateListener(new ShuffleView.7(this));
    }
  }
  
  public void setEnterAnimatorListener(ShuffleView.a parama)
  {
    this.lPd = parama;
  }
  
  public void setExitAnimator(ValueAnimator paramValueAnimator)
  {
    if (this.lOZ != null)
    {
      this.lOZ.removeAllListeners();
      this.lOZ.cancel();
    }
    this.lOZ = paramValueAnimator;
    if (this.lOZ != null) {
      this.lOZ.addUpdateListener(new ShuffleView.6(this));
    }
  }
  
  public void setExitAnimatorListener(ShuffleView.a parama)
  {
    this.lPc = parama;
  }
  
  public void setShuffleSetting(ShuffleView.c paramc)
  {
    this.lOY = paramc;
    this.jjN = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.lPC);
    this.lPb = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(paramc.lPD);
  }
  
  public final float ti(int paramInt)
  {
    if ((this.lOY.lPz == 2) && (this.lPk > 0))
    {
      if (this.lOY.lPA == 3) {
        return (this.lPk - 1) * 0.5F * this.lPl - this.lPl * paramInt;
      }
      if (this.lOY.lPA == 4) {
        return this.lPl * paramInt - (this.lPk - 1) * 0.5F * this.lPl;
      }
    }
    return 0.0F;
  }
  
  public final float tj(int paramInt)
  {
    if (this.lOY.lPz == 1)
    {
      if (this.lOY.lPA == 1) {
        return (this.lPk - 1) * 0.5F * this.lPm - this.lPm * paramInt;
      }
      if (this.lOY.lPA == 2) {
        return this.lPm * paramInt - (this.lPk - 1) * 0.5F * this.lPm;
      }
    }
    return 0.0F;
  }
  
  final void tk(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.lPk))
    {
      y.i("ShuffleView", "select card " + paramInt);
      if (this.lPb.isStarted()) {
        this.lPb.cancel();
      }
      this.lPb.removeAllUpdateListeners();
      this.lPb.removeAllListeners();
      this.fnv = ((View)this.lOX.get(paramInt));
      this.lPh = paramInt;
      this.lPi = null;
      this.lPj = -1;
      switch (this.lOY.lPA)
      {
      }
    }
    for (;;)
    {
      this.lPb.start();
      return;
      if (paramInt > 0)
      {
        int i = this.lPk;
        this.lPb.addUpdateListener(new ShuffleView.9(this, paramInt - 1, i - 1 - paramInt));
      }
      else
      {
        this.lPb.addUpdateListener(new ShuffleView.10(this));
      }
    }
  }
  
  final void tm(int paramInt)
  {
    this.jjN.removeAllUpdateListeners();
    this.jjN.removeAllListeners();
    if (this.lOX.size() < this.lPk)
    {
      this.lPk -= 1;
      if (this.lPk == 1) {
        ((View)this.lOX.get(0)).findViewById(a.f.lucky_money_f2f_single_card).setVisibility(0);
      }
      bfB();
      this.jjN.addUpdateListener(new ShuffleView.15(this));
      this.jjN.addListener(new ShuffleView.2(this));
      this.jjN.start();
      return;
    }
    this.lPg = ((View)this.lOX.get(this.lPk - 1));
    K(this.lPg, this.lPk - 1);
    addView(this.lPg, 0);
    if (this.lPa != null) {
      switch (this.lOY.lPB)
      {
      }
    }
    for (;;)
    {
      this.lPg.setVisibility(4);
      this.jjN.addUpdateListener(new ShuffleView.3(this, paramInt));
      this.jjN.addListener(new ShuffleView.4(this));
      break;
      this.lPg.setTranslationY(-eRM.heightPixels);
      continue;
      this.lPg.setTranslationY(eRM.heightPixels);
      continue;
      this.lPg.setTranslationX(-eRM.widthPixels);
      continue;
      this.lPg.setTranslationX(eRM.widthPixels);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.f2f.ui.ShuffleView
 * JD-Core Version:    0.7.0.1
 */