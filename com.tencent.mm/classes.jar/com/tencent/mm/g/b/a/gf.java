package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gf
  extends a
{
  public String eJg = "";
  public long eJh = 0L;
  public long eJi = 2L;
  public long eJj = 0L;
  public String eJk = "";
  public long eJl;
  public String eJm = "";
  
  public final String abV()
  {
    AppMethodBeat.i(187891);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eJg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eJm);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(187891);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(187892);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("HasConfirmed:").append(this.eJg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Oper:").append(this.eJh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasSideNote:").append(this.eJi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalShareCount:").append(this.eJj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FinalShareCountByType:").append(this.eJk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ForwardScene:").append(this.eJl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsername:").append(this.eJm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(187892);
    return localObject;
  }
  
  public final int getId()
  {
    return 20559;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gf
 * JD-Core Version:    0.7.0.1
 */