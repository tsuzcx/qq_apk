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
  private String lqQ;
  private final e lrK;
  private final d lrL;
  private boolean lrM;
  private boolean lrN;
  
  public r(e parame, d paramd)
  {
    AppMethodBeat.i(211104);
    this.lqQ = "";
    this.lrK = ((e)a.checkNotNull(parame));
    this.lrL = ((d)a.checkNotNull(paramd));
    AppMethodBeat.o(211104);
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(211111);
    String str = this.lqQ + "TeeDataSource";
    AppMethodBeat.o(211111);
    return str;
  }
  
  public final void Ru(String paramString)
  {
    this.lqQ = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(211105);
    long l3 = this.lrK.a(paramg);
    long l1 = -1L;
    c localc = c.lrO;
    long l2;
    Object localObject;
    if ((this.lrK instanceof l))
    {
      l2 = this.lrK.bbj();
      localObject = (List)((l)this.lrK).getResponseHeaders().get("Content-Type");
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (!((List)localObject).isEmpty()) {
          localc = c.Rx((String)((List)localObject).get(0));
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
      this.lrM = false;
      if (l2 != -1L) {}
      for (;;)
      {
        try
        {
          this.lrL.a((g)localObject, l2, localc);
          this.lrN = true;
          AppMethodBeat.o(211105);
          return l3;
        }
        catch (b.a paramg)
        {
          this.lrM = true;
          h.a(5, getLogTag(), "error open dataSink " + paramg.toString(), paramg);
          continue;
        }
        this.lrM = true;
      }
      l2 = l1;
    }
  }
  
  public final long available()
  {
    AppMethodBeat.i(211107);
    long l = this.lrK.available();
    AppMethodBeat.o(211107);
    return l;
  }
  
  public final long bbj()
  {
    AppMethodBeat.i(211110);
    long l = this.lrK.bbj();
    AppMethodBeat.o(211110);
    return l;
  }
  
  public final c bom()
  {
    AppMethodBeat.i(211109);
    c localc = this.lrK.bom();
    AppMethodBeat.o(211109);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(211108);
    try
    {
      this.lrK.close();
      try
      {
        if (this.lrN) {
          this.lrL.close();
        }
        AppMethodBeat.o(211108);
        return;
      }
      catch (b.a locala1)
      {
        h.a(5, getLogTag(), "error close dataSink " + locala1.toString(), locala1);
        AppMethodBeat.o(211108);
        return;
      }
      try
      {
        if (this.lrN) {
          this.lrL.close();
        }
        AppMethodBeat.o(211108);
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
    AppMethodBeat.i(211106);
    paramInt2 = this.lrK.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      if (this.lrM)
      {
        AppMethodBeat.o(211106);
        return paramInt2;
      }
    }
    try
    {
      if (this.lrN) {
        this.lrL.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      AppMethodBeat.o(211106);
      return paramInt2;
    }
    catch (b.a paramArrayOfByte)
    {
      for (;;)
      {
        this.lrM = true;
        h.a(5, getLogTag(), "error write dataSink " + paramArrayOfByte.toString(), paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.r
 * JD-Core Version:    0.7.0.1
 */