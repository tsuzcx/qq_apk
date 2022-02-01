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
import androidx.core.g.w;
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
  private final int bwl;
  private final c bwm;
  private final a bwn;
  private Animator bwo;
  private Animator bwp;
  private Animator bwq;
  private boolean bwr;
  private boolean bws;
  AnimatorListenerAdapter bwt;
  private int fabAlignmentMode;
  
  public BottomAppBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.bottomAppBarStyle);
  }
  
  public BottomAppBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235018);
    this.bws = true;
    this.bwt = new AnimatorListenerAdapter()
    {
      public final void onAnimationStart(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(234920);
        BottomAppBar.a(BottomAppBar.this, BottomAppBar.f(BottomAppBar.this));
        BottomAppBar.a(BottomAppBar.this, BottomAppBar.g(BottomAppBar.this), BottomAppBar.f(BottomAppBar.this));
        AppMethodBeat.o(234920);
      }
    };
    paramAttributeSet = k.a(paramContext, paramAttributeSet, a.k.BottomAppBar, paramInt, a.j.Widget_MaterialComponents_BottomAppBar, new int[0]);
    paramContext = com.google.android.material.e.a.b(paramContext, paramAttributeSet, a.k.BottomAppBar_backgroundTint);
    float f1 = paramAttributeSet.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleMargin, 0);
    float f2 = paramAttributeSet.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleRoundedCornerRadius, 0);
    float f3 = paramAttributeSet.getDimensionPixelOffset(a.k.BottomAppBar_fabCradleVerticalOffset, 0);
    this.fabAlignmentMode = paramAttributeSet.getInt(a.k.BottomAppBar_fabAlignmentMode, 0);
    this.bwr = paramAttributeSet.getBoolean(a.k.BottomAppBar_hideOnScroll, false);
    paramAttributeSet.recycle();
    this.bwl = getResources().getDimensionPixelOffset(a.d.mtrl_bottomappbar_fabOffsetEndMode);
    this.bwn = new a(f1, f2, f3);
    paramAttributeSet = new e();
    paramAttributeSet.bEt = this.bwn;
    this.bwm = new c(paramAttributeSet);
    paramAttributeSet = this.bwm;
    paramAttributeSet.bEc = true;
    paramAttributeSet.invalidateSelf();
    paramAttributeSet = this.bwm;
    paramAttributeSet.bEg = Paint.Style.FILL;
    paramAttributeSet.invalidateSelf();
    androidx.core.graphics.drawable.a.a(this.bwm, paramContext);
    w.a(this, this.bwm);
    AppMethodBeat.o(235018);
  }
  
  private void a(final int paramInt, final boolean paramBoolean, List<Animator> paramList)
  {
    AppMethodBeat.i(235029);
    Object localObject = getActionMenuView();
    if (localObject == null)
    {
      AppMethodBeat.o(235029);
      return;
    }
    ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(localObject, "alpha", new float[] { 1.0F });
    if (((this.bws) || ((paramBoolean) && (wi()))) && ((this.fabAlignmentMode == 1) || (paramInt == 1)))
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
          AppMethodBeat.i(234911);
          if (!this.cancelled) {
            BottomAppBar.a(BottomAppBar.this, this.bwv, paramInt, paramBoolean);
          }
          AppMethodBeat.o(234911);
        }
      });
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).setDuration(150L);
      ((AnimatorSet)localObject).playSequentially(new Animator[] { localObjectAnimator2, localObjectAnimator1 });
      paramList.add(localObject);
      AppMethodBeat.o(235029);
      return;
    }
    if (((ActionMenuView)localObject).getAlpha() < 1.0F) {
      paramList.add(localObjectAnimator1);
    }
    AppMethodBeat.o(235029);
  }
  
  private void a(ActionMenuView paramActionMenuView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(235039);
    int i;
    int k;
    int j;
    label23:
    View localView;
    int n;
    if (w.I(this) == 1)
    {
      i = 1;
      k = 0;
      j = 0;
      if (k >= getChildCount()) {
        break label140;
      }
      localView = getChildAt(k);
      if ((!(localView.getLayoutParams() instanceof Toolbar.LayoutParams)) || ((((Toolbar.LayoutParams)localView.getLayoutParams()).ek & 0x800007) != 8388611)) {
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
      AppMethodBeat.o(235039);
      return;
      i = paramActionMenuView.getLeft();
      break;
    }
  }
  
  private float bc(boolean paramBoolean)
  {
    AppMethodBeat.i(235030);
    FloatingActionButton localFloatingActionButton = wh();
    if (localFloatingActionButton == null)
    {
      AppMethodBeat.o(235030);
      return 0.0F;
    }
    Rect localRect = new Rect();
    localFloatingActionButton.i(localRect);
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
      AppMethodBeat.o(235030);
      return f1 + f3;
      f1 = f2 - f4;
    }
  }
  
  private int fU(int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(235034);
    if (w.I(this) == 1) {}
    for (int i = 1; paramInt == 1; i = 0)
    {
      int k = getMeasuredWidth() / 2;
      int m = this.bwl;
      paramInt = j;
      if (i != 0) {
        paramInt = -1;
      }
      AppMethodBeat.o(235034);
      return paramInt * (k - m);
    }
    AppMethodBeat.o(235034);
    return 0;
  }
  
  private ActionMenuView getActionMenuView()
  {
    AppMethodBeat.i(235037);
    int i = 0;
    while (i < getChildCount())
    {
      Object localObject = getChildAt(i);
      if ((localObject instanceof ActionMenuView))
      {
        localObject = (ActionMenuView)localObject;
        AppMethodBeat.o(235037);
        return localObject;
      }
      i += 1;
    }
    AppMethodBeat.o(235037);
    return null;
  }
  
  private float getFabTranslationX()
  {
    AppMethodBeat.i(235035);
    float f = fU(this.fabAlignmentMode);
    AppMethodBeat.o(235035);
    return f;
  }
  
  private float getFabTranslationY()
  {
    AppMethodBeat.i(235032);
    float f = bc(this.bws);
    AppMethodBeat.o(235032);
    return f;
  }
  
  private void q(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(235028);
    if (!w.ah(this))
    {
      AppMethodBeat.o(235028);
      return;
    }
    if (this.bwq != null) {
      this.bwq.cancel();
    }
    ArrayList localArrayList = new ArrayList();
    if (!wi())
    {
      paramBoolean = false;
      paramInt = 0;
    }
    a(paramInt, paramBoolean, localArrayList);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.playTogether(localArrayList);
    this.bwq = localAnimatorSet;
    this.bwq.addListener(new AnimatorListenerAdapter()
    {
      public final void onAnimationEnd(Animator paramAnonymousAnimator)
      {
        AppMethodBeat.i(234906);
        BottomAppBar.d(BottomAppBar.this);
        AppMethodBeat.o(234906);
      }
    });
    this.bwq.start();
    AppMethodBeat.o(235028);
  }
  
  private FloatingActionButton wh()
  {
    AppMethodBeat.i(235026);
    if (!(getParent() instanceof CoordinatorLayout))
    {
      AppMethodBeat.o(235026);
      return null;
    }
    Object localObject = ((CoordinatorLayout)getParent()).y(this).iterator();
    while (((Iterator)localObject).hasNext())
    {
      View localView = (View)((Iterator)localObject).next();
      if ((localView instanceof FloatingActionButton))
      {
        localObject = (FloatingActionButton)localView;
        AppMethodBeat.o(235026);
        return localObject;
      }
    }
    AppMethodBeat.o(235026);
    return null;
  }
  
  private boolean wi()
  {
    AppMethodBeat.i(235027);
    FloatingActionButton localFloatingActionButton = wh();
    if ((localFloatingActionButton != null) && (localFloatingActionButton.getImpl().xf()))
    {
      AppMethodBeat.o(235027);
      return true;
    }
    AppMethodBeat.o(235027);
    return false;
  }
  
  private void wj()
  {
    AppMethodBeat.i(235044);
    this.bwn.bwD = getFabTranslationX();
    Object localObject = wh();
    c localc = this.bwm;
    if ((this.bws) && (wi())) {}
    for (float f = 1.0F;; f = 0.0F)
    {
      localc.Z(f);
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
      if (wi()) {
        break;
      }
      a((ActionMenuView)localObject, 0, false);
      AppMethodBeat.o(235044);
      return;
    }
    a((ActionMenuView)localObject, this.fabAlignmentMode, this.bws);
    label121:
    AppMethodBeat.o(235044);
  }
  
  public ColorStateList getBackgroundTint()
  {
    return this.bwm.bEh;
  }
  
  public CoordinatorLayout.Behavior<BottomAppBar> getBehavior()
  {
    AppMethodBeat.i(235047);
    Behavior localBehavior = new Behavior();
    AppMethodBeat.o(235047);
    return localBehavior;
  }
  
  public float getCradleVerticalOffset()
  {
    return this.bwn.bwC;
  }
  
  public int getFabAlignmentMode()
  {
    return this.fabAlignmentMode;
  }
  
  public float getFabCradleMargin()
  {
    return this.bwn.bwA;
  }
  
  public float getFabCradleRoundedCornerRadius()
  {
    return this.bwn.bwz;
  }
  
  public boolean getHideOnScroll()
  {
    return this.bwr;
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235042);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.bwo != null) {
      this.bwo.cancel();
    }
    if (this.bwq != null) {
      this.bwq.cancel();
    }
    if (this.bwp != null) {
      this.bwp.cancel();
    }
    wj();
    AppMethodBeat.o(235042);
  }
  
  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(235050);
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(235050);
      return;
    }
    paramParcelable = (SavedState)paramParcelable;
    super.onRestoreInstanceState(paramParcelable.Rb);
    this.fabAlignmentMode = paramParcelable.fabAlignmentMode;
    this.bws = paramParcelable.bws;
    AppMethodBeat.o(235050);
  }
  
  public Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(235048);
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.fabAlignmentMode = this.fabAlignmentMode;
    localSavedState.bws = this.bws;
    AppMethodBeat.o(235048);
    return localSavedState;
  }
  
  public void setBackgroundTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235020);
    androidx.core.graphics.drawable.a.a(this.bwm, paramColorStateList);
    AppMethodBeat.o(235020);
  }
  
  public void setCradleVerticalOffset(float paramFloat)
  {
    AppMethodBeat.i(235023);
    if (paramFloat != getCradleVerticalOffset())
    {
      this.bwn.bwC = paramFloat;
      this.bwm.invalidateSelf();
    }
    AppMethodBeat.o(235023);
  }
  
  public void setFabAlignmentMode(int paramInt)
  {
    AppMethodBeat.i(235019);
    if ((this.fabAlignmentMode == paramInt) || (!w.ah(this))) {}
    for (;;)
    {
      q(paramInt, this.bws);
      this.fabAlignmentMode = paramInt;
      AppMethodBeat.o(235019);
      return;
      if (this.bwp != null) {
        this.bwp.cancel();
      }
      ArrayList localArrayList = new ArrayList();
      if (this.bws)
      {
        localObject = ValueAnimator.ofFloat(new float[] { this.bwn.bwD, fU(paramInt) });
        ((ValueAnimator)localObject).addUpdateListener(new ValueAnimator.AnimatorUpdateListener()
        {
          public final void onAnimationUpdate(ValueAnimator paramAnonymousValueAnimator)
          {
            AppMethodBeat.i(234905);
            BottomAppBar.b(BottomAppBar.this).bwD = ((Float)paramAnonymousValueAnimator.getAnimatedValue()).floatValue();
            BottomAppBar.c(BottomAppBar.this).invalidateSelf();
            AppMethodBeat.o(234905);
          }
        });
        ((ValueAnimator)localObject).setDuration(300L);
        localArrayList.add(localObject);
      }
      Object localObject = ObjectAnimator.ofFloat(wh(), "translationX", new float[] { fU(paramInt) });
      ((ObjectAnimator)localObject).setDuration(300L);
      localArrayList.add(localObject);
      localObject = new AnimatorSet();
      ((AnimatorSet)localObject).playTogether(localArrayList);
      this.bwp = ((Animator)localObject);
      this.bwp.addListener(new AnimatorListenerAdapter()
      {
        public final void onAnimationEnd(Animator paramAnonymousAnimator)
        {
          AppMethodBeat.i(234903);
          BottomAppBar.a(BottomAppBar.this);
          AppMethodBeat.o(234903);
        }
      });
      this.bwp.start();
    }
  }
  
  public void setFabCradleMargin(float paramFloat)
  {
    AppMethodBeat.i(235021);
    if (paramFloat != getFabCradleMargin())
    {
      this.bwn.bwA = paramFloat;
      this.bwm.invalidateSelf();
    }
    AppMethodBeat.o(235021);
  }
  
  public void setFabCradleRoundedCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(235022);
    if (paramFloat != getFabCradleRoundedCornerRadius())
    {
      this.bwn.bwz = paramFloat;
      this.bwm.invalidateSelf();
    }
    AppMethodBeat.o(235022);
  }
  
  void setFabDiameter(int paramInt)
  {
    AppMethodBeat.i(235025);
    if (paramInt != this.bwn.bwB)
    {
      this.bwn.bwB = paramInt;
      this.bwm.invalidateSelf();
    }
    AppMethodBeat.o(235025);
  }
  
  public void setHideOnScroll(boolean paramBoolean)
  {
    this.bwr = paramBoolean;
  }
  
  public void setSubtitle(CharSequence paramCharSequence) {}
  
  public void setTitle(CharSequence paramCharSequence) {}
  
  public static class Behavior
    extends HideBottomViewOnScrollBehavior<BottomAppBar>
  {
    private final Rect bwy;
    
    public Behavior()
    {
      AppMethodBeat.i(234921);
      this.bwy = new Rect();
      AppMethodBeat.o(234921);
    }
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(234922);
      this.bwy = new Rect();
      AppMethodBeat.o(234922);
    }
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, BottomAppBar paramBottomAppBar, int paramInt)
    {
      AppMethodBeat.i(234926);
      FloatingActionButton localFloatingActionButton = BottomAppBar.h(paramBottomAppBar);
      if (localFloatingActionButton != null)
      {
        ((CoordinatorLayout.d)localFloatingActionButton.getLayoutParams()).anchorGravity = 17;
        BottomAppBar.a(paramBottomAppBar, localFloatingActionButton);
        Rect localRect = this.bwy;
        localRect.set(0, 0, localFloatingActionButton.getMeasuredWidth(), localFloatingActionButton.getMeasuredHeight());
        localFloatingActionButton.j(localRect);
        paramBottomAppBar.setFabDiameter(this.bwy.height());
      }
      if (!BottomAppBar.i(paramBottomAppBar)) {
        BottomAppBar.j(paramBottomAppBar);
      }
      paramCoordinatorLayout.h(paramBottomAppBar, paramInt);
      boolean bool = super.a(paramCoordinatorLayout, paramBottomAppBar, paramInt);
      AppMethodBeat.o(234926);
      return bool;
    }
  }
  
  static class SavedState
    extends AbsSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR;
    boolean bws;
    int fabAlignmentMode;
    
    static
    {
      AppMethodBeat.i(235015);
      CREATOR = new Parcelable.ClassLoaderCreator() {};
      AppMethodBeat.o(235015);
    }
    
    public SavedState(Parcel paramParcel, ClassLoader paramClassLoader)
    {
      super(paramClassLoader);
      AppMethodBeat.i(235013);
      this.fabAlignmentMode = paramParcel.readInt();
      if (paramParcel.readInt() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.bws = bool;
        AppMethodBeat.o(235013);
        return;
      }
    }
    
    public SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(235014);
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.fabAlignmentMode);
      if (this.bws) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(235014);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.bottomappbar.BottomAppBar
 * JD-Core Version:    0.7.0.1
 */