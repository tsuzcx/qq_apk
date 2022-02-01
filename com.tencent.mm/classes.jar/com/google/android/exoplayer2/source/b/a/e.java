package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.u;
import com.google.android.exoplayer2.h.u.a;
import com.google.android.exoplayer2.i.w;
import com.google.android.exoplayer2.source.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public final class e
  implements t.a<u<c>>
{
  public a bxQ;
  public final d byk;
  final com.google.android.exoplayer2.source.b.a byl;
  public final u.a<c> byt;
  public final Uri bzH;
  public final int bzI;
  public final IdentityHashMap<a.a, a> bzJ;
  public final Handler bzK;
  final e bzL;
  public final t bzM;
  public a.a bzN;
  b bzO;
  public boolean bzP;
  public final List<b> listeners;
  
  public e(Uri paramUri, d paramd, com.google.android.exoplayer2.source.b.a parama, int paramInt, e parame, u.a<c> parama1)
  {
    AppMethodBeat.i(62914);
    this.bzH = paramUri;
    this.byk = paramd;
    this.byl = parama;
    this.bzI = paramInt;
    this.bzL = parame;
    this.byt = parama1;
    this.listeners = new ArrayList();
    this.bzM = new t("HlsPlaylistTracker:MasterPlaylist");
    this.bzJ = new IdentityHashMap();
    this.bzK = new Handler();
    AppMethodBeat.o(62914);
  }
  
  static b.a a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(62919);
    int i = paramb2.byU - paramb1.byU;
    paramb1 = paramb1.segments;
    if (i < paramb1.size())
    {
      paramb1 = (b.a)paramb1.get(i);
      AppMethodBeat.o(62919);
      return paramb1;
    }
    AppMethodBeat.o(62919);
    return null;
  }
  
  private void e(a.a parama)
  {
    AppMethodBeat.i(62917);
    if ((parama == this.bzN) || (!this.bxQ.byO.contains(parama)) || ((this.bzO != null) && (this.bzO.byX)))
    {
      AppMethodBeat.o(62917);
      return;
    }
    this.bzN = parama;
    ((a)this.bzJ.get(this.bzN)).vX();
    AppMethodBeat.o(62917);
  }
  
  private void v(List<a.a> paramList)
  {
    AppMethodBeat.i(62918);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)paramList.get(i);
      a locala1 = new a(locala);
      this.bzJ.put(locala, locala1);
      i += 1;
    }
    AppMethodBeat.o(62918);
  }
  
  public final b c(a.a parama)
  {
    AppMethodBeat.i(62915);
    b localb = ((a)this.bzJ.get(parama)).bzT;
    if (localb != null) {
      e(parama);
    }
    AppMethodBeat.o(62915);
    return localb;
  }
  
  public final void d(a.a parama)
  {
    AppMethodBeat.i(62916);
    this.bzJ.get(parama);
    AppMethodBeat.o(62916);
  }
  
  public final class a
    implements t.a<u<c>>, Runnable
  {
    private final a.a bzQ;
    public final t bzR;
    private final u<c> bzS;
    public b bzT;
    public long bzU;
    private long bzV;
    private long bzW;
    private long bzX;
    private boolean bzY;
    private IOException bzZ;
    
    public a(a.a parama)
    {
      AppMethodBeat.i(62904);
      this.bzQ = parama;
      this.bzR = new t("HlsPlaylistTracker:MediaPlaylist");
      this.bzS = new u(e.this.byk.vO(), w.m(e.this.bxQ.bzg, parama.url), e.this.byt);
      AppMethodBeat.o(62904);
    }
    
    private void b(b paramb)
    {
      AppMethodBeat.i(62908);
      b localb = this.bzT;
      long l3 = SystemClock.elapsedRealtime();
      this.bzU = l3;
      Object localObject1 = e.this;
      int i;
      label70:
      Object localObject2;
      if ((localb == null) || (paramb.byU > localb.byU))
      {
        i = 1;
        if (i != 0) {
          break label363;
        }
        if (!paramb.byX) {
          break label356;
        }
        if (!localb.byX) {
          break label273;
        }
        localObject1 = localb;
        this.bzT = ((b)localObject1);
        if (this.bzT == localb) {
          break label635;
        }
        this.bzZ = null;
        this.bzV = l3;
        paramb = e.this;
        localObject1 = this.bzQ;
        localObject2 = this.bzT;
        if (localObject1 == paramb.bzN) {
          if (paramb.bzO == null) {
            if (((b)localObject2).byX) {
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
        paramb.bzP = bool;
        paramb.bzO = ((b)localObject2);
        paramb.bzL.a((b)localObject2);
        int j = paramb.listeners.size();
        i = 0;
        while (i < j)
        {
          ((e.b)paramb.listeners.get(i)).vR();
          i += 1;
        }
        if (paramb.byU >= localb.byU)
        {
          i = paramb.segments.size();
          j = localb.segments.size();
          if ((i > j) || ((i == j) && (paramb.byX) && (!localb.byX)))
          {
            i = 1;
            break;
          }
        }
        i = 0;
        break;
        localObject1 = new b(localb.byQ, localb.bzg, localb.bzh, localb.byR, localb.bxn, localb.byS, localb.byT, localb.byU, localb.version, localb.byV, localb.byW, true, localb.byY, localb.byZ, localb.segments);
        break label70;
        localObject1 = localb;
        break label70;
        if (paramb.byY) {
          l1 = paramb.bxn;
        }
        for (;;)
        {
          if (!paramb.byS) {
            break label553;
          }
          i = paramb.byT;
          localObject1 = new b(paramb.byQ, paramb.bzg, paramb.bzh, paramb.byR, l1, true, i, paramb.byU, paramb.version, paramb.byV, paramb.byW, paramb.byX, paramb.byY, paramb.byZ, paramb.segments);
          break;
          if (((e)localObject1).bzO != null) {}
          for (long l2 = ((e)localObject1).bzO.bxn;; l2 = 0L)
          {
            l1 = l2;
            if (localb == null) {
              break;
            }
            i = localb.segments.size();
            localObject2 = e.a(localb, paramb);
            if (localObject2 == null) {
              break label525;
            }
            l1 = localb.bxn + ((b.a)localObject2).bzb;
            break;
          }
          l1 = l2;
          if (i == paramb.byU - localb.byU) {
            l1 = localb.vW();
          }
        }
        if (((e)localObject1).bzO != null) {}
        for (j = ((e)localObject1).bzO.byT;; j = 0)
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
          i = localb.byT + ((b.a)localObject1).bza - ((b.a)paramb.segments.get(0)).bza;
          break;
        }
      }
      label525:
      label553:
      label635:
      if (!this.bzT.byX)
      {
        if (paramb.byU + paramb.segments.size() < this.bzT.byU) {
          this.bzZ = new e.c(this.bzQ.url, (byte)0);
        }
      }
      else {
        if (this.bzT == localb) {
          break label806;
        }
      }
      label806:
      for (long l1 = this.bzT.byV;; l1 = this.bzT.byV / 2L)
      {
        this.bzW = (com.google.android.exoplayer2.b.v(l1) + l3);
        if ((this.bzQ == e.this.bzN) && (!this.bzT.byX)) {
          vX();
        }
        AppMethodBeat.o(62908);
        return;
        if (l3 - this.bzV <= com.google.android.exoplayer2.b.v(this.bzT.byV) * 3.5D) {
          break;
        }
        this.bzZ = new e.d(this.bzQ.url, (byte)0);
        vZ();
        break;
      }
    }
    
    private void vY()
    {
      AppMethodBeat.i(62907);
      this.bzR.a(this.bzS, this, e.this.bzI);
      AppMethodBeat.o(62907);
    }
    
    private boolean vZ()
    {
      AppMethodBeat.i(62909);
      this.bzX = (SystemClock.elapsedRealtime() + 60000L);
      e.a(e.this, this.bzQ);
      if ((e.this.bzN == this.bzQ) && (!e.a(e.this)))
      {
        AppMethodBeat.o(62909);
        return true;
      }
      AppMethodBeat.o(62909);
      return false;
    }
    
    public final void run()
    {
      AppMethodBeat.i(62906);
      this.bzY = false;
      vY();
      AppMethodBeat.o(62906);
    }
    
    public final void vX()
    {
      AppMethodBeat.i(62905);
      this.bzX = 0L;
      if ((this.bzY) || (this.bzR.isLoading()))
      {
        AppMethodBeat.o(62905);
        return;
      }
      long l = SystemClock.elapsedRealtime();
      if (l < this.bzW)
      {
        this.bzY = true;
        e.this.bzK.postDelayed(this, this.bzW - l);
        AppMethodBeat.o(62905);
        return;
      }
      vY();
      AppMethodBeat.o(62905);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(a.a parama);
    
    public abstract void vR();
  }
  
  public static abstract interface e
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.e
 * JD-Core Version:    0.7.0.1
 */