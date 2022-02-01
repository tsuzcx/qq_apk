package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class c
  extends a
{
  public String eiP = "";
  public String eiQ = "";
  public long eiR;
  public String eiS = "";
  public String eiT = "";
  
  public final String abV()
  {
    AppMethodBeat.i(238828);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiT);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(238828);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(238829);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InputJson:").append(this.eiP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputJson:").append(this.eiQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.eiR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelMd5:").append(this.eiS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriInputJson:").append(this.eiT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(238829);
    return localObject;
  }
  
  public final int getId()
  {
    return 21520;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.c
 * JD-Core Version:    0.7.0.1
 */