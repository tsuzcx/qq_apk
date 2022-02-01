package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dj
  extends a
{
  private String dZH;
  private String efH;
  private long efI;
  private long efJ;
  private long efK;
  
  public final String RD()
  {
    AppMethodBeat.i(195654);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dZH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efK);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(195654);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(195655);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EditId:").append(this.dZH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JsonInfo:").append(this.efH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCount:").append(this.efI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageCount:").append(this.efJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditItemCount:").append(this.efK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(195655);
    return localObject;
  }
  
  public final int getId()
  {
    return 20741;
  }
  
  public final dj jI(long paramLong)
  {
    this.efI = paramLong;
    return this;
  }
  
  public final dj jJ(long paramLong)
  {
    this.efJ = paramLong;
    return this;
  }
  
  public final dj jK(long paramLong)
  {
    this.efK = paramLong;
    return this;
  }
  
  public final dj mQ(String paramString)
  {
    AppMethodBeat.i(195652);
    this.dZH = t("EditId", paramString, true);
    AppMethodBeat.o(195652);
    return this;
  }
  
  public final dj mR(String paramString)
  {
    AppMethodBeat.i(195653);
    this.efH = t("JsonInfo", paramString, true);
    AppMethodBeat.o(195653);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dj
 * JD-Core Version:    0.7.0.1
 */