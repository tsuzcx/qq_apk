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
  private PorterDuff.Mode fP;
  private ColorStateList fQ;
  private ColorStateList fS;
  private ColorStateList pf;
  private PorterDuff.Mode pg;
  private int ph;
  private int pi;
  private int pj;
  boolean pk;
  final Rect pl = new Rect();
  private final Rect pm = new Rect();
  private final android.support.v7.widget.i pn;
  private final c po;
  private h pp;
  private int size;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969011);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = android.support.design.internal.f.a(paramContext, paramAttributeSet, a.a.FloatingActionButton, paramInt, 2131821637, new int[0]);
    this.fQ = android.support.design.d.a.b(paramContext, localTypedArray, 0);
    this.fP = android.support.design.internal.g.a(localTypedArray.getInt(1, -1), null);
    this.fS = android.support.design.d.a.b(paramContext, localTypedArray, 10);
    this.size = localTypedArray.getInt(5, -1);
    this.ph = localTypedArray.getDimensionPixelSize(4, 0);
    this.borderWidth = localTypedArray.getDimensionPixelSize(2, 0);
    float f1 = localTypedArray.getDimension(3, 0.0F);
    float f2 = localTypedArray.getDimension(7, 0.0F);
    float f3 = localTypedArray.getDimension(9, 0.0F);
    this.pk = localTypedArray.getBoolean(12, false);
    this.pj = localTypedArray.getDimensionPixelSize(8, 0);
    android.support.design.a.h localh = android.support.design.a.h.a(paramContext, localTypedArray, 11);
    paramContext = android.support.design.a.h.a(paramContext, localTypedArray, 6);
    localTypedArray.recycle();
    this.pn = new android.support.v7.widget.i(this);
    this.pn.a(paramAttributeSet, paramInt);
    this.po = new c(this);
    getImpl().a(this.fQ, this.fP, this.fS, this.borderWidth);
    getImpl().setElevation(f1);
    getImpl().r(f2);
    getImpl().s(f3);
    paramAttributeSet = getImpl();
    paramInt = this.pj;
    if (paramAttributeSet.pj != paramInt)
    {
      paramAttributeSet.pj = paramInt;
      paramAttributeSet.ck();
    }
    getImpl().gP = localh;
    getImpl().gQ = paramContext;
    setScaleType(ImageView.ScaleType.MATRIX);
  }
  
  private h.d c(final a parama)
  {
    if (parama == null) {
      return null;
    }
    new h.d() {};
  }
  
  private void ci()
  {
    Drawable localDrawable = getDrawable();
    if (localDrawable == null) {
      return;
    }
    if (this.pf == null)
    {
      android.support.v4.graphics.drawable.a.h(localDrawable);
      return;
    }
    int i = this.pf.getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode2 = this.pg;
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
    if (!((h)localObject).cs())
    {
      if (((h)localObject).pw != null) {
        ((h)localObject).pw.cancel();
      }
      if (((h)localObject).ct())
      {
        if (((h)localObject).pN.getVisibility() != 0)
        {
          ((h)localObject).pN.setAlpha(0.0F);
          ((h)localObject).pN.setScaleY(0.0F);
          ((h)localObject).pN.setScaleX(0.0F);
          ((h)localObject).t(0.0F);
        }
        if (((h)localObject).gP != null) {}
        for (parama = ((h)localObject).gP;; parama = ((h)localObject).px)
        {
          parama = ((h)localObject).a(parama, 1.0F, 1.0F, 1.0F);
          parama.addListener(new h.2((h)localObject, locald));
          if (((h)localObject).pI == null) {
            break;
          }
          localObject = ((h)localObject).pI.iterator();
          while (((Iterator)localObject).hasNext()) {
            parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
          }
          if (((h)localObject).px == null) {
            ((h)localObject).px = android.support.design.a.h.k(((h)localObject).pN.getContext(), 2130837507);
          }
        }
        parama.start();
      }
    }
    else
    {
      return;
    }
    ((h)localObject).pN.e(0, false);
    ((h)localObject).pN.setAlpha(1.0F);
    ((h)localObject).pN.setScaleY(1.0F);
    ((h)localObject).pN.setScaleX(1.0F);
    ((h)localObject).t(1.0F);
  }
  
  final void b(a parama)
  {
    int i = 1;
    Object localObject = getImpl();
    h.d locald = c(parama);
    if (((h)localObject).pN.getVisibility() == 0) {
      if (((h)localObject).pv == 1)
      {
        if (i != 0) {
          break label186;
        }
        if (((h)localObject).pw != null) {
          ((h)localObject).pw.cancel();
        }
        if (!((h)localObject).ct()) {
          break label187;
        }
        if (((h)localObject).gQ == null) {
          break label150;
        }
      }
    }
    for (parama = ((h)localObject).gQ;; parama = ((h)localObject).py)
    {
      parama = ((h)localObject).a(parama, 0.0F, 0.0F, 0.0F);
      parama.addListener(new h.1((h)localObject, locald));
      if (((h)localObject).pJ == null) {
        break label182;
      }
      localObject = ((h)localObject).pJ.iterator();
      while (((Iterator)localObject).hasNext()) {
        parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
      }
      i = 0;
      break;
      if (((h)localObject).pv != 2) {
        break;
      }
      i = 0;
      break;
      label150:
      if (((h)localObject).py == null) {
        ((h)localObject).py = android.support.design.a.h.k(((h)localObject).pN.getContext(), 2130837506);
      }
    }
    label182:
    parama.start();
    label186:
    return;
    label187:
    ((h)localObject).pN.e(4, false);
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
  
  public final boolean bk()
  {
    return this.po.hW;
  }
  
  public final void c(Rect paramRect)
  {
    paramRect.left += this.pl.left;
    paramRect.top += this.pl.top;
    paramRect.right -= this.pl.right;
    paramRect.bottom -= this.pl.bottom;
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    getImpl().d(getDrawableState());
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.fQ;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.fP;
  }
  
  public float getCompatElevation()
  {
    return getImpl().getElevation();
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    return getImpl().pF;
  }
  
  public float getCompatPressedTranslationZ()
  {
    return getImpl().pG;
  }
  
  public Drawable getContentBackground()
  {
    return getImpl().pE;
  }
  
  public int getCustomSize()
  {
    return this.ph;
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.po.hX;
  }
  
  public android.support.design.a.h getHideMotionSpec()
  {
    return getImpl().gQ;
  }
  
  public h getImpl()
  {
    if (this.pp == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label42;
      }
    }
    label42:
    for (Object localObject = new i(this, new b());; localObject = new h(this, new b()))
    {
      this.pp = ((h)localObject);
      return this.pp;
    }
  }
  
  @Deprecated
  public int getRippleColor()
  {
    if (this.fS != null) {
      return this.fS.getDefaultColor();
    }
    return 0;
  }
  
  public ColorStateList getRippleColorStateList()
  {
    return this.fS;
  }
  
  public android.support.design.a.h getShowMotionSpec()
  {
    return getImpl().gP;
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
      if (this.ph != 0) {
        return this.ph;
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
    return this.pf;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.pg;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.pk;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    getImpl().cl();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    h localh = getImpl();
    if (localh.co())
    {
      if (localh.pQ == null) {
        localh.pQ = new h.3(localh);
      }
      localh.pN.getViewTreeObserver().addOnPreDrawListener(localh.pQ);
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    h localh = getImpl();
    if (localh.pQ != null)
    {
      localh.pN.getViewTreeObserver().removeOnPreDrawListener(localh.pQ);
      localh.pQ = null;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = getSizeDimension();
    this.pi = ((i - this.pj) / 2);
    getImpl().cn();
    paramInt1 = Math.min(resolveAdjustedSize(i, paramInt1), resolveAdjustedSize(i, paramInt2));
    setMeasuredDimension(this.pl.left + paramInt1 + this.pl.right, paramInt1 + this.pl.top + this.pl.bottom);
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
        super.onRestoreInstanceState(((AbsSavedState)localObject).Nj);
        paramParcelable = this.po;
        localObject = (Bundle)((ExtendableSavedState)localObject).kD.get("expandableWidgetHelper");
        paramParcelable.hW = ((Bundle)localObject).getBoolean("expanded", false);
        paramParcelable.hX = ((Bundle)localObject).getInt("expandedComponentIdHint", 0);
      } while (!paramParcelable.hW);
      localObject = paramParcelable.hV.getParent();
    } while (!(localObject instanceof CoordinatorLayout));
    ((CoordinatorLayout)localObject).r(paramParcelable.hV);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    ExtendableSavedState localExtendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
    n localn = localExtendableSavedState.kD;
    c localc = this.po;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", localc.hW);
    localBundle.putInt("expandedComponentIdHint", localc.hX);
    localn.put("expandableWidgetHelper", localBundle);
    return localExtendableSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (b(this.pm)) && (!this.pm.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY()))) {
      return false;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (this.fQ != paramColorStateList)
    {
      this.fQ = paramColorStateList;
      h localh = getImpl();
      if (localh.pB != null) {
        android.support.v4.graphics.drawable.a.a(localh.pB, paramColorStateList);
      }
      if (localh.pD != null) {
        localh.pD.c(paramColorStateList);
      }
    }
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (this.fP != paramMode)
    {
      this.fP = paramMode;
      h localh = getImpl();
      if (localh.pB != null) {
        android.support.v4.graphics.drawable.a.a(localh.pB, paramMode);
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
    getImpl().r(paramFloat);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt)
  {
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    getImpl().s(paramFloat);
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
    this.ph = paramInt;
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    this.po.hX = paramInt;
  }
  
  public void setHideMotionSpec(android.support.design.a.h paramh)
  {
    getImpl().gQ = paramh;
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    setHideMotionSpec(android.support.design.a.h.k(getContext(), paramInt));
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    getImpl().ck();
  }
  
  public void setImageResource(int paramInt)
  {
    this.pn.setImageResource(paramInt);
  }
  
  public void setRippleColor(int paramInt)
  {
    setRippleColor(ColorStateList.valueOf(paramInt));
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.fS != paramColorStateList)
    {
      this.fS = paramColorStateList;
      getImpl().setRippleColor(this.fS);
    }
  }
  
  public void setShowMotionSpec(android.support.design.a.h paramh)
  {
    getImpl().gP = paramh;
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    setShowMotionSpec(android.support.design.a.h.k(getContext(), paramInt));
  }
  
  public void setSize(int paramInt)
  {
    this.ph = 0;
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
    if (this.pf != paramColorStateList)
    {
      this.pf = paramColorStateList;
      ci();
    }
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    if (this.pg != paramMode)
    {
      this.pg = paramMode;
      ci();
    }
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    if (this.pk != paramBoolean)
    {
      this.pk = paramBoolean;
      getImpl().cm();
    }
  }
  
  protected static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private Rect kK;
    private FloatingActionButton.a ps;
    private boolean pt;
    
    public BaseBehavior()
    {
      this.pt = true;
    }
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.FloatingActionButton_Behavior_Layout);
      this.pt = paramContext.getBoolean(0, true);
      paramContext.recycle();
    }
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      if (!a(paramAppBarLayout, paramFloatingActionButton)) {
        return false;
      }
      if (this.kK == null) {
        this.kK = new Rect();
      }
      Rect localRect = this.kK;
      f.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.b(this.ps);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.a(this.ps);
      }
    }
    
    private boolean a(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
      if (!this.pt) {
        return false;
      }
      if (locald.oK != paramView.getId()) {
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
        paramFloatingActionButton.b(this.ps);
      }
      for (;;)
      {
        return true;
        paramFloatingActionButton.a(this.ps);
      }
    }
    
    private static boolean u(View paramView)
    {
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.d)) {
        return ((CoordinatorLayout.d)paramView).oH instanceof BottomSheetBehavior;
      }
      return false;
    }
    
    public void a(CoordinatorLayout.d paramd)
    {
      if (paramd.oM == 0) {
        paramd.oM = 80;
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
        localObject1 = paramFloatingActionButton.pl;
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
      paramCoordinatorLayout = paramFloatingActionButton.pl;
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
    
    public final boolean cj()
    {
      return FloatingActionButton.this.pk;
    }
    
    public final void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      FloatingActionButton.this.pl.set(paramInt1, paramInt2, paramInt3, paramInt4);
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