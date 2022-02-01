package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class hb
  extends a
{
  private long eLm;
  private long eLn;
  private int eLo;
  private long eLp;
  private long eLq;
  private String eoL;
  private String eoM;
  private String eoO;
  private String eoP;
  private String eoR;
  private long eoS;
  private long eoT;
  private String epb;
  private String epf;
  
  public hb()
  {
    this.eoS = 0L;
    this.eoT = 0L;
    this.eLm = 0L;
    this.eoR = "";
    this.eLn = 0L;
    this.eLo = 0;
    this.eLp = 0L;
    this.epb = "";
    this.eoL = "";
    this.eoM = "";
    this.eLq = 0L;
    this.eoO = "";
    this.eoP = "";
    this.epf = "";
  }
  
  public hb(String paramString)
  {
    AppMethodBeat.i(126687);
    this.eoS = 0L;
    this.eoT = 0L;
    this.eLm = 0L;
    this.eoR = "";
    this.eLn = 0L;
    this.eLo = 0;
    this.eLp = 0L;
    this.epb = "";
    this.eoL = "";
    this.eoM = "";
    this.eLq = 0L;
    this.eoO = "";
    this.eoP = "";
    this.epf = "";
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
      this.eoS = Util.getLong(paramString[0], 0L);
      this.eoT = Util.getLong(paramString[1], 0L);
      this.eLm = Util.getLong(paramString[2], 0L);
      this.eoR = x("NewMd5", paramString[3], true);
      this.eLn = Util.getLong(paramString[4], 0L);
      this.eLo = Util.getInt(paramString[5], 0);
      this.eLp = Util.getLong(paramString[6], 0L);
      this.epb = x("CDNIp", paramString[7], true);
      this.eoL = x("FromUser", paramString[8], true);
      this.eoM = x("Session", paramString[9], true);
      this.eLq = Util.getLong(paramString[10], 0L);
      this.eoO = x("FileId", paramString[11], true);
      this.eoP = x("SnsUrl", paramString[12], true);
      this.epf = x("Publishid", paramString[13], true);
      AppMethodBeat.o(126687);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(126688);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epf);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(126688);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(126689);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("DownloadStartTime:").append(this.eoS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadEndTime:").append(this.eoT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSize:").append(this.eLm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.eoR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgType:").append(this.eLn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("DownloadSpeed:").append(this.eLo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HadFinishSize:").append(this.eLp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.epb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FromUser:").append(this.eoL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Session:").append(this.eoM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatroomNum:").append(this.eLq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FileId:").append(this.eoO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.eoP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Publishid:").append(this.epf);
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
 * Qualified Name:     com.tencent.mm.g.b.a.hb
 * JD-Core Version:    0.7.0.1
 */