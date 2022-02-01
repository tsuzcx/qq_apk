package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dr
  extends a
{
  private String eBg = "";
  private String eBh = "";
  private long eBi;
  private String eiB = "";
  private String eoz = "";
  private String erH = "";
  private String err = "";
  private long ery;
  
  public final String abV()
  {
    AppMethodBeat.i(209165);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.err);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ery);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eBi);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209165);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209166);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddUsername:").append(this.eBg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DeleteUsername:").append(this.eBh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FeedId:").append(this.err);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.ery);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("refuseLastCount:").append(this.eBi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209166);
    return localObject;
  }
  
  public final int getId()
  {
    return 19957;
  }
  
  public final dr ku(long paramLong)
  {
    this.ery = paramLong;
    return this;
  }
  
  public final dr kv(long paramLong)
  {
    this.eBi = paramLong;
    return this;
  }
  
  public final dr pA(String paramString)
  {
    AppMethodBeat.i(209159);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(209159);
    return this;
  }
  
  public final dr pB(String paramString)
  {
    AppMethodBeat.i(209160);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(209160);
    return this;
  }
  
  public final dr pC(String paramString)
  {
    AppMethodBeat.i(209161);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209161);
    return this;
  }
  
  public final dr pD(String paramString)
  {
    AppMethodBeat.i(209162);
    this.eBg = x("AddUsername", paramString, true);
    AppMethodBeat.o(209162);
    return this;
  }
  
  public final dr pE(String paramString)
  {
    AppMethodBeat.i(209163);
    this.eBh = x("DeleteUsername", paramString, true);
    AppMethodBeat.o(209163);
    return this;
  }
  
  public final dr pF(String paramString)
  {
    AppMethodBeat.i(209164);
    this.err = x("FeedId", paramString, true);
    AppMethodBeat.o(209164);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dr
 * JD-Core Version:    0.7.0.1
 */