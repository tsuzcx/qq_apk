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
  private float ayf;
  private float ayg;
  private float daO;
  private float daP;
  private Bitmap dbD;
  private LinkedList<e.b> dbE;
  public e.a dbF;
  private boolean dbn;
  private boolean dbo;
  private Path xN;
  
  public g()
  {
    AppMethodBeat.i(9168);
    this.dbn = true;
    this.dbo = false;
    this.xN = new Path();
    this.dbE = new LinkedList();
    this.dbF = e.a.gzg;
    AppMethodBeat.o(9168);
  }
  
  public final a NI()
  {
    return a.dae;
  }
  
  public final void NJ()
  {
    AppMethodBeat.i(9174);
    if ((NO() != null) && (!NO().isRecycled())) {
      NO().recycle();
    }
    s(((i)super.NK()).XN());
    AppMethodBeat.o(9174);
  }
  
  public final void cl(boolean paramBoolean)
  {
    AppMethodBeat.i(9173);
    super.cl(paramBoolean);
    ((i)super.NK()).t(NO());
    AppMethodBeat.o(9173);
  }
  
  public final boolean n(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(9172);
    if (!NP())
    {
      AppMethodBeat.o(9172);
      return false;
    }
    if (this.dat != null) {
      this.dat.n(paramMotionEvent);
    }
    Object localObject = u(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.dbn;
      AppMethodBeat.o(9172);
      return bool;
      float f1;
      if (this.dam.contains((int)localObject[0], (int)localObject[1]))
      {
        f1 = localObject[0];
        this.daO = f1;
        this.ayf = f1;
        f1 = localObject[1];
        this.daP = f1;
        this.ayg = f1;
      }
      for (this.dbn = true;; this.dbn = false)
      {
        this.dbo = false;
        break;
      }
      if ((this.dbn) && (this.dbo))
      {
        if ((i)super.NK() == null)
        {
          ad.e("MicroMsg.MosaicArtist", "getCache is null???");
          AppMethodBeat.o(9172);
          return true;
        }
        if (this.dbF != e.a.gzg) {
          break label328;
        }
        ((i)super.NK()).a(new e(this.dbF, new Path(this.xN), 1.0F / getScale(), this.dbD));
        cl(false);
      }
      for (;;)
      {
        c.XI().b(com.tencent.mm.api.g.cRG);
        NS();
        this.dbE.clear();
        this.xN.reset();
        this.dbo = false;
        this.dbn = false;
        break;
        label328:
        if (this.dbF == e.a.gzh)
        {
          ((i)super.NK()).a(new e(this.dbF, new LinkedList(this.dbE), 1.0F / getScale()));
          cl(false);
        }
      }
      if ((this.dbn) && (this.dbo))
      {
        this.daO = this.ayf;
        this.daP = this.ayg;
        this.ayf = localObject[0];
        this.ayg = localObject[1];
        if (this.dbF == e.a.gzg) {
          this.xN.quadTo(this.daO, this.daP, (this.ayf + this.daO) / 2.0F, (this.ayg + this.daP) / 2.0F);
        }
        while (this.dbF != e.a.gzh)
        {
          NR();
          break;
        }
        double d = Math.toDegrees(Math.atan((this.ayf - this.daO) / (this.ayg - this.daP)));
        label536:
        float f2;
        float f3;
        float f4;
        if (getRotation() == 180.0F)
        {
          i = 180;
          f1 = (float)(i + d);
          paramMotionEvent = this.dbE;
          f2 = 1.0F / getScale();
          f3 = this.ayf;
          f4 = this.ayg;
          localObject = this.dak.ffU();
          if ((localObject != null) && (f3 < ((Bitmap)localObject).getWidth()) && (f4 < ((Bitmap)localObject).getHeight()) && (f3 > 0.0F) && (f4 > 0.0F)) {
            break label693;
          }
          ad.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[] { Float.valueOf(f3), Float.valueOf(f4) });
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
      if ((this.dbn) && (!this.dbo))
      {
        if (this.dbF == e.a.gzg) {
          this.xN.moveTo(localObject[0], localObject[1]);
        }
        this.dbo = true;
      }
    }
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9169);
    super.onAlive();
    if ((i)super.NK() != null) {
      s(((i)super.NK()).XN());
    }
    Bitmap localBitmap2 = this.dak.ffU();
    if (localBitmap2 == null)
    {
      ad.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
      localBitmap1 = null;
      this.dbD = localBitmap1;
      AppMethodBeat.o(9169);
      return;
    }
    int n = localBitmap2.getWidth();
    int i1 = localBitmap2.getHeight();
    int i3 = com.tencent.mm.cm.a.cd(6.0F);
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
    if ((this.dbD != null) && (!this.dbD.isRecycled())) {
      this.dbD.recycle();
    }
    AppMethodBeat.o(9170);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9171);
    paramCanvas.save();
    paramCanvas.clipRect(this.dam);
    if (this.dbF == e.a.gzg)
    {
      d(paramCanvas);
      new e(this.dbF, this.xN, 1.0F / getScale(), this.dbD).draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(9171);
      return;
      if (this.dbF == e.a.gzh)
      {
        new e(this.dbF, new LinkedList(this.dbE), 1.0F / getScale()).draw(new Canvas(NO()));
        d(paramCanvas);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.e.g
 * JD-Core Version:    0.7.0.1
 */