package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class mm
  extends a
{
  private long gBe;
  private String gHP = "";
  private String gUb = "";
  private int gUt;
  private String gUu = "";
  private long gef;
  private String gjO = "";
  
  public final mm Da(String paramString)
  {
    AppMethodBeat.i(237916);
    this.gjO = z("SessionID", paramString, true);
    AppMethodBeat.o(237916);
    return this;
  }
  
  public final mm Db(String paramString)
  {
    AppMethodBeat.i(237919);
    this.gUb = z("IconID", paramString, true);
    AppMethodBeat.o(237919);
    return this;
  }
  
  public final mm Dc(String paramString)
  {
    AppMethodBeat.i(237920);
    this.gHP = z("ToUsername", paramString, true);
    AppMethodBeat.o(237920);
    return this;
  }
  
  public final mm Dd(String paramString)
  {
    AppMethodBeat.i(237921);
    this.gUu = z("UvPerIcon", paramString, true);
    AppMethodBeat.o(237921);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(237923);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gjO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gef);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gHP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUt);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gUu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBe);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(237923);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(237924);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SessionID:").append(this.gjO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Action:").append(this.gef);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IconID:").append(this.gUb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUsername:").append(this.gHP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("SameStatusUsersCount:").append(this.gUt);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UvPerIcon:").append(this.gUu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Source:").append(this.gBe);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(237924);
    return localObject;
  }
  
  public final int getId()
  {
    return 22663;
  }
  
  public final mm nR(int paramInt)
  {
    this.gUt = paramInt;
    return this;
  }
  
  public final mm ya(long paramLong)
  {
    this.gef = paramLong;
    return this;
  }
  
  public final mm yb(long paramLong)
  {
    this.gBe = paramLong;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.mm
 * JD-Core Version:    0.7.0.1
 */