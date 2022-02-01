package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public long sJS;
  public long sJT;
  public String sJU;
  public boolean sJV;
  public String value;
  
  public b() {}
  
  public b(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(220618);
    this.sJS = paramLong1;
    this.value = paramString;
    this.sJT = paramLong2;
    this.sJV = paramBoolean;
    this.sJU = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(paramLong2));
    AppMethodBeat.o(220618);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(220619);
    String str = this.sJU + ":" + this.value;
    AppMethodBeat.o(220619);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.b
 * JD-Core Version:    0.7.0.1
 */