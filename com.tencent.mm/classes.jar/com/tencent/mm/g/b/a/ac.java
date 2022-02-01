package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ac
  extends a
{
  public String enA = "";
  public String enB = "";
  public int enC = 0;
  
  public final String abV()
  {
    AppMethodBeat.i(121744);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enC);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(121744);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(121745);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.enA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptScore:").append(this.enB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptFlag:").append(this.enC);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121745);
    return localObject;
  }
  
  public final int getId()
  {
    return 15459;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ac
 * JD-Core Version:    0.7.0.1
 */