package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hk
  extends a
{
  public String ggg = "";
  public long ggh;
  public long ggi;
  
  public final String agH()
  {
    AppMethodBeat.i(288893);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggi);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(288893);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(288894);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.ggh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.ggi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(288894);
    return localObject;
  }
  
  public final int getId()
  {
    return 22595;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hk
 * JD-Core Version:    0.7.0.1
 */