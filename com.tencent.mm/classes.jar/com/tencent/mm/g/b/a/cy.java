package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cy
  extends a
{
  private String eeR = "";
  private String eeS = "";
  private String eeu = "";
  private long eev;
  private long eex;
  private long efe = 0L;
  private long eff;
  private long efg;
  private String efh = "";
  
  public final String RC()
  {
    AppMethodBeat.i(215522);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eeu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eev);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eex);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eff);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efh);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(215522);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(215523);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.eeu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.eev);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micid:").append(this.efe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.eeR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.eex);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("closeRole:").append(this.eff);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasVideo:").append(this.efg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.eeS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("livemicid:").append(this.efh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(215523);
    return localObject;
  }
  
  public final int getId()
  {
    return 19895;
  }
  
  public final cy iW(long paramLong)
  {
    this.eev = paramLong;
    return this;
  }
  
  public final cy iX(long paramLong)
  {
    this.eex = paramLong;
    return this;
  }
  
  public final cy iY(long paramLong)
  {
    this.eff = paramLong;
    return this;
  }
  
  public final cy iZ(long paramLong)
  {
    this.efg = paramLong;
    return this;
  }
  
  public final cy mu(String paramString)
  {
    AppMethodBeat.i(215519);
    this.eeu = t("roomid", paramString, true);
    AppMethodBeat.o(215519);
    return this;
  }
  
  public final cy mv(String paramString)
  {
    AppMethodBeat.i(215520);
    this.eeS = t("liveusername", paramString, true);
    AppMethodBeat.o(215520);
    return this;
  }
  
  public final cy mw(String paramString)
  {
    AppMethodBeat.i(215521);
    this.efh = t("livemicid", paramString, true);
    AppMethodBeat.o(215521);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cy
 * JD-Core Version:    0.7.0.1
 */