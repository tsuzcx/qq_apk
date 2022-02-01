package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fg
  extends a
{
  public int dRj = -1;
  public int dTw = -1;
  private String dYc = "";
  private String elg = "";
  public int ema = -1;
  public int emb = -1;
  
  public final String RC()
  {
    AppMethodBeat.i(94847);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dYc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dRj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ema);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dTw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emb);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(94847);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(94848);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Username:").append(this.dYc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PublishId:").append(this.elg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.dRj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("OnDestroyAction:").append(this.ema);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.dTw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StayTime:").append(this.emb);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(94848);
    return localObject;
  }
  
  public final int getId()
  {
    return 18197;
  }
  
  public final fg oI(String paramString)
  {
    AppMethodBeat.i(94845);
    this.dYc = t("Username", paramString, true);
    AppMethodBeat.o(94845);
    return this;
  }
  
  public final fg oJ(String paramString)
  {
    AppMethodBeat.i(94846);
    this.elg = t("PublishId", paramString, true);
    AppMethodBeat.o(94846);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.fg
 * JD-Core Version:    0.7.0.1
 */