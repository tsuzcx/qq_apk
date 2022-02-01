package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fq
  extends a
{
  public String iJb = "";
  public String iJc = "";
  public int iJd;
  public int iJe;
  public String iJf = "";
  public long iJg;
  public int iJh;
  public String iJi = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368033);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iJb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJi);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368033);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368036);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("opType:").append(this.iJb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreloadSource:").append(this.iJc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("tabType:").append(this.iJd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pullType:").append(this.iJe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("entranceRedDotObjectId:").append(this.iJf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("entranceRedDotScene:").append(this.iJg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("entranceRedDotPreloadFlag:").append(this.iJh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("serverConfig:").append(this.iJi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368036);
    return localObject;
  }
  
  public final int getId()
  {
    return 24123;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.fq
 * JD-Core Version:    0.7.0.1
 */