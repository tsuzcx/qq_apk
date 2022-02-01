package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mh
  extends a
{
  public long ime;
  public long jbx;
  public String jby = "";
  
  public final String aIE()
  {
    AppMethodBeat.i(368399);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.jbx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ime);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.jby);
    localObject = ((StringBuffer)localObject).toString();
    aUm((String)localObject);
    AppMethodBeat.o(368399);
    return localObject;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(368405);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("wording_type:").append(this.jbx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action_type:").append(this.ime);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("wording:").append(this.jby);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(368405);
    return localObject;
  }
  
  public final int getId()
  {
    return 24336;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.mh
 * JD-Core Version:    0.7.0.1
 */