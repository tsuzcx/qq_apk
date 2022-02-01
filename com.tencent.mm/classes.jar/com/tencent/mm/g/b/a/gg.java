package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gg
  extends a
{
  private long eDd;
  private long eJn;
  private long eJo;
  private String eJp = "";
  private long eJq;
  private long ejA;
  private String eoz = "";
  private String evo = "";
  
  public final String abV()
  {
    AppMethodBeat.i(200247);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eDd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJq);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(200247);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(200248);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.eJn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.evo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.eDd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeTimestamp:").append(this.eJo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.ejA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemSubId:").append(this.eJp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActualExposeTimestamp:").append(this.eJq);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(200248);
    return localObject;
  }
  
  public final int getId()
  {
    return 21922;
  }
  
  public final gg pX(long paramLong)
  {
    this.eJn = paramLong;
    return this;
  }
  
  public final gg pY(long paramLong)
  {
    this.eDd = paramLong;
    return this;
  }
  
  public final gg pZ(long paramLong)
  {
    this.eJo = paramLong;
    return this;
  }
  
  public final gg qa(long paramLong)
  {
    this.ejA = paramLong;
    return this;
  }
  
  public final gg qb(long paramLong)
  {
    this.eJq = paramLong;
    return this;
  }
  
  public final gg tM(String paramString)
  {
    AppMethodBeat.i(200244);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(200244);
    return this;
  }
  
  public final gg tN(String paramString)
  {
    AppMethodBeat.i(200245);
    this.evo = x("ItemId", paramString, true);
    AppMethodBeat.o(200245);
    return this;
  }
  
  public final gg tO(String paramString)
  {
    AppMethodBeat.i(200246);
    this.eJp = x("ItemSubId", paramString, true);
    AppMethodBeat.o(200246);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gg
 * JD-Core Version:    0.7.0.1
 */