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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.z.e;
import com.tencent.mm.z.e.a;
import com.tencent.mm.z.e.b;
import java.util.LinkedList;

public final class g
  extends b<i>
{
  private float ayf;
  private float ayg;
  private float dbQ;
  private float dbR;
  private Bitmap dcF;
  private LinkedList<e.b> dcG;
  public e.a dcH;
  private boolean dcp;
  private boolean dcq;
  private Path xN;
  
  public g()
  {
    AppMethodBeat.i(9168);
    this.dcp = true;
    this.dcq = false;
    this.xN = new Path();
    this.dcG = new LinkedList();
    this.dcH = e.a.gBN;
    AppMethodBeat.o(9168);
  }
  
  public final a NG()
  {
    return a.dbg;
  }
  
  public final void NH()
  {
    AppMethodBeat.i(9174);
    if ((NM() != null) && (!NM().isRecycled())) {
      NM().recycle();
    }
    t(((i)super.NI()).XX());
    AppMethodBeat.o(9174);
  }
  
  public final void cl(boolean paramBoolean)
  {
    AppMethodBeat.i(9173);
    super.cl(paramBoolean);
    ((i)super.NI()).u(NM());
    AppMethodBeat.o(9173);
  }
  
  public final boolean n(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(9172);
    if (!NN())
    {
      AppMethodBeat.o(9172);
      return false;
    }
    if (this.dbv != null) {
      this.dbv.n(paramMotionEvent);
    }
    Object localObject = u(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.dcp;
      AppMethodBeat.o(9172);
      return bool;
      float f1;
      if (this.dbo.contains((int)localObject[0], (int)localObject[1]))
      {
        f1 = localObject[0];
        this.dbQ = f1;
        this.ayf = f1;
        f1 = localObject[1];
        this.dbR = f1;
        this.ayg = f1;
      }
      for (this.dcp = true;; this.dcp = false)
      {
        this.dcq = false;
        break;
      }
      if ((this.dcp) && (this.dcq))
      {
        if ((i)super.NI() == null)
        {
          ae.e("MicroMsg.MosaicArtist", "getCache is null???");
          AppMethodBeat.o(9172);
          return true;
        }
        if (this.dcH != e.a.gBN) {
          break label328;
        }
        ((i)super.NI()).a(new e(this.dcH, new Path(this.xN), 1.0F / getScale(), this.dcF));
        cl(false);
      }
      for (;;)
      {
        c.XS().b(com.tencent.mm.api.g.cSq);
        NQ();
        this.dcG.clear();
        this.xN.reset();
        this.dcq = false;
        this.dcp = false;
        break;
        label328:
        if (this.dcH == e.a.gBO)
        {
          ((i)super.NI()).a(new e(this.dcH, new LinkedList(this.dcG), 1.0F / getScale()));
          cl(false);
        }
      }
      if ((this.dcp) && (this.dcq))
      {
        this.dbQ = this.ayf;
        this.dbR = this.ayg;
        this.ayf = localObject[0];
        this.ayg = localObject[1];
        if (this.dcH == e.a.gBN) {
          this.xN.quadTo(this.dbQ, this.dbR, (this.ayf + this.dbQ) / 2.0F, (this.ayg + this.dbR) / 2.0F);
        }
        while (this.dcH != e.a.gBO)
        {
          NP();
          break;
        }
        double d = Math.toDegrees(Math.atan((this.ayf - this.dbQ) / (this.ayg - this.dbR)));
        label536:
        float f2;
        float f3;
        float f4;
        if (getRotation() == 180.0F)
        {
          i = 180;
          f1 = (float)(i + d);
          paramMotionEvent = this.dcG;
          f2 = 1.0F / getScale();
          f3 = this.ayf;
          f4 = this.ayg;
          localObject = this.dbm.fjK();
          if ((localObject != null) && (f3 < ((Bitmap)localObject).getWidth()) && (f4 < ((Bitmap)localObject).getHeight()) && (f3 > 0.0F) && (f4 > 0.0F)) {
            break label693;
          }
          ae.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[] { Float.valueOf(f3), Float.valueOf(f4) });
        }
        label693:
        for (int i = j;; i = ((Bitmap)localObject).getPixel((int)f3, (int)f4))
        {
          paramMotionEvent.add(new e.b(f2, i, f1 % 360.0F, this.ayf, this.ayg));
          break;
          i = 0;
          break label536;
        }
      }
      if ((this.dcp) && (!this.dcq))
      {
        if (this.dcH == e.a.gBN) {
          this.xN.moveTo(localObject[0], localObject[1]);
        }
        this.dcq = true;
      }
    }
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9169);
    super.onAlive();
    if ((i)super.NI() != null) {
      t(((i)super.NI()).XX());
    }
    Bitmap localBitmap2 = this.dbm.fjK();
    if (localBitmap2 == null)
    {
      ae.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
      localBitmap1 = null;
      this.dcF = localBitmap1;
      AppMethodBeat.o(9169);
      return;
    }
    int n = localBitmap2.getWidth();
    int i1 = localBitmap2.getHeight();
    int i3 = com.tencent.mm.cl.a.cb(6.0F);
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
  
  public final void onDestroy()
  {
    AppMethodBeat.i(9170);
    super.onDestroy();
    if ((this.dcF != null) && (!this.dcF.isRecycled())) {
      this.dcF.recycle();
    }
    AppMethodBeat.o(9170);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9171);
    paramCanvas.save();
    paramCanvas.clipRect(this.dbo);
    if (this.dcH == e.a.gBN)
    {
      d(paramCanvas);
      new e(this.dcH, this.xN, 1.0F / getScale(), this.dcF).draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(9171);
      return;
      if (this.dcH == e.a.gBO)
      {
        new e(this.dcH, new LinkedList(this.dcG), 1.0F / getScale()).draw(new Canvas(NM()));
        d(paramCanvas);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.e.g
 * JD-Core Version:    0.7.0.1
 */