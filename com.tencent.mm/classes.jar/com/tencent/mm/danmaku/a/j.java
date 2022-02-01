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
  protected int gOE;
  private int gOF;
  private int[] gOG;
  private com.tencent.mm.danmaku.b.a[] gOH;
  private List<List<com.tencent.mm.danmaku.b.a>> gOI;
  
  protected j(com.tencent.mm.danmaku.c.a parama, b paramb, Comparator<com.tencent.mm.danmaku.b.a> paramComparator, f paramf, com.tencent.mm.danmaku.d.c paramc)
  {
    super(parama, paramb, paramComparator, paramf, paramc);
  }
  
  private void a(com.tencent.mm.danmaku.b.a parama, int paramInt)
  {
    AppMethodBeat.i(241672);
    parama.asI();
    parama.a(paramInt, this.gNv.gQA, this.gNw.gQv);
    AppMethodBeat.o(241672);
  }
  
  private void a(List<List<com.tencent.mm.danmaku.b.a>> paramList, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(241670);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)paramList.get(i)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.danmaku.b.d locald = (com.tencent.mm.danmaku.b.d)localIterator.next();
        locald.asu();
        long l = this.gNw.gQv;
        int k = (int)locald.mLeft;
        b(locald);
        locald.ze(l - (int)((com.tencent.mm.danmaku.b.d.getScreenWidth() - k) / --locald.gPj));
        locald.mTop = paramArrayOfInt[i];
        locald.mLeft = k;
      }
      i += 1;
    }
    AppMethodBeat.o(241670);
  }
  
  private void ast()
  {
    AppMethodBeat.i(241673);
    int j = this.gOI.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.gOI.get(i)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.danmaku.b.a locala = (com.tencent.mm.danmaku.b.a)localIterator.next();
        if ((locala.yZ(this.gNw.gQv)) || (!locala.isShown()))
        {
          if (locala == this.gOH[i]) {
            this.gOH[i] = null;
          }
          localIterator.remove();
          this.gNo -= 1;
          this.gNq.add(locala);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(241673);
  }
  
  public final com.tencent.mm.danmaku.b.a a(com.tencent.mm.danmaku.d.h paramh)
  {
    AppMethodBeat.i(241676);
    int k = this.gOI.size();
    int i = 0;
    while (i < k)
    {
      Iterator localIterator = ((List)this.gOI.get(i)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.danmaku.b.a locala = (com.tencent.mm.danmaku.b.a)localIterator.next();
        if (com.tencent.mm.danmaku.b.a.asF())
        {
          float f1 = paramh.mPoint.x;
          float f2 = paramh.mPoint.y;
          float f3 = paramh.gQF;
          float[] arrayOfFloat = locala.zd(paramh.mTime);
          if ((arrayOfFloat != null) && (arrayOfFloat[0] <= f1) && (f1 <= f3 + arrayOfFloat[2]) && (arrayOfFloat[1] <= f2) && (f2 <= arrayOfFloat[3])) {}
          for (int j = 1; j != 0; j = 0)
          {
            if (e.gQV >= 5) {
              e.v("Danmaku_R2LWindow", new Object[] { "onClick:", locala, "[left:", Float.valueOf(locala.getLeft()), ",top:", Float.valueOf(locala.getTop()), "]" });
            }
            AppMethodBeat.o(241676);
            return locala;
          }
        }
      }
      i += 1;
    }
    e.v("Danmaku_R2LWindow", "onClick:null");
    AppMethodBeat.o(241676);
    return null;
  }
  
  public final void arP()
  {
    AppMethodBeat.i(241669);
    Object localObject = com.tencent.mm.danmaku.c.a.asO();
    this.gOE = ((m)localObject).gPH;
    int i;
    if ((this.gOG == null) || (this.gOF != ((m)localObject).gOF))
    {
      this.gOF = ((m)localObject).gOF;
      this.gOG = new int[this.gOF];
      localObject = new com.tencent.mm.danmaku.b.a[this.gOF];
      if (this.gOH != null) {
        System.arraycopy(this.gOH, 0, localObject, 0, Math.min(localObject.length, this.gOH.length));
      }
      this.gOH = ((com.tencent.mm.danmaku.b.a[])localObject);
      if (this.gOI != null)
      {
        i = this.gOI.size();
        if (i < this.gOF) {
          while (i < this.gOF)
          {
            this.gOI.add(new LinkedList());
            i += 1;
          }
        }
        i -= 1;
        while (i >= this.gOF)
        {
          this.gOI.remove(i);
          i -= 1;
        }
      }
      this.gOI = new ArrayList(this.gOF);
      i = 0;
      while (i < this.gOF)
      {
        this.gOI.add(new LinkedList());
        i += 1;
      }
    }
    localObject = this.gNt;
    StringBuilder localStringBuilder1;
    int j;
    label265:
    StringBuilder localStringBuilder2;
    if (((com.tencent.mm.danmaku.c.a)localObject).gPy != null)
    {
      i = ((com.tencent.mm.danmaku.c.a)localObject).gPy.asU();
      localStringBuilder1 = new StringBuilder("[");
      j = 0;
      if (j >= this.gOF) {
        break label350;
      }
      this.gOG[j] = (j * i + this.gOE);
      localStringBuilder2 = localStringBuilder1.append(this.gOG[j]);
      if (j == this.gOF - 1) {
        break label343;
      }
    }
    label343:
    for (localObject = ", ";; localObject = "")
    {
      localStringBuilder2.append((String)localObject);
      j += 1;
      break label265;
      i = (int)Math.ceil(com.tencent.mm.danmaku.e.d.a(com.tencent.mm.danmaku.c.a.asO()));
      break;
    }
    label350:
    localStringBuilder1.append("]");
    e.d("Danmaku_R2LWindow", new Object[] { "reloadConfig, mRowCount = %d, mMarginTop = %d, lineHeight = %d, lineTops = %s", Integer.valueOf(this.gOF), Integer.valueOf(this.gOE), Integer.valueOf(i), localStringBuilder1 });
    a(this.gOI, this.gOG);
    a(this.gOI, this.gOG);
    AppMethodBeat.o(241669);
  }
  
  public final void arQ()
  {
    int j = 0;
    AppMethodBeat.i(241675);
    int i = 0;
    while (i < this.gOF)
    {
      this.gOH[i] = null;
      i += 1;
    }
    int k = this.gOI.size();
    i = j;
    while (i < k)
    {
      Iterator localIterator = ((List)this.gOI.get(i)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.danmaku.b.a locala = (com.tencent.mm.danmaku.b.a)localIterator.next();
        localIterator.remove();
        this.gNo -= 1;
        this.gNq.add(locala);
      }
      i += 1;
    }
    AppMethodBeat.o(241675);
  }
  
  public final void i(Canvas paramCanvas)
  {
    AppMethodBeat.i(241674);
    int j = this.gOI.size();
    int i = 0;
    while (i < j)
    {
      Iterator localIterator = ((List)this.gOI.get(i)).iterator();
      while (localIterator.hasNext())
      {
        com.tencent.mm.danmaku.b.a locala = (com.tencent.mm.danmaku.b.a)localIterator.next();
        locala.x(this.gNw.gQw, this.gNw.gQv);
        if (!locala.za(this.gNw.gQv)) {
          a(paramCanvas, locala);
        }
      }
      i += 1;
    }
    AppMethodBeat.o(241674);
  }
  
  public final void layout()
  {
    AppMethodBeat.i(241671);
    com.tencent.mm.danmaku.c.a.asO();
    if (e.gQV >= 5) {
      e.d("Danmaku_R2LWindow", new Object[] { Integer.valueOf(this.gNp.size()) });
    }
    Iterator localIterator = this.gNp.iterator();
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
      if ((!locala.yZ(this.gNw.gQv)) && (!locala.yY(this.gNv.gQA)))
      {
        localObject = this.gOI.iterator();
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
        if (e.gQV >= 5) {
          e.d("Danmaku_R2LWindow", new Object[] { locala, " is out side" });
        }
        this.gNq.add(locala);
        break;
      }
      if (!locala.asx()) {
        h.a(this.gNt, locala);
      }
      i = locala.oY(this.gOF);
      if (i >= 0)
      {
        k = i;
        m = 2147483647;
        if (i < 0) {
          break label362;
        }
      }
      for (int n = k + 1;; n = this.gOF + k)
      {
        e.d("Danmaku_R2LWindow", "startLayout, startLine = " + k + ", maxLine = " + n + ", danmaku = " + locala);
        i = j;
        j = m;
        if (k >= n) {
          break label1035;
        }
        m = k;
        while (m >= this.gOF) {
          m -= this.gOF;
        }
        k = locala.oX(this.gOF);
        break;
      }
      if (e.gQV >= 5)
      {
        e.d("Danmaku_R2LWindow", new Object[] { locala, " try layout" });
        i1 = 0;
        if (i1 < this.gOF)
        {
          StringBuilder localStringBuilder = new StringBuilder("row ").append(i1);
          if (this.gOH[i1] == null) {}
          for (localObject = " null";; localObject = this.gOH[i1])
          {
            e.d("Danmaku_R2LWindow", localObject);
            i1 += 1;
            break;
          }
        }
      }
      if (this.gOH[m] == null)
      {
        this.gOH[m] = locala;
        ((List)this.gOI.get(m)).add(locala);
        this.gNo += 1;
        a(locala, this.gOG[m]);
        if (e.gQV >= 4) {
          e.d("Danmaku_R2LWindow", new Object[] { locala, " layout success:", Integer.valueOf(m), ",top:", Integer.valueOf(this.gOG[m]) });
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
        if (locala.oW(j))
        {
          this.gOH[i] = locala;
          ((List)this.gOI.get(i)).add(locala);
          this.gNo += 1;
          a(locala, this.gOG[i]);
          if (e.gQV >= 4) {
            e.d("Danmaku_R2LWindow", new Object[] { locala, " layout success:", Integer.valueOf(i), ",top:", this.gOG[i] + ", danmakuRepeatTime = " + locala.asD() });
          }
          m = 1;
        }
      }
      if (m == 0)
      {
        this.gNq.add(locala);
        if (e.gQV >= 4) {
          e.d("Danmaku_R2LWindow", new Object[] { locala, " can not in window" });
        }
      }
      j = i;
      if (!locala.asM()) {
        break;
      }
      j = i;
      if (m == 0) {
        break;
      }
      e.d("Danmaku_R2LWindow", "must show danmaku layout success :".concat(String.valueOf(locala)));
      j = i;
      break;
      if (!this.gOH[m].isPaused())
      {
        i1 = com.tencent.mm.danmaku.e.c.a(this.gOH[m], locala, this.gNw.gQv);
        if (i1 < j)
        {
          i = m;
          j = i1;
          label875:
          if (j < 0)
          {
            this.gOH[m] = locala;
            ((List)this.gOI.get(m)).add(locala);
            this.gNo += 1;
            a(locala, this.gOG[m]);
            if (e.gQV >= 4) {
              e.d("Danmaku_R2LWindow", new Object[] { locala, " layout success:", Integer.valueOf(m), ",top:", this.gOG[m] + ", hitTime = " + j });
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
        ast();
        AppMethodBeat.o(241671);
        return;
        break label875;
      }
      label1035:
      k = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.danmaku.a.j
 * JD-Core Version:    0.7.0.1
 */