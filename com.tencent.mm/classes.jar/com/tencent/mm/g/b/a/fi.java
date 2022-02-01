package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fi
  extends a
{
  private long eFA;
  private long eFB;
  private String eFc = "";
  private long eFd;
  private String eFy = "";
  private long eFz;
  private long erw;
  private String evz = "";
  private long eyI;
  
  public final String abV()
  {
    AppMethodBeat.i(207429);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFB);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207429);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207430);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.evz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.eFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.eFz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusEnd:").append(this.eFA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusBegin:").append(this.eFB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207430);
    return localObject;
  }
  
  public final int getId()
  {
    return 19897;
  }
  
  public final fi nG(long paramLong)
  {
    this.eyI = paramLong;
    return this;
  }
  
  public final fi nH(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final fi nI(long paramLong)
  {
    this.eFz = paramLong;
    return this;
  }
  
  public final fi nJ(long paramLong)
  {
    this.eFd = paramLong;
    return this;
  }
  
  public final fi nK(long paramLong)
  {
    this.eFA = paramLong;
    return this;
  }
  
  public final fi nL(long paramLong)
  {
    this.eFB = paramLong;
    return this;
  }
  
  public final fi sj(String paramString)
  {
    AppMethodBeat.i(207426);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(207426);
    return this;
  }
  
  public final fi sk(String paramString)
  {
    AppMethodBeat.i(207427);
    this.evz = x("topic", paramString, true);
    AppMethodBeat.o(207427);
    return this;
  }
  
  public final fi sl(String paramString)
  {
    AppMethodBeat.i(207428);
    this.eFy = x("liveusername", paramString, true);
    AppMethodBeat.o(207428);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fi
 * JD-Core Version:    0.7.0.1
 */