package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class x
  extends a
{
  private String cTJ = "";
  private String cTK = "";
  public long cTL = 0L;
  public long cTM = 0L;
  public long cTN = 0L;
  public long cTO = 0L;
  public long cTP = 0L;
  public long cTQ = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(77595);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cTJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTQ);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(77595);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(77596);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.cTJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userName:").append(this.cTK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("succeedStatus:").append(this.cTL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userStatus:").append(this.cTM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showSucceedMethod:").append(this.cTN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickSucceedAction:").append(this.cTO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("watchMessageRecord:").append(this.cTP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sendMessageStatus:").append(this.cTQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(77596);
    return localObject;
  }
  
  public final x fs(String paramString)
  {
    AppMethodBeat.i(77593);
    this.cTJ = t("sessionid", paramString, true);
    AppMethodBeat.o(77593);
    return this;
  }
  
  public final x ft(String paramString)
  {
    AppMethodBeat.i(77594);
    this.cTK = t("userName", paramString, true);
    AppMethodBeat.o(77594);
    return this;
  }
  
  public final int getId()
  {
    return 15855;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.x
 * JD-Core Version:    0.7.0.1
 */