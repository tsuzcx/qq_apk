package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cf
  extends a
{
  private String dTr = "";
  private long edA;
  private String edB = "";
  private String edC = "";
  private long edD;
  private long edE;
  private long edF;
  private String edG = "";
  private long edH;
  private String edI = "";
  private long edJ;
  public long edK;
  private String edL = "";
  private long edM;
  private long edw;
  private long edx;
  private long edy;
  private long edz;
  
  public final String RC()
  {
    AppMethodBeat.i(214268);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.edw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.edM);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(214268);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(214269);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SceneID:").append(this.edw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIArea:").append(this.edx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PositionID:").append(this.edy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionID:").append(this.edz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceID:").append(this.edA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameID:").append(this.edB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionStatus:").append(this.edC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GiftID:").append(this.edD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GiftType:").append(this.edE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("from_account_type:").append(this.edF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("from_username:").append(this.edG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_account_type:").append(this.edH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_username:").append(this.edI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDot:").append(this.edJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalNum:").append(this.edK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExternInfo:").append(this.edL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Time:").append(this.edM);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(214269);
    return localObject;
  }
  
  public final int getId()
  {
    return 20488;
  }
  
  public final cf hW(long paramLong)
  {
    this.edw = paramLong;
    return this;
  }
  
  public final cf hX(long paramLong)
  {
    this.edx = paramLong;
    return this;
  }
  
  public final cf hY(long paramLong)
  {
    this.edy = paramLong;
    return this;
  }
  
  public final cf hZ(long paramLong)
  {
    this.edz = paramLong;
    return this;
  }
  
  public final cf ia(long paramLong)
  {
    this.edA = paramLong;
    return this;
  }
  
  public final cf ib(long paramLong)
  {
    this.edF = paramLong;
    return this;
  }
  
  public final cf ic(long paramLong)
  {
    this.edH = paramLong;
    return this;
  }
  
  public final cf id(long paramLong)
  {
    this.edK = paramLong;
    return this;
  }
  
  public final cf lV(String paramString)
  {
    AppMethodBeat.i(214263);
    this.edC = t("ActionStatus", paramString, true);
    AppMethodBeat.o(214263);
    return this;
  }
  
  public final cf lW(String paramString)
  {
    AppMethodBeat.i(214264);
    this.edG = t("from_username", paramString, true);
    AppMethodBeat.o(214264);
    return this;
  }
  
  public final cf lX(String paramString)
  {
    AppMethodBeat.i(214265);
    this.edI = t("to_username", paramString, true);
    AppMethodBeat.o(214265);
    return this;
  }
  
  public final cf lY(String paramString)
  {
    AppMethodBeat.i(214266);
    this.dTr = t("SessionId", paramString, true);
    AppMethodBeat.o(214266);
    return this;
  }
  
  public final cf lZ(String paramString)
  {
    AppMethodBeat.i(214267);
    this.edL = t("ExternInfo", paramString, true);
    AppMethodBeat.o(214267);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cf
 * JD-Core Version:    0.7.0.1
 */