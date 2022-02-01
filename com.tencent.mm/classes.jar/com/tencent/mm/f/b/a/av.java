package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class av
  extends a
{
  private String gjY;
  private String gjZ;
  private long gka;
  private String gkb;
  private String gkc;
  private int gkd;
  private String gke;
  private long gkf;
  private long gkg;
  private long gkh;
  private long gki;
  private long gkj;
  private long gkk;
  private long gkl;
  private long gkm;
  private long gkn;
  private String gko;
  private long gkp;
  private long gkq;
  private long gkr;
  private String gks;
  
  public av()
  {
    this.gjY = "";
    this.gjZ = "";
    this.gka = 0L;
    this.gkb = "";
    this.gkc = "";
    this.gkd = 0;
    this.gke = "";
    this.gkf = 0L;
    this.gkg = 0L;
    this.gkh = 0L;
    this.gki = 0L;
    this.gkj = 0L;
    this.gkk = 0L;
    this.gkl = 0L;
    this.gkm = 0L;
    this.gkn = 0L;
    this.gko = "";
    this.gkp = 0L;
    this.gkq = 0L;
    this.gkr = 0L;
    this.gks = "";
  }
  
  public av(String paramString)
  {
    AppMethodBeat.i(126681);
    this.gjY = "";
    this.gjZ = "";
    this.gka = 0L;
    this.gkb = "";
    this.gkc = "";
    this.gkd = 0;
    this.gke = "";
    this.gkf = 0L;
    this.gkg = 0L;
    this.gkh = 0L;
    this.gki = 0L;
    this.gkj = 0L;
    this.gkk = 0L;
    this.gkl = 0L;
    this.gkm = 0L;
    this.gkn = 0L;
    this.gko = "";
    this.gkp = 0L;
    this.gkq = 0L;
    this.gkr = 0L;
    this.gks = "";
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
      this.gjY = z("FromUser", paramString[0], true);
      this.gjZ = z("Session", paramString[1], true);
      this.gka = Util.getLong(paramString[2], 0L);
      this.gkb = z("FileId", paramString[3], true);
      this.gkc = z("SnsUrl", paramString[4], true);
      this.gkd = Util.getInt(paramString[5], 0);
      this.gke = z("NewMd5", paramString[6], true);
      this.gkf = Util.getLong(paramString[7], 0L);
      this.gkg = Util.getLong(paramString[8], 0L);
      this.gkh = Util.getLong(paramString[9], 0L);
      this.gki = Util.getLong(paramString[10], 0L);
      this.gkj = Util.getLong(paramString[11], 0L);
      this.gkk = Util.getLong(paramString[12], 0L);
      this.gkl = Util.getLong(paramString[13], 0L);
      this.gkm = Util.getLong(paramString[14], 0L);
      this.gkn = Util.getLong(paramString[15], 0L);
      this.gko = z("CDNIp", paramString[16], true);
      this.gkp = Util.getLong(paramString[17], 0L);
      this.gkq = Util.getLong(paramString[18], 0L);
      this.gkr = Util.getLong(paramString[19], 0L);
      this.gks = z("Publishid", paramString[20], true);
      AppMethodBeat.o(126681);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(126682);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gka);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gke);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gki);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gko);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gks);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(126682);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(126683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FromUser:").append(this.gjY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.gjZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNum:").append(this.gka);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.gkb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.gkc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.gkd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.gke);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.gkf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.gkg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.gkh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.gki);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.gkj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.gkk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.gkl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.gkm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.gkn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.gko);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.gkp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.gkq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.gkr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.gks);
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
 * Qualified Name:     com.tencent.mm.f.b.a.av
 * JD-Core Version:    0.7.0.1
 */