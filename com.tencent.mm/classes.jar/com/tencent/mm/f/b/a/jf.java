package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jf
  extends a
{
  private String gcU = "";
  private int geN;
  private int ggl;
  private int ggm;
  
  public final jf Am(String paramString)
  {
    AppMethodBeat.i(186792);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(186792);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(186798);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(186798);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(186804);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.geN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.ggm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186804);
    return localObject;
  }
  
  public final jf ama()
  {
    this.ggl = 3;
    return this;
  }
  
  public final int getId()
  {
    return 20379;
  }
  
  public final jf nl(int paramInt)
  {
    this.geN = paramInt;
    return this;
  }
  
  public final jf nm(int paramInt)
  {
    this.ggm = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jf
 * JD-Core Version:    0.7.0.1
 */