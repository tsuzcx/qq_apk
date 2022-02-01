package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ho
  extends a
{
  private long gGF;
  private long gGG;
  private long gGH;
  private String ggA = "";
  private String ggB = "";
  private String gjk = "";
  private String gjw = "";
  private long goP;
  private String gqo = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209679);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGH);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209679);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209681);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.gjw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.gqo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.goP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongvideoLen:").append(this.gGF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveGuide:").append(this.gGG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayLen:").append(this.gGH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209681);
    return localObject;
  }
  
  public final ho alK()
  {
    this.goP = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21152;
  }
  
  public final ho rP(long paramLong)
  {
    this.gGF = paramLong;
    return this;
  }
  
  public final ho rQ(long paramLong)
  {
    this.gGG = paramLong;
    return this;
  }
  
  public final ho rR(long paramLong)
  {
    this.gGH = paramLong;
    return this;
  }
  
  public final ho wC(String paramString)
  {
    AppMethodBeat.i(209667);
    this.gjw = z("Feedid", paramString, true);
    AppMethodBeat.o(209667);
    return this;
  }
  
  public final ho wD(String paramString)
  {
    AppMethodBeat.i(209669);
    this.gqo = z("LongVideoId", paramString, true);
    AppMethodBeat.o(209669);
    return this;
  }
  
  public final ho wE(String paramString)
  {
    AppMethodBeat.i(209671);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(209671);
    return this;
  }
  
  public final ho wF(String paramString)
  {
    AppMethodBeat.i(209673);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(209673);
    return this;
  }
  
  public final ho wG(String paramString)
  {
    AppMethodBeat.i(209675);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209675);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ho
 * JD-Core Version:    0.7.0.1
 */