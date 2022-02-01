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
import com.tencent.mm.sdk.platformtools.FileProviderHelper;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.io.IOException;

public final class c
  implements e
{
  private long bom;
  private final boolean bpH;
  private final boolean bpI;
  private long bpM;
  private long bpQ;
  private int flags;
  private String key;
  private long nHt;
  private int priority;
  private final a pvM;
  private String pvQ;
  private long pvR;
  private int pvS;
  private long pvT;
  private final e pvU;
  private final e pvV;
  public final e pvW;
  private final a pvX;
  private e pvY;
  private f pvZ;
  private boolean pwa;
  private boolean pwb;
  private Uri uri;
  private String uuid;
  
  public c(a parama, e parame1, e parame2, d paramd, a parama1)
  {
    AppMethodBeat.i(229226);
    this.pvR = 0L;
    this.pvQ = "";
    this.pvM = parama;
    this.pvU = parame2;
    this.bpH = false;
    this.bpI = true;
    this.pvW = parame1;
    if (paramd != null) {}
    for (this.pvV = new r(parame1, paramd);; this.pvV = null)
    {
      this.pvX = parama1;
      AppMethodBeat.o(229226);
      return;
    }
  }
  
  private void b(IOException paramIOException)
  {
    AppMethodBeat.i(229262);
    h.log(3, getLogTag(), "handleBeforeThrow " + paramIOException + ", ignoreCacheOnError=" + this.bpI + ", currentDataSource=" + this.pvY);
    if ((this.bpI) && (this.pvY == this.pvU))
    {
      h.log(4, getLogTag(), "handleBeforeThrow currentDataSource=" + this.pvY + ", exception=" + paramIOException);
      this.pwa = true;
    }
    AppMethodBeat.o(229262);
  }
  
  private long bVx()
  {
    int i = 0;
    AppMethodBeat.i(229257);
    for (;;)
    {
      long l1;
      Object localObject2;
      try
      {
        Object localObject1;
        if (this.pwa)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            this.pvY = this.pvW;
            localObject1 = new g(this.uri, this.bpM, this.bpM, this.bom, this.key, this.flags, this.uuid, this.priority);
            l1 = this.pvY.a((g)localObject1);
            if (((this.pvY instanceof l)) && (this.pvY.getTotalLength() != -1L) && (((g)localObject1).position >= this.pvY.getTotalLength() - 1L)) {
              h.log(6, getLogTag(), "read position out of bound");
            }
            if ((this.bom == -1L) && (this.pvY.getTotalLength() != -1L))
            {
              this.bom = (this.pvY.getTotalLength() - this.bpM);
              h.log(4, getLogTag(), "init bytesRemaining " + this.bom + ", readPosition=" + this.bpM + ", totalLength=" + this.pvY.getTotalLength());
            }
            this.bom = Math.max(0L, Math.min(this.bom, getTotalLength()));
            this.pwb = false;
            AppMethodBeat.o(229257);
            return l1;
          }
        }
        else
        {
          if (this.bpH)
          {
            localObject1 = this.pvM.Q(this.key, this.bpM);
            continue;
          }
          localObject1 = this.pvM.R(this.key, this.bpM);
          continue;
        }
        if (!((f)localObject1).bpU) {
          break label546;
        }
        localObject3 = FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), ((f)localObject1).file);
        l1 = this.bpM - ((f)localObject1).position;
        if (this.bom == -1L)
        {
          this.bom = (((f)localObject1).nHt - this.bpM);
          long l2 = Math.min(((f)localObject1).aFL - l1, this.bom);
          localObject1 = new g((Uri)localObject3, this.bpM, l1, l2, this.key, this.flags, this.uuid, this.priority);
          localObject3 = this.pvU;
          this.pvY = ((e)localObject3);
          continue;
        }
        if (this.bom <= ((f)localObject2).nHt - this.bpM) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject2 = new RuntimeException(localInterruptedException);
        AppMethodBeat.o(229257);
        throw ((Throwable)localObject2);
      }
      h.log(5, getLogTag(), "fix bytesRemaining, max=" + (((f)localObject2).nHt - this.bpM) + " current=" + this.bom);
      this.bom = (((f)localObject2).nHt - this.bpM);
      continue;
      label546:
      this.pvZ = ((f)localObject2);
      if (((f)localObject2).aFL == -1L) {
        i = 1;
      }
      if (i != 0) {
        l1 = this.bom;
      }
      for (;;)
      {
        localObject2 = new g(this.uri, this.bpM, this.bpM, l1, this.key, this.flags, this.uuid, this.priority);
        if (this.pvV == null) {
          break label665;
        }
        localObject3 = this.pvV;
        break;
        if (this.bom != -1L) {
          l1 = Math.min(((f)localObject2).aFL, this.bom);
        } else {
          l1 = ((f)localObject2).aFL;
        }
      }
      label665:
      Object localObject3 = this.pvW;
    }
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(229275);
    String str = this.pvQ + "CacheDataSource";
    AppMethodBeat.o(229275);
    return str;
  }
  
  private void uS()
  {
    AppMethodBeat.i(229259);
    if (this.pvY == null)
    {
      AppMethodBeat.o(229259);
      return;
    }
    try
    {
      this.pvY.close();
      this.pvY = null;
      return;
    }
    finally
    {
      if (this.pvZ != null)
      {
        this.pvM.a(this.pvZ);
        this.pvZ = null;
      }
      AppMethodBeat.o(229259);
    }
    AppMethodBeat.o(229259);
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(229237);
    long l1;
    long l2;
    try
    {
      this.uri = paramg.uri;
      this.flags = paramg.flags;
      this.uuid = paramg.uuid;
      this.key = paramg.key;
      this.bpM = paramg.position;
      this.bom = paramg.aFL;
      this.priority = paramg.priority;
      l1 = System.currentTimeMillis();
      l2 = bVx();
      this.nHt = getTotalLength();
      this.pvR = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(229237);
      return l2;
    }
    catch (IOException paramg)
    {
      if ((this.pvY instanceof k)) {
        h.log(6, getLogTag(), "open cache error " + paramg.toString());
      }
      for (;;)
      {
        b(paramg);
        if (this.pwa) {
          break;
        }
        AppMethodBeat.o(229237);
        throw paramg;
        h.log(6, getLogTag(), "open error " + paramg.toString());
      }
    }
    try
    {
      uS();
      h.log(6, getLogTag(), "open cache error, try reopen without cache");
      l1 = System.currentTimeMillis();
      l2 = bVx();
      this.nHt = getTotalLength();
      this.pvR = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(229237);
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
    AppMethodBeat.i(229263);
    if (this.pvY == null)
    {
      AppMethodBeat.o(229263);
      return 0L;
    }
    long l = this.pvY.available();
    AppMethodBeat.o(229263);
    return l;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c bVy()
  {
    AppMethodBeat.i(229269);
    if (this.pvY == null)
    {
      localc = com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c.pwO;
      AppMethodBeat.o(229269);
      return localc;
    }
    if ((this.pvY == this.pvU) && (this.pvM != null))
    {
      localc = this.pvM.aiS(this.key);
      AppMethodBeat.o(229269);
      return localc;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c localc = this.pvY.bVy();
    AppMethodBeat.o(229269);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(229267);
    try
    {
      uS();
      AppMethodBeat.o(229267);
      return;
    }
    catch (IOException localIOException)
    {
      if (!(this.pvY instanceof k)) {
        break label70;
      }
    }
    h.log(6, getLogTag(), "close cache error " + localIOException.toString());
    for (;;)
    {
      b(localIOException);
      AppMethodBeat.o(229267);
      throw localIOException;
      label70:
      h.log(6, getLogTag(), "close error " + localIOException.toString());
    }
  }
  
  public final long getTotalLength()
  {
    AppMethodBeat.i(229272);
    if (this.pvY == null)
    {
      AppMethodBeat.o(229272);
      return -1L;
    }
    if ((this.pvY == this.pvU) && (this.pvM != null))
    {
      l = this.pvM.aiR(this.key);
      AppMethodBeat.o(229272);
      return l;
    }
    long l = this.pvY.getTotalLength();
    AppMethodBeat.o(229272);
    return l;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229246);
    try
    {
      if ((!this.pwb) && ((this.pvY instanceof k)) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().dal)) {
        h.log(4, getLogTag(), "read from cache " + ((k)this.pvY).getUri() + ", fileSize=" + this.pvY.available());
      }
      long l = System.currentTimeMillis();
      int i = this.pvY.read(paramArrayOfByte, paramInt1, paramInt2);
      l = System.currentTimeMillis() - l;
      if (!this.pwb)
      {
        if ((this.pvY != this.pvU) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bVt().pvJ != null) && (this.priority == 90) && (URLUtil.isNetworkUrl(this.uri.toString())) && (this.pvX != null)) {
          this.pvX.b(this.uuid, this.pvR, this.pvR, l);
        }
        this.pwb = true;
      }
      if (i >= 0)
      {
        if (this.pvY == this.pvU) {
          this.bpQ += i;
        }
        for (;;)
        {
          this.bpM += i;
          if (this.bom != -1L) {
            this.bom -= i;
          }
          AppMethodBeat.o(229246);
          return i;
          this.pvS += i;
          this.pvT += l;
        }
        h.log(6, getLogTag(), "read cache error " + paramArrayOfByte.toString());
      }
    }
    catch (IOException paramArrayOfByte)
    {
      if (!(this.pvY instanceof k)) {}
    }
    for (;;)
    {
      b(paramArrayOfByte);
      AppMethodBeat.o(229246);
      throw paramArrayOfByte;
      if (this.pvX != null)
      {
        if (this.priority == 90) {
          this.pvX.a(this.uuid, this.pvS, this.pvT, this.nHt, this.bpQ);
        }
        this.pvS = 0;
        this.pvT = 0L;
        if ((this.pvY == this.pvU) && (this.bpQ > 0L))
        {
          this.pvX.l(this.pvM.uP(), this.bpQ);
          this.bpQ = 0L;
        }
      }
      uS();
      if (this.bom <= 0L) {
        break;
      }
      bVx();
      paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(229246);
      return paramInt1;
      h.log(6, getLogTag(), "read error " + paramArrayOfByte.toString());
    }
  }
  
  public final void setLogTag(String paramString)
  {
    this.pvQ = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void b(String paramString, long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void l(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c
 * JD-Core Version:    0.7.0.1
 */