package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class SnsTemplateReportStruct
  extends a
{
  private String izT = "";
  private int jia;
  private String jib = "";
  private int jic;
  private int jid;
  private int jie;
  private int jif;
  private String jig = "";
  private String jih = "";
  private int jii;
  private int jij;
  
  public final String aIE()
  {
    AppMethodBeat.i(369316);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jia);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.izT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jib);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jic);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jid);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jie);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jif);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jig);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jih);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jii);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jij);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(369316);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(369319);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("source:").append(this.jia);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionID:").append(this.izT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediadetail:").append(this.jib);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("egviewcnt:").append(this.jic);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("egpreviewcnt:").append(this.jid);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("egendcnt:").append(this.jie);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("musiccnt:").append(this.jif);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("egdetail:").append(this.jig);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("editdetail:").append(this.jih);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("moreAction:").append(this.jii);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("installMiaojian:").append(this.jij);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(369319);
    return localObject;
  }
  
  public final int getId()
  {
    return 25245;
  }
  
  public final SnsTemplateReportStruct setEditdetail(String paramString)
  {
    AppMethodBeat.i(369313);
    this.jih = F("editdetail", paramString, true);
    AppMethodBeat.o(369313);
    return this;
  }
  
  public final SnsTemplateReportStruct setEgdetail(String paramString)
  {
    AppMethodBeat.i(369311);
    this.jig = F("egdetail", paramString, true);
    AppMethodBeat.o(369311);
    return this;
  }
  
  public final SnsTemplateReportStruct setEgendcnt(int paramInt)
  {
    this.jie = paramInt;
    return this;
  }
  
  public final SnsTemplateReportStruct setEgpreviewcnt(int paramInt)
  {
    this.jid = paramInt;
    return this;
  }
  
  public final SnsTemplateReportStruct setEgviewcnt(int paramInt)
  {
    this.jic = paramInt;
    return this;
  }
  
  public final SnsTemplateReportStruct setInstallMiaojian(int paramInt)
  {
    this.jij = paramInt;
    return this;
  }
  
  public final SnsTemplateReportStruct setMediadetail(String paramString)
  {
    AppMethodBeat.i(369301);
    this.jib = F("mediadetail", paramString, true);
    AppMethodBeat.o(369301);
    return this;
  }
  
  public final SnsTemplateReportStruct setMoreAction(int paramInt)
  {
    this.jii = paramInt;
    return this;
  }
  
  public final SnsTemplateReportStruct setMusiccnt(int paramInt)
  {
    this.jif = paramInt;
    return this;
  }
  
  public final SnsTemplateReportStruct setSessionID(String paramString)
  {
    AppMethodBeat.i(369295);
    this.izT = F("sessionID", paramString, true);
    AppMethodBeat.o(369295);
    return this;
  }
  
  public final SnsTemplateReportStruct setSource(int paramInt)
  {
    this.jia = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.SnsTemplateReportStruct
 * JD-Core Version:    0.7.0.1
 */