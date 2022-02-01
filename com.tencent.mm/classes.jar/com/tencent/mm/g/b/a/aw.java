package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aw
  extends a
{
  private long dPH;
  private String dVa;
  private String dVb;
  private String dWX;
  private long dXA;
  private long dXB;
  private String dXz;
  
  public final String RD()
  {
    AppMethodBeat.i(209115);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dXz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dXB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWX);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(209115);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(209116);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("feedid:").append(this.dXz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("mediaType:").append(this.dXA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentscene:").append(this.dXB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sessionid:").append(this.dVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Contextid:").append(this.dVb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextid:").append(this.dWX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209116);
    return localObject;
  }
  
  public final aw dW(long paramLong)
  {
    this.dXA = paramLong;
    return this;
  }
  
  public final aw dX(long paramLong)
  {
    this.dXB = paramLong;
    return this;
  }
  
  public final aw dY(long paramLong)
  {
    this.dPH = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 20353;
  }
  
  public final aw iu(String paramString)
  {
    AppMethodBeat.i(209111);
    this.dXz = t("feedid", paramString, true);
    AppMethodBeat.o(209111);
    return this;
  }
  
  public final aw iv(String paramString)
  {
    AppMethodBeat.i(209112);
    this.dVa = t("Sessionid", paramString, true);
    AppMethodBeat.o(209112);
    return this;
  }
  
  public final aw iw(String paramString)
  {
    AppMethodBeat.i(209113);
    this.dVb = t("Contextid", paramString, true);
    AppMethodBeat.o(209113);
    return this;
  }
  
  public final aw ix(String paramString)
  {
    AppMethodBeat.i(209114);
    this.dWX = t("ClickTabContextid", paramString, true);
    AppMethodBeat.o(209114);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aw
 * JD-Core Version:    0.7.0.1
 */