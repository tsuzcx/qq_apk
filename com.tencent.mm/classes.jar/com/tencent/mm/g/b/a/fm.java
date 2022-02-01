package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fm
  extends a
{
  private long eFT = 0L;
  private long eFU;
  private String eFV = "";
  private String eFW = "";
  private long eFX;
  private String eFc = "";
  private long eFd;
  private long eFz;
  private long ejW;
  private long elz;
  private long eyI;
  
  public final String abV()
  {
    AppMethodBeat.i(207445);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eFc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eFX);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(207445);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(207446);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eFc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eyI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.eFT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.eFz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionResult:").append(this.eFU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.elz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUserName:").append(this.eFV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("anchorusername:").append(this.eFW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audiencecount:").append(this.eFX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207446);
    return localObject;
  }
  
  public final int getId()
  {
    return 19893;
  }
  
  public final fm ob(long paramLong)
  {
    this.eyI = paramLong;
    return this;
  }
  
  public final fm oc(long paramLong)
  {
    this.eFz = paramLong;
    return this;
  }
  
  public final fm od(long paramLong)
  {
    this.eFd = paramLong;
    return this;
  }
  
  public final fm oe(long paramLong)
  {
    this.ejW = paramLong;
    return this;
  }
  
  public final fm of(long paramLong)
  {
    this.eFU = paramLong;
    return this;
  }
  
  public final fm og(long paramLong)
  {
    this.elz = paramLong;
    return this;
  }
  
  public final fm oh(long paramLong)
  {
    this.eFX = paramLong;
    return this;
  }
  
  public final fm sr(String paramString)
  {
    AppMethodBeat.i(207442);
    this.eFc = x("roomid", paramString, true);
    AppMethodBeat.o(207442);
    return this;
  }
  
  public final fm ss(String paramString)
  {
    AppMethodBeat.i(207443);
    this.eFV = x("audienceUserName", paramString, true);
    AppMethodBeat.o(207443);
    return this;
  }
  
  public final fm st(String paramString)
  {
    AppMethodBeat.i(207444);
    this.eFW = x("anchorusername", paramString, true);
    AppMethodBeat.o(207444);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fm
 * JD-Core Version:    0.7.0.1
 */