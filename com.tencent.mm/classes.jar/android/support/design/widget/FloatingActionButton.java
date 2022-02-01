package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.a.a;
import android.support.design.c.c;
import android.support.design.stateful.ExtendableSavedState;
import android.support.v4.e.n;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.u;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.ImageView.ScaleType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CoordinatorLayout.b(Behavior.class)
public class FloatingActionButton
  extends VisibilityAwareImageButton
  implements android.support.design.c.a, android.support.v4.view.s, android.support.v4.widget.s
{
  private PorterDuff.Mode hI;
  private ColorStateList hJ;
  private ColorStateList hL;
  private ColorStateList ra;
  private PorterDuff.Mode rb;
  private int rc;
  private int rd;
  private int re;
  private int rf;
  boolean rg;
  final Rect rh = new Rect();
  private final Rect ri = new Rect();
  private final android.support.v7.widget.i rj;
  private final c rk;
  private h rl;
  private int size;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969040);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = android.support.design.internal.f.a(paramContext, paramAttributeSet, a.a.FloatingActionButton, paramInt, 2131821685, new int[0]);
    this.hJ = android.support.design.d.a.b(paramContext, localTypedArray, 0);
    this.hI = android.support.design.internal.g.a(localTypedArray.getInt(1, -1), null);
    this.hL = android.support.design.d.a.b(paramContext, localTypedArray, 10);
    this.size = localTypedArray.getInt(5, -1);
    this.rd = localTypedArray.getDimensionPixelSize(4, 0);
    this.rc = localTypedArray.getDimensionPixelSize(2, 0);
    float f1 = localTypedArray.getDimension(3, 0.0F);
    float f2 = localTypedArray.getDimension(7, 0.0F);
    float f3 = localTypedArray.getDimension(9, 0.0F);
    this.rg = localTypedArray.getBoolean(12, false);
    this.rf = localTypedArray.getDimensionPixelSize(8, 0);
    android.support.design.a.h localh = android.support.design.a.h.a(paramContext, localTypedArray, 11);
    paramContext = android.support.design.a.h.a(paramContext, localTypedArray, 6);
    localTypedArray.recycle();
    this.rj = new android.support.v7.widget.i(this);
    this.rj.a(paramAttributeSet, paramInt);
    this.rk = new c(this);
    getImpl().a(this.hJ, this.hI, this.hL, this.rc);
    getImpl().setElevation(f1);
    getImpl().p(f2);
    getImpl().q(f3);
    paramAttributeSet = getImpl();
    paramInt = this.rf;
    if (paramAttributeSet.rf != paramInt)
    {
      paramAttributeSet.rf = paramInt;
      paramAttributeSet.cC();
    }
    getImpl().iM = localh;
    getImpl().iN = paramContext;
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private h.d c(final a parama)
  {
    if (parama == null) {
      return null;
    }
    new h.d() {};
  }
  
  private void cA()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    if (this.ra == null)
    {
      android.support.v4.graphics.drawable.a.h(localDrawable);
      return;
    }
    int i = this.ra.getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode2 = this.rb;
    PorterDuff.Mode localMode1 = localMode2;
    if (localMode2 == null) {
      localMode1 = PorterDuff.Mode.SRC_IN;
    }
    localDrawable.mutate().setColorFilter(android.support.v7.widget.g.b(i, localMode1));
  }
  
  private static int resolveAdjustedSize(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getMode(paramInt2);
    int j = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (i)
    {
    default: 
      throw new IllegalArgumentException();
    case -2147483648: 
      paramInt2 = Math.min(paramInt1, j);
    case 0: 
      return paramInt2;
    }
    return j;
  }
  
  final void a(a parama)
  {
    Object localObject = getImpl();
    h.d locald = c(parama);
    if (!((h)localObject).cK())
    {
      if (((h)localObject).rt != null) {
        ((h)localObject).rt.cancel();
      }
      if (((h)localObject).cL())
      {
        if (((h)localObject).rK.getVisibility() != 0)
        {
          ((h)localObject).rK.setAlpha(0.0F);
          ((h)localObject).rK.setScaleY(0.0F);
          ((h)localObject).rK.setScaleX(0.0F);
          ((h)localObject).r(0.0F);
        }
        if (((h)localObject).iM != null) {}
        for (parama = ((h)localObject).iM;; parama = ((h)localObject).ru)
        {
          parama = ((h)localObject).a(parama, 1.0F, 1.0F, 1.0F);
          parama.addListener(new h.2((h)localObject, locald));
          if (((h)localObject).rF == null) {
            break;
          }
          localObject = ((h)localObject).rF.iterator();
          while (((Iterator)localObject).hasNext()) {
            parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
          }
          if (((h)localObject).ru == null) {
            ((h)localObject).ru = android.support.design.a.h.k(((h)localObject).rK.getContext(), 2130837507);
          }
        }
        parama.start();
      }
    }
    else
    {
      return;
    }
    ((h)localObject).rK.e(0, false);
    ((h)localObject).rK.setAlpha(1.0F);
    ((h)localObject).rK.setScaleY(1.0F);
    ((h)localObject).rK.setScaleX(1.0F);
    ((h)localObject).r(1.0F);
  }
  
  final void b(a parama)
  {
    int i = 1;
    Object localObject = getImpl();
    h.d locald = c(parama);
    if (((h)localObject).rK.getVisibility() == 0) {
      if (((h)localObject).rs == 1)
      {
        if (i != 0) {
          break label186;
        }
        if (((h)localObject).rt != null) {
          ((h)localObject).rt.cancel();
        }
        if (!((h)localObject).cL()) {
          break label187;
        }
        if (((h)localObject).iN == null) {
          break label150;
        }
      }
    }
    for (parama = ((h)localObject).iN;; parama = ((h)localObject).rv)
    {
      parama = ((h)localObject).a(parama, 0.0F, 0.0F, 0.0F);
      parama.addListener(new h.1((h)localObject, locald));
      if (((h)localObject).rG == null) {
        break label182;
      }
      localObject = ((h)localObject).rG.iterator();
      while (((Iterator)localObject).hasNext()) {
        parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
      }
      i = 0;
      break;
      if (((h)localObject).rs != 2) {
        break;
      }
      i = 0;
      break;
      label150:
      if (((h)localObject).rv == null) {
        ((h)localObject).rv = android.support.design.a.h.k(((h)localObject).rK.getContext(), 2130837506);
      }
    }
    label182:
    parama.start();
    label186:
    return;
    label187:
    ((h)localObject).rK.e(4, false);
  }
  
  @Deprecated
  public final boolean b(Rect paramRect)
  {
    boolean bool = false;
    if (u.az(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      c(paramRect);
      bool = true;
    }
    return bool;
  }
  
  public final boolean bB()
  {
    return this.rk.jT;
  }
  
  public final void c(Rect paramRect)
  {
    paramRect.left += this.rh.left;
    paramRect.top += this.rh.top;
    paramRect.right -= this.rh.right;
    paramRect.bottom -= this.rh.bottom;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().d(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.hJ;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.hI;
  }
  
  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    return getImpl().rC;
  }
  
  public float getCompatPressedTranslationZ()
  {
    return getImpl().rD;
  }
  
  public Drawable getContentBackground()
  {
    return getImpl().rB;
  }
  
  public int getCustomSize()
  {
    return this.rd;
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.rk.jU;
  }
  
  public android.support.design.a.h getHideMotionSpec()
  {
    return getImpl().iN;
  }
  
  public h getImpl()
  {
    if (this.rl == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label42;
      }
    }
    label42:
    for (Object localObject = new i(this, new b());; localObject = new h(this, new b()))
    {
      this.rl = ((h)localObject);
      return this.rl;
    }
  }
  
  @Deprecated
  public int getRippleColor()
  {
    if (this.hL != null) {
      return this.hL.getDefaultColor();
    }
    return 0;
  }
  
  public ColorStateList getRippleColorStateList()
  {
    return this.hL;
  }
  
  public android.support.design.a.h getShowMotionSpec()
  {
    return getImpl().iM;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  int getSizeDimension()
  {
    int i = this.size;
    Resources localResources;
    for (;;)
    {
      if (this.rd != 0) {
        return this.rd;
      }
      localResources = getResources();
      switch (i)
      {
      case 0: 
      default: 
        return localResources.getDimensionPixelSize(2131166151);
      case -1: 
        if (Math.max(localResources.getConfiguration().screenWidthDp, localResources.getConfiguration().screenHeightDp) < 470) {
          i = 1;
        } else {
          i = 0;
        }
        break;
      }
    }
    return localResources.getDimensionPixelSize(2131166150);
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    return getBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    return getBackgroundTintMode();
  }
  
  public ColorStateList getSupportImageTintList()
  {
    return this.ra;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.rb;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.rg;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().cD();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    h localh = getImpl();
    if (localh.cG())
    {
      if (localh.rN == null) {
        localh.rN = new h.3(localh);
      }
      localh.rK.getViewTreeObserver().addOnPreDrawListener(localh.rN);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h localh = getImpl();
    if (localh.rN != null)
    {
      localh.rK.getViewTreeObserver().removeOnPreDrawListener(localh.rN);
      localh.rN = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    this.re = ((i - this.rf) / 2);
    getImpl().cF();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(this.rh.left + paramInt1 + this.rh.right, paramInt1 + this.rh.top + this.rh.bottom);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof ExtendableSavedState)) {
      super.onRestoreInstanceState(paramParcelable);
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (ExtendableSavedState)paramParcelable;
        super.onRestoreInstanceState(((AbsSavedState)localObject).Pm);
        paramParcelable = this.rk;
        localObject = (Bundle)((ExtendableSavedState)localObject).mv.get("expandableWidgetHelper");
        paramParcelable.jT = ((Bundle)localObject).getBoolean("expanded", false);
        paramParcelable.jU = ((Bundle)localObject).getInt("expandedComponentIdHint", 0);
      } while (!paramParcelable.jT);
      localObject = paramParcelable.jS.getParent();
    } while (!(localObject instanceof CoordinatorLayout));
    ((CoordinatorLayout)localObject).s(paramParcelable.jS);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    ExtendableSavedState localExtendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
    n localn = localExtendableSavedState.mv;
    c localc = this.rk;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", localc.jT);
    localBundle.putInt("expandedComponentIdHint", localc.jU);
    localn.put("expandableWidgetHelper", localBundle);
    return localExtendableSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (b(this.ri)) && (!this.ri.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.hJ != paramColorStateList)
    {
      this.hJ = paramColorStateList;
      h localh = getImpl();
      if (localh.ry != null) {
        android.support.v4.graphics.drawable.a.a(localh.ry, paramColorStateList);
      }
      if (localh.rA != null) {
        localh.rA.c(paramColorStateList);
      }
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.hI != paramMode)
    {
      this.hI = paramMode;
      h localh = getImpl();
      if (localh.ry != null) {
        android.support.v4.graphics.drawable.a.a(localh.ry, paramMode);
      }
    }
  }
  
  public void setCompatElevation(float paramFloat)
  {
    getImpl().setElevation(paramFloat);
  }
  
  public void setCompatElevationResource(int paramInt)
  {
    setCompatElevation(getResources().getDimension(paramInt));
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    getImpl().p(paramFloat);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    getImpl().q(paramFloat);
  }
  
  public void setCompatPressedTranslationZResource(int paramInt)
  {
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCustomSize(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Custom size must be non-negative");
    }
    this.rd = paramInt;
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    this.rk.jU = paramInt;
  }
  
  public void setHideMotionSpec(android.support.design.a.h paramh)
  {
    getImpl().iN = paramh;
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(android.support.design.a.h.k(getContext(), paramInt));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    getImpl().cC();
  }
  
  public void setImageResource(int paramInt)
  {
    this.rj.setImageResource(paramInt);
  }
  
  public void setRippleColor(int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.hL != paramColorStateList)
    {
      this.hL = paramColorStateList;
      getImpl().setRippleColor(this.hL);
    }
  }
  
  public void setShowMotionSpec(android.support.design.a.h paramh)
  {
    getImpl().iM = paramh;
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(android.support.design.a.h.k(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    this.rd = 0;
    if (paramInt != this.size)
    {
      this.size = paramInt;
      requestLayout();
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    setBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setBackgroundTintMode(paramMode);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    if (this.ra != paramColorStateList)
    {
      this.ra = paramColorStateList;
      cA();
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.rb != paramMode)
    {
      this.rb = paramMode;
      cA();
    }
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.rg != paramBoolean)
    {
      this.rg = paramBoolean;
      getImpl().cE();
    }
  }
  
  protected static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private Rect mC;
    private FloatingActionButton.a ro;
    private boolean rp;
    
    public BaseBehavior()
    {
      this.rp = true;
    }
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FloatingActionButton_Behavior_Layout);
      this.rp = paramContext.getBoolean(0, true);
      paramContext.recycle();
    }
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (!a(paramAppBarLayout, paramFloatingActionButton)) {
        return false;
      }
      if (this.mC == null) {
        this.mC = new Rect();
      }
      Rect localRect = this.mC;
      f.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.b(this.ro);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.a(this.ro);
      }
    }
    
    private boolean a(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
      if (!this.rp) {
        return false;
      }
      if (locald.qF != paramView.getId()) {
        return false;
      }
      return paramFloatingActionButton.getUserSetVisibility() == 0;
    }
    
    private boolean b(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      if (!a(paramView, paramFloatingActionButton)) {
        return false;
      }
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
      int i = paramView.getTop();
      int j = paramFloatingActionButton.getHeight() / 2;
      if (i < locald.topMargin + j) {
        paramFloatingActionButton.b(this.ro);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.a(this.ro);
      }
    }
    
    private static boolean v(View paramView)
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.d)) {
        return ((CoordinatorLayout.d)paramView).qC instanceof BottomSheetBehavior;
      }
      return false;
    }
    
    public void a(CoordinatorLayout.d paramd)
    {
      if (paramd.qH == 0) {
        paramd.qH = 80;
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      int j = 0;
      Object localObject1 = paramCoordinatorLayout.t(paramFloatingActionButton);
      int k = ((List)localObject1).size();
      int i = 0;
      Object localObject2;
      if (i < k)
      {
        localObject2 = (View)((List)localObject1).get(i);
        if ((localObject2 instanceof AppBarLayout)) {
          if (!a(paramCoordinatorLayout, (AppBarLayout)localObject2, paramFloatingActionButton)) {
            break label194;
          }
        }
      }
      else
      {
        label65:
        paramCoordinatorLayout.g(paramFloatingActionButton, paramInt);
        localObject1 = paramFloatingActionButton.rh;
        if ((localObject1 != null) && (((Rect)localObject1).centerX() > 0) && (((Rect)localObject1).centerY() > 0))
        {
          localObject2 = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
          if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - ((CoordinatorLayout.d)localObject2).rightMargin) {
            break label203;
          }
          paramInt = ((Rect)localObject1).right;
        }
      }
      for (;;)
      {
        label130:
        if (paramFloatingActionButton.getBottom() >= paramCoordinatorLayout.getHeight() - ((CoordinatorLayout.d)localObject2).bottomMargin) {
          i = ((Rect)localObject1).bottom;
        }
        for (;;)
        {
          if (i != 0) {
            u.s(paramFloatingActionButton, i);
          }
          if (paramInt != 0) {
            u.u(paramFloatingActionButton, paramInt);
          }
          return true;
          if ((v((View)localObject2)) && (b((View)localObject2, paramFloatingActionButton))) {
            break label65;
          }
          label194:
          i += 1;
          break;
          label203:
          if (paramFloatingActionButton.getLeft() > ((CoordinatorLayout.d)localObject2).leftMargin) {
            break label252;
          }
          paramInt = -((Rect)localObject1).left;
          break label130;
          i = j;
          if (paramFloatingActionButton.getTop() <= ((CoordinatorLayout.d)localObject2).topMargin) {
            i = -((Rect)localObject1).top;
          }
        }
        label252:
        paramInt = 0;
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, Rect paramRect)
    {
      paramCoordinatorLayout = paramFloatingActionButton.rh;
      paramRect.set(paramFloatingActionButton.getLeft() + paramCoordinatorLayout.left, paramFloatingActionButton.getTop() + paramCoordinatorLayout.top, paramFloatingActionButton.getRight() - paramCoordinatorLayout.right, paramFloatingActionButton.getBottom() - paramCoordinatorLayout.bottom);
      return true;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      if ((paramView instanceof AppBarLayout)) {
        a(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      }
      for (;;)
      {
        return false;
        if (v(paramView)) {
          b(paramView, paramFloatingActionButton);
        }
      }
    }
  }
  
  public static class Behavior
    extends FloatingActionButton.BaseBehavior<FloatingActionButton>
  {
    public Behavior() {}
    
    public Behavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
  }
  
  public static abstract class a {}
  
  final class b
    implements m
  {
    b() {}
    
    public final boolean cB()
    {
      return FloatingActionButton.this.rg;
    }
    
    public final void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      FloatingActionButton.this.rh.set(paramInt1, paramInt2, paramInt3, paramInt4);
      FloatingActionButton localFloatingActionButton = FloatingActionButton.this;
      localFloatingActionButton.setPadding(FloatingActionButton.a(localFloatingActionButton) + paramInt1, FloatingActionButton.a(FloatingActionButton.this) + paramInt2, FloatingActionButton.a(FloatingActionButton.this) + paramInt3, FloatingActionButton.a(FloatingActionButton.this) + paramInt4);
    }
    
    public final float getRadius()
    {
      return FloatingActionButton.this.getSizeDimension() / 2.0F;
    }
    
    public final void setBackgroundDrawable(Drawable paramDrawable)
    {
      FloatingActionButton.a(FloatingActionButton.this, paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.design.widget.FloatingActionButton
 * JD-Core Version:    0.7.0.1
 */