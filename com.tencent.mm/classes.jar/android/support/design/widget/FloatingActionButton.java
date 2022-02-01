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
  private PorterDuff.Mode eO;
  private ColorStateList eP;
  private ColorStateList eR;
  private ColorStateList oe;
  private PorterDuff.Mode of;
  private int og;
  private int oh;
  private int oi;
  boolean oj;
  final Rect ok = new Rect();
  private final Rect ol = new Rect();
  private final android.support.v7.widget.i om;
  private final c oo;
  private h oq;
  private int size;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969011);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = android.support.design.internal.f.a(paramContext, paramAttributeSet, a.a.FloatingActionButton, paramInt, 2131821637, new int[0]);
    this.eP = android.support.design.d.a.b(paramContext, localTypedArray, 0);
    this.eO = android.support.design.internal.g.a(localTypedArray.getInt(1, -1), null);
    this.eR = android.support.design.d.a.b(paramContext, localTypedArray, 10);
    this.size = localTypedArray.getInt(5, -1);
    this.og = localTypedArray.getDimensionPixelSize(4, 0);
    this.borderWidth = localTypedArray.getDimensionPixelSize(2, 0);
    float f1 = localTypedArray.getDimension(3, 0.0F);
    float f2 = localTypedArray.getDimension(7, 0.0F);
    float f3 = localTypedArray.getDimension(9, 0.0F);
    this.oj = localTypedArray.getBoolean(12, false);
    this.oi = localTypedArray.getDimensionPixelSize(8, 0);
    android.support.design.a.h localh = android.support.design.a.h.a(paramContext, localTypedArray, 11);
    paramContext = android.support.design.a.h.a(paramContext, localTypedArray, 6);
    localTypedArray.recycle();
    this.om = new android.support.v7.widget.i(this);
    this.om.a(paramAttributeSet, paramInt);
    this.oo = new c(this);
    getImpl().a(this.eP, this.eO, this.eR, this.borderWidth);
    getImpl().setElevation(f1);
    getImpl().n(f2);
    getImpl().o(f3);
    paramAttributeSet = getImpl();
    paramInt = this.oi;
    if (paramAttributeSet.oi != paramInt)
    {
      paramAttributeSet.oi = paramInt;
      paramAttributeSet.cd();
    }
    getImpl().fQ = localh;
    getImpl().fR = paramContext;
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private h.d c(final a parama)
  {
    if (parama == null) {
      return null;
    }
    new h.d() {};
  }
  
  private void cb()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    if (this.oe == null)
    {
      android.support.v4.graphics.drawable.a.h(localDrawable);
      return;
    }
    int i = this.oe.getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode2 = this.of;
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
    if (!((h)localObject).cl())
    {
      if (((h)localObject).ox != null) {
        ((h)localObject).ox.cancel();
      }
      if (((h)localObject).cm())
      {
        if (((h)localObject).oO.getVisibility() != 0)
        {
          ((h)localObject).oO.setAlpha(0.0F);
          ((h)localObject).oO.setScaleY(0.0F);
          ((h)localObject).oO.setScaleX(0.0F);
          ((h)localObject).p(0.0F);
        }
        if (((h)localObject).fQ != null) {}
        for (parama = ((h)localObject).fQ;; parama = ((h)localObject).oy)
        {
          parama = ((h)localObject).a(parama, 1.0F, 1.0F, 1.0F);
          parama.addListener(new h.2((h)localObject, locald));
          if (((h)localObject).oJ == null) {
            break;
          }
          localObject = ((h)localObject).oJ.iterator();
          while (((Iterator)localObject).hasNext()) {
            parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
          }
          if (((h)localObject).oy == null) {
            ((h)localObject).oy = android.support.design.a.h.k(((h)localObject).oO.getContext(), 2130837507);
          }
        }
        parama.start();
      }
    }
    else
    {
      return;
    }
    ((h)localObject).oO.e(0, false);
    ((h)localObject).oO.setAlpha(1.0F);
    ((h)localObject).oO.setScaleY(1.0F);
    ((h)localObject).oO.setScaleX(1.0F);
    ((h)localObject).p(1.0F);
  }
  
  final void b(a parama)
  {
    int i = 1;
    Object localObject = getImpl();
    h.d locald = c(parama);
    if (((h)localObject).oO.getVisibility() == 0) {
      if (((h)localObject).ow == 1)
      {
        if (i != 0) {
          break label186;
        }
        if (((h)localObject).ox != null) {
          ((h)localObject).ox.cancel();
        }
        if (!((h)localObject).cm()) {
          break label187;
        }
        if (((h)localObject).fR == null) {
          break label150;
        }
      }
    }
    for (parama = ((h)localObject).fR;; parama = ((h)localObject).oz)
    {
      parama = ((h)localObject).a(parama, 0.0F, 0.0F, 0.0F);
      parama.addListener(new h.1((h)localObject, locald));
      if (((h)localObject).oK == null) {
        break label182;
      }
      localObject = ((h)localObject).oK.iterator();
      while (((Iterator)localObject).hasNext()) {
        parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
      }
      i = 0;
      break;
      if (((h)localObject).ow != 2) {
        break;
      }
      i = 0;
      break;
      label150:
      if (((h)localObject).oz == null) {
        ((h)localObject).oz = android.support.design.a.h.k(((h)localObject).oO.getContext(), 2130837506);
      }
    }
    label182:
    parama.start();
    label186:
    return;
    label187:
    ((h)localObject).oO.e(4, false);
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
  
  public final boolean bd()
  {
    return this.oo.gX;
  }
  
  public final void c(Rect paramRect)
  {
    paramRect.left += this.ok.left;
    paramRect.top += this.ok.top;
    paramRect.right -= this.ok.right;
    paramRect.bottom -= this.ok.bottom;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().d(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.eP;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.eO;
  }
  
  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    return getImpl().oG;
  }
  
  public float getCompatPressedTranslationZ()
  {
    return getImpl().oH;
  }
  
  public Drawable getContentBackground()
  {
    return getImpl().oF;
  }
  
  public int getCustomSize()
  {
    return this.og;
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.oo.gY;
  }
  
  public android.support.design.a.h getHideMotionSpec()
  {
    return getImpl().fR;
  }
  
  public h getImpl()
  {
    if (this.oq == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label42;
      }
    }
    label42:
    for (Object localObject = new i(this, new b());; localObject = new h(this, new b()))
    {
      this.oq = ((h)localObject);
      return this.oq;
    }
  }
  
  @Deprecated
  public int getRippleColor()
  {
    if (this.eR != null) {
      return this.eR.getDefaultColor();
    }
    return 0;
  }
  
  public ColorStateList getRippleColorStateList()
  {
    return this.eR;
  }
  
  public android.support.design.a.h getShowMotionSpec()
  {
    return getImpl().fQ;
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
      if (this.og != 0) {
        return this.og;
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
    return this.oe;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.of;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.oj;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().ce();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    h localh = getImpl();
    if (localh.ch())
    {
      if (localh.oR == null) {
        localh.oR = new h.3(localh);
      }
      localh.oO.getViewTreeObserver().addOnPreDrawListener(localh.oR);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h localh = getImpl();
    if (localh.oR != null)
    {
      localh.oO.getViewTreeObserver().removeOnPreDrawListener(localh.oR);
      localh.oR = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    this.oh = ((i - this.oi) / 2);
    getImpl().cg();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(this.ok.left + paramInt1 + this.ok.right, paramInt1 + this.ok.top + this.ok.bottom);
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
        super.onRestoreInstanceState(((AbsSavedState)localObject).Mm);
        paramParcelable = this.oo;
        localObject = (Bundle)((ExtendableSavedState)localObject).jE.get("expandableWidgetHelper");
        paramParcelable.gX = ((Bundle)localObject).getBoolean("expanded", false);
        paramParcelable.gY = ((Bundle)localObject).getInt("expandedComponentIdHint", 0);
      } while (!paramParcelable.gX);
      localObject = paramParcelable.gW.getParent();
    } while (!(localObject instanceof CoordinatorLayout));
    ((CoordinatorLayout)localObject).r(paramParcelable.gW);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    ExtendableSavedState localExtendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
    n localn = localExtendableSavedState.jE;
    c localc = this.oo;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", localc.gX);
    localBundle.putInt("expandedComponentIdHint", localc.gY);
    localn.put("expandableWidgetHelper", localBundle);
    return localExtendableSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (b(this.ol)) && (!this.ol.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.eP != paramColorStateList)
    {
      this.eP = paramColorStateList;
      h localh = getImpl();
      if (localh.oC != null) {
        android.support.v4.graphics.drawable.a.a(localh.oC, paramColorStateList);
      }
      if (localh.oE != null) {
        localh.oE.c(paramColorStateList);
      }
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.eO != paramMode)
    {
      this.eO = paramMode;
      h localh = getImpl();
      if (localh.oC != null) {
        android.support.v4.graphics.drawable.a.a(localh.oC, paramMode);
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
    getImpl().n(paramFloat);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    getImpl().o(paramFloat);
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
    this.og = paramInt;
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    this.oo.gY = paramInt;
  }
  
  public void setHideMotionSpec(android.support.design.a.h paramh)
  {
    getImpl().fR = paramh;
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(android.support.design.a.h.k(getContext(), paramInt));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    getImpl().cd();
  }
  
  public void setImageResource(int paramInt)
  {
    this.om.setImageResource(paramInt);
  }
  
  public void setRippleColor(int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.eR != paramColorStateList)
    {
      this.eR = paramColorStateList;
      getImpl().setRippleColor(this.eR);
    }
  }
  
  public void setShowMotionSpec(android.support.design.a.h paramh)
  {
    getImpl().fQ = paramh;
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(android.support.design.a.h.k(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    this.og = 0;
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
    if (this.oe != paramColorStateList)
    {
      this.oe = paramColorStateList;
      cb();
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.of != paramMode)
    {
      this.of = paramMode;
      cb();
    }
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.oj != paramBoolean)
    {
      this.oj = paramBoolean;
      getImpl().cf();
    }
  }
  
  protected static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private Rect jL;
    private FloatingActionButton.a ot;
    private boolean ou;
    
    public BaseBehavior()
    {
      this.ou = true;
    }
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FloatingActionButton_Behavior_Layout);
      this.ou = paramContext.getBoolean(0, true);
      paramContext.recycle();
    }
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (!a(paramAppBarLayout, paramFloatingActionButton)) {
        return false;
      }
      if (this.jL == null) {
        this.jL = new Rect();
      }
      Rect localRect = this.jL;
      f.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.b(this.ot);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.a(this.ot);
      }
    }
    
    private boolean a(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
      if (!this.ou) {
        return false;
      }
      if (locald.nJ != paramView.getId()) {
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
        paramFloatingActionButton.b(this.ot);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.a(this.ot);
      }
    }
    
    private static boolean u(View paramView)
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.d)) {
        return ((CoordinatorLayout.d)paramView).nG instanceof BottomSheetBehavior;
      }
      return false;
    }
    
    public void a(CoordinatorLayout.d paramd)
    {
      if (paramd.nL == 0) {
        paramd.nL = 80;
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
        localObject1 = paramFloatingActionButton.ok;
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
      paramCoordinatorLayout = paramFloatingActionButton.ok;
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
    
    public final boolean cc()
    {
      return FloatingActionButton.this.oj;
    }
    
    public final void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      FloatingActionButton.this.ok.set(paramInt1, paramInt2, paramInt3, paramInt4);
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