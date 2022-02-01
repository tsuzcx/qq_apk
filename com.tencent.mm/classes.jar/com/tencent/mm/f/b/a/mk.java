package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mk
  extends a
{
  private int gTU = -1;
  private int gTV = -1;
  private String gTW = "";
  private int gTX = -1;
  
  public final mk CN(String paramString)
  {
    AppMethodBeat.i(218195);
    this.gTW = z("MsgExt", paramString, true);
    AppMethodBeat.o(218195);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(218200);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gTU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gTX);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(218200);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(218202);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("IsComeScene:").append(this.gTU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsSolve:").append(this.gTV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgExt:").append(this.gTW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isHit:").append(this.gTX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(218202);
    return localObject;
  }
  
  public final int getId()
  {
    return 22021;
  }
  
  public final mk nP(int paramInt)
  {
    this.gTX = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mk
 * JD-Core Version:    0.7.0.1
 */