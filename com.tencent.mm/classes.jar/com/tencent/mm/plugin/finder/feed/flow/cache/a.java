package com.tencent.mm.plugin.finder.feed.flow.cache;

import android.graphics.Point;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
{
  final int Bdg;
  public int Bdh;
  public SparseArray<Point> Bdi;
  public SparseArray<b> Bdj;
  public boolean Bdk;
  
  public a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(363585);
    this.Bdk = false;
    this.Bdg = paramInt1;
    this.Bdh = paramInt2;
    this.Bdi = new SparseArray();
    this.Bdj = new SparseArray();
    AppMethodBeat.o(363585);
  }
  
  private b NU(int paramInt)
  {
    AppMethodBeat.i(363592);
    if (!boj())
    {
      AppMethodBeat.o(363592);
      return null;
    }
    b localb = NW(NT(paramInt));
    AppMethodBeat.o(363592);
    return localb;
  }
  
  private static void a(b paramb, Point paramPoint, int paramInt)
  {
    paramb.bUo += 1;
    paramb.Bdl += paramPoint.x;
    if (paramPoint.y > paramb.maxHeight) {}
    for (int i = paramPoint.y;; i = paramb.maxHeight)
    {
      paramb.maxHeight = i;
      if (paramPoint.y == paramb.maxHeight) {
        paramb.Bdm = paramInt;
      }
      return;
    }
  }
  
  private int edt()
  {
    AppMethodBeat.i(363602);
    int i = 0;
    int j = 0;
    while (i < this.Bdj.size())
    {
      j += ((b)this.Bdj.get(i)).bUo;
      i += 1;
    }
    if (j >= this.Bdi.size())
    {
      AppMethodBeat.o(363602);
      return -1;
    }
    AppMethodBeat.o(363602);
    return j;
  }
  
  public final int NT(int paramInt)
  {
    AppMethodBeat.i(363622);
    if (!boj())
    {
      AppMethodBeat.o(363622);
      return -1;
    }
    int i = 0;
    int j = 0;
    while (i < this.Bdj.size())
    {
      j += ((b)this.Bdj.get(i)).bUo;
      if (j >= paramInt + 1)
      {
        AppMethodBeat.o(363622);
        return i;
      }
      i += 1;
    }
    AppMethodBeat.o(363622);
    return -1;
  }
  
  public final int NV(int paramInt)
  {
    AppMethodBeat.i(363627);
    if (!boj())
    {
      AppMethodBeat.o(363627);
      return -1;
    }
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      j += ((b)this.Bdj.get(i)).bUo;
      i += 1;
    }
    AppMethodBeat.o(363627);
    return j;
  }
  
  public final b NW(int paramInt)
  {
    AppMethodBeat.i(363632);
    if (!boj())
    {
      AppMethodBeat.o(363632);
      return null;
    }
    b localb = (b)this.Bdj.get(paramInt, null);
    AppMethodBeat.o(363632);
    return localb;
  }
  
  public final void NX(int paramInt)
  {
    AppMethodBeat.i(363640);
    this.Bdh = paramInt;
    this.Bdj.clear();
    eds();
    AppMethodBeat.o(363640);
  }
  
  public final void NY(int paramInt)
  {
    AppMethodBeat.i(363670);
    if (this.Bdk)
    {
      AppMethodBeat.o(363670);
      return;
    }
    int i = NT(paramInt);
    b localb2 = (b)this.Bdj.get(i, null);
    b localb1 = localb2;
    paramInt = i;
    if (localb2 == null)
    {
      localb1 = localb2;
      paramInt = i;
      if (this.Bdj.size() > 0)
      {
        this.Bdj.remove(this.Bdj.size() - 1);
        paramInt = i;
      }
    }
    for (localb1 = localb2; localb1 != null; localb1 = (b)this.Bdj.get(paramInt, null))
    {
      this.Bdj.remove(paramInt);
      paramInt += 1;
    }
    AppMethodBeat.o(363670);
  }
  
  public final void a(int paramInt, Point paramPoint)
  {
    AppMethodBeat.i(363617);
    if (!boj())
    {
      AppMethodBeat.o(363617);
      return;
    }
    if (this.Bdi.get(paramInt, null) != null)
    {
      if (!((Point)this.Bdi.get(paramInt)).equals(paramPoint))
      {
        NY(paramInt);
        this.Bdi.put(paramInt, paramPoint);
        eds();
      }
      AppMethodBeat.o(363617);
      return;
    }
    NY(paramInt);
    this.Bdi.put(paramInt, paramPoint);
    eds();
    AppMethodBeat.o(363617);
  }
  
  public final boolean boj()
  {
    return this.Bdh > 0;
  }
  
  public final void eds()
  {
    AppMethodBeat.i(363654);
    if ((!boj()) || (this.Bdk))
    {
      AppMethodBeat.o(363654);
      return;
    }
    int m = edt();
    Point localPoint = (Point)this.Bdi.get(m, null);
    int i = this.Bdj.size();
    int j = 0;
    b localb = NU(m);
    int n;
    int k;
    if (localb == null)
    {
      localb = new b();
      n = localb.Bdl;
      k = i;
      i = j;
      j = n;
      label92:
      if (localPoint == null) {
        break label297;
      }
      j = localPoint.x + j;
      n = i + 1;
      if (j > this.Bdh) {
        break label254;
      }
      if (this.Bdg <= 0) {
        break label237;
      }
      if (n <= this.Bdg) {
        break label220;
      }
      this.Bdj.put(k, localb);
      localb = new b();
      a(localb, localPoint, m);
      i = localPoint.x;
      j = 1;
      k += 1;
    }
    for (;;)
    {
      n = m + 1;
      localPoint = (Point)this.Bdi.get(n, null);
      m = j;
      j = i;
      i = m;
      m = n;
      break label92;
      i = NT(m);
      break;
      label220:
      a(localb, localPoint, m);
      i = j;
      j = n;
      continue;
      label237:
      a(localb, localPoint, m);
      i = j;
      j = n;
      continue;
      label254:
      this.Bdj.put(k, localb);
      localb = new b();
      a(localb, localPoint, m);
      i = localPoint.x;
      j = 1;
      k += 1;
    }
    label297:
    if (localb.bUo > 0) {
      this.Bdj.append(k, localb);
    }
    AppMethodBeat.o(363654);
  }
  
  public final void hw(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(363609);
    if (!boj())
    {
      AppMethodBeat.o(363609);
      return;
    }
    NY(paramInt1);
    int i = hx(paramInt1, paramInt2);
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      this.Bdi.remove(paramInt1 + paramInt2);
      paramInt2 += 1;
    }
    eds();
    AppMethodBeat.o(363609);
  }
  
  public final int hx(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(363663);
    if (paramInt1 + paramInt2 > this.Bdi.size())
    {
      paramInt2 = this.Bdi.size();
      AppMethodBeat.o(363663);
      return paramInt2 - paramInt1;
    }
    AppMethodBeat.o(363663);
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.flow.cache.a
 * JD-Core Version:    0.7.0.1
 */