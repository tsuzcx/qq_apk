package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fo
  extends a
{
  private String eFc = "";
  private long eFd;
  private String eFy = "";
  private long eFz;
  private long eGH;
  private long eGI;
  private String evz = "";
  private long eyI;
  
  public final String abV()
  {
    AppMethodBeat.i(207450);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGI);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207450);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207451);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.evz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.eFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.eFz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wholeTime:").append(this.eGH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("viewTime:").append(this.eGI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207451);
    return localObject;
  }
  
  public final int getId()
  {
    return 19898;
  }
  
  public final fo oO(long paramLong)
  {
    this.eyI = paramLong;
    return this;
  }
  
  public final fo oP(long paramLong)
  {
    this.eFz = paramLong;
    return this;
  }
  
  public final fo oQ(long paramLong)
  {
    this.eFd = paramLong;
    return this;
  }
  
  public final fo oR(long paramLong)
  {
    this.eGH = paramLong;
    return this;
  }
  
  public final fo oS(long paramLong)
  {
    this.eGI = paramLong;
    return this;
  }
  
  public final fo sA(String paramString)
  {
    AppMethodBeat.i(207449);
    this.eFy = x("liveusername", paramString, true);
    AppMethodBeat.o(207449);
    return this;
  }
  
  public final fo sy(String paramString)
  {
    AppMethodBeat.i(207447);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(207447);
    return this;
  }
  
  public final fo sz(String paramString)
  {
    AppMethodBeat.i(207448);
    this.evz = x("topic", paramString, true);
    AppMethodBeat.o(207448);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fo
 * JD-Core Version:    0.7.0.1
 */