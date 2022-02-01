package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jx
  extends a
{
  private long eSQ;
  private long eSR;
  private long eSS;
  private long eST;
  private String eiB = "";
  
  public final String abV()
  {
    AppMethodBeat.i(199745);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eST);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(199745);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(199746);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullStartTimeStamp:").append(this.eSQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PullEndTimeStamp:").append(this.eSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSuccess:").append(this.eSS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FailedType:").append(this.eST);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(199746);
    return localObject;
  }
  
  public final int getId()
  {
    return 20205;
  }
  
  public final jx sZ(long paramLong)
  {
    this.eSQ = paramLong;
    return this;
  }
  
  public final jx ta(long paramLong)
  {
    this.eSR = paramLong;
    return this;
  }
  
  public final jx tb(long paramLong)
  {
    this.eSS = paramLong;
    return this;
  }
  
  public final jx tc(long paramLong)
  {
    this.eST = paramLong;
    return this;
  }
  
  public final jx xi(String paramString)
  {
    AppMethodBeat.i(199744);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(199744);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jx
 * JD-Core Version:    0.7.0.1
 */