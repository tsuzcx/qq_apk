package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mn
  extends a
{
  private long gBI;
  private String gHP = "";
  private long gUv;
  private long gUw;
  private String gUx = "";
  private long gnP;
  
  public final mn De(String paramString)
  {
    AppMethodBeat.i(237190);
    this.gHP = z("ToUsername", paramString, true);
    AppMethodBeat.o(237190);
    return this;
  }
  
  public final mn Df(String paramString)
  {
    AppMethodBeat.i(237191);
    this.gUx = z("SceneExtInfo", paramString, true);
    AppMethodBeat.o(237191);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(237192);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gHP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUx);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(237192);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(237194);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUsername:").append(this.gHP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasTextStatusIcon:").append(this.gUv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionResult:").append(this.gUw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.gBI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SceneExtInfo:").append(this.gUx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(237194);
    return localObject;
  }
  
  public final int getId()
  {
    return 22210;
  }
  
  public final mn yc(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final mn yd(long paramLong)
  {
    this.gUv = paramLong;
    return this;
  }
  
  public final mn ye(long paramLong)
  {
    this.gUw = paramLong;
    return this;
  }
  
  public final mn yf(long paramLong)
  {
    this.gBI = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mn
 * JD-Core Version:    0.7.0.1
 */