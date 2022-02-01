package com.google.android.exoplayer2.source.c;

import android.util.Base64;
import com.google.android.exoplayer2.c.d.k;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.source.a.g;
import com.google.android.exoplayer2.source.c.a.a;
import com.google.android.exoplayer2.source.c.a.a.b;
import com.google.android.exoplayer2.source.e;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.i.a;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.source.n.a;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.source.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class c
  implements i, n.a<com.google.android.exoplayer2.source.a.f<b>>
{
  private final q aRd;
  private final k[] bbN;
  private final int bkJ;
  private final com.google.android.exoplayer2.h.b bkM;
  private i.a bkx;
  private final com.google.android.exoplayer2.source.a.a bmE;
  private final u bmW;
  com.google.android.exoplayer2.source.a.f<b>[] bmY;
  private e bmZ;
  private a brg;
  private final b.a bri;
  
  public c(a parama, b.a parama1, int paramInt, com.google.android.exoplayer2.source.a.a parama2, u paramu, com.google.android.exoplayer2.h.b paramb)
  {
    AppMethodBeat.i(90005);
    this.bri = parama1;
    this.bmW = paramu;
    this.bkJ = paramInt;
    this.bmE = parama2;
    this.bkM = paramb;
    this.aRd = b(parama);
    parama1 = parama.bro;
    if (parama1 != null) {}
    for (this.bbN = new k[] { new k(true, null, 8, u(parama1.data), 0, 0, null) };; this.bbN = null)
    {
      this.brg = parama;
      this.bmY = new com.google.android.exoplayer2.source.a.f[0];
      this.bmZ = new e(this.bmY);
      AppMethodBeat.o(90005);
      return;
    }
  }
  
  private static q b(a parama)
  {
    AppMethodBeat.i(90013);
    p[] arrayOfp = new p[parama.brp.length];
    int i = 0;
    while (i < parama.brp.length)
    {
      arrayOfp[i] = new p(parama.brp[i].blC);
      i += 1;
    }
    parama = new q(arrayOfp);
    AppMethodBeat.o(90013);
    return parama;
  }
  
  private static void j(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramArrayOfByte[paramInt1];
    paramArrayOfByte[paramInt1] = paramArrayOfByte[paramInt2];
    paramArrayOfByte[paramInt2] = i;
  }
  
  private static byte[] u(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90014);
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append((char)paramArrayOfByte[i]);
      i += 2;
    }
    paramArrayOfByte = localStringBuilder.toString();
    paramArrayOfByte = Base64.decode(paramArrayOfByte.substring(paramArrayOfByte.indexOf("<KID>") + 5, paramArrayOfByte.indexOf("</KID>")), 0);
    j(paramArrayOfByte, 0, 3);
    j(paramArrayOfByte, 1, 2);
    j(paramArrayOfByte, 4, 5);
    j(paramArrayOfByte, 6, 7);
    AppMethodBeat.o(90014);
    return paramArrayOfByte;
  }
  
  public final void U(long paramLong) {}
  
  public final long V(long paramLong)
  {
    AppMethodBeat.i(90012);
    com.google.android.exoplayer2.source.a.f[] arrayOff = this.bmY;
    int j = arrayOff.length;
    int i = 0;
    while (i < j)
    {
      arrayOff[i].af(paramLong);
      i += 1;
    }
    AppMethodBeat.o(90012);
    return paramLong;
  }
  
  public final boolean W(long paramLong)
  {
    AppMethodBeat.i(90009);
    boolean bool = this.bmZ.W(paramLong);
    AppMethodBeat.o(90009);
    return bool;
  }
  
  public final long a(com.google.android.exoplayer2.g.f[] paramArrayOff, boolean[] paramArrayOfBoolean1, m[] paramArrayOfm, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    AppMethodBeat.i(90008);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramArrayOff.length)
    {
      Object localObject;
      if (paramArrayOfm[i] != null)
      {
        localObject = (com.google.android.exoplayer2.source.a.f)paramArrayOfm[i];
        if ((paramArrayOff[i] != null) && (paramArrayOfBoolean1[i] != 0)) {
          break label196;
        }
        ((com.google.android.exoplayer2.source.a.f)localObject).release();
        paramArrayOfm[i] = null;
      }
      for (;;)
      {
        if ((paramArrayOfm[i] == null) && (paramArrayOff[i] != null))
        {
          localObject = paramArrayOff[i];
          int j = this.aRd.a(((com.google.android.exoplayer2.g.f)localObject).va());
          localObject = this.bri.a(this.bmW, this.brg, j, (com.google.android.exoplayer2.g.f)localObject, this.bbN);
          localObject = new com.google.android.exoplayer2.source.a.f(this.brg.brp[j].type, null, (g)localObject, this, this.bkM, paramLong, this.bkJ, this.bmE);
          localArrayList.add(localObject);
          paramArrayOfm[i] = localObject;
          paramArrayOfBoolean2[i] = true;
        }
        i += 1;
        break;
        label196:
        localArrayList.add(localObject);
      }
    }
    this.bmY = new com.google.android.exoplayer2.source.a.f[localArrayList.size()];
    localArrayList.toArray(this.bmY);
    this.bmZ = new e(this.bmY);
    AppMethodBeat.o(90008);
    return paramLong;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(90006);
    this.brg = parama;
    com.google.android.exoplayer2.source.a.f[] arrayOff = this.bmY;
    int j = arrayOff.length;
    int i = 0;
    while (i < j)
    {
      ((b)arrayOff[i].bmC).a(parama);
      i += 1;
    }
    this.bkx.a(this);
    AppMethodBeat.o(90006);
  }
  
  public final void a(i.a parama, long paramLong)
  {
    AppMethodBeat.i(90007);
    this.bkx = parama;
    parama.a(this);
    AppMethodBeat.o(90007);
  }
  
  public final void tA() {}
  
  public final q tB()
  {
    return this.aRd;
  }
  
  public final long tC()
  {
    return -9223372036854775807L;
  }
  
  public final long tD()
  {
    AppMethodBeat.i(90011);
    long l = this.bmZ.tD();
    AppMethodBeat.o(90011);
    return l;
  }
  
  public final long tE()
  {
    AppMethodBeat.i(90010);
    long l = this.bmZ.tE();
    AppMethodBeat.o(90010);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.c
 * JD-Core Version:    0.7.0.1
 */