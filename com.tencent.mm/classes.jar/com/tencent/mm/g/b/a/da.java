package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class da
  extends a
{
  private String dZB = "";
  private String eeS = "";
  private long eeT;
  private String eeu = "";
  private long eev;
  private long eew;
  private long efo;
  private long efp;
  
  public final String RC()
  {
    AppMethodBeat.i(215532);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eev);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eew);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efp);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215532);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215533);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dZB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.eeS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.eeT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.eew);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wholeTime:").append(this.efo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("viewTime:").append(this.efp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215533);
    return localObject;
  }
  
  public final int getId()
  {
    return 19898;
  }
  
  public final da jh(long paramLong)
  {
    this.eev = paramLong;
    return this;
  }
  
  public final da ji(long paramLong)
  {
    this.eeT = paramLong;
    return this;
  }
  
  public final da jj(long paramLong)
  {
    this.eew = paramLong;
    return this;
  }
  
  public final da jk(long paramLong)
  {
    this.efo = paramLong;
    return this;
  }
  
  public final da jl(long paramLong)
  {
    this.efp = paramLong;
    return this;
  }
  
  public final da mA(String paramString)
  {
    AppMethodBeat.i(215529);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(215529);
    return this;
  }
  
  public final da mB(String paramString)
  {
    AppMethodBeat.i(215530);
    this.dZB = t("topic", paramString, true);
    AppMethodBeat.o(215530);
    return this;
  }
  
  public final da mC(String paramString)
  {
    AppMethodBeat.i(215531);
    this.eeS = t("liveusername", paramString, true);
    AppMethodBeat.o(215531);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.da
 * JD-Core Version:    0.7.0.1
 */