package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hs
  extends a
{
  private String ggA = "";
  private String gnZ = "";
  private String guT = "";
  private int guU;
  private String guV = "";
  private String guW = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209593);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guW);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209593);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209594);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("findercontextid:").append(this.guT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_code:").append(this.guU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("event_time:").append(this.guV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eid:").append(this.gnZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udf_kv:").append(this.guW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209594);
    return localObject;
  }
  
  public final int getId()
  {
    return 22657;
  }
  
  public final hs nf(int paramInt)
  {
    this.guU = paramInt;
    return this;
  }
  
  public final hs wY(String paramString)
  {
    AppMethodBeat.i(209584);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(209584);
    return this;
  }
  
  public final hs wZ(String paramString)
  {
    AppMethodBeat.i(209585);
    this.guT = z("findercontextid", paramString, true);
    AppMethodBeat.o(209585);
    return this;
  }
  
  public final hs xa(String paramString)
  {
    AppMethodBeat.i(209587);
    this.guV = z("event_time", paramString, true);
    AppMethodBeat.o(209587);
    return this;
  }
  
  public final hs xb(String paramString)
  {
    AppMethodBeat.i(209589);
    this.gnZ = z("eid", paramString, true);
    AppMethodBeat.o(209589);
    return this;
  }
  
  public final hs xc(String paramString)
  {
    AppMethodBeat.i(209591);
    this.guW = z("udf_kv", paramString, true);
    AppMethodBeat.o(209591);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hs
 * JD-Core Version:    0.7.0.1
 */