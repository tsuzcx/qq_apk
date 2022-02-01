package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class fn
  extends a
{
  private String gAT = "";
  private long gAU;
  private long gAV;
  private long gAW;
  private long gAX;
  private long gAY;
  private long gAZ;
  private String gBa = "";
  private long gBb;
  private long gBc;
  private String gBd = "";
  private long gdk;
  private long gnP;
  private long nmI;
  
  public final fn LM(long paramLong)
  {
    this.gdk = paramLong;
    return this;
  }
  
  public final fn SE(long paramLong)
  {
    this.nmI = paramLong;
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(186397);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gAT);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAU);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAV);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gnP);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gAZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBa);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gBd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gdk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.nmI);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(186397);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(186398);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("MsgTypeList:").append(this.gAT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecieveType:").append(this.gAU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("UsedListSeq:").append(this.gAV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("RecentListSeq:").append(this.gAW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CreateNew:").append(this.gAX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("IsMultiSelect:").append(this.gAY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Scene:").append(this.gnP);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ClickZone:").append(this.gAZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ToUser:").append(this.gBa);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("AppMsgInnerTypeList:").append(this.gBb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TopSessionCount:").append(this.gBc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InnerAppMsgTypeList:").append(this.gBd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("CostTime:").append(this.gdk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("LogVersion:").append(this.nmI);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186398);
    return localObject;
  }
  
  public final int getId()
  {
    return 23009;
  }
  
  public final fn oh(long paramLong)
  {
    this.gAU = paramLong;
    return this;
  }
  
  public final fn oi(long paramLong)
  {
    this.gAV = paramLong;
    return this;
  }
  
  public final fn oj(long paramLong)
  {
    this.gAW = paramLong;
    return this;
  }
  
  public final fn ok(long paramLong)
  {
    this.gAX = paramLong;
    return this;
  }
  
  public final fn ol(long paramLong)
  {
    this.gAY = paramLong;
    return this;
  }
  
  public final fn om(long paramLong)
  {
    this.gnP = paramLong;
    return this;
  }
  
  public final fn on(long paramLong)
  {
    this.gAZ = paramLong;
    return this;
  }
  
  public final fn oo(long paramLong)
  {
    this.gBc = paramLong;
    return this;
  }
  
  public final fn uR(String paramString)
  {
    AppMethodBeat.i(186385);
    this.gAT = z("MsgTypeList", paramString, true);
    AppMethodBeat.o(186385);
    return this;
  }
  
  public final fn uS(String paramString)
  {
    AppMethodBeat.i(186393);
    this.gBa = z("ToUser", paramString, true);
    AppMethodBeat.o(186393);
    return this;
  }
  
  public final fn uT(String paramString)
  {
    AppMethodBeat.i(186396);
    this.gBd = z("InnerAppMsgTypeList", paramString, true);
    AppMethodBeat.o(186396);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.b.a.fn
 * JD-Core Version:    0.7.0.1
 */