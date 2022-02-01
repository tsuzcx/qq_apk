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
import android.support.v4.view.u;
import android.support.v4.widget.q;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

public class MaterialButton
  extends AppCompatButton
{
  private PorterDuff.Mode hA;
  private ColorStateList hB;
  private int hC;
  private int hD;
  private int hE;
  private final b hy;
  private int hz;
  private Drawable icon;
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969363);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = f.a(paramContext, paramAttributeSet, a.a.MaterialButton, paramInt, 2131821696, new int[0]);
    this.hz = paramAttributeSet.getDimensionPixelSize(9, 0);
    this.hA = g.a(paramAttributeSet.getInt(12, -1), PorterDuff.Mode.SRC_IN);
    this.hB = android.support.design.d.a.b(getContext(), paramAttributeSet, 11);
    this.icon = android.support.design.d.a.c(getContext(), paramAttributeSet, 7);
    this.hE = paramAttributeSet.getInteger(8, 1);
    this.hC = paramAttributeSet.getDimensionPixelSize(10, 0);
    this.hy = new b(this);
    b localb = this.hy;
    localb.insetLeft = paramAttributeSet.getDimensionPixelOffset(0, 0);
    localb.insetRight = paramAttributeSet.getDimensionPixelOffset(1, 0);
    localb.insetTop = paramAttributeSet.getDimensionPixelOffset(2, 0);
    localb.insetBottom = paramAttributeSet.getDimensionPixelOffset(3, 0);
    localb.hH = paramAttributeSet.getDimensionPixelSize(6, 0);
    localb.strokeWidth = paramAttributeSet.getDimensionPixelSize(15, 0);
    localb.hI = g.a(paramAttributeSet.getInt(5, -1), PorterDuff.Mode.SRC_IN);
    localb.hJ = android.support.design.d.a.b(localb.hG.getContext(), paramAttributeSet, 4);
    localb.hK = android.support.design.d.a.b(localb.hG.getContext(), paramAttributeSet, 14);
    localb.hL = android.support.design.d.a.b(localb.hG.getContext(), paramAttributeSet, 13);
    localb.hM.setStyle(Paint.Style.STROKE);
    localb.hM.setStrokeWidth(localb.strokeWidth);
    paramContext = localb.hM;
    int i;
    int j;
    int k;
    MaterialButton localMaterialButton;
    if (localb.hK != null)
    {
      paramInt = localb.hK.getColorForState(localb.hG.getDrawableState(), 0);
      paramContext.setColor(paramInt);
      paramInt = u.ac(localb.hG);
      i = localb.hG.getPaddingTop();
      j = u.ad(localb.hG);
      k = localb.hG.getPaddingBottom();
      localMaterialButton = localb.hG;
      if (!b.hF) {
        break label446;
      }
    }
    for (paramContext = localb.ba();; paramContext = localb.a(new LayerDrawable(new Drawable[] { localb.hQ, localb.hS })))
    {
      localMaterialButton.setInternalBackground(paramContext);
      u.d(localb.hG, paramInt + localb.insetLeft, i + localb.insetTop, j + localb.insetRight, localb.insetBottom + k);
      paramAttributeSet.recycle();
      setCompoundDrawablePadding(this.hz);
      aX();
      return;
      paramInt = 0;
      break;
      label446:
      localb.hP = new GradientDrawable();
      localb.hP.setCornerRadius(localb.hH + 1.0E-005F);
      localb.hP.setColor(-1);
      localb.hQ = android.support.v4.graphics.drawable.a.i(localb.hP);
      android.support.v4.graphics.drawable.a.a(localb.hQ, localb.hJ);
      if (localb.hI != null) {
        android.support.v4.graphics.drawable.a.a(localb.hQ, localb.hI);
      }
      localb.hR = new GradientDrawable();
      localb.hR.setCornerRadius(localb.hH + 1.0E-005F);
      localb.hR.setColor(-1);
      localb.hS = android.support.v4.graphics.drawable.a.i(localb.hR);
      android.support.v4.graphics.drawable.a.a(localb.hS, localb.hL);
    }
  }
  
  private void aX()
  {
    int i;
    if (this.icon != null)
    {
      this.icon = this.icon.mutate();
      android.support.v4.graphics.drawable.a.a(this.icon, this.hB);
      if (this.hA != null) {
        android.support.v4.graphics.drawable.a.a(this.icon, this.hA);
      }
      if (this.hC == 0) {
        break label102;
      }
      i = this.hC;
      if (this.hC == 0) {
        break label113;
      }
    }
    label102:
    label113:
    for (int j = this.hC;; j = this.icon.getIntrinsicHeight())
    {
      this.icon.setBounds(this.hD, 0, i + this.hD, j);
      q.a(this, this.icon, null, null, null);
      return;
      i = this.icon.getIntrinsicWidth();
      break;
    }
  }
  
  private boolean aY()
  {
    return (this.hy != null) && (!this.hy.hW);
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
    if (aY()) {
      return this.hy.hH;
    }
    return 0;
  }
  
  public Drawable getIcon()
  {
    return this.icon;
  }
  
  public int getIconGravity()
  {
    return this.hE;
  }
  
  public int getIconPadding()
  {
    return this.hz;
  }
  
  public int getIconSize()
  {
    return this.hC;
  }
  
  public ColorStateList getIconTint()
  {
    return this.hB;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.hA;
  }
  
  public ColorStateList getRippleColor()
  {
    if (aY()) {
      return this.hy.hL;
    }
    return null;
  }
  
  public ColorStateList getStrokeColor()
  {
    if (aY()) {
      return this.hy.hK;
    }
    return null;
  }
  
  public int getStrokeWidth()
  {
    if (aY()) {
      return this.hy.strokeWidth;
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (aY()) {
      return this.hy.hJ;
    }
    return super.getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (aY()) {
      return this.hy.hI;
    }
    return super.getSupportBackgroundTintMode();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (aY()))
    {
      b localb = this.hy;
      if ((paramCanvas != null) && (localb.hK != null) && (localb.strokeWidth > 0))
      {
        localb.hN.set(localb.hG.getBackground().getBounds());
        localb.hO.set(localb.hN.left + localb.strokeWidth / 2.0F + localb.insetLeft, localb.hN.top + localb.strokeWidth / 2.0F + localb.insetTop, localb.hN.right - localb.strokeWidth / 2.0F - localb.insetRight, localb.hN.bottom - localb.strokeWidth / 2.0F - localb.insetBottom);
        float f = localb.hH - localb.strokeWidth / 2.0F;
        paramCanvas.drawRoundRect(localb.hO, f, f, localb.hM);
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT == 21) && (this.hy != null))
    {
      b localb = this.hy;
      if (localb.hV != null) {
        localb.hV.setBounds(localb.insetLeft, localb.insetTop, paramInt3 - paramInt1 - localb.insetRight, paramInt4 - paramInt2 - localb.insetBottom);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    super.onMeasure(paramInt1, paramInt2);
    if ((this.icon == null) || (this.hE != 2)) {
      return;
    }
    paramInt2 = (int)getPaint().measureText(getText().toString());
    label57:
    int j;
    if (this.hC == 0)
    {
      paramInt1 = this.icon.getIntrinsicWidth();
      j = (getMeasuredWidth() - paramInt2 - u.ad(this) - paramInt1 - this.hz - u.ac(this)) / 2;
      if (u.Z(this) != 1) {
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
      if (this.hD == paramInt2) {
        break;
      }
      this.hD = paramInt2;
      aX();
      return;
      paramInt1 = this.hC;
      break label57;
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (aY())
    {
      b localb = this.hy;
      if ((b.hF) && (localb.hT != null)) {
        localb.hT.setColor(paramInt);
      }
      while ((b.hF) || (localb.hP == null)) {
        return;
      }
      localb.hP.setColor(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (aY())
    {
      if (paramDrawable != getBackground())
      {
        b localb = this.hy;
        localb.hW = true;
        localb.hG.setSupportBackgroundTintList(localb.hJ);
        localb.hG.setSupportBackgroundTintMode(localb.hI);
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
    if (aY())
    {
      localb = this.hy;
      if (localb.hH != paramInt)
      {
        localb.hH = paramInt;
        if ((!b.hF) || (localb.hT == null) || (localb.hU == null) || (localb.hV == null)) {
          break label219;
        }
        if (Build.VERSION.SDK_INT == 21)
        {
          if ((!b.hF) || (localb.hG.getBackground() == null)) {
            break label209;
          }
          localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.hG.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
          localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
          if ((!b.hF) || (localb.hG.getBackground() == null)) {
            break label214;
          }
          localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.hG.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
          localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
        }
        localb.hT.setCornerRadius(paramInt + 1.0E-005F);
        localb.hU.setCornerRadius(paramInt + 1.0E-005F);
        localb.hV.setCornerRadius(paramInt + 1.0E-005F);
      }
    }
    label209:
    label214:
    label219:
    while ((b.hF) || (localb.hP == null) || (localb.hR == null)) {
      for (;;)
      {
        return;
        GradientDrawable localGradientDrawable = null;
        continue;
        localGradientDrawable = null;
      }
    }
    localb.hP.setCornerRadius(paramInt + 1.0E-005F);
    localb.hR.setCornerRadius(paramInt + 1.0E-005F);
    localb.hG.invalidate();
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    if (aY()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (this.icon != paramDrawable)
    {
      this.icon = paramDrawable;
      aX();
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    this.hE = paramInt;
  }
  
  public void setIconPadding(int paramInt)
  {
    if (this.hz != paramInt)
    {
      this.hz = paramInt;
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
    if (this.hC != paramInt)
    {
      this.hC = paramInt;
      aX();
    }
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    if (this.hB != paramColorStateList)
    {
      this.hB = paramColorStateList;
      aX();
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.hA != paramMode)
    {
      this.hA = paramMode;
      aX();
    }
  }
  
  public void setIconTintResource(@android.support.annotation.a int paramInt)
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
    if (aY())
    {
      localb = this.hy;
      if (localb.hL != paramColorStateList)
      {
        localb.hL = paramColorStateList;
        if ((!b.hF) || (!(localb.hG.getBackground() instanceof RippleDrawable))) {
          break label59;
        }
        ((RippleDrawable)localb.hG.getBackground()).setColor(paramColorStateList);
      }
    }
    label59:
    while ((b.hF) || (localb.hS == null)) {
      return;
    }
    android.support.v4.graphics.drawable.a.a(localb.hS, paramColorStateList);
  }
  
  public void setRippleColorResource(@android.support.annotation.a int paramInt)
  {
    if (aY()) {
      setRippleColor(android.support.v7.c.a.a.m(getContext(), paramInt));
    }
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    int i = 0;
    if (aY())
    {
      b localb = this.hy;
      if (localb.hK != paramColorStateList)
      {
        localb.hK = paramColorStateList;
        Paint localPaint = localb.hM;
        if (paramColorStateList != null) {
          i = paramColorStateList.getColorForState(localb.hG.getDrawableState(), 0);
        }
        localPaint.setColor(i);
        localb.bb();
      }
    }
  }
  
  public void setStrokeColorResource(@android.support.annotation.a int paramInt)
  {
    if (aY()) {
      setStrokeColor(android.support.v7.c.a.a.m(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    if (aY())
    {
      b localb = this.hy;
      if (localb.strokeWidth != paramInt)
      {
        localb.strokeWidth = paramInt;
        localb.hM.setStrokeWidth(paramInt);
        localb.bb();
      }
    }
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    if (aY()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (aY())
    {
      localb = this.hy;
      if (localb.hJ != paramColorStateList)
      {
        localb.hJ = paramColorStateList;
        if (!b.hF) {
          break label36;
        }
        localb.aZ();
      }
    }
    label36:
    while (this.hy == null)
    {
      b localb;
      do
      {
        return;
      } while (localb.hQ == null);
      android.support.v4.graphics.drawable.a.a(localb.hQ, localb.hJ);
      return;
    }
    super.setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (aY())
    {
      localb = this.hy;
      if (localb.hI != paramMode)
      {
        localb.hI = paramMode;
        if (!b.hF) {
          break label36;
        }
        localb.aZ();
      }
    }
    label36:
    while (this.hy == null)
    {
      b localb;
      do
      {
        return;
      } while ((localb.hQ == null) || (localb.hI == null));
      android.support.v4.graphics.drawable.a.a(localb.hQ, localb.hI);
      return;
    }
    super.setSupportBackgroundTintMode(paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.button.MaterialButton
 * JD-Core Version:    0.7.0.1
 */