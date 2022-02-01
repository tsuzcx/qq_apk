package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class df
  extends a
{
  private String els = "";
  private long ezg;
  private long ezh;
  private long ezi;
  private long ezj;
  private long ezk;
  private long ezl;
  private long ezm;
  
  public final String abV()
  {
    AppMethodBeat.i(209101);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezm);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209101);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209102);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTimeMs:").append(this.ezg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDotEnter:").append(this.ezh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Event:").append(this.ezi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("BannerType:").append(this.ezj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EventTime:").append(this.ezk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsHaveRedDot:").append(this.ezl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("MsgCnt:").append(this.ezm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209102);
    return localObject;
  }
  
  public final int getId()
  {
    return 20372;
  }
  
  public final df jb(long paramLong)
  {
    AppMethodBeat.i(209100);
    this.ezg = paramLong;
    super.bi("EnterTimeMs", this.ezg);
    AppMethodBeat.o(209100);
    return this;
  }
  
  public final df jc(long paramLong)
  {
    this.ezh = paramLong;
    return this;
  }
  
  public final df jd(long paramLong)
  {
    this.ezi = paramLong;
    return this;
  }
  
  public final df je(long paramLong)
  {
    this.ezj = paramLong;
    return this;
  }
  
  public final df jf(long paramLong)
  {
    this.ezk = paramLong;
    return this;
  }
  
  public final df jg(long paramLong)
  {
    this.ezl = paramLong;
    return this;
  }
  
  public final df jh(long paramLong)
  {
    this.ezm = paramLong;
    return this;
  }
  
  public final df ov(String paramString)
  {
    AppMethodBeat.i(209099);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(209099);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.df
 * JD-Core Version:    0.7.0.1
 */