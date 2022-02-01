package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eu
  extends a
{
  private String dFe = "";
  private int dVB = 0;
  private int dVC = 0;
  private int dVD = 0;
  private int dVE = 0;
  private String dVF = "";
  private int dVG = 0;
  private int dVH = 0;
  private String dVI = "";
  private long dVJ = 0L;
  
  public final String PR()
  {
    AppMethodBeat.i(118493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dFe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVC);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVE);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVJ);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(118493);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(118494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dFe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.dVB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeOrder:").append(this.dVC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinCount:").append(this.dVD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewFavorUinCount:").append(this.dVE);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinList:").append(this.dVF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinCount:").append(this.dVG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeFavorUinCount:").append(this.dVH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinList:").append(this.dVI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.dVJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118494);
    return localObject;
  }
  
  public final int Rp()
  {
    return this.dVB;
  }
  
  public final int Rq()
  {
    return this.dVE;
  }
  
  public final int Rr()
  {
    return this.dVH;
  }
  
  public final int getId()
  {
    return 16887;
  }
  
  public final eu in(int paramInt)
  {
    this.dVB = paramInt;
    return this;
  }
  
  public final eu io(int paramInt)
  {
    this.dVC = paramInt;
    return this;
  }
  
  public final eu ip(int paramInt)
  {
    this.dVD = paramInt;
    return this;
  }
  
  public final eu iq(int paramInt)
  {
    this.dVE = paramInt;
    return this;
  }
  
  public final eu ir(int paramInt)
  {
    this.dVG = paramInt;
    return this;
  }
  
  public final eu is(int paramInt)
  {
    this.dVH = paramInt;
    return this;
  }
  
  public final eu je(long paramLong)
  {
    this.dVJ = paramLong;
    return this;
  }
  
  public final eu mw(String paramString)
  {
    AppMethodBeat.i(118490);
    this.dFe = t("SessionId", paramString, true);
    AppMethodBeat.o(118490);
    return this;
  }
  
  public final eu mx(String paramString)
  {
    AppMethodBeat.i(118491);
    this.dVF = t("ExposeNewUinList", paramString, true);
    AppMethodBeat.o(118491);
    return this;
  }
  
  public final eu my(String paramString)
  {
    AppMethodBeat.i(118492);
    this.dVI = t("ExposeBeforeUinList", paramString, true);
    AppMethodBeat.o(118492);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eu
 * JD-Core Version:    0.7.0.1
 */