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
  private final b fF;
  private int fG;
  private PorterDuff.Mode fH;
  private ColorStateList fI;
  private int fJ;
  private int fK;
  private int fL;
  private Drawable icon;
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969294);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = f.a(paramContext, paramAttributeSet, a.a.MaterialButton, paramInt, 2131821648, new int[0]);
    this.fG = paramAttributeSet.getDimensionPixelSize(9, 0);
    this.fH = g.a(paramAttributeSet.getInt(12, -1), PorterDuff.Mode.SRC_IN);
    this.fI = android.support.design.d.a.b(getContext(), paramAttributeSet, 11);
    this.icon = android.support.design.d.a.c(getContext(), paramAttributeSet, 7);
    this.fL = paramAttributeSet.getInteger(8, 1);
    this.fJ = paramAttributeSet.getDimensionPixelSize(10, 0);
    this.fF = new b(this);
    b localb = this.fF;
    localb.insetLeft = paramAttributeSet.getDimensionPixelOffset(0, 0);
    localb.insetRight = paramAttributeSet.getDimensionPixelOffset(1, 0);
    localb.insetTop = paramAttributeSet.getDimensionPixelOffset(2, 0);
    localb.insetBottom = paramAttributeSet.getDimensionPixelOffset(3, 0);
    localb.fO = paramAttributeSet.getDimensionPixelSize(6, 0);
    localb.strokeWidth = paramAttributeSet.getDimensionPixelSize(15, 0);
    localb.fP = g.a(paramAttributeSet.getInt(5, -1), PorterDuff.Mode.SRC_IN);
    localb.fQ = android.support.design.d.a.b(localb.fN.getContext(), paramAttributeSet, 4);
    localb.fR = android.support.design.d.a.b(localb.fN.getContext(), paramAttributeSet, 14);
    localb.fS = android.support.design.d.a.b(localb.fN.getContext(), paramAttributeSet, 13);
    localb.fT.setStyle(Paint.Style.STROKE);
    localb.fT.setStrokeWidth(localb.strokeWidth);
    paramContext = localb.fT;
    int i;
    int j;
    int k;
    MaterialButton localMaterialButton;
    if (localb.fR != null)
    {
      paramInt = localb.fR.getColorForState(localb.fN.getDrawableState(), 0);
      paramContext.setColor(paramInt);
      paramInt = t.ab(localb.fN);
      i = localb.fN.getPaddingTop();
      j = t.ac(localb.fN);
      k = localb.fN.getPaddingBottom();
      localMaterialButton = localb.fN;
      if (!b.fM) {
        break label446;
      }
    }
    for (paramContext = localb.aI();; paramContext = localb.a(new LayerDrawable(new Drawable[] { localb.fX, localb.fZ })))
    {
      localMaterialButton.setInternalBackground(paramContext);
      t.d(localb.fN, paramInt + localb.insetLeft, i + localb.insetTop, j + localb.insetRight, localb.insetBottom + k);
      paramAttributeSet.recycle();
      setCompoundDrawablePadding(this.fG);
      aF();
      return;
      paramInt = 0;
      break;
      label446:
      localb.fW = new GradientDrawable();
      localb.fW.setCornerRadius(localb.fO + 1.0E-005F);
      localb.fW.setColor(-1);
      localb.fX = android.support.v4.graphics.drawable.a.i(localb.fW);
      android.support.v4.graphics.drawable.a.a(localb.fX, localb.fQ);
      if (localb.fP != null) {
        android.support.v4.graphics.drawable.a.a(localb.fX, localb.fP);
      }
      localb.fY = new GradientDrawable();
      localb.fY.setCornerRadius(localb.fO + 1.0E-005F);
      localb.fY.setColor(-1);
      localb.fZ = android.support.v4.graphics.drawable.a.i(localb.fY);
      android.support.v4.graphics.drawable.a.a(localb.fZ, localb.fS);
    }
  }
  
  private void aF()
  {
    int i;
    if (this.icon != null)
    {
      this.icon = this.icon.mutate();
      android.support.v4.graphics.drawable.a.a(this.icon, this.fI);
      if (this.fH != null) {
        android.support.v4.graphics.drawable.a.a(this.icon, this.fH);
      }
      if (this.fJ == 0) {
        break label102;
      }
      i = this.fJ;
      if (this.fJ == 0) {
        break label113;
      }
    }
    label102:
    label113:
    for (int j = this.fJ;; j = this.icon.getIntrinsicHeight())
    {
      this.icon.setBounds(this.fK, 0, i + this.fK, j);
      q.a(this, this.icon, null, null, null);
      return;
      i = this.icon.getIntrinsicWidth();
      break;
    }
  }
  
  private boolean aG()
  {
    return (this.fF != null) && (!this.fF.gd);
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
    if (aG()) {
      return this.fF.fO;
    }
    return 0;
  }
  
  public Drawable getIcon()
  {
    return this.icon;
  }
  
  public int getIconGravity()
  {
    return this.fL;
  }
  
  public int getIconPadding()
  {
    return this.fG;
  }
  
  public int getIconSize()
  {
    return this.fJ;
  }
  
  public ColorStateList getIconTint()
  {
    return this.fI;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.fH;
  }
  
  public ColorStateList getRippleColor()
  {
    if (aG()) {
      return this.fF.fS;
    }
    return null;
  }
  
  public ColorStateList getStrokeColor()
  {
    if (aG()) {
      return this.fF.fR;
    }
    return null;
  }
  
  public int getStrokeWidth()
  {
    if (aG()) {
      return this.fF.strokeWidth;
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (aG()) {
      return this.fF.fQ;
    }
    return super.getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (aG()) {
      return this.fF.fP;
    }
    return super.getSupportBackgroundTintMode();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (aG()))
    {
      b localb = this.fF;
      if ((paramCanvas != null) && (localb.fR != null) && (localb.strokeWidth > 0))
      {
        localb.fU.set(localb.fN.getBackground().getBounds());
        localb.fV.set(localb.fU.left + localb.strokeWidth / 2.0F + localb.insetLeft, localb.fU.top + localb.strokeWidth / 2.0F + localb.insetTop, localb.fU.right - localb.strokeWidth / 2.0F - localb.insetRight, localb.fU.bottom - localb.strokeWidth / 2.0F - localb.insetBottom);
        float f = localb.fO - localb.strokeWidth / 2.0F;
        paramCanvas.drawRoundRect(localb.fV, f, f, localb.fT);
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT == 21) && (this.fF != null))
    {
      b localb = this.fF;
      if (localb.gc != null) {
        localb.gc.setBounds(localb.insetLeft, localb.insetTop, paramInt3 - paramInt1 - localb.insetRight, paramInt4 - paramInt2 - localb.insetBottom);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    super.onMeasure(paramInt1, paramInt2);
    if ((this.icon == null) || (this.fL != 2)) {
      return;
    }
    paramInt2 = (int)getPaint().measureText(getText().toString());
    label57:
    int j;
    if (this.fJ == 0)
    {
      paramInt1 = this.icon.getIntrinsicWidth();
      j = (getMeasuredWidth() - paramInt2 - t.ac(this) - paramInt1 - this.fG - t.ab(this)) / 2;
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
      if (this.fK == paramInt2) {
        break;
      }
      this.fK = paramInt2;
      aF();
      return;
      paramInt1 = this.fJ;
      break label57;
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (aG())
    {
      b localb = this.fF;
      if ((b.fM) && (localb.ga != null)) {
        localb.ga.setColor(paramInt);
      }
      while ((b.fM) || (localb.fW == null)) {
        return;
      }
      localb.fW.setColor(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (aG())
    {
      if (paramDrawable != getBackground())
      {
        b localb = this.fF;
        localb.gd = true;
        localb.fN.setSupportBackgroundTintList(localb.fQ);
        localb.fN.setSupportBackgroundTintMode(localb.fP);
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
    if (aG())
    {
      localb = this.fF;
      if (localb.fO != paramInt)
      {
        localb.fO = paramInt;
        if ((!b.fM) || (localb.ga == null) || (localb.gb == null) || (localb.gc == null)) {
          break label219;
        }
        if (Build.VERSION.SDK_INT == 21)
        {
          if ((!b.fM) || (localb.fN.getBackground() == null)) {
            break label209;
          }
          localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.fN.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
          localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
          if ((!b.fM) || (localb.fN.getBackground() == null)) {
            break label214;
          }
          localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.fN.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
          localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
        }
        localb.ga.setCornerRadius(paramInt + 1.0E-005F);
        localb.gb.setCornerRadius(paramInt + 1.0E-005F);
        localb.gc.setCornerRadius(paramInt + 1.0E-005F);
      }
    }
    label209:
    label214:
    label219:
    while ((b.fM) || (localb.fW == null) || (localb.fY == null)) {
      for (;;)
      {
        return;
        GradientDrawable localGradientDrawable = null;
        continue;
        localGradientDrawable = null;
      }
    }
    localb.fW.setCornerRadius(paramInt + 1.0E-005F);
    localb.fY.setCornerRadius(paramInt + 1.0E-005F);
    localb.fN.invalidate();
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    if (aG()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (this.icon != paramDrawable)
    {
      this.icon = paramDrawable;
      aF();
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    this.fL = paramInt;
  }
  
  public void setIconPadding(int paramInt)
  {
    if (this.fG != paramInt)
    {
      this.fG = paramInt;
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
    if (this.fJ != paramInt)
    {
      this.fJ = paramInt;
      aF();
    }
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    if (this.fI != paramColorStateList)
    {
      this.fI = paramColorStateList;
      aF();
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.fH != paramMode)
    {
      this.fH = paramMode;
      aF();
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
    if (aG())
    {
      localb = this.fF;
      if (localb.fS != paramColorStateList)
      {
        localb.fS = paramColorStateList;
        if ((!b.fM) || (!(localb.fN.getBackground() instanceof RippleDrawable))) {
          break label59;
        }
        ((RippleDrawable)localb.fN.getBackground()).setColor(paramColorStateList);
      }
    }
    label59:
    while ((b.fM) || (localb.fZ == null)) {
      return;
    }
    android.support.v4.graphics.drawable.a.a(localb.fZ, paramColorStateList);
  }
  
  public void setRippleColorResource(int paramInt)
  {
    if (aG()) {
      setRippleColor(android.support.v7.c.a.a.m(getContext(), paramInt));
    }
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    int i = 0;
    if (aG())
    {
      b localb = this.fF;
      if (localb.fR != paramColorStateList)
      {
        localb.fR = paramColorStateList;
        Paint localPaint = localb.fT;
        if (paramColorStateList != null) {
          i = paramColorStateList.getColorForState(localb.fN.getDrawableState(), 0);
        }
        localPaint.setColor(i);
        localb.aJ();
      }
    }
  }
  
  public void setStrokeColorResource(int paramInt)
  {
    if (aG()) {
      setStrokeColor(android.support.v7.c.a.a.m(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    if (aG())
    {
      b localb = this.fF;
      if (localb.strokeWidth != paramInt)
      {
        localb.strokeWidth = paramInt;
        localb.fT.setStrokeWidth(paramInt);
        localb.aJ();
      }
    }
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    if (aG()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (aG())
    {
      localb = this.fF;
      if (localb.fQ != paramColorStateList)
      {
        localb.fQ = paramColorStateList;
        if (!b.fM) {
          break label36;
        }
        localb.aH();
      }
    }
    label36:
    while (this.fF == null)
    {
      b localb;
      do
      {
        return;
      } while (localb.fX == null);
      android.support.v4.graphics.drawable.a.a(localb.fX, localb.fQ);
      return;
    }
    super.setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (aG())
    {
      localb = this.fF;
      if (localb.fP != paramMode)
      {
        localb.fP = paramMode;
        if (!b.fM) {
          break label36;
        }
        localb.aH();
      }
    }
    label36:
    while (this.fF == null)
    {
      b localb;
      do
      {
        return;
      } while ((localb.fX == null) || (localb.fP == null));
      android.support.v4.graphics.drawable.a.a(localb.fX, localb.fP);
      return;
    }
    super.setSupportBackgroundTintMode(paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.button.MaterialButton
 * JD-Core Version:    0.7.0.1
 */