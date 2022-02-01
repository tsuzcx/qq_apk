package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dk
  extends a
{
  public String ehn = "";
  public long eho = 0L;
  public long ehp = 2L;
  public long ehq = 0L;
  public String ehr = "";
  public long ehs;
  public String eht = "";
  
  public final String RC()
  {
    AppMethodBeat.i(193969);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ehn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eho);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehp);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehr);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eht);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(193969);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(193970);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("HasConfirmed:").append(this.ehn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Oper:").append(this.eho);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSideNote:").append(this.ehp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalShareCount:").append(this.ehq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalShareCountByType:").append(this.ehr);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardScene:").append(this.ehs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsername:").append(this.eht);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(193970);
    return localObject;
  }
  
  public final int getId()
  {
    return 20559;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dk
 * JD-Core Version:    0.7.0.1
 */