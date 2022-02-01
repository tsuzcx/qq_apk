package com.tencent.mm.plugin.appbrand.utils.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.g.a;
import java.util.concurrent.atomic.AtomicBoolean;

public enum a
  implements e, g.a
{
  public static final c moX;
  private final e moY;
  private final AtomicBoolean moZ;
  
  static
  {
    AppMethodBeat.i(137930);
    moW = new a("INST");
    mpa = new a[] { moW };
    moX = new c();
    AppMethodBeat.o(137930);
  }
  
  private a()
  {
    AppMethodBeat.i(137924);
    this.moZ = new AtomicBoolean(false);
    this.moY = new b();
    AppMethodBeat.o(137924);
  }
  
  public final void bxo()
  {
    AppMethodBeat.i(137929);
    release();
    AppMethodBeat.o(137929);
  }
  
  public final c bxu()
  {
    AppMethodBeat.i(137927);
    c localc = this.moY.bxu();
    AppMethodBeat.o(137927);
    return localc;
  }
  
  public final void dR(Context paramContext)
  {
    AppMethodBeat.i(137928);
    init(paramContext);
    AppMethodBeat.o(137928);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(137925);
    if (!this.moZ.getAndSet(true)) {
      this.moY.init(paramContext);
    }
    AppMethodBeat.o(137925);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137926);
    this.moY.release();
    AppMethodBeat.o(137926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a.a
 * JD-Core Version:    0.7.0.1
 */