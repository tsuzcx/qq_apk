package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dq
  extends a
{
  private String dRJ = "";
  private String eis = "";
  public long eit = 0L;
  public long eiu = 0L;
  public long eiv = 0L;
  public long eiw = 0L;
  public long eix = 0L;
  public long eiy = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(149920);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eis);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eit);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eix);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiy);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149920);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149921);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userName:").append(this.eis);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("succeedStatus:").append(this.eit);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("userStatus:").append(this.eiu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("showSucceedMethod:").append(this.eiv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickSucceedAction:").append(this.eiw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("watchMessageRecord:").append(this.eix);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sendMessageStatus:").append(this.eiy);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149921);
    return localObject;
  }
  
  public final int getId()
  {
    return 15855;
  }
  
  public final dq nn(String paramString)
  {
    AppMethodBeat.i(149918);
    this.dRJ = t("sessionid", paramString, true);
    AppMethodBeat.o(149918);
    return this;
  }
  
  public final dq no(String paramString)
  {
    AppMethodBeat.i(149919);
    this.eis = t("userName", paramString, true);
    AppMethodBeat.o(149919);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dq
 * JD-Core Version:    0.7.0.1
 */