package com.tencent.mm.plugin.appbrand.jsapi.video.b.a;

import android.net.Uri;
import android.webkit.URLUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.d;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.g;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.k;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.l;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.b.r;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.m;
import java.io.IOException;

public final class c
  implements e
{
  private long bus;
  private long bvD;
  private long bvH;
  private final boolean bvy;
  private final boolean bvz;
  private int flags;
  private long jox;
  private final a kPL;
  private String kPQ;
  private long kPR;
  private int kPS;
  private long kPT;
  private final e kPU;
  private final e kPV;
  public final e kPW;
  private final a kPX;
  private e kPY;
  private f kPZ;
  private boolean kQa;
  private boolean kQb;
  private String key;
  private int priority;
  private Uri uri;
  private String uuid;
  
  public c(a parama, e parame1, e parame2, d paramd, a parama1)
  {
    AppMethodBeat.i(194161);
    this.kPR = 0L;
    this.kPQ = "";
    this.kPL = parama;
    this.kPU = parame2;
    this.bvy = false;
    this.bvz = true;
    this.kPW = parame1;
    if (paramd != null) {}
    for (this.kPV = new r(parame1, paramd);; this.kPV = null)
    {
      this.kPX = parama1;
      AppMethodBeat.o(194161);
      return;
    }
  }
  
  private void b(IOException paramIOException)
  {
    AppMethodBeat.i(194166);
    h.log(3, getLogTag(), "handleBeforeThrow " + paramIOException + ", ignoreCacheOnError=" + this.bvz + ", currentDataSource=" + this.kPY);
    if ((this.bvz) && (this.kPY == this.kPU))
    {
      h.log(4, getLogTag(), "handleBeforeThrow currentDataSource=" + this.kPY + ", exception=" + paramIOException);
      this.kQa = true;
    }
    AppMethodBeat.o(194166);
  }
  
  private long bjQ()
  {
    int i = 0;
    AppMethodBeat.i(194164);
    for (;;)
    {
      long l1;
      Object localObject2;
      try
      {
        Object localObject1;
        if (this.kQa)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            this.kPY = this.kPW;
            localObject1 = new g(this.uri, this.bvD, this.bvD, this.bus, this.key, this.flags, this.uuid, this.priority);
            l1 = this.kPY.a((g)localObject1);
            if (((this.kPY instanceof l)) && (this.kPY.aXm() != -1L) && (((g)localObject1).position >= this.kPY.aXm() - 1L)) {
              h.log(6, getLogTag(), "read position out of bound");
            }
            if ((this.bus == -1L) && (this.kPY.aXm() != -1L))
            {
              this.bus = (this.kPY.aXm() - this.bvD);
              h.log(4, getLogTag(), "init bytesRemaining " + this.bus + ", readPosition=" + this.bvD + ", totalLength=" + this.kPY.aXm());
            }
            this.bus = Math.max(0L, Math.min(this.bus, aXm()));
            this.kQb = false;
            AppMethodBeat.o(194164);
            return l1;
          }
        }
        else
        {
          if (this.bvy)
          {
            localObject1 = this.kPL.J(this.key, this.bvD);
            continue;
          }
          localObject1 = this.kPL.K(this.key, this.bvD);
          continue;
        }
        if (!((f)localObject1).bvL) {
          break label546;
        }
        localObject3 = m.a(ai.getContext(), ((f)localObject1).kPM);
        l1 = this.bvD - ((f)localObject1).position;
        if (this.bus == -1L)
        {
          this.bus = (((f)localObject1).jox - this.bvD);
          long l2 = Math.min(((f)localObject1).length - l1, this.bus);
          localObject1 = new g((Uri)localObject3, this.bvD, l1, l2, this.key, this.flags, this.uuid, this.priority);
          localObject3 = this.kPU;
          this.kPY = ((e)localObject3);
          continue;
        }
        if (this.bus <= ((f)localObject2).jox - this.bvD) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject2 = new RuntimeException(localInterruptedException);
        AppMethodBeat.o(194164);
        throw ((Throwable)localObject2);
      }
      h.log(5, getLogTag(), "fix bytesRemaining, max=" + (((f)localObject2).jox - this.bvD) + " current=" + this.bus);
      this.bus = (((f)localObject2).jox - this.bvD);
      continue;
      label546:
      this.kPZ = ((f)localObject2);
      if (((f)localObject2).length == -1L) {
        i = 1;
      }
      if (i != 0) {
        l1 = this.bus;
      }
      for (;;)
      {
        localObject2 = new g(this.uri, this.bvD, this.bvD, l1, this.key, this.flags, this.uuid, this.priority);
        if (this.kPV == null) {
          break label665;
        }
        localObject3 = this.kPV;
        break;
        if (this.bus != -1L) {
          l1 = Math.min(((f)localObject2).length, this.bus);
        } else {
          l1 = ((f)localObject2).length;
        }
      }
      label665:
      Object localObject3 = this.kPW;
    }
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(194171);
    String str = this.kPQ + "CacheDataSource";
    AppMethodBeat.o(194171);
    return str;
  }
  
  private void vl()
  {
    AppMethodBeat.i(194165);
    if (this.kPY == null)
    {
      AppMethodBeat.o(194165);
      return;
    }
    try
    {
      this.kPY.close();
      this.kPY = null;
      return;
    }
    finally
    {
      if (this.kPZ != null)
      {
        this.kPL.a(this.kPZ);
        this.kPZ = null;
      }
      AppMethodBeat.o(194165);
    }
    AppMethodBeat.o(194165);
  }
  
  public final void No(String paramString)
  {
    this.kPQ = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(194162);
    long l1;
    long l2;
    try
    {
      this.uri = paramg.uri;
      this.flags = paramg.flags;
      this.uuid = paramg.uuid;
      this.key = paramg.key;
      this.bvD = paramg.position;
      this.bus = paramg.length;
      this.priority = paramg.priority;
      l1 = System.currentTimeMillis();
      l2 = bjQ();
      this.jox = aXm();
      this.kPR = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(194162);
      return l2;
    }
    catch (IOException paramg)
    {
      if ((this.kPY instanceof k)) {
        h.log(6, getLogTag(), "open cache error " + paramg.toString());
      }
      for (;;)
      {
        b(paramg);
        if (this.kQa) {
          break;
        }
        AppMethodBeat.o(194162);
        throw paramg;
        h.log(6, getLogTag(), "open error " + paramg.toString());
      }
    }
    try
    {
      vl();
      h.log(6, getLogTag(), "open cache error, try reopen without cache");
      l1 = System.currentTimeMillis();
      l2 = bjQ();
      this.jox = aXm();
      this.kPR = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(194162);
      return l2;
    }
    catch (Exception paramg)
    {
      for (;;)
      {
        h.a(5, getLogTag(), "open, failed on closeCurrentSource, shouldn't be a problem", paramg);
      }
    }
  }
  
  public final long aXm()
  {
    AppMethodBeat.i(194170);
    if (this.kPY == null)
    {
      AppMethodBeat.o(194170);
      return -1L;
    }
    if ((this.kPY == this.kPU) && (this.kPL != null))
    {
      l = this.kPL.Nl(this.key);
      AppMethodBeat.o(194170);
      return l;
    }
    long l = this.kPY.aXm();
    AppMethodBeat.o(194170);
    return l;
  }
  
  public final long available()
  {
    AppMethodBeat.i(194167);
    if (this.kPY == null)
    {
      AppMethodBeat.o(194167);
      return 0L;
    }
    long l = this.kPY.available();
    AppMethodBeat.o(194167);
    return l;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c bjR()
  {
    AppMethodBeat.i(194169);
    if (this.kPY == null)
    {
      localc = com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c.kQO;
      AppMethodBeat.o(194169);
      return localc;
    }
    if ((this.kPY == this.kPU) && (this.kPL != null))
    {
      localc = this.kPL.Nm(this.key);
      AppMethodBeat.o(194169);
      return localc;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c localc = this.kPY.bjR();
    AppMethodBeat.o(194169);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(194168);
    try
    {
      vl();
      AppMethodBeat.o(194168);
      return;
    }
    catch (IOException localIOException)
    {
      if (!(this.kPY instanceof k)) {
        break label70;
      }
    }
    h.log(6, getLogTag(), "close cache error " + localIOException.toString());
    for (;;)
    {
      b(localIOException);
      AppMethodBeat.o(194168);
      throw localIOException;
      label70:
      h.log(6, getLogTag(), "close error " + localIOException.toString());
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(194163);
    try
    {
      if ((!this.kQb) && ((this.kPY instanceof k)) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().cuo)) {
        h.log(4, getLogTag(), "read from cache " + ((k)this.kPY).getUri() + ", fileSize=" + this.kPY.available());
      }
      long l = System.currentTimeMillis();
      int i = this.kPY.read(paramArrayOfByte, paramInt1, paramInt2);
      l = System.currentTimeMillis() - l;
      if (!this.kQb)
      {
        if ((this.kPY != this.kPU) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bjM().kPI != null) && (this.priority == 90) && (URLUtil.isNetworkUrl(this.uri.toString())) && (this.kPX != null)) {
          this.kPX.b(this.uuid, this.kPR, this.kPR, l);
        }
        this.kQb = true;
      }
      if (i >= 0)
      {
        if (this.kPY == this.kPU) {
          this.bvH += i;
        }
        for (;;)
        {
          this.bvD += i;
          if (this.bus != -1L) {
            this.bus -= i;
          }
          AppMethodBeat.o(194163);
          return i;
          this.kPS += i;
          this.kPT += l;
        }
        h.log(6, getLogTag(), "read cache error " + paramArrayOfByte.toString());
      }
    }
    catch (IOException paramArrayOfByte)
    {
      if (!(this.kPY instanceof k)) {}
    }
    for (;;)
    {
      b(paramArrayOfByte);
      AppMethodBeat.o(194163);
      throw paramArrayOfByte;
      if (this.kPX != null)
      {
        if (this.priority == 90) {
          this.kPX.a(this.uuid, this.kPS, this.kPT, this.jox, this.bvH);
        }
        this.kPS = 0;
        this.kPT = 0L;
        if ((this.kPY == this.kPU) && (this.bvH > 0L))
        {
          this.kPX.k(this.kPL.vi(), this.bvH);
          this.bvH = 0L;
        }
      }
      vl();
      if (this.bus <= 0L) {
        break;
      }
      bjQ();
      paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(194163);
      return paramInt1;
      h.log(6, getLogTag(), "read error " + paramArrayOfByte.toString());
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void b(String paramString, long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void k(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c
 * JD-Core Version:    0.7.0.1
 */