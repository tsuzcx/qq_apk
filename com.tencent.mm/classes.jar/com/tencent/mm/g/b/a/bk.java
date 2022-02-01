package com.tencent.mm.g.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Arrays;

public final class bk
  extends a
{
  public int dKu;
  private String dKv;
  private String dNH;
  public long dNI;
  public long dNJ;
  public long dNK;
  public long dPH;
  private long dPI;
  private boolean dPJ;
  
  public bk()
  {
    this.dKu = 0;
    this.dKv = "";
    this.dPH = 0L;
    this.dNH = "";
    this.dNI = 0L;
    this.dNJ = 0L;
    this.dPI = 0L;
    this.dNK = 0L;
  }
  
  public bk(String paramString)
  {
    AppMethodBeat.i(121758);
    this.dKu = 0;
    this.dKv = "";
    this.dPH = 0L;
    this.dNH = "";
    this.dNI = 0L;
    this.dNJ = 0L;
    this.dPI = 0L;
    this.dNK = 0L;
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
      this.dKu = bt.getInt(paramString[0], 0);
      ij(paramString[1]);
      this.dPH = bt.getLong(paramString[2], 0L);
      ik(paramString[3]);
      this.dNI = bt.getLong(paramString[4], 0L);
      eU(bt.getLong(paramString[5], 0L));
      this.dPI = bt.getLong(paramString[6], 0L);
      this.dPJ = a.getBoolean(paramString[7]);
      this.dNK = bt.getLong(paramString[8], 0L);
      AppMethodBeat.o(121758);
      return;
    }
  }
  
  public final String PV()
  {
    AppMethodBeat.i(121762);
    String str = il(",");
    AppMethodBeat.o(121762);
    return str;
  }
  
  public final String PW()
  {
    AppMethodBeat.i(121764);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("PID:").append(this.dKu);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("PName:").append(this.dKv);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Seq:").append(this.dPH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Name:").append(this.dNH);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("Type:").append(this.dNI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("TimeStampMs:").append(this.dNJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("GreenManFg:").append(this.dPI);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("QueueFgBool:").append(this.dPJ);
    ((StringBuffer)localObject).append("\r\n");
    ((StringBuffer)localObject).append("HashCode:").append(this.dNK);
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(121764);
    return localObject;
  }
  
  public final bk eU(long paramLong)
  {
    AppMethodBeat.i(121761);
    this.dNJ = paramLong;
    super.bb("TimeStampMs", this.dNJ);
    AppMethodBeat.o(121761);
    return this;
  }
  
  public final int getId()
  {
    return 15885;
  }
  
  public final bk ij(String paramString)
  {
    AppMethodBeat.i(121759);
    this.dKv = t("PName", paramString, true);
    AppMethodBeat.o(121759);
    return this;
  }
  
  public final bk ik(String paramString)
  {
    AppMethodBeat.i(121760);
    this.dNH = t("Name", paramString, true);
    AppMethodBeat.o(121760);
    return this;
  }
  
  public final String il(String paramString)
  {
    AppMethodBeat.i(121763);
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.dKu);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dKv);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dPH);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dNH);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dNI);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dNJ);
    localStringBuffer.append(paramString);
    localStringBuffer.append(this.dPI);
    localStringBuffer.append(paramString);
    if (this.dPJ) {}
    for (int i = 1;; i = 0)
    {
      localStringBuffer.append(i);
      localStringBuffer.append(paramString);
      localStringBuffer.append(this.dNK);
      paramString = localStringBuffer.toString();
      ams(paramString);
      AppMethodBeat.o(121763);
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.b.a.bk
 * JD-Core Version:    0.7.0.1
 */