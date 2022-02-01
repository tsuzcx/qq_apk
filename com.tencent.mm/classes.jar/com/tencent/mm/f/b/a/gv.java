package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gv
  extends a
{
  private long gDA;
  private long gDB;
  private long gDC;
  private long gDD;
  private long gDE;
  private long gDF;
  private long gDG;
  private String gDw = "";
  private long gDx;
  private long gDy;
  private long gDz;
  private long gea = 0L;
  private long gmT;
  private String grG = "";
  
  public final String agH()
  {
    AppMethodBeat.i(201389);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gea);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDG);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(201389);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(201403);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.gDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.gDx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.grG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.gDy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.gea);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.gDz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCountMax:").append(this.gDA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.gDB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.gDC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.gDD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowReplay:").append(this.gDE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.gDF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.gDG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(201403);
    return localObject;
  }
  
  public final gv ala()
  {
    this.gmT = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19891;
  }
  
  public final gv pA(long paramLong)
  {
    this.gDG = paramLong;
    return this;
  }
  
  public final gv pr(long paramLong)
  {
    this.gDx = paramLong;
    return this;
  }
  
  public final gv ps(long paramLong)
  {
    this.gDy = paramLong;
    return this;
  }
  
  public final gv pt(long paramLong)
  {
    this.gDz = paramLong;
    return this;
  }
  
  public final gv pu(long paramLong)
  {
    this.gDA = paramLong;
    return this;
  }
  
  public final gv pv(long paramLong)
  {
    this.gDB = paramLong;
    return this;
  }
  
  public final gv pw(long paramLong)
  {
    this.gDC = paramLong;
    return this;
  }
  
  public final gv px(long paramLong)
  {
    this.gDD = paramLong;
    return this;
  }
  
  public final gv py(long paramLong)
  {
    this.gDE = paramLong;
    return this;
  }
  
  public final gv pz(long paramLong)
  {
    this.gDF = paramLong;
    return this;
  }
  
  public final gv vM(String paramString)
  {
    AppMethodBeat.i(201369);
    this.gDw = z("roomid", paramString, true);
    AppMethodBeat.o(201369);
    return this;
  }
  
  public final gv vN(String paramString)
  {
    AppMethodBeat.i(201371);
    this.grG = z("topic", paramString, true);
    AppMethodBeat.o(201371);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gv
 * JD-Core Version:    0.7.0.1
 */