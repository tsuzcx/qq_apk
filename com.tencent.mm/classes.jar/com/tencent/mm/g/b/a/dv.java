package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class dv
  extends a
{
  private String dTD;
  private String dTj;
  private String dTk;
  private String dTm;
  private String dTn;
  private String dTp;
  private long dTq;
  private long dTr;
  private String dTz;
  private long ehd;
  private long ehe;
  private int ehf;
  private long ehg;
  private long ehh;
  
  public dv()
  {
    this.dTq = 0L;
    this.dTr = 0L;
    this.ehd = 0L;
    this.dTp = "";
    this.ehe = 0L;
    this.ehf = 0;
    this.ehg = 0L;
    this.dTz = "";
    this.dTj = "";
    this.dTk = "";
    this.ehh = 0L;
    this.dTm = "";
    this.dTn = "";
    this.dTD = "";
  }
  
  public dv(String paramString)
  {
    AppMethodBeat.i(126687);
    this.dTq = 0L;
    this.dTr = 0L;
    this.ehd = 0L;
    this.dTp = "";
    this.ehe = 0L;
    this.ehf = 0;
    this.ehg = 0L;
    this.dTz = "";
    this.dTj = "";
    this.dTk = "";
    this.ehh = 0L;
    this.dTm = "";
    this.dTn = "";
    this.dTD = "";
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
      this.dTq = bt.getLong(paramString[0], 0L);
      this.dTr = bt.getLong(paramString[1], 0L);
      this.ehd = bt.getLong(paramString[2], 0L);
      this.dTp = t("NewMd5", paramString[3], true);
      this.ehe = bt.getLong(paramString[4], 0L);
      this.ehf = bt.getInt(paramString[5], 0);
      this.ehg = bt.getLong(paramString[6], 0L);
      this.dTz = t("CDNIp", paramString[7], true);
      this.dTj = t("FromUser", paramString[8], true);
      this.dTk = t("Session", paramString[9], true);
      this.ehh = bt.getLong(paramString[10], 0L);
      this.dTm = t("FileId", paramString[11], true);
      this.dTn = t("SnsUrl", paramString[12], true);
      this.dTD = t("Publishid", paramString[13], true);
      AppMethodBeat.o(126687);
      return;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(126688);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTD);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(126688);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(126689);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSize:").append(this.ehd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dTp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.ehe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSpeed:").append(this.ehf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadFinishSize:").append(this.ehg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dTz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromUser:").append(this.dTj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.dTk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomNum:").append(this.ehh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.dTm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dTn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.dTD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126689);
    return localObject;
  }
  
  public final int getId()
  {
    return 14499;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dv
 * JD-Core Version:    0.7.0.1
 */