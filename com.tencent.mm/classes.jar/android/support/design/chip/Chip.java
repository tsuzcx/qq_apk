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
  private static final Rect gg = new Rect();
  private static final int[] gh = { 16842913 };
  private final RectF fV = new RectF();
  private a gi;
  private RippleDrawable gj;
  private View.OnClickListener gk;
  private CompoundButton.OnCheckedChangeListener gl;
  private boolean gm;
  private int gn = -2147483648;
  private boolean go;
  private boolean gp;
  private boolean gq;
  private final a gr;
  private final f.a gs = new f.a()
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
    this.gr = new a(this);
    t.a(this, this.gr);
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
    setChecked(this.gm);
    paramContext.hv = false;
    setText(paramContext.gA);
    setEllipsize(paramContext.hu);
    setIncludeFontPadding(false);
    if (getTextAppearance() != null) {
      a(getTextAppearance());
    }
    setSingleLine();
    setGravity(8388627);
    aN();
  }
  
  private void a(b paramb)
  {
    TextPaint localTextPaint = getPaint();
    localTextPaint.drawableState = this.gi.getState();
    paramb.b(getContext(), localTextPaint, this.gs);
  }
  
  private void aN()
  {
    if ((TextUtils.isEmpty(getText())) || (this.gi == null)) {}
    float f2;
    do
    {
      return;
      f2 = this.gi.gR + this.gi.gY + this.gi.gU + this.gi.gV;
      float f1;
      if ((!this.gi.gD) || (this.gi.getChipIcon() == null))
      {
        f1 = f2;
        if (this.gi.gO != null)
        {
          f1 = f2;
          if (this.gi.gN)
          {
            f1 = f2;
            if (!isChecked()) {}
          }
        }
      }
      else
      {
        f1 = f2 + (this.gi.gS + this.gi.gT + this.gi.gG);
      }
      f2 = f1;
      if (this.gi.gH)
      {
        f2 = f1;
        if (this.gi.getCloseIcon() != null) {
          f2 = f1 + (this.gi.gW + this.gi.gX + this.gi.gK);
        }
      }
    } while (t.ac(this) == f2);
    t.d(this, t.ab(this), getPaddingTop(), (int)f2, getPaddingBottom());
  }
  
  private void aQ()
  {
    if (this.gn == -2147483648) {
      setFocusedVirtualView(-1);
    }
  }
  
  private boolean aR()
  {
    return (this.gi != null) && (this.gi.getCloseIcon() != null);
  }
  
  @SuppressLint({"PrivateApi"})
  private boolean d(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 10) {}
    try
    {
      paramMotionEvent = j.class.getDeclaredField("mHoveredVirtualViewId");
      paramMotionEvent.setAccessible(true);
      if (((Integer)paramMotionEvent.get(this.gr)).intValue() != -2147483648)
      {
        paramMotionEvent = j.class.getDeclaredMethod("updateHoveredVirtualView", new Class[] { Integer.TYPE });
        paramMotionEvent.setAccessible(true);
        paramMotionEvent.invoke(this.gr, new Object[] { Integer.valueOf(-2147483648) });
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
    this.fV.setEmpty();
    if (aR())
    {
      a locala = this.gi;
      RectF localRectF = this.fV;
      locala.c(locala.getBounds(), localRectF);
    }
    return this.fV;
  }
  
  private Rect getCloseIconTouchBoundsInt()
  {
    RectF localRectF = getCloseIconTouchBounds();
    this.rect.set((int)localRectF.left, (int)localRectF.top, (int)localRectF.right, (int)localRectF.bottom);
    return this.rect;
  }
  
  private b getTextAppearance()
  {
    if (this.gi != null) {
      return this.gi.gC;
    }
    return null;
  }
  
  private boolean n(boolean paramBoolean)
  {
    aQ();
    if (paramBoolean)
    {
      if (this.gn == -1)
      {
        setFocusedVirtualView(0);
        return true;
      }
    }
    else if (this.gn == 0)
    {
      setFocusedVirtualView(-1);
      return true;
    }
    return false;
  }
  
  private void setCloseIconFocused(boolean paramBoolean)
  {
    if (this.gq != paramBoolean)
    {
      this.gq = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconHovered(boolean paramBoolean)
  {
    if (this.gp != paramBoolean)
    {
      this.gp = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setCloseIconPressed(boolean paramBoolean)
  {
    if (this.go != paramBoolean)
    {
      this.go = paramBoolean;
      refreshDrawableState();
    }
  }
  
  private void setFocusedVirtualView(int paramInt)
  {
    if (this.gn != paramInt)
    {
      if (this.gn == 0) {
        setCloseIconFocused(false);
      }
      this.gn = paramInt;
      if (paramInt == 0) {
        setCloseIconFocused(true);
      }
    }
  }
  
  public final void aO()
  {
    aN();
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
  }
  
  public final boolean aP()
  {
    playSoundEffect(0);
    if (this.gk != null) {
      this.gk.onClick(this);
    }
    for (boolean bool = true;; bool = false)
    {
      this.gr.sendEventForVirtualView(0, 1);
      return bool;
    }
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    return (d(paramMotionEvent)) || (this.gr.dispatchHoverEvent(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent));
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return (this.gr.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent));
  }
  
  protected void drawableStateChanged()
  {
    int k = 1;
    boolean bool2 = false;
    super.drawableStateChanged();
    boolean bool1 = bool2;
    a locala;
    if (this.gi != null)
    {
      bool1 = bool2;
      if (a.b(this.gi.gI))
      {
        locala = this.gi;
        if (!isEnabled()) {
          break label222;
        }
      }
    }
    label222:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.gq) {
        i = j + 1;
      }
      j = i;
      if (this.gp) {
        j = i + 1;
      }
      i = j;
      if (this.go) {
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
        if (this.gq)
        {
          arrayOfInt[j] = 16842908;
          i = j + 1;
        }
        j = i;
        if (this.gp)
        {
          arrayOfInt[i] = 16843623;
          j = i + 1;
        }
        i = j;
        if (this.go)
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
    if (this.gi != null) {
      return this.gi.gO;
    }
    return null;
  }
  
  public ColorStateList getChipBackgroundColor()
  {
    if (this.gi != null) {
      return this.gi.gv;
    }
    return null;
  }
  
  public float getChipCornerRadius()
  {
    if (this.gi != null) {
      return this.gi.gx;
    }
    return 0.0F;
  }
  
  public Drawable getChipDrawable()
  {
    return this.gi;
  }
  
  public float getChipEndPadding()
  {
    if (this.gi != null) {
      return this.gi.gY;
    }
    return 0.0F;
  }
  
  public Drawable getChipIcon()
  {
    if (this.gi != null) {
      return this.gi.getChipIcon();
    }
    return null;
  }
  
  public float getChipIconSize()
  {
    if (this.gi != null) {
      return this.gi.gG;
    }
    return 0.0F;
  }
  
  public ColorStateList getChipIconTint()
  {
    if (this.gi != null) {
      return this.gi.gF;
    }
    return null;
  }
  
  public float getChipMinHeight()
  {
    if (this.gi != null) {
      return this.gi.gw;
    }
    return 0.0F;
  }
  
  public float getChipStartPadding()
  {
    if (this.gi != null) {
      return this.gi.gR;
    }
    return 0.0F;
  }
  
  public ColorStateList getChipStrokeColor()
  {
    if (this.gi != null) {
      return this.gi.gy;
    }
    return null;
  }
  
  public float getChipStrokeWidth()
  {
    if (this.gi != null) {
      return this.gi.gz;
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
    if (this.gi != null) {
      return this.gi.getCloseIcon();
    }
    return null;
  }
  
  public CharSequence getCloseIconContentDescription()
  {
    if (this.gi != null) {
      return this.gi.gL;
    }
    return null;
  }
  
  public float getCloseIconEndPadding()
  {
    if (this.gi != null) {
      return this.gi.gX;
    }
    return 0.0F;
  }
  
  public float getCloseIconSize()
  {
    if (this.gi != null) {
      return this.gi.gK;
    }
    return 0.0F;
  }
  
  public float getCloseIconStartPadding()
  {
    if (this.gi != null) {
      return this.gi.gW;
    }
    return 0.0F;
  }
  
  public ColorStateList getCloseIconTint()
  {
    if (this.gi != null) {
      return this.gi.gJ;
    }
    return null;
  }
  
  public TextUtils.TruncateAt getEllipsize()
  {
    if (this.gi != null) {
      return this.gi.hu;
    }
    return null;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    if (this.gn == 0)
    {
      paramRect.set(getCloseIconTouchBoundsInt());
      return;
    }
    super.getFocusedRect(paramRect);
  }
  
  public h getHideMotionSpec()
  {
    if (this.gi != null) {
      return this.gi.gQ;
    }
    return null;
  }
  
  public float getIconEndPadding()
  {
    if (this.gi != null) {
      return this.gi.gT;
    }
    return 0.0F;
  }
  
  public float getIconStartPadding()
  {
    if (this.gi != null) {
      return this.gi.gS;
    }
    return 0.0F;
  }
  
  public ColorStateList getRippleColor()
  {
    if (this.gi != null) {
      return this.gi.fS;
    }
    return null;
  }
  
  public h getShowMotionSpec()
  {
    if (this.gi != null) {
      return this.gi.gP;
    }
    return null;
  }
  
  public CharSequence getText()
  {
    if (this.gi != null) {
      return this.gi.gA;
    }
    return "";
  }
  
  public float getTextEndPadding()
  {
    if (this.gi != null) {
      return this.gi.gV;
    }
    return 0.0F;
  }
  
  public float getTextStartPadding()
  {
    if (this.gi != null) {
      return this.gi.gU;
    }
    return 0.0F;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, gh);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((TextUtils.isEmpty(getText())) || (this.gi == null) || (this.gi.hv))
    {
      super.onDraw(paramCanvas);
      return;
    }
    int i = paramCanvas.save();
    a locala = this.gi;
    float f = getChipStartPadding();
    f = locala.aX() + f + getTextStartPadding();
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
      this.gr.onFocusChanged(paramBoolean, paramInt, paramRect);
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
            switch (this.gn)
            {
            default: 
              bool1 = bool2;
              break;
            case -1: 
              performClick();
              return true;
            case 0: 
              aP();
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
        if (!this.go) {
          break;
        }
        if (!bool2) {
          setCloseIconPressed(false);
        }
        i = 1;
      }
    case 1: 
      if (this.go) {
        aP();
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
    if ((paramDrawable != this.gi) && (paramDrawable != this.gj)) {
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
    if ((paramDrawable != this.gi) && (paramDrawable != this.gj)) {
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
    if (this.gi != null) {
      this.gi.setCheckable(paramBoolean);
    }
  }
  
  public void setCheckableResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setCheckable(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.gi == null) {
      this.gm = paramBoolean;
    }
    boolean bool;
    do
    {
      do
      {
        return;
      } while (!this.gi.gM);
      bool = isChecked();
      super.setChecked(paramBoolean);
    } while ((bool == paramBoolean) || (this.gl == null));
    this.gl.onCheckedChanged(this, paramBoolean);
  }
  
  public void setCheckedIcon(Drawable paramDrawable)
  {
    if (this.gi != null) {
      this.gi.setCheckedIcon(paramDrawable);
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
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setCheckedIcon(android.support.v7.c.a.a.l(locala.context, paramInt));
    }
  }
  
  public void setCheckedIconVisible(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setCheckedIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    if (this.gi != null) {
      this.gi.setCheckedIconVisible(paramBoolean);
    }
  }
  
  public void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    if (this.gi != null) {
      this.gi.setChipBackgroundColor(paramColorStateList);
    }
  }
  
  public void setChipBackgroundColorResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setChipBackgroundColor(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setChipCornerRadius(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setChipCornerRadius(paramFloat);
    }
  }
  
  public void setChipCornerRadiusResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setChipCornerRadius(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipDrawable(a parama)
  {
    if (this.gi != parama)
    {
      a locala = this.gi;
      if (locala != null) {
        locala.a(null);
      }
      this.gi = parama;
      this.gi.a(this);
      if (android.support.design.e.a.jP)
      {
        this.gj = new RippleDrawable(android.support.design.e.a.b(this.gi.fS), this.gi, null);
        this.gi.o(false);
        t.a(this, this.gj);
      }
    }
    else
    {
      return;
    }
    this.gi.o(true);
    t.a(this, this.gi);
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setChipEndPadding(paramFloat);
    }
  }
  
  public void setChipEndPaddingResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setChipEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipIcon(Drawable paramDrawable)
  {
    if (this.gi != null) {
      this.gi.setChipIcon(paramDrawable);
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
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setChipIcon(android.support.v7.c.a.a.l(locala.context, paramInt));
    }
  }
  
  public void setChipIconSize(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setChipIconSize(paramFloat);
    }
  }
  
  public void setChipIconSizeResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setChipIconSize(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipIconTint(ColorStateList paramColorStateList)
  {
    if (this.gi != null) {
      this.gi.setChipIconTint(paramColorStateList);
    }
  }
  
  public void setChipIconTintResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setChipIconTint(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setChipIconVisible(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setChipIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    if (this.gi != null) {
      this.gi.setChipIconVisible(paramBoolean);
    }
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setChipMinHeight(paramFloat);
    }
  }
  
  public void setChipMinHeightResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setChipMinHeight(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setChipStartPadding(paramFloat);
    }
  }
  
  public void setChipStartPaddingResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setChipStartPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    if (this.gi != null) {
      this.gi.setChipStrokeColor(paramColorStateList);
    }
  }
  
  public void setChipStrokeColorResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setChipStrokeColor(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setChipStrokeWidth(paramFloat);
    }
  }
  
  public void setChipStrokeWidthResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
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
    if (this.gi != null) {
      this.gi.setCloseIcon(paramDrawable);
    }
  }
  
  public void setCloseIconContentDescription(CharSequence paramCharSequence)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      if (locala.gL != paramCharSequence)
      {
        locala.gL = android.support.v4.d.a.eK().unicodeWrap(paramCharSequence);
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
    if (this.gi != null) {
      this.gi.setCloseIconEndPadding(paramFloat);
    }
  }
  
  public void setCloseIconEndPaddingResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setCloseIconEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setCloseIconResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setCloseIcon(android.support.v7.c.a.a.l(locala.context, paramInt));
    }
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setCloseIconSize(paramFloat);
    }
  }
  
  public void setCloseIconSizeResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setCloseIconSize(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setCloseIconStartPadding(paramFloat);
    }
  }
  
  public void setCloseIconStartPaddingResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setCloseIconStartPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setCloseIconTint(ColorStateList paramColorStateList)
  {
    if (this.gi != null) {
      this.gi.setCloseIconTint(paramColorStateList);
    }
  }
  
  public void setCloseIconTintResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setCloseIconTint(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setCloseIconVisible(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setCloseIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    if (this.gi != null) {
      this.gi.setCloseIconVisible(paramBoolean);
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
    if (this.gi == null) {}
    do
    {
      return;
      if (paramTruncateAt == TextUtils.TruncateAt.MARQUEE) {
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
      }
      super.setEllipsize(paramTruncateAt);
    } while (this.gi == null);
    this.gi.hu = paramTruncateAt;
  }
  
  public void setGravity(int paramInt)
  {
    if (paramInt == 8388627) {
      super.setGravity(paramInt);
    }
  }
  
  public void setHideMotionSpec(h paramh)
  {
    if (this.gi != null) {
      this.gi.gQ = paramh;
    }
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.gQ = h.k(locala.context, paramInt);
    }
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setIconEndPadding(paramFloat);
    }
  }
  
  public void setIconEndPaddingResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setIconEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setIconStartPadding(paramFloat);
    }
  }
  
  public void setIconStartPaddingResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
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
    if (this.gi != null) {
      this.gi.maxWidth = paramInt;
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
    this.gl = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gk = paramOnClickListener;
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (this.gi != null) {
      this.gi.setRippleColor(paramColorStateList);
    }
  }
  
  public void setRippleColorResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setRippleColor(android.support.v7.c.a.a.m(locala.context, paramInt));
    }
  }
  
  public void setShowMotionSpec(h paramh)
  {
    if (this.gi != null) {
      this.gi.gP = paramh;
    }
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.gP = h.k(locala.context, paramInt);
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
    if (this.gi == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramCharSequence;
      if (paramCharSequence == null) {
        localObject = "";
      }
      paramCharSequence = android.support.v4.d.a.eK().unicodeWrap((CharSequence)localObject);
      if (this.gi.hv) {
        paramCharSequence = null;
      }
      super.setText(paramCharSequence, paramBufferType);
    } while (this.gi == null);
    this.gi.setText((CharSequence)localObject);
  }
  
  public void setTextAppearance(int paramInt)
  {
    super.setTextAppearance(paramInt);
    if (this.gi != null) {
      this.gi.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(getContext(), getPaint(), this.gs);
      a(getTextAppearance());
    }
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    super.setTextAppearance(paramContext, paramInt);
    if (this.gi != null) {
      this.gi.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(paramContext, getPaint(), this.gs);
      a(getTextAppearance());
    }
  }
  
  public void setTextAppearance(b paramb)
  {
    if (this.gi != null) {
      this.gi.setTextAppearance(paramb);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(getContext(), getPaint(), this.gs);
      a(paramb);
    }
  }
  
  public void setTextAppearanceResource(int paramInt)
  {
    if (this.gi != null) {
      this.gi.setTextAppearanceResource(paramInt);
    }
    setTextAppearance(getContext(), paramInt);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setTextEndPadding(paramFloat);
    }
  }
  
  public void setTextEndPaddingResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
      locala.setTextEndPadding(locala.context.getResources().getDimension(paramInt));
    }
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    if (this.gi != null) {
      this.gi.setTextStartPadding(paramFloat);
    }
  }
  
  public void setTextStartPaddingResource(int paramInt)
  {
    if (this.gi != null)
    {
      a locala = this.gi;
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
        return Chip.this.aP();
      }
      return false;
    }
    
    public final void onPopulateNodeForHost(c paramc)
    {
      if ((Chip.a(Chip.this) != null) && (Chip.a(Chip.this).gM)) {}
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
          localObject = c.a.Ps;
          if (Build.VERSION.SDK_INT >= 21) {
            paramc.Pm.addAction((AccessibilityNodeInfo.AccessibilityAction)((c.a)localObject).PV);
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
      paramc.setBoundsInParent(Chip.aS());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.chip.Chip
 * JD-Core Version:    0.7.0.1
 */