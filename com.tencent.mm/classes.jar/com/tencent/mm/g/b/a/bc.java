package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bc
  extends a
{
  private long dLG;
  private String dLH;
  private long dLI;
  private long dLJ;
  private String dLK;
  private long dLL;
  
  public final String PR()
  {
    AppMethodBeat.i(195018);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dLG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dLL);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(195018);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(195019);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("CtrType:").append(this.dLG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TipsId:").append(this.dLH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecallTime:").append(this.dLI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.dLJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeId:").append(this.dLK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeStatus:").append(this.dLL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195019);
    return localObject;
  }
  
  public final bc eW(long paramLong)
  {
    this.dLG = paramLong;
    return this;
  }
  
  public final bc eX(long paramLong)
  {
    this.dLI = paramLong;
    return this;
  }
  
  public final bc eY(long paramLong)
  {
    this.dLJ = paramLong;
    return this;
  }
  
  public final bc eZ(long paramLong)
  {
    this.dLL = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20223;
  }
  
  public final bc iQ(String paramString)
  {
    AppMethodBeat.i(195016);
    this.dLH = t("TipsId", paramString, true);
    AppMethodBeat.o(195016);
    return this;
  }
  
  public final bc iR(String paramString)
  {
    AppMethodBeat.i(195017);
    this.dLK = t("RevokeId", paramString, true);
    AppMethodBeat.o(195017);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bc
 * JD-Core Version:    0.7.0.1
 */