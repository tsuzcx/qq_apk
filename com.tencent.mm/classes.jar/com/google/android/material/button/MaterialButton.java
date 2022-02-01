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
import androidx.core.g.z;
import androidx.core.widget.j;
import com.google.android.material.a.b;
import com.google.android.material.a.j;
import com.google.android.material.a.k;
import com.google.android.material.internal.k;
import com.google.android.material.internal.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MaterialButton
  extends AppCompatButton
{
  private ColorStateList dpR;
  private final b dqW;
  private PorterDuff.Mode dqX;
  private Drawable dqY;
  private int dqZ;
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
    AppMethodBeat.i(209867);
    paramAttributeSet = k.a(paramContext, paramAttributeSet, a.k.MaterialButton, paramInt, a.j.Widget_MaterialComponents_Button, new int[0]);
    this.iconPadding = paramAttributeSet.getDimensionPixelSize(a.k.MaterialButton_iconPadding, 0);
    this.dqX = l.c(paramAttributeSet.getInt(a.k.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.dpR = com.google.android.material.e.a.b(getContext(), paramAttributeSet, a.k.MaterialButton_iconTint);
    this.dqY = com.google.android.material.e.a.c(getContext(), paramAttributeSet, a.k.MaterialButton_icon);
    this.iconGravity = paramAttributeSet.getInteger(a.k.MaterialButton_iconGravity, 1);
    this.iconSize = paramAttributeSet.getDimensionPixelSize(a.k.MaterialButton_iconSize, 0);
    this.dqW = new b(this);
    b localb = this.dqW;
    localb.drc = paramAttributeSet.getDimensionPixelOffset(a.k.MaterialButton_android_insetLeft, 0);
    localb.drd = paramAttributeSet.getDimensionPixelOffset(a.k.MaterialButton_android_insetRight, 0);
    localb.dre = paramAttributeSet.getDimensionPixelOffset(a.k.MaterialButton_android_insetTop, 0);
    localb.drf = paramAttributeSet.getDimensionPixelOffset(a.k.MaterialButton_android_insetBottom, 0);
    localb.cornerRadius = paramAttributeSet.getDimensionPixelSize(a.k.MaterialButton_cornerRadius, 0);
    localb.strokeWidth = paramAttributeSet.getDimensionPixelSize(a.k.MaterialButton_strokeWidth, 0);
    localb.drg = l.c(paramAttributeSet.getInt(a.k.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
    localb.drh = com.google.android.material.e.a.b(localb.drb.getContext(), paramAttributeSet, a.k.MaterialButton_backgroundTint);
    localb.dri = com.google.android.material.e.a.b(localb.drb.getContext(), paramAttributeSet, a.k.MaterialButton_strokeColor);
    localb.drj = com.google.android.material.e.a.b(localb.drb.getContext(), paramAttributeSet, a.k.MaterialButton_rippleColor);
    localb.drk.setStyle(Paint.Style.STROKE);
    localb.drk.setStrokeWidth(localb.strokeWidth);
    paramContext = localb.drk;
    int i;
    int j;
    int k;
    MaterialButton localMaterialButton;
    if (localb.dri != null)
    {
      paramInt = localb.dri.getColorForState(localb.drb.getDrawableState(), 0);
      paramContext.setColor(paramInt);
      paramInt = z.X(localb.drb);
      i = localb.drb.getPaddingTop();
      j = z.Y(localb.drb);
      k = localb.drb.getPaddingBottom();
      localMaterialButton = localb.drb;
      if (!b.dra) {
        break label479;
      }
    }
    for (paramContext = localb.VR();; paramContext = localb.G(new LayerDrawable(new Drawable[] { localb.drm, localb.dro })))
    {
      localMaterialButton.setInternalBackground(paramContext);
      z.g(localb.drb, paramInt + localb.drc, i + localb.dre, j + localb.drd, localb.drf + k);
      paramAttributeSet.recycle();
      setCompoundDrawablePadding(this.iconPadding);
      VO();
      AppMethodBeat.o(209867);
      return;
      paramInt = 0;
      break;
      label479:
      localb.drl = new GradientDrawable();
      localb.drl.setCornerRadius(localb.cornerRadius + 1.0E-005F);
      localb.drl.setColor(-1);
      localb.drm = androidx.core.graphics.drawable.a.s(localb.drl);
      androidx.core.graphics.drawable.a.a(localb.drm, localb.drh);
      if (localb.drg != null) {
        androidx.core.graphics.drawable.a.a(localb.drm, localb.drg);
      }
      localb.drn = new GradientDrawable();
      localb.drn.setCornerRadius(localb.cornerRadius + 1.0E-005F);
      localb.drn.setColor(-1);
      localb.dro = androidx.core.graphics.drawable.a.s(localb.drn);
      androidx.core.graphics.drawable.a.a(localb.dro, localb.drj);
    }
  }
  
  private void VO()
  {
    AppMethodBeat.i(209882);
    int i;
    if (this.dqY != null)
    {
      this.dqY = this.dqY.mutate();
      androidx.core.graphics.drawable.a.a(this.dqY, this.dpR);
      if (this.dqX != null) {
        androidx.core.graphics.drawable.a.a(this.dqY, this.dqX);
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
    for (int j = this.iconSize;; j = this.dqY.getIntrinsicHeight())
    {
      this.dqY.setBounds(this.dqZ, 0, i + this.dqZ, j);
      j.a(this, this.dqY, null, null, null);
      AppMethodBeat.o(209882);
      return;
      i = this.dqY.getIntrinsicWidth();
      break;
    }
  }
  
  private boolean VP()
  {
    return (this.dqW != null) && (!this.dqW.drs);
  }
  
  public ColorStateList getBackgroundTintList()
  {
    AppMethodBeat.i(209969);
    ColorStateList localColorStateList = getSupportBackgroundTintList();
    AppMethodBeat.o(209969);
    return localColorStateList;
  }
  
  public PorterDuff.Mode getBackgroundTintMode()
  {
    AppMethodBeat.i(209989);
    PorterDuff.Mode localMode = getSupportBackgroundTintMode();
    AppMethodBeat.o(209989);
    return localMode;
  }
  
  public int getCornerRadius()
  {
    AppMethodBeat.i(210239);
    if (VP())
    {
      int i = this.dqW.cornerRadius;
      AppMethodBeat.o(210239);
      return i;
    }
    AppMethodBeat.o(210239);
    return 0;
  }
  
  public Drawable getIcon()
  {
    return this.dqY;
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
    return this.dpR;
  }
  
  public PorterDuff.Mode getIconTintMode()
  {
    return this.dqX;
  }
  
  public ColorStateList getRippleColor()
  {
    AppMethodBeat.i(210177);
    if (VP())
    {
      ColorStateList localColorStateList = this.dqW.drj;
      AppMethodBeat.o(210177);
      return localColorStateList;
    }
    AppMethodBeat.o(210177);
    return null;
  }
  
  public ColorStateList getStrokeColor()
  {
    AppMethodBeat.i(210194);
    if (VP())
    {
      ColorStateList localColorStateList = this.dqW.dri;
      AppMethodBeat.o(210194);
      return localColorStateList;
    }
    AppMethodBeat.o(210194);
    return null;
  }
  
  public int getStrokeWidth()
  {
    AppMethodBeat.i(210218);
    if (VP())
    {
      int i = this.dqW.strokeWidth;
      AppMethodBeat.o(210218);
      return i;
    }
    AppMethodBeat.o(210218);
    return 0;
  }
  
  public ColorStateList getSupportBackgroundTintList()
  {
    AppMethodBeat.i(209927);
    if (VP())
    {
      localColorStateList = this.dqW.drh;
      AppMethodBeat.o(209927);
      return localColorStateList;
    }
    ColorStateList localColorStateList = super.getSupportBackgroundTintList();
    AppMethodBeat.o(209927);
    return localColorStateList;
  }
  
  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    AppMethodBeat.i(209950);
    if (VP())
    {
      localMode = this.dqW.drg;
      AppMethodBeat.o(209950);
      return localMode;
    }
    PorterDuff.Mode localMode = super.getSupportBackgroundTintMode();
    AppMethodBeat.o(209950);
    return localMode;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209900);
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (VP()))
    {
      b localb = this.dqW;
      if ((paramCanvas != null) && (localb.dri != null) && (localb.strokeWidth > 0))
      {
        localb.bounds.set(localb.drb.getBackground().getBounds());
        localb.avO.set(localb.bounds.left + localb.strokeWidth / 2.0F + localb.drc, localb.bounds.top + localb.strokeWidth / 2.0F + localb.dre, localb.bounds.right - localb.strokeWidth / 2.0F - localb.drd, localb.bounds.bottom - localb.strokeWidth / 2.0F - localb.drf);
        float f = localb.cornerRadius - localb.strokeWidth / 2.0F;
        paramCanvas.drawRoundRect(localb.avO, f, f, localb.drk);
      }
    }
    AppMethodBeat.o(209900);
  }
  
  public void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(210040);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT == 21) && (this.dqW != null))
    {
      b localb = this.dqW;
      if (localb.drr != null) {
        localb.drr.setBounds(localb.drc, localb.dre, paramInt3 - paramInt1 - localb.drd, paramInt4 - paramInt2 - localb.drf);
      }
    }
    AppMethodBeat.o(210040);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 1;
    AppMethodBeat.i(210054);
    super.onMeasure(paramInt1, paramInt2);
    if ((this.dqY == null) || (this.iconGravity != 2))
    {
      AppMethodBeat.o(210054);
      return;
    }
    paramInt2 = (int)getPaint().measureText(getText().toString());
    int j;
    if (this.iconSize == 0)
    {
      paramInt1 = this.dqY.getIntrinsicWidth();
      j = (getMeasuredWidth() - paramInt2 - z.Y(this) - paramInt1 - this.iconPadding - z.X(this)) / 2;
      if (z.U(this) != 1) {
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
      if (this.dqZ != paramInt2)
      {
        this.dqZ = paramInt2;
        VO();
      }
      AppMethodBeat.o(210054);
      return;
      paramInt1 = this.iconSize;
      break;
    }
  }
  
  public void setBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(210012);
    setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(210012);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(210002);
    if (VP())
    {
      b localb = this.dqW;
      if ((b.dra) && (localb.drp != null))
      {
        localb.drp.setColor(paramInt);
        AppMethodBeat.o(210002);
        return;
      }
      if ((!b.dra) && (localb.drl != null)) {
        localb.drl.setColor(paramInt);
      }
      AppMethodBeat.o(210002);
      return;
    }
    super.setBackgroundColor(paramInt);
    AppMethodBeat.o(210002);
  }
  
  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(210028);
    if (VP())
    {
      if (paramDrawable != getBackground())
      {
        b localb = this.dqW;
        localb.drs = true;
        localb.drb.setSupportBackgroundTintList(localb.drh);
        localb.drb.setSupportBackgroundTintMode(localb.drg);
      }
    }
    else
    {
      super.setBackgroundDrawable(paramDrawable);
      AppMethodBeat.o(210028);
      return;
    }
    getBackground().setState(paramDrawable.getState());
    AppMethodBeat.o(210028);
  }
  
  public void setBackgroundResource(int paramInt)
  {
    AppMethodBeat.i(210019);
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = androidx.appcompat.a.a.a.m(getContext(), paramInt);
    }
    setBackgroundDrawable(localDrawable);
    AppMethodBeat.o(210019);
  }
  
  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209961);
    setSupportBackgroundTintList(paramColorStateList);
    AppMethodBeat.o(209961);
  }
  
  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(209981);
    setSupportBackgroundTintMode(paramMode);
    AppMethodBeat.o(209981);
  }
  
  public void setCornerRadius(int paramInt)
  {
    AppMethodBeat.i(210227);
    if (VP())
    {
      b localb = this.dqW;
      if (localb.cornerRadius != paramInt)
      {
        localb.cornerRadius = paramInt;
        if ((b.dra) && (localb.drp != null) && (localb.drq != null) && (localb.drr != null))
        {
          if (Build.VERSION.SDK_INT == 21)
          {
            if ((!b.dra) || (localb.drb.getBackground() == null)) {
              break label226;
            }
            localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.drb.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
            localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
            if ((!b.dra) || (localb.drb.getBackground() == null)) {
              break label231;
            }
          }
          label226:
          label231:
          for (GradientDrawable localGradientDrawable = (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)localb.drb.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);; localGradientDrawable = null)
          {
            localGradientDrawable.setCornerRadius(paramInt + 1.0E-005F);
            localb.drp.setCornerRadius(paramInt + 1.0E-005F);
            localb.drq.setCornerRadius(paramInt + 1.0E-005F);
            localb.drr.setCornerRadius(paramInt + 1.0E-005F);
            AppMethodBeat.o(210227);
            return;
            localGradientDrawable = null;
            break;
          }
        }
        if ((!b.dra) && (localb.drl != null) && (localb.drn != null))
        {
          localb.drl.setCornerRadius(paramInt + 1.0E-005F);
          localb.drn.setCornerRadius(paramInt + 1.0E-005F);
          localb.drb.invalidate();
        }
      }
    }
    AppMethodBeat.o(210227);
  }
  
  public void setCornerRadiusResource(int paramInt)
  {
    AppMethodBeat.i(210234);
    if (VP()) {
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
    }
    AppMethodBeat.o(210234);
  }
  
  public void setIcon(Drawable paramDrawable)
  {
    AppMethodBeat.i(210101);
    if (this.dqY != paramDrawable)
    {
      this.dqY = paramDrawable;
      VO();
    }
    AppMethodBeat.o(210101);
  }
  
  public void setIconGravity(int paramInt)
  {
    this.iconGravity = paramInt;
  }
  
  public void setIconPadding(int paramInt)
  {
    AppMethodBeat.i(210066);
    if (this.iconPadding != paramInt)
    {
      this.iconPadding = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
    AppMethodBeat.o(210066);
  }
  
  public void setIconResource(int paramInt)
  {
    AppMethodBeat.i(210113);
    Drawable localDrawable = null;
    if (paramInt != 0) {
      localDrawable = androidx.appcompat.a.a.a.m(getContext(), paramInt);
    }
    setIcon(localDrawable);
    AppMethodBeat.o(210113);
  }
  
  public void setIconSize(int paramInt)
  {
    AppMethodBeat.i(210084);
    if (paramInt < 0)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("iconSize cannot be less than 0");
      AppMethodBeat.o(210084);
      throw localIllegalArgumentException;
    }
    if (this.iconSize != paramInt)
    {
      this.iconSize = paramInt;
      VO();
    }
    AppMethodBeat.o(210084);
  }
  
  public void setIconTint(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210128);
    if (this.dpR != paramColorStateList)
    {
      this.dpR = paramColorStateList;
      VO();
    }
    AppMethodBeat.o(210128);
  }
  
  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(210147);
    if (this.dqX != paramMode)
    {
      this.dqX = paramMode;
      VO();
    }
    AppMethodBeat.o(210147);
  }
  
  public void setIconTintResource(int paramInt)
  {
    AppMethodBeat.i(210136);
    setIconTint(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    AppMethodBeat.o(210136);
  }
  
  void setInternalBackground(Drawable paramDrawable)
  {
    AppMethodBeat.i(210057);
    super.setBackgroundDrawable(paramDrawable);
    AppMethodBeat.o(210057);
  }
  
  public void setRippleColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(210161);
    if (VP())
    {
      b localb = this.dqW;
      if (localb.drj != paramColorStateList)
      {
        localb.drj = paramColorStateList;
        if ((b.dra) && ((localb.drb.getBackground() instanceof RippleDrawable)))
        {
          ((RippleDrawable)localb.drb.getBackground()).setColor(paramColorStateList);
          AppMethodBeat.o(210161);
          return;
        }
        if ((!b.dra) && (localb.dro != null)) {
          androidx.core.graphics.drawable.a.a(localb.dro, paramColorStateList);
        }
      }
    }
    AppMethodBeat.o(210161);
  }
  
  public void setRippleColorResource(int paramInt)
  {
    AppMethodBeat.i(210168);
    if (VP()) {
      setRippleColor(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    }
    AppMethodBeat.o(210168);
  }
  
  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    int i = 0;
    AppMethodBeat.i(210185);
    if (VP())
    {
      b localb = this.dqW;
      if (localb.dri != paramColorStateList)
      {
        localb.dri = paramColorStateList;
        Paint localPaint = localb.drk;
        if (paramColorStateList != null) {
          i = paramColorStateList.getColorForState(localb.drb.getDrawableState(), 0);
        }
        localPaint.setColor(i);
        localb.VS();
      }
    }
    AppMethodBeat.o(210185);
  }
  
  public void setStrokeColorResource(int paramInt)
  {
    AppMethodBeat.i(210190);
    if (VP()) {
      setStrokeColor(androidx.appcompat.a.a.a.l(getContext(), paramInt));
    }
    AppMethodBeat.o(210190);
  }
  
  public void setStrokeWidth(int paramInt)
  {
    AppMethodBeat.i(210201);
    if (VP())
    {
      b localb = this.dqW;
      if (localb.strokeWidth != paramInt)
      {
        localb.strokeWidth = paramInt;
        localb.drk.setStrokeWidth(paramInt);
        localb.VS();
      }
    }
    AppMethodBeat.o(210201);
  }
  
  public void setStrokeWidthResource(int paramInt)
  {
    AppMethodBeat.i(210208);
    if (VP()) {
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
    }
    AppMethodBeat.o(210208);
  }
  
  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(209916);
    if (VP())
    {
      b localb = this.dqW;
      if (localb.drh != paramColorStateList)
      {
        localb.drh = paramColorStateList;
        if (b.dra)
        {
          localb.VQ();
          AppMethodBeat.o(209916);
          return;
        }
        if (localb.drm != null) {
          androidx.core.graphics.drawable.a.a(localb.drm, localb.drh);
        }
      }
      AppMethodBeat.o(209916);
      return;
    }
    if (this.dqW != null) {
      super.setSupportBackgroundTintList(paramColorStateList);
    }
    AppMethodBeat.o(209916);
  }
  
  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    AppMethodBeat.i(209938);
    if (VP())
    {
      b localb = this.dqW;
      if (localb.drg != paramMode)
      {
        localb.drg = paramMode;
        if (b.dra)
        {
          localb.VQ();
          AppMethodBeat.o(209938);
          return;
        }
        if ((localb.drm != null) && (localb.drg != null)) {
          androidx.core.graphics.drawable.a.a(localb.drm, localb.drg);
        }
      }
      AppMethodBeat.o(209938);
      return;
    }
    if (this.dqW != null) {
      super.setSupportBackgroundTintMode(paramMode);
    }
    AppMethodBeat.o(209938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.button.MaterialButton
 * JD-Core Version:    0.7.0.1
 */