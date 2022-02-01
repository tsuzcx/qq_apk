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
import android.support.annotation.a;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.a;

public class CircleImageView
  extends ImageView
{
  private static final Bitmap.Config itA = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType xZH = ImageView.ScaleType.CENTER_CROP;
  private BitmapShader Kv;
  private final Matrix Kw;
  private float lSR;
  private int lST;
  private final Paint lSU;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private final RectF xZI;
  private final RectF xZJ;
  private final Paint xZK;
  private int xZL;
  private float xZM;
  private boolean xZN;
  private boolean xZO;
  private boolean xZP;
  private ColorFilter xo;
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42593);
    this.xZI = new RectF();
    this.xZJ = new RectF();
    this.Kw = new Matrix();
    this.xZK = new Paint();
    this.lSU = new Paint();
    this.lST = -16777216;
    this.xZL = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, g.a.CircleImageView, paramInt, 0);
    this.xZL = paramContext.getDimensionPixelSize(2, 0);
    this.lST = paramContext.getColor(0, -16777216);
    this.xZP = paramContext.getBoolean(1, false);
    paramContext.recycle();
    super.setScaleType(xZH);
    this.xZN = true;
    if (this.xZO)
    {
      setup();
      this.xZO = false;
    }
    AppMethodBeat.o(42593);
  }
  
  private void dWV()
  {
    AppMethodBeat.i(42609);
    this.Kw.set(null);
    float f1;
    float f3;
    float f2;
    if (this.mBitmapWidth * this.xZI.height() > this.xZI.width() * this.mBitmapHeight)
    {
      f1 = this.xZI.height() / this.mBitmapHeight;
      f3 = (this.xZI.width() - this.mBitmapWidth * f1) * 0.5F;
      f2 = 0.0F;
    }
    for (;;)
    {
      this.Kw.setScale(f1, f1);
      this.Kw.postTranslate((int)(f3 + 0.5F) + this.xZI.left, (int)(f2 + 0.5F) + this.xZI.top);
      this.Kv.setLocalMatrix(this.Kw);
      AppMethodBeat.o(42609);
      return;
      f1 = this.xZI.width() / this.mBitmapWidth;
      f2 = (this.xZI.height() - this.mBitmapHeight * f1) * 0.5F;
      f3 = 0.0F;
    }
  }
  
  private void setup()
  {
    AppMethodBeat.i(42608);
    if (!this.xZN)
    {
      this.xZO = true;
      AppMethodBeat.o(42608);
      return;
    }
    if (this.mBitmap == null)
    {
      AppMethodBeat.o(42608);
      return;
    }
    Bitmap localBitmap = this.mBitmap;
    Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
    this.Kv = new BitmapShader(localBitmap, localTileMode, localTileMode);
    this.xZK.setAntiAlias(true);
    this.xZK.setShader(this.Kv);
    this.lSU.setStyle(Paint.Style.STROKE);
    this.lSU.setAntiAlias(true);
    this.lSU.setColor(this.lST);
    this.lSU.setStrokeWidth(this.xZL);
    this.mBitmapHeight = this.mBitmap.getHeight();
    this.mBitmapWidth = this.mBitmap.getWidth();
    this.xZJ.set(0.0F, 0.0F, getWidth(), getHeight());
    this.lSR = Math.min((this.xZJ.height() - this.xZL) / 2.0F, (this.xZJ.width() - this.xZL) / 2.0F);
    this.xZI.set(this.xZJ);
    if (!this.xZP) {
      this.xZI.inset(this.xZL, this.xZL);
    }
    this.xZM = Math.min(this.xZI.height() / 2.0F, this.xZI.width() / 2.0F);
    dWV();
    invalidate();
    AppMethodBeat.o(42608);
  }
  
  private static Bitmap z(Drawable paramDrawable)
  {
    AppMethodBeat.i(42607);
    if (paramDrawable == null)
    {
      AppMethodBeat.o(42607);
      return null;
    }
    if ((paramDrawable instanceof BitmapDrawable))
    {
      paramDrawable = ((BitmapDrawable)paramDrawable).getBitmap();
      AppMethodBeat.o(42607);
      return paramDrawable;
    }
    try
    {
      if ((paramDrawable instanceof ColorDrawable)) {}
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, itA);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), itA))
      {
        Canvas localCanvas = new Canvas(localBitmap);
        paramDrawable.setBounds(0, 0, localCanvas.getWidth(), localCanvas.getHeight());
        paramDrawable.draw(localCanvas);
        AppMethodBeat.o(42607);
        return localBitmap;
      }
      return null;
    }
    catch (OutOfMemoryError paramDrawable)
    {
      AppMethodBeat.o(42607);
    }
  }
  
  public int getBorderColor()
  {
    return this.lST;
  }
  
  public int getBorderWidth()
  {
    return this.xZL;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return xZH;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42596);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(42596);
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.xZM, this.xZK);
    if (this.xZL != 0) {
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.lSR, this.lSU);
    }
    AppMethodBeat.o(42596);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(42597);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    setup();
    AppMethodBeat.o(42597);
  }
  
  public void setAdjustViewBounds(boolean paramBoolean)
  {
    AppMethodBeat.i(42595);
    if (paramBoolean)
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException("adjustViewBounds not supported.");
      AppMethodBeat.o(42595);
      throw localIllegalArgumentException;
    }
    AppMethodBeat.o(42595);
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(42598);
    if (paramInt == this.lST)
    {
      AppMethodBeat.o(42598);
      return;
    }
    this.lST = paramInt;
    this.lSU.setColor(this.lST);
    invalidate();
    AppMethodBeat.o(42598);
  }
  
  public void setBorderColorResource(@a int paramInt)
  {
    AppMethodBeat.i(42599);
    setBorderColor(getContext().getResources().getColor(paramInt));
    AppMethodBeat.o(42599);
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    AppMethodBeat.i(42601);
    if (paramBoolean == this.xZP)
    {
      AppMethodBeat.o(42601);
      return;
    }
    this.xZP = paramBoolean;
    setup();
    AppMethodBeat.o(42601);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(42600);
    if (paramInt == this.xZL)
    {
      AppMethodBeat.o(42600);
      return;
    }
    this.xZL = paramInt;
    setup();
    AppMethodBeat.o(42600);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(42606);
    if (paramColorFilter == this.xo)
    {
      AppMethodBeat.o(42606);
      return;
    }
    this.xo = paramColorFilter;
    this.xZK.setColorFilter(this.xo);
    invalidate();
    AppMethodBeat.o(42606);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(42602);
    super.setImageBitmap(paramBitmap);
    this.mBitmap = paramBitmap;
    setup();
    AppMethodBeat.o(42602);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(42603);
    super.setImageDrawable(paramDrawable);
    this.mBitmap = z(paramDrawable);
    setup();
    AppMethodBeat.o(42603);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(42604);
    super.setImageResource(paramInt);
    this.mBitmap = z(getDrawable());
    setup();
    AppMethodBeat.o(42604);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(42605);
    super.setImageURI(paramUri);
    this.mBitmap = z(getDrawable());
    setup();
    AppMethodBeat.o(42605);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(42594);
    if (paramScaleType != xZH)
    {
      paramScaleType = new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
      AppMethodBeat.o(42594);
      throw paramScaleType;
    }
    AppMethodBeat.o(42594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.CircleImageView
 * JD-Core Version:    0.7.0.1
 */