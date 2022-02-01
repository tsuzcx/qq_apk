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
  private String mxw;
  private final e myq;
  private final d myr;
  private boolean mys;
  private boolean myt;
  
  public r(e parame, d paramd)
  {
    AppMethodBeat.i(234773);
    this.mxw = "";
    this.myq = ((e)a.checkNotNull(parame));
    this.myr = ((d)a.checkNotNull(paramd));
    AppMethodBeat.o(234773);
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(234780);
    String str = this.mxw + "TeeDataSource";
    AppMethodBeat.o(234780);
    return str;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(234774);
    long l3 = this.myq.a(paramg);
    long l1 = -1L;
    c localc = c.myu;
    long l2;
    Object localObject;
    if ((this.myq instanceof l))
    {
      l2 = this.myq.getTotalLength();
      localObject = (List)((l)this.myq).getResponseHeaders().get("Content-Type");
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (!((List)localObject).isEmpty()) {
          localc = c.abd((String)((List)localObject).get(0));
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
          localObject = new g(paramg.uri, paramg.bEP, paramg.position, l3, paramg.key, paramg.flags, paramg.uuid, paramg.priority);
        }
      }
      this.mys = false;
      if (l2 != -1L) {}
      for (;;)
      {
        try
        {
          this.myr.a((g)localObject, l2, localc);
          this.myt = true;
          AppMethodBeat.o(234774);
          return l3;
        }
        catch (b.a paramg)
        {
          this.mys = true;
          h.a(5, getLogTag(), "error open dataSink " + paramg.toString(), paramg);
          continue;
        }
        this.mys = true;
      }
      l2 = l1;
    }
  }
  
  public final long available()
  {
    AppMethodBeat.i(234776);
    long l = this.myq.available();
    AppMethodBeat.o(234776);
    return l;
  }
  
  public final c bJP()
  {
    AppMethodBeat.i(234778);
    c localc = this.myq.bJP();
    AppMethodBeat.o(234778);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(234777);
    try
    {
      this.myq.close();
      try
      {
        if (this.myt) {
          this.myr.close();
        }
        AppMethodBeat.o(234777);
        return;
      }
      catch (b.a locala1)
      {
        h.a(5, getLogTag(), "error close dataSink " + locala1.toString(), locala1);
        AppMethodBeat.o(234777);
        return;
      }
      try
      {
        if (this.myt) {
          this.myr.close();
        }
        AppMethodBeat.o(234777);
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
  
  public final long getTotalLength()
  {
    AppMethodBeat.i(234779);
    long l = this.myq.getTotalLength();
    AppMethodBeat.o(234779);
    return l;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(234775);
    paramInt2 = this.myq.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      if (this.mys)
      {
        AppMethodBeat.o(234775);
        return paramInt2;
      }
    }
    try
    {
      if (this.myt) {
        this.myr.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      AppMethodBeat.o(234775);
      return paramInt2;
    }
    catch (b.a paramArrayOfByte)
    {
      for (;;)
      {
        this.mys = true;
        h.a(5, getLogTag(), "error write dataSink " + paramArrayOfByte.toString(), paramArrayOfByte);
      }
    }
  }
  
  public final void setLogTag(String paramString)
  {
    this.mxw = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.r
 * JD-Core Version:    0.7.0.1
 */