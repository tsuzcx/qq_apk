package com.tencent.kinda.framework.widget.base;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

public class MMKViewBackgroundBorderDrawable
  extends Drawable
{
  private int backgroundColor;
  private int borderColor;
  private Path borderPath;
  private int borderPressedColor;
  private float borderRadius;
  private float borderWidth;
  private float bottomLeftBorderRadius;
  private float bottomRightBorderRadius;
  private Drawable insetDrawable;
  private Path insetDrawableClipPath;
  private boolean isPressed;
  private View mView;
  private Paint paint;
  private RectF roundBorderRectF;
  private float[] roundBorderradii;
  private float topLeftBorderRadius;
  private float topRightBorderRadius;
  
  public MMKViewBackgroundBorderDrawable(View paramView)
  {
    AppMethodBeat.i(145082);
    this.borderWidth = 0.0F;
    this.borderRadius = 0.0F;
    this.topLeftBorderRadius = 0.0F;
    this.topRightBorderRadius = 0.0F;
    this.bottomLeftBorderRadius = 0.0F;
    this.bottomRightBorderRadius = 0.0F;
    this.borderColor = 0;
    this.borderPressedColor = 0;
    this.isPressed = false;
    this.backgroundColor = 0;
    this.paint = new Paint();
    this.roundBorderRectF = new RectF();
    this.roundBorderradii = new float[8];
    this.paint = new Paint();
    this.paint.setAntiAlias(true);
    this.borderPath = new Path();
    this.insetDrawableClipPath = new Path();
    this.mView = paramView;
    AppMethodBeat.o(145082);
  }
  
  private boolean containsPressedState(int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < paramArrayOfInt.length)
      {
        if (paramArrayOfInt[i] == 16842919) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  private void drawClipRadiusBorder(Canvas paramCanvas)
  {
    AppMethodBeat.i(145096);
    this.paint.reset();
    this.borderPath.reset();
    this.insetDrawableClipPath.reset();
    this.paint.setAntiAlias(true);
    this.roundBorderRectF.set(getBounds());
    this.roundBorderRectF.inset(this.borderWidth / 2.0F, this.borderWidth / 2.0F);
    Arrays.fill(this.roundBorderradii, this.borderRadius);
    if (this.topLeftBorderRadius > 0.0F)
    {
      this.roundBorderradii[0] = this.topLeftBorderRadius;
      this.roundBorderradii[1] = this.topLeftBorderRadius;
    }
    if (this.topRightBorderRadius > 0.0F)
    {
      this.roundBorderradii[2] = this.topRightBorderRadius;
      this.roundBorderradii[3] = this.topRightBorderRadius;
    }
    if (this.bottomLeftBorderRadius > 0.0F)
    {
      this.roundBorderradii[4] = this.bottomLeftBorderRadius;
      this.roundBorderradii[5] = this.bottomLeftBorderRadius;
    }
    if (this.bottomRightBorderRadius > 0.0F)
    {
      this.roundBorderradii[6] = this.bottomRightBorderRadius;
      this.roundBorderradii[7] = this.bottomRightBorderRadius;
    }
    this.borderPath.addRoundRect(this.roundBorderRectF, this.roundBorderradii, Path.Direction.CCW);
    this.roundBorderRectF.set(getBounds());
    this.roundBorderRectF.inset(this.borderWidth, this.borderWidth);
    Arrays.fill(this.roundBorderradii, this.borderRadius);
    if (this.topLeftBorderRadius > 0.0F)
    {
      this.roundBorderradii[0] = this.topLeftBorderRadius;
      this.roundBorderradii[1] = this.topLeftBorderRadius;
    }
    if (this.topRightBorderRadius > 0.0F)
    {
      this.roundBorderradii[2] = this.topRightBorderRadius;
      this.roundBorderradii[3] = this.topRightBorderRadius;
    }
    if (this.bottomLeftBorderRadius > 0.0F)
    {
      this.roundBorderradii[4] = this.bottomLeftBorderRadius;
      this.roundBorderradii[5] = this.bottomLeftBorderRadius;
    }
    if (this.bottomRightBorderRadius > 0.0F)
    {
      this.roundBorderradii[6] = this.bottomRightBorderRadius;
      this.roundBorderradii[7] = this.bottomRightBorderRadius;
    }
    this.insetDrawableClipPath.addRoundRect(this.roundBorderRectF, this.roundBorderradii, Path.Direction.CCW);
    if ((this.insetDrawable == null) && (Color.alpha(this.backgroundColor) > 0))
    {
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setColor(this.backgroundColor);
      paramCanvas.drawPath(this.borderPath, this.paint);
    }
    if ((Color.alpha(this.borderColor) > 0) && (!this.isPressed))
    {
      this.paint.setColor(this.borderColor);
      this.paint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.borderPath, this.paint);
      if (this.insetDrawable != null)
      {
        paramCanvas.clipPath(this.insetDrawableClipPath);
        AppMethodBeat.o(145096);
      }
    }
    else if ((Color.alpha(this.borderPressedColor) > 0) && (this.isPressed))
    {
      this.paint.setColor(this.borderPressedColor);
      this.paint.setStyle(Paint.Style.FILL);
      paramCanvas.drawPath(this.borderPath, this.paint);
      if (this.insetDrawable != null)
      {
        paramCanvas.clipPath(this.insetDrawableClipPath);
        AppMethodBeat.o(145096);
      }
    }
    else
    {
      paramCanvas.clipPath(this.insetDrawableClipPath);
    }
    AppMethodBeat.o(145096);
  }
  
  private void drawClipRectBorder(Canvas paramCanvas)
  {
    AppMethodBeat.i(145095);
    Rect localRect = getBounds();
    int i = localRect.top;
    int j = localRect.left;
    int k = localRect.width();
    int m = localRect.height();
    this.paint.reset();
    if (this.isPressed) {
      this.paint.setColor(this.borderPressedColor);
    }
    for (;;)
    {
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setAntiAlias(true);
      this.borderPath.reset();
      this.borderPath.moveTo(j, i);
      this.borderPath.lineTo(j + this.borderWidth, i);
      this.borderPath.lineTo(j + this.borderWidth, i + m);
      this.borderPath.lineTo(j, i + m);
      this.borderPath.lineTo(j, i);
      paramCanvas.drawPath(this.borderPath, this.paint);
      this.borderPath.reset();
      this.borderPath.moveTo(j + this.borderWidth, i);
      this.borderPath.lineTo(j + k, i);
      this.borderPath.lineTo(j + k, i + this.borderWidth);
      this.borderPath.lineTo(j + this.borderWidth, i + this.borderWidth);
      this.borderPath.lineTo(j + this.borderWidth, i);
      paramCanvas.drawPath(this.borderPath, this.paint);
      this.borderPath.reset();
      this.borderPath.moveTo(j + k, i);
      this.borderPath.lineTo(j + k, i + m);
      this.borderPath.lineTo(j + k - this.borderWidth, i + m);
      this.borderPath.lineTo(j + k - this.borderWidth, i);
      this.borderPath.lineTo(j + k, i);
      paramCanvas.drawPath(this.borderPath, this.paint);
      this.borderPath.reset();
      this.borderPath.moveTo(j + this.borderWidth, i + m - this.borderWidth);
      this.borderPath.lineTo(j + k, i + m - this.borderWidth);
      this.borderPath.lineTo(k + j, i + m);
      this.borderPath.lineTo(j + this.borderWidth, i + m);
      this.borderPath.lineTo(j + this.borderWidth, m + i - this.borderWidth);
      paramCanvas.drawPath(this.borderPath, this.paint);
      this.paint.setAntiAlias(false);
      AppMethodBeat.o(145095);
      return;
      this.paint.setColor(this.borderColor);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(145094);
    Rect localRect = getBounds();
    int i = localRect.width();
    int j = localRect.height();
    if ((i <= 0) || (j <= 0))
    {
      AppMethodBeat.o(145094);
      return;
    }
    this.paint.reset();
    if ((this.borderRadius <= 0.0F) && (this.topLeftBorderRadius <= 0.0F) && (this.topRightBorderRadius <= 0.0F) && (this.bottomLeftBorderRadius <= 0.0F) && (this.bottomRightBorderRadius <= 0.0F)) {
      if (this.insetDrawable == null) {
        paramCanvas.drawARGB(Color.alpha(this.backgroundColor), Color.red(this.backgroundColor), Color.green(this.backgroundColor), Color.blue(this.backgroundColor));
      }
    }
    while (this.borderWidth > 0.0F)
    {
      drawClipRectBorder(paramCanvas);
      AppMethodBeat.o(145094);
      return;
      this.insetDrawable.draw(paramCanvas);
      continue;
      drawClipRadiusBorder(paramCanvas);
      if (this.insetDrawable != null) {
        this.insetDrawable.draw(paramCanvas);
      }
    }
    AppMethodBeat.o(145094);
  }
  
  public int getOpacity()
  {
    AppMethodBeat.i(145084);
    if (this.insetDrawable != null)
    {
      int i = this.insetDrawable.getOpacity();
      AppMethodBeat.o(145084);
      return i;
    }
    if (this.backgroundColor == 0)
    {
      AppMethodBeat.o(145084);
      return -2;
    }
    if (Color.alpha(this.backgroundColor) > 0)
    {
      AppMethodBeat.o(145084);
      return -3;
    }
    AppMethodBeat.o(145084);
    return -1;
  }
  
  public boolean isStateful()
  {
    AppMethodBeat.i(145097);
    if (this.insetDrawable != null)
    {
      boolean bool = this.insetDrawable.isStateful();
      AppMethodBeat.o(145097);
      return bool;
    }
    AppMethodBeat.o(145097);
    return false;
  }
  
  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    AppMethodBeat.i(145098);
    if ((this.mView != null) && (!this.mView.isEnabled()) && (containsPressedState(paramArrayOfInt)) && (!this.isPressed))
    {
      AppMethodBeat.o(145098);
      return false;
    }
    if (containsPressedState(paramArrayOfInt)) {}
    for (this.isPressed = true; this.insetDrawable != null; this.isPressed = false)
    {
      bool = this.insetDrawable.setState(paramArrayOfInt);
      invalidateSelf();
      AppMethodBeat.o(145098);
      return bool;
    }
    boolean bool = super.onStateChange(paramArrayOfInt);
    AppMethodBeat.o(145098);
    return bool;
  }
  
  public void setAlpha(int paramInt)
  {
    AppMethodBeat.i(145099);
    if (this.insetDrawable != null) {
      this.insetDrawable.setAlpha(paramInt);
    }
    AppMethodBeat.o(145099);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(145093);
    if (this.backgroundColor != paramInt)
    {
      this.backgroundColor = paramInt;
      invalidateSelf();
    }
    AppMethodBeat.o(145093);
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(145086);
    if (this.borderColor != paramInt)
    {
      this.borderColor = paramInt;
      invalidateSelf();
    }
    AppMethodBeat.o(145086);
  }
  
  public void setBorderPressedColor(int paramInt)
  {
    AppMethodBeat.i(145087);
    if (this.borderPressedColor != paramInt)
    {
      this.borderPressedColor = paramInt;
      invalidateSelf();
    }
    AppMethodBeat.o(145087);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    AppMethodBeat.i(145088);
    if (this.borderRadius != paramFloat)
    {
      this.borderRadius = paramFloat;
      invalidateSelf();
    }
    AppMethodBeat.o(145088);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(145085);
    if (this.borderWidth != paramFloat)
    {
      this.borderWidth = paramFloat;
      invalidateSelf();
    }
    AppMethodBeat.o(145085);
  }
  
  public void setBottomLeftBorderRadius(float paramFloat)
  {
    AppMethodBeat.i(145091);
    if (this.bottomLeftBorderRadius != paramFloat)
    {
      this.bottomLeftBorderRadius = paramFloat;
      invalidateSelf();
    }
    AppMethodBeat.o(145091);
  }
  
  public void setBottomRightBorderRadius(float paramFloat)
  {
    AppMethodBeat.i(145092);
    if (this.bottomRightBorderRadius != paramFloat)
    {
      this.bottomRightBorderRadius = paramFloat;
      invalidateSelf();
    }
    AppMethodBeat.o(145092);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(145100);
    if (this.insetDrawable != null) {
      this.insetDrawable.setColorFilter(paramColorFilter);
    }
    AppMethodBeat.o(145100);
  }
  
  public void setInsetDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(145083);
    this.insetDrawable = paramDrawable;
    invalidateSelf();
    AppMethodBeat.o(145083);
  }
  
  public void setTopLeftBorderRadius(float paramFloat)
  {
    AppMethodBeat.i(145089);
    if (this.topLeftBorderRadius != paramFloat)
    {
      this.topLeftBorderRadius = paramFloat;
      invalidateSelf();
    }
    AppMethodBeat.o(145089);
  }
  
  public void setTopRightBorderRadius(float paramFloat)
  {
    AppMethodBeat.i(145090);
    if (this.topRightBorderRadius != paramFloat)
    {
      this.topRightBorderRadius = paramFloat;
      invalidateSelf();
    }
    AppMethodBeat.o(145090);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKViewBackgroundBorderDrawable
 * JD-Core Version:    0.7.0.1
 */