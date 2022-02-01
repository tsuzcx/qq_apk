package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class at
  extends a
{
  private long gjR = 0L;
  private long gjS = 0L;
  private long gjT;
  
  public final String agH()
  {
    AppMethodBeat.i(209246);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209246);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209247);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EntranceID:").append(this.gjR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SettingEvent:").append(this.gjS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("settingMethod:").append(this.gjT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209247);
    return localObject;
  }
  
  public final at agQ()
  {
    this.gjT = 1L;
    return this;
  }
  
  public final at cI(long paramLong)
  {
    this.gjR = paramLong;
    return this;
  }
  
  public final at cJ(long paramLong)
  {
    this.gjS = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 15185;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.at
 * JD-Core Version:    0.7.0.1
 */