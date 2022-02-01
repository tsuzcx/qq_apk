package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cs
  extends a
{
  private long eeG = 0L;
  private long eeH;
  private String eeI = "";
  private long eeJ;
  private long eeK;
  private String eeu = "";
  private long eev;
  
  public final String RC()
  {
    AppMethodBeat.i(215497);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eev);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeK);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215497);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215498);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("waitCount:").append(this.eeG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowConnect:").append(this.eeH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.eeI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.eeJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("linkCount:").append(this.eeK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215498);
    return localObject;
  }
  
  public final int getId()
  {
    return 19894;
  }
  
  public final cs iu(long paramLong)
  {
    this.eev = paramLong;
    return this;
  }
  
  public final cs iv(long paramLong)
  {
    this.eeG = paramLong;
    return this;
  }
  
  public final cs iw(long paramLong)
  {
    this.eeH = paramLong;
    return this;
  }
  
  public final cs ix(long paramLong)
  {
    this.eeK = paramLong;
    return this;
  }
  
  public final cs mj(String paramString)
  {
    AppMethodBeat.i(215496);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(215496);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cs
 * JD-Core Version:    0.7.0.1
 */