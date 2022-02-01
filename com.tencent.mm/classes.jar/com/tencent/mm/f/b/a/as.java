package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class as
  extends a
{
  private long geB;
  private long gjN;
  private String gjO = "";
  private String gjP = "";
  private long gjQ;
  
  public final String agH()
  {
    AppMethodBeat.i(285373);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjQ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(285373);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(285374);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionTimestamp:").append(this.gjN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.gjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.gjP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Entrance_Type:").append(this.gjQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(285374);
    return localObject;
  }
  
  public final as cF(long paramLong)
  {
    this.gjN = paramLong;
    return this;
  }
  
  public final as cG(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final as cH(long paramLong)
  {
    this.gjQ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21831;
  }
  
  public final as jr(String paramString)
  {
    AppMethodBeat.i(285371);
    this.gjO = z("SessionID", paramString, true);
    AppMethodBeat.o(285371);
    return this;
  }
  
  public final as js(String paramString)
  {
    AppMethodBeat.i(285372);
    this.gjP = z("ContextID", paramString, true);
    AppMethodBeat.o(285372);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.as
 * JD-Core Version:    0.7.0.1
 */