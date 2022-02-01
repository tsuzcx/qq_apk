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
  public static final int gK = 0;
  private final a gL;
  private final Path gM;
  private final Paint gN;
  public final Paint gO;
  private c.d gP;
  public Drawable gQ;
  private boolean gR;
  private boolean gS;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      gK = 2;
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      gK = 1;
      return;
    }
  }
  
  public b(a parama)
  {
    this.gL = parama;
    this.view = ((View)parama);
    this.view.setWillNotDraw(false);
    this.gM = new Path();
    this.gN = new Paint(7);
    this.gO = new Paint(1);
    this.gO.setColor(0);
  }
  
  private float a(c.d paramd)
  {
    return k.c(paramd.centerX, paramd.centerY, this.view.getWidth(), this.view.getHeight());
  }
  
  private void aY()
  {
    if (gK == 1)
    {
      this.gM.rewind();
      if (this.gP != null) {
        this.gM.addCircle(this.gP.centerX, this.gP.centerY, this.gP.radius, Path.Direction.CW);
      }
    }
    this.view.invalidate();
  }
  
  private boolean aZ()
  {
    int i;
    if ((this.gP == null) || (this.gP.bc()))
    {
      i = 1;
      if (gK != 0) {
        break label45;
      }
      if ((i != 0) || (!this.gS)) {
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
  
  private void b(Canvas paramCanvas)
  {
    if (bb())
    {
      Rect localRect = this.gQ.getBounds();
      float f1 = this.gP.centerX - localRect.width() / 2.0F;
      float f2 = this.gP.centerY - localRect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.gQ.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private boolean ba()
  {
    return (!this.gR) && (Color.alpha(this.gO.getColor()) != 0);
  }
  
  private boolean bb()
  {
    return (!this.gR) && (this.gQ != null) && (this.gP != null);
  }
  
  public final void aV()
  {
    if (gK == 0)
    {
      this.gR = true;
      this.gS = false;
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
        localObject2 = this.gN;
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        ((Paint)localObject2).setShader(new BitmapShader((Bitmap)localObject1, localTileMode, localTileMode));
      }
      this.gR = false;
      this.gS = true;
    }
  }
  
  public final void aW()
  {
    if (gK == 0)
    {
      this.gS = false;
      this.view.destroyDrawingCache();
      this.gN.setShader(null);
      this.view.invalidate();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (aZ()) {
      switch (gK)
      {
      default: 
        throw new IllegalStateException("Unsupported strategy " + gK);
      case 2: 
        this.gL.a(paramCanvas);
        if (ba()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.gO);
        }
        break;
      }
    }
    for (;;)
    {
      b(paramCanvas);
      return;
      int i = paramCanvas.save();
      paramCanvas.clipPath(this.gM);
      this.gL.a(paramCanvas);
      if (ba()) {
        paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.gO);
      }
      paramCanvas.restoreToCount(i);
      continue;
      paramCanvas.drawCircle(this.gP.centerX, this.gP.centerY, this.gP.radius, this.gN);
      if (ba())
      {
        paramCanvas.drawCircle(this.gP.centerX, this.gP.centerY, this.gP.radius, this.gO);
        continue;
        this.gL.a(paramCanvas);
        if (ba()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.gO);
        }
      }
    }
  }
  
  public final c.d getRevealInfo()
  {
    Object localObject;
    if (this.gP == null) {
      localObject = null;
    }
    c.d locald;
    do
    {
      return localObject;
      locald = new c.d(this.gP);
      localObject = locald;
    } while (!locald.bc());
    locald.radius = a(locald);
    return locald;
  }
  
  public final boolean isOpaque()
  {
    return (this.gL.aX()) && (!aZ());
  }
  
  public final void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.gQ = paramDrawable;
    this.view.invalidate();
  }
  
  public final void setCircularRevealScrimColor(int paramInt)
  {
    this.gO.setColor(paramInt);
    this.view.invalidate();
  }
  
  public final void setRevealInfo(c.d paramd)
  {
    if (paramd == null) {
      this.gP = null;
    }
    label70:
    for (;;)
    {
      aY();
      return;
      if (this.gP == null) {
        this.gP = new c.d(paramd);
      }
      for (;;)
      {
        if (!k.e(paramd.radius, a(paramd))) {
          break label70;
        }
        this.gP.radius = 3.4028235E+38F;
        break;
        this.gP.b(paramd);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Canvas paramCanvas);
    
    public abstract boolean aX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.design.circularreveal.b
 * JD-Core Version:    0.7.0.1
 */