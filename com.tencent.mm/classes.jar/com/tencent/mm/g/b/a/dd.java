package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class dd
  extends a
{
  private String _ID;
  private long dWt;
  private long dYY;
  private long efB;
  private long efC;
  private long efD;
  private long efE;
  private long efF;
  private long efG;
  private String efH;
  private String efI;
  private long efJ;
  private long efK;
  private String efL;
  private String efM;
  public long efN;
  private long efO;
  private long efP;
  private String efQ;
  private String efR;
  private String efS;
  private long efT;
  private String efU;
  private String efV;
  private String efW;
  public long efX;
  
  public dd()
  {
    this._ID = "";
    this.dYY = 0L;
    this.efB = 0L;
    this.efC = 0L;
    this.efD = 0L;
    this.efE = 0L;
    this.efF = 0L;
    this.efG = 0L;
    this.efH = "";
    this.efI = "";
    this.efJ = 0L;
    this.efK = 0L;
    this.efL = "";
    this.efM = "";
    this.efN = 0L;
    this.dWt = 0L;
    this.efO = 0L;
    this.efP = 0L;
    this.efQ = "";
    this.efR = "";
    this.efS = "";
    this.efT = 0L;
    this.efU = "";
    this.efV = "";
    this.efW = "";
    this.efX = 0L;
  }
  
  public dd(String paramString)
  {
    AppMethodBeat.i(94820);
    this._ID = "";
    this.dYY = 0L;
    this.efB = 0L;
    this.efC = 0L;
    this.efD = 0L;
    this.efE = 0L;
    this.efF = 0L;
    this.efG = 0L;
    this.efH = "";
    this.efI = "";
    this.efJ = 0L;
    this.efK = 0L;
    this.efL = "";
    this.efM = "";
    this.efN = 0L;
    this.dWt = 0L;
    this.efO = 0L;
    this.efP = 0L;
    this.efQ = "";
    this.efR = "";
    this.efS = "";
    this.efT = 0L;
    this.efU = "";
    this.efV = "";
    this.efW = "";
    this.efX = 0L;
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
      this._ID = t("ID", paramString[0], true);
      this.dYY = bu.getLong(paramString[1], 0L);
      this.efB = bu.getLong(paramString[2], 0L);
      this.efC = bu.getLong(paramString[3], 0L);
      this.efD = bu.getLong(paramString[4], 0L);
      this.efE = bu.getLong(paramString[5], 0L);
      this.efF = bu.getLong(paramString[6], 0L);
      this.efG = bu.getLong(paramString[7], 0L);
      this.efH = t("FNumber", paramString[8], true);
      this.efI = t("ExposureTime", paramString[9], true);
      this.efJ = bu.getLong(paramString[10], 0L);
      this.efK = bu.getLong(paramString[11], 0L);
      this.efL = t("LensModel", paramString[12], true);
      this.efM = t("CreatTime", paramString[13], true);
      this.efN = bu.getLong(paramString[14], 0L);
      this.dWt = bu.getLong(paramString[15], 0L);
      this.efO = bu.getLong(paramString[16], 0L);
      this.efP = bu.getLong(paramString[17], 0L);
      this.efQ = t("make", paramString[18], true);
      this.efR = t("software", paramString[19], true);
      this.efS = t("fileExt", paramString[20], true);
      this.efT = bu.getLong(paramString[21], 0L);
      this.efU = t("YCbCrSubSampling", paramString[22], true);
      this.efV = t("md5", paramString[23], true);
      mJ(paramString[24]);
      this.efX = bu.getLong(paramString[25], 0L);
      AppMethodBeat.o(94820);
      return;
    }
  }
  
  public final String RC()
  {
    AppMethodBeat.i(94822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this._ID);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dWt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efX);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(94822);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94823);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ID:").append(this._ID);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.dYY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginWidth:").append(this.efB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginHeight:").append(this.efC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedWidth:").append(this.efD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedHeight:").append(this.efE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.efF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedSize:").append(this.efG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FNumber:").append(this.efH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposureTime:").append(this.efI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ISO:").append(this.efJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Flash:").append(this.efK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LensModel:").append(this.efL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatTime:").append(this.efM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFromWeChat:").append(this.efN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dWt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneType:").append(this.efO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSource:").append(this.efP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("make:").append(this.efQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("software:").append(this.efR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileExt:").append(this.efS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("faceCount:").append(this.efT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("YCbCrSubSampling:").append(this.efU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.efV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("publishId:").append(this.efW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("destMeidaType:").append(this.efX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94823);
    return localObject;
  }
  
  public final int getId()
  {
    return 16585;
  }
  
  public final dd mJ(String paramString)
  {
    AppMethodBeat.i(94821);
    this.efW = t("publishId", paramString, true);
    AppMethodBeat.o(94821);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dd
 * JD-Core Version:    0.7.0.1
 */