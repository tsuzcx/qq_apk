package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ab
  extends a
{
  private long geB;
  private String ggA = "";
  private String ggB = "";
  private String ggC = "";
  private long ggD;
  private long ggE;
  private String ggF = "";
  private long ggG;
  private long ggH;
  private long ggI;
  private String ggJ = "";
  private String ggK = "";
  private String ggL = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209984);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggL);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209984);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209985);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.ggB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextid:").append(this.ggC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nearby_uin:").append(this.ggD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("distance:").append(this.ggE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("district:").append(this.ggF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("if_sns:").append(this.ggG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.ggH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("filterType:").append(this.ggI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("nearby_username:").append(this.ggJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("city:").append(this.ggK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("country:").append(this.ggL);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209985);
    return localObject;
  }
  
  public final ab agN()
  {
    this.ggD = 0L;
    return this;
  }
  
  public final ab cl(long paramLong)
  {
    this.ggE = paramLong;
    return this;
  }
  
  public final ab cm(long paramLong)
  {
    this.ggG = paramLong;
    return this;
  }
  
  public final ab cn(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final ab co(long paramLong)
  {
    this.ggH = paramLong;
    return this;
  }
  
  public final ab cp(long paramLong)
  {
    this.ggI = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21855;
  }
  
  public final ab iO(String paramString)
  {
    AppMethodBeat.i(209972);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(209972);
    return this;
  }
  
  public final ab iP(String paramString)
  {
    AppMethodBeat.i(209973);
    this.ggB = z("contextid", paramString, true);
    AppMethodBeat.o(209973);
    return this;
  }
  
  public final ab iQ(String paramString)
  {
    AppMethodBeat.i(209975);
    this.ggC = z("clickTabContextid", paramString, true);
    AppMethodBeat.o(209975);
    return this;
  }
  
  public final ab iR(String paramString)
  {
    AppMethodBeat.i(209977);
    this.ggF = z("district", paramString, true);
    AppMethodBeat.o(209977);
    return this;
  }
  
  public final ab iS(String paramString)
  {
    AppMethodBeat.i(209980);
    this.ggJ = z("nearby_username", paramString, true);
    AppMethodBeat.o(209980);
    return this;
  }
  
  public final ab iT(String paramString)
  {
    AppMethodBeat.i(209982);
    this.ggK = z("city", paramString, true);
    AppMethodBeat.o(209982);
    return this;
  }
  
  public final ab iU(String paramString)
  {
    AppMethodBeat.i(209983);
    this.ggL = z("country", paramString, true);
    AppMethodBeat.o(209983);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ab
 * JD-Core Version:    0.7.0.1
 */