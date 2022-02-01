package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class o
  extends a
{
  private String geV = "";
  private int geW;
  private int geX;
  private int geY;
  private int geZ;
  private String gfa = "";
  
  public final String agH()
  {
    AppMethodBeat.i(235835);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.geV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.geZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gfa);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(235835);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(235837);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Content:").append(this.geV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfPlay:").append(this.geW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IfPlaySuccess:").append(this.geX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PlayFailReason:").append(this.geY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecentUse:").append(this.geZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ChatId:").append(this.gfa);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(235837);
    return localObject;
  }
  
  public final o agM()
  {
    this.geY = 1;
    return this;
  }
  
  public final int getId()
  {
    return 22146;
  }
  
  public final o iH(String paramString)
  {
    AppMethodBeat.i(235828);
    this.geV = z("Content", paramString, true);
    AppMethodBeat.o(235828);
    return this;
  }
  
  public final o iI(String paramString)
  {
    AppMethodBeat.i(235833);
    this.gfa = z("ChatId", paramString, true);
    AppMethodBeat.o(235833);
    return this;
  }
  
  public final o kW(int paramInt)
  {
    this.geW = paramInt;
    return this;
  }
  
  public final o kX(int paramInt)
  {
    this.geX = paramInt;
    return this;
  }
  
  public final o kY(int paramInt)
  {
    this.geZ = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.o
 * JD-Core Version:    0.7.0.1
 */