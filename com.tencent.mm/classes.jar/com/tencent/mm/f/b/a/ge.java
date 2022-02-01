package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ge
  extends a
{
  private int gCo = 0;
  private int giX = 0;
  private int gvX = 0;
  
  public final String agH()
  {
    AppMethodBeat.i(217276);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.giX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gvX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gCo);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(217276);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(217277);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.giX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.gvX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsJoinCollectData:").append(this.gCo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217277);
    return localObject;
  }
  
  public final int getId()
  {
    return 21764;
  }
  
  public final ge mE(int paramInt)
  {
    this.giX = paramInt;
    return this;
  }
  
  public final ge mF(int paramInt)
  {
    this.gvX = paramInt;
    return this;
  }
  
  public final ge mG(int paramInt)
  {
    this.gCo = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ge
 * JD-Core Version:    0.7.0.1
 */