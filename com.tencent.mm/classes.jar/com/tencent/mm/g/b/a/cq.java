package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cq
  extends a
{
  private long ejA;
  private String eoD = "";
  private String erH = "";
  private long erO;
  private long erR;
  private long exg;
  private long exh;
  private String exi = "";
  
  public final String abV()
  {
    AppMethodBeat.i(220141);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.exi);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220141);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220142);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PageType:").append(this.erR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTS:").append(this.erO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Clickid:").append(this.exg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.exh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextID:").append(this.eoD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.erH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session_Id:").append(this.exi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220142);
    return localObject;
  }
  
  public final String ack()
  {
    return this.erH;
  }
  
  public final long acs()
  {
    return this.erO;
  }
  
  public final long act()
  {
    return this.ejA;
  }
  
  public final long acw()
  {
    return this.erR;
  }
  
  public final long aec()
  {
    return this.exg;
  }
  
  public final String aed()
  {
    return this.eoD;
  }
  
  public final String aee()
  {
    return this.exi;
  }
  
  public final int getId()
  {
    return 21631;
  }
  
  public final cq hI(long paramLong)
  {
    this.erR = paramLong;
    return this;
  }
  
  public final cq hJ(long paramLong)
  {
    this.erO = paramLong;
    return this;
  }
  
  public final cq hK(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final cq nb(String paramString)
  {
    AppMethodBeat.i(220138);
    this.eoD = x("ContextID", paramString, true);
    AppMethodBeat.o(220138);
    return this;
  }
  
  public final cq nc(String paramString)
  {
    AppMethodBeat.i(220139);
    this.erH = x("ClickTabContextId", paramString, true);
    AppMethodBeat.o(220139);
    return this;
  }
  
  public final cq nd(String paramString)
  {
    AppMethodBeat.i(220140);
    this.exi = x("Session_Id", paramString, true);
    AppMethodBeat.o(220140);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cq
 * JD-Core Version:    0.7.0.1
 */