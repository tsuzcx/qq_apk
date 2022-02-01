package com.tencent.mm.e;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.e;
import com.tencent.mm.aa.e.a;
import com.tencent.mm.aa.e.b;
import com.tencent.mm.cache.c;
import com.tencent.mm.cache.i;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.LinkedList;

public final class g
  extends b<i>
{
  private float avt;
  private float avu;
  private boolean cSB;
  private Bitmap cSQ;
  private LinkedList<e.b> cSR;
  public e.a cSS;
  private boolean cSd;
  private float cSe;
  private float cSf;
  private Path uW;
  
  public g()
  {
    AppMethodBeat.i(9168);
    this.cSB = true;
    this.cSd = false;
    this.uW = new Path();
    this.cSR = new LinkedList();
    this.cSS = e.a.gaQ;
    AppMethodBeat.o(9168);
  }
  
  public final a Mb()
  {
    return a.cRt;
  }
  
  public final void Mc()
  {
    AppMethodBeat.i(9174);
    if ((Mh() != null) && (!Mh().isRecycled())) {
      Mh().recycle();
    }
    s(((i)super.Md()).UB());
    AppMethodBeat.o(9174);
  }
  
  public final void ci(boolean paramBoolean)
  {
    AppMethodBeat.i(9173);
    super.ci(paramBoolean);
    ((i)super.Md()).t(Mh());
    AppMethodBeat.o(9173);
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9169);
    super.onAlive();
    if ((i)super.Md() != null) {
      s(((i)super.Md()).UB());
    }
    Bitmap localBitmap2 = this.cRz.eBw();
    if (localBitmap2 == null)
    {
      ad.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
      localBitmap1 = null;
      this.cSQ = localBitmap1;
      AppMethodBeat.o(9169);
      return;
    }
    int n = localBitmap2.getWidth();
    int i1 = localBitmap2.getHeight();
    int i3 = com.tencent.mm.cn.a.bP(6.0F);
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
    if ((this.cSQ != null) && (!this.cSQ.isRecycled())) {
      this.cSQ.recycle();
    }
    AppMethodBeat.o(9170);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9171);
    paramCanvas.save();
    paramCanvas.clipRect(this.cRB);
    if (this.cSS == e.a.gaQ)
    {
      d(paramCanvas);
      new e(this.cSS, this.uW, 1.0F / getScale(), this.cSQ).draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(9171);
      return;
      if (this.cSS == e.a.gaR)
      {
        new e(this.cSS, new LinkedList(this.cSR), 1.0F / getScale()).draw(new Canvas(Mh()));
        d(paramCanvas);
      }
    }
  }
  
  public final boolean p(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(9172);
    if (!Mi())
    {
      AppMethodBeat.o(9172);
      return false;
    }
    if (this.cRI != null) {
      this.cRI.p(paramMotionEvent);
    }
    Object localObject = s(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.cSB;
      AppMethodBeat.o(9172);
      return bool;
      float f1;
      if (this.cRB.contains((int)localObject[0], (int)localObject[1]))
      {
        f1 = localObject[0];
        this.cSe = f1;
        this.avt = f1;
        f1 = localObject[1];
        this.cSf = f1;
        this.avu = f1;
      }
      for (this.cSB = true;; this.cSB = false)
      {
        this.cSd = false;
        break;
      }
      if ((this.cSB) && (this.cSd))
      {
        if ((i)super.Md() == null)
        {
          ad.e("MicroMsg.MosaicArtist", "getCache is null???");
          AppMethodBeat.o(9172);
          return true;
        }
        if (this.cSS != e.a.gaQ) {
          break label329;
        }
        ((i)super.Md()).a(new e(this.cSS, new Path(this.uW), 1.0F / getScale(), this.cSQ));
        ci(false);
      }
      for (;;)
      {
        c.Uw().b(com.tencent.mm.api.g.cJv);
        Ml();
        this.cSR.clear();
        this.uW.reset();
        this.cSd = false;
        this.cSB = false;
        break;
        label329:
        if (this.cSS == e.a.gaR)
        {
          ((i)super.Md()).a(new e(this.cSS, new LinkedList(this.cSR), 1.0F / getScale()));
          ci(false);
        }
      }
      if ((this.cSB) && (this.cSd))
      {
        this.cSe = this.avt;
        this.cSf = this.avu;
        this.avt = localObject[0];
        this.avu = localObject[1];
        if (this.cSS == e.a.gaQ) {
          this.uW.quadTo(this.cSe, this.cSf, (this.avt + this.cSe) / 2.0F, (this.avu + this.cSf) / 2.0F);
        }
        while (this.cSS != e.a.gaR)
        {
          Mk();
          break;
        }
        double d = Math.toDegrees(Math.atan((this.avt - this.cSe) / (this.avu - this.cSf)));
        label538:
        float f2;
        float f3;
        float f4;
        if (getRotation() == 180.0F)
        {
          i = 180;
          f1 = (float)(i + d);
          paramMotionEvent = this.cSR;
          f2 = 1.0F / getScale();
          f3 = this.avt;
          f4 = this.avu;
          localObject = this.cRz.eBw();
          if ((localObject != null) && (f3 < ((Bitmap)localObject).getWidth()) && (f4 < ((Bitmap)localObject).getHeight()) && (f3 > 0.0F) && (f4 > 0.0F)) {
            break label696;
          }
          ad.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[] { Float.valueOf(f3), Float.valueOf(f4) });
        }
        label696:
        for (int i = j;; i = ((Bitmap)localObject).getPixel((int)f3, (int)f4))
        {
          paramMotionEvent.add(new e.b(f2, i, f1 % 360.0F, this.avt, this.avu));
          break;
          i = 0;
          break label538;
        }
      }
      if ((this.cSB) && (!this.cSd))
      {
        if (this.cSS == e.a.gaQ) {
          this.uW.moveTo(localObject[0], localObject[1]);
        }
        this.cSd = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.e.g
 * JD-Core Version:    0.7.0.1
 */