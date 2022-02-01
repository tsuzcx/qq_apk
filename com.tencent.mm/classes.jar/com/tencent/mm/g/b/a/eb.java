package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class eb
  extends a
{
  public long eiS = 0L;
  private String eiT = "";
  
  public final String RC()
  {
    AppMethodBeat.i(149928);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eiS);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eiT);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(149928);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(149929);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("SendScene:").append(this.eiS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("emoticonMd5:").append(this.eiT);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(149929);
    return localObject;
  }
  
  public final int getId()
  {
    return 16868;
  }
  
  public final eb nC(String paramString)
  {
    AppMethodBeat.i(162225);
    this.eiT = t("emoticonMd5", paramString, true);
    AppMethodBeat.o(162225);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.eb
 * JD-Core Version:    0.7.0.1
 */