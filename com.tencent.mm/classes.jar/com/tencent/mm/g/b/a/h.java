package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class h
  extends a
{
  private String cQc = "";
  private String cQd = "";
  public int cQe = 0;
  
  public final String Ff()
  {
    AppMethodBeat.i(73280);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cQc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cQe);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(73280);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(73281);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ChatroomName:").append(this.cQc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptScore:").append(this.cQd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExptFlag:").append(this.cQe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73281);
    return localObject;
  }
  
  public final h eT(String paramString)
  {
    AppMethodBeat.i(73278);
    this.cQc = t("ChatroomName", paramString, true);
    AppMethodBeat.o(73278);
    return this;
  }
  
  public final h eU(String paramString)
  {
    AppMethodBeat.i(73279);
    this.cQd = t("ExptScore", paramString, true);
    AppMethodBeat.o(73279);
    return this;
  }
  
  public final int getId()
  {
    return 15459;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.h
 * JD-Core Version:    0.7.0.1
 */