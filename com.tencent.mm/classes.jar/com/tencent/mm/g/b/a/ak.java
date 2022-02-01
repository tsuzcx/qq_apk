package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ak
  extends a
{
  private String dHV;
  private long dJg;
  private long dJo = 0L;
  private long dJp;
  private String dJq;
  private long dJr;
  private long dJs;
  private String dJt;
  
  public final String PR()
  {
    AppMethodBeat.i(194929);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dJo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJt);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(194929);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(194930);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("fromTab:").append(this.dJo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toTab:").append(this.dJp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.dJg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dHV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickContextid:").append(this.dJq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasRedDot:").append(this.dJr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuallyTapped:").append(this.dJs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.dJt);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194930);
    return localObject;
  }
  
  public final String Qd()
  {
    return this.dJq;
  }
  
  public final ak Qe()
  {
    this.dJr = 1L;
    return this;
  }
  
  public final ak Qf()
  {
    this.dJs = 0L;
    return this;
  }
  
  public final ak dh(long paramLong)
  {
    this.dJo = paramLong;
    return this;
  }
  
  public final ak di(long paramLong)
  {
    this.dJp = paramLong;
    return this;
  }
  
  public final ak dj(long paramLong)
  {
    this.dJg = paramLong;
    return this;
  }
  
  public final ak gW(String paramString)
  {
    AppMethodBeat.i(194926);
    this.dHV = t("Sessionid", paramString, true);
    AppMethodBeat.o(194926);
    return this;
  }
  
  public final ak gX(String paramString)
  {
    AppMethodBeat.i(194927);
    this.dJq = t("ClickContextid", paramString, true);
    AppMethodBeat.o(194927);
    return this;
  }
  
  public final ak gY(String paramString)
  {
    AppMethodBeat.i(194928);
    this.dJt = t("ContextID", paramString, true);
    AppMethodBeat.o(194928);
    return this;
  }
  
  public final int getId()
  {
    return 19949;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ak
 * JD-Core Version:    0.7.0.1
 */