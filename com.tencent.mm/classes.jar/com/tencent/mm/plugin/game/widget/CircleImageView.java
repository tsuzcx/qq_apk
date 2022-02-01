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
import androidx.annotation.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.k;

public class CircleImageView
  extends ImageView
{
  private static final ImageView.ScaleType Deo = ImageView.ScaleType.CENTER_CROP;
  private static final Bitmap.Config liJ = Bitmap.Config.ARGB_8888;
  private final RectF Dep;
  private final RectF Deq;
  private final Paint Der;
  private int Des;
  private float Det;
  private boolean Deu;
  private boolean Dev;
  private boolean Dew;
  private BitmapShader KT;
  private final Matrix KU;
  private ColorFilter jC;
  private Bitmap mBitmap;
  private int mBitmapHeight;
  private int mBitmapWidth;
  private float oPA;
  private int oPC;
  private final Paint oPD;
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public CircleImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(42593);
    this.Dep = new RectF();
    this.Deq = new RectF();
    this.KU = new Matrix();
    this.Der = new Paint();
    this.oPD = new Paint();
    this.oPC = -16777216;
    this.Des = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, g.k.eWA, paramInt, 0);
    this.Des = paramContext.getDimensionPixelSize(g.k.Cql, 0);
    this.oPC = paramContext.getColor(g.k.Cqj, -16777216);
    this.Dew = paramContext.getBoolean(g.k.Cqk, false);
    paramContext.recycle();
    super.setScaleType(Deo);
    this.Deu = true;
    if (this.Dev)
    {
      setup();
      this.Dev = false;
    }
    AppMethodBeat.o(42593);
  }
  
  private static Bitmap F(Drawable paramDrawable)
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
      for (Bitmap localBitmap = Bitmap.createBitmap(2, 2, liJ);; localBitmap = Bitmap.createBitmap(paramDrawable.getIntrinsicWidth(), paramDrawable.getIntrinsicHeight(), liJ))
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
  
  private void eAe()
  {
    AppMethodBeat.i(42609);
    this.KU.set(null);
    float f1;
    float f3;
    float f2;
    if (this.mBitmapWidth * this.Dep.height() > this.Dep.width() * this.mBitmapHeight)
    {
      f1 = this.Dep.height() / this.mBitmapHeight;
      f3 = (this.Dep.width() - this.mBitmapWidth * f1) * 0.5F;
      f2 = 0.0F;
    }
    for (;;)
    {
      this.KU.setScale(f1, f1);
      this.KU.postTranslate((int)(f3 + 0.5F) + this.Dep.left, (int)(f2 + 0.5F) + this.Dep.top);
      this.KT.setLocalMatrix(this.KU);
      AppMethodBeat.o(42609);
      return;
      f1 = this.Dep.width() / this.mBitmapWidth;
      f2 = (this.Dep.height() - this.mBitmapHeight * f1) * 0.5F;
      f3 = 0.0F;
    }
  }
  
  private void setup()
  {
    AppMethodBeat.i(42608);
    if (!this.Deu)
    {
      this.Dev = true;
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
    this.KT = new BitmapShader(localBitmap, localTileMode, localTileMode);
    this.Der.setAntiAlias(true);
    this.Der.setShader(this.KT);
    this.oPD.setStyle(Paint.Style.STROKE);
    this.oPD.setAntiAlias(true);
    this.oPD.setColor(this.oPC);
    this.oPD.setStrokeWidth(this.Des);
    this.mBitmapHeight = this.mBitmap.getHeight();
    this.mBitmapWidth = this.mBitmap.getWidth();
    this.Deq.set(0.0F, 0.0F, getWidth(), getHeight());
    this.oPA = Math.min((this.Deq.height() - this.Des) / 2.0F, (this.Deq.width() - this.Des) / 2.0F);
    this.Dep.set(this.Deq);
    if (!this.Dew) {
      this.Dep.inset(this.Des, this.Des);
    }
    this.Det = Math.min(this.Dep.height() / 2.0F, this.Dep.width() / 2.0F);
    eAe();
    invalidate();
    AppMethodBeat.o(42608);
  }
  
  public int getBorderColor()
  {
    return this.oPC;
  }
  
  public int getBorderWidth()
  {
    return this.Des;
  }
  
  public ImageView.ScaleType getScaleType()
  {
    return Deo;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(42596);
    if (getDrawable() == null)
    {
      AppMethodBeat.o(42596);
      return;
    }
    paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.Det, this.Der);
    if (this.Des != 0) {
      paramCanvas.drawCircle(getWidth() / 2, getHeight() / 2, this.oPA, this.oPD);
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
    if (paramInt == this.oPC)
    {
      AppMethodBeat.o(42598);
      return;
    }
    this.oPC = paramInt;
    this.oPD.setColor(this.oPC);
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
    if (paramBoolean == this.Dew)
    {
      AppMethodBeat.o(42601);
      return;
    }
    this.Dew = paramBoolean;
    setup();
    AppMethodBeat.o(42601);
  }
  
  public void setBorderWidth(int paramInt)
  {
    AppMethodBeat.i(42600);
    if (paramInt == this.Des)
    {
      AppMethodBeat.o(42600);
      return;
    }
    this.Des = paramInt;
    setup();
    AppMethodBeat.o(42600);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    AppMethodBeat.i(42606);
    if (paramColorFilter == this.jC)
    {
      AppMethodBeat.o(42606);
      return;
    }
    this.jC = paramColorFilter;
    this.Der.setColorFilter(this.jC);
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
    this.mBitmap = F(paramDrawable);
    setup();
    AppMethodBeat.o(42603);
  }
  
  public void setImageResource(int paramInt)
  {
    AppMethodBeat.i(42604);
    super.setImageResource(paramInt);
    this.mBitmap = F(getDrawable());
    setup();
    AppMethodBeat.o(42604);
  }
  
  public void setImageURI(Uri paramUri)
  {
    AppMethodBeat.i(42605);
    super.setImageURI(paramUri);
    this.mBitmap = F(getDrawable());
    setup();
    AppMethodBeat.o(42605);
  }
  
  public void setScaleType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(42594);
    if (paramScaleType != Deo)
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