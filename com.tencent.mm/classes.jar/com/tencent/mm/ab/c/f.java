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
  d gbG;
  g gbJ;
  a gbx;
  
  public f(d paramd, g paramg, a parama)
  {
    AppMethodBeat.i(144818);
    Assert.assertNotNull(paramd);
    Assert.assertNotNull(paramg);
    Assert.assertNotNull(parama);
    this.gbG = paramd;
    this.gbJ = paramg;
    this.gbx = parama;
    AppMethodBeat.o(144818);
  }
  
  static String aek()
  {
    AppMethodBeat.i(144819);
    Object localObject = new HashMap();
    ((HashMap)localObject).put("nativeTime", Long.valueOf(System.currentTimeMillis()));
    localObject = new JSONObject((Map)localObject).toString();
    AppMethodBeat.o(144819);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.ab.c.f
 * JD-Core Version:    0.7.0.1
 */