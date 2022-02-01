package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gz
  extends a
{
  public long esA;
  public long esp;
  public long esq;
  public long esr;
  public long ess;
  public String est = "";
  public String esu = "";
  public long esv;
  private String esw = "";
  private String esx = "";
  private String esy = "";
  private String esz = "";
  
  public final String RC()
  {
    AppMethodBeat.i(43454);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ess);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.est);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esA);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(43454);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(43455);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterListTimeStamp:").append(this.esp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListTimeStamp:").append(this.esq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListType:").append(this.esr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIndex:").append(this.ess);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppid:").append(this.est);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidName:").append(this.esu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIsStar:").append(this.esv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom1And5:").append(this.esw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom6And10:").append(this.esx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom11And15:").append(this.esy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom16And20:").append(this.esz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSession:").append(this.esA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43455);
    return localObject;
  }
  
  public final int getId()
  {
    return 18094;
  }
  
  public final gz qk(String paramString)
  {
    AppMethodBeat.i(43450);
    this.esw = t("AppidFrom1And5", paramString, true);
    AppMethodBeat.o(43450);
    return this;
  }
  
  public final gz ql(String paramString)
  {
    AppMethodBeat.i(43451);
    this.esx = t("AppidFrom6And10", paramString, true);
    AppMethodBeat.o(43451);
    return this;
  }
  
  public final gz qm(String paramString)
  {
    AppMethodBeat.i(43452);
    this.esy = t("AppidFrom11And15", paramString, true);
    AppMethodBeat.o(43452);
    return this;
  }
  
  public final gz qn(String paramString)
  {
    AppMethodBeat.i(43453);
    this.esz = t("AppidFrom16And20", paramString, true);
    AppMethodBeat.o(43453);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gz
 * JD-Core Version:    0.7.0.1
 */