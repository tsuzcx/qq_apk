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
import android.support.v4.view.t;
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
  private int borderWidth;
  private PorterDuff.Mode hG;
  private ColorStateList hH;
  private ColorStateList hJ;
  private ColorStateList qY;
  private PorterDuff.Mode qZ;
  private int ra;
  private int rb;
  private int rc;
  boolean rd;
  final Rect re = new Rect();
  private final Rect rf = new Rect();
  private final android.support.v7.widget.i rg;
  private final c rh;
  private h ri;
  private int size;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969011);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = android.support.design.internal.f.a(paramContext, paramAttributeSet, a.a.FloatingActionButton, paramInt, 2131821637, new int[0]);
    this.hH = android.support.design.d.a.b(paramContext, localTypedArray, 0);
    this.hG = android.support.design.internal.g.a(localTypedArray.getInt(1, -1), null);
    this.hJ = android.support.design.d.a.b(paramContext, localTypedArray, 10);
    this.size = localTypedArray.getInt(5, -1);
    this.ra = localTypedArray.getDimensionPixelSize(4, 0);
    this.borderWidth = localTypedArray.getDimensionPixelSize(2, 0);
    float f1 = localTypedArray.getDimension(3, 0.0F);
    float f2 = localTypedArray.getDimension(7, 0.0F);
    float f3 = localTypedArray.getDimension(9, 0.0F);
    this.rd = localTypedArray.getBoolean(12, false);
    this.rc = localTypedArray.getDimensionPixelSize(8, 0);
    android.support.design.a.h localh = android.support.design.a.h.a(paramContext, localTypedArray, 11);
    paramContext = android.support.design.a.h.a(paramContext, localTypedArray, 6);
    localTypedArray.recycle();
    this.rg = new android.support.v7.widget.i(this);
    this.rg.a(paramAttributeSet, paramInt);
    this.rh = new c(this);
    getImpl().a(this.hH, this.hG, this.hJ, this.borderWidth);
    getImpl().setElevation(f1);
    getImpl().p(f2);
    getImpl().q(f3);
    paramAttributeSet = getImpl();
    paramInt = this.rc;
    if (paramAttributeSet.rc != paramInt)
    {
      paramAttributeSet.rc = paramInt;
      paramAttributeSet.cA();
    }
    getImpl().iK = localh;
    getImpl().iL = paramContext;
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private h.d c(final a parama)
  {
    if (parama == null) {
      return null;
    }
    new h.d() {};
  }
  
  private void cy()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    if (this.qY == null)
    {
      android.support.v4.graphics.drawable.a.h(localDrawable);
      return;
    }
    int i = this.qY.getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode2 = this.qZ;
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
    if (!((h)localObject).cI())
    {
      if (((h)localObject).rp != null) {
        ((h)localObject).rp.cancel();
      }
      if (((h)localObject).cJ())
      {
        if (((h)localObject).rH.getVisibility() != 0)
        {
          ((h)localObject).rH.setAlpha(0.0F);
          ((h)localObject).rH.setScaleY(0.0F);
          ((h)localObject).rH.setScaleX(0.0F);
          ((h)localObject).r(0.0F);
        }
        if (((h)localObject).iK != null) {}
        for (parama = ((h)localObject).iK;; parama = ((h)localObject).rq)
        {
          parama = ((h)localObject).a(parama, 1.0F, 1.0F, 1.0F);
          parama.addListener(new h.2((h)localObject, locald));
          if (((h)localObject).rC == null) {
            break;
          }
          localObject = ((h)localObject).rC.iterator();
          while (((Iterator)localObject).hasNext()) {
            parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
          }
          if (((h)localObject).rq == null) {
            ((h)localObject).rq = android.support.design.a.h.k(((h)localObject).rH.getContext(), 2130837507);
          }
        }
        parama.start();
      }
    }
    else
    {
      return;
    }
    ((h)localObject).rH.e(0, false);
    ((h)localObject).rH.setAlpha(1.0F);
    ((h)localObject).rH.setScaleY(1.0F);
    ((h)localObject).rH.setScaleX(1.0F);
    ((h)localObject).r(1.0F);
  }
  
  final void b(a parama)
  {
    int i = 1;
    Object localObject = getImpl();
    h.d locald = c(parama);
    if (((h)localObject).rH.getVisibility() == 0) {
      if (((h)localObject).ro == 1)
      {
        if (i != 0) {
          break label186;
        }
        if (((h)localObject).rp != null) {
          ((h)localObject).rp.cancel();
        }
        if (!((h)localObject).cJ()) {
          break label187;
        }
        if (((h)localObject).iL == null) {
          break label150;
        }
      }
    }
    for (parama = ((h)localObject).iL;; parama = ((h)localObject).rs)
    {
      parama = ((h)localObject).a(parama, 0.0F, 0.0F, 0.0F);
      parama.addListener(new h.1((h)localObject, locald));
      if (((h)localObject).rD == null) {
        break label182;
      }
      localObject = ((h)localObject).rD.iterator();
      while (((Iterator)localObject).hasNext()) {
        parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
      }
      i = 0;
      break;
      if (((h)localObject).ro != 2) {
        break;
      }
      i = 0;
      break;
      label150:
      if (((h)localObject).rs == null) {
        ((h)localObject).rs = android.support.design.a.h.k(((h)localObject).rH.getContext(), 2130837506);
      }
    }
    label182:
    parama.start();
    label186:
    return;
    label187:
    ((h)localObject).rH.e(4, false);
  }
  
  @Deprecated
  public final boolean b(Rect paramRect)
  {
    boolean bool = false;
    if (t.ay(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      c(paramRect);
      bool = true;
    }
    return bool;
  }
  
  public final boolean bz()
  {
    return this.rh.jR;
  }
  
  public final void c(Rect paramRect)
  {
    paramRect.left += this.re.left;
    paramRect.top += this.re.top;
    paramRect.right -= this.re.right;
    paramRect.bottom -= this.re.bottom;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().d(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.hH;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.hG;
  }
  
  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    return getImpl().rz;
  }
  
  public float getCompatPressedTranslationZ()
  {
    return getImpl().rA;
  }
  
  public Drawable getContentBackground()
  {
    return getImpl().ry;
  }
  
  public int getCustomSize()
  {
    return this.ra;
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.rh.jS;
  }
  
  public android.support.design.a.h getHideMotionSpec()
  {
    return getImpl().iL;
  }
  
  public h getImpl()
  {
    if (this.ri == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label42;
      }
    }
    label42:
    for (Object localObject = new i(this, new b());; localObject = new h(this, new b()))
    {
      this.ri = ((h)localObject);
      return this.ri;
    }
  }
  
  @Deprecated
  public int getRippleColor()
  {
    if (this.hJ != null) {
      return this.hJ.getDefaultColor();
    }
    return 0;
  }
  
  public ColorStateList getRippleColorStateList()
  {
    return this.hJ;
  }
  
  public android.support.design.a.h getShowMotionSpec()
  {
    return getImpl().iK;
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
      if (this.ra != 0) {
        return this.ra;
      }
      localResources = getResources();
      switch (i)
      {
      case 0: 
      default: 
        return localResources.getDimensionPixelSize(2131166110);
      case -1: 
        if (Math.max(localResources.getConfiguration().screenWidthDp, localResources.getConfiguration().screenHeightDp) < 470) {
          i = 1;
        } else {
          i = 0;
        }
        break;
      }
    }
    return localResources.getDimensionPixelSize(2131166109);
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
    return this.qY;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.qZ;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.rd;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().cB();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    h localh = getImpl();
    if (localh.cE())
    {
      if (localh.rK == null) {
        localh.rK = new h.3(localh);
      }
      localh.rH.getViewTreeObserver().addOnPreDrawListener(localh.rK);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h localh = getImpl();
    if (localh.rK != null)
    {
      localh.rH.getViewTreeObserver().removeOnPreDrawListener(localh.rK);
      localh.rK = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    this.rb = ((i - this.rc) / 2);
    getImpl().cD();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(this.re.left + paramInt1 + this.re.right, paramInt1 + this.re.top + this.re.bottom);
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
        super.onRestoreInstanceState(((AbsSavedState)localObject).Pa);
        paramParcelable = this.rh;
        localObject = (Bundle)((ExtendableSavedState)localObject).mt.get("expandableWidgetHelper");
        paramParcelable.jR = ((Bundle)localObject).getBoolean("expanded", false);
        paramParcelable.jS = ((Bundle)localObject).getInt("expandedComponentIdHint", 0);
      } while (!paramParcelable.jR);
      localObject = paramParcelable.jQ.getParent();
    } while (!(localObject instanceof CoordinatorLayout));
    ((CoordinatorLayout)localObject).r(paramParcelable.jQ);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    ExtendableSavedState localExtendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
    n localn = localExtendableSavedState.mt;
    c localc = this.rh;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", localc.jR);
    localBundle.putInt("expandedComponentIdHint", localc.jS);
    localn.put("expandableWidgetHelper", localBundle);
    return localExtendableSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (b(this.rf)) && (!this.rf.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.hH != paramColorStateList)
    {
      this.hH = paramColorStateList;
      h localh = getImpl();
      if (localh.rv != null) {
        android.support.v4.graphics.drawable.a.a(localh.rv, paramColorStateList);
      }
      if (localh.rx != null) {
        localh.rx.c(paramColorStateList);
      }
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.hG != paramMode)
    {
      this.hG = paramMode;
      h localh = getImpl();
      if (localh.rv != null) {
        android.support.v4.graphics.drawable.a.a(localh.rv, paramMode);
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
    this.ra = paramInt;
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    this.rh.jS = paramInt;
  }
  
  public void setHideMotionSpec(android.support.design.a.h paramh)
  {
    getImpl().iL = paramh;
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(android.support.design.a.h.k(getContext(), paramInt));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    getImpl().cA();
  }
  
  public void setImageResource(int paramInt)
  {
    this.rg.setImageResource(paramInt);
  }
  
  public void setRippleColor(int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.hJ != paramColorStateList)
    {
      this.hJ = paramColorStateList;
      getImpl().setRippleColor(this.hJ);
    }
  }
  
  public void setShowMotionSpec(android.support.design.a.h paramh)
  {
    getImpl().iK = paramh;
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(android.support.design.a.h.k(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    this.ra = 0;
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
    if (this.qY != paramColorStateList)
    {
      this.qY = paramColorStateList;
      cy();
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.qZ != paramMode)
    {
      this.qZ = paramMode;
      cy();
    }
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.rd != paramBoolean)
    {
      this.rd = paramBoolean;
      getImpl().cC();
    }
  }
  
  protected static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private Rect mA;
    private FloatingActionButton.a rl;
    private boolean rm;
    
    public BaseBehavior()
    {
      this.rm = true;
    }
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FloatingActionButton_Behavior_Layout);
      this.rm = paramContext.getBoolean(0, true);
      paramContext.recycle();
    }
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (!a(paramAppBarLayout, paramFloatingActionButton)) {
        return false;
      }
      if (this.mA == null) {
        this.mA = new Rect();
      }
      Rect localRect = this.mA;
      f.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.b(this.rl);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.a(this.rl);
      }
    }
    
    private boolean a(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
      if (!this.rm) {
        return false;
      }
      if (locald.qD != paramView.getId()) {
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
        paramFloatingActionButton.b(this.rl);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.a(this.rl);
      }
    }
    
    private static boolean u(View paramView)
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.d)) {
        return ((CoordinatorLayout.d)paramView).qA instanceof BottomSheetBehavior;
      }
      return false;
    }
    
    public void a(CoordinatorLayout.d paramd)
    {
      if (paramd.qF == 0) {
        paramd.qF = 80;
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      int j = 0;
      Object localObject1 = paramCoordinatorLayout.s(paramFloatingActionButton);
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
        paramCoordinatorLayout.f(paramFloatingActionButton, paramInt);
        localObject1 = paramFloatingActionButton.re;
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
            t.s(paramFloatingActionButton, i);
          }
          if (paramInt != 0) {
            t.u(paramFloatingActionButton, paramInt);
          }
          return true;
          if ((u((View)localObject2)) && (b((View)localObject2, paramFloatingActionButton))) {
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
      paramCoordinatorLayout = paramFloatingActionButton.re;
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
        if (u(paramView)) {
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
    
    public final boolean cz()
    {
      return FloatingActionButton.this.rd;
    }
    
    public final void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      FloatingActionButton.this.re.set(paramInt1, paramInt2, paramInt3, paramInt4);
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