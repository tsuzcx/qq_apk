package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kw
  extends a
{
  public long iLV;
  public long iMn;
  public long iMp;
  public String iXK = "";
  public String iXL = "";
  public String iYe = "";
  public String iYl = "";
  public long iYm;
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368283);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iMn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iMp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iLV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYm);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368283);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368288);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextId:").append(this.iYe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvObjectId:").append(this.iXK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvNonceId:").append(this.iXL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstFrameTime:").append(this.iMn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaittingCount:").append(this.iMp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayTime:").append(this.iLV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoPlayInfo:").append(this.iYl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoErrCount:").append(this.iYm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368288);
    return localObject;
  }
  
  public final int getId()
  {
    return 22222;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kw
 * JD-Core Version:    0.7.0.1
 */