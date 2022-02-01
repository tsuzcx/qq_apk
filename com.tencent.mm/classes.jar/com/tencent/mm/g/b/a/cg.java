package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cg
  extends a
{
  private String dNK;
  private long dNL;
  private long dNN;
  private String dOh;
  private String dOi;
  private long dOu = 0L;
  private long dOv;
  private long dOw;
  private String dOx;
  
  public final String PR()
  {
    AppMethodBeat.i(190829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOx);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190829);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190830);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.dNL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micid:").append(this.dOu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.dOh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.dNN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("closeRole:").append(this.dOv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasVideo:").append(this.dOw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.dOi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("livemicid:").append(this.dOx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190830);
    return localObject;
  }
  
  public final int getId()
  {
    return 19895;
  }
  
  public final cg hj(long paramLong)
  {
    this.dNL = paramLong;
    return this;
  }
  
  public final cg hk(long paramLong)
  {
    this.dNN = paramLong;
    return this;
  }
  
  public final cg hl(long paramLong)
  {
    this.dOv = paramLong;
    return this;
  }
  
  public final cg hm(long paramLong)
  {
    this.dOw = paramLong;
    return this;
  }
  
  public final cg kh(String paramString)
  {
    AppMethodBeat.i(190826);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(190826);
    return this;
  }
  
  public final cg ki(String paramString)
  {
    AppMethodBeat.i(190827);
    this.dOi = t("liveusername", paramString, true);
    AppMethodBeat.o(190827);
    return this;
  }
  
  public final cg kj(String paramString)
  {
    AppMethodBeat.i(190828);
    this.dOx = t("livemicid", paramString, true);
    AppMethodBeat.o(190828);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cg
 * JD-Core Version:    0.7.0.1
 */