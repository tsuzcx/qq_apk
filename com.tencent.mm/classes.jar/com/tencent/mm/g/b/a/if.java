package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class if
  extends a
{
  private String dKR;
  private long dKc;
  private String dQr;
  private long mas;
  private long mat;
  private String mbi;
  private long mbj;
  private long mbk;
  private long mbl;
  
  public final if Ag(long paramLong)
  {
    this.mas = paramLong;
    return this;
  }
  
  public final if Ah(long paramLong)
  {
    this.dKc = paramLong;
    return this;
  }
  
  public final if Ai(long paramLong)
  {
    this.mbj = paramLong;
    return this;
  }
  
  public final if Aj(long paramLong)
  {
    this.mat = paramLong;
    return this;
  }
  
  public final if Ak(long paramLong)
  {
    this.mbk = paramLong;
    return this;
  }
  
  public final if Al(long paramLong)
  {
    this.mbl = paramLong;
    return this;
  }
  
  public final String PV()
  {
    AppMethodBeat.i(202452);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dQr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mas);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mat);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.mbl);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(202452);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(202453);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dQr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.mas);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dKR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.mbi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.dKc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.mbj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.mat);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusEnd:").append(this.mbk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("replayStatusBegin:").append(this.mbl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(202453);
    return localObject;
  }
  
  public final if aTb(String paramString)
  {
    AppMethodBeat.i(202449);
    this.dQr = t("roomid", paramString, true);
    AppMethodBeat.o(202449);
    return this;
  }
  
  public final if aTc(String paramString)
  {
    AppMethodBeat.i(202450);
    this.dKR = t("topic", paramString, true);
    AppMethodBeat.o(202450);
    return this;
  }
  
  public final if aTd(String paramString)
  {
    AppMethodBeat.i(202451);
    this.mbi = t("liveusername", paramString, true);
    AppMethodBeat.o(202451);
    return this;
  }
  
  public final int getId()
  {
    return 19897;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.if
 * JD-Core Version:    0.7.0.1
 */