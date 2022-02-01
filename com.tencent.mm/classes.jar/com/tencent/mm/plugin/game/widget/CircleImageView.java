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
import com.tencent.mm.plugin.game.g.a;

public class CircleImageView
  extends ImageView
{
  private static final Bitmap.Config hzs = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType uHv = ImageView.ScaleType.CENTER_CROP;
  private BitmapShader Kl;
  private final Matrix Km;
  private float kNY;
  private int kOb;
  private final Paint kOc;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private float uHA;
  private boolean uHB;
  private boolean uHC;
  private boolean uHD;
  private final RectF uHw;
  private final RectF uHx;
  private final Paint uHy;
  private int uHz;
  private ColorFilter xh;
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42593);
    this.uHw = new RectF();
    this.uHx = new RectF();
    this.Km = new Matrix();
    this.uHy = new Paint();
    this.kOc = new Paint();
    this.kOb = -16777216;
    this.uHz = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, g.a.CircleImageView, paramInt, 0);
    this.uHz = paramContext.getDimensionPixelSize(2, 0);
    this.kOb = paramContext.getColor(0, -16777216);
    this.uHD = paramContext.getBoolean(1, false);
    paramContext.recycle();
    super.setScaleType(uHv);
    this.uHB = true;
    if (this.uHC)
    {
      setup();
      this.uHC = false;
    }
    AppMethodBeat.o(42593);
  }
  
  private void ddl()
  {
    AppMethodBeat.i(42609);
    this.Km.set(null);
    float f1;
    float f3;
    float f2;
    if (this.mBitmapWidth * this.uHw.height() > this.uHw.width() * this.mBitmapHeight)
    {
      f1 = this.uHw.height() / this.mBitmapHeight;
      f3 = (this.uHw.width() - this.mBitmapWidth * f1) * 0.5F;
      f2 = 0.0F;
    }
    for (;;)
    {
      this.Km.setScale(f1, f1);
      this.Km.postTranslate((int)(f3 + 0.5F) + this.uHw.left, (int)(f2 + 0.5F) + this.uHw.top);
      this.Kl.setLocalMatrix(this.Km);
      AppMethodBeat.o(42609);
      return;
      f1 = this.uHw.width() / this.mBitmapWidth;
      f2 = (this.uHw.height() - this.mBitmapHeight * f1) * 0.5F;
      f3 = 0.0F;
    }
  }
  
  private void setup()
  {
    AppMethodBeat.i(42608);
    if (!this.uHB)
    {
      this.uHC = true;
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
    this.Kl = new BitmapShader(localBitmap, localTileMode, localTileMode);
    this.uHy.setAntiAlias(true);
    this.uHy.setShader(this.Kl);
    this.kOc.setStyle(Paint.Style.STROKE);
    this.kOc.setAntiAlias(true);
    this.kOc.setColor(this.kOb);
    this.kOc.setStrokeWidth(this.uHz);
    this.mBitmapHeight = this.mBitmap.getHeight();
    this.mBitmapWidth = this.mBitmap.getWidth();
    this.uHx.set(0.0F, 0.0F, getWidth(), getHeight());
    this.kNY = Math.min((this.uHx.height() - this.uHz) / 2.0F, (this.uHx.width() - this.uHz) / 2.0F);
    this.uHw.set(this.uHx);
    if (!this.uHD) {
      this.uHw.inset(this.uHz, this.uHz);
    }
    this.uHA = Math.min(this.uHw.height() / 2.0F, this.uHw.width() / 2.0F);
    ddl();
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
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, hzs);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), hzs))
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
    return this.kOb;
  }
  
  public int getBorderWidth()
  {
    return this.uHz;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return uHv;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42596);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(42596);
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.uHA, this.uHy);
    if (this.uHz != 0) {
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.kNY, this.kOc);
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
    if (paramInt == this.kOb)
    {
      AppMethodBeat.o(42598);
      return;
    }
    this.kOb = paramInt;
    this.kOc.setColor(this.kOb);
    invalidate();
    AppMethodBeat.o(42598);
  }
  
  public void setBorderColorResource(int paramInt)
  {
    AppMethodBeat.i(42599);
    setBorderColor(getContext().getResources().getColor(paramInt));
    AppMethodBeat.o(42599);
  }
  
  public void setBorderOverlay(boolean paramBoolean)
  {
    AppMethodBeat.i(42601);
    if (paramBoolean == this.uHD)
    {
      AppMethodBeat.o(42601);
      return;
    }
    this.uHD = paramBoolean;
    setup();
    AppMethodBeat.o(42601);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(42600);
    if (paramInt == this.uHz)
    {
      AppMethodBeat.o(42600);
      return;
    }
    this.uHz = paramInt;
    setup();
    AppMethodBeat.o(42600);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(42606);
    if (paramColorFilter == this.xh)
    {
      AppMethodBeat.o(42606);
      return;
    }
    this.xh = paramColorFilter;
    this.uHy.setColorFilter(this.xh);
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
    if (paramScaleType != uHv)
    {
      paramScaleType = new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
      AppMethodBeat.o(42594);
      throw paramScaleType;
    }
    AppMethodBeat.o(42594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.CircleImageView
 * JD-Core Version:    0.7.0.1
 */