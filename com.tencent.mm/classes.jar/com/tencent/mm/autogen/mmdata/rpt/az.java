package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class az
  extends a
{
  public long ila;
  public long iqd;
  public long iqe;
  public long iqf;
  public long iqg;
  public long iqh;
  public long iqi;
  public long iqj;
  
  public final String aIE()
  {
    AppMethodBeat.i(368985);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ila);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.iqj);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368985);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368991);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("action:").append(this.ila);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("biz_type:").append(this.iqd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("auth_type:").append(this.iqe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selection_type:").append(this.iqf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selection_count:").append(this.iqg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("selection_fri_count:").append(this.iqh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("origin_list_fri_count:").append(this.iqi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("submit_fri_count:").append(this.iqj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368991);
    return localObject;
  }
  
  public final int getId()
  {
    return 22666;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.az
 * JD-Core Version:    0.7.0.1
 */