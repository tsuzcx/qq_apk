package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hl
  extends a
{
  private String dKI;
  private long hNd;
  private long iRS = 0L;
  private long iRT;
  private String iRU;
  private long iRV;
  private long iRW;
  private String iSd;
  
  public final String PV()
  {
    AppMethodBeat.i(203713);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iRS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hNd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSd);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(203713);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(203714);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("fromTab:").append(this.iRS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toTab:").append(this.iRT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.hNd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickContextid:").append(this.iRU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasRedDot:").append(this.iRV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ManuallyTapped:").append(this.iRW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.iSd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(203714);
    return localObject;
  }
  
  public final hl Zh(String paramString)
  {
    AppMethodBeat.i(203710);
    this.dKI = t("Sessionid", paramString, true);
    AppMethodBeat.o(203710);
    return this;
  }
  
  public final hl Zj(String paramString)
  {
    AppMethodBeat.i(203711);
    this.iRU = t("ClickContextid", paramString, true);
    AppMethodBeat.o(203711);
    return this;
  }
  
  public final hl Zk(String paramString)
  {
    AppMethodBeat.i(203712);
    this.iSd = t("ContextID", paramString, true);
    AppMethodBeat.o(203712);
    return this;
  }
  
  public final String ahP()
  {
    return this.iRU;
  }
  
  public final hl ahR()
  {
    this.iRV = 1L;
    return this;
  }
  
  public final hl ajr()
  {
    this.iRW = 0L;
    return this;
  }
  
  public final int getId()
  {
    return 19949;
  }
  
  public final hl yj(long paramLong)
  {
    this.iRS = paramLong;
    return this;
  }
  
  public final hl yk(long paramLong)
  {
    this.iRT = paramLong;
    return this;
  }
  
  public final hl yl(long paramLong)
  {
    this.hNd = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.hl
 * JD-Core Version:    0.7.0.1
 */