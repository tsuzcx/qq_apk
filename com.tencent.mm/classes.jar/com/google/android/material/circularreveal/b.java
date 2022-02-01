package com.google.android.material.circularreveal;

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
import android.view.View;
import com.google.android.material.d.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
{
  public static final int bzW = 0;
  public final Paint bAa;
  private c.d bAb;
  public Drawable bAc;
  private boolean bAd;
  private boolean bAe;
  private final a bzX;
  private final Path bzY;
  private final Paint bzZ;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      bzW = 2;
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      bzW = 1;
      return;
    }
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(236610);
    this.bzX = parama;
    this.view = ((View)parama);
    this.view.setWillNotDraw(false);
    this.bzY = new Path();
    this.bzZ = new Paint(7);
    this.bAa = new Paint(1);
    this.bAa.setColor(0);
    AppMethodBeat.o(236610);
  }
  
  private float a(c.d paramd)
  {
    AppMethodBeat.i(236623);
    float f = a.i(paramd.aGt, paramd.aGu, this.view.getWidth(), this.view.getHeight());
    AppMethodBeat.o(236623);
    return f;
  }
  
  private void c(Canvas paramCanvas)
  {
    AppMethodBeat.i(236626);
    if (wS())
    {
      Rect localRect = this.bAc.getBounds();
      float f1 = this.bAb.aGt - localRect.width() / 2.0F;
      float f2 = this.bAb.aGu - localRect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.bAc.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
    AppMethodBeat.o(236626);
  }
  
  private void wP()
  {
    AppMethodBeat.i(236622);
    if (bzW == 1)
    {
      this.bzY.rewind();
      if (this.bAb != null) {
        this.bzY.addCircle(this.bAb.aGt, this.bAb.aGu, this.bAb.radius, Path.Direction.CW);
      }
    }
    this.view.invalidate();
    AppMethodBeat.o(236622);
  }
  
  private boolean wQ()
  {
    AppMethodBeat.i(236628);
    int i;
    if ((this.bAb == null) || (this.bAb.isInvalid())) {
      i = 1;
    }
    while (bzW == 0) {
      if ((i == 0) && (this.bAe))
      {
        AppMethodBeat.o(236628);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(236628);
        return false;
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(236628);
      return true;
    }
    AppMethodBeat.o(236628);
    return false;
  }
  
  private boolean wR()
  {
    AppMethodBeat.i(236631);
    if ((!this.bAd) && (Color.alpha(this.bAa.getColor()) != 0))
    {
      AppMethodBeat.o(236631);
      return true;
    }
    AppMethodBeat.o(236631);
    return false;
  }
  
  private boolean wS()
  {
    return (!this.bAd) && (this.bAc != null) && (this.bAb != null);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(236624);
    if (wQ()) {
      switch (bzW)
      {
      default: 
        paramCanvas = new IllegalStateException("Unsupported strategy " + bzW);
        AppMethodBeat.o(236624);
        throw paramCanvas;
      case 2: 
        this.bzX.b(paramCanvas);
        if (wR()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.bAa);
        }
        break;
      }
    }
    for (;;)
    {
      c(paramCanvas);
      AppMethodBeat.o(236624);
      return;
      int i = paramCanvas.save();
      paramCanvas.clipPath(this.bzY);
      this.bzX.b(paramCanvas);
      if (wR()) {
        paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.bAa);
      }
      paramCanvas.restoreToCount(i);
      continue;
      paramCanvas.drawCircle(this.bAb.aGt, this.bAb.aGu, this.bAb.radius, this.bzZ);
      if (wR())
      {
        paramCanvas.drawCircle(this.bAb.aGt, this.bAb.aGu, this.bAb.radius, this.bAa);
        continue;
        this.bzX.b(paramCanvas);
        if (wR()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.bAa);
        }
      }
    }
  }
  
  public final c.d getRevealInfo()
  {
    AppMethodBeat.i(236617);
    if (this.bAb == null)
    {
      AppMethodBeat.o(236617);
      return null;
    }
    c.d locald = new c.d(this.bAb);
    if (locald.isInvalid()) {
      locald.radius = a(locald);
    }
    AppMethodBeat.o(236617);
    return locald;
  }
  
  public final boolean isOpaque()
  {
    AppMethodBeat.i(236627);
    if ((this.bzX.wO()) && (!wQ()))
    {
      AppMethodBeat.o(236627);
      return true;
    }
    AppMethodBeat.o(236627);
    return false;
  }
  
  public final void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(236621);
    this.bAc = paramDrawable;
    this.view.invalidate();
    AppMethodBeat.o(236621);
  }
  
  public final void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(236618);
    this.bAa.setColor(paramInt);
    this.view.invalidate();
    AppMethodBeat.o(236618);
  }
  
  public final void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(236615);
    if (paramd == null) {
      this.bAb = null;
    }
    label79:
    for (;;)
    {
      wP();
      AppMethodBeat.o(236615);
      return;
      if (this.bAb == null) {
        this.bAb = new c.d(paramd);
      }
      for (;;)
      {
        if (!a.s(paramd.radius, a(paramd))) {
          break label79;
        }
        this.bAb.radius = 3.4028235E+38F;
        break;
        this.bAb.b(paramd);
      }
    }
  }
  
  public final void wM()
  {
    AppMethodBeat.i(236611);
    if (bzW == 0)
    {
      this.bAd = true;
      this.bAe = false;
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
        localObject2 = this.bzZ;
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        ((Paint)localObject2).setShader(new BitmapShader((Bitmap)localObject1, localTileMode, localTileMode));
      }
      this.bAd = false;
      this.bAe = true;
    }
    AppMethodBeat.o(236611);
  }
  
  public final void wN()
  {
    AppMethodBeat.i(236613);
    if (bzW == 0)
    {
      this.bAe = false;
      this.view.destroyDrawingCache();
      this.bzZ.setShader(null);
      this.view.invalidate();
    }
    AppMethodBeat.o(236613);
  }
  
  public static abstract interface a
  {
    public abstract void b(Canvas paramCanvas);
    
    public abstract boolean wO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.material.circularreveal.b
 * JD-Core Version:    0.7.0.1
 */