package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class nf
  extends a
{
  private String gYB = "";
  public long gef;
  private String ggg = "";
  public long ggh;
  public long ggi;
  
  public final nf DZ(String paramString)
  {
    AppMethodBeat.i(186445);
    this.ggg = z("ChatName", paramString, true);
    AppMethodBeat.o(186445);
    return this;
  }
  
  public final nf Ea(String paramString)
  {
    AppMethodBeat.i(186446);
    this.gYB = z("NoticeId", paramString, true);
    AppMethodBeat.o(186446);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(186448);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gYB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(186448);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(186450);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatName:").append(this.ggg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Role:").append(this.ggh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MemberCount:").append(this.ggi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NoticeId:").append(this.gYB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186450);
    return localObject;
  }
  
  public final int getId()
  {
    return 22613;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.nf
 * JD-Core Version:    0.7.0.1
 */