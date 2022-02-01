package com.google.android.material.chip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView.BufferType;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.content.a.f.a;
import androidx.core.g.a.d;
import androidx.core.g.a.d.a;
import androidx.core.g.w;
import com.google.android.material.a.b;
import com.google.android.material.a.i;
import com.google.android.material.a.j;
import com.google.android.material.a.h;
import com.google.android.material.e.b;
import com.google.android.material.internal.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip
  extends AppCompatCheckBox
  implements a.a
{
  private static final Rect byu;
  private static final int[] byv;
  private boolean byA;
  private int byB;
  private boolean byC;
  private boolean byD;
  private boolean byE;
  private final a byF;
  private final Rect byG;
  private final f.a byH;
  private final RectF byj;
  private a byw;
  private RippleDrawable byx;
  private View.OnClickListener byy;
  private CompoundButton.OnCheckedChangeListener byz;
  
  static
  {
    AppMethodBeat.i(235925);
    byu = new Rect();
    byv = new int[] { 16842913 };
    AppMethodBeat.o(235925);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.chipStyle);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235723);
    this.byB = -2147483648;
    this.byG = new Rect();
    this.byj = new RectF();
    this.byH = new f.a()
    {
      public final void a(Typeface paramAnonymousTypeface)
      {
        AppMethodBeat.i(235684);
        Chip.this.setText(Chip.this.getText());
        Chip.this.requestLayout();
        Chip.this.invalidate();
        AppMethodBeat.o(235684);
      }
      
      public final void au(int paramAnonymousInt) {}
    };
    if (paramAttributeSet != null)
    {
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null)
      {
        paramContext = new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
        AppMethodBeat.o(235723);
        throw paramContext;
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null)
      {
        paramContext = new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        AppMethodBeat.o(235723);
        throw paramContext;
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null)
      {
        paramContext = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        AppMethodBeat.o(235723);
        throw paramContext;
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null)
      {
        paramContext = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        AppMethodBeat.o(235723);
        throw paramContext;
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null)
      {
        paramContext = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        AppMethodBeat.o(235723);
        throw paramContext;
      }
      if ((!paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true)) || (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1) || (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1) || (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1))
      {
        paramContext = new UnsupportedOperationException("Chip does not support multi-line text");
        AppMethodBeat.o(235723);
        throw paramContext;
      }
      paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
    }
    paramContext = a.b(paramContext, paramAttributeSet, paramInt, a.j.Widget_MaterialComponents_Chip_Action);
    setChipDrawable(paramContext);
    this.byF = new a(this);
    w.a(this, this.byF);
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new ViewOutlineProvider()
      {
        @TargetApi(21)
        public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
        {
          AppMethodBeat.i(235690);
          if (Chip.a(Chip.this) != null)
          {
            Chip.a(Chip.this).getOutline(paramAnonymousOutline);
            AppMethodBeat.o(235690);
            return;
          }
          paramAnonymousOutline.setAlpha(0.0F);
          AppMethodBeat.o(235690);
        }
      });
    }
    setChecked(this.byA);
    paramContext.bzK = false;
    setText(paramContext.byP);
    setEllipsize(paramContext.bzJ);
    setIncludeFontPadding(false);
    if (getTextAppearance() != null) {
      a(getTextAppearance());
    }
    setSingleLine();
    setGravity(8388627);
    wx();
    AppMethodBeat.o(235723);
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(235829);
    TextPaint localTextPaint = getPaint();
    localTextPaint.drawableState = this.byw.getState();
    paramb.b(getContext(), localTextPaint, this.byH);
    AppMethodBeat.o(235829);
  }
  
  private boolean bf(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(235790);
    wA();
    if (paramBoolean)
    {
      if (this.byB != -1) {
        break label54;
      }
      setFocusedVirtualView(0);
      paramBoolean = bool;
    }
    for (;;)
    {
      AppMethodBeat.o(235790);
      return paramBoolean;
      if (this.byB == 0)
      {
        setFocusedVirtualView(-1);
        paramBoolean = bool;
      }
      else
      {
        label54:
        paramBoolean = false;
      }
    }
  }
  
  private RectF getCloseIconTouchBounds()
  {
    AppMethodBeat.i(235803);
    this.byj.setEmpty();
    if (wB())
    {
      localObject = this.byw;
      RectF localRectF = this.byj;
      ((a)localObject).c(((a)localObject).getBounds(), localRectF);
    }
    Object localObject = this.byj;
    AppMethodBeat.o(235803);
    return localObject;
  }
  
  private Rect getCloseIconTouchBoundsInt()
  {
    AppMethodBeat.i(235805);
    Object localObject = getCloseIconTouchBounds();
    this.byG.set((int)((RectF)localObject).left, (int)((RectF)localObject).top, (int)((RectF)localObject).right, (int)((RectF)localObject).bottom);
    localObject = this.byG;
    AppMethodBeat.o(235805);
    return localObject;
  }
  
  private b getTextAppearance()
  {
    if (this.byw != null) {
      return this.byw.byR;
    }
    return null;
  }
  
  @SuppressLint({"PrivateApi"})
  private boolean m(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235781);
    if (paramMotionEvent.getAction() == 10) {}
    try
    {
      paramMotionEvent = androidx.customview.a.a.class.getDeclaredField("mHoveredVirtualViewId");
      paramMotionEvent.setAccessible(true);
      if (((Integer)paramMotionEvent.get(this.byF)).intValue() != -2147483648)
      {
        paramMotionEvent = androidx.customview.a.a.class.getDeclaredMethod("updateHoveredVirtualView", new Class[] { Integer.TYPE });
        paramMotionEvent.setAccessible(true);
        paramMotionEvent.invoke(this.byF, new Object[] { Integer.valueOf(-2147483648) });
        AppMethodBeat.o(235781);
        return true;
      }
    }
    catch (NoSuchFieldException paramMotionEvent)
    {
      AppMethodBeat.o(235781);
      return false;
    }
    catch (InvocationTargetException paramMotionEvent)
    {
      break label104;
    }
    catch (IllegalAccessException paramMotionEvent)
    {
      break label104;
    }
    catch (NoSuchMethodException paramMotionEvent)
    {
      label104:
      break label104;
    }
  }
  
  private void setCloseIconFocused(boolean paramBoolean)
  {
    AppMethodBeat.i(235798);
    if (this.byE != paramBoolean)
    {
      this.byE = paramBoolean;
      refreshDrawableState();
    }
    AppMethodBeat.o(235798);
  }
  
  private void setCloseIconHovered(boolean paramBoolean)
  {
    AppMethodBeat.i(235797);
    if (this.byD != paramBoolean)
    {
      this.byD = paramBoolean;
      refreshDrawableState();
    }
    AppMethodBeat.o(235797);
  }
  
  private void setCloseIconPressed(boolean paramBoolean)
  {
    AppMethodBeat.i(235795);
    if (this.byC != paramBoolean)
    {
      this.byC = paramBoolean;
      refreshDrawableState();
    }
    AppMethodBeat.o(235795);
  }
  
  private void setFocusedVirtualView(int paramInt)
  {
    AppMethodBeat.i(235794);
    if (this.byB != paramInt)
    {
      if (this.byB == 0) {
        setCloseIconFocused(false);
      }
      this.byB = paramInt;
      if (paramInt == 0) {
        setCloseIconFocused(true);
      }
    }
    AppMethodBeat.o(235794);
  }
  
  private void wA()
  {
    AppMethodBeat.i(235791);
    if (this.byB == -2147483648) {
      setFocusedVirtualView(-1);
    }
    AppMethodBeat.o(235791);
  }
  
  private boolean wB()
  {
    AppMethodBeat.i(235802);
    if ((this.byw != null) && (this.byw.getCloseIcon() != null))
    {
      AppMethodBeat.o(235802);
      return true;
    }
    AppMethodBeat.o(235802);
    return false;
  }
  
  private void wx()
  {
    AppMethodBeat.i(235724);
    if ((TextUtils.isEmpty(getText())) || (this.byw == null))
    {
      AppMethodBeat.o(235724);
      return;
    }
    float f2 = this.byw.bzg + this.byw.bzn + this.byw.bzj + this.byw.bzk;
    float f1;
    if ((!this.byw.byS) || (this.byw.getChipIcon() == null))
    {
      f1 = f2;
      if (this.byw.bzd != null)
      {
        f1 = f2;
        if (this.byw.bzc)
        {
          f1 = f2;
          if (!isChecked()) {}
        }
      }
    }
    else
    {
      f1 = f2 + (this.byw.bzh + this.byw.bzi + this.byw.byV);
    }
    f2 = f1;
    if (this.byw.byW)
    {
      f2 = f1;
      if (this.byw.getCloseIcon() != null) {
        f2 = f1 + (this.byw.bzl + this.byw.bzm + this.byw.byZ);
      }
    }
    if (w.M(this) != f2) {
      w.g(this, w.L(this), getPaddingTop(), (int)f2, getPaddingBottom());
    }
    AppMethodBeat.o(235724);
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235782);
    if ((m(paramMotionEvent)) || (this.byF.dispatchHoverEvent(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(235782);
      return true;
    }
    AppMethodBeat.o(235782);
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(235784);
    if ((this.byF.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(235784);
      return true;
    }
    AppMethodBeat.o(235784);
    return false;
  }
  
  protected void drawableStateChanged()
  {
    int k = 1;
    boolean bool2 = false;
    AppMethodBeat.i(235800);
    super.drawableStateChanged();
    boolean bool1 = bool2;
    a locala;
    if (this.byw != null)
    {
      bool1 = bool2;
      if (a.x(this.byw.byX))
      {
        locala = this.byw;
        if (!isEnabled()) {
          break label234;
        }
      }
    }
    label234:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.byE) {
        i = j + 1;
      }
      j = i;
      if (this.byD) {
        j = i + 1;
      }
      i = j;
      if (this.byC) {
        i = j + 1;
      }
      j = i;
      if (isChecked()) {
        j = i + 1;
      }
      int[] arrayOfInt = new int[j];
      if (isEnabled()) {
        arrayOfInt[0] = 16842910;
      }
      for (j = k;; j = 0)
      {
        i = j;
        if (this.byE)
        {
          arrayOfInt[j] = 16842908;
          i = j + 1;
        }
        j = i;
        if (this.byD)
        {
          arrayOfInt[i] = 16843623;
          j = i + 1;
        }
        i = j;
        if (this.byC)
        {
          arrayOfInt[j] = 16842919;
          i = j + 1;
        }
        if (isChecked()) {
          arrayOfInt[i] = 16842913;
        }
        bool1 = locala.n(arrayOfInt);
        if (bool1) {
          invalidate();
        }
        AppMethodBeat.o(235800);
        return;
      }
    }
  }
  
  public Drawable getCheckedIcon()
  {
    if (this.byw != null) {
      return this.byw.bzd;
    }
    return null;
  }
  
  public ColorStateList getChipBackgroundColor()
  {
    if (this.byw != null) {
      return this.byw.byK;
    }
    return null;
  }
  
  public float getChipCornerRadius()
  {
    if (this.byw != null) {
      return this.byw.byM;
    }
    return 0.0F;
  }
  
  public Drawable getChipDrawable()
  {
    return this.byw;
  }
  
  public float getChipEndPadding()
  {
    if (this.byw != null) {
      return this.byw.bzn;
    }
    return 0.0F;
  }
  
  public Drawable getChipIcon()
  {
    AppMethodBeat.i(235842);
    if (this.byw != null)
    {
      Drawable localDrawable = this.byw.getChipIcon();
      AppMethodBeat.o(235842);
      return localDrawable;
    }
    AppMethodBeat.o(235842);
    return null;
  }
  
  public float getChipIconSize()
  {
    if (this.byw != null) {
      return this.byw.byV;
    }
    return 0.0F;
  }
  
  public ColorStateList getChipIconTint()
  {
    if (this.byw != null) {
      return this.byw.byU;
    }
    return null;
  }
  
  public float getChipMinHeight()
  {
    if (this.byw != null) {
      return this.byw.byL;
    }
    return 0.0F;
  }
  
  public float getChipStartPadding()
  {
    if (this.byw != null) {
      return this.byw.bzg;
    }
    return 0.0F;
  }
  
  public ColorStateList getChipStrokeColor()
  {
    if (this.byw != null) {
      return this.byw.byN;
    }
    return null;
  }
  
  public float getChipStrokeWidth()
  {
    if (this.byw != null) {
      return this.byw.byO;
    }
    return 0.0F;
  }
  
  @Deprecated
  public CharSequence getChipText()
  {
    AppMethodBeat.i(235824);
    CharSequence localCharSequence = getText();
    AppMethodBeat.o(235824);
    return localCharSequence;
  }
  
  public Drawable getCloseIcon()
  {
    AppMethodBeat.i(235864);
    if (this.byw != null)
    {
      Drawable localDrawable = this.byw.getCloseIcon();
      AppMethodBeat.o(235864);
      return localDrawable;
    }
    AppMethodBeat.o(235864);
    return null;
  }
  
  public CharSequence getCloseIconContentDescription()
  {
    if (this.byw != null) {
      return this.byw.bza;
    }
    return null;
  }
  
  public float getCloseIconEndPadding()
  {
    if (this.byw != null) {
      return this.byw.bzm;
    }
    return 0.0F;
  }
  
  public float getCloseIconSize()
  {
    if (this.byw != null) {
      return this.byw.byZ;
    }
    return 0.0F;
  }
  
  public float getCloseIconStartPadding()
  {
    if (this.byw != null) {
      return this.byw.bzl;
    }
    return 0.0F;
  }
  
  public ColorStateList getCloseIconTint()
  {
    if (this.byw != null) {
      return this.byw.byY;
    }
    return null;
  }
  
  public TextUtils.TruncateAt getEllipsize()
  {
    if (this.byw != null) {
      return this.byw.bzJ;
    }
    return null;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    AppMethodBeat.i(235793);
    if (this.byB == 0)
    {
      paramRect.set(getCloseIconTouchBoundsInt());
      AppMethodBeat.o(235793);
      return;
    }
    super.getFocusedRect(paramRect);
    AppMethodBeat.o(235793);
  }
  
  public h getHideMotionSpec()
  {
    if (this.byw != null) {
      return this.byw.bzf;
    }
    return null;
  }
  
  public float getIconEndPadding()
  {
    if (this.byw != null) {
      return this.byw.bzi;
    }
    return 0.0F;
  }
  
  public float getIconStartPadding()
  {
    if (this.byw != null) {
      return this.byw.bzh;
    }
    return 0.0F;
  }
  
  public ColorStateList getRippleColor()
  {
    if (this.byw != null) {
      return this.byw.byg;
    }
    return null;
  }
  
  public h getShowMotionSpec()
  {
    if (this.byw != null) {
      return this.byw.bze;
    }
    return null;
  }
  
  public CharSequence getText()
  {
    if (this.byw != null) {
      return this.byw.byP;
    }
    return "";
  }
  
  public float getTextEndPadding()
  {
    if (this.byw != null) {
      return this.byw.bzk;
    }
    return 0.0F;
  }
  
  public float getTextStartPadding()
  {
    if (this.byw != null) {
      return this.byw.bzj;
    }
    return 0.0F;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(235727);
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, byv);
    }
    AppMethodBeat.o(235727);
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(235729);
    if ((TextUtils.isEmpty(getText())) || (this.byw == null) || (this.byw.bzK))
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(235729);
      return;
    }
    int i = paramCanvas.save();
    a locala = this.byw;
    float f = getChipStartPadding();
    f = locala.wH() + f + getTextStartPadding();
    if (w.I(this) == 0) {}
    for (;;)
    {
      paramCanvas.translate(f, 0.0F);
      super.onDraw(paramCanvas);
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(235729);
      return;
      f = -f;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(235786);
    if (paramBoolean) {
      setFocusedVirtualView(-1);
    }
    for (;;)
    {
      invalidate();
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.byF.onFocusChanged(paramBoolean, paramInt, paramRect);
      AppMethodBeat.o(235786);
      return;
      setFocusedVirtualView(-2147483648);
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235780);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(235780);
      return bool;
      setCloseIconHovered(getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY()));
      continue;
      setCloseIconHovered(false);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    AppMethodBeat.i(235789);
    boolean bool1;
    switch (paramKeyEvent.getKeyCode())
    {
    default: 
      bool1 = bool2;
    }
    int i;
    for (;;)
    {
      if (bool1)
      {
        invalidate();
        AppMethodBeat.o(235789);
        return true;
        bool1 = bool2;
        if (paramKeyEvent.hasNoModifiers())
        {
          bool1 = bf(l.s(this));
          continue;
          bool1 = bool2;
          if (paramKeyEvent.hasNoModifiers())
          {
            bool1 = bool3;
            if (!l.s(this)) {
              bool1 = true;
            }
            bool1 = bf(bool1);
            continue;
            switch (this.byB)
            {
            default: 
              bool1 = bool2;
              break;
            case -1: 
              performClick();
              AppMethodBeat.o(235789);
              return true;
            case 0: 
              wz();
              AppMethodBeat.o(235789);
              return true;
              if (paramKeyEvent.hasNoModifiers()) {
                i = 2;
              }
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i == 0) {
        break;
      }
      ViewParent localViewParent = getParent();
      Object localObject = this;
      View localView;
      do
      {
        localView = ((View)localObject).focusSearch(i);
        if ((localView == null) || (localView == this)) {
          break;
        }
        localObject = localView;
      } while (localView.getParent() == localViewParent);
      bool1 = bool2;
      if (localView == null) {
        break;
      }
      localView.requestFocus();
      AppMethodBeat.o(235789);
      return true;
      if (paramKeyEvent.hasModifiers(1))
      {
        i = 1;
        continue;
        bool1 = super.onKeyDown(paramInt, paramKeyEvent);
        AppMethodBeat.o(235789);
        return bool1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  @TargetApi(24)
  public PointerIcon onResolvePointerIcon(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(235806);
    if ((getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (isEnabled()))
    {
      paramMotionEvent = PointerIcon.getSystemIcon(getContext(), 1002);
      AppMethodBeat.o(235806);
      return paramMotionEvent;
    }
    AppMethodBeat.o(235806);
    return null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(235778);
    int i = paramMotionEvent.getActionMasked();
    boolean bool = getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (i)
    {
    default: 
      i = 0;
    case 0: 
    case 2: 
    case 1: 
      for (;;)
      {
        if ((i != 0) || (super.onTouchEvent(paramMotionEvent)))
        {
          AppMethodBeat.o(235778);
          return true;
          if (!bool) {
            break;
          }
          setCloseIconPressed(true);
          i = 1;
          continue;
          if (!this.byC) {
            break;
          }
          if (!bool) {
            setCloseIconPressed(false);
          }
          i = 1;
          continue;
          if (!this.byC) {
            break label147;
          }
          wz();
        }
      }
    }
    label147:
    for (i = 1;; i = 0)
    {
      setCloseIconPressed(false);
      break;
      AppMethodBeat.o(235778);
      return false;
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(235738);
    if ((paramDrawable != this.byw) && (paramDrawable != this.byx))
    {
      paramDrawable = new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
      AppMethodBeat.o(235738);
      throw paramDrawable;
    }
    super.setBackground(paramDrawable);
    AppMethodBeat.o(235738);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(235734);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    AppMethodBeat.o(235734);
    throw localUnsupportedOperationException;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(235740);
    if ((paramDrawable != this.byw) && (paramDrawable != this.byx))
    {
      paramDrawable = new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
      AppMethodBeat.o(235740);
      throw paramDrawable;
    }
    super.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(235740);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(235736);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    AppMethodBeat.o(235736);
    throw localUnsupportedOperationException;
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235732);
    paramColorStateList = new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    AppMethodBeat.o(235732);
    throw paramColorStateList;
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(235733);
    paramMode = new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    AppMethodBeat.o(235733);
    throw paramMode;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(235879);
    if (this.byw != null) {
      this.byw.setCheckable(paramBoolean);
    }
    AppMethodBeat.o(235879);
  }
  
  public void setCheckableResource(int paramInt)
  {
    AppMethodBeat.i(235877);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setCheckable(locala.context.getResources().getBoolean(paramInt));
    }
    AppMethodBeat.o(235877);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(235776);
    if (this.byw == null)
    {
      this.byA = paramBoolean;
      AppMethodBeat.o(235776);
      return;
    }
    if (this.byw.bzb)
    {
      boolean bool = isChecked();
      super.setChecked(paramBoolean);
      if ((bool != paramBoolean) && (this.byz != null)) {
        this.byz.onCheckedChanged(this, paramBoolean);
      }
    }
    AppMethodBeat.o(235776);
  }
  
  public void setCheckedIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(235888);
    if (this.byw != null) {
      this.byw.setCheckedIcon(paramDrawable);
    }
    AppMethodBeat.o(235888);
  }
  
  @Deprecated
  public void setCheckedIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(235886);
    setCheckedIconVisible(paramBoolean);
    AppMethodBeat.o(235886);
  }
  
  @Deprecated
  public void setCheckedIconEnabledResource(int paramInt)
  {
    AppMethodBeat.i(235883);
    setCheckedIconVisible(paramInt);
    AppMethodBeat.o(235883);
  }
  
  public void setCheckedIconResource(int paramInt)
  {
    AppMethodBeat.i(235887);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setCheckedIcon(androidx.appcompat.a.a.a.m(locala.context, paramInt));
    }
    AppMethodBeat.o(235887);
  }
  
  public void setCheckedIconVisible(int paramInt)
  {
    AppMethodBeat.i(235880);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setCheckedIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
    AppMethodBeat.o(235880);
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(235881);
    if (this.byw != null) {
      this.byw.setCheckedIconVisible(paramBoolean);
    }
    AppMethodBeat.o(235881);
  }
  
  public void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235810);
    if (this.byw != null) {
      this.byw.setChipBackgroundColor(paramColorStateList);
    }
    AppMethodBeat.o(235810);
  }
  
  public void setChipBackgroundColorResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(235808);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipBackgroundColor(androidx.appcompat.a.a.a.l(locala.context, paramInt));
    }
    AppMethodBeat.o(235808);
  }
  
  public void setChipCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(235815);
    if (this.byw != null) {
      this.byw.setChipCornerRadius(paramFloat);
    }
    AppMethodBeat.o(235815);
  }
  
  public void setChipCornerRadiusResource(int paramInt)
  {
    AppMethodBeat.i(235813);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipCornerRadius(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235813);
  }
  
  public void setChipDrawable(a parama)
  {
    AppMethodBeat.i(235725);
    if (this.byw != parama)
    {
      a locala = this.byw;
      if (locala != null) {
        locala.a(null);
      }
      this.byw = parama;
      this.byw.a(this);
      if (com.google.android.material.f.a.bDy)
      {
        this.byx = new RippleDrawable(com.google.android.material.f.a.g(this.byw.byg), this.byw, null);
        this.byw.bg(false);
        w.a(this, this.byx);
        AppMethodBeat.o(235725);
        return;
      }
      this.byw.bg(true);
      w.a(this, this.byw);
    }
    AppMethodBeat.o(235725);
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    AppMethodBeat.i(235918);
    if (this.byw != null) {
      this.byw.setChipEndPadding(paramFloat);
    }
    AppMethodBeat.o(235918);
  }
  
  public void setChipEndPaddingResource(int paramInt)
  {
    AppMethodBeat.i(235916);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipEndPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235916);
  }
  
  public void setChipIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(235846);
    if (this.byw != null) {
      this.byw.setChipIcon(paramDrawable);
    }
    AppMethodBeat.o(235846);
  }
  
  @Deprecated
  public void setChipIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(235840);
    setChipIconVisible(paramBoolean);
    AppMethodBeat.o(235840);
  }
  
  @Deprecated
  public void setChipIconEnabledResource(int paramInt)
  {
    AppMethodBeat.i(235839);
    setChipIconVisible(paramInt);
    AppMethodBeat.o(235839);
  }
  
  public void setChipIconResource(int paramInt)
  {
    AppMethodBeat.i(235844);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipIcon(androidx.appcompat.a.a.a.m(locala.context, paramInt));
    }
    AppMethodBeat.o(235844);
  }
  
  public void setChipIconSize(float paramFloat)
  {
    AppMethodBeat.i(235854);
    if (this.byw != null) {
      this.byw.setChipIconSize(paramFloat);
    }
    AppMethodBeat.o(235854);
  }
  
  public void setChipIconSizeResource(int paramInt)
  {
    AppMethodBeat.i(235853);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipIconSize(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235853);
  }
  
  public void setChipIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235851);
    if (this.byw != null) {
      this.byw.setChipIconTint(paramColorStateList);
    }
    AppMethodBeat.o(235851);
  }
  
  public void setChipIconTintResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(235849);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipIconTint(androidx.appcompat.a.a.a.l(locala.context, paramInt));
    }
    AppMethodBeat.o(235849);
  }
  
  public void setChipIconVisible(int paramInt)
  {
    AppMethodBeat.i(235836);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
    AppMethodBeat.o(235836);
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(235838);
    if (this.byw != null) {
      this.byw.setChipIconVisible(paramBoolean);
    }
    AppMethodBeat.o(235838);
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    AppMethodBeat.i(235812);
    if (this.byw != null) {
      this.byw.setChipMinHeight(paramFloat);
    }
    AppMethodBeat.o(235812);
  }
  
  public void setChipMinHeightResource(int paramInt)
  {
    AppMethodBeat.i(235811);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipMinHeight(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235811);
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    AppMethodBeat.i(235896);
    if (this.byw != null) {
      this.byw.setChipStartPadding(paramFloat);
    }
    AppMethodBeat.o(235896);
  }
  
  public void setChipStartPaddingResource(int paramInt)
  {
    AppMethodBeat.i(235895);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipStartPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235895);
  }
  
  public void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235818);
    if (this.byw != null) {
      this.byw.setChipStrokeColor(paramColorStateList);
    }
    AppMethodBeat.o(235818);
  }
  
  public void setChipStrokeColorResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(235817);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipStrokeColor(androidx.appcompat.a.a.a.l(locala.context, paramInt));
    }
    AppMethodBeat.o(235817);
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(235820);
    if (this.byw != null) {
      this.byw.setChipStrokeWidth(paramFloat);
    }
    AppMethodBeat.o(235820);
  }
  
  public void setChipStrokeWidthResource(int paramInt)
  {
    AppMethodBeat.i(235819);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setChipStrokeWidth(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235819);
  }
  
  @Deprecated
  public void setChipText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(235827);
    setText(paramCharSequence);
    AppMethodBeat.o(235827);
  }
  
  @Deprecated
  public void setChipTextResource(int paramInt)
  {
    AppMethodBeat.i(235826);
    setText(getResources().getString(paramInt));
    AppMethodBeat.o(235826);
  }
  
  public void setCloseIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(235867);
    if (this.byw != null) {
      this.byw.setCloseIcon(paramDrawable);
    }
    AppMethodBeat.o(235867);
  }
  
  public void setCloseIconContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(235875);
    if (this.byw != null)
    {
      a locala = this.byw;
      if (locala.bza != paramCharSequence)
      {
        locala.bza = androidx.core.e.a.gI().p(paramCharSequence);
        locala.invalidateSelf();
      }
    }
    AppMethodBeat.o(235875);
  }
  
  @Deprecated
  public void setCloseIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(235862);
    setCloseIconVisible(paramBoolean);
    AppMethodBeat.o(235862);
  }
  
  @Deprecated
  public void setCloseIconEnabledResource(int paramInt)
  {
    AppMethodBeat.i(235860);
    setCloseIconVisible(paramInt);
    AppMethodBeat.o(235860);
  }
  
  public void setCloseIconEndPadding(float paramFloat)
  {
    AppMethodBeat.i(235915);
    if (this.byw != null) {
      this.byw.setCloseIconEndPadding(paramFloat);
    }
    AppMethodBeat.o(235915);
  }
  
  public void setCloseIconEndPaddingResource(int paramInt)
  {
    AppMethodBeat.i(235914);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setCloseIconEndPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235914);
  }
  
  public void setCloseIconResource(int paramInt)
  {
    AppMethodBeat.i(235865);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setCloseIcon(androidx.appcompat.a.a.a.m(locala.context, paramInt));
    }
    AppMethodBeat.o(235865);
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    AppMethodBeat.i(235873);
    if (this.byw != null) {
      this.byw.setCloseIconSize(paramFloat);
    }
    AppMethodBeat.o(235873);
  }
  
  public void setCloseIconSizeResource(int paramInt)
  {
    AppMethodBeat.i(235872);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setCloseIconSize(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235872);
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    AppMethodBeat.i(235912);
    if (this.byw != null) {
      this.byw.setCloseIconStartPadding(paramFloat);
    }
    AppMethodBeat.o(235912);
  }
  
  public void setCloseIconStartPaddingResource(int paramInt)
  {
    AppMethodBeat.i(235911);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setCloseIconStartPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235911);
  }
  
  public void setCloseIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235871);
    if (this.byw != null) {
      this.byw.setCloseIconTint(paramColorStateList);
    }
    AppMethodBeat.o(235871);
  }
  
  public void setCloseIconTintResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(235869);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setCloseIconTint(androidx.appcompat.a.a.a.l(locala.context, paramInt));
    }
    AppMethodBeat.o(235869);
  }
  
  public void setCloseIconVisible(int paramInt)
  {
    AppMethodBeat.i(235856);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setCloseIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
    AppMethodBeat.o(235856);
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(235858);
    if (this.byw != null) {
      this.byw.setCloseIconVisible(paramBoolean);
    }
    AppMethodBeat.o(235858);
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    AppMethodBeat.i(235743);
    if (paramDrawable1 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      AppMethodBeat.o(235743);
      throw paramDrawable1;
    }
    if (paramDrawable3 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      AppMethodBeat.o(235743);
      throw paramDrawable1;
    }
    super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppMethodBeat.o(235743);
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    AppMethodBeat.i(235753);
    if (paramDrawable1 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      AppMethodBeat.o(235753);
      throw paramDrawable1;
    }
    if (paramDrawable3 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      AppMethodBeat.o(235753);
      throw paramDrawable1;
    }
    super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppMethodBeat.o(235753);
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235755);
    UnsupportedOperationException localUnsupportedOperationException;
    if (paramInt1 != 0)
    {
      localUnsupportedOperationException = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      AppMethodBeat.o(235755);
      throw localUnsupportedOperationException;
    }
    if (paramInt3 != 0)
    {
      localUnsupportedOperationException = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      AppMethodBeat.o(235755);
      throw localUnsupportedOperationException;
    }
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(235755);
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    AppMethodBeat.i(235758);
    if (paramDrawable1 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      AppMethodBeat.o(235758);
      throw paramDrawable1;
    }
    if (paramDrawable3 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      AppMethodBeat.o(235758);
      throw paramDrawable1;
    }
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppMethodBeat.o(235758);
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235747);
    UnsupportedOperationException localUnsupportedOperationException;
    if (paramInt1 != 0)
    {
      localUnsupportedOperationException = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      AppMethodBeat.o(235747);
      throw localUnsupportedOperationException;
    }
    if (paramInt3 != 0)
    {
      localUnsupportedOperationException = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      AppMethodBeat.o(235747);
      throw localUnsupportedOperationException;
    }
    super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(235747);
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    AppMethodBeat.i(235750);
    if (paramDrawable1 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
      AppMethodBeat.o(235750);
      throw paramDrawable1;
    }
    if (paramDrawable3 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
      AppMethodBeat.o(235750);
      throw paramDrawable1;
    }
    super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppMethodBeat.o(235750);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(235761);
    if (this.byw == null)
    {
      AppMethodBeat.o(235761);
      return;
    }
    if (paramTruncateAt == TextUtils.TruncateAt.MARQUEE)
    {
      paramTruncateAt = new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
      AppMethodBeat.o(235761);
      throw paramTruncateAt;
    }
    super.setEllipsize(paramTruncateAt);
    if (this.byw != null) {
      this.byw.bzJ = paramTruncateAt;
    }
    AppMethodBeat.o(235761);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(235731);
    if (paramInt == 8388627) {
      super.setGravity(paramInt);
    }
    AppMethodBeat.o(235731);
  }
  
  public void setHideMotionSpec(h paramh)
  {
    if (this.byw != null) {
      this.byw.bzf = paramh;
    }
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    AppMethodBeat.i(235893);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.bzf = h.y(locala.context, paramInt);
    }
    AppMethodBeat.o(235893);
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    AppMethodBeat.i(235902);
    if (this.byw != null) {
      this.byw.setIconEndPadding(paramFloat);
    }
    AppMethodBeat.o(235902);
  }
  
  public void setIconEndPaddingResource(int paramInt)
  {
    AppMethodBeat.i(235900);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setIconEndPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235900);
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    AppMethodBeat.i(235898);
    if (this.byw != null) {
      this.byw.setIconStartPadding(paramFloat);
    }
    AppMethodBeat.o(235898);
  }
  
  public void setIconStartPaddingResource(int paramInt)
  {
    AppMethodBeat.i(235897);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setIconStartPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235897);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(235765);
    if (paramInt > 1)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
      AppMethodBeat.o(235765);
      throw localUnsupportedOperationException;
    }
    super.setLines(paramInt);
    AppMethodBeat.o(235765);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(235769);
    if (paramInt > 1)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
      AppMethodBeat.o(235769);
      throw localUnsupportedOperationException;
    }
    super.setMaxLines(paramInt);
    AppMethodBeat.o(235769);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(235771);
    super.setMaxWidth(paramInt);
    if (this.byw != null) {
      this.byw.maxWidth = paramInt;
    }
    AppMethodBeat.o(235771);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(235767);
    if (paramInt > 1)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
      AppMethodBeat.o(235767);
      throw localUnsupportedOperationException;
    }
    super.setMinLines(paramInt);
    AppMethodBeat.o(235767);
  }
  
  void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.byz = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.byy = paramOnClickListener;
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235822);
    if (this.byw != null) {
      this.byw.setRippleColor(paramColorStateList);
    }
    AppMethodBeat.o(235822);
  }
  
  public void setRippleColorResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(235821);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setRippleColor(androidx.appcompat.a.a.a.l(locala.context, paramInt));
    }
    AppMethodBeat.o(235821);
  }
  
  public void setShowMotionSpec(h paramh)
  {
    if (this.byw != null) {
      this.byw.bze = paramh;
    }
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    AppMethodBeat.i(235890);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.bze = h.y(locala.context, paramInt);
    }
    AppMethodBeat.o(235890);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(235763);
    if (!paramBoolean)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
      AppMethodBeat.o(235763);
      throw localUnsupportedOperationException;
    }
    super.setSingleLine(paramBoolean);
    AppMethodBeat.o(235763);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(235825);
    if (this.byw == null)
    {
      AppMethodBeat.o(235825);
      return;
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    paramCharSequence = androidx.core.e.a.gI().p((CharSequence)localObject);
    if (this.byw.bzK) {
      paramCharSequence = null;
    }
    super.setText(paramCharSequence, paramBufferType);
    if (this.byw != null) {
      this.byw.setText((CharSequence)localObject);
    }
    AppMethodBeat.o(235825);
  }
  
  public void setTextAppearance(int paramInt)
  {
    AppMethodBeat.i(235834);
    super.setTextAppearance(paramInt);
    if (this.byw != null) {
      this.byw.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(getContext(), getPaint(), this.byH);
      a(getTextAppearance());
    }
    AppMethodBeat.o(235834);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(235832);
    super.setTextAppearance(paramContext, paramInt);
    if (this.byw != null) {
      this.byw.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(paramContext, getPaint(), this.byH);
      a(getTextAppearance());
    }
    AppMethodBeat.o(235832);
  }
  
  public void setTextAppearance(b paramb)
  {
    AppMethodBeat.i(235831);
    if (this.byw != null) {
      this.byw.setTextAppearance(paramb);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(getContext(), getPaint(), this.byH);
      a(paramb);
    }
    AppMethodBeat.o(235831);
  }
  
  public void setTextAppearanceResource(int paramInt)
  {
    AppMethodBeat.i(235830);
    if (this.byw != null) {
      this.byw.setTextAppearanceResource(paramInt);
    }
    setTextAppearance(getContext(), paramInt);
    AppMethodBeat.o(235830);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    AppMethodBeat.i(235910);
    if (this.byw != null) {
      this.byw.setTextEndPadding(paramFloat);
    }
    AppMethodBeat.o(235910);
  }
  
  public void setTextEndPaddingResource(int paramInt)
  {
    AppMethodBeat.i(235909);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setTextEndPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235909);
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    AppMethodBeat.i(235906);
    if (this.byw != null) {
      this.byw.setTextStartPadding(paramFloat);
    }
    AppMethodBeat.o(235906);
  }
  
  public void setTextStartPaddingResource(int paramInt)
  {
    AppMethodBeat.i(235904);
    if (this.byw != null)
    {
      a locala = this.byw;
      locala.setTextStartPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(235904);
  }
  
  public final void wy()
  {
    AppMethodBeat.i(235773);
    wx();
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
    AppMethodBeat.o(235773);
  }
  
  public final boolean wz()
  {
    AppMethodBeat.i(235777);
    playSoundEffect(0);
    if (this.byy != null) {
      this.byy.onClick(this);
    }
    for (boolean bool = true;; bool = false)
    {
      this.byF.sendEventForVirtualView(0, 1);
      AppMethodBeat.o(235777);
      return bool;
    }
  }
  
  final class a
    extends androidx.customview.a.a
  {
    a(Chip paramChip)
    {
      super();
    }
    
    public final int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      AppMethodBeat.i(235698);
      if ((Chip.b(Chip.this)) && (Chip.c(Chip.this).contains(paramFloat1, paramFloat2)))
      {
        AppMethodBeat.o(235698);
        return 0;
      }
      AppMethodBeat.o(235698);
      return -1;
    }
    
    public final void getVisibleVirtualViews(List<Integer> paramList)
    {
      AppMethodBeat.i(235700);
      if (Chip.b(Chip.this)) {
        paramList.add(Integer.valueOf(0));
      }
      AppMethodBeat.o(235700);
    }
    
    public final boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      AppMethodBeat.i(235705);
      if ((paramInt2 == 16) && (paramInt1 == 0))
      {
        boolean bool = Chip.this.wz();
        AppMethodBeat.o(235705);
        return bool;
      }
      AppMethodBeat.o(235705);
      return false;
    }
    
    public final void onPopulateNodeForHost(d paramd)
    {
      AppMethodBeat.i(235703);
      if ((Chip.a(Chip.this) != null) && (Chip.a(Chip.this).bzb)) {}
      CharSequence localCharSequence;
      for (boolean bool = true;; bool = false)
      {
        paramd.setCheckable(bool);
        paramd.t(Chip.class.getName());
        localCharSequence = Chip.this.getText();
        if (Build.VERSION.SDK_INT < 23) {
          break;
        }
        paramd.setText(localCharSequence);
        AppMethodBeat.o(235703);
        return;
      }
      paramd.setContentDescription(localCharSequence);
      AppMethodBeat.o(235703);
    }
    
    public final void onPopulateNodeForVirtualView(int paramInt, d paramd)
    {
      AppMethodBeat.i(235702);
      if (Chip.b(Chip.this))
      {
        Object localObject = Chip.this.getCloseIconContentDescription();
        if (localObject != null)
        {
          paramd.setContentDescription((CharSequence)localObject);
          paramd.f(Chip.d(Chip.this));
          paramd.a(d.a.OD);
          paramd.setEnabled(Chip.this.isEnabled());
          AppMethodBeat.o(235702);
          return;
        }
        localObject = Chip.this.getText();
        Context localContext = Chip.this.getContext();
        paramInt = a.i.mtrl_chip_close_icon_content_description;
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        for (;;)
        {
          paramd.setContentDescription(localContext.getString(paramInt, new Object[] { localObject }).trim());
          break;
          localObject = "";
        }
      }
      paramd.setContentDescription("");
      paramd.f(Chip.wC());
      AppMethodBeat.o(235702);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.chip.Chip
 * JD-Core Version:    0.7.0.1
 */