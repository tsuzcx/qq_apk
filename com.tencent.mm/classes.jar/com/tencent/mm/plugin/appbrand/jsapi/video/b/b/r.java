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
  private String pvQ;
  private final e pwK;
  private final d pwL;
  private boolean pwM;
  private boolean pwN;
  
  public r(e parame, d paramd)
  {
    AppMethodBeat.i(229330);
    this.pvQ = "";
    this.pwK = ((e)a.checkNotNull(parame));
    this.pwL = ((d)a.checkNotNull(paramd));
    AppMethodBeat.o(229330);
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(229349);
    String str = this.pvQ + "TeeDataSource";
    AppMethodBeat.o(229349);
    return str;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(229335);
    long l3 = this.pwK.a(paramg);
    long l1 = -1L;
    c localc = c.pwO;
    long l2;
    Object localObject;
    if ((this.pwK instanceof l))
    {
      l2 = this.pwK.getTotalLength();
      localObject = (List)((l)this.pwK).getResponseHeaders().get("Content-Type");
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (!((List)localObject).isEmpty()) {
          localc = c.aiX((String)((List)localObject).get(0));
        }
      }
    }
    for (;;)
    {
      localObject = paramg;
      if (paramg.aFL == -1L)
      {
        localObject = paramg;
        if (l3 != -1L) {
          localObject = new g(paramg.uri, paramg.bos, paramg.position, l3, paramg.key, paramg.flags, paramg.uuid, paramg.priority);
        }
      }
      this.pwM = false;
      if (l2 != -1L) {}
      for (;;)
      {
        try
        {
          this.pwL.a((g)localObject, l2, localc);
          this.pwN = true;
          AppMethodBeat.o(229335);
          return l3;
        }
        catch (b.a paramg)
        {
          this.pwM = true;
          h.a(5, getLogTag(), "error open dataSink " + paramg.toString(), paramg);
          continue;
        }
        this.pwM = true;
      }
      l2 = l1;
    }
  }
  
  public final long available()
  {
    AppMethodBeat.i(229339);
    long l = this.pwK.available();
    AppMethodBeat.o(229339);
    return l;
  }
  
  public final c bVy()
  {
    AppMethodBeat.i(229346);
    c localc = this.pwK.bVy();
    AppMethodBeat.o(229346);
    return localc;
  }
  
  public final void close()
  {
    AppMethodBeat.i(229345);
    try
    {
      this.pwK.close();
      try
      {
        if (this.pwN) {
          this.pwL.close();
        }
        AppMethodBeat.o(229345);
        return;
      }
      catch (b.a locala1)
      {
        h.a(5, getLogTag(), "error close dataSink " + locala1.toString(), locala1);
        AppMethodBeat.o(229345);
        return;
      }
      try
      {
        if (this.pwN) {
          this.pwL.close();
        }
        AppMethodBeat.o(229345);
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
    AppMethodBeat.i(229347);
    long l = this.pwK.getTotalLength();
    AppMethodBeat.o(229347);
    return l;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(229337);
    paramInt2 = this.pwK.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      if (this.pwM)
      {
        AppMethodBeat.o(229337);
        return paramInt2;
      }
    }
    try
    {
      if (this.pwN) {
        this.pwL.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      AppMethodBeat.o(229337);
      return paramInt2;
    }
    catch (b.a paramArrayOfByte)
    {
      for (;;)
      {
        this.pwM = true;
        h.a(5, getLogTag(), "error write dataSink " + paramArrayOfByte.toString(), paramArrayOfByte);
      }
    }
  }
  
  public final void setLogTag(String paramString)
  {
    this.pvQ = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.r
 * JD-Core Version:    0.7.0.1
 */