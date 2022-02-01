package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gh
  extends a
{
  private long eJn;
  private String eJp = "";
  private long eJr;
  private String eoz = "";
  private long ete;
  private String evo = "";
  
  public final String abV()
  {
    AppMethodBeat.i(200252);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.evo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ete);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJp);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(200252);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(200253);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ItemId:").append(this.evo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.eJn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AddType:").append(this.eJr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Status:").append(this.ete);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemSubId:").append(this.eJp);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(200253);
    return localObject;
  }
  
  public final int getId()
  {
    return 21935;
  }
  
  public final gh qc(long paramLong)
  {
    this.eJn = paramLong;
    return this;
  }
  
  public final gh qd(long paramLong)
  {
    this.eJr = paramLong;
    return this;
  }
  
  public final gh qe(long paramLong)
  {
    this.ete = paramLong;
    return this;
  }
  
  public final gh tP(String paramString)
  {
    AppMethodBeat.i(200249);
    this.evo = x("ItemId", paramString, true);
    AppMethodBeat.o(200249);
    return this;
  }
  
  public final gh tQ(String paramString)
  {
    AppMethodBeat.i(200250);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(200250);
    return this;
  }
  
  public final gh tR(String paramString)
  {
    AppMethodBeat.i(200251);
    this.eJp = x("ItemSubId", paramString, true);
    AppMethodBeat.o(200251);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gh
 * JD-Core Version:    0.7.0.1
 */