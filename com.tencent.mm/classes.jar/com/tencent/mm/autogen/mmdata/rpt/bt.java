package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bt
  extends a
{
  public int ilm;
  private String iqB = "";
  public int iuw;
  private String iux = "";
  public int iuy;
  
  public final String aIE()
  {
    AppMethodBeat.i(183914);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iux);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqB);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(183914);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(183915);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRed:").append(this.iuw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterPid:").append(this.iux);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Index:").append(this.iuy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Pid:").append(this.iqB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(183915);
    return localObject;
  }
  
  public final int getId()
  {
    return 19435;
  }
  
  public final bt lb(String paramString)
  {
    AppMethodBeat.i(183912);
    this.iux = F("EnterPid", paramString, true);
    AppMethodBeat.o(183912);
    return this;
  }
  
  public final bt lc(String paramString)
  {
    AppMethodBeat.i(183913);
    this.iqB = F("Pid", paramString, true);
    AppMethodBeat.o(183913);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bt
 * JD-Core Version:    0.7.0.1
 */