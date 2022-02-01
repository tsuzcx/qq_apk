package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class am
  extends a
{
  public long eoH;
  public long eoI;
  public long eoJ = 0L;
  public String eoK = "";
  
  public final String abV()
  {
    AppMethodBeat.i(224146);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eoH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoK);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(224146);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(224147);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ClickMethod:").append(this.eoH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UnreadNum:").append(this.eoI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("JumpToChatType:").append(this.eoJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UserName:").append(this.eoK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(224147);
    return localObject;
  }
  
  public final int getId()
  {
    return 20134;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.am
 * JD-Core Version:    0.7.0.1
 */