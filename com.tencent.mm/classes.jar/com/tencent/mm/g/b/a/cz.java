package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cz
  extends a
{
  private long dPH;
  private String ecZ;
  private long edN = 0L;
  private long edO;
  private long edP;
  private String edQ;
  private long eda;
  private long edb;
  private long edy;
  
  public final String RD()
  {
    AppMethodBeat.i(211910);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eda);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edQ);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(211910);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(211911);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.ecZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eda);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.edN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.edy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.edb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionResult:").append(this.edO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.edP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUserName:").append(this.edQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(211911);
    return localObject;
  }
  
  public final int getId()
  {
    return 19893;
  }
  
  public final cz iV(long paramLong)
  {
    this.eda = paramLong;
    return this;
  }
  
  public final cz iW(long paramLong)
  {
    this.edy = paramLong;
    return this;
  }
  
  public final cz iX(long paramLong)
  {
    this.edb = paramLong;
    return this;
  }
  
  public final cz iY(long paramLong)
  {
    this.dPH = paramLong;
    return this;
  }
  
  public final cz iZ(long paramLong)
  {
    this.edO = paramLong;
    return this;
  }
  
  public final cz ja(long paramLong)
  {
    this.edP = paramLong;
    return this;
  }
  
  public final cz mg(String paramString)
  {
    AppMethodBeat.i(211908);
    this.ecZ = t("roomid", paramString, true);
    AppMethodBeat.o(211908);
    return this;
  }
  
  public final cz mh(String paramString)
  {
    AppMethodBeat.i(211909);
    this.edQ = t("audienceUserName", paramString, true);
    AppMethodBeat.o(211909);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cz
 * JD-Core Version:    0.7.0.1
 */