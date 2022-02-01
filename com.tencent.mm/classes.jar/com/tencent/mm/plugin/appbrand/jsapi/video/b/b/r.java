package com.tencent.mm.plugin.appbrand.jsapi.video.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.a.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.c.c;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.a;
import com.tencent.mm.plugin.appbrand.jsapi.video.b.e.h;
import java.util.List;
import java.util.Map;

public final class r
  implements e
{
  private String kox;
  private final e kpr;
  private final d kps;
  private boolean kpt;
  private boolean kpu;
  
  public r(e parame, d paramd)
  {
    AppMethodBeat.i(193918);
    this.kox = "";
    this.kpr = ((e)a.checkNotNull(parame));
    this.kps = ((d)a.checkNotNull(paramd));
    AppMethodBeat.o(193918);
  }
  
  private String EE()
  {
    AppMethodBeat.i(193925);
    String str = this.kox + "TeeDataSource";
    AppMethodBeat.o(193925);
    return str;
  }
  
  public final void Jk(String paramString)
  {
    this.kox = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(193919);
    long l3 = this.kpr.a(paramg);
    long l1 = -1L;
    c localc = c.kpv;
    long l2;
    Object localObject;
    if ((this.kpr instanceof l))
    {
      l2 = this.kpr.aQu();
      localObject = (List)((l)this.kpr).getResponseHeaders().get("Content-Type");
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (!((List)localObject).isEmpty()) {
          localc = c.Jn((String)((List)localObject).get(0));
        }
      }
    }
    for (;;)
    {
      localObject = paramg;
      if (paramg.length == -1L)
      {
        localObject = paramg;
        if (l3 != -1L) {
          localObject = new g(paramg.uri, paramg.bwz, paramg.position, l3, paramg.key, paramg.flags, paramg.uuid, paramg.priority);
        }
      }
      this.kpt = false;
      if (l2 != -1L) {}
      for (;;)
      {
        try
        {
          this.kps.a((g)localObject, l2, localc);
          this.kpu = true;
          AppMethodBeat.o(193919);
          return l3;
        }
        catch (b.a paramg)
        {
          this.kpt = true;
          h.a(5, EE(), "error open dataSink " + paramg.toString(), paramg);
          continue;
        }
        this.kpt = true;
      }
      l2 = l1;
    }
  }
  
  public final long aQu()
  {
    AppMethodBeat.i(193924);
    long l = this.kpr.aQu();
    AppMethodBeat.o(193924);
    return l;
  }
  
  public final long available()
  {
    AppMethodBeat.i(193921);
    long l = this.kpr.available();
    AppMethodBeat.o(193921);
    return l;
  }
  
  public final c bcW()
  {
    AppMethodBeat.i(193923);
    c localc = this.kpr.bcW();
    AppMethodBeat.o(193923);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(193922);
    try
    {
      this.kpr.close();
      try
      {
        if (this.kpu) {
          this.kps.close();
        }
        AppMethodBeat.o(193922);
        return;
      }
      catch (b.a locala1)
      {
        h.a(5, EE(), "error close dataSink " + locala1.toString(), locala1);
        AppMethodBeat.o(193922);
        return;
      }
      try
      {
        if (this.kpu) {
          this.kps.close();
        }
        AppMethodBeat.o(193922);
        throw localObject;
      }
      catch (b.a locala2)
      {
        for (;;)
        {
          h.a(5, EE(), "error close dataSink " + locala2.toString(), locala2);
        }
      }
    }
    finally {}
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(193920);
    paramInt2 = this.kpr.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      if (this.kpt)
      {
        AppMethodBeat.o(193920);
        return paramInt2;
      }
    }
    try
    {
      if (this.kpu) {
        this.kps.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      AppMethodBeat.o(193920);
      return paramInt2;
    }
    catch (b.a paramArrayOfByte)
    {
      for (;;)
      {
        this.kpt = true;
        h.a(5, EE(), "error write dataSink " + paramArrayOfByte.toString(), paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.r
 * JD-Core Version:    0.7.0.1
 */