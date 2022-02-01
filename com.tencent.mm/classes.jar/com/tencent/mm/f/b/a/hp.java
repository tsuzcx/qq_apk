package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hp
  extends a
{
  private String ggA = "";
  private String ggB = "";
  private long giq;
  private String gjk = "";
  private String gjw = "";
  private long goQ;
  private String gqo = "";
  
  public final String agH()
  {
    AppMethodBeat.i(207759);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(207759);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(207760);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Feedid:").append(this.gjw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LongVideoId:").append(this.gqo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.goQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207760);
    return localObject;
  }
  
  public final int getId()
  {
    return 21151;
  }
  
  public final hp rS(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final hp rT(long paramLong)
  {
    this.goQ = paramLong;
    return this;
  }
  
  public final hp wH(String paramString)
  {
    AppMethodBeat.i(207751);
    this.gjw = z("Feedid", paramString, true);
    AppMethodBeat.o(207751);
    return this;
  }
  
  public final hp wI(String paramString)
  {
    AppMethodBeat.i(207753);
    this.gqo = z("LongVideoId", paramString, true);
    AppMethodBeat.o(207753);
    return this;
  }
  
  public final hp wJ(String paramString)
  {
    AppMethodBeat.i(207755);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(207755);
    return this;
  }
  
  public final hp wK(String paramString)
  {
    AppMethodBeat.i(207756);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(207756);
    return this;
  }
  
  public final hp wL(String paramString)
  {
    AppMethodBeat.i(207758);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(207758);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hp
 * JD-Core Version:    0.7.0.1
 */