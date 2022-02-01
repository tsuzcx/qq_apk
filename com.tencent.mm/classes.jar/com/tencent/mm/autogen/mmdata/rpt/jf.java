package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jf
  extends a
{
  public long iFo;
  public String iNB = "";
  public long iQA;
  public long iQB;
  public long iQC;
  public long iQP;
  private String iQS = "";
  public String iQT = "";
  public long iSh;
  public long iSi;
  public long iSj;
  public long iSk;
  public long iSl;
  public long iSm;
  public long iku;
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368557);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iku);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368557);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368571);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.iNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.iFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.iQS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.iQP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterRoomCount:").append(this.iSh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitRoomCount:").append(this.iSi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.iQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.iQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectReqCount:").append(this.iSj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.iQC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.iQT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.iku);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("enterTimestamp:").append(this.iSk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitTimestamp:").append(this.iSl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitChatroomUV:").append(this.iSm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368571);
    return localObject;
  }
  
  public final int getId()
  {
    return 19892;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jf
 * JD-Core Version:    0.7.0.1
 */