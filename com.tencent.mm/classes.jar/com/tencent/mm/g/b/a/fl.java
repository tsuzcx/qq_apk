package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fl
  extends a
{
  private long eFL = 0L;
  private long eFM;
  private long eFN;
  private String eFO = "";
  private long eFP;
  private long eFQ;
  private long eFR;
  private long eFS;
  private String eFc = "";
  private long eFe;
  private String eFx = "";
  private String eFy = "";
  private long eyI;
  
  public final String abV()
  {
    AppMethodBeat.i(207440);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFS);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207440);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207441);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micid:").append(this.eFL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.eFx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.eFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("closeRole:").append(this.eFM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasVideo:").append(this.eFN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.eFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("livemicid:").append(this.eFO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartTimeStamp:").append(this.eFP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndTimeStamp:").append(this.eFQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StartAudienceUV:").append(this.eFR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EndAudienceUV:").append(this.eFS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207441);
    return localObject;
  }
  
  public final int getId()
  {
    return 19895;
  }
  
  public final fl nT(long paramLong)
  {
    this.eyI = paramLong;
    return this;
  }
  
  public final fl nU(long paramLong)
  {
    this.eFe = paramLong;
    return this;
  }
  
  public final fl nV(long paramLong)
  {
    this.eFM = paramLong;
    return this;
  }
  
  public final fl nW(long paramLong)
  {
    this.eFN = paramLong;
    return this;
  }
  
  public final fl nX(long paramLong)
  {
    this.eFP = paramLong;
    return this;
  }
  
  public final fl nY(long paramLong)
  {
    this.eFQ = paramLong;
    return this;
  }
  
  public final fl nZ(long paramLong)
  {
    this.eFR = paramLong;
    return this;
  }
  
  public final fl oa(long paramLong)
  {
    this.eFS = paramLong;
    return this;
  }
  
  public final fl so(String paramString)
  {
    AppMethodBeat.i(207437);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(207437);
    return this;
  }
  
  public final fl sp(String paramString)
  {
    AppMethodBeat.i(207438);
    this.eFy = x("liveusername", paramString, true);
    AppMethodBeat.o(207438);
    return this;
  }
  
  public final fl sq(String paramString)
  {
    AppMethodBeat.i(207439);
    this.eFO = x("livemicid", paramString, true);
    AppMethodBeat.o(207439);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fl
 * JD-Core Version:    0.7.0.1
 */