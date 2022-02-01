package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hg
  extends a
{
  private String gDS = "";
  private long gDT;
  private String gDw = "";
  private long gDx;
  private long gDy;
  private long gFf;
  private long gFg;
  private String grG = "";
  
  public final String agH()
  {
    AppMethodBeat.i(194721);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFg);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(194721);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(194727);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.gDx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.grG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.gDS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.gDT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.gDy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wholeTime:").append(this.gFf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("viewTime:").append(this.gFg);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194727);
    return localObject;
  }
  
  public final int getId()
  {
    return 19898;
  }
  
  public final hg rb(long paramLong)
  {
    this.gDx = paramLong;
    return this;
  }
  
  public final hg rc(long paramLong)
  {
    this.gDT = paramLong;
    return this;
  }
  
  public final hg rd(long paramLong)
  {
    this.gDy = paramLong;
    return this;
  }
  
  public final hg re(long paramLong)
  {
    this.gFf = paramLong;
    return this;
  }
  
  public final hg rf(long paramLong)
  {
    this.gFg = paramLong;
    return this;
  }
  
  public final hg wl(String paramString)
  {
    AppMethodBeat.i(194698);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(194698);
    return this;
  }
  
  public final hg wm(String paramString)
  {
    AppMethodBeat.i(194706);
    this.grG = z("topic", paramString, true);
    AppMethodBeat.o(194706);
    return this;
  }
  
  public final hg wn(String paramString)
  {
    AppMethodBeat.i(194709);
    this.gDS = z("liveusername", paramString, true);
    AppMethodBeat.o(194709);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hg
 * JD-Core Version:    0.7.0.1
 */