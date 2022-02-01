package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ak
  extends a
{
  private String dHr;
  private String dJY;
  private String dJZ;
  private long dKJ;
  private long dKK;
  private String dKM;
  private long dKa;
  private long dKb;
  
  public final String PV()
  {
    AppMethodBeat.i(168925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKM);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(168925);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(168926);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardType:").append(this.dKJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardResult:").append(this.dKK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.dJY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.dJZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.dKa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.dKb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardToUsr:").append(this.dKM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168926);
    return localObject;
  }
  
  public final ak dM(long paramLong)
  {
    this.dKJ = paramLong;
    return this;
  }
  
  public final ak dN(long paramLong)
  {
    this.dKK = paramLong;
    return this;
  }
  
  public final ak dO(long paramLong)
  {
    this.dKb = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19187;
  }
  
  public final ak ht(String paramString)
  {
    AppMethodBeat.i(168921);
    this.dHr = t("SessionId", paramString, true);
    AppMethodBeat.o(168921);
    return this;
  }
  
  public final ak hu(String paramString)
  {
    AppMethodBeat.i(168922);
    this.dJY = t("Tag", paramString, true);
    AppMethodBeat.o(168922);
    return this;
  }
  
  public final ak hv(String paramString)
  {
    AppMethodBeat.i(168923);
    this.dJZ = t("TagId", paramString, true);
    AppMethodBeat.o(168923);
    return this;
  }
  
  public final ak hw(String paramString)
  {
    AppMethodBeat.i(168924);
    this.dKM = t("ForwardToUsr", paramString, true);
    AppMethodBeat.o(168924);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ak
 * JD-Core Version:    0.7.0.1
 */