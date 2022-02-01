package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class q
  extends a
{
  private String dIc;
  private String dId;
  private long dIe;
  private String dIf;
  private String dIg;
  private int dIh;
  private String dIi;
  private long dIj;
  private long dIk;
  private long dIl;
  private long dIm;
  private long dIn;
  private long dIo;
  private long dIp;
  private long dIq;
  private long dIr;
  private String dIs;
  private long dIt;
  private long dIu;
  private long dIv;
  private String dIw;
  
  public q()
  {
    this.dIc = "";
    this.dId = "";
    this.dIe = 0L;
    this.dIf = "";
    this.dIg = "";
    this.dIh = 0;
    this.dIi = "";
    this.dIj = 0L;
    this.dIk = 0L;
    this.dIl = 0L;
    this.dIm = 0L;
    this.dIn = 0L;
    this.dIo = 0L;
    this.dIp = 0L;
    this.dIq = 0L;
    this.dIr = 0L;
    this.dIs = "";
    this.dIt = 0L;
    this.dIu = 0L;
    this.dIv = 0L;
    this.dIw = "";
  }
  
  public q(String paramString)
  {
    AppMethodBeat.i(126681);
    this.dIc = "";
    this.dId = "";
    this.dIe = 0L;
    this.dIf = "";
    this.dIg = "";
    this.dIh = 0;
    this.dIi = "";
    this.dIj = 0L;
    this.dIk = 0L;
    this.dIl = 0L;
    this.dIm = 0L;
    this.dIn = 0L;
    this.dIo = 0L;
    this.dIp = 0L;
    this.dIq = 0L;
    this.dIr = 0L;
    this.dIs = "";
    this.dIt = 0L;
    this.dIu = 0L;
    this.dIv = 0L;
    this.dIw = "";
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
      this.dIc = t("FromUser", paramString[0], true);
      this.dId = t("Session", paramString[1], true);
      this.dIe = bt.getLong(paramString[2], 0L);
      this.dIf = t("FileId", paramString[3], true);
      this.dIg = t("SnsUrl", paramString[4], true);
      this.dIh = bt.getInt(paramString[5], 0);
      this.dIi = t("NewMd5", paramString[6], true);
      this.dIj = bt.getLong(paramString[7], 0L);
      this.dIk = bt.getLong(paramString[8], 0L);
      this.dIl = bt.getLong(paramString[9], 0L);
      this.dIm = bt.getLong(paramString[10], 0L);
      this.dIn = bt.getLong(paramString[11], 0L);
      this.dIo = bt.getLong(paramString[12], 0L);
      this.dIp = bt.getLong(paramString[13], 0L);
      this.dIq = bt.getLong(paramString[14], 0L);
      this.dIr = bt.getLong(paramString[15], 0L);
      this.dIs = t("CDNIp", paramString[16], true);
      this.dIt = bt.getLong(paramString[17], 0L);
      this.dIu = bt.getLong(paramString[18], 0L);
      this.dIv = bt.getLong(paramString[19], 0L);
      this.dIw = t("Publishid", paramString[20], true);
      AppMethodBeat.o(126681);
      return;
    }
  }
  
  public final String PV()
  {
    AppMethodBeat.i(126682);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dIc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dId);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dIw);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(126682);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(126683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FromUser:").append(this.dIc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.dId);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNum:").append(this.dIe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.dIf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dIg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.dIh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dIi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dIj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dIk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.dIl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dIm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dIn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.dIo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.dIp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.dIq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.dIr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dIs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dIt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dIu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dIv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.dIw);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126683);
    return localObject;
  }
  
  public final int getId()
  {
    return 13795;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.q
 * JD-Core Version:    0.7.0.1
 */