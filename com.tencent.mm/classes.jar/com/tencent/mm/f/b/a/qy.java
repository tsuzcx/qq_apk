package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class qy
  extends a
{
  private String hkG = "";
  private String hlR = "";
  private String hlS = "";
  private int hlT = -1;
  private long hlU = 0L;
  private String hlV = "";
  
  public final qy Et(long paramLong)
  {
    this.hlU = paramLong;
    return this;
  }
  
  public final qy HN(String paramString)
  {
    AppMethodBeat.i(252390);
    this.hlR = z("ViewId", paramString, true);
    AppMethodBeat.o(252390);
    return this;
  }
  
  public final qy HO(String paramString)
  {
    AppMethodBeat.i(252391);
    this.hkG = z("PageId", paramString, true);
    AppMethodBeat.o(252391);
    return this;
  }
  
  public final qy HP(String paramString)
  {
    AppMethodBeat.i(252392);
    this.hlS = z("LayoutId", paramString, true);
    AppMethodBeat.o(252392);
    return this;
  }
  
  public final qy HQ(String paramString)
  {
    AppMethodBeat.i(252395);
    this.hlV = z("resName", paramString, true);
    AppMethodBeat.o(252395);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(184287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hlR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hkG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hlV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(184287);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(184288);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ViewId:").append(this.hlR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageId:").append(this.hkG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LayoutId:").append(this.hlS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OpEvent:").append(this.hlT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("timeConsuming:").append(this.hlU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resName:").append(this.hlV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184288);
    return localObject;
  }
  
  public final int getId()
  {
    return 19316;
  }
  
  public final qy pl(int paramInt)
  {
    this.hlT = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.qy
 * JD-Core Version:    0.7.0.1
 */