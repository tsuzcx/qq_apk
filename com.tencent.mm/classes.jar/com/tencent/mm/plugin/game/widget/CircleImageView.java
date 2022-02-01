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
  private static final Bitmap.Config hew = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType twK = ImageView.ScaleType.CENTER_CROP;
  private BitmapShader It;
  private final Matrix Iu;
  private float kpJ;
  private int kpM;
  private final Paint kpN;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private final RectF twL;
  private final RectF twM;
  private final Paint twN;
  private int twO;
  private float twP;
  private boolean twQ;
  private boolean twR;
  private boolean twS;
  private ColorFilter vo;
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42593);
    this.twL = new RectF();
    this.twM = new RectF();
    this.Iu = new Matrix();
    this.twN = new Paint();
    this.kpN = new Paint();
    this.kpM = -16777216;
    this.twO = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, f.a.CircleImageView, paramInt, 0);
    this.twO = paramContext.getDimensionPixelSize(2, 0);
    this.kpM = paramContext.getColor(0, -16777216);
    this.twS = paramContext.getBoolean(1, false);
    paramContext.recycle();
    super.setScaleType(twK);
    this.twQ = true;
    if (this.twR)
    {
      setup();
      this.twR = false;
    }
    AppMethodBeat.o(42593);
  }
  
  private void cRP()
  {
    AppMethodBeat.i(42609);
    this.Iu.set(null);
    float f1;
    float f3;
    float f2;
    if (this.mBitmapWidth * this.twL.height() > this.twL.width() * this.mBitmapHeight)
    {
      f1 = this.twL.height() / this.mBitmapHeight;
      f3 = (this.twL.width() - this.mBitmapWidth * f1) * 0.5F;
      f2 = 0.0F;
    }
    for (;;)
    {
      this.Iu.setScale(f1, f1);
      this.Iu.postTranslate((int)(f3 + 0.5F) + this.twL.left, (int)(f2 + 0.5F) + this.twL.top);
      this.It.setLocalMatrix(this.Iu);
      AppMethodBeat.o(42609);
      return;
      f1 = this.twL.width() / this.mBitmapWidth;
      f2 = (this.twL.height() - this.mBitmapHeight * f1) * 0.5F;
      f3 = 0.0F;
    }
  }
  
  private void setup()
  {
    AppMethodBeat.i(42608);
    if (!this.twQ)
    {
      this.twR = true;
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
    this.It = new BitmapShader(localBitmap, localTileMode, localTileMode);
    this.twN.setAntiAlias(true);
    this.twN.setShader(this.It);
    this.kpN.setStyle(Paint.Style.STROKE);
    this.kpN.setAntiAlias(true);
    this.kpN.setColor(this.kpM);
    this.kpN.setStrokeWidth(this.twO);
    this.mBitmapHeight = this.mBitmap.getHeight();
    this.mBitmapWidth = this.mBitmap.getWidth();
    this.twM.set(0.0F, 0.0F, getWidth(), getHeight());
    this.kpJ = Math.min((this.twM.height() - this.twO) / 2.0F, (this.twM.width() - this.twO) / 2.0F);
    this.twL.set(this.twM);
    if (!this.twS) {
      this.twL.inset(this.twO, this.twO);
    }
    this.twP = Math.min(this.twL.height() / 2.0F, this.twL.width() / 2.0F);
    cRP();
    invalidate();
    AppMethodBeat.o(42608);
  }
  
  private static Bitmap y(Drawable paramDrawable)
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
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, hew);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), hew))
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
    return this.kpM;
  }
  
  public int getBorderWidth()
  {
    return this.twO;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return twK;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42596);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(42596);
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.twP, this.twN);
    if (this.twO != 0) {
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.kpJ, this.kpN);
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
    if (paramInt == this.kpM)
    {
      AppMethodBeat.o(42598);
      return;
    }
    this.kpM = paramInt;
    this.kpN.setColor(this.kpM);
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
    if (paramBoolean == this.twS)
    {
      AppMethodBeat.o(42601);
      return;
    }
    this.twS = paramBoolean;
    setup();
    AppMethodBeat.o(42601);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(42600);
    if (paramInt == this.twO)
    {
      AppMethodBeat.o(42600);
      return;
    }
    this.twO = paramInt;
    setup();
    AppMethodBeat.o(42600);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(42606);
    if (paramColorFilter == this.vo)
    {
      AppMethodBeat.o(42606);
      return;
    }
    this.vo = paramColorFilter;
    this.twN.setColorFilter(this.vo);
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
    this.mBitmap = y(paramDrawable);
    setup();
    AppMethodBeat.o(42603);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(42604);
    super.setImageResource(paramInt);
    this.mBitmap = y(getDrawable());
    setup();
    AppMethodBeat.o(42604);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(42605);
    super.setImageURI(paramUri);
    this.mBitmap = y(getDrawable());
    setup();
    AppMethodBeat.o(42605);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(42594);
    if (paramScaleType != twK)
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