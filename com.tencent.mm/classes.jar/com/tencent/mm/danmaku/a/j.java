package com.tencent.mm.danmaku.a;

import android.graphics.Canvas;
import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.danmaku.c.g;
import com.tencent.mm.danmaku.c.m;
import com.tencent.mm.danmaku.d.f;
import com.tencent.mm.danmaku.e.e;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public final class j
  extends a
{
  protected int jyY;
  private int jyZ;
  private int[] jza;
  private com.tencent.mm.danmaku.b.a[] jzb;
  private List<List<com.tencent.mm.danmaku.b.a>> jzc;
  
  protected j(com.tencent.mm.danmaku.c.a parama, b paramb, Comparator<com.tencent.mm.danmaku.b.a> paramComparator, f paramf, com.tencent.mm.danmaku.d.c paramc)
  {
    super(parama, paramb, paramComparator, paramf, paramc);
  }
  
  private void a(com.tencent.mm.danmaku.b.a parama, int paramInt)
  {
    AppMethodBeat.i(280724);
    parama.azw();
    parama.a(paramInt, this.jxQ.jAT, this.jxR.jAO);
    AppMethodBeat.o(280724);
  }
  
  private void a(List<List<com.tencent.mm.danmaku.b.a>> paramList, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(280722);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.danmaku.b.d locald = (com.tencent.mm.danmaku.b.d)localIterator.next();
        locald.azi();
        long l = this.jxR.jAO;
        int k = (int)locald.mLeft;
        b(locald);
        locald.Fi(l - (int)((com.tencent.mm.danmaku.b.d.getScreenWidth() - k) / --locald.jzC));
        locald.mTop = paramArrayOfInt[i];
        locald.mLeft = k;
      }
      i += 1;
    }
    AppMethodBeat.o(280722);
  }
  
  private void azh()
  {
    AppMethodBeat.i(280725);
    int j = this.jzc.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jzc.get(i)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.danmaku.b.a locala = (com.tencent.mm.danmaku.b.a)localIterator.next();
        if ((locala.Fd(this.jxR.jAO)) || (!locala.isShown()))
        {
          if (locala == this.jzb[i]) {
            this.jzb[i] = null;
          }
          localIterator.remove();
          this.jxJ -= 1;
          this.jxL.add(locala);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(280725);
  }
  
  public final com.tencent.mm.danmaku.b.a a(com.tencent.mm.danmaku.d.h paramh)
  {
    AppMethodBeat.i(280728);
    int k = this.jzc.size();
    int i = 0;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jzc.get(i)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.danmaku.b.a locala = (com.tencent.mm.danmaku.b.a)localIterator.next();
        if (com.tencent.mm.danmaku.b.a.azt())
        {
          float f1 = paramh.mPoint.x;
          float f2 = paramh.mPoint.y;
          float f3 = paramh.jAY;
          float[] arrayOfFloat = locala.Fh(paramh.mTime);
          if ((arrayOfFloat != null) && (arrayOfFloat[0] <= f1) && (f1 <= f3 + arrayOfFloat[2]) && (arrayOfFloat[1] <= f2) && (f2 <= arrayOfFloat[3])) {}
          for (int j = 1; j != 0; j = 0)
          {
            if (e.jBo >= 5) {
              e.v("Danmaku_R2LWindow", new Object[] { "onClick:", locala, "[left:", Float.valueOf(locala.getLeft()), ",top:", Float.valueOf(locala.getTop()), "]" });
            }
            AppMethodBeat.o(280728);
            return locala;
          }
        }
      }
      i += 1;
    }
    e.v("Danmaku_R2LWindow", "onClick:null");
    AppMethodBeat.o(280728);
    return null;
  }
  
  public final void ayA()
  {
    AppMethodBeat.i(280721);
    Object localObject = com.tencent.mm.danmaku.c.a.azC();
    this.jyY = ((m)localObject).jAa;
    int i;
    if ((this.jza == null) || (this.jyZ != ((m)localObject).jyZ))
    {
      this.jyZ = ((m)localObject).jyZ;
      this.jza = new int[this.jyZ];
      localObject = new com.tencent.mm.danmaku.b.a[this.jyZ];
      if (this.jzb != null) {
        System.arraycopy(this.jzb, 0, localObject, 0, Math.min(localObject.length, this.jzb.length));
      }
      this.jzb = ((com.tencent.mm.danmaku.b.a[])localObject);
      if (this.jzc != null)
      {
        i = this.jzc.size();
        if (i < this.jyZ) {
          while (i < this.jyZ)
          {
            this.jzc.add(new LinkedList());
            i += 1;
          }
        }
        i -= 1;
        while (i >= this.jyZ)
        {
          this.jzc.remove(i);
          i -= 1;
        }
      }
      this.jzc = new ArrayList(this.jyZ);
      i = 0;
      while (i < this.jyZ)
      {
        this.jzc.add(new LinkedList());
        i += 1;
      }
    }
    localObject = this.jxO;
    StringBuilder localStringBuilder1;
    int j;
    label265:
    StringBuilder localStringBuilder2;
    if (((com.tencent.mm.danmaku.c.a)localObject).jzR != null)
    {
      i = ((com.tencent.mm.danmaku.c.a)localObject).jzR.azI();
      localStringBuilder1 = new StringBuilder("[");
      j = 0;
      if (j >= this.jyZ) {
        break label350;
      }
      this.jza[j] = (j * i + this.jyY);
      localStringBuilder2 = localStringBuilder1.append(this.jza[j]);
      if (j == this.jyZ - 1) {
        break label343;
      }
    }
    label343:
    for (localObject = ", ";; localObject = "")
    {
      localStringBuilder2.append((String)localObject);
      j += 1;
      break label265;
      i = (int)Math.ceil(com.tencent.mm.danmaku.e.d.a(com.tencent.mm.danmaku.c.a.azC()));
      break;
    }
    label350:
    localStringBuilder1.append("]");
    e.d("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.jyZ), Integer.valueOf(this.jyY), Integer.valueOf(i), localStringBuilder1 });
    a(this.jzc, this.jza);
    a(this.jzc, this.jza);
    AppMethodBeat.o(280721);
  }
  
  public final void ayB()
  {
    int j = 0;
    AppMethodBeat.i(280727);
    int i = 0;
    while (i < this.jyZ)
    {
      this.jzb[i] = null;
      i += 1;
    }
    int k = this.jzc.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.jzc.get(i)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.danmaku.b.a locala = (com.tencent.mm.danmaku.b.a)localIterator.next();
        localIterator.remove();
        this.jxJ -= 1;
        this.jxL.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(280727);
  }
  
  public final void fP()
  {
    AppMethodBeat.i(280723);
    com.tencent.mm.danmaku.c.a.azC();
    if (e.jBo >= 5) {
      e.d("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.jxK.size()) });
    }
    Iterator localIterator = this.jxK.iterator();
    int j = 0;
    com.tencent.mm.danmaku.b.a locala;
    int i;
    label223:
    int k;
    int m;
    label362:
    int i1;
    if (localIterator.hasNext())
    {
      locala = (com.tencent.mm.danmaku.b.a)localIterator.next();
      localIterator.remove();
      Object localObject;
      if ((!locala.Fd(this.jxR.jAO)) && (!locala.Fc(this.jxQ.jAT)))
      {
        localObject = this.jzc.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (((List)((Iterator)localObject).next()).contains(locala)) {
            e.d("Danmaku_R2LWindow", new Object[] { locala, " is repeat" });
          }
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label223;
        }
        if (e.jBo >= 5) {
          e.d("Danmaku_R2LWindow", new Object[] { locala, " is out side" });
        }
        this.jxL.add(locala);
        break;
      }
      if (!locala.azl()) {
        h.a(this.jxO, locala);
      }
      i = locala.rt(this.jyZ);
      if (i >= 0)
      {
        k = i;
        m = 2147483647;
        if (i < 0) {
          break label362;
        }
      }
      for (int n = k + 1;; n = this.jyZ + k)
      {
        e.d("Danmaku_R2LWindow", "startLayout, startLine = " + k + ", maxLine = " + n + ", danmaku = " + locala);
        i = j;
        j = m;
        if (k >= n) {
          break label1035;
        }
        m = k;
        while (m >= this.jyZ) {
          m -= this.jyZ;
        }
        k = locala.rs(this.jyZ);
        break;
      }
      if (e.jBo >= 5)
      {
        e.d("Danmaku_R2LWindow", new Object[] { locala, " try layout" });
        i1 = 0;
        if (i1 < this.jyZ)
        {
          StringBuilder localStringBuilder = new StringBuilder("row ").append(i1);
          if (this.jzb[i1] == null) {}
          for (localObject = " null";; localObject = this.jzb[i1])
          {
            e.d("Danmaku_R2LWindow", localObject);
            i1 += 1;
            break;
          }
        }
      }
      if (this.jzb[m] == null)
      {
        this.jzb[m] = locala;
        ((List)this.jzc.get(m)).add(locala);
        this.jxJ += 1;
        a(locala, this.jza[m]);
        if (e.jBo >= 4) {
          e.d("Danmaku_R2LWindow", new Object[] { locala, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.jza[m]) });
        }
        k = 1;
      }
    }
    for (;;)
    {
      m = k;
      if (k == 0)
      {
        m = k;
        if (locala.rr(j))
        {
          this.jzb[i] = locala;
          ((List)this.jzc.get(i)).add(locala);
          this.jxJ += 1;
          a(locala, this.jza[i]);
          if (e.jBo >= 4) {
            e.d("Danmaku_R2LWindow", new Object[] { locala, " layout success:", Integer.valueOf(i), ",top:", this.jza[i] + ", danmakuRepeatTime = " + locala.azr() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.jxL.add(locala);
        if (e.jBo >= 4) {
          e.d("Danmaku_R2LWindow", new Object[] { locala, " can not in window" });
        }
      }
      j = i;
      if (!locala.azA()) {
        break;
      }
      j = i;
      if (m == 0) {
        break;
      }
      e.d("Danmaku_R2LWindow", "must show danmaku layout success :".concat(String.valueOf(locala)));
      j = i;
      break;
      if (!this.jzb[m].isPaused())
      {
        i1 = com.tencent.mm.danmaku.e.c.a(this.jzb[m], locala, this.jxR.jAO);
        if (i1 < j)
        {
          i = m;
          j = i1;
          label875:
          if (j < 0)
          {
            this.jzb[m] = locala;
            ((List)this.jzc.get(m)).add(locala);
            this.jxJ += 1;
            a(locala, this.jza[m]);
            if (e.jBo >= 4) {
              e.d("Danmaku_R2LWindow", new Object[] { locala, " layout success:", Integer.valueOf(m), ",top:", this.jza[m] + ", hitTime = " + j });
            }
            k = 1;
            continue;
          }
        }
      }
      for (;;)
      {
        k += 1;
        break;
        azh();
        AppMethodBeat.o(280723);
        return;
        break label875;
      }
      label1035:
      k = 0;
    }
  }
  
  public final void j(Canvas paramCanvas)
  {
    AppMethodBeat.i(280726);
    int j = this.jzc.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.jzc.get(i)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.danmaku.b.a locala = (com.tencent.mm.danmaku.b.a)localIterator.next();
        locala.x(this.jxR.jAP, this.jxR.jAO);
        if (!locala.Fe(this.jxR.jAO)) {
          a(paramCanvas, locala);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(280726);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.j
 * JD-Core Version:    0.7.0.1
 */