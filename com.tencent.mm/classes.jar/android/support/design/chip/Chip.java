package android.support.design.chip;

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
import android.support.design.a.h;
import android.support.design.d.b;
import android.support.design.internal.g;
import android.support.v4.content.a.f.a;
import android.support.v4.view.a.c;
import android.support.v4.view.a.c.a;
import android.support.v4.view.t;
import android.support.v4.widget.j;
import android.support.v7.widget.AppCompatCheckBox;
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
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView.BufferType;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class Chip
  extends AppCompatCheckBox
  implements a.a
{
  private static final Rect hX = new Rect();
  private static final int[] hY = { 16842913 };
  private final RectF hM = new RectF();
  private a hZ;
  private RippleDrawable ia;
  private View.OnClickListener ib;
  private CompoundButton.OnCheckedChangeListener ic;
  private boolean ie;
  private int jdField_if = -2147483648;
  private boolean ig;
  private boolean ih;
  private boolean ii;
  private final a ij;
  private final f.a ik = new f.a()
  {
    public final void D(int paramAnonymousInt) {}
    
    public final void a(Typeface paramAnonymousTypeface)
    {
      Chip.this.setText(Chip.this.getText());
      Chip.this.requestLayout();
      Chip.this.invalidate();
    }
  };
  private final Rect rect = new Rect();
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130968769);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (paramAttributeSet != null)
    {
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
        throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      }
      if ((!paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true)) || (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1) || (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1) || (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1)) {
        throw new UnsupportedOperationException("Chip does not support multi-line text");
      }
      paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
    }
    paramContext = a.a(paramContext, paramAttributeSet, paramInt);
    setChipDrawable(paramContext);
    this.ij = new a(this);
    t.a(this, this.ij);
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new ViewOutlineProvider()
      {
        @TargetApi(21)
        public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
        {
          if (Chip.a(Chip.this) != null)
          {
            Chip.a(Chip.this).getOutline(paramAnonymousOutline);
            return;
          }
          paramAnonymousOutline.setAlpha(0.0F);
        }
      });
    }
    setChecked(this.ie);
    paramContext.jq = false;
    setText(paramContext.iu);
    setEllipsize(paramContext.jp);
    setIncludeFontPadding(false);
    if (getTextAppearance() != null) {
      a(getTextAppearance());
    }
    setSingleLine();
    setGravity(8388627);
    bd();
  }
  
  private void a(b paramb)
  {
    TextPaint localTextPaint = getPaint();
    localTextPaint.drawableState = this.hZ.getState();
    paramb.b(getContext(), localTextPaint, this.ik);
  }
  
  private void bd()
  {
    if ((TextUtils.isEmpty(getText())) || (this.hZ == null)) {}
    float f2;
    do
    {
      return;
      f2 = this.hZ.iM + this.hZ.iT + this.hZ.iP + this.hZ.iQ;
      float f1;
      if ((!this.hZ.iy) || (this.hZ.getChipIcon() == null))
      {
        f1 = f2;
        if (this.hZ.iJ != null)
        {
          f1 = f2;
          if (this.hZ.iI)
          {
            f1 = f2;
            if (!isChecked()) {}
          }
        }
      }
      else
      {
        f1 = f2 + (this.hZ.iN + this.hZ.iO + this.hZ.iB);
      }
      f2 = f1;
      if (this.hZ.iC)
      {
        f2 = f1;
        if (this.hZ.getCloseIcon() != null) {
          f2 = f1 + (this.hZ.iR + this.hZ.iS + this.hZ.iF);
        }
      }
    } while (t.ac(this) == f2);
    t.d(this, t.ab(this), getPaddingTop(), (int)f2, getPaddingBottom());
  }
  
  private void bg()
  {
    if (this.jdField_if == -2147483648) {
      setFocusedVirtualView(-1);
    }
  }
  
  private boolean bh()
  {
    return (this.hZ != null) && (this.hZ.getCloseIcon() != null);
  }
  
  @SuppressLint({"PrivateApi"})
  private boolean d(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 10) {}
    try
    {
      paramMotionEvent = j.class.getDeclaredField("mHoveredVirtualViewId");
      paramMotionEvent.setAccessible(true);
      if (((Integer)paramMotionEvent.get(this.ij)).intValue() != -2147483648)
      {
        paramMotionEvent = j.class.getDeclaredMethod("updateHoveredVirtualView", new Class[] { Integer.TYPE });
        paramMotionEvent.setAccessible(true);
        paramMotionEvent.invoke(this.ij, new Object[] { Integer.valueOf(-2147483648) });
        return true;
      }
    }
    catch (NoSuchFieldException paramMotionEvent)
    {
      return false;
    }
    catch (InvocationTargetException paramMotionEvent)
    {
      break label92;
    }
    catch (IllegalAccessException paramMotionEvent)
    {
      break label92;
    }
    catch (NoSuchMethodException paramMotionEvent)
    {
      label92:
      break label92;
    }
  }
  
  private RectF getCloseIconTouchBounds()
  {
    this.hM.setEmpty();
    if (bh())
    {
      a locala = this.hZ;
      RectF localRectF = this.hM;
      locala.c(locala.getBounds(), localRectF);
    }
    return this.hM;
  }
  
  private Rect getCloseIconTouchBoundsInt()
  {
    RectF localRectF = getCloseIconTouchBounds();
    this.rect.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    return this.rect;
  }
  
  private b getTextAppearance()
  {
    if (this.hZ != null) {
      return this.hZ.ix;
    }
    return null;
  }
  
  private boolean n(boolean paramBoolean)
  {
    bg();
    if (paramBoolean)
    {
      if (this.jdField_if == -1)
      {
        setFocusedVirtualView(0);
        return true;
      }
    }
    else if (this.jdField_if == 0)
    {
      setFocusedVirtualView(-1);
      return true;
    }
    return false;
  }
  
  private void setCloseIconFocused(boolean paramBoolean)
  {
    if (this.ii != paramBoolean)
    {
      this.ii = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconHovered(boolean paramBoolean)
  {
    if (this.ih != paramBoolean)
    {
      this.ih = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconPressed(boolean paramBoolean)
  {
    if (this.ig != paramBoolean)
    {
      this.ig = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setFocusedVirtualView(int paramInt)
  {
    if (this.jdField_if != paramInt)
    {
      if (this.jdField_if == 0) {
        setCloseIconFocused(false);
      }
      this.jdField_if = paramInt;
      if (paramInt == 0) {
        setCloseIconFocused(true);
      }
    }
  }
  
  public final void be()
  {
    bd();
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
  }
  
  public final boolean bf()
  {
    playSoundEffect(0);
    if (this.ib != null) {
      this.ib.onClick(this);
    }
    for (boolean bool = true;; bool = false)
    {
      this.ij.sendEventForVirtualView(0, 1);
      return bool;
    }
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    return (d(paramMotionEvent)) || (this.ij.dispatchHoverEvent(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this.ij.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  protected void drawableStateChanged()
  {
    int k = 1;
    boolean bool2 = false;
    super.drawableStateChanged();
    boolean bool1 = bool2;
    a locala;
    if (this.hZ != null)
    {
      bool1 = bool2;
      if (a.b(this.hZ.iD))
      {
        locala = this.hZ;
        if (!isEnabled()) {
          break label222;
        }
      }
    }
    label222:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.ii) {
        i = j + 1;
      }
      j = i;
      if (this.ih) {
        j = i + 1;
      }
      i = j;
      if (this.ig) {
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
        if (this.ii)
        {
          arrayOfInt[j] = 16842908;
          i = j + 1;
        }
        j = i;
        if (this.ih)
        {
          arrayOfInt[i] = 16843623;
          j = i + 1;
        }
        i = j;
        if (this.ig)
        {
          arrayOfInt[j] = 16842919;
          i = j + 1;
        }
        if (isChecked()) {
          arrayOfInt[i] = 16842913;
        }
        bool1 = locala.b(arrayOfInt);
        if (bool1) {
          invalidate();
        }
        return;
      }
    }
  }
  
  public Drawable getCheckedIcon()
  {
    if (this.hZ != null) {
      return this.hZ.iJ;
    }
    return null;
  }
  
  public ColorStateList getChipBackgroundColor()
  {
    if (this.hZ != null) {
      return this.hZ.io;
    }
    return null;
  }
  
  public float getChipCornerRadius()
  {
    if (this.hZ != null) {
      return this.hZ.ir;
    }
    return 0.0F;
  }
  
  public Drawable getChipDrawable()
  {
    return this.hZ;
  }
  
  public float getChipEndPadding()
  {
    if (this.hZ != null) {
      return this.hZ.iT;
    }
    return 0.0F;
  }
  
  public Drawable getChipIcon()
  {
    if (this.hZ != null) {
      return this.hZ.getChipIcon();
    }
    return null;
  }
  
  public float getChipIconSize()
  {
    if (this.hZ != null) {
      return this.hZ.iB;
    }
    return 0.0F;
  }
  
  public ColorStateList getChipIconTint()
  {
    if (this.hZ != null) {
      return this.hZ.iA;
    }
    return null;
  }
  
  public float getChipMinHeight()
  {
    if (this.hZ != null) {
      return this.hZ.iq;
    }
    return 0.0F;
  }
  
  public float getChipStartPadding()
  {
    if (this.hZ != null) {
      return this.hZ.iM;
    }
    return 0.0F;
  }
  
  public ColorStateList getChipStrokeColor()
  {
    if (this.hZ != null) {
      return this.hZ.is;
    }
    return null;
  }
  
  public float getChipStrokeWidth()
  {
    if (this.hZ != null) {
      return this.hZ.it;
    }
    return 0.0F;
  }
  
  @Deprecated
  public CharSequence getChipText()
  {
    return getText();
  }
  
  public Drawable getCloseIcon()
  {
    if (this.hZ != null) {
      return this.hZ.getCloseIcon();
    }
    return null;
  }
  
  public CharSequence getCloseIconContentDescription()
  {
    if (this.hZ != null) {
      return this.hZ.iG;
    }
    return null;
  }
  
  public float getCloseIconEndPadding()
  {
    if (this.hZ != null) {
      return this.hZ.iS;
    }
    return 0.0F;
  }
  
  public float getCloseIconSize()
  {
    if (this.hZ != null) {
      return this.hZ.iF;
    }
    return 0.0F;
  }
  
  public float getCloseIconStartPadding()
  {
    if (this.hZ != null) {
      return this.hZ.iR;
    }
    return 0.0F;
  }
  
  public ColorStateList getCloseIconTint()
  {
    if (this.hZ != null) {
      return this.hZ.iE;
    }
    return null;
  }
  
  public TextUtils.TruncateAt getEllipsize()
  {
    if (this.hZ != null) {
      return this.hZ.jp;
    }
    return null;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    if (this.jdField_if == 0)
    {
      paramRect.set(getCloseIconTouchBoundsInt());
      return;
    }
    super.getFocusedRect(paramRect);
  }
  
  public h getHideMotionSpec()
  {
    if (this.hZ != null) {
      return this.hZ.iL;
    }
    return null;
  }
  
  public float getIconEndPadding()
  {
    if (this.hZ != null) {
      return this.hZ.iO;
    }
    return 0.0F;
  }
  
  public float getIconStartPadding()
  {
    if (this.hZ != null) {
      return this.hZ.iN;
    }
    return 0.0F;
  }
  
  public ColorStateList getRippleColor()
  {
    if (this.hZ != null) {
      return this.hZ.hJ;
    }
    return null;
  }
  
  public h getShowMotionSpec()
  {
    if (this.hZ != null) {
      return this.hZ.iK;
    }
    return null;
  }
  
  public CharSequence getText()
  {
    if (this.hZ != null) {
      return this.hZ.iu;
    }
    return "";
  }
  
  public float getTextEndPadding()
  {
    if (this.hZ != null) {
      return this.hZ.iQ;
    }
    return 0.0F;
  }
  
  public float getTextStartPadding()
  {
    if (this.hZ != null) {
      return this.hZ.iP;
    }
    return 0.0F;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, hY);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((TextUtils.isEmpty(getText())) || (this.hZ == null) || (this.hZ.jq))
    {
      super.onDraw(paramCanvas);
      return;
    }
    int i = paramCanvas.save();
    a locala = this.hZ;
    float f = getChipStartPadding();
    f = locala.bn() + f + getTextStartPadding();
    if (t.Y(this) == 0) {}
    for (;;)
    {
      paramCanvas.translate(f, 0.0F);
      super.onDraw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
      f = -f;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    if (paramBoolean) {
      setFocusedVirtualView(-1);
    }
    for (;;)
    {
      invalidate();
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.ij.onFocusChanged(paramBoolean, paramInt, paramRect);
      return;
      setFocusedVirtualView(-2147483648);
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return super.onHoverEvent(paramMotionEvent);
      setCloseIconHovered(getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY()));
      continue;
      setCloseIconHovered(false);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    boolean bool3 = false;
    boolean bool2 = false;
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
        return true;
        bool1 = bool2;
        if (paramKeyEvent.hasNoModifiers())
        {
          bool1 = n(g.d(this));
          continue;
          bool1 = bool2;
          if (paramKeyEvent.hasNoModifiers())
          {
            bool1 = bool3;
            if (!g.d(this)) {
              bool1 = true;
            }
            bool1 = n(bool1);
            continue;
            switch (this.jdField_if)
            {
            default: 
              bool1 = bool2;
              break;
            case -1: 
              performClick();
              return true;
            case 0: 
              bf();
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
      return true;
      if (paramKeyEvent.hasModifiers(1))
      {
        i = 1;
        continue;
        return super.onKeyDown(paramInt, paramKeyEvent);
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
    if ((getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (isEnabled())) {
      return PointerIcon.getSystemIcon(getContext(), 1002);
    }
    return null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = false;
    int i = paramMotionEvent.getActionMasked();
    boolean bool2 = getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (i)
    {
    default: 
      i = 0;
    case 0: 
    case 2: 
      for (;;)
      {
        if ((i != 0) || (super.onTouchEvent(paramMotionEvent))) {
          bool1 = true;
        }
        return bool1;
        if (!bool2) {
          break;
        }
        setCloseIconPressed(true);
        i = 1;
        continue;
        if (!this.ig) {
          break;
        }
        if (!bool2) {
          setCloseIconPressed(false);
        }
        i = 1;
      }
    case 1: 
      if (this.ig) {
        bf();
      }
      break;
    }
    for (i = 1;; i = 0)
    {
      setCloseIconPressed(false);
      break;
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    if ((paramDrawable != this.hZ) && (paramDrawable != this.ia)) {
      throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
    }
    super.setBackground(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if ((paramDrawable != this.hZ) && (paramDrawable != this.ia)) {
      throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
    }
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    if (this.hZ != null) {
      this.hZ.setCheckable(paramBoolean);
    }
  }
  
  public void setCheckableResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setCheckable(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.hZ == null) {
      this.ie = paramBoolean;
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!this.hZ.iH);
      bool = isChecked();
      super.setChecked(paramBoolean);
    } while ((bool == paramBoolean) || (this.ic == null));
    this.ic.onCheckedChanged(this, paramBoolean);
  }
  
  public void setCheckedIcon(Drawable paramDrawable)
  {
    if (this.hZ != null) {
      this.hZ.setCheckedIcon(paramDrawable);
    }
  }
  
  @Deprecated
  public void setCheckedIconEnabled(boolean paramBoolean)
  {
    setCheckedIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCheckedIconEnabledResource(int paramInt)
  {
    setCheckedIconVisible(paramInt);
  }
  
  public void setCheckedIconResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setCheckedIcon(android.support.v7.c.a.a.l(locala.context, paramInt));
    }
  }
  
  public void setCheckedIconVisible(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setCheckedIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    if (this.hZ != null) {
      this.hZ.setCheckedIconVisible(paramBoolean);
    }
  }
  
  public void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    if (this.hZ != null) {
      this.hZ.setChipBackgroundColor(paramColorStateList);
    }
  }
  
  public void setChipBackgroundColorResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipBackgroundColor(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setChipCornerRadius(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setChipCornerRadius(paramFloat);
    }
  }
  
  public void setChipCornerRadiusResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipCornerRadius(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipDrawable(a parama)
  {
    if (this.hZ != parama)
    {
      a locala = this.hZ;
      if (locala != null) {
        locala.a(null);
      }
      this.hZ = parama;
      this.hZ.a(this);
      if (android.support.design.e.a.lF)
      {
        this.ia = new RippleDrawable(android.support.design.e.a.b(this.hZ.hJ), this.hZ, null);
        this.hZ.o(false);
        t.a(this, this.ia);
      }
    }
    else
    {
      return;
    }
    this.hZ.o(true);
    t.a(this, this.hZ);
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setChipEndPadding(paramFloat);
    }
  }
  
  public void setChipEndPaddingResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipIcon(Drawable paramDrawable)
  {
    if (this.hZ != null) {
      this.hZ.setChipIcon(paramDrawable);
    }
  }
  
  @Deprecated
  public void setChipIconEnabled(boolean paramBoolean)
  {
    setChipIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setChipIconEnabledResource(int paramInt)
  {
    setChipIconVisible(paramInt);
  }
  
  public void setChipIconResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipIcon(android.support.v7.c.a.a.l(locala.context, paramInt));
    }
  }
  
  public void setChipIconSize(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setChipIconSize(paramFloat);
    }
  }
  
  public void setChipIconSizeResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipIconSize(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipIconTint(ColorStateList paramColorStateList)
  {
    if (this.hZ != null) {
      this.hZ.setChipIconTint(paramColorStateList);
    }
  }
  
  public void setChipIconTintResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipIconTint(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setChipIconVisible(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    if (this.hZ != null) {
      this.hZ.setChipIconVisible(paramBoolean);
    }
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setChipMinHeight(paramFloat);
    }
  }
  
  public void setChipMinHeightResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipMinHeight(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setChipStartPadding(paramFloat);
    }
  }
  
  public void setChipStartPaddingResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipStartPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    if (this.hZ != null) {
      this.hZ.setChipStrokeColor(paramColorStateList);
    }
  }
  
  public void setChipStrokeColorResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipStrokeColor(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setChipStrokeWidth(paramFloat);
    }
  }
  
  public void setChipStrokeWidthResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setChipStrokeWidth(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  @Deprecated
  public void setChipText(CharSequence paramCharSequence)
  {
    setText(paramCharSequence);
  }
  
  @Deprecated
  public void setChipTextResource(int paramInt)
  {
    setText(getResources().getString(paramInt));
  }
  
  public void setCloseIcon(Drawable paramDrawable)
  {
    if (this.hZ != null) {
      this.hZ.setCloseIcon(paramDrawable);
    }
  }
  
  public void setCloseIconContentDescription(CharSequence paramCharSequence)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      if (locala.iG != paramCharSequence)
      {
        locala.iG = android.support.v4.d.a.fb().unicodeWrap(paramCharSequence);
        locala.invalidateSelf();
      }
    }
  }
  
  @Deprecated
  public void setCloseIconEnabled(boolean paramBoolean)
  {
    setCloseIconVisible(paramBoolean);
  }
  
  @Deprecated
  public void setCloseIconEnabledResource(int paramInt)
  {
    setCloseIconVisible(paramInt);
  }
  
  public void setCloseIconEndPadding(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setCloseIconEndPadding(paramFloat);
    }
  }
  
  public void setCloseIconEndPaddingResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setCloseIconEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setCloseIconResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setCloseIcon(android.support.v7.c.a.a.l(locala.context, paramInt));
    }
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setCloseIconSize(paramFloat);
    }
  }
  
  public void setCloseIconSizeResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setCloseIconSize(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setCloseIconStartPadding(paramFloat);
    }
  }
  
  public void setCloseIconStartPaddingResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setCloseIconStartPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setCloseIconTint(ColorStateList paramColorStateList)
  {
    if (this.hZ != null) {
      this.hZ.setCloseIconTint(paramColorStateList);
    }
  }
  
  public void setCloseIconTintResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setCloseIconTint(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setCloseIconVisible(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setCloseIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    if (this.hZ != null) {
      this.hZ.setCloseIconVisible(paramBoolean);
    }
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 != null) {
      throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }
    if (paramDrawable3 != null) {
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 != null) {
      throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }
    if (paramDrawable3 != null) {
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != 0) {
      throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }
    if (paramInt3 != 0) {
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 != null) {
      throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }
    if (paramDrawable3 != null) {
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != 0) {
      throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }
    if (paramInt3 != 0) {
      throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }
    super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (paramDrawable1 != null) {
      throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }
    if (paramDrawable3 != null) {
      throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }
    super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    if (this.hZ == null) {}
    do
    {
      return;
      if (paramTruncateAt == TextUtils.TruncateAt.MARQUEE) {
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
      }
      super.setEllipsize(paramTruncateAt);
    } while (this.hZ == null);
    this.hZ.jp = paramTruncateAt;
  }
  
  public void setGravity(int paramInt)
  {
    if (paramInt == 8388627) {
      super.setGravity(paramInt);
    }
  }
  
  public void setHideMotionSpec(h paramh)
  {
    if (this.hZ != null) {
      this.hZ.iL = paramh;
    }
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.iL = h.k(locala.context, paramInt);
    }
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setIconEndPadding(paramFloat);
    }
  }
  
  public void setIconEndPaddingResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setIconEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setIconStartPadding(paramFloat);
    }
  }
  
  public void setIconStartPaddingResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setIconStartPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setLines(int paramInt)
  {
    if (paramInt > 1) {
      throw new UnsupportedOperationException("Chip does not support multi-line text");
    }
    super.setLines(paramInt);
  }
  
  public void setMaxLines(int paramInt)
  {
    if (paramInt > 1) {
      throw new UnsupportedOperationException("Chip does not support multi-line text");
    }
    super.setMaxLines(paramInt);
  }
  
  public void setMaxWidth(int paramInt)
  {
    super.setMaxWidth(paramInt);
    if (this.hZ != null) {
      this.hZ.maxWidth = paramInt;
    }
  }
  
  public void setMinLines(int paramInt)
  {
    if (paramInt > 1) {
      throw new UnsupportedOperationException("Chip does not support multi-line text");
    }
    super.setMinLines(paramInt);
  }
  
  void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.ic = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ib = paramOnClickListener;
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.hZ != null) {
      this.hZ.setRippleColor(paramColorStateList);
    }
  }
  
  public void setRippleColorResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setRippleColor(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setShowMotionSpec(h paramh)
  {
    if (this.hZ != null) {
      this.hZ.iK = paramh;
    }
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.iK = h.k(locala.context, paramInt);
    }
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new UnsupportedOperationException("Chip does not support multi-line text");
    }
    super.setSingleLine(paramBoolean);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    if (this.hZ == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      paramCharSequence = android.support.v4.d.a.fb().unicodeWrap((CharSequence)localObject);
      if (this.hZ.jq) {
        paramCharSequence = null;
      }
      super.setText(paramCharSequence, paramBufferType);
    } while (this.hZ == null);
    this.hZ.setText((CharSequence)localObject);
  }
  
  public void setTextAppearance(int paramInt)
  {
    super.setTextAppearance(paramInt);
    if (this.hZ != null) {
      this.hZ.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(getContext(), getPaint(), this.ik);
      a(getTextAppearance());
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.hZ != null) {
      this.hZ.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(paramContext, getPaint(), this.ik);
      a(getTextAppearance());
    }
  }
  
  public void setTextAppearance(b paramb)
  {
    if (this.hZ != null) {
      this.hZ.setTextAppearance(paramb);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(getContext(), getPaint(), this.ik);
      a(paramb);
    }
  }
  
  public void setTextAppearanceResource(int paramInt)
  {
    if (this.hZ != null) {
      this.hZ.setTextAppearanceResource(paramInt);
    }
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setTextEndPadding(paramFloat);
    }
  }
  
  public void setTextEndPaddingResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setTextEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    if (this.hZ != null) {
      this.hZ.setTextStartPadding(paramFloat);
    }
  }
  
  public void setTextStartPaddingResource(int paramInt)
  {
    if (this.hZ != null)
    {
      a locala = this.hZ;
      locala.setTextStartPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  final class a
    extends j
  {
    a(Chip paramChip)
    {
      super();
    }
    
    public final int getVirtualViewAt(float paramFloat1, float paramFloat2)
    {
      if ((Chip.b(Chip.this)) && (Chip.c(Chip.this).contains(paramFloat1, paramFloat2))) {
        return 0;
      }
      return -1;
    }
    
    public final void getVisibleVirtualViews(List<Integer> paramList)
    {
      if (Chip.b(Chip.this)) {
        paramList.add(Integer.valueOf(0));
      }
    }
    
    public final boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if ((paramInt2 == 16) && (paramInt1 == 0)) {
        return Chip.this.bf();
      }
      return false;
    }
    
    public final void onPopulateNodeForHost(c paramc)
    {
      if ((Chip.a(Chip.this) != null) && (Chip.a(Chip.this).iH)) {}
      CharSequence localCharSequence;
      for (boolean bool = true;; bool = false)
      {
        paramc.setCheckable(bool);
        paramc.setClassName(Chip.class.getName());
        localCharSequence = Chip.this.getText();
        if (Build.VERSION.SDK_INT < 23) {
          break;
        }
        paramc.setText(localCharSequence);
        return;
      }
      paramc.setContentDescription(localCharSequence);
    }
    
    public final void onPopulateNodeForVirtualView(int paramInt, c paramc)
    {
      if (Chip.b(Chip.this))
      {
        Object localObject = Chip.this.getCloseIconContentDescription();
        if (localObject != null)
        {
          paramc.setContentDescription((CharSequence)localObject);
          paramc.setBoundsInParent(Chip.d(Chip.this));
          localObject = c.a.Rh;
          if (Build.VERSION.SDK_INT >= 21) {
            paramc.Rb.addAction((AccessibilityNodeInfo.AccessibilityAction)((c.a)localObject).RK);
          }
          paramc.setEnabled(Chip.this.isEnabled());
          return;
        }
        localObject = Chip.this.getText();
        Context localContext = Chip.this.getContext();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        for (;;)
        {
          paramc.setContentDescription(localContext.getString(2131761379, new Object[] { localObject }).trim());
          break;
          localObject = "";
        }
      }
      paramc.setContentDescription("");
      paramc.setBoundsInParent(Chip.bi());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.chip.Chip
 * JD-Core Version:    0.7.0.1
 */