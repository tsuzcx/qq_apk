package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Arrays;

public final class s
  extends a
{
  public String cSG;
  public long cSH;
  public long cSI;
  public long cSJ;
  
  public s()
  {
    this.cSG = "";
    this.cSH = 0L;
    this.cSI = 0L;
    this.cSJ = 0L;
  }
  
  public s(String paramString)
  {
    AppMethodBeat.i(73291);
    this.cSG = "";
    this.cSH = 0L;
    this.cSI = 0L;
    this.cSJ = 0L;
    if (paramString != null)
    {
      paramString = paramString.split(",");
      if (paramString != null)
      {
        if (paramString.length >= 4) {
          break label123;
        }
        String[] arrayOfString = new String[4];
        Arrays.fill(arrayOfString, 0, 4, "");
        System.arraycopy(paramString, 0, arrayOfString, 0, paramString.length);
        paramString = arrayOfString;
      }
    }
    label123:
    for (;;)
    {
      fp(paramString[0]);
      this.cSH = bo.getLong(paramString[1], 0L);
      bx(bo.getLong(paramString[2], 0L));
      this.cSJ = bo.getLong(paramString[3], 0L);
      AppMethodBeat.o(73291);
      return;
    }
  }
  
  public final String Ff()
  {
    AppMethodBeat.i(73294);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.cSG);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.cSJ);
    localObject = ((StringBuffer)localObject).toString();
    Yp((String)localObject);
    AppMethodBeat.o(73294);
    return localObject;
  }
  
  public final String Fg()
  {
    AppMethodBeat.i(73295);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Name:").append(this.cSG);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.cSH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.cSI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.cSJ);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(73295);
    return localObject;
  }
  
  public final s bx(long paramLong)
  {
    AppMethodBeat.i(73293);
    this.cSI = paramLong;
    super.az("TimeStampMs", this.cSI);
    AppMethodBeat.o(73293);
    return this;
  }
  
  public final s fp(String paramString)
  {
    AppMethodBeat.i(73292);
    this.cSG = t("Name", paramString, true);
    AppMethodBeat.o(73292);
    return this;
  }
  
  public final int getId()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.b.a.s
 * JD-Core Version:    0.7.0.1
 */