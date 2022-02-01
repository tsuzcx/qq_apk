package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ep
  extends a
{
  public String ijk = "";
  public long ioV;
  public String iwX = "";
  public long izK;
  
  public final String aIE()
  {
    AppMethodBeat.i(367916);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367916);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367922);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.iwX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.izK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367922);
    return localObject;
  }
  
  public final ep eP(long paramLong)
  {
    AppMethodBeat.i(367902);
    this.izK = paramLong;
    super.bw("ActionTimeMs", this.izK);
    AppMethodBeat.o(367902);
    return this;
  }
  
  public final int getId()
  {
    return 21919;
  }
  
  public final ep pc(String paramString)
  {
    AppMethodBeat.i(367892);
    this.iwX = F("ActionResult", paramString, true);
    AppMethodBeat.o(367892);
    return this;
  }
  
  public final ep pd(String paramString)
  {
    AppMethodBeat.i(367908);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(367908);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ep
 * JD-Core Version:    0.7.0.1
 */