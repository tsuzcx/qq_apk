package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cf
  extends a
{
  private String dSb;
  private long ecb;
  private long ecc;
  private long ecd;
  private long ece;
  private long ecf;
  private String ecg;
  private String ech;
  private long eci;
  private long ecj;
  private long eck;
  private String ecl;
  private long ecm;
  private String ecn;
  private long eco;
  public long ecp;
  private String ecq;
  private long ecr;
  
  public final String RD()
  {
    AppMethodBeat.i(217410);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ecb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ece);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ech);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eci);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eck);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eco);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ecr);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(217410);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(217411);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SceneID:").append(this.ecb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIArea:").append(this.ecc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PositionID:").append(this.ecd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionID:").append(this.ece);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceID:").append(this.ecf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameID:").append(this.ecg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionStatus:").append(this.ech);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GiftID:").append(this.eci);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GiftType:").append(this.ecj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("from_account_type:").append(this.eck);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("from_username:").append(this.ecl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_account_type:").append(this.ecm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_username:").append(this.ecn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDot:").append(this.eco);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalNum:").append(this.ecp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExternInfo:").append(this.ecq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Time:").append(this.ecr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(217411);
    return localObject;
  }
  
  public final int getId()
  {
    return 20488;
  }
  
  public final cf hR(long paramLong)
  {
    this.ecb = paramLong;
    return this;
  }
  
  public final cf hS(long paramLong)
  {
    this.ecc = paramLong;
    return this;
  }
  
  public final cf hT(long paramLong)
  {
    this.ecd = paramLong;
    return this;
  }
  
  public final cf hU(long paramLong)
  {
    this.ece = paramLong;
    return this;
  }
  
  public final cf hV(long paramLong)
  {
    this.ecf = paramLong;
    return this;
  }
  
  public final cf hW(long paramLong)
  {
    this.eck = paramLong;
    return this;
  }
  
  public final cf hX(long paramLong)
  {
    this.ecm = paramLong;
    return this;
  }
  
  public final cf hY(long paramLong)
  {
    this.ecp = paramLong;
    return this;
  }
  
  public final cf lE(String paramString)
  {
    AppMethodBeat.i(217405);
    this.ech = t("ActionStatus", paramString, true);
    AppMethodBeat.o(217405);
    return this;
  }
  
  public final cf lF(String paramString)
  {
    AppMethodBeat.i(217406);
    this.ecl = t("from_username", paramString, true);
    AppMethodBeat.o(217406);
    return this;
  }
  
  public final cf lG(String paramString)
  {
    AppMethodBeat.i(217407);
    this.ecn = t("to_username", paramString, true);
    AppMethodBeat.o(217407);
    return this;
  }
  
  public final cf lH(String paramString)
  {
    AppMethodBeat.i(217408);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(217408);
    return this;
  }
  
  public final cf lI(String paramString)
  {
    AppMethodBeat.i(217409);
    this.ecq = t("ExternInfo", paramString, true);
    AppMethodBeat.o(217409);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cf
 * JD-Core Version:    0.7.0.1
 */