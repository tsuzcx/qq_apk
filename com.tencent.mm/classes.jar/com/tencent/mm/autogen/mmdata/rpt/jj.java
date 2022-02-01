package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class jj
  extends a
{
  private long iAH;
  private long iFd;
  private long iSA;
  private long iSB;
  private long iSC;
  private long iSD;
  private long iSE;
  private String iSF;
  private String iSG;
  private long iSH;
  private long iSI;
  private String iSJ;
  private String iSK;
  public long iSL;
  private long iSM;
  private String iSN;
  private String iSO;
  private String iSP;
  private long iSQ;
  private String iSR;
  private String iSS;
  public long iST;
  private String iSy;
  private long iSz;
  private long iqr;
  private String iqw;
  
  public jj()
  {
    this.iSy = "";
    this.iAH = 0L;
    this.iSz = 0L;
    this.iSA = 0L;
    this.iSB = 0L;
    this.iSC = 0L;
    this.iSD = 0L;
    this.iSE = 0L;
    this.iSF = "";
    this.iSG = "";
    this.iSH = 0L;
    this.iSI = 0L;
    this.iSJ = "";
    this.iSK = "";
    this.iSL = 0L;
    this.iqr = 0L;
    this.iFd = 0L;
    this.iSM = 0L;
    this.iSN = "";
    this.iSO = "";
    this.iSP = "";
    this.iSQ = 0L;
    this.iSR = "";
    this.iqw = "";
    this.iSS = "";
    this.iST = 0L;
  }
  
  public jj(String paramString)
  {
    AppMethodBeat.i(94820);
    this.iSy = "";
    this.iAH = 0L;
    this.iSz = 0L;
    this.iSA = 0L;
    this.iSB = 0L;
    this.iSC = 0L;
    this.iSD = 0L;
    this.iSE = 0L;
    this.iSF = "";
    this.iSG = "";
    this.iSH = 0L;
    this.iSI = 0L;
    this.iSJ = "";
    this.iSK = "";
    this.iSL = 0L;
    this.iqr = 0L;
    this.iFd = 0L;
    this.iSM = 0L;
    this.iSN = "";
    this.iSO = "";
    this.iSP = "";
    this.iSQ = 0L;
    this.iSR = "";
    this.iqw = "";
    this.iSS = "";
    this.iST = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 26) {
          break label537;
        }
        String[] arrayOfString = new String[26];
        Arrays.fill(arrayOfString, 0, 26, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label537:
    for (;;)
    {
      this.iSy = F("ID", paramString[0], true);
      this.iAH = Util.getLong(paramString[1], 0L);
      this.iSz = Util.getLong(paramString[2], 0L);
      this.iSA = Util.getLong(paramString[3], 0L);
      this.iSB = Util.getLong(paramString[4], 0L);
      this.iSC = Util.getLong(paramString[5], 0L);
      this.iSD = Util.getLong(paramString[6], 0L);
      this.iSE = Util.getLong(paramString[7], 0L);
      this.iSF = F("FNumber", paramString[8], true);
      this.iSG = F("ExposureTime", paramString[9], true);
      this.iSH = Util.getLong(paramString[10], 0L);
      this.iSI = Util.getLong(paramString[11], 0L);
      this.iSJ = F("LensModel", paramString[12], true);
      this.iSK = F("CreatTime", paramString[13], true);
      this.iSL = Util.getLong(paramString[14], 0L);
      this.iqr = Util.getLong(paramString[15], 0L);
      this.iFd = Util.getLong(paramString[16], 0L);
      this.iSM = Util.getLong(paramString[17], 0L);
      this.iSN = F("make", paramString[18], true);
      this.iSO = F("software", paramString[19], true);
      this.iSP = F("fileExt", paramString[20], true);
      this.iSQ = Util.getLong(paramString[21], 0L);
      this.iSR = F("YCbCrSubSampling", paramString[22], true);
      this.iqw = F("md5", paramString[23], true);
      sg(paramString[24]);
      this.iST = Util.getLong(paramString[25], 0L);
      AppMethodBeat.o(94820);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(94822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iSy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iAH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iFd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iSS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iST);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(94822);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(94823);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ID:").append(this.iSy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.iAH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginWidth:").append(this.iSz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginHeight:").append(this.iSA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedWidth:").append(this.iSB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedHeight:").append(this.iSC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.iSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedSize:").append(this.iSE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FNumber:").append(this.iSF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposureTime:").append(this.iSG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ISO:").append(this.iSH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Flash:").append(this.iSI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LensModel:").append(this.iSJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatTime:").append(this.iSK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFromWeChat:").append(this.iSL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.iqr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneType:").append(this.iFd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSource:").append(this.iSM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("make:").append(this.iSN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("software:").append(this.iSO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileExt:").append(this.iSP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("faceCount:").append(this.iSQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("YCbCrSubSampling:").append(this.iSR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.iqw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("publishId:").append(this.iSS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("destMeidaType:").append(this.iST);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94823);
    return localObject;
  }
  
  public final int getId()
  {
    return 16585;
  }
  
  public final jj sg(String paramString)
  {
    AppMethodBeat.i(94821);
    this.iSS = F("publishId", paramString, true);
    AppMethodBeat.o(94821);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.jj
 * JD-Core Version:    0.7.0.1
 */