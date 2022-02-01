package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ok
  extends a
{
  private long eCU;
  private long eDm;
  private long eDo;
  private long erw;
  private String oll = "";
  private String olm = "";
  private String opY = "";
  private String oqg = "";
  private long oqh;
  
  public final ok Qr(long paramLong)
  {
    this.erw = paramLong;
    return this;
  }
  
  public final ok Qs(long paramLong)
  {
    this.eDm = paramLong;
    return this;
  }
  
  public final ok Qt(long paramLong)
  {
    this.eDo = paramLong;
    return this;
  }
  
  public final ok Qu(long paramLong)
  {
    this.eCU = paramLong;
    return this;
  }
  
  public final ok Qv(long paramLong)
  {
    this.oqh = paramLong;
    return this;
  }
  
  public final String abV()
  {
    AppMethodBeat.i(258830);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.erw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.opY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oll);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.olm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oqh);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(258830);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(258831);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.erw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextId:").append(this.opY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvObjectId:").append(this.oll);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mvNonceId:").append(this.olm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FirstFrameTime:").append(this.eDm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WaittingCount:").append(this.eDo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayTime:").append(this.eCU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoPlayInfo:").append(this.oqg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoErrCount:").append(this.oqh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(258831);
    return localObject;
  }
  
  public final ok bwt(String paramString)
  {
    AppMethodBeat.i(258826);
    this.opY = x("contextId", paramString, true);
    AppMethodBeat.o(258826);
    return this;
  }
  
  public final ok bwu(String paramString)
  {
    AppMethodBeat.i(258827);
    this.oll = x("mvObjectId", paramString, true);
    AppMethodBeat.o(258827);
    return this;
  }
  
  public final ok bwv(String paramString)
  {
    AppMethodBeat.i(258828);
    this.olm = x("mvNonceId", paramString, true);
    AppMethodBeat.o(258828);
    return this;
  }
  
  public final ok bww(String paramString)
  {
    AppMethodBeat.i(258829);
    this.oqg = x("VideoPlayInfo", paramString, true);
    AppMethodBeat.o(258829);
    return this;
  }
  
  public final int getId()
  {
    return 22222;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ok
 * JD-Core Version:    0.7.0.1
 */