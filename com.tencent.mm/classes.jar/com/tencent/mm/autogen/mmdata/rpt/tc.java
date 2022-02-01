package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class tc
  extends a
{
  public String iSn = "";
  public String ilM = "";
  public String imT = "";
  public long ind = 0L;
  public long ine = 0L;
  public long iqr = 0L;
  public String iqw = "";
  public long jAV;
  public long jAW;
  public String jAX = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368807);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ind);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ine);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jAX);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368807);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368812);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InstanceId:").append(this.ilM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppId:").append(this.imT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppVersion:").append(this.ind);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppState:").append(this.ine);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.iqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("moduleName:").append(this.iSn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("packageType:").append(this.jAV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reuse_type:").append(this.jAW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resue_reason:").append(this.jAX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368812);
    return localObject;
  }
  
  public final int getId()
  {
    return 22832;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.tc
 * JD-Core Version:    0.7.0.1
 */