package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.Arrays;

public final class de
  extends a
{
  public long dZW;
  public String efY;
  public long efZ;
  public long ega;
  
  public de()
  {
    this.efY = "";
    this.dZW = 0L;
    this.efZ = 0L;
    this.ega = 0L;
  }
  
  public de(String paramString)
  {
    AppMethodBeat.i(121753);
    this.efY = "";
    this.dZW = 0L;
    this.efZ = 0L;
    this.ega = 0L;
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
      mK(paramString[0]);
      this.dZW = bu.getLong(paramString[1], 0L);
      jz(bu.getLong(paramString[2], 0L));
      this.ega = bu.getLong(paramString[3], 0L);
      AppMethodBeat.o(121753);
      return;
    }
  }
  
  public final String RC()
  {
    AppMethodBeat.i(121756);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.efY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dZW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.efZ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.ega);
    localObject = ((StringBuffer)localObject).toString();
    axO((String)localObject);
    AppMethodBeat.o(121756);
    return localObject;
  }
  
  public final String RD()
  {
    AppMethodBeat.i(121757);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Name:").append(this.efY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dZW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.efZ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.ega);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121757);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final de jz(long paramLong)
  {
    AppMethodBeat.i(121755);
    this.efZ = paramLong;
    super.bh("TimeStampMs", this.efZ);
    AppMethodBeat.o(121755);
    return this;
  }
  
  public final de mK(String paramString)
  {
    AppMethodBeat.i(121754);
    this.efY = t("Name", paramString, true);
    AppMethodBeat.o(121754);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.de
 * JD-Core Version:    0.7.0.1
 */