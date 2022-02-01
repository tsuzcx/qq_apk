package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cp
  extends a
{
  public long dCS;
  private String dDw;
  public long dPX;
  public long dPY;
  
  public final String PR()
  {
    AppMethodBeat.i(207480);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dDw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dCS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPY);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(207480);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(207481);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.dDw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.dCS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.dPX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pageid:").append(this.dPY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(207481);
    return localObject;
  }
  
  public final int getId()
  {
    return 19818;
  }
  
  public final cp kA(String paramString)
  {
    AppMethodBeat.i(207479);
    this.dDw = t("sessionid", paramString, true);
    AppMethodBeat.o(207479);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cp
 * JD-Core Version:    0.7.0.1
 */