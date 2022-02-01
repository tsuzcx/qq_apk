package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cr
  extends a
{
  private String elt = "";
  private long enl;
  private String erH = "";
  private long erN;
  private String erS = "";
  private String erT = "";
  private String etQ = "";
  private long etR;
  private String exj = "";
  private String exk = "";
  private String exl = "";
  
  public final String abV()
  {
    AppMethodBeat.i(220152);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.exj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erT);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220152);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220153);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FinderUsrName:").append(this.exj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.etQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.etR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterLiveId:").append(this.exk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterStatus:").append(this.erN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.exl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.elt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AdData:").append(this.erS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scenenote:").append(this.erT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220153);
    return localObject;
  }
  
  public final String acJ()
  {
    return this.etQ;
  }
  
  public final long acK()
  {
    return this.etR;
  }
  
  public final long acL()
  {
    return this.enl;
  }
  
  public final String ack()
  {
    return this.erH;
  }
  
  public final long acr()
  {
    return this.erN;
  }
  
  public final String acx()
  {
    return this.erS;
  }
  
  public final String acy()
  {
    return this.erT;
  }
  
  public final String aef()
  {
    return this.exj;
  }
  
  public final String aeg()
  {
    return this.exk;
  }
  
  public final cr aeh()
  {
    this.erN = 0L;
    return this;
  }
  
  public final String aei()
  {
    return this.exl;
  }
  
  public final String aej()
  {
    return this.elt;
  }
  
  public final int getId()
  {
    return 21158;
  }
  
  public final cr hL(long paramLong)
  {
    AppMethodBeat.i(220145);
    this.etR = paramLong;
    super.bi("ActionTimeMs", this.etR);
    AppMethodBeat.o(220145);
    return this;
  }
  
  public final cr hM(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final cr ne(String paramString)
  {
    AppMethodBeat.i(220143);
    this.exj = x("FinderUsrName", paramString, true);
    AppMethodBeat.o(220143);
    return this;
  }
  
  public final cr nf(String paramString)
  {
    AppMethodBeat.i(220144);
    this.etQ = x("FinderSessionId", paramString, true);
    AppMethodBeat.o(220144);
    return this;
  }
  
  public final cr ng(String paramString)
  {
    AppMethodBeat.i(220146);
    this.exk = x("EnterLiveId", paramString, true);
    AppMethodBeat.o(220146);
    return this;
  }
  
  public final cr nh(String paramString)
  {
    AppMethodBeat.i(220147);
    this.exl = x("commentscene", paramString, true);
    AppMethodBeat.o(220147);
    return this;
  }
  
  public final cr ni(String paramString)
  {
    AppMethodBeat.i(220148);
    this.elt = x("contextid", paramString, true);
    AppMethodBeat.o(220148);
    return this;
  }
  
  public final cr nj(String paramString)
  {
    AppMethodBeat.i(220149);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(220149);
    return this;
  }
  
  public final cr nk(String paramString)
  {
    AppMethodBeat.i(220150);
    this.erS = x("AdData", paramString, true);
    AppMethodBeat.o(220150);
    return this;
  }
  
  public final cr nl(String paramString)
  {
    AppMethodBeat.i(220151);
    this.erT = x("Scenenote", paramString, true);
    AppMethodBeat.o(220151);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cr
 * JD-Core Version:    0.7.0.1
 */