package com.tencent.mm.plugin.appbrand.utils.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.n.a;
import java.util.concurrent.atomic.AtomicBoolean;

public enum a
  implements e, n.a
{
  public static final c urU;
  private final e urV;
  private final AtomicBoolean urW;
  
  static
  {
    AppMethodBeat.i(137930);
    urT = new a("INST");
    urX = new a[] { urT };
    urU = new c();
    AppMethodBeat.o(137930);
  }
  
  private a()
  {
    AppMethodBeat.i(137924);
    this.urW = new AtomicBoolean(false);
    this.urV = new b();
    AppMethodBeat.o(137924);
  }
  
  public final c cNI()
  {
    AppMethodBeat.i(137927);
    c localc = this.urV.cNI();
    AppMethodBeat.o(137927);
    return localc;
  }
  
  public final void cNz()
  {
    AppMethodBeat.i(137929);
    release();
    AppMethodBeat.o(137929);
  }
  
  public final void fn(Context paramContext)
  {
    AppMethodBeat.i(137928);
    init(paramContext);
    AppMethodBeat.o(137928);
  }
  
  public final void init(Context paramContext)
  {
    AppMethodBeat.i(137925);
    if (!this.urW.getAndSet(true)) {
      this.urV.init(paramContext);
    }
    AppMethodBeat.o(137925);
  }
  
  public final void release()
  {
    AppMethodBeat.i(137926);
    this.urV.release();
    AppMethodBeat.o(137926);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.utils.a.a
 * JD-Core Version:    0.7.0.1
 */