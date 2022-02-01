package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ff
  extends a
{
  private String gcU = "";
  private String goZ = "";
  private String gpa = "";
  private long gpb;
  private long gpc;
  private long grk;
  private long grl;
  private String grn = "";
  
  public final String agH()
  {
    AppMethodBeat.i(168925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grn);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(168925);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(168926);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardType:").append(this.grk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardResult:").append(this.grl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Tag:").append(this.goZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagId:").append(this.gpa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPoi:").append(this.gpb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TagFeedCnt:").append(this.gpc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardToUsr:").append(this.grn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(168926);
    return localObject;
  }
  
  public final int getId()
  {
    return 19187;
  }
  
  public final ff nc(long paramLong)
  {
    this.grk = paramLong;
    return this;
  }
  
  public final ff nd(long paramLong)
  {
    this.grl = paramLong;
    return this;
  }
  
  public final ff ne(long paramLong)
  {
    this.gpc = paramLong;
    return this;
  }
  
  public final ff tV(String paramString)
  {
    AppMethodBeat.i(168921);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(168921);
    return this;
  }
  
  public final ff tW(String paramString)
  {
    AppMethodBeat.i(168922);
    this.goZ = z("Tag", paramString, true);
    AppMethodBeat.o(168922);
    return this;
  }
  
  public final ff tX(String paramString)
  {
    AppMethodBeat.i(168923);
    this.gpa = z("TagId", paramString, true);
    AppMethodBeat.o(168923);
    return this;
  }
  
  public final ff tY(String paramString)
  {
    AppMethodBeat.i(168924);
    this.grn = z("ForwardToUsr", paramString, true);
    AppMethodBeat.o(168924);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ff
 * JD-Core Version:    0.7.0.1
 */