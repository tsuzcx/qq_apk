package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eq
  extends a
{
  private long gcX;
  private String gfl = "";
  private String gjk = "";
  private long goh;
  private String gyk = "";
  private String gyl = "";
  private String gym = "";
  private long gyn;
  private long gyo;
  private long gyp;
  private long gyq;
  private long gyr;
  
  public final String agH()
  {
    AppMethodBeat.i(209967);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gfl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gjk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gym);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyr);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209967);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209968);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionId:").append(this.gfl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTabContextId:").append(this.gjk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.goh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchSessionId:").append(this.gyk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("requestId:").append(this.gyl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("query:").append(this.gym);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchScene:").append(this.gyn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.gyo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.gcX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchResultType:").append(this.gyp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isAccountEmpty:").append(this.gyq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isFeedEmpty:").append(this.gyr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209968);
    return localObject;
  }
  
  public final eq akd()
  {
    this.goh = 1L;
    return this;
  }
  
  public final int getId()
  {
    return 21690;
  }
  
  public final eq mh(long paramLong)
  {
    this.gyn = paramLong;
    return this;
  }
  
  public final eq mi(long paramLong)
  {
    this.gyo = paramLong;
    return this;
  }
  
  public final eq mj(long paramLong)
  {
    this.gcX = paramLong;
    return this;
  }
  
  public final eq mk(long paramLong)
  {
    this.gyp = paramLong;
    return this;
  }
  
  public final eq ml(long paramLong)
  {
    this.gyq = paramLong;
    return this;
  }
  
  public final eq mm(long paramLong)
  {
    this.gyr = paramLong;
    return this;
  }
  
  public final eq sP(String paramString)
  {
    AppMethodBeat.i(209959);
    this.gfl = z("sessionId", paramString, true);
    AppMethodBeat.o(209959);
    return this;
  }
  
  public final eq sQ(String paramString)
  {
    AppMethodBeat.i(209960);
    this.gjk = z("ClickTabContextId", paramString, true);
    AppMethodBeat.o(209960);
    return this;
  }
  
  public final eq sR(String paramString)
  {
    AppMethodBeat.i(209961);
    this.gyk = z("searchSessionId", paramString, true);
    AppMethodBeat.o(209961);
    return this;
  }
  
  public final eq sS(String paramString)
  {
    AppMethodBeat.i(209962);
    this.gyl = z("requestId", paramString, true);
    AppMethodBeat.o(209962);
    return this;
  }
  
  public final eq sT(String paramString)
  {
    AppMethodBeat.i(209963);
    this.gym = z("query", paramString, true);
    AppMethodBeat.o(209963);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.eq
 * JD-Core Version:    0.7.0.1
 */