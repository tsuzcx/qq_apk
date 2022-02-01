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
  private final b eE;
  private int eF;
  private PorterDuff.Mode eG;
  private ColorStateList eH;
  private int eI;
  private int eJ;
  private int eK;
  private Drawable icon;
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 2130969294);
  }
  
  public MaterialButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = f.a(paramContext, paramAttributeSet, a.a.MaterialButton, paramInt, 2131821648, new int[0]);
    this.eF = paramAttributeSet.getDimensionPixelSize(9, 0);
    this.eG = g.a(paramAttributeSet.getInt(12, -1), PorterDuff.Mode.SRC_IN);
    this.eH = android.support.design.d.a.b(getContext(), paramAttributeSet, 11);
    this.icon = android.support.design.d.a.c(getContext(), paramAttributeSet, 7);
    this.eK = paramAttributeSet.getInteger(8, 1);
    this.eI = paramAttributeSet.getDimensionPixelSize(10, 0);
    this.eE = new b(this);
    b localb = this.eE;
    localb.insetLeft = paramAttributeSet.getDimensionPixelOffset(0, 0);
    localb.insetRight = paramAttributeSet.getDimensionPixelOffset(1, 0);
    localb.insetTop = paramAttributeSet.getDimensionPixelOffset(2, 0);
    localb.insetBottom = paramAttributeSet.getDimensionPixelOffset(3, 0);
    localb.eN = paramAttributeSet.getDimensionPixelSize(6, 0);
    localb.strokeWidth = paramAttributeSet.getDimensionPixelSize(15, 0);
    localb.eO = g.a(paramAttributeSet.getInt(5, -1), PorterDuff.Mode.SRC_IN);
    localb.eP = android.support.design.d.a.b(localb.eM.getContext(), paramAttributeSet, 4);
    localb.eQ = android.support.design.d.a.b(localb.eM.getContext(), paramAttributeSet, 14);
    localb.eR = android.support.design.d.a.b(localb.eM.getContext(), paramAttributeSet, 13);
    localb.eS.setStyle(Paint.Style.STROKE);
    localb.eS.setStrokeWidth(localb.strokeWidth);
    paramContext = localb.eS;
    int i;
    int j;
    int k;
    MaterialButton localMaterialButton;
    if (localb.eQ != null)
    {
      paramInt = localb.eQ.getColorForState(localb.eM.getDrawableState(), 0);
      paramContext.setColor(paramInt);
      paramInt = t.ab(localb.eM);
      i = localb.eM.getPaddingTop();
      j = t.ac(localb.eM);
      k = localb.eM.getPaddingBottom();
      localMaterialButton = localb.eM;
      if (!b.eL) {
        break label446;
      }
    }
    for (paramContext = localb.aB();; paramContext = localb.a(new LayerDrawable(new Drawable[] { localb.eW, localb.eY })))
    {
      localMaterialButton.setInternalBackground(paramContext);
      t.d(localb.eM, paramInt + localb.insetLeft, i + localb.insetTop, j + localb.insetRight, localb.insetBottom + k);
      paramAttributeSet.recycle();
      setCompoundDrawablePadding(this.eF);
      ay();
      return;
      paramInt = 0;
      break;
      label446:
      localb.eV = new GradientDrawable();
      localb.eV.setCornerRadius(localb.eN + 1.0E-005F);
      localb.eV.setColor(-1);
      localb.eW = android.support.v4.graphics.drawable.a.i(localb.eV);
      android.support.v4.graphics.drawable.a.a(localb.eW, localb.eP);
      if (localb.eO != null) {
        android.support.v4.graphics.drawable.a.a(localb.eW, localb.eO);
      }
      localb.eX = new GradientDrawable();
      localb.eX.setCornerRadius(localb.eN + 1.0E-005F);
      localb.eX.setColor(-1);
      localb.eY = android.support.v4.graphics.drawable.a.i(localb.eX);
      android.support.v4.graphics.drawable.a.a(localb.eY, localb.eR);
    }
  }
  
  private void ay()
  {
    int i;
    if (this.icon != null)
    {
      this.icon = this.icon.mutate();
      android.support.v4.graphics.drawable.a.a(this.icon, this.eH);
      if (this.eG != null) {
        android.support.v4.graphics.drawable.a.a(this.icon, this.eG);
      }
      if (this.eI == 0) {
        break label102;
      }
      i = this.eI;
      if (this.eI == 0) {
        break label113;
      }
    }
    label102:
    label113:
    for (int j = this.eI;; j = this.icon.getIntrinsicHeight())
    {
      this.icon.setBounds(this.eJ, 0, i + this.eJ, j);
      q.a(this, this.icon, null, null, null);
      return;
      i = this.icon.getIntrinsicWidth();
      break;
    }
  }
  
  private boolean az()
  {
    return (this.eE != null) && (!this.eE.fc);
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
    if (az()) {
      return this.eE.eN;
    }
    return 0;
  }
  
  public Drawable getIcon()
  {
    return this.icon;
  }
  
  public int getIconGravity()
  {
    return this.eK;
  }
  
  public int getIconPadding()
  {
    return this.eF;
  }
  
  public int getIconSize()
  {
    return this.eI;
  }
  
  public ColorStateList getIconTint()
  {
    return this.eH;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.eG;
  }
  
  public ColorStateList getRippleColor()
  {
    if (az()) {
      return this.eE.eR;
    }
    return null;
  }
  
  public ColorStateList getStrokeColor()
  {
    if (az()) {
      return this.eE.eQ;
    }
    return null;
  }
  
  public int getStrokeWidth()
  {
    if (az()) {
      return this.eE.strokeWidth;
    }
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    if (az()) {
      return this.eE.eP;
    }
    return super.getSupportBackgroundTintList();
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (az()) {
      return this.eE.eO;
    }
    return super.getSupportBackgroundTintMode();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (az()))
    {
      b localb = this.eE;
      if ((paramCanvas != null) && (localb.eQ != null) && (localb.strokeWidth > 0))
      {
        localb.eT.set(localb.eM.getBackground().getBounds());
        localb.eU.set(localb.eT.left + localb.strokeWidth / 2.0F + localb.insetLeft, localb.eT.top + localb.strokeWidth / 2.0F + localb.insetTop, localb.eT.right - localb.strokeWidth / 2.0F - localb.insetRight, localb.eT.bottom - localb.strokeWidth / 2.0F - localb.insetBottom);
        float f = localb.eN - localb.strokeWidth / 2.0F;
        paramCanvas.drawRoundRect(localb.eU, f, f, localb.eS);
      }
    }
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT == 21) && (this.eE != null))
    {
      b localb = this.eE;
      if (localb.fb != null) {
        localb.fb.setBounds(localb.insetLeft, localb.insetTop, paramInt3 - paramInt1 - localb.insetRight, paramInt4 - paramInt2 - localb.insetBottom);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    super.onMeasure(paramInt1, paramInt2);
    if ((this.icon == null) || (this.eK != 2)) {
      return;
    }
    paramInt2 = (int)getPaint().measureText(getText().toString());
    label57:
    int j;
    if (this.eI == 0)
    {
      paramInt1 = this.icon.getIntrinsicWidth();
      j = (getMeasuredWidth() - paramInt2 - t.ac(this) - paramInt1 - this.eF - t.ab(this)) / 2;
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
      if (this.eJ == paramInt2) {
        break;
      }
      this.eJ = paramInt2;
      ay();
      return;
      paramInt1 = this.eI;
      break label57;
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    if (az())
    {
      b localb = this.eE;
      if ((b.eL) && (localb.eZ != null)) {
        localb.eZ.setColor(paramInt);
      }
      while ((b.eL) || (localb.eV == null)) {
        return;
      }
      localb.eV.setColor(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (az())
    {
      if (paramDrawable != getBackground())
      {
        b localb = this.eE;
        localb.fc = true;
        localb.eM.setSupportBackgroundTintList(localb.eP);
        localb.eM.setSupportBackgroundTintMode(localb.eO);
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
    if (az())
    {
      localb = this.eE;
      if (localb.eN != paramInt)
      {
        localb.eN = paramInt;
        if ((!b.eL) || (localb.eZ == null) || (localb.fa == null) || (localb.fb == null)) {
          break label219;
        }
        if (Build.VERSION.SDK_INT == 21)
        {
          if ((!b.eL) || (localb.eM.getBackground() == null)) {
            break label209;
          }
          localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.eM.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
          localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
          if ((!b.eL) || (localb.eM.getBackground() == null)) {
            break label214;
          }
          localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.eM.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
          localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
        }
        localb.eZ.setCornerRadius(paramInt + 1.0E-005F);
        localb.fa.setCornerRadius(paramInt + 1.0E-005F);
        localb.fb.setCornerRadius(paramInt + 1.0E-005F);
      }
    }
    label209:
    label214:
    label219:
    while ((b.eL) || (localb.eV == null) || (localb.eX == null)) {
      for (;;)
      {
        return;
        GradientDrawable localGradientDrawable = null;
        continue;
        localGradientDrawable = null;
      }
    }
    localb.eV.setCornerRadius(paramInt + 1.0E-005F);
    localb.eX.setCornerRadius(paramInt + 1.0E-005F);
    localb.eM.invalidate();
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    if (az()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    if (this.icon != paramDrawable)
    {
      this.icon = paramDrawable;
      ay();
    }
  }
  
  public void setIconGravity(int paramInt)
  {
    this.eK = paramInt;
  }
  
  public void setIconPadding(int paramInt)
  {
    if (this.eF != paramInt)
    {
      this.eF = paramInt;
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
    if (this.eI != paramInt)
    {
      this.eI = paramInt;
      ay();
    }
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    if (this.eH != paramColorStateList)
    {
      this.eH = paramColorStateList;
      ay();
    }
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.eG != paramMode)
    {
      this.eG = paramMode;
      ay();
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
    if (az())
    {
      localb = this.eE;
      if (localb.eR != paramColorStateList)
      {
        localb.eR = paramColorStateList;
        if ((!b.eL) || (!(localb.eM.getBackground() instanceof RippleDrawable))) {
          break label59;
        }
        ((RippleDrawable)localb.eM.getBackground()).setColor(paramColorStateList);
      }
    }
    label59:
    while ((b.eL) || (localb.eY == null)) {
      return;
    }
    android.support.v4.graphics.drawable.a.a(localb.eY, paramColorStateList);
  }
  
  public void setRippleColorResource(int paramInt)
  {
    if (az()) {
      setRippleColor(android.support.v7.c.a.a.m(getContext(), paramInt));
    }
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    int i = 0;
    if (az())
    {
      b localb = this.eE;
      if (localb.eQ != paramColorStateList)
      {
        localb.eQ = paramColorStateList;
        Paint localPaint = localb.eS;
        if (paramColorStateList != null) {
          i = paramColorStateList.getColorForState(localb.eM.getDrawableState(), 0);
        }
        localPaint.setColor(i);
        localb.aC();
      }
    }
  }
  
  public void setStrokeColorResource(int paramInt)
  {
    if (az()) {
      setStrokeColor(android.support.v7.c.a.a.m(getContext(), paramInt));
    }
  }
  
  public void setStrokeWidth(int paramInt)
  {
    if (az())
    {
      b localb = this.eE;
      if (localb.strokeWidth != paramInt)
      {
        localb.strokeWidth = paramInt;
        localb.eS.setStrokeWidth(paramInt);
        localb.aC();
      }
    }
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    if (az()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (az())
    {
      localb = this.eE;
      if (localb.eP != paramColorStateList)
      {
        localb.eP = paramColorStateList;
        if (!b.eL) {
          break label36;
        }
        localb.aA();
      }
    }
    label36:
    while (this.eE == null)
    {
      b localb;
      do
      {
        return;
      } while (localb.eW == null);
      android.support.v4.graphics.drawable.a.a(localb.eW, localb.eP);
      return;
    }
    super.setSupportBackgroundTintList(paramColorStateList);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (az())
    {
      localb = this.eE;
      if (localb.eO != paramMode)
      {
        localb.eO = paramMode;
        if (!b.eL) {
          break label36;
        }
        localb.aA();
      }
    }
    label36:
    while (this.eE == null)
    {
      b localb;
      do
      {
        return;
      } while ((localb.eW == null) || (localb.eO == null));
      android.support.v4.graphics.drawable.a.a(localb.eW, localb.eO);
      return;
    }
    super.setSupportBackgroundTintMode(paramMode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.button.MaterialButton
 * JD-Core Version:    0.7.0.1
 */