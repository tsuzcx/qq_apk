package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.MotionEvent;
import com.tencent.mm.cache.g;
import com.tencent.mm.cache.g.1;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.z.d;
import com.tencent.mm.z.d.a;
import com.tencent.mm.z.d.b;
import java.util.HashMap;
import java.util.LinkedList;

public final class f
  extends b<g>
{
  private float alB;
  private float alC;
  private float bAA;
  private float bAB;
  private boolean bAX = true;
  private boolean bAz = false;
  private Bitmap bBl;
  private LinkedList<d.b> bBm = new LinkedList();
  public d.a bBn = d.a.dIe;
  private Path nw = new Path();
  
  public final void aS(boolean paramBoolean)
  {
    super.aS(paramBoolean);
    g localg = (g)tI();
    Bitmap localBitmap = tN().copy(Bitmap.Config.ARGB_8888, true);
    String str1 = a.bzQ.toString();
    str1 = com.tencent.mm.compatible.util.e.dzC + String.format("%s%d.%s", new Object[] { "wx_photo_edit_", Long.valueOf(System.currentTimeMillis()), str1 });
    y.i("MicroMsg.MosaicCache", "[saveCacheToLocal] path:%s size:%s", new Object[] { str1, Integer.valueOf(localg.bg(true)) });
    String str2 = (String)localg.dle.get(localg.bg(true));
    if (!bk.bl(str2))
    {
      com.tencent.mm.vfs.e.deleteFile(str2);
      localg.dle.remove(localg.bg(true));
    }
    localg.dle.put(localg.bg(true), str1);
    localg.dlf.put(str1, localBitmap);
    com.tencent.mm.sdk.f.e.csu();
    com.tencent.mm.sdk.f.e.a(new g.1(localg, localBitmap, str1), "[saveCacheToLocal] mosaic path:" + str1);
  }
  
  public final boolean m(MotionEvent paramMotionEvent)
  {
    int j = 0;
    if (!tO()) {
      return false;
    }
    Object localObject = A(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      return this.bAX;
      float f1;
      if (this.bzX.contains((int)localObject[0], (int)localObject[1]))
      {
        f1 = localObject[0];
        this.bAA = f1;
        this.alB = f1;
        f1 = localObject[1];
        this.bAB = f1;
        this.alC = f1;
      }
      for (this.bAX = true;; this.bAX = false)
      {
        this.bAz = false;
        break;
      }
      if ((this.bAX) && (this.bAz))
      {
        if (this.bBn != d.a.dIe) {
          break label252;
        }
        ((g)tI()).a(new d(this.bBn, new Path(this.nw), 1.0F / getScale(), this.bBl));
        aS(false);
      }
      for (;;)
      {
        tR();
        this.bBm.clear();
        this.nw.reset();
        this.bAz = false;
        this.bAX = false;
        break;
        label252:
        if (this.bBn == d.a.dIf)
        {
          ((g)tI()).a(new d(this.bBn, new LinkedList(this.bBm), 1.0F / getScale()));
          aS(false);
        }
      }
      if ((this.bAX) && (this.bAz))
      {
        this.bAA = this.alB;
        this.bAB = this.alC;
        this.alB = localObject[0];
        this.alC = localObject[1];
        if (this.bBn == d.a.dIe) {
          this.nw.quadTo(this.bAA, this.bAB, (this.alB + this.bAA) / 2.0F, (this.alC + this.bAB) / 2.0F);
        }
        while (this.bBn != d.a.dIf)
        {
          tQ();
          break;
        }
        double d = Math.toDegrees(Math.atan((this.alB - this.bAA) / (this.alC - this.bAB)));
        label461:
        float f2;
        float f3;
        float f4;
        if (getRotation() == 180.0F)
        {
          i = 180;
          f1 = (float)(i + d);
          paramMotionEvent = this.bBm;
          f2 = 1.0F / getScale();
          f3 = this.alB;
          f4 = this.alC;
          localObject = this.bzV.coJ();
          if ((localObject != null) && (f3 < ((Bitmap)localObject).getWidth()) && (f4 < ((Bitmap)localObject).getHeight()) && (f3 > 0.0F) && (f4 > 0.0F)) {
            break label620;
          }
          y.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[] { Float.valueOf(f3), Float.valueOf(f4) });
        }
        label620:
        for (int i = j;; i = ((Bitmap)localObject).getPixel((int)f3, (int)f4))
        {
          paramMotionEvent.add(new d.b(f2, i, f1 % 360.0F, this.alB, this.alC));
          break;
          i = 0;
          break label461;
        }
      }
      if ((this.bAX) && (!this.bAz))
      {
        if (this.bBn == d.a.dIe) {
          this.nw.moveTo(localObject[0], localObject[1]);
        }
        this.bAz = true;
      }
    }
  }
  
  public final void onDestroy()
  {
    super.onDestroy();
    if ((this.bBl != null) && (!this.bBl.isRecycled())) {
      this.bBl.recycle();
    }
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.clipRect(this.bzX);
    if (this.bBn == d.a.dIe)
    {
      b(paramCanvas);
      new d(this.bBn, this.nw, 1.0F / getScale(), this.bBl).draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      return;
      if (this.bBn == d.a.dIf)
      {
        new d(this.bBn, new LinkedList(this.bBm), 1.0F / getScale()).draw(new Canvas(tN()));
        b(paramCanvas);
      }
    }
  }
  
  public final a tG()
  {
    return a.bzQ;
  }
  
  public final void tH()
  {
    if ((tN() != null) && (!tN().isRecycled())) {
      tN().recycle();
    }
    j(((g)tI()).wU());
  }
  
  public final void tJ()
  {
    super.tJ();
    j(((g)tI()).wU());
    Bitmap localBitmap2 = this.bzV.coJ();
    if (localBitmap2 == null)
    {
      y.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
      localBitmap1 = null;
      this.bBl = localBitmap1;
      return;
    }
    int n = localBitmap2.getWidth();
    int i1 = localBitmap2.getHeight();
    int i3 = com.tencent.mm.cj.a.aR(6.0F);
    Bitmap localBitmap1 = Bitmap.createBitmap(n, i1, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap1);
    int i4 = (int)Math.ceil(n / i3);
    int i5 = (int)Math.ceil(i1 / i3);
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    int i = 0;
    label143:
    int j;
    label151:
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
          break label266;
        }
        k = n;
      }
    }
    label266:
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
      break label151;
      i += 1;
      break label143;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.e.f
 * JD-Core Version:    0.7.0.1
 */