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
  public static final int jE = 0;
  private final a jF;
  private final Path jG;
  private final Paint jH;
  public final Paint jI;
  private c.d jJ;
  public Drawable jK;
  private boolean jL;
  private boolean jM;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      jE = 2;
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      jE = 1;
      return;
    }
  }
  
  public b(a parama)
  {
    this.jF = parama;
    this.view = ((View)parama);
    this.view.setWillNotDraw(false);
    this.jG = new Path();
    this.jH = new Paint(7);
    this.jI = new Paint(1);
    this.jI.setColor(0);
  }
  
  private float a(c.d paramd)
  {
    return k.c(paramd.centerX, paramd.centerY, this.view.getWidth(), this.view.getHeight());
  }
  
  private void b(Canvas paramCanvas)
  {
    if (by())
    {
      Rect localRect = this.jK.getBounds();
      float f1 = this.jJ.centerX - localRect.width() / 2.0F;
      float f2 = this.jJ.centerY - localRect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.jK.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void bv()
  {
    if (jE == 1)
    {
      this.jG.rewind();
      if (this.jJ != null) {
        this.jG.addCircle(this.jJ.centerX, this.jJ.centerY, this.jJ.radius, Path.Direction.CW);
      }
    }
    this.view.invalidate();
  }
  
  private boolean bw()
  {
    int i;
    if ((this.jJ == null) || (this.jJ.isInvalid()))
    {
      i = 1;
      if (jE != 0) {
        break label45;
      }
      if ((i != 0) || (!this.jM)) {
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
  
  private boolean bx()
  {
    return (!this.jL) && (Color.alpha(this.jI.getColor()) != 0);
  }
  
  private boolean by()
  {
    return (!this.jL) && (this.jK != null) && (this.jJ != null);
  }
  
  public final void bs()
  {
    if (jE == 0)
    {
      this.jL = true;
      this.jM = false;
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
        localObject2 = this.jH;
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        ((Paint)localObject2).setShader(new BitmapShader((Bitmap)localObject1, localTileMode, localTileMode));
      }
      this.jL = false;
      this.jM = true;
    }
  }
  
  public final void bt()
  {
    if (jE == 0)
    {
      this.jM = false;
      this.view.destroyDrawingCache();
      this.jH.setShader(null);
      this.view.invalidate();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (bw()) {
      switch (jE)
      {
      default: 
        throw new IllegalStateException("Unsupported strategy " + jE);
      case 2: 
        this.jF.a(paramCanvas);
        if (bx()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.jI);
        }
        break;
      }
    }
    for (;;)
    {
      b(paramCanvas);
      return;
      int i = paramCanvas.save();
      paramCanvas.clipPath(this.jG);
      this.jF.a(paramCanvas);
      if (bx()) {
        paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.jI);
      }
      paramCanvas.restoreToCount(i);
      continue;
      paramCanvas.drawCircle(this.jJ.centerX, this.jJ.centerY, this.jJ.radius, this.jH);
      if (bx())
      {
        paramCanvas.drawCircle(this.jJ.centerX, this.jJ.centerY, this.jJ.radius, this.jI);
        continue;
        this.jF.a(paramCanvas);
        if (bx()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.jI);
        }
      }
    }
  }
  
  public final c.d getRevealInfo()
  {
    Object localObject;
    if (this.jJ == null) {
      localObject = null;
    }
    c.d locald;
    do
    {
      return localObject;
      locald = new c.d(this.jJ);
      localObject = locald;
    } while (!locald.isInvalid());
    locald.radius = a(locald);
    return locald;
  }
  
  public final boolean isOpaque()
  {
    return (this.jF.bu()) && (!bw());
  }
  
  public final void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.jK = paramDrawable;
    this.view.invalidate();
  }
  
  public final void setCircularRevealScrimColor(int paramInt)
  {
    this.jI.setColor(paramInt);
    this.view.invalidate();
  }
  
  public final void setRevealInfo(c.d paramd)
  {
    if (paramd == null) {
      this.jJ = null;
    }
    label70:
    for (;;)
    {
      bv();
      return;
      if (this.jJ == null) {
        this.jJ = new c.d(paramd);
      }
      for (;;)
      {
        if (!k.e(paramd.radius, a(paramd))) {
          break label70;
        }
        this.jJ.radius = 3.4028235E+38F;
        break;
        this.jJ.b(paramd);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Canvas paramCanvas);
    
    public abstract boolean bu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.circularreveal.b
 * JD-Core Version:    0.7.0.1
 */