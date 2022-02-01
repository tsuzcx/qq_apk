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
import androidx.core.g.x;
import androidx.core.g.z;
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
import com.google.android.material.internal.k;
import com.google.android.material.stateful.ExtendableSavedState;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@CoordinatorLayout.b(Dr=Behavior.class)
public class FloatingActionButton
  extends VisibilityAwareImageButton
  implements x, androidx.core.widget.l, com.google.android.material.c.a
{
  private int borderWidth;
  private PorterDuff.Mode drg;
  private ColorStateList drh;
  private ColorStateList drj;
  private ColorStateList dtl;
  private PorterDuff.Mode dtm;
  private int dtn;
  private int dto;
  boolean dtp;
  final Rect dtq;
  private final Rect dtr;
  private final androidx.appcompat.widget.h dtt;
  private final c dtu;
  private a dtv;
  private int maxImageSize;
  private int size;
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.floatingActionButtonStyle);
  }
  
  public FloatingActionButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(209936);
    this.dtq = new Rect();
    this.dtr = new Rect();
    TypedArray localTypedArray = k.a(paramContext, paramAttributeSet, a.k.FloatingActionButton, paramInt, a.j.Widget_Design_FloatingActionButton, new int[0]);
    this.drh = com.google.android.material.e.a.b(paramContext, localTypedArray, a.k.FloatingActionButton_backgroundTint);
    this.drg = com.google.android.material.internal.l.c(localTypedArray.getInt(a.k.FloatingActionButton_backgroundTintMode, -1), null);
    this.drj = com.google.android.material.e.a.b(paramContext, localTypedArray, a.k.FloatingActionButton_rippleColor);
    this.size = localTypedArray.getInt(a.k.FloatingActionButton_fabSize, -1);
    this.dtn = localTypedArray.getDimensionPixelSize(a.k.FloatingActionButton_fabCustomSize, 0);
    this.borderWidth = localTypedArray.getDimensionPixelSize(a.k.FloatingActionButton_borderWidth, 0);
    float f1 = localTypedArray.getDimension(a.k.FloatingActionButton_elevation, 0.0F);
    float f2 = localTypedArray.getDimension(a.k.FloatingActionButton_hoveredFocusedTranslationZ, 0.0F);
    float f3 = localTypedArray.getDimension(a.k.FloatingActionButton_pressedTranslationZ, 0.0F);
    this.dtp = localTypedArray.getBoolean(a.k.FloatingActionButton_useCompatPadding, false);
    this.maxImageSize = localTypedArray.getDimensionPixelSize(a.k.FloatingActionButton_maxImageSize, 0);
    com.google.android.material.a.h localh = com.google.android.material.a.h.a(paramContext, localTypedArray, a.k.FloatingActionButton_showMotionSpec);
    paramContext = com.google.android.material.a.h.a(paramContext, localTypedArray, a.k.FloatingActionButton_hideMotionSpec);
    localTypedArray.recycle();
    this.dtt = new androidx.appcompat.widget.h(this);
    this.dtt.a(paramAttributeSet, paramInt);
    this.dtu = new c(this);
    getImpl().a(this.drh, this.drg, this.drj, this.borderWidth);
    getImpl().g(f1);
    getImpl().aR(f2);
    getImpl().aS(f3);
    paramAttributeSet = getImpl();
    paramInt = this.maxImageSize;
    if (paramAttributeSet.maxImageSize != paramInt)
    {
      paramAttributeSet.maxImageSize = paramInt;
      paramAttributeSet.Wv();
    }
    getImpl().dse = localh;
    getImpl().dsf = paramContext;
    setScaleType(ImageView.ScaleType.MATRIX);
    AppMethodBeat.o(209936);
  }
  
  private void Wt()
  {
    AppMethodBeat.i(209944);
    Drawable localDrawable = getDrawable();
    if (localDrawable == null)
    {
      AppMethodBeat.o(209944);
      return;
    }
    if (this.dtl == null)
    {
      androidx.core.graphics.drawable.a.r(localDrawable);
      AppMethodBeat.o(209944);
      return;
    }
    int i = this.dtl.getColorForState(getDrawableState(), 0);
    PorterDuff.Mode localMode2 = this.dtm;
    PorterDuff.Mode localMode1 = localMode2;
    if (localMode2 == null) {
      localMode1 = PorterDuff.Mode.SRC_IN;
    }
    localDrawable.mutate().setColorFilter(f.a(i, localMode1));
    AppMethodBeat.o(209944);
  }
  
  private a.d c(final a parama)
  {
    AppMethodBeat.i(209953);
    if (parama == null)
    {
      AppMethodBeat.o(209953);
      return null;
    }
    parama = new a.d() {};
    AppMethodBeat.o(209953);
    return parama;
  }
  
  private static int cv(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209958);
    int j = View.MeasureSpec.getMode(paramInt2);
    int i = View.MeasureSpec.getSize(paramInt2);
    paramInt2 = paramInt1;
    switch (j)
    {
    default: 
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException();
      AppMethodBeat.o(209958);
      throw localIllegalArgumentException;
    }
    for (paramInt2 = Math.min(paramInt1, i);; paramInt2 = i)
    {
      AppMethodBeat.o(209958);
      return paramInt2;
    }
  }
  
  public final boolean Ws()
  {
    return this.dtu.qv;
  }
  
  final void a(a parama)
  {
    AppMethodBeat.i(210104);
    Object localObject = getImpl();
    a.d locald = c(parama);
    if (!((a)localObject).WD())
    {
      if (((a)localObject).dtC != null) {
        ((a)localObject).dtC.cancel();
      }
      if (((a)localObject).WE())
      {
        if (((a)localObject).dtV.getVisibility() != 0)
        {
          ((a)localObject).dtV.setAlpha(0.0F);
          ((a)localObject).dtV.setScaleY(0.0F);
          ((a)localObject).dtV.setScaleX(0.0F);
          ((a)localObject).aT(0.0F);
        }
        if (((a)localObject).dse != null) {}
        for (parama = ((a)localObject).dse;; parama = ((a)localObject).dtD)
        {
          parama = ((a)localObject).a(parama, 1.0F, 1.0F, 1.0F);
          parama.addListener(new a.2((a)localObject, locald));
          if (((a)localObject).dtO == null) {
            break;
          }
          localObject = ((a)localObject).dtO.iterator();
          while (((Iterator)localObject).hasNext()) {
            parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
          }
          if (((a)localObject).dtD == null) {
            ((a)localObject).dtD = com.google.android.material.a.h.B(((a)localObject).dtV.getContext(), a.a.design_fab_show_motion_spec);
          }
        }
        parama.start();
        AppMethodBeat.o(210104);
        return;
      }
      ((a)localObject).dtV.G(0, false);
      ((a)localObject).dtV.setAlpha(1.0F);
      ((a)localObject).dtV.setScaleY(1.0F);
      ((a)localObject).dtV.setScaleX(1.0F);
      ((a)localObject).aT(1.0F);
    }
    AppMethodBeat.o(210104);
  }
  
  final void b(a parama)
  {
    int i = 1;
    AppMethodBeat.i(210116);
    Object localObject = getImpl();
    a.d locald = c(parama);
    if (((a)localObject).dtV.getVisibility() == 0) {
      if (((a)localObject).dtB == 1)
      {
        if (i != 0) {
          break label208;
        }
        if (((a)localObject).dtC != null) {
          ((a)localObject).dtC.cancel();
        }
        if (!((a)localObject).WE()) {
          break label199;
        }
        if (((a)localObject).dsf == null) {
          break label156;
        }
      }
    }
    for (parama = ((a)localObject).dsf;; parama = ((a)localObject).dtE)
    {
      parama = ((a)localObject).a(parama, 0.0F, 0.0F, 0.0F);
      parama.addListener(new a.1((a)localObject, locald));
      if (((a)localObject).dtP == null) {
        break label188;
      }
      localObject = ((a)localObject).dtP.iterator();
      while (((Iterator)localObject).hasNext()) {
        parama.addListener((Animator.AnimatorListener)((Iterator)localObject).next());
      }
      i = 0;
      break;
      if (((a)localObject).dtB != 2) {
        break;
      }
      i = 0;
      break;
      label156:
      if (((a)localObject).dtE == null) {
        ((a)localObject).dtE = com.google.android.material.a.h.B(((a)localObject).dtV.getContext(), a.a.design_fab_hide_motion_spec);
      }
    }
    label188:
    parama.start();
    AppMethodBeat.o(210116);
    return;
    label199:
    ((a)localObject).dtV.G(4, false);
    label208:
    AppMethodBeat.o(210116);
  }
  
  protected void drawableStateChanged()
  {
    AppMethodBeat.i(210173);
    super.drawableStateChanged();
    getImpl().s(getDrawableState());
    AppMethodBeat.o(210173);
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return this.drh;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return this.drg;
  }
  
  public float getCompatElevation()
  {
    AppMethodBeat.i(210211);
    float f = getImpl().za();
    AppMethodBeat.o(210211);
    return f;
  }
  
  public float getCompatHoveredFocusedTranslationZ()
  {
    AppMethodBeat.i(210225);
    float f = getImpl().dtL;
    AppMethodBeat.o(210225);
    return f;
  }
  
  public float getCompatPressedTranslationZ()
  {
    AppMethodBeat.i(210237);
    float f = getImpl().dtM;
    AppMethodBeat.o(210237);
    return f;
  }
  
  public Drawable getContentBackground()
  {
    AppMethodBeat.i(210200);
    Drawable localDrawable = getImpl().dtK;
    AppMethodBeat.o(210200);
    return localDrawable;
  }
  
  public int getCustomSize()
  {
    return this.dtn;
  }
  
  public int getExpandedComponentIdHint()
  {
    return this.dtu.dtk;
  }
  
  public com.google.android.material.a.h getHideMotionSpec()
  {
    AppMethodBeat.i(210255);
    com.google.android.material.a.h localh = getImpl().dsf;
    AppMethodBeat.o(210255);
    return localh;
  }
  
  public a getImpl()
  {
    AppMethodBeat.i(210262);
    if (this.dtv == null) {
      if (Build.VERSION.SDK_INT < 21) {
        break label56;
      }
    }
    label56:
    for (Object localObject = new b(this, new b());; localObject = new a(this, new b()))
    {
      this.dtv = ((a)localObject);
      localObject = this.dtv;
      AppMethodBeat.o(210262);
      return localObject;
    }
  }
  
  @Deprecated
  public int getRippleColor()
  {
    AppMethodBeat.i(209986);
    if (this.drj != null)
    {
      int i = this.drj.getDefaultColor();
      AppMethodBeat.o(209986);
      return i;
    }
    AppMethodBeat.o(209986);
    return 0;
  }
  
  public ColorStateList getRippleColorStateList()
  {
    return this.drj;
  }
  
  public com.google.android.material.a.h getShowMotionSpec()
  {
    AppMethodBeat.i(210247);
    com.google.android.material.a.h localh = getImpl().dse;
    AppMethodBeat.o(210247);
    return localh;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  int getSizeDimension()
  {
    AppMethodBeat.i(210157);
    int i = this.size;
    Resources localResources;
    for (;;)
    {
      if (this.dtn != 0)
      {
        i = this.dtn;
        AppMethodBeat.o(210157);
        return i;
      }
      localResources = getResources();
      switch (i)
      {
      case 0: 
      default: 
        i = localResources.getDimensionPixelSize(com.google.android.material.a.d.design_fab_size_normal);
        AppMethodBeat.o(210157);
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
    AppMethodBeat.o(210157);
    return i;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(210036);
    ColorStateList localColorStateList = getBackgroundTintList();
    AppMethodBeat.o(210036);
    return localColorStateList;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(210051);
    PorterDuff.Mode localMode = getBackgroundTintMode();
    AppMethodBeat.o(210051);
    return localMode;
  }
  
  public ColorStateList getSupportImageTintList()
  {
    return this.dtl;
  }
  
  public PorterDuff.Mode getSupportImageTintMode()
  {
    return this.dtm;
  }
  
  public boolean getUseCompatPadding()
  {
    return this.dtp;
  }
  
  public void jumpDrawablesToCurrentState()
  {
    AppMethodBeat.i(210178);
    super.jumpDrawablesToCurrentState();
    getImpl().Ww();
    AppMethodBeat.o(210178);
  }
  
  @Deprecated
  public final boolean o(Rect paramRect)
  {
    AppMethodBeat.i(210193);
    if (z.au(this))
    {
      paramRect.set(0, 0, getWidth(), getHeight());
      p(paramRect);
      AppMethodBeat.o(210193);
      return true;
    }
    AppMethodBeat.o(210193);
    return false;
  }
  
  protected void onAttachedToWindow()
  {
    AppMethodBeat.i(210162);
    super.onAttachedToWindow();
    a locala = getImpl();
    if (locala.Wz())
    {
      if (locala.dua == null) {
        locala.dua = new a.3(locala);
      }
      locala.dtV.getViewTreeObserver().addOnPreDrawListener(locala.dua);
    }
    AppMethodBeat.o(210162);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(210167);
    super.onDetachedFromWindow();
    a locala = getImpl();
    if (locala.dua != null)
    {
      locala.dtV.getViewTreeObserver().removeOnPreDrawListener(locala.dua);
      locala.dua = null;
    }
    AppMethodBeat.o(210167);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(209979);
    int i = getSizeDimension();
    this.dto = ((i - this.maxImageSize) / 2);
    getImpl().Wy();
    paramInt1 = Math.min(cv(i, paramInt1), cv(i, paramInt2));
    setMeasuredDimension(this.dtq.left + paramInt1 + this.dtq.right, paramInt1 + this.dtq.top + this.dtq.bottom);
    AppMethodBeat.o(209979);
  }
  
  protected void onRestoreInstanceState(Parcelable paramParcelable)
  {
    AppMethodBeat.i(210189);
    if (!(paramParcelable instanceof ExtendableSavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      AppMethodBeat.o(210189);
      return;
    }
    Object localObject = (ExtendableSavedState)paramParcelable;
    super.onRestoreInstanceState(((AbsSavedState)localObject).bxs);
    paramParcelable = this.dtu;
    localObject = (Bundle)((ExtendableSavedState)localObject).dxM.get("expandableWidgetHelper");
    paramParcelable.qv = ((Bundle)localObject).getBoolean("expanded", false);
    paramParcelable.dtk = ((Bundle)localObject).getInt("expandedComponentIdHint", 0);
    if (paramParcelable.qv)
    {
      localObject = paramParcelable.dtj.getParent();
      if ((localObject instanceof CoordinatorLayout)) {
        ((CoordinatorLayout)localObject).F(paramParcelable.dtj);
      }
    }
    AppMethodBeat.o(210189);
  }
  
  protected Parcelable onSaveInstanceState()
  {
    AppMethodBeat.i(210182);
    ExtendableSavedState localExtendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
    g localg = localExtendableSavedState.dxM;
    c localc = this.dtu;
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("expanded", localc.qv);
    localBundle.putInt("expandedComponentIdHint", localc.dtk);
    localg.put("expandableWidgetHelper", localBundle);
    AppMethodBeat.o(210182);
    return localExtendableSavedState;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(210206);
    if ((paramMotionEvent.getAction() == 0) && (o(this.dtr)) && (!this.dtr.contains((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY())))
    {
      AppMethodBeat.o(210206);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(210206);
    return bool;
  }
  
  public final void p(Rect paramRect)
  {
    paramRect.left += this.dtq.left;
    paramRect.top += this.dtq.top;
    paramRect.right -= this.dtq.right;
    paramRect.bottom -= this.dtq.bottom;
  }
  
  public void setBackgroundColor(int paramInt) {}
  
  public void setBackgroundDrawable(Drawable paramDrawable) {}
  
  public void setBackgroundResource(int paramInt) {}
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210018);
    if (this.drh != paramColorStateList)
    {
      this.drh = paramColorStateList;
      a locala = getImpl();
      if (locala.dtH != null) {
        androidx.core.graphics.drawable.a.a(locala.dtH, paramColorStateList);
      }
      if (locala.dtJ != null) {
        locala.dtJ.d(paramColorStateList);
      }
    }
    AppMethodBeat.o(210018);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(210025);
    if (this.drg != paramMode)
    {
      this.drg = paramMode;
      a locala = getImpl();
      if (locala.dtH != null) {
        androidx.core.graphics.drawable.a.a(locala.dtH, paramMode);
      }
    }
    AppMethodBeat.o(210025);
  }
  
  public void setCompatElevation(float paramFloat)
  {
    AppMethodBeat.i(210216);
    getImpl().g(paramFloat);
    AppMethodBeat.o(210216);
  }
  
  public void setCompatElevationResource(int paramInt)
  {
    AppMethodBeat.i(210220);
    setCompatElevation(getResources().getDimension(paramInt));
    AppMethodBeat.o(210220);
  }
  
  public void setCompatHoveredFocusedTranslationZ(float paramFloat)
  {
    AppMethodBeat.i(210228);
    getImpl().aR(paramFloat);
    AppMethodBeat.o(210228);
  }
  
  public void setCompatHoveredFocusedTranslationZResource(int paramInt)
  {
    AppMethodBeat.i(210232);
    setCompatHoveredFocusedTranslationZ(getResources().getDimension(paramInt));
    AppMethodBeat.o(210232);
  }
  
  public void setCompatPressedTranslationZ(float paramFloat)
  {
    AppMethodBeat.i(210242);
    getImpl().aS(paramFloat);
    AppMethodBeat.o(210242);
  }
  
  public void setCompatPressedTranslationZResource(int paramInt)
  {
    AppMethodBeat.i(210243);
    setCompatPressedTranslationZ(getResources().getDimension(paramInt));
    AppMethodBeat.o(210243);
  }
  
  public void setCustomSize(int paramInt)
  {
    AppMethodBeat.i(210149);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("Custom size must be non-negative");
      AppMethodBeat.o(210149);
      throw localIllegalArgumentException;
    }
    this.dtn = paramInt;
    AppMethodBeat.o(210149);
  }
  
  public void setExpandedComponentIdHint(int paramInt)
  {
    this.dtu.dtk = paramInt;
  }
  
  public void setHideMotionSpec(com.google.android.material.a.h paramh)
  {
    AppMethodBeat.i(210257);
    getImpl().dsf = paramh;
    AppMethodBeat.o(210257);
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    AppMethodBeat.i(210260);
    setHideMotionSpec(com.google.android.material.a.h.B(getContext(), paramInt));
    AppMethodBeat.o(210260);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(210093);
    super.setImageDrawable(paramDrawable);
    getImpl().Wv();
    AppMethodBeat.o(210093);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(210088);
    this.dtt.setImageResource(paramInt);
    AppMethodBeat.o(210088);
  }
  
  public void setRippleColor(int paramInt)
  {
    AppMethodBeat.i(209998);
    setRippleColor(ColorStateList.valueOf(paramInt));
    AppMethodBeat.o(209998);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210007);
    if (this.drj != paramColorStateList)
    {
      this.drj = paramColorStateList;
      getImpl().setRippleColor(this.drj);
    }
    AppMethodBeat.o(210007);
  }
  
  public void setShowMotionSpec(com.google.android.material.a.h paramh)
  {
    AppMethodBeat.i(210249);
    getImpl().dse = paramh;
    AppMethodBeat.o(210249);
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    AppMethodBeat.i(210252);
    setShowMotionSpec(com.google.android.material.a.h.B(getContext(), paramInt));
    AppMethodBeat.o(210252);
  }
  
  public void setSize(int paramInt)
  {
    AppMethodBeat.i(210140);
    this.dtn = 0;
    if (paramInt != this.size)
    {
      this.size = paramInt;
      requestLayout();
    }
    AppMethodBeat.o(210140);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210030);
    setBackgroundTintList(paramColorStateList);
    AppMethodBeat.o(210030);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(210043);
    setBackgroundTintMode(paramMode);
    AppMethodBeat.o(210043);
  }
  
  public void setSupportImageTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210055);
    if (this.dtl != paramColorStateList)
    {
      this.dtl = paramColorStateList;
      Wt();
    }
    AppMethodBeat.o(210055);
  }
  
  public void setSupportImageTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(210059);
    if (this.dtm != paramMode)
    {
      this.dtm = paramMode;
      Wt();
    }
    AppMethodBeat.o(210059);
  }
  
  public void setUseCompatPadding(boolean paramBoolean)
  {
    AppMethodBeat.i(210133);
    if (this.dtp != paramBoolean)
    {
      this.dtp = paramBoolean;
      getImpl().Wx();
    }
    AppMethodBeat.o(210133);
  }
  
  protected static class BaseBehavior<T extends FloatingActionButton>
    extends CoordinatorLayout.Behavior<T>
  {
    private FloatingActionButton.a dty;
    private boolean dtz;
    private Rect tmpRect;
    
    public BaseBehavior()
    {
      this.dtz = true;
    }
    
    public BaseBehavior(Context paramContext, AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
      AppMethodBeat.i(209848);
      paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.k.FloatingActionButton_Behavior_Layout);
      this.dtz = paramContext.getBoolean(a.k.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
      paramContext.recycle();
      AppMethodBeat.o(209848);
    }
    
    private boolean a(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      AppMethodBeat.i(209864);
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
      if (!this.dtz)
      {
        AppMethodBeat.o(209864);
        return false;
      }
      if (locald.bnu != paramView.getId())
      {
        AppMethodBeat.o(209864);
        return false;
      }
      if (paramFloatingActionButton.getUserSetVisibility() != 0)
      {
        AppMethodBeat.o(209864);
        return false;
      }
      AppMethodBeat.o(209864);
      return true;
    }
    
    private boolean a(CoordinatorLayout paramCoordinatorLayout, AppBarLayout paramAppBarLayout, FloatingActionButton paramFloatingActionButton)
    {
      AppMethodBeat.i(209870);
      if (!a(paramAppBarLayout, paramFloatingActionButton))
      {
        AppMethodBeat.o(209870);
        return false;
      }
      if (this.tmpRect == null) {
        this.tmpRect = new Rect();
      }
      Rect localRect = this.tmpRect;
      d.a(paramCoordinatorLayout, paramAppBarLayout, localRect);
      if (localRect.bottom <= paramAppBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
        paramFloatingActionButton.b(this.dty);
      }
      for (;;)
      {
        AppMethodBeat.o(209870);
        return true;
        paramFloatingActionButton.a(this.dty);
      }
    }
    
    private boolean b(View paramView, FloatingActionButton paramFloatingActionButton)
    {
      AppMethodBeat.i(209878);
      if (!a(paramView, paramFloatingActionButton))
      {
        AppMethodBeat.o(209878);
        return false;
      }
      CoordinatorLayout.d locald = (CoordinatorLayout.d)paramFloatingActionButton.getLayoutParams();
      int i = paramView.getTop();
      int j = paramFloatingActionButton.getHeight() / 2;
      if (i < locald.topMargin + j) {
        paramFloatingActionButton.b(this.dty);
      }
      for (;;)
      {
        AppMethodBeat.o(209878);
        return true;
        paramFloatingActionButton.a(this.dty);
      }
    }
    
    private static boolean cE(View paramView)
    {
      AppMethodBeat.i(209858);
      paramView = paramView.getLayoutParams();
      if ((paramView instanceof CoordinatorLayout.d))
      {
        boolean bool = ((CoordinatorLayout.d)paramView).bnr instanceof BottomSheetBehavior;
        AppMethodBeat.o(209858);
        return bool;
      }
      AppMethodBeat.o(209858);
      return false;
    }
    
    public void a(CoordinatorLayout.d paramd)
    {
      if (paramd.bnw == 0) {
        paramd.bnw = 80;
      }
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, int paramInt)
    {
      int j = 0;
      AppMethodBeat.i(209899);
      Object localObject1 = paramCoordinatorLayout.G(paramFloatingActionButton);
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
        localObject1 = paramFloatingActionButton.dtq;
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
            z.s(paramFloatingActionButton, i);
          }
          if (paramInt != 0) {
            z.u(paramFloatingActionButton, paramInt);
          }
          AppMethodBeat.o(209899);
          return true;
          if ((cE((View)localObject2)) && (b((View)localObject2, paramFloatingActionButton))) {
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
      AppMethodBeat.i(209907);
      paramCoordinatorLayout = paramFloatingActionButton.dtq;
      paramRect.set(paramFloatingActionButton.getLeft() + paramCoordinatorLayout.left, paramFloatingActionButton.getTop() + paramCoordinatorLayout.top, paramFloatingActionButton.getRight() - paramCoordinatorLayout.right, paramFloatingActionButton.getBottom() - paramCoordinatorLayout.bottom);
      AppMethodBeat.o(209907);
      return true;
    }
    
    public boolean a(CoordinatorLayout paramCoordinatorLayout, FloatingActionButton paramFloatingActionButton, View paramView)
    {
      AppMethodBeat.i(209890);
      if ((paramView instanceof AppBarLayout)) {
        a(paramCoordinatorLayout, (AppBarLayout)paramView, paramFloatingActionButton);
      }
      for (;;)
      {
        AppMethodBeat.o(209890);
        return false;
        if (cE(paramView)) {
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
    
    public final boolean Wu()
    {
      return FloatingActionButton.this.dtp;
    }
    
    public final void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(209898);
      FloatingActionButton.this.dtq.set(paramInt1, paramInt2, paramInt3, paramInt4);
      FloatingActionButton localFloatingActionButton = FloatingActionButton.this;
      localFloatingActionButton.setPadding(FloatingActionButton.a(localFloatingActionButton) + paramInt1, FloatingActionButton.a(FloatingActionButton.this) + paramInt2, FloatingActionButton.a(FloatingActionButton.this) + paramInt3, FloatingActionButton.a(FloatingActionButton.this) + paramInt4);
      AppMethodBeat.o(209898);
    }
    
    public final float getRadius()
    {
      AppMethodBeat.i(209893);
      float f = FloatingActionButton.this.getSizeDimension() / 2.0F;
      AppMethodBeat.o(209893);
      return f;
    }
    
    public final void setBackgroundDrawable(Drawable paramDrawable)
    {
      AppMethodBeat.i(209902);
      FloatingActionButton.a(FloatingActionButton.this, paramDrawable);
      AppMethodBeat.o(209902);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButton
 * JD-Core Version:    0.7.0.1
 */