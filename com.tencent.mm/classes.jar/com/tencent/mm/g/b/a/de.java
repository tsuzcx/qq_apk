package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class de
  extends a
{
  private long enl;
  private String etN = "";
  private String etO = "";
  private int etP;
  private String etQ = "";
  private long etR;
  private long ews;
  private String eyL = "";
  
  public final String abV()
  {
    AppMethodBeat.i(220187);
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
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ews);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220187);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220188);
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
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionJson:").append(this.eyL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceScene:").append(this.ews);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220188);
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
  
  public final long adn()
  {
    return this.ews;
  }
  
  public final String aeO()
  {
    return this.eyL;
  }
  
  public final int getId()
  {
    return 21106;
  }
  
  public final de iY(long paramLong)
  {
    AppMethodBeat.i(220185);
    this.etR = paramLong;
    super.bi("ActionTimeMs", this.etR);
    AppMethodBeat.o(220185);
    return this;
  }
  
  public final de iZ(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final de ja(long paramLong)
  {
    this.ews = paramLong;
    return this;
  }
  
  public final de kI(int paramInt)
  {
    this.etP = paramInt;
    return this;
  }
  
  public final de or(String paramString)
  {
    AppMethodBeat.i(220182);
    this.etN = x("FinderUsrname", paramString, true);
    AppMethodBeat.o(220182);
    return this;
  }
  
  public final de os(String paramString)
  {
    AppMethodBeat.i(220183);
    this.etO = x("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(220183);
    return this;
  }
  
  public final de ot(String paramString)
  {
    AppMethodBeat.i(220184);
    this.etQ = x("FinderSessionId", paramString, true);
    AppMethodBeat.o(220184);
    return this;
  }
  
  public final de ou(String paramString)
  {
    AppMethodBeat.i(220186);
    this.eyL = x("ActionJson", paramString, true);
    AppMethodBeat.o(220186);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.de
 * JD-Core Version:    0.7.0.1
 */