package com.google.android.material.bottomappbar;

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
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.Toolbar.LayoutParams;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.a;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.core.g.z;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a.b;
import com.google.android.material.a.d;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.h.c;
import com.google.android.material.h.e;
import com.google.android.material.internal.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BottomAppBar
  extends Toolbar
  implements CoordinatorLayout.a
{
  private final int dpo;
  private final c dpp;
  private final a dpq;
  private Animator dpr;
  private Animator dps;
  private Animator dpt;
  private boolean dpu;
  private boolean dpv;
  AnimatorListenerAdapter dpw;
  private int fabAlignmentMode;
  
  public BottomAppBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.bottomAppBarStyle);
  }
  
  public BottomAppBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209552);
    this.dpv = true;
    this.dpw = new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(209536);
        BottomAppBar.a(BottomAppBar.this, BottomAppBar.f(BottomAppBar.this));
        BottomAppBar.a(BottomAppBar.this, BottomAppBar.g(BottomAppBar.this), BottomAppBar.f(BottomAppBar.this));
        AppMethodBeat.o(209536);
      }
    };
    paramAttributeSet = k.a(paramContext, paramAttributeSet, a.k.BottomAppBar, paramInt, a.j.Widget_MaterialComponents_BottomAppBar, new int[0]);
    paramContext = com.google.android.material.e.a.b(paramContext, paramAttributeSet, a.k.BottomAppBar_backgroundTint);
    float f1 = paramAttributeSet.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleMargin, 0);
    float f2 = paramAttributeSet.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleRoundedCornerRadius, 0);
    float f3 = paramAttributeSet.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleVerticalOffset, 0);
    this.fabAlignmentMode = paramAttributeSet.getInt(a.k.BottomAppBar_fabAlignmentMode, 0);
    this.dpu = paramAttributeSet.getBoolean(a.k.BottomAppBar_hideOnScroll, false);
    paramAttributeSet.recycle();
    this.dpo = getResources().getDimensionPixelOffset(a.d.mtrl_bottomappbar_fabOffsetEndMode);
    this.dpq = new a(f1, f2, f3);
    paramAttributeSet = new e();
    paramAttributeSet.dxu = this.dpq;
    this.dpp = new c(paramAttributeSet);
    paramAttributeSet = this.dpp;
    paramAttributeSet.dxd = true;
    paramAttributeSet.invalidateSelf();
    paramAttributeSet = this.dpp;
    paramAttributeSet.dxh = Paint.Style.FILL;
    paramAttributeSet.invalidateSelf();
    androidx.core.graphics.drawable.a.a(this.dpp, paramContext);
    z.a(this, this.dpp);
    AppMethodBeat.o(209552);
  }
  
  private void E(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(209584);
    if (!z.au(this))
    {
      AppMethodBeat.o(209584);
      return;
    }
    if (this.dpt != null) {
      this.dpt.cancel();
    }
    ArrayList localArrayList = new ArrayList();
    if (!VH())
    {
      paramBoolean = false;
      paramInt = 0;
    }
    a(paramInt, paramBoolean, localArrayList);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(localArrayList);
    this.dpt = localAnimatorSet;
    this.dpt.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(209563);
        BottomAppBar.d(BottomAppBar.this);
        AppMethodBeat.o(209563);
      }
    });
    this.dpt.start();
    AppMethodBeat.o(209584);
  }
  
  private FloatingActionButton VG()
  {
    AppMethodBeat.i(209564);
    if (!(getParent() instanceof CoordinatorLayout))
    {
      AppMethodBeat.o(209564);
      return null;
    }
    Object localObject = ((CoordinatorLayout)getParent()).H(this).iterator();
    while (((Iterator)localObject).hasNext())
    {
      View localView = (View)((Iterator)localObject).next();
      if ((localView instanceof FloatingActionButton))
      {
        localObject = (FloatingActionButton)localView;
        AppMethodBeat.o(209564);
        return localObject;
      }
    }
    AppMethodBeat.o(209564);
    return null;
  }
  
  private boolean VH()
  {
    AppMethodBeat.i(209576);
    FloatingActionButton localFloatingActionButton = VG();
    if ((localFloatingActionButton != null) && (localFloatingActionButton.getImpl().WD()))
    {
      AppMethodBeat.o(209576);
      return true;
    }
    AppMethodBeat.o(209576);
    return false;
  }
  
  private void VI()
  {
    AppMethodBeat.i(209673);
    this.dpq.dpG = getFabTranslationX();
    Object localObject = VG();
    c localc = this.dpp;
    if ((this.dpv) && (VH())) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      localc.ba(f);
      if (localObject != null)
      {
        ((FloatingActionButton)localObject).setTranslationY(getFabTranslationY());
        ((FloatingActionButton)localObject).setTranslationX(getFabTranslationX());
      }
      localObject = getActionMenuView();
      if (localObject == null) {
        break label121;
      }
      ((ActionMenuView)localObject).setAlpha(1.0F);
      if (VH()) {
        break;
      }
      a((ActionMenuView)localObject, 0, false);
      AppMethodBeat.o(209673);
      return;
    }
    a((ActionMenuView)localObject, this.fabAlignmentMode, this.dpv);
    label121:
    AppMethodBeat.o(209673);
  }
  
  private void a(final int paramInt, final boolean paramBoolean, List<Animator> paramList)
  {
    AppMethodBeat.i(209599);
    Object localObject = getActionMenuView();
    if (localObject == null)
    {
      AppMethodBeat.o(209599);
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F });
    if (((this.dpv) || ((paramBoolean) && (VH()))) && ((this.fabAlignmentMode == 1) || (paramInt == 1)))
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
          AppMethodBeat.i(209557);
          if (!this.cancelled) {
            BottomAppBar.a(BottomAppBar.this, this.dpy, paramInt, paramBoolean);
          }
          AppMethodBeat.o(209557);
        }
      });
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).setDuration(150L);
      ((AnimatorSet)localObject).playSequentially(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      paramList.add(localObject);
      AppMethodBeat.o(209599);
      return;
    }
    if (((ActionMenuView)localObject).getAlpha() < 1.0F) {
      paramList.add(localObjectAnimator1);
    }
    AppMethodBeat.o(209599);
  }
  
  private void a(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(209662);
    int i;
    int k;
    int j;
    label23:
    View localView;
    int n;
    if (z.U(this) == 1)
    {
      i = 1;
      k = 0;
      j = 0;
      if (k >= getChildCount()) {
        break label140;
      }
      localView = getChildAt(k);
      if ((!(localView.getLayoutParams() instanceof Toolbar.LayoutParams)) || ((((Toolbar.LayoutParams)localView.getLayoutParams()).fl & 0x800007) != 8388611)) {
        break label124;
      }
      n = 1;
      label75:
      m = j;
      if (n != 0) {
        if (i == 0) {
          break label130;
        }
      }
    }
    label130:
    for (int m = localView.getLeft();; m = localView.getRight())
    {
      m = Math.max(j, m);
      k += 1;
      j = m;
      break label23;
      i = 0;
      break;
      label124:
      n = 0;
      break label75;
    }
    label140:
    if (i != 0)
    {
      i = paramActionMenuView.getRight();
      if ((paramInt != 1) || (!paramBoolean)) {
        break label190;
      }
    }
    label190:
    for (float f = j - i;; f = 0.0F)
    {
      paramActionMenuView.setTranslationX(f);
      AppMethodBeat.o(209662);
      return;
      i = paramActionMenuView.getLeft();
      break;
    }
  }
  
  private float bK(boolean paramBoolean)
  {
    AppMethodBeat.i(209609);
    FloatingActionButton localFloatingActionButton = VG();
    if (localFloatingActionButton == null)
    {
      AppMethodBeat.o(209609);
      return 0.0F;
    }
    Rect localRect = new Rect();
    localFloatingActionButton.o(localRect);
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
      AppMethodBeat.o(209609);
      return f1 + f3;
      f1 = f2 - f4;
    }
  }
  
  private ActionMenuView getActionMenuView()
  {
    AppMethodBeat.i(209652);
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof ActionMenuView))
      {
        localObject = (ActionMenuView)localObject;
        AppMethodBeat.o(209652);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(209652);
    return null;
  }
  
  private float getFabTranslationX()
  {
    AppMethodBeat.i(209642);
    float f = jj(this.fabAlignmentMode);
    AppMethodBeat.o(209642);
    return f;
  }
  
  private float getFabTranslationY()
  {
    AppMethodBeat.i(209616);
    float f = bK(this.dpv);
    AppMethodBeat.o(209616);
    return f;
  }
  
  private int jj(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(209628);
    if (z.U(this) == 1) {}
    for (int i = 1; paramInt == 1; i = 0)
    {
      int k = getMeasuredWidth() / 2;
      int m = this.dpo;
      paramInt = j;
      if (i != 0) {
        paramInt = -1;
      }
      AppMethodBeat.o(209628);
      return paramInt * (k - m);
    }
    AppMethodBeat.o(209628);
    return 0;
  }
  
  public ColorStateList getBackgroundTint()
  {
    return this.dpp.dxi;
  }
  
  public CoordinatorLayout.Behavior<BottomAppBar> getBehavior()
  {
    AppMethodBeat.i(210026);
    Behavior localBehavior = new Behavior();
    AppMethodBeat.o(210026);
    return localBehavior;
  }
  
  public float getCradleVerticalOffset()
  {
    return this.dpq.dpF;
  }
  
  public int getFabAlignmentMode()
  {
    return this.fabAlignmentMode;
  }
  
  public float getFabCradleMargin()
  {
    return this.dpq.dpD;
  }
  
  public float getFabCradleRoundedCornerRadius()
  {
    return this.dpq.dpC;
  }
  
  public boolean getHideOnScroll()
  {
    return this.dpu;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(210004);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.dpr != null) {
      this.dpr.cancel();
    }
    if (this.dpt != null) {
      this.dpt.cancel();
    }
    if (this.dps != null) {
      this.dps.cancel();
    }
    VI();
    AppMethodBeat.o(210004);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(210050);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(210050);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.bxs);
    this.fabAlignmentMode = paramParcelable.fabAlignmentMode;
    this.dpv = paramParcelable.dpv;
    AppMethodBeat.o(210050);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(210035);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.fabAlignmentMode = this.fabAlignmentMode;
    localSavedState.dpv = this.dpv;
    AppMethodBeat.o(210035);
    return localSavedState;
  }
  
  public void setBackgroundTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209888);
    androidx.core.graphics.drawable.a.a(this.dpp, paramColorStateList);
    AppMethodBeat.o(209888);
  }
  
  public void setCradleVerticalOffset(float paramFloat)
  {
    AppMethodBeat.i(209962);
    if (paramFloat != getCradleVerticalOffset())
    {
      this.dpq.dpF = paramFloat;
      this.dpp.invalidateSelf();
    }
    AppMethodBeat.o(209962);
  }
  
  public void setFabAlignmentMode(int paramInt)
  {
    AppMethodBeat.i(209879);
    if ((this.fabAlignmentMode == paramInt) || (!z.au(this))) {}
    for (;;)
    {
      E(paramInt, this.dpv);
      this.fabAlignmentMode = paramInt;
      AppMethodBeat.o(209879);
      return;
      if (this.dps != null) {
        this.dps.cancel();
      }
      ArrayList localArrayList = new ArrayList();
      if (this.dpv)
      {
        localObject = ValueAnimator.ofFloat(new float[] { this.dpq.dpG, jj(paramInt) });
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(209555);
            BottomAppBar.b(BottomAppBar.this).dpG = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            BottomAppBar.c(BottomAppBar.this).invalidateSelf();
            AppMethodBeat.o(209555);
          }
        });
        ((ValueAnimator)localObject).setDuration(300L);
        localArrayList.add(localObject);
      }
      Object localObject = ObjectAnimator.ofFloat(VG(), "translationX", new float[] { jj(paramInt) });
      ((ObjectAnimator)localObject).setDuration(300L);
      localArrayList.add(localObject);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(localArrayList);
      this.dps = ((Animator)localObject);
      this.dps.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(209560);
          BottomAppBar.a(BottomAppBar.this);
          AppMethodBeat.o(209560);
        }
      });
      this.dps.start();
    }
  }
  
  public void setFabCradleMargin(float paramFloat)
  {
    AppMethodBeat.i(209919);
    if (paramFloat != getFabCradleMargin())
    {
      this.dpq.dpD = paramFloat;
      this.dpp.invalidateSelf();
    }
    AppMethodBeat.o(209919);
  }
  
  public void setFabCradleRoundedCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(209939);
    if (paramFloat != getFabCradleRoundedCornerRadius())
    {
      this.dpq.dpC = paramFloat;
      this.dpp.invalidateSelf();
    }
    AppMethodBeat.o(209939);
  }
  
  void setFabDiameter(int paramInt)
  {
    AppMethodBeat.i(209990);
    if (paramInt != this.dpq.dpE)
    {
      this.dpq.dpE = paramInt;
      this.dpp.invalidateSelf();
    }
    AppMethodBeat.o(209990);
  }
  
  public void setHideOnScroll(boolean paramBoolean)
  {
    this.dpu = paramBoolean;
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public static class Behavior
    extends HideBottomViewOnScrollBehavior<BottomAppBar>
  {
    private final Rect dpB;
    
    public Behavior()
    {
      AppMethodBeat.i(209528);
      this.dpB = new Rect();
      AppMethodBeat.o(209528);
    }
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(209545);
      this.dpB = new Rect();
      AppMethodBeat.o(209545);
    }
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, BottomAppBar paramBottomAppBar, int paramInt)
    {
      AppMethodBeat.i(209559);
      FloatingActionButton localFloatingActionButton = BottomAppBar.h(paramBottomAppBar);
      if (localFloatingActionButton != null)
      {
        ((CoordinatorLayout.d)localFloatingActionButton.getLayoutParams()).anchorGravity = 17;
        BottomAppBar.a(paramBottomAppBar, localFloatingActionButton);
        Rect localRect = this.dpB;
        localRect.set(0, 0, localFloatingActionButton.getMeasuredWidth(), localFloatingActionButton.getMeasuredHeight());
        localFloatingActionButton.p(localRect);
        paramBottomAppBar.setFabDiameter(this.dpB.height());
      }
      if (!BottomAppBar.i(paramBottomAppBar)) {
        BottomAppBar.j(paramBottomAppBar);
      }
      paramCoordinatorLayout.h(paramBottomAppBar, paramInt);
      boolean bool = super.a(paramCoordinatorLayout, paramBottomAppBar, paramInt);
      AppMethodBeat.o(209559);
      return bool;
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean dpv;
    int fabAlignmentMode;
    
    static
    {
      AppMethodBeat.i(209534);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(209534);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(209526);
      this.fabAlignmentMode = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.dpv = bool;
        AppMethodBeat.o(209526);
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(209549);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.fabAlignmentMode);
      if (this.dpv) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(209549);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar
 * JD-Core Version:    0.7.0.1
 */