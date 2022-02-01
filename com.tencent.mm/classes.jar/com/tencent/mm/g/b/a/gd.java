package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gd
  extends a
{
  private long dVR = 0L;
  private long emO = 0L;
  private String eoF = "";
  private String eoG = "";
  private long eog = 0L;
  
  public final String RC()
  {
    AppMethodBeat.i(118514);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.emO);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eog);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dVR);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoF);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eoG);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(118514);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(118515);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.emO);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.eog);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.dVR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryOwnerUserName:").append(this.eoF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryTid:").append(this.eoG);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118515);
    return localObject;
  }
  
  public final long TJ()
  {
    return this.dVR;
  }
  
  public final int getId()
  {
    return 16763;
  }
  
  public final gd lK(long paramLong)
  {
    this.emO = paramLong;
    return this;
  }
  
  public final gd lL(long paramLong)
  {
    this.eog = paramLong;
    return this;
  }
  
  public final gd lM(long paramLong)
  {
    this.dVR = paramLong;
    return this;
  }
  
  public final gd po(String paramString)
  {
    AppMethodBeat.i(118512);
    this.eoF = t("StoryOwnerUserName", paramString, true);
    AppMethodBeat.o(118512);
    return this;
  }
  
  public final gd pp(String paramString)
  {
    AppMethodBeat.i(118513);
    this.eoG = t("StoryTid", paramString, true);
    AppMethodBeat.o(118513);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gd
 * JD-Core Version:    0.7.0.1
 */