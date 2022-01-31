package com.google.android.exoplayer2.source.b.a;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.i.w;
import com.google.android.exoplayer2.source.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.List;

public final class e$a
  implements t.a<u<c>>, Runnable
{
  private IOException aTA;
  private final a.a aTr;
  public final t aTs;
  private final u<c> aTt;
  public b aTu;
  public long aTv;
  private long aTw;
  private long aTx;
  private long aTy;
  private boolean aTz;
  
  public e$a(e parame, a.a parama)
  {
    AppMethodBeat.i(125980);
    this.aTr = parama;
    this.aTs = new t("HlsPlaylistTracker:MediaPlaylist");
    this.aTt = new u(parame.aRI.pu(), w.m(parame.aRo.aSG, parama.url), parame.aRR);
    AppMethodBeat.o(125980);
  }
  
  private void b(b paramb)
  {
    AppMethodBeat.i(125984);
    b localb = this.aTu;
    long l3 = SystemClock.elapsedRealtime();
    this.aTv = l3;
    Object localObject1 = this.aTB;
    int i;
    label70:
    Object localObject2;
    if ((localb == null) || (paramb.aSt > localb.aSt))
    {
      i = 1;
      if (i != 0) {
        break label363;
      }
      if (!paramb.aSw) {
        break label356;
      }
      if (!localb.aSw) {
        break label273;
      }
      localObject1 = localb;
      this.aTu = ((b)localObject1);
      if (this.aTu == localb) {
        break label635;
      }
      this.aTA = null;
      this.aTw = l3;
      paramb = this.aTB;
      localObject1 = this.aTr;
      localObject2 = this.aTu;
      if (localObject1 == paramb.aTo) {
        if (paramb.aTp == null) {
          if (((b)localObject2).aSw) {
            break label629;
          }
        }
      }
    }
    label273:
    label356:
    label363:
    label629:
    for (boolean bool = true;; bool = false)
    {
      paramb.aTq = bool;
      paramb.aTp = ((b)localObject2);
      paramb.aTl.a((b)localObject2);
      int j = paramb.aTm.size();
      i = 0;
      while (i < j)
      {
        ((e.b)paramb.aTm.get(i)).py();
        i += 1;
      }
      if (paramb.aSt >= localb.aSt)
      {
        i = paramb.aSz.size();
        j = localb.aSz.size();
        if ((i > j) || ((i == j) && (paramb.aSw) && (!localb.aSw)))
        {
          i = 1;
          break;
        }
      }
      i = 0;
      break;
      localObject1 = new b(localb.aSp, localb.aSG, localb.aSH, localb.aSq, localb.aQM, localb.aSr, localb.aSs, localb.aSt, localb.version, localb.aSu, localb.aSv, true, localb.aSx, localb.aSy, localb.aSz);
      break label70;
      localObject1 = localb;
      break label70;
      if (paramb.aSx) {
        l1 = paramb.aQM;
      }
      for (;;)
      {
        if (!paramb.aSr) {
          break label553;
        }
        i = paramb.aSs;
        localObject1 = new b(paramb.aSp, paramb.aSG, paramb.aSH, paramb.aSq, l1, true, i, paramb.aSt, paramb.version, paramb.aSu, paramb.aSv, paramb.aSw, paramb.aSx, paramb.aSy, paramb.aSz);
        break;
        if (((e)localObject1).aTp != null) {}
        for (long l2 = ((e)localObject1).aTp.aQM;; l2 = 0L)
        {
          l1 = l2;
          if (localb == null) {
            break;
          }
          i = localb.aSz.size();
          localObject2 = e.a(localb, paramb);
          if (localObject2 == null) {
            break label525;
          }
          l1 = localb.aQM + ((b.a)localObject2).aSB;
          break;
        }
        l1 = l2;
        if (i == paramb.aSt - localb.aSt) {
          l1 = localb.pD();
        }
      }
      if (((e)localObject1).aTp != null) {}
      for (j = ((e)localObject1).aTp.aSs;; j = 0)
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
        i = localb.aSs + ((b.a)localObject1).aSA - ((b.a)paramb.aSz.get(0)).aSA;
        break;
      }
    }
    label525:
    label553:
    label635:
    if (!this.aTu.aSw)
    {
      if (paramb.aSt + paramb.aSz.size() < this.aTu.aSt) {
        this.aTA = new e.c(this.aTr.url, (byte)0);
      }
    }
    else {
      if (this.aTu == localb) {
        break label806;
      }
    }
    label806:
    for (long l1 = this.aTu.aSu;; l1 = this.aTu.aSu / 2L)
    {
      this.aTx = (com.google.android.exoplayer2.b.o(l1) + l3);
      if ((this.aTr == this.aTB.aTo) && (!this.aTu.aSw)) {
        pE();
      }
      AppMethodBeat.o(125984);
      return;
      if (l3 - this.aTw <= com.google.android.exoplayer2.b.o(this.aTu.aSu) * 3.5D) {
        break;
      }
      this.aTA = new e.d(this.aTr.url, (byte)0);
      pG();
      break;
    }
  }
  
  private void pF()
  {
    AppMethodBeat.i(125983);
    this.aTs.a(this.aTt, this, this.aTB.aTi);
    AppMethodBeat.o(125983);
  }
  
  private boolean pG()
  {
    AppMethodBeat.i(125985);
    this.aTy = (SystemClock.elapsedRealtime() + 60000L);
    e.a(this.aTB, this.aTr);
    if ((this.aTB.aTo == this.aTr) && (!e.a(this.aTB)))
    {
      AppMethodBeat.o(125985);
      return true;
    }
    AppMethodBeat.o(125985);
    return false;
  }
  
  public final void pE()
  {
    AppMethodBeat.i(125981);
    this.aTy = 0L;
    if ((this.aTz) || (this.aTs.isLoading()))
    {
      AppMethodBeat.o(125981);
      return;
    }
    long l = SystemClock.elapsedRealtime();
    if (l < this.aTx)
    {
      this.aTz = true;
      this.aTB.aTk.postDelayed(this, this.aTx - l);
      AppMethodBeat.o(125981);
      return;
    }
    pF();
    AppMethodBeat.o(125981);
  }
  
  public final void run()
  {
    AppMethodBeat.i(125982);
    this.aTz = false;
    pF();
    AppMethodBeat.o(125982);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.e.a
 * JD-Core Version:    0.7.0.1
 */