package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ko
  extends a
{
  private String eWA = "";
  public long eWB;
  public long eWq;
  public long eWr;
  public long eWs;
  public long eWt;
  public String eWu = "";
  public String eWv = "";
  public long eWw;
  private String eWx = "";
  private String eWy = "";
  private String eWz = "";
  
  public final String abV()
  {
    AppMethodBeat.i(43454);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eWB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(43454);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(43455);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterListTimeStamp:").append(this.eWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListTimeStamp:").append(this.eWr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListType:").append(this.eWs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIndex:").append(this.eWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppid:").append(this.eWu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidName:").append(this.eWv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIsStar:").append(this.eWw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom1And5:").append(this.eWx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom6And10:").append(this.eWy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom11And15:").append(this.eWz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom16And20:").append(this.eWA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSession:").append(this.eWB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43455);
    return localObject;
  }
  
  public final int getId()
  {
    return 18094;
  }
  
  public final ko xW(String paramString)
  {
    AppMethodBeat.i(43450);
    this.eWx = x("AppidFrom1And5", paramString, true);
    AppMethodBeat.o(43450);
    return this;
  }
  
  public final ko xX(String paramString)
  {
    AppMethodBeat.i(43451);
    this.eWy = x("AppidFrom6And10", paramString, true);
    AppMethodBeat.o(43451);
    return this;
  }
  
  public final ko xY(String paramString)
  {
    AppMethodBeat.i(43452);
    this.eWz = x("AppidFrom11And15", paramString, true);
    AppMethodBeat.o(43452);
    return this;
  }
  
  public final ko xZ(String paramString)
  {
    AppMethodBeat.i(43453);
    this.eWA = x("AppidFrom16And20", paramString, true);
    AppMethodBeat.o(43453);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ko
 * JD-Core Version:    0.7.0.1
 */