package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class gw
  extends a
{
  private String eHv;
  public long eHw;
  public long eHx;
  public long eLd;
  private long eLe;
  private boolean eLf;
  public long erY;
  public int euv;
  private String euw;
  
  public gw()
  {
    this.euv = 0;
    this.euw = "";
    this.eLd = 0L;
    this.eHv = "";
    this.erY = 0L;
    this.eHw = 0L;
    this.eLe = 0L;
    this.eHx = 0L;
  }
  
  public gw(String paramString)
  {
    AppMethodBeat.i(121758);
    this.euv = 0;
    this.euw = "";
    this.eLd = 0L;
    this.eHv = "";
    this.erY = 0L;
    this.eHw = 0L;
    this.eLe = 0L;
    this.eHx = 0L;
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
      this.euv = Util.getInt(paramString[0], 0);
      uJ(paramString[1]);
      this.eLd = Util.getLong(paramString[2], 0L);
      uK(paramString[3]);
      this.erY = Util.getLong(paramString[4], 0L);
      qH(Util.getLong(paramString[5], 0L));
      this.eLe = Util.getLong(paramString[6], 0L);
      this.eLf = a.getBoolean(paramString[7]);
      this.eHx = Util.getLong(paramString[8], 0L);
      AppMethodBeat.o(121758);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(121762);
    String str = uL(",");
    AppMethodBeat.o(121762);
    return str;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(121764);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.euv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.euw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.eLd);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Name:").append(this.eHv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.erY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.eHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GreenManFg:").append(this.eLe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueueFgBool:").append(this.eLf);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.eHx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121764);
    return localObject;
  }
  
  public final int getId()
  {
    return 15885;
  }
  
  public final gw qH(long paramLong)
  {
    AppMethodBeat.i(121761);
    this.eHw = paramLong;
    super.bj("TimeStampMs", this.eHw);
    AppMethodBeat.o(121761);
    return this;
  }
  
  public final gw uJ(String paramString)
  {
    AppMethodBeat.i(121759);
    this.euw = x("PName", paramString, true);
    AppMethodBeat.o(121759);
    return this;
  }
  
  public final gw uK(String paramString)
  {
    AppMethodBeat.i(121760);
    this.eHv = x("Name", paramString, true);
    AppMethodBeat.o(121760);
    return this;
  }
  
  public final String uL(String paramString)
  {
    AppMethodBeat.i(121763);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.euv);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.euw);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.eLd);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.eHv);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.erY);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.eHw);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.eLe);
    localStringBuffer.append(paramString);
    if (this.eLf) {}
    for (int i = 1;; i = 0)
    {
      localStringBuffer.append(i);
      localStringBuffer.append(paramString);
      localStringBuffer.append(this.eHx);
      paramString = localStringBuffer.toString();
      aMq(paramString);
      AppMethodBeat.o(121763);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.gw
 * JD-Core Version:    0.7.0.1
 */