package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class es
  extends a
{
  private String gcU = "";
  private int giX;
  private String git = "";
  private String glM = "";
  private String gru = "";
  private String guW = "";
  private int gyA;
  private String gyB = "";
  private int gyC;
  private int gys;
  private int gyt;
  private int gyw;
  private int gyx;
  private int gyy;
  private String gyz = "";
  
  public final String agH()
  {
    AppMethodBeat.i(209572);
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
    ((StringBuffer)localObject).append(this.gyw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gcU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyz);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gyC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.guW);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(209572);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(209575);
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
    ((StringBuffer)localObject).append("ItemPosition:").append(this.gyw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchScene:").append(this.gyx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AccountType:").append(this.gyy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.gcU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClicktabcontextId:").append(this.gyz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CommentScene:").append(this.gyA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchSessionid:").append(this.gyB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ActionType:").append(this.giX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SearchType:").append(this.gyC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("udf_kv:").append(this.guW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209575);
    return localObject;
  }
  
  public final es akg()
  {
    this.gyy = 1;
    return this;
  }
  
  public final int getId()
  {
    return 22178;
  }
  
  public final es mj(int paramInt)
  {
    this.gys = paramInt;
    return this;
  }
  
  public final es mk(int paramInt)
  {
    this.gyt = paramInt;
    return this;
  }
  
  public final es ml(int paramInt)
  {
    this.gyw = paramInt;
    return this;
  }
  
  public final es mm(int paramInt)
  {
    this.gyx = paramInt;
    return this;
  }
  
  public final es mn(int paramInt)
  {
    this.gyA = paramInt;
    return this;
  }
  
  public final es mo(int paramInt)
  {
    this.giX = paramInt;
    return this;
  }
  
  public final es mp(int paramInt)
  {
    this.gyC = paramInt;
    return this;
  }
  
  public final es ta(String paramString)
  {
    AppMethodBeat.i(209549);
    this.git = z("RequestId", paramString, true);
    AppMethodBeat.o(209549);
    return this;
  }
  
  public final es tb(String paramString)
  {
    AppMethodBeat.i(209552);
    this.glM = z("Query", paramString, true);
    AppMethodBeat.o(209552);
    return this;
  }
  
  public final es tc(String paramString)
  {
    AppMethodBeat.i(209556);
    this.gru = z("ItemId", paramString, true);
    AppMethodBeat.o(209556);
    return this;
  }
  
  public final es td(String paramString)
  {
    AppMethodBeat.i(209561);
    this.gcU = z("SessionId", paramString, true);
    AppMethodBeat.o(209561);
    return this;
  }
  
  public final es te(String paramString)
  {
    AppMethodBeat.i(209564);
    this.gyz = z("ClicktabcontextId", paramString, true);
    AppMethodBeat.o(209564);
    return this;
  }
  
  public final es tf(String paramString)
  {
    AppMethodBeat.i(209568);
    this.gyB = z("SearchSessionid", paramString, true);
    AppMethodBeat.o(209568);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.es
 * JD-Core Version:    0.7.0.1
 */