package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ii
  extends a
{
  private String dQr;
  private long mas;
  private long mau;
  private String mbh;
  private String mbi;
  private long oOE = 0L;
  private long oOJ;
  private long oOO;
  private String oOP;
  
  public final ii As(long paramLong)
  {
    this.mas = paramLong;
    return this;
  }
  
  public final ii At(long paramLong)
  {
    this.mau = paramLong;
    return this;
  }
  
  public final ii Au(long paramLong)
  {
    this.oOJ = paramLong;
    return this;
  }
  
  public final ii Av(long paramLong)
  {
    this.oOO = paramLong;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(202463);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mas);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oOE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mau);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oOJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oOO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oOP);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202463);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202464);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.mas);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("micid:").append(this.oOE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.mbh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.mau);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("closeRole:").append(this.oOJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasVideo:").append(this.oOO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.mbi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("livemicid:").append(this.oOP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202464);
    return localObject;
  }
  
  public final ii aTg(String paramString)
  {
    AppMethodBeat.i(202460);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(202460);
    return this;
  }
  
  public final ii aTh(String paramString)
  {
    AppMethodBeat.i(202461);
    this.mbi = t("liveusername", paramString, true);
    AppMethodBeat.o(202461);
    return this;
  }
  
  public final ii aTi(String paramString)
  {
    AppMethodBeat.i(202462);
    this.oOP = t("livemicid", paramString, true);
    AppMethodBeat.o(202462);
    return this;
  }
  
  public final int getId()
  {
    return 19895;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ii
 * JD-Core Version:    0.7.0.1
 */