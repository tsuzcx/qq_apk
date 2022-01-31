package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class r
  extends a
{
  private String _ID;
  private long cRG;
  private String cSA;
  private String cSB;
  private long cSC;
  private String cSD;
  private String cSE;
  private String cSF;
  private long cSj;
  private long cSk;
  private long cSl;
  private long cSm;
  private long cSn;
  private long cSo;
  private long cSp;
  private String cSq;
  private String cSr;
  private long cSs;
  private long cSt;
  private String cSu;
  private String cSv;
  public long cSw;
  private long cSx;
  private long cSy;
  private String cSz;
  
  public r()
  {
    this._ID = "";
    this.cSj = 0L;
    this.cSk = 0L;
    this.cSl = 0L;
    this.cSm = 0L;
    this.cSn = 0L;
    this.cSo = 0L;
    this.cSp = 0L;
    this.cSq = "";
    this.cSr = "";
    this.cSs = 0L;
    this.cSt = 0L;
    this.cSu = "";
    this.cSv = "";
    this.cSw = 0L;
    this.cRG = 0L;
    this.cSx = 0L;
    this.cSy = 0L;
    this.cSz = "";
    this.cSA = "";
    this.cSB = "";
    this.cSC = 0L;
    this.cSD = "";
    this.cSE = "";
    this.cSF = "";
  }
  
  public r(String paramString)
  {
    AppMethodBeat.i(35556);
    this._ID = "";
    this.cSj = 0L;
    this.cSk = 0L;
    this.cSl = 0L;
    this.cSm = 0L;
    this.cSn = 0L;
    this.cSo = 0L;
    this.cSp = 0L;
    this.cSq = "";
    this.cSr = "";
    this.cSs = 0L;
    this.cSt = 0L;
    this.cSu = "";
    this.cSv = "";
    this.cSw = 0L;
    this.cRG = 0L;
    this.cSx = 0L;
    this.cSy = 0L;
    this.cSz = "";
    this.cSA = "";
    this.cSB = "";
    this.cSC = 0L;
    this.cSD = "";
    this.cSE = "";
    this.cSF = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 25) {
          break label520;
        }
        String[] arrayOfString = new String[25];
        Arrays.fill(arrayOfString, 0, 25, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label520:
    for (;;)
    {
      this._ID = t("ID", paramString[0], true);
      this.cSj = bo.getLong(paramString[1], 0L);
      this.cSk = bo.getLong(paramString[2], 0L);
      this.cSl = bo.getLong(paramString[3], 0L);
      this.cSm = bo.getLong(paramString[4], 0L);
      this.cSn = bo.getLong(paramString[5], 0L);
      this.cSo = bo.getLong(paramString[6], 0L);
      this.cSp = bo.getLong(paramString[7], 0L);
      this.cSq = t("FNumber", paramString[8], true);
      this.cSr = t("ExposureTime", paramString[9], true);
      this.cSs = bo.getLong(paramString[10], 0L);
      this.cSt = bo.getLong(paramString[11], 0L);
      this.cSu = t("LensModel", paramString[12], true);
      this.cSv = t("CreatTime", paramString[13], true);
      this.cSw = bo.getLong(paramString[14], 0L);
      this.cRG = bo.getLong(paramString[15], 0L);
      this.cSx = bo.getLong(paramString[16], 0L);
      this.cSy = bo.getLong(paramString[17], 0L);
      this.cSz = t("make", paramString[18], true);
      this.cSA = t("software", paramString[19], true);
      this.cSB = t("fileExt", paramString[20], true);
      this.cSC = bo.getLong(paramString[21], 0L);
      this.cSD = t("YCbCrSubSampling", paramString[22], true);
      this.cSE = t("md5", paramString[23], true);
      fo(paramString[24]);
      AppMethodBeat.o(35556);
      return;
    }
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(35558);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this._ID);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cRG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSF);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(35558);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(35559);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ID:").append(this._ID);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.cSj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginWidth:").append(this.cSk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginHeight:").append(this.cSl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedWidth:").append(this.cSm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedHeight:").append(this.cSn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.cSo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedSize:").append(this.cSp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FNumber:").append(this.cSq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposureTime:").append(this.cSr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ISO:").append(this.cSs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Flash:").append(this.cSt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LensModel:").append(this.cSu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatTime:").append(this.cSv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFromWeChat:").append(this.cSw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.cRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneType:").append(this.cSx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSource:").append(this.cSy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("make:").append(this.cSz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("software:").append(this.cSA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileExt:").append(this.cSB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("faceCount:").append(this.cSC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("YCbCrSubSampling:").append(this.cSD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.cSE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("publishId:").append(this.cSF);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(35559);
    return localObject;
  }
  
  public final r fo(String paramString)
  {
    AppMethodBeat.i(35557);
    this.cSF = t("publishId", paramString, true);
    AppMethodBeat.o(35557);
    return this;
  }
  
  public final int getId()
  {
    return 16585;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.r
 * JD-Core Version:    0.7.0.1
 */