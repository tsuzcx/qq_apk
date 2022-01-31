package com.tencent.mm.plugin.appbrand.debugger;

import com.tencent.mm.h.a.m;
import com.tencent.mm.h.a.m.a;
import com.tencent.mm.protocal.c.cgt;
import com.tencent.mm.sdk.b.c;
import org.json.JSONObject;

final class l$4
  extends c<m>
{
  l$4(l paraml)
  {
    this.udX = m.class.getName().hashCode();
  }
  
  private boolean a(m paramm)
  {
    if ((paramm == null) || (paramm.bFp == null) || (paramm.bFp.bFs == null)) {
      return true;
    }
    cgt localcgt = new cgt();
    localcgt.bFq = paramm.bFp.bFq;
    localcgt.bFr = paramm.bFp.bFr;
    localcgt.tVG = paramm.bFp.bFs.toString();
    localcgt.timestamp = System.currentTimeMillis();
    paramm = r.a(localcgt, this.fSs.fSm, "networkDebugAPI");
    this.fSs.a(paramm);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.l.4
 * JD-Core Version:    0.7.0.1
 */