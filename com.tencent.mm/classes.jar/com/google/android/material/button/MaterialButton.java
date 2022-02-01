package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.g.w;
import androidx.core.widget.i;
import com.google.android.material.a.b;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MaterialButton
  extends AppCompatButton
{
  private ColorStateList bwO;
  private final b bxT;
  private PorterDuff.Mode bxU;
  private Drawable bxV;
  private int bxW;
  private int iconGravity;
  private int iconPadding;
  private int iconSize;
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, a.b.materialButtonStyle);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(235505);
    paramAttributeSet = k.a(paramContext, paramAttributeSet, a.k.MaterialButton, paramInt, a.j.Widget_MaterialComponents_Button, new int[0]);
    this.iconPadding = paramAttributeSet.getDimensionPixelSize(a.k.MaterialButton_iconPadding, 0);
    this.bxU = l.c(paramAttributeSet.getInt(a.k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.bwO = com.google.android.material.e.a.b(getContext(), paramAttributeSet, a.k.MaterialButton_iconTint);
    this.bxV = com.google.android.material.e.a.c(getContext(), paramAttributeSet, a.k.MaterialButton_icon);
    this.iconGravity = paramAttributeSet.getInteger(a.k.MaterialButton_iconGravity, 1);
    this.iconSize = paramAttributeSet.getDimensionPixelSize(a.k.MaterialButton_iconSize, 0);
    this.bxT = new b(this);
    b localb = this.bxT;
    localb.bxZ = paramAttributeSet.getDimensionPixelOffset(a.k.MaterialButton_android_insetLeft, 0);
    localb.bya = paramAttributeSet.getDimensionPixelOffset(a.k.MaterialButton_android_insetRight, 0);
    localb.byb = paramAttributeSet.getDimensionPixelOffset(a.k.MaterialButton_android_insetTop, 0);
    localb.byc = paramAttributeSet.getDimensionPixelOffset(a.k.MaterialButton_android_insetBottom, 0);
    localb.cornerRadius = paramAttributeSet.getDimensionPixelSize(a.k.MaterialButton_cornerRadius, 0);
    localb.strokeWidth = paramAttributeSet.getDimensionPixelSize(a.k.MaterialButton_strokeWidth, 0);
    localb.byd = l.c(paramAttributeSet.getInt(a.k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
    localb.bye = com.google.android.material.e.a.b(localb.bxY.getContext(), paramAttributeSet, a.k.MaterialButton_backgroundTint);
    localb.byf = com.google.android.material.e.a.b(localb.bxY.getContext(), paramAttributeSet, a.k.MaterialButton_strokeColor);
    localb.byg = com.google.android.material.e.a.b(localb.bxY.getContext(), paramAttributeSet, a.k.MaterialButton_rippleColor);
    localb.byh.setStyle(Paint.Style.STROKE);
    localb.byh.setStrokeWidth(localb.strokeWidth);
    paramContext = localb.byh;
    int i;
    int j;
    int k;
    MaterialButton localMaterialButton;
    if (localb.byf != null)
    {
      paramInt = localb.byf.getColorForState(localb.bxY.getDrawableState(), 0);
      paramContext.setColor(paramInt);
      paramInt = w.L(localb.bxY);
      i = localb.bxY.getPaddingTop();
      j = w.M(localb.bxY);
      k = localb.bxY.getPaddingBottom();
      localMaterialButton = localb.bxY;
      if (!b.bxX) {
        break label479;
      }
    }
    for (paramContext = localb.ws();; paramContext = localb.w(new LayerDrawable(new Drawable[] { localb.byl, localb.byn })))
    {
      localMaterialButton.setInternalBackground(paramContext);
      w.g(localb.bxY, paramInt + localb.bxZ, i + localb.byb, j + localb.bya, localb.byc + k);
      paramAttributeSet.recycle();
      setCompoundDrawablePadding(this.iconPadding);
      wp();
      AppMethodBeat.o(235505);
      return;
      paramInt = 0;
      break;
      label479:
      localb.byk = new GradientDrawable();
      localb.byk.setCornerRadius(localb.cornerRadius + 1.0E-005F);
      localb.byk.setColor(-1);
      localb.byl = androidx.core.graphics.drawable.a.p(localb.byk);
      androidx.core.graphics.drawable.a.a(localb.byl, localb.bye);
      if (localb.byd != null) {
        androidx.core.graphics.drawable.a.a(localb.byl, localb.byd);
      }
      localb.bym = new GradientDrawable();
      localb.bym.setCornerRadius(localb.cornerRadius + 1.0E-005F);
      localb.bym.setColor(-1);
      localb.byn = androidx.core.graphics.drawable.a.p(localb.bym);
      androidx.core.graphics.drawable.a.a(localb.byn, localb.byg);
    }
  }
  
  private void wp()
  {
    AppMethodBeat.i(235553);
    int i;
    if (this.bxV != null)
    {
      this.bxV = this.bxV.mutate();
      androidx.core.graphics.drawable.a.a(this.bxV, this.bwO);
      if (this.bxU != null) {
        androidx.core.graphics.drawable.a.a(this.bxV, this.bxU);
      }
      if (this.iconSize == 0) {
        break label114;
      }
      i = this.iconSize;
      if (this.iconSize == 0) {
        break label125;
      }
    }
    label114:
    label125:
    for (int j = this.iconSize;; j = this.bxV.getIntrinsicHeight())
    {
      this.bxV.setBounds(this.bxW, 0, i + this.bxW, j);
      i.a(this, this.bxV, null, null, null);
      AppMethodBeat.o(235553);
      return;
      i = this.bxV.getIntrinsicWidth();
      break;
    }
  }
  
  private boolean wq()
  {
    return (this.bxT != null) && (!this.bxT.byr);
  }
  
  public ColorStateList getBackgroundTintList()
  {
    AppMethodBeat.i(235520);
    ColorStateList localColorStateList = getSupportBackgroundTintList();
    AppMethodBeat.o(235520);
    return localColorStateList;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    AppMethodBeat.i(235523);
    PorterDuff.Mode localMode = getSupportBackgroundTintMode();
    AppMethodBeat.o(235523);
    return localMode;
  }
  
  public int getCornerRadius()
  {
    AppMethodBeat.i(235581);
    if (wq())
    {
      int i = this.bxT.cornerRadius;
      AppMethodBeat.o(235581);
      return i;
    }
    AppMethodBeat.o(235581);
    return 0;
  }
  
  public Drawable getIcon()
  {
    return this.bxV;
  }
  
  public int getIconGravity()
  {
    return this.iconGravity;
  }
  
  public int getIconPadding()
  {
    return this.iconPadding;
  }
  
  public int getIconSize()
  {
    return this.iconSize;
  }
  
  public ColorStateList getIconTint()
  {
    return this.bwO;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.bxU;
  }
  
  public ColorStateList getRippleColor()
  {
    AppMethodBeat.i(235560);
    if (wq())
    {
      ColorStateList localColorStateList = this.bxT.byg;
      AppMethodBeat.o(235560);
      return localColorStateList;
    }
    AppMethodBeat.o(235560);
    return null;
  }
  
  public ColorStateList getStrokeColor()
  {
    AppMethodBeat.i(235566);
    if (wq())
    {
      ColorStateList localColorStateList = this.bxT.byf;
      AppMethodBeat.o(235566);
      return localColorStateList;
    }
    AppMethodBeat.o(235566);
    return null;
  }
  
  public int getStrokeWidth()
  {
    AppMethodBeat.i(235573);
    if (wq())
    {
      int i = this.bxT.strokeWidth;
      AppMethodBeat.o(235573);
      return i;
    }
    AppMethodBeat.o(235573);
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(235512);
    if (wq())
    {
      localColorStateList = this.bxT.bye;
      AppMethodBeat.o(235512);
      return localColorStateList;
    }
    ColorStateList localColorStateList = super.getSupportBackgroundTintList();
    AppMethodBeat.o(235512);
    return localColorStateList;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(235516);
    if (wq())
    {
      localMode = this.bxT.byd;
      AppMethodBeat.o(235516);
      return localMode;
    }
    PorterDuff.Mode localMode = super.getSupportBackgroundTintMode();
    AppMethodBeat.o(235516);
    return localMode;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(235508);
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (wq()))
    {
      b localb = this.bxT;
      if ((paramCanvas != null) && (localb.byf != null) && (localb.strokeWidth > 0))
      {
        localb.byi.set(localb.bxY.getBackground().getBounds());
        localb.byj.set(localb.byi.left + localb.strokeWidth / 2.0F + localb.bxZ, localb.byi.top + localb.strokeWidth / 2.0F + localb.byb, localb.byi.right - localb.strokeWidth / 2.0F - localb.bya, localb.byi.bottom - localb.strokeWidth / 2.0F - localb.byc);
        float f = localb.cornerRadius - localb.strokeWidth / 2.0F;
        paramCanvas.drawRoundRect(localb.byj, f, f, localb.byh);
      }
    }
    AppMethodBeat.o(235508);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(235532);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT == 21) && (this.bxT != null))
    {
      b localb = this.bxT;
      if (localb.byq != null) {
        localb.byq.setBounds(localb.bxZ, localb.byb, paramInt3 - paramInt1 - localb.bya, paramInt4 - paramInt2 - localb.byc);
      }
    }
    AppMethodBeat.o(235532);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(235534);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.bxV == null) || (this.iconGravity != 2))
    {
      AppMethodBeat.o(235534);
      return;
    }
    paramInt2 = (int)getPaint().measureText(getText().toString());
    int j;
    if (this.iconSize == 0)
    {
      paramInt1 = this.bxV.getIntrinsicWidth();
      j = (getMeasuredWidth() - paramInt2 - w.M(this) - paramInt1 - this.iconPadding - w.L(this)) / 2;
      if (w.I(this) != 1) {
        break label149;
      }
    }
    label149:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      paramInt2 = j;
      if (paramInt1 != 0) {
        paramInt2 = -j;
      }
      if (this.bxW != paramInt2)
      {
        this.bxW = paramInt2;
        wp();
      }
      AppMethodBeat.o(235534);
      return;
      paramInt1 = this.iconSize;
      break;
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(235527);
    setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(235527);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(235525);
    if (wq())
    {
      b localb = this.bxT;
      if ((b.bxX) && (localb.byo != null))
      {
        localb.byo.setColor(paramInt);
        AppMethodBeat.o(235525);
        return;
      }
      if ((!b.bxX) && (localb.byk != null)) {
        localb.byk.setColor(paramInt);
      }
      AppMethodBeat.o(235525);
      return;
    }
    super.setBackgroundColor(paramInt);
    AppMethodBeat.o(235525);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(235530);
    if (wq())
    {
      if (paramDrawable != getBackground())
      {
        b localb = this.bxT;
        localb.byr = true;
        localb.bxY.setSupportBackgroundTintList(localb.bye);
        localb.bxY.setSupportBackgroundTintMode(localb.byd);
      }
    }
    else
    {
      super.setBackgroundDrawable(paramDrawable);
      AppMethodBeat.o(235530);
      return;
    }
    getBackground().setState(paramDrawable.getState());
    AppMethodBeat.o(235530);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(235529);
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = androidx.appcompat.a.a.a.m(getContext(), paramInt);
    }
    setBackgroundDrawable(localDrawable);
    AppMethodBeat.o(235529);
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235518);
    setSupportBackgroundTintList(paramColorStateList);
    AppMethodBeat.o(235518);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(235521);
    setSupportBackgroundTintMode(paramMode);
    AppMethodBeat.o(235521);
  }
  
  public void setCornerRadius(int paramInt)
  {
    AppMethodBeat.i(235576);
    if (wq())
    {
      b localb = this.bxT;
      if (localb.cornerRadius != paramInt)
      {
        localb.cornerRadius = paramInt;
        if ((b.bxX) && (localb.byo != null) && (localb.byp != null) && (localb.byq != null))
        {
          if (Build.VERSION.SDK_INT == 21)
          {
            if ((!b.bxX) || (localb.bxY.getBackground() == null)) {
              break label226;
            }
            localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.bxY.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
            localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
            if ((!b.bxX) || (localb.bxY.getBackground() == null)) {
              break label231;
            }
          }
          label226:
          label231:
          for (GradientDrawable localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.bxY.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);; localGradientDrawable = null)
          {
            localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
            localb.byo.setCornerRadius(paramInt + 1.0E-005F);
            localb.byp.setCornerRadius(paramInt + 1.0E-005F);
            localb.byq.setCornerRadius(paramInt + 1.0E-005F);
            AppMethodBeat.o(235576);
            return;
            localGradientDrawable = null;
            break;
          }
        }
        if ((!b.bxX) && (localb.byk != null) && (localb.bym != null))
        {
          localb.byk.setCornerRadius(paramInt + 1.0E-005F);
          localb.bym.setCornerRadius(paramInt + 1.0E-005F);
          localb.bxY.invalidate();
        }
      }
    }
    AppMethodBeat.o(235576);
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    AppMethodBeat.i(235579);
    if (wq()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
    AppMethodBeat.o(235579);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(235541);
    if (this.bxV != paramDrawable)
    {
      this.bxV = paramDrawable;
      wp();
    }
    AppMethodBeat.o(235541);
  }
  
  public void setIconGravity(int paramInt)
  {
    this.iconGravity = paramInt;
  }
  
  public void setIconPadding(int paramInt)
  {
    AppMethodBeat.i(235536);
    if (this.iconPadding != paramInt)
    {
      this.iconPadding = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
    AppMethodBeat.o(235536);
  }
  
  public void setIconResource(int paramInt)
  {
    AppMethodBeat.i(235543);
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = androidx.appcompat.a.a.a.m(getContext(), paramInt);
    }
    setIcon(localDrawable);
    AppMethodBeat.o(235543);
  }
  
  public void setIconSize(int paramInt)
  {
    AppMethodBeat.i(235538);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("iconSize cannot be less than 0");
      AppMethodBeat.o(235538);
      throw localIllegalArgumentException;
    }
    if (this.iconSize != paramInt)
    {
      this.iconSize = paramInt;
      wp();
    }
    AppMethodBeat.o(235538);
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235546);
    if (this.bwO != paramColorStateList)
    {
      this.bwO = paramColorStateList;
      wp();
    }
    AppMethodBeat.o(235546);
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(235550);
    if (this.bxU != paramMode)
    {
      this.bxU = paramMode;
      wp();
    }
    AppMethodBeat.o(235550);
  }
  
  public void setIconTintResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(235547);
    setIconTint(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    AppMethodBeat.o(235547);
  }
  
  void setInternalBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(235535);
    super.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(235535);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235556);
    if (wq())
    {
      b localb = this.bxT;
      if (localb.byg != paramColorStateList)
      {
        localb.byg = paramColorStateList;
        if ((b.bxX) && ((localb.bxY.getBackground() instanceof RippleDrawable)))
        {
          ((RippleDrawable)localb.bxY.getBackground()).setColor(paramColorStateList);
          AppMethodBeat.o(235556);
          return;
        }
        if ((!b.bxX) && (localb.byn != null)) {
          androidx.core.graphics.drawable.a.a(localb.byn, paramColorStateList);
        }
      }
    }
    AppMethodBeat.o(235556);
  }
  
  public void setRippleColorResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(235558);
    if (wq()) {
      setRippleColor(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    }
    AppMethodBeat.o(235558);
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    int i = 0;
    AppMethodBeat.i(235562);
    if (wq())
    {
      b localb = this.bxT;
      if (localb.byf != paramColorStateList)
      {
        localb.byf = paramColorStateList;
        Paint localPaint = localb.byh;
        if (paramColorStateList != null) {
          i = paramColorStateList.getColorForState(localb.bxY.getDrawableState(), 0);
        }
        localPaint.setColor(i);
        localb.wt();
      }
    }
    AppMethodBeat.o(235562);
  }
  
  public void setStrokeColorResource(@androidx.annotation.a int paramInt)
  {
    AppMethodBeat.i(235565);
    if (wq()) {
      setStrokeColor(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    }
    AppMethodBeat.o(235565);
  }
  
  public void setStrokeWidth(int paramInt)
  {
    AppMethodBeat.i(235568);
    if (wq())
    {
      b localb = this.bxT;
      if (localb.strokeWidth != paramInt)
      {
        localb.strokeWidth = paramInt;
        localb.byh.setStrokeWidth(paramInt);
        localb.wt();
      }
    }
    AppMethodBeat.o(235568);
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    AppMethodBeat.i(235571);
    if (wq()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
    AppMethodBeat.o(235571);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(235510);
    if (wq())
    {
      b localb = this.bxT;
      if (localb.bye != paramColorStateList)
      {
        localb.bye = paramColorStateList;
        if (b.bxX)
        {
          localb.wr();
          AppMethodBeat.o(235510);
          return;
        }
        if (localb.byl != null) {
          androidx.core.graphics.drawable.a.a(localb.byl, localb.bye);
        }
      }
      AppMethodBeat.o(235510);
      return;
    }
    if (this.bxT != null) {
      super.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(235510);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(235514);
    if (wq())
    {
      b localb = this.bxT;
      if (localb.byd != paramMode)
      {
        localb.byd = paramMode;
        if (b.bxX)
        {
          localb.wr();
          AppMethodBeat.o(235514);
          return;
        }
        if ((localb.byl != null) && (localb.byd != null)) {
          androidx.core.graphics.drawable.a.a(localb.byl, localb.byd);
        }
      }
      AppMethodBeat.o(235514);
      return;
    }
    if (this.bxT != null) {
      super.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(235514);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.button.MaterialButton
 * JD-Core Version:    0.7.0.1
 */