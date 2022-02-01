package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gj
  extends a
{
  private int gCC;
  private int gCD = 0;
  private String gCE = "";
  private int ggl;
  
  public final String agH()
  {
    AppMethodBeat.i(209994);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gCC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCE);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209994);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209998);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Enable:").append(this.gCC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtendInt:").append(this.gCD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExtendStr:").append(this.gCE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209998);
    return localObject;
  }
  
  public final int getId()
  {
    return 22421;
  }
  
  public final gj mN(int paramInt)
  {
    this.gCC = paramInt;
    return this;
  }
  
  public final gj mO(int paramInt)
  {
    this.ggl = paramInt;
    return this;
  }
  
  public final gj mP(int paramInt)
  {
    this.gCD = paramInt;
    return this;
  }
  
  public final gj vx(String paramString)
  {
    AppMethodBeat.i(209993);
    this.gCE = z("ExtendStr", paramString, true);
    AppMethodBeat.o(209993);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gj
 * JD-Core Version:    0.7.0.1
 */