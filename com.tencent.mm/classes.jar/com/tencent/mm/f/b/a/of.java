package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class of
  extends a
{
  private String giT = "";
  private int glx;
  private String hbi = "";
  private String hbj = "";
  private int hbk;
  private int hbl;
  
  public final of Fb(String paramString)
  {
    AppMethodBeat.i(271506);
    this.hbi = z("requestid", paramString, true);
    AppMethodBeat.o(271506);
    return this;
  }
  
  public final of Fc(String paramString)
  {
    AppMethodBeat.i(271508);
    this.hbj = z("message", paramString, true);
    AppMethodBeat.o(271508);
    return this;
  }
  
  public final of Fd(String paramString)
  {
    AppMethodBeat.i(271509);
    this.giT = z("appid", paramString, true);
    AppMethodBeat.o(271509);
    return this;
  }
  
  public final String agH()
  {
    AppMethodBeat.i(271510);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.hbi);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.glx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.hbl);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.giT);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(271510);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(271511);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("requestid:").append(this.hbi);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("scene:").append(this.glx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("message:").append(this.hbj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("actiontype:").append(this.hbk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("pagetype:").append(this.hbl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("appid:").append(this.giT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(271511);
    return localObject;
  }
  
  public final of aoe()
  {
    this.hbl = 1;
    return this;
  }
  
  public final int getId()
  {
    return 23012;
  }
  
  public final of oc(int paramInt)
  {
    this.glx = paramInt;
    return this;
  }
  
  public final of od(int paramInt)
  {
    this.hbk = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.b.a.of
 * JD-Core Version:    0.7.0.1
 */