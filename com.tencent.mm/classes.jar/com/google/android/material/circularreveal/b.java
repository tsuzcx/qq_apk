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
  public static final int dsX = 0;
  private final a dsY;
  private final Path dsZ;
  private final Paint dta;
  public final Paint dtb;
  private c.d dtc;
  public Drawable dtd;
  private boolean dte;
  private boolean dtf;
  private final View view;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      dsX = 2;
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      dsX = 1;
      return;
    }
  }
  
  public b(a parama)
  {
    AppMethodBeat.i(209085);
    this.dsY = parama;
    this.view = ((View)parama);
    this.view.setWillNotDraw(false);
    this.dsZ = new Path();
    this.dta = new Paint(7);
    this.dtb = new Paint(1);
    this.dtb.setColor(0);
    AppMethodBeat.o(209085);
  }
  
  private void Wo()
  {
    AppMethodBeat.i(209103);
    if (dsX == 1)
    {
      this.dsZ.rewind();
      if (this.dtc != null) {
        this.dsZ.addCircle(this.dtc.centerX, this.dtc.centerY, this.dtc.radius, Path.Direction.CW);
      }
    }
    this.view.invalidate();
    AppMethodBeat.o(209103);
  }
  
  private boolean Wp()
  {
    AppMethodBeat.i(209138);
    int i;
    if ((this.dtc == null) || (this.dtc.isInvalid())) {
      i = 1;
    }
    while (dsX == 0) {
      if ((i == 0) && (this.dtf))
      {
        AppMethodBeat.o(209138);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(209138);
        return false;
      }
    }
    if (i == 0)
    {
      AppMethodBeat.o(209138);
      return true;
    }
    AppMethodBeat.o(209138);
    return false;
  }
  
  private boolean Wq()
  {
    AppMethodBeat.i(209149);
    if ((!this.dte) && (Color.alpha(this.dtb.getColor()) != 0))
    {
      AppMethodBeat.o(209149);
      return true;
    }
    AppMethodBeat.o(209149);
    return false;
  }
  
  private boolean Wr()
  {
    return (!this.dte) && (this.dtd != null) && (this.dtc != null);
  }
  
  private float a(c.d paramd)
  {
    AppMethodBeat.i(209118);
    float f = a.l(paramd.centerX, paramd.centerY, this.view.getWidth(), this.view.getHeight());
    AppMethodBeat.o(209118);
    return f;
  }
  
  private void f(Canvas paramCanvas)
  {
    AppMethodBeat.i(209128);
    if (Wr())
    {
      Rect localRect = this.dtd.getBounds();
      float f1 = this.dtc.centerX - localRect.width() / 2.0F;
      float f2 = this.dtc.centerY - localRect.height() / 2.0F;
      paramCanvas.translate(f1, f2);
      this.dtd.draw(paramCanvas);
      paramCanvas.translate(-f1, -f2);
    }
    AppMethodBeat.o(209128);
  }
  
  public final void Wl()
  {
    AppMethodBeat.i(209178);
    if (dsX == 0)
    {
      this.dte = true;
      this.dtf = false;
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
        localObject2 = this.dta;
        Shader.TileMode localTileMode = Shader.TileMode.CLAMP;
        ((Paint)localObject2).setShader(new BitmapShader((Bitmap)localObject1, localTileMode, localTileMode));
      }
      this.dte = false;
      this.dtf = true;
    }
    AppMethodBeat.o(209178);
  }
  
  public final void Wm()
  {
    AppMethodBeat.i(209185);
    if (dsX == 0)
    {
      this.dtf = false;
      this.view.destroyDrawingCache();
      this.dta.setShader(null);
      this.view.invalidate();
    }
    AppMethodBeat.o(209185);
  }
  
  public final void draw(Canvas paramCanvas)
  {
    AppMethodBeat.i(209251);
    if (Wp()) {
      switch (dsX)
      {
      default: 
        paramCanvas = new IllegalStateException("Unsupported strategy " + dsX);
        AppMethodBeat.o(209251);
        throw paramCanvas;
      case 2: 
        this.dsY.e(paramCanvas);
        if (Wq()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.dtb);
        }
        break;
      }
    }
    for (;;)
    {
      f(paramCanvas);
      AppMethodBeat.o(209251);
      return;
      int i = paramCanvas.save();
      paramCanvas.clipPath(this.dsZ);
      this.dsY.e(paramCanvas);
      if (Wq()) {
        paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.dtb);
      }
      paramCanvas.restoreToCount(i);
      continue;
      paramCanvas.drawCircle(this.dtc.centerX, this.dtc.centerY, this.dtc.radius, this.dta);
      if (Wq())
      {
        paramCanvas.drawCircle(this.dtc.centerX, this.dtc.centerY, this.dtc.radius, this.dtb);
        continue;
        this.dsY.e(paramCanvas);
        if (Wq()) {
          paramCanvas.drawRect(0.0F, 0.0F, this.view.getWidth(), this.view.getHeight(), this.dtb);
        }
      }
    }
  }
  
  public final c.d getRevealInfo()
  {
    AppMethodBeat.i(209211);
    if (this.dtc == null)
    {
      AppMethodBeat.o(209211);
      return null;
    }
    c.d locald = new c.d(this.dtc);
    if (locald.isInvalid()) {
      locald.radius = a(locald);
    }
    AppMethodBeat.o(209211);
    return locald;
  }
  
  public final boolean isOpaque()
  {
    AppMethodBeat.i(209259);
    if ((this.dsY.Wn()) && (!Wp()))
    {
      AppMethodBeat.o(209259);
      return true;
    }
    AppMethodBeat.o(209259);
    return false;
  }
  
  public final void setCircularRevealOverlayDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(209239);
    this.dtd = paramDrawable;
    this.view.invalidate();
    AppMethodBeat.o(209239);
  }
  
  public final void setCircularRevealScrimColor(int paramInt)
  {
    AppMethodBeat.i(209225);
    this.dtb.setColor(paramInt);
    this.view.invalidate();
    AppMethodBeat.o(209225);
  }
  
  public final void setRevealInfo(c.d paramd)
  {
    AppMethodBeat.i(209197);
    if (paramd == null) {
      this.dtc = null;
    }
    label82:
    for (;;)
    {
      Wo();
      AppMethodBeat.o(209197);
      return;
      if (this.dtc == null) {
        this.dtc = new c.d(paramd);
      }
      for (;;)
      {
        if (!a.Y(paramd.radius, a(paramd))) {
          break label82;
        }
        this.dtc.radius = 3.4028235E+38F;
        break;
        this.dtc.b(paramd);
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract boolean Wn();
    
    public abstract void e(Canvas paramCanvas);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.google.android.material.circularreveal.b
 * JD-Core Version:    0.7.0.1
 */