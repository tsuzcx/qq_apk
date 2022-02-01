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
  protected int jxJ;
  protected final TreeSet<com.tencent.mm.danmaku.b.a> jxK;
  protected final List<com.tencent.mm.danmaku.b.a> jxL;
  protected final com.tencent.mm.danmaku.render.b jxM;
  private ArrayList<Object> jxN;
  protected com.tencent.mm.danmaku.c.a jxO;
  protected b jxP;
  protected f jxQ;
  protected c jxR;
  
  protected a(com.tencent.mm.danmaku.c.a parama, b paramb, Comparator<com.tencent.mm.danmaku.b.a> paramComparator, f paramf, c paramc)
  {
    this.jxO = parama;
    this.jxP = paramb;
    this.jxQ = paramf;
    this.jxR = paramc;
    this.jxM = new com.tencent.mm.danmaku.render.b(paramb);
    this.jxK = new TreeSet(paramComparator);
    this.jxL = new LinkedList();
    ayA();
  }
  
  public static a a(com.tencent.mm.danmaku.c.a parama, b paramb, Comparator<com.tencent.mm.danmaku.b.a> paramComparator, f paramf, c paramc)
  {
    return new j(parama, paramb, paramComparator, paramf, paramc);
  }
  
  public abstract com.tencent.mm.danmaku.b.a a(com.tencent.mm.danmaku.d.h paramh);
  
  protected final void a(Canvas paramCanvas, com.tencent.mm.danmaku.b.a parama)
  {
    com.tencent.mm.danmaku.render.a locala = this.jxO.d(parama);
    com.tencent.mm.danmaku.render.b localb = this.jxM;
    com.tencent.mm.danmaku.c.a locala1 = this.jxO;
    b localb1;
    Object localObject2;
    Object localObject1;
    if (paramCanvas != null) {
      if (parama.azw())
      {
        localb1 = localb.jxP;
        if (parama == null) {
          throw new RuntimeException("fetchBitmapCache NullPointException, BaseDanmaku is null");
        }
        if (!parama.jzy) {
          break label291;
        }
        localObject2 = parama.azx();
        if (localObject2 != null) {
          break label150;
        }
        localObject1 = localb1.jxS.getBitmap((int)parama.azp(), (int)parama.azq());
        parama.r((Bitmap)localObject1);
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
        m.azL();
        i = paramCanvas.save();
        locala.a(paramCanvas, parama, parama.azu(), parama.azv());
        paramCanvas.restoreToCount(i);
      }
      parama.aqk();
      return;
      label150:
      if (((Bitmap)localObject2).getWidth() >= (int)parama.azp())
      {
        localObject1 = localObject2;
        if (((Bitmap)localObject2).getHeight() >= (int)parama.azq()) {
          break;
        }
      }
      localb1.jxS.s((Bitmap)localObject2);
      localObject1 = localb1.jxS.getBitmap((int)parama.azp(), (int)parama.azq());
      break;
      label213:
      localObject2 = parama.azy();
      if (localObject2 == null)
      {
        localObject2 = new Canvas((Bitmap)localObject1);
        parama.n((Canvas)localObject2);
      }
      for (;;)
      {
        ((Bitmap)localObject1).eraseColor(0);
        parama.jzy = false;
        locala1.d(parama).a((Canvas)localObject2, parama, com.tencent.mm.danmaku.c.a.azC().jAc, com.tencent.mm.danmaku.c.a.azC().jAb);
        break;
        ((Canvas)localObject2).setBitmap((Bitmap)localObject1);
      }
      label291:
      localObject1 = parama.azx();
      break label106;
      label300:
      i = paramCanvas.save();
      localb.jAn.set(0, 0, (int)parama.azp(), (int)parama.azq());
      localb.jAo.set((int)parama.getLeft(), (int)parama.getTop(), (int)parama.getRight(), (int)parama.getBottom());
      paramCanvas.drawBitmap((Bitmap)localObject1, localb.jAn, localb.jAo, localb.jAp);
      paramCanvas.restoreToCount(i);
    }
  }
  
  public final void a(com.tencent.mm.danmaku.b.a parama)
  {
    this.jxK.add(parama);
  }
  
  public void ayA() {}
  
  public abstract void ayB();
  
  public final int ayC()
  {
    return this.jxJ;
  }
  
  public final List<com.tencent.mm.danmaku.b.a> ayD()
  {
    return this.jxL;
  }
  
  public final void ayE()
  {
    this.jxL.clear();
  }
  
  public final void b(com.tencent.mm.danmaku.b.a parama)
  {
    parama.jzy = true;
    parama.jzx = true;
    float f = parama.azp();
    h.a(this.jxO, parama);
    parama.ai((parama.azp() + com.tencent.mm.danmaku.b.a.getScreenWidth()) / (f + com.tencent.mm.danmaku.b.a.getScreenWidth()));
  }
  
  public abstract void fP();
  
  public final void i(Canvas paramCanvas)
  {
    j(paramCanvas);
    if ((this.jxN != null) && (paramCanvas != null))
    {
      paramCanvas = this.jxN.iterator();
      while (paramCanvas.hasNext()) {
        paramCanvas.next();
      }
    }
  }
  
  public abstract void j(Canvas paramCanvas);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.a
 * JD-Core Version:    0.7.0.1
 */