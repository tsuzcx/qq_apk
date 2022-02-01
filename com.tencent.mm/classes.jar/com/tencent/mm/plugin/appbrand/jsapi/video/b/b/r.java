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
  private String kPQ;
  private final e kQK;
  private final d kQL;
  private boolean kQM;
  private boolean kQN;
  
  public r(e parame, d paramd)
  {
    AppMethodBeat.i(194265);
    this.kPQ = "";
    this.kQK = ((e)a.checkNotNull(parame));
    this.kQL = ((d)a.checkNotNull(paramd));
    AppMethodBeat.o(194265);
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(194272);
    String str = this.kPQ + "TeeDataSource";
    AppMethodBeat.o(194272);
    return str;
  }
  
  public final void No(String paramString)
  {
    this.kPQ = paramString;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(194266);
    long l3 = this.kQK.a(paramg);
    long l1 = -1L;
    c localc = c.kQO;
    long l2;
    Object localObject;
    if ((this.kQK instanceof l))
    {
      l2 = this.kQK.aXm();
      localObject = (List)((l)this.kQK).getResponseHeaders().get("Content-Type");
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (!((List)localObject).isEmpty()) {
          localc = c.Nr((String)((List)localObject).get(0));
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
      this.kQM = false;
      if (l2 != -1L) {}
      for (;;)
      {
        try
        {
          this.kQL.a((g)localObject, l2, localc);
          this.kQN = true;
          AppMethodBeat.o(194266);
          return l3;
        }
        catch (b.a paramg)
        {
          this.kQM = true;
          h.a(5, getLogTag(), "error open dataSink " + paramg.toString(), paramg);
          continue;
        }
        this.kQM = true;
      }
      l2 = l1;
    }
  }
  
  public final long aXm()
  {
    AppMethodBeat.i(194271);
    long l = this.kQK.aXm();
    AppMethodBeat.o(194271);
    return l;
  }
  
  public final long available()
  {
    AppMethodBeat.i(194268);
    long l = this.kQK.available();
    AppMethodBeat.o(194268);
    return l;
  }
  
  public final c bjR()
  {
    AppMethodBeat.i(194270);
    c localc = this.kQK.bjR();
    AppMethodBeat.o(194270);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(194269);
    try
    {
      this.kQK.close();
      try
      {
        if (this.kQN) {
          this.kQL.close();
        }
        AppMethodBeat.o(194269);
        return;
      }
      catch (b.a locala1)
      {
        h.a(5, getLogTag(), "error close dataSink " + locala1.toString(), locala1);
        AppMethodBeat.o(194269);
        return;
      }
      try
      {
        if (this.kQN) {
          this.kQL.close();
        }
        AppMethodBeat.o(194269);
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
    AppMethodBeat.i(194267);
    paramInt2 = this.kQK.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      if (this.kQM)
      {
        AppMethodBeat.o(194267);
        return paramInt2;
      }
    }
    try
    {
      if (this.kQN) {
        this.kQL.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      AppMethodBeat.o(194267);
      return paramInt2;
    }
    catch (b.a paramArrayOfByte)
    {
      for (;;)
      {
        this.kQM = true;
        h.a(5, getLogTag(), "error write dataSink " + paramArrayOfByte.toString(), paramArrayOfByte);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.r
 * JD-Core Version:    0.7.0.1
 */