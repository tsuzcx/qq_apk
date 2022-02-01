package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class n
  extends a
{
  public String dSm = "";
  public String dSn = "";
  public int dSo = 0;
  
  public final String RD()
  {
    AppMethodBeat.i(121744);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSn);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dSo);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(121744);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(121745);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.dSm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptScore:").append(this.dSn);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptFlag:").append(this.dSo);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121745);
    return localObject;
  }
  
  public final int getId()
  {
    return 15459;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.n
 * JD-Core Version:    0.7.0.1
 */