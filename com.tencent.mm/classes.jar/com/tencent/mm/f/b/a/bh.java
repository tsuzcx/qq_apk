package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class bh
  extends a
{
  public int ggm = -1;
  public int gmf = -1;
  public int gmg = -1;
  private String gmh = "";
  
  public final String agH()
  {
    AppMethodBeat.i(191009);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gmf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gmh);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(191009);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(191016);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("EventType:").append(this.gmf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("FaceType:").append(this.gmg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorCode:").append(this.ggm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ErrorMsg:").append(this.gmh);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(191016);
    return localObject;
  }
  
  public final int getId()
  {
    return 21597;
  }
  
  public final bh jJ(String paramString)
  {
    AppMethodBeat.i(191002);
    this.gmh = z("ErrorMsg", paramString, true);
    AppMethodBeat.o(191002);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.bh
 * JD-Core Version:    0.7.0.1
 */