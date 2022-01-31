package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;

public final class aw
  extends a
{
  public long cic = 0L;
  public String ckG;
  public String cpZ;
  private long cqa = 0L;
  public String cqb;
  public String cqc;
  public aw.b cqd;
  public aw.a cqe;
  public String cqf;
  public aw.c cqg;
  public aw.d cqh;
  
  public final int getId()
  {
    return 16024;
  }
  
  public final String uI()
  {
    int j = -1;
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ckG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cpZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqc);
    ((StringBuffer)localObject).append(",");
    if (this.cqd != null)
    {
      i = this.cqd.value;
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      if (this.cqe == null) {
        break label247;
      }
      i = this.cqe.value;
      label133:
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cic);
      ((StringBuffer)localObject).append(",");
      ((StringBuffer)localObject).append(this.cqf);
      ((StringBuffer)localObject).append(",");
      if (this.cqg == null) {
        break label252;
      }
    }
    label247:
    label252:
    for (int i = this.cqg.value;; i = -1)
    {
      ((StringBuffer)localObject).append(i);
      ((StringBuffer)localObject).append(",");
      i = j;
      if (this.cqh != null) {
        i = this.cqh.value;
      }
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      LT((String)localObject);
      return localObject;
      i = -1;
      break;
      i = -1;
      break label133;
    }
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("AppId:").append(this.ckG);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("PageId:").append(this.cpZ);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ActionTimeStampMs:").append(this.cqa);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ShareTicket:").append(this.cqb);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("ChattingId:").append(this.cqc);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("IsGroupChatting:").append(this.cqd);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("EventId:").append(this.cqe);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Scene:").append(this.cic);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SceneNote:").append(this.cqf);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("MsgState:").append(this.cqg);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("SubScribeState:").append(this.cqh);
    return localStringBuffer.toString();
  }
  
  public final aw ve()
  {
    this.cqa = bk.UY();
    super.ag("ActionTimeStampMs", this.cqa);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.b.a.aw
 * JD-Core Version:    0.7.0.1
 */