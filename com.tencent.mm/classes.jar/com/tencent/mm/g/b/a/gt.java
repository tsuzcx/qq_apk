package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gt
  extends a
{
  private String eKU = "";
  private String eKV = "";
  public long ejW;
  
  public final String abV()
  {
    AppMethodBeat.i(193999);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eKU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eKV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ejW);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(193999);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(194000);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("roomID:").append(this.eKU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("oldRoomID:").append(this.eKV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("action:").append(this.ejW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(194000);
    return localObject;
  }
  
  public final int getId()
  {
    return 20246;
  }
  
  public final gt uw(String paramString)
  {
    AppMethodBeat.i(193997);
    this.eKU = x("roomID", paramString, true);
    AppMethodBeat.o(193997);
    return this;
  }
  
  public final gt ux(String paramString)
  {
    AppMethodBeat.i(193998);
    this.eKV = x("oldRoomID", paramString, true);
    AppMethodBeat.o(193998);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gt
 * JD-Core Version:    0.7.0.1
 */