package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hr
  extends a
{
  private String gGJ = "";
  private long gGK;
  private String gGM = "";
  private long gGN;
  private long gGO;
  private String ggA = "";
  private String ggB = "";
  private String gjk = "";
  private String gjw = "";
  private String gqo = "";
  
  public final String agH()
  {
    AppMethodBeat.i(207668);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gGM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gGK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjw);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(207668);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(207670);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickTimeStamp:").append(this.gGM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GenerateType:").append(this.gGN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GenerateScene:").append(this.gGO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MiniSessionId:").append(this.gGJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TaskOrder:").append(this.gGK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.gqo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Feedid:").append(this.gjw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207670);
    return localObject;
  }
  
  public final hr alM()
  {
    this.gGO = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21154;
  }
  
  public final hr rX(long paramLong)
  {
    this.gGN = paramLong;
    return this;
  }
  
  public final hr rY(long paramLong)
  {
    this.gGK = paramLong;
    return this;
  }
  
  public final hr wR(String paramString)
  {
    AppMethodBeat.i(207651);
    this.gGM = z("ClickTimeStamp", paramString, true);
    AppMethodBeat.o(207651);
    return this;
  }
  
  public final hr wS(String paramString)
  {
    AppMethodBeat.i(207653);
    this.gGJ = z("MiniSessionId", paramString, true);
    AppMethodBeat.o(207653);
    return this;
  }
  
  public final hr wT(String paramString)
  {
    AppMethodBeat.i(207654);
    this.gqo = z("LongVideoId", paramString, true);
    AppMethodBeat.o(207654);
    return this;
  }
  
  public final hr wU(String paramString)
  {
    AppMethodBeat.i(207655);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(207655);
    return this;
  }
  
  public final hr wV(String paramString)
  {
    AppMethodBeat.i(207657);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(207657);
    return this;
  }
  
  public final hr wW(String paramString)
  {
    AppMethodBeat.i(207660);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(207660);
    return this;
  }
  
  public final hr wX(String paramString)
  {
    AppMethodBeat.i(207662);
    this.gjw = z("Feedid", paramString, true);
    AppMethodBeat.o(207662);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hr
 * JD-Core Version:    0.7.0.1
 */