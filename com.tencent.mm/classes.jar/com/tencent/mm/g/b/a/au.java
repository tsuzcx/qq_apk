package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class au
  extends a
{
  private String dWq = "";
  private long dYA;
  private String dYB = "";
  private long dYh;
  private long dYw = 0L;
  private long dYx;
  private String dYy = "";
  private long dYz;
  
  public final String RC()
  {
    AppMethodBeat.i(189141);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYB);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189141);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189142);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("fromTab:").append(this.dYw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toTab:").append(this.dYx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.dYh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickContextid:").append(this.dYy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasRedDot:").append(this.dYz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuallyTapped:").append(this.dYA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.dYB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189142);
    return localObject;
  }
  
  public final String RZ()
  {
    return this.dYy;
  }
  
  public final au Sa()
  {
    this.dYz = 1L;
    return this;
  }
  
  public final au dT(long paramLong)
  {
    this.dYw = paramLong;
    return this;
  }
  
  public final au dU(long paramLong)
  {
    this.dYx = paramLong;
    return this;
  }
  
  public final au dV(long paramLong)
  {
    this.dYh = paramLong;
    return this;
  }
  
  public final au dW(long paramLong)
  {
    this.dYA = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19949;
  }
  
  public final au ix(String paramString)
  {
    AppMethodBeat.i(189138);
    this.dWq = t("Sessionid", paramString, true);
    AppMethodBeat.o(189138);
    return this;
  }
  
  public final au iy(String paramString)
  {
    AppMethodBeat.i(189139);
    this.dYy = t("ClickContextid", paramString, true);
    AppMethodBeat.o(189139);
    return this;
  }
  
  public final au iz(String paramString)
  {
    AppMethodBeat.i(189140);
    this.dYB = t("ContextID", paramString, true);
    AppMethodBeat.o(189140);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.au
 * JD-Core Version:    0.7.0.1
 */