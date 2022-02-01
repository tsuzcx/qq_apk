package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ki
  extends a
{
  private long eLv;
  private long eSx;
  private long eSy;
  private String eUZ;
  private String eVa;
  private String eVb;
  private String eVc;
  private long eVd;
  private long eVe;
  private long eVf;
  private long eVg;
  private long eVh;
  private long eVi;
  private long eVj;
  private int eVk;
  private long eVl;
  private long eVm;
  private long eVn;
  private long eVo;
  private long eVp;
  private long eVq;
  private long eVr;
  private String eoP;
  private int eoQ;
  private String eoR;
  private String epb;
  private long epc;
  
  public ki()
  {
    this.eUZ = "";
    this.eVa = "";
    this.eoQ = 0;
    this.eVb = "";
    this.eoR = "";
    this.eVc = "";
    this.eSx = 0L;
    this.eSy = 0L;
    this.eVd = 0L;
    this.eVe = 0L;
    this.eVf = 0L;
    this.eVg = 0L;
    this.eVh = 0L;
    this.eVi = 0L;
    this.eVj = 0L;
    this.eVk = 0;
    this.eVl = 0L;
    this.eVm = 0L;
    this.eVn = 0L;
    this.eVo = 0L;
    this.eVp = 0L;
    this.eVq = 0L;
    this.eVr = 0L;
    this.eLv = 0L;
    this.epb = "";
    this.epc = 0L;
    this.eoP = "";
  }
  
  public ki(String paramString)
  {
    AppMethodBeat.i(126701);
    this.eUZ = "";
    this.eVa = "";
    this.eoQ = 0;
    this.eVb = "";
    this.eoR = "";
    this.eVc = "";
    this.eSx = 0L;
    this.eSy = 0L;
    this.eVd = 0L;
    this.eVe = 0L;
    this.eVf = 0L;
    this.eVg = 0L;
    this.eVh = 0L;
    this.eVi = 0L;
    this.eVj = 0L;
    this.eVk = 0;
    this.eVl = 0L;
    this.eVm = 0L;
    this.eVn = 0L;
    this.eVo = 0L;
    this.eVp = 0L;
    this.eVq = 0L;
    this.eVr = 0L;
    this.eLv = 0L;
    this.epb = "";
    this.epc = 0L;
    this.eoP = "";
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 27) {
          break label544;
        }
        String[] arrayOfString = new String[27];
        Arrays.fill(arrayOfString, 0, 27, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label544:
    for (;;)
    {
      this.eUZ = x("ToUser", paramString[0], true);
      this.eVa = x("MsgSource", paramString[1], true);
      this.eoQ = Util.getInt(paramString[2], 0);
      this.eVb = x("FieldId", paramString[3], true);
      this.eoR = x("NewMd5", paramString[4], true);
      this.eVc = x("SnsInfoId", paramString[5], true);
      this.eSx = Util.getLong(paramString[6], 0L);
      this.eSy = Util.getLong(paramString[7], 0L);
      this.eVd = Util.getLong(paramString[8], 0L);
      this.eVe = Util.getLong(paramString[9], 0L);
      this.eVf = Util.getLong(paramString[10], 0L);
      this.eVg = Util.getLong(paramString[11], 0L);
      this.eVh = Util.getLong(paramString[12], 0L);
      this.eVi = Util.getLong(paramString[13], 0L);
      this.eVj = Util.getLong(paramString[14], 0L);
      this.eVk = Util.getInt(paramString[15], 0);
      this.eVl = Util.getLong(paramString[16], 0L);
      this.eVm = Util.getLong(paramString[17], 0L);
      this.eVn = Util.getLong(paramString[18], 0L);
      this.eVo = Util.getLong(paramString[19], 0L);
      this.eVp = Util.getLong(paramString[20], 0L);
      this.eVq = Util.getLong(paramString[21], 0L);
      this.eVr = Util.getLong(paramString[22], 0L);
      this.eLv = Util.getLong(paramString[23], 0L);
      this.epb = x("CDNIp", paramString[24], true);
      this.epc = Util.getLong(paramString[25], 0L);
      this.eoP = x("SnsUrl", paramString[26], true);
      AppMethodBeat.o(126701);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(126702);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eUZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eVr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.epc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoP);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(126702);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(126703);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ToUser:").append(this.eUZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgSource:").append(this.eVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NetType:").append(this.eoQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FieldId:").append(this.eVb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("NewMd5:").append(this.eoR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsInfoId:").append(this.eVc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadStartTime:").append(this.eSx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UploadEndTime:").append(this.eSy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalSize:").append(this.eVd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalDuration:").append(this.eVe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalVideoBitrate:").append(this.eVf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioBitrate:").append(this.eVg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalFps:").append(this.eVh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalWidth:").append(this.eVi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalHeight:").append(this.eVj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpStatus:").append(this.eVk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpSize:").append(this.eVl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpDuration:").append(this.eVm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpVideoBitrate:").append(this.eVn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpAudioiBitrate:").append(this.eVo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpFps:").append(this.eVp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpWidth:").append(this.eVq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CpHeight:").append(this.eVr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SendScene:").append(this.eLv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CDNIp:").append(this.epb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriginalAudioChannel:").append(this.epc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SnsUrl:").append(this.eoP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(126703);
    return localObject;
  }
  
  public final int getId()
  {
    return 13794;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ki
 * JD-Core Version:    0.7.0.1
 */