package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class pb
  extends a
{
  private String ijk = "";
  public long jkg = 0L;
  private String jld = "";
  public long jle = 0L;
  private String jlf = "";
  public long jlg = 0L;
  
  public final String aIE()
  {
    AppMethodBeat.i(94854);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jld);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jle);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jlg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jkg);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(94854);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(94855);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterObjectId:").append(this.jld);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinCount:").append(this.jle);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeUinList:").append(this.jlf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewVideoCount:").append(this.jlg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.jkg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94855);
    return localObject;
  }
  
  public final int getId()
  {
    return 16843;
  }
  
  public final pb wD(String paramString)
  {
    AppMethodBeat.i(94851);
    this.jld = F("EnterObjectId", paramString, true);
    AppMethodBeat.o(94851);
    return this;
  }
  
  public final pb wE(String paramString)
  {
    AppMethodBeat.i(94852);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(94852);
    return this;
  }
  
  public final pb wF(String paramString)
  {
    AppMethodBeat.i(94853);
    this.jlf = F("ExposeUinList", paramString, true);
    AppMethodBeat.o(94853);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.pb
 * JD-Core Version:    0.7.0.1
 */