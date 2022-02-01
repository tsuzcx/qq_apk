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
  public static final int hJ = 0;
  private final a hK;
  private final Path hL;
  private final Paint hM;
  public final Paint hN;
  private c.d hO;
  public Drawable hP;
  private boolean hQ;
  private boolean hR;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      hJ = 2;
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      hJ = 1;
      return;
    }
  }
  
  public b(a parama)
  {
    this.hK = parama;
    this.view = ((View)parama);
    this.view.setWillNotDraw(false);
    this.hL = new Path();
    this.hM = new Paint(7);
    this.hN = new Paint(1);
    this.hN.setColor(0);
  }
  
  private float a(c.d paramd)
  {
    return k.c(paramd.centerX, paramd.centerY, this.view.getWidth(), this.view.getHeight());
  }
  
  private void b(Canvas paramCanvas)
  {
    if (bi())
    {
      Rect localRect = this.hP.getBounds();
      float f1 = this.hO.centerX - localRect.width() / 2.0F;
      float f2 = this.hO.centerY - localRect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.hP.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
  }
  
  private void bf()
  {
    if (hJ == 1)
    {
      this.hL.rewind();
      if (this.hO != null) {
        this.hL.addCircle(this.hO.centerX, this.hO.centerY, this.hO.radius, Path.Direction.CW);
      }
    }
    this.view.invalidate();
  }
  
  private boolean bg()
  {
    int i;
    if ((this.hO == null) || (this.hO.bj()))
    {
      i = 1;
      if (hJ != 0) {
        break label45;
      }
      if ((i != 0) || (!this.hR)) {
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
  
  private boolean bh()
  {
    return (!this.hQ) && (Color.alpha(this.hN.getColor()) != 0);
  }
  
  private boolean bi()
  {
    return (!this.hQ) && (this.hP != null) && (this.hO != null);
  }
  
  public final void bc()
  {
    if (hJ == 0)
    {
      this.hQ = true;
      this.hR = false;
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
        localObject2 = this.hM;
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        ((Paint)localObject2).setShader(new BitmapShader((Bitmap)localObject1, localTileMode, localTileMode));
      }
      this.hQ = false;
      this.hR = true;
    }
  }
  
  public final void bd()
  {
    if (hJ == 0)
    {
      this.hR = false;
      this.view.destroyDrawingCache();
      this.hM.setShader(null);
      this.view.invalidate();
    }
  }
  
  public final void draw(Canvas paramCanvas)
  {
    if (bg()) {
      switch (hJ)
      {
      default: 
        throw new IllegalStateException("Unsupported strategy " + hJ);
      case 2: 
        this.hK.a(paramCanvas);
        if (bh()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.hN);
        }
        break;
      }
    }
    for (;;)
    {
      b(paramCanvas);
      return;
      int i = paramCanvas.save();
      paramCanvas.clipPath(this.hL);
      this.hK.a(paramCanvas);
      if (bh()) {
        paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.hN);
      }
      paramCanvas.restoreToCount(i);
      continue;
      paramCanvas.drawCircle(this.hO.centerX, this.hO.centerY, this.hO.radius, this.hM);
      if (bh())
      {
        paramCanvas.drawCircle(this.hO.centerX, this.hO.centerY, this.hO.radius, this.hN);
        continue;
        this.hK.a(paramCanvas);
        if (bh()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.hN);
        }
      }
    }
  }
  
  public final c.d getRevealInfo()
  {
    Object localObject;
    if (this.hO == null) {
      localObject = null;
    }
    c.d locald;
    do
    {
      return localObject;
      locald = new c.d(this.hO);
      localObject = locald;
    } while (!locald.bj());
    locald.radius = a(locald);
    return locald;
  }
  
  public final boolean isOpaque()
  {
    return (this.hK.be()) && (!bg());
  }
  
  public final void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    this.hP = paramDrawable;
    this.view.invalidate();
  }
  
  public final void setCircularRevealScrimColor(int paramInt)
  {
    this.hN.setColor(paramInt);
    this.view.invalidate();
  }
  
  public final void setRevealInfo(c.d paramd)
  {
    if (paramd == null) {
      this.hO = null;
    }
    label70:
    for (;;)
    {
      bf();
      return;
      if (this.hO == null) {
        this.hO = new c.d(paramd);
      }
      for (;;)
      {
        if (!k.e(paramd.radius, a(paramd))) {
          break label70;
        }
        this.hO.radius = 3.4028235E+38F;
        break;
        this.hO.b(paramd);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Canvas paramCanvas);
    
    public abstract boolean be();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     android.support.design.circularreveal.b
 * JD-Core Version:    0.7.0.1
 */