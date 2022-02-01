package com.tencent.mm.bz;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h
{
  f GiA;
  public boolean GiN;
  public boolean GiO;
  public boolean GiP;
  public int GiQ;
  public boolean GiR;
  public int Giy;
  
  private h(Context paramContext)
  {
    AppMethodBeat.i(194814);
    this.GiA = new f.b(paramContext, "recovery_statistic").eRU();
    this.Giy = this.GiA.getInt("crash_count", 0);
    this.GiN = this.GiA.getBoolean("launch_recovery", false);
    this.GiO = this.GiA.getBoolean("launch_recovery_real", false);
    this.GiP = this.GiA.getBoolean("recover_from_crash", false);
    this.GiQ = this.GiA.getInt("recovery_status", -1);
    this.GiR = this.GiA.getBoolean("recover_is_discard", false);
    AppMethodBeat.o(194814);
  }
  
  public static h hJ(Context paramContext)
  {
    AppMethodBeat.i(194813);
    paramContext = new h(paramContext);
    AppMethodBeat.o(194813);
    return paramContext;
  }
  
  public final void save()
  {
    AppMethodBeat.i(194815);
    this.GiA.fH("crash_count", this.Giy).cA("launch_recovery", this.GiN).cA("launch_recovery_real", this.GiO).cA("recover_from_crash", this.GiP).fH("recovery_status", this.GiQ).cA("recover_is_discard", this.GiR).eRS();
    AppMethodBeat.o(194815);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.h
 * JD-Core Version:    0.7.0.1
 */