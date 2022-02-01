package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class er
  extends a
{
  private String ggA = "";
  private int ggl;
  private String git = "";
  private String glM = "";
  private int glq;
  private String goj = "";
  private int grt;
  private String gru = "";
  private int grv;
  private int grw;
  private int gys;
  private int gyt;
  private String gyu = "";
  private int gyv;
  
  public final String agH()
  {
    AppMethodBeat.i(210434);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.git);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gys);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyv);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210434);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210437);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.git);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.glM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestType:").append(this.gys);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.gyt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.gru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.grv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.grw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.goj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.grt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchSessionid:").append(this.gyu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.glq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.gyv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210437);
    return localObject;
  }
  
  public final er ake()
  {
    this.grw = 1;
    return this;
  }
  
  public final er akf()
  {
    this.glq = 2;
    return this;
  }
  
  public final int getId()
  {
    return 18690;
  }
  
  public final er md(int paramInt)
  {
    this.gys = paramInt;
    return this;
  }
  
  public final er me(int paramInt)
  {
    this.gyt = paramInt;
    return this;
  }
  
  public final er mf(int paramInt)
  {
    this.grv = paramInt;
    return this;
  }
  
  public final er mg(int paramInt)
  {
    this.ggl = paramInt;
    return this;
  }
  
  public final er mh(int paramInt)
  {
    this.grt = paramInt;
    return this;
  }
  
  public final er mi(int paramInt)
  {
    this.gyv = paramInt;
    return this;
  }
  
  public final er sU(String paramString)
  {
    AppMethodBeat.i(210411);
    this.git = z("RequestId", paramString, true);
    AppMethodBeat.o(210411);
    return this;
  }
  
  public final er sV(String paramString)
  {
    AppMethodBeat.i(210414);
    this.glM = z("Query", paramString, true);
    AppMethodBeat.o(210414);
    return this;
  }
  
  public final er sW(String paramString)
  {
    AppMethodBeat.i(210418);
    this.gru = z("ItemId", paramString, true);
    AppMethodBeat.o(210418);
    return this;
  }
  
  public final er sX(String paramString)
  {
    AppMethodBeat.i(210424);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(210424);
    return this;
  }
  
  public final er sY(String paramString)
  {
    AppMethodBeat.i(210425);
    this.goj = z("clicktabcontextid", paramString, true);
    AppMethodBeat.o(210425);
    return this;
  }
  
  public final er sZ(String paramString)
  {
    AppMethodBeat.i(210429);
    this.gyu = z("searchSessionid", paramString, true);
    AppMethodBeat.o(210429);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.er
 * JD-Core Version:    0.7.0.1
 */