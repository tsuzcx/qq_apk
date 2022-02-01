package android.support.design.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.ClassLoaderCreator;
import android.os.Parcelable.Creator;
import android.support.design.a.a;
import android.support.design.behavior.HideBottomViewOnScrollBehavior;
import android.support.design.f.c;
import android.support.design.f.e;
import android.support.design.internal.f;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.a;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.h;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.t;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.LayoutParams;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar
  extends Toolbar
  implements CoordinatorLayout.a
{
  private final int fk;
  private final c fl;
  private final a fn;
  private Animator fo;
  private Animator fp;
  private Animator fq;
  private int fr;
  private boolean fs;
  private boolean ft = true;
  AnimatorListenerAdapter fu = new AnimatorListenerAdapter()
  {
    public final void onAnimationStart(Animator paramAnonymousAnimator)
    {
      BottomAppBar.a(BottomAppBar.this, BottomAppBar.f(BottomAppBar.this));
      BottomAppBar.a(BottomAppBar.this, BottomAppBar.g(BottomAppBar.this), BottomAppBar.f(BottomAppBar.this));
    }
  };
  
  public BottomAppBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968688);
  }
  
  public BottomAppBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = f.a(paramContext, paramAttributeSet, a.a.BottomAppBar, paramInt, 2131821643, new int[0]);
    paramContext = android.support.design.d.a.b(paramContext, paramAttributeSet, 0);
    float f1 = paramAttributeSet.getDimensionPixelOffset(2, 0);
    float f2 = paramAttributeSet.getDimensionPixelOffset(3, 0);
    float f3 = paramAttributeSet.getDimensionPixelOffset(4, 0);
    this.fr = paramAttributeSet.getInt(1, 0);
    this.fs = paramAttributeSet.getBoolean(5, false);
    paramAttributeSet.recycle();
    this.fk = getResources().getDimensionPixelOffset(2131166605);
    this.fn = new a(f1, f2, f3);
    paramAttributeSet = new e();
    paramAttributeSet.kz = this.fn;
    this.fl = new c(paramAttributeSet);
    paramAttributeSet = this.fl;
    paramAttributeSet.kg = true;
    paramAttributeSet.invalidateSelf();
    paramAttributeSet = this.fl;
    paramAttributeSet.kk = Paint.Style.FILL;
    paramAttributeSet.invalidateSelf();
    android.support.v4.graphics.drawable.a.a(this.fl, paramContext);
    t.a(this, this.fl);
  }
  
  private int C(int paramInt)
  {
    int j = 1;
    if (t.Y(this) == 1) {}
    for (int i = 1; paramInt == 1; i = 0)
    {
      int k = getMeasuredWidth() / 2;
      int m = this.fk;
      paramInt = j;
      if (i != 0) {
        paramInt = -1;
      }
      return paramInt * (k - m);
    }
    return 0;
  }
  
  private void a(final int paramInt, final boolean paramBoolean, List<Animator> paramList)
  {
    Object localObject = getActionMenuView();
    if (localObject == null) {}
    ObjectAnimator localObjectAnimator1;
    do
    {
      return;
      localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F });
      if (((this.ft) || ((paramBoolean) && (aD()))) && ((this.fr == 1) || (paramInt == 1)))
      {
        ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 0.0F });
        localObjectAnimator2.addListener(new AnimatorListenerAdapter()
        {
          public boolean cancelled;
          
          public final void onAnimationCancel(Animator paramAnonymousAnimator)
          {
            this.cancelled = true;
          }
          
          public final void onAnimationEnd(Animator paramAnonymousAnimator)
          {
            if (!this.cancelled) {
              BottomAppBar.a(BottomAppBar.this, this.fw, paramInt, paramBoolean);
            }
          }
        });
        localObject = new AnimatorSet();
        ((AnimatorSet)localObject).setDuration(150L);
        ((AnimatorSet)localObject).playSequentially(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
        paramList.add(localObject);
        return;
      }
    } while (((ActionMenuView)localObject).getAlpha() >= 1.0F);
    paramList.add(localObjectAnimator1);
  }
  
  private void a(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    int i;
    int k;
    int j;
    label17:
    View localView;
    int n;
    if (t.Y(this) == 1)
    {
      i = 1;
      k = 0;
      j = 0;
      if (k >= getChildCount()) {
        break label134;
      }
      localView = getChildAt(k);
      if ((!(localView.getLayoutParams() instanceof Toolbar.LayoutParams)) || ((((Toolbar.LayoutParams)localView.getLayoutParams()).gravity & 0x800007) != 8388611)) {
        break label118;
      }
      n = 1;
      label69:
      m = j;
      if (n != 0) {
        if (i == 0) {
          break label124;
        }
      }
    }
    label118:
    label124:
    for (int m = localView.getLeft();; m = localView.getRight())
    {
      m = Math.max(j, m);
      k += 1;
      j = m;
      break label17;
      i = 0;
      break;
      n = 0;
      break label69;
    }
    label134:
    if (i != 0)
    {
      i = paramActionMenuView.getRight();
      if ((paramInt != 1) || (!paramBoolean)) {
        break label178;
      }
    }
    label178:
    for (float f = j - i;; f = 0.0F)
    {
      paramActionMenuView.setTranslationX(f);
      return;
      i = paramActionMenuView.getLeft();
      break;
    }
  }
  
  private FloatingActionButton aC()
  {
    if (!(getParent() instanceof CoordinatorLayout)) {
      return null;
    }
    Iterator localIterator = ((CoordinatorLayout)getParent()).t(this).iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if ((localView instanceof FloatingActionButton)) {
        return (FloatingActionButton)localView;
      }
    }
    return null;
  }
  
  private boolean aD()
  {
    FloatingActionButton localFloatingActionButton = aC();
    return (localFloatingActionButton != null) && (localFloatingActionButton.getImpl().cs());
  }
  
  private void aE()
  {
    this.fn.fE = getFabTranslationX();
    Object localObject = aC();
    c localc = this.fl;
    if ((this.ft) && (aD())) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      localc.j(f);
      if (localObject != null)
      {
        ((FloatingActionButton)localObject).setTranslationY(getFabTranslationY());
        ((FloatingActionButton)localObject).setTranslationX(getFabTranslationX());
      }
      localObject = getActionMenuView();
      if (localObject != null)
      {
        ((ActionMenuView)localObject).setAlpha(1.0F);
        if (aD()) {
          break;
        }
        a((ActionMenuView)localObject, 0, false);
      }
      return;
    }
    a((ActionMenuView)localObject, this.fr, this.ft);
  }
  
  private void b(int paramInt, boolean paramBoolean)
  {
    if (!t.ay(this)) {
      return;
    }
    if (this.fq != null) {
      this.fq.cancel();
    }
    ArrayList localArrayList = new ArrayList();
    if (!aD())
    {
      paramBoolean = false;
      paramInt = 0;
    }
    a(paramInt, paramBoolean, localArrayList);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(localArrayList);
    this.fq = localAnimatorSet;
    this.fq.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        BottomAppBar.d(BottomAppBar.this);
      }
    });
    this.fq.start();
  }
  
  private ActionMenuView getActionMenuView()
  {
    int i = 0;
    while (i < getChildCount())
    {
      View localView = getChildAt(i);
      if ((localView instanceof ActionMenuView)) {
        return (ActionMenuView)localView;
      }
      i += 1;
    }
    return null;
  }
  
  private float getFabTranslationX()
  {
    return C(this.fr);
  }
  
  private float getFabTranslationY()
  {
    return m(this.ft);
  }
  
  private float m(boolean paramBoolean)
  {
    FloatingActionButton localFloatingActionButton = aC();
    if (localFloatingActionButton == null) {
      return 0.0F;
    }
    Rect localRect = new Rect();
    localFloatingActionButton.b(localRect);
    float f2 = localRect.height();
    float f1 = f2;
    if (f2 == 0.0F) {
      f1 = localFloatingActionButton.getMeasuredHeight();
    }
    float f3 = localFloatingActionButton.getHeight() - localRect.bottom;
    f2 = localFloatingActionButton.getHeight() - localRect.height();
    float f4 = -getCradleVerticalOffset();
    f1 = f1 / 2.0F + f4 + f3;
    f4 = localFloatingActionButton.getPaddingBottom();
    f3 = -getMeasuredHeight();
    if (paramBoolean) {}
    for (;;)
    {
      return f1 + f3;
      f1 = f2 - f4;
    }
  }
  
  public ColorStateList getBackgroundTint()
  {
    return this.fl.kl;
  }
  
  public CoordinatorLayout.Behavior<BottomAppBar> getBehavior()
  {
    return new Behavior();
  }
  
  public float getCradleVerticalOffset()
  {
    return this.fn.fD;
  }
  
  public int getFabAlignmentMode()
  {
    return this.fr;
  }
  
  public float getFabCradleMargin()
  {
    return this.fn.fB;
  }
  
  public float getFabCradleRoundedCornerRadius()
  {
    return this.fn.fA;
  }
  
  public boolean getHideOnScroll()
  {
    return this.fs;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.fo != null) {
      this.fo.cancel();
    }
    if (this.fq != null) {
      this.fq.cancel();
    }
    if (this.fp != null) {
      this.fp.cancel();
    }
    aE();
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Nj);
    this.fr = paramParcelable.fr;
    this.ft = paramParcelable.ft;
  }
  
  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.fr = this.fr;
    localSavedState.ft = this.ft;
    return localSavedState;
  }
  
  public void setBackgroundTint(ColorStateList paramColorStateList)
  {
    android.support.v4.graphics.drawable.a.a(this.fl, paramColorStateList);
  }
  
  public void setCradleVerticalOffset(float paramFloat)
  {
    if (paramFloat != getCradleVerticalOffset())
    {
      this.fn.fD = paramFloat;
      this.fl.invalidateSelf();
    }
  }
  
  public void setFabAlignmentMode(int paramInt)
  {
    if ((this.fr == paramInt) || (!t.ay(this))) {}
    for (;;)
    {
      b(paramInt, this.ft);
      this.fr = paramInt;
      return;
      if (this.fp != null) {
        this.fp.cancel();
      }
      ArrayList localArrayList = new ArrayList();
      if (this.ft)
      {
        localObject = ValueAnimator.ofFloat(new float[] { this.fn.fE, C(paramInt) });
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            BottomAppBar.b(BottomAppBar.this).fE = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            BottomAppBar.c(BottomAppBar.this).invalidateSelf();
          }
        });
        ((ValueAnimator)localObject).setDuration(300L);
        localArrayList.add(localObject);
      }
      Object localObject = ObjectAnimator.ofFloat(aC(), "translationX", new float[] { C(paramInt) });
      ((ObjectAnimator)localObject).setDuration(300L);
      localArrayList.add(localObject);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(localArrayList);
      this.fp = ((Animator)localObject);
      this.fp.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          BottomAppBar.a(BottomAppBar.this);
        }
      });
      this.fp.start();
    }
  }
  
  public void setFabCradleMargin(float paramFloat)
  {
    if (paramFloat != getFabCradleMargin())
    {
      this.fn.fB = paramFloat;
      this.fl.invalidateSelf();
    }
  }
  
  public void setFabCradleRoundedCornerRadius(float paramFloat)
  {
    if (paramFloat != getFabCradleRoundedCornerRadius())
    {
      this.fn.fA = paramFloat;
      this.fl.invalidateSelf();
    }
  }
  
  void setFabDiameter(int paramInt)
  {
    if (paramInt != this.fn.fC)
    {
      this.fn.fC = paramInt;
      this.fl.invalidateSelf();
    }
  }
  
  public void setHideOnScroll(boolean paramBoolean)
  {
    this.fs = paramBoolean;
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public static class Behavior
    extends HideBottomViewOnScrollBehavior<BottomAppBar>
  {
    private final Rect fz = new Rect();
    
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator() {};
    int fr;
    boolean ft;
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      this.fr = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.ft = bool;
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.fr);
      if (this.ft) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.bottomappbar.BottomAppBar
 * JD-Core Version:    0.7.0.1
 */