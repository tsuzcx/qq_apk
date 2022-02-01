package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class d
  extends a
{
  public long ijA;
  public String ijB = "";
  public String ijC = "";
  public String ijy = "";
  public String ijz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368760);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijC);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368760);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368771);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InputJson:").append(this.ijy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputJson:").append(this.ijz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.ijA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelMd5:").append(this.ijB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriInputJson:").append(this.ijC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368771);
    return localObject;
  }
  
  public final int getId()
  {
    return 21520;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.d
 * JD-Core Version:    0.7.0.1
 */