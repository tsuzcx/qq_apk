package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class at
  extends a
{
  public long ikt = 0L;
  public long ila;
  public String ipA = "";
  private String ipq = "";
  public long ips = 0L;
  public long ipv;
  public long ipw = 0L;
  public String ipx = "";
  public String ipy = "";
  public String ipz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(184765);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ipq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ips);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipA);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184765);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184766);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomusrname:").append(this.ipq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topCount:").append(this.ipv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedCount:").append(this.ipw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("role:").append(this.ips);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.ipx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appname:").append(this.ipy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isTop:").append(this.ikt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topAppList:").append(this.ipz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usedAppList:").append(this.ipA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184766);
    return localObject;
  }
  
  public final int getId()
  {
    return 19436;
  }
  
  public final at kH(String paramString)
  {
    AppMethodBeat.i(184764);
    this.ipq = F("roomusrname", paramString, true);
    AppMethodBeat.o(184764);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.at
 * JD-Core Version:    0.7.0.1
 */