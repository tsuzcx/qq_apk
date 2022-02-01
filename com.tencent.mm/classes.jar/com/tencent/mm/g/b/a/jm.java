package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jm
  extends a
{
  private long eRE = 0L;
  private long eRF = 0L;
  private long eRG = 0L;
  private long eRH = 0L;
  private int eRI = 0;
  
  public final String abV()
  {
    AppMethodBeat.i(118500);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eRE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eRI);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(118500);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(118501);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("StartZipTime:").append(this.eRE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Enable:").append(this.eRF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Exceed:").append(this.eRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Cost:").append(this.eRH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Result:").append(this.eRI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118501);
    return localObject;
  }
  
  public final jm ahu()
  {
    this.eRG = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 17654;
  }
  
  public final jm lM(int paramInt)
  {
    this.eRI = paramInt;
    return this;
  }
  
  public final jm sg(long paramLong)
  {
    this.eRE = paramLong;
    return this;
  }
  
  public final jm sh(long paramLong)
  {
    this.eRF = paramLong;
    return this;
  }
  
  public final jm si(long paramLong)
  {
    this.eRH = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jm
 * JD-Core Version:    0.7.0.1
 */