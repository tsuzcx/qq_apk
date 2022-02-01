package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class du
  extends a
{
  private long giq;
  private String gpU = "";
  private String gpV = "";
  private int gpW;
  private String gpX = "";
  private long gpY;
  private String gsx = "";
  private long gsz;
  private long guS;
  private String guy = "";
  
  public final String agH()
  {
    AppMethodBeat.i(252279);
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
    ((StringBuffer)localObject).append(this.gsx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guS);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(252279);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(252280);
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
    ((StringBuffer)localObject).append("Description:").append(this.gsx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Advancetype:").append(this.guS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(252280);
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
  
  public final du ajW()
  {
    this.guS = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21106;
  }
  
  public final du jS(long paramLong)
  {
    AppMethodBeat.i(252273);
    this.gpY = paramLong;
    super.bk("ActionTimeMs", this.gpY);
    AppMethodBeat.o(252273);
    return this;
  }
  
  public final du jT(long paramLong)
  {
    this.giq = paramLong;
    return this;
  }
  
  public final du jU(long paramLong)
  {
    this.gsz = paramLong;
    return this;
  }
  
  public final du lL(int paramInt)
  {
    this.gpW = paramInt;
    return this;
  }
  
  public final du qO(String paramString)
  {
    AppMethodBeat.i(252267);
    this.gpU = z("FinderUsrname", paramString, true);
    AppMethodBeat.o(252267);
    return this;
  }
  
  public final du qP(String paramString)
  {
    AppMethodBeat.i(252270);
    this.gpV = z("FinderWxAppInfo", paramString, true);
    AppMethodBeat.o(252270);
    return this;
  }
  
  public final du qQ(String paramString)
  {
    AppMethodBeat.i(252272);
    this.gpX = z("FinderSessionId", paramString, true);
    AppMethodBeat.o(252272);
    return this;
  }
  
  public final du qR(String paramString)
  {
    AppMethodBeat.i(252274);
    this.guy = z("ActionJson", paramString, true);
    AppMethodBeat.o(252274);
    return this;
  }
  
  public final du qS(String paramString)
  {
    AppMethodBeat.i(252277);
    this.gsx = z("Description", paramString, true);
    AppMethodBeat.o(252277);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.du
 * JD-Core Version:    0.7.0.1
 */