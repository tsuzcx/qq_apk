package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ch
  extends a
{
  private long dCS;
  private String dNK;
  private long dNL;
  private long dNM;
  private long dOA;
  private String dOB;
  private long dOj;
  private long dOy = 0L;
  private long dOz;
  
  public final String PR()
  {
    AppMethodBeat.i(190833);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOB);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190833);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190834);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.dNL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUin:").append(this.dOy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveRole:").append(this.dOj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.dNM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionResult:").append(this.dOz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTS:").append(this.dOA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceUserName:").append(this.dOB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190834);
    return localObject;
  }
  
  public final int getId()
  {
    return 19893;
  }
  
  public final ch hn(long paramLong)
  {
    this.dNL = paramLong;
    return this;
  }
  
  public final ch ho(long paramLong)
  {
    this.dOj = paramLong;
    return this;
  }
  
  public final ch hp(long paramLong)
  {
    this.dNM = paramLong;
    return this;
  }
  
  public final ch hq(long paramLong)
  {
    this.dCS = paramLong;
    return this;
  }
  
  public final ch hr(long paramLong)
  {
    this.dOz = paramLong;
    return this;
  }
  
  public final ch hs(long paramLong)
  {
    this.dOA = paramLong;
    return this;
  }
  
  public final ch kk(String paramString)
  {
    AppMethodBeat.i(190831);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(190831);
    return this;
  }
  
  public final ch kl(String paramString)
  {
    AppMethodBeat.i(190832);
    this.dOB = t("audienceUserName", paramString, true);
    AppMethodBeat.o(190832);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ch
 * JD-Core Version:    0.7.0.1
 */