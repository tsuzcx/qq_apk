package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class y
  extends a
{
  public int cRR;
  private String cRS;
  private String cSG;
  public long cSH;
  public long cSI;
  public long cSJ;
  public long cTR;
  private long cTS;
  private boolean cTT;
  
  public y()
  {
    this.cRR = 0;
    this.cRS = "";
    this.cTR = 0L;
    this.cSG = "";
    this.cSH = 0L;
    this.cSI = 0L;
    this.cTS = 0L;
    this.cSJ = 0L;
  }
  
  public y(String paramString)
  {
    AppMethodBeat.i(73296);
    this.cRR = 0;
    this.cRS = "";
    this.cTR = 0L;
    this.cSG = "";
    this.cSH = 0L;
    this.cSI = 0L;
    this.cTS = 0L;
    this.cSJ = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 9) {
          break label201;
        }
        String[] arrayOfString = new String[9];
        Arrays.fill(arrayOfString, 0, 9, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label201:
    for (;;)
    {
      this.cRR = bo.getInt(paramString[0], 0);
      fu(paramString[1]);
      this.cTR = bo.getLong(paramString[2], 0L);
      fv(paramString[3]);
      this.cSH = bo.getLong(paramString[4], 0L);
      by(bo.getLong(paramString[5], 0L));
      this.cTS = bo.getLong(paramString[6], 0L);
      this.cTT = a.getBoolean(paramString[7]);
      this.cSJ = bo.getLong(paramString[8], 0L);
      AppMethodBeat.o(73296);
      return;
    }
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(73300);
    String str = fw(",");
    AppMethodBeat.o(73300);
    return str;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(73302);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.cRR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.cRS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.cTR);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Name:").append(this.cSG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.cSH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.cSI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GreenManFg:").append(this.cTS);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueueFgBool:").append(this.cTT);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.cSJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73302);
    return localObject;
  }
  
  public final y by(long paramLong)
  {
    AppMethodBeat.i(73299);
    this.cSI = paramLong;
    super.az("TimeStampMs", this.cSI);
    AppMethodBeat.o(73299);
    return this;
  }
  
  public final y fu(String paramString)
  {
    AppMethodBeat.i(73297);
    this.cRS = t("PName", paramString, true);
    AppMethodBeat.o(73297);
    return this;
  }
  
  public final y fv(String paramString)
  {
    AppMethodBeat.i(73298);
    this.cSG = t("Name", paramString, true);
    AppMethodBeat.o(73298);
    return this;
  }
  
  public final String fw(String paramString)
  {
    AppMethodBeat.i(73301);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.cRR);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.cRS);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.cTR);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.cSG);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.cSH);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.cSI);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.cTS);
    localStringBuffer.append(paramString);
    if (this.cTT) {}
    for (int i = 1;; i = 0)
    {
      localStringBuffer.append(i);
      localStringBuffer.append(paramString);
      localStringBuffer.append(this.cSJ);
      paramString = localStringBuffer.toString();
      Yp(paramString);
      AppMethodBeat.o(73301);
      return paramString;
    }
  }
  
  public final int getId()
  {
    return 15885;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.y
 * JD-Core Version:    0.7.0.1
 */