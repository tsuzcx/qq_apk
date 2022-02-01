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
  private String lmq;
  private final e lnl;
  private final d lnm;
  private boolean lnn;
  private boolean lno;
  
  public r(e parame, d paramd)
  {
    AppMethodBeat.i(206077);
    this.lmq = "";
    this.lnl = ((e)a.checkNotNull(parame));
    this.lnm = ((d)a.checkNotNull(paramd));
    AppMethodBeat.o(206077);
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(206084);
    String str = this.lmq + "TeeDataSource";
    AppMethodBeat.o(206084);
    return str;
  }
  
  public final void QL(String paramString)
  {
    this.lmq = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(206078);
    long l3 = this.lnl.a(paramg);
    long l1 = -1L;
    c localc = c.lnp;
    long l2;
    Object localObject;
    if ((this.lnl instanceof l))
    {
      l2 = this.lnl.baK();
      localObject = (List)((l)this.lnl).getResponseHeaders().get("Content-Type");
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (!((List)localObject).isEmpty()) {
          localc = c.QO((String)((List)localObject).get(0));
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
          localObject = new g(paramg.uri, paramg.absoluteStreamPosition, paramg.position, l3, paramg.key, paramg.flags, paramg.uuid, paramg.priority);
        }
      }
      this.lnn = false;
      if (l2 != -1L) {}
      for (;;)
      {
        try
        {
          this.lnm.a((g)localObject, l2, localc);
          this.lno = true;
          AppMethodBeat.o(206078);
          return l3;
        }
        catch (b.a paramg)
        {
          this.lnn = true;
          h.a(5, getLogTag(), "error open dataSink " + paramg.toString(), paramg);
          continue;
        }
        this.lnn = true;
      }
      l2 = l1;
    }
  }
  
  public final long available()
  {
    AppMethodBeat.i(206080);
    long l = this.lnl.available();
    AppMethodBeat.o(206080);
    return l;
  }
  
  public final long baK()
  {
    AppMethodBeat.i(206083);
    long l = this.lnl.baK();
    AppMethodBeat.o(206083);
    return l;
  }
  
  public final c bnC()
  {
    AppMethodBeat.i(206082);
    c localc = this.lnl.bnC();
    AppMethodBeat.o(206082);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(206081);
    try
    {
      this.lnl.close();
      try
      {
        if (this.lno) {
          this.lnm.close();
        }
        AppMethodBeat.o(206081);
        return;
      }
      catch (b.a locala1)
      {
        h.a(5, getLogTag(), "error close dataSink " + locala1.toString(), locala1);
        AppMethodBeat.o(206081);
        return;
      }
      try
      {
        if (this.lno) {
          this.lnm.close();
        }
        AppMethodBeat.o(206081);
        throw localObject;
      }
      catch (b.a locala2)
      {
        for (;;)
        {
          h.a(5, getLogTag(), "error close dataSink " + locala2.toString(), locala2);
        }
      }
    }
    finally {}
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(206079);
    paramInt2 = this.lnl.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      if (this.lnn)
      {
        AppMethodBeat.o(206079);
        return paramInt2;
      }
    }
    try
    {
      if (this.lno) {
        this.lnm.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      AppMethodBeat.o(206079);
      return paramInt2;
    }
    catch (b.a paramArrayOfByte)
    {
      for (;;)
      {
        this.lnn = true;
        h.a(5, getLogTag(), "error write dataSink " + paramArrayOfByte.toString(), paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.r
 * JD-Core Version:    0.7.0.1
 */