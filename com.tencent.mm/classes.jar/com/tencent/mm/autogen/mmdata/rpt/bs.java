package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bs
  extends a
{
  public long ijg;
  public long iuq;
  public int iur;
  public int ius;
  public int iut;
  public int iuu;
  public int iuv;
  
  public final String aIE()
  {
    AppMethodBeat.i(368842);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.iuq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ijg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iur);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ius);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iut);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iuv);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368842);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368845);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("result:").append(this.iuq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errType:").append(this.ijg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emojiCount:").append(this.iur);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldVersion:").append(this.ius);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("newVersion:").append(this.iut);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("subType:").append(this.iuu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.iuv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368845);
    return localObject;
  }
  
  public final int getId()
  {
    return 21843;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.bs
 * JD-Core Version:    0.7.0.1
 */