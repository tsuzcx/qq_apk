package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dp
  extends a
{
  private long ghs;
  private long giq;
  private String gpU = "";
  private String gpV = "";
  private int gpW;
  private String gpX = "";
  private long gpY;
  private long gsz;
  private String gtc = "";
  private String guy = "";
  
  public final String agH()
  {
    AppMethodBeat.i(257629);
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
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ghs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gtc);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(257629);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(257632);
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
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionJson:").append(this.guy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceScene:").append(this.gsz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConnectCount:").append(this.ghs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConnectDuration:").append(this.gtc);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(257632);
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
  
  public final long aic()
  {
    return this.gsz;
  }
  
  public final String ajI()
  {
    return this.guy;
  }
  
  public final int getId()
  {
    return 21017;
  }
  
  public final dp ju(long paramLong)
  {
    AppMethodBeat.i(257619);
    this.gpY = paramLong;
    super.bk("ActionTimeMs", this.gpY);
    AppMethodBeat.o(257619);
    return this;
  }
  
  public final dp jv(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final dp jw(long paramLong)
  {
    this.gsz = paramLong;
    return this;
  }
  
  public final dp lK(int paramInt)
  {
    this.gpW = paramInt;
    return this;
  }
  
  public final dp qG(String paramString)
  {
    AppMethodBeat.i(257609);
    this.gpU = z("FinderUsrname", paramString, true);
    AppMethodBeat.o(257609);
    return this;
  }
  
  public final dp qH(String paramString)
  {
    AppMethodBeat.i(257612);
    this.gpV = z("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(257612);
    return this;
  }
  
  public final dp qI(String paramString)
  {
    AppMethodBeat.i(257617);
    this.gpX = z("FinderSessionId", paramString, true);
    AppMethodBeat.o(257617);
    return this;
  }
  
  public final dp qJ(String paramString)
  {
    AppMethodBeat.i(257623);
    this.guy = z("ActionJson", paramString, true);
    AppMethodBeat.o(257623);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.dp
 * JD-Core Version:    0.7.0.1
 */