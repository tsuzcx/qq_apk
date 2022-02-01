package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kv
  extends a
{
  public long iMn;
  public String iXK = "";
  public String iXL = "";
  public String iYe = "";
  public int iYf;
  public int iYg;
  public int iYh;
  public long iYi;
  public long iYj;
  public long iYk;
  public long iuA;
  
  public final String aIE()
  {
    AppMethodBeat.i(368277);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iXL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iMn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iYk);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368277);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368282);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.iuA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextId:").append(this.iYe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvObjectId:").append(this.iXK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvNonceId:").append(this.iXL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvIndex:").append(this.iYf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isChanged:").append(this.iYg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isLocal:").append(this.iYh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstFrameTime:").append(this.iMn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaitCount:").append(this.iYi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrType:").append(this.iYj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayErrCode:").append(this.iYk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368282);
    return localObject;
  }
  
  public final int getId()
  {
    return 22278;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.kv
 * JD-Core Version:    0.7.0.1
 */