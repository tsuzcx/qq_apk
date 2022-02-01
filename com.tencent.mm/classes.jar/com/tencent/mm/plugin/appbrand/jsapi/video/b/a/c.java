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
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.o;
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
  private long jLu;
  private String key;
  private final a lqM;
  private String lqQ;
  private long lqR;
  private int lqS;
  private long lqT;
  private final e lqU;
  private final e lqV;
  public final e lqW;
  private final a lqX;
  private e lqY;
  private f lqZ;
  private boolean lra;
  private boolean lrb;
  private int priority;
  private Uri uri;
  private String uuid;
  
  public c(a parama, e parame1, e parame2, d paramd, a parama1)
  {
    AppMethodBeat.i(211000);
    this.lqR = 0L;
    this.lqQ = "";
    this.lqM = parama;
    this.lqU = parame2;
    this.bFM = false;
    this.bFN = true;
    this.lqW = parame1;
    if (paramd != null) {}
    for (this.lqV = new r(parame1, paramd);; this.lqV = null)
    {
      this.lqX = parama1;
      AppMethodBeat.o(211000);
      return;
    }
  }
  
  private void b(IOException paramIOException)
  {
    AppMethodBeat.i(211005);
    h.log(3, getLogTag(), "handleBeforeThrow " + paramIOException + ", ignoreCacheOnError=" + this.bFN + ", currentDataSource=" + this.lqY);
    if ((this.bFN) && (this.lqY == this.lqU))
    {
      h.log(4, getLogTag(), "handleBeforeThrow currentDataSource=" + this.lqY + ", exception=" + paramIOException);
      this.lra = true;
    }
    AppMethodBeat.o(211005);
  }
  
  private long bol()
  {
    int i = 0;
    AppMethodBeat.i(211003);
    for (;;)
    {
      long l1;
      Object localObject2;
      try
      {
        Object localObject1;
        if (this.lra)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            this.lqY = this.lqW;
            localObject1 = new g(this.uri, this.bFR, this.bFR, this.bEH, this.key, this.flags, this.uuid, this.priority);
            l1 = this.lqY.a((g)localObject1);
            if (((this.lqY instanceof l)) && (this.lqY.bbj() != -1L) && (((g)localObject1).position >= this.lqY.bbj() - 1L)) {
              h.log(6, getLogTag(), "read position out of bound");
            }
            if ((this.bEH == -1L) && (this.lqY.bbj() != -1L))
            {
              this.bEH = (this.lqY.bbj() - this.bFR);
              h.log(4, getLogTag(), "init bytesRemaining " + this.bEH + ", readPosition=" + this.bFR + ", totalLength=" + this.lqY.bbj());
            }
            this.bEH = Math.max(0L, Math.min(this.bEH, bbj()));
            this.lrb = false;
            AppMethodBeat.o(211003);
            return l1;
          }
        }
        else
        {
          if (this.bFM)
          {
            localObject1 = this.lqM.Q(this.key, this.bFR);
            continue;
          }
          localObject1 = this.lqM.R(this.key, this.bFR);
          continue;
        }
        if (!((f)localObject1).bFZ) {
          break label546;
        }
        localObject3 = o.a(ak.getContext(), ((f)localObject1).aXd);
        l1 = this.bFR - ((f)localObject1).position;
        if (this.bEH == -1L)
        {
          this.bEH = (((f)localObject1).jLu - this.bFR);
          long l2 = Math.min(((f)localObject1).length - l1, this.bEH);
          localObject1 = new g((Uri)localObject3, this.bFR, l1, l2, this.key, this.flags, this.uuid, this.priority);
          localObject3 = this.lqU;
          this.lqY = ((e)localObject3);
          continue;
        }
        if (this.bEH <= ((f)localObject2).jLu - this.bFR) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject2 = new RuntimeException(localInterruptedException);
        AppMethodBeat.o(211003);
        throw ((Throwable)localObject2);
      }
      h.log(5, getLogTag(), "fix bytesRemaining, max=" + (((f)localObject2).jLu - this.bFR) + " current=" + this.bEH);
      this.bEH = (((f)localObject2).jLu - this.bFR);
      continue;
      label546:
      this.lqZ = ((f)localObject2);
      if (((f)localObject2).length == -1L) {
        i = 1;
      }
      if (i != 0) {
        l1 = this.bEH;
      }
      for (;;)
      {
        localObject2 = new g(this.uri, this.bFR, this.bFR, l1, this.key, this.flags, this.uuid, this.priority);
        if (this.lqV == null) {
          break label665;
        }
        localObject3 = this.lqV;
        break;
        if (this.bEH != -1L) {
          l1 = Math.min(((f)localObject2).length, this.bEH);
        } else {
          l1 = ((f)localObject2).length;
        }
      }
      label665:
      Object localObject3 = this.lqW;
    }
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(211010);
    String str = this.lqQ + "CacheDataSource";
    AppMethodBeat.o(211010);
    return str;
  }
  
  private void wI()
  {
    AppMethodBeat.i(211004);
    if (this.lqY == null)
    {
      AppMethodBeat.o(211004);
      return;
    }
    try
    {
      this.lqY.close();
      this.lqY = null;
      return;
    }
    finally
    {
      if (this.lqZ != null)
      {
        this.lqM.a(this.lqZ);
        this.lqZ = null;
      }
      AppMethodBeat.o(211004);
    }
    AppMethodBeat.o(211004);
  }
  
  public final void Ru(String paramString)
  {
    this.lqQ = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(211001);
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
      l2 = bol();
      this.jLu = bbj();
      this.lqR = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(211001);
      return l2;
    }
    catch (IOException paramg)
    {
      if ((this.lqY instanceof k)) {
        h.log(6, getLogTag(), "open cache error " + paramg.toString());
      }
      for (;;)
      {
        b(paramg);
        if (this.lra) {
          break;
        }
        AppMethodBeat.o(211001);
        throw paramg;
        h.log(6, getLogTag(), "open error " + paramg.toString());
      }
    }
    try
    {
      wI();
      h.log(6, getLogTag(), "open cache error, try reopen without cache");
      l1 = System.currentTimeMillis();
      l2 = bol();
      this.jLu = bbj();
      this.lqR = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(211001);
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
    AppMethodBeat.i(211006);
    if (this.lqY == null)
    {
      AppMethodBeat.o(211006);
      return 0L;
    }
    long l = this.lqY.available();
    AppMethodBeat.o(211006);
    return l;
  }
  
  public final long bbj()
  {
    AppMethodBeat.i(211009);
    if (this.lqY == null)
    {
      AppMethodBeat.o(211009);
      return -1L;
    }
    if ((this.lqY == this.lqU) && (this.lqM != null))
    {
      l = this.lqM.Rr(this.key);
      AppMethodBeat.o(211009);
      return l;
    }
    long l = this.lqY.bbj();
    AppMethodBeat.o(211009);
    return l;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c bom()
  {
    AppMethodBeat.i(211008);
    if (this.lqY == null)
    {
      localc = com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c.lrO;
      AppMethodBeat.o(211008);
      return localc;
    }
    if ((this.lqY == this.lqU) && (this.lqM != null))
    {
      localc = this.lqM.Rs(this.key);
      AppMethodBeat.o(211008);
      return localc;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c localc = this.lqY.bom();
    AppMethodBeat.o(211008);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(211007);
    try
    {
      wI();
      AppMethodBeat.o(211007);
      return;
    }
    catch (IOException localIOException)
    {
      if (!(this.lqY instanceof k)) {
        break label70;
      }
    }
    h.log(6, getLogTag(), "close cache error " + localIOException.toString());
    for (;;)
    {
      b(localIOException);
      AppMethodBeat.o(211007);
      throw localIOException;
      label70:
      h.log(6, getLogTag(), "close error " + localIOException.toString());
    }
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(211002);
    try
    {
      if ((!this.lrb) && ((this.lqY instanceof k)) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().cFS)) {
        h.log(4, getLogTag(), "read from cache " + ((k)this.lqY).getUri() + ", fileSize=" + this.lqY.available());
      }
      long l = System.currentTimeMillis();
      int i = this.lqY.read(paramArrayOfByte, paramInt1, paramInt2);
      l = System.currentTimeMillis() - l;
      if (!this.lrb)
      {
        if ((this.lqY != this.lqU) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.boh().lqJ != null) && (this.priority == 90) && (URLUtil.isNetworkUrl(this.uri.toString())) && (this.lqX != null)) {
          this.lqX.b(this.uuid, this.lqR, this.lqR, l);
        }
        this.lrb = true;
      }
      if (i >= 0)
      {
        if (this.lqY == this.lqU) {
          this.bFV += i;
        }
        for (;;)
        {
          this.bFR += i;
          if (this.bEH != -1L) {
            this.bEH -= i;
          }
          AppMethodBeat.o(211002);
          return i;
          this.lqS += i;
          this.lqT += l;
        }
        h.log(6, getLogTag(), "read cache error " + paramArrayOfByte.toString());
      }
    }
    catch (IOException paramArrayOfByte)
    {
      if (!(this.lqY instanceof k)) {}
    }
    for (;;)
    {
      b(paramArrayOfByte);
      AppMethodBeat.o(211002);
      throw paramArrayOfByte;
      if (this.lqX != null)
      {
        if (this.priority == 90) {
          this.lqX.a(this.uuid, this.lqS, this.lqT, this.jLu, this.bFV);
        }
        this.lqS = 0;
        this.lqT = 0L;
        if ((this.lqY == this.lqU) && (this.bFV > 0L))
        {
          this.lqX.k(this.lqM.wF(), this.bFV);
          this.bFV = 0L;
        }
      }
      wI();
      if (this.bEH <= 0L) {
        break;
      }
      bol();
      paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(211002);
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