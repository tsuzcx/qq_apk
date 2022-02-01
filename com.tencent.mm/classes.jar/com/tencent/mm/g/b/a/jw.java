package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class jw
  extends a
{
  public long eSN = 0L;
  public String eSO = "";
  public String eSP = "";
  
  public final String abV()
  {
    AppMethodBeat.i(19868);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eSN);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eSP);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(19868);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(19869);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("LogType:").append(this.eSN);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("WechatLanguage:").append(this.eSO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("InputLanguage:").append(this.eSP);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(19869);
    return localObject;
  }
  
  public final int getId()
  {
    return 15493;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.jw
 * JD-Core Version:    0.7.0.1
 */