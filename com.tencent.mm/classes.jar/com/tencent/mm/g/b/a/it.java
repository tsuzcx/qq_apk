package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class it
  extends a
{
  public long elA = 0L;
  public String elB = "";
  
  public final String PR()
  {
    AppMethodBeat.i(116506);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elB);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(116506);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(116507);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("canPreload:").append(this.elA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("existPkgInfo:").append(this.elB);
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
 * Qualified Name:     com.tencent.mm.g.b.a.it
 * JD-Core Version:    0.7.0.1
 */