package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class e
  extends a
{
  public long dFA;
  public long dFB;
  public String dFC;
  public long dFD;
  public long dFE;
  public long dFF;
  public String dFG;
  public String dFH;
  public long dFI;
  public String dFJ;
  public long dFz;
  
  public final String PV()
  {
    AppMethodBeat.i(191120);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFJ);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(191120);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(191121);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("actioncode:").append(this.dFz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selectfriendnum:").append(this.dFA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("modifiedsucfriendnum:").append(this.dFB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("modifiedsucfriendlist:").append(this.dFC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("beforsocialblackfriendnum:").append(this.dFD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("aftersocialblackfriendnum:").append(this.dFE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionnum:").append(this.dFF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selecttagname:").append(this.dFG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selecttagid:").append(this.dFH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("staytime:").append(this.dFI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.dFJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(191121);
    return localObject;
  }
  
  public final int getId()
  {
    return 19824;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.e
 * JD-Core Version:    0.7.0.1
 */