package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class q
  extends a
{
  private String gfg = "";
  public long gfh;
  public long gfi;
  public long gfj;
  private String gfk = "";
  private String gfl = "";
  
  public final String agH()
  {
    AppMethodBeat.i(283785);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfl);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(283785);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(283787);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("appId:").append(this.gfg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appType:").append(this.gfh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("aliveTime:").append(this.gfi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reason:").append(this.gfj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("flags:").append(this.gfk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionId:").append(this.gfl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(283787);
    return localObject;
  }
  
  public final int getId()
  {
    return 21804;
  }
  
  public final q iJ(String paramString)
  {
    AppMethodBeat.i(283779);
    this.gfg = z("appId", paramString, true);
    AppMethodBeat.o(283779);
    return this;
  }
  
  public final q iK(String paramString)
  {
    AppMethodBeat.i(283781);
    this.gfk = z("flags", paramString, true);
    AppMethodBeat.o(283781);
    return this;
  }
  
  public final q iL(String paramString)
  {
    AppMethodBeat.i(283783);
    this.gfl = z("sessionId", paramString, true);
    AppMethodBeat.o(283783);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.q
 * JD-Core Version:    0.7.0.1
 */