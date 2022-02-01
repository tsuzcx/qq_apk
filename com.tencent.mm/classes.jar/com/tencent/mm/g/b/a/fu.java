package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fu
  extends a
{
  public long eaa;
  public long eab;
  public long eac;
  public long ead;
  public String eae;
  public String eaf;
  public long eag;
  private String eah;
  private String eai;
  private String eaj;
  private String eak;
  public long eal;
  
  public final String PR()
  {
    AppMethodBeat.i(43454);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eaa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eab);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eac);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ead);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eae);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eag);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eah);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eai);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eaj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eak);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eal);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(43454);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(43455);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EnterListTimeStamp:").append(this.eaa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListTimeStamp:").append(this.eab);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LeaveListType:").append(this.eac);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIndex:").append(this.ead);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppid:").append(this.eae);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidName:").append(this.eaf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickAppidIsStar:").append(this.eag);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom1And5:").append(this.eah);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom6And10:").append(this.eai);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom11And15:").append(this.eaj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppidFrom16And20:").append(this.eak);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("openSession:").append(this.eal);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(43455);
    return localObject;
  }
  
  public final int getId()
  {
    return 18094;
  }
  
  public final fu nq(String paramString)
  {
    AppMethodBeat.i(43450);
    this.eah = t("AppidFrom1And5", paramString, true);
    AppMethodBeat.o(43450);
    return this;
  }
  
  public final fu nr(String paramString)
  {
    AppMethodBeat.i(43451);
    this.eai = t("AppidFrom6And10", paramString, true);
    AppMethodBeat.o(43451);
    return this;
  }
  
  public final fu ns(String paramString)
  {
    AppMethodBeat.i(43452);
    this.eaj = t("AppidFrom11And15", paramString, true);
    AppMethodBeat.o(43452);
    return this;
  }
  
  public final fu nt(String paramString)
  {
    AppMethodBeat.i(43453);
    this.eak = t("AppidFrom16And20", paramString, true);
    AppMethodBeat.o(43453);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fu
 * JD-Core Version:    0.7.0.1
 */