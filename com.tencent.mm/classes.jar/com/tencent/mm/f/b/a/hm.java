package com.tencent.mm.f.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class hm
  extends a
{
  public String gFW;
  public long gFX;
  public long gFY;
  public long goe;
  
  public hm()
  {
    this.gFW = "";
    this.goe = 0L;
    this.gFX = 0L;
    this.gFY = 0L;
  }
  
  public hm(String paramString)
  {
    AppMethodBeat.i(121753);
    this.gFW = "";
    this.goe = 0L;
    this.gFX = 0L;
    this.gFY = 0L;
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
      wy(paramString[0]);
      this.goe = Util.getLong(paramString[1], 0L);
      rA(Util.getLong(paramString[2], 0L));
      this.gFY = Util.getLong(paramString[3], 0L);
      AppMethodBeat.o(121753);
      return;
    }
  }
  
  public final String agH()
  {
    AppMethodBeat.i(121756);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.gFW);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.goe);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFX);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.gFY);
    localObject = ((StringBuffer)localObject).toString();
    aWW((String)localObject);
    AppMethodBeat.o(121756);
    return localObject;
  }
  
  public final String agI()
  {
    AppMethodBeat.i(121757);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Name:").append(this.gFW);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.goe);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.gFX);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.gFY);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121757);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final hm rA(long paramLong)
  {
    AppMethodBeat.i(121755);
    this.gFX = paramLong;
    super.bm("TimeStampMs", this.gFX);
    AppMethodBeat.o(121755);
    return this;
  }
  
  public final hm wy(String paramString)
  {
    AppMethodBeat.i(121754);
    this.gFW = z("Name", paramString, true);
    AppMethodBeat.o(121754);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.b.a.hm
 * JD-Core Version:    0.7.0.1
 */