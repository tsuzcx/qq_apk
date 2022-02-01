package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hi
  extends a
{
  private long gDZ;
  private String gFn = "";
  private long gFo;
  private String gFp = "";
  private long gFq;
  private long gFr;
  private long gFs;
  private long gFt;
  private String gFu = "";
  private long gmT;
  
  public final String agH()
  {
    AppMethodBeat.i(200218);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gFn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gDZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFu);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(200218);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(200223);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("moduleName:").append(this.gFn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventCode:").append(this.gFo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("eventMsg:").append(this.gFp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveId:").append(this.gDZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mode:").append(this.gFq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("anchorSEITimestamp:").append(this.gFr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceSEITimestamp:").append(this.gFs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sdkliveid:").append(this.gFt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("finderName:").append(this.gFu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(200223);
    return localObject;
  }
  
  public final long alF()
  {
    return this.gmT;
  }
  
  public final int getId()
  {
    return 21505;
  }
  
  public final hi rt(long paramLong)
  {
    this.gFo = paramLong;
    return this;
  }
  
  public final hi ru(long paramLong)
  {
    this.gDZ = paramLong;
    return this;
  }
  
  public final hi rv(long paramLong)
  {
    this.gmT = paramLong;
    return this;
  }
  
  public final hi rw(long paramLong)
  {
    this.gFq = paramLong;
    return this;
  }
  
  public final hi rx(long paramLong)
  {
    this.gFr = paramLong;
    return this;
  }
  
  public final hi ry(long paramLong)
  {
    this.gFs = paramLong;
    return this;
  }
  
  public final hi rz(long paramLong)
  {
    this.gFt = paramLong;
    return this;
  }
  
  public final hi wq(String paramString)
  {
    AppMethodBeat.i(200207);
    this.gFn = z("moduleName", paramString, true);
    AppMethodBeat.o(200207);
    return this;
  }
  
  public final hi wr(String paramString)
  {
    AppMethodBeat.i(200209);
    this.gFp = z("eventMsg", paramString, true);
    AppMethodBeat.o(200209);
    return this;
  }
  
  public final hi ws(String paramString)
  {
    AppMethodBeat.i(200215);
    this.gFu = z("finderName", paramString, true);
    AppMethodBeat.o(200215);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hi
 * JD-Core Version:    0.7.0.1
 */