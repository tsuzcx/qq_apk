package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fs
  extends a
{
  private long gBH;
  private long gBI;
  private String gBJ = "";
  private long gef;
  private String ggg = "";
  
  public final String agH()
  {
    AppMethodBeat.i(292297);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBJ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(292297);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(292298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReddotType:").append(this.gBH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.gBI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LiveIDList:").append(this.gBJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(292298);
    return localObject;
  }
  
  public final int getId()
  {
    return 21799;
  }
  
  public final fs oG(long paramLong)
  {
    this.gBH = paramLong;
    return this;
  }
  
  public final fs oH(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final fs oI(long paramLong)
  {
    this.gBI = paramLong;
    return this;
  }
  
  public final fs vf(String paramString)
  {
    AppMethodBeat.i(292294);
    this.ggg = z("ChatName", paramString, true);
    AppMethodBeat.o(292294);
    return this;
  }
  
  public final fs vg(String paramString)
  {
    AppMethodBeat.i(292296);
    this.gBJ = z("LiveIDList", paramString, true);
    AppMethodBeat.o(292296);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fs
 * JD-Core Version:    0.7.0.1
 */