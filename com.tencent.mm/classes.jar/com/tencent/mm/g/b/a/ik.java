package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ik
  extends a
{
  private String dKR;
  private String dQr;
  private long mas;
  private long mat;
  private String mbi;
  private long mbj;
  private long oOU;
  private long oOV;
  
  public final ik AC(long paramLong)
  {
    this.mas = paramLong;
    return this;
  }
  
  public final ik AD(long paramLong)
  {
    this.mbj = paramLong;
    return this;
  }
  
  public final ik AE(long paramLong)
  {
    this.mat = paramLong;
    return this;
  }
  
  public final ik AF(long paramLong)
  {
    this.oOU = paramLong;
    return this;
  }
  
  public final ik AG(long paramLong)
  {
    this.oOV = paramLong;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(202472);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mas);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mat);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oOU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.oOV);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202472);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202473);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.mas);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dKR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.mbi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.mbj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.mat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wholeTime:").append(this.oOU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("viewTime:").append(this.oOV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202473);
    return localObject;
  }
  
  public final ik aTl(String paramString)
  {
    AppMethodBeat.i(202469);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(202469);
    return this;
  }
  
  public final ik aTm(String paramString)
  {
    AppMethodBeat.i(202470);
    this.dKR = t("topic", paramString, true);
    AppMethodBeat.o(202470);
    return this;
  }
  
  public final ik aTn(String paramString)
  {
    AppMethodBeat.i(202471);
    this.mbi = t("liveusername", paramString, true);
    AppMethodBeat.o(202471);
    return this;
  }
  
  public final int getId()
  {
    return 19898;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ik
 * JD-Core Version:    0.7.0.1
 */