package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gc
  extends a
{
  public long eIu;
  public long eIv;
  public long ejW;
  private String els = "";
  
  public final String abV()
  {
    AppMethodBeat.i(186335);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.els);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eIv);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(186335);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(186336);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.els);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errortype:").append(this.eIu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pageid:").append(this.eIv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186336);
    return localObject;
  }
  
  public final int getId()
  {
    return 19818;
  }
  
  public final gc tm(String paramString)
  {
    AppMethodBeat.i(186334);
    this.els = x("sessionid", paramString, true);
    AppMethodBeat.o(186334);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gc
 * JD-Core Version:    0.7.0.1
 */