package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public long raj;
  public long rak;
  public String ral;
  public boolean ram;
  public String value;
  
  public b() {}
  
  public b(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(210518);
    this.raj = paramLong1;
    this.value = paramString;
    this.rak = paramLong2;
    this.ram = paramBoolean;
    this.ral = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(paramLong2));
    AppMethodBeat.o(210518);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(210519);
    String str = this.ral + ":" + this.value;
    AppMethodBeat.o(210519);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.b
 * JD-Core Version:    0.7.0.1
 */