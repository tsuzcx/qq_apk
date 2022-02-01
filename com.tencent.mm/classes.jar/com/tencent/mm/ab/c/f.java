package com.tencent.mm.ab.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ab.b.d;
import com.tencent.mm.ab.d.a;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public final class f
{
  a gzN;
  d gzW;
  g gzZ;
  
  public f(d paramd, g paramg, a parama)
  {
    AppMethodBeat.i(144818);
    Assert.assertNotNull(paramd);
    Assert.assertNotNull(paramg);
    Assert.assertNotNull(parama);
    this.gzW = paramd;
    this.gzZ = paramg;
    this.gzN = parama;
    AppMethodBeat.o(144818);
  }
  
  static String aim()
  {
    AppMethodBeat.i(144819);
    Object localObject = new HashMap();
    ((HashMap)localObject).put("nativeTime", Long.valueOf(System.currentTimeMillis()));
    localObject = new JSONObject((Map)localObject).toString();
    AppMethodBeat.o(144819);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ab.c.f
 * JD-Core Version:    0.7.0.1
 */