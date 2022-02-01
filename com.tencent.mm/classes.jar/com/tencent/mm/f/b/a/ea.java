package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ea
  extends a
{
  private long gqU;
  private String gvN = "";
  private String gvO = "";
  private long gvP;
  private long gvQ;
  private long gvR;
  private long gvS;
  
  public final String agH()
  {
    AppMethodBeat.i(208781);
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
    ((StringBuffer)localObject).append(this.gvS);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(208781);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(208783);
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
    ((StringBuffer)localObject).append("DeleteFlag:").append(this.gvS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208783);
    return localObject;
  }
  
  public final int getId()
  {
    return 21638;
  }
  
  public final ea kv(long paramLong)
  {
    this.gvP = paramLong;
    return this;
  }
  
  public final ea kw(long paramLong)
  {
    this.gqU = paramLong;
    return this;
  }
  
  public final ea kx(long paramLong)
  {
    this.gvQ = paramLong;
    return this;
  }
  
  public final ea ky(long paramLong)
  {
    this.gvR = paramLong;
    return this;
  }
  
  public final ea rn(String paramString)
  {
    AppMethodBeat.i(208778);
    this.gvN = z("PostId", paramString, true);
    AppMethodBeat.o(208778);
    return this;
  }
  
  public final ea ro(String paramString)
  {
    AppMethodBeat.i(208779);
    this.gvO = z("EditId", paramString, true);
    AppMethodBeat.o(208779);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ea
 * JD-Core Version:    0.7.0.1
 */