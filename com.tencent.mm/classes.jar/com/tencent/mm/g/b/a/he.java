package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class he
  extends a
{
  public long eLv = 0L;
  public String eLw = "";
  public long eLx = 0L;
  
  public final String abV()
  {
    AppMethodBeat.i(149924);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eLv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eLx);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(149924);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(149925);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.eLv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.eLw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("hasTxt:").append(this.eLx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149925);
    return localObject;
  }
  
  public final int getId()
  {
    return 16872;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.he
 * JD-Core Version:    0.7.0.1
 */