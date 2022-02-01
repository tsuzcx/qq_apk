package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;

public final class gb
  extends a
{
  private long dUB = 0L;
  private long elh = 0L;
  private String emW = "";
  private String emX = "";
  private long emx = 0L;
  
  public final String RD()
  {
    AppMethodBeat.i(118514);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.elh);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emx);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dUB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.emX);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(118514);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(118515);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PreviewEnterScene:").append(this.elh);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("ProfileSource:").append(this.emx);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("EnterTime:").append(this.dUB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryOwnerUserName:").append(this.emW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("StoryTid:").append(this.emX);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(118515);
    return localObject;
  }
  
  public final long TD()
  {
    return this.dUB;
  }
  
  public final int getId()
  {
    return 16763;
  }
  
  public final gb lA(long paramLong)
  {
    this.emx = paramLong;
    return this;
  }
  
  public final gb lB(long paramLong)
  {
    this.dUB = paramLong;
    return this;
  }
  
  public final gb lz(long paramLong)
  {
    this.elh = paramLong;
    return this;
  }
  
  public final gb oT(String paramString)
  {
    AppMethodBeat.i(118512);
    this.emW = t("StoryOwnerUserName", paramString, true);
    AppMethodBeat.o(118512);
    return this;
  }
  
  public final gb oU(String paramString)
  {
    AppMethodBeat.i(118513);
    this.emX = t("StoryTid", paramString, true);
    AppMethodBeat.o(118513);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gb
 * JD-Core Version:    0.7.0.1
 */