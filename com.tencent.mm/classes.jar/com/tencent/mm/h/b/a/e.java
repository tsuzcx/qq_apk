package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class e
  extends a
{
  public String cgX = "";
  public long cgY = 0L;
  public long cgZ = 0L;
  public long cha = 0L;
  public boolean chb;
  public long chc = 0L;
  public long chd = 0L;
  public long che = 0L;
  private long chf = 0L;
  private long chg = 0L;
  public e.a chh;
  
  public final int getId()
  {
    return 15749;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cgX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cgZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cha);
    ((StringBuffer)localObject).append(",");
    if (this.chb)
    {
      i = 1;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.chc);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.chd);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.che);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.chf);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.chg);
      ((StringBuffer)localObject).append(",");
      if (this.chh == null) {
        break label213;
      }
    }
    label213:
    for (int i = this.chh.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      LT((String)localObject);
      return localObject;
      i = 0;
      break;
    }
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ChatName:").append(this.cgX);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MemberCount:").append(this.cgY);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MsgSvrId:").append(this.cgZ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MsgCreateTime:").append(this.cha);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("IsHdImgBool:").append(this.chb);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ImgSize:").append(this.chc);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ImgWidth:").append(this.chd);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ImgHeight:").append(this.che);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartDownloadTimeStampMs:").append(this.chf);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FinishDownloadTimeStampMs:").append(this.chg);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("FinishCode:").append(this.chh);
    return localStringBuffer.toString();
  }
  
  public final e uM()
  {
    this.chf = bk.UY();
    super.ag("StartDownloadTimeStampMs", this.chf);
    return this;
  }
  
  public final e uN()
  {
    this.chg = bk.UY();
    super.ag("FinishDownloadTimeStampMs", this.chg);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.h.b.a.e
 * JD-Core Version:    0.7.0.1
 */