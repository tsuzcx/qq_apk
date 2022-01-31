package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class z
  extends a
{
  private String cQA;
  private String cQB;
  private String cQD;
  private long cQE;
  private long cQF;
  private String cQN;
  private String cQR;
  private String cQx;
  private String cQy;
  private long cTU;
  private long cTV;
  private int cTW;
  private long cTX;
  private long cTY;
  
  public z()
  {
    this.cQE = 0L;
    this.cQF = 0L;
    this.cTU = 0L;
    this.cQD = "";
    this.cTV = 0L;
    this.cTW = 0;
    this.cTX = 0L;
    this.cQN = "";
    this.cQx = "";
    this.cQy = "";
    this.cTY = 0L;
    this.cQA = "";
    this.cQB = "";
    this.cQR = "";
  }
  
  public z(String paramString)
  {
    AppMethodBeat.i(50537);
    this.cQE = 0L;
    this.cQF = 0L;
    this.cTU = 0L;
    this.cQD = "";
    this.cTV = 0L;
    this.cTW = 0;
    this.cTX = 0L;
    this.cQN = "";
    this.cQx = "";
    this.cQy = "";
    this.cTY = 0L;
    this.cQA = "";
    this.cQB = "";
    this.cQR = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 14) {
          break label323;
        }
        String[] arrayOfString = new String[14];
        Arrays.fill(arrayOfString, 0, 14, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label323:
    for (;;)
    {
      this.cQE = bo.getLong(paramString[0], 0L);
      this.cQF = bo.getLong(paramString[1], 0L);
      this.cTU = bo.getLong(paramString[2], 0L);
      this.cQD = t("NewMd5", paramString[3], true);
      this.cTV = bo.getLong(paramString[4], 0L);
      this.cTW = bo.getInt(paramString[5], 0);
      this.cTX = bo.getLong(paramString[6], 0L);
      this.cQN = t("CDNIp", paramString[7], true);
      this.cQx = t("FromUser", paramString[8], true);
      this.cQy = t("Session", paramString[9], true);
      this.cTY = bo.getLong(paramString[10], 0L);
      this.cQA = t("FileId", paramString[11], true);
      this.cQB = t("SnsUrl", paramString[12], true);
      this.cQR = t("Publishid", paramString[13], true);
      AppMethodBeat.o(50537);
      return;
    }
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(50538);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cQE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cTY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQR);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(50538);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(50539);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.cQE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.cQF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSize:").append(this.cTU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.cQD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.cTV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSpeed:").append(this.cTW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadFinishSize:").append(this.cTX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.cQN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromUser:").append(this.cQx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.cQy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomNum:").append(this.cTY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.cQA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.cQB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.cQR);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(50539);
    return localObject;
  }
  
  public final int getId()
  {
    return 14499;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.z
 * JD-Core Version:    0.7.0.1
 */