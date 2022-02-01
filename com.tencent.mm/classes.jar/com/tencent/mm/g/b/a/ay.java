package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ay
  extends a
{
  public long eqP;
  public long eqQ;
  public long eqR;
  private int eqS;
  public int eqT;
  public int eqU;
  public int eqV;
  public long eqW;
  public long eqX;
  public long eqY;
  private String eqZ = "";
  private String era = "";
  public int erb;
  public long erc = 0L;
  public long erd = 0L;
  public long ere = 0L;
  public long erf = 0L;
  public long erg = 0L;
  public long erh = 0L;
  public long eri = 0L;
  public long erj = 0L;
  public long erk = 0L;
  private String erl = "";
  
  public final String abV()
  {
    AppMethodBeat.i(186353);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eqP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.era);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ere);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eri);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erl);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(186353);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(186354);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ResultCode:").append(this.eqP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AliveType:").append(this.eqQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalState:").append(this.eqR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PrepareCgiErrorCode:").append(this.eqS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfigCgiErrorCode:").append(this.eqT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CdnErrorCode:").append(this.eqU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VerifyCgiErrorCode:").append(this.eqV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CdnCost:").append(this.eqW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LivenessCost:").append(this.eqX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ResetCount:").append(this.eqY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StateRecord:").append(this.eqZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AndroidStateRecord:").append(this.era);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FaceReset:").append(this.erb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ConfirmPageTimeStamp:").append(this.erc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FlashUIPageTimeStamp:").append(this.erd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ReqConfigTimeStamp:").append(this.ere);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RspConfigTimeStamp:").append(this.erf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VerifyStartTimeStamp:").append(this.erg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VerifyEndTimeStamp:").append(this.erh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CdnEndTimeStamp:").append(this.eri);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RspVerifyTimeStamp:").append(this.erj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExitVerifyTimeStamp:").append(this.erk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BioId:").append(this.erl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186354);
    return localObject;
  }
  
  public final int getId()
  {
    return 21130;
  }
  
  public final ay iD(String paramString)
  {
    AppMethodBeat.i(186350);
    this.eqZ = x("StateRecord", paramString, true);
    AppMethodBeat.o(186350);
    return this;
  }
  
  public final ay iE(String paramString)
  {
    AppMethodBeat.i(186351);
    this.era = x("AndroidStateRecord", paramString, true);
    AppMethodBeat.o(186351);
    return this;
  }
  
  public final ay iF(String paramString)
  {
    AppMethodBeat.i(186352);
    this.erl = x("BioId", paramString, true);
    AppMethodBeat.o(186352);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ay
 * JD-Core Version:    0.7.0.1
 */