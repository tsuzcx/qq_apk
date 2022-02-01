package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fv
  extends a
{
  private long eIe;
  private long eIf;
  private long eIg;
  private String eoj = "";
  private long esJ;
  private String eui = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209250);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eui);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esJ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209250);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209251);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.eoj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.eui);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoDuration:").append(this.eIe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordingCnt:").append(this.eIf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DurationPosition:").append(this.eIg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.esJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209251);
    return localObject;
  }
  
  public final int getId()
  {
    return 21150;
  }
  
  public final fv pA(long paramLong)
  {
    this.eIf = paramLong;
    return this;
  }
  
  public final fv pB(long paramLong)
  {
    this.eIg = paramLong;
    return this;
  }
  
  public final fv pC(long paramLong)
  {
    this.esJ = paramLong;
    return this;
  }
  
  public final fv pz(long paramLong)
  {
    this.eIe = paramLong;
    return this;
  }
  
  public final fv sO(String paramString)
  {
    AppMethodBeat.i(209248);
    this.eoj = x("Feedid", paramString, true);
    AppMethodBeat.o(209248);
    return this;
  }
  
  public final fv sP(String paramString)
  {
    AppMethodBeat.i(209249);
    this.eui = x("LongVideoId", paramString, true);
    AppMethodBeat.o(209249);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fv
 * JD-Core Version:    0.7.0.1
 */