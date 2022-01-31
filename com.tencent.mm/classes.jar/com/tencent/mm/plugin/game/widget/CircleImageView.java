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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.f.a;

public class CircleImageView
  extends ImageView
{
  private static final Bitmap.Config fdK = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType nEJ = ImageView.ScaleType.CENTER_CROP;
  private BitmapShader Ba;
  private final Matrix Bb;
  private int Bg;
  private int Bh;
  private float hLe;
  private int hLf;
  private final Paint hLg;
  private int jh;
  private boolean keQ;
  private Bitmap mBitmap;
  private final RectF nEK;
  private final RectF nEL;
  private final Paint nEM;
  private float nEN;
  private boolean nEO;
  private boolean nEP;
  private ColorFilter nO;
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(112386);
    this.nEK = new RectF();
    this.nEL = new RectF();
    this.Bb = new Matrix();
    this.nEM = new Paint();
    this.hLg = new Paint();
    this.hLf = -16777216;
    this.jh = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, f.a.CircleImageView, paramInt, 0);
    this.jh = paramContext.getDimensionPixelSize(0, 0);
    this.hLf = paramContext.getColor(1, -16777216);
    this.nEP = paramContext.getBoolean(2, false);
    paramContext.recycle();
    super.setScaleType(nEJ);
    this.keQ = true;
    if (this.nEO)
    {
      setup();
      this.nEO = false;
    }
    AppMethodBeat.o(112386);
  }
  
  private void bHI()
  {
    AppMethodBeat.i(112402);
    this.Bb.set(null);
    float f1;
    float f3;
    float f2;
    if (this.Bg * this.nEK.height() > this.nEK.width() * this.Bh)
    {
      f1 = this.nEK.height() / this.Bh;
      f3 = (this.nEK.width() - this.Bg * f1) * 0.5F;
      f2 = 0.0F;
    }
    for (;;)
    {
      this.Bb.setScale(f1, f1);
      this.Bb.postTranslate((int)(f3 + 0.5F) + this.nEK.left, (int)(f2 + 0.5F) + this.nEK.top);
      this.Ba.setLocalMatrix(this.Bb);
      AppMethodBeat.o(112402);
      return;
      f1 = this.nEK.width() / this.Bg;
      f2 = (this.nEK.height() - this.Bh * f1) * 0.5F;
      f3 = 0.0F;
    }
  }
  
  private static Bitmap r(Drawable paramDrawable)
  {
    AppMethodBeat.i(112400);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(112400);
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(112400);
      return paramDrawable;
    }
    try
    {
      if ((paramDrawable instanceof ColorDrawable)) {}
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, fdK);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), fdK))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        AppMethodBeat.o(112400);
        return localBitmap;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      AppMethodBeat.o(112400);
    }
  }
  
  private void setup()
  {
    AppMethodBeat.i(112401);
    if (!this.keQ)
    {
      this.nEO = true;
      AppMethodBeat.o(112401);
      return;
    }
    if (this.mBitmap == null)
    {
      AppMethodBeat.o(112401);
      return;
    }
    Bitmap localBitmap = this.mBitmap;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.Ba = new BitmapShader(localBitmap, localTileMode, localTileMode);
    this.nEM.setAntiAlias(true);
    this.nEM.setShader(this.Ba);
    this.hLg.setStyle(Paint.Style.STROKE);
    this.hLg.setAntiAlias(true);
    this.hLg.setColor(this.hLf);
    this.hLg.setStrokeWidth(this.jh);
    this.Bh = this.mBitmap.getHeight();
    this.Bg = this.mBitmap.getWidth();
    this.nEL.set(0.0F, 0.0F, getWidth(), getHeight());
    this.hLe = Math.min((this.nEL.height() - this.jh) / 2.0F, (this.nEL.width() - this.jh) / 2.0F);
    this.nEK.set(this.nEL);
    if (!this.nEP) {
      this.nEK.inset(this.jh, this.jh);
    }
    this.nEN = Math.min(this.nEK.height() / 2.0F, this.nEK.width() / 2.0F);
    bHI();
    invalidate();
    AppMethodBeat.o(112401);
  }
  
  public int getBorderColor()
  {
    return this.hLf;
  }
  
  public int getBorderWidth()
  {
    return this.jh;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return nEJ;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(112389);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(112389);
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.nEN, this.nEM);
    if (this.jh != 0) {
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.hLe, this.hLg);
    }
    AppMethodBeat.o(112389);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(112390);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
    AppMethodBeat.o(112390);
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    AppMethodBeat.i(112388);
    if (paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("adjustViewBounds not supported.");
      AppMethodBeat.o(112388);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(112388);
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(112391);
    if (paramInt == this.hLf)
    {
      AppMethodBeat.o(112391);
      return;
    }
    this.hLf = paramInt;
    this.hLg.setColor(this.hLf);
    invalidate();
    AppMethodBeat.o(112391);
  }
  
  public void setBorderColorResource(int paramInt)
  {
    AppMethodBeat.i(112392);
    setBorderColor(getContext().getResources().getColor(paramInt));
    AppMethodBeat.o(112392);
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    AppMethodBeat.i(112394);
    if (paramBoolean == this.nEP)
    {
      AppMethodBeat.o(112394);
      return;
    }
    this.nEP = paramBoolean;
    setup();
    AppMethodBeat.o(112394);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(112393);
    if (paramInt == this.jh)
    {
      AppMethodBeat.o(112393);
      return;
    }
    this.jh = paramInt;
    setup();
    AppMethodBeat.o(112393);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(112399);
    if (paramColorFilter == this.nO)
    {
      AppMethodBeat.o(112399);
      return;
    }
    this.nO = paramColorFilter;
    this.nEM.setColorFilter(this.nO);
    invalidate();
    AppMethodBeat.o(112399);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(112395);
    super.setImageBitmap(paramBitmap);
    this.mBitmap = paramBitmap;
    setup();
    AppMethodBeat.o(112395);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(112396);
    super.setImageDrawable(paramDrawable);
    this.mBitmap = r(paramDrawable);
    setup();
    AppMethodBeat.o(112396);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(112397);
    super.setImageResource(paramInt);
    this.mBitmap = r(getDrawable());
    setup();
    AppMethodBeat.o(112397);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(112398);
    super.setImageURI(paramUri);
    this.mBitmap = r(getDrawable());
    setup();
    AppMethodBeat.o(112398);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(112387);
    if (paramScaleType != nEJ)
    {
      paramScaleType = new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
      AppMethodBeat.o(112387);
      throw paramScaleType;
    }
    AppMethodBeat.o(112387);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.CircleImageView
 * JD-Core Version:    0.7.0.1
 */