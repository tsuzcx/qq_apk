package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Arrays;

public final class d
  extends a
{
  private int cfP = 0;
  private long cfQ = 0L;
  private long cfR = 0L;
  private long cfS = 0L;
  private long cfT = 0L;
  private long cfU = 0L;
  private long cfV = 0L;
  private long cfW = 0L;
  private long cfX = 0L;
  private String cfY = "";
  private long cfZ = 0L;
  private long cgA = 0L;
  private long cgB = 0L;
  private long cgC = 0L;
  private long cgD = 0L;
  private long cgE = 0L;
  private long cgF = 0L;
  private long cgG = 0L;
  private long cgH = 0L;
  private long cgI = 0L;
  private long cgJ = 0L;
  private long cgK = 0L;
  private int cgL = 0;
  private String cgM = "";
  private long cgN = 0L;
  private String cgO = "";
  private long cgP = 0L;
  private String cgQ = "";
  private long cgR = 0L;
  private String cgS = "";
  private long cgT = 0L;
  private long cgU = 0L;
  private long cgV = 0L;
  private long cgW = 0L;
  private String cga = "";
  private long cgb = 0L;
  private long cgc = 0L;
  private long cgd = 0L;
  private long cge = 0L;
  private long cgf = 0L;
  private long cgg = 0L;
  private long cgh = 0L;
  private long cgj = 0L;
  private long cgk = 0L;
  private long cgl = 0L;
  private long cgm = 0L;
  private long cgn = 0L;
  private long cgo = 0L;
  private String cgp = "";
  private long cgq = 0L;
  private long cgr = 0L;
  private long cgs = 0L;
  private long cgt = 0L;
  private long cgu = 0L;
  private long cgv = 0L;
  private long cgw = 0L;
  private long cgx = 0L;
  private long cgy = 0L;
  private long cgz = 0L;
  
  public d() {}
  
  public d(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 59) {
          break label1029;
        }
        String[] arrayOfString = new String[59];
        Arrays.fill(arrayOfString, 0, 59, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label1029:
    for (;;)
    {
      this.cfP = bk.getInt(paramString[0], 0);
      this.cfQ = bk.getLong(paramString[1], 0L);
      this.cfR = bk.getLong(paramString[2], 0L);
      this.cfS = bk.getLong(paramString[3], 0L);
      this.cfT = bk.getLong(paramString[4], 0L);
      this.cfU = bk.getLong(paramString[5], 0L);
      this.cfV = bk.getLong(paramString[6], 0L);
      this.cfW = bk.getLong(paramString[7], 0L);
      this.cfX = bk.getLong(paramString[8], 0L);
      this.cfY = paramString[9];
      this.cfZ = bk.getLong(paramString[10], 0L);
      this.cga = paramString[11];
      this.cgb = bk.getLong(paramString[12], 0L);
      this.cgc = bk.getLong(paramString[13], 0L);
      this.cgd = bk.getLong(paramString[14], 0L);
      this.cge = bk.getLong(paramString[15], 0L);
      this.cgf = bk.getLong(paramString[16], 0L);
      this.cgg = bk.getLong(paramString[17], 0L);
      this.cgh = bk.getLong(paramString[18], 0L);
      this.cgj = bk.getLong(paramString[19], 0L);
      this.cgk = bk.getLong(paramString[20], 0L);
      this.cgl = bk.getLong(paramString[21], 0L);
      this.cgm = bk.getLong(paramString[22], 0L);
      this.cgn = bk.getLong(paramString[23], 0L);
      this.cgo = bk.getLong(paramString[24], 0L);
      this.cgp = paramString[25];
      this.cgq = bk.getLong(paramString[26], 0L);
      this.cgr = bk.getLong(paramString[27], 0L);
      this.cgs = bk.getLong(paramString[28], 0L);
      this.cgt = bk.getLong(paramString[29], 0L);
      this.cgu = bk.getLong(paramString[30], 0L);
      this.cgv = bk.getLong(paramString[31], 0L);
      this.cgw = bk.getLong(paramString[32], 0L);
      this.cgx = bk.getLong(paramString[33], 0L);
      this.cgy = bk.getLong(paramString[34], 0L);
      this.cgz = bk.getLong(paramString[35], 0L);
      this.cgA = bk.getLong(paramString[36], 0L);
      this.cgB = bk.getLong(paramString[37], 0L);
      this.cgC = bk.getLong(paramString[38], 0L);
      this.cgD = bk.getLong(paramString[39], 0L);
      this.cgE = bk.getLong(paramString[40], 0L);
      this.cgF = bk.getLong(paramString[41], 0L);
      this.cgG = bk.getLong(paramString[42], 0L);
      this.cgH = bk.getLong(paramString[43], 0L);
      this.cgI = bk.getLong(paramString[44], 0L);
      this.cgJ = bk.getLong(paramString[45], 0L);
      this.cgK = bk.getLong(paramString[46], 0L);
      this.cgL = bk.getInt(paramString[47], 0);
      this.cgM = paramString[48];
      this.cgN = bk.getLong(paramString[49], 0L);
      this.cgO = paramString[50];
      this.cgP = bk.getLong(paramString[51], 0L);
      this.cgQ = paramString[52];
      this.cgR = bk.getLong(paramString[53], 0L);
      this.cgS = paramString[54];
      this.cgT = bk.getLong(paramString[55], 0L);
      this.cgU = bk.getLong(paramString[56], 0L);
      this.cgV = bk.getLong(paramString[57], 0L);
      this.cgW = bk.getLong(paramString[58], 0L);
      return;
    }
  }
  
  public final int getId()
  {
    return 13937;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cfP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cfZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cga);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cge);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgW);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("CientErrNo:").append(this.cfP);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OpType:").append(this.cfQ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OpStartTs:").append(this.cfR);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("OpEndTs:").append(this.cfS);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("NetType:").append(this.cfT);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FileType:").append(this.cfU);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FileSize:").append(this.cfV);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CDNErrNo:").append(this.cfW);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CDNOpType:").append(this.cfX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SvrIP:").append(this.cfY);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("IPCount:").append(this.cfZ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FileKey:").append(this.cga);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SliceCount:").append(this.cgb);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("TransportSize:").append(this.cgc);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ConnTotalCost:").append(this.cgd);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ConnTryTimes:").append(this.cge);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CDNTransfStartTs:").append(this.cgf);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CDNTransfEndTs:").append(this.cgg);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("IsHitCache:").append(this.cgh);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("CompressPicLevel:").append(this.cgj);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SrcFileSize:").append(this.cgk);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ImgSource:").append(this.cgl);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ResolutionX:").append(this.cgm);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ResolutionY:").append(this.cgn);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ReportCode:").append(this.cgo);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UUID:").append(this.cgp);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ETLTime:").append(this.cgq);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("PTLTime:").append(this.cgr);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ETLSize:").append(this.cgs);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("PTLSize:").append(this.cgt);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SkeyFailCount:").append(this.cgu);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SKeyTimeoutCount:").append(this.cgv);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ConnectCount:").append(this.cgw);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ConnectTotalMS:").append(this.cgx);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ConnectAvgMS:").append(this.cgy);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ConnectVarianceMS:").append(this.cgz);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ConnectMinMS:").append(this.cgA);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ConnectMaxMS:").append(this.cgB);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("TransforCount:").append(this.cgC);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("TransforTotalMS:").append(this.cgD);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("TransforAvgMS:").append(this.cgE);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("TransforVarianceMS:").append(this.cgF);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("TransforMinMS:").append(this.cgG);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("TransforMaxMS:").append(this.cgH);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("IsProgressiveJPEG:").append(this.cgI);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("WaitSec:").append(this.cgJ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("LastPort:").append(this.cgK);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ConnErrorCode:").append(this.cgL);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UsedIp1:").append(this.cgM);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UsedPort1:").append(this.cgN);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UsedIp2:").append(this.cgO);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UsedPort2:").append(this.cgP);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UsedIp3:").append(this.cgQ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UsedPort3:").append(this.cgR);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UsedIp4:").append(this.cgS);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("UsedPort4:").append(this.cgT);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("LogCreateTime:").append(this.cgU);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("LogReportTime:").append(this.cgV);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("LogReportSvrTime:").append(this.cgW);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.b.a.d
 * JD-Core Version:    0.7.0.1
 */