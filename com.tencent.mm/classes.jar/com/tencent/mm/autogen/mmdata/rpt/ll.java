package com.tencent.mm.autogen.mmdata.rpt;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ll
  extends a
{
  public int iAo;
  private String iAp;
  private String iSU;
  public long iSV;
  public long iSW;
  public long iZX;
  private long iZY;
  private boolean iZZ;
  public long ixB;
  
  public ll()
  {
    this.iAo = 0;
    this.iAp = "";
    this.iZX = 0L;
    this.iSU = "";
    this.ixB = 0L;
    this.iSV = 0L;
    this.iZY = 0L;
    this.iSW = 0L;
  }
  
  public ll(String paramString)
  {
    AppMethodBeat.i(121758);
    this.iAo = 0;
    this.iAp = "";
    this.iZX = 0L;
    this.iSU = "";
    this.ixB = 0L;
    this.iSV = 0L;
    this.iZY = 0L;
    this.iSW = 0L;
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
      this.iAo = Util.getInt(paramString[0], 0);
      ur(paramString[1]);
      this.iZX = Util.getLong(paramString[2], 0L);
      us(paramString[3]);
      this.ixB = Util.getLong(paramString[4], 0L);
      fl(Util.getLong(paramString[5], 0L));
      this.iZY = Util.getLong(paramString[6], 0L);
      this.iZZ = a.getBoolean(paramString[7]);
      this.iSW = Util.getLong(paramString[8], 0L);
      AppMethodBeat.o(121758);
      return;
    }
  }
  
  public final String aIE()
  {
    AppMethodBeat.i(121762);
    String str = ut(",");
    AppMethodBeat.o(121762);
    return str;
  }
  
  public final String aIF()
  {
    AppMethodBeat.i(121764);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.iAo);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.iAp);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.iZX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Name:").append(this.iSU);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.ixB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.iSV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GreenManFg:").append(this.iZY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueueFgBool:").append(this.iZZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.iSW);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121764);
    return localObject;
  }
  
  public final ll fl(long paramLong)
  {
    AppMethodBeat.i(121761);
    this.iSV = paramLong;
    super.by("TimeStampMs", this.iSV);
    AppMethodBeat.o(121761);
    return this;
  }
  
  public final int getId()
  {
    return 15885;
  }
  
  public final ll ur(String paramString)
  {
    AppMethodBeat.i(121759);
    this.iAp = F("PName", paramString, true);
    AppMethodBeat.o(121759);
    return this;
  }
  
  public final ll us(String paramString)
  {
    AppMethodBeat.i(121760);
    this.iSU = F("Name", paramString, true);
    AppMethodBeat.o(121760);
    return this;
  }
  
  public final String ut(String paramString)
  {
    AppMethodBeat.i(121763);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.iAo);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.iAp);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.iZX);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.iSU);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.ixB);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.iSV);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.iZY);
    localStringBuffer.append(paramString);
    if (this.iZZ) {}
    for (int i = 1;; i = 0)
    {
      localStringBuffer.append(i);
      localStringBuffer.append(paramString);
      localStringBuffer.append(this.iSW);
      paramString = localStringBuffer.toString();
      aUm(paramString);
      AppMethodBeat.o(121763);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.autogen.mmdata.rpt.ll
 * JD-Core Version:    0.7.0.1
 */