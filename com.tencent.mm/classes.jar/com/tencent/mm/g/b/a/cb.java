package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cb
  extends a
{
  private long dFs;
  private long dHR;
  private String dKl = "";
  private String dNK;
  private long dNM;
  private long dNU;
  private long dOb;
  private long dOc;
  private long dOd;
  private long dOe;
  private long dOf;
  private long dOg;
  
  public final String PR()
  {
    AppMethodBeat.i(190808);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOb);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOc);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOd);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOf);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dFs);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOg);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNU);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190808);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190809);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("rulePop:").append(this.dOb);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ruleCheck:").append(this.dOc);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dKl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("customTopic:").append(this.dOd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("cameraStatus:").append(this.dOe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("horizontalStatus:").append(this.dOf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("exitType:").append(this.dFs);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("errcode:").append(this.dOg);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.dNM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomCount:").append(this.dNU);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190809);
    return localObject;
  }
  
  public final cb QK()
  {
    this.dHR = 1L;
    return this;
  }
  
  public final cb gL(long paramLong)
  {
    this.dOb = paramLong;
    return this;
  }
  
  public final cb gM(long paramLong)
  {
    this.dOc = paramLong;
    return this;
  }
  
  public final cb gN(long paramLong)
  {
    this.dOd = paramLong;
    return this;
  }
  
  public final cb gO(long paramLong)
  {
    this.dOe = paramLong;
    return this;
  }
  
  public final cb gP(long paramLong)
  {
    this.dOf = paramLong;
    return this;
  }
  
  public final cb gQ(long paramLong)
  {
    this.dFs = paramLong;
    return this;
  }
  
  public final cb gR(long paramLong)
  {
    this.dOg = paramLong;
    return this;
  }
  
  public final cb gS(long paramLong)
  {
    this.dNM = paramLong;
    return this;
  }
  
  public final cb gT(long paramLong)
  {
    this.dNU = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19890;
  }
  
  public final cb jX(String paramString)
  {
    AppMethodBeat.i(190806);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(190806);
    return this;
  }
  
  public final cb jY(String paramString)
  {
    AppMethodBeat.i(190807);
    this.dKl = t("topic", paramString, true);
    AppMethodBeat.o(190807);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cb
 * JD-Core Version:    0.7.0.1
 */