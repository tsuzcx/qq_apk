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
  private String sAW;
  private final e sBQ;
  private final d sBR;
  private boolean sBS;
  private boolean sBT;
  
  public r(e parame, d paramd)
  {
    AppMethodBeat.i(328544);
    this.sAW = "";
    this.sBQ = ((e)a.checkNotNull(parame));
    this.sBR = ((d)a.checkNotNull(paramd));
    AppMethodBeat.o(328544);
  }
  
  private String getLogTag()
  {
    AppMethodBeat.i(328550);
    String str = this.sAW + "TeeDataSource";
    AppMethodBeat.o(328550);
    return str;
  }
  
  public final long a(g paramg)
  {
    AppMethodBeat.i(328563);
    long l3 = this.sBQ.a(paramg);
    long l1 = -1L;
    c localc = c.sBU;
    long l2;
    Object localObject;
    if ((this.sBQ instanceof l))
    {
      l2 = this.sBQ.getTotalLength();
      localObject = (List)((l)this.sBQ).getResponseHeaders().get("Content-Type");
      l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (!((List)localObject).isEmpty()) {
          localc = c.abW((String)((List)localObject).get(0));
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
      this.sBS = false;
      if (l2 != -1L) {}
      for (;;)
      {
        try
        {
          this.sBR.a((g)localObject, l2, localc);
          this.sBT = true;
          AppMethodBeat.o(328563);
          return l3;
        }
        catch (b.a paramg)
        {
          this.sBS = true;
          h.b(5, getLogTag(), "error open dataSink " + paramg.toString(), paramg);
          continue;
        }
        this.sBS = true;
      }
      l2 = l1;
    }
  }
  
  public final long available()
  {
    AppMethodBeat.i(328575);
    long l = this.sBQ.available();
    AppMethodBeat.o(328575);
    return l;
  }
  
  public final void close()
  {
    AppMethodBeat.i(328581);
    try
    {
      this.sBQ.close();
      try
      {
        if (this.sBT) {
          this.sBR.close();
        }
        AppMethodBeat.o(328581);
        return;
      }
      catch (b.a locala1)
      {
        h.b(5, getLogTag(), "error close dataSink " + locala1.toString(), locala1);
        AppMethodBeat.o(328581);
        return;
      }
      try
      {
        if (this.sBT) {
          this.sBR.close();
        }
        AppMethodBeat.o(328581);
        throw localObject;
      }
      catch (b.a locala2)
      {
        for (;;)
        {
          h.b(5, getLogTag(), "error close dataSink " + locala2.toString(), locala2);
        }
      }
    }
    finally {}
  }
  
  public final c cvM()
  {
    AppMethodBeat.i(328588);
    c localc = this.sBQ.cvM();
    AppMethodBeat.o(328588);
    return localc;
  }
  
  public final long getTotalLength()
  {
    AppMethodBeat.i(328593);
    long l = this.sBQ.getTotalLength();
    AppMethodBeat.o(328593);
    return l;
  }
  
  public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(328568);
    paramInt2 = this.sBQ.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > 0) {
      if (this.sBS)
      {
        AppMethodBeat.o(328568);
        return paramInt2;
      }
    }
    try
    {
      if (this.sBT) {
        this.sBR.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      AppMethodBeat.o(328568);
      return paramInt2;
    }
    catch (b.a paramArrayOfByte)
    {
      for (;;)
      {
        this.sBS = true;
        h.b(5, getLogTag(), "error write dataSink " + paramArrayOfByte.toString(), paramArrayOfByte);
      }
    }
  }
  
  public final void setLogTag(String paramString)
  {
    this.sAW = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.video.b.b.r
 * JD-Core Version:    0.7.0.1
 */