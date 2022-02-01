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
import com.tencent.mm.sdk.platformtools.Log;
import java.util.LinkedList;

public final class h
  extends b<com.tencent.mm.cache.i>
{
  private Path cja;
  private boolean hpV;
  private boolean hpW;
  private float hpx;
  private float hpy;
  private Bitmap hqr;
  private LinkedList<e.b> hqs;
  public e.a hqt;
  private float wT;
  private float wU;
  
  public h()
  {
    AppMethodBeat.i(9168);
    this.hpV = true;
    this.hpW = false;
    this.cja = new Path();
    this.hqs = new LinkedList();
    this.hqt = e.a.mAw;
    AppMethodBeat.o(9168);
  }
  
  public final a aEy()
  {
    return a.hoL;
  }
  
  public final void aEz()
  {
    AppMethodBeat.i(9174);
    if ((aEE() != null) && (!aEE().isRecycled())) {
      aEE().recycle();
    }
    A(((com.tencent.mm.cache.i)super.aEA()).aLF());
    AppMethodBeat.o(9174);
  }
  
  public final void ec(boolean paramBoolean)
  {
    AppMethodBeat.i(9173);
    super.ec(paramBoolean);
    ((com.tencent.mm.cache.i)super.aEA()).B(aEE());
    AppMethodBeat.o(9173);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9169);
    super.onAlive();
    if ((com.tencent.mm.cache.i)super.aEA() != null) {
      A(((com.tencent.mm.cache.i)super.aEA()).aLF());
    }
    Bitmap localBitmap2 = this.hoR.iPu();
    if (localBitmap2 == null)
    {
      Log.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
      localBitmap1 = null;
      this.hqr = localBitmap1;
      AppMethodBeat.o(9169);
      return;
    }
    int n = localBitmap2.getWidth();
    int i1 = localBitmap2.getHeight();
    int i3 = com.tencent.mm.cl.a.eo(6.0F);
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
    if ((this.hqr != null) && (!this.hqr.isRecycled())) {
      this.hqr.recycle();
    }
    AppMethodBeat.o(9170);
  }
  
  public final boolean onDispatchTouch(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(9172);
    if (!aEF())
    {
      AppMethodBeat.o(9172);
      return false;
    }
    if (this.hpb != null) {
      this.hpb.onDispatchTouch(paramMotionEvent);
    }
    Object localObject = ad(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.hpV;
      AppMethodBeat.o(9172);
      return bool;
      float f1;
      if (getAliveRect().contains((int)localObject[0], (int)localObject[1]))
      {
        f1 = localObject[0];
        this.hpx = f1;
        this.wT = f1;
        f1 = localObject[1];
        this.hpy = f1;
        this.wU = f1;
      }
      for (this.hpV = true;; this.hpV = false)
      {
        this.hpW = false;
        break;
      }
      if ((this.hpV) && (this.hpW))
      {
        if ((com.tencent.mm.cache.i)super.aEA() == null)
        {
          Log.e("MicroMsg.MosaicArtist", "getCache is null???");
          AppMethodBeat.o(9172);
          return true;
        }
        if (this.hqt != e.a.mAw) {
          break label328;
        }
        ((com.tencent.mm.cache.i)super.aEA()).a(new e(this.hqt, new Path(this.cja), 1.0F / getScale(), this.hqr));
        ec(false);
      }
      for (;;)
      {
        c.aLA().b(com.tencent.mm.api.i.hdR);
        aEI();
        this.hqs.clear();
        this.cja.reset();
        this.hpW = false;
        this.hpV = false;
        break;
        label328:
        if (this.hqt == e.a.mAx)
        {
          ((com.tencent.mm.cache.i)super.aEA()).a(new e(this.hqt, new LinkedList(this.hqs), 1.0F / getScale()));
          ec(false);
        }
      }
      if ((this.hpV) && (this.hpW))
      {
        this.hpx = this.wT;
        this.hpy = this.wU;
        this.wT = localObject[0];
        this.wU = localObject[1];
        if (this.hqt == e.a.mAw) {
          this.cja.quadTo(this.hpx, this.hpy, (this.wT + this.hpx) / 2.0F, (this.wU + this.hpy) / 2.0F);
        }
        while (this.hqt != e.a.mAx)
        {
          aEH();
          break;
        }
        double d = Math.toDegrees(Math.atan((this.wT - this.hpx) / (this.wU - this.hpy)));
        label537:
        float f2;
        float f3;
        float f4;
        if (getRotation() == 180.0F)
        {
          i = 180;
          f1 = (float)(i + d);
          paramMotionEvent = this.hqs;
          f2 = 1.0F / getScale();
          f3 = this.wT;
          f4 = this.wU;
          localObject = this.hoR.iPu();
          if ((localObject != null) && (f3 < ((Bitmap)localObject).getWidth()) && (f4 < ((Bitmap)localObject).getHeight()) && (f3 > 0.0F) && (f4 > 0.0F)) {
            break label695;
          }
          Log.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[] { Float.valueOf(f3), Float.valueOf(f4) });
        }
        label695:
        for (int i = j;; i = ((Bitmap)localObject).getPixel((int)f3, (int)f4))
        {
          paramMotionEvent.add(new e.b(f2, i, f1 % 360.0F, this.wT, this.wU));
          break;
          i = 0;
          break label537;
        }
      }
      if ((this.hpV) && (!this.hpW))
      {
        if (this.hqt == e.a.mAw) {
          this.cja.moveTo(localObject[0], localObject[1]);
        }
        this.hpW = true;
      }
    }
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9171);
    paramCanvas.save();
    paramCanvas.clipRect(getAliveRect());
    if (this.hqt == e.a.mAw)
    {
      h(paramCanvas);
      new e(this.hqt, this.cja, 1.0F / getScale(), this.hqr).draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(9171);
      return;
      if (this.hqt == e.a.mAx)
      {
        new e(this.hqt, new LinkedList(this.hqs), 1.0F / getScale()).draw(new Canvas(aEE()));
        h(paramCanvas);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.e.h
 * JD-Core Version:    0.7.0.1
 */