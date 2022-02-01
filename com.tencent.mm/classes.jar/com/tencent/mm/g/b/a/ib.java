package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ib
  extends a
{
  private String dKR = "";
  private long dKc;
  private String dQr;
  private long ehr;
  private long maR;
  private long maS;
  private long maT;
  private long maU;
  private long maV;
  private long mas;
  private long mat;
  private long mau = 0L;
  private long mav;
  private long maw;
  
  public final String PV()
  {
    AppMethodBeat.i(202435);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mas);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mat);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mau);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mav);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.maV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehr);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202435);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202436);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.mas);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dKR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.mat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.mau);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.mav);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCountMax:").append(this.maw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentCount:").append(this.maR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("heartCount:").append(this.maS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("connectCount:").append(this.maT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("allowReplay:").append(this.maU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.maV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("costTime:").append(this.ehr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202436);
    return localObject;
  }
  
  public final ib aST(String paramString)
  {
    AppMethodBeat.i(202433);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(202433);
    return this;
  }
  
  public final ib aSU(String paramString)
  {
    AppMethodBeat.i(202434);
    this.dKR = t("topic", paramString, true);
    AppMethodBeat.o(202434);
    return this;
  }
  
  public final ib bsY()
  {
    this.dKc = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 19891;
  }
  
  public final ib zG(long paramLong)
  {
    this.mas = paramLong;
    return this;
  }
  
  public final ib zH(long paramLong)
  {
    this.mat = paramLong;
    return this;
  }
  
  public final ib zI(long paramLong)
  {
    this.mav = paramLong;
    return this;
  }
  
  public final ib zJ(long paramLong)
  {
    this.maw = paramLong;
    return this;
  }
  
  public final ib zK(long paramLong)
  {
    this.maR = paramLong;
    return this;
  }
  
  public final ib zL(long paramLong)
  {
    this.maS = paramLong;
    return this;
  }
  
  public final ib zM(long paramLong)
  {
    this.maT = paramLong;
    return this;
  }
  
  public final ib zN(long paramLong)
  {
    this.maU = paramLong;
    return this;
  }
  
  public final ib zO(long paramLong)
  {
    this.maV = paramLong;
    return this;
  }
  
  public final ib zP(long paramLong)
  {
    this.ehr = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ib
 * JD-Core Version:    0.7.0.1
 */