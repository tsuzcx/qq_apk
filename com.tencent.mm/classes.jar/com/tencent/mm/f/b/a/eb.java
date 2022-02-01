package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eb
  extends a
{
  private long gqU;
  private String gvN = "";
  private String gvO = "";
  private long gvP;
  private long gvQ;
  private long gvR;
  private long gvT;
  private long gvU;
  
  public final String agH()
  {
    AppMethodBeat.i(223073);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gvN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvU);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(223073);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(223077);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PostId:").append(this.gvN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditId:").append(this.gvO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSource:").append(this.gvP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.gqU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PicCnt:").append(this.gvQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoLen:").append(this.gvR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaViewType:").append(this.gvT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("previewViewScene:").append(this.gvU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(223077);
    return localObject;
  }
  
  public final int getId()
  {
    return 21640;
  }
  
  public final eb kA(long paramLong)
  {
    this.gvQ = paramLong;
    return this;
  }
  
  public final eb kB(long paramLong)
  {
    this.gvR = paramLong;
    return this;
  }
  
  public final eb kC(long paramLong)
  {
    this.gvT = paramLong;
    return this;
  }
  
  public final eb kD(long paramLong)
  {
    this.gvU = paramLong;
    return this;
  }
  
  public final eb kz(long paramLong)
  {
    this.gvP = paramLong;
    return this;
  }
  
  public final eb rp(String paramString)
  {
    AppMethodBeat.i(223068);
    this.gvN = z("PostId", paramString, true);
    AppMethodBeat.o(223068);
    return this;
  }
  
  public final eb rq(String paramString)
  {
    AppMethodBeat.i(223070);
    this.gvO = z("EditId", paramString, true);
    AppMethodBeat.o(223070);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.eb
 * JD-Core Version:    0.7.0.1
 */