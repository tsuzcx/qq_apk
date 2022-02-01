package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dw
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
    AppMethodBeat.i(209200);
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
    AppMethodBeat.o(209200);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209201);
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
    AppMethodBeat.o(209201);
    return localObject;
  }
  
  public final dw afi()
  {
    this.evq = 1;
    return this;
  }
  
  public final dw afj()
  {
    this.eqe = 2;
    return this;
  }
  
  public final int getId()
  {
    return 18690;
  }
  
  public final dw kX(int paramInt)
  {
    this.ezc = paramInt;
    return this;
  }
  
  public final dw kY(int paramInt)
  {
    this.ezd = paramInt;
    return this;
  }
  
  public final dw kZ(int paramInt)
  {
    this.evp = paramInt;
    return this;
  }
  
  public final dw la(int paramInt)
  {
    this.enq = paramInt;
    return this;
  }
  
  public final dw lb(int paramInt)
  {
    this.evn = paramInt;
    return this;
  }
  
  public final dw lc(int paramInt)
  {
    this.ezf = paramInt;
    return this;
  }
  
  public final dw qf(String paramString)
  {
    AppMethodBeat.i(209194);
    this.eno = x("RequestId", paramString, true);
    AppMethodBeat.o(209194);
    return this;
  }
  
  public final dw qg(String paramString)
  {
    AppMethodBeat.i(209195);
    this.eqv = x("Query", paramString, true);
    AppMethodBeat.o(209195);
    return this;
  }
  
  public final dw qh(String paramString)
  {
    AppMethodBeat.i(209196);
    this.evo = x("ItemId", paramString, true);
    AppMethodBeat.o(209196);
    return this;
  }
  
  public final dw qi(String paramString)
  {
    AppMethodBeat.i(209197);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(209197);
    return this;
  }
  
  public final dw qj(String paramString)
  {
    AppMethodBeat.i(209198);
    this.esd = x("clicktabcontextid", paramString, true);
    AppMethodBeat.o(209198);
    return this;
  }
  
  public final dw qk(String paramString)
  {
    AppMethodBeat.i(209199);
    this.eze = x("searchSessionid", paramString, true);
    AppMethodBeat.o(209199);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dw
 * JD-Core Version:    0.7.0.1
 */