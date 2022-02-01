package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cache.c;
import com.tencent.mm.cache.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.z.e;
import com.tencent.mm.z.e.a;
import com.tencent.mm.z.e.b;
import java.util.LinkedList;

public final class h
  extends b<i>
{
  private float ayd;
  private float aye;
  private boolean dsX;
  private boolean dsY;
  private float dsy;
  private float dsz;
  private Bitmap dtw;
  private LinkedList<e.b> dtx;
  public e.a dty;
  private Path xT;
  
  public h()
  {
    AppMethodBeat.i(9168);
    this.dsX = true;
    this.dsY = false;
    this.xT = new Path();
    this.dtx = new LinkedList();
    this.dty = e.a.hoC;
    AppMethodBeat.o(9168);
  }
  
  public final a XS()
  {
    return a.drM;
  }
  
  public final void XT()
  {
    AppMethodBeat.i(9174);
    if ((XY() != null) && (!XY().isRecycled())) {
      XY().recycle();
    }
    t(((i)super.XU()).alK());
    AppMethodBeat.o(9174);
  }
  
  public final void cT(boolean paramBoolean)
  {
    AppMethodBeat.i(9173);
    super.cT(paramBoolean);
    ((i)super.XU()).u(XY());
    AppMethodBeat.o(9173);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9169);
    super.onAlive();
    if ((i)super.XU() != null) {
      t(((i)super.XU()).alK());
    }
    Bitmap localBitmap2 = this.drS.gtm();
    if (localBitmap2 == null)
    {
      Log.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
      localBitmap1 = null;
      this.dtw = localBitmap1;
      AppMethodBeat.o(9169);
      return;
    }
    int n = localBitmap2.getWidth();
    int i1 = localBitmap2.getHeight();
    int i3 = com.tencent.mm.cl.a.ao(6.0F);
    Bitmap localBitmap1 = Bitmap.createBitmap(n, i1, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap1);
    int i4 = (int)Math.ceil(n / i3);
    int i5 = (int)Math.ceil(i1 / i3);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    int i = 0;
    label162:
    int j;
    label170:
    int i6;
    int i7;
    int k;
    if (i < i4)
    {
      j = 0;
      if (j < i5)
      {
        i6 = i3 * i;
        i7 = i3 * j;
        k = i6 + i3;
        if (k <= n) {
          break label285;
        }
        k = n;
      }
    }
    label285:
    for (;;)
    {
      int i2 = i7 + i3;
      int m = i2;
      if (i2 > i1) {
        m = i1;
      }
      i2 = localBitmap2.getPixel(i6, i7);
      Rect localRect = new Rect(i6, i7, k, m);
      localPaint.setColor(i2);
      localCanvas.drawRect(localRect, localPaint);
      j += 1;
      break label170;
      i += 1;
      break label162;
      break;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9170);
    super.onDestroy();
    if ((this.dtw != null) && (!this.dtw.isRecycled())) {
      this.dtw.recycle();
    }
    AppMethodBeat.o(9170);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9171);
    paramCanvas.save();
    paramCanvas.clipRect(this.drU);
    if (this.dty == e.a.hoC)
    {
      d(paramCanvas);
      new e(this.dty, this.xT, 1.0F / getScale(), this.dtw).draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(9171);
      return;
      if (this.dty == e.a.hoD)
      {
        new e(this.dty, new LinkedList(this.dtx), 1.0F / getScale()).draw(new Canvas(XY()));
        d(paramCanvas);
      }
    }
  }
  
  public final boolean q(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(9172);
    if (!XZ())
    {
      AppMethodBeat.o(9172);
      return false;
    }
    if (this.dsb != null) {
      this.dsb.q(paramMotionEvent);
    }
    Object localObject = v(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.dsX;
      AppMethodBeat.o(9172);
      return bool;
      float f1;
      if (this.drU.contains((int)localObject[0], (int)localObject[1]))
      {
        f1 = localObject[0];
        this.dsy = f1;
        this.ayd = f1;
        f1 = localObject[1];
        this.dsz = f1;
        this.aye = f1;
      }
      for (this.dsX = true;; this.dsX = false)
      {
        this.dsY = false;
        break;
      }
      if ((this.dsX) && (this.dsY))
      {
        if ((i)super.XU() == null)
        {
          Log.e("MicroMsg.MosaicArtist", "getCache is null???");
          AppMethodBeat.o(9172);
          return true;
        }
        if (this.dty != e.a.hoC) {
          break label329;
        }
        ((i)super.XU()).a(new e(this.dty, new Path(this.xT), 1.0F / getScale(), this.dtw));
        cT(false);
      }
      for (;;)
      {
        c.alF().b(com.tencent.mm.api.h.diK);
        Yc();
        this.dtx.clear();
        this.xT.reset();
        this.dsY = false;
        this.dsX = false;
        break;
        label329:
        if (this.dty == e.a.hoD)
        {
          ((i)super.XU()).a(new e(this.dty, new LinkedList(this.dtx), 1.0F / getScale()));
          cT(false);
        }
      }
      if ((this.dsX) && (this.dsY))
      {
        this.dsy = this.ayd;
        this.dsz = this.aye;
        this.ayd = localObject[0];
        this.aye = localObject[1];
        if (this.dty == e.a.hoC) {
          this.xT.quadTo(this.dsy, this.dsz, (this.ayd + this.dsy) / 2.0F, (this.aye + this.dsz) / 2.0F);
        }
        while (this.dty != e.a.hoD)
        {
          Yb();
          break;
        }
        double d = Math.toDegrees(Math.atan((this.ayd - this.dsy) / (this.aye - this.dsz)));
        label538:
        float f2;
        float f3;
        float f4;
        if (getRotation() == 180.0F)
        {
          i = 180;
          f1 = (float)(i + d);
          paramMotionEvent = this.dtx;
          f2 = 1.0F / getScale();
          f3 = this.ayd;
          f4 = this.aye;
          localObject = this.drS.gtm();
          if ((localObject != null) && (f3 < ((Bitmap)localObject).getWidth()) && (f4 < ((Bitmap)localObject).getHeight()) && (f3 > 0.0F) && (f4 > 0.0F)) {
            break label696;
          }
          Log.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[] { Float.valueOf(f3), Float.valueOf(f4) });
        }
        label696:
        for (int i = j;; i = ((Bitmap)localObject).getPixel((int)f3, (int)f4))
        {
          paramMotionEvent.add(new e.b(f2, i, f1 % 360.0F, this.ayd, this.aye));
          break;
          i = 0;
          break label538;
        }
      }
      if ((this.dsX) && (!this.dsY))
      {
        if (this.dty == e.a.hoC) {
          this.xT.moveTo(localObject[0], localObject[1]);
        }
        this.dsY = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.h
 * JD-Core Version:    0.7.0.1
 */