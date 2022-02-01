package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bt
  extends a
{
  private long enl;
  private String etN = "";
  private String etO = "";
  private int etP;
  private String etQ = "";
  private long etR;
  
  public final String abV()
  {
    AppMethodBeat.i(220099);
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
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(220099);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(220100);
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
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(220100);
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
  
  public final bt eF(long paramLong)
  {
    AppMethodBeat.i(220098);
    this.etR = paramLong;
    super.bi("ActionTimeMs", this.etR);
    AppMethodBeat.o(220098);
    return this;
  }
  
  public final bt eG(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21113;
  }
  
  public final bt jX(int paramInt)
  {
    this.etP = paramInt;
    return this;
  }
  
  public final bt ke(String paramString)
  {
    AppMethodBeat.i(220095);
    this.etN = x("FinderUsrname", paramString, true);
    AppMethodBeat.o(220095);
    return this;
  }
  
  public final bt kf(String paramString)
  {
    AppMethodBeat.i(220096);
    this.etO = x("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(220096);
    return this;
  }
  
  public final bt kg(String paramString)
  {
    AppMethodBeat.i(220097);
    this.etQ = x("FinderSessionId", paramString, true);
    AppMethodBeat.o(220097);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bt
 * JD-Core Version:    0.7.0.1
 */