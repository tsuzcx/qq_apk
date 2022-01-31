package com.tencent.liteav.network;

import android.os.Bundle;
import com.tencent.liteav.basic.f.b;
import com.tencent.liteav.basic.log.TXCLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class d$b
  implements com.tencent.liteav.basic.c.a, f
{
  private final int a = 2;
  private long b = 0L;
  private long c = 0L;
  private int d = 0;
  private boolean e = false;
  private long f = 0L;
  private long g = 0L;
  private long h = 0L;
  private ArrayList<b> i = new ArrayList();
  private ArrayList<com.tencent.liteav.basic.f.a> j = new ArrayList();
  private TXIStreamDownloader k = null;
  private WeakReference<d> l;
  private f m;
  
  public d$b(TXIStreamDownloader paramTXIStreamDownloader, d paramd)
  {
    this.l = new WeakReference(paramd);
    this.k = paramTXIStreamDownloader;
    this.k.setListener(this);
  }
  
  private void a(com.tencent.liteav.basic.f.a parama)
  {
    if (parama == null) {}
    while ((parama.e < this.c) || (parama.e < this.b)) {
      return;
    }
    if ((this.m != null) && (this.c > 0L) && (parama.e >= this.c))
    {
      this.m.onPullAudio(parama);
      return;
    }
    this.j.add(parama);
  }
  
  private void a(b paramb)
  {
    d locald = (d)this.l.get();
    if ((paramb.b == 0) && (!this.e))
    {
      this.d += 1;
      if ((locald != null) && ((d.a(locald) <= paramb.g) || (this.d == 2)))
      {
        this.b = locald.a(paramb.g);
        this.e = true;
      }
      TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start begin gop " + this.d + " last iframe ts " + d.a(locald) + " pts " + paramb.g + " from " + this.b + " type " + paramb.b);
    }
    if (!this.e) {}
    do
    {
      do
      {
        return;
        if (locald != null) {
          locald.b(paramb.g);
        }
      } while (paramb.g < this.b);
      if ((paramb.b == 0) && (this.c == 0L))
      {
        this.c = paramb.g;
        TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end " + paramb.g + " from " + this.b + " type " + paramb.b);
      }
    } while (this.c <= 0L);
    if (this.m != null)
    {
      Iterator localIterator;
      Object localObject;
      if (!this.j.isEmpty())
      {
        localIterator = this.j.iterator();
        while (localIterator.hasNext())
        {
          localObject = (com.tencent.liteav.basic.f.a)localIterator.next();
          if (((com.tencent.liteav.basic.f.a)localObject).e >= this.c)
          {
            TXCLog.i("TXCMultiStreamDownloader", " stream_switch pre start cache audio pts " + ((com.tencent.liteav.basic.f.a)localObject).e + " from " + this.c);
            this.m.onPullAudio((com.tencent.liteav.basic.f.a)localObject);
          }
        }
        TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end audio cache  " + this.j.size());
        this.j.clear();
      }
      if (!this.i.isEmpty())
      {
        TXCLog.w("TXCMultiStreamDownloader", " stream_switch pre start end video cache  " + this.i.size());
        localIterator = this.i.iterator();
        while (localIterator.hasNext())
        {
          localObject = (b)localIterator.next();
          this.m.onPullNAL((b)localObject);
        }
        this.i.clear();
      }
      this.m.onPullNAL(paramb);
      this.m = null;
      if (locald != null) {
        locald.a(this.k, true);
      }
      this.k.setNotifyListener(null);
      return;
    }
    TXCLog.i("TXCMultiStreamDownloader", " stream_switch pre start cache video pts " + paramb.g + " from " + this.c + " type " + paramb.b);
    this.i.add(paramb);
  }
  
  private void b(com.tencent.liteav.basic.f.a parama)
  {
    if (this.h > 0L) {}
    do
    {
      return;
      if ((this.g > 0L) && (parama != null) && (parama.e >= this.g))
      {
        this.h = parama.e;
        return;
      }
    } while (this.m == null);
    this.m.onPullAudio(parama);
  }
  
  private void b(b paramb)
  {
    d locald = (d)this.l.get();
    if (locald != null) {
      locald.c(paramb.g);
    }
    if (paramb.g >= this.f)
    {
      if (paramb.b == 0) {
        this.g = paramb.g;
      }
      if (this.g > 0L) {
        if (this.h > 0L)
        {
          TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop end video pts " + this.g + " audio ts " + this.h + " from " + this.f);
          if (locald != null) {
            locald.b();
          }
          this.m = null;
          this.k.setListener(null);
          this.k.stopDownload();
        }
      }
    }
    while (this.m == null)
    {
      do
      {
        return;
        TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop video end wait audio end video pts " + paramb.g + " from " + this.f + " type " + paramb.b);
        return;
      } while (this.m == null);
      this.m.onPullNAL(paramb);
      return;
    }
    this.m.onPullNAL(paramb);
  }
  
  public void a(long paramLong)
  {
    this.d = 0;
    this.b = paramLong;
    this.k.setListener(this);
    this.k.setNotifyListener(this);
  }
  
  public void a(f paramf)
  {
    this.m = paramf;
  }
  
  public void b(long paramLong)
  {
    this.b = 0L;
    this.f = paramLong;
    this.h = 0L;
    this.g = 0L;
    if ((this.k != null) && (this.f == 0L))
    {
      this.k.stopDownload();
      this.k = null;
    }
  }
  
  public void onNotifyEvent(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 12012) || (paramInt == 12011))
    {
      paramBundle = (d)this.l.get();
      if (paramBundle != null) {
        paramBundle.a(this.k, false);
      }
      this.k.setNotifyListener(null);
    }
  }
  
  public void onPullAudio(com.tencent.liteav.basic.f.a parama)
  {
    if (this.b > 0L) {
      a(parama);
    }
    do
    {
      return;
      if (this.f > 0L)
      {
        b(parama);
        return;
      }
    } while (this.m == null);
    this.m.onPullAudio(parama);
  }
  
  public void onPullNAL(b paramb)
  {
    if (paramb == null) {}
    do
    {
      return;
      if (this.b > 0L)
      {
        a(paramb);
        return;
      }
      if (this.f > 0L)
      {
        b(paramb);
        return;
      }
    } while (this.m == null);
    this.m.onPullNAL(paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.network.d.b
 * JD-Core Version:    0.7.0.1
 */