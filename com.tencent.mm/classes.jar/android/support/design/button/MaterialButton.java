package android.support.design.button;

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
import android.support.design.a.a;
import android.support.design.internal.f;
import android.support.design.internal.g;
import android.support.v4.view.t;
import android.support.v4.widget.q;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class MaterialButton
  extends AppCompatButton
{
  private int hA;
  private int hB;
  private int hC;
  private final b hw;
  private int hx;
  private PorterDuff.Mode hy;
  private ColorStateList hz;
  private Drawable icon;
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969294);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = f.a(paramContext, paramAttributeSet, a.a.MaterialButton, paramInt, 2131821648, new int[0]);
    this.hx = paramAttributeSet.getDimensionPixelSize(9, 0);
    this.hy = g.a(paramAttributeSet.getInt(12, -1), PorterDuff.Mode.SRC_IN);
    this.hz = android.support.design.d.a.b(getContext(), paramAttributeSet, 11);
    this.icon = android.support.design.d.a.c(getContext(), paramAttributeSet, 7);
    this.hC = paramAttributeSet.getInteger(8, 1);
    this.hA = paramAttributeSet.getDimensionPixelSize(10, 0);
    this.hw = new b(this);
    b localb = this.hw;
    localb.insetLeft = paramAttributeSet.getDimensionPixelOffset(0, 0);
    localb.insetRight = paramAttributeSet.getDimensionPixelOffset(1, 0);
    localb.insetTop = paramAttributeSet.getDimensionPixelOffset(2, 0);
    localb.insetBottom = paramAttributeSet.getDimensionPixelOffset(3, 0);
    localb.hF = paramAttributeSet.getDimensionPixelSize(6, 0);
    localb.strokeWidth = paramAttributeSet.getDimensionPixelSize(15, 0);
    localb.hG = g.a(paramAttributeSet.getInt(5, -1), PorterDuff.Mode.SRC_IN);
    localb.hH = android.support.design.d.a.b(localb.hE.getContext(), paramAttributeSet, 4);
    localb.hI = android.support.design.d.a.b(localb.hE.getContext(), paramAttributeSet, 14);
    localb.hJ = android.support.design.d.a.b(localb.hE.getContext(), paramAttributeSet, 13);
    localb.hK.setStyle(Paint.Style.STROKE);
    localb.hK.setStrokeWidth(localb.strokeWidth);
    paramContext = localb.hK;
    int i;
    int j;
    int k;
    MaterialButton localMaterialButton;
    if (localb.hI != null)
    {
      paramInt = localb.hI.getColorForState(localb.hE.getDrawableState(), 0);
      paramContext.setColor(paramInt);
      paramInt = t.ab(localb.hE);
      i = localb.hE.getPaddingTop();
      j = t.ac(localb.hE);
      k = localb.hE.getPaddingBottom();
      localMaterialButton = localb.hE;
      if (!b.hD) {
        break label446;
      }
    }
    for (paramContext = localb.aY();; paramContext = localb.a(new LayerDrawable(new Drawable[] { localb.hO, localb.hQ })))
    {
      localMaterialButton.setInternalBackground(paramContext);
      t.d(localb.hE, paramInt + localb.insetLeft, i + localb.insetTop, j + localb.insetRight, localb.insetBottom + k);
      paramAttributeSet.recycle();
      setCompoundDrawablePadding(this.hx);
      aV();
      return;
      paramInt = 0;
      break;
      label446:
      localb.hN = new GradientDrawable();
      localb.hN.setCornerRadius(localb.hF + 1.0E-005F);
      localb.hN.setColor(-1);
      localb.hO = android.support.v4.graphics.drawable.a.i(localb.hN);
      android.support.v4.graphics.drawable.a.a(localb.hO, localb.hH);
      if (localb.hG != null) {
        android.support.v4.graphics.drawable.a.a(localb.hO, localb.hG);
      }
      localb.hP = new GradientDrawable();
      localb.hP.setCornerRadius(localb.hF + 1.0E-005F);
      localb.hP.setColor(-1);
      localb.hQ = android.support.v4.graphics.drawable.a.i(localb.hP);
      android.support.v4.graphics.drawable.a.a(localb.hQ, localb.hJ);
    }
  }
  
  private void aV()
  {
    int i;
    if (this.icon != null)
    {
      this.icon = this.icon.mutate();
      android.support.v4.graphics.drawable.a.a(this.icon, this.hz);
      if (this.hy != null) {
        android.support.v4.graphics.drawable.a.a(this.icon, this.hy);
      }
      if (this.hA == 0) {
        break label102;
      }
      i = this.hA;
      if (this.hA == 0) {
        break label113;
      }
    }
    label102:
    label113:
    for (int j = this.hA;; j = this.icon.getIntrinsicHeight())
    {
      this.icon.setBounds(this.hB, 0, i + this.hB, j);
      q.a(this, this.icon, null, null, null);
      return;
      i = this.icon.getIntrinsicWidth();
      break;
    }
  }
  
  private boolean aW()
  {
    return (this.hw != null) && (!this.hw.hU);
  }
  
  public ColorStateList getBackgroundTintList()
  {
    return getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    return getSupportBackgroundTintMode();
  }
  
  public int getCornerRadius()
  {
    if (aW()) {
      return this.hw.hF;
    }
    return 0;
  }
  
  public Drawable getIcon()
  {
    return this.icon;
  }
  
  public int getIconGravity()
  {
    return this.hC;
  }
  
  public int getIconPadding()
  {
    return this.hx;
  }
  
  public int getIconSize()
  {
    return this.hA;
  }
  
  public ColorStateList getIconTint()
  {
    return this.hz;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.hy;
  }
  
  public ColorStateList getRippleColor()
  {
    if (aW()) {
      return this.hw.hJ;
    }
    return null;
  }
  
  public ColorStateList getStrokeColor()
  {
    if (aW()) {
      return this.hw.hI;
    }
    return null;
  }
  
  public int getStrokeWidth()
  {
    if (aW()) {
      return this.hw.strokeWidth;
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (aW()) {
      return this.hw.hH;
    }
    return super.getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (aW()) {
      return this.hw.hG;
    }
    return super.getSupportBackgroundTintMode();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (aW()))
    {
      b localb = this.hw;
      if ((paramCanvas != null) && (localb.hI != null) && (localb.strokeWidth > 0))
      {
        localb.hL.set(localb.hE.getBackground().getBounds());
        localb.hM.set(localb.hL.left + localb.strokeWidth / 2.0F + localb.insetLeft, localb.hL.top + localb.strokeWidth / 2.0F + localb.insetTop, localb.hL.right - localb.strokeWidth / 2.0F - localb.insetRight, localb.hL.bottom - localb.strokeWidth / 2.0F - localb.insetBottom);
        float f = localb.hF - localb.strokeWidth / 2.0F;
        paramCanvas.drawRoundRect(localb.hM, f, f, localb.hK);
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT == 21) && (this.hw != null))
    {
      b localb = this.hw;
      if (localb.hT != null) {
        localb.hT.setBounds(localb.insetLeft, localb.insetTop, paramInt3 - paramInt1 - localb.insetRight, paramInt4 - paramInt2 - localb.insetBottom);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    super.onMeasure(paramInt1, paramInt2);
    if ((this.icon == null) || (this.hC != 2)) {
      return;
    }
    paramInt2 = (int)getPaint().measureText(getText().toString());
    label57:
    int j;
    if (this.hA == 0)
    {
      paramInt1 = this.icon.getIntrinsicWidth();
      j = (getMeasuredWidth() - paramInt2 - t.ac(this) - paramInt1 - this.hx - t.ab(this)) / 2;
      if (t.Y(this) != 1) {
        break label131;
      }
    }
    label131:
    for (paramInt1 = i;; paramInt1 = 0)
    {
      paramInt2 = j;
      if (paramInt1 != 0) {
        paramInt2 = -j;
      }
      if (this.hB == paramInt2) {
        break;
      }
      this.hB = paramInt2;
      aV();
      return;
      paramInt1 = this.hA;
      break label57;
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (aW())
    {
      b localb = this.hw;
      if ((b.hD) && (localb.hR != null)) {
        localb.hR.setColor(paramInt);
      }
      while ((b.hD) || (localb.hN == null)) {
        return;
      }
      localb.hN.setColor(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (aW())
    {
      if (paramDrawable != getBackground())
      {
        b localb = this.hw;
        localb.hU = true;
        localb.hE.setSupportBackgroundTintList(localb.hH);
        localb.hE.setSupportBackgroundTintMode(localb.hG);
      }
    }
    else
    {
      super.setBackgroundDrawable(paramDrawable);
      return;
    }
    getBackground().setState(paramDrawable.getState());
  }
  
  public void setBackgroundResource(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = android.support.v7.c.a.a.l(getContext(), paramInt);
    }
    setBackgroundDrawable(localDrawable);
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setSupportBackgroundTintMode(paramMode);
  }
  
  public void setCornerRadius(int paramInt)
  {
    b localb;
    if (aW())
    {
      localb = this.hw;
      if (localb.hF != paramInt)
      {
        localb.hF = paramInt;
        if ((!b.hD) || (localb.hR == null) || (localb.hS == null) || (localb.hT == null)) {
          break label219;
        }
        if (Build.VERSION.SDK_INT == 21)
        {
          if ((!b.hD) || (localb.hE.getBackground() == null)) {
            break label209;
          }
          localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.hE.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
          localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
          if ((!b.hD) || (localb.hE.getBackground() == null)) {
            break label214;
          }
          localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.hE.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
          localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
        }
        localb.hR.setCornerRadius(paramInt + 1.0E-005F);
        localb.hS.setCornerRadius(paramInt + 1.0E-005F);
        localb.hT.setCornerRadius(paramInt + 1.0E-005F);
      }
    }
    label209:
    label214:
    label219:
    while ((b.hD) || (localb.hN == null) || (localb.hP == null)) {
      for (;;)
      {
        return;
        GradientDrawable localGradientDrawable = null;
        continue;
        localGradientDrawable = null;
      }
    }
    localb.hN.setCornerRadius(paramInt + 1.0E-005F);
    localb.hP.setCornerRadius(paramInt + 1.0E-005F);
    localb.hE.invalidate();
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    if (aW()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (this.icon != paramDrawable)
    {
      this.icon = paramDrawable;
      aV();
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    this.hC = paramInt;
  }
  
  public void setIconPadding(int paramInt)
  {
    if (this.hx != paramInt)
    {
      this.hx = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
  }
  
  public void setIconResource(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = android.support.v7.c.a.a.l(getContext(), paramInt);
    }
    setIcon(localDrawable);
  }
  
  public void setIconSize(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("iconSize cannot be less than 0");
    }
    if (this.hA != paramInt)
    {
      this.hA = paramInt;
      aV();
    }
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    if (this.hz != paramColorStateList)
    {
      this.hz = paramColorStateList;
      aV();
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.hy != paramMode)
    {
      this.hy = paramMode;
      aV();
    }
  }
  
  public void setIconTintResource(int paramInt)
  {
    setIconTint(android.support.v7.c.a.a.m(getContext(), paramInt));
  }
  
  void setInternalBackground(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    b localb;
    if (aW())
    {
      localb = this.hw;
      if (localb.hJ != paramColorStateList)
      {
        localb.hJ = paramColorStateList;
        if ((!b.hD) || (!(localb.hE.getBackground() instanceof RippleDrawable))) {
          break label59;
        }
        ((RippleDrawable)localb.hE.getBackground()).setColor(paramColorStateList);
      }
    }
    label59:
    while ((b.hD) || (localb.hQ == null)) {
      return;
    }
    android.support.v4.graphics.drawable.a.a(localb.hQ, paramColorStateList);
  }
  
  public void setRippleColorResource(int paramInt)
  {
    if (aW()) {
      setRippleColor(android.support.v7.c.a.a.m(getContext(), paramInt));
    }
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    int i = 0;
    if (aW())
    {
      b localb = this.hw;
      if (localb.hI != paramColorStateList)
      {
        localb.hI = paramColorStateList;
        Paint localPaint = localb.hK;
        if (paramColorStateList != null) {
          i = paramColorStateList.getColorForState(localb.hE.getDrawableState(), 0);
        }
        localPaint.setColor(i);
        localb.aZ();
      }
    }
  }
  
  public void setStrokeColorResource(int paramInt)
  {
    if (aW()) {
      setStrokeColor(android.support.v7.c.a.a.m(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    if (aW())
    {
      b localb = this.hw;
      if (localb.strokeWidth != paramInt)
      {
        localb.strokeWidth = paramInt;
        localb.hK.setStrokeWidth(paramInt);
        localb.aZ();
      }
    }
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    if (aW()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (aW())
    {
      localb = this.hw;
      if (localb.hH != paramColorStateList)
      {
        localb.hH = paramColorStateList;
        if (!b.hD) {
          break label36;
        }
        localb.aX();
      }
    }
    label36:
    while (this.hw == null)
    {
      b localb;
      do
      {
        return;
      } while (localb.hO == null);
      android.support.v4.graphics.drawable.a.a(localb.hO, localb.hH);
      return;
    }
    super.setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (aW())
    {
      localb = this.hw;
      if (localb.hG != paramMode)
      {
        localb.hG = paramMode;
        if (!b.hD) {
          break label36;
        }
        localb.aX();
      }
    }
    label36:
    while (this.hw == null)
    {
      b localb;
      do
      {
        return;
      } while ((localb.hO == null) || (localb.hG == null));
      android.support.v4.graphics.drawable.a.a(localb.hO, localb.hG);
      return;
    }
    super.setSupportBackgroundTintMode(paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.button.MaterialButton
 * JD-Core Version:    0.7.0.1
 */