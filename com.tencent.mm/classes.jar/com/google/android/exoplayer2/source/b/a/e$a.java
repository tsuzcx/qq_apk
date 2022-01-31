package com.google.android.exoplayer2.source.b.a;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.h.r;
import com.google.android.exoplayer2.h.r.a;
import com.google.android.exoplayer2.source.b.d;
import java.io.IOException;
import java.util.IdentityHashMap;
import java.util.List;

public final class e$a
  implements r.a<com.google.android.exoplayer2.h.s<c>>, Runnable
{
  private final a.a aLX;
  public final r aLY;
  private final com.google.android.exoplayer2.h.s<c> aLZ;
  public b aMa;
  public long aMb;
  private long aMc;
  private long aMd;
  private long aMe;
  private boolean aMf;
  IOException aMg;
  
  public e$a(e parame, a.a parama)
  {
    this.aLX = parama;
    this.aLY = new r("HlsPlaylistTracker:MediaPlaylist");
    this.aLZ = new com.google.android.exoplayer2.h.s(parame.aKd.mU(), com.google.android.exoplayer2.i.s.l(parame.aJI.aLm, parama.url), parame.aKn);
  }
  
  private void b(b paramb)
  {
    b localb = this.aMa;
    long l3 = SystemClock.elapsedRealtime();
    this.aMb = l3;
    Object localObject1 = this.aMh;
    int i;
    label65:
    Object localObject2;
    if ((localb == null) || (paramb.aKZ > localb.aKZ))
    {
      i = 1;
      if (i != 0) {
        break label358;
      }
      if (!paramb.aLc) {
        break label351;
      }
      if (!localb.aLc) {
        break label268;
      }
      localObject1 = localb;
      this.aMa = ((b)localObject1);
      if (this.aMa == localb) {
        break label630;
      }
      this.aMg = null;
      this.aMc = l3;
      paramb = this.aMh;
      localObject1 = this.aLX;
      localObject2 = this.aMa;
      if (localObject1 == paramb.aLU) {
        if (paramb.aLV == null) {
          if (((b)localObject2).aLc) {
            break label624;
          }
        }
      }
    }
    label268:
    label351:
    label358:
    label624:
    for (boolean bool = true;; bool = false)
    {
      paramb.aLW = bool;
      paramb.aLV = ((b)localObject2);
      paramb.aLR.a((b)localObject2);
      int j = paramb.aLS.size();
      i = 0;
      while (i < j)
      {
        ((e.b)paramb.aLS.get(i)).mZ();
        i += 1;
      }
      if (paramb.aKZ >= localb.aKZ)
      {
        i = paramb.aLf.size();
        j = localb.aLf.size();
        if ((i > j) || ((i == j) && (paramb.aLc) && (!localb.aLc)))
        {
          i = 1;
          break;
        }
      }
      i = 0;
      break;
      localObject1 = new b(localb.aKV, localb.aLm, localb.aLn, localb.aKW, localb.aJe, localb.aKX, localb.aKY, localb.aKZ, localb.version, localb.aLa, localb.aLb, true, localb.aLd, localb.aLe, localb.aLf);
      break label65;
      localObject1 = localb;
      break label65;
      if (paramb.aLd) {
        l1 = paramb.aJe;
      }
      for (;;)
      {
        if (!paramb.aKX) {
          break label548;
        }
        i = paramb.aKY;
        localObject1 = new b(paramb.aKV, paramb.aLm, paramb.aLn, paramb.aKW, l1, true, i, paramb.aKZ, paramb.version, paramb.aLa, paramb.aLb, paramb.aLc, paramb.aLd, paramb.aLe, paramb.aLf);
        break;
        if (((e)localObject1).aLV != null) {}
        for (long l2 = ((e)localObject1).aLV.aJe;; l2 = 0L)
        {
          l1 = l2;
          if (localb == null) {
            break;
          }
          i = localb.aLf.size();
          localObject2 = e.a(localb, paramb);
          if (localObject2 == null) {
            break label520;
          }
          l1 = localb.aJe + ((b.a)localObject2).aLh;
          break;
        }
        l1 = l2;
        if (i == paramb.aKZ - localb.aKZ) {
          l1 = localb.ng();
        }
      }
      if (((e)localObject1).aLV != null) {}
      for (j = ((e)localObject1).aLV.aKY;; j = 0)
      {
        i = j;
        if (localb == null) {
          break;
        }
        localObject1 = e.a(localb, paramb);
        i = j;
        if (localObject1 == null) {
          break;
        }
        i = localb.aKY + ((b.a)localObject1).aLg - ((b.a)paramb.aLf.get(0)).aLg;
        break;
      }
    }
    label520:
    label548:
    label630:
    if (!this.aMa.aLc)
    {
      if (paramb.aKZ + paramb.aLf.size() < this.aMa.aKZ) {
        this.aMg = new e.c(this.aLX.url, (byte)0);
      }
    }
    else {
      if (this.aMa == localb) {
        break label796;
      }
    }
    label796:
    for (long l1 = this.aMa.aLa;; l1 = this.aMa.aLa / 2L)
    {
      this.aMd = (com.google.android.exoplayer2.b.q(l1) + l3);
      if ((this.aLX == this.aMh.aLU) && (!this.aMa.aLc)) {
        nh();
      }
      return;
      if (l3 - this.aMc <= com.google.android.exoplayer2.b.q(this.aMa.aLa) * 3.5D) {
        break;
      }
      this.aMg = new e.d(this.aLX.url, (byte)0);
      nj();
      break;
    }
  }
  
  private void ni()
  {
    this.aLY.a(this.aLZ, this, this.aMh.aLO);
  }
  
  private boolean nj()
  {
    this.aMe = (SystemClock.elapsedRealtime() + 60000L);
    e locale = this.aMh;
    Object localObject = this.aLX;
    int j = locale.aLS.size();
    int i = 0;
    while (i < j)
    {
      ((e.b)locale.aLS.get(i)).b((a.a)localObject);
      i += 1;
    }
    if (this.aMh.aLU == this.aLX)
    {
      locale = this.aMh;
      localObject = locale.aJI.aKS;
      j = ((List)localObject).size();
      long l = SystemClock.elapsedRealtime();
      i = 0;
      if (i < j)
      {
        a locala = (a)locale.aLP.get(((List)localObject).get(i));
        if (l > locala.aMe)
        {
          locale.aLU = locala.aLX;
          locala.nh();
        }
      }
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label184;
        }
        return true;
        i += 1;
        break;
      }
    }
    label184:
    return false;
  }
  
  public final void nh()
  {
    this.aMe = 0L;
    if ((this.aMf) || (this.aLY.isLoading())) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l < this.aMd)
    {
      this.aMf = true;
      this.aMh.aLQ.postDelayed(this, this.aMd - l);
      return;
    }
    ni();
  }
  
  public final void run()
  {
    this.aMf = false;
    ni();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.e.a
 * JD-Core Version:    0.7.0.1
 */