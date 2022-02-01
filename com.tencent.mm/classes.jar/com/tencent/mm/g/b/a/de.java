package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class de
  extends a
{
  public long dYD;
  public long eeA;
  public String eey;
  public long eez;
  
  public de()
  {
    this.eey = "";
    this.dYD = 0L;
    this.eez = 0L;
    this.eeA = 0L;
  }
  
  public de(String paramString)
  {
    AppMethodBeat.i(121753);
    this.eey = "";
    this.dYD = 0L;
    this.eez = 0L;
    this.eeA = 0L;
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
      ms(paramString[0]);
      this.dYD = bt.getLong(paramString[1], 0L);
      jp(bt.getLong(paramString[2], 0L));
      this.eeA = bt.getLong(paramString[3], 0L);
      AppMethodBeat.o(121753);
      return;
    }
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121756);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eey);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dYD);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eez);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eeA);
    localObject = ((StringBuffer)localObject).toString();
    awz((String)localObject);
    AppMethodBeat.o(121756);
    return localObject;
  }
  
  public final String RE()
  {
    AppMethodBeat.i(121757);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Name:").append(this.eey);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dYD);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.eez);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.eeA);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121757);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final de jp(long paramLong)
  {
    AppMethodBeat.i(121755);
    this.eez = paramLong;
    super.bg("TimeStampMs", this.eez);
    AppMethodBeat.o(121755);
    return this;
  }
  
  public final de ms(String paramString)
  {
    AppMethodBeat.i(121754);
    this.eey = t("Name", paramString, true);
    AppMethodBeat.o(121754);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.de
 * JD-Core Version:    0.7.0.1
 */