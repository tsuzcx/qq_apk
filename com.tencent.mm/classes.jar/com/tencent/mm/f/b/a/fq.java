package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fq
  extends a
{
  private long gBA;
  private String gBB = "";
  private long gBC;
  public long gBD;
  private long gBE;
  private long gBh;
  private long gBi;
  private long gBj;
  private long gBk;
  private long gBm;
  private String gBn = "";
  private String gBt = "";
  private String gBv = "";
  private long gBw;
  private long gBx;
  private long gBy;
  private String gBz = "";
  private String gcU = "";
  
  public final String agH()
  {
    AppMethodBeat.i(199289);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gBh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBE);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(199289);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(199298);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SceneID:").append(this.gBh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UIArea:").append(this.gBi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PositionID:").append(this.gBj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionID:").append(this.gBk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SourceID:").append(this.gBm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GameID:").append(this.gBn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionStatus:").append(this.gBv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GiftID:").append(this.gBw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GiftType:").append(this.gBx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("from_account_type:").append(this.gBy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("from_username:").append(this.gBz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_account_type:").append(this.gBA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("to_username:").append(this.gBB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDot:").append(this.gBC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TotalNum:").append(this.gBD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExternInfo:").append(this.gBt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Time:").append(this.gBE);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(199298);
    return localObject;
  }
  
  public final int getId()
  {
    return 20488;
  }
  
  public final fq oA(long paramLong)
  {
    this.gBj = paramLong;
    return this;
  }
  
  public final fq oB(long paramLong)
  {
    this.gBk = paramLong;
    return this;
  }
  
  public final fq oC(long paramLong)
  {
    this.gBm = paramLong;
    return this;
  }
  
  public final fq oD(long paramLong)
  {
    this.gBy = paramLong;
    return this;
  }
  
  public final fq oE(long paramLong)
  {
    this.gBA = paramLong;
    return this;
  }
  
  public final fq oF(long paramLong)
  {
    this.gBD = paramLong;
    return this;
  }
  
  public final fq oy(long paramLong)
  {
    this.gBh = paramLong;
    return this;
  }
  
  public final fq oz(long paramLong)
  {
    this.gBi = paramLong;
    return this;
  }
  
  public final fq va(String paramString)
  {
    AppMethodBeat.i(199276);
    this.gBv = z("ActionStatus", paramString, true);
    AppMethodBeat.o(199276);
    return this;
  }
  
  public final fq vb(String paramString)
  {
    AppMethodBeat.i(199277);
    this.gBz = z("from_username", paramString, true);
    AppMethodBeat.o(199277);
    return this;
  }
  
  public final fq vc(String paramString)
  {
    AppMethodBeat.i(199280);
    this.gBB = z("to_username", paramString, true);
    AppMethodBeat.o(199280);
    return this;
  }
  
  public final fq vd(String paramString)
  {
    AppMethodBeat.i(199282);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(199282);
    return this;
  }
  
  public final fq ve(String paramString)
  {
    AppMethodBeat.i(199284);
    this.gBt = z("ExternInfo", paramString, true);
    AppMethodBeat.o(199284);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fq
 * JD-Core Version:    0.7.0.1
 */