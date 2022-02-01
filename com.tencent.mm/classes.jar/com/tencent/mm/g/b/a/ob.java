package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ob
  extends a
{
  public long fiR = 0L;
  public String fiS = "";
  
  public final String abV()
  {
    AppMethodBeat.i(116506);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.fiR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.fiS);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(116506);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(116507);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("canPreload:").append(this.fiR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("existPkgInfo:").append(this.fiS);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(116507);
    return localObject;
  }
  
  public final int getId()
  {
    return 15779;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ob
 * JD-Core Version:    0.7.0.1
 */