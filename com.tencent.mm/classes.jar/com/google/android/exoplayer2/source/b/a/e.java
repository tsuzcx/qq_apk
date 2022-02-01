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
  public final d bhM;
  final com.google.android.exoplayer2.source.b.a bhN;
  public final u.a<c> bhV;
  public a bhs;
  public final Uri bji;
  public final int bjj;
  public final IdentityHashMap<a.a, a> bjk;
  public final Handler bjl;
  final e bjm;
  public final t bjn;
  public a.a bjo;
  b bjp;
  public boolean bjq;
  public final List<b> listeners;
  
  public e(Uri paramUri, d paramd, com.google.android.exoplayer2.source.b.a parama, int paramInt, e parame, u.a<c> parama1)
  {
    AppMethodBeat.i(62914);
    this.bji = paramUri;
    this.bhM = paramd;
    this.bhN = parama;
    this.bjj = paramInt;
    this.bjm = parame;
    this.bhV = parama1;
    this.listeners = new ArrayList();
    this.bjn = new t("HlsPlaylistTracker:MasterPlaylist");
    this.bjk = new IdentityHashMap();
    this.bjl = new Handler();
    AppMethodBeat.o(62914);
  }
  
  static b.a a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(62919);
    int i = paramb2.biv - paramb1.biv;
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
    if ((parama == this.bjo) || (!this.bhs.bip.contains(parama)) || ((this.bjp != null) && (this.bjp.biy)))
    {
      AppMethodBeat.o(62917);
      return;
    }
    this.bjo = parama;
    ((a)this.bjk.get(this.bjo)).tW();
    AppMethodBeat.o(62917);
  }
  
  private void q(List<a.a> paramList)
  {
    AppMethodBeat.i(62918);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)paramList.get(i);
      a locala1 = new a(locala);
      this.bjk.put(locala, locala1);
      i += 1;
    }
    AppMethodBeat.o(62918);
  }
  
  public final b c(a.a parama)
  {
    AppMethodBeat.i(62915);
    b localb = ((a)this.bjk.get(parama)).bju;
    if (localb != null) {
      e(parama);
    }
    AppMethodBeat.o(62915);
    return localb;
  }
  
  public final void d(a.a parama)
  {
    AppMethodBeat.i(62916);
    ((a)this.bjk.get(parama)).tX();
    AppMethodBeat.o(62916);
  }
  
  public final class a
    implements t.a<u<c>>, Runnable
  {
    private IOException bjA;
    private final a.a bjr;
    public final t bjs;
    private final u<c> bjt;
    public b bju;
    public long bjv;
    private long bjw;
    private long bjx;
    private long bjy;
    private boolean bjz;
    
    public a(a.a parama)
    {
      AppMethodBeat.i(62904);
      this.bjr = parama;
      this.bjs = new t("HlsPlaylistTracker:MediaPlaylist");
      this.bjt = new u(e.this.bhM.tM(), w.q(e.this.bhs.biH, parama.url), e.this.bhV);
      AppMethodBeat.o(62904);
    }
    
    private void b(b paramb)
    {
      AppMethodBeat.i(62908);
      b localb = this.bju;
      long l3 = SystemClock.elapsedRealtime();
      this.bjv = l3;
      Object localObject1 = e.this;
      int i;
      label70:
      Object localObject2;
      if ((localb == null) || (paramb.biv > localb.biv))
      {
        i = 1;
        if (i != 0) {
          break label363;
        }
        if (!paramb.biy) {
          break label356;
        }
        if (!localb.biy) {
          break label273;
        }
        localObject1 = localb;
        this.bju = ((b)localObject1);
        if (this.bju == localb) {
          break label635;
        }
        this.bjA = null;
        this.bjw = l3;
        paramb = e.this;
        localObject1 = this.bjr;
        localObject2 = this.bju;
        if (localObject1 == paramb.bjo) {
          if (paramb.bjp == null) {
            if (((b)localObject2).biy) {
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
        paramb.bjq = bool;
        paramb.bjp = ((b)localObject2);
        paramb.bjm.a((b)localObject2);
        int j = paramb.listeners.size();
        i = 0;
        while (i < j)
        {
          ((e.b)paramb.listeners.get(i)).tP();
          i += 1;
        }
        if (paramb.biv >= localb.biv)
        {
          i = paramb.segments.size();
          j = localb.segments.size();
          if ((i > j) || ((i == j) && (paramb.biy) && (!localb.biy)))
          {
            i = 1;
            break;
          }
        }
        i = 0;
        break;
        localObject1 = new b(localb.bir, localb.biH, localb.biI, localb.bis, localb.bgP, localb.bit, localb.biu, localb.biv, localb.version, localb.biw, localb.bix, true, localb.biz, localb.biA, localb.segments);
        break label70;
        localObject1 = localb;
        break label70;
        if (paramb.biz) {
          l1 = paramb.bgP;
        }
        for (;;)
        {
          if (!paramb.bit) {
            break label553;
          }
          i = paramb.biu;
          localObject1 = new b(paramb.bir, paramb.biH, paramb.biI, paramb.bis, l1, true, i, paramb.biv, paramb.version, paramb.biw, paramb.bix, paramb.biy, paramb.biz, paramb.biA, paramb.segments);
          break;
          if (((e)localObject1).bjp != null) {}
          for (long l2 = ((e)localObject1).bjp.bgP;; l2 = 0L)
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
            l1 = localb.bgP + ((b.a)localObject2).biC;
            break;
          }
          l1 = l2;
          if (i == paramb.biv - localb.biv) {
            l1 = localb.tU();
          }
        }
        if (((e)localObject1).bjp != null) {}
        for (j = ((e)localObject1).bjp.biu;; j = 0)
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
          i = localb.biu + ((b.a)localObject1).biB - ((b.a)paramb.segments.get(0)).biB;
          break;
        }
      }
      label525:
      label553:
      label635:
      if (!this.bju.biy)
      {
        if (paramb.biv + paramb.segments.size() < this.bju.biv) {
          this.bjA = new e.c(this.bjr.url, (byte)0);
        }
      }
      else {
        if (this.bju == localb) {
          break label806;
        }
      }
      label806:
      for (long l1 = this.bju.biw;; l1 = this.bju.biw / 2L)
      {
        this.bjx = (com.google.android.exoplayer2.b.y(l1) + l3);
        if ((this.bjr == e.this.bjo) && (!this.bju.biy)) {
          tW();
        }
        AppMethodBeat.o(62908);
        return;
        if (l3 - this.bjw <= com.google.android.exoplayer2.b.y(this.bju.biw) * 3.5D) {
          break;
        }
        this.bjA = new e.d(this.bjr.url, (byte)0);
        tZ();
        break;
      }
    }
    
    private void tY()
    {
      AppMethodBeat.i(62907);
      this.bjs.a(this.bjt, this, e.this.bjj);
      AppMethodBeat.o(62907);
    }
    
    private boolean tZ()
    {
      AppMethodBeat.i(62909);
      this.bjy = (SystemClock.elapsedRealtime() + 60000L);
      e.a(e.this, this.bjr);
      if ((e.this.bjo == this.bjr) && (!e.a(e.this)))
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
      this.bjz = false;
      tY();
      AppMethodBeat.o(62906);
    }
    
    public final void tW()
    {
      AppMethodBeat.i(62905);
      this.bjy = 0L;
      if ((this.bjz) || (this.bjs.isLoading()))
      {
        AppMethodBeat.o(62905);
        return;
      }
      long l = SystemClock.elapsedRealtime();
      if (l < this.bjx)
      {
        this.bjz = true;
        e.this.bjl.postDelayed(this, this.bjx - l);
        AppMethodBeat.o(62905);
        return;
      }
      tY();
      AppMethodBeat.o(62905);
    }
    
    public final void tX()
    {
      AppMethodBeat.i(210991);
      this.bjs.uO();
      if (this.bjA != null)
      {
        IOException localIOException = this.bjA;
        AppMethodBeat.o(210991);
        throw localIOException;
      }
      AppMethodBeat.o(210991);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(a.a parama);
    
    public abstract void tP();
  }
  
  public static abstract interface e
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.e
 * JD-Core Version:    0.7.0.1
 */