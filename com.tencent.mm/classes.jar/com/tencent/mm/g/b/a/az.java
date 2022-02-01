package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class az
  extends a
{
  private String _ID;
  private long dKe;
  private String dNA;
  private String dNB;
  private long dNC;
  private String dND;
  private String dNE;
  private String dNF;
  public long dNG;
  private long dNj;
  private long dNk;
  private long dNl;
  private long dNm;
  private long dNn;
  private long dNo;
  private long dNp;
  private String dNq;
  private String dNr;
  private long dNs;
  private long dNt;
  private String dNu;
  private String dNv;
  public long dNw;
  private long dNx;
  private long dNy;
  private String dNz;
  
  public az()
  {
    this._ID = "";
    this.dNj = 0L;
    this.dNk = 0L;
    this.dNl = 0L;
    this.dNm = 0L;
    this.dNn = 0L;
    this.dNo = 0L;
    this.dNp = 0L;
    this.dNq = "";
    this.dNr = "";
    this.dNs = 0L;
    this.dNt = 0L;
    this.dNu = "";
    this.dNv = "";
    this.dNw = 0L;
    this.dKe = 0L;
    this.dNx = 0L;
    this.dNy = 0L;
    this.dNz = "";
    this.dNA = "";
    this.dNB = "";
    this.dNC = 0L;
    this.dND = "";
    this.dNE = "";
    this.dNF = "";
    this.dNG = 0L;
  }
  
  public az(String paramString)
  {
    AppMethodBeat.i(94820);
    this._ID = "";
    this.dNj = 0L;
    this.dNk = 0L;
    this.dNl = 0L;
    this.dNm = 0L;
    this.dNn = 0L;
    this.dNo = 0L;
    this.dNp = 0L;
    this.dNq = "";
    this.dNr = "";
    this.dNs = 0L;
    this.dNt = 0L;
    this.dNu = "";
    this.dNv = "";
    this.dNw = 0L;
    this.dKe = 0L;
    this.dNx = 0L;
    this.dNy = 0L;
    this.dNz = "";
    this.dNA = "";
    this.dNB = "";
    this.dNC = 0L;
    this.dND = "";
    this.dNE = "";
    this.dNF = "";
    this.dNG = 0L;
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
      this.dNj = bt.getLong(paramString[1], 0L);
      this.dNk = bt.getLong(paramString[2], 0L);
      this.dNl = bt.getLong(paramString[3], 0L);
      this.dNm = bt.getLong(paramString[4], 0L);
      this.dNn = bt.getLong(paramString[5], 0L);
      this.dNo = bt.getLong(paramString[6], 0L);
      this.dNp = bt.getLong(paramString[7], 0L);
      this.dNq = t("FNumber", paramString[8], true);
      this.dNr = t("ExposureTime", paramString[9], true);
      this.dNs = bt.getLong(paramString[10], 0L);
      this.dNt = bt.getLong(paramString[11], 0L);
      this.dNu = t("LensModel", paramString[12], true);
      this.dNv = t("CreatTime", paramString[13], true);
      this.dNw = bt.getLong(paramString[14], 0L);
      this.dKe = bt.getLong(paramString[15], 0L);
      this.dNx = bt.getLong(paramString[16], 0L);
      this.dNy = bt.getLong(paramString[17], 0L);
      this.dNz = t("make", paramString[18], true);
      this.dNA = t("software", paramString[19], true);
      this.dNB = t("fileExt", paramString[20], true);
      this.dNC = bt.getLong(paramString[21], 0L);
      this.dND = t("YCbCrSubSampling", paramString[22], true);
      this.dNE = t("md5", paramString[23], true);
      hT(paramString[24]);
      this.dNG = bt.getLong(paramString[25], 0L);
      AppMethodBeat.o(94820);
      return;
    }
  }
  
  public final String PV()
  {
    AppMethodBeat.i(94822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this._ID);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dND);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNG);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(94822);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(94823);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ID:").append(this._ID);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.dNj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginWidth:").append(this.dNk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginHeight:").append(this.dNl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedWidth:").append(this.dNm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedHeight:").append(this.dNn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.dNo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedSize:").append(this.dNp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FNumber:").append(this.dNq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposureTime:").append(this.dNr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ISO:").append(this.dNs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Flash:").append(this.dNt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LensModel:").append(this.dNu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatTime:").append(this.dNv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFromWeChat:").append(this.dNw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dKe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneType:").append(this.dNx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSource:").append(this.dNy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("make:").append(this.dNz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("software:").append(this.dNA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileExt:").append(this.dNB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("faceCount:").append(this.dNC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("YCbCrSubSampling:").append(this.dND);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.dNE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("publishId:").append(this.dNF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("destMeidaType:").append(this.dNG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94823);
    return localObject;
  }
  
  public final int getId()
  {
    return 16585;
  }
  
  public final az hT(String paramString)
  {
    AppMethodBeat.i(94821);
    this.dNF = t("publishId", paramString, true);
    AppMethodBeat.o(94821);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.az
 * JD-Core Version:    0.7.0.1
 */