package com.google.b.a.a;

import com.google.b.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

final class f
{
  static final f ccs;
  private final g cct;
  final int ccu;
  final int ccv;
  final int mode;
  
  static
  {
    AppMethodBeat.i(12368);
    ccs = new f(g.ccw, 0, 0, 0);
    AppMethodBeat.o(12368);
  }
  
  private f(g paramg, int paramInt1, int paramInt2, int paramInt3)
  {
    this.cct = paramg;
    this.mode = paramInt1;
    this.ccu = paramInt2;
    this.ccv = paramInt3;
  }
  
  final a J(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(12366);
    Object localObject2 = new LinkedList();
    for (Object localObject1 = he(paramArrayOfByte.length).cct; localObject1 != null; localObject1 = ((g)localObject1).ccx) {
      ((Deque)localObject2).addFirst(localObject1);
    }
    localObject1 = new a();
    localObject2 = ((Deque)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((g)((Iterator)localObject2).next()).a((a)localObject1, paramArrayOfByte);
    }
    AppMethodBeat.o(12366);
    return localObject1;
  }
  
  final boolean a(f paramf)
  {
    int j = this.ccv + (d.ccm[this.mode][paramf.mode] >> 16);
    int i = j;
    if (paramf.ccu > 0) {
      if (this.ccu != 0)
      {
        i = j;
        if (this.ccu <= paramf.ccu) {}
      }
      else
      {
        i = j + 10;
      }
    }
    return i <= paramf.ccv;
  }
  
  final f bD(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12362);
    int i = this.ccv;
    Object localObject = this.cct;
    int j;
    if (paramInt1 != this.mode)
    {
      j = d.ccm[this.mode][paramInt1];
      localObject = ((g)localObject).bF(0xFFFF & j, j >> 16);
      i += (j >> 16);
    }
    for (;;)
    {
      if (paramInt1 == 2) {}
      for (j = 4;; j = 5)
      {
        localObject = new f(((g)localObject).bF(paramInt2, j), paramInt1, 0, j + i);
        AppMethodBeat.o(12362);
        return localObject;
      }
    }
  }
  
  final f bE(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(12363);
    Object localObject = this.cct;
    if (this.mode == 2) {}
    for (int i = 4;; i = 5)
    {
      localObject = new f(((g)localObject).bF(d.cco[this.mode][paramInt1], i).bF(paramInt2, 5), this.mode, 0, i + this.ccv + 5);
      AppMethodBeat.o(12363);
      return localObject;
    }
  }
  
  final f hd(int paramInt)
  {
    AppMethodBeat.i(12364);
    g localg = this.cct;
    int m = this.mode;
    int i = this.ccv;
    int k;
    int j;
    Object localObject;
    if (this.mode != 4)
    {
      k = i;
      j = m;
      localObject = localg;
      if (this.mode != 2) {}
    }
    else
    {
      j = d.ccm[m][0];
      localObject = localg.bF(0xFFFF & j, j >> 16);
      k = i + (j >> 16);
      j = 0;
    }
    if ((this.ccu == 0) || (this.ccu == 31))
    {
      i = 18;
      localObject = new f((g)localObject, j, this.ccu + 1, k + i);
      if (((f)localObject).ccu != 2078) {
        break label175;
      }
      localObject = ((f)localObject).he(paramInt + 1);
    }
    label175:
    for (;;)
    {
      AppMethodBeat.o(12364);
      return localObject;
      if (this.ccu == 62)
      {
        i = 9;
        break;
      }
      i = 8;
      break;
    }
  }
  
  final f he(int paramInt)
  {
    AppMethodBeat.i(12365);
    if (this.ccu == 0)
    {
      AppMethodBeat.o(12365);
      return this;
    }
    f localf = new f(this.cct.bG(paramInt - this.ccu, this.ccu), this.mode, 0, this.ccv);
    AppMethodBeat.o(12365);
    return localf;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(12367);
    String str = String.format("%s bits=%d bytes=%d", new Object[] { d.ccl[this.mode], Integer.valueOf(this.ccv), Integer.valueOf(this.ccu) });
    AppMethodBeat.o(12367);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */