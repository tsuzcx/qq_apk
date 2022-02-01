package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bp
  extends a
{
  public int imW;
  public int itZ;
  public long iua;
  public long iub;
  public int iuc = 0;
  public int iud = 0;
  public int iue = 0;
  
  public final String aIE()
  {
    AppMethodBeat.i(368816);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.imW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.itZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iua);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iub);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iud);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iue);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368816);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368820);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Scene:").append(this.imW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RenderType:").append(this.itZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateCost:").append(this.iua);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RenderCost:").append(this.iub);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SizeError:").append(this.iuc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InputError:").append(this.iud);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputError:").append(this.iue);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368820);
    return localObject;
  }
  
  public final int getId()
  {
    return 23689;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bp
 * JD-Core Version:    0.7.0.1
 */