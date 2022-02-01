package com.tencent.mm.plugin.expt.kvdebug;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public String value;
  public long zLT;
  public long zLU;
  public String zLV;
  public boolean zLW;
  
  public b() {}
  
  public b(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(299462);
    this.zLT = paramLong1;
    this.value = paramString;
    this.zLU = paramLong2;
    this.zLW = paramBoolean;
    this.zLV = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(paramLong2));
    AppMethodBeat.o(299462);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(299467);
    String str = this.zLV + ":" + this.value;
    AppMethodBeat.o(299467);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.kvdebug.b
 * JD-Core Version:    0.7.0.1
 */