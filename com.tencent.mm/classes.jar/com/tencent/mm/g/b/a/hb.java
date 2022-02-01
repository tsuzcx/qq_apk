package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class hb
  extends a
{
  public long ejw = 0L;
  public String ejx = "";
  
  public final String PV()
  {
    AppMethodBeat.i(116506);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ejw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejx);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(116506);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(116507);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("canPreload:").append(this.ejw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("existPkgInfo:").append(this.ejx);
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
 * Qualified Name:     com.tencent.mm.g.b.a.hb
 * JD-Core Version:    0.7.0.1
 */