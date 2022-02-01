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
import com.tencent.mm.plugin.game.h.k;

public class CircleImageView
  extends ImageView
{
  private static final ImageView.ScaleType IYF = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config nNu = Bitmap.Config.ARGB_8888;
  private final RectF IYG;
  private final RectF IYH;
  private final Paint IYI;
  private int IYJ;
  private float IYK;
  private boolean IYL;
  private boolean IYM;
  private boolean IYN;
  private BitmapShader brc;
  private final Matrix brd;
  private ColorFilter kx;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private float rTn;
  private int rTq;
  private final Paint rTr;
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42593);
    this.IYG = new RectF();
    this.IYH = new RectF();
    this.brd = new Matrix();
    this.IYI = new Paint();
    this.rTr = new Paint();
    this.rTq = -16777216;
    this.IYJ = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, h.k.gZO, paramInt, 0);
    this.IYJ = paramContext.getDimensionPixelSize(h.k.Icu, 0);
    this.rTq = paramContext.getColor(h.k.Ics, -16777216);
    this.IYN = paramContext.getBoolean(h.k.Ict, false);
    paramContext.recycle();
    super.setScaleType(IYF);
    this.IYL = true;
    if (this.IYM)
    {
      setup();
      this.IYM = false;
    }
    AppMethodBeat.o(42593);
  }
  
  private static Bitmap P(Drawable paramDrawable)
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
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, nNu);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), nNu))
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
  
  private void fIf()
  {
    AppMethodBeat.i(42609);
    this.brd.set(null);
    float f1;
    float f3;
    float f2;
    if (this.mBitmapWidth * this.IYG.height() > this.IYG.width() * this.mBitmapHeight)
    {
      f1 = this.IYG.height() / this.mBitmapHeight;
      f3 = (this.IYG.width() - this.mBitmapWidth * f1) * 0.5F;
      f2 = 0.0F;
    }
    for (;;)
    {
      this.brd.setScale(f1, f1);
      this.brd.postTranslate((int)(f3 + 0.5F) + this.IYG.left, (int)(f2 + 0.5F) + this.IYG.top);
      this.brc.setLocalMatrix(this.brd);
      AppMethodBeat.o(42609);
      return;
      f1 = this.IYG.width() / this.mBitmapWidth;
      f2 = (this.IYG.height() - this.mBitmapHeight * f1) * 0.5F;
      f3 = 0.0F;
    }
  }
  
  private void setup()
  {
    AppMethodBeat.i(42608);
    if (!this.IYL)
    {
      this.IYM = true;
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
    this.brc = new BitmapShader(localBitmap, localTileMode, localTileMode);
    this.IYI.setAntiAlias(true);
    this.IYI.setShader(this.brc);
    this.rTr.setStyle(Paint.Style.STROKE);
    this.rTr.setAntiAlias(true);
    this.rTr.setColor(this.rTq);
    this.rTr.setStrokeWidth(this.IYJ);
    this.mBitmapHeight = this.mBitmap.getHeight();
    this.mBitmapWidth = this.mBitmap.getWidth();
    this.IYH.set(0.0F, 0.0F, getWidth(), getHeight());
    this.rTn = Math.min((this.IYH.height() - this.IYJ) / 2.0F, (this.IYH.width() - this.IYJ) / 2.0F);
    this.IYG.set(this.IYH);
    if (!this.IYN) {
      this.IYG.inset(this.IYJ, this.IYJ);
    }
    this.IYK = Math.min(this.IYG.height() / 2.0F, this.IYG.width() / 2.0F);
    fIf();
    invalidate();
    AppMethodBeat.o(42608);
  }
  
  public int getBorderColor()
  {
    return this.rTq;
  }
  
  public int getBorderWidth()
  {
    return this.IYJ;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return IYF;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42596);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(42596);
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.IYK, this.IYI);
    if (this.IYJ != 0) {
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.rTn, this.rTr);
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
    if (paramInt == this.rTq)
    {
      AppMethodBeat.o(42598);
      return;
    }
    this.rTq = paramInt;
    this.rTr.setColor(this.rTq);
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
    if (paramBoolean == this.IYN)
    {
      AppMethodBeat.o(42601);
      return;
    }
    this.IYN = paramBoolean;
    setup();
    AppMethodBeat.o(42601);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(42600);
    if (paramInt == this.IYJ)
    {
      AppMethodBeat.o(42600);
      return;
    }
    this.IYJ = paramInt;
    setup();
    AppMethodBeat.o(42600);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(42606);
    if (paramColorFilter == this.kx)
    {
      AppMethodBeat.o(42606);
      return;
    }
    this.kx = paramColorFilter;
    this.IYI.setColorFilter(this.kx);
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
    this.mBitmap = P(paramDrawable);
    setup();
    AppMethodBeat.o(42603);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(42604);
    super.setImageResource(paramInt);
    this.mBitmap = P(getDrawable());
    setup();
    AppMethodBeat.o(42604);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(42605);
    super.setImageURI(paramUri);
    this.mBitmap = P(getDrawable());
    setup();
    AppMethodBeat.o(42605);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(42594);
    if (paramScaleType != IYF)
    {
      paramScaleType = new IllegalArgumentException(String.format("ScaleType %s not supported.", new Object[] { paramScaleType }));
      AppMethodBeat.o(42594);
      throw paramScaleType;
    }
    AppMethodBeat.o(42594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.widget.CircleImageView
 * JD-Core Version:    0.7.0.1
 */