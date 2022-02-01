package com.tencent.mm.plugin.appbrand.utils.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.j.a;
import java.util.concurrent.atomic.AtomicBoolean;

public enum a
  implements e, j.a
{
  public static final c rjA;
  private final e rjB;
  private final AtomicBoolean rjC;
  
  static
  {
    AppMethodBeat.i(137930);
    rjz = new a("INST");
    rjD = new a[] { rjz };
    rjA = new c();
    AppMethodBeat.o(137930);
  }
  
  private a()
  {
    AppMethodBeat.i(137924);
    this.rjC = new AtomicBoolean(false);
    this.rjB = new b();
    AppMethodBeat.o(137924);
  }
  
  public final void cmf()
  {
    AppMethodBeat.i(137929);
    release();
    AppMethodBeat.o(137929);
  }
  
  public final c cmn()
  {
    AppMethodBeat.i(137927);
    c localc = this.rjB.cmn();
    AppMethodBeat.o(137927);
    return localc;
  }
  
  public final void er(Context paramContext)
  {
    AppMethodBeat.i(137928);
    init(paramContext);
    AppMethodBeat.o(137928);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(137925);
    if (!this.rjC.getAndSet(true)) {
      this.rjB.init(paramContext);
    }
    AppMethodBeat.o(137925);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137926);
    this.rjB.release();
    AppMethodBeat.o(137926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a.a
 * JD-Core Version:    0.7.0.1
 */