package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ft
  extends a
{
  private long dPs;
  private String dZT;
  private String dZU;
  private long dZV;
  private String dZW;
  private String dZX;
  private long dZY;
  private long dZZ;
  
  public final String PR()
  {
    AppMethodBeat.i(186178);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZZ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(186178);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(186179);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.dZT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.dZU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampInMs:").append(this.dZV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventName:").append(this.dZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventType:").append(this.dPs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Parent:").append(this.dZX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Category:").append(this.dZY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Option:").append(this.dZZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186179);
    return localObject;
  }
  
  public final int getId()
  {
    return 19175;
  }
  
  public final ft km(long paramLong)
  {
    this.dZV = paramLong;
    return this;
  }
  
  public final ft kn(long paramLong)
  {
    this.dPs = paramLong;
    return this;
  }
  
  public final ft ko(long paramLong)
  {
    this.dZY = paramLong;
    return this;
  }
  
  public final ft nm(String paramString)
  {
    AppMethodBeat.i(186174);
    this.dZT = t("InstanceId", paramString, true);
    AppMethodBeat.o(186174);
    return this;
  }
  
  public final ft nn(String paramString)
  {
    AppMethodBeat.i(186175);
    this.dZU = t("Appid", paramString, true);
    AppMethodBeat.o(186175);
    return this;
  }
  
  public final ft no(String paramString)
  {
    AppMethodBeat.i(186176);
    this.dZW = t("EventName", paramString, true);
    AppMethodBeat.o(186176);
    return this;
  }
  
  public final ft np(String paramString)
  {
    AppMethodBeat.i(186177);
    this.dZX = t("Parent", paramString, true);
    AppMethodBeat.o(186177);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ft
 * JD-Core Version:    0.7.0.1
 */