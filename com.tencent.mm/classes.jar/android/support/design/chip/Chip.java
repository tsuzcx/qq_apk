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
import android.support.v4.view.u;
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
  private static final Rect hZ = new Rect();
  private static final int[] ia = { 16842913 };
  private final RectF hO = new RectF();
  private a ib;
  private RippleDrawable ic;
  private View.OnClickListener ie;
  private CompoundButton.OnCheckedChangeListener jdField_if;
  private boolean ig;
  private int ih = -2147483648;
  private boolean ii;
  private boolean ij;
  private boolean ik;
  private final a il;
  private final f.a im = new f.a()
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
    this(paramContext, paramAttributeSet, 2130968784);
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
    this.il = new a(this);
    u.a(this, this.il);
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
    setChecked(this.ig);
    paramContext.js = false;
    setText(paramContext.ix);
    setEllipsize(paramContext.jr);
    setIncludeFontPadding(false);
    if (getTextAppearance() != null) {
      a(getTextAppearance());
    }
    setSingleLine();
    setGravity(8388627);
    bf();
  }
  
  private void a(b paramb)
  {
    TextPaint localTextPaint = getPaint();
    localTextPaint.drawableState = this.ib.getState();
    paramb.b(getContext(), localTextPaint, this.im);
  }
  
  private void bf()
  {
    if ((TextUtils.isEmpty(getText())) || (this.ib == null)) {}
    float f2;
    do
    {
      return;
      f2 = this.ib.iO + this.ib.iV + this.ib.iR + this.ib.iS;
      float f1;
      if ((!this.ib.iA) || (this.ib.getChipIcon() == null))
      {
        f1 = f2;
        if (this.ib.iL != null)
        {
          f1 = f2;
          if (this.ib.iK)
          {
            f1 = f2;
            if (!isChecked()) {}
          }
        }
      }
      else
      {
        f1 = f2 + (this.ib.iP + this.ib.iQ + this.ib.iD);
      }
      f2 = f1;
      if (this.ib.iE)
      {
        f2 = f1;
        if (this.ib.getCloseIcon() != null) {
          f2 = f1 + (this.ib.iT + this.ib.iU + this.ib.iH);
        }
      }
    } while (u.ad(this) == f2);
    u.d(this, u.ac(this), getPaddingTop(), (int)f2, getPaddingBottom());
  }
  
  private void bi()
  {
    if (this.ih == -2147483648) {
      setFocusedVirtualView(-1);
    }
  }
  
  private boolean bj()
  {
    return (this.ib != null) && (this.ib.getCloseIcon() != null);
  }
  
  @SuppressLint({"PrivateApi"})
  private boolean d(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 10) {}
    try
    {
      paramMotionEvent = j.class.getDeclaredField("mHoveredVirtualViewId");
      paramMotionEvent.setAccessible(true);
      if (((Integer)paramMotionEvent.get(this.il)).intValue() != -2147483648)
      {
        paramMotionEvent = j.class.getDeclaredMethod("updateHoveredVirtualView", new Class[] { Integer.TYPE });
        paramMotionEvent.setAccessible(true);
        paramMotionEvent.invoke(this.il, new Object[] { Integer.valueOf(-2147483648) });
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
    this.hO.setEmpty();
    if (bj())
    {
      a locala = this.ib;
      RectF localRectF = this.hO;
      locala.c(locala.getBounds(), localRectF);
    }
    return this.hO;
  }
  
  private Rect getCloseIconTouchBoundsInt()
  {
    RectF localRectF = getCloseIconTouchBounds();
    this.rect.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    return this.rect;
  }
  
  private b getTextAppearance()
  {
    if (this.ib != null) {
      return this.ib.iz;
    }
    return null;
  }
  
  private boolean n(boolean paramBoolean)
  {
    bi();
    if (paramBoolean)
    {
      if (this.ih == -1)
      {
        setFocusedVirtualView(0);
        return true;
      }
    }
    else if (this.ih == 0)
    {
      setFocusedVirtualView(-1);
      return true;
    }
    return false;
  }
  
  private void setCloseIconFocused(boolean paramBoolean)
  {
    if (this.ik != paramBoolean)
    {
      this.ik = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconHovered(boolean paramBoolean)
  {
    if (this.ij != paramBoolean)
    {
      this.ij = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconPressed(boolean paramBoolean)
  {
    if (this.ii != paramBoolean)
    {
      this.ii = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setFocusedVirtualView(int paramInt)
  {
    if (this.ih != paramInt)
    {
      if (this.ih == 0) {
        setCloseIconFocused(false);
      }
      this.ih = paramInt;
      if (paramInt == 0) {
        setCloseIconFocused(true);
      }
    }
  }
  
  public final void bg()
  {
    bf();
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
  }
  
  public final boolean bh()
  {
    playSoundEffect(0);
    if (this.ie != null) {
      this.ie.onClick(this);
    }
    for (boolean bool = true;; bool = false)
    {
      this.il.sendEventForVirtualView(0, 1);
      return bool;
    }
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    return (d(paramMotionEvent)) || (this.il.dispatchHoverEvent(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this.il.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  protected void drawableStateChanged()
  {
    int k = 1;
    boolean bool2 = false;
    super.drawableStateChanged();
    boolean bool1 = bool2;
    a locala;
    if (this.ib != null)
    {
      bool1 = bool2;
      if (a.b(this.ib.iF))
      {
        locala = this.ib;
        if (!isEnabled()) {
          break label222;
        }
      }
    }
    label222:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.ik) {
        i = j + 1;
      }
      j = i;
      if (this.ij) {
        j = i + 1;
      }
      i = j;
      if (this.ii) {
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
        if (this.ik)
        {
          arrayOfInt[j] = 16842908;
          i = j + 1;
        }
        j = i;
        if (this.ij)
        {
          arrayOfInt[i] = 16843623;
          j = i + 1;
        }
        i = j;
        if (this.ii)
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
    if (this.ib != null) {
      return this.ib.iL;
    }
    return null;
  }
  
  public ColorStateList getChipBackgroundColor()
  {
    if (this.ib != null) {
      return this.ib.ir;
    }
    return null;
  }
  
  public float getChipCornerRadius()
  {
    if (this.ib != null) {
      return this.ib.it;
    }
    return 0.0F;
  }
  
  public Drawable getChipDrawable()
  {
    return this.ib;
  }
  
  public float getChipEndPadding()
  {
    if (this.ib != null) {
      return this.ib.iV;
    }
    return 0.0F;
  }
  
  public Drawable getChipIcon()
  {
    if (this.ib != null) {
      return this.ib.getChipIcon();
    }
    return null;
  }
  
  public float getChipIconSize()
  {
    if (this.ib != null) {
      return this.ib.iD;
    }
    return 0.0F;
  }
  
  public ColorStateList getChipIconTint()
  {
    if (this.ib != null) {
      return this.ib.iC;
    }
    return null;
  }
  
  public float getChipMinHeight()
  {
    if (this.ib != null) {
      return this.ib.is;
    }
    return 0.0F;
  }
  
  public float getChipStartPadding()
  {
    if (this.ib != null) {
      return this.ib.iO;
    }
    return 0.0F;
  }
  
  public ColorStateList getChipStrokeColor()
  {
    if (this.ib != null) {
      return this.ib.iu;
    }
    return null;
  }
  
  public float getChipStrokeWidth()
  {
    if (this.ib != null) {
      return this.ib.iw;
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
    if (this.ib != null) {
      return this.ib.getCloseIcon();
    }
    return null;
  }
  
  public CharSequence getCloseIconContentDescription()
  {
    if (this.ib != null) {
      return this.ib.iI;
    }
    return null;
  }
  
  public float getCloseIconEndPadding()
  {
    if (this.ib != null) {
      return this.ib.iU;
    }
    return 0.0F;
  }
  
  public float getCloseIconSize()
  {
    if (this.ib != null) {
      return this.ib.iH;
    }
    return 0.0F;
  }
  
  public float getCloseIconStartPadding()
  {
    if (this.ib != null) {
      return this.ib.iT;
    }
    return 0.0F;
  }
  
  public ColorStateList getCloseIconTint()
  {
    if (this.ib != null) {
      return this.ib.iG;
    }
    return null;
  }
  
  public TextUtils.TruncateAt getEllipsize()
  {
    if (this.ib != null) {
      return this.ib.jr;
    }
    return null;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    if (this.ih == 0)
    {
      paramRect.set(getCloseIconTouchBoundsInt());
      return;
    }
    super.getFocusedRect(paramRect);
  }
  
  public h getHideMotionSpec()
  {
    if (this.ib != null) {
      return this.ib.iN;
    }
    return null;
  }
  
  public float getIconEndPadding()
  {
    if (this.ib != null) {
      return this.ib.iQ;
    }
    return 0.0F;
  }
  
  public float getIconStartPadding()
  {
    if (this.ib != null) {
      return this.ib.iP;
    }
    return 0.0F;
  }
  
  public ColorStateList getRippleColor()
  {
    if (this.ib != null) {
      return this.ib.hL;
    }
    return null;
  }
  
  public h getShowMotionSpec()
  {
    if (this.ib != null) {
      return this.ib.iM;
    }
    return null;
  }
  
  public CharSequence getText()
  {
    if (this.ib != null) {
      return this.ib.ix;
    }
    return "";
  }
  
  public float getTextEndPadding()
  {
    if (this.ib != null) {
      return this.ib.iS;
    }
    return 0.0F;
  }
  
  public float getTextStartPadding()
  {
    if (this.ib != null) {
      return this.ib.iR;
    }
    return 0.0F;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, ia);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((TextUtils.isEmpty(getText())) || (this.ib == null) || (this.ib.js))
    {
      super.onDraw(paramCanvas);
      return;
    }
    int i = paramCanvas.save();
    a locala = this.ib;
    float f = getChipStartPadding();
    f = locala.bp() + f + getTextStartPadding();
    if (u.Z(this) == 0) {}
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
      this.il.onFocusChanged(paramBoolean, paramInt, paramRect);
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
            switch (this.ih)
            {
            default: 
              bool1 = bool2;
              break;
            case -1: 
              performClick();
              return true;
            case 0: 
              bh();
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
        if (!this.ii) {
          break;
        }
        if (!bool2) {
          setCloseIconPressed(false);
        }
        i = 1;
      }
    case 1: 
      if (this.ii) {
        bh();
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
    if ((paramDrawable != this.ib) && (paramDrawable != this.ic)) {
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
    if ((paramDrawable != this.ib) && (paramDrawable != this.ic)) {
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
    if (this.ib != null) {
      this.ib.setCheckable(paramBoolean);
    }
  }
  
  public void setCheckableResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setCheckable(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.ib == null) {
      this.ig = paramBoolean;
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!this.ib.iJ);
      bool = isChecked();
      super.setChecked(paramBoolean);
    } while ((bool == paramBoolean) || (this.jdField_if == null));
    this.jdField_if.onCheckedChanged(this, paramBoolean);
  }
  
  public void setCheckedIcon(Drawable paramDrawable)
  {
    if (this.ib != null) {
      this.ib.setCheckedIcon(paramDrawable);
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
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setCheckedIcon(android.support.v7.c.a.a.l(locala.context, paramInt));
    }
  }
  
  public void setCheckedIconVisible(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setCheckedIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    if (this.ib != null) {
      this.ib.setCheckedIconVisible(paramBoolean);
    }
  }
  
  public void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    if (this.ib != null) {
      this.ib.setChipBackgroundColor(paramColorStateList);
    }
  }
  
  public void setChipBackgroundColorResource(@android.support.annotation.a int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setChipBackgroundColor(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setChipCornerRadius(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setChipCornerRadius(paramFloat);
    }
  }
  
  public void setChipCornerRadiusResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setChipCornerRadius(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipDrawable(a parama)
  {
    if (this.ib != parama)
    {
      a locala = this.ib;
      if (locala != null) {
        locala.a(null);
      }
      this.ib = parama;
      this.ib.a(this);
      if (android.support.design.e.a.lH)
      {
        this.ic = new RippleDrawable(android.support.design.e.a.b(this.ib.hL), this.ib, null);
        this.ib.o(false);
        u.a(this, this.ic);
      }
    }
    else
    {
      return;
    }
    this.ib.o(true);
    u.a(this, this.ib);
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setChipEndPadding(paramFloat);
    }
  }
  
  public void setChipEndPaddingResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setChipEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipIcon(Drawable paramDrawable)
  {
    if (this.ib != null) {
      this.ib.setChipIcon(paramDrawable);
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
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setChipIcon(android.support.v7.c.a.a.l(locala.context, paramInt));
    }
  }
  
  public void setChipIconSize(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setChipIconSize(paramFloat);
    }
  }
  
  public void setChipIconSizeResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setChipIconSize(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipIconTint(ColorStateList paramColorStateList)
  {
    if (this.ib != null) {
      this.ib.setChipIconTint(paramColorStateList);
    }
  }
  
  public void setChipIconTintResource(@android.support.annotation.a int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setChipIconTint(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setChipIconVisible(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setChipIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    if (this.ib != null) {
      this.ib.setChipIconVisible(paramBoolean);
    }
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setChipMinHeight(paramFloat);
    }
  }
  
  public void setChipMinHeightResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setChipMinHeight(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setChipStartPadding(paramFloat);
    }
  }
  
  public void setChipStartPaddingResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setChipStartPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    if (this.ib != null) {
      this.ib.setChipStrokeColor(paramColorStateList);
    }
  }
  
  public void setChipStrokeColorResource(@android.support.annotation.a int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setChipStrokeColor(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setChipStrokeWidth(paramFloat);
    }
  }
  
  public void setChipStrokeWidthResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
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
    if (this.ib != null) {
      this.ib.setCloseIcon(paramDrawable);
    }
  }
  
  public void setCloseIconContentDescription(CharSequence paramCharSequence)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      if (locala.iI != paramCharSequence)
      {
        locala.iI = android.support.v4.d.a.fg().unicodeWrap(paramCharSequence);
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
    if (this.ib != null) {
      this.ib.setCloseIconEndPadding(paramFloat);
    }
  }
  
  public void setCloseIconEndPaddingResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setCloseIconEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setCloseIconResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setCloseIcon(android.support.v7.c.a.a.l(locala.context, paramInt));
    }
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setCloseIconSize(paramFloat);
    }
  }
  
  public void setCloseIconSizeResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setCloseIconSize(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setCloseIconStartPadding(paramFloat);
    }
  }
  
  public void setCloseIconStartPaddingResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setCloseIconStartPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setCloseIconTint(ColorStateList paramColorStateList)
  {
    if (this.ib != null) {
      this.ib.setCloseIconTint(paramColorStateList);
    }
  }
  
  public void setCloseIconTintResource(@android.support.annotation.a int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setCloseIconTint(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setCloseIconVisible(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setCloseIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    if (this.ib != null) {
      this.ib.setCloseIconVisible(paramBoolean);
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
    if (this.ib == null) {}
    do
    {
      return;
      if (paramTruncateAt == TextUtils.TruncateAt.MARQUEE) {
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
      }
      super.setEllipsize(paramTruncateAt);
    } while (this.ib == null);
    this.ib.jr = paramTruncateAt;
  }
  
  public void setGravity(int paramInt)
  {
    if (paramInt == 8388627) {
      super.setGravity(paramInt);
    }
  }
  
  public void setHideMotionSpec(h paramh)
  {
    if (this.ib != null) {
      this.ib.iN = paramh;
    }
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.iN = h.k(locala.context, paramInt);
    }
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setIconEndPadding(paramFloat);
    }
  }
  
  public void setIconEndPaddingResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setIconEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setIconStartPadding(paramFloat);
    }
  }
  
  public void setIconStartPaddingResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
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
    if (this.ib != null) {
      this.ib.maxWidth = paramInt;
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
    this.jdField_if = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.ie = paramOnClickListener;
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.ib != null) {
      this.ib.setRippleColor(paramColorStateList);
    }
  }
  
  public void setRippleColorResource(@android.support.annotation.a int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setRippleColor(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setShowMotionSpec(h paramh)
  {
    if (this.ib != null) {
      this.ib.iM = paramh;
    }
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.iM = h.k(locala.context, paramInt);
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
    if (this.ib == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      paramCharSequence = android.support.v4.d.a.fg().unicodeWrap((CharSequence)localObject);
      if (this.ib.js) {
        paramCharSequence = null;
      }
      super.setText(paramCharSequence, paramBufferType);
    } while (this.ib == null);
    this.ib.setText((CharSequence)localObject);
  }
  
  public void setTextAppearance(int paramInt)
  {
    super.setTextAppearance(paramInt);
    if (this.ib != null) {
      this.ib.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(getContext(), getPaint(), this.im);
      a(getTextAppearance());
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.ib != null) {
      this.ib.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(paramContext, getPaint(), this.im);
      a(getTextAppearance());
    }
  }
  
  public void setTextAppearance(b paramb)
  {
    if (this.ib != null) {
      this.ib.setTextAppearance(paramb);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(getContext(), getPaint(), this.im);
      a(paramb);
    }
  }
  
  public void setTextAppearanceResource(int paramInt)
  {
    if (this.ib != null) {
      this.ib.setTextAppearanceResource(paramInt);
    }
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setTextEndPadding(paramFloat);
    }
  }
  
  public void setTextEndPaddingResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
      locala.setTextEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    if (this.ib != null) {
      this.ib.setTextStartPadding(paramFloat);
    }
  }
  
  public void setTextStartPaddingResource(int paramInt)
  {
    if (this.ib != null)
    {
      a locala = this.ib;
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
        return Chip.this.bh();
      }
      return false;
    }
    
    public final void onPopulateNodeForHost(c paramc)
    {
      if ((Chip.a(Chip.this) != null) && (Chip.a(Chip.this).iJ)) {}
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
          localObject = c.a.Ru;
          if (Build.VERSION.SDK_INT >= 21) {
            paramc.Ro.addAction((AccessibilityNodeInfo.AccessibilityAction)((c.a)localObject).RX);
          }
          paramc.setEnabled(Chip.this.isEnabled());
          return;
        }
        localObject = Chip.this.getText();
        Context localContext = Chip.this.getContext();
        if (!TextUtils.isEmpty((CharSequence)localObject)) {}
        for (;;)
        {
          paramc.setContentDescription(localContext.getString(2131763214, new Object[] { localObject }).trim());
          break;
          localObject = "";
        }
      }
      paramc.setContentDescription("");
      paramc.setBoundsInParent(Chip.bk());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.chip.Chip
 * JD-Core Version:    0.7.0.1
 */