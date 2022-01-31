package com.tencent.mm.booter;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class o$a
{
  int dio;
  int dip = 1;
  int diq;
  int dis;
  int dit;
  
  public final boolean es(String paramString)
  {
    paramString = paramString.split(",");
    if ((paramString == null) || (paramString.length != 5))
    {
      y.e("MicroMsg.ProcessReport", "error format");
      return false;
    }
    try
    {
      this.dio = bk.getInt(paramString[0], 0);
      this.dip = bk.getInt(paramString[1], 0);
      this.diq = bk.getInt(paramString[2], 0);
      this.dis = bk.getInt(paramString[3], 0);
      this.dit = bk.getInt(paramString[4], 0);
      return true;
    }
    catch (Exception paramString)
    {
      y.e("MicroMsg.ProcessReport", "ParseFrom parse failed");
      y.printErrStackTrace("MicroMsg.ProcessReport", paramString, "", new Object[0]);
    }
    return false;
  }
  
  public final String toString()
  {
    return String.format("%d,%d,%d,%d,%d", new Object[] { Integer.valueOf(this.dio), Integer.valueOf(this.dip), Integer.valueOf(this.diq), Integer.valueOf(this.dis), Integer.valueOf(this.dit) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.o.a
 * JD-Core Version:    0.7.0.1
 */