package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mz
  extends a
{
  public int iHU;
  public long iOI;
  private String iWh = "";
  public int ilm;
  public String iqO = "";
  public String jcF = "";
  public long jcG;
  public long jcH;
  private String jcI = "";
  public long jcJ;
  public long jcL;
  public String jcM = "";
  public String jcN = "";
  public String jcO = "";
  public String jcP = "";
  public String jcQ = "";
  private long jcR;
  private long jcS;
  public long jcT;
  public int jcV;
  
  public final String aIE()
  {
    AppMethodBeat.i(368327);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iOI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iWh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iHU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcT);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368327);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368337);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Action:").append(this.ilm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionTs:").append(this.iOI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsername:").append(this.iWh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToSongOrTv:").append(this.jcF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUinPos:").append(this.jcG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUinGender:").append(this.jcH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUinDistanceStr:").append(this.jcI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUinHasSignature:").append(this.jcJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TabType:").append(this.jcV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterScene:").append(this.iHU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ShakeCostTime:").append(this.jcL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionID:").append(this.iqO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SharkSessionID:").append(this.jcM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToSongName:").append(this.jcN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToSongSinger:").append(this.jcO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToSongWeburl:").append(this.jcP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToSongDataurl:").append(this.jcQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpStatus:").append(this.jcR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToSongRecommendPos:").append(this.jcS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToSongCopyRighted:").append(this.jcT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368337);
    return localObject;
  }
  
  public final int getId()
  {
    return 23899;
  }
  
  public final mz vv(String paramString)
  {
    AppMethodBeat.i(368310);
    this.iWh = F("ToUsername", paramString, true);
    AppMethodBeat.o(368310);
    return this;
  }
  
  public final mz vw(String paramString)
  {
    AppMethodBeat.i(368318);
    this.jcI = F("ToUinDistanceStr", paramString, true);
    AppMethodBeat.o(368318);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mz
 * JD-Core Version:    0.7.0.1
 */