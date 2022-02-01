package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jg
  extends a
{
  public long iDB;
  private String iSn = "";
  public long iSo;
  private String iSp = "";
  public long iSq;
  public long iSr;
  public long iSs;
  public long iSt;
  private String iSu = "";
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368559);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iSn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSu);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368559);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368566);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("moduleName:").append(this.iSn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventCode:").append(this.iSo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventMsg:").append(this.iSp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.iDB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mode:").append(this.iSq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("anchorSEITimestamp:").append(this.iSr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceSEITimestamp:").append(this.iSs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkliveid:").append(this.iSt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderName:").append(this.iSu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368566);
    return localObject;
  }
  
  public final int getId()
  {
    return 21505;
  }
  
  public final jg rZ(String paramString)
  {
    AppMethodBeat.i(368542);
    this.iSn = F("moduleName", paramString, true);
    AppMethodBeat.o(368542);
    return this;
  }
  
  public final jg sa(String paramString)
  {
    AppMethodBeat.i(368547);
    this.iSp = F("eventMsg", paramString, true);
    AppMethodBeat.o(368547);
    return this;
  }
  
  public final jg sb(String paramString)
  {
    AppMethodBeat.i(368551);
    this.iSu = F("finderName", paramString, true);
    AppMethodBeat.o(368551);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jg
 * JD-Core Version:    0.7.0.1
 */