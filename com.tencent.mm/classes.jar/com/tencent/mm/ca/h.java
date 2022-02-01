package com.tencent.mm.ca;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  public boolean ELB;
  public boolean ELC;
  public boolean ELD;
  public int ELE;
  public boolean ELF;
  public int ELm;
  f ELo;
  
  private h(Context paramContext)
  {
    AppMethodBeat.i(189873);
    this.ELo = new f.b(paramContext, "recovery_statistic").eCA();
    this.ELm = this.ELo.getInt("crash_count", 0);
    this.ELB = this.ELo.getBoolean("launch_recovery", false);
    this.ELC = this.ELo.getBoolean("launch_recovery_real", false);
    this.ELD = this.ELo.getBoolean("recover_from_crash", false);
    this.ELE = this.ELo.getInt("recovery_status", -1);
    this.ELF = this.ELo.getBoolean("recover_is_discard", false);
    AppMethodBeat.o(189873);
  }
  
  public static h hy(Context paramContext)
  {
    AppMethodBeat.i(189872);
    paramContext = new h(paramContext);
    AppMethodBeat.o(189872);
    return paramContext;
  }
  
  public final void save()
  {
    AppMethodBeat.i(189874);
    this.ELo.fC("crash_count", this.ELm).cu("launch_recovery", this.ELB).cu("launch_recovery_real", this.ELC).cu("recover_from_crash", this.ELD).fC("recovery_status", this.ELE).cu("recover_is_discard", this.ELF).eCx();
    AppMethodBeat.o(189874);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ca.h
 * JD-Core Version:    0.7.0.1
 */