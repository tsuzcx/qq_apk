package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class k
  extends a
{
  private int eki;
  private long ekj;
  private long ekk;
  private long ekl;
  private long ekm;
  private String ekn = "";
  private String eko = "";
  private long ekp;
  
  public final String abV()
  {
    AppMethodBeat.i(224144);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eko);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ekp);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(224144);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(224145);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.eki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqNum:").append(this.ekj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RespNum:").append(this.ekk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataStartTime:").append(this.ekl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataEndTime:").append(this.ekm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqContent:").append(this.ekn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RespContent:").append(this.eko);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DataNum:").append(this.ekp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(224145);
    return localObject;
  }
  
  public final k bM(long paramLong)
  {
    this.ekj = paramLong;
    return this;
  }
  
  public final k bN(long paramLong)
  {
    this.ekk = paramLong;
    return this;
  }
  
  public final k bO(long paramLong)
  {
    this.ekl = paramLong;
    return this;
  }
  
  public final k bP(long paramLong)
  {
    this.ekm = paramLong;
    return this;
  }
  
  public final k bQ(long paramLong)
  {
    this.ekp = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20808;
  }
  
  public final k hN(String paramString)
  {
    AppMethodBeat.i(224142);
    this.ekn = x("ReqContent", paramString, true);
    AppMethodBeat.o(224142);
    return this;
  }
  
  public final k hO(String paramString)
  {
    AppMethodBeat.i(224143);
    this.eko = x("RespContent", paramString, true);
    AppMethodBeat.o(224143);
    return this;
  }
  
  public final k jB(int paramInt)
  {
    this.eki = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.k
 * JD-Core Version:    0.7.0.1
 */