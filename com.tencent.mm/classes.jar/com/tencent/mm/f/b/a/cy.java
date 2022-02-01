package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cy
  extends a
{
  private String ggA = "";
  private String ggC = "";
  private int ggl;
  private int glq;
  private int grt;
  private String gru = "";
  private int grv;
  private int grw;
  private String grx = "";
  
  public final String agH()
  {
    AppMethodBeat.i(210099);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ggA);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gru);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ggl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glq);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.grx);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(210099);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(210103);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("sessionid:").append(this.ggA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("clickTabContextid:").append(this.ggC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("commentScene:").append(this.grt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ItemId:").append(this.gru);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Position:").append(this.grv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.ggl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("myAccountType:").append(this.grw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actionType:").append(this.glq);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("reasonId:").append(this.grx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(210103);
    return localObject;
  }
  
  public final cy ahS()
  {
    this.ggl = 1;
    return this;
  }
  
  public final cy ahT()
  {
    this.grw = 1;
    return this;
  }
  
  public final int getId()
  {
    return 22080;
  }
  
  public final cy lv(int paramInt)
  {
    this.grt = paramInt;
    return this;
  }
  
  public final cy lw(int paramInt)
  {
    this.grv = paramInt;
    return this;
  }
  
  public final cy lx(int paramInt)
  {
    this.glq = paramInt;
    return this;
  }
  
  public final cy oa(String paramString)
  {
    AppMethodBeat.i(210091);
    this.ggA = z("sessionid", paramString, true);
    AppMethodBeat.o(210091);
    return this;
  }
  
  public final cy ob(String paramString)
  {
    AppMethodBeat.i(210092);
    this.ggC = z("clickTabContextid", paramString, true);
    AppMethodBeat.o(210092);
    return this;
  }
  
  public final cy oc(String paramString)
  {
    AppMethodBeat.i(210093);
    this.gru = z("ItemId", paramString, true);
    AppMethodBeat.o(210093);
    return this;
  }
  
  public final cy od(String paramString)
  {
    AppMethodBeat.i(210097);
    this.grx = z("reasonId", paramString, true);
    AppMethodBeat.o(210097);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.cy
 * JD-Core Version:    0.7.0.1
 */