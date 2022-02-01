package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ne
  extends a
{
  public long gYA;
  public String gYB = "";
  public String ggg = "";
  public long ggh;
  public long ggi;
  public long gmT;
  
  public final String agH()
  {
    AppMethodBeat.i(190449);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(190449);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(190458);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.ggh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.ggi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isMuteRoom:").append(this.gYA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.gmT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NoticeId:").append(this.gYB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190458);
    return localObject;
  }
  
  public final int getId()
  {
    return 22600;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ne
 * JD-Core Version:    0.7.0.1
 */