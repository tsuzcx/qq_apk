package com.tencent.liteav.network;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class d$b
  implements com.tencent.liteav.basic.c.a, f
{
  private final int a;
  private long b;
  private long c;
  private int d;
  private boolean e;
  private long f;
  private long g;
  private long h;
  private ArrayList<TXSNALPacket> i;
  private ArrayList<com.tencent.liteav.basic.structs.a> j;
  private TXIStreamDownloader k;
  private WeakReference<d> l;
  private f m;
  
  public d$b(TXIStreamDownloader paramTXIStreamDownloader, d paramd)
  {
    AppMethodBeat.i(67584);
    this.a = 2;
    this.b = 0L;
    this.c = 0L;
    this.d = 0;
    this.e = false;
    this.f = 0L;
    this.g = 0L;
    this.h = 0L;
    this.i = new ArrayList();
    this.j = new ArrayList();
    this.k = null;
    this.l = new WeakReference(paramd);
    this.k = paramTXIStreamDownloader;
    this.k.setListener(this);
    AppMethodBeat.o(67584);
  }
  
  private void a(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(146786);
    Object localObject1 = (d)this.l.get();
    if ((paramTXSNALPacket.nalType == 0) && (!this.e))
    {
      this.d += 1;
      if ((localObject1 != null) && ((d.a((d)localObject1) <= paramTXSNALPacket.pts) || (this.d == 2)))
      {
        this.b = ((d)localObject1).a(paramTXSNALPacket.pts);
        this.e = true;
      }
      if (localObject1 != null) {
        TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start begin gop " + this.d + " last iframe ts " + d.a((d)localObject1) + " pts " + paramTXSNALPacket.pts + " from " + this.b + " type " + paramTXSNALPacket.nalType);
      }
    }
    if (!this.e)
    {
      AppMethodBeat.o(146786);
      return;
    }
    if (localObject1 != null) {
      ((d)localObject1).b(paramTXSNALPacket.pts);
    }
    if (paramTXSNALPacket.pts >= this.b)
    {
      if ((paramTXSNALPacket.nalType == 0) && (this.c == 0L))
      {
        this.c = paramTXSNALPacket.pts;
        TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end " + paramTXSNALPacket.pts + " from " + this.b + " type " + paramTXSNALPacket.nalType);
      }
      if (this.c > 0L)
      {
        if (this.m != null)
        {
          if (localObject1 != null) {
            ((d)localObject1).a(this.k, true);
          }
          Object localObject2;
          if (!this.j.isEmpty())
          {
            localObject1 = this.j.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (com.tencent.liteav.basic.structs.a)((Iterator)localObject1).next();
              if (((com.tencent.liteav.basic.structs.a)localObject2).e >= this.c)
              {
                TXCLog.i("TXCMultiStreamDownloader", " stream_switch pre start cache audio pts " + ((com.tencent.liteav.basic.structs.a)localObject2).e + " from " + this.c);
                this.m.onPullAudio((com.tencent.liteav.basic.structs.a)localObject2);
              }
            }
            TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end audio cache  " + this.j.size());
            this.j.clear();
          }
          if (!this.i.isEmpty())
          {
            TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end video cache  " + this.i.size());
            localObject1 = this.i.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (TXSNALPacket)((Iterator)localObject1).next();
              this.m.onPullNAL((TXSNALPacket)localObject2);
            }
            this.i.clear();
          }
          TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start first pull nal " + paramTXSNALPacket.pts + " from " + this.c + " type " + paramTXSNALPacket.nalType);
          this.m.onPullNAL(paramTXSNALPacket);
          this.m = null;
          this.k.setNotifyListener(null);
          AppMethodBeat.o(146786);
          return;
        }
        TXCLog.i("TXCMultiStreamDownloader", " stream_switch pre start cache video pts " + paramTXSNALPacket.pts + " from " + this.c + " type " + paramTXSNALPacket.nalType);
        this.i.add(paramTXSNALPacket);
      }
    }
    AppMethodBeat.o(146786);
  }
  
  private void a(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(146784);
    if (parama == null)
    {
      AppMethodBeat.o(146784);
      return;
    }
    if ((parama.e < this.c) || (parama.e < this.b))
    {
      AppMethodBeat.o(146784);
      return;
    }
    if ((this.m != null) && (this.c > 0L) && (parama.e >= this.c))
    {
      this.m.onPullAudio(parama);
      AppMethodBeat.o(146784);
      return;
    }
    this.j.add(parama);
    AppMethodBeat.o(146784);
  }
  
  private void b(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(146787);
    d locald = (d)this.l.get();
    if (locald != null) {
      locald.c(paramTXSNALPacket.pts);
    }
    if (paramTXSNALPacket.pts >= this.f)
    {
      if (paramTXSNALPacket.nalType == 0) {
        this.g = paramTXSNALPacket.pts;
      }
      if (this.g > 0L)
      {
        if (this.h > 0L)
        {
          TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop end video pts " + this.g + " audio ts " + this.h + " from " + this.f);
          if (locald != null) {
            locald.b();
          }
          this.m = null;
          this.k.setListener(null);
          this.k.stopDownload();
          AppMethodBeat.o(146787);
          return;
        }
        TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop video end wait audio end video pts " + paramTXSNALPacket.pts + " from " + this.f + " type " + paramTXSNALPacket.nalType);
        AppMethodBeat.o(146787);
        return;
      }
      if (this.m != null)
      {
        this.m.onPullNAL(paramTXSNALPacket);
        AppMethodBeat.o(146787);
      }
    }
    else if (this.m != null)
    {
      this.m.onPullNAL(paramTXSNALPacket);
    }
    AppMethodBeat.o(146787);
  }
  
  private void b(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(146785);
    if (this.h > 0L)
    {
      AppMethodBeat.o(146785);
      return;
    }
    if ((this.g > 0L) && (parama != null) && (parama.e >= this.g))
    {
      this.h = parama.e;
      AppMethodBeat.o(146785);
      return;
    }
    if (this.m != null) {
      this.m.onPullAudio(parama);
    }
    AppMethodBeat.o(146785);
  }
  
  public void a(long paramLong)
  {
    AppMethodBeat.i(67585);
    this.d = 0;
    this.b = paramLong;
    this.k.setListener(this);
    this.k.setNotifyListener(this);
    AppMethodBeat.o(67585);
  }
  
  public void a(f paramf)
  {
    this.m = paramf;
  }
  
  public void b(long paramLong)
  {
    AppMethodBeat.i(67586);
    this.b = 0L;
    this.f = paramLong;
    this.h = 0L;
    this.g = 0L;
    if ((this.k != null) && (this.f == 0L))
    {
      this.k.stopDownload();
      this.k = null;
    }
    AppMethodBeat.o(67586);
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(67593);
    if ((paramInt == -2301) || (paramInt == 3010))
    {
      paramBundle = (d)this.l.get();
      if (paramBundle != null) {
        paramBundle.a(this.k, false);
      }
      this.k.setNotifyListener(null);
    }
    AppMethodBeat.o(67593);
  }
  
  public void onPullAudio(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(146782);
    if (this.b > 0L)
    {
      a(parama);
      AppMethodBeat.o(146782);
      return;
    }
    if (this.f > 0L)
    {
      b(parama);
      AppMethodBeat.o(146782);
      return;
    }
    if (this.m != null) {
      this.m.onPullAudio(parama);
    }
    AppMethodBeat.o(146782);
  }
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(146783);
    if (paramTXSNALPacket == null)
    {
      AppMethodBeat.o(146783);
      return;
    }
    if (this.b > 0L)
    {
      a(paramTXSNALPacket);
      AppMethodBeat.o(146783);
      return;
    }
    if (this.f > 0L)
    {
      b(paramTXSNALPacket);
      AppMethodBeat.o(146783);
      return;
    }
    if (this.m != null) {
      this.m.onPullNAL(paramTXSNALPacket);
    }
    AppMethodBeat.o(146783);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.network.d.b
 * JD-Core Version:    0.7.0.1
 */