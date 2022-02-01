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
import com.tencent.mm.sdk.platformtools.n;
import java.io.IOException;

public final class c
  implements e
{
  private long bEH;
  private final boolean bFM;
  private final boolean bFN;
  private long bFR;
  private long bFV;
  private int flags;
  private long jIt;
  private String key;
  private boolean lmA;
  private boolean lmB;
  private final a lmm;
  private String lmq;
  private long lmr;
  private int lms;
  private long lmt;
  private final e lmu;
  private final e lmv;
  public final e lmw;
  private final a lmx;
  private e lmy;
  private f lmz;
  private int priority;
  private Uri uri;
  private String uuid;
  
  public c(a parama, e parame1, e parame2, d paramd, a parama1)
  {
    AppMethodBeat.i(205973);
    this.lmr = 0L;
    this.lmq = "";
    this.lmm = parama;
    this.lmu = parame2;
    this.bFM = false;
    this.bFN = true;
    this.lmw = parame1;
    if (paramd != null) {}
    for (this.lmv = new r(parame1, paramd);; this.lmv = null)
    {
      this.lmx = parama1;
      AppMethodBeat.o(205973);
      return;
    }
  }
  
  private void b(IOException paramIOException)
  {
    AppMethodBeat.i(205978);
    h.log(3, getLogTag(), "handleBeforeThrow " + paramIOException + ", ignoreCacheOnError=" + this.bFN + ", currentDataSource=" + this.lmy);
    if ((this.bFN) && (this.lmy == this.lmu))
    {
      h.log(4, getLogTag(), "handleBeforeThrow currentDataSource=" + this.lmy + ", exception=" + paramIOException);
      this.lmA = true;
    }
    AppMethodBeat.o(205978);
  }
  
  private long bnB()
  {
    int i = 0;
    AppMethodBeat.i(205976);
    for (;;)
    {
      long l1;
      Object localObject2;
      try
      {
        Object localObject1;
        if (this.lmA)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            this.lmy = this.lmw;
            localObject1 = new g(this.uri, this.bFR, this.bFR, this.bEH, this.key, this.flags, this.uuid, this.priority);
            l1 = this.lmy.a((g)localObject1);
            if (((this.lmy instanceof l)) && (this.lmy.baK() != -1L) && (((g)localObject1).position >= this.lmy.baK() - 1L)) {
              h.log(6, getLogTag(), "read position out of bound");
            }
            if ((this.bEH == -1L) && (this.lmy.baK() != -1L))
            {
              this.bEH = (this.lmy.baK() - this.bFR);
              h.log(4, getLogTag(), "init bytesRemaining " + this.bEH + ", readPosition=" + this.bFR + ", totalLength=" + this.lmy.baK());
            }
            this.bEH = Math.max(0L, Math.min(this.bEH, baK()));
            this.lmB = false;
            AppMethodBeat.o(205976);
            return l1;
          }
        }
        else
        {
          if (this.bFM)
          {
            localObject1 = this.lmm.Q(this.key, this.bFR);
            continue;
          }
          localObject1 = this.lmm.R(this.key, this.bFR);
          continue;
        }
        if (!((f)localObject1).bFZ) {
          break label546;
        }
        localObject3 = n.a(aj.getContext(), ((f)localObject1).aXd);
        l1 = this.bFR - ((f)localObject1).position;
        if (this.bEH == -1L)
        {
          this.bEH = (((f)localObject1).jIt - this.bFR);
          long l2 = Math.min(((f)localObject1).length - l1, this.bEH);
          localObject1 = new g((Uri)localObject3, this.bFR, l1, l2, this.key, this.flags, this.uuid, this.priority);
          localObject3 = this.lmu;
          this.lmy = ((e)localObject3);
          continue;
        }
        if (this.bEH <= ((f)localObject2).jIt - this.bFR) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject2 = new RuntimeException(localInterruptedException);
        AppMethodBeat.o(205976);
        throw ((Throwable)localObject2);
      }
      h.log(5, getLogTag(), "fix bytesRemaining, max=" + (((f)localObject2).jIt - this.bFR) + " current=" + this.bEH);
      this.bEH = (((f)localObject2).jIt - this.bFR);
      continue;
      label546:
      this.lmz = ((f)localObject2);
      if (((f)localObject2).length == -1L) {
        i = 1;
      }
      if (i != 0) {
        l1 = this.bEH;
      }
      for (;;)
      {
        localObject2 = new g(this.uri, this.bFR, this.bFR, l1, this.key, this.flags, this.uuid, this.priority);
        if (this.lmv == null) {
          break label665;
        }
        localObject3 = this.lmv;
        break;
        if (this.bEH != -1L) {
          l1 = Math.min(((f)localObject2).length, this.bEH);
        } else {
          l1 = ((f)localObject2).length;
        }
      }
      label665:
      Object localObject3 = this.lmw;
    }
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(205983);
    String str = this.lmq + "CacheDataSource";
    AppMethodBeat.o(205983);
    return str;
  }
  
  private void wI()
  {
    AppMethodBeat.i(205977);
    if (this.lmy == null)
    {
      AppMethodBeat.o(205977);
      return;
    }
    try
    {
      this.lmy.close();
      this.lmy = null;
      return;
    }
    finally
    {
      if (this.lmz != null)
      {
        this.lmm.a(this.lmz);
        this.lmz = null;
      }
      AppMethodBeat.o(205977);
    }
    AppMethodBeat.o(205977);
  }
  
  public final void QL(String paramString)
  {
    this.lmq = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(205974);
    long l1;
    long l2;
    try
    {
      this.uri = paramg.uri;
      this.flags = paramg.flags;
      this.uuid = paramg.uuid;
      this.key = paramg.key;
      this.bFR = paramg.position;
      this.bEH = paramg.length;
      this.priority = paramg.priority;
      l1 = System.currentTimeMillis();
      l2 = bnB();
      this.jIt = baK();
      this.lmr = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(205974);
      return l2;
    }
    catch (IOException paramg)
    {
      if ((this.lmy instanceof k)) {
        h.log(6, getLogTag(), "open cache error " + paramg.toString());
      }
      for (;;)
      {
        b(paramg);
        if (this.lmA) {
          break;
        }
        AppMethodBeat.o(205974);
        throw paramg;
        h.log(6, getLogTag(), "open error " + paramg.toString());
      }
    }
    try
    {
      wI();
      h.log(6, getLogTag(), "open cache error, try reopen without cache");
      l1 = System.currentTimeMillis();
      l2 = bnB();
      this.jIt = baK();
      this.lmr = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(205974);
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
  
  public final long available()
  {
    AppMethodBeat.i(205979);
    if (this.lmy == null)
    {
      AppMethodBeat.o(205979);
      return 0L;
    }
    long l = this.lmy.available();
    AppMethodBeat.o(205979);
    return l;
  }
  
  public final long baK()
  {
    AppMethodBeat.i(205982);
    if (this.lmy == null)
    {
      AppMethodBeat.o(205982);
      return -1L;
    }
    if ((this.lmy == this.lmu) && (this.lmm != null))
    {
      l = this.lmm.QI(this.key);
      AppMethodBeat.o(205982);
      return l;
    }
    long l = this.lmy.baK();
    AppMethodBeat.o(205982);
    return l;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c bnC()
  {
    AppMethodBeat.i(205981);
    if (this.lmy == null)
    {
      localc = com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c.lnp;
      AppMethodBeat.o(205981);
      return localc;
    }
    if ((this.lmy == this.lmu) && (this.lmm != null))
    {
      localc = this.lmm.QJ(this.key);
      AppMethodBeat.o(205981);
      return localc;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c localc = this.lmy.bnC();
    AppMethodBeat.o(205981);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(205980);
    try
    {
      wI();
      AppMethodBeat.o(205980);
      return;
    }
    catch (IOException localIOException)
    {
      if (!(this.lmy instanceof k)) {
        break label70;
      }
    }
    h.log(6, getLogTag(), "close cache error " + localIOException.toString());
    for (;;)
    {
      b(localIOException);
      AppMethodBeat.o(205980);
      throw localIOException;
      label70:
      h.log(6, getLogTag(), "close error " + localIOException.toString());
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(205975);
    try
    {
      if ((!this.lmB) && ((this.lmy instanceof k)) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().cFj)) {
        h.log(4, getLogTag(), "read from cache " + ((k)this.lmy).getUri() + ", fileSize=" + this.lmy.available());
      }
      long l = System.currentTimeMillis();
      int i = this.lmy.read(paramArrayOfByte, paramInt1, paramInt2);
      l = System.currentTimeMillis() - l;
      if (!this.lmB)
      {
        if ((this.lmy != this.lmu) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bnx().lmj != null) && (this.priority == 90) && (URLUtil.isNetworkUrl(this.uri.toString())) && (this.lmx != null)) {
          this.lmx.b(this.uuid, this.lmr, this.lmr, l);
        }
        this.lmB = true;
      }
      if (i >= 0)
      {
        if (this.lmy == this.lmu) {
          this.bFV += i;
        }
        for (;;)
        {
          this.bFR += i;
          if (this.bEH != -1L) {
            this.bEH -= i;
          }
          AppMethodBeat.o(205975);
          return i;
          this.lms += i;
          this.lmt += l;
        }
        h.log(6, getLogTag(), "read cache error " + paramArrayOfByte.toString());
      }
    }
    catch (IOException paramArrayOfByte)
    {
      if (!(this.lmy instanceof k)) {}
    }
    for (;;)
    {
      b(paramArrayOfByte);
      AppMethodBeat.o(205975);
      throw paramArrayOfByte;
      if (this.lmx != null)
      {
        if (this.priority == 90) {
          this.lmx.a(this.uuid, this.lms, this.lmt, this.jIt, this.bFV);
        }
        this.lms = 0;
        this.lmt = 0L;
        if ((this.lmy == this.lmu) && (this.bFV > 0L))
        {
          this.lmx.k(this.lmm.wF(), this.bFV);
          this.bFV = 0L;
        }
      }
      wI();
      if (this.bEH <= 0L) {
        break;
      }
      bnB();
      paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(205975);
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