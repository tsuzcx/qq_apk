package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class oa
  extends a
{
  public String ikF = "";
  public long jfa = 0L;
  public int jhV = 0;
  public long jhW = -1L;
  public String jhX = "";
  public int jhY = -1;
  public int jhZ = -1;
  
  public final String aIE()
  {
    AppMethodBeat.i(368050);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jfa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jhV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jhW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jhX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ikF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jhY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jhZ);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368050);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368056);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("OriginDbCount:").append(this.jfa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SqlType:").append(this.jhV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExecuteTime:").append(this.jhW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Sql:").append(this.jhX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Stack:").append(this.ikF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsBeforeFirstTimeClean:").append(this.jhY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsMainThread:").append(this.jhZ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368056);
    return localObject;
  }
  
  public final int getId()
  {
    return 23845;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.oa
 * JD-Core Version:    0.7.0.1
 */