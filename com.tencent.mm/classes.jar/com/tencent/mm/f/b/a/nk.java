package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nk
  extends a
{
  public long gYW;
  public long gYX;
  public long gYY;
  public long gYZ;
  public String gZa = "";
  public String gZb = "";
  public long gZc;
  private String gZd = "";
  private String gZe = "";
  private String gZf = "";
  private String gZg = "";
  public long gZh;
  
  public final nk Eo(String paramString)
  {
    AppMethodBeat.i(43450);
    this.gZd = z("AppidFrom1And5", paramString, true);
    AppMethodBeat.o(43450);
    return this;
  }
  
  public final nk Ep(String paramString)
  {
    AppMethodBeat.i(43451);
    this.gZe = z("AppidFrom6And10", paramString, true);
    AppMethodBeat.o(43451);
    return this;
  }
  
  public final nk Eq(String paramString)
  {
    AppMethodBeat.i(43452);
    this.gZf = z("AppidFrom11And15", paramString, true);
    AppMethodBeat.o(43452);
    return this;
  }
  
  public final nk Er(String paramString)
  {
    AppMethodBeat.i(43453);
    this.gZg = z("AppidFrom16And20", paramString, true);
    AppMethodBeat.o(43453);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(43454);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gYW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gZh);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(43454);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(43455);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterListTimeStamp:").append(this.gYW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListTimeStamp:").append(this.gYX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListType:").append(this.gYY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIndex:").append(this.gYZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppid:").append(this.gZa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidName:").append(this.gZb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIsStar:").append(this.gZc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom1And5:").append(this.gZd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom6And10:").append(this.gZe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom11And15:").append(this.gZf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom16And20:").append(this.gZg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSession:").append(this.gZh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43455);
    return localObject;
  }
  
  public final int getId()
  {
    return 18094;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.nk
 * JD-Core Version:    0.7.0.1
 */