package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class al
  extends a
{
  public int ioI = 0;
  public int ioJ = 0;
  public int ioK = 0;
  public int ioL = 0;
  private String ioM = "";
  public int ioN;
  public long ioO = 0L;
  public long ioP = 0L;
  private String ioQ = "";
  public long ioR = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(149905);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioR);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(149905);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(149906);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("optype:").append(this.ioI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errtype:").append(this.ioJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.ioK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mapederror:").append(this.ioL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filekey:").append(this.ioM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filetype:").append(this.ioN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TryWritenBytes:").append(this.ioO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AvailableBytes:").append(this.ioP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SystemErrorDescribe:").append(this.ioQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentFileSize:").append(this.ioR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149906);
    return localObject;
  }
  
  public final int getId()
  {
    return 17473;
  }
  
  public final al kA(String paramString)
  {
    AppMethodBeat.i(149904);
    this.ioQ = F("SystemErrorDescribe", paramString, true);
    AppMethodBeat.o(149904);
    return this;
  }
  
  public final al kz(String paramString)
  {
    AppMethodBeat.i(149903);
    this.ioM = F("filekey", paramString, true);
    AppMethodBeat.o(149903);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.al
 * JD-Core Version:    0.7.0.1
 */