package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dj
  extends a
{
  private String eba = "";
  private String ehi = "";
  private long ehj;
  private long ehk;
  private long ehl;
  private long ehm;
  
  public final String RC()
  {
    AppMethodBeat.i(191111);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eba);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehm);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(191111);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(191112);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EditId:").append(this.eba);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JsonInfo:").append(this.ehi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VideoCount:").append(this.ehj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ImageCount:").append(this.ehk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EditItemCount:").append(this.ehl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AudioCount:").append(this.ehm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(191112);
    return localObject;
  }
  
  public final int getId()
  {
    return 20741;
  }
  
  public final dj jS(long paramLong)
  {
    this.ehj = paramLong;
    return this;
  }
  
  public final dj jT(long paramLong)
  {
    this.ehk = paramLong;
    return this;
  }
  
  public final dj jU(long paramLong)
  {
    this.ehl = paramLong;
    return this;
  }
  
  public final dj jV(long paramLong)
  {
    this.ehm = paramLong;
    return this;
  }
  
  public final dj ni(String paramString)
  {
    AppMethodBeat.i(191109);
    this.eba = t("EditId", paramString, true);
    AppMethodBeat.o(191109);
    return this;
  }
  
  public final dj nj(String paramString)
  {
    AppMethodBeat.i(191110);
    this.ehi = t("JsonInfo", paramString, true);
    AppMethodBeat.o(191110);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dj
 * JD-Core Version:    0.7.0.1
 */