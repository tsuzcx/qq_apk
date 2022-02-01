package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bb
  extends a
{
  public long imq;
  private String inx = "";
  private long iqr = 0L;
  private long iqs = 0L;
  public long iqt = 0L;
  private String iqu = "";
  public long iqv;
  private String iqw = "";
  private String iqx = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368993);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.imq);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368993);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368998);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DesignerUin:").append(this.iqs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SetID:").append(this.iqt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SetName:").append(this.iqu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("entrance_scene:").append(this.iqv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.iqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("index:").append(this.iqx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("page:").append(this.imq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368998);
    return localObject;
  }
  
  public final bb aIK()
  {
    this.iqr = 3L;
    return this;
  }
  
  public final int getId()
  {
    return 12875;
  }
  
  public final bb kN(String paramString)
  {
    AppMethodBeat.i(368972);
    this.iqu = F("SetName", paramString, true);
    AppMethodBeat.o(368972);
    return this;
  }
  
  public final bb kO(String paramString)
  {
    AppMethodBeat.i(368975);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(368975);
    return this;
  }
  
  public final bb kP(String paramString)
  {
    AppMethodBeat.i(368981);
    this.iqw = F("md5", paramString, true);
    AppMethodBeat.o(368981);
    return this;
  }
  
  public final bb kQ(String paramString)
  {
    AppMethodBeat.i(368987);
    this.iqx = F("index", paramString, true);
    AppMethodBeat.o(368987);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bb
 * JD-Core Version:    0.7.0.1
 */