package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cn
  extends a
{
  private long enl;
  private long erK;
  private String erP = "";
  private String err = "";
  private String etN = "";
  private String etO = "";
  private int etP;
  private String etQ = "";
  private long etR;
  private long evx;
  private String ewp = "";
  private String ewq = "";
  private long ewr;
  private long ews;
  
  public final String abV()
  {
    AppMethodBeat.i(220109);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.etN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.etR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ews);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220109);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220110);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FinderUsrname:").append(this.etN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderWxAppInfo:").append(this.etO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPrivate:").append(this.etP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.etQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.etR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveId:").append(this.ewp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Description:").append(this.ewq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveTime:").append(this.erK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LikeCount:").append(this.evx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnlineCount:").append(this.ewr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.erP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceScene:").append(this.ews);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220110);
    return localObject;
  }
  
  public final String acG()
  {
    return this.etN;
  }
  
  public final String acH()
  {
    return this.etO;
  }
  
  public final int acI()
  {
    return this.etP;
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
  
  public final long aco()
  {
    return this.erK;
  }
  
  public final String acu()
  {
    return this.erP;
  }
  
  public final String adj()
  {
    return this.ewp;
  }
  
  public final String adk()
  {
    return this.err;
  }
  
  public final long adl()
  {
    return this.evx;
  }
  
  public final long adm()
  {
    return this.ewr;
  }
  
  public final long adn()
  {
    return this.ews;
  }
  
  public final cn gJ(long paramLong)
  {
    AppMethodBeat.i(220104);
    this.etR = paramLong;
    super.bi("ActionTimeMs", this.etR);
    AppMethodBeat.o(220104);
    return this;
  }
  
  public final cn gK(long paramLong)
  {
    this.erK = paramLong;
    return this;
  }
  
  public final cn gL(long paramLong)
  {
    this.evx = paramLong;
    return this;
  }
  
  public final cn gM(long paramLong)
  {
    this.ewr = paramLong;
    return this;
  }
  
  public final cn gN(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final cn gO(long paramLong)
  {
    this.ews = paramLong;
    return this;
  }
  
  public final String getDescription()
  {
    return this.ewq;
  }
  
  public final int getId()
  {
    return 21054;
  }
  
  public final cn ke(int paramInt)
  {
    this.etP = paramInt;
    return this;
  }
  
  public final cn mA(String paramString)
  {
    AppMethodBeat.i(220105);
    this.ewp = x("LiveId", paramString, true);
    AppMethodBeat.o(220105);
    return this;
  }
  
  public final cn mB(String paramString)
  {
    AppMethodBeat.i(220106);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(220106);
    return this;
  }
  
  public final cn mC(String paramString)
  {
    AppMethodBeat.i(220107);
    this.ewq = x("Description", paramString, true);
    AppMethodBeat.o(220107);
    return this;
  }
  
  public final cn mD(String paramString)
  {
    AppMethodBeat.i(220108);
    this.erP = x("ActionResult", paramString, true);
    AppMethodBeat.o(220108);
    return this;
  }
  
  public final cn mx(String paramString)
  {
    AppMethodBeat.i(220101);
    this.etN = x("FinderUsrname", paramString, true);
    AppMethodBeat.o(220101);
    return this;
  }
  
  public final cn my(String paramString)
  {
    AppMethodBeat.i(220102);
    this.etO = x("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(220102);
    return this;
  }
  
  public final cn mz(String paramString)
  {
    AppMethodBeat.i(220103);
    this.etQ = x("FinderSessionId", paramString, true);
    AppMethodBeat.o(220103);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cn
 * JD-Core Version:    0.7.0.1
 */