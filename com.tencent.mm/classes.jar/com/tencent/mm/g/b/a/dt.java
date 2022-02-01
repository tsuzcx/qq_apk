package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class dt
  extends a
{
  public int dYC;
  private String dYD;
  public long dZW;
  private String efY;
  public long efZ;
  public long ega;
  public long eiF;
  private long eiG;
  private boolean eiH;
  
  public dt()
  {
    this.dYC = 0;
    this.dYD = "";
    this.eiF = 0L;
    this.efY = "";
    this.dZW = 0L;
    this.efZ = 0L;
    this.eiG = 0L;
    this.ega = 0L;
  }
  
  public dt(String paramString)
  {
    AppMethodBeat.i(121758);
    this.dYC = 0;
    this.dYD = "";
    this.eiF = 0L;
    this.efY = "";
    this.dZW = 0L;
    this.efZ = 0L;
    this.eiG = 0L;
    this.ega = 0L;
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
      this.dYC = bu.getInt(paramString[0], 0);
      nw(paramString[1]);
      this.eiF = bu.getLong(paramString[2], 0L);
      nx(paramString[3]);
      this.dZW = bu.getLong(paramString[4], 0L);
      kd(bu.getLong(paramString[5], 0L));
      this.eiG = bu.getLong(paramString[6], 0L);
      this.eiH = a.getBoolean(paramString[7]);
      this.ega = bu.getLong(paramString[8], 0L);
      AppMethodBeat.o(121758);
      return;
    }
  }
  
  public final String RC()
  {
    AppMethodBeat.i(121762);
    String str = ny(",");
    AppMethodBeat.o(121762);
    return str;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121764);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.dYC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.eiF);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Name:").append(this.efY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.efZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GreenManFg:").append(this.eiG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueueFgBool:").append(this.eiH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.ega);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121764);
    return localObject;
  }
  
  public final int getId()
  {
    return 15885;
  }
  
  public final dt kd(long paramLong)
  {
    AppMethodBeat.i(121761);
    this.efZ = paramLong;
    super.bh("TimeStampMs", this.efZ);
    AppMethodBeat.o(121761);
    return this;
  }
  
  public final dt nw(String paramString)
  {
    AppMethodBeat.i(121759);
    this.dYD = t("PName", paramString, true);
    AppMethodBeat.o(121759);
    return this;
  }
  
  public final dt nx(String paramString)
  {
    AppMethodBeat.i(121760);
    this.efY = t("Name", paramString, true);
    AppMethodBeat.o(121760);
    return this;
  }
  
  public final String ny(String paramString)
  {
    AppMethodBeat.i(121763);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.dYC);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dYD);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.eiF);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.efY);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dZW);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.efZ);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.eiG);
    localStringBuffer.append(paramString);
    if (this.eiH) {}
    for (int i = 1;; i = 0)
    {
      localStringBuffer.append(i);
      localStringBuffer.append(paramString);
      localStringBuffer.append(this.ega);
      paramString = localStringBuffer.toString();
      axO(paramString);
      AppMethodBeat.o(121763);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.dt
 * JD-Core Version:    0.7.0.1
 */