package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class ba
  extends a
{
  public String dNH;
  public long dNI;
  public long dNJ;
  public long dNK;
  
  public ba()
  {
    this.dNH = "";
    this.dNI = 0L;
    this.dNJ = 0L;
    this.dNK = 0L;
  }
  
  public ba(String paramString)
  {
    AppMethodBeat.i(121753);
    this.dNH = "";
    this.dNI = 0L;
    this.dNJ = 0L;
    this.dNK = 0L;
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
      hU(paramString[0]);
      this.dNI = bt.getLong(paramString[1], 0L);
      ey(bt.getLong(paramString[2], 0L));
      this.dNK = bt.getLong(paramString[3], 0L);
      AppMethodBeat.o(121753);
      return;
    }
  }
  
  public final String PV()
  {
    AppMethodBeat.i(121756);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dNH);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNI);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNJ);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dNK);
    localObject = ((StringBuffer)localObject).toString();
    ams((String)localObject);
    AppMethodBeat.o(121756);
    return localObject;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(121757);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Name:").append(this.dNH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dNI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.dNJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.dNK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121757);
    return localObject;
  }
  
  public final ba ey(long paramLong)
  {
    AppMethodBeat.i(121755);
    this.dNJ = paramLong;
    super.bb("TimeStampMs", this.dNJ);
    AppMethodBeat.o(121755);
    return this;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final ba hU(String paramString)
  {
    AppMethodBeat.i(121754);
    this.dNH = t("Name", paramString, true);
    AppMethodBeat.o(121754);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.ba
 * JD-Core Version:    0.7.0.1
 */