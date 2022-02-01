package com.google.android.material.chip;

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
import androidx.core.content.a.f.c;
import androidx.core.g.a.d;
import androidx.core.g.a.d.a;
import androidx.core.g.z;
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
  private static final Rect drv;
  private static final int[] drw;
  private final RectF avO;
  private CompoundButton.OnCheckedChangeListener drA;
  private boolean drB;
  private int drC;
  private boolean drD;
  private boolean drE;
  private boolean drF;
  private final a drG;
  private final f.c drH;
  private a drx;
  private RippleDrawable dry;
  private View.OnClickListener drz;
  private final Rect rect;
  
  static
  {
    AppMethodBeat.i(209114);
    drv = new Rect();
    drw = new int[] { 16842913 };
    AppMethodBeat.o(209114);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.chipStyle);
  }
  
  public Chip(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(208985);
    this.drC = -2147483648;
    this.rect = new Rect();
    this.avO = new RectF();
    this.drH = new f.c()
    {
      public final void as(int paramAnonymousInt) {}
      
      public final void b(Typeface paramAnonymousTypeface)
      {
        AppMethodBeat.i(208997);
        Chip.this.setText(Chip.this.getText());
        Chip.this.requestLayout();
        Chip.this.invalidate();
        AppMethodBeat.o(208997);
      }
    };
    if (paramAttributeSet != null)
    {
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null)
      {
        paramContext = new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
        AppMethodBeat.o(208985);
        throw paramContext;
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null)
      {
        paramContext = new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        AppMethodBeat.o(208985);
        throw paramContext;
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null)
      {
        paramContext = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        AppMethodBeat.o(208985);
        throw paramContext;
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null)
      {
        paramContext = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        AppMethodBeat.o(208985);
        throw paramContext;
      }
      if (paramAttributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null)
      {
        paramContext = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        AppMethodBeat.o(208985);
        throw paramContext;
      }
      if ((!paramAttributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true)) || (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1) || (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1) || (paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1))
      {
        paramContext = new UnsupportedOperationException("Chip does not support multi-line text");
        AppMethodBeat.o(208985);
        throw paramContext;
      }
      paramAttributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
    }
    paramContext = a.b(paramContext, paramAttributeSet, paramInt, a.j.Widget_MaterialComponents_Chip_Action);
    setChipDrawable(paramContext);
    this.drG = new a(this);
    z.a(this, this.drG);
    if (Build.VERSION.SDK_INT >= 21) {
      setOutlineProvider(new ViewOutlineProvider()
      {
        public final void getOutline(View paramAnonymousView, Outline paramAnonymousOutline)
        {
          AppMethodBeat.i(209003);
          if (Chip.a(Chip.this) != null)
          {
            Chip.a(Chip.this).getOutline(paramAnonymousOutline);
            AppMethodBeat.o(209003);
            return;
          }
          paramAnonymousOutline.setAlpha(0.0F);
          AppMethodBeat.o(209003);
        }
      });
    }
    setChecked(this.drB);
    paramContext.dsL = false;
    setText(paramContext.drP);
    setEllipsize(paramContext.dsK);
    setIncludeFontPadding(false);
    if (getTextAppearance() != null) {
      a(getTextAppearance());
    }
    setSingleLine();
    setGravity(8388627);
    VW();
    AppMethodBeat.o(208985);
  }
  
  private void VW()
  {
    AppMethodBeat.i(208993);
    if ((TextUtils.isEmpty(getText())) || (this.drx == null))
    {
      AppMethodBeat.o(208993);
      return;
    }
    float f2 = this.drx.dsg + this.drx.dsn + this.drx.dsj + this.drx.dsk;
    float f1;
    if ((!this.drx.drS) || (this.drx.getChipIcon() == null))
    {
      f1 = f2;
      if (this.drx.dsd != null)
      {
        f1 = f2;
        if (this.drx.dsc)
        {
          f1 = f2;
          if (!isChecked()) {}
        }
      }
    }
    else
    {
      f1 = f2 + (this.drx.dsh + this.drx.dsi + this.drx.drV);
    }
    f2 = f1;
    if (this.drx.drW)
    {
      f2 = f1;
      if (this.drx.getCloseIcon() != null) {
        f2 = f1 + (this.drx.dsl + this.drx.dsm + this.drx.drZ);
      }
    }
    if (z.Y(this) != f2) {
      z.g(this, z.X(this), getPaddingTop(), (int)f2, getPaddingBottom());
    }
    AppMethodBeat.o(208993);
  }
  
  private void VZ()
  {
    AppMethodBeat.i(209014);
    if (this.drC == -2147483648) {
      setFocusedVirtualView(-1);
    }
    AppMethodBeat.o(209014);
  }
  
  private boolean Wa()
  {
    AppMethodBeat.i(209049);
    if ((this.drx != null) && (this.drx.getCloseIcon() != null))
    {
      AppMethodBeat.o(209049);
      return true;
    }
    AppMethodBeat.o(209049);
    return false;
  }
  
  private void a(b paramb)
  {
    AppMethodBeat.i(209074);
    TextPaint localTextPaint = getPaint();
    localTextPaint.drawableState = this.drx.getState();
    paramb.b(getContext(), localTextPaint, this.drH);
    AppMethodBeat.o(209074);
  }
  
  private boolean bM(boolean paramBoolean)
  {
    boolean bool = true;
    AppMethodBeat.i(209008);
    VZ();
    if (paramBoolean)
    {
      if (this.drC != -1) {
        break label56;
      }
      setFocusedVirtualView(0);
      paramBoolean = bool;
    }
    for (;;)
    {
      AppMethodBeat.o(209008);
      return paramBoolean;
      if (this.drC == 0)
      {
        setFocusedVirtualView(-1);
        paramBoolean = bool;
      }
      else
      {
        label56:
        paramBoolean = false;
      }
    }
  }
  
  private RectF getCloseIconTouchBounds()
  {
    AppMethodBeat.i(209055);
    this.avO.setEmpty();
    if (Wa())
    {
      localObject = this.drx;
      RectF localRectF = this.avO;
      ((a)localObject).c(((a)localObject).getBounds(), localRectF);
    }
    Object localObject = this.avO;
    AppMethodBeat.o(209055);
    return localObject;
  }
  
  private Rect getCloseIconTouchBoundsInt()
  {
    AppMethodBeat.i(209062);
    Object localObject = getCloseIconTouchBounds();
    this.rect.set((int)((RectF)localObject).left, (int)((RectF)localObject).top, (int)((RectF)localObject).right, (int)((RectF)localObject).bottom);
    localObject = this.rect;
    AppMethodBeat.o(209062);
    return localObject;
  }
  
  private b getTextAppearance()
  {
    if (this.drx != null) {
      return this.drx.drR;
    }
    return null;
  }
  
  private boolean m(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209001);
    if (paramMotionEvent.getAction() == 10) {}
    try
    {
      paramMotionEvent = androidx.customview.a.a.class.getDeclaredField("mHoveredVirtualViewId");
      paramMotionEvent.setAccessible(true);
      if (((Integer)paramMotionEvent.get(this.drG)).intValue() != -2147483648)
      {
        paramMotionEvent = androidx.customview.a.a.class.getDeclaredMethod("updateHoveredVirtualView", new Class[] { Integer.TYPE });
        paramMotionEvent.setAccessible(true);
        paramMotionEvent.invoke(this.drG, new Object[] { Integer.valueOf(-2147483648) });
        AppMethodBeat.o(209001);
        return true;
      }
    }
    catch (NoSuchFieldException paramMotionEvent)
    {
      AppMethodBeat.o(209001);
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
    AppMethodBeat.i(209044);
    if (this.drF != paramBoolean)
    {
      this.drF = paramBoolean;
      refreshDrawableState();
    }
    AppMethodBeat.o(209044);
  }
  
  private void setCloseIconHovered(boolean paramBoolean)
  {
    AppMethodBeat.i(209033);
    if (this.drE != paramBoolean)
    {
      this.drE = paramBoolean;
      refreshDrawableState();
    }
    AppMethodBeat.o(209033);
  }
  
  private void setCloseIconPressed(boolean paramBoolean)
  {
    AppMethodBeat.i(209025);
    if (this.drD != paramBoolean)
    {
      this.drD = paramBoolean;
      refreshDrawableState();
    }
    AppMethodBeat.o(209025);
  }
  
  private void setFocusedVirtualView(int paramInt)
  {
    AppMethodBeat.i(209018);
    if (this.drC != paramInt)
    {
      if (this.drC == 0) {
        setCloseIconFocused(false);
      }
      this.drC = paramInt;
      if (paramInt == 0) {
        setCloseIconFocused(true);
      }
    }
    AppMethodBeat.o(209018);
  }
  
  public final void VX()
  {
    AppMethodBeat.i(209298);
    VW();
    requestLayout();
    if (Build.VERSION.SDK_INT >= 21) {
      invalidateOutline();
    }
    AppMethodBeat.o(209298);
  }
  
  public final boolean VY()
  {
    AppMethodBeat.i(209328);
    playSoundEffect(0);
    if (this.drz != null) {
      this.drz.onClick(this);
    }
    for (boolean bool = true;; bool = false)
    {
      this.drG.sendEventForVirtualView(0, 1);
      AppMethodBeat.o(209328);
      return bool;
    }
  }
  
  protected boolean dispatchHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209349);
    if ((m(paramMotionEvent)) || (this.drG.dispatchHoverEvent(paramMotionEvent)) || (super.dispatchHoverEvent(paramMotionEvent)))
    {
      AppMethodBeat.o(209349);
      return true;
    }
    AppMethodBeat.o(209349);
    return false;
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(209354);
    if ((this.drG.dispatchKeyEvent(paramKeyEvent)) || (super.dispatchKeyEvent(paramKeyEvent)))
    {
      AppMethodBeat.o(209354);
      return true;
    }
    AppMethodBeat.o(209354);
    return false;
  }
  
  protected void drawableStateChanged()
  {
    int k = 1;
    boolean bool2 = false;
    AppMethodBeat.i(209391);
    super.drawableStateChanged();
    boolean bool1 = bool2;
    a locala;
    if (this.drx != null)
    {
      bool1 = bool2;
      if (a.H(this.drx.drX))
      {
        locala = this.drx;
        if (!isEnabled()) {
          break label234;
        }
      }
    }
    label234:
    for (int j = 1;; j = 0)
    {
      int i = j;
      if (this.drF) {
        i = j + 1;
      }
      j = i;
      if (this.drE) {
        j = i + 1;
      }
      i = j;
      if (this.drD) {
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
        if (this.drF)
        {
          arrayOfInt[j] = 16842908;
          i = j + 1;
        }
        j = i;
        if (this.drE)
        {
          arrayOfInt[i] = 16843623;
          j = i + 1;
        }
        i = j;
        if (this.drD)
        {
          arrayOfInt[j] = 16842919;
          i = j + 1;
        }
        if (isChecked()) {
          arrayOfInt[i] = 16842913;
        }
        bool1 = locala.q(arrayOfInt);
        if (bool1) {
          invalidate();
        }
        AppMethodBeat.o(209391);
        return;
      }
    }
  }
  
  public Drawable getCheckedIcon()
  {
    if (this.drx != null) {
      return this.drx.dsd;
    }
    return null;
  }
  
  public ColorStateList getChipBackgroundColor()
  {
    if (this.drx != null) {
      return this.drx.drK;
    }
    return null;
  }
  
  public float getChipCornerRadius()
  {
    if (this.drx != null) {
      return this.drx.drM;
    }
    return 0.0F;
  }
  
  public Drawable getChipDrawable()
  {
    return this.drx;
  }
  
  public float getChipEndPadding()
  {
    if (this.drx != null) {
      return this.drx.dsn;
    }
    return 0.0F;
  }
  
  public Drawable getChipIcon()
  {
    AppMethodBeat.i(209620);
    if (this.drx != null)
    {
      Drawable localDrawable = this.drx.getChipIcon();
      AppMethodBeat.o(209620);
      return localDrawable;
    }
    AppMethodBeat.o(209620);
    return null;
  }
  
  public float getChipIconSize()
  {
    if (this.drx != null) {
      return this.drx.drV;
    }
    return 0.0F;
  }
  
  public ColorStateList getChipIconTint()
  {
    if (this.drx != null) {
      return this.drx.drU;
    }
    return null;
  }
  
  public float getChipMinHeight()
  {
    if (this.drx != null) {
      return this.drx.drL;
    }
    return 0.0F;
  }
  
  public float getChipStartPadding()
  {
    if (this.drx != null) {
      return this.drx.dsg;
    }
    return 0.0F;
  }
  
  public ColorStateList getChipStrokeColor()
  {
    if (this.drx != null) {
      return this.drx.drN;
    }
    return null;
  }
  
  public float getChipStrokeWidth()
  {
    if (this.drx != null) {
      return this.drx.drO;
    }
    return 0.0F;
  }
  
  @Deprecated
  public CharSequence getChipText()
  {
    AppMethodBeat.i(209530);
    CharSequence localCharSequence = getText();
    AppMethodBeat.o(209530);
    return localCharSequence;
  }
  
  public Drawable getCloseIcon()
  {
    AppMethodBeat.i(209706);
    if (this.drx != null)
    {
      Drawable localDrawable = this.drx.getCloseIcon();
      AppMethodBeat.o(209706);
      return localDrawable;
    }
    AppMethodBeat.o(209706);
    return null;
  }
  
  public CharSequence getCloseIconContentDescription()
  {
    if (this.drx != null) {
      return this.drx.dsa;
    }
    return null;
  }
  
  public float getCloseIconEndPadding()
  {
    if (this.drx != null) {
      return this.drx.dsm;
    }
    return 0.0F;
  }
  
  public float getCloseIconSize()
  {
    if (this.drx != null) {
      return this.drx.drZ;
    }
    return 0.0F;
  }
  
  public float getCloseIconStartPadding()
  {
    if (this.drx != null) {
      return this.drx.dsl;
    }
    return 0.0F;
  }
  
  public ColorStateList getCloseIconTint()
  {
    if (this.drx != null) {
      return this.drx.drY;
    }
    return null;
  }
  
  public TextUtils.TruncateAt getEllipsize()
  {
    if (this.drx != null) {
      return this.drx.dsK;
    }
    return null;
  }
  
  public void getFocusedRect(Rect paramRect)
  {
    AppMethodBeat.i(209380);
    if (this.drC == 0)
    {
      paramRect.set(getCloseIconTouchBoundsInt());
      AppMethodBeat.o(209380);
      return;
    }
    super.getFocusedRect(paramRect);
    AppMethodBeat.o(209380);
  }
  
  public h getHideMotionSpec()
  {
    if (this.drx != null) {
      return this.drx.dsf;
    }
    return null;
  }
  
  public float getIconEndPadding()
  {
    if (this.drx != null) {
      return this.drx.dsi;
    }
    return 0.0F;
  }
  
  public float getIconStartPadding()
  {
    if (this.drx != null) {
      return this.drx.dsh;
    }
    return 0.0F;
  }
  
  public ColorStateList getRippleColor()
  {
    if (this.drx != null) {
      return this.drx.drj;
    }
    return null;
  }
  
  public h getShowMotionSpec()
  {
    if (this.drx != null) {
      return this.drx.dse;
    }
    return null;
  }
  
  public CharSequence getText()
  {
    if (this.drx != null) {
      return this.drx.drP;
    }
    return "";
  }
  
  public float getTextEndPadding()
  {
    if (this.drx != null) {
      return this.drx.dsk;
    }
    return 0.0F;
  }
  
  public float getTextStartPadding()
  {
    if (this.drx != null) {
      return this.drx.dsj;
    }
    return 0.0F;
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    AppMethodBeat.i(209140);
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, drw);
    }
    AppMethodBeat.o(209140);
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209152);
    if ((TextUtils.isEmpty(getText())) || (this.drx == null) || (this.drx.dsL))
    {
      super.onDraw(paramCanvas);
      AppMethodBeat.o(209152);
      return;
    }
    int i = paramCanvas.save();
    a locala = this.drx;
    float f = getChipStartPadding();
    f = locala.Wg() + f + getTextStartPadding();
    if (z.U(this) == 0) {}
    for (;;)
    {
      paramCanvas.translate(f, 0.0F);
      super.onDraw(paramCanvas);
      paramCanvas.restoreToCount(i);
      AppMethodBeat.o(209152);
      return;
      f = -f;
    }
  }
  
  protected void onFocusChanged(boolean paramBoolean, int paramInt, Rect paramRect)
  {
    AppMethodBeat.i(209363);
    if (paramBoolean) {
      setFocusedVirtualView(-1);
    }
    for (;;)
    {
      invalidate();
      super.onFocusChanged(paramBoolean, paramInt, paramRect);
      this.drG.onFocusChanged(paramBoolean, paramInt, paramRect);
      AppMethodBeat.o(209363);
      return;
      setFocusedVirtualView(-2147483648);
    }
  }
  
  public boolean onHoverEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209341);
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = super.onHoverEvent(paramMotionEvent);
      AppMethodBeat.o(209341);
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
    AppMethodBeat.i(209374);
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
        AppMethodBeat.o(209374);
        return true;
        bool1 = bool2;
        if (paramKeyEvent.hasNoModifiers())
        {
          bool1 = bM(l.s(this));
          continue;
          bool1 = bool2;
          if (paramKeyEvent.hasNoModifiers())
          {
            bool1 = bool3;
            if (!l.s(this)) {
              bool1 = true;
            }
            bool1 = bM(bool1);
            continue;
            switch (this.drC)
            {
            default: 
              bool1 = bool2;
              break;
            case -1: 
              performClick();
              AppMethodBeat.o(209374);
              return true;
            case 0: 
              VY();
              AppMethodBeat.o(209374);
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
      AppMethodBeat.o(209374);
      return true;
      if (paramKeyEvent.hasModifiers(1))
      {
        i = 1;
        continue;
        bool1 = super.onKeyDown(paramInt, paramKeyEvent);
        AppMethodBeat.o(209374);
        return bool1;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  public PointerIcon onResolvePointerIcon(MotionEvent paramMotionEvent, int paramInt)
  {
    AppMethodBeat.i(209402);
    if ((getCloseIconTouchBounds().contains(paramMotionEvent.getX(), paramMotionEvent.getY())) && (isEnabled()))
    {
      paramMotionEvent = PointerIcon.getSystemIcon(getContext(), 1002);
      AppMethodBeat.o(209402);
      return paramMotionEvent;
    }
    AppMethodBeat.o(209402);
    return null;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(209336);
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
          AppMethodBeat.o(209336);
          return true;
          if (!bool) {
            break;
          }
          setCloseIconPressed(true);
          i = 1;
          continue;
          if (!this.drD) {
            break;
          }
          if (!bool) {
            setCloseIconPressed(false);
          }
          i = 1;
          continue;
          if (!this.drD) {
            break label147;
          }
          VY();
        }
      }
    }
    label147:
    for (i = 1;; i = 0)
    {
      setCloseIconPressed(false);
      break;
      AppMethodBeat.o(209336);
      return false;
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(209192);
    if ((paramDrawable != this.drx) && (paramDrawable != this.dry))
    {
      paramDrawable = new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
      AppMethodBeat.o(209192);
      throw paramDrawable;
    }
    super.setBackground(paramDrawable);
    AppMethodBeat.o(209192);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(209177);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    AppMethodBeat.o(209177);
    throw localUnsupportedOperationException;
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(209201);
    if ((paramDrawable != this.drx) && (paramDrawable != this.dry))
    {
      paramDrawable = new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
      AppMethodBeat.o(209201);
      throw paramDrawable;
    }
    super.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(209201);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(209179);
    UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    AppMethodBeat.o(209179);
    throw localUnsupportedOperationException;
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209162);
    paramColorStateList = new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    AppMethodBeat.o(209162);
    throw paramColorStateList;
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(209169);
    paramMode = new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    AppMethodBeat.o(209169);
    throw paramMode;
  }
  
  public void setCheckable(boolean paramBoolean)
  {
    AppMethodBeat.i(209789);
    if (this.drx != null) {
      this.drx.setCheckable(paramBoolean);
    }
    AppMethodBeat.o(209789);
  }
  
  public void setCheckableResource(int paramInt)
  {
    AppMethodBeat.i(209779);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setCheckable(locala.context.getResources().getBoolean(paramInt));
    }
    AppMethodBeat.o(209779);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    AppMethodBeat.i(209301);
    if (this.drx == null)
    {
      this.drB = paramBoolean;
      AppMethodBeat.o(209301);
      return;
    }
    if (this.drx.dsb)
    {
      boolean bool = isChecked();
      super.setChecked(paramBoolean);
      if ((bool != paramBoolean) && (this.drA != null)) {
        this.drA.onCheckedChanged(this, paramBoolean);
      }
    }
    AppMethodBeat.o(209301);
  }
  
  public void setCheckedIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(209843);
    if (this.drx != null) {
      this.drx.setCheckedIcon(paramDrawable);
    }
    AppMethodBeat.o(209843);
  }
  
  @Deprecated
  public void setCheckedIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(209822);
    setCheckedIconVisible(paramBoolean);
    AppMethodBeat.o(209822);
  }
  
  @Deprecated
  public void setCheckedIconEnabledResource(int paramInt)
  {
    AppMethodBeat.i(209815);
    setCheckedIconVisible(paramInt);
    AppMethodBeat.o(209815);
  }
  
  public void setCheckedIconResource(int paramInt)
  {
    AppMethodBeat.i(209833);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setCheckedIcon(androidx.appcompat.a.a.a.m(locala.context, paramInt));
    }
    AppMethodBeat.o(209833);
  }
  
  public void setCheckedIconVisible(int paramInt)
  {
    AppMethodBeat.i(209798);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setCheckedIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
    AppMethodBeat.o(209798);
  }
  
  public void setCheckedIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(209806);
    if (this.drx != null) {
      this.drx.setCheckedIconVisible(paramBoolean);
    }
    AppMethodBeat.o(209806);
  }
  
  public void setChipBackgroundColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209419);
    if (this.drx != null) {
      this.drx.setChipBackgroundColor(paramColorStateList);
    }
    AppMethodBeat.o(209419);
  }
  
  public void setChipBackgroundColorResource(int paramInt)
  {
    AppMethodBeat.i(209411);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipBackgroundColor(androidx.appcompat.a.a.a.l(locala.context, paramInt));
    }
    AppMethodBeat.o(209411);
  }
  
  public void setChipCornerRadius(float paramFloat)
  {
    AppMethodBeat.i(209456);
    if (this.drx != null) {
      this.drx.setChipCornerRadius(paramFloat);
    }
    AppMethodBeat.o(209456);
  }
  
  public void setChipCornerRadiusResource(int paramInt)
  {
    AppMethodBeat.i(209449);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipCornerRadius(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209449);
  }
  
  public void setChipDrawable(a parama)
  {
    AppMethodBeat.i(209131);
    if (this.drx != parama)
    {
      a locala = this.drx;
      if (locala != null) {
        locala.a(null);
      }
      this.drx = parama;
      this.drx.a(this);
      if (com.google.android.material.f.a.dwz)
      {
        this.dry = new RippleDrawable(com.google.android.material.f.a.g(this.drx.drj), this.drx, null);
        this.drx.bN(false);
        z.a(this, this.dry);
        AppMethodBeat.o(209131);
        return;
      }
      this.drx.bN(true);
      z.a(this, this.drx);
    }
    AppMethodBeat.o(209131);
  }
  
  public void setChipEndPadding(float paramFloat)
  {
    AppMethodBeat.i(210016);
    if (this.drx != null) {
      this.drx.setChipEndPadding(paramFloat);
    }
    AppMethodBeat.o(210016);
  }
  
  public void setChipEndPaddingResource(int paramInt)
  {
    AppMethodBeat.i(210014);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipEndPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(210014);
  }
  
  public void setChipIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(209634);
    if (this.drx != null) {
      this.drx.setChipIcon(paramDrawable);
    }
    AppMethodBeat.o(209634);
  }
  
  @Deprecated
  public void setChipIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(209611);
    setChipIconVisible(paramBoolean);
    AppMethodBeat.o(209611);
  }
  
  @Deprecated
  public void setChipIconEnabledResource(int paramInt)
  {
    AppMethodBeat.i(209605);
    setChipIconVisible(paramInt);
    AppMethodBeat.o(209605);
  }
  
  public void setChipIconResource(int paramInt)
  {
    AppMethodBeat.i(209627);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipIcon(androidx.appcompat.a.a.a.m(locala.context, paramInt));
    }
    AppMethodBeat.o(209627);
  }
  
  public void setChipIconSize(float paramFloat)
  {
    AppMethodBeat.i(209670);
    if (this.drx != null) {
      this.drx.setChipIconSize(paramFloat);
    }
    AppMethodBeat.o(209670);
  }
  
  public void setChipIconSizeResource(int paramInt)
  {
    AppMethodBeat.i(209666);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipIconSize(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209666);
  }
  
  public void setChipIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209656);
    if (this.drx != null) {
      this.drx.setChipIconTint(paramColorStateList);
    }
    AppMethodBeat.o(209656);
  }
  
  public void setChipIconTintResource(int paramInt)
  {
    AppMethodBeat.i(209649);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipIconTint(androidx.appcompat.a.a.a.l(locala.context, paramInt));
    }
    AppMethodBeat.o(209649);
  }
  
  public void setChipIconVisible(int paramInt)
  {
    AppMethodBeat.i(209593);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
    AppMethodBeat.o(209593);
  }
  
  public void setChipIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(209600);
    if (this.drx != null) {
      this.drx.setChipIconVisible(paramBoolean);
    }
    AppMethodBeat.o(209600);
  }
  
  public void setChipMinHeight(float paramFloat)
  {
    AppMethodBeat.i(209440);
    if (this.drx != null) {
      this.drx.setChipMinHeight(paramFloat);
    }
    AppMethodBeat.o(209440);
  }
  
  public void setChipMinHeightResource(int paramInt)
  {
    AppMethodBeat.i(209432);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipMinHeight(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209432);
  }
  
  public void setChipStartPadding(float paramFloat)
  {
    AppMethodBeat.i(209896);
    if (this.drx != null) {
      this.drx.setChipStartPadding(paramFloat);
    }
    AppMethodBeat.o(209896);
  }
  
  public void setChipStartPaddingResource(int paramInt)
  {
    AppMethodBeat.i(209889);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipStartPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209889);
  }
  
  public void setChipStrokeColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209476);
    if (this.drx != null) {
      this.drx.setChipStrokeColor(paramColorStateList);
    }
    AppMethodBeat.o(209476);
  }
  
  public void setChipStrokeColorResource(int paramInt)
  {
    AppMethodBeat.i(209468);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipStrokeColor(androidx.appcompat.a.a.a.l(locala.context, paramInt));
    }
    AppMethodBeat.o(209468);
  }
  
  public void setChipStrokeWidth(float paramFloat)
  {
    AppMethodBeat.i(209493);
    if (this.drx != null) {
      this.drx.setChipStrokeWidth(paramFloat);
    }
    AppMethodBeat.o(209493);
  }
  
  public void setChipStrokeWidthResource(int paramInt)
  {
    AppMethodBeat.i(209488);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setChipStrokeWidth(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209488);
  }
  
  @Deprecated
  public void setChipText(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209554);
    setText(paramCharSequence);
    AppMethodBeat.o(209554);
  }
  
  @Deprecated
  public void setChipTextResource(int paramInt)
  {
    AppMethodBeat.i(209547);
    setText(getResources().getString(paramInt));
    AppMethodBeat.o(209547);
  }
  
  public void setCloseIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(209718);
    if (this.drx != null) {
      this.drx.setCloseIcon(paramDrawable);
    }
    AppMethodBeat.o(209718);
  }
  
  public void setCloseIconContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(209765);
    if (this.drx != null)
    {
      a locala = this.drx;
      if (locala.dsa != paramCharSequence)
      {
        locala.dsa = androidx.core.e.a.DT().r(paramCharSequence);
        locala.invalidateSelf();
      }
    }
    AppMethodBeat.o(209765);
  }
  
  @Deprecated
  public void setCloseIconEnabled(boolean paramBoolean)
  {
    AppMethodBeat.i(209698);
    setCloseIconVisible(paramBoolean);
    AppMethodBeat.o(209698);
  }
  
  @Deprecated
  public void setCloseIconEnabledResource(int paramInt)
  {
    AppMethodBeat.i(209692);
    setCloseIconVisible(paramInt);
    AppMethodBeat.o(209692);
  }
  
  public void setCloseIconEndPadding(float paramFloat)
  {
    AppMethodBeat.i(210006);
    if (this.drx != null) {
      this.drx.setCloseIconEndPadding(paramFloat);
    }
    AppMethodBeat.o(210006);
  }
  
  public void setCloseIconEndPaddingResource(int paramInt)
  {
    AppMethodBeat.i(209997);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setCloseIconEndPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209997);
  }
  
  public void setCloseIconResource(int paramInt)
  {
    AppMethodBeat.i(209711);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setCloseIcon(androidx.appcompat.a.a.a.m(locala.context, paramInt));
    }
    AppMethodBeat.o(209711);
  }
  
  public void setCloseIconSize(float paramFloat)
  {
    AppMethodBeat.i(209757);
    if (this.drx != null) {
      this.drx.setCloseIconSize(paramFloat);
    }
    AppMethodBeat.o(209757);
  }
  
  public void setCloseIconSizeResource(int paramInt)
  {
    AppMethodBeat.i(209750);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setCloseIconSize(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209750);
  }
  
  public void setCloseIconStartPadding(float paramFloat)
  {
    AppMethodBeat.i(209984);
    if (this.drx != null) {
      this.drx.setCloseIconStartPadding(paramFloat);
    }
    AppMethodBeat.o(209984);
  }
  
  public void setCloseIconStartPaddingResource(int paramInt)
  {
    AppMethodBeat.i(209978);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setCloseIconStartPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209978);
  }
  
  public void setCloseIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209739);
    if (this.drx != null) {
      this.drx.setCloseIconTint(paramColorStateList);
    }
    AppMethodBeat.o(209739);
  }
  
  public void setCloseIconTintResource(int paramInt)
  {
    AppMethodBeat.i(209729);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setCloseIconTint(androidx.appcompat.a.a.a.l(locala.context, paramInt));
    }
    AppMethodBeat.o(209729);
  }
  
  public void setCloseIconVisible(int paramInt)
  {
    AppMethodBeat.i(209679);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setCloseIconVisible(locala.context.getResources().getBoolean(paramInt));
    }
    AppMethodBeat.o(209679);
  }
  
  public void setCloseIconVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(209683);
    if (this.drx != null) {
      this.drx.setCloseIconVisible(paramBoolean);
    }
    AppMethodBeat.o(209683);
  }
  
  public void setCompoundDrawables(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    AppMethodBeat.i(209213);
    if (paramDrawable1 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      AppMethodBeat.o(209213);
      throw paramDrawable1;
    }
    if (paramDrawable3 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      AppMethodBeat.o(209213);
      throw paramDrawable1;
    }
    super.setCompoundDrawables(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppMethodBeat.o(209213);
  }
  
  public void setCompoundDrawablesRelative(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    AppMethodBeat.i(209236);
    if (paramDrawable1 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      AppMethodBeat.o(209236);
      throw paramDrawable1;
    }
    if (paramDrawable3 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      AppMethodBeat.o(209236);
      throw paramDrawable1;
    }
    super.setCompoundDrawablesRelative(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppMethodBeat.o(209236);
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209242);
    UnsupportedOperationException localUnsupportedOperationException;
    if (paramInt1 != 0)
    {
      localUnsupportedOperationException = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      AppMethodBeat.o(209242);
      throw localUnsupportedOperationException;
    }
    if (paramInt3 != 0)
    {
      localUnsupportedOperationException = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      AppMethodBeat.o(209242);
      throw localUnsupportedOperationException;
    }
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(209242);
  }
  
  public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    AppMethodBeat.i(209250);
    if (paramDrawable1 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      AppMethodBeat.o(209250);
      throw paramDrawable1;
    }
    if (paramDrawable3 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      AppMethodBeat.o(209250);
      throw paramDrawable1;
    }
    super.setCompoundDrawablesRelativeWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppMethodBeat.o(209250);
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(209219);
    UnsupportedOperationException localUnsupportedOperationException;
    if (paramInt1 != 0)
    {
      localUnsupportedOperationException = new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
      AppMethodBeat.o(209219);
      throw localUnsupportedOperationException;
    }
    if (paramInt3 != 0)
    {
      localUnsupportedOperationException = new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
      AppMethodBeat.o(209219);
      throw localUnsupportedOperationException;
    }
    super.setCompoundDrawablesWithIntrinsicBounds(paramInt1, paramInt2, paramInt3, paramInt4);
    AppMethodBeat.o(209219);
  }
  
  public void setCompoundDrawablesWithIntrinsicBounds(Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    AppMethodBeat.i(209232);
    if (paramDrawable1 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
      AppMethodBeat.o(209232);
      throw paramDrawable1;
    }
    if (paramDrawable3 != null)
    {
      paramDrawable1 = new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
      AppMethodBeat.o(209232);
      throw paramDrawable1;
    }
    super.setCompoundDrawablesWithIntrinsicBounds(paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4);
    AppMethodBeat.o(209232);
  }
  
  public void setEllipsize(TextUtils.TruncateAt paramTruncateAt)
  {
    AppMethodBeat.i(209261);
    if (this.drx == null)
    {
      AppMethodBeat.o(209261);
      return;
    }
    if (paramTruncateAt == TextUtils.TruncateAt.MARQUEE)
    {
      paramTruncateAt = new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
      AppMethodBeat.o(209261);
      throw paramTruncateAt;
    }
    super.setEllipsize(paramTruncateAt);
    if (this.drx != null) {
      this.drx.dsK = paramTruncateAt;
    }
    AppMethodBeat.o(209261);
  }
  
  public void setGravity(int paramInt)
  {
    AppMethodBeat.i(209158);
    if (paramInt == 8388627) {
      super.setGravity(paramInt);
    }
    AppMethodBeat.o(209158);
  }
  
  public void setHideMotionSpec(h paramh)
  {
    if (this.drx != null) {
      this.drx.dsf = paramh;
    }
  }
  
  public void setHideMotionSpecResource(int paramInt)
  {
    AppMethodBeat.i(209872);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.dsf = h.B(locala.context, paramInt);
    }
    AppMethodBeat.o(209872);
  }
  
  public void setIconEndPadding(float paramFloat)
  {
    AppMethodBeat.i(209931);
    if (this.drx != null) {
      this.drx.setIconEndPadding(paramFloat);
    }
    AppMethodBeat.o(209931);
  }
  
  public void setIconEndPaddingResource(int paramInt)
  {
    AppMethodBeat.i(209924);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setIconEndPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209924);
  }
  
  public void setIconStartPadding(float paramFloat)
  {
    AppMethodBeat.i(209911);
    if (this.drx != null) {
      this.drx.setIconStartPadding(paramFloat);
    }
    AppMethodBeat.o(209911);
  }
  
  public void setIconStartPaddingResource(int paramInt)
  {
    AppMethodBeat.i(209906);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setIconStartPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209906);
  }
  
  public void setLines(int paramInt)
  {
    AppMethodBeat.i(209268);
    if (paramInt > 1)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
      AppMethodBeat.o(209268);
      throw localUnsupportedOperationException;
    }
    super.setLines(paramInt);
    AppMethodBeat.o(209268);
  }
  
  public void setMaxLines(int paramInt)
  {
    AppMethodBeat.i(209281);
    if (paramInt > 1)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
      AppMethodBeat.o(209281);
      throw localUnsupportedOperationException;
    }
    super.setMaxLines(paramInt);
    AppMethodBeat.o(209281);
  }
  
  public void setMaxWidth(int paramInt)
  {
    AppMethodBeat.i(209291);
    super.setMaxWidth(paramInt);
    if (this.drx != null) {
      this.drx.maxWidth = paramInt;
    }
    AppMethodBeat.o(209291);
  }
  
  public void setMinLines(int paramInt)
  {
    AppMethodBeat.i(209277);
    if (paramInt > 1)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
      AppMethodBeat.o(209277);
      throw localUnsupportedOperationException;
    }
    super.setMinLines(paramInt);
    AppMethodBeat.o(209277);
  }
  
  void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener)
  {
    this.drA = paramOnCheckedChangeListener;
  }
  
  public void setOnCloseIconClickListener(View.OnClickListener paramOnClickListener)
  {
    this.drz = paramOnClickListener;
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209513);
    if (this.drx != null) {
      this.drx.setRippleColor(paramColorStateList);
    }
    AppMethodBeat.o(209513);
  }
  
  public void setRippleColorResource(int paramInt)
  {
    AppMethodBeat.i(209509);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setRippleColor(androidx.appcompat.a.a.a.l(locala.context, paramInt));
    }
    AppMethodBeat.o(209509);
  }
  
  public void setShowMotionSpec(h paramh)
  {
    if (this.drx != null) {
      this.drx.dse = paramh;
    }
  }
  
  public void setShowMotionSpecResource(int paramInt)
  {
    AppMethodBeat.i(209854);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.dse = h.B(locala.context, paramInt);
    }
    AppMethodBeat.o(209854);
  }
  
  public void setSingleLine(boolean paramBoolean)
  {
    AppMethodBeat.i(209263);
    if (!paramBoolean)
    {
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException("Chip does not support multi-line text");
      AppMethodBeat.o(209263);
      throw localUnsupportedOperationException;
    }
    super.setSingleLine(paramBoolean);
    AppMethodBeat.o(209263);
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    AppMethodBeat.i(209538);
    if (this.drx == null)
    {
      AppMethodBeat.o(209538);
      return;
    }
    Object localObject = paramCharSequence;
    if (paramCharSequence == null) {
      localObject = "";
    }
    paramCharSequence = androidx.core.e.a.DT().r((CharSequence)localObject);
    if (this.drx.dsL) {
      paramCharSequence = null;
    }
    super.setText(paramCharSequence, paramBufferType);
    if (this.drx != null) {
      this.drx.setText((CharSequence)localObject);
    }
    AppMethodBeat.o(209538);
  }
  
  public void setTextAppearance(int paramInt)
  {
    AppMethodBeat.i(209587);
    super.setTextAppearance(paramInt);
    if (this.drx != null) {
      this.drx.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(getContext(), getPaint(), this.drH);
      a(getTextAppearance());
    }
    AppMethodBeat.o(209587);
  }
  
  public void setTextAppearance(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(209579);
    super.setTextAppearance(paramContext, paramInt);
    if (this.drx != null) {
      this.drx.setTextAppearanceResource(paramInt);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(paramContext, getPaint(), this.drH);
      a(getTextAppearance());
    }
    AppMethodBeat.o(209579);
  }
  
  public void setTextAppearance(b paramb)
  {
    AppMethodBeat.i(209573);
    if (this.drx != null) {
      this.drx.setTextAppearance(paramb);
    }
    if (getTextAppearance() != null)
    {
      getTextAppearance().c(getContext(), getPaint(), this.drH);
      a(paramb);
    }
    AppMethodBeat.o(209573);
  }
  
  public void setTextAppearanceResource(int paramInt)
  {
    AppMethodBeat.i(209565);
    if (this.drx != null) {
      this.drx.setTextAppearanceResource(paramInt);
    }
    setTextAppearance(getContext(), paramInt);
    AppMethodBeat.o(209565);
  }
  
  public void setTextEndPadding(float paramFloat)
  {
    AppMethodBeat.i(209967);
    if (this.drx != null) {
      this.drx.setTextEndPadding(paramFloat);
    }
    AppMethodBeat.o(209967);
  }
  
  public void setTextEndPaddingResource(int paramInt)
  {
    AppMethodBeat.i(209960);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setTextEndPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209960);
  }
  
  public void setTextStartPadding(float paramFloat)
  {
    AppMethodBeat.i(209948);
    if (this.drx != null) {
      this.drx.setTextStartPadding(paramFloat);
    }
    AppMethodBeat.o(209948);
  }
  
  public void setTextStartPaddingResource(int paramInt)
  {
    AppMethodBeat.i(209943);
    if (this.drx != null)
    {
      a locala = this.drx;
      locala.setTextStartPadding(locala.context.getResources().getDimension(paramInt));
    }
    AppMethodBeat.o(209943);
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
      AppMethodBeat.i(208994);
      if ((Chip.b(Chip.this)) && (Chip.c(Chip.this).contains(paramFloat1, paramFloat2)))
      {
        AppMethodBeat.o(208994);
        return 0;
      }
      AppMethodBeat.o(208994);
      return -1;
    }
    
    public final void getVisibleVirtualViews(List<Integer> paramList)
    {
      AppMethodBeat.i(209000);
      if (Chip.b(Chip.this)) {
        paramList.add(Integer.valueOf(0));
      }
      AppMethodBeat.o(209000);
    }
    
    public final boolean onPerformActionForVirtualView(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      AppMethodBeat.i(209020);
      if ((paramInt2 == 16) && (paramInt1 == 0))
      {
        boolean bool = Chip.this.VY();
        AppMethodBeat.o(209020);
        return bool;
      }
      AppMethodBeat.o(209020);
      return false;
    }
    
    public final void onPopulateNodeForHost(d paramd)
    {
      AppMethodBeat.i(209015);
      if ((Chip.a(Chip.this) != null) && (Chip.a(Chip.this).dsb)) {}
      CharSequence localCharSequence;
      for (boolean bool = true;; bool = false)
      {
        paramd.setCheckable(bool);
        paramd.v(Chip.class.getName());
        localCharSequence = Chip.this.getText();
        if (Build.VERSION.SDK_INT < 23) {
          break;
        }
        paramd.setText(localCharSequence);
        AppMethodBeat.o(209015);
        return;
      }
      paramd.setContentDescription(localCharSequence);
      AppMethodBeat.o(209015);
    }
    
    public final void onPopulateNodeForVirtualView(int paramInt, d paramd)
    {
      AppMethodBeat.i(209009);
      if (Chip.b(Chip.this))
      {
        Object localObject = Chip.this.getCloseIconContentDescription();
        if (localObject != null)
        {
          paramd.setContentDescription((CharSequence)localObject);
          paramd.k(Chip.d(Chip.this));
          paramd.a(d.a.buW);
          paramd.setEnabled(Chip.this.isEnabled());
          AppMethodBeat.o(209009);
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
      paramd.k(Chip.Wb());
      AppMethodBeat.o(209009);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.chip.Chip
 * JD-Core Version:    0.7.0.1
 */