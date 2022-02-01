package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ch
  extends a
{
  private String els = "";
  private String elu = "";
  private int enq;
  private int eqe;
  private int evn;
  private String evo = "";
  private int evp;
  private int evq;
  
  public final String abV()
  {
    AppMethodBeat.i(209001);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evo);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.evq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eqe);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(209001);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(209002);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextid:").append(this.elu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.evn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.evo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.evp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.enq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.evq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.eqe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(209002);
    return localObject;
  }
  
  public final ch adc()
  {
    this.enq = 1;
    return this;
  }
  
  public final ch ade()
  {
    this.evq = 1;
    return this;
  }
  
  public final int getId()
  {
    return 22080;
  }
  
  public final ch kb(int paramInt)
  {
    this.evn = paramInt;
    return this;
  }
  
  public final ch kc(int paramInt)
  {
    this.evp = paramInt;
    return this;
  }
  
  public final ch kd(int paramInt)
  {
    this.eqe = paramInt;
    return this;
  }
  
  public final ch lI(String paramString)
  {
    AppMethodBeat.i(208998);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(208998);
    return this;
  }
  
  public final ch lJ(String paramString)
  {
    AppMethodBeat.i(208999);
    this.elu = x("clickTabContextid", paramString, true);
    AppMethodBeat.o(208999);
    return this;
  }
  
  public final ch lK(String paramString)
  {
    AppMethodBeat.i(209000);
    this.evo = x("ItemId", paramString, true);
    AppMethodBeat.o(209000);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ch
 * JD-Core Version:    0.7.0.1
 */