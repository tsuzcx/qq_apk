package com.tencent.mm.plugin.appbrand.utils.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.f.a;
import java.util.concurrent.atomic.AtomicBoolean;

public enum a
  implements e, f.a
{
  public static final c lMX;
  private final e lMY;
  private final AtomicBoolean lMZ;
  
  static
  {
    AppMethodBeat.i(137930);
    lMW = new a("INST");
    lNa = new a[] { lMW };
    lMX = new c();
    AppMethodBeat.o(137930);
  }
  
  private a()
  {
    AppMethodBeat.i(137924);
    this.lMZ = new AtomicBoolean(false);
    this.lMY = new b();
    AppMethodBeat.o(137924);
  }
  
  public final void bqq()
  {
    AppMethodBeat.i(137929);
    release();
    AppMethodBeat.o(137929);
  }
  
  public final c bqu()
  {
    AppMethodBeat.i(137927);
    c localc = this.lMY.bqu();
    AppMethodBeat.o(137927);
    return localc;
  }
  
  public final void dJ(Context paramContext)
  {
    AppMethodBeat.i(137928);
    init(paramContext);
    AppMethodBeat.o(137928);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(137925);
    if (!this.lMZ.getAndSet(true)) {
      this.lMY.init(paramContext);
    }
    AppMethodBeat.o(137925);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137926);
    this.lMY.release();
    AppMethodBeat.o(137926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a.a
 * JD-Core Version:    0.7.0.1
 */