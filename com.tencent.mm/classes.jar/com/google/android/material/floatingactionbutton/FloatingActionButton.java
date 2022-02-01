package com.google.android.material.floatingactionbutton;

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
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.ImageView.ScaleType;
import androidx.appcompat.widget.f;
import androidx.b.g;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout.b;
import androidx.coordinatorlayout.widget.CoordinatorLayout.d;
import androidx.core.g.u;
import androidx.core.g.w;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.a.a;
import com.google.android.material.a.b;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.c.c;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.internal.d;
import com.google.android.material.internal.l;
import com.google.android.material.stateful.ExtendableSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CoordinatorLayout.b(gf=Behavior.class)
public class FloatingActionButton
  extends VisibilityAwareImageButton
  implements u, androidx.core.widget.k, com.google.android.material.c.a
{
  private ColorStateList bAk;
  private PorterDuff.Mode bAl;
  private int bAm;
  private int bAn;
  boolean bAo;
  final Rect bAp;
  private final Rect bAq;
  private final androidx.appcompat.widget.h bAr;
  private final c bAs;
  private a bAt;
  private int borderWidth;
  private PorterDuff.Mode byd;
  private ColorStateList bye;
  private ColorStateList byg;
  private int maxImageSize;
  private int size;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.floatingActionButtonStyle);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(237196);
    this.bAp = new Rect();
    this.bAq = new Rect();
    TypedArray localTypedArray = com.google.android.material.internal.k.a(paramContext, paramAttributeSet, a.k.FloatingActionButton, paramInt, a.j.Widget_Design_FloatingActionButton, new int[0]);
    this.bye = com.google.android.material.e.a.b(paramContext, localTypedArray, a.k.FloatingActionButton_backgroundTint);
    this.byd = l.c(localTypedArray.getInt(a.k.FloatingActionButton_backgroundTintMode, -1), null);
    this.byg = com.google.android.material.e.a.b(paramContext, localTypedArray, a.k.FloatingActionButton_rippleColor);
    this.size = localTypedArray.getInt(a.k.FloatingActionButton_fabSize, -1);
    this.bAm = localTypedArray.getDimensionPixelSize(a.k.FloatingActionButton_fabCustomSize, 0);
    this.borderWidth = localTypedArray.getDimensionPixelSize(a.k.FloatingActionButton_borderWidth, 0);
    float f1 = localTypedArray.getDimension(a.k.FloatingActionButton_elevation, 0.0F);
    float f2 = localTypedArray.getDimension(a.k.FloatingActionButton_hoveredFocusedTranslationZ, 0.0F);
    float f3 = localTypedArray.getDimension(a.k.FloatingActionButton_pressedTranslationZ, 0.0F);
    this.bAo = localTypedArray.getBoolean(a.k.FloatingActionButton_useCompatPadding, false);
    this.maxImageSize = localTypedArray.getDimensionPixelSize(a.k.FloatingActionButton_maxImageSize, 0);
    com.google.android.material.a.h localh = com.google.android.material.a.h.a(paramContext, localTypedArray, a.k.FloatingActionButton_showMotionSpec);
    paramContext = com.google.android.material.a.h.a(paramContext, localTypedArray, a.k.FloatingActionButton_hideMotionSpec);
    localTypedArray.recycle();
    this.bAr = new androidx.appcompat.widget.h(this);
    this.bAr.a(paramAttributeSet, paramInt);
    this.bAs = new c(this);
    getImpl().a(this.bye, this.byd, this.byg, this.borderWidth);
    getImpl().e(f1);
    getImpl().Q(f2);
    getImpl().R(f3);
    paramAttributeSet = getImpl();
    paramInt = this.maxImageSize;
    if (paramAttributeSet.maxImageSize != paramInt)
    {
      paramAttributeSet.maxImageSize = paramInt;
      paramAttributeSet.wX();
    }
    getImpl().bze = localh;
    getImpl().bzf = paramContext;
    setScaleType(ImageView.ScaleType.MATRIX);
    AppMethodBeat.o(237196);
  }
  
  private static int bA(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237273);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (j)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(237273);
      throw localIllegalArgumentException;
    }
    for (paramInt2 = Math.min(paramInt1, i);; paramInt2 = i)
    {
      AppMethodBeat.o(237273);
      return paramInt2;
    }
  }
  
  private a.d c(final a parama)
  {
    AppMethodBeat.i(237250);
    if (parama == null)
    {
      AppMethodBeat.o(237250);
      return null;
    }
    parama = new a.d() {};
    AppMethodBeat.o(237250);
    return parama;
  }
  
  private void wU()
  {
    AppMethodBeat.i(237236);
    Drawable localDrawable = getDrawable();
    if (localDrawable == null)
    {
      AppMethodBeat.o(237236);
      return;
    }
    if (this.bAk == null)
    {
      androidx.core.graphics.drawable.a.o(localDrawable);
      AppMethodBeat.o(237236);
      return;
    }
    int i = this.bAk.getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode2 = this.bAl;
    PorterDuff.Mode localMode1 = localMode2;
    if (localMode2 == null) {
      localMode1 = PorterDuff.Mode.SRC_IN;
    }
    localDrawable.mutate().setColorFilter(f.a(i, localMode1));
    AppMethodBeat.o(237236);
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(237243);
    Object localObject = getImpl();
    a.d locald = c(parama);
    if (!((a)localObject).xf())
    {
      if (((a)localObject).bAA != null) {
        ((a)localObject).bAA.cancel();
      }
      if (((a)localObject).xg())
      {
        if (((a)localObject).bAT.getVisibility() != 0)
        {
          ((a)localObject).bAT.setAlpha(0.0F);
          ((a)localObject).bAT.setScaleY(0.0F);
          ((a)localObject).bAT.setScaleX(0.0F);
          ((a)localObject).S(0.0F);
        }
        if (((a)localObject).bze != null) {}
        for (parama = ((a)localObject).bze;; parama = ((a)localObject).bAB)
        {
          parama = ((a)localObject).a(parama, 1.0F, 1.0F, 1.0F);
          parama.addListener(new a.2((a)localObject, locald));
          if (((a)localObject).bAM == null) {
            break;
          }
          localObject = ((a)localObject).bAM.iterator();
          while (((Iterator)localObject).hasNext()) {
            parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
          }
          if (((a)localObject).bAB == null) {
            ((a)localObject).bAB = com.google.android.material.a.h.y(((a)localObject).bAT.getContext(), a.a.design_fab_show_motion_spec);
          }
        }
        parama.start();
        AppMethodBeat.o(237243);
        return;
      }
      ((a)localObject).bAT.s(0, false);
      ((a)localObject).bAT.setAlpha(1.0F);
      ((a)localObject).bAT.setScaleY(1.0F);
      ((a)localObject).bAT.setScaleX(1.0F);
      ((a)localObject).S(1.0F);
    }
    AppMethodBeat.o(237243);
  }
  
  final void b(a parama)
  {
    int i = 1;
    AppMethodBeat.i(237244);
    Object localObject = getImpl();
    a.d locald = c(parama);
    if (((a)localObject).bAT.getVisibility() == 0) {
      if (((a)localObject).bAz == 1)
      {
        if (i != 0) {
          break label208;
        }
        if (((a)localObject).bAA != null) {
          ((a)localObject).bAA.cancel();
        }
        if (!((a)localObject).xg()) {
          break label199;
        }
        if (((a)localObject).bzf == null) {
          break label156;
        }
      }
    }
    for (parama = ((a)localObject).bzf;; parama = ((a)localObject).bAC)
    {
      parama = ((a)localObject).a(parama, 0.0F, 0.0F, 0.0F);
      parama.addListener(new a.1((a)localObject, locald));
      if (((a)localObject).bAN == null) {
        break label188;
      }
      localObject = ((a)localObject).bAN.iterator();
      while (((Iterator)localObject).hasNext()) {
        parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
      }
      i = 0;
      break;
      if (((a)localObject).bAz != 2) {
        break;
      }
      i = 0;
      break;
      label156:
      if (((a)localObject).bAC == null) {
        ((a)localObject).bAC = com.google.android.material.a.h.y(((a)localObject).bAT.getContext(), a.a.design_fab_hide_motion_spec);
      }
    }
    label188:
    parama.start();
    AppMethodBeat.o(237244);
    return;
    label199:
    ((a)localObject).bAT.s(4, false);
    label208:
    AppMethodBeat.o(237244);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(237263);
    super.drawableStateChanged();
    getImpl().p(getDrawableState());
    AppMethodBeat.o(237263);
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.bye;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.byd;
  }
  
  public float getCompatElevation()
  {
    AppMethodBeat.i(237275);
    float f = getImpl().wW();
    AppMethodBeat.o(237275);
    return f;
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    AppMethodBeat.i(237278);
    float f = getImpl().bAJ;
    AppMethodBeat.o(237278);
    return f;
  }
  
  public float getCompatPressedTranslationZ()
  {
    AppMethodBeat.i(237282);
    float f = getImpl().bAK;
    AppMethodBeat.o(237282);
    return f;
  }
  
  public Drawable getContentBackground()
  {
    AppMethodBeat.i(237272);
    Drawable localDrawable = getImpl().bAI;
    AppMethodBeat.o(237272);
    return localDrawable;
  }
  
  public int getCustomSize()
  {
    return this.bAm;
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.bAs.bAj;
  }
  
  public com.google.android.material.a.h getHideMotionSpec()
  {
    AppMethodBeat.i(237289);
    com.google.android.material.a.h localh = getImpl().bzf;
    AppMethodBeat.o(237289);
    return localh;
  }
  
  public a getImpl()
  {
    AppMethodBeat.i(237294);
    if (this.bAt == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label56;
      }
    }
    label56:
    for (Object localObject = new b(this, new b());; localObject = new a(this, new b()))
    {
      this.bAt = ((a)localObject);
      localObject = this.bAt;
      AppMethodBeat.o(237294);
      return localObject;
    }
  }
  
  @Deprecated
  public int getRippleColor()
  {
    AppMethodBeat.i(237200);
    if (this.byg != null)
    {
      int i = this.byg.getDefaultColor();
      AppMethodBeat.o(237200);
      return i;
    }
    AppMethodBeat.o(237200);
    return 0;
  }
  
  public ColorStateList getRippleColorStateList()
  {
    return this.byg;
  }
  
  public com.google.android.material.a.h getShowMotionSpec()
  {
    AppMethodBeat.i(237286);
    com.google.android.material.a.h localh = getImpl().bze;
    AppMethodBeat.o(237286);
    return localh;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  int getSizeDimension()
  {
    AppMethodBeat.i(237255);
    int i = this.size;
    Resources localResources;
    for (;;)
    {
      if (this.bAm != 0)
      {
        i = this.bAm;
        AppMethodBeat.o(237255);
        return i;
      }
      localResources = getResources();
      switch (i)
      {
      case 0: 
      default: 
        i = localResources.getDimensionPixelSize(com.google.android.material.a.d.design_fab_size_normal);
        AppMethodBeat.o(237255);
        return i;
      case -1: 
        if (Math.max(localResources.getConfiguration().screenWidthDp, localResources.getConfiguration().screenHeightDp) < 470) {
          i = 1;
        } else {
          i = 0;
        }
        break;
      }
    }
    i = localResources.getDimensionPixelSize(com.google.android.material.a.d.design_fab_size_mini);
    AppMethodBeat.o(237255);
    return i;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(237219);
    ColorStateList localColorStateList = getBackgroundTintList();
    AppMethodBeat.o(237219);
    return localColorStateList;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(237223);
    PorterDuff.Mode localMode = getBackgroundTintMode();
    AppMethodBeat.o(237223);
    return localMode;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    return this.bAk;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.bAl;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.bAo;
  }
  
  @Deprecated
  public final boolean i(Rect paramRect)
  {
    AppMethodBeat.i(237271);
    if (w.ah(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      j(paramRect);
      AppMethodBeat.o(237271);
      return true;
    }
    AppMethodBeat.o(237271);
    return false;
  }
  
  public final void j(Rect paramRect)
  {
    paramRect.left += this.bAp.left;
    paramRect.top += this.bAp.top;
    paramRect.right -= this.bAp.right;
    paramRect.bottom -= this.bAp.bottom;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(237267);
    super.jumpDrawablesToCurrentState();
    getImpl().wY();
    AppMethodBeat.o(237267);
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(237256);
    super.onAttachedToWindow();
    a locala = getImpl();
    if (locala.xb())
    {
      if (locala.bAY == null) {
        locala.bAY = new a.3(locala);
      }
      locala.bAT.getViewTreeObserver().addOnPreDrawListener(locala.bAY);
    }
    AppMethodBeat.o(237256);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(237262);
    super.onDetachedFromWindow();
    a locala = getImpl();
    if (locala.bAY != null)
    {
      locala.bAT.getViewTreeObserver().removeOnPreDrawListener(locala.bAY);
      locala.bAY = null;
    }
    AppMethodBeat.o(237262);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(237198);
    int i = getSizeDimension();
    this.bAn = ((i - this.maxImageSize) / 2);
    getImpl().xa();
    paramInt1 = Math.min(bA(i, paramInt1), bA(i, paramInt2));
    setMeasuredDimension(this.bAp.left + paramInt1 + this.bAp.right, paramInt1 + this.bAp.top + this.bAp.bottom);
    AppMethodBeat.o(237198);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(237270);
    if (!(paramParcelable instanceof ExtendableSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(237270);
      return;
    }
    Object localObject = (ExtendableSavedState)paramParcelable;
    super.onRestoreInstanceState(((AbsSavedState)localObject).Rb);
    paramParcelable = this.bAs;
    localObject = (Bundle)((ExtendableSavedState)localObject).bEM.get("expandableWidgetHelper");
    paramParcelable.py = ((Bundle)localObject).getBoolean("expanded", false);
    paramParcelable.bAj = ((Bundle)localObject).getInt("expandedComponentIdHint", 0);
    if (paramParcelable.py)
    {
      localObject = paramParcelable.bAi.getParent();
      if ((localObject instanceof CoordinatorLayout)) {
        ((CoordinatorLayout)localObject).w(paramParcelable.bAi);
      }
    }
    AppMethodBeat.o(237270);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(237269);
    ExtendableSavedState localExtendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
    g localg = localExtendableSavedState.bEM;
    c localc = this.bAs;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", localc.py);
    localBundle.putInt("expandedComponentIdHint", localc.bAj);
    localg.put("expandableWidgetHelper", localBundle);
    AppMethodBeat.o(237269);
    return localExtendableSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(237274);
    if ((paramMotionEvent.getAction() == 0) && (i(this.bAq)) && (!this.bAq.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
    {
      AppMethodBeat.o(237274);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(237274);
    return bool;
  }
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237211);
    if (this.bye != paramColorStateList)
    {
      this.bye = paramColorStateList;
      a locala = getImpl();
      if (locala.bAF != null) {
        androidx.core.graphics.drawable.a.a(locala.bAF, paramColorStateList);
      }
      if (locala.bAH != null) {
        locala.bAH.d(paramColorStateList);
      }
    }
    AppMethodBeat.o(237211);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(237215);
    if (this.byd != paramMode)
    {
      this.byd = paramMode;
      a locala = getImpl();
      if (locala.bAF != null) {
        androidx.core.graphics.drawable.a.a(locala.bAF, paramMode);
      }
    }
    AppMethodBeat.o(237215);
  }
  
  public void setCompatElevation(float paramFloat)
  {
    AppMethodBeat.i(237276);
    getImpl().e(paramFloat);
    AppMethodBeat.o(237276);
  }
  
  public void setCompatElevationResource(int paramInt)
  {
    AppMethodBeat.i(237277);
    setCompatElevation(getResources().getDimension(paramInt));
    AppMethodBeat.o(237277);
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    AppMethodBeat.i(237279);
    getImpl().Q(paramFloat);
    AppMethodBeat.o(237279);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt)
  {
    AppMethodBeat.i(237281);
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
    AppMethodBeat.o(237281);
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    AppMethodBeat.i(237284);
    getImpl().R(paramFloat);
    AppMethodBeat.o(237284);
  }
  
  public void setCompatPressedTranslationZResource(int paramInt)
  {
    AppMethodBeat.i(237285);
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
    AppMethodBeat.o(237285);
  }
  
  public void setCustomSize(int paramInt)
  {
    AppMethodBeat.i(237251);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Custom size must be non-negative");
      AppMethodBeat.o(237251);
      throw localIllegalArgumentException;
    }
    this.bAm = paramInt;
    AppMethodBeat.o(237251);
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    this.bAs.bAj = paramInt;
  }
  
  public void setHideMotionSpec(com.google.android.material.a.h paramh)
  {
    AppMethodBeat.i(237291);
    getImpl().bzf = paramh;
    AppMethodBeat.o(237291);
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    AppMethodBeat.i(237292);
    setHideMotionSpec(com.google.android.material.a.h.y(getContext(), paramInt));
    AppMethodBeat.o(237292);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(237242);
    super.setImageDrawable(paramDrawable);
    getImpl().wX();
    AppMethodBeat.o(237242);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(237240);
    this.bAr.setImageResource(paramInt);
    AppMethodBeat.o(237240);
  }
  
  public void setRippleColor(int paramInt)
  {
    AppMethodBeat.i(237205);
    setRippleColor(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(237205);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237207);
    if (this.byg != paramColorStateList)
    {
      this.byg = paramColorStateList;
      getImpl().setRippleColor(this.byg);
    }
    AppMethodBeat.o(237207);
  }
  
  public void setShowMotionSpec(com.google.android.material.a.h paramh)
  {
    AppMethodBeat.i(237287);
    getImpl().bze = paramh;
    AppMethodBeat.o(237287);
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    AppMethodBeat.i(237288);
    setShowMotionSpec(com.google.android.material.a.h.y(getContext(), paramInt));
    AppMethodBeat.o(237288);
  }
  
  public void setSize(int paramInt)
  {
    AppMethodBeat.i(237247);
    this.bAm = 0;
    if (paramInt != this.size)
    {
      this.size = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(237247);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237217);
    setBackgroundTintList(paramColorStateList);
    AppMethodBeat.o(237217);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(237221);
    setBackgroundTintMode(paramMode);
    AppMethodBeat.o(237221);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(237226);
    if (this.bAk != paramColorStateList)
    {
      this.bAk = paramColorStateList;
      wU();
    }
    AppMethodBeat.o(237226);
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(237230);
    if (this.bAl != paramMode)
    {
      this.bAl = paramMode;
      wU();
    }
    AppMethodBeat.o(237230);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(237245);
    if (this.bAo != paramBoolean)
    {
      this.bAo = paramBoolean;
      getImpl().wZ();
    }
    AppMethodBeat.o(237245);
  }
  
  public final boolean wT()
  {
    return this.bAs.py;
  }
  
  protected static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private FloatingActionButton.a bAw;
    private boolean bAx;
    private Rect bvn;
    
    public BaseBehavior()
    {
      this.bAx = true;
    }
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(237091);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.FloatingActionButton_Behavior_Layout);
      this.bAx = paramContext.getBoolean(a.k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
      paramContext.recycle();
      AppMethodBeat.o(237091);
    }
    
    private boolean a(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      AppMethodBeat.i(237098);
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
      if (!this.bAx)
      {
        AppMethodBeat.o(237098);
        return false;
      }
      if (locald.Ht != paramView.getId())
      {
        AppMethodBeat.o(237098);
        return false;
      }
      if (paramFloatingActionButton.getUserSetVisibility() != 0)
      {
        AppMethodBeat.o(237098);
        return false;
      }
      AppMethodBeat.o(237098);
      return true;
    }
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      AppMethodBeat.i(237100);
      if (!a(paramAppBarLayout, paramFloatingActionButton))
      {
        AppMethodBeat.o(237100);
        return false;
      }
      if (this.bvn == null) {
        this.bvn = new Rect();
      }
      Rect localRect = this.bvn;
      d.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.b(this.bAw);
      }
      for (;;)
      {
        AppMethodBeat.o(237100);
        return true;
        paramFloatingActionButton.a(this.bAw);
      }
    }
    
    private boolean b(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      AppMethodBeat.i(237102);
      if (!a(paramView, paramFloatingActionButton))
      {
        AppMethodBeat.o(237102);
        return false;
      }
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
      int i = paramView.getTop();
      int j = paramFloatingActionButton.getHeight() / 2;
      if (i < locald.topMargin + j) {
        paramFloatingActionButton.b(this.bAw);
      }
      for (;;)
      {
        AppMethodBeat.o(237102);
        return true;
        paramFloatingActionButton.a(this.bAw);
      }
    }
    
    private static boolean ci(View paramView)
    {
      AppMethodBeat.i(237096);
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.d))
      {
        boolean bool = ((CoordinatorLayout.d)paramView).Hq instanceof BottomSheetBehavior;
        AppMethodBeat.o(237096);
        return bool;
      }
      AppMethodBeat.o(237096);
      return false;
    }
    
    public void a(CoordinatorLayout.d paramd)
    {
      if (paramd.Hv == 0) {
        paramd.Hv = 80;
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(237103);
      Object localObject1 = paramCoordinatorLayout.x(paramFloatingActionButton);
      int k = ((List)localObject1).size();
      int i = 0;
      Object localObject2;
      if (i < k)
      {
        localObject2 = (View)((List)localObject1).get(i);
        if ((localObject2 instanceof AppBarLayout)) {
          if (!a(paramCoordinatorLayout, (AppBarLayout)localObject2, paramFloatingActionButton)) {
            break label204;
          }
        }
      }
      else
      {
        label70:
        paramCoordinatorLayout.h(paramFloatingActionButton, paramInt);
        localObject1 = paramFloatingActionButton.bAp;
        if ((localObject1 != null) && (((Rect)localObject1).centerX() > 0) && (((Rect)localObject1).centerY() > 0))
        {
          localObject2 = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
          if (paramFloatingActionButton.getRight() < paramCoordinatorLayout.getWidth() - ((CoordinatorLayout.d)localObject2).rightMargin) {
            break label213;
          }
          paramInt = ((Rect)localObject1).right;
        }
      }
      for (;;)
      {
        label135:
        if (paramFloatingActionButton.getBottom() >= paramCoordinatorLayout.getHeight() - ((CoordinatorLayout.d)localObject2).bottomMargin) {
          i = ((Rect)localObject1).bottom;
        }
        for (;;)
        {
          if (i != 0) {
            w.s(paramFloatingActionButton, i);
          }
          if (paramInt != 0) {
            w.u(paramFloatingActionButton, paramInt);
          }
          AppMethodBeat.o(237103);
          return true;
          if ((ci((View)localObject2)) && (b((View)localObject2, paramFloatingActionButton))) {
            break label70;
          }
          label204:
          i += 1;
          break;
          label213:
          if (paramFloatingActionButton.getLeft() > ((CoordinatorLayout.d)localObject2).leftMargin) {
            break label262;
          }
          paramInt = -((Rect)localObject1).left;
          break label135;
          i = j;
          if (paramFloatingActionButton.getTop() <= ((CoordinatorLayout.d)localObject2).topMargin) {
            i = -((Rect)localObject1).top;
          }
        }
        label262:
        paramInt = 0;
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, Rect paramRect)
    {
      AppMethodBeat.i(237104);
      paramCoordinatorLayout = paramFloatingActionButton.bAp;
      paramRect.set(paramFloatingActionButton.getLeft() + paramCoordinatorLayout.left, paramFloatingActionButton.getTop() + paramCoordinatorLayout.top, paramFloatingActionButton.getRight() - paramCoordinatorLayout.right, paramFloatingActionButton.getBottom() - paramCoordinatorLayout.bottom);
      AppMethodBeat.o(237104);
      return true;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      AppMethodBeat.i(237094);
      if ((paramView instanceof AppBarLayout)) {
        a(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      }
      for (;;)
      {
        AppMethodBeat.o(237094);
        return false;
        if (ci(paramView)) {
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
    implements com.google.android.material.g.b
  {
    b() {}
    
    public final void c(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(237159);
      FloatingActionButton.this.bAp.set(paramInt1, paramInt2, paramInt3, paramInt4);
      FloatingActionButton localFloatingActionButton = FloatingActionButton.this;
      localFloatingActionButton.setPadding(FloatingActionButton.a(localFloatingActionButton) + paramInt1, FloatingActionButton.a(FloatingActionButton.this) + paramInt2, FloatingActionButton.a(FloatingActionButton.this) + paramInt3, FloatingActionButton.a(FloatingActionButton.this) + paramInt4);
      AppMethodBeat.o(237159);
    }
    
    public final float getRadius()
    {
      AppMethodBeat.i(237157);
      float f = FloatingActionButton.this.getSizeDimension() / 2.0F;
      AppMethodBeat.o(237157);
      return f;
    }
    
    public final void setBackgroundDrawable(Drawable paramDrawable)
    {
      AppMethodBeat.i(237160);
      FloatingActionButton.a(FloatingActionButton.this, paramDrawable);
      AppMethodBeat.o(237160);
    }
    
    public final boolean wV()
    {
      return FloatingActionButton.this.bAo;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton
 * JD-Core Version:    0.7.0.1
 */