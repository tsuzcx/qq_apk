package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bf
  extends a
{
  public long iqR = 0L;
  public long iqS = 0L;
  public long iqT;
  
  public final String aIE()
  {
    AppMethodBeat.i(368925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iqR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368925);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368933);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EntranceID:").append(this.iqR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SettingEvent:").append(this.iqS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("settingMethod:").append(this.iqT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368933);
    return localObject;
  }
  
  public final int getId()
  {
    return 15185;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bf
 * JD-Core Version:    0.7.0.1
 */