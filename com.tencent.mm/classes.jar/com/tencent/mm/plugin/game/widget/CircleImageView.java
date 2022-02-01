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
  private static final Bitmap.Config gDV = Bitmap.Config.ARGB_8888;
  private static final ImageView.ScaleType soR = ImageView.ScaleType.CENTER_CROP;
  private int HC;
  private int HD;
  private BitmapShader Hv;
  private final Matrix Hw;
  private float jPi;
  private int jPk;
  private final Paint jPl;
  private Bitmap mBitmap;
  private final RectF soS;
  private final RectF soT;
  private final Paint soU;
  private int soV;
  private float soW;
  private boolean soX;
  private boolean soY;
  private boolean soZ;
  private ColorFilter up;
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42593);
    this.soS = new RectF();
    this.soT = new RectF();
    this.Hw = new Matrix();
    this.soU = new Paint();
    this.jPl = new Paint();
    this.jPk = -16777216;
    this.soV = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, f.a.CircleImageView, paramInt, 0);
    this.soV = paramContext.getDimensionPixelSize(2, 0);
    this.jPk = paramContext.getColor(0, -16777216);
    this.soZ = paramContext.getBoolean(1, false);
    paramContext.recycle();
    super.setScaleType(soR);
    this.soX = true;
    if (this.soY)
    {
      setup();
      this.soY = false;
    }
    AppMethodBeat.o(42593);
  }
  
  private void cEF()
  {
    AppMethodBeat.i(42609);
    this.Hw.set(null);
    float f1;
    float f3;
    float f2;
    if (this.HC * this.soS.height() > this.soS.width() * this.HD)
    {
      f1 = this.soS.height() / this.HD;
      f3 = (this.soS.width() - this.HC * f1) * 0.5F;
      f2 = 0.0F;
    }
    for (;;)
    {
      this.Hw.setScale(f1, f1);
      this.Hw.postTranslate((int)(f3 + 0.5F) + this.soS.left, (int)(f2 + 0.5F) + this.soS.top);
      this.Hv.setLocalMatrix(this.Hw);
      AppMethodBeat.o(42609);
      return;
      f1 = this.soS.width() / this.HC;
      f2 = (this.soS.height() - this.HD * f1) * 0.5F;
      f3 = 0.0F;
    }
  }
  
  private void setup()
  {
    AppMethodBeat.i(42608);
    if (!this.soX)
    {
      this.soY = true;
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
    this.Hv = new BitmapShader(localBitmap, localTileMode, localTileMode);
    this.soU.setAntiAlias(true);
    this.soU.setShader(this.Hv);
    this.jPl.setStyle(Paint.Style.STROKE);
    this.jPl.setAntiAlias(true);
    this.jPl.setColor(this.jPk);
    this.jPl.setStrokeWidth(this.soV);
    this.HD = this.mBitmap.getHeight();
    this.HC = this.mBitmap.getWidth();
    this.soT.set(0.0F, 0.0F, getWidth(), getHeight());
    this.jPi = Math.min((this.soT.height() - this.soV) / 2.0F, (this.soT.width() - this.soV) / 2.0F);
    this.soS.set(this.soT);
    if (!this.soZ) {
      this.soS.inset(this.soV, this.soV);
    }
    this.soW = Math.min(this.soS.height() / 2.0F, this.soS.width() / 2.0F);
    cEF();
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
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, gDV);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), gDV))
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
    return this.jPk;
  }
  
  public int getBorderWidth()
  {
    return this.soV;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return soR;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42596);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(42596);
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.soW, this.soU);
    if (this.soV != 0) {
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.jPi, this.jPl);
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
    if (paramInt == this.jPk)
    {
      AppMethodBeat.o(42598);
      return;
    }
    this.jPk = paramInt;
    this.jPl.setColor(this.jPk);
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
    if (paramBoolean == this.soZ)
    {
      AppMethodBeat.o(42601);
      return;
    }
    this.soZ = paramBoolean;
    setup();
    AppMethodBeat.o(42601);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(42600);
    if (paramInt == this.soV)
    {
      AppMethodBeat.o(42600);
      return;
    }
    this.soV = paramInt;
    setup();
    AppMethodBeat.o(42600);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(42606);
    if (paramColorFilter == this.up)
    {
      AppMethodBeat.o(42606);
      return;
    }
    this.up = paramColorFilter;
    this.soU.setColorFilter(this.up);
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
    if (paramScaleType != soR)
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