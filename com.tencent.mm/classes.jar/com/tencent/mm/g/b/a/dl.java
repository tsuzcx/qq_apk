package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class dl
  extends a
{
  public int ehu;
  private String ehv = "";
  
  public final String RC()
  {
    AppMethodBeat.i(186328);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.ehu);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ehv);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(186328);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(186329);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Type:").append(this.ehu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("VoiceID:").append(this.ehv);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(186329);
    return localObject;
  }
  
  public final int getId()
  {
    return 20551;
  }
  
  public final dl nk(String paramString)
  {
    AppMethodBeat.i(186327);
    this.ehv = t("VoiceID", paramString, true);
    AppMethodBeat.o(186327);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dl
 * JD-Core Version:    0.7.0.1
 */