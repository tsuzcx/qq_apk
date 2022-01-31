package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class aw
  extends a
{
  private String cSd = "";
  private int cVO = 0;
  private int cVP = 0;
  private int cVQ = 0;
  private int cVR = 0;
  private String cVS = "";
  private int cVT = 0;
  private int cVU = 0;
  private String cVV = "";
  private long cVW = 0L;
  
  public final int FA()
  {
    return this.cVR;
  }
  
  public final int FB()
  {
    return this.cVU;
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(108857);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cSd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVQ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cVW);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(108857);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(108858);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.cSd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.cVO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeOrder:").append(this.cVP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinCount:").append(this.cVQ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewFavorUinCount:").append(this.cVR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinList:").append(this.cVS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinCount:").append(this.cVT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeFavorUinCount:").append(this.cVU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinList:").append(this.cVV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.cVW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(108858);
    return localObject;
  }
  
  public final int Fz()
  {
    return this.cVO;
  }
  
  public final aw co(long paramLong)
  {
    this.cVW = paramLong;
    return this;
  }
  
  public final aw gD(int paramInt)
  {
    this.cVO = paramInt;
    return this;
  }
  
  public final aw gE(int paramInt)
  {
    this.cVP = paramInt;
    return this;
  }
  
  public final aw gF(int paramInt)
  {
    this.cVQ = paramInt;
    return this;
  }
  
  public final aw gG(int paramInt)
  {
    this.cVR = paramInt;
    return this;
  }
  
  public final aw gH(int paramInt)
  {
    this.cVT = paramInt;
    return this;
  }
  
  public final aw gI(int paramInt)
  {
    this.cVU = paramInt;
    return this;
  }
  
  public final int getId()
  {
    return 16887;
  }
  
  public final aw gj(String paramString)
  {
    AppMethodBeat.i(108854);
    this.cSd = t("SessionId", paramString, true);
    AppMethodBeat.o(108854);
    return this;
  }
  
  public final aw gk(String paramString)
  {
    AppMethodBeat.i(108855);
    this.cVS = t("ExposeNewUinList", paramString, true);
    AppMethodBeat.o(108855);
    return this;
  }
  
  public final aw gl(String paramString)
  {
    AppMethodBeat.i(108856);
    this.cVV = t("ExposeBeforeUinList", paramString, true);
    AppMethodBeat.o(108856);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.aw
 * JD-Core Version:    0.7.0.1
 */