package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class an
  extends a
{
  private String eoL;
  private String eoM;
  private long eoN;
  private String eoO;
  private String eoP;
  private int eoQ;
  private String eoR;
  private long eoS;
  private long eoT;
  private long eoU;
  private long eoV;
  private long eoW;
  private long eoX;
  private long eoY;
  private long eoZ;
  private long epa;
  private String epb;
  private long epc;
  private long epd;
  private long epe;
  private String epf;
  
  public an()
  {
    this.eoL = "";
    this.eoM = "";
    this.eoN = 0L;
    this.eoO = "";
    this.eoP = "";
    this.eoQ = 0;
    this.eoR = "";
    this.eoS = 0L;
    this.eoT = 0L;
    this.eoU = 0L;
    this.eoV = 0L;
    this.eoW = 0L;
    this.eoX = 0L;
    this.eoY = 0L;
    this.eoZ = 0L;
    this.epa = 0L;
    this.epb = "";
    this.epc = 0L;
    this.epd = 0L;
    this.epe = 0L;
    this.epf = "";
  }
  
  public an(String paramString)
  {
    AppMethodBeat.i(126681);
    this.eoL = "";
    this.eoM = "";
    this.eoN = 0L;
    this.eoO = "";
    this.eoP = "";
    this.eoQ = 0;
    this.eoR = "";
    this.eoS = 0L;
    this.eoT = 0L;
    this.eoU = 0L;
    this.eoV = 0L;
    this.eoW = 0L;
    this.eoX = 0L;
    this.eoY = 0L;
    this.eoZ = 0L;
    this.epa = 0L;
    this.epb = "";
    this.epc = 0L;
    this.epd = 0L;
    this.epe = 0L;
    this.epf = "";
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
      this.eoL = x("FromUser", paramString[0], true);
      this.eoM = x("Session", paramString[1], true);
      this.eoN = Util.getLong(paramString[2], 0L);
      this.eoO = x("FileId", paramString[3], true);
      this.eoP = x("SnsUrl", paramString[4], true);
      this.eoQ = Util.getInt(paramString[5], 0);
      this.eoR = x("NewMd5", paramString[6], true);
      this.eoS = Util.getLong(paramString[7], 0L);
      this.eoT = Util.getLong(paramString[8], 0L);
      this.eoU = Util.getLong(paramString[9], 0L);
      this.eoV = Util.getLong(paramString[10], 0L);
      this.eoW = Util.getLong(paramString[11], 0L);
      this.eoX = Util.getLong(paramString[12], 0L);
      this.eoY = Util.getLong(paramString[13], 0L);
      this.eoZ = Util.getLong(paramString[14], 0L);
      this.epa = Util.getLong(paramString[15], 0L);
      this.epb = x("CDNIp", paramString[16], true);
      this.epc = Util.getLong(paramString[17], 0L);
      this.epd = Util.getLong(paramString[18], 0L);
      this.epe = Util.getLong(paramString[19], 0L);
      this.epf = x("Publishid", paramString[20], true);
      AppMethodBeat.o(126681);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(126682);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epf);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(126682);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(126683);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("FromUser:").append(this.eoL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.eoM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatNum:").append(this.eoN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.eoO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.eoP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.eoQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.eoR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.eoS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.eoT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoSize:").append(this.eoU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoDuration:").append(this.eoV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoBitrate:").append(this.eoW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioBitrate:").append(this.eoX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoFps:").append(this.eoY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoWidth:").append(this.eoZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoHeight:").append(this.epa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.epb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.epc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadSize:").append(this.epd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadPreloadCompletion:").append(this.epe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.epf);
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
 * Qualified Name:     com.tencent.mm.g.b.a.an
 * JD-Core Version:    0.7.0.1
 */