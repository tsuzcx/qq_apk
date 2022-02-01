package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ck
  extends a
{
  private long giq;
  private String gpU = "";
  private String gpV = "";
  private int gpW;
  private String gpX = "";
  private long gpY;
  
  public final String agH()
  {
    AppMethodBeat.i(254510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gpU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gpY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giq);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(254510);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(254512);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FinderUsrname:").append(this.gpU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderWxAppInfo:").append(this.gpV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsPrivate:").append(this.gpW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinderSessionId:").append(this.gpX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTimeMs:").append(this.gpY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(254512);
    return localObject;
  }
  
  public final String ahA()
  {
    return this.gpX;
  }
  
  public final long ahB()
  {
    return this.gpY;
  }
  
  public final long ahC()
  {
    return this.giq;
  }
  
  public final String ahx()
  {
    return this.gpU;
  }
  
  public final String ahy()
  {
    return this.gpV;
  }
  
  public final int ahz()
  {
    return this.gpW;
  }
  
  public final ck fv(long paramLong)
  {
    AppMethodBeat.i(254506);
    this.gpY = paramLong;
    super.bk("ActionTimeMs", this.gpY);
    AppMethodBeat.o(254506);
    return this;
  }
  
  public final ck fw(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21113;
  }
  
  public final ck lr(int paramInt)
  {
    this.gpW = paramInt;
    return this;
  }
  
  public final ck mu(String paramString)
  {
    AppMethodBeat.i(254496);
    this.gpU = z("FinderUsrname", paramString, true);
    AppMethodBeat.o(254496);
    return this;
  }
  
  public final ck mv(String paramString)
  {
    AppMethodBeat.i(254500);
    this.gpV = z("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(254500);
    return this;
  }
  
  public final ck mw(String paramString)
  {
    AppMethodBeat.i(254504);
    this.gpX = z("FinderSessionId", paramString, true);
    AppMethodBeat.o(254504);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ck
 * JD-Core Version:    0.7.0.1
 */