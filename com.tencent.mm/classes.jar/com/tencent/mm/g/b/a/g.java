package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class g
  extends a
{
  public long dRA;
  public long dRB;
  public String dRC = "";
  public long dRD;
  public long dRE;
  public long dRF;
  public String dRG = "";
  public String dRH = "";
  public long dRI;
  public String dRJ = "";
  public long dRz;
  
  public final String RC()
  {
    AppMethodBeat.i(186322);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRJ);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(186322);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(186323);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actioncode:").append(this.dRz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectfriendnum:").append(this.dRA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("modifiedsucfriendnum:").append(this.dRB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("modifiedsucfriendlist:").append(this.dRC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("beforsocialblackfriendnum:").append(this.dRD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("aftersocialblackfriendnum:").append(this.dRE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionnum:").append(this.dRF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selecttagname:").append(this.dRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selecttagid:").append(this.dRH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("staytime:").append(this.dRI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dRJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186323);
    return localObject;
  }
  
  public final int getId()
  {
    return 19824;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.g
 * JD-Core Version:    0.7.0.1
 */