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
  private long bEJ;
  private final boolean bGd;
  private final boolean bGe;
  private long bGi;
  private long bGm;
  private int flags;
  private long kNt;
  private String key;
  private final e mxA;
  private final e mxB;
  public final e mxC;
  private final a mxD;
  private e mxE;
  private f mxF;
  private boolean mxG;
  private boolean mxH;
  private final a mxs;
  private String mxw;
  private long mxx;
  private int mxy;
  private long mxz;
  private int priority;
  private Uri uri;
  private String uuid;
  
  public c(a parama, e parame1, e parame2, d paramd, a parama1)
  {
    AppMethodBeat.i(234669);
    this.mxx = 0L;
    this.mxw = "";
    this.mxs = parama;
    this.mxA = parame2;
    this.bGd = false;
    this.bGe = true;
    this.mxC = parame1;
    if (paramd != null) {}
    for (this.mxB = new r(parame1, paramd);; this.mxB = null)
    {
      this.mxD = parama1;
      AppMethodBeat.o(234669);
      return;
    }
  }
  
  private void b(IOException paramIOException)
  {
    AppMethodBeat.i(234674);
    h.log(3, getLogTag(), "handleBeforeThrow " + paramIOException + ", ignoreCacheOnError=" + this.bGe + ", currentDataSource=" + this.mxE);
    if ((this.bGe) && (this.mxE == this.mxA))
    {
      h.log(4, getLogTag(), "handleBeforeThrow currentDataSource=" + this.mxE + ", exception=" + paramIOException);
      this.mxG = true;
    }
    AppMethodBeat.o(234674);
  }
  
  private long bJO()
  {
    int i = 0;
    AppMethodBeat.i(234672);
    for (;;)
    {
      long l1;
      Object localObject2;
      try
      {
        Object localObject1;
        if (this.mxG)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            this.mxE = this.mxC;
            localObject1 = new g(this.uri, this.bGi, this.bGi, this.bEJ, this.key, this.flags, this.uuid, this.priority);
            l1 = this.mxE.a((g)localObject1);
            if (((this.mxE instanceof l)) && (this.mxE.getTotalLength() != -1L) && (((g)localObject1).position >= this.mxE.getTotalLength() - 1L)) {
              h.log(6, getLogTag(), "read position out of bound");
            }
            if ((this.bEJ == -1L) && (this.mxE.getTotalLength() != -1L))
            {
              this.bEJ = (this.mxE.getTotalLength() - this.bGi);
              h.log(4, getLogTag(), "init bytesRemaining " + this.bEJ + ", readPosition=" + this.bGi + ", totalLength=" + this.mxE.getTotalLength());
            }
            this.bEJ = Math.max(0L, Math.min(this.bEJ, getTotalLength()));
            this.mxH = false;
            AppMethodBeat.o(234672);
            return l1;
          }
        }
        else
        {
          if (this.bGd)
          {
            localObject1 = this.mxs.Q(this.key, this.bGi);
            continue;
          }
          localObject1 = this.mxs.R(this.key, this.bGi);
          continue;
        }
        if (!((f)localObject1).bGq) {
          break label546;
        }
        localObject3 = FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), ((f)localObject1).file);
        l1 = this.bGi - ((f)localObject1).position;
        if (this.bEJ == -1L)
        {
          this.bEJ = (((f)localObject1).kNt - this.bGi);
          long l2 = Math.min(((f)localObject1).length - l1, this.bEJ);
          localObject1 = new g((Uri)localObject3, this.bGi, l1, l2, this.key, this.flags, this.uuid, this.priority);
          localObject3 = this.mxA;
          this.mxE = ((e)localObject3);
          continue;
        }
        if (this.bEJ <= ((f)localObject2).kNt - this.bGi) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject2 = new RuntimeException(localInterruptedException);
        AppMethodBeat.o(234672);
        throw ((Throwable)localObject2);
      }
      h.log(5, getLogTag(), "fix bytesRemaining, max=" + (((f)localObject2).kNt - this.bGi) + " current=" + this.bEJ);
      this.bEJ = (((f)localObject2).kNt - this.bGi);
      continue;
      label546:
      this.mxF = ((f)localObject2);
      if (((f)localObject2).length == -1L) {
        i = 1;
      }
      if (i != 0) {
        l1 = this.bEJ;
      }
      for (;;)
      {
        localObject2 = new g(this.uri, this.bGi, this.bGi, l1, this.key, this.flags, this.uuid, this.priority);
        if (this.mxB == null) {
          break label665;
        }
        localObject3 = this.mxB;
        break;
        if (this.bEJ != -1L) {
          l1 = Math.min(((f)localObject2).length, this.bEJ);
        } else {
          l1 = ((f)localObject2).length;
        }
      }
      label665:
      Object localObject3 = this.mxC;
    }
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(234679);
    String str = this.mxw + "CacheDataSource";
    AppMethodBeat.o(234679);
    return str;
  }
  
  private void wQ()
  {
    AppMethodBeat.i(234673);
    if (this.mxE == null)
    {
      AppMethodBeat.o(234673);
      return;
    }
    try
    {
      this.mxE.close();
      this.mxE = null;
      return;
    }
    finally
    {
      if (this.mxF != null)
      {
        this.mxs.a(this.mxF);
        this.mxF = null;
      }
      AppMethodBeat.o(234673);
    }
    AppMethodBeat.o(234673);
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(234670);
    long l1;
    long l2;
    try
    {
      this.uri = paramg.uri;
      this.flags = paramg.flags;
      this.uuid = paramg.uuid;
      this.key = paramg.key;
      this.bGi = paramg.position;
      this.bEJ = paramg.length;
      this.priority = paramg.priority;
      l1 = System.currentTimeMillis();
      l2 = bJO();
      this.kNt = getTotalLength();
      this.mxx = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(234670);
      return l2;
    }
    catch (IOException paramg)
    {
      if ((this.mxE instanceof k)) {
        h.log(6, getLogTag(), "open cache error " + paramg.toString());
      }
      for (;;)
      {
        b(paramg);
        if (this.mxG) {
          break;
        }
        AppMethodBeat.o(234670);
        throw paramg;
        h.log(6, getLogTag(), "open error " + paramg.toString());
      }
    }
    try
    {
      wQ();
      h.log(6, getLogTag(), "open cache error, try reopen without cache");
      l1 = System.currentTimeMillis();
      l2 = bJO();
      this.kNt = getTotalLength();
      this.mxx = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(234670);
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
    AppMethodBeat.i(234675);
    if (this.mxE == null)
    {
      AppMethodBeat.o(234675);
      return 0L;
    }
    long l = this.mxE.available();
    AppMethodBeat.o(234675);
    return l;
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c bJP()
  {
    AppMethodBeat.i(234677);
    if (this.mxE == null)
    {
      localc = com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c.myu;
      AppMethodBeat.o(234677);
      return localc;
    }
    if ((this.mxE == this.mxA) && (this.mxs != null))
    {
      localc = this.mxs.aaZ(this.key);
      AppMethodBeat.o(234677);
      return localc;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c localc = this.mxE.bJP();
    AppMethodBeat.o(234677);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(234676);
    try
    {
      wQ();
      AppMethodBeat.o(234676);
      return;
    }
    catch (IOException localIOException)
    {
      if (!(this.mxE instanceof k)) {
        break label70;
      }
    }
    h.log(6, getLogTag(), "close cache error " + localIOException.toString());
    for (;;)
    {
      b(localIOException);
      AppMethodBeat.o(234676);
      throw localIOException;
      label70:
      h.log(6, getLogTag(), "close error " + localIOException.toString());
    }
  }
  
  public final long getTotalLength()
  {
    AppMethodBeat.i(234678);
    if (this.mxE == null)
    {
      AppMethodBeat.o(234678);
      return -1L;
    }
    if ((this.mxE == this.mxA) && (this.mxs != null))
    {
      l = this.mxs.aaY(this.key);
      AppMethodBeat.o(234678);
      return l;
    }
    long l = this.mxE.getTotalLength();
    AppMethodBeat.o(234678);
    return l;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234671);
    try
    {
      if ((!this.mxH) && ((this.mxE instanceof k)) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().cWq)) {
        h.log(4, getLogTag(), "read from cache " + ((k)this.mxE).getUri() + ", fileSize=" + this.mxE.available());
      }
      long l = System.currentTimeMillis();
      int i = this.mxE.read(paramArrayOfByte, paramInt1, paramInt2);
      l = System.currentTimeMillis() - l;
      if (!this.mxH)
      {
        if ((this.mxE != this.mxA) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.bJK().mxp != null) && (this.priority == 90) && (URLUtil.isNetworkUrl(this.uri.toString())) && (this.mxD != null)) {
          this.mxD.b(this.uuid, this.mxx, this.mxx, l);
        }
        this.mxH = true;
      }
      if (i >= 0)
      {
        if (this.mxE == this.mxA) {
          this.bGm += i;
        }
        for (;;)
        {
          this.bGi += i;
          if (this.bEJ != -1L) {
            this.bEJ -= i;
          }
          AppMethodBeat.o(234671);
          return i;
          this.mxy += i;
          this.mxz += l;
        }
        h.log(6, getLogTag(), "read cache error " + paramArrayOfByte.toString());
      }
    }
    catch (IOException paramArrayOfByte)
    {
      if (!(this.mxE instanceof k)) {}
    }
    for (;;)
    {
      b(paramArrayOfByte);
      AppMethodBeat.o(234671);
      throw paramArrayOfByte;
      if (this.mxD != null)
      {
        if (this.priority == 90) {
          this.mxD.a(this.uuid, this.mxy, this.mxz, this.kNt, this.bGm);
        }
        this.mxy = 0;
        this.mxz = 0L;
        if ((this.mxE == this.mxA) && (this.bGm > 0L))
        {
          this.mxD.k(this.mxs.wN(), this.bGm);
          this.bGm = 0L;
        }
      }
      wQ();
      if (this.bEJ <= 0L) {
        break;
      }
      bJO();
      paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(234671);
      return paramInt1;
      h.log(6, getLogTag(), "read error " + paramArrayOfByte.toString());
    }
  }
  
  public final void setLogTag(String paramString)
  {
    this.mxw = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void b(String paramString, long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void k(long paramLong1, long paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c
 * JD-Core Version:    0.7.0.1
 */