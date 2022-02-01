package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gc
  extends a
{
  public long iGr;
  private String iIg = "";
  private String iJT = "";
  public long iJV;
  public long iKa;
  public long iKn;
  public long iKo;
  public long iKp;
  public long iKq;
  private String iKr = "";
  private String iKs = "";
  private long iKt;
  public long iKu;
  private String ijk = "";
  public long ikE;
  private String ipT = "";
  private String ipU = "";
  private String ivZ = "";
  public long iwf;
  
  public final String aIE()
  {
    AppMethodBeat.i(184179);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ijk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iwf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ivZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iGr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iJV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iKu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iIg);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(184179);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(184180);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.ijk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrUI:").append(this.iJT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotType:").append(this.iKn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ikE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotSubType:").append(this.iKo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShowType:").append(this.iKp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerVersion:").append(this.iwf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotCount:").append(this.iKq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotId:").append(this.iKr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWording:").append(this.iKs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotWordingType:").append(this.iKt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.ivZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.ipT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.ipU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.iGr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsOpenRedDotButton:").append(this.iJV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CurrentTabType:").append(this.iKa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AutoClick:").append(this.iKu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtInfo:").append(this.iIg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184180);
    return localObject;
  }
  
  public final int getId()
  {
    return 18948;
  }
  
  public final gc qJ(String paramString)
  {
    AppMethodBeat.i(184176);
    this.ijk = F("SessionId", paramString, true);
    AppMethodBeat.o(184176);
    return this;
  }
  
  public final gc qK(String paramString)
  {
    AppMethodBeat.i(184177);
    this.iJT = F("CurrUI", paramString, true);
    AppMethodBeat.o(184177);
    return this;
  }
  
  public final gc qL(String paramString)
  {
    AppMethodBeat.i(184178);
    this.iKr = F("RedDotId", paramString, true);
    AppMethodBeat.o(184178);
    return this;
  }
  
  public final gc qM(String paramString)
  {
    AppMethodBeat.i(186003);
    this.iKs = F("RedDotWording", paramString, true);
    AppMethodBeat.o(186003);
    return this;
  }
  
  public final gc qN(String paramString)
  {
    AppMethodBeat.i(368019);
    this.ivZ = F("FeedId", paramString, true);
    AppMethodBeat.o(368019);
    return this;
  }
  
  public final gc qO(String paramString)
  {
    AppMethodBeat.i(368024);
    this.ipT = F("ContextId", paramString, true);
    AppMethodBeat.o(368024);
    return this;
  }
  
  public final gc qP(String paramString)
  {
    AppMethodBeat.i(368026);
    this.ipU = F("ClickTabContextId", paramString, true);
    AppMethodBeat.o(368026);
    return this;
  }
  
  public final gc qQ(String paramString)
  {
    AppMethodBeat.i(368031);
    this.iIg = F("ExtInfo", paramString, true);
    AppMethodBeat.o(368031);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.gc
 * JD-Core Version:    0.7.0.1
 */