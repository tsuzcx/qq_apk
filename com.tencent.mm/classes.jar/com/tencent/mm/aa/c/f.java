package com.tencent.mm.aa.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aa.b.d;
import com.tencent.mm.aa.d.a;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public final class f
{
  a hpi;
  d hpr;
  g hpu;
  
  public f(d paramd, g paramg, a parama)
  {
    AppMethodBeat.i(144818);
    Assert.assertNotNull(paramd);
    Assert.assertNotNull(paramg);
    Assert.assertNotNull(parama);
    this.hpr = paramd;
    this.hpu = paramg;
    this.hpi = parama;
    AppMethodBeat.o(144818);
  }
  
  static String ayR()
  {
    AppMethodBeat.i(144819);
    Object localObject = new HashMap();
    ((HashMap)localObject).put("nativeTime", Long.valueOf(System.currentTimeMillis()));
    localObject = new JSONObject((Map)localObject).toString();
    AppMethodBeat.o(144819);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aa.c.f
 * JD-Core Version:    0.7.0.1
 */