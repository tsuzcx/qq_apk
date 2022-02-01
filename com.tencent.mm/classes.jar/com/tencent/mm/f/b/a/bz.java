package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bz
  extends a
{
  private long geB;
  private String ggA = "";
  private long gll;
  private String goE = "";
  private String goF = "";
  private String goG = "";
  private long goH;
  private String goj = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209020);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.goE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gll);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goH);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209020);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209022);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("finderUsername:").append(this.goE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toUsername:").append(this.goF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("toFinderUsername:").append(this.goG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.geB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.gll);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.goj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickScene:").append(this.goH);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209022);
    return localObject;
  }
  
  public final String ahq()
  {
    return this.ggA;
  }
  
  public final String ahr()
  {
    return this.goj;
  }
  
  public final bz ew(long paramLong)
  {
    this.geB = paramLong;
    return this;
  }
  
  public final bz ex(long paramLong)
  {
    this.gll = paramLong;
    return this;
  }
  
  public final bz ey(long paramLong)
  {
    this.goH = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20671;
  }
  
  public final bz lt(String paramString)
  {
    AppMethodBeat.i(209006);
    this.goE = z("finderUsername", paramString, true);
    AppMethodBeat.o(209006);
    return this;
  }
  
  public final bz lu(String paramString)
  {
    AppMethodBeat.i(209008);
    this.goF = z("toUsername", paramString, true);
    AppMethodBeat.o(209008);
    return this;
  }
  
  public final bz lv(String paramString)
  {
    AppMethodBeat.i(209010);
    this.goG = z("toFinderUsername", paramString, true);
    AppMethodBeat.o(209010);
    return this;
  }
  
  public final bz lw(String paramString)
  {
    AppMethodBeat.i(209013);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(209013);
    return this;
  }
  
  public final bz lx(String paramString)
  {
    AppMethodBeat.i(209015);
    this.goj = z("clicktabcontextid", paramString, true);
    AppMethodBeat.o(209015);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bz
 * JD-Core Version:    0.7.0.1
 */