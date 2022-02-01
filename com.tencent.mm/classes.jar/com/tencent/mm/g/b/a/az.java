package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class az
  extends a
{
  public long eqP;
  public long eqQ;
  public long eqR;
  public int eqS;
  public int eqT;
  public int eqU;
  public int eqV;
  public long eqW;
  public long eqX;
  public long eqY;
  private String eqZ = "";
  private String era = "";
  public int erb;
  
  public final String abV()
  {
    AppMethodBeat.i(186357);
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
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(186357);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(186358);
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
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186358);
    return localObject;
  }
  
  public final int getId()
  {
    return 21131;
  }
  
  public final az iG(String paramString)
  {
    AppMethodBeat.i(186355);
    this.eqZ = x("StateRecord", paramString, true);
    AppMethodBeat.o(186355);
    return this;
  }
  
  public final az iH(String paramString)
  {
    AppMethodBeat.i(186356);
    this.era = x("AndroidStateRecord", paramString, true);
    AppMethodBeat.o(186356);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.az
 * JD-Core Version:    0.7.0.1
 */