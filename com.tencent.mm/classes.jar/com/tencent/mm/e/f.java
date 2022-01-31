package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.e;
import com.tencent.mm.cache.c;
import com.tencent.mm.cache.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.util.LinkedList;

public final class f
  extends b<h>
{
  private float anT;
  private float anU;
  private boolean cdU;
  private boolean cdw;
  private float cdx;
  private float cdy;
  private Bitmap cei;
  private LinkedList<d.b> cej;
  public d.a cek;
  private Path ou;
  
  public f()
  {
    AppMethodBeat.i(116198);
    this.cdU = true;
    this.cdw = false;
    this.ou = new Path();
    this.cej = new LinkedList();
    this.cek = d.a.eFI;
    AppMethodBeat.o(116198);
  }
  
  public final void CA()
  {
    AppMethodBeat.i(116204);
    if ((CF() != null) && (!CF().isRecycled())) {
      CF().recycle();
    }
    l(((h)super.CB()).Jl());
    AppMethodBeat.o(116204);
  }
  
  public final a Cz()
  {
    return a.ccN;
  }
  
  public final void bt(boolean paramBoolean)
  {
    AppMethodBeat.i(116203);
    super.bt(paramBoolean);
    ((h)super.CB()).m(CF());
    AppMethodBeat.o(116203);
  }
  
  public final boolean o(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(116202);
    if (!CG())
    {
      AppMethodBeat.o(116202);
      return false;
    }
    if (this.cdb != null) {
      this.cdb.o(paramMotionEvent);
    }
    Object localObject = B(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.cdU;
      AppMethodBeat.o(116202);
      return bool;
      float f1;
      if (this.ccU.contains((int)localObject[0], (int)localObject[1]))
      {
        f1 = localObject[0];
        this.cdx = f1;
        this.anT = f1;
        f1 = localObject[1];
        this.cdy = f1;
        this.anU = f1;
      }
      for (this.cdU = true;; this.cdU = false)
      {
        this.cdw = false;
        break;
      }
      if ((this.cdU) && (this.cdw))
      {
        if (this.cek != d.a.eFI) {
          break label298;
        }
        ((h)super.CB()).a(new d(this.cek, new Path(this.ou), 1.0F / getScale(), this.cei));
        bt(false);
      }
      for (;;)
      {
        c.Jg().b(e.bVZ);
        CJ();
        this.cej.clear();
        this.ou.reset();
        this.cdw = false;
        this.cdU = false;
        break;
        label298:
        if (this.cek == d.a.eFJ)
        {
          ((h)super.CB()).a(new d(this.cek, new LinkedList(this.cej), 1.0F / getScale()));
          bt(false);
        }
      }
      if ((this.cdU) && (this.cdw))
      {
        this.cdx = this.anT;
        this.cdy = this.anU;
        this.anT = localObject[0];
        this.anU = localObject[1];
        if (this.cek == d.a.eFI) {
          this.ou.quadTo(this.cdx, this.cdy, (this.anT + this.cdx) / 2.0F, (this.anU + this.cdy) / 2.0F);
        }
        while (this.cek != d.a.eFJ)
        {
          CI();
          break;
        }
        double d = Math.toDegrees(Math.atan((this.anT - this.cdx) / (this.anU - this.cdy)));
        label506:
        float f2;
        float f3;
        float f4;
        if (getRotation() == 180.0F)
        {
          i = 180;
          f1 = (float)(i + d);
          paramMotionEvent = this.cej;
          f2 = 1.0F / getScale();
          f3 = this.anT;
          f4 = this.anU;
          localObject = this.ccS.dqf();
          if ((localObject != null) && (f3 < ((Bitmap)localObject).getWidth()) && (f4 < ((Bitmap)localObject).getHeight()) && (f3 > 0.0F) && (f4 > 0.0F)) {
            break label663;
          }
          ab.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[] { Float.valueOf(f3), Float.valueOf(f4) });
        }
        label663:
        for (int i = j;; i = ((Bitmap)localObject).getPixel((int)f3, (int)f4))
        {
          paramMotionEvent.add(new d.b(f2, i, f1 % 360.0F, this.anT, this.anU));
          break;
          i = 0;
          break label506;
        }
      }
      if ((this.cdU) && (!this.cdw))
      {
        if (this.cek == d.a.eFI) {
          this.ou.moveTo(localObject[0], localObject[1]);
        }
        this.cdw = true;
      }
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(116200);
    super.onDestroy();
    if ((this.cei != null) && (!this.cei.isRecycled())) {
      this.cei.recycle();
    }
    AppMethodBeat.o(116200);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(116201);
    paramCanvas.save();
    paramCanvas.clipRect(this.ccU);
    if (this.cek == d.a.eFI)
    {
      b(paramCanvas);
      new d(this.cek, this.ou, 1.0F / getScale(), this.cei).draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(116201);
      return;
      if (this.cek == d.a.eFJ)
      {
        new d(this.cek, new LinkedList(this.cej), 1.0F / getScale()).draw(new Canvas(CF()));
        b(paramCanvas);
      }
    }
  }
  
  public final void zy()
  {
    AppMethodBeat.i(116199);
    super.zy();
    if ((h)super.CB() != null) {
      l(((h)super.CB()).Jl());
    }
    Bitmap localBitmap2 = this.ccS.dqf();
    if (localBitmap2 == null)
    {
      ab.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
      localBitmap1 = null;
      this.cei = localBitmap1;
      AppMethodBeat.o(116199);
      return;
    }
    int n = localBitmap2.getWidth();
    int i1 = localBitmap2.getHeight();
    int i3 = com.tencent.mm.cl.a.bC(6.0F);
    Bitmap localBitmap1 = Bitmap.createBitmap(n, i1, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap1);
    int i4 = (int)Math.ceil(n / i3);
    int i5 = (int)Math.ceil(i1 / i3);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    int i = 0;
    label164:
    int j;
    label172:
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
          break label287;
        }
        k = n;
      }
    }
    label287:
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
      break label172;
      i += 1;
      break label164;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.f
 * JD-Core Version:    0.7.0.1
 */