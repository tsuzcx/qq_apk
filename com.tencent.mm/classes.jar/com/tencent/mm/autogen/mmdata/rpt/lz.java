package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class lz
  extends a
{
  public long iAO = 0L;
  public long iEj = 0L;
  public long ikE = 0L;
  public String iqB = "";
  public String iuD = "";
  private long ixB = 0L;
  private String jaA = "";
  private long jaB = 0L;
  private long jaC = 0L;
  private long jaD = 0L;
  public String jaE = "";
  public String jaF = "";
  public String jaG = "";
  private String jaH = "";
  private String jaz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(104431);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iEj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ixB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jaH);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(104431);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(104432);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.iEj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourcePid:").append(this.jaz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceMd5:").append(this.jaA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.iqB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.iuD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.iAO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MaxRowCount:").append(this.jaB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree:").append(this.jaC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.ixB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal:").append(this.jaD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFree2:").append(this.jaE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type2:").append(this.jaF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsLocal2:").append(this.jaG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatID:").append(this.jaH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(104432);
    return localObject;
  }
  
  public final lz aIP()
  {
    this.jaB = 4L;
    return this;
  }
  
  public final int getId()
  {
    return 18739;
  }
  
  public final lz uA(String paramString)
  {
    AppMethodBeat.i(104424);
    this.jaz = F("SourcePid", paramString, true);
    AppMethodBeat.o(104424);
    return this;
  }
  
  public final lz uB(String paramString)
  {
    AppMethodBeat.i(104425);
    this.jaA = F("SourceMd5", paramString, true);
    AppMethodBeat.o(104425);
    return this;
  }
  
  public final lz uC(String paramString)
  {
    AppMethodBeat.i(104426);
    this.iqB = F("Pid", paramString, true);
    AppMethodBeat.o(104426);
    return this;
  }
  
  public final lz uD(String paramString)
  {
    AppMethodBeat.i(104427);
    this.iuD = F("Md5", paramString, true);
    AppMethodBeat.o(104427);
    return this;
  }
  
  public final lz uE(String paramString)
  {
    AppMethodBeat.i(104428);
    this.jaE = F("IsFree2", paramString, true);
    AppMethodBeat.o(104428);
    return this;
  }
  
  public final lz uF(String paramString)
  {
    AppMethodBeat.i(104429);
    this.jaF = F("Type2", paramString, true);
    AppMethodBeat.o(104429);
    return this;
  }
  
  public final lz uG(String paramString)
  {
    AppMethodBeat.i(104430);
    this.jaG = F("IsLocal2", paramString, true);
    AppMethodBeat.o(104430);
    return this;
  }
  
  public final lz uH(String paramString)
  {
    AppMethodBeat.i(368533);
    this.jaH = F("ChatID", paramString, true);
    AppMethodBeat.o(368533);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.lz
 * JD-Core Version:    0.7.0.1
 */