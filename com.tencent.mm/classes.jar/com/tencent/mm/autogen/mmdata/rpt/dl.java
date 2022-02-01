package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dl
  extends a
{
  public long ioV;
  public String izG = "";
  public String izH = "";
  public int izI;
  public String izJ = "";
  public long izK;
  
  public final String aIE()
  {
    AppMethodBeat.i(368441);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.izG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368441);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368446);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FinderUsrname:").append(this.izG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderWxAppInfo:").append(this.izH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPrivate:").append(this.izI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.izJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.izK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368446);
    return localObject;
  }
  
  public final dl eI(long paramLong)
  {
    AppMethodBeat.i(368436);
    this.izK = paramLong;
    super.bw("ActionTimeMs", this.izK);
    AppMethodBeat.o(368436);
    return this;
  }
  
  public final int getId()
  {
    return 21113;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.dl
 * JD-Core Version:    0.7.0.1
 */