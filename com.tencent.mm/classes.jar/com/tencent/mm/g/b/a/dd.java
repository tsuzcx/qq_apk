package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dd
  extends a
{
  private long dFO = 0L;
  private String dTG = "";
  public long dTH = 0L;
  private long dTI = 0L;
  private long dTd = 0L;
  private long dTe = 0L;
  
  public final String PV()
  {
    AppMethodBeat.i(118486);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTI);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(118486);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(118487);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("NetType:").append(this.dFO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.dTd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceUserName:").append(this.dTG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceContactType:").append(this.dTH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.dTe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasEnterPreview:").append(this.dTI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118487);
    return localObject;
  }
  
  public final dd QJ()
  {
    this.dTe = 1L;
    return this;
  }
  
  public final dd QK()
  {
    this.dTI = 1L;
    return this;
  }
  
  public final dd fA(long paramLong)
  {
    this.dTd = paramLong;
    return this;
  }
  
  public final dd fz(long paramLong)
  {
    this.dFO = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 16659;
  }
  
  public final dd jC(String paramString)
  {
    AppMethodBeat.i(118485);
    this.dTG = t("SourceUserName", paramString, true);
    AppMethodBeat.o(118485);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dd
 * JD-Core Version:    0.7.0.1
 */