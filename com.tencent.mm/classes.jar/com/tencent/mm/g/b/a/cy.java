package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.Arrays;

public final class cy
  extends a
{
  public int dJu;
  private String dJv;
  public long dKB;
  private String dPj;
  public long dPk;
  public long dPl;
  private boolean dRA;
  public long dRy;
  private long dRz;
  
  public cy()
  {
    this.dJu = 0;
    this.dJv = "";
    this.dRy = 0L;
    this.dPj = "";
    this.dKB = 0L;
    this.dPk = 0L;
    this.dRz = 0L;
    this.dPl = 0L;
  }
  
  public cy(String paramString)
  {
    AppMethodBeat.i(121758);
    this.dJu = 0;
    this.dJv = "";
    this.dRy = 0L;
    this.dPj = "";
    this.dKB = 0L;
    this.dPk = 0L;
    this.dRz = 0L;
    this.dPl = 0L;
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
      this.dJu = bs.getInt(paramString[0], 0);
      kY(paramString[1]);
      this.dRy = bs.getLong(paramString[2], 0L);
      kZ(paramString[3]);
      this.dKB = bs.getLong(paramString[4], 0L);
      ih(bs.getLong(paramString[5], 0L));
      this.dRz = bs.getLong(paramString[6], 0L);
      this.dRA = a.getBoolean(paramString[7]);
      this.dPl = bs.getLong(paramString[8], 0L);
      AppMethodBeat.o(121758);
      return;
    }
  }
  
  public final String PR()
  {
    AppMethodBeat.i(121762);
    String str = la(",");
    AppMethodBeat.o(121762);
    return str;
  }
  
  public final String PS()
  {
    AppMethodBeat.i(121764);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.dJu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dJv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dRy);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Name:").append(this.dPj);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dKB);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.dPk);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GreenManFg:").append(this.dRz);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueueFgBool:").append(this.dRA);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.dPl);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121764);
    return localObject;
  }
  
  public final int getId()
  {
    return 15885;
  }
  
  public final cy ih(long paramLong)
  {
    AppMethodBeat.i(121761);
    this.dPk = paramLong;
    super.bd("TimeStampMs", this.dPk);
    AppMethodBeat.o(121761);
    return this;
  }
  
  public final cy kY(String paramString)
  {
    AppMethodBeat.i(121759);
    this.dJv = t("PName", paramString, true);
    AppMethodBeat.o(121759);
    return this;
  }
  
  public final cy kZ(String paramString)
  {
    AppMethodBeat.i(121760);
    this.dPj = t("Name", paramString, true);
    AppMethodBeat.o(121760);
    return this;
  }
  
  public final String la(String paramString)
  {
    AppMethodBeat.i(121763);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.dJu);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dJv);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dRy);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dPj);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dKB);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dPk);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dRz);
    localStringBuffer.append(paramString);
    if (this.dRA) {}
    for (int i = 1;; i = 0)
    {
      localStringBuffer.append(i);
      localStringBuffer.append(paramString);
      localStringBuffer.append(this.dPl);
      paramString = localStringBuffer.toString();
      arz(paramString);
      AppMethodBeat.o(121763);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.b.a.cy
 * JD-Core Version:    0.7.0.1
 */