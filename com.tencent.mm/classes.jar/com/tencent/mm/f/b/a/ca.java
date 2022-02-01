package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ca
  extends a
{
  private String gcU = "";
  private String gmO = "";
  private long gmT;
  private String goI = "";
  private String goJ = "";
  private String goK = "";
  private long goL;
  private long goM;
  private long goN;
  
  public final String agH()
  {
    AppMethodBeat.i(209185);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goN);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209185);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209186);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FeedId:").append(this.gmO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PosterUsername:").append(this.goI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ViewerUsername:").append(this.goJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MentionedUsername:").append(this.goK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("recommendtype:").append(this.goL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("likecnt:").append(this.goM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commcnt:").append(this.goN);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209186);
    return localObject;
  }
  
  public final ca eA(long paramLong)
  {
    this.goL = paramLong;
    return this;
  }
  
  public final ca eB(long paramLong)
  {
    this.goM = paramLong;
    return this;
  }
  
  public final ca eC(long paramLong)
  {
    this.goN = paramLong;
    return this;
  }
  
  public final ca ez(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19793;
  }
  
  public final ca lA(String paramString)
  {
    AppMethodBeat.i(209180);
    this.goI = z("PosterUsername", paramString, true);
    AppMethodBeat.o(209180);
    return this;
  }
  
  public final ca lB(String paramString)
  {
    AppMethodBeat.i(209181);
    this.goJ = z("ViewerUsername", paramString, true);
    AppMethodBeat.o(209181);
    return this;
  }
  
  public final ca lC(String paramString)
  {
    AppMethodBeat.i(209183);
    this.goK = z("MentionedUsername", paramString, true);
    AppMethodBeat.o(209183);
    return this;
  }
  
  public final ca ly(String paramString)
  {
    AppMethodBeat.i(209177);
    this.gmO = z("FeedId", paramString, true);
    AppMethodBeat.o(209177);
    return this;
  }
  
  public final ca lz(String paramString)
  {
    AppMethodBeat.i(209178);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209178);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ca
 * JD-Core Version:    0.7.0.1
 */