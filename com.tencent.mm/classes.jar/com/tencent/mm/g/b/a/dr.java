package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class dr
  extends a
{
  public int dXl;
  private String dXm;
  public long dYD;
  public long eeA;
  private String eey;
  public long eez;
  public long egV;
  private long egW;
  private boolean egX;
  
  public dr()
  {
    this.dXl = 0;
    this.dXm = "";
    this.egV = 0L;
    this.eey = "";
    this.dYD = 0L;
    this.eez = 0L;
    this.egW = 0L;
    this.eeA = 0L;
  }
  
  public dr(String paramString)
  {
    AppMethodBeat.i(121758);
    this.dXl = 0;
    this.dXm = "";
    this.egV = 0L;
    this.eey = "";
    this.dYD = 0L;
    this.eez = 0L;
    this.egW = 0L;
    this.eeA = 0L;
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
      this.dXl = bt.getInt(paramString[0], 0);
      nb(paramString[1]);
      this.egV = bt.getLong(paramString[2], 0L);
      nc(paramString[3]);
      this.dYD = bt.getLong(paramString[4], 0L);
      jS(bt.getLong(paramString[5], 0L));
      this.egW = bt.getLong(paramString[6], 0L);
      this.egX = a.getBoolean(paramString[7]);
      this.eeA = bt.getLong(paramString[8], 0L);
      AppMethodBeat.o(121758);
      return;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121762);
    String str = nd(",");
    AppMethodBeat.o(121762);
    return str;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(121764);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.dXl);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dXm);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.egV);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Name:").append(this.eey);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.eez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GreenManFg:").append(this.egW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueueFgBool:").append(this.egX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.eeA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121764);
    return localObject;
  }
  
  public final int getId()
  {
    return 15885;
  }
  
  public final dr jS(long paramLong)
  {
    AppMethodBeat.i(121761);
    this.eez = paramLong;
    super.bg("TimeStampMs", this.eez);
    AppMethodBeat.o(121761);
    return this;
  }
  
  public final dr nb(String paramString)
  {
    AppMethodBeat.i(121759);
    this.dXm = t("PName", paramString, true);
    AppMethodBeat.o(121759);
    return this;
  }
  
  public final dr nc(String paramString)
  {
    AppMethodBeat.i(121760);
    this.eey = t("Name", paramString, true);
    AppMethodBeat.o(121760);
    return this;
  }
  
  public final String nd(String paramString)
  {
    AppMethodBeat.i(121763);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.dXl);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dXm);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.egV);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.eey);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dYD);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.eez);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.egW);
    localStringBuffer.append(paramString);
    if (this.egX) {}
    for (int i = 1;; i = 0)
    {
      localStringBuffer.append(i);
      localStringBuffer.append(paramString);
      localStringBuffer.append(this.eeA);
      paramString = localStringBuffer.toString();
      awz(paramString);
      AppMethodBeat.o(121763);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dr
 * JD-Core Version:    0.7.0.1
 */