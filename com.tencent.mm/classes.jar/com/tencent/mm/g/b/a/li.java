package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class li
  extends a
{
  private long eYA;
  private long eYB;
  private long eYp = 0L;
  private String eYq = "";
  private long eYr = 0L;
  private String eYs = "";
  private String eYw = "";
  private String eYx = "";
  private String eYy = "";
  private String eYz = "";
  private long enl = 0L;
  private long eua = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(187810);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eua);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eYB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187810);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187811);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeStamp:").append(this.eua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultType:").append(this.eYp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResultQuery:").append(this.eYq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareScene:").append(this.eYr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSceneId:").append(this.eYs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSessionId:").append(this.eYw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSearchId:").append(this.eYx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareRequestId:").append(this.eYy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareDocId:").append(this.eYz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareBizType:").append(this.eYA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShareSubType:").append(this.eYB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187811);
    return localObject;
  }
  
  public final li aiA()
  {
    this.eYp = 2L;
    return this;
  }
  
  public final int getId()
  {
    return 20997;
  }
  
  public final li uM(long paramLong)
  {
    this.enl = paramLong;
    return this;
  }
  
  public final li uN(long paramLong)
  {
    this.eua = paramLong;
    return this;
  }
  
  public final li uO(long paramLong)
  {
    this.eYr = paramLong;
    return this;
  }
  
  public final li uP(long paramLong)
  {
    this.eYA = paramLong;
    return this;
  }
  
  public final li uQ(long paramLong)
  {
    this.eYB = paramLong;
    return this;
  }
  
  public final li yA(String paramString)
  {
    AppMethodBeat.i(187807);
    this.eYx = x("ShareSearchId", paramString, true);
    AppMethodBeat.o(187807);
    return this;
  }
  
  public final li yB(String paramString)
  {
    AppMethodBeat.i(187808);
    this.eYy = x("ShareRequestId", paramString, true);
    AppMethodBeat.o(187808);
    return this;
  }
  
  public final li yC(String paramString)
  {
    AppMethodBeat.i(187809);
    this.eYz = x("ShareDocId", paramString, true);
    AppMethodBeat.o(187809);
    return this;
  }
  
  public final li yx(String paramString)
  {
    AppMethodBeat.i(187804);
    this.eYq = x("ResultQuery", paramString, true);
    AppMethodBeat.o(187804);
    return this;
  }
  
  public final li yy(String paramString)
  {
    AppMethodBeat.i(187805);
    this.eYs = x("ShareSceneId", paramString, true);
    AppMethodBeat.o(187805);
    return this;
  }
  
  public final li yz(String paramString)
  {
    AppMethodBeat.i(187806);
    this.eYw = x("ShareSessionId", paramString, true);
    AppMethodBeat.o(187806);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.li
 * JD-Core Version:    0.7.0.1
 */