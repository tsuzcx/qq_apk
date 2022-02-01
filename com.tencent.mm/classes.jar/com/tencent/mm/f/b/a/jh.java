package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jh
  extends a
{
  private long gKV;
  private long gKW;
  private String gKX = "";
  private String gKY = "";
  private String glF = "";
  private long gxD;
  private String gxE = "";
  private long gxG;
  private String gxJ = "";
  private long gxU;
  
  public final jh An(String paramString)
  {
    AppMethodBeat.i(209635);
    this.glF = z("RedDotTipsID", paramString, true);
    AppMethodBeat.o(209635);
    return this;
  }
  
  public final jh Ao(String paramString)
  {
    AppMethodBeat.i(209636);
    this.gxE = z("RedDotShowInfoPath", paramString, true);
    AppMethodBeat.o(209636);
    return this;
  }
  
  public final jh Ap(String paramString)
  {
    AppMethodBeat.i(209637);
    this.gKX = z("WhiteListReddotList", paramString, true);
    AppMethodBeat.o(209637);
    return this;
  }
  
  public final jh Aq(String paramString)
  {
    AppMethodBeat.i(209638);
    this.gKY = z("OverwriteRedDotTipsID", paramString, true);
    AppMethodBeat.o(209638);
    return this;
  }
  
  public final jh Ar(String paramString)
  {
    AppMethodBeat.i(209640);
    this.gxJ = z("RedDotShowInfoExt", paramString, true);
    AppMethodBeat.o(209640);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(209643);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gxD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gxJ);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209643);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209645);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RedDotCtrlType:").append(this.gxD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoType:").append(this.gxG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeState:").append(this.gKV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotTipsID:").append(this.glF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoPath:").append(this.gxE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RevokeType:").append(this.gKW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WhiteListReddotList:").append(this.gKX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OverwriteRedDotTipsID:").append(this.gKY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotactiontimestamp:").append(this.gxU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RedDotShowInfoExt:").append(this.gxJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209645);
    return localObject;
  }
  
  public final int getId()
  {
    return 20951;
  }
  
  public final jh up(long paramLong)
  {
    this.gxD = paramLong;
    return this;
  }
  
  public final jh uq(long paramLong)
  {
    this.gxG = paramLong;
    return this;
  }
  
  public final jh ur(long paramLong)
  {
    this.gKV = paramLong;
    return this;
  }
  
  public final jh us(long paramLong)
  {
    this.gKW = paramLong;
    return this;
  }
  
  public final jh ut(long paramLong)
  {
    this.gxU = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jh
 * JD-Core Version:    0.7.0.1
 */