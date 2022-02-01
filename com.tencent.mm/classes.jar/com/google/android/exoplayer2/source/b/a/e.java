package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.h.t.a;
import com.google.android.exoplayer2.h.v;
import com.google.android.exoplayer2.h.v.a;
import com.google.android.exoplayer2.i.w;
import com.google.android.exoplayer2.source.b.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.List;

public final class e
  implements t.a<v<c>>
{
  final com.google.android.exoplayer2.source.a.a bmE;
  public a boY;
  public final d bpq;
  public final v.a<c> bpw;
  public final Uri bqK;
  public final int bqL;
  public final IdentityHashMap<a.a, a> bqM;
  public final Handler bqN;
  final e bqO;
  public final t bqP;
  public a.a bqQ;
  b bqR;
  public boolean bqS;
  public final List<b> listeners;
  
  public e(Uri paramUri, d paramd, com.google.android.exoplayer2.source.a.a parama, int paramInt, e parame, v.a<c> parama1)
  {
    AppMethodBeat.i(62914);
    this.bqK = paramUri;
    this.bpq = paramd;
    this.bmE = parama;
    this.bqL = paramInt;
    this.bqO = parame;
    this.bpw = parama1;
    this.listeners = new ArrayList();
    this.bqP = new t("HlsPlaylistTracker:MasterPlaylist");
    this.bqM = new IdentityHashMap();
    this.bqN = new Handler();
    AppMethodBeat.o(62914);
  }
  
  private void A(List<a.a> paramList)
  {
    AppMethodBeat.i(62918);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)paramList.get(i);
      a locala1 = new a(locala);
      this.bqM.put(locala, locala1);
      i += 1;
    }
    AppMethodBeat.o(62918);
  }
  
  static b.a a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(62919);
    int i = paramb2.bpW - paramb1.bpW;
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
    if ((parama == this.bqQ) || (!this.boY.bpP.contains(parama)) || ((this.bqR != null) && (this.bqR.bpZ)))
    {
      AppMethodBeat.o(62917);
      return;
    }
    this.bqQ = parama;
    ((a)this.bqM.get(this.bqQ)).ux();
    AppMethodBeat.o(62917);
  }
  
  public final b c(a.a parama)
  {
    AppMethodBeat.i(62915);
    b localb = ((a)this.bqM.get(parama)).bqW;
    if (localb != null) {
      e(parama);
    }
    AppMethodBeat.o(62915);
    return localb;
  }
  
  public final void d(a.a parama)
  {
    AppMethodBeat.i(62916);
    this.bqM.get(parama);
    AppMethodBeat.o(62916);
  }
  
  public final class a
    implements t.a<v<c>>, Runnable
  {
    private final a.a bqT;
    public final t bqU;
    private final v<c> bqV;
    public b bqW;
    public long bqX;
    private long bqY;
    private long bqZ;
    private long bra;
    private boolean brb;
    private IOException brc;
    
    public a(a.a parama)
    {
      AppMethodBeat.i(62904);
      this.bqT = parama;
      this.bqU = new t("HlsPlaylistTracker:MediaPlaylist");
      this.bqV = new v(e.this.bpq.uo(), w.l(e.this.boY.bqj, parama.url), 4, e.this.bpw);
      AppMethodBeat.o(62904);
    }
    
    private void b(b paramb)
    {
      AppMethodBeat.i(62908);
      b localb = this.bqW;
      long l3 = SystemClock.elapsedRealtime();
      this.bqX = l3;
      Object localObject1 = e.this;
      int i;
      label70:
      Object localObject2;
      if ((localb == null) || (paramb.bpW > localb.bpW))
      {
        i = 1;
        if (i != 0) {
          break label363;
        }
        if (!paramb.bpZ) {
          break label356;
        }
        if (!localb.bpZ) {
          break label273;
        }
        localObject1 = localb;
        this.bqW = ((b)localObject1);
        if (this.bqW == localb) {
          break label635;
        }
        this.brc = null;
        this.bqY = l3;
        paramb = e.this;
        localObject1 = this.bqT;
        localObject2 = this.bqW;
        if (localObject1 == paramb.bqQ) {
          if (paramb.bqR == null) {
            if (((b)localObject2).bpZ) {
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
        paramb.bqS = bool;
        paramb.bqR = ((b)localObject2);
        paramb.bqO.a((b)localObject2);
        int j = paramb.listeners.size();
        i = 0;
        while (i < j)
        {
          ((e.b)paramb.listeners.get(i)).ur();
          i += 1;
        }
        if (paramb.bpW >= localb.bpW)
        {
          i = paramb.segments.size();
          j = localb.segments.size();
          if ((i > j) || ((i == j) && (paramb.bpZ) && (!localb.bpZ)))
          {
            i = 1;
            break;
          }
        }
        i = 0;
        break;
        localObject1 = new b(localb.bpS, localb.bqj, localb.bqk, localb.bpT, localb.bmp, localb.bpU, localb.bpV, localb.bpW, localb.version, localb.bpX, localb.bpY, true, localb.bqa, localb.bqb, localb.segments);
        break label70;
        localObject1 = localb;
        break label70;
        if (paramb.bqa) {
          l1 = paramb.bmp;
        }
        for (;;)
        {
          if (!paramb.bpU) {
            break label553;
          }
          i = paramb.bpV;
          localObject1 = new b(paramb.bpS, paramb.bqj, paramb.bqk, paramb.bpT, l1, true, i, paramb.bpW, paramb.version, paramb.bpX, paramb.bpY, paramb.bpZ, paramb.bqa, paramb.bqb, paramb.segments);
          break;
          if (((e)localObject1).bqR != null) {}
          for (long l2 = ((e)localObject1).bqR.bmp;; l2 = 0L)
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
            l1 = localb.bmp + ((b.a)localObject2).bqe;
            break;
          }
          l1 = l2;
          if (i == paramb.bpW - localb.bpW) {
            l1 = localb.uw();
          }
        }
        if (((e)localObject1).bqR != null) {}
        for (j = ((e)localObject1).bqR.bpV;; j = 0)
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
          i = localb.bpV + ((b.a)localObject1).bqd - ((b.a)paramb.segments.get(0)).bqd;
          break;
        }
      }
      label525:
      label553:
      label635:
      if (!this.bqW.bpZ)
      {
        if (paramb.bpW + paramb.segments.size() < this.bqW.bpW) {
          this.brc = new e.c(this.bqT.url, (byte)0);
        }
      }
      else {
        if (this.bqW == localb) {
          break label806;
        }
      }
      label806:
      for (long l1 = this.bqW.bpX;; l1 = this.bqW.bpX / 2L)
      {
        this.bqZ = (com.google.android.exoplayer2.b.t(l1) + l3);
        if ((this.bqT == e.this.bqQ) && (!this.bqW.bpZ)) {
          ux();
        }
        AppMethodBeat.o(62908);
        return;
        if (l3 - this.bqY <= com.google.android.exoplayer2.b.t(this.bqW.bpX) * 3.5D) {
          break;
        }
        this.brc = new e.d(this.bqT.url, (byte)0);
        uz();
        break;
      }
    }
    
    private void uy()
    {
      AppMethodBeat.i(62907);
      this.bqU.a(this.bqV, this, e.this.bqL);
      AppMethodBeat.o(62907);
    }
    
    private boolean uz()
    {
      AppMethodBeat.i(62909);
      this.bra = (SystemClock.elapsedRealtime() + 60000L);
      e.a(e.this, this.bqT);
      if ((e.this.bqQ == this.bqT) && (!e.a(e.this)))
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
      this.brb = false;
      uy();
      AppMethodBeat.o(62906);
    }
    
    public final void ux()
    {
      AppMethodBeat.i(62905);
      this.bra = 0L;
      if ((this.brb) || (this.bqU.isLoading()))
      {
        AppMethodBeat.o(62905);
        return;
      }
      long l = SystemClock.elapsedRealtime();
      if (l < this.bqZ)
      {
        this.brb = true;
        e.this.bqN.postDelayed(this, this.bqZ - l);
        AppMethodBeat.o(62905);
        return;
      }
      uy();
      AppMethodBeat.o(62905);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(a.a parama);
    
    public abstract void ur();
  }
  
  public static final class c
    extends IOException
  {
    public final String url;
    
    private c(String paramString)
    {
      this.url = paramString;
    }
  }
  
  public static final class d
    extends IOException
  {
    public final String url;
    
    private d(String paramString)
    {
      this.url = paramString;
    }
  }
  
  public static abstract interface e
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.e
 * JD-Core Version:    0.7.0.1
 */