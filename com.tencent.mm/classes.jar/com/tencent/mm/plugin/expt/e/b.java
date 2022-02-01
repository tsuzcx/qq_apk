package com.tencent.mm.plugin.expt.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class b
{
  public String value;
  public long wpQ;
  public long wpR;
  public String wpS;
  public boolean wpT;
  
  public b() {}
  
  public b(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    AppMethodBeat.i(253029);
    this.wpQ = paramLong1;
    this.value = paramString;
    this.wpR = paramLong2;
    this.wpT = paramBoolean;
    this.wpS = new SimpleDateFormat("[yy-MM-dd HH:mm:ss:SSS]").format(new Date(paramLong2));
    AppMethodBeat.o(253029);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(253031);
    String str = this.wpS + ":" + this.value;
    AppMethodBeat.o(253031);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.e.b
 * JD-Core Version:    0.7.0.1
 */