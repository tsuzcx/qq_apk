package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class is
  extends a
{
  public int gJu;
  private String gJv = "";
  
  public final String agH()
  {
    AppMethodBeat.i(287707);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gJu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gJv);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(287707);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(287708);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.gJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VoiceID:").append(this.gJv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(287708);
    return localObject;
  }
  
  public final int getId()
  {
    return 20551;
  }
  
  public final is zO(String paramString)
  {
    AppMethodBeat.i(287706);
    this.gJv = z("VoiceID", paramString, true);
    AppMethodBeat.o(287706);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.b.a.is
 * JD-Core Version:    0.7.0.1
 */