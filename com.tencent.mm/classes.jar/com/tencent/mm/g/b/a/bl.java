package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bl
  extends a
{
  private long eiE;
  private long erZ;
  private long esH;
  private long esI;
  private long esJ;
  
  public final String abV()
  {
    AppMethodBeat.i(208885);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.esH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erZ);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208885);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208886);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickTimestamps:").append(this.esH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickType:").append(this.esI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Outcome:").append(this.esJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.eiE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Followcount:").append(this.erZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208886);
    return localObject;
  }
  
  public final bl dP(long paramLong)
  {
    this.esH = paramLong;
    return this;
  }
  
  public final bl dQ(long paramLong)
  {
    this.esI = paramLong;
    return this;
  }
  
  public final bl dR(long paramLong)
  {
    this.esJ = paramLong;
    return this;
  }
  
  public final bl dS(long paramLong)
  {
    this.eiE = paramLong;
    return this;
  }
  
  public final bl dT(long paramLong)
  {
    this.erZ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21077;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bl
 * JD-Core Version:    0.7.0.1
 */