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
  public final d bnN;
  final com.google.android.exoplayer2.source.a.a bnO;
  public final u.a<c> bnW;
  public a bnt;
  public final Uri bpk;
  public final int bpl;
  public final IdentityHashMap<a.a, a> bpm;
  public final Handler bpn;
  final e bpo;
  public final t bpp;
  public a.a bpq;
  b bpr;
  public boolean bps;
  public final List<b> listeners;
  
  public e(Uri paramUri, d paramd, com.google.android.exoplayer2.source.a.a parama, int paramInt, e parame, u.a<c> parama1)
  {
    AppMethodBeat.i(62914);
    this.bpk = paramUri;
    this.bnN = paramd;
    this.bnO = parama;
    this.bpl = paramInt;
    this.bpo = parame;
    this.bnW = parama1;
    this.listeners = new ArrayList();
    this.bpp = new t("HlsPlaylistTracker:MasterPlaylist");
    this.bpm = new IdentityHashMap();
    this.bpn = new Handler();
    AppMethodBeat.o(62914);
  }
  
  static b.a a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(62919);
    int i = paramb2.box - paramb1.box;
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
    if ((parama == this.bpq) || (!this.bnt.bor.contains(parama)) || ((this.bpr != null) && (this.bpr.boA)))
    {
      AppMethodBeat.o(62917);
      return;
    }
    this.bpq = parama;
    ((a)this.bpm.get(this.bpq)).ut();
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
      this.bpm.put(locala, locala1);
      i += 1;
    }
    AppMethodBeat.o(62918);
  }
  
  public final b c(a.a parama)
  {
    AppMethodBeat.i(62915);
    b localb = ((a)this.bpm.get(parama)).bpw;
    if (localb != null) {
      e(parama);
    }
    AppMethodBeat.o(62915);
    return localb;
  }
  
  public final void d(a.a parama)
  {
    AppMethodBeat.i(62916);
    this.bpm.get(parama);
    AppMethodBeat.o(62916);
  }
  
  public final class a
    implements t.a<u<c>>, Runnable
  {
    private long bpA;
    private boolean bpB;
    private IOException bpC;
    private final a.a bpt;
    public final t bpu;
    private final u<c> bpv;
    public b bpw;
    public long bpx;
    private long bpy;
    private long bpz;
    
    public a(a.a parama)
    {
      AppMethodBeat.i(62904);
      this.bpt = parama;
      this.bpu = new t("HlsPlaylistTracker:MediaPlaylist");
      this.bpv = new u(e.this.bnN.uk(), w.m(e.this.bnt.boJ, parama.url), e.this.bnW);
      AppMethodBeat.o(62904);
    }
    
    private void b(b paramb)
    {
      AppMethodBeat.i(62908);
      b localb = this.bpw;
      long l3 = SystemClock.elapsedRealtime();
      this.bpx = l3;
      Object localObject1 = e.this;
      int i;
      label70:
      Object localObject2;
      if ((localb == null) || (paramb.box > localb.box))
      {
        i = 1;
        if (i != 0) {
          break label363;
        }
        if (!paramb.boA) {
          break label356;
        }
        if (!localb.boA) {
          break label273;
        }
        localObject1 = localb;
        this.bpw = ((b)localObject1);
        if (this.bpw == localb) {
          break label635;
        }
        this.bpC = null;
        this.bpy = l3;
        paramb = e.this;
        localObject1 = this.bpt;
        localObject2 = this.bpw;
        if (localObject1 == paramb.bpq) {
          if (paramb.bpr == null) {
            if (((b)localObject2).boA) {
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
        paramb.bps = bool;
        paramb.bpr = ((b)localObject2);
        paramb.bpo.a((b)localObject2);
        int j = paramb.listeners.size();
        i = 0;
        while (i < j)
        {
          ((e.b)paramb.listeners.get(i)).un();
          i += 1;
        }
        if (paramb.box >= localb.box)
        {
          i = paramb.segments.size();
          j = localb.segments.size();
          if ((i > j) || ((i == j) && (paramb.boA) && (!localb.boA)))
          {
            i = 1;
            break;
          }
        }
        i = 0;
        break;
        localObject1 = new b(localb.bot, localb.boJ, localb.boK, localb.bou, localb.bmR, localb.bov, localb.bow, localb.box, localb.version, localb.boy, localb.boz, true, localb.boB, localb.boC, localb.segments);
        break label70;
        localObject1 = localb;
        break label70;
        if (paramb.boB) {
          l1 = paramb.bmR;
        }
        for (;;)
        {
          if (!paramb.bov) {
            break label553;
          }
          i = paramb.bow;
          localObject1 = new b(paramb.bot, paramb.boJ, paramb.boK, paramb.bou, l1, true, i, paramb.box, paramb.version, paramb.boy, paramb.boz, paramb.boA, paramb.boB, paramb.boC, paramb.segments);
          break;
          if (((e)localObject1).bpr != null) {}
          for (long l2 = ((e)localObject1).bpr.bmR;; l2 = 0L)
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
            l1 = localb.bmR + ((b.a)localObject2).boE;
            break;
          }
          l1 = l2;
          if (i == paramb.box - localb.box) {
            l1 = localb.us();
          }
        }
        if (((e)localObject1).bpr != null) {}
        for (j = ((e)localObject1).bpr.bow;; j = 0)
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
          i = localb.bow + ((b.a)localObject1).boD - ((b.a)paramb.segments.get(0)).boD;
          break;
        }
      }
      label525:
      label553:
      label635:
      if (!this.bpw.boA)
      {
        if (paramb.box + paramb.segments.size() < this.bpw.box) {
          this.bpC = new e.c(this.bpt.url, (byte)0);
        }
      }
      else {
        if (this.bpw == localb) {
          break label806;
        }
      }
      label806:
      for (long l1 = this.bpw.boy;; l1 = this.bpw.boy / 2L)
      {
        this.bpz = (com.google.android.exoplayer2.b.v(l1) + l3);
        if ((this.bpt == e.this.bpq) && (!this.bpw.boA)) {
          ut();
        }
        AppMethodBeat.o(62908);
        return;
        if (l3 - this.bpy <= com.google.android.exoplayer2.b.v(this.bpw.boy) * 3.5D) {
          break;
        }
        this.bpC = new e.d(this.bpt.url, (byte)0);
        uv();
        break;
      }
    }
    
    private void uu()
    {
      AppMethodBeat.i(62907);
      this.bpu.a(this.bpv, this, e.this.bpl);
      AppMethodBeat.o(62907);
    }
    
    private boolean uv()
    {
      AppMethodBeat.i(62909);
      this.bpA = (SystemClock.elapsedRealtime() + 60000L);
      e.a(e.this, this.bpt);
      if ((e.this.bpq == this.bpt) && (!e.a(e.this)))
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
      this.bpB = false;
      uu();
      AppMethodBeat.o(62906);
    }
    
    public final void ut()
    {
      AppMethodBeat.i(62905);
      this.bpA = 0L;
      if ((this.bpB) || (this.bpu.isLoading()))
      {
        AppMethodBeat.o(62905);
        return;
      }
      long l = SystemClock.elapsedRealtime();
      if (l < this.bpz)
      {
        this.bpB = true;
        e.this.bpn.postDelayed(this, this.bpz - l);
        AppMethodBeat.o(62905);
        return;
      }
      uu();
      AppMethodBeat.o(62905);
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(a.a parama);
    
    public abstract void un();
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