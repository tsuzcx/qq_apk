package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class cc
  extends a
{
  private long dHR;
  private String dKl;
  private String dNK;
  private long dNL;
  private long dNM;
  private long dNO;
  private String dOh;
  private String dOi;
  
  public final String PR()
  {
    AppMethodBeat.i(190813);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dHR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNK);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNL);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNM);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dOi);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(190813);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(190814);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("scene:").append(this.dHR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomid:").append(this.dNK);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveid:").append(this.dNL);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("topic:").append(this.dKl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveuin:").append(this.dOh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("roomRole:").append(this.dNM);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("audienceCount:").append(this.dNO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("liveusername:").append(this.dOi);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(190814);
    return localObject;
  }
  
  public final cc QL()
  {
    this.dHR = 1L;
    return this;
  }
  
  public final cc gU(long paramLong)
  {
    this.dNL = paramLong;
    return this;
  }
  
  public final cc gV(long paramLong)
  {
    this.dNM = paramLong;
    return this;
  }
  
  public final cc gW(long paramLong)
  {
    this.dNO = paramLong;
    return this;
  }
  
  public final int getId()
  {
    return 19896;
  }
  
  public final cc jZ(String paramString)
  {
    AppMethodBeat.i(190810);
    this.dNK = t("roomid", paramString, true);
    AppMethodBeat.o(190810);
    return this;
  }
  
  public final cc ka(String paramString)
  {
    AppMethodBeat.i(190811);
    this.dKl = t("topic", paramString, true);
    AppMethodBeat.o(190811);
    return this;
  }
  
  public final cc kb(String paramString)
  {
    AppMethodBeat.i(190812);
    this.dOi = t("liveusername", paramString, true);
    AppMethodBeat.o(190812);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cc
 * JD-Core Version:    0.7.0.1
 */