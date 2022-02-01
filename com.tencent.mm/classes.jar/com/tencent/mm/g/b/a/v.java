package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class v
  extends a
{
  private long dTA;
  private long dTB;
  private long dTC;
  private String dTD;
  private String dTj;
  private String dTk;
  private long dTl;
  private String dTm;
  private String dTn;
  private int dTo;
  private String dTp;
  private long dTq;
  private long dTr;
  private long dTs;
  private long dTt;
  private long dTu;
  private long dTv;
  private long dTw;
  private long dTx;
  private long dTy;
  private String dTz;
  
  public v()
  {
    this.dTj = "";
    this.dTk = "";
    this.dTl = 0L;
    this.dTm = "";
    this.dTn = "";
    this.dTo = 0;
    this.dTp = "";
    this.dTq = 0L;
    this.dTr = 0L;
    this.dTs = 0L;
    this.dTt = 0L;
    this.dTu = 0L;
    this.dTv = 0L;
    this.dTw = 0L;
    this.dTx = 0L;
    this.dTy = 0L;
    this.dTz = "";
    this.dTA = 0L;
    this.dTB = 0L;
    this.dTC = 0L;
    this.dTD = "";
  }
  
  public v(String paramString)
  {
    AppMethodBeat.i(126681);
    this.dTj = "";
    this.dTk = "";
    this.dTl = 0L;
    this.dTm = "";
    this.dTn = "";
    this.dTo = 0;
    this.dTp = "";
    this.dTq = 0L;
    this.dTr = 0L;
    this.dTs = 0L;
    this.dTt = 0L;
    this.dTu = 0L;
    this.dTv = 0L;
    this.dTw = 0L;
    this.dTx = 0L;
    this.dTy = 0L;
    this.dTz = "";
    this.dTA = 0L;
    this.dTB = 0L;
    this.dTC = 0L;
    this.dTD = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 21) {
          break label442;
        }
        String[] arrayOfString = new String[21];
        Arrays.fill(arrayOfString, 0, 21, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label442:
    for (;;)
    {
      this.dTj = t("FromUser", paramString[0], true);
      this.dTk = t("Session", paramString[1], true);
      this.dTl = bt.getLong(paramString[2], 0L);
      this.dTm = t("FileId", paramString[3], true);
      this.dTn = t("SnsUrl", paramString[4], true);
      this.dTo = bt.getInt(paramString[5], 0);
      this.dTp = t("NewMd5", paramString[6], true);
      this.dTq = bt.getLong(paramString[7], 0L);
      this.dTr = bt.getLong(paramString[8], 0L);
      this.dTs = bt.getLong(paramString[9], 0L);
      this.dTt = bt.getLong(paramString[10], 0L);
      this.dTu = bt.getLong(paramString[11], 0L);
      this.dTv = bt.getLong(paramString[12], 0L);
      this.dTw = bt.getLong(paramString[13], 0L);
      this.dTx = bt.getLong(paramString[14], 0L);
      this.dTy = bt.getLong(paramString[15], 0L);
      this.dTz = t("CDNIp", paramString[16], true);
      this.dTA = bt.getLong(paramString[17], 0L);
      this.dTB = bt.getLong(paramString[18], 0L);
      this.dTC = bt.getLong(paramString[19], 0L);
      this.dTD = t("Publishid", paramString[20], true);
      AppMethodBeat.o(126681);
      return;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(126682);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dTj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTD);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(126682);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(126683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FromUser:").append(this.dTj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.dTk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNum:").append(this.dTl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.dTm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dTn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.dTo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dTp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dTq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dTr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.dTs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dTt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dTu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.dTv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.dTx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.dTy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dTz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dTA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dTB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dTC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.dTD);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126683);
    return localObject;
  }
  
  public final int getId()
  {
    return 13795;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.v
 * JD-Core Version:    0.7.0.1
 */