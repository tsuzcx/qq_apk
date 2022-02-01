package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gk
  extends a
{
  private int gCF;
  private int gCe;
  private int giX;
  
  public final String agH()
  {
    AppMethodBeat.i(217287);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCF);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(217287);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(217288);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionScene:").append(this.gCe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PageType:").append(this.gCF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217288);
    return localObject;
  }
  
  public final int getId()
  {
    return 21769;
  }
  
  public final gk mQ(int paramInt)
  {
    this.giX = paramInt;
    return this;
  }
  
  public final gk mR(int paramInt)
  {
    this.gCe = paramInt;
    return this;
  }
  
  public final gk mS(int paramInt)
  {
    this.gCF = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.gk
 * JD-Core Version:    0.7.0.1
 */