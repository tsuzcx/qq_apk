package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ec
  extends a
{
  private int eCs;
  private long eCt = -1L;
  private String eCu = "";
  private String eCv = "";
  private int eCw = -1;
  private String eCx = "";
  private long eCy = -1L;
  private long eCz = -1L;
  private long eiE;
  private String eyH = "";
  
  public final String abV()
  {
    AppMethodBeat.i(209216);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eCs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eyH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCy);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eCz);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209216);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209217);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("innerversion:").append(this.eCs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionCode:").append(this.eCt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionName:").append(this.eCu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionExt:").append(this.eCv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("result:").append(this.eCw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("resultExt:").append(this.eCx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.eiE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("snn:").append(this.eyH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cost:").append(this.eCy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionTime:").append(this.eCz);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209217);
    return localObject;
  }
  
  public final ec afx()
  {
    this.eCs = 8;
    return this;
  }
  
  public final int getId()
  {
    return 22138;
  }
  
  public final ec lA(long paramLong)
  {
    this.eiE = paramLong;
    return this;
  }
  
  public final ec lB(long paramLong)
  {
    this.eCy = paramLong;
    return this;
  }
  
  public final ec lC(long paramLong)
  {
    this.eCz = paramLong;
    return this;
  }
  
  public final ec le(int paramInt)
  {
    this.eCw = paramInt;
    return this;
  }
  
  public final ec lz(long paramLong)
  {
    this.eCt = paramLong;
    return this;
  }
  
  public final ec qF(String paramString)
  {
    AppMethodBeat.i(209212);
    this.eCu = x("actionName", paramString, true);
    AppMethodBeat.o(209212);
    return this;
  }
  
  public final ec qG(String paramString)
  {
    AppMethodBeat.i(209213);
    this.eCv = x("actionExt", paramString, true);
    AppMethodBeat.o(209213);
    return this;
  }
  
  public final ec qH(String paramString)
  {
    AppMethodBeat.i(209214);
    this.eCx = x("resultExt", paramString, true);
    AppMethodBeat.o(209214);
    return this;
  }
  
  public final ec qI(String paramString)
  {
    AppMethodBeat.i(209215);
    this.eyH = x("snn", paramString, true);
    AppMethodBeat.o(209215);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ec
 * JD-Core Version:    0.7.0.1
 */