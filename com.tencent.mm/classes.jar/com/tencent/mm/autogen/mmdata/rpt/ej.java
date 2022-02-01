package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ej
  extends a
{
  public String iDA = "";
  public long iDB;
  public long iDC;
  public long iDD;
  public long iDE;
  public long iDF;
  public long iDG;
  private int iDH;
  public int iDI;
  public long iDJ;
  public long iDK;
  private int iDL;
  public long iDM;
  public long iDN;
  public String iDO = "";
  private long ijn;
  
  public final String aIE()
  {
    AppMethodBeat.i(367923);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iDA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iDO);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367923);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367933);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("tid:").append(this.iDA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.iDB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.ijn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("beginEnterLiveTimestamp:").append(this.iDC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("startCdnPlayTimestamp:").append(this.iDD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cdnPlayerConnectTimestamp:").append(this.iDE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("realCdnPlayOkTimestamp:").append(this.iDF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("firstJoinLiveResponseTimestamp:").append(this.iDG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isPreviewingWhenEnterLive:").append(this.iDH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasJoinLiveMicInfo:").append(this.iDI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("loadJoinLiveMicInfoFinishedTimestamp:").append(this.iDJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("closeLiveOrLiveEndTimestamp:").append(this.iDK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("canReuseCdnPlayerItemWhenEnterLive:").append(this.iDL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userTapOpenLiveTimestamp:").append(this.iDM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("firstShowCdnPlayerViewTimestamp:").append(this.iDN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentSceneStr:").append(this.iDO);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367933);
    return localObject;
  }
  
  public final int getId()
  {
    return 22976;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ej
 * JD-Core Version:    0.7.0.1
 */