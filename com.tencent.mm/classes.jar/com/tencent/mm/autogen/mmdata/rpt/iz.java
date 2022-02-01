package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class iz
  extends a
{
  public long iFo;
  public String iNB = "";
  private String iQS = "";
  public String iQT = "";
  private long iRf = 0L;
  public long iRg;
  public long iRh;
  public String iRi = "";
  public long iRj;
  public long iRk;
  public long iRl;
  public long iRm;
  public long iku;
  
  public final String aIE()
  {
    AppMethodBeat.i(368672);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iku);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iRm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368672);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368676);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.iFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micid:").append(this.iRf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.iQS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.iku);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("closeRole:").append(this.iRg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasVideo:").append(this.iRh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.iQT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("livemicid:").append(this.iRi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStamp:").append(this.iRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStamp:").append(this.iRk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartAudienceUV:").append(this.iRl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndAudienceUV:").append(this.iRm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368676);
    return localObject;
  }
  
  public final int getId()
  {
    return 19895;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.iz
 * JD-Core Version:    0.7.0.1
 */