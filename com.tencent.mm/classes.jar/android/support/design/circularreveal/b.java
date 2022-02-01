package android.support.design.circularreveal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.widget.k;
import android.view.View;

public final class b
{
  public static final int jG = 0;
  private final a jH;
  private final Path jI;
  private final Paint jJ;
  public final Paint jK;
  private c.d jL;
  public Drawable jM;
  private boolean jN;
  private boolean jO;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      jG = 2;
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      jG = 1;
      return;
    }
  }
  
  public b(a parama)
  {
    this.jH = parama;
    this.view = ((View)parama);
    this.view.setWillNotDraw(false);
    this.jI = new Path();
    this.jJ = new Paint(7);
    this.jK = new Paint(1);
    this.jK.setColor(0);
  }
  
  private float a(c.d paramd)
  {
    return k.c(paramd.centerX, paramd.centerY, this.view.getWidth(), this.view.getHeight());
  }
  
  private void b(Canvas paramCanvas)
  {
    if (bA())
    {
      Rect localRect = this.jM.getBounds();
      float f1 = this.jL.centerX - localRect.width() / 2.0F;
      float f2 = this.jL.centerY - localRect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.jM.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private boolean bA()
  {
    return (!this.jN) && (this.jM != null) && (this.jL != null);
  }
  
  private void bx()
  {
    if (jG == 1)
    {
      this.jI.rewind();
      if (this.jL != null) {
        this.jI.addCircle(this.jL.centerX, this.jL.centerY, this.jL.radius, Path.Direction.CW);
      }
    }
    this.view.invalidate();
  }
  
  private boolean by()
  {
    int i;
    if ((this.jL == null) || (this.jL.isInvalid()))
    {
      i = 1;
      if (jG != 0) {
        break label45;
      }
      if ((i != 0) || (!this.jO)) {
        break label43;
      }
    }
    label43:
    label45:
    while (i == 0)
    {
      return true;
      i = 0;
      break;
      return false;
    }
    return false;
  }
  
  private boolean bz()
  {
    return (!this.jN) && (Color.alpha(this.jK.getColor()) != 0);
  }
  
  public final void bu()
  {
    if (jG == 0)
    {
      this.jN = true;
      this.jO = false;
      this.view.buildDrawingCache();
      Object localObject2 = this.view.getDrawingCache();
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (this.view.getWidth() != 0)
        {
          localObject1 = localObject2;
          if (this.view.getHeight() != 0)
          {
            localObject1 = Bitmap.createBitmap(this.view.getWidth(), this.view.getHeight(), Bitmap.Config.ARGB_8888);
            localObject2 = new Canvas((Bitmap)localObject1);
            this.view.draw((Canvas)localObject2);
          }
        }
      }
      if (localObject1 != null)
      {
        localObject2 = this.jJ;
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        ((Paint)localObject2).setShader(new BitmapShader((Bitmap)localObject1, localTileMode, localTileMode));
      }
      this.jN = false;
      this.jO = true;
    }
  }
  
  public final void bv()
  {
    if (jG == 0)
    {
      this.jO = false;
      this.view.destroyDrawingCache();
      this.jJ.setShader(null);
      this.view.invalidate();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (by()) {
      switch (jG)
      {
      default: 
        throw new IllegalStateException("Unsupported strategy " + jG);
      case 2: 
        this.jH.a(paramCanvas);
        if (bz()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.jK);
        }
        break;
      }
    }
    for (;;)
    {
      b(paramCanvas);
      return;
      int i = paramCanvas.save();
      paramCanvas.clipPath(this.jI);
      this.jH.a(paramCanvas);
      if (bz()) {
        paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.jK);
      }
      paramCanvas.restoreToCount(i);
      continue;
      paramCanvas.drawCircle(this.jL.centerX, this.jL.centerY, this.jL.radius, this.jJ);
      if (bz())
      {
        paramCanvas.drawCircle(this.jL.centerX, this.jL.centerY, this.jL.radius, this.jK);
        continue;
        this.jH.a(paramCanvas);
        if (bz()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.jK);
        }
      }
    }
  }
  
  public final c.d getRevealInfo()
  {
    Object localObject;
    if (this.jL == null) {
      localObject = null;
    }
    c.d locald;
    do
    {
      return localObject;
      locald = new c.d(this.jL);
      localObject = locald;
    } while (!locald.isInvalid());
    locald.radius = a(locald);
    return locald;
  }
  
  public final boolean isOpaque()
  {
    return (this.jH.bw()) && (!by());
  }
  
  public final void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.jM = paramDrawable;
    this.view.invalidate();
  }
  
  public final void setCircularRevealScrimColor(int paramInt)
  {
    this.jK.setColor(paramInt);
    this.view.invalidate();
  }
  
  public final void setRevealInfo(c.d paramd)
  {
    if (paramd == null) {
      this.jL = null;
    }
    label70:
    for (;;)
    {
      bx();
      return;
      if (this.jL == null) {
        this.jL = new c.d(paramd);
      }
      for (;;)
      {
        if (!k.e(paramd.radius, a(paramd))) {
          break label70;
        }
        this.jL.radius = 3.4028235E+38F;
        break;
        this.jL.b(paramd);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Canvas paramCanvas);
    
    public abstract boolean bw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.circularreveal.b
 * JD-Core Version:    0.7.0.1
 */