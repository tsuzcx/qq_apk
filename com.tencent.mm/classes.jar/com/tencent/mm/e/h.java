package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.e.a;
import com.tencent.mm.ab.e.b;
import com.tencent.mm.cache.c;
import com.tencent.mm.cache.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
  extends b<i>
{
  private Path auD;
  private boolean flI;
  private boolean flJ;
  private float flk;
  private float fll;
  private Bitmap fme;
  private LinkedList<e.b> fmf;
  public e.a fmg;
  private float vX;
  private float vY;
  
  public h()
  {
    AppMethodBeat.i(9168);
    this.flI = true;
    this.flJ = false;
    this.auD = new Path();
    this.fmf = new LinkedList();
    this.fmg = e.a.kat;
    AppMethodBeat.o(9168);
  }
  
  public final a acy()
  {
    return a.fky;
  }
  
  public final void acz()
  {
    AppMethodBeat.i(9174);
    if ((acE() != null) && (!acE().isRecycled())) {
      acE().recycle();
    }
    o(((i)super.acA()).arJ());
    AppMethodBeat.o(9174);
  }
  
  public final void dq(boolean paramBoolean)
  {
    AppMethodBeat.i(9173);
    super.dq(paramBoolean);
    ((i)super.acA()).p(acE());
    AppMethodBeat.o(9173);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9169);
    super.onAlive();
    if ((i)super.acA() != null) {
      o(((i)super.acA()).arJ());
    }
    Bitmap localBitmap2 = this.fkE.hoy();
    if (localBitmap2 == null)
    {
      Log.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
      localBitmap1 = null;
      this.fme = localBitmap1;
      AppMethodBeat.o(9169);
      return;
    }
    int n = localBitmap2.getWidth();
    int i1 = localBitmap2.getHeight();
    int i3 = com.tencent.mm.cs.a.an(6.0F);
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
    if ((this.fme != null) && (!this.fme.isRecycled())) {
      this.fme.recycle();
    }
    AppMethodBeat.o(9170);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9171);
    paramCanvas.save();
    paramCanvas.clipRect(getAliveRect());
    if (this.fmg == e.a.kat)
    {
      e(paramCanvas);
      new e(this.fmg, this.auD, 1.0F / getScale(), this.fme).draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(9171);
      return;
      if (this.fmg == e.a.kau)
      {
        new e(this.fmg, new LinkedList(this.fmf), 1.0F / getScale()).draw(new Canvas(acE()));
        e(paramCanvas);
      }
    }
  }
  
  public final boolean q(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(9172);
    if (!acF())
    {
      AppMethodBeat.o(9172);
      return false;
    }
    if (this.fkO != null) {
      this.fkO.q(paramMotionEvent);
    }
    Object localObject = x(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.flI;
      AppMethodBeat.o(9172);
      return bool;
      float f1;
      if (getAliveRect().contains((int)localObject[0], (int)localObject[1]))
      {
        f1 = localObject[0];
        this.flk = f1;
        this.vX = f1;
        f1 = localObject[1];
        this.fll = f1;
        this.vY = f1;
      }
      for (this.flI = true;; this.flI = false)
      {
        this.flJ = false;
        break;
      }
      if ((this.flI) && (this.flJ))
      {
        if ((i)super.acA() == null)
        {
          Log.e("MicroMsg.MosaicArtist", "getCache is null???");
          AppMethodBeat.o(9172);
          return true;
        }
        if (this.fmg != e.a.kat) {
          break label329;
        }
        ((i)super.acA()).a(new e(this.fmg, new Path(this.auD), 1.0F / getScale(), this.fme));
        dq(false);
      }
      for (;;)
      {
        c.arE().b(com.tencent.mm.api.h.faq);
        acI();
        this.fmf.clear();
        this.auD.reset();
        this.flJ = false;
        this.flI = false;
        break;
        label329:
        if (this.fmg == e.a.kau)
        {
          ((i)super.acA()).a(new e(this.fmg, new LinkedList(this.fmf), 1.0F / getScale()));
          dq(false);
        }
      }
      if ((this.flI) && (this.flJ))
      {
        this.flk = this.vX;
        this.fll = this.vY;
        this.vX = localObject[0];
        this.vY = localObject[1];
        if (this.fmg == e.a.kat) {
          this.auD.quadTo(this.flk, this.fll, (this.vX + this.flk) / 2.0F, (this.vY + this.fll) / 2.0F);
        }
        while (this.fmg != e.a.kau)
        {
          acH();
          break;
        }
        double d = Math.toDegrees(Math.atan((this.vX - this.flk) / (this.vY - this.fll)));
        label538:
        float f2;
        float f3;
        float f4;
        if (getRotation() == 180.0F)
        {
          i = 180;
          f1 = (float)(i + d);
          paramMotionEvent = this.fmf;
          f2 = 1.0F / getScale();
          f3 = this.vX;
          f4 = this.vY;
          localObject = this.fkE.hoy();
          if ((localObject != null) && (f3 < ((Bitmap)localObject).getWidth()) && (f4 < ((Bitmap)localObject).getHeight()) && (f3 > 0.0F) && (f4 > 0.0F)) {
            break label696;
          }
          Log.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[] { Float.valueOf(f3), Float.valueOf(f4) });
        }
        label696:
        for (int i = j;; i = ((Bitmap)localObject).getPixel((int)f3, (int)f4))
        {
          paramMotionEvent.add(new e.b(f2, i, f1 % 360.0F, this.vX, this.vY));
          break;
          i = 0;
          break label538;
        }
      }
      if ((this.flI) && (!this.flJ))
      {
        if (this.fmg == e.a.kat) {
          this.auD.moveTo(localObject[0], localObject[1]);
        }
        this.flJ = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.h
 * JD-Core Version:    0.7.0.1
 */