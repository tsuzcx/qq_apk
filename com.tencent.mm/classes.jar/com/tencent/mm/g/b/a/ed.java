package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ed
  extends a
{
  private long dNR;
  private String dYa;
  private String dYb;
  private long dYc;
  private String dYd;
  private String dYe;
  private long dYf;
  private long dYg;
  
  public final String PV()
  {
    AppMethodBeat.i(195479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYg);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(195479);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(195480);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dYa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.dYb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampInMs:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventName:").append(this.dYd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventType:").append(this.dNR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Parent:").append(this.dYe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Category:").append(this.dYf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Option:").append(this.dYg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195480);
    return localObject;
  }
  
  public final ed gR(long paramLong)
  {
    this.dYc = paramLong;
    return this;
  }
  
  public final ed gS(long paramLong)
  {
    this.dNR = paramLong;
    return this;
  }
  
  public final ed gT(long paramLong)
  {
    this.dYf = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19175;
  }
  
  public final ed ku(String paramString)
  {
    AppMethodBeat.i(195475);
    this.dYa = t("InstanceId", paramString, true);
    AppMethodBeat.o(195475);
    return this;
  }
  
  public final ed kv(String paramString)
  {
    AppMethodBeat.i(195476);
    this.dYb = t("Appid", paramString, true);
    AppMethodBeat.o(195476);
    return this;
  }
  
  public final ed kw(String paramString)
  {
    AppMethodBeat.i(195477);
    this.dYd = t("EventName", paramString, true);
    AppMethodBeat.o(195477);
    return this;
  }
  
  public final ed kx(String paramString)
  {
    AppMethodBeat.i(195478);
    this.dYe = t("Parent", paramString, true);
    AppMethodBeat.o(195478);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ed
 * JD-Core Version:    0.7.0.1
 */