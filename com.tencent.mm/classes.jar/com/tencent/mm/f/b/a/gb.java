package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gb
  extends a
{
  private int gCe;
  private int gCf;
  private String gcU = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209627);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCf);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209627);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209628);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionScene:").append(this.gCe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WordIndex:").append(this.gCf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209628);
    return localObject;
  }
  
  public final int getId()
  {
    return 21768;
  }
  
  public final gb mA(int paramInt)
  {
    this.gCe = paramInt;
    return this;
  }
  
  public final gb mB(int paramInt)
  {
    this.gCf = paramInt;
    return this;
  }
  
  public final gb vo(String paramString)
  {
    AppMethodBeat.i(209624);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209624);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gb
 * JD-Core Version:    0.7.0.1
 */