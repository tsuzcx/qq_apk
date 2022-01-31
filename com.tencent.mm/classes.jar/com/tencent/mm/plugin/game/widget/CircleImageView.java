package com.tencent.mm.plugin.game.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.game.g.k;

public class CircleImageView
  extends ImageView
{
  private static final Bitmap.Config dPd = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType lgQ = ImageView.ScaleType.CENTER_CROP;
  private BitmapShader Ao;
  private final Matrix Ap = new Matrix();
  private int Au;
  private int Av;
  private float gqm;
  private int gqn = -16777216;
  private final Paint gqo = new Paint();
  private int il = 0;
  private final RectF lgR = new RectF();
  private final RectF lgS = new RectF();
  private final Paint lgT = new Paint();
  private float lgU;
  private boolean lgV;
  private boolean lgW;
  private boolean lgX;
  private Bitmap mBitmap;
  private ColorFilter mR;
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, g.k.CircleImageView, paramInt, 0);
    this.il = paramContext.getDimensionPixelSize(g.k.CircleImageView_border_width, 0);
    this.gqn = paramContext.getColor(g.k.CircleImageView_border_color, -16777216);
    this.lgX = paramContext.getBoolean(g.k.CircleImageView_border_overlay, false);
    paramContext.recycle();
    super.setScaleType(lgQ);
    this.lgV = true;
    if (this.lgW)
    {
      setup();
      this.lgW = false;
    }
  }
  
  private static Bitmap n(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable)) {
      return ((BitmapDrawable)paramDrawable).getBitmap();
    }
    try
    {
      if ((paramDrawable instanceof ColorDrawable)) {}
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, dPd);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), dPd))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        return localBitmap;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable) {}
  }
  
  private void setup()
  {
    if (!this.lgV) {
      this.lgW = true;
    }
    while (this.mBitmap == null) {
      return;
    }
    this.Ao = new BitmapShader(this.mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    this.lgT.setAntiAlias(true);
    this.lgT.setShader(this.Ao);
    this.gqo.setStyle(Paint.Style.STROKE);
    this.gqo.setAntiAlias(true);
    this.gqo.setColor(this.gqn);
    this.gqo.setStrokeWidth(this.il);
    this.Av = this.mBitmap.getHeight();
    this.Au = this.mBitmap.getWidth();
    this.lgS.set(0.0F, 0.0F, getWidth(), getHeight());
    this.gqm = Math.min((this.lgS.height() - this.il) / 2.0F, (this.lgS.width() - this.il) / 2.0F);
    this.lgR.set(this.lgS);
    if (!this.lgX) {
      this.lgR.inset(this.il, this.il);
    }
    this.lgU = Math.min(this.lgR.height() / 2.0F, this.lgR.width() / 2.0F);
    this.Ap.set(null);
    float f3;
    float f2;
    float f1;
    if (this.Au * this.lgR.height() > this.lgR.width() * this.Av)
    {
      f3 = this.lgR.height() / this.Av;
      f2 = (this.lgR.width() - this.Au * f3) * 0.5F;
      f1 = 0.0F;
    }
    for (;;)
    {
      this.Ap.setScale(f3, f3);
      this.Ap.postTranslate((int)(f2 + 0.5F) + this.lgR.left, (int)(f1 + 0.5F) + this.lgR.top);
      this.Ao.setLocalMatrix(this.Ap);
      invalidate();
      return;
      f3 = this.lgR.width() / this.Au;
      f1 = (this.lgR.height() - this.Av * f3) * 0.5F;
      f2 = 0.0F;
    }
  }
  
  public int getBorderColor()
  {
    return this.gqn;
  }
  
  public int getBorderWidth()
  {
    return this.il;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return lgQ;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getDrawable() == null) {}
    do
    {
      return;
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.lgU, this.lgT);
    } while (this.il == 0);
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.gqm, this.gqo);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    if (paramBoolean) {
      throw new IllegalArgumentException("adjustViewBounds not supported.");
    }
  }
  
  public void setBorderColor(int paramInt)
  {
    if (paramInt == this.gqn) {
      return;
    }
    this.gqn = paramInt;
    this.gqo.setColor(this.gqn);
    invalidate();
  }
  
  public void setBorderColorResource(int paramInt)
  {
    setBorderColor(getContext().getResources().getColor(paramInt));
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    if (paramBoolean == this.lgX) {
      return;
    }
    this.lgX = paramBoolean;
    setup();
  }
  
  public void setBorderWidth(int paramInt)
  {
    if (paramInt == this.il) {
      return;
    }
    this.il = paramInt;
    setup();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    if (paramColorFilter == this.mR) {
      return;
    }
    this.mR = paramColorFilter;
    this.lgT.setColorFilter(this.mR);
    invalidate();
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
    this.mBitmap = paramBitmap;
    setup();
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    this.mBitmap = n(paramDrawable);
    setup();
  }
  
  public void setImageResource(int paramInt)
  {
    super.setImageResource(paramInt);
    this.mBitmap = n(getDrawable());
    setup();
  }
  
  public void setImageURI(Uri paramUri)
  {
    super.setImageURI(paramUri);
    this.mBitmap = n(getDrawable());
    setup();
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType != lgQ) {
      throw new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.CircleImageView
 * JD-Core Version:    0.7.0.1
 */