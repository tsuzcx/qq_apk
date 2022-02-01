package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class my
  extends a
{
  private int iHU;
  public long iOI;
  private String iWh = "";
  public int ilm;
  private String iqO = "";
  private String jcF = "";
  private long jcG;
  private long jcH;
  private String jcI = "";
  private long jcJ;
  public int jcK;
  private long jcL;
  public String jcM = "";
  private String jcN = "";
  private String jcO = "";
  private String jcP = "";
  private String jcQ = "";
  public long jcR;
  public long jcS;
  public long jcT;
  public long jcU;
  
  public final String aIE()
  {
    AppMethodBeat.i(368338);
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
    ((StringBuffer)localObject).append(this.jcK);
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
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jcU);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368338);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368344);
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
    ((StringBuffer)localObject).append("TapType:").append(this.jcK);
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
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MusicScene:").append(this.jcU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368344);
    return localObject;
  }
  
  public final int getId()
  {
    return 23899;
  }
  
  public final my vp(String paramString)
  {
    AppMethodBeat.i(368303);
    this.jcF = F("ToSongOrTv", paramString, true);
    AppMethodBeat.o(368303);
    return this;
  }
  
  public final my vq(String paramString)
  {
    AppMethodBeat.i(368306);
    this.iqO = F("SessionID", paramString, true);
    AppMethodBeat.o(368306);
    return this;
  }
  
  public final my vr(String paramString)
  {
    AppMethodBeat.i(368311);
    this.jcN = F("ToSongName", paramString, true);
    AppMethodBeat.o(368311);
    return this;
  }
  
  public final my vs(String paramString)
  {
    AppMethodBeat.i(368319);
    this.jcO = F("ToSongSinger", paramString, true);
    AppMethodBeat.o(368319);
    return this;
  }
  
  public final my vt(String paramString)
  {
    AppMethodBeat.i(368325);
    this.jcP = F("ToSongWeburl", paramString, true);
    AppMethodBeat.o(368325);
    return this;
  }
  
  public final my vu(String paramString)
  {
    AppMethodBeat.i(368332);
    this.jcQ = F("ToSongDataurl", paramString, true);
    AppMethodBeat.o(368332);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.my
 * JD-Core Version:    0.7.0.1
 */