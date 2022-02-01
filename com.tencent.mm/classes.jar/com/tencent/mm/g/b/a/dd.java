package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dd
  extends a
{
  private String els = "";
  private String eno = "";
  private int enq;
  private int eqe;
  private String eqv = "";
  private String esd = "";
  private int evn;
  private String evo = "";
  private int evp;
  private int evq;
  private int ezc;
  private int ezd;
  private String eze = "";
  private int ezf;
  
  public final String abV()
  {
    AppMethodBeat.i(209097);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eno);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.esd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eze);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ezf);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209097);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209098);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RequestId:").append(this.eno);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Query:").append(this.eqv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RequestType:").append(this.ezc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemType:").append(this.ezd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.evo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.evq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clicktabcontextid:").append(this.esd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.evn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchSessionid:").append(this.eze);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.eqe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("searchType:").append(this.ezf);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209098);
    return localObject;
  }
  
  public final dd afc()
  {
    this.evq = 1;
    return this;
  }
  
  public final int getId()
  {
    return 22178;
  }
  
  public final dd kB(int paramInt)
  {
    this.ezc = paramInt;
    return this;
  }
  
  public final dd kC(int paramInt)
  {
    this.ezd = paramInt;
    return this;
  }
  
  public final dd kD(int paramInt)
  {
    this.evp = paramInt;
    return this;
  }
  
  public final dd kE(int paramInt)
  {
    this.enq = paramInt;
    return this;
  }
  
  public final dd kF(int paramInt)
  {
    this.evn = paramInt;
    return this;
  }
  
  public final dd kG(int paramInt)
  {
    this.eqe = paramInt;
    return this;
  }
  
  public final dd kH(int paramInt)
  {
    this.ezf = paramInt;
    return this;
  }
  
  public final dd ol(String paramString)
  {
    AppMethodBeat.i(209091);
    this.eno = x("RequestId", paramString, true);
    AppMethodBeat.o(209091);
    return this;
  }
  
  public final dd om(String paramString)
  {
    AppMethodBeat.i(209092);
    this.eqv = x("Query", paramString, true);
    AppMethodBeat.o(209092);
    return this;
  }
  
  public final dd on(String paramString)
  {
    AppMethodBeat.i(209093);
    this.evo = x("ItemId", paramString, true);
    AppMethodBeat.o(209093);
    return this;
  }
  
  public final dd oo(String paramString)
  {
    AppMethodBeat.i(209094);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(209094);
    return this;
  }
  
  public final dd op(String paramString)
  {
    AppMethodBeat.i(209095);
    this.esd = x("clicktabcontextid", paramString, true);
    AppMethodBeat.o(209095);
    return this;
  }
  
  public final dd oq(String paramString)
  {
    AppMethodBeat.i(209096);
    this.eze = x("searchSessionid", paramString, true);
    AppMethodBeat.o(209096);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dd
 * JD-Core Version:    0.7.0.1
 */