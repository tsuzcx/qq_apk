package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class fs
  extends a
{
  private String _ID;
  private long eGY;
  private long eGZ;
  private long eHa;
  private long eHb;
  private long eHc;
  private long eHd;
  private String eHe;
  private String eHf;
  private long eHg;
  private long eHh;
  private String eHi;
  private String eHj;
  public long eHk;
  private long eHl;
  private long eHm;
  private String eHn;
  private String eHo;
  private String eHp;
  private long eHq;
  private String eHr;
  private String eHs;
  private String eHt;
  public long eHu;
  private long erW;
  private long euQ;
  
  public fs()
  {
    this._ID = "";
    this.euQ = 0L;
    this.eGY = 0L;
    this.eGZ = 0L;
    this.eHa = 0L;
    this.eHb = 0L;
    this.eHc = 0L;
    this.eHd = 0L;
    this.eHe = "";
    this.eHf = "";
    this.eHg = 0L;
    this.eHh = 0L;
    this.eHi = "";
    this.eHj = "";
    this.eHk = 0L;
    this.erW = 0L;
    this.eHl = 0L;
    this.eHm = 0L;
    this.eHn = "";
    this.eHo = "";
    this.eHp = "";
    this.eHq = 0L;
    this.eHr = "";
    this.eHs = "";
    this.eHt = "";
    this.eHu = 0L;
  }
  
  public fs(String paramString)
  {
    AppMethodBeat.i(94820);
    this._ID = "";
    this.euQ = 0L;
    this.eGY = 0L;
    this.eGZ = 0L;
    this.eHa = 0L;
    this.eHb = 0L;
    this.eHc = 0L;
    this.eHd = 0L;
    this.eHe = "";
    this.eHf = "";
    this.eHg = 0L;
    this.eHh = 0L;
    this.eHi = "";
    this.eHj = "";
    this.eHk = 0L;
    this.erW = 0L;
    this.eHl = 0L;
    this.eHm = 0L;
    this.eHn = "";
    this.eHo = "";
    this.eHp = "";
    this.eHq = 0L;
    this.eHr = "";
    this.eHs = "";
    this.eHt = "";
    this.eHu = 0L;
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
      this._ID = x("ID", paramString[0], true);
      this.euQ = Util.getLong(paramString[1], 0L);
      this.eGY = Util.getLong(paramString[2], 0L);
      this.eGZ = Util.getLong(paramString[3], 0L);
      this.eHa = Util.getLong(paramString[4], 0L);
      this.eHb = Util.getLong(paramString[5], 0L);
      this.eHc = Util.getLong(paramString[6], 0L);
      this.eHd = Util.getLong(paramString[7], 0L);
      this.eHe = x("FNumber", paramString[8], true);
      this.eHf = x("ExposureTime", paramString[9], true);
      this.eHg = Util.getLong(paramString[10], 0L);
      this.eHh = Util.getLong(paramString[11], 0L);
      this.eHi = x("LensModel", paramString[12], true);
      this.eHj = x("CreatTime", paramString[13], true);
      this.eHk = Util.getLong(paramString[14], 0L);
      this.erW = Util.getLong(paramString[15], 0L);
      this.eHl = Util.getLong(paramString[16], 0L);
      this.eHm = Util.getLong(paramString[17], 0L);
      this.eHn = x("make", paramString[18], true);
      this.eHo = x("software", paramString[19], true);
      this.eHp = x("fileExt", paramString[20], true);
      this.eHq = Util.getLong(paramString[21], 0L);
      this.eHr = x("YCbCrSubSampling", paramString[22], true);
      this.eHs = x("md5", paramString[23], true);
      sJ(paramString[24]);
      this.eHu = Util.getLong(paramString[25], 0L);
      AppMethodBeat.o(94820);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(94822);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this._ID);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.euQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eGZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHu);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(94822);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(94823);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ID:").append(this._ID);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MediaType:").append(this.euQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginWidth:").append(this.eGY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginHeight:").append(this.eGZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedWidth:").append(this.eHa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedHeight:").append(this.eHb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginSize:").append(this.eHc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CompressedSize:").append(this.eHd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FNumber:").append(this.eHe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposureTime:").append(this.eHf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ISO:").append(this.eHg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Flash:").append(this.eHh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LensModel:").append(this.eHi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreatTime:").append(this.eHj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsFromWeChat:").append(this.eHk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.erW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sceneType:").append(this.eHl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileSource:").append(this.eHm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("make:").append(this.eHn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("software:").append(this.eHo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("fileExt:").append(this.eHp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("faceCount:").append(this.eHq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("YCbCrSubSampling:").append(this.eHr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("md5:").append(this.eHs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("publishId:").append(this.eHt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("destMeidaType:").append(this.eHu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94823);
    return localObject;
  }
  
  public final int getId()
  {
    return 16585;
  }
  
  public final fs sJ(String paramString)
  {
    AppMethodBeat.i(94821);
    this.eHt = x("publishId", paramString, true);
    AppMethodBeat.o(94821);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fs
 * JD-Core Version:    0.7.0.1
 */