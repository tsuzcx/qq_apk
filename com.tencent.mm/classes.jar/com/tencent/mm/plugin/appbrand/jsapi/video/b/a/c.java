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
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.m;
import java.io.IOException;

public final class c
  implements e
{
  private long bwt;
  private final boolean bxP;
  private final boolean bxQ;
  private long bxU;
  private long bxY;
  private int flags;
  private long iOo;
  private String key;
  private long koA;
  private final e koB;
  private final e koC;
  public final e koD;
  private final a koE;
  private e koF;
  private f koG;
  private boolean koH;
  private boolean koI;
  private final a kos;
  private String kox;
  private long koy;
  private int koz;
  private int priority;
  private Uri uri;
  private String uuid;
  
  public c(a parama, e parame1, e parame2, d paramd, a parama1)
  {
    AppMethodBeat.i(193814);
    this.koy = 0L;
    this.kox = "";
    this.kos = parama;
    this.koB = parame2;
    this.bxP = false;
    this.bxQ = true;
    this.koD = parame1;
    if (paramd != null) {}
    for (this.koC = new r(parame1, paramd);; this.koC = null)
    {
      this.koE = parama1;
      AppMethodBeat.o(193814);
      return;
    }
  }
  
  private String EE()
  {
    AppMethodBeat.i(193824);
    String str = this.kox + "CacheDataSource";
    AppMethodBeat.o(193824);
    return str;
  }
  
  private void b(IOException paramIOException)
  {
    AppMethodBeat.i(193819);
    h.log(3, EE(), "handleBeforeThrow " + paramIOException + ", ignoreCacheOnError=" + this.bxQ + ", currentDataSource=" + this.koF);
    if ((this.bxQ) && (this.koF == this.koB))
    {
      h.log(4, EE(), "handleBeforeThrow currentDataSource=" + this.koF + ", exception=" + paramIOException);
      this.koH = true;
    }
    AppMethodBeat.o(193819);
  }
  
  private long bcV()
  {
    int i = 0;
    AppMethodBeat.i(193817);
    for (;;)
    {
      long l1;
      Object localObject2;
      try
      {
        Object localObject1;
        if (this.koH)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            this.koF = this.koD;
            localObject1 = new g(this.uri, this.bxU, this.bxU, this.bwt, this.key, this.flags, this.uuid, this.priority);
            l1 = this.koF.a((g)localObject1);
            if (((this.koF instanceof l)) && (this.koF.aQu() != -1L) && (((g)localObject1).position >= this.koF.aQu() - 1L)) {
              h.log(6, EE(), "read position out of bound");
            }
            if ((this.bwt == -1L) && (this.koF.aQu() != -1L))
            {
              this.bwt = (this.koF.aQu() - this.bxU);
              h.log(4, EE(), "init bytesRemaining " + this.bwt + ", readPosition=" + this.bxU + ", totalLength=" + this.koF.aQu());
            }
            this.bwt = Math.max(0L, Math.min(this.bwt, aQu()));
            this.koI = false;
            AppMethodBeat.o(193817);
            return l1;
          }
        }
        else
        {
          if (this.bxP)
          {
            localObject1 = this.kos.I(this.key, this.bxU);
            continue;
          }
          localObject1 = this.kos.J(this.key, this.bxU);
          continue;
        }
        if (!((f)localObject1).byc) {
          break label546;
        }
        localObject3 = m.a(aj.getContext(), ((f)localObject1).kot);
        l1 = this.bxU - ((f)localObject1).position;
        if (this.bwt == -1L)
        {
          this.bwt = (((f)localObject1).iOo - this.bxU);
          long l2 = Math.min(((f)localObject1).length - l1, this.bwt);
          localObject1 = new g((Uri)localObject3, this.bxU, l1, l2, this.key, this.flags, this.uuid, this.priority);
          localObject3 = this.koB;
          this.koF = ((e)localObject3);
          continue;
        }
        if (this.bwt <= ((f)localObject2).iOo - this.bxU) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject2 = new RuntimeException(localInterruptedException);
        AppMethodBeat.o(193817);
        throw ((Throwable)localObject2);
      }
      h.log(5, EE(), "fix bytesRemaining, max=" + (((f)localObject2).iOo - this.bxU) + " current=" + this.bwt);
      this.bwt = (((f)localObject2).iOo - this.bxU);
      continue;
      label546:
      this.koG = ((f)localObject2);
      if (((f)localObject2).length == -1L) {
        i = 1;
      }
      if (i != 0) {
        l1 = this.bwt;
      }
      for (;;)
      {
        localObject2 = new g(this.uri, this.bxU, this.bxU, l1, this.key, this.flags, this.uuid, this.priority);
        if (this.koC == null) {
          break label665;
        }
        localObject3 = this.koC;
        break;
        if (this.bwt != -1L) {
          l1 = Math.min(((f)localObject2).length, this.bwt);
        } else {
          l1 = ((f)localObject2).length;
        }
      }
      label665:
      Object localObject3 = this.koD;
    }
  }
  
  private void vu()
  {
    AppMethodBeat.i(193818);
    if (this.koF == null)
    {
      AppMethodBeat.o(193818);
      return;
    }
    try
    {
      this.koF.close();
      this.koF = null;
      return;
    }
    finally
    {
      if (this.koG != null)
      {
        this.kos.a(this.koG);
        this.koG = null;
      }
      AppMethodBeat.o(193818);
    }
    AppMethodBeat.o(193818);
  }
  
  public final void Jk(String paramString)
  {
    this.kox = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(193815);
    long l1;
    long l2;
    try
    {
      this.uri = paramg.uri;
      this.flags = paramg.flags;
      this.uuid = paramg.uuid;
      this.key = paramg.key;
      this.bxU = paramg.position;
      this.bwt = paramg.length;
      this.priority = paramg.priority;
      l1 = System.currentTimeMillis();
      l2 = bcV();
      this.iOo = aQu();
      this.koy = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(193815);
      return l2;
    }
    catch (IOException paramg)
    {
      if ((this.koF instanceof k)) {
        h.log(6, EE(), "open cache error " + paramg.toString());
      }
      for (;;)
      {
        b(paramg);
        if (this.koH) {
          break;
        }
        AppMethodBeat.o(193815);
        throw paramg;
        h.log(6, EE(), "open error " + paramg.toString());
      }
    }
    try
    {
      vu();
      h.log(6, EE(), "open cache error, try reopen without cache");
      l1 = System.currentTimeMillis();
      l2 = bcV();
      this.iOo = aQu();
      this.koy = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(193815);
      return l2;
    }
    catch (Exception paramg)
    {
      for (;;)
      {
        h.a(5, EE(), "open, failed on closeCurrentSource, shouldn't be a problem", paramg);
      }
    }
  }
  
  public final long aQu()
  {
    AppMethodBeat.i(193823);
    if (this.koF == null)
    {
      AppMethodBeat.o(193823);
      return -1L;
    }
    if ((this.koF == this.koB) && (this.kos != null))
    {
      l = this.kos.Jh(this.key);
      AppMethodBeat.o(193823);
      return l;
    }
    long l = this.koF.aQu();
    AppMethodBeat.o(193823);
    return l;
  }
  
  public final long available()
  {
    AppMethodBeat.i(193820);
    if (this.koF == null)
    {
      AppMethodBeat.o(193820);
      return 0L;
    }
    long l = this.koF.available();
    AppMethodBeat.o(193820);
    return l;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c bcW()
  {
    AppMethodBeat.i(193822);
    if (this.koF == null)
    {
      localc = com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c.kpv;
      AppMethodBeat.o(193822);
      return localc;
    }
    if ((this.koF == this.koB) && (this.kos != null))
    {
      localc = this.kos.Ji(this.key);
      AppMethodBeat.o(193822);
      return localc;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c localc = this.koF.bcW();
    AppMethodBeat.o(193822);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(193821);
    try
    {
      vu();
      AppMethodBeat.o(193821);
      return;
    }
    catch (IOException localIOException)
    {
      if (!(this.koF instanceof k)) {
        break label70;
      }
    }
    h.log(6, EE(), "close cache error " + localIOException.toString());
    for (;;)
    {
      b(localIOException);
      AppMethodBeat.o(193821);
      throw localIOException;
      label70:
      h.log(6, EE(), "close error " + localIOException.toString());
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193816);
    try
    {
      if ((!this.koI) && ((this.koF instanceof k)) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().cxf)) {
        h.log(4, EE(), "read from cache " + ((k)this.koF).getUri() + ", fileSize=" + this.koF.available());
      }
      long l = System.currentTimeMillis();
      int i = this.koF.read(paramArrayOfByte, paramInt1, paramInt2);
      l = System.currentTimeMillis() - l;
      if (!this.koI)
      {
        if ((this.koF != this.koB) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bcR().kop != null) && (this.priority == 90) && (URLUtil.isNetworkUrl(this.uri.toString())) && (this.koE != null)) {
          this.koE.b(this.uuid, this.koy, this.koy, l);
        }
        this.koI = true;
      }
      if (i >= 0)
      {
        if (this.koF == this.koB) {
          this.bxY += i;
        }
        for (;;)
        {
          this.bxU += i;
          if (this.bwt != -1L) {
            this.bwt -= i;
          }
          AppMethodBeat.o(193816);
          return i;
          this.koz += i;
          this.koA += l;
        }
        h.log(6, EE(), "read cache error " + paramArrayOfByte.toString());
      }
    }
    catch (IOException paramArrayOfByte)
    {
      if (!(this.koF instanceof k)) {}
    }
    for (;;)
    {
      b(paramArrayOfByte);
      AppMethodBeat.o(193816);
      throw paramArrayOfByte;
      if (this.koE != null)
      {
        if (this.priority == 90) {
          this.koE.a(this.uuid, this.koz, this.koA, this.iOo, this.bxY);
        }
        this.koz = 0;
        this.koA = 0L;
        if ((this.koF == this.koB) && (this.bxY > 0L))
        {
          this.koE.m(this.kos.vr(), this.bxY);
          this.bxY = 0L;
        }
      }
      vu();
      if (this.bwt <= 0L) {
        break;
      }
      bcV();
      paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(193816);
      return paramInt1;
      h.log(6, EE(), "read error " + paramArrayOfByte.toString());
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void b(String paramString, long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void m(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c
 * JD-Core Version:    0.7.0.1
 */