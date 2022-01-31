package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;

public final class bb
  extends a
{
  public long cqP = 0L;
  public String cqQ = "";
  
  public final int getId()
  {
    return 15779;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cqP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cqQ);
    localObject = ((StringBuffer)localObject).toString();
    LT((String)localObject);
    return localObject;
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("canPreload:").append(this.cqP);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("existPkgInfo:").append(this.cqQ);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.b.a.bb
 * JD-Core Version:    0.7.0.1
 */