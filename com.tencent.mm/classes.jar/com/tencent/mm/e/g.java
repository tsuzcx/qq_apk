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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.z.e;
import com.tencent.mm.z.e.a;
import com.tencent.mm.z.e.b;
import java.util.LinkedList;

public final class g
  extends b<i>
{
  private float awo;
  private float awp;
  private boolean cPX;
  private boolean cPY;
  private float cPy;
  private float cPz;
  private Bitmap cQn;
  private LinkedList<e.b> cQo;
  public e.a cQp;
  private Path vU;
  
  public g()
  {
    AppMethodBeat.i(9168);
    this.cPX = true;
    this.cPY = false;
    this.vU = new Path();
    this.cQo = new LinkedList();
    this.cQp = e.a.gfw;
    AppMethodBeat.o(9168);
  }
  
  public final a LZ()
  {
    return a.cOO;
  }
  
  public final void Ma()
  {
    AppMethodBeat.i(9174);
    if ((Mf() != null) && (!Mf().isRecycled())) {
      Mf().recycle();
    }
    s(((i)super.Mb()).Vw());
    AppMethodBeat.o(9174);
  }
  
  public final void ck(boolean paramBoolean)
  {
    AppMethodBeat.i(9173);
    super.ck(paramBoolean);
    ((i)super.Mb()).t(Mf());
    AppMethodBeat.o(9173);
  }
  
  public final boolean n(MotionEvent paramMotionEvent)
  {
    int j = 0;
    AppMethodBeat.i(9172);
    if (!Mg())
    {
      AppMethodBeat.o(9172);
      return false;
    }
    if (this.cPd != null) {
      this.cPd.n(paramMotionEvent);
    }
    Object localObject = s(paramMotionEvent.getX(), paramMotionEvent.getY());
    switch (paramMotionEvent.getActionMasked())
    {
    }
    for (;;)
    {
      boolean bool = this.cPX;
      AppMethodBeat.o(9172);
      return bool;
      float f1;
      if (this.cOW.contains((int)localObject[0], (int)localObject[1]))
      {
        f1 = localObject[0];
        this.cPy = f1;
        this.awo = f1;
        f1 = localObject[1];
        this.cPz = f1;
        this.awp = f1;
      }
      for (this.cPX = true;; this.cPX = false)
      {
        this.cPY = false;
        break;
      }
      if ((this.cPX) && (this.cPY))
      {
        if ((i)super.Mb() == null)
        {
          ac.e("MicroMsg.MosaicArtist", "getCache is null???");
          AppMethodBeat.o(9172);
          return true;
        }
        if (this.cQp != e.a.gfw) {
          break label328;
        }
        ((i)super.Mb()).a(new e(this.cQp, new Path(this.vU), 1.0F / getScale(), this.cQn));
        ck(false);
      }
      for (;;)
      {
        c.Vr().b(com.tencent.mm.api.g.cGC);
        Mj();
        this.cQo.clear();
        this.vU.reset();
        this.cPY = false;
        this.cPX = false;
        break;
        label328:
        if (this.cQp == e.a.gfx)
        {
          ((i)super.Mb()).a(new e(this.cQp, new LinkedList(this.cQo), 1.0F / getScale()));
          ck(false);
        }
      }
      if ((this.cPX) && (this.cPY))
      {
        this.cPy = this.awo;
        this.cPz = this.awp;
        this.awo = localObject[0];
        this.awp = localObject[1];
        if (this.cQp == e.a.gfw) {
          this.vU.quadTo(this.cPy, this.cPz, (this.awo + this.cPy) / 2.0F, (this.awp + this.cPz) / 2.0F);
        }
        while (this.cQp != e.a.gfx)
        {
          Mi();
          break;
        }
        double d = Math.toDegrees(Math.atan((this.awo - this.cPy) / (this.awp - this.cPz)));
        label536:
        float f2;
        float f3;
        float f4;
        if (getRotation() == 180.0F)
        {
          i = 180;
          f1 = (float)(i + d);
          paramMotionEvent = this.cQo;
          f2 = 1.0F / getScale();
          f3 = this.awo;
          f4 = this.awp;
          localObject = this.cOU.eQQ();
          if ((localObject != null) && (f3 < ((Bitmap)localObject).getWidth()) && (f4 < ((Bitmap)localObject).getHeight()) && (f3 > 0.0F) && (f4 > 0.0F)) {
            break label693;
          }
          ac.w("MicroMsg.MosaicArtist", "[getPosColor] X:%s,Y:%s", new Object[] { Float.valueOf(f3), Float.valueOf(f4) });
        }
        label693:
        for (int i = j;; i = ((Bitmap)localObject).getPixel((int)f3, (int)f4))
        {
          paramMotionEvent.add(new e.b(f2, i, f1 % 360.0F, this.awo, this.awp));
          break;
          i = 0;
          break label536;
        }
      }
      if ((this.cPX) && (!this.cPY))
      {
        if (this.cQp == e.a.gfw) {
          this.vU.moveTo(localObject[0], localObject[1]);
        }
        this.cPY = true;
      }
    }
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(9169);
    super.onAlive();
    if ((i)super.Mb() != null) {
      s(((i)super.Mb()).Vw());
    }
    Bitmap localBitmap2 = this.cOU.eQQ();
    if (localBitmap2 == null)
    {
      ac.e("MicroMsg.MosaicArtist", "[generateMosaicImage] bitmap is null");
      localBitmap1 = null;
      this.cQn = localBitmap1;
      AppMethodBeat.o(9169);
      return;
    }
    int n = localBitmap2.getWidth();
    int i1 = localBitmap2.getHeight();
    int i3 = com.tencent.mm.cm.a.bY(6.0F);
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
    if ((this.cQn != null) && (!this.cQn.isRecycled())) {
      this.cQn.recycle();
    }
    AppMethodBeat.o(9170);
  }
  
  public final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(9171);
    paramCanvas.save();
    paramCanvas.clipRect(this.cOW);
    if (this.cQp == e.a.gfw)
    {
      d(paramCanvas);
      new e(this.cQp, this.vU, 1.0F / getScale(), this.cQn).draw(paramCanvas);
    }
    for (;;)
    {
      paramCanvas.restore();
      AppMethodBeat.o(9171);
      return;
      if (this.cQp == e.a.gfx)
      {
        new e(this.cQp, new LinkedList(this.cQo), 1.0F / getScale()).draw(new Canvas(Mf()));
        d(paramCanvas);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.e.g
 * JD-Core Version:    0.7.0.1
 */