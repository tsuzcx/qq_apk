package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class bo
  extends a
{
  private String dIc;
  private String dId;
  private String dIf;
  private String dIg;
  private String dIi;
  private long dIj;
  private long dIk;
  private String dIs;
  private String dIw;
  private long dPP;
  private long dPQ;
  private int dPR;
  private long dPS;
  private long dPT;
  
  public bo()
  {
    this.dIj = 0L;
    this.dIk = 0L;
    this.dPP = 0L;
    this.dIi = "";
    this.dPQ = 0L;
    this.dPR = 0;
    this.dPS = 0L;
    this.dIs = "";
    this.dIc = "";
    this.dId = "";
    this.dPT = 0L;
    this.dIf = "";
    this.dIg = "";
    this.dIw = "";
  }
  
  public bo(String paramString)
  {
    AppMethodBeat.i(126687);
    this.dIj = 0L;
    this.dIk = 0L;
    this.dPP = 0L;
    this.dIi = "";
    this.dPQ = 0L;
    this.dPR = 0;
    this.dPS = 0L;
    this.dIs = "";
    this.dIc = "";
    this.dId = "";
    this.dPT = 0L;
    this.dIf = "";
    this.dIg = "";
    this.dIw = "";
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
      this.dIj = bt.getLong(paramString[0], 0L);
      this.dIk = bt.getLong(paramString[1], 0L);
      this.dPP = bt.getLong(paramString[2], 0L);
      this.dIi = t("NewMd5", paramString[3], true);
      this.dPQ = bt.getLong(paramString[4], 0L);
      this.dPR = bt.getInt(paramString[5], 0);
      this.dPS = bt.getLong(paramString[6], 0L);
      this.dIs = t("CDNIp", paramString[7], true);
      this.dIc = t("FromUser", paramString[8], true);
      this.dId = t("Session", paramString[9], true);
      this.dPT = bt.getLong(paramString[10], 0L);
      this.dIf = t("FileId", paramString[11], true);
      this.dIg = t("SnsUrl", paramString[12], true);
      this.dIw = t("Publishid", paramString[13], true);
      AppMethodBeat.o(126687);
      return;
    }
  }
  
  public final String PV()
  {
    AppMethodBeat.i(126688);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dIj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dId);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIw);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(126688);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(126689);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dIj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dIk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSize:").append(this.dPP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dIi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.dPQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSpeed:").append(this.dPR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadFinishSize:").append(this.dPS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromUser:").append(this.dIc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.dId);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomNum:").append(this.dPT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.dIf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dIg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.dIw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126689);
    return localObject;
  }
  
  public final int getId()
  {
    return 14499;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bo
 * JD-Core Version:    0.7.0.1
 */