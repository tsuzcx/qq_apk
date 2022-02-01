package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ss
  extends a
{
  private String iEy = "";
  public long iQF;
  private String ipx = "";
  private String iqX = "";
  public long jzA;
  public int jzB;
  public int jzC;
  public int jzD;
  private String jzx = "";
  public long jzy;
  public long jzz;
  
  public final String aIE()
  {
    AppMethodBeat.i(369007);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jzx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jzy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jzz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iQF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iEy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jzA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jzB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jzC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jzD);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369007);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369018);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("instanceId:").append(this.jzx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.ipx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("username:").append(this.iqX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("startTimeStamp:").append(this.jzy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("endTimeStamp:").append(this.jzz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.iQF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("networkType:").append(this.iEy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("responseSize:").append(this.jzA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ret:").append(this.jzB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("bizRet:").append(this.jzC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cgiNo:").append(this.jzD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369018);
    return localObject;
  }
  
  public final int getId()
  {
    return 19127;
  }
  
  public final ss zi(String paramString)
  {
    AppMethodBeat.i(368976);
    this.jzx = F("instanceId", paramString, true);
    AppMethodBeat.o(368976);
    return this;
  }
  
  public final ss zj(String paramString)
  {
    AppMethodBeat.i(368986);
    this.ipx = F("appid", paramString, true);
    AppMethodBeat.o(368986);
    return this;
  }
  
  public final ss zk(String paramString)
  {
    AppMethodBeat.i(368995);
    this.iqX = F("username", paramString, true);
    AppMethodBeat.o(368995);
    return this;
  }
  
  public final ss zl(String paramString)
  {
    AppMethodBeat.i(368999);
    this.iEy = F("networkType", paramString, true);
    AppMethodBeat.o(368999);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ss
 * JD-Core Version:    0.7.0.1
 */