package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qo
  extends a
{
  public long iIE;
  public int imM;
  public String imN = "";
  public long jag;
  public int jtf;
  public int jtg;
  public String jth = "";
  public long jti;
  public int jtj;
  
  public final String aIE()
  {
    AppMethodBeat.i(369247);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jtf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jth);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jti);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jtj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jag);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369247);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369256);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("MsgType:").append(this.jtf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSource:").append(this.jtg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FildID:").append(this.jth);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverwriteMsgID:").append(this.jti);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatType:").append(this.imM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatName:").append(this.imN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.jtj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileSize:").append(this.iIE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSize:").append(this.jag);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369256);
    return localObject;
  }
  
  public final int getId()
  {
    return 25022;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qo
 * JD-Core Version:    0.7.0.1
 */