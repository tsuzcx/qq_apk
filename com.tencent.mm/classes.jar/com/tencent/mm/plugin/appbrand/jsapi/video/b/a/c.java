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
  private long die;
  private final boolean djl;
  private final boolean djm;
  private long djq;
  private long dju;
  private int flags;
  private String key;
  private int priority;
  private long qHg;
  private final a sAS;
  private String sAW;
  private long sAX;
  private int sAY;
  private long sAZ;
  private final e sBa;
  private final e sBb;
  public final e sBc;
  private final a sBd;
  private e sBe;
  private f sBf;
  private boolean sBg;
  private boolean sBh;
  private Uri uri;
  private String uuid;
  
  public c(a parama, e parame1, e parame2, d paramd, a parama1)
  {
    AppMethodBeat.i(328306);
    this.sAX = 0L;
    this.sAW = "";
    this.sAS = parama;
    this.sBa = parame2;
    this.djl = false;
    this.djm = true;
    this.sBc = parame1;
    if (paramd != null) {}
    for (this.sBb = new r(parame1, paramd);; this.sBb = null)
    {
      this.sBd = parama1;
      AppMethodBeat.o(328306);
      return;
    }
  }
  
  private void Ur()
  {
    AppMethodBeat.i(328358);
    if (this.sBe == null)
    {
      AppMethodBeat.o(328358);
      return;
    }
    try
    {
      this.sBe.close();
      this.sBe = null;
      return;
    }
    finally
    {
      if (this.sBf != null)
      {
        this.sAS.a(this.sBf);
        this.sBf = null;
      }
      AppMethodBeat.o(328358);
    }
    AppMethodBeat.o(328358);
  }
  
  private void b(IOException paramIOException)
  {
    AppMethodBeat.i(328371);
    h.log(3, getLogTag(), "handleBeforeThrow " + paramIOException + ", ignoreCacheOnError=" + this.djm + ", currentDataSource=" + this.sBe);
    if ((this.djm) && (this.sBe == this.sBa))
    {
      h.log(4, getLogTag(), "handleBeforeThrow currentDataSource=" + this.sBe + ", exception=" + paramIOException);
      this.sBg = true;
    }
    AppMethodBeat.o(328371);
  }
  
  private long cvL()
  {
    int i = 0;
    AppMethodBeat.i(328339);
    for (;;)
    {
      long l1;
      Object localObject2;
      try
      {
        Object localObject1;
        if (this.sBg)
        {
          localObject1 = null;
          if (localObject1 == null)
          {
            this.sBe = this.sBc;
            localObject1 = new g(this.uri, this.djq, this.djq, this.die, this.key, this.flags, this.uuid, this.priority);
            l1 = this.sBe.a((g)localObject1);
            if (((this.sBe instanceof l)) && (this.sBe.getTotalLength() != -1L) && (((g)localObject1).position >= this.sBe.getTotalLength() - 1L)) {
              h.log(6, getLogTag(), "read position out of bound");
            }
            if ((this.die == -1L) && (this.sBe.getTotalLength() != -1L))
            {
              this.die = (this.sBe.getTotalLength() - this.djq);
              h.log(4, getLogTag(), "init bytesRemaining " + this.die + ", readPosition=" + this.djq + ", totalLength=" + this.sBe.getTotalLength());
            }
            this.die = Math.max(0L, Math.min(this.die, getTotalLength()));
            this.sBh = false;
            AppMethodBeat.o(328339);
            return l1;
          }
        }
        else
        {
          if (this.djl)
          {
            localObject1 = this.sAS.V(this.key, this.djq);
            continue;
          }
          localObject1 = this.sAS.W(this.key, this.djq);
          continue;
        }
        if (!((f)localObject1).djy) {
          break label546;
        }
        localObject3 = FileProviderHelper.getUriForFile(MMApplicationContext.getContext(), ((f)localObject1).file);
        l1 = this.djq - ((f)localObject1).position;
        if (this.die == -1L)
        {
          this.die = (((f)localObject1).qHg - this.djq);
          long l2 = Math.min(((f)localObject1).length - l1, this.die);
          localObject1 = new g((Uri)localObject3, this.djq, l1, l2, this.key, this.flags, this.uuid, this.priority);
          localObject3 = this.sBa;
          this.sBe = ((e)localObject3);
          continue;
        }
        if (this.die <= ((f)localObject2).qHg - this.djq) {
          continue;
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        localObject2 = new RuntimeException(localInterruptedException);
        AppMethodBeat.o(328339);
        throw ((Throwable)localObject2);
      }
      h.log(5, getLogTag(), "fix bytesRemaining, max=" + (((f)localObject2).qHg - this.djq) + " current=" + this.die);
      this.die = (((f)localObject2).qHg - this.djq);
      continue;
      label546:
      this.sBf = ((f)localObject2);
      if (((f)localObject2).length == -1L) {
        i = 1;
      }
      if (i != 0) {
        l1 = this.die;
      }
      for (;;)
      {
        localObject2 = new g(this.uri, this.djq, this.djq, l1, this.key, this.flags, this.uuid, this.priority);
        if (this.sBb == null) {
          break label665;
        }
        localObject3 = this.sBb;
        break;
        if (this.die != -1L) {
          l1 = Math.min(((f)localObject2).length, this.die);
        } else {
          l1 = ((f)localObject2).length;
        }
      }
      label665:
      Object localObject3 = this.sBc;
    }
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(328385);
    String str = this.sAW + "CacheDataSource";
    AppMethodBeat.o(328385);
    return str;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(328409);
    long l1;
    long l2;
    try
    {
      this.uri = paramg.uri;
      this.flags = paramg.flags;
      this.uuid = paramg.uuid;
      this.key = paramg.key;
      this.djq = paramg.position;
      this.die = paramg.length;
      this.priority = paramg.priority;
      l1 = System.currentTimeMillis();
      l2 = cvL();
      this.qHg = getTotalLength();
      this.sAX = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(328409);
      return l2;
    }
    catch (IOException paramg)
    {
      if ((this.sBe instanceof k)) {
        h.log(6, getLogTag(), "open cache error " + paramg.toString());
      }
      for (;;)
      {
        b(paramg);
        if (this.sBg) {
          break;
        }
        AppMethodBeat.o(328409);
        throw paramg;
        h.log(6, getLogTag(), "open error " + paramg.toString());
      }
    }
    try
    {
      Ur();
      h.log(6, getLogTag(), "open cache error, try reopen without cache");
      l1 = System.currentTimeMillis();
      l2 = cvL();
      this.qHg = getTotalLength();
      this.sAX = (System.currentTimeMillis() - l1);
      AppMethodBeat.o(328409);
      return l2;
    }
    catch (Exception paramg)
    {
      for (;;)
      {
        h.b(5, getLogTag(), "open, failed on closeCurrentSource, shouldn't be a problem", paramg);
      }
    }
  }
  
  public final long available()
  {
    AppMethodBeat.i(328447);
    if (this.sBe == null)
    {
      AppMethodBeat.o(328447);
      return 0L;
    }
    long l = this.sBe.available();
    AppMethodBeat.o(328447);
    return l;
  }
  
  public final void close()
  {
    AppMethodBeat.i(328462);
    try
    {
      Ur();
      AppMethodBeat.o(328462);
      return;
    }
    catch (IOException localIOException)
    {
      if (!(this.sBe instanceof k)) {
        break label70;
      }
    }
    h.log(6, getLogTag(), "close cache error " + localIOException.toString());
    for (;;)
    {
      b(localIOException);
      AppMethodBeat.o(328462);
      throw localIOException;
      label70:
      h.log(6, getLogTag(), "close error " + localIOException.toString());
    }
  }
  
  public final com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c cvM()
  {
    AppMethodBeat.i(328479);
    if (this.sBe == null)
    {
      localc = com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c.sBU;
      AppMethodBeat.o(328479);
      return localc;
    }
    if ((this.sBe == this.sBa) && (this.sAS != null))
    {
      localc = this.sAS.abR(this.key);
      AppMethodBeat.o(328479);
      return localc;
    }
    com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c localc = this.sBe.cvM();
    AppMethodBeat.o(328479);
    return localc;
  }
  
  public final long getTotalLength()
  {
    AppMethodBeat.i(328490);
    if (this.sBe == null)
    {
      AppMethodBeat.o(328490);
      return -1L;
    }
    if ((this.sBe == this.sBa) && (this.sAS != null))
    {
      l = this.sAS.abQ(this.key);
      AppMethodBeat.o(328490);
      return l;
    }
    long l = this.sBe.getTotalLength();
    AppMethodBeat.o(328490);
    return l;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328438);
    try
    {
      if ((!this.sBh) && ((this.sBe instanceof k)) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().eYL)) {
        h.log(4, getLogTag(), "read from cache " + ((k)this.sBe).getUri() + ", fileSize=" + this.sBe.available());
      }
      long l = System.currentTimeMillis();
      int i = this.sBe.read(paramArrayOfByte, paramInt1, paramInt2);
      l = System.currentTimeMillis() - l;
      if (!this.sBh)
      {
        if ((this.sBe != this.sBa) && (com.tencent.mm.plugin.appbrand.jsapi.video.b.a.cvH().sAP != null) && (this.priority == 90) && (URLUtil.isNetworkUrl(this.uri.toString())) && (this.sBd != null)) {
          this.sBd.c(this.uuid, this.sAX, this.sAX, l);
        }
        this.sBh = true;
      }
      if (i >= 0)
      {
        if (this.sBe == this.sBa) {
          this.dju += i;
        }
        for (;;)
        {
          this.djq += i;
          if (this.die != -1L) {
            this.die -= i;
          }
          AppMethodBeat.o(328438);
          return i;
          this.sAY += i;
          this.sAZ += l;
        }
        h.log(6, getLogTag(), "read cache error " + paramArrayOfByte.toString());
      }
    }
    catch (IOException paramArrayOfByte)
    {
      if (!(this.sBe instanceof k)) {}
    }
    for (;;)
    {
      b(paramArrayOfByte);
      AppMethodBeat.o(328438);
      throw paramArrayOfByte;
      if (this.sBd != null)
      {
        if (this.priority == 90) {
          this.sBd.a(this.uuid, this.sAY, this.sAZ, this.qHg, this.dju);
        }
        this.sAY = 0;
        this.sAZ = 0L;
        if ((this.sBe == this.sBa) && (this.dju > 0L))
        {
          this.sBd.H(this.sAS.Uo(), this.dju);
          this.dju = 0L;
        }
      }
      Ur();
      if (this.die <= 0L) {
        break;
      }
      cvL();
      paramInt1 = read(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(328438);
      return paramInt1;
      h.log(6, getLogTag(), "read error " + paramArrayOfByte.toString());
    }
  }
  
  public final void setLogTag(String paramString)
  {
    this.sAW = paramString;
  }
  
  public static abstract interface a
  {
    public abstract void H(long paramLong1, long paramLong2);
    
    public abstract void a(String paramString, int paramInt, long paramLong1, long paramLong2, long paramLong3);
    
    public abstract void c(String paramString, long paramLong1, long paramLong2, long paramLong3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.a.c
 * JD-Core Version:    0.7.0.1
 */