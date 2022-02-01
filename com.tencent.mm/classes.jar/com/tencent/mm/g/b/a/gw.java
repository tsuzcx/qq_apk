package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gw
  extends a
{
  private long eeH;
  private long eqD;
  private String eqE;
  private String eqF;
  private long eqG;
  private long eqH;
  private String eqs;
  private String eqt;
  
  public final String RD()
  {
    AppMethodBeat.i(187823);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqH);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(187823);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(187824);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.eqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Appid:").append(this.eqs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampInMs:").append(this.eqD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventName:").append(this.eqE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventType:").append(this.eeH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Parent:").append(this.eqF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Category:").append(this.eqG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Option:").append(this.eqH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187824);
    return localObject;
  }
  
  public final int getId()
  {
    return 19175;
  }
  
  public final gw mf(long paramLong)
  {
    this.eqD = paramLong;
    return this;
  }
  
  public final gw mg(long paramLong)
  {
    this.eeH = paramLong;
    return this;
  }
  
  public final gw mh(long paramLong)
  {
    this.eqG = paramLong;
    return this;
  }
  
  public final gw mi(long paramLong)
  {
    this.eqH = paramLong;
    return this;
  }
  
  public final gw pL(String paramString)
  {
    AppMethodBeat.i(187819);
    this.eqt = t("InstanceId", paramString, true);
    AppMethodBeat.o(187819);
    return this;
  }
  
  public final gw pM(String paramString)
  {
    AppMethodBeat.i(187820);
    this.eqs = t("Appid", paramString, true);
    AppMethodBeat.o(187820);
    return this;
  }
  
  public final gw pN(String paramString)
  {
    AppMethodBeat.i(187821);
    this.eqE = t("EventName", paramString, true);
    AppMethodBeat.o(187821);
    return this;
  }
  
  public final gw pO(String paramString)
  {
    AppMethodBeat.i(187822);
    this.eqF = t("Parent", paramString, true);
    AppMethodBeat.o(187822);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gw
 * JD-Core Version:    0.7.0.1
 */