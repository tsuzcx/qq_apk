package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class dc
  extends a
{
  private String dGe;
  private String dGf;
  private String dGh;
  private String dGi;
  private String dGk;
  private long dGl;
  private long dGm;
  private String dGu;
  private String dGy;
  private long dRG;
  private long dRH;
  private int dRI;
  private long dRJ;
  private long dRK;
  
  public dc()
  {
    this.dGl = 0L;
    this.dGm = 0L;
    this.dRG = 0L;
    this.dGk = "";
    this.dRH = 0L;
    this.dRI = 0;
    this.dRJ = 0L;
    this.dGu = "";
    this.dGe = "";
    this.dGf = "";
    this.dRK = 0L;
    this.dGh = "";
    this.dGi = "";
    this.dGy = "";
  }
  
  public dc(String paramString)
  {
    AppMethodBeat.i(126687);
    this.dGl = 0L;
    this.dGm = 0L;
    this.dRG = 0L;
    this.dGk = "";
    this.dRH = 0L;
    this.dRI = 0;
    this.dRJ = 0L;
    this.dGu = "";
    this.dGe = "";
    this.dGf = "";
    this.dRK = 0L;
    this.dGh = "";
    this.dGi = "";
    this.dGy = "";
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
      this.dGl = bs.getLong(paramString[0], 0L);
      this.dGm = bs.getLong(paramString[1], 0L);
      this.dRG = bs.getLong(paramString[2], 0L);
      this.dGk = t("NewMd5", paramString[3], true);
      this.dRH = bs.getLong(paramString[4], 0L);
      this.dRI = bs.getInt(paramString[5], 0);
      this.dRJ = bs.getLong(paramString[6], 0L);
      this.dGu = t("CDNIp", paramString[7], true);
      this.dGe = t("FromUser", paramString[8], true);
      this.dGf = t("Session", paramString[9], true);
      this.dRK = bs.getLong(paramString[10], 0L);
      this.dGh = t("FileId", paramString[11], true);
      this.dGi = t("SnsUrl", paramString[12], true);
      this.dGy = t("Publishid", paramString[13], true);
      AppMethodBeat.o(126687);
      return;
    }
  }
  
  public final String PR()
  {
    AppMethodBeat.i(126688);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGy);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(126688);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(126689);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dGl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dGm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSize:").append(this.dRG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dGk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.dRH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSpeed:").append(this.dRI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadFinishSize:").append(this.dRJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dGu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromUser:").append(this.dGe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.dGf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomNum:").append(this.dRK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.dGh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dGi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.dGy);
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
 * Qualified Name:     com.tencent.mm.g.b.a.dc
 * JD-Core Version:    0.7.0.1
 */