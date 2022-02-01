package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gy
  extends a
{
  public long eLg = 0L;
  private String eLh = "";
  private String eLi = "";
  public int eLj;
  
  public final String abV()
  {
    AppMethodBeat.i(231492);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eLi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLj);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(231492);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(231493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("RoomName:").append(this.eLi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsRedDot:").append(this.eLg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppList:").append(this.eLh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PanelPage:").append(this.eLj);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(231493);
    return localObject;
  }
  
  public final int getId()
  {
    return 19959;
  }
  
  public final gy uN(String paramString)
  {
    AppMethodBeat.i(231490);
    this.eLi = x("RoomName", paramString, true);
    AppMethodBeat.o(231490);
    return this;
  }
  
  public final gy uO(String paramString)
  {
    AppMethodBeat.i(231491);
    this.eLh = x("AppList", paramString, true);
    AppMethodBeat.o(231491);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gy
 * JD-Core Version:    0.7.0.1
 */