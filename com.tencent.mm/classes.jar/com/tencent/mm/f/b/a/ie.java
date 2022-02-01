package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ie
  extends a
{
  private String gHT = "";
  private String gjj = "";
  private long glS;
  private String gru = "";
  private long gsB;
  
  public final String agH()
  {
    AppMethodBeat.i(249189);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gsB);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(249189);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(249190);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ContextId:").append(this.gjj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.gru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.glS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemSubId:").append(this.gHT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Duration:").append(this.gsB);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(249190);
    return localObject;
  }
  
  public final int getId()
  {
    return 21947;
  }
  
  public final ie sA(long paramLong)
  {
    this.glS = paramLong;
    return this;
  }
  
  public final ie sB(long paramLong)
  {
    this.gsB = paramLong;
    return this;
  }
  
  public final ie xL(String paramString)
  {
    AppMethodBeat.i(249185);
    this.gjj = z("ContextId", paramString, true);
    AppMethodBeat.o(249185);
    return this;
  }
  
  public final ie xM(String paramString)
  {
    AppMethodBeat.i(249186);
    this.gru = z("ItemId", paramString, true);
    AppMethodBeat.o(249186);
    return this;
  }
  
  public final ie xN(String paramString)
  {
    AppMethodBeat.i(249187);
    this.gHT = z("ItemSubId", paramString, true);
    AppMethodBeat.o(249187);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.ie
 * JD-Core Version:    0.7.0.1
 */