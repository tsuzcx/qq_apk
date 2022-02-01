package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public long rip;
  public long riq;
  public String rir;
  public boolean ris;
  public String value;
  
  public b() {}
  
  public b(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(196185);
    this.rip = paramLong1;
    this.value = paramString;
    this.riq = paramLong2;
    this.ris = paramBoolean;
    this.rir = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(paramLong2));
    AppMethodBeat.o(196185);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(196186);
    String str = this.rir + ":" + this.value;
    AppMethodBeat.o(196186);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.b
 * JD-Core Version:    0.7.0.1
 */