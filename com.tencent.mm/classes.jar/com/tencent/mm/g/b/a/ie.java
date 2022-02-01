package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ie
  extends a
{
  private String dKR;
  private long dKc;
  private String dQr;
  private long mas;
  private long mat;
  private long mav;
  private String mbh;
  private String mbi;
  
  public final ie Ad(long paramLong)
  {
    this.mas = paramLong;
    return this;
  }
  
  public final ie Ae(long paramLong)
  {
    this.mat = paramLong;
    return this;
  }
  
  public final ie Af(long paramLong)
  {
    this.mav = paramLong;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(202447);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mas);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mat);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mav);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbi);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202447);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202448);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.mas);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dKR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.mbh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.mat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.mav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.mbi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202448);
    return localObject;
  }
  
  public final ie aSY(String paramString)
  {
    AppMethodBeat.i(202444);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(202444);
    return this;
  }
  
  public final ie aSZ(String paramString)
  {
    AppMethodBeat.i(202445);
    this.dKR = t("topic", paramString, true);
    AppMethodBeat.o(202445);
    return this;
  }
  
  public final ie aTa(String paramString)
  {
    AppMethodBeat.i(202446);
    this.mbi = t("liveusername", paramString, true);
    AppMethodBeat.o(202446);
    return this;
  }
  
  public final ie bta()
  {
    this.dKc = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19896;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ie
 * JD-Core Version:    0.7.0.1
 */