package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qc
  extends a
{
  private String ijk = "";
  private String ilz = "";
  public int ipH;
  private String jqd = "";
  private String jqe = "";
  public int jqf;
  public int jqg;
  public int jqh;
  private String jqi = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(369015);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jqe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jqf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jqg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jqh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jqi);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369015);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369021);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TypeSessionId:").append(this.jqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ipH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ButtonType:").append(this.jqe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatId:").append(this.ilz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TypeLength:").append(this.jqf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TransLength:").append(this.jqg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendLength:").append(this.jqh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TargetLanguage:").append(this.jqi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369021);
    return localObject;
  }
  
  public final int getId()
  {
    return 23607;
  }
  
  public final qc xg(String paramString)
  {
    AppMethodBeat.i(369002);
    this.jqd = F("TypeSessionId", paramString, true);
    AppMethodBeat.o(369002);
    return this;
  }
  
  public final qc xh(String paramString)
  {
    AppMethodBeat.i(369004);
    this.jqe = F("ButtonType", paramString, true);
    AppMethodBeat.o(369004);
    return this;
  }
  
  public final qc xi(String paramString)
  {
    AppMethodBeat.i(369008);
    this.ilz = F("ChatId", paramString, true);
    AppMethodBeat.o(369008);
    return this;
  }
  
  public final qc xj(String paramString)
  {
    AppMethodBeat.i(369011);
    this.jqi = F("TargetLanguage", paramString, true);
    AppMethodBeat.o(369011);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.qc
 * JD-Core Version:    0.7.0.1
 */