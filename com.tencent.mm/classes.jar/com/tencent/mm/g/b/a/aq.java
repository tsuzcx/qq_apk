package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aq
  extends a
{
  private String cUZ = "";
  public long cVa = 0L;
  public long cVb = 0L;
  
  public final String Ff()
  {
    AppMethodBeat.i(108837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cUZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVb);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108837);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108838);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("UserName:").append(this.cUZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.cVa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HasUnreadStoryTips:").append(this.cVb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108838);
    return localObject;
  }
  
  public final aq fX(String paramString)
  {
    AppMethodBeat.i(108836);
    this.cUZ = t("UserName", paramString, true);
    AppMethodBeat.o(108836);
    return this;
  }
  
  public final int getId()
  {
    return 16656;
  }
  
  public final String getUserName()
  {
    return this.cUZ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aq
 * JD-Core Version:    0.7.0.1
 */