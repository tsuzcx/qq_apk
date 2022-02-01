package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ap
  extends a
{
  private long epY;
  private long epZ;
  public int eqa;
  private int eqb;
  private int eqc;
  public int eqd;
  private int eqe;
  
  public final String abV()
  {
    AppMethodBeat.i(199741);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.epY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqe);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(199741);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(199742);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("result:").append(this.epY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errType:").append(this.epZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emojiCount:").append(this.eqa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldVersion:").append(this.eqb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newVersion:").append(this.eqc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("subType:").append(this.eqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.eqe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(199742);
    return localObject;
  }
  
  public final ap cV(long paramLong)
  {
    this.epY = paramLong;
    return this;
  }
  
  public final ap cW(long paramLong)
  {
    this.epZ = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 21843;
  }
  
  public final ap jP(int paramInt)
  {
    this.eqb = paramInt;
    return this;
  }
  
  public final ap jQ(int paramInt)
  {
    this.eqc = paramInt;
    return this;
  }
  
  public final ap jR(int paramInt)
  {
    this.eqe = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ap
 * JD-Core Version:    0.7.0.1
 */