package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gi
  extends a
{
  private long eJn;
  private String eJp = "";
  private String eoz = "";
  private String evo = "";
  private long ewu;
  
  public final String abV()
  {
    AppMethodBeat.i(200257);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ewu);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(200257);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(200258);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.eoz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.evo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.eJn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemSubId:").append(this.eJp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.ewu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(200258);
    return localObject;
  }
  
  public final int getId()
  {
    return 21947;
  }
  
  public final gi qf(long paramLong)
  {
    this.eJn = paramLong;
    return this;
  }
  
  public final gi qg(long paramLong)
  {
    this.ewu = paramLong;
    return this;
  }
  
  public final gi tS(String paramString)
  {
    AppMethodBeat.i(200254);
    this.eoz = x("ContextId", paramString, true);
    AppMethodBeat.o(200254);
    return this;
  }
  
  public final gi tT(String paramString)
  {
    AppMethodBeat.i(200255);
    this.evo = x("ItemId", paramString, true);
    AppMethodBeat.o(200255);
    return this;
  }
  
  public final gi tU(String paramString)
  {
    AppMethodBeat.i(200256);
    this.eJp = x("ItemSubId", paramString, true);
    AppMethodBeat.o(200256);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gi
 * JD-Core Version:    0.7.0.1
 */