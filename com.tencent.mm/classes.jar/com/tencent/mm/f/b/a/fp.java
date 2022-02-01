package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fp
  extends a
{
  private long gBh;
  private long gBi;
  private long gBj;
  private long gBk;
  private long gBl;
  private long gBm;
  private String gBn = "";
  private String gBo = "";
  private long gBp;
  private String gBq = "";
  private String gBr = "";
  private int gBs;
  private String gBt = "";
  private long gBu;
  public long glN;
  private String gqd = "";
  private long gzD;
  
  public final String agH()
  {
    AppMethodBeat.i(199150);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gBh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBu);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(199150);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(199165);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SceneID:").append(this.gBh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIArea:").append(this.gBi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PositionID:").append(this.gBj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionID:").append(this.gBk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionStatus:").append(this.gzD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Ssid:").append(this.gBl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceID:").append(this.gBm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameID:").append(this.gBn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomID:").append(this.gBo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MessageID:").append(this.gBp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameLeval:").append(this.gBq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameTitle:").append(this.gBr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserState:").append(this.gBs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Username:").append(this.gqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.glN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExternInfo:").append(this.gBt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NoticeID:").append(this.gBu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(199165);
    return localObject;
  }
  
  public final int getId()
  {
    return 23070;
  }
  
  public final fp op(long paramLong)
  {
    this.gBh = paramLong;
    return this;
  }
  
  public final fp oq(long paramLong)
  {
    this.gBi = paramLong;
    return this;
  }
  
  public final fp or(long paramLong)
  {
    this.gBj = paramLong;
    return this;
  }
  
  public final fp os(long paramLong)
  {
    this.gBk = paramLong;
    return this;
  }
  
  public final fp ot(long paramLong)
  {
    this.gzD = paramLong;
    return this;
  }
  
  public final fp ou(long paramLong)
  {
    this.gBl = paramLong;
    return this;
  }
  
  public final fp ov(long paramLong)
  {
    this.gBm = paramLong;
    return this;
  }
  
  public final fp ow(long paramLong)
  {
    this.gBp = paramLong;
    return this;
  }
  
  public final fp ox(long paramLong)
  {
    this.gBu = paramLong;
    return this;
  }
  
  public final fp uW(String paramString)
  {
    AppMethodBeat.i(199138);
    this.gBn = z("GameID", paramString, true);
    AppMethodBeat.o(199138);
    return this;
  }
  
  public final fp uX(String paramString)
  {
    AppMethodBeat.i(199139);
    this.gBo = z("ChatroomID", paramString, true);
    AppMethodBeat.o(199139);
    return this;
  }
  
  public final fp uY(String paramString)
  {
    AppMethodBeat.i(199140);
    this.gqd = z("Username", paramString, true);
    AppMethodBeat.o(199140);
    return this;
  }
  
  public final fp uZ(String paramString)
  {
    AppMethodBeat.i(199142);
    this.gBt = z("ExternInfo", paramString, true);
    AppMethodBeat.o(199142);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fp
 * JD-Core Version:    0.7.0.1
 */