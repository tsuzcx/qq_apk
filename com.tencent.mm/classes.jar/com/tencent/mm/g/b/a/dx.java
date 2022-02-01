package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class dx
  extends a
{
  private String dUA;
  private String dUC;
  private String dUD;
  private String dUF;
  private long dUG;
  private long dUH;
  private String dUP;
  private String dUT;
  private String dUz;
  private long eiN;
  private long eiO;
  private int eiP;
  private long eiQ;
  private long eiR;
  
  public dx()
  {
    this.dUG = 0L;
    this.dUH = 0L;
    this.eiN = 0L;
    this.dUF = "";
    this.eiO = 0L;
    this.eiP = 0;
    this.eiQ = 0L;
    this.dUP = "";
    this.dUz = "";
    this.dUA = "";
    this.eiR = 0L;
    this.dUC = "";
    this.dUD = "";
    this.dUT = "";
  }
  
  public dx(String paramString)
  {
    AppMethodBeat.i(126687);
    this.dUG = 0L;
    this.dUH = 0L;
    this.eiN = 0L;
    this.dUF = "";
    this.eiO = 0L;
    this.eiP = 0;
    this.eiQ = 0L;
    this.dUP = "";
    this.dUz = "";
    this.dUA = "";
    this.eiR = 0L;
    this.dUC = "";
    this.dUD = "";
    this.dUT = "";
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
      this.dUG = bu.getLong(paramString[0], 0L);
      this.dUH = bu.getLong(paramString[1], 0L);
      this.eiN = bu.getLong(paramString[2], 0L);
      this.dUF = t("NewMd5", paramString[3], true);
      this.eiO = bu.getLong(paramString[4], 0L);
      this.eiP = bu.getInt(paramString[5], 0);
      this.eiQ = bu.getLong(paramString[6], 0L);
      this.dUP = t("CDNIp", paramString[7], true);
      this.dUz = t("FromUser", paramString[8], true);
      this.dUA = t("Session", paramString[9], true);
      this.eiR = bu.getLong(paramString[10], 0L);
      this.dUC = t("FileId", paramString[11], true);
      this.dUD = t("SnsUrl", paramString[12], true);
      this.dUT = t("Publishid", paramString[13], true);
      AppMethodBeat.o(126687);
      return;
    }
  }
  
  public final String RC()
  {
    AppMethodBeat.i(126688);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dUG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUT);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(126688);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(126689);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dUG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dUH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSize:").append(this.eiN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dUF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.eiO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSpeed:").append(this.eiP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadFinishSize:").append(this.eiQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dUP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromUser:").append(this.dUz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.dUA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomNum:").append(this.eiR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.dUC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dUD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.dUT);
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
 * Qualified Name:     com.tencent.mm.g.b.a.dx
 * JD-Core Version:    0.7.0.1
 */