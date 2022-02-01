package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class d
  extends a
{
  public String gdi = "";
  public String gdj = "";
  public long gdk;
  public String gdl = "";
  public String gdm = "";
  
  public final String agH()
  {
    AppMethodBeat.i(240249);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gdi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdm);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(240249);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(240252);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("InputJson:").append(this.gdi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OutputJson:").append(this.gdj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.gdk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ModelMd5:").append(this.gdl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OriInputJson:").append(this.gdm);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(240252);
    return localObject;
  }
  
  public final int getId()
  {
    return 21520;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.d
 * JD-Core Version:    0.7.0.1
 */