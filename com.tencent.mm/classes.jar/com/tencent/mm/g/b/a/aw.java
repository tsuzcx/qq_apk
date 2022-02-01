package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aw
  extends a
{
  private long dQX;
  private String dWq = "";
  private String dWr = "";
  private String dYQ = "";
  private long dYR;
  private long dYS;
  private String dYp = "";
  
  public final String RC()
  {
    AppMethodBeat.i(189147);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(189147);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(189148);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("feedid:").append(this.dYQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.dYR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.dYS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dQX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dWq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dWr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dYp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(189148);
    return localObject;
  }
  
  public final aw dX(long paramLong)
  {
    this.dYR = paramLong;
    return this;
  }
  
  public final aw dY(long paramLong)
  {
    this.dYS = paramLong;
    return this;
  }
  
  public final aw dZ(long paramLong)
  {
    this.dQX = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20353;
  }
  
  public final aw iE(String paramString)
  {
    AppMethodBeat.i(189143);
    this.dYQ = t("feedid", paramString, true);
    AppMethodBeat.o(189143);
    return this;
  }
  
  public final aw iF(String paramString)
  {
    AppMethodBeat.i(189144);
    this.dWq = t("Sessionid", paramString, true);
    AppMethodBeat.o(189144);
    return this;
  }
  
  public final aw iG(String paramString)
  {
    AppMethodBeat.i(189145);
    this.dWr = t("Contextid", paramString, true);
    AppMethodBeat.o(189145);
    return this;
  }
  
  public final aw iH(String paramString)
  {
    AppMethodBeat.i(189146);
    this.dYp = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(189146);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aw
 * JD-Core Version:    0.7.0.1
 */