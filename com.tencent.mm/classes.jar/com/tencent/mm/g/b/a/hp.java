package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hp
  extends a
{
  private long dFf;
  private String dKI;
  private long dKe;
  private String dkR;
  private String jiI;
  private long lQq;
  
  public final String PV()
  {
    AppMethodBeat.i(203748);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dkR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jiI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.lQq);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203748);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203749);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dkR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.jiI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTimeStamp:").append(this.lQq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203749);
    return localObject;
  }
  
  public final hp aRP(String paramString)
  {
    AppMethodBeat.i(203745);
    this.dKI = t("Sessionid", paramString, true);
    AppMethodBeat.o(203745);
    return this;
  }
  
  public final hp aRQ(String paramString)
  {
    AppMethodBeat.i(203746);
    this.dkR = t("Contextid", paramString, true);
    AppMethodBeat.o(203746);
    return this;
  }
  
  public final hp aRR(String paramString)
  {
    AppMethodBeat.i(203747);
    this.jiI = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(203747);
    return this;
  }
  
  public final int getId()
  {
    return 19998;
  }
  
  public final hp yC(long paramLong)
  {
    this.dKe = paramLong;
    return this;
  }
  
  public final hp yD(long paramLong)
  {
    this.dFf = paramLong;
    return this;
  }
  
  public final hp yE(long paramLong)
  {
    this.lQq = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hp
 * JD-Core Version:    0.7.0.1
 */