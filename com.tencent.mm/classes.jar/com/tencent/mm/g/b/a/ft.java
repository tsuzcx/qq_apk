package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class ft
  extends a
{
  private String dSb = "";
  private int elS = 0;
  private int elT = 0;
  private int elU = 0;
  private int elV = 0;
  private String elW = "";
  private int elX = 0;
  private int elY = 0;
  private String elZ = "";
  private long ema = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(118493);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dSb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.elZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ema);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118493);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118494);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionId:").append(this.dSb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeViewId:").append(this.elS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeOrder:").append(this.elT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinCount:").append(this.elU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewFavorUinCount:").append(this.elV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeNewUinList:").append(this.elW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinCount:").append(this.elX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeFavorUinCount:").append(this.elY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ExposeBeforeUinList:").append(this.elZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InteractiveUserCount:").append(this.ema);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118494);
    return localObject;
  }
  
  public final int Tw()
  {
    return this.elS;
  }
  
  public final int Tx()
  {
    return this.elV;
  }
  
  public final int Ty()
  {
    return this.elY;
  }
  
  public final int getId()
  {
    return 16887;
  }
  
  public final ft iE(int paramInt)
  {
    this.elS = paramInt;
    return this;
  }
  
  public final ft iF(int paramInt)
  {
    this.elT = paramInt;
    return this;
  }
  
  public final ft iG(int paramInt)
  {
    this.elU = paramInt;
    return this;
  }
  
  public final ft iH(int paramInt)
  {
    this.elV = paramInt;
    return this;
  }
  
  public final ft iI(int paramInt)
  {
    this.elX = paramInt;
    return this;
  }
  
  public final ft iJ(int paramInt)
  {
    this.elY = paramInt;
    return this;
  }
  
  public final ft kQ(long paramLong)
  {
    this.ema = paramLong;
    return this;
  }
  
  public final ft oJ(String paramString)
  {
    AppMethodBeat.i(118490);
    this.dSb = t("SessionId", paramString, true);
    AppMethodBeat.o(118490);
    return this;
  }
  
  public final ft oK(String paramString)
  {
    AppMethodBeat.i(118491);
    this.elW = t("ExposeNewUinList", paramString, true);
    AppMethodBeat.o(118491);
    return this;
  }
  
  public final ft oL(String paramString)
  {
    AppMethodBeat.i(118492);
    this.elZ = t("ExposeBeforeUinList", paramString, true);
    AppMethodBeat.o(118492);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ft
 * JD-Core Version:    0.7.0.1
 */