package com.tencent.mm.plugin.appbrand.t.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.f.a;

public enum a
  implements e, f.a
{
  public static final c iYl;
  private final e iYm;
  
  static
  {
    AppMethodBeat.i(126652);
    iYk = new a("INST");
    iYn = new a[] { iYk };
    iYl = new c();
    AppMethodBeat.o(126652);
  }
  
  private a()
  {
    AppMethodBeat.i(126646);
    this.iYm = new b();
    AppMethodBeat.o(126646);
  }
  
  public final void aNZ()
  {
    AppMethodBeat.i(126651);
    release();
    AppMethodBeat.o(126651);
  }
  
  public final c aOb()
  {
    AppMethodBeat.i(126649);
    c localc = this.iYm.aOb();
    AppMethodBeat.o(126649);
    return localc;
  }
  
  public final void dg(Context paramContext)
  {
    AppMethodBeat.i(126650);
    init(paramContext);
    AppMethodBeat.o(126650);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(126647);
    this.iYm.init(paramContext);
    AppMethodBeat.o(126647);
  }
  
  public final void release()
  {
    AppMethodBeat.i(126648);
    this.iYm.release();
    AppMethodBeat.o(126648);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t.a.a
 * JD-Core Version:    0.7.0.1
 */