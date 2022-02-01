package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class jg
  extends a
{
  private long gKQ;
  private long gKR;
  private int gKS;
  private long gKT;
  private long gKU;
  private String gjY;
  private String gjZ;
  private String gkb;
  private String gkc;
  private String gke;
  private long gkf;
  private long gkg;
  private String gko;
  private String gks;
  
  public jg()
  {
    this.gkf = 0L;
    this.gkg = 0L;
    this.gKQ = 0L;
    this.gke = "";
    this.gKR = 0L;
    this.gKS = 0;
    this.gKT = 0L;
    this.gko = "";
    this.gjY = "";
    this.gjZ = "";
    this.gKU = 0L;
    this.gkb = "";
    this.gkc = "";
    this.gks = "";
  }
  
  public jg(String paramString)
  {
    AppMethodBeat.i(126687);
    this.gkf = 0L;
    this.gkg = 0L;
    this.gKQ = 0L;
    this.gke = "";
    this.gKR = 0L;
    this.gKS = 0;
    this.gKT = 0L;
    this.gko = "";
    this.gjY = "";
    this.gjZ = "";
    this.gKU = 0L;
    this.gkb = "";
    this.gkc = "";
    this.gks = "";
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
      this.gkf = Util.getLong(paramString[0], 0L);
      this.gkg = Util.getLong(paramString[1], 0L);
      this.gKQ = Util.getLong(paramString[2], 0L);
      this.gke = z("NewMd5", paramString[3], true);
      this.gKR = Util.getLong(paramString[4], 0L);
      this.gKS = Util.getInt(paramString[5], 0);
      this.gKT = Util.getLong(paramString[6], 0L);
      this.gko = z("CDNIp", paramString[7], true);
      this.gjY = z("FromUser", paramString[8], true);
      this.gjZ = z("Session", paramString[9], true);
      this.gKU = Util.getLong(paramString[10], 0L);
      this.gkb = z("FileId", paramString[11], true);
      this.gkc = z("SnsUrl", paramString[12], true);
      this.gks = z("Publishid", paramString[13], true);
      AppMethodBeat.o(126687);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(126688);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gkf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gke);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gko);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gKU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gkc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gks);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(126688);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(126689);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.gkf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.gkg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSize:").append(this.gKQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.gke);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.gKR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSpeed:").append(this.gKS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadFinishSize:").append(this.gKT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.gko);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromUser:").append(this.gjY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.gjZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomNum:").append(this.gKU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.gkb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.gkc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.gks);
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
 * Qualified Name:     com.tencent.mm.f.b.a.jg
 * JD-Core Version:    0.7.0.1
 */