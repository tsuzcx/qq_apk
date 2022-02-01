package com.tencent.mm.danmaku.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.d.c;
import com.tencent.mm.danmaku.d.f;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public abstract class a
{
  protected int gNo;
  protected final TreeSet<com.tencent.mm.danmaku.b.a> gNp;
  protected final List<com.tencent.mm.danmaku.b.a> gNq;
  protected final com.tencent.mm.danmaku.render.b gNr;
  private ArrayList<Object> gNs;
  protected com.tencent.mm.danmaku.c.a gNt;
  protected b gNu;
  protected f gNv;
  protected c gNw;
  
  protected a(com.tencent.mm.danmaku.c.a parama, b paramb, Comparator<com.tencent.mm.danmaku.b.a> paramComparator, f paramf, c paramc)
  {
    this.gNt = parama;
    this.gNu = paramb;
    this.gNv = paramf;
    this.gNw = paramc;
    this.gNr = new com.tencent.mm.danmaku.render.b(paramb);
    this.gNp = new TreeSet(paramComparator);
    this.gNq = new LinkedList();
    arP();
  }
  
  public static a a(com.tencent.mm.danmaku.c.a parama, b paramb, Comparator<com.tencent.mm.danmaku.b.a> paramComparator, f paramf, c paramc)
  {
    return new j(parama, paramb, paramComparator, paramf, paramc);
  }
  
  public abstract com.tencent.mm.danmaku.b.a a(com.tencent.mm.danmaku.d.h paramh);
  
  protected final void a(Canvas paramCanvas, com.tencent.mm.danmaku.b.a parama)
  {
    com.tencent.mm.danmaku.render.a locala = this.gNt.e(parama);
    com.tencent.mm.danmaku.render.b localb = this.gNr;
    com.tencent.mm.danmaku.c.a locala1 = this.gNt;
    b localb1;
    Object localObject2;
    Object localObject1;
    if (paramCanvas != null) {
      if (parama.asI())
      {
        localb1 = localb.gNu;
        if (parama == null) {
          throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
        }
        if (!parama.gPe) {
          break label291;
        }
        localObject2 = parama.asJ();
        if (localObject2 != null) {
          break label150;
        }
        localObject1 = localb1.gNx.getBitmap((int)parama.asB(), (int)parama.asC());
        parama.w((Bitmap)localObject1);
        if (localObject1 != null) {
          break label213;
        }
        localObject1 = null;
        label106:
        if (localObject1 != null) {
          break label300;
        }
      }
    }
    for (int i = 0;; i = 1)
    {
      if (i == 0)
      {
        m.asX();
        i = paramCanvas.save();
        locala.a(paramCanvas, parama, parama.asG(), parama.asH());
        paramCanvas.restoreToCount(i);
      }
      parama.ako();
      return;
      label150:
      if (((Bitmap)localObject2).getWidth() >= (int)parama.asB())
      {
        localObject1 = localObject2;
        if (((Bitmap)localObject2).getHeight() >= (int)parama.asC()) {
          break;
        }
      }
      localb1.gNx.x((Bitmap)localObject2);
      localObject1 = localb1.gNx.getBitmap((int)parama.asB(), (int)parama.asC());
      break;
      label213:
      localObject2 = parama.asK();
      if (localObject2 == null)
      {
        localObject2 = new Canvas((Bitmap)localObject1);
        parama.m((Canvas)localObject2);
      }
      for (;;)
      {
        ((Bitmap)localObject1).eraseColor(0);
        parama.gPe = false;
        locala1.e(parama).a((Canvas)localObject2, parama, com.tencent.mm.danmaku.c.a.asO().gPJ, com.tencent.mm.danmaku.c.a.asO().gPI);
        break;
        ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
      }
      label291:
      localObject1 = parama.asJ();
      break label106;
      label300:
      i = paramCanvas.save();
      localb.gPU.set(0, 0, (int)parama.asB(), (int)parama.asC());
      localb.gPV.set((int)parama.getLeft(), (int)parama.getTop(), (int)parama.getRight(), (int)parama.getBottom());
      paramCanvas.drawBitmap((Bitmap)localObject1, localb.gPU, localb.gPV, localb.gPW);
      paramCanvas.restoreToCount(i);
    }
  }
  
  public final void a(com.tencent.mm.danmaku.b.a parama)
  {
    this.gNp.add(parama);
  }
  
  public void arP() {}
  
  public abstract void arQ();
  
  public final int arR()
  {
    return this.gNo;
  }
  
  public final List<com.tencent.mm.danmaku.b.a> arS()
  {
    return this.gNq;
  }
  
  public final void arT()
  {
    this.gNq.clear();
  }
  
  public final void b(com.tencent.mm.danmaku.b.a parama)
  {
    parama.gPe = true;
    parama.gPd = true;
    float f = parama.asB();
    h.a(this.gNt, parama);
    parama.aj((parama.asB() + com.tencent.mm.danmaku.b.a.getScreenWidth()) / (f + com.tencent.mm.danmaku.b.a.getScreenWidth()));
  }
  
  public final void h(Canvas paramCanvas)
  {
    i(paramCanvas);
    if ((this.gNs != null) && (paramCanvas != null))
    {
      paramCanvas = this.gNs.iterator();
      while (paramCanvas.hasNext()) {
        paramCanvas.next();
      }
    }
  }
  
  public abstract void i(Canvas paramCanvas);
  
  public abstract void layout();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.a
 * JD-Core Version:    0.7.0.1
 */