package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ft
  extends a
{
  public String eHv;
  public long eHw;
  public long eHx;
  public long erY;
  
  public ft()
  {
    this.eHv = "";
    this.erY = 0L;
    this.eHw = 0L;
    this.eHx = 0L;
  }
  
  public ft(String paramString)
  {
    AppMethodBeat.i(121753);
    this.eHv = "";
    this.erY = 0L;
    this.eHw = 0L;
    this.eHx = 0L;
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
      sK(paramString[0]);
      this.erY = Util.getLong(paramString[1], 0L);
      pk(Util.getLong(paramString[2], 0L));
      this.eHx = Util.getLong(paramString[3], 0L);
      AppMethodBeat.o(121753);
      return;
    }
  }
  
  public final String abV()
  {
    AppMethodBeat.i(121756);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.eHv);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.erY);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHw);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.eHx);
    localObject = ((StringBuffer)localObject).toString();
    aMq((String)localObject);
    AppMethodBeat.o(121756);
    return localObject;
  }
  
  public final String abW()
  {
    AppMethodBeat.i(121757);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Name:").append(this.eHv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.erY);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.eHw);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.eHx);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121757);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final ft pk(long paramLong)
  {
    AppMethodBeat.i(121755);
    this.eHw = paramLong;
    super.bj("TimeStampMs", this.eHw);
    AppMethodBeat.o(121755);
    return this;
  }
  
  public final ft sK(String paramString)
  {
    AppMethodBeat.i(121754);
    this.eHv = x("Name", paramString, true);
    AppMethodBeat.o(121754);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ft
 * JD-Core Version:    0.7.0.1
 */