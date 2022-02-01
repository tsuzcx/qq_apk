package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class al
  extends a
{
  private long eoE = 0L;
  private long eoF = 0L;
  private long eoG;
  
  public final String abV()
  {
    AppMethodBeat.i(208840);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoG);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(208840);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(208841);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EntranceID:").append(this.eoE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SettingEvent:").append(this.eoF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("settingMethod:").append(this.eoG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(208841);
    return localObject;
  }
  
  public final al acd()
  {
    this.eoG = 1L;
    return this;
  }
  
  public final al cd(long paramLong)
  {
    this.eoE = paramLong;
    return this;
  }
  
  public final al ce(long paramLong)
  {
    this.eoF = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 15185;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.al
 * JD-Core Version:    0.7.0.1
 */