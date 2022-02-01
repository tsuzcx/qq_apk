package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class eg
  extends a
{
  public long iBT;
  private String iCD;
  public long iCE;
  private String iCF;
  private String iCG;
  public long iCH;
  private String iCI;
  public long iCJ;
  public long iCK;
  public long iCL;
  public long iCM;
  public long iCN;
  public long iCO;
  private String iCP;
  private String iCQ;
  private String iCz;
  private String inx;
  private String iny;
  public long ioV;
  private String ipW;
  private String iqp;
  
  public eg()
  {
    this.inx = "";
    this.iny = "";
    this.iCz = "";
    this.iCG = "";
    this.iCD = "";
    this.iCF = "";
    this.iCI = "";
    this.ipW = "";
    this.iqp = "";
    this.iCP = "";
    this.iCQ = "";
  }
  
  public eg(String paramString)
  {
    AppMethodBeat.i(367953);
    this.inx = "";
    this.iny = "";
    this.iCz = "";
    this.iCG = "";
    this.iCD = "";
    this.iCF = "";
    this.iCI = "";
    this.ipW = "";
    this.iqp = "";
    this.iCP = "";
    this.iCQ = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 21) {
          break label342;
        }
        String[] arrayOfString = new String[21];
        Arrays.fill(arrayOfString, 0, 21, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label342:
    for (;;)
    {
      or(paramString[0]);
      os(paramString[1]);
      ot(paramString[2]);
      ou(paramString[3]);
      this.ioV = Util.getLong(paramString[4], 0L);
      ov(paramString[5]);
      this.iCH = Util.getLong(paramString[6], 0L);
      this.iCE = Util.getLong(paramString[7], 0L);
      ow(paramString[8]);
      ox(paramString[9]);
      this.iCJ = Util.getLong(paramString[10], 0L);
      this.iCK = Util.getLong(paramString[11], 0L);
      this.iCL = Util.getLong(paramString[12], 0L);
      oy(paramString[13]);
      this.iBT = Util.getLong(paramString[14], 0L);
      this.iCM = Util.getLong(paramString[15], 0L);
      this.iCN = Util.getLong(paramString[16], 0L);
      this.iCO = Util.getLong(paramString[17], 0L);
      oz(paramString[18]);
      oA(paramString[19]);
      oB(paramString[20]);
      AppMethodBeat.o(367953);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(368010);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.inx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iny);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ioV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ipW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iBT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iCQ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368010);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368016);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.inx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("contextid:").append(this.iny);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextId:").append(this.iCz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("refreshTime:").append(this.iCG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.ioV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardid:").append(this.iCD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardIndex:").append(this.iCH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardIcon:").append(this.iCE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardTag:").append(this.iCF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardStatus:").append(this.iCI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardExposeTime:").append(this.iCJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardStartExposeTime:").append(this.iCK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cardEndExposeTime:").append(this.iCL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedid:").append(this.ipW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedIndex:").append(this.iBT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedExposeTime:").append(this.iCM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedStartExposeTime:").append(this.iCN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("feedEndExposeTime:").append(this.iCO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionBuffer:").append(this.iqp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lat:").append(this.iCP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lng:").append(this.iCQ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368016);
    return localObject;
  }
  
  public final int getId()
  {
    return 21567;
  }
  
  public final eg oA(String paramString)
  {
    AppMethodBeat.i(368000);
    this.iCP = F("lat", paramString, true);
    AppMethodBeat.o(368000);
    return this;
  }
  
  public final eg oB(String paramString)
  {
    AppMethodBeat.i(368003);
    this.iCQ = F("lng", paramString, true);
    AppMethodBeat.o(368003);
    return this;
  }
  
  public final eg or(String paramString)
  {
    AppMethodBeat.i(367962);
    this.inx = F("sessionid", paramString, true);
    AppMethodBeat.o(367962);
    return this;
  }
  
  public final eg os(String paramString)
  {
    AppMethodBeat.i(367966);
    this.iny = F("contextid", paramString, true);
    AppMethodBeat.o(367966);
    return this;
  }
  
  public final eg ot(String paramString)
  {
    AppMethodBeat.i(367971);
    this.iCz = F("clickTabContextId", paramString, true);
    AppMethodBeat.o(367971);
    return this;
  }
  
  public final eg ou(String paramString)
  {
    AppMethodBeat.i(367974);
    this.iCG = F("refreshTime", paramString, true);
    AppMethodBeat.o(367974);
    return this;
  }
  
  public final eg ov(String paramString)
  {
    AppMethodBeat.i(367978);
    this.iCD = F("cardid", paramString, true);
    AppMethodBeat.o(367978);
    return this;
  }
  
  public final eg ow(String paramString)
  {
    AppMethodBeat.i(367982);
    this.iCF = F("cardTag", paramString, true);
    AppMethodBeat.o(367982);
    return this;
  }
  
  public final eg ox(String paramString)
  {
    AppMethodBeat.i(367987);
    this.iCI = F("cardStatus", paramString, true);
    AppMethodBeat.o(367987);
    return this;
  }
  
  public final eg oy(String paramString)
  {
    AppMethodBeat.i(367991);
    this.ipW = F("feedid", paramString, true);
    AppMethodBeat.o(367991);
    return this;
  }
  
  public final eg oz(String paramString)
  {
    AppMethodBeat.i(367996);
    this.iqp = F("SessionBuffer", paramString, true);
    AppMethodBeat.o(367996);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.eg
 * JD-Core Version:    0.7.0.1
 */