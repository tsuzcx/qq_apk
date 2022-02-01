package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class q
  extends a
{
  private String ilu = "";
  public int ilv;
  public int ilw;
  public int ilx;
  public int ily;
  private String ilz = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368578);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ilu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ily);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ilz);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368578);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368582);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Content:").append(this.ilu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfPlay:").append(this.ilv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfPlaySuccess:").append(this.ilw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayFailReason:").append(this.ilx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecentUse:").append(this.ily);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatId:").append(this.ilz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368582);
    return localObject;
  }
  
  public final int getId()
  {
    return 22146;
  }
  
  public final q kg(String paramString)
  {
    AppMethodBeat.i(368570);
    this.ilu = F("Content", paramString, true);
    AppMethodBeat.o(368570);
    return this;
  }
  
  public final q kh(String paramString)
  {
    AppMethodBeat.i(368574);
    this.ilz = F("ChatId", paramString, true);
    AppMethodBeat.o(368574);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.q
 * JD-Core Version:    0.7.0.1
 */