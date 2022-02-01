package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ic
  extends a
{
  private long gHS;
  private String gHT = "";
  private long gHU;
  private long gef;
  private String gjj = "";
  private long glS;
  private String gru = "";
  private long gzP;
  
  public final String agH()
  {
    AppMethodBeat.i(249108);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gzP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHU);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(249108);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(249110);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.glS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.gru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.gzP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeTimestamp:").append(this.gHS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemSubId:").append(this.gHT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActualExposeTimestamp:").append(this.gHU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(249110);
    return localObject;
  }
  
  public final int getId()
  {
    return 21922;
  }
  
  public final ic ss(long paramLong)
  {
    this.glS = paramLong;
    return this;
  }
  
  public final ic st(long paramLong)
  {
    this.gzP = paramLong;
    return this;
  }
  
  public final ic su(long paramLong)
  {
    this.gHS = paramLong;
    return this;
  }
  
  public final ic sv(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final ic sw(long paramLong)
  {
    this.gHU = paramLong;
    return this;
  }
  
  public final ic xF(String paramString)
  {
    AppMethodBeat.i(249100);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(249100);
    return this;
  }
  
  public final ic xG(String paramString)
  {
    AppMethodBeat.i(249102);
    this.gru = z("ItemId", paramString, true);
    AppMethodBeat.o(249102);
    return this;
  }
  
  public final ic xH(String paramString)
  {
    AppMethodBeat.i(249107);
    this.gHT = z("ItemSubId", paramString, true);
    AppMethodBeat.o(249107);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ic
 * JD-Core Version:    0.7.0.1
 */