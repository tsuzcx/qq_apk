package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class hl
  extends a
{
  private long gFA;
  private long gFB;
  private long gFC;
  private long gFD;
  private long gFE;
  private String gFF;
  private String gFG;
  private long gFH;
  private long gFI;
  private String gFJ;
  private String gFK;
  public long gFL;
  private long gFM;
  private long gFN;
  private String gFO;
  private String gFP;
  private String gFQ;
  private long gFR;
  private String gFS;
  private String gFT;
  private String gFU;
  public long gFV;
  private String gFy;
  private long gFz;
  private long gnP;
  private long gqU;
  
  public hl()
  {
    this.gFy = "";
    this.gqU = 0L;
    this.gFz = 0L;
    this.gFA = 0L;
    this.gFB = 0L;
    this.gFC = 0L;
    this.gFD = 0L;
    this.gFE = 0L;
    this.gFF = "";
    this.gFG = "";
    this.gFH = 0L;
    this.gFI = 0L;
    this.gFJ = "";
    this.gFK = "";
    this.gFL = 0L;
    this.gnP = 0L;
    this.gFM = 0L;
    this.gFN = 0L;
    this.gFO = "";
    this.gFP = "";
    this.gFQ = "";
    this.gFR = 0L;
    this.gFS = "";
    this.gFT = "";
    this.gFU = "";
    this.gFV = 0L;
  }
  
  public hl(String paramString)
  {
    AppMethodBeat.i(94820);
    this.gFy = "";
    this.gqU = 0L;
    this.gFz = 0L;
    this.gFA = 0L;
    this.gFB = 0L;
    this.gFC = 0L;
    this.gFD = 0L;
    this.gFE = 0L;
    this.gFF = "";
    this.gFG = "";
    this.gFH = 0L;
    this.gFI = 0L;
    this.gFJ = "";
    this.gFK = "";
    this.gFL = 0L;
    this.gnP = 0L;
    this.gFM = 0L;
    this.gFN = 0L;
    this.gFO = "";
    this.gFP = "";
    this.gFQ = "";
    this.gFR = 0L;
    this.gFS = "";
    this.gFT = "";
    this.gFU = "";
    this.gFV = 0L;
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
      this.gFy = z("ID", paramString[0], true);
      this.gqU = Util.getLong(paramString[1], 0L);
      this.gFz = Util.getLong(paramString[2], 0L);
      this.gFA = Util.getLong(paramString[3], 0L);
      this.gFB = Util.getLong(paramString[4], 0L);
      this.gFC = Util.getLong(paramString[5], 0L);
      this.gFD = Util.getLong(paramString[6], 0L);
      this.gFE = Util.getLong(paramString[7], 0L);
      this.gFF = z("FNumber", paramString[8], true);
      this.gFG = z("ExposureTime", paramString[9], true);
      this.gFH = Util.getLong(paramString[10], 0L);
      this.gFI = Util.getLong(paramString[11], 0L);
      this.gFJ = z("LensModel", paramString[12], true);
      this.gFK = z("CreatTime", paramString[13], true);
      this.gFL = Util.getLong(paramString[14], 0L);
      this.gnP = Util.getLong(paramString[15], 0L);
      this.gFM = Util.getLong(paramString[16], 0L);
      this.gFN = Util.getLong(paramString[17], 0L);
      this.gFO = z("make", paramString[18], true);
      this.gFP = z("software", paramString[19], true);
      this.gFQ = z("fileExt", paramString[20], true);
      this.gFR = Util.getLong(paramString[21], 0L);
      this.gFS = z("YCbCrSubSampling", paramString[22], true);
      this.gFT = z("md5", paramString[23], true);
      wx(paramString[24]);
      this.gFV = Util.getLong(paramString[25], 0L);
      AppMethodBeat.o(94820);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(94822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gFy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gqU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFV);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(94822);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(94823);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ID:").append(this.gFy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.gqU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginWidth:").append(this.gFz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginHeight:").append(this.gFA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedWidth:").append(this.gFB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedHeight:").append(this.gFC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.gFD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedSize:").append(this.gFE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FNumber:").append(this.gFF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposureTime:").append(this.gFG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ISO:").append(this.gFH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Flash:").append(this.gFI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LensModel:").append(this.gFJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatTime:").append(this.gFK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFromWeChat:").append(this.gFL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneType:").append(this.gFM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSource:").append(this.gFN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("make:").append(this.gFO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("software:").append(this.gFP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileExt:").append(this.gFQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("faceCount:").append(this.gFR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("YCbCrSubSampling:").append(this.gFS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.gFT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("publishId:").append(this.gFU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("destMeidaType:").append(this.gFV);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94823);
    return localObject;
  }
  
  public final int getId()
  {
    return 16585;
  }
  
  public final hl wx(String paramString)
  {
    AppMethodBeat.i(94821);
    this.gFU = z("publishId", paramString, true);
    AppMethodBeat.o(94821);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hl
 * JD-Core Version:    0.7.0.1
 */