package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dd
  extends a
{
  public String ijk = "";
  public long iqE;
  public long iyK;
  public long iyL;
  private String iyM = "";
  public long iyN;
  public long iyO;
  private long iyP;
  public long iyQ;
  private long iyR;
  public long iyS;
  
  public final String aIE()
  {
    AppMethodBeat.i(368492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iyS);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368492);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368503);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.iyK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReason:").append(this.iyL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailReasonWording:").append(this.iyM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasAvatar:").append(this.iyN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasNickName:").append(this.iyO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSignature:").append(this.iyP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSex:").append(this.iyQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasLocation:").append(this.iqE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasCheckAgreement:").append(this.iyR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("createscene:").append(this.iyS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368503);
    return localObject;
  }
  
  public final int getId()
  {
    return 19815;
  }
  
  public final dd nh(String paramString)
  {
    AppMethodBeat.i(368485);
    this.iyM = F("FailReasonWording", paramString, true);
    AppMethodBeat.o(368485);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dd
 * JD-Core Version:    0.7.0.1
 */