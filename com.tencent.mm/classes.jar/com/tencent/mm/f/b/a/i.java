package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class i
  extends a
{
  public long gdX = 0L;
  public String gdY = "";
  public long gdZ = 0L;
  public long gea;
  public long geb = 0L;
  public long gec = 0L;
  
  public final String agH()
  {
    AppMethodBeat.i(240324);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gdX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gea);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gec);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(240324);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(240327);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("index:").append(this.gdX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("usrType:").append(this.gdY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("isTop:").append(this.gdZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("lastTime:").append(this.gea);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("sil:").append(this.geb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("unread:").append(this.gec);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(240327);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.i
 * JD-Core Version:    0.7.0.1
 */