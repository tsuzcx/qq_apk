package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eq
  extends a
{
  private long eDY;
  private long eDZ;
  private long eEa;
  private long eEb;
  private long eEc;
  private String eEd = "";
  private String eEe = "";
  private long eEf;
  private long eEg;
  private long eEh;
  private String eEi = "";
  private long eEj;
  private String eEk = "";
  private long eEl;
  public long eEm;
  private String eEn = "";
  private long eEo;
  private String eiB = "";
  
  public final String abV()
  {
    AppMethodBeat.i(190321);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eDY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEo);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(190321);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(190322);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SceneID:").append(this.eDY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIArea:").append(this.eDZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PositionID:").append(this.eEa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionID:").append(this.eEb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceID:").append(this.eEc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameID:").append(this.eEd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionStatus:").append(this.eEe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GiftID:").append(this.eEf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GiftType:").append(this.eEg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("from_account_type:").append(this.eEh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("from_username:").append(this.eEi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_account_type:").append(this.eEj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_username:").append(this.eEk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDot:").append(this.eEl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalNum:").append(this.eEm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExternInfo:").append(this.eEn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Time:").append(this.eEo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190322);
    return localObject;
  }
  
  public final int getId()
  {
    return 20488;
  }
  
  public final eq mS(long paramLong)
  {
    this.eDY = paramLong;
    return this;
  }
  
  public final eq mT(long paramLong)
  {
    this.eDZ = paramLong;
    return this;
  }
  
  public final eq mU(long paramLong)
  {
    this.eEa = paramLong;
    return this;
  }
  
  public final eq mV(long paramLong)
  {
    this.eEb = paramLong;
    return this;
  }
  
  public final eq mW(long paramLong)
  {
    this.eEc = paramLong;
    return this;
  }
  
  public final eq mX(long paramLong)
  {
    this.eEh = paramLong;
    return this;
  }
  
  public final eq mY(long paramLong)
  {
    this.eEj = paramLong;
    return this;
  }
  
  public final eq mZ(long paramLong)
  {
    this.eEm = paramLong;
    return this;
  }
  
  public final eq rM(String paramString)
  {
    AppMethodBeat.i(190316);
    this.eEe = x("ActionStatus", paramString, true);
    AppMethodBeat.o(190316);
    return this;
  }
  
  public final eq rN(String paramString)
  {
    AppMethodBeat.i(190317);
    this.eEi = x("from_username", paramString, true);
    AppMethodBeat.o(190317);
    return this;
  }
  
  public final eq rO(String paramString)
  {
    AppMethodBeat.i(190318);
    this.eEk = x("to_username", paramString, true);
    AppMethodBeat.o(190318);
    return this;
  }
  
  public final eq rP(String paramString)
  {
    AppMethodBeat.i(190319);
    this.eiB = x("SessionId", paramString, true);
    AppMethodBeat.o(190319);
    return this;
  }
  
  public final eq rQ(String paramString)
  {
    AppMethodBeat.i(190320);
    this.eEn = x("ExternInfo", paramString, true);
    AppMethodBeat.o(190320);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eq
 * JD-Core Version:    0.7.0.1
 */