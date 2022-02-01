package com.tencent.mm.bz;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c
{
  private f GiA;
  public long Gix;
  public int Giy;
  public String Giz;
  
  private c(Context paramContext)
  {
    AppMethodBeat.i(194769);
    this.GiA = new f.b(paramContext, "recovery_crash").eRU();
    this.Giz = this.GiA.getString("crash_version", null);
    this.Gix = Math.max(this.GiA.getLong("crash_time", 0L), 0L);
    this.Giy = Math.max(this.GiA.getInt("crash_count", 0), 0);
    AppMethodBeat.o(194769);
  }
  
  public static c hE(Context paramContext)
  {
    AppMethodBeat.i(194768);
    paramContext = new c(paramContext);
    AppMethodBeat.o(194768);
    return paramContext;
  }
  
  public final c eRO()
  {
    this.Giy += 1;
    return this;
  }
  
  public final c eRP()
  {
    this.Gix = 0L;
    this.Giy = 0;
    this.Giz = null;
    return this;
  }
  
  public final void eRQ()
  {
    AppMethodBeat.i(194771);
    this.GiA.lg("crash_version", this.Giz).fH("crash_count", this.Giy).bN("crash_time", this.Gix).eRT();
    AppMethodBeat.o(194771);
  }
  
  public final void save()
  {
    AppMethodBeat.i(194770);
    this.GiA.lg("crash_version", this.Giz).fH("crash_count", this.Giy).bN("crash_time", this.Gix).eRS();
    AppMethodBeat.o(194770);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.c
 * JD-Core Version:    0.7.0.1
 */