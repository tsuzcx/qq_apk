package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cx
  extends a
{
  private long eeT;
  private String eeX = "";
  private long eeY;
  private String eeZ = "";
  private long efa;
  private long efb;
  private long efc;
  private int efd;
  
  public final String RC()
  {
    AppMethodBeat.i(215517);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efd);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215517);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215518);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomId:").append(this.eeX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.eeY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micId:").append(this.eeZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.eeT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("groupRole:").append(this.efa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkStatus:").append(this.efb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceMode:").append(this.efc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errorCode:").append(this.efd);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215518);
    return localObject;
  }
  
  public final int getId()
  {
    return 19968;
  }
  
  public final cx iE(int paramInt)
  {
    this.efd = paramInt;
    return this;
  }
  
  public final cx iR(long paramLong)
  {
    this.eeY = paramLong;
    return this;
  }
  
  public final cx iS(long paramLong)
  {
    this.eeT = paramLong;
    return this;
  }
  
  public final cx iT(long paramLong)
  {
    this.efa = paramLong;
    return this;
  }
  
  public final cx iU(long paramLong)
  {
    this.efb = paramLong;
    return this;
  }
  
  public final cx iV(long paramLong)
  {
    this.efc = paramLong;
    return this;
  }
  
  public final cx mt(String paramString)
  {
    AppMethodBeat.i(215516);
    this.eeZ = t("micId", paramString, true);
    AppMethodBeat.o(215516);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cx
 * JD-Core Version:    0.7.0.1
 */