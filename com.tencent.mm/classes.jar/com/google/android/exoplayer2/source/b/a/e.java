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
  public final d dbG;
  final com.google.android.exoplayer2.source.b.a dbH;
  public final u.a<c> dbP;
  public a dbl;
  public final Uri ddc;
  public final int ddd;
  public final IdentityHashMap<a.a, a> dde;
  public final Handler ddf;
  final e ddg;
  public final t ddh;
  public a.a ddi;
  b ddj;
  public boolean ddk;
  public final List<b> listeners;
  
  public e(Uri paramUri, d paramd, com.google.android.exoplayer2.source.b.a parama, int paramInt, e parame, u.a<c> parama1)
  {
    AppMethodBeat.i(62914);
    this.ddc = paramUri;
    this.dbG = paramd;
    this.dbH = parama;
    this.ddd = paramInt;
    this.ddg = parame;
    this.dbP = parama1;
    this.listeners = new ArrayList();
    this.ddh = new t("HlsPlaylistTracker:MasterPlaylist");
    this.dde = new IdentityHashMap();
    this.ddf = new Handler();
    AppMethodBeat.o(62914);
  }
  
  static b.a a(b paramb1, b paramb2)
  {
    AppMethodBeat.i(62919);
    int i = paramb2.dcp - paramb1.dcp;
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
  
  private void aj(List<a.a> paramList)
  {
    AppMethodBeat.i(62918);
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      a.a locala = (a.a)paramList.get(i);
      a locala1 = new a(locala);
      this.dde.put(locala, locala1);
      i += 1;
    }
    AppMethodBeat.o(62918);
  }
  
  private void e(a.a parama)
  {
    AppMethodBeat.i(62917);
    if ((parama == this.ddi) || (!this.dbl.dcj.contains(parama)) || ((this.ddj != null) && (this.ddj.dcs)))
    {
      AppMethodBeat.o(62917);
      return;
    }
    this.ddi = parama;
    ((a)this.dde.get(this.ddi)).Tz();
    AppMethodBeat.o(62917);
  }
  
  public final b c(a.a parama)
  {
    AppMethodBeat.i(62915);
    b localb = ((a)this.dde.get(parama)).ddo;
    if (localb != null) {
      e(parama);
    }
    AppMethodBeat.o(62915);
    return localb;
  }
  
  public final void d(a.a parama)
  {
    AppMethodBeat.i(62916);
    ((a)this.dde.get(parama)).TA();
    AppMethodBeat.o(62916);
  }
  
  public final class a
    implements t.a<u<c>>, Runnable
  {
    private final a.a ddl;
    public final t ddm;
    private final u<c> ddn;
    public b ddo;
    public long ddp;
    private long ddq;
    private long ddr;
    private long dds;
    private boolean ddt;
    private IOException ddu;
    
    public a(a.a parama)
    {
      AppMethodBeat.i(62904);
      this.ddl = parama;
      this.ddm = new t("HlsPlaylistTracker:MediaPlaylist");
      this.ddn = new u(e.this.dbG.Tp(), w.x(e.this.dbl.dcB, parama.url), e.this.dbP);
      AppMethodBeat.o(62904);
    }
    
    private void TB()
    {
      AppMethodBeat.i(62907);
      this.ddm.a(this.ddn, this, e.this.ddd);
      AppMethodBeat.o(62907);
    }
    
    private boolean TC()
    {
      AppMethodBeat.i(62909);
      this.dds = (SystemClock.elapsedRealtime() + 60000L);
      e.a(e.this, this.ddl);
      if ((e.this.ddi == this.ddl) && (!e.a(e.this)))
      {
        AppMethodBeat.o(62909);
        return true;
      }
      AppMethodBeat.o(62909);
      return false;
    }
    
    private void b(b paramb)
    {
      AppMethodBeat.i(62908);
      b localb = this.ddo;
      long l3 = SystemClock.elapsedRealtime();
      this.ddp = l3;
      Object localObject1 = e.this;
      int i;
      label70:
      Object localObject2;
      if ((localb == null) || (paramb.dcp > localb.dcp))
      {
        i = 1;
        if (i != 0) {
          break label363;
        }
        if (!paramb.dcs) {
          break label356;
        }
        if (!localb.dcs) {
          break label273;
        }
        localObject1 = localb;
        this.ddo = ((b)localObject1);
        if (this.ddo == localb) {
          break label635;
        }
        this.ddu = null;
        this.ddq = l3;
        paramb = e.this;
        localObject1 = this.ddl;
        localObject2 = this.ddo;
        if (localObject1 == paramb.ddi) {
          if (paramb.ddj == null) {
            if (((b)localObject2).dcs) {
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
        paramb.ddk = bool;
        paramb.ddj = ((b)localObject2);
        paramb.ddg.a((b)localObject2);
        int j = paramb.listeners.size();
        i = 0;
        while (i < j)
        {
          ((e.b)paramb.listeners.get(i)).Ts();
          i += 1;
        }
        if (paramb.dcp >= localb.dcp)
        {
          i = paramb.segments.size();
          j = localb.segments.size();
          if ((i > j) || ((i == j) && (paramb.dcs) && (!localb.dcs)))
          {
            i = 1;
            break;
          }
        }
        i = 0;
        break;
        localObject1 = new b(localb.dcl, localb.dcB, localb.dcC, localb.dcm, localb.daJ, localb.dcn, localb.dco, localb.dcp, localb.version, localb.dcq, localb.dcr, true, localb.dct, localb.dcu, localb.segments);
        break label70;
        localObject1 = localb;
        break label70;
        if (paramb.dct) {
          l1 = paramb.daJ;
        }
        for (;;)
        {
          if (!paramb.dcn) {
            break label553;
          }
          i = paramb.dco;
          localObject1 = new b(paramb.dcl, paramb.dcB, paramb.dcC, paramb.dcm, l1, true, i, paramb.dcp, paramb.version, paramb.dcq, paramb.dcr, paramb.dcs, paramb.dct, paramb.dcu, paramb.segments);
          break;
          if (((e)localObject1).ddj != null) {}
          for (long l2 = ((e)localObject1).ddj.daJ;; l2 = 0L)
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
            l1 = localb.daJ + ((b.a)localObject2).dcw;
            break;
          }
          l1 = l2;
          if (i == paramb.dcp - localb.dcp) {
            l1 = localb.Tx();
          }
        }
        if (((e)localObject1).ddj != null) {}
        for (j = ((e)localObject1).ddj.dco;; j = 0)
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
          i = localb.dco + ((b.a)localObject1).dcv - ((b.a)paramb.segments.get(0)).dcv;
          break;
        }
      }
      label525:
      label553:
      label635:
      if (!this.ddo.dcs)
      {
        if (paramb.dcp + paramb.segments.size() < this.ddo.dcp) {
          this.ddu = new e.c(this.ddl.url, (byte)0);
        }
      }
      else {
        if (this.ddo == localb) {
          break label806;
        }
      }
      label806:
      for (long l1 = this.ddo.dcq;; l1 = this.ddo.dcq / 2L)
      {
        this.ddr = (com.google.android.exoplayer2.b.bM(l1) + l3);
        if ((this.ddl == e.this.ddi) && (!this.ddo.dcs)) {
          Tz();
        }
        AppMethodBeat.o(62908);
        return;
        if (l3 - this.ddq <= com.google.android.exoplayer2.b.bM(this.ddo.dcq) * 3.5D) {
          break;
        }
        this.ddu = new e.d(this.ddl.url, (byte)0);
        TC();
        break;
      }
    }
    
    public final void TA()
    {
      AppMethodBeat.i(210362);
      this.ddm.Un();
      if (this.ddu != null)
      {
        IOException localIOException = this.ddu;
        AppMethodBeat.o(210362);
        throw localIOException;
      }
      AppMethodBeat.o(210362);
    }
    
    public final void Tz()
    {
      AppMethodBeat.i(62905);
      this.dds = 0L;
      if ((this.ddt) || (this.ddm.isLoading()))
      {
        AppMethodBeat.o(62905);
        return;
      }
      long l = SystemClock.elapsedRealtime();
      if (l < this.ddr)
      {
        this.ddt = true;
        e.this.ddf.postDelayed(this, this.ddr - l);
        AppMethodBeat.o(62905);
        return;
      }
      TB();
      AppMethodBeat.o(62905);
    }
    
    public final void run()
    {
      AppMethodBeat.i(62906);
      this.ddt = false;
      TB();
      AppMethodBeat.o(62906);
    }
  }
  
  public static abstract interface b
  {
    public abstract void Ts();
    
    public abstract void b(a.a parama);
  }
  
  public static abstract interface e
  {
    public abstract void a(b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.e
 * JD-Core Version:    0.7.0.1
 */