package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eh
  extends a
{
  private String eiB = "";
  private String esS = "";
  private String esT = "";
  private long esU;
  private long esV;
  private long evg;
  private long evh;
  private String evj = "";
  
  public final String abV()
  {
    AppMethodBeat.i(168925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(168925);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(168926);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardType:").append(this.evg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardResult:").append(this.evh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.esS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.esT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.esU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.esV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardToUsr:").append(this.evj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168926);
    return localObject;
  }
  
  public final int getId()
  {
    return 19187;
  }
  
  public final eh lP(long paramLong)
  {
    this.evg = paramLong;
    return this;
  }
  
  public final eh lQ(long paramLong)
  {
    this.evh = paramLong;
    return this;
  }
  
  public final eh lR(long paramLong)
  {
    this.esV = paramLong;
    return this;
  }
  
  public final eh qR(String paramString)
  {
    AppMethodBeat.i(168921);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(168921);
    return this;
  }
  
  public final eh qS(String paramString)
  {
    AppMethodBeat.i(168922);
    this.esS = x("Tag", paramString, true);
    AppMethodBeat.o(168922);
    return this;
  }
  
  public final eh qT(String paramString)
  {
    AppMethodBeat.i(168923);
    this.esT = x("TagId", paramString, true);
    AppMethodBeat.o(168923);
    return this;
  }
  
  public final eh qU(String paramString)
  {
    AppMethodBeat.i(168924);
    this.evj = x("ForwardToUsr", paramString, true);
    AppMethodBeat.o(168924);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eh
 * JD-Core Version:    0.7.0.1
 */