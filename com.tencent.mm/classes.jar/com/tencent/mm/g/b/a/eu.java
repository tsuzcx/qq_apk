package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eu
  extends a
{
  private String eEs = "";
  public long eEu;
  
  public final String abV()
  {
    AppMethodBeat.i(184630);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eEs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEu);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(184630);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(184631);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Roomid:").append(this.eEs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrCode:").append(this.eEu);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(184631);
    return localObject;
  }
  
  public final int getId()
  {
    return 19352;
  }
  
  public final eu rS(String paramString)
  {
    AppMethodBeat.i(184629);
    this.eEs = x("Roomid", paramString, true);
    AppMethodBeat.o(184629);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eu
 * JD-Core Version:    0.7.0.1
 */