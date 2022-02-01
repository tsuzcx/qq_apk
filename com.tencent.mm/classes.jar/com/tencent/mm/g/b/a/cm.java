package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class cm
  extends a
{
  public long dKB;
  public String dPj;
  public long dPk;
  public long dPl;
  
  public cm()
  {
    this.dPj = "";
    this.dKB = 0L;
    this.dPk = 0L;
    this.dPl = 0L;
  }
  
  public cm(String paramString)
  {
    AppMethodBeat.i(121753);
    this.dPj = "";
    this.dKB = 0L;
    this.dPk = 0L;
    this.dPl = 0L;
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
      kw(paramString[0]);
      this.dKB = bs.getLong(paramString[1], 0L);
      hH(bs.getLong(paramString[2], 0L));
      this.dPl = bs.getLong(paramString[3], 0L);
      AppMethodBeat.o(121753);
      return;
    }
  }
  
  public final String PR()
  {
    AppMethodBeat.i(121756);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append(this.dPj);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dKB);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPk);
    ((StringBuffer)localObject).append(",");
    ((StringBuffer)localObject).append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    arz((String)localObject);
    AppMethodBeat.o(121756);
    return localObject;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(121757);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("Name:").append(this.dPj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.dPk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121757);
    return localObject;
  }
  
  public final int getId()
  {
    return 0;
  }
  
  public final cm hH(long paramLong)
  {
    AppMethodBeat.i(121755);
    this.dPk = paramLong;
    super.bd("TimeStampMs", this.dPk);
    AppMethodBeat.o(121755);
    return this;
  }
  
  public final cm kw(String paramString)
  {
    AppMethodBeat.i(121754);
    this.dPj = t("Name", paramString, true);
    AppMethodBeat.o(121754);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cm
 * JD-Core Version:    0.7.0.1
 */