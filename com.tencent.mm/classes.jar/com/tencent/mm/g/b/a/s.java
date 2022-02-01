package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class s
  extends a
{
  private String dGe;
  private String dGf;
  private long dGg;
  private String dGh;
  private String dGi;
  private int dGj;
  private String dGk;
  private long dGl;
  private long dGm;
  private long dGn;
  private long dGo;
  private long dGp;
  private long dGq;
  private long dGr;
  private long dGs;
  private long dGt;
  private String dGu;
  private long dGv;
  private long dGw;
  private long dGx;
  private String dGy;
  
  public s()
  {
    this.dGe = "";
    this.dGf = "";
    this.dGg = 0L;
    this.dGh = "";
    this.dGi = "";
    this.dGj = 0;
    this.dGk = "";
    this.dGl = 0L;
    this.dGm = 0L;
    this.dGn = 0L;
    this.dGo = 0L;
    this.dGp = 0L;
    this.dGq = 0L;
    this.dGr = 0L;
    this.dGs = 0L;
    this.dGt = 0L;
    this.dGu = "";
    this.dGv = 0L;
    this.dGw = 0L;
    this.dGx = 0L;
    this.dGy = "";
  }
  
  public s(String paramString)
  {
    AppMethodBeat.i(126681);
    this.dGe = "";
    this.dGf = "";
    this.dGg = 0L;
    this.dGh = "";
    this.dGi = "";
    this.dGj = 0;
    this.dGk = "";
    this.dGl = 0L;
    this.dGm = 0L;
    this.dGn = 0L;
    this.dGo = 0L;
    this.dGp = 0L;
    this.dGq = 0L;
    this.dGr = 0L;
    this.dGs = 0L;
    this.dGt = 0L;
    this.dGu = "";
    this.dGv = 0L;
    this.dGw = 0L;
    this.dGx = 0L;
    this.dGy = "";
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
      this.dGe = t("FromUser", paramString[0], true);
      this.dGf = t("Session", paramString[1], true);
      this.dGg = bs.getLong(paramString[2], 0L);
      this.dGh = t("FileId", paramString[3], true);
      this.dGi = t("SnsUrl", paramString[4], true);
      this.dGj = bs.getInt(paramString[5], 0);
      this.dGk = t("NewMd5", paramString[6], true);
      this.dGl = bs.getLong(paramString[7], 0L);
      this.dGm = bs.getLong(paramString[8], 0L);
      this.dGn = bs.getLong(paramString[9], 0L);
      this.dGo = bs.getLong(paramString[10], 0L);
      this.dGp = bs.getLong(paramString[11], 0L);
      this.dGq = bs.getLong(paramString[12], 0L);
      this.dGr = bs.getLong(paramString[13], 0L);
      this.dGs = bs.getLong(paramString[14], 0L);
      this.dGt = bs.getLong(paramString[15], 0L);
      this.dGu = t("CDNIp", paramString[16], true);
      this.dGv = bs.getLong(paramString[17], 0L);
      this.dGw = bs.getLong(paramString[18], 0L);
      this.dGx = bs.getLong(paramString[19], 0L);
      this.dGy = t("Publishid", paramString[20], true);
      AppMethodBeat.o(126681);
      return;
    }
  }
  
  public final String PR()
  {
    AppMethodBeat.i(126682);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dGe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dGy);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(126682);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(126683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FromUser:").append(this.dGe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.dGf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNum:").append(this.dGg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.dGh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.dGi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.dGj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.dGk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.dGl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.dGm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.dGn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.dGo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.dGp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.dGq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.dGr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.dGs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.dGt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.dGu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.dGv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.dGw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.dGx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.dGy);
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
 * Qualified Name:     com.tencent.mm.g.b.a.s
 * JD-Core Version:    0.7.0.1
 */