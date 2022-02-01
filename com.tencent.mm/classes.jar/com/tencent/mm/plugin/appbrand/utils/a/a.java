package com.tencent.mm.plugin.appbrand.utils.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.h.a;
import java.util.concurrent.atomic.AtomicBoolean;

public enum a
  implements e, h.a
{
  public static final c ohM;
  private final e ohN;
  private final AtomicBoolean ohO;
  
  static
  {
    AppMethodBeat.i(137930);
    ohL = new a("INST");
    ohP = new a[] { ohL };
    ohM = new c();
    AppMethodBeat.o(137930);
  }
  
  private a()
  {
    AppMethodBeat.i(137924);
    this.ohO = new AtomicBoolean(false);
    this.ohN = new b();
    AppMethodBeat.o(137924);
  }
  
  public final void bZq()
  {
    AppMethodBeat.i(137929);
    release();
    AppMethodBeat.o(137929);
  }
  
  public final c bZx()
  {
    AppMethodBeat.i(137927);
    c localc = this.ohN.bZx();
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
    if (!this.ohO.getAndSet(true)) {
      this.ohN.init(paramContext);
    }
    AppMethodBeat.o(137925);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137926);
    this.ohN.release();
    AppMethodBeat.o(137926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a.a
 * JD-Core Version:    0.7.0.1
 */