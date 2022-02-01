package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class kb
  extends a
{
  public long eEq = 0L;
  public String eEr = "";
  
  public final String RC()
  {
    AppMethodBeat.i(116506);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eEq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eEr);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(116506);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(116507);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("canPreload:").append(this.eEq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("existPkgInfo:").append(this.eEr);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116507);
    return localObject;
  }
  
  public final int getId()
  {
    return 15779;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.b.a.kb
 * JD-Core Version:    0.7.0.1
 */