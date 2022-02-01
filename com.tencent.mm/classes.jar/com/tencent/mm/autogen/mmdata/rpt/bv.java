package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bv
  extends a
{
  public int ilm;
  public int imW;
  private String iqB = "";
  private String iuD = "";
  public int iuy;
  
  public final String aIE()
  {
    AppMethodBeat.i(183918);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuy);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(183918);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(183919);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.iqB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Md5:").append(this.iuD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.iuy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183919);
    return localObject;
  }
  
  public final int getId()
  {
    return 19434;
  }
  
  public final bv le(String paramString)
  {
    AppMethodBeat.i(183916);
    this.iqB = F("Pid", paramString, true);
    AppMethodBeat.o(183916);
    return this;
  }
  
  public final bv lf(String paramString)
  {
    AppMethodBeat.i(183917);
    this.iuD = F("Md5", paramString, true);
    AppMethodBeat.o(183917);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bv
 * JD-Core Version:    0.7.0.1
 */