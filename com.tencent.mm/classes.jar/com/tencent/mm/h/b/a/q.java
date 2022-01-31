package com.tencent.mm.h.b.a;

import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.Arrays;

public final class q
  extends a
{
  public long cjn = 0L;
  public long cjo = 0L;
  public String cjp = "";
  public boolean cjq;
  
  public q() {}
  
  public q(String paramString)
  {
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 4) {
          break label118;
        }
        String[] arrayOfString = new String[4];
        Arrays.fill(arrayOfString, 0, 4, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label118:
    for (;;)
    {
      this.cjn = bk.getLong(paramString[0], 0L);
      ao(bk.getLong(paramString[1], 0L));
      this.cjp = paramString[2];
      if (bk.getInt(paramString[3], 0) != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.cjq = bool;
        return;
      }
    }
  }
  
  private q ao(long paramLong)
  {
    this.cjo = paramLong;
    super.ah("StartTimeStampSec", this.cjo);
    return this;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final String uI()
  {
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cjn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cjp);
    ((StringBuffer)localObject).append(",");
    if (this.cjq) {}
    for (int i = 1;; i = 0)
    {
      ((StringBuffer)localObject).append(i);
      localObject = ((StringBuffer)localObject).toString();
      LT((String)localObject);
      return localObject;
    }
  }
  
  public final String uJ()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("ExptFlag:").append(this.cjn);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("StartTimeStampSec:").append(this.cjo);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("Roomname:").append(this.cjp);
    localStringBuffer.append("\r\n");
    localStringBuffer.append("hardcodeExptBool:").append(this.cjq);
    return localStringBuffer.toString();
  }
  
  public final q uP()
  {
    return ao(bk.UX());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.b.a.q
 * JD-Core Version:    0.7.0.1
 */