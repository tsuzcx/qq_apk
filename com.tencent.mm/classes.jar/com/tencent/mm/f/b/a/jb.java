package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class jb
  extends a
{
  private String gFW;
  public long gFX;
  public long gFY;
  public long gKH;
  private long gKI;
  private boolean gKJ;
  public long goe;
  public int gqB;
  private String gqC;
  
  public jb()
  {
    this.gqB = 0;
    this.gqC = "";
    this.gKH = 0L;
    this.gFW = "";
    this.goe = 0L;
    this.gFX = 0L;
    this.gKI = 0L;
    this.gFY = 0L;
  }
  
  public jb(String paramString)
  {
    AppMethodBeat.i(121758);
    this.gqB = 0;
    this.gqC = "";
    this.gKH = 0L;
    this.gFW = "";
    this.goe = 0L;
    this.gFX = 0L;
    this.gKI = 0L;
    this.gFY = 0L;
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
      this.gqB = Util.getInt(paramString[0], 0);
      Ag(paramString[1]);
      this.gKH = Util.getLong(paramString[2], 0L);
      Ah(paramString[3]);
      this.goe = Util.getLong(paramString[4], 0L);
      uo(Util.getLong(paramString[5], 0L));
      this.gKI = Util.getLong(paramString[6], 0L);
      this.gKJ = a.getBoolean(paramString[7]);
      this.gFY = Util.getLong(paramString[8], 0L);
      AppMethodBeat.o(121758);
      return;
    }
  }
  
  public final jb Ag(String paramString)
  {
    AppMethodBeat.i(121759);
    this.gqC = z("PName", paramString, true);
    AppMethodBeat.o(121759);
    return this;
  }
  
  public final jb Ah(String paramString)
  {
    AppMethodBeat.i(121760);
    this.gFW = z("Name", paramString, true);
    AppMethodBeat.o(121760);
    return this;
  }
  
  public final String Ai(String paramString)
  {
    AppMethodBeat.i(121763);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.gqB);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.gqC);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.gKH);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.gFW);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.goe);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.gFX);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.gKI);
    localStringBuffer.append(paramString);
    if (this.gKJ) {}
    for (int i = 1;; i = 0)
    {
      localStringBuffer.append(i);
      localStringBuffer.append(paramString);
      localStringBuffer.append(this.gFY);
      paramString = localStringBuffer.toString();
      aWW(paramString);
      AppMethodBeat.o(121763);
      return paramString;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(121762);
    String str = Ai(",");
    AppMethodBeat.o(121762);
    return str;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(121764);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.gqB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.gqC);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.gKH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Name:").append(this.gFW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.goe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.gFX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GreenManFg:").append(this.gKI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueueFgBool:").append(this.gKJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.gFY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121764);
    return localObject;
  }
  
  public final int getId()
  {
    return 15885;
  }
  
  public final jb uo(long paramLong)
  {
    AppMethodBeat.i(121761);
    this.gFX = paramLong;
    super.bm("TimeStampMs", this.gFX);
    AppMethodBeat.o(121761);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.jb
 * JD-Core Version:    0.7.0.1
 */