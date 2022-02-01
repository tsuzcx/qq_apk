package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gd
  extends a
{
  public int iKv;
  public int iKw;
  public int iKx;
  public long iKy;
  public long iKz;
  private String ikf = "";
  private String ikk = "";
  public int ilm;
  
  public final String aIE()
  {
    AppMethodBeat.i(367995);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ikf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKz);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(367995);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(367999);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("TipsId:").append(this.ikf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Path:").append(this.ikk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeCountLimit:").append(this.iKv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeLimitStrategy:").append(this.iKw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeCount:").append(this.iKx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ColdTime:").append(this.iKy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionMs:").append(this.iKz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(367999);
    return localObject;
  }
  
  public final int getId()
  {
    return 23303;
  }
  
  public final gd qR(String paramString)
  {
    AppMethodBeat.i(367983);
    this.ikf = F("TipsId", paramString, true);
    AppMethodBeat.o(367983);
    return this;
  }
  
  public final gd qS(String paramString)
  {
    AppMethodBeat.i(367988);
    this.ikk = F("Path", paramString, true);
    AppMethodBeat.o(367988);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gd
 * JD-Core Version:    0.7.0.1
 */