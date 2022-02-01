package com.tencent.mm.ca;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  public long ELl;
  public int ELm;
  public String ELn;
  private f ELo;
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(189828);
    this.ELo = new f.b(paramContext, "recovery_crash").eCA();
    this.ELn = this.ELo.getString("crash_version", null);
    this.ELl = Math.max(this.ELo.getLong("crash_time", 0L), 0L);
    this.ELm = Math.max(this.ELo.getInt("crash_count", 0), 0);
    AppMethodBeat.o(189828);
  }
  
  public static c ht(Context paramContext)
  {
    AppMethodBeat.i(189827);
    paramContext = new c(paramContext);
    AppMethodBeat.o(189827);
    return paramContext;
  }
  
  public final c eCt()
  {
    this.ELm += 1;
    return this;
  }
  
  public final c eCu()
  {
    this.ELl = 0L;
    this.ELm = 0;
    this.ELn = null;
    return this;
  }
  
  public final void eCv()
  {
    AppMethodBeat.i(189830);
    this.ELo.kJ("crash_version", this.ELn).fC("crash_count", this.ELm).bL("crash_time", this.ELl).eCy();
    AppMethodBeat.o(189830);
  }
  
  public final void save()
  {
    AppMethodBeat.i(189829);
    this.ELo.kJ("crash_version", this.ELn).fC("crash_count", this.ELm).bL("crash_time", this.ELl).eCx();
    AppMethodBeat.o(189829);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ca.c
 * JD-Core Version:    0.7.0.1
 */