package com.tencent.mm.booter;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Locale;

public final class y$a
{
  public int cmy;
  public String eag;
  public int eah;
  public int eai;
  public long eaj;
  public int eak;
  public int eal = 0;
  int eam = 0;
  int ean = 0;
  public long time;
  public int type;
  
  public y$a(y paramy) {}
  
  public final String toString()
  {
    AppMethodBeat.i(15878);
    String str = String.format(Locale.US, "%d#%d#%d#%d#%d#%d#%d#%s#%d#%d#%d|", new Object[] { Integer.valueOf(this.type), Long.valueOf(this.time), Integer.valueOf(this.eah), Integer.valueOf(this.cmy), Integer.valueOf(this.eai), Long.valueOf(this.eaj), Integer.valueOf(this.eak), this.eag, Integer.valueOf(this.eal), Integer.valueOf(this.eam), Integer.valueOf(this.ean) });
    AppMethodBeat.o(15878);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.booter.y.a
 * JD-Core Version:    0.7.0.1
 */