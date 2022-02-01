package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tf
  extends a
{
  public String imT = "";
  public long jBl;
  public long jBm;
  public long jBn;
  public String jBo = "";
  public long jax;
  public String jzR = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(43631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jBl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jBm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jBn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jax);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jzR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jBo);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(43631);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(43632);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("visitScene:").append(this.jBl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("businessScene:").append(this.jBm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("innerScene:").append(this.jBn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppType:").append(this.jax);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("path:").append(this.jzR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openRate:").append(this.jBo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43632);
    return localObject;
  }
  
  public final int getId()
  {
    return 18852;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tf
 * JD-Core Version:    0.7.0.1
 */