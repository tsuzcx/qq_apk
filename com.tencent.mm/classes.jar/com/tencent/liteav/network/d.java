package com.tencent.liteav.network;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

public class d
  implements f
{
  private f a = null;
  private b b = null;
  private long c = 0L;
  private long d = 0L;
  private b e = null;
  private a f;
  private long g = 0L;
  private long h = 0L;
  
  public d(a parama)
  {
    this.f = parama;
  }
  
  long a(long paramLong)
  {
    AppMethodBeat.i(15404);
    if (this.b != null) {
      this.b.b(this.c);
    }
    TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop begin from " + this.c);
    paramLong = this.c;
    AppMethodBeat.o(15404);
    return paramLong;
  }
  
  public void a()
  {
    AppMethodBeat.i(15400);
    if (this.b != null) {
      this.b.b(0L);
    }
    if (this.e != null) {
      this.e.b(0L);
    }
    AppMethodBeat.o(15400);
  }
  
  public void a(TXIStreamDownloader paramTXIStreamDownloader1, TXIStreamDownloader paramTXIStreamDownloader2, long paramLong1, long paramLong2, String paramString)
  {
    AppMethodBeat.i(15401);
    this.c = paramTXIStreamDownloader1.getCurrentTS();
    this.d = paramTXIStreamDownloader1.getLastIFrameTS();
    this.b = new b(paramTXIStreamDownloader1, this);
    this.b.a(this);
    ((TXCFLVDownloader)paramTXIStreamDownloader1).recvData(true);
    Vector localVector = new Vector();
    localVector.add(new e(paramString, false));
    paramTXIStreamDownloader2.setOriginUrl(paramString);
    ((TXCFLVDownloader)paramTXIStreamDownloader2).recvData(true);
    paramTXIStreamDownloader2.startDownload(localVector, false, false, paramTXIStreamDownloader1.mEnableMessage, paramTXIStreamDownloader1.mEnableMetaData);
    this.e = new b(paramTXIStreamDownloader2, this);
    this.e.a(this.c);
    AppMethodBeat.o(15401);
  }
  
  void a(TXIStreamDownloader paramTXIStreamDownloader, boolean paramBoolean)
  {
    AppMethodBeat.i(15403);
    if (this.f != null) {
      this.f.onSwitchFinish(paramTXIStreamDownloader, paramBoolean);
    }
    AppMethodBeat.o(15403);
  }
  
  public void a(f paramf)
  {
    this.a = paramf;
  }
  
  public void b()
  {
    AppMethodBeat.i(15402);
    this.b.a(null);
    this.e.a(this);
    this.b = this.e;
    this.e = null;
    StringBuilder localStringBuilder = new StringBuilder(" stream_switch end at ").append(this.c).append(" stop ts ").append(this.h).append(" start ts ").append(this.g).append(" diff ts ");
    if (this.h > this.g) {}
    for (long l = this.h - this.g;; l = this.g - this.h)
    {
      TXCLog.w("TXCMultiStreamDownloader", l);
      AppMethodBeat.o(15402);
      return;
    }
  }
  
  void b(long paramLong)
  {
    this.g = paramLong;
  }
  
  void c(long paramLong)
  {
    this.h = paramLong;
  }
  
  public void onPullAudio(com.tencent.liteav.basic.structs.a parama)
  {
    AppMethodBeat.i(15405);
    if (this.a != null) {
      this.a.onPullAudio(parama);
    }
    AppMethodBeat.o(15405);
  }
  
  public void onPullNAL(TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(15406);
    this.c = paramTXSNALPacket.pts;
    if (paramTXSNALPacket.nalType == 0) {
      this.d = paramTXSNALPacket.pts;
    }
    if (this.a != null) {
      this.a.onPullNAL(paramTXSNALPacket);
    }
    AppMethodBeat.o(15406);
  }
  
  public static abstract interface a
  {
    public abstract void onSwitchFinish(TXIStreamDownloader paramTXIStreamDownloader, boolean paramBoolean);
  }
  
  static class b
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
    
    public b(TXIStreamDownloader paramTXIStreamDownloader, d paramd)
    {
      AppMethodBeat.i(15490);
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
      AppMethodBeat.o(15490);
    }
    
    private void a(TXSNALPacket paramTXSNALPacket)
    {
      AppMethodBeat.i(15497);
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
        AppMethodBeat.o(15497);
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
            AppMethodBeat.o(15497);
            return;
          }
          TXCLog.i("TXCMultiStreamDownloader", " stream_switch pre start cache video pts " + paramTXSNALPacket.pts + " from " + this.c + " type " + paramTXSNALPacket.nalType);
          this.i.add(paramTXSNALPacket);
        }
      }
      AppMethodBeat.o(15497);
    }
    
    private void a(com.tencent.liteav.basic.structs.a parama)
    {
      AppMethodBeat.i(15495);
      if (parama == null)
      {
        AppMethodBeat.o(15495);
        return;
      }
      if ((parama.e < this.c) || (parama.e < this.b))
      {
        AppMethodBeat.o(15495);
        return;
      }
      if ((this.m != null) && (this.c > 0L) && (parama.e >= this.c))
      {
        this.m.onPullAudio(parama);
        AppMethodBeat.o(15495);
        return;
      }
      this.j.add(parama);
      AppMethodBeat.o(15495);
    }
    
    private void b(TXSNALPacket paramTXSNALPacket)
    {
      AppMethodBeat.i(15498);
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
            AppMethodBeat.o(15498);
            return;
          }
          TXCLog.w("TXCMultiStreamDownloader", " stream_switch delay stop video end wait audio end video pts " + paramTXSNALPacket.pts + " from " + this.f + " type " + paramTXSNALPacket.nalType);
          AppMethodBeat.o(15498);
          return;
        }
        if (this.m != null)
        {
          this.m.onPullNAL(paramTXSNALPacket);
          AppMethodBeat.o(15498);
        }
      }
      else if (this.m != null)
      {
        this.m.onPullNAL(paramTXSNALPacket);
      }
      AppMethodBeat.o(15498);
    }
    
    private void b(com.tencent.liteav.basic.structs.a parama)
    {
      AppMethodBeat.i(15496);
      if (this.h > 0L)
      {
        AppMethodBeat.o(15496);
        return;
      }
      if ((this.g > 0L) && (parama != null) && (parama.e >= this.g))
      {
        this.h = parama.e;
        AppMethodBeat.o(15496);
        return;
      }
      if (this.m != null) {
        this.m.onPullAudio(parama);
      }
      AppMethodBeat.o(15496);
    }
    
    public void a(long paramLong)
    {
      AppMethodBeat.i(15491);
      this.d = 0;
      this.b = paramLong;
      this.k.setListener(this);
      this.k.setNotifyListener(this);
      AppMethodBeat.o(15491);
    }
    
    public void a(f paramf)
    {
      this.m = paramf;
    }
    
    public void b(long paramLong)
    {
      AppMethodBeat.i(15492);
      this.b = 0L;
      this.f = paramLong;
      this.h = 0L;
      this.g = 0L;
      if ((this.k != null) && (this.f == 0L))
      {
        this.k.stopDownload();
        this.k = null;
      }
      AppMethodBeat.o(15492);
    }
    
    public void onNotifyEvent(int paramInt, Bundle paramBundle)
    {
      AppMethodBeat.i(15499);
      if ((paramInt == -2301) || (paramInt == 3010))
      {
        paramBundle = (d)this.l.get();
        if (paramBundle != null) {
          paramBundle.a(this.k, false);
        }
        this.k.setNotifyListener(null);
      }
      AppMethodBeat.o(15499);
    }
    
    public void onPullAudio(com.tencent.liteav.basic.structs.a parama)
    {
      AppMethodBeat.i(15493);
      if (this.b > 0L)
      {
        a(parama);
        AppMethodBeat.o(15493);
        return;
      }
      if (this.f > 0L)
      {
        b(parama);
        AppMethodBeat.o(15493);
        return;
      }
      if (this.m != null) {
        this.m.onPullAudio(parama);
      }
      AppMethodBeat.o(15493);
    }
    
    public void onPullNAL(TXSNALPacket paramTXSNALPacket)
    {
      AppMethodBeat.i(15494);
      if (paramTXSNALPacket == null)
      {
        AppMethodBeat.o(15494);
        return;
      }
      if (this.b > 0L)
      {
        a(paramTXSNALPacket);
        AppMethodBeat.o(15494);
        return;
      }
      if (this.f > 0L)
      {
        b(paramTXSNALPacket);
        AppMethodBeat.o(15494);
        return;
      }
      if (this.m != null) {
        this.m.onPullNAL(paramTXSNALPacket);
      }
      AppMethodBeat.o(15494);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.d
 * JD-Core Version:    0.7.0.1
 */