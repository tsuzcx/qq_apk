package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ax
  extends a
{
  private long gcQ;
  private long gll;
  public int glm;
  private int gln;
  private int glo;
  public int glp;
  private int glq;
  
  public final String agH()
  {
    AppMethodBeat.i(231477);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gll);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gln);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glq);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(231477);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(231479);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("result:").append(this.gll);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errType:").append(this.gcQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emojiCount:").append(this.glm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldVersion:").append(this.gln);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newVersion:").append(this.glo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("subType:").append(this.glp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.glq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231479);
    return localObject;
  }
  
  public final ax dA(long paramLong)
  {
    this.gll = paramLong;
    return this;
  }
  
  public final ax dB(long paramLong)
  {
    this.gcQ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21843;
  }
  
  public final ax lj(int paramInt)
  {
    this.gln = paramInt;
    return this;
  }
  
  public final ax lk(int paramInt)
  {
    this.glo = paramInt;
    return this;
  }
  
  public final ax ll(int paramInt)
  {
    this.glq = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ax
 * JD-Core Version:    0.7.0.1
 */