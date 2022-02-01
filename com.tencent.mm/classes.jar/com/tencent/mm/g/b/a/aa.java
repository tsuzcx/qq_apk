package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aa
  extends a
{
  public String eiB = "";
  public long enl;
  public long enm;
  public long enn;
  
  public final String abV()
  {
    AppMethodBeat.i(163174);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.enl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enm);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.enn);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(163174);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(163175);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("ActionType:").append(this.enl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SessionId:").append(this.eiB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WeShiCount:").append(this.enm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickTime:").append(this.enn);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(163175);
    return localObject;
  }
  
  public final int getId()
  {
    return 18869;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aa
 * JD-Core Version:    0.7.0.1
 */