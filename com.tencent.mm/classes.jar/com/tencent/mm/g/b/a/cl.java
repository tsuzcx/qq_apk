package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class cl
  extends a
{
  private String _ID;
  private long dHY;
  private long dJN;
  private long dOM;
  private long dON;
  private long dOO;
  private long dOP;
  private long dOQ;
  private long dOR;
  private String dOS;
  private String dOT;
  private long dOU;
  private long dOV;
  private String dOW;
  private String dOX;
  public long dOY;
  private long dOZ;
  private long dPa;
  private String dPb;
  private String dPc;
  private String dPd;
  private long dPe;
  private String dPf;
  private String dPg;
  private String dPh;
  public long dPi;
  
  public cl()
  {
    this._ID = "";
    this.dJN = 0L;
    this.dOM = 0L;
    this.dON = 0L;
    this.dOO = 0L;
    this.dOP = 0L;
    this.dOQ = 0L;
    this.dOR = 0L;
    this.dOS = "";
    this.dOT = "";
    this.dOU = 0L;
    this.dOV = 0L;
    this.dOW = "";
    this.dOX = "";
    this.dOY = 0L;
    this.dHY = 0L;
    this.dOZ = 0L;
    this.dPa = 0L;
    this.dPb = "";
    this.dPc = "";
    this.dPd = "";
    this.dPe = 0L;
    this.dPf = "";
    this.dPg = "";
    this.dPh = "";
    this.dPi = 0L;
  }
  
  public cl(String paramString)
  {
    AppMethodBeat.i(94820);
    this._ID = "";
    this.dJN = 0L;
    this.dOM = 0L;
    this.dON = 0L;
    this.dOO = 0L;
    this.dOP = 0L;
    this.dOQ = 0L;
    this.dOR = 0L;
    this.dOS = "";
    this.dOT = "";
    this.dOU = 0L;
    this.dOV = 0L;
    this.dOW = "";
    this.dOX = "";
    this.dOY = 0L;
    this.dHY = 0L;
    this.dOZ = 0L;
    this.dPa = 0L;
    this.dPb = "";
    this.dPc = "";
    this.dPd = "";
    this.dPe = 0L;
    this.dPf = "";
    this.dPg = "";
    this.dPh = "";
    this.dPi = 0L;
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
      this.dJN = bs.getLong(paramString[1], 0L);
      this.dOM = bs.getLong(paramString[2], 0L);
      this.dON = bs.getLong(paramString[3], 0L);
      this.dOO = bs.getLong(paramString[4], 0L);
      this.dOP = bs.getLong(paramString[5], 0L);
      this.dOQ = bs.getLong(paramString[6], 0L);
      this.dOR = bs.getLong(paramString[7], 0L);
      this.dOS = t("FNumber", paramString[8], true);
      this.dOT = t("ExposureTime", paramString[9], true);
      this.dOU = bs.getLong(paramString[10], 0L);
      this.dOV = bs.getLong(paramString[11], 0L);
      this.dOW = t("LensModel", paramString[12], true);
      this.dOX = t("CreatTime", paramString[13], true);
      this.dOY = bs.getLong(paramString[14], 0L);
      this.dHY = bs.getLong(paramString[15], 0L);
      this.dOZ = bs.getLong(paramString[16], 0L);
      this.dPa = bs.getLong(paramString[17], 0L);
      this.dPb = t("make", paramString[18], true);
      this.dPc = t("software", paramString[19], true);
      this.dPd = t("fileExt", paramString[20], true);
      this.dPe = bs.getLong(paramString[21], 0L);
      this.dPf = t("YCbCrSubSampling", paramString[22], true);
      this.dPg = t("md5", paramString[23], true);
      kv(paramString[24]);
      this.dPi = bs.getLong(paramString[25], 0L);
      AppMethodBeat.o(94820);
      return;
    }
  }
  
  public final String PR()
  {
    AppMethodBeat.i(94822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this._ID);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dJN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dON);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dHY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPi);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(94822);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(94823);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ID:").append(this._ID);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.dJN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginWidth:").append(this.dOM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginHeight:").append(this.dON);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedWidth:").append(this.dOO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedHeight:").append(this.dOP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.dOQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedSize:").append(this.dOR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FNumber:").append(this.dOS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposureTime:").append(this.dOT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ISO:").append(this.dOU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Flash:").append(this.dOV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LensModel:").append(this.dOW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatTime:").append(this.dOX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFromWeChat:").append(this.dOY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dHY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneType:").append(this.dOZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSource:").append(this.dPa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("make:").append(this.dPb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("software:").append(this.dPc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileExt:").append(this.dPd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("faceCount:").append(this.dPe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("YCbCrSubSampling:").append(this.dPf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.dPg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("publishId:").append(this.dPh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("destMeidaType:").append(this.dPi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94823);
    return localObject;
  }
  
  public final int getId()
  {
    return 16585;
  }
  
  public final cl kv(String paramString)
  {
    AppMethodBeat.i(94821);
    this.dPh = t("publishId", paramString, true);
    AppMethodBeat.o(94821);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cl
 * JD-Core Version:    0.7.0.1
 */